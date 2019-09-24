package com.liu.vo;

import lombok.Data;

@Data
public class LogOnVO {
    private Integer status;
    private String message;

    public static LogOnVO success(){
        LogOnVO logOnVO = new LogOnVO();
        logOnVO.setMessage("成功");
        logOnVO.setStatus(0);
     return logOnVO;
    }

    public static LogOnVO error(Integer status,String message){
        LogOnVO logOnVO = new LogOnVO();
        logOnVO.setMessage(message);
        logOnVO.setStatus(status);
        return logOnVO;
    }
}
