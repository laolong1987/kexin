package com.web.controller;

import com.utils.ConvertUtil;
import com.web.entity.ReportProduct;
import com.web.entity.Uploadfile;
import com.web.model.ReportProductModel;
import com.web.service.RecordInfoService;
import com.web.service.UploadFileService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

/**
 * Created by gaoyang on 16/2/28.
 */
@RestController
public class UploadFileController {

    @Autowired
    UploadFileService uploadFileService;


    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Uploadfile adduploadfile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {

        String uuid=request.getParameter("uuid");
        int file_type=ConvertUtil.safeToInteger(request.getParameter("file_type"),1);


        /**构建保存的目录**/
        String tmpPathDir = "/tmp";
        String tmpRealPathDir = request.getSession().getServletContext().getRealPath(tmpPathDir);
        /**根据真实路径创建目录**/
        File tmpSaveFile = new File(tmpRealPathDir);
        if (!tmpSaveFile.exists())
            tmpSaveFile.mkdirs();
        String fileuuid = UUID.randomUUID().toString();
        String fileName = tmpRealPathDir + File.separator + fileuuid;

        File transferred = new File(fileName);
        file.transferTo(transferred);

         String attachmentName = FilenameUtils.getName(file.getOriginalFilename());
         String attachmentContentType = file.getContentType();

        Uploadfile uploadfile = new Uploadfile();
        uploadfile.setUpdate_time(new Date());
        uploadfile.setCreate_time(new Date());
        uploadfile.setFilename(attachmentName);
        uploadfile.setMimetype(attachmentContentType);
        uploadfile.setUuid(uuid);
        uploadfile.setFile_type(ConvertUtil.safeToInteger(file_type,0));
        uploadfile.setFilepath(fileuuid);
        uploadfile.setType(file_type);
        uploadFileService.saveUploadFile(uploadfile);
        return uploadfile;
    }


    @RequestMapping(value = "/doDownload/{id}", method = RequestMethod.GET)
    public void doDownload(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Uploadfile uploadfile = uploadFileService.getUploadfile(id);

        if (null == uploadfile) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        if (StringUtils.isNotBlank(uploadfile.getMimetype()))
            response.setContentType(uploadfile.getMimetype());
        else
            response.setContentType("application/octet-stream");

        if (StringUtils.isNotBlank(uploadfile.getFilename())) {
            response.setHeader("Content-Disposition", getContentDispositionValue(uploadfile.getFilename()));
        }

        /**构建保存的目录**/
        String tmpPathDir = "/file";
        String tmpRealPathDir = request.getSession().getServletContext().getRealPath(tmpPathDir);
        String fileName = tmpRealPathDir + File.separator + uploadfile.getFilepath();
        /**根据真实路径创建目录**/
        File saveFile = new File(fileName);
        response.setContentLength((int) saveFile.length());
        OutputStream out = response.getOutputStream();
        try {
            FileUtils.copyFile(saveFile, out);
        } finally {
            IOUtils.closeQuietly(out);
        }

    }

    private String getAsciiFilename(String filename) {
        return new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }

    private String getContentDispositionValue(String filename) {

        return String.format("attachment; filename=\"%s\"; filename*=UTF-8''%s",
                getAsciiFilename(filename),
                urlEncode(filename));
        //return String.format("attachment; filename=\"%s\"", getAsciiFilename(encodedFilename));
    }

    private String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException(uee);
        }
    }

//    @ExceptionHandler
//    public ResponseEntity<ErrorModel> handleBindException(BindException be) {
//        ErrorModelBuilder errorModelBuilder = new ErrorModelBuilder("000500");
//
//        for (FieldError fieldError : be.getBindingResult().getFieldErrors()) {
//            String errorCode = fieldError.getDefaultMessage();
//            if (ErrorModelBuilder.validateErrorCode(errorCode))
//                errorModelBuilder.addChildError(errorCode);
//        }
//
//        ErrorModel model = errorModelBuilder.build();
//        return new ResponseEntity<>(model, HttpStatus.valueOf(model.getStatusCode()));
//    }
}
