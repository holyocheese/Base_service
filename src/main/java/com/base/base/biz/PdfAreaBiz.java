package com.base.base.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.dao.pdf.entity.PdfArea;
import com.base.dao.pdf.mapper.PdfAreaMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class PdfAreaBiz extends BaseBiz<PdfAreaMapper, PdfArea>{

}
