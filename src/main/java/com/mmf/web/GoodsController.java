package com.mmf.web;

import com.mmf.dto.ResponseModel;
import com.mmf.model.GoodsDetail;
import com.mmf.model.GoodsImg;
import com.mmf.model.Page;
import com.mmf.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by MMF on 2017-06-21.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
    @Resource
    private IGoodsService goodsService;

    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
//    private Object uploadFile(@RequestParam(value = "data",defaultValue = "",required = false) String data,@RequestParam(value = "params",defaultValue = "",required = false) Map<String, MultipartFile> params) {
//    private Object uploadFile(@RequestParam(value = "data",defaultValue = "",required = false) String data,Map<String, MultipartFile> params) {
    private Object uploadFile(@RequestPart(name = "data", value = "data", required = false) String data, @RequestBody Map<String, RequestBody> params) {
        List<String> list = new ArrayList<String>();
        list.add("sss");
//                = fileService.uploadFile();
//        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        System.out.println("**********/////////" + data);
        return list;
    }

    @RequestMapping(value = "/insertDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object insertDetail(GoodsDetail goodsDetail, MultipartHttpServletRequest request) throws IllegalStateException, IOException {
        return goodsService.insertDetail(goodsDetail, request);
    }

    @RequestMapping(value = "/getGoodsDetail", method = RequestMethod.GET)
    @ResponseBody
    public Object getGoodsDetail(Integer id, Integer type) {
        ResponseModel model = new ResponseModel<List<GoodsImg>>(0, "获取数据成功");
        if (StringUtils.isEmpty(id)) {
            model.setMessage("缺少参数id");
            return model;
        }

        return goodsService.getGoodsDetail(id, type);
    }

    @RequestMapping(value = "/getGoodsList", method = RequestMethod.GET)
    @ResponseBody
    public Object getGoodsList(Integer pageNo, Integer pageSize) {
        Page page = new Page(request);
        return goodsService.getGoodsList(page);
    }
}
