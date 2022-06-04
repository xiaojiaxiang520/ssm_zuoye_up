package com.biunm.system211.Utils;

import com.alibaba.fastjson.JSONObject;
import com.biunm.system211.pojo.Task;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class QiniuFileUpload {
    //七牛云的配置文件

    String ACCESS_KEY="uAwSdPaXOmuOA6lL2mQmw5u972RNPTaXPJ8xE4Dz";

    String SECRET_KEY="XkLrU_q4aTwTM4e0ae5UPjyoLjUuJFLet8OXUteD";

    String bucketname="htsystem";

    String QINIU_IMAGE_DOMAIN="http://cos.biunm.com/";

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
    Configuration cfg = new Configuration(Region.huadong());
    // ...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    public String saveFile(MultipartFile file, Task task) {
        // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
        String uploadToken = auth.uploadToken(bucketname);

        try {
            // 调用put方法上传
            String fileName ="task/"+task.getCourseId()+"/"+task.getTaskId()+"/"+file.getOriginalFilename();
            //上传：文件，地址，身份验证
            Response res = uploadManager.put(file.getBytes(),fileName,uploadToken);
            // 打印返回的信息
            if (res.isOK() && res.isJson()) {
                // 返回这张存储照片的地址
                System.out.println("返回地址："+QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key"));
                return QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key");
            } else {
                System.out.println("七牛异常:" + res.bodyString());
                return null;
            }
        } catch (QiniuException e) {
            System.out.println("七牛异常:" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("IO流异常："+e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
