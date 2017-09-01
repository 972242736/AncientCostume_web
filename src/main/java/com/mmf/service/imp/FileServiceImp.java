package com.mmf.service.imp;

import com.mmf.dao.IFileDao;
import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import com.mmf.service.IFileService;
import com.mmf.utils.Md5;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MMF on 2017-06-21.
 */
@Service("fileService")
public class FileServiceImp implements IFileService {
    @Resource
    private IFileDao fileDao;

    /**
     * 多文件上传
     ***/
    public void uploadFile(List<MultipartFile> files, int detailId) {
        //图片命名
        long time = System.currentTimeMillis();
        (new File("D:/upload")).mkdirs();
        if (files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                String pathTemp = Md5.getMD5Code(time + file.getOriginalFilename()) + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".") - 1, file.getOriginalFilename().length());
                String path = "D:/upload/" + pathTemp;
                //上传
                try {
                    file.transferTo(new File(path));
                    //在数据库中插入一个记录
                    fileDao.insertFile(pathTemp, detailId,Integer.parseInt(file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int insertDetail(GoodsDetail goodsDetail) {
        return fileDao.insertDetail(goodsDetail);
    }

    @Override
    public GoodsDetail getDetail(int id) {
        return fileDao.getDetail(id);
    }

    @Override
    public GoodsImg getDetailImg(int id, List<Integer> types) {
        return fileDao.getDetailImg(id,types);
    }

}
