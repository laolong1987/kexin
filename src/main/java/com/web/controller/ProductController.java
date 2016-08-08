package com.web.controller;

import com.utils.ConvertUtil;
import com.web.entity.*;
import com.web.model.*;
import com.web.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

//import javax.validation.Valid;

/**
 * Created by gaoyang on 16/2/28.
 */
@RestController
public class ProductController {

    @Autowired
    RecordInfoService recordInfoService;

    private static String IMGURL="http://www.ecdata.org.cn/srv/viewDownloadAction.action?fileName=publishedFile/";

    @RequestMapping(value = "/search-product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RepProductModel> listproduct(@RequestParam(required=false ) String productname,@RequestParam(required=false ) String page,@RequestParam(required=false ) String pageSize){
        List<RepProductModel> result=new ArrayList<>();
        Map p=new HashMap();
        p.put("productname",ConvertUtil.safeToString(productname,""));
        p.put("page",page);
        p.put("pageSize",pageSize);
        List<Map> list=recordInfoService.findProduct(p);
        for (Map map:list) {
            RepProductModel product=new RepProductModel();
            String productn=ConvertUtil.safeToString(map.get("PRODUCT_NAME"),"");
            if(!"".equals(productn)){
                product.setProductname(productn);
            }else{
                product.setProductname(ConvertUtil.safeToString(map.get("GENERIC_NAME"),""));
            }
            product.setCompanyname(ConvertUtil.safeToString(map.get("MANUFACTURER"),""));
            product.setId(ConvertUtil.safeToString(map.get("ID"),""));
            product.setEvaluation(ConvertUtil.safeToString(map.get("POINT"),""));
            String picurl= ConvertUtil.safeToString(map.get("MANUAL_FILE"),"");
            if("".equals(picurl)){
                picurl=ConvertUtil.safeToString(map.get("PICURL"),"");
            }
            if(!"".equals(picurl)){
                String ps[]=picurl.split(";");
                product.setPicurl(IMGURL+ps[0]);
            }
            result.add(product);
        }
        return result;
    }


