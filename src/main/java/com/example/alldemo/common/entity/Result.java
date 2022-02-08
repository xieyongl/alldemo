package com.example.alldemo.common.entity;


import com.example.alldemo.enums.ErrorConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 自定义结果集
 */
public class Result extends ResponseEntity implements Serializable {

    private static final long serialVersionUID = -5358885280863549754L;

    public Result(HttpStatus status) {
        super(status);
    }

    /**
     * 成功
     *
     * @param
     * @return
     */
    public static ResponseEntity success() {
        return ResponseEntity.ok(ResultData.success());
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResponseEntity success(ResultData data) {
        return ResponseEntity.ok(data);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResponseEntity success(Object data) {
        return ResponseEntity.ok(ResultData.success(data));
    }

    /**
     * 失败
     *
     * @param status
     * @param data
     * @return
     */
    public static ResponseEntity fail(HttpStatus status, ResultData data) {
        return ResponseEntity.status(status).body(data);
    }

    /**
     * 失败
     *
     * @param status
     * @param data
     * @return
     */
    public static ResponseEntity error(HttpStatus status, ResultData data) {
        return ResponseEntity.status(status).body(data);
    }

    /**
     * 失败 code和HTTP一致
     *
     * @param status
     * @param errMsg
     * @return
     */
    public static ResponseEntity error(HttpStatus status, String errMsg) {
        return ResponseEntity.status(status).body(ResultData.error(errMsg,status.value()));
    }

    /**
     * 失败 自定义code
     *
     * @param status
     * @param errMsg
     * @return
     */
    public static ResponseEntity error(HttpStatus status,int code ,String errMsg) {
        return ResponseEntity.status(status).body(ResultData.error(errMsg,code));
    }

    /**
     * 失败 枚举常量
     *
     * @return
     */
    public static ResponseEntity error(HttpStatus status, ErrorConstants errorConstants) {
        return ResponseEntity.status(status).body(ResultData.error(errorConstants.getMsg(),errorConstants.getCode()));
    }

    /**
     * 自定义结果内部类
     */
    public static class ResultData extends HashMap<String,Object>{

        /**
         * 状态码
         */
        public static final String CODE_TAG = "code";

        /**
         * 返回内容
         */
        public static final String MSG_TAG = "msg";

        /**
         * 数据对象
         */
        public static final String DATA_TAG = "data";

        public static final String OK = "success";

        public static final String FAILED = "failed";

        /**
         * 初始化一个新创建的 Result 对象，使其表示一个空消息。
         */
        public ResultData() {
        }

        /**
         * 初始化一个新创建的 Result 对象
         *
         * @param code 状态码
         * @param msg  返回内容
         */
        public ResultData(int code, String msg) {
            super.put(CODE_TAG, code);
            super.put(MSG_TAG, msg);
        }

        /**
         * 初始化一个新创建的 Result 对象
         *
         * @param code 状态码
         * @param msg  返回内容
         * @param data 数据对象
         */
        public ResultData(int code, String msg, Object data) {
            super.put(CODE_TAG, code);
            super.put(MSG_TAG, msg);
            if (null != data) {
                super.put(DATA_TAG, data);
            }
        }

        /**
         * 返回成功消息
         *
         * @return 成功消息
         */
        public static ResultData success() {
            return ResultData.success(OK);
        }

        /**
         * 返回成功数据
         *
         * @return 成功消息
         */
        public static ResultData success(Object data) {
            return ResultData.success(OK, data);
        }

        /**
         * 返回成功消息
         *
         * @param msg  返回内容
         * @param data 数据对象
         * @return 成功消息
         */
        public static ResultData success(String msg, Object data) {
            return new ResultData(HttpStatus.OK.value(), msg, data);
        }

        /**
         * 返回错误消息
         *
         * @return
         */
        public static ResultData error() {
            return ResultData.error(FAILED);
        }

        /**
         * 返回错误消息
         *
         * @param msg 返回内容
         * @return 警告消息
         */
        public static ResultData error(String msg) {
            return ResultData.error(msg, null);
        }

        /**
         * 返回错误消息
         *
         * @param msg  返回内容
         * @param data 数据对象
         * @return 警告消息
         */
        public static ResultData error(String msg, Object data) {
            return new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
        }

        /**
         * 返回错误消息
         *
         * @param msg  返回内容
         * @param data 数据对象
         * @return 警告消息
         */
        public static ResultData error(String msg, int code) {
            return new ResultData(code, msg);
        }

        /**
         * 返回错误消息
         *
         * @param msg  返回内容
         * @param data 数据对象
         * @return 警告消息
         */
        public static ResultData error(int code, String msg, Object data) {
            return new ResultData(code, msg, data);
        }

        /**
         * 返回错误消息
         *
         * @param code 状态码
         * @param msg  返回内容
         * @return 警告消息
         */
        public static ResultData error(int code, String msg) {
            return new ResultData(code, msg, null);
        }

    }
}
