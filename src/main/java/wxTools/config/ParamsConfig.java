package wxTools.config;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import wxTools.model.BaseOpenApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 操作读取配置文件
 */

public class ParamsConfig {
    /**
     * 获取舞象参数
     *
     * @return
     */
    public static BaseOpenApi getWxParams(String path) {
        BaseOpenApi baseOpenApi = new BaseOpenApi();
        try {
            Properties props = PropertiesLoaderUtils.loadAllProperties(path);
            for (Object key : props.keySet()) {
                Map<String, Object> params = new HashMap<>();
                if ("wx.api.url".equals(key)) {
                    baseOpenApi.setOldUrl(props.get(key) + "");
                }
                if ("wx.api.appId".equals(key)) {
                    baseOpenApi.setOldAppId(props.get(key) + "");
                }
                if ("wx.api.secret".equals(key)) {
                    baseOpenApi.setOldSecret(props.get(key) + "");
                }
                if ("wx.api.newUrl".equals(key)) {
                    baseOpenApi.setNewUrl(props.get(key) + "");
                }
                if ("wx.api.newAppId".equals(key)) {
                    baseOpenApi.setNewAppId(props.get(key) + "");
                }
                if ("wx.api.newSecret".equals(key)) {
                    baseOpenApi.setNewSecret(props.get(key) + "");
                }
                if ("wx.api.version".equals(key)) {
                    baseOpenApi.setVersion(props.get(key) + "");
                }
                if ("wx.api.contentType".equals(key)) {
                    baseOpenApi.setContentType(props.get(key) + "");
                }
                if ("wx.api.storeCode".equals(key)) {
                    baseOpenApi.setStoreCode(props.get(key) + "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseOpenApi;
    }
}
