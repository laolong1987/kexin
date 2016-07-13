package com.web.service;

import java.util.*;


import com.common.SearchTemplate;
import com.utils.DateUtil;
import com.web.dao.WaringsInfoDao;
import com.web.entity.WaringsInfo;
import com.web.model.Warings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/7/10.
 */
@Service
public class WaringsInfoService {

    @Autowired
    private WaringsInfoDao waringsInfoDao;

    public List<Warings> findWaringsInfoByKeyWords(String keyword) {
        List<WaringsInfo> list = waringsInfoDao.findWaringsInfoByKeyWords(keyword);
        List<Warings> waringsList = new ArrayList<>();
        for (WaringsInfo waringsInfo : list) {
            Warings warings = new Warings();
            warings.setTitle(waringsInfo.getTitle());
            warings.setContent(waringsInfo.getContent());
            warings.setEnterprise(waringsInfo.getEnterprise());
            warings.setProduct(waringsInfo.getProduct());
            warings.setPublish_department(waringsInfo.getPublish_department());
            warings.setPublish_time(DateUtil.FormatUIDate(waringsInfo.getCreate_time()));
            waringsList.add(warings);
        }

        return waringsList;
    }

    /**
     * 保存警示信息
     * @param waringsInfo
     */
    public void saveWaringsInfo(WaringsInfo waringsInfo) {
        waringsInfoDao.save(waringsInfo);
    }


    /**
     * 查询警示信息
     *
     * @param map
     *
     * @return
     */
    public SearchTemplate searchWaringsInfo(Map map) {
        return waringsInfoDao.searchWaringsInfo(map);
    }

    /**
     * 通过ID查询警示信息
     *
     * @param id
     *
     * @return
     */
    public WaringsInfo findWaringsInfoById(String id) {

        WaringsInfo waringsInfo =(WaringsInfo) waringsInfoDao.getObjectById(id,WaringsInfo.class);
        return waringsInfo;

    }

    /**
     * 删除警示信息
     * @param id
     */
    public void deleteWaringById(String id){
        WaringsInfo waringsInfo=new WaringsInfo();
        waringsInfo.setId(id);
        waringsInfoDao.remove(waringsInfo);
    }
}
