package com.mmf.service.imp;

import com.mmf.dao.IAddressDao;
import com.mmf.dao.IGoodsDao;
import com.mmf.dto.ResponseModel;
import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import com.mmf.model.GoodsList;
import com.mmf.model.Page;
import com.mmf.service.IAddressService;
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
@Service("addressService")
public class AddressServiceImp implements IAddressService {
    @Resource
    private IAddressDao addressDao;

    /**
     * 获取所有省份的信息
     *
     * @return
     */
    @Override
    public ResponseModel getProvinceList() {
        ResponseModel model = new ResponseModel<List<GoodsList>>(0, "获取数据成功");
        model.setData(addressDao.getProvinceList());
        return model;
    }

    /**
     * 获取所有城市的信息
     *
     * @return
     */
    @Override
    public ResponseModel getCityList(int provinceId) {
        ResponseModel model = new ResponseModel<List<GoodsList>>(0, "获取数据成功");
        model.setData(addressDao.getCityList(provinceId));
        return model;
    }

    /**
     * 获取所有地区的信息
     *
     * @return
     */
    @Override
    public ResponseModel getDistrictList(int cityId) {
        ResponseModel model = new ResponseModel<List<GoodsList>>(0, "获取数据成功");
        model.setData(addressDao.getDistrictList(cityId));
        return model;
    }

}