    @RequestMapping(value = "/search-product/{id}/{userid}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RepProductDetailModel getproduct(@PathVariable String id,@PathVariable String userid){
        RepProductDetailModel productDetailModel=new RepProductDetailModel();
        DraftPermit product = recordInfoService.getProduct(id);
        if(null!=product){
            String productname=ConvertUtil.safeToString(product.getProduct_name(),"");
            if(!"".equals(productname)){
                productDetailModel.setProductname(product.getProduct_name());
            }else{
                productDetailModel.setProductname(product.getGeneric_name());
            }
            productDetailModel.setBrands(ConvertUtil.safeToString(product.getBrand(),""));
            productDetailModel.setCompanyname(ConvertUtil.safeToString(product.getManufacturer(),""));
            productDetailModel.setCampanyaddress(ConvertUtil.safeToString(product.getManu_address(),""));
            if(!"".equals(ConvertUtil.safeToString(product.getProduction_license_file(),""))){
                productDetailModel.setLicense(IMGURL+product.getProduction_license_file());
                productDetailModel.setLicense(productDetailModel.getLicense().replaceAll(";",""));
            }
            String picurl= ConvertUtil.safeToString(product.getManual_file(),"");
            if("".equals(picurl)){
                picurl=ConvertUtil.safeToString(product.getPicurl(),"");
            }
            List<String> list2=new ArrayList<>();
            if(!"".equals(picurl)){
                String ps[]=picurl.split(";");
                for (String s:ps ) {
                    list2.add(IMGURL+s);
                }
            }
            productDetailModel.setProductimg(list2);

            List<Map> webSitelist = recordInfoService.findWebSite(id);
            List<RepWebSite> website=new ArrayList<>();
            for (Map map: webSitelist) {
                RepWebSite ws=new RepWebSite();
                ws.setName(ConvertUtil.safeToString(map.get("WEBSITE_NAME"),""));
                ws.setUrl(ConvertUtil.safeToString(map.get("WEBSITE_ADDRESS"),""));
                website.add(ws);
            }
            productDetailModel.setAuthorize(webSitelist.size());
            productDetailModel.setWebSiteList(website);
            productDetailModel.setEvaluation(recordInfoService.getProductCommentpoint(id));

            //补充
            productDetailModel.setId(product.getId());
            productDetailModel.setProduct_source(product.getProduct_source());
            productDetailModel.setGeneric_name(product.getGeneric_name());
            productDetailModel.setProduct_name(product.getProduct_name());
            productDetailModel.setName_en(product.getName_en());
            productDetailModel.setPicurl(product.getPicurl());
            productDetailModel.setBrand(product.getBrand());
            productDetailModel.setProducing_region(product.getProducing_region());
            productDetailModel.setApproval_number(product.getApproval_number());
            productDetailModel.setApproval_file(product.getApproval_file());
            productDetailModel.setApproval_date(product.getApproval_date());
            productDetailModel.setGmp_number(product.getGmp_number());
            productDetailModel.setGmp_file(product.getGmp_file());
            productDetailModel.setGmp_date(product.getGmp_date());
            productDetailModel.setAdministrative(product.getAdministrative());
            productDetailModel.setAdministrative_file(product.getAdministrative_file());
            productDetailModel.setAdministrative_date(product.getAdministrative_date());
            productDetailModel.setQuality_report(product.getQuality_report());
            productDetailModel.setQuality_date(product.getQuality_date());
            productDetailModel.setManual_file(product.getManual_file());
            productDetailModel.setPrescription_type(product.getPrescription_type());
            productDetailModel.setDurability(product.getDurability());
            productDetailModel.setSpecification(product.getSpecification());
            productDetailModel.setFormulation(product.getFormulation());
            productDetailModel.setDescription(product.getDescription());
            productDetailModel.setNotes(product.getNotes());
            productDetailModel.setStandard(product.getStandard());
            productDetailModel.setModel(product.getModel());
            productDetailModel.setVideo(product.getVideo());
            productDetailModel.setAnimation(product.getAnimation());
            productDetailModel.setAppropriate(product.getAppropriate());
            productDetailModel.setNot_appropriate(product.getNot_appropriate());
            productDetailModel.setHealth_function(product.getHealth_function());
            productDetailModel.setRaw_material(product.getRaw_material());
            productDetailModel.setEffect_content(product.getEffect_content());
            productDetailModel.setImporter(product.getImporter());
            productDetailModel.setImporter_address(product.getImporter_address());
            productDetailModel.setRegister_agent(product.getRegister_agent());
            productDetailModel.setRegister_address(product.getRegister_address());
            productDetailModel.setPackage_company(product.getPackage_company());
            productDetailModel.setPackage_address(product.getPackage_address());
            productDetailModel.setService_sector(product.getService_sector());
            productDetailModel.setService_address(product.getService_address());
            productDetailModel.setCode(product.getCode());
            productDetailModel.setPass_time(product.getPass_time());
            productDetailModel.setCompany_user(product.getCompany_user());
            productDetailModel.setArea_id(product.getArea_id());
            productDetailModel.setInfo_pic(product.getInfo_pic());
            productDetailModel.setIngredient(product.getIngredient());
            productDetailModel.setTaboo(product.getTaboo());
            productDetailModel.setIndication(product.getIndication());
            productDetailModel.setAdverse(product.getAdverse());
            productDetailModel.setUsage(product.getUsage());
            productDetailModel.setAttention(product.getAttention());
            productDetailModel.setPerformance(product.getPerformance());
            productDetailModel.setPackage_specification(product.getPackage_specification());
            productDetailModel.setBarcode(product.getBarcode());
            productDetailModel.setText_manual(product.getText_manual());
            productDetailModel.setWoman_usage(product.getWoman_usage());
            productDetailModel.setChild_usage(product.getChild_usage());
            productDetailModel.setOlder_usage(product.getOlder_usage());
            productDetailModel.setDrug_interaction(product.getDrug_interaction());
            productDetailModel.setClinical_trials(product.getClinical_trials());
            productDetailModel.setToxicology(product.getToxicology());
            productDetailModel.setPharmacokinetics(product.getPharmacokinetics());
            productDetailModel.setStorage(product.getStorage());
            productDetailModel.setTechnology_description(product.getTechnology_description());
            productDetailModel.setExecution_standard(product.getExecution_standard());
            productDetailModel.setMedicare_type(product.getMedicare_type());
            productDetailModel.setReg_type(product.getReg_type());
            productDetailModel.setSmall_pic(product.getSmall_pic());
            productDetailModel.setExternal_links(product.getExternal_links());
            productDetailModel.setTemplate_id(product.getTemplate_id());
            productDetailModel.setBrand_awards_files(product.getBrand_awards_files());
            productDetailModel.setBrand_mark_files(product.getBrand_mark_files());
            productDetailModel.setAfter_sale_service(product.getAfter_sale_service());
            productDetailModel.setUnit(product.getUnit());
            productDetailModel.setImages(product.getImages());
            productDetailModel.setProduction_license_valid_date(product.getProduction_license_valid_date());
            productDetailModel.setProduction_license_expire_date(product.getProduction_license_expire_date());
            productDetailModel.setAdditive(product.getAdditive());
            productDetailModel.setCrops_type(product.getCrops_type());
            productDetailModel.setCrops_name(product.getCrops_name());
            productDetailModel.setFeeding_scale(product.getFeeding_scale());
            productDetailModel.setMetal_material(product.getMetal_material());
            productDetailModel.setMetal_use(product.getMetal_use());
            productDetailModel.setMetal_weight(product.getMetal_weight());
            productDetailModel.setProduct_size(product.getProduct_size());
            productDetailModel.setMetal_surface_treatment(product.getMetal_surface_treatment());
            productDetailModel.setMetal_torque_inertia(product.getMetal_torque_inertia());
            productDetailModel.setService_content(product.getService_content());
            productDetailModel.setRank_certification_files(product.getRank_certification_files());
            productDetailModel.setService_product_sales(product.getService_product_sales());
            productDetailModel.setService_phone(product.getService_phone());
            productDetailModel.setProduction_license_number(product.getProduction_license_number());
            productDetailModel.setWithdrawal_period(product.getWithdrawal_period());
            productDetailModel.setManu_date(product.getManu_date());
            productDetailModel.setUse(product.getUse());
            productDetailModel.setRegister_license_number(product.getRegister_license_number());
            productDetailModel.setRegister_license_expire_date(product.getRegister_license_expire_date());
            productDetailModel.setRegister_license_valid_date(product.getRegister_license_valid_date());
            productDetailModel.setRegister_license_expire_date(product.getRegister_license_expire_date());
            productDetailModel.setParental_origin(product.getParental_origin());
            productDetailModel.setCip(product.getCip());
            productDetailModel.setContent_introduction(product.getContent_introduction());
            productDetailModel.setRecommend_category(product.getRecommend_category());
            productDetailModel.setAuthor(product.getAuthor());
            productDetailModel.setEditor(product.getEditor());
            productDetailModel.setTranslator(product.getTranslator());
            productDetailModel.setPublishing_times(product.getPublishing_times());
            productDetailModel.setPrint_times(product.getPrint_times());
            productDetailModel.setPrint_amount(product.getPrint_times());
            productDetailModel.setUniform_price(product.getUniform_price());
            productDetailModel.setCopyright(product.getCopyright());
            productDetailModel.setDanger_summary(product.getDanger_summary());
            productDetailModel.setChemical_properties(product.getChemical_properties());
            productDetailModel.setDisposal(product.getDisposal());
            productDetailModel.setExport_area(product.getExport_area());
            productDetailModel.setAppropriate_area(product.getAppropriate_area());
            productDetailModel.setCountry_code(product.getCountry_code());
            productDetailModel.setPermission_type(product.getPermission_type());
            productDetailModel.setProduct_variety(product.getProduct_variety());
            productDetailModel.setLocation(product.getLocation());
            productDetailModel.setSync_time(product.getSync_time());
            productDetailModel.setRemote_id(product.getRemote_id());
            productDetailModel.setAntifake(product.getAntifake());
            productDetailModel.setLive_camera_serialno(product.getLive_camera_serialno());

            //判断是否收藏 0 无收藏 1 收藏了
            if(!"0".equals(userid)){
                productDetailModel.setIscollect(recordInfoService.findCollect(id,2,userid));

            }
            //记录日志
            recordInfoService.setlog(userid,2,id);
        }
        return productDetailModel;
    }

