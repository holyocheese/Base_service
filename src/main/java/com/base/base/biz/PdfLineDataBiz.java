package com.base.base.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.constant.PDFConstants;
import com.base.dao.pdf.entity.PdfLinedata;
import com.base.dao.pdf.mapper.PdfLinedataMapper;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(rollbackFor = Exception.class)
public class PdfLineDataBiz extends BaseBiz<PdfLinedataMapper, PdfLinedata> {

	public List<PdfLinedata> selectByPdfId(Integer id,Float positionX,Float positionY,String type,String dataType){
		Example example = new Example(PdfLinedata.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pdfId", id);
        if(positionX==null&&positionY==null&&type=="breath"){
        	criteria.andLessThan("yBegin", 120);
        }
        if(positionX!=null){
        	criteria.andLessThan("xBegin", positionX);
        }
        if(positionY!=null){
        	criteria.andGreaterThan("yBegin", positionY);
        }
        if(dataType!=null){
        	criteria.andEqualTo("type", dataType);
        }
		return mapper.selectByExample(example);
	}
	
	public String getTableJsonByPdfId(Integer id){
		String result = "{\n";
		Example example = new Example(PdfLinedata.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pdfId", id);
        criteria.andEqualTo("type", PDFConstants.PDF_LINEDATA_TYPE_TABLE);
        List<PdfLinedata> fromList = mapper.selectByExample(example);
        List<PdfLinedata> headList = new ArrayList<PdfLinedata>();
        List<PdfLinedata> leftList = new ArrayList<PdfLinedata>();
        List<PdfLinedata> bodyList = new ArrayList<PdfLinedata>();
        for(PdfLinedata pld: fromList){
        	if(pld.getTableDataType().equals("top")){
        		headList.add(pld);
        	}
        	if(pld.getTableDataType().equals("left")){
        		leftList.add(pld);
        	}
        	if(pld.getTableDataType().equals("body")){
        		bodyList.add(pld);
        	}
        }
        for(int i=0;i<leftList.size();i++){
        	result += "\"" + leftList.get(i).getText() +"\" : {\n" ;
        	Float leftYMin = leftList.get(i).getyBegin() - 5;
        	Float leftYMax = leftList.get(i).getyBegin() + 10;
        	//表体判断
        	for(int j=0;j<headList.size();j++){
            	//判断头的范围
            	Float xbegin = headList.get(j).getxBegin();
            	Float xend = headList.get(j).getxBegin() + 30;//TODO 改动态判断
//            	if(j!=headList.size()-1){
//            		xend = headList.get(j+1).getxEnd();
//            	}
            	int length = result.length();
            	String header = "";
            	for(PdfLinedata body: bodyList){
            		header = headList.get(j).getText();
            		//同一直线
            		if((body.getxBegin().compareTo(xbegin)>=0&&body.getxEnd().compareTo(xend)<=0)&& //垂直判断
            				(body.getyBegin().compareTo(leftYMin)>=0&&body.getyBegin().compareTo(leftYMax)<=0)){
            			String bodyPar = " \"" + headList.get(j).getText() +"\":" ;
            			bodyPar += " \"" + body.getText() +"\",\n";
            			result+=bodyPar;
            		}
            	}
            	if(result.length()==length){
            		String bodyPar = " \"" + header +"\":" ;
        			bodyPar += " \"" + " " +"\",\n";
        			result+=bodyPar;
            	}
            }
        	result = result.substring(0,result.length()-2);
        	result += "\n";
        	if(i!=leftList.size()-1){
        		result += " },\n";
        	}else{
        		result += " }";
        	}
        	
        }
        
        
        result += "\n}";

		return result;
	}
}
