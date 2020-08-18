package com.base.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "base_element")
public class Element {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源路径
     */
    private String uri;

    /**
     * 资源关联菜单
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 上级资源
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 资源树状检索路径
     */
    private String path;

    /**
     * 资源请求类型
     */
    private String method;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

    /**
     * 创建用户
     */
    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

    /**
     * 附加字段1
     */
    private String attr1;

    /**
     * 附加字段2
     */
    private String attr2;

    /**
     * 附加字段3
     */
    private String attr3;

    /**
     * 附加字段4
     */
    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源编码
     *
     * @return code - 资源编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置资源编码
     *
     * @param code 资源编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取资源类型
     *
     * @return type - 资源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置资源类型
     *
     * @param type 资源类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取资源路径
     *
     * @return uri - 资源路径
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置资源路径
     *
     * @param uri 资源路径
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取资源关联菜单
     *
     * @return menu_id - 资源关联菜单
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置资源关联菜单
     *
     * @param menuId 资源关联菜单
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取上级资源
     *
     * @return parent_id - 上级资源
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级资源
     *
     * @param parentId 上级资源
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取资源树状检索路径
     *
     * @return path - 资源树状检索路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置资源树状检索路径
     *
     * @param path 资源树状检索路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取资源请求类型
     *
     * @return method - 资源请求类型
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置资源请求类型
     *
     * @param method 资源请求类型
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建时间
     *
     * @return crt_time - 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置创建时间
     *
     * @param crtTime 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取创建用户
     *
     * @return crt_user - 创建用户
     */
    public String getCrtUser() {
        return crtUser;
    }

    /**
     * 设置创建用户
     *
     * @param crtUser 创建用户
     */
    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    /**
     * @return crt_name
     */
    public String getCrtName() {
        return crtName;
    }

    /**
     * @param crtName
     */
    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    /**
     * @return crt_host
     */
    public String getCrtHost() {
        return crtHost;
    }

    /**
     * @param crtHost
     */
    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }

    /**
     * 获取附加字段1
     *
     * @return attr1 - 附加字段1
     */
    public String getAttr1() {
        return attr1;
    }

    /**
     * 设置附加字段1
     *
     * @param attr1 附加字段1
     */
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    /**
     * 获取附加字段2
     *
     * @return attr2 - 附加字段2
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * 设置附加字段2
     *
     * @param attr2 附加字段2
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    /**
     * 获取附加字段3
     *
     * @return attr3 - 附加字段3
     */
    public String getAttr3() {
        return attr3;
    }

    /**
     * 设置附加字段3
     *
     * @param attr3 附加字段3
     */
    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    /**
     * 获取附加字段4
     *
     * @return attr4 - 附加字段4
     */
    public String getAttr4() {
        return attr4;
    }

    /**
     * 设置附加字段4
     *
     * @param attr4 附加字段4
     */
    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    /**
     * @return attr5
     */
    public String getAttr5() {
        return attr5;
    }

    /**
     * @param attr5
     */
    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    /**
     * @return attr6
     */
    public String getAttr6() {
        return attr6;
    }

    /**
     * @param attr6
     */
    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }

    /**
     * @return attr7
     */
    public String getAttr7() {
        return attr7;
    }

    /**
     * @param attr7
     */
    public void setAttr7(String attr7) {
        this.attr7 = attr7;
    }

    /**
     * @return attr8
     */
    public String getAttr8() {
        return attr8;
    }

    /**
     * @param attr8
     */
    public void setAttr8(String attr8) {
        this.attr8 = attr8;
    }
}