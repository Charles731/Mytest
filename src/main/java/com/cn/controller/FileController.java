package com.cn.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by User on 2017/10/26.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    /*
    * 文件上传功能
    * @param file
    * @throw IOException
    * */
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public String upload(@RequestParam(value = "upLoadFile", required = false) MultipartFile file, HttpServletRequest request,Model model) throws IOException {
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("/pic/");
            //上传文件名
            String fileName = file.getOriginalFilename();
            File dir = new File(path, fileName);
            //判断路径是否存在，如果不存在就创建一个
            if (!dir.getParentFile().exists()) {
                dir.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中,MultipartFile自带的解析方法
            file.transferTo(dir);
            model.addAttribute("fileName",fileName);
            return "fileSuccess";
        } else {
            return "fileError";
        }
    }
    /*
    * 文件自带下载功能
    * @param request
    * @throws Exception
    * */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("downLoadFile")String file, Model model) throws Exception{
        //下载文件路径
        String path = request.getServletContext().getRealPath("/pic/");
        File dir = new File(path + File.separator + file);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFileName = new String(file.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment",downloadFileName);
        //application/octet-stream:二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(dir),headers, HttpStatus.CREATED);
    }

}
