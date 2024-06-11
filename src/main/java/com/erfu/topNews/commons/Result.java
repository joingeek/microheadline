package com.erfu.topNews.commons;

/**
 * 全局统一返回结果类
 *
 * @param <T> 返回的数据类型
 *
 * 该类用于封装所有返回给前端的响应数据，包括状态码、消息和具体数据。通过使用泛型，可以灵活地返回不同类型的数据。
 */
public class Result<T> {
    // 返回码
    private Integer code;
    // 返回消息
    private String message;
    // 返回数据
    private T data;

    // 无参构造函数
    public Result(){}

    /**
     * 构建返回数据的静态方法
     *
     * @param data 需要返回的数据
     * @param <T>  数据的类型
     * @return 返回一个包含数据的Result对象
     */
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    /**
     * 构建返回数据和状态码、消息的静态方法
     *
     * @param body    返回的数据
     * @param code    返回的状态码
     * @param message 返回的消息
     * @param <T>     数据的类型
     * @return 返回一个包含数据、状态码和消息的Result对象
     */
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 构建返回数据和状态码枚举的静态方法
     *
     * @param body           返回的数据
     * @param resultCodeEnum 状态码枚举
     * @param <T>            数据的类型
     * @return 返回一个包含数据和状态码枚举信息的Result对象
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 操作成功时返回的数据
     *
     * @param data 返回的数据
     * @param <T>  数据的类型
     * @return 返回一个表示操作成功的Result对象
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 设置返回消息
     *
     * @param msg 返回的消息
     * @return 返回设置消息后的Result对象
     */
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    /**
     * 设置返回码
     *
     * @param code 返回的状态码
     * @return 返回设置状态码后的Result对象
     */
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    // 获取返回码
    public Integer getCode() {
        return code;
    }

    // 设置返回码
    public void setCode(Integer code) {
        this.code = code;
    }

    // 获取返回消息
    public String getMessage() {
        return message;
    }

    // 设置返回消息
    public void setMessage(String message) {
        this.message = message;
    }

    // 获取返回数据
    public T getData() {
        return data;
    }

    // 设置返回数据
    public void setData(T data) {
        this.data = data;
    }
}
