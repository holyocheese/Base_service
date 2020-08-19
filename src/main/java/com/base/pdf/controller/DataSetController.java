package com.base.pdf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.model.vo.MsgVo;
import com.base.pdf.service.ReadablePdfService;


@RestController
@RequestMapping("/dataSet")
public class DataSetController {
	
	@Autowired
	private ReadablePdfService readablePdfService;

	//路径下的pdf存到数据库
	@RequestMapping(value = "/convertPdfIntoDataSet", method = RequestMethod.GET)
    public MsgVo<String> convertPdfIntoDataSet(@RequestParam String path) throws IOException {
		readablePdfService.convertPdfIntoDataSet(path);
		return null;
	}
}
