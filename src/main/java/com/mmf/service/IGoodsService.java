package com.mmf.service;

import com.mmf.dto.ResponseModel;
import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import com.mmf.model.GoodsList;
import com.mmf.model.Page;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

/**
 * Created by MMF on 2017-06-21.
 */
public interface IGoodsService {
    /**
     * 多文件上传
     */
    void uploadFile(List<MultipartFile> files, int detailId,MultipartHttpServletRequest request);

    //    public int insertDetail(String title,String describe,String rental,String deposit);

    /**
     * 插入一条发布详细信息
     *
     * @param goodsDetail
     * @return
     */
    ResponseModel insertDetail(GoodsDetail goodsDetail, MultipartHttpServletRequest request);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    ResponseModel getGoodsDetail(int id, int type);

    /**
     * 获取详情图片信息
     *
     * @param id
     * @param type
     * @return
     */
    List<GoodsImg> getDetailImg(int id, List<Integer> type);

    /**
     * 获取商品列表
     * @param page
     * @return
     */
    ResponseModel getGoodsList(Page page);
}
