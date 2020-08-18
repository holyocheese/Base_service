package com.base.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.config.BaseContextHandler;
import com.base.model.response.ObjectRestResponse;
import com.base.model.response.TableResultResponse;
import com.base.util.Query;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

public class BaseController<Biz extends BaseBiz,Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    @ApiIgnore
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>();
    }
    @ApiOperation(value = "根据id获取数据", notes = "根据id获取数据")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<Entity> get(@PathVariable int id){
        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
        Object o = baseBiz.selectById(id);
        entityObjectRestResponse.data((Entity)o);
        return entityObjectRestResponse;
    }
    @ApiOperation(value = "根据id更新数据", notes = "根据id更新数据")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiIgnore
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>();
    }
    @ApiOperation(value = "根据id删除数据", notes = "根据id删除数据")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiIgnore
    public ObjectRestResponse<Entity> remove(@PathVariable int id){
        baseBiz.deleteById(id);
        return new ObjectRestResponse<Entity>();
    }
    @ApiOperation(value = "all列表", notes = "all列表")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    @ApiIgnore
    public List<Entity> all(){
        return baseBiz.selectListAll();
    }
    @ApiOperation(value = "分页列表", notes = "分页列表")
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    @ApiIgnore
    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return baseBiz.selectByQuery(query);
    }
    @ApiOperation(value = "分页列表(精确查询)", notes = "分页列表(精确查询)")
    @RequestMapping(value = "/pageEqual",method = RequestMethod.GET)
    @ResponseBody
    @ApiIgnore
    public TableResultResponse<Entity> listEqual(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return baseBiz.selectByQueryEqual(query);
    }
    public String getCurrentUserName(){
        return BaseContextHandler.getUsername();
    }
    
    public String getCurrentUserId(){
        return BaseContextHandler.getUserID();
    }
    
    public String getCurrentTenantId(){
        return BaseContextHandler.get("tenantId")+"";
    }
    
    public HttpHeaders getDownloadHeaders(String fileName) throws UnsupportedEncodingException{
    	HttpHeaders headers = new HttpHeaders();
    	 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);    
         headers.setContentDispositionFormData("attachment", fileName);
         List<String> headList = new ArrayList<String>();
         headList.add("Access-Control-Expose-Headers");
         headList.add("Content-Disposition");
         headers.setAccessControlExposeHeaders(headList);
         return headers;
    }
}
