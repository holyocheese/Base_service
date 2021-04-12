package com.base.pdf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.base.biz.PdfAreaBiz;
import com.base.common.BaseController;
import com.base.dao.pdf.entity.PdfArea;

@RestController
@RequestMapping("pdfArea")
public class PdfAreaController extends BaseController<PdfAreaBiz, PdfArea>{

}
