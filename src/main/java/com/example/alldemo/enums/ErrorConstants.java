package com.example.alldemo.enums;

/**
 * @Description 返回值常量类
 */
public enum ErrorConstants {

    SUCCESS_MESSAGE(200,"操作成功"),
    ERROR_MESSAGE(500,"操作失败"),
    OPERATION_OFTEN_ERROR(800,"操作频繁，请稍后再试"),

    /** 用户相关 **/
    USER_EMPTY(900,"该用户不存在"),
    TOKEN_ERROR(901,"无效token"),

    USER_NICKNAME_EXIST(902, "用户昵称已存在"),

    /** 训练营相关 **/
    TRAINING_END(1000,"很抱歉，该期训练营已结束"),
    CONTENT_ERROR(1001,"该内容已失效，请刷新重试"),
    TRAINING_TEMPLATE_ERROR(1002,"该模板已失效，请重新选择模板"),
    // CONTENT_PARAM_EMPTY(1003,"发布内容id缺失"),
    CONTENT_TITLE_ERROR(1004,"无法保存空白内容"),
    COMMENT_EMPTY(1005,"该评论已删除，请刷新重试"),
    CONTENT_NODE_ERROR(1006,"所传字段与模板字段不一致"),
    ILLEGAL_CONTENT(1007,"检测内容违规"),
    ILLEGAL_SAVE(1008,"非法编辑"),
    RECOMMEND_ALREADY_EXIST(1009, "推荐案例已存在，不能重复设置推荐");









    private final int code;
    private final String msg;

    ErrorConstants(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
