package com.base.base.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.dao.pdf.entity.PdfLinedata;
import com.base.dao.pdf.mapper.PdfLinedataMapper;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(rollbackFor = Exception.class)
public class PdfLineDataBiz extends BaseBiz<PdfLinedataMapper, PdfLinedata> {

	public List<PdfLinedata> selectByPdfId(Integer id,Float positionX,Float positionY){
		Example example = new Example(PdfLinedata.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pdfId", id);
        if(positionX==null&&positionY==null){
        	criteria.andLessThan("yBegin", 120);
        }
        if(positionX!=null){
        	criteria.andLessThan("xBegin", positionX);
        }
        if(positionY!=null){
        	criteria.andGreaterThan("yBegin", positionY);
        }
		return mapper.selectByExample(example);
	}
}
