package com.csftgroup.ocsp.business.project.manage.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

@ApiModel(value = "子项目信息表",description = "子项目对象模型")
public class SubProject {

    @Digits(integer = 32,fraction = 0)
    @ApiModelProperty(name="id",value = "Id",dataType = "Long")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @Length(min = 0,max = 64)
    @ApiModelProperty(name="projectId",value = "项目ID",dataType = "String")
    private String projectId;
    @Length(min = 0,max = 64)
    @ApiModelProperty(name="subProjectId",value = "子项目ID",dataType = "String")
    private String subProjectId;
    @Length(min = 0,max = 512)
    @ApiModelProperty(name="subProjectName",value = "子项目名称",dataType = "String")
    private String subProjectName;
    @Length(min = 0,max = 512)
    @ApiModelProperty(name="subProjectDisplay",value = "子项目描述",dataType = "String")
    private String subProjectDisplay;
    @Length(min = 0,max = 32)
    @ApiModelProperty(name="serviceGroupid",value = "服务组ID",dataType = "String")
    private String serviceGroupid;
    @Length(min = 0,max = 32)
    @ApiModelProperty(name="serviceId",value = "服务ID",dataType = "String")
    private String serviceId;
    @Length(min = 0,max = 32)
    @ApiModelProperty(name="templateId",value = "模板表ID",dataType = "String")
    private String templateId;
    @Length(min = 0,max = 32)
    @ApiModelProperty(name="proComId",value = "项目组件关系表ID",dataType = "String")
    private String proComId;
    @ApiModelProperty(name="createTime",value = "创建时间",dataType = "String")
    private String createTime;
    @Length(min = 0,max = 32)
    @ApiModelProperty(name="createUserId",value = "创建用户",dataType = "String")
    private String createUserId;
    @ApiModelProperty(name="lstModiTime",value = "最后修改时间",dataType = "String")
    private String lstModiTime;
    @Length(min = 0,max = 32)
    @ApiModelProperty(name="lstModiUserId",value = "最后修改用户",dataType = "String")
    private String lstModiUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSubProjectId() {
        return subProjectId;
    }

    public void setSubProjectId(String subProjectId) {
        this.subProjectId = subProjectId;
    }

    public String getSubProjectName() {
        return subProjectName;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public String getSubProjectDisplay() {
        return subProjectDisplay;
    }

    public void setSubProjectDisplay(String subProjectDisplay) {
        this.subProjectDisplay = subProjectDisplay;
    }

    public String getServiceGroupid() {
        return serviceGroupid;
    }

    public void setServiceGroupid(String serviceGroupid) {
        this.serviceGroupid = serviceGroupid;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getProComId() {
        return proComId;
    }

    public void setProComId(String proComId) {
        this.proComId = proComId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getLstModiTime() {
        return lstModiTime;
    }

    public void setLstModiTime(String lstModiTime) {
        this.lstModiTime = lstModiTime;
    }

    public String getLstModiUserId() {
        return lstModiUserId;
    }

    public void setLstModiUserId(String lstModiUserId) {
        this.lstModiUserId = lstModiUserId;
    }
}
