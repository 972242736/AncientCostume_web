package com.mmf.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by MMF on 2017-06-21.
 */
public interface IFileService {
    /**
     *
     * 多文件上传
     *
     ***/
    public Object uploadFile(List<MultipartFile> files,int detailId);
}
