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

	public List<PdfLinedata> selectByPdfId(Integer id){
		Example example = new Example(PdfLinedata.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pdfId", id);
		return mapper.selectByExample(example);
	}
}
