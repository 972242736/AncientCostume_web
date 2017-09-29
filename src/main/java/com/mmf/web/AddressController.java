package com.mmf.web;

import com.mmf.dto.ResponseModel;
import com.mmf.service.IAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by MMF on 2017-09-28.
 */
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Resource
    private IAddressService addressService;


    /**
     * 获取所有省份的信息
     *
     * @return
     */
    @RequestMapping(value = "/getProvinceList", method = RequestMethod.GET)
    @ResponseBody
    public Object getProvinceList() {
        return addressService.getProvinceList();
    }


    /**
     * 获取所有城市的信息
     *
     * @return
     */
    @RequestMapping(value = "/getCityList", method = RequestMethod.GET)
    @ResponseBody
    ResponseModel getCityList(int provinceId) {
        return addressService.getCityList(provinceId);
    }

    /**
     * 获取所有地区的信息
     *
     * @return
     */
    @RequestMapping(value = "/getDistrictList", method = RequestMethod.GET)
    @ResponseBody
    ResponseModel getDistrictList(int cityId) {
        return addressService.getDistrictList(cityId);
    }

}
