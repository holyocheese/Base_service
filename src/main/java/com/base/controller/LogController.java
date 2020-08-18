package com.base.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.constant.MessageCodeConstant;

import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/logBack")
@ApiIgnore
public class LogController {
	
	@Value("${path.log}")
	private String path;
	
	//根据服务&日志等级读取日志
	@RequestMapping(value = "/logger",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> select(@RequestParam(value="lineCount",required=false)Integer lineCount,
    		@RequestParam(value="level")String level,
    		@RequestParam(value="lastReadLine" ,required=false)Integer lastReadLine){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", MessageCodeConstant.SUCCESS);
		result.put("message", MessageCodeConstant.MESSAGE_OK);
		File f = null;
		String resultStr = "";
		String fileName = "ewheel-admin-" + level + ".log";
		try{
			f = new File(path+fileName);
			int totalCount = getTotalLines(f);
			if(lastReadLine!=null&&totalCount==lastReadLine){
				result.put("lineTotal",totalCount);
				result.put("data",resultStr);
				return result;
			}
			//如果传入上次读取的行数，
			if(lastReadLine!=null&&totalCount>lastReadLine){
				resultStr = readAppointedLineNumber(f,lastReadLine,totalCount);//读最新行数
			}else{
				//如果指定读取的行数
				if(lineCount!=null){
					if(totalCount<=lineCount){
						resultStr = readAppointedLineNumber(f,0,totalCount);
					}else{
						resultStr = readAppointedLineNumber(f,totalCount-lineCount,totalCount);
					}
				}
			}
 			result.put("lineTotal",totalCount);
			result.put("data",resultStr);
		}catch (Exception e) {
			result.put("status", MessageCodeConstant.SERVER_500);
			result.put("message", "日志文件路径打开ERROR");
		}
        return result;
    }
	
	//根据路径读取日志
	@RequestMapping(value = "/loggerByPath",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> select(@RequestParam(value="path")String path,
    		@RequestParam(value="lineCount",required=false)Integer lineCount,
    		@RequestParam(value="lastReadLine" ,required=false)Integer lastReadLine){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", MessageCodeConstant.SUCCESS);
		result.put("message", MessageCodeConstant.MESSAGE_OK);
		File f = null;
		String resultStr = "";
		try{
			f = new File(path);
			int totalCount = getTotalLines(f);
			if(lastReadLine!=null&&totalCount==lastReadLine){
				result.put("lineTotal",totalCount);
				result.put("data",resultStr);
				return result;
			}
			//如果传入上次读取的行数，
			if(lastReadLine!=null&&totalCount>lastReadLine){
				resultStr = readAppointedLineNumber(f,lastReadLine,totalCount);//读最新行数
			}else{
				//如果指定读取的行数
				if(lineCount!=null){
					if(totalCount<=lineCount){
						resultStr = readAppointedLineNumber(f,0,totalCount);
					}else{
						resultStr = readAppointedLineNumber(f,totalCount-lineCount,totalCount);
					}
				}
			}
			result.put("lineTotal",totalCount);
			result.put("data",resultStr);
		}catch (Exception e) {
			result.put("status", MessageCodeConstant.SERVER_500);
			result.put("message", "日志文件路径打开ERROR");
		}
        return result;
    }
	
	@RequestMapping(value = "/downloadByLevel",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<FileSystemResource> export(@RequestParam(value="level",required=true)String level) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=日志.txt");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
		String fileName = "ewheel-admin-" + level + ".log";		
        File file =  new File(path+fileName);
        if (!file.canExecute()) {
        	return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
	                .headers(headers)
	                .contentType(MediaType.parseMediaType("application/octet-stream"))
	                .body(new FileSystemResource(file));
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
    }
	
	// 文件内容的总行数。
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
    
    // 读取文件指定行。
    // 源文件 倒数多少行 总行数
	static String readAppointedLineNumber(File sourceFile, int lineNumber, int totalLine)
            throws IOException {
        FileReader in = null;
        LineNumberReader reader = null;
        try{
        	in = new FileReader(sourceFile);
        	reader = new LineNumberReader(in);
        	String s = "";
            if (lineNumber > totalLine) {
                return s;
            }
            int lines = 0;
            while (lines<totalLine) {
            	if(lines>lineNumber){
            		s += reader.readLine() + "\n";
            	}else{
            		s =  reader.readLine() + "\n";
            	}
                lines++;
            }
            reader.close();
            in.close();
            return s;
        }catch (Exception e) {
			return "";
		}finally {
			try{
				if(in!=null){
					in.close();
				}
				if(reader!=null){
					in.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
    }
    
    
    /**
     * 读取文件指定行。
     */
    public static void main(String[] args) throws IOException {
        // 指定读取的行号
        int lineNumber = 2;
        String path = "C:\\Users\\54329\\Desktop\\test.log";
        // 读取文件
        File sourceFile = new File(path);
        // 读取指定的行
        String s = readAppointedLineNumber(sourceFile, getTotalLines(sourceFile),getTotalLines(sourceFile));
        System.out.println(s);
        // 获取文件的内容的总行数
        //System.out.println(getTotalLines(sourceFile));
    }

}
