package com.ct.service.ForegroundService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FileuploadService {
    public List<String> imgUpload(MultipartFile[] files) {
        List<String> result = new ArrayList<>();
        for (MultipartFile uploadFile : files) {
            File folder = new File("C:\\HzauTrade\\imgs");
            if(!folder.isDirectory()){
                folder.mkdirs();
            }
            Calendar calendar= Calendar.getInstance();
            SimpleDateFormat dateFormat= new SimpleDateFormat("hh:mm:ss");
            String fileName = uploadFile.getOriginalFilename();
            String slat = dateFormat.format(calendar.getTime());
            // 设置待加密字符串
            String  str = fileName + slat;
            String NewFileName = "";
            try {
                MessageDigest m = MessageDigest.getInstance("MD5");
                m.update(str.getBytes("UTF8"));
                byte s[] = m.digest();
                for (int i = 0; i < s.length; i++) {
                    NewFileName += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
                }
                NewFileName = NewFileName + ".jpg";
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                uploadFile.transferTo(new File(folder, NewFileName));
                //静态资源访问地址返回
                result.add("http://localhost:1024/image/" + NewFileName);
            } catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

}
