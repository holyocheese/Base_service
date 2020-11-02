package com.base.pdf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.base.biz.PdfBiz;
import com.base.common.BaseController;
import com.base.dao.pdf.entity.Pdf;

@RestController
@RequestMapping("pdf")
public class PdfController  extends BaseController<PdfBiz, Pdf>{

}