    @RequestMapping(value="/comment-product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public  ProductComment addComment(ReqCommentModel commentModel) {
        ProductComment productComment=new ProductComment();
        productComment.setCreate_time(new Date());
        productComment.setUpdate_time(new Date());
        productComment.setDirections(commentModel.getDirections());
        productComment.setUserid(commentModel.getUserid());
        productComment.setProductid(commentModel.getProductid());
        productComment.setPoint(commentModel.getPoint());
        productComment.setIsfalse(commentModel.getIsfalse());
        recordInfoService.saveProductComment(productComment);

        //预警检测
        recordInfoService.runproductreminde(productComment.getDirections(),productComment.getProductid(),productComment.getPoint());
        return productComment;
    }


    @RequestMapping(value = "/search-productcomment", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductCommentModel> listproduct(@RequestParam(required=false ) String productid){
        List<ProductCommentModel> productCommentModelList=new ArrayList<>();
        List<Map> list=recordInfoService.findProductComment2(productid);
        for (Map map:list) {
            ProductCommentModel pc=new ProductCommentModel();
            pc.setIsfalse(ConvertUtil.safeToInteger(map.get("ISFALSE"),0));
            pc.setDirections(ConvertUtil.safeToString(map.get("DIRECTIONS"),""));
            pc.setPoint(ConvertUtil.safeToInteger(map.get("POINT"),0));
            pc.setCreate_time(ConvertUtil.safeToString(map.get("CREATE_TIME"),""));
            pc.setUsername(ConvertUtil.safeToString(map.get("NAME"),""));
            pc.setUserid(ConvertUtil.safeToString(map.get("USERID"),""));
            productCommentModelList.add(pc);
        }
        return productCommentModelList;
    }


}
