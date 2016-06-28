package com.web.controller;

import com.web.entity.ReportProduct;
import com.web.entity.Uploadfile;
import com.web.model.ReportProductModel;
import com.web.service.RecordInfoService;
import com.web.service.UploadFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by gaoyang on 16/2/28.
 */
@RestController
public class UploadFileController {

    @Autowired
    UploadFileService uploadFileService;


    @RequestMapping(value="/uploadfile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Uploadfile adduploadfile(HttpServletRequest request) throws IOException {
        String uuid= request.getHeader("uuid");
        String mimetype= request.getHeader("mimetype");
        String filename=new String(Base64Utils.decodeFromString(request.getHeader("filename")),"UTF-8");


        /**构建保存的目录**/
        String tmpPathDir = "/tmp";
        String tmpRealPathDir = request.getSession().getServletContext().getRealPath(tmpPathDir);
        /**根据真实路径创建目录**/
        File tmpSaveFile = new File(tmpRealPathDir);
        if(!tmpSaveFile.exists())
            tmpSaveFile.mkdirs();
        String fileuuid=UUID.randomUUID().toString();
        String fileName = tmpRealPathDir + File.separator   + fileuuid;
        File file = new File(fileName);
        FileUtils.copyInputStreamToFile(request.getInputStream(),file);

        Uploadfile uploadfile=new Uploadfile();
        uploadfile.setUpdate_time(new Date());
        uploadfile.setCreate_time(new Date());
        uploadfile.setFilename(filename);
        uploadfile.setMimetype(mimetype);
        uploadfile.setUuid(uuid);
        uploadfile.setFilepath(fileuuid);
        uploadfile.setType(0);
        uploadFileService.saveUploadFile(uploadfile);
        return uploadfile;
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
