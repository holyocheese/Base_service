package com.base.base.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.dao.pdf.entity.Pdf;
import com.base.dao.pdf.mapper.PdfMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class PdfBiz extends BaseBiz<PdfMapper, Pdf> {

}
