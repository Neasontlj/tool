package wxTools.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import wxTools.model.BaseOpenApi;
import wxTools.model.ResultUtil;
import wxTools.tools.FormatUtil;
import wxTools.tools.HttpClientUtils;
import wxTools.tools.Md5Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WxToolsApi {



    /**
     *
     *
     * @param model 业务名称 例：coupon
     * @param method 具体业务方法名称 例：getUseableCoupons
     * @param json 请求参数json格式 例 {"mobile":"13282832584"}
     * @return 返回json文件
     *
     */
    public static ResultUtil getCRMNewOpenApi(BaseOpenApi baseOpenApi,String storeCode, String model, String method, String json,String path){
        baseOpenApi=ParamsConfig.getWxParams(path);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String date = FormatUtil.formatDataTime(new Date());
        Map<String,String> paramater = new HashMap<>();
        if (!StringUtils.isEmpty(storeCode)){
            paramater.put("store_code",storeCode);
        }else {
            paramater.put("store_code",baseOpenApi.getStoreCode());
        }
        paramater.put("model",model);
        paramater.put("method",method);
        paramater.put("app_id", baseOpenApi.getNewAppId());
        paramater.put("ts", date);
        paramater.put("Content-Type", baseOpenApi.getContentType());
        String sign = Md5Util.MD5( baseOpenApi.getNewAppId()+baseOpenApi.getNewSecret()+date+jsonObject.toString());
        log.info("加密参数为"+baseOpenApi.getNewAppId()+baseOpenApi.getNewSecret()+date+jsonObject.toString());
        log.info("sign ====="+sign);
        paramater.put("sign", sign);
        String jsonto = HttpClientUtils.ajaxPostJson(baseOpenApi.getNewUrl(), paramater, json);
        ResultUtil resultUtil = JSONObject.parseObject(jsonto, new TypeReference<ResultUtil>(){});
        return resultUtil;
    }


    /**
     * 老版本CRM开放接口
     * @param model
     * @param method
     * @param json
     * @return
     */
    public static ResultUtil getCRMOldOpenApi(BaseOpenApi baseOpenApi,String storeCode,String model,String method,String json,String path){
        baseOpenApi=ParamsConfig.getWxParams(path);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String date = FormatUtil.formatDataTime(new Date());
        Map<String,String> paramater = new HashMap<>();
        if (!StringUtils.isEmpty(storeCode)){
            paramater.put("store_code",storeCode);
        }else {
            paramater.put("store_code",baseOpenApi.getStoreCode());
        }
        paramater.put("model",model);
        paramater.put("method",method);
        paramater.put("appid", baseOpenApi.getOldAppId());
        paramater.put("ts", date);
        paramater.put("v", baseOpenApi.getVersion());
        paramater.put("msg", jsonObject.toString());
        String sign = Md5Util.MD5( baseOpenApi.getOldAppId()+baseOpenApi.getNewSecret()+date+baseOpenApi.getVersion());
        log.info("加密参数为"+baseOpenApi.getNewAppId()+baseOpenApi.getNewSecret()+date+baseOpenApi.getVersion());
        log.info("sign ====="+sign);
        paramater.put("sign", sign);
        String jsonto = HttpClientUtils.post(baseOpenApi.getNewUrl(), paramater, "UTF-8");
        ResultUtil resultUtil = JSONObject.parseObject(jsonto, new TypeReference<ResultUtil>(){});
        return resultUtil;
    }


}
