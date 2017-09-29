package com.mmf.service;

import com.mmf.dto.ResponseModel;

/**
 * Created by MMF on 2017-09-29
 */
public interface IAddressService {

    /**
     * 获取所有省份的信息
     *
     * @return
     */
    ResponseModel getProvinceList();

    /**
     * 获取所有城市的信息
     *
     * @return
     */
    ResponseModel getCityList(int provinceId);

    /**
     * 获取所有地区的信息
     *
     * @return
     */
    ResponseModel getDistrictList(int cityId);
}
