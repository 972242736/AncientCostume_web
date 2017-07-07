package com.mmf.service.imp;

import com.mmf.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by MMF on 2017-06-21.
 */
@Service("fileService")
public class FileServiceImp implements IFileService{
    /**
     *
     * 多文件上传
     *
     ***/
    public Object uploadFile(MultipartFile[] files){
        Object object = new Object();

//        StringBuffer path = new StringBuffer();
//        path = path.append(configReader.getDriverLetter()).append(configReader.getLocalPath()).append(1000000000).append("/").append(1000000001).append("/");
//        System.out.println("文件存放路径"+path);
//        //如果目录不存在，则新建
//        File dir = new File(path.toString());
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//        String tmpPath = path.toString();
//        for (int i = 0; i < files.length; i++) {
//
//            MultipartFile file = files[i];
//
//            //图片命名
//            String tmp = Utils.getSysTimeSSS();
//            tmpPath = tmpPath+tmp+".png";
//            System.out.println("文件路径:"+tmpPath);
//
//            //上传图片
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(tmpPath)));
//                stream.write(bytes);
//                stream.close();
//                tmpPath=path.toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//
//                //评论图片上传失败
//                return null;
//            }
//        }

        return object;
    }
}
