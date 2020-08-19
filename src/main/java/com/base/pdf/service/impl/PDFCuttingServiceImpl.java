package com.base.pdf.service.impl;

import org.springframework.stereotype.Service;

import com.base.pdf.service.PDFCuttingService;


@Service
public class PDFCuttingServiceImpl implements PDFCuttingService{

	@Override
	public String cutting4PatientInfor(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cutting4PdfInfor(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cutToTwoPart(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAndSave4head(String path_head) {
		// TODO Auto-generated method stub
		/*OcrBase ocrBase = new OcrBase();
		TessExample example = new TessExample();
		String result = example.tess4eng(path_head);
		String[] resultArray =  result.split(" |\\n|:");
		//标记数据下标
		for(int i=0;i<resultArray.length;i++){
			Map<String,Integer> map = new HashMap<String,Integer>();
			if(resultArray[i].lastIndexOf("Name")>=0){
				map.put("Name", i);
				continue;
			}
			if(resultArray[i].lastIndexOf("Sex")>=0){
				map.put("Sex", i);
				continue;
			}
			if(resultArray[i].lastIndexOf("Height")>=0){
				map.put("Height", i);
				continue;
			}
			if(resultArray[i].lastIndexOf("Patient")>=0){
				if(resultArray[i+1].lastIndexOf("ID")>=0){
					map.put("P_id", i+1);
					continue;
				}
			}
			if(resultArray[i].lastIndexOf("Ethnicity")>=0){
				map.put("Ethnicity", i);
				continue;
			}
			if(resultArray[i].lastIndexOf("Ethnicity")>=0){
				map.put("Ethnicity", i);
				continue;
			}
		}*/
	}



}
