package com.mmf.dao;

import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import com.mmf.model.GoodsList;
import com.mmf.model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MMF on 2017-07-28.
 */
public interface IGoodsDao {
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
    GoodsDetail getGoodsDetail(int id);

    /**
     * 获取商品的图片信息
     * @param detailId
     * @return
     */
    List<GoodsImg> getDetailImg(@Param("detailId")int detailId, @Param("types") List<Integer> types);

    /**
     * 获取商品列表
     * @param page
     * @return
     */
    List<GoodsList> getGoodsList(@Param("page")Page page);
}
