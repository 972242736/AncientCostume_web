package com.mmf.dao;

import com.mmf.model.GoodsDetail;
import org.apache.ibatis.annotations.Param;

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
    int insertFile(@Param("imgName")String imgName,@Param("detailId")int detailId);

    /**
     * 插入商品的详细数据
     * @param goodsDetail
     * @return
     */
    int insertDetail(GoodsDetail goodsDetail);

    /**
     * 获取商品的详细数据
     * @param id
     * @return
     */
    GoodsDetail getDetail(int id);
}
