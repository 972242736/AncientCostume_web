package com.mmf.dao;

import com.mmf.model.Address;

import java.util.List;

/**
 * Created by MMF on 2017-09-29.
 */
public interface IAddressDao {

    /**
     * 获取所有省份的信息
     *
     * @return
     */
    List<Address> getProvinceList();

    /**
     * 获取所有城市的信息
     *
     * @return
     */
    List<Address> getCityList(int provinceId);

    /**
     * 获取所有地区的信息
     *
     * @return
     */
    List<Address> getDistrictList(int cityId);
}
