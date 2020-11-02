package com.base.pdf.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.pdf.entity.Pdf;
import com.base.dao.pdf.entity.PdfLinedata;
import com.base.dao.pdf.mapper.PdfLinedataMapper;
import com.base.dao.pdf.mapper.PdfMapper;
import com.base.pdf.service.ReadablePdfService;


@Service
public class ReadablePdfServiceImpl implements ReadablePdfService {

	@Autowired
	private PdfMapper pdfMapper;
	@Autowired
	private PdfLinedataMapper pdfLinedataMapper;
	
	Integer count = 0;
	
	Integer lastId = 0;
	
	float minDistance = Float.parseFloat("18.0");
	
	public class PrintTextLocations extends PDFTextStripper
	{
	    /**
	     * Instantiate a new PDFTextStripper object.
	     *
	     * @throws IOException If there is an error loading the properties.
	     */
	    public PrintTextLocations() throws IOException
	    {
	    }

	    @Override
	    protected void writeString(String string, List<TextPosition> textPositions) throws IOException
	    {
	    	int first = 0;
	    	float lastLineY = textPositions.get(0).getYDirAdj();
	    	PdfLinedata pdfLinedata = new PdfLinedata();
	    	float lastX = Float.parseFloat("0.0");
	        for (TextPosition text : textPositions){
	        	//上半部
//	        	if(Float.compare(lastLineY, Float.parseFloat("420"))>0){
//	        		return;
//	        	}
	        	if(first==0){
	        		pdfLinedata.setxBegin(pdfLinedata.getxBegin()==null?text.getXDirAdj():pdfLinedata.getxBegin());
	        		pdfLinedata.setText(pdfLinedata.getText()==null?text.getUnicode():pdfLinedata.getText()+text.getUnicode());
	        		pdfLinedata.setyBegin(lastLineY);
	        		pdfLinedata.setxEnd(text.getWidthOfSpace()+text.getXDirAdj());
	        	}else{
	        		//如果大于最小间隔 则
	        		if(text.getXDirAdj()-lastX>minDistance){
	        			pdfLinedata.setPdfId(pdfMapper.selectMaxId());
	        			pdfLinedataMapper.insertSelective(pdfLinedata);
	        			first = -1;//重新作为头
	        			pdfLinedata.setText(text.getUnicode());
	        			pdfLinedata.setxBegin(text.getXDirAdj());
	        		}else{
	        			pdfLinedata.setText(pdfLinedata.getText()+text.getUnicode());
			            pdfLinedata.setxEnd(text.getWidthOfSpace()+text.getXDirAdj());
	        		}
	        		
	        	}
	        	//去掉空格
	        	if(!StringUtils.isBlank(text.getUnicode())&&text.getWidthDirAdj()>=3){
	        		lastX = text.getXDirAdj();
	        	}
	        	first++;
	        	//读取
	            System.out.println( "String[" + text.getXDirAdj() + "," +
	                    text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale=" +
	                    text.getXScale() + " height=" + text.getHeightDir() + " space=" +
	                    text.getWidthOfSpace() + " width=" +
	                    text.getWidthDirAdj() + "]" + text.getUnicode() );
	        }
	        pdfLinedata.setPdfId(pdfMapper.selectMaxId());
	        pdfLinedataMapper.insertSelective(pdfLinedata);
	    }
	    
	}

	

	@Override
	public void convertPdfIntoDataSet(String path) throws IOException {
		Pdf pdf = new Pdf();
		File dirfile = new File(path);
		if (dirfile.exists() && dirfile.isDirectory()) {
			String[] filelist = dirfile.list();
			for (int i = 0; i < filelist.length; i++) {
				//写入pdf
				pdf.setPath(path);
				pdf.setFileName(filelist[i]);
				pdfMapper.insertSelective(pdf);
				// 目标路径
				File readfile = new File(path + "\\" + filelist[i]);
				if (!readfile.isDirectory()) {
					String fileType = filelist[i].substring(filelist[i].lastIndexOf("."), filelist[i].length());
					if (fileType.indexOf("pd") >= 0) {// pdf
				        try (PDDocument document = PDDocument.load(readfile)){
				            PDFTextStripper stripper = new PrintTextLocations();
				            stripper.setSortByPosition( true );
				            stripper.setStartPage( 0 );
				            stripper.setEndPage( document.getNumberOfPages() );
				            //包含写入
				            stripper.getText(document);
				        }
					} else {
						continue;
					}
				} else if (readfile.isDirectory()) {
					continue;
				}
			}
		} else {
			
		}

	}
}
