package com.web.dao;


import com.common.BaseDao;
import com.web.entity.Uploadfile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/29.
 */
@Repository
public class UploadFileDao extends BaseDao{


    public List<Uploadfile> findUploadfileByUUID(String uuid){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from uploadfile where uuid=:uuid and type=0 ");
        Map map = new HashMap();
        map.put("uuid",uuid);
        List<Uploadfile> list = super.findObjects(sql.toString(), map, Uploadfile.class);
        return list;
    }

    public List<Uploadfile> findUploadfileByReportId(String report_id,String report_type){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from uploadfile where report_id=:report_id and type=1 and report_type=:report_type ");
        Map map = new HashMap();
        map.put("report_id",report_id);
        map.put("report_type",report_type);
        List<Uploadfile> list = super.findObjects(sql.toString(), map, Uploadfile.class);
        return list;
    }
}
