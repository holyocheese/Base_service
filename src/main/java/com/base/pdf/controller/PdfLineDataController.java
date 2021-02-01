package com.base.pdf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.base.biz.PdfLineDataBiz;
import com.base.common.BaseController;
import com.base.dao.pdf.entity.PdfLinedata;
import com.base.model.vo.MsgVo;

@RestController
@RequestMapping("pdfLinedata")
public class PdfLineDataController  extends BaseController<PdfLineDataBiz, PdfLinedata>{
	
	@Autowired
	private PdfLineDataBiz pdfLineDataBiz;

	@RequestMapping(value = "/pdfList", method = RequestMethod.GET)
    @ResponseBody
    public List<PdfLinedata> list(@RequestParam(value="id")Integer id,
    		@RequestParam(value="positionX",required=false)Float positionX,
    		@RequestParam(value="positionY",required=false)Float positionY,
    		@RequestParam(value="type",required=false)String type,
    		@RequestParam(value="dataType",required=false)String dataType) {
        return baseBiz.selectByPdfId(id,positionX,positionY,type,dataType);
    }
	
	@RequestMapping(value = "/getTableJson", method = RequestMethod.GET)
    @ResponseBody
    public MsgVo<String> list(@RequestParam(value="id")Integer id) {
		MsgVo<String> result = new MsgVo<String>();
		result.setStatus(200);
		result.setMessage("ok");
		result.setData(pdfLineDataBiz.getTableJsonByPdfId(id));
        return result;
    }
}
