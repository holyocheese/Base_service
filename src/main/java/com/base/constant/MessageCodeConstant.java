package com.base.constant;

public class MessageCodeConstant {
    // 异常编码
    public static final int SUCCESS            = 200;
    public static final int QUERY_EMPTY        = 410;
    public static final int SERVER_ERROR       = 500;
    public static final int PARAM_FORMAT_ERROR = 400;

    public static final String MESSAGE_OK   = "OK";
    public static final String MESSAGE_FAIL = "FAIL";

    public static final int SERVER_404 = 404;
    public static final int SERVER_504 = 504;
    public static final int SERVER_500 = 500;
    public static final int SERVER_400 = 400;

    public static final String MESSAGE_404 = "目标资源不存在";
    public static final String MESSAGE_504 = "请求超时";
    public static final String MESSAGE_500 = "系统繁忙,请稍后重试";
    public static final String MESSAGE_400 = "请求数据非法";

    public static final int SERVER_201 = 201;  //不能更改行程
    public static final int SERVER_600 = 600;  //退票
    public static final int SERVER_601 = 601;
    public static final int SERVER_602 = 602;
    public static final int SERVER_603 = 603;
    public static final int SERVER_700 = 700;

    public static final String MESSAGE_600 = "用户已登录";
    public static final String MESSAGE_601 = "用户未登录";
    public static final String MESSAGE_700 = "版本过低，需要更新最新版本";

    public static final String INPUT_DATA_SUCCESS         = "导入数据成功!";
    public static final String SELECT_ERROR               = "查询时异常:";
    public static final String DELETE_ERROR               = "删除时异常:";
    public static final String UPDATE_ERROR               = "更新时异常:";
    public static final String ADD_ERROR                  = "新增时发生异常:";
    public static final String SYNCHRONIZE_FAILED         = "同步失败";
    public static final String    INVOKE_REMOTE_API_ERROR = "调用成本中心接口时发生异常:";
    public static final String PARSE_ERROR                = "转换时发生异常:";
    public static final String PARAMETER_IS_NULL          = "参数为空";
}
