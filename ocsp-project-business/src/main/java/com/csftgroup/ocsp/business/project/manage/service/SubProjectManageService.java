package com.csftgroup.ocsp.business.project.manage.service;

import com.csftgroup.ocsp.business.project.manage.endpoint.ProjectManageClient;
import com.csftgroup.ocsp.business.project.manage.model.SubProject;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubProjectManageService {

    @Resource
    private ProjectManageClient projectManageClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RspModel querySubProjectPaging(ReqModel<SubProject> reqModel) throws Exception{
        try {
            return projectManageClient.querySubProjectPaging(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

    public RspModel addSubProject(ReqModel<SubProject> reqModel) throws Exception{
        try {
            return projectManageClient.addSubProject(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

    public RspModel updateSubProject(ReqModel<SubProject> reqModel) throws Exception{
        try {
            return projectManageClient.updateSubProject(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

    public RspModel deleteSubProject(ReqModel<SubProject> reqModel) throws Exception{
        try {
            return projectManageClient.deleteSubProject(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

}
