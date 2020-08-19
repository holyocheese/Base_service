package com.base.pdf.service;

import java.io.IOException;

import com.base.model.vo.MsgVo;


public interface ReadablePdfService {

	//呼吸报告PDF （目录下所有PDF）
	//MsgVo<String> readingPdf4BreathReports(String path);
	
	//目录下的特定pdf转换为data（根据间隔）
	void convertPdfIntoDataSet(String path) throws IOException;
}
