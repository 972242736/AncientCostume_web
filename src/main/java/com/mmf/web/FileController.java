package com.mmf.web;

import com.mmf.model.User;
import com.mmf.service.IFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private Object uploadFile(@RequestParam(value = "data",defaultValue = "",required = false) String data) {
        List<String> list = new ArrayList<String>();
        list.add("sss");
//                = fileService.uploadFile();
//        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        System.out.println("**********/////////" +data);
        return list;
    }
}
