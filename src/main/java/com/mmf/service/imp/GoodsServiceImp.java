package com.mmf.service.imp;

import com.mmf.dao.IGoodsDao;
import com.mmf.dto.ResponseModel;
import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import com.mmf.model.GoodsList;
import com.mmf.model.Page;
import com.mmf.service.IGoodsService;
import com.mmf.utils.Md5;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by MMF on 2017-06-21.
 */
@Service("goodsService")
public class GoodsServiceImp implements IGoodsService {
    @Resource
    private IGoodsDao goodsDao;

    /**
     * 多文件上传
     ***/
    public void uploadFile(List<MultipartFile> files, int detailId,MultipartHttpServletRequest request) {
        //图片命名
        long time = System.currentTimeMillis();
        String filePath = request.getServletContext().getRealPath("/")+"/upload/";
        (new File(filePath)).mkdirs();
        if (files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                String pathTemp = Md5.getMD5Code(time + file.getOriginalFilename()) + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".") - 1, file.getOriginalFilename().length());
                String path = filePath + pathTemp;
                //上传
                try {
                    file.transferTo(new File(path));
                    //在数据库中插入一个记录
                    goodsDao.insertFile(pathTemp, detailId, Integer.parseInt(file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ResponseModel insertDetail(GoodsDetail goodsDetail, MultipartHttpServletRequest request) {
        //先插入发布的详情数据，获取到对应的详情的id的值
        int count = goodsDao.insertDetail(goodsDetail);
        if (count < 1) {
            return new ResponseModel(-1, "发布失败");
        }
        int detailId = goodsDetail.getId();
        Iterator iter = request.getFileNames();
        while (iter.hasNext()) {
            //一次遍历所有文件
            List<MultipartFile> files = request.getFiles(iter.next().toString());
            uploadFile(files, detailId,request);
        }
        return new ResponseModel(0, "发布成功");
    }

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    @Override
    public ResponseModel getGoodsDetail(int id, int type) {
        GoodsDetail goodsDetail = goodsDao.getGoodsDetail(id);
        List<Integer> typeList = new ArrayList<>();
        if (type == 1) {
            typeList.add(0);
            typeList.add(1);
        } else {
            typeList.add(2);
            typeList.add(1);
            typeList.add(0);
        }
        List<GoodsImg> goodsImg = getDetailImg(id, typeList);
        ResponseModel model = new ResponseModel<List<GoodsImg>>(0, "获取数据成功");
        model.setData(goodsImg);

        return model;
    }

    @Override
    public List<GoodsImg> getDetailImg(int id, List<Integer> types) {
        return goodsDao.getDetailImg(id, types);
    }

    /**
     * 获取商品列表
     *
     * @param page
     * @return
     */
    @Override
    public ResponseModel getGoodsList(Page page) {
        ResponseModel model = new ResponseModel<List<GoodsList>>(0, "获取数据成功");
        model.setData(goodsDao.getGoodsList(page));
        return model;
    }

}
