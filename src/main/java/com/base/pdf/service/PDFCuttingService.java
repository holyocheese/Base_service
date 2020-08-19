package com.base.pdf.service;

public interface PDFCuttingService {

	//病人数据 返回文件夹路径
	public String cutting4PatientInfor(String path);
	
	//扫描的数据 返回文件夹路径
	public String cutting4PdfInfor(String path);
	
	//切成两份 保存在当前文件夹 
	public void	cutToTwoPart(String path);
	
	//读取内容并保存到数据库（第一部分：头部）
	public void readAndSave4head(String path_head);
}
