package com.csftgroup.ocsp.business.project.manage.endpoint;

import com.csftgroup.ocsp.business.project.manage.model.Project;
import com.csftgroup.ocsp.business.project.manage.model.SubProject;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ocsp-project-atomic")
public interface ProjectManageClient {

    @RequestMapping(value = "/projectManage/queryProjectPaging",method = RequestMethod.POST)
    RspModel queryProjectPaging(ReqModel<Project> reqModel);

    @RequestMapping(value = "/projectManage/addProject",method = RequestMethod.POST)
    RspModel addProject(ReqModel<Project> reqModel);

    @RequestMapping(value = "/projectManage/updateProject",method = RequestMethod.POST)
    RspModel updateProject(ReqModel<Project> reqModel);

    @RequestMapping(value = "/projectManage/deleteProject",method = RequestMethod.POST)
    RspModel deleteProject(ReqModel<Project> reqModel);

    @RequestMapping(value = "/subProjectManage/querySubProjectPaging",method = RequestMethod.POST)
    RspModel querySubProjectPaging(ReqModel<SubProject> reqModel);

    @RequestMapping(value = "/subProjectManage/addSubProject",method = RequestMethod.POST)
    RspModel addSubProject(ReqModel<SubProject> reqModel);

    @RequestMapping(value = "/subProjectManage/updateSubProject",method = RequestMethod.POST)
    RspModel updateSubProject(ReqModel<SubProject> reqModel);

    @RequestMapping(value = "/subProjectManage/deleteSubProject",method = RequestMethod.POST)
    RspModel deleteSubProject(ReqModel<SubProject> reqModel);
}
