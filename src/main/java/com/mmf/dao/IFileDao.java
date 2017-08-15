package com.mmf.dao;

import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MMF on 2017-07-28.
 */
public interface IFileDao {
    /**
     * 插入图片的记录
     * @param imgName
     * @param detailId
     * @return
     */
    int insertFile(@Param("imgName")String imgName,@Param("detailId")int detailId,@Param("type")int type);

    /**
     * 插入商品的详细数据
     * @param goodsDetail
     * @return
     */
    int insertDetail(GoodsDetail goodsDetail);

    /**
     * 获取商品的详细信息
     * @param id
     * @return
     */
    GoodsDetail getDetail(int id);

    /**
     * 获取商品的图片信息
     * @param detailId
     * @return
     */
    GoodsImg getDetailImg(int detailId, List<Integer> type);
}
