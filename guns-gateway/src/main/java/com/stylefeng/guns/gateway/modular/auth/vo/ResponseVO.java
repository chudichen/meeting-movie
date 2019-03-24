package com.stylefeng.guns.gateway.modular.auth.vo;

import lombok.Data;

/**
 * 返回值VO
 *
 * @author Michael.Chu
 * @date 2019-03-18 21:32
 */
@Data
public class ResponseVO<M> {

    /** 返回状态[0-成功，1-失败，999-系统异常] */
    private Integer status;
    /** 返回信息 */
    private String msg;
    /** 返回数据实体 */
    private M data;
    /** 图片前缀 */
    private String imgPre;

    private ResponseVO() {}

    public static<M> ResponseVO success(M model) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(model);
        return responseVO;
    }

    public static<M> ResponseVO success(M model, String imgPre) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(model);
        responseVO.setImgPre(imgPre);
        return responseVO;
    }

    public static<M> ResponseVO success(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static ResponseVO serviceFail(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static ResponseVO appFail(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);
        return responseVO;
    }
}
