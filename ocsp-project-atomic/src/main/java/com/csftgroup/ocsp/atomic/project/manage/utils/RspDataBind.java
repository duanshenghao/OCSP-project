package com.csftgroup.ocsp.atomic.project.manage.utils;

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

/**
 * create by: zyy
 * description: TODO
 * create time: 2020/6/15 14:53
 * describe: 用于绑定响应数据
 */
@Component
public class RspDataBind {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public RspModel setRspModelSuccess(ReqHeader reqHeader, RspModel rspModel){
        RspHeader rspHeader = rspModel.getHeader();
        rspHeader.setGloSeqNo(reqHeader.getGloSeqNo());
        log.info("流水生成前：gloSeq:{} tim:{}",reqHeader.getGloSeqNo(),System.currentTimeMillis());
        rspHeader.setRspSeqNo(Sequence.getSequenceNo()); //为获取
        log.info("流水生成后：gloSeq:{} tim:{}",reqHeader.getGloSeqNo(),System.currentTimeMillis());

        rspHeader.setRspTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        //默认成功
        rspHeader.setRspMsg(ErrorEnum.OCSP_SUCCESS.getMessage());
        rspHeader.setRspCode(ErrorEnum.OCSP_SUCCESS.getCode());
        rspHeader.setRspStatus(StatusEnum.SUCCESS.getMessage());
        log.info("返回处理后：gloSeq:{} tim:{}",reqHeader.getGloSeqNo(),System.currentTimeMillis());

        return rspModel;
    }

    public RspModel setRspModelFail(ReqHeader reqHeader, RspModel rspModel, Exception e){
        RspHeader rspHeader = rspModel.getHeader();
        rspHeader.setGloSeqNo(reqHeader.getGloSeqNo());
        rspHeader.setRspSeqNo(Sequence.getSequenceNo()); //为获取
        rspHeader.setRspTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        //默认失败
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
}
