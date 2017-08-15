package com.mmf.service;

import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by MMF on 2017-06-21.
 */
public interface IFileService {
    /**
     * 多文件上传
     */
    public void uploadFile(List<MultipartFile> files, int detailId);

    //    public int insertDetail(String title,String describe,String rental,String deposit);

    /**
     * 插入一条发布详细信息
     * @param goodsDetail
     * @return
     */
    public int insertDetail(GoodsDetail goodsDetail);

    /**
     * 获取详情
     * @param id
     * @return
     */
    public GoodsDetail getDetail(int id);

    /**
     * 获取详情图片信息
     * @param id
     * @param type
     * @return
     */
    public GoodsImg getDetailImg(int id, List<Integer> type);
}
