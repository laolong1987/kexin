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
        sql.append("select * from uploadfile where uuid=:uuid  ");
        Map map = new HashMap();
        map.put("uuid",uuid);
        List<Uploadfile> list = super.findObjects(sql.toString(), map, Uploadfile.class);
        return list;
    }
}
