package com.base.pdf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.base.biz.PdfLineDataBiz;
import com.base.common.BaseController;
import com.base.dao.pdf.entity.PdfLinedata;

@RestController
@RequestMapping("pdfLinedata")
public class PdfLineDataController  extends BaseController<PdfLineDataBiz, PdfLinedata>{

	@RequestMapping(value = "/pdfList", method = RequestMethod.GET)
    @ResponseBody
    public List<PdfLinedata> list(Integer id) {
        return baseBiz.selectByPdfId(id);
    }
}