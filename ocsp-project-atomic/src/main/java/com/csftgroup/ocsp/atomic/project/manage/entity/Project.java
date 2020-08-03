package com.csftgroup.ocsp.atomic.project.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel(value = "项目信息表",description = "项目对象模型")
public class Project {
    @Digits(integer = 32,fraction = 0)
    @ApiModelProperty(name="id",value = "Id",dataType = "Long")
    @TableId(value = "id",type = IdType.INPUT)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @Length(min = 0,max = 64)
    @ApiModelProperty(name="projectId",value = "项目ID",dataType = "String")
    private String projectId;
    @Length(min = 0,max = 512)
    @ApiModelProperty(name="projectName",value = "项目名称",dataType = "String")
    private String projectName;
    @Length(min = 0,max = 512)
    @ApiModelProperty(name="projectDisplay",value = "项目描述",dataType = "String")
    private String projectDisplay;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDisplay() {
        return projectDisplay;
    }

    public void setProjectDisplay(String projectDisplay) {
        this.projectDisplay = projectDisplay;
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
