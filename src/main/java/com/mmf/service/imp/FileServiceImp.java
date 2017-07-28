package com.mmf.service.imp;

import com.mmf.service.IFileService;
import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MMF on 2017-06-21.
 */
@Service("fileService")
public class FileServiceImp implements IFileService {
    /**
     * 多文件上传
     ***/
    public Object uploadFile(List<MultipartFile> files,int detailId) {
        Object object = new Object();

     //图片命名
        long time = System.currentTimeMillis();

        (new File("D:/upload")).mkdirs();
        if (files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                String path = "D:/upload/" + time + file.getName().substring(file.getName().indexOf(".") - 1, file.getName().length() - 1);
                //在数据库中插入一个记录

                System.out.println("path" + path);
                //上传
                try {
                    file.transferTo(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return object;
    }

}
