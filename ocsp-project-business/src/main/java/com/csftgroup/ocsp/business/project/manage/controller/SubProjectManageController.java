package com.csftgroup.ocsp.business.project.manage.controller;

import com.csftgroup.ocsp.business.project.manage.model.SubProject;
import com.csftgroup.ocsp.business.project.manage.service.SubProjectManageService;
import com.csftgroup.ocsp.core.component.code.ErrorEnum;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.core.component.model.header.RspHeader;
import com.csftgroup.ocsp.business.project.manage.utils.RspDataBind;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/subProjectManage")
@RestController
@Api(tags ="子项目管理-微服务层")
public class SubProjectManageController {
    @Autowired
    private SubProjectManageService subProjectManageService;
    @Autowired
    private RspDataBind rspDataBind;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 查询所有
     * @return
     */
    @PostMapping("/querySubProjectPaging")
    @ApiOperation(value = "查询所有子项目",notes = "分页查询")
    public RspModel querySubProjectPaging(@RequestBody @Valid ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  subProjectManageService.querySubProjectPaging(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 新增
     * @return
     */
    @PostMapping("/addSubProject")
    @ApiOperation(value = "新增子项目",notes = "新增子项目")
    public RspModel addSubProject(@RequestBody @Valid ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  subProjectManageService.addSubProject(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 修改
     * @return
     */
    @PostMapping("/updateSubProject")
    @ApiOperation(value = "修改子项目",notes = "修改子项目")
    public RspModel updateSubProject(@RequestBody @Valid ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  subProjectManageService.updateSubProject(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 删除
     * @return
     */
    @PostMapping("/deleteSubProject")
    @ApiOperation(value = "删除子项目",notes = "删除子项目")
    public RspModel<String> deleteSubProject(@RequestBody @Valid ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  subProjectManageService.deleteSubProject(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }
}
