package com.mmf.web;

import com.mmf.dto.ResponseModel;
import com.mmf.model.User;
import com.mmf.service.IFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by MMF on 2017-06-21.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Resource
    private IFileService fileService;

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

    //
    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(@RequestParam Map<String,MultipartFile> files1,HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                List<MultipartFile> files = multiRequest.getFiles(iter.next().toString());
                (new File("D:/upload")).mkdirs();
                if (files != null && files.size() > 0) {
                    for (MultipartFile file : files) {
                        String path = "D:/upload/" + file.getOriginalFilename();
                        //上传
                        file.transferTo(new File(path));
                    }
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        ResponseModel model = new ResponseModel(0, "获取数据成功");
        List<String> list = new ArrayList<String>();
        list.add("哈哈");
        model.setData(list);
        return model;
    }

    //    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public Object uploadFile(@RequestParam Map<String,MultipartFile> files) throws IllegalStateException, IOException {
//        long startTime = System.currentTimeMillis();
//        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
////        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
////                request.getSession().getServletContext());
////        //检查form中是否有enctype="multipart/form-data"
////        if (multipartResolver.isMultipart(request)) {
////            //将request变成多部分request
////            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
////            //获取multiRequest 中所有的文件名
////            Iterator iter = multiRequest.getFileNames();
//
////            while (iter.hasNext()) {
////                //一次遍历所有文件
//
//        (new File("D:/upload")).mkdirs();
////        Set<String> keySet = files.keySet();
//
////        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); ) {
////            String key = iterator.next();
//
////            String value = (String)files.get(key);
////            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
////                request.getSession().getServletContext());
////        //检查form中是否有enctype="multipart/form-data"
////        if (multipartResolver.isMultipart(request)) {
////            //将request变成多部分request
////            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
////            //获取multiRequest 中所有的文件名
////            Iterator iter = multiRequest.getFileNames();
////            /                    for (MultipartFile file : files) {
////            String path = "D:/upload/" + value.getOriginalFilename();
////            //上传
////            value.transferTo(new File(path));
////            System.out.println("value"+value);
////
////        }
//////                List<MultipartFile> files = multiRequest.getFiles(iter.next().toString());
////                if (files != null && files.length > 0) {
//
////                    }
////                }
//
////            }
//
////        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
//        ResponseModel model = new ResponseModel(0, "获取数据成功");
//        List<String> list = new ArrayList<String>();
//        list.add("哈哈");
//        model.setData(list);
//        return model;
//    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile1(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
//        List<MultipartFile> files= request.getFiles("files");
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//                request.getSession().getServletContext());
//        //检查form中是否有enctype="multipart/form-data"
//        if (multipartResolver.isMultipart(request)) {
//            //将request变成多部分request
//            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//            //获取multiRequest 中所有的文件名
        Iterator iter = request.getFileNames();

        (new File("D:/upload")).mkdirs();
        while (iter.hasNext()) {
            //一次遍历所有文件
            List<MultipartFile> files = request.getFiles(iter.next().toString());
            if (files != null && files.size() > 0) {
                for (MultipartFile file : files) {
                    String path = "D:/upload/" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        ResponseModel model = new ResponseModel(0, "获取数据成功");
        List<String> list = new ArrayList<String>();
        list.add("哈哈");
        model.setData(list);
        return model;
    }
}
