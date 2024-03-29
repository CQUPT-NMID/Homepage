package cn.itrover.homepage.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/15 12:32
 */

@ConfigurationProperties(prefix = "config.cos")
@Component
public class CosUtil {

    private String secretId;

    private String secretKey;

    private String regin;

    private String bucketName;

    private String url;

    public COSClient getCOSClient(){
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(regin);
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    public String upload(MultipartFile file) throws IOException {
        COSClient cosClient = getCOSClient();
        // 指定要上传到的存储桶
        // 指定要上传到 COS 上对象键
        Date time = new Date();
        String key = "image/"+time.getTime()+"_"+file.getOriginalFilename();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(),null);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return url+key;
    }

    // --------------------- getter & setter ---------------------


    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRegin(String regin) {
        this.regin = regin;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
