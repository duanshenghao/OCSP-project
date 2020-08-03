package com.csftgroup.ocsp.business.project.manage.utils;

import com.csftgroup.ocsp.component.sequence.util.Sequence;
import com.csftgroup.ocsp.core.component.code.ErrorEnum;
import com.csftgroup.ocsp.core.component.code.StatusEnum;
import com.csftgroup.ocsp.core.component.exception.BusinessException;
import com.csftgroup.ocsp.core.component.model.RspModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.core.component.model.header.RspHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RspDataBind {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public synchronized RspModel setRspModelSuccess(ReqHeader reqHeader, RspModel rspModel){

        RspHeader rspHeader = rspModel.getHeader();
        rspHeader.setGloSeqNo(reqHeader.getGloSeqNo());
        rspHeader.setRspSeqNo(Sequence.getSequenceNo()); //为获取
        rspHeader.setRspTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        //默认成功
        rspHeader.setRspMsg(ErrorEnum.OCSP_SUCCESS.getMessage());
        rspHeader.setRspCode(ErrorEnum.OCSP_SUCCESS.getCode());
        rspHeader.setRspStatus(StatusEnum.SUCCESS.getMessage());
        return rspModel;
    }

    public synchronized RspModel setRspModelFail(ReqHeader reqHeader, RspModel rspModel, Exception e){
        RspHeader rspHeader = rspModel.getHeader();
        rspHeader.setGloSeqNo(reqHeader.getGloSeqNo());
        rspHeader.setRspSeqNo(Sequence.getSequenceNo()); //为获取
        rspHeader.setRspTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        if(e instanceof BusinessException){
            rspHeader.setRspMsg(((BusinessException) e).getErrMsg());
            rspHeader.setRspCode(((BusinessException) e).getErrCode());
            rspHeader.setRspStatus(StatusEnum.ERROR.getMessage());
        }else{
            rspHeader.setRspMsg(ErrorEnum.OCSP_ERROR.getMessage());
            rspHeader.setRspCode(ErrorEnum.OCSP_ERROR.getCode());
            rspHeader.setRspStatus(StatusEnum.ERROR.getMessage());
        }
        return rspModel;
    }

    //上游服务发生异常
    public synchronized RspModel setRspModelFail(ReqHeader reqHeader, RspModel rspModel, RspHeader rspHeader1){
        RspHeader rspHeader = rspModel.getHeader();
        rspHeader.setGloSeqNo(reqHeader.getGloSeqNo());
        rspHeader.setRspSeqNo(Sequence.getSequenceNo()); //为获取
        rspHeader.setRspTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        //返回上游返回异常
        rspHeader.setRspMsg(rspHeader1.getRspMsg());
        rspHeader.setRspCode(rspHeader1.getRspCode());
        rspHeader.setRspStatus(rspHeader1.getRspStatus());
        return rspModel;
    }
}
