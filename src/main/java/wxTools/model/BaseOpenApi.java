package wxTools.model;

import lombok.Data;

@Data
public class BaseOpenApi {

    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 版本号
     */
    private String version;
    /**
     * 老接口请求地址
     */
    private String oldUrl;
    /**
     * 老接口舞象云id
     */
    private String oldAppId;
    /**
     *老接口私密信息
     */
    private String oldSecret;
    /**
     * 新接口url
     */
    private String newUrl;
    /**
     * 新接口appId
     */
    private String newAppId;
    /**
     * 新接口私密信息
     */
    private String newSecret;
    /**
     * 接口请求头类型
     */
    private String contentType;
    /**
     * 请求类
     */
    private String model;
    /**
     * 请求方法
     */
    private String method;
}
