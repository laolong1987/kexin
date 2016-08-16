package com.web.dao;

import java.util.List;

import com.common.BaseDao;
import com.web.entity.FileList;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/8/14.
 */
@Repository
public class FileListDao extends BaseDao{

    public List<FileList> findFileList(FileList fileList){
        StringBuffer sql=new StringBuffer();
        sql.append("From FileList t where 1=1 ");
        sql.append(" and t.record_no=:record_no");
        sql.append(" and t.certificate_order=:certificate_order");
        return super.findObjects(sql.toString(), fileList);
    }

}
