package com.web.service;

import java.util.ArrayList;
import java.util.List;

import com.web.dao.FileListDao;
import com.web.entity.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/8/14.
 */
@Service
public class FileListService {
    @Autowired
    private FileListDao fileListDao;

    public List<String> findFilePathList(String recordNo,String certificate_order){
        List<String> filePathList=new ArrayList<>();
        if (certificate_order==null || "".equals(certificate_order))
            return  filePathList;

        FileList fileList=new FileList();
        fileList.setRecord_no(recordNo);
        fileList.setCertificate_order(Integer.parseInt(certificate_order));
        List<FileList> list= fileListDao.findFileList(fileList);
        for (FileList file : list){
            String real_path=file.getFile_path();
            String filename=real_path.substring(real_path.lastIndexOf("/")+1);
            String filePath="http://www.ecdata.org.cn/srv/viewPartyDownloadAction.action?fileName=" +filename;
            filePathList.add(filePath);
        }
        return filePathList;
    }

}
