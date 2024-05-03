package com.powerconvert.backgroundconvert.module.wordconvert.controller;


import com.powerconvert.backgroundconvert.intercepter.LoginInterceptor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@Api(tags = "Word文件转成其他文件")
@RequestMapping(value = "/word")
public class WordConvertController {

    private static final Logger logger = LoggerFactory.getLogger(WordConvertController.class);

    @PostMapping(value = "/convertPdf")
    @ApiOperation(value = "Word文件转成Pdf文件")
    public void word2Pdf(@ApiParam(value = "需要转换的word文件")
                                   @RequestPart
                                   @RequestParam(value = "需要转换的word文件") MultipartFile file,
                         HttpServletResponse response) throws IOException {

        File localFile = new File("/Users/luqiqi/Downloads/十方融海面试登记表2024.doc");
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            String encodeFileName = URLEncoder.encode(localFile.getName(), "UTF-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + encodeFileName + "\"");
            response.addHeader("Content-Length", "" + localFile.length());

            fileInputStream = new FileInputStream(localFile);
            outputStream = response.getOutputStream();
            byte[] car = new byte[1024 * 4];
            int len = 0;
            while ((len = fileInputStream.read(car)) != -1){
                outputStream.write(car, 0, len);
            }

        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        } finally {
            fileInputStream.close();
            outputStream.close();;
        }


    }


}
