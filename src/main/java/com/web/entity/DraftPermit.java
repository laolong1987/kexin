package com.web.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by gaoyang on 16/7/7.
 */
public class DraftPermit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private int id;
    @Column(name ="product_source")
    private int product_source;
    @Column(name ="generic_name")
    private String generic_name;
    @Column(name ="product_name")
    private String product_name;
    @Column(name ="name_en")
    private String name_en;
    @Column(name ="picurl")
    private String picurl;
    @Column(name ="brand")
    private String brand;
    @Column(name ="producing_region")
    private String producing_region;
    @Column(name ="approval_number")
    private String approval_number;
    @Column(name ="approval_file")
    private String approval_file;
    @Column(name ="approval_date")
    private Date approval_date;
    @Column(name ="gmp_number")
    private String gmp_number;
    @Column(name ="gmp_file")
    private String gmp_file;
    @Column(name ="gmp_date")
    private Date gmp_date;
    @Column(name ="administrative")
    private String administrative;
    @Column(name ="administrative_file")
    private String administrative_file;
    @Column(name ="administrative_date")
    private Date administrative_date;
    @Column(name ="quality_report")
    private String quality_report;
    @Column(name ="quality_date")
    private Date quality_date;
    @Column(name ="manual_file")
    private String manual_file;
    @Column(name ="prescription_type")
    private int prescription_type;
    @Column(name ="durability")
    private String durability;
    @Column(name ="specification")
    private String specification;
    @Column(name ="formulation")
    private String formulation;
    @Column(name ="description")
    private String description;
    @Column(name ="notes")
    private String notes;
    @Column(name ="standard")
    private String standard;
    @Column(name ="model")
    private String model;
    @Column(name ="video")
    private String video;
    @Column(name ="animation")
    private String animation;
    @Column(name ="appropriate")
    private String appropriate;
    @Column(name ="not_appropriate")
    private String not_appropriate;
    @Column(name ="health_function")
    private String health_function;
    @Column(name ="raw_material")
    private String raw_material;
    @Column(name ="effect_content")
    private String effect_content;
    @Column(name ="manufacturer")
    private String manufacturer;
    @Column(name ="manu_address")
    private String manu_address;
    @Column(name ="importer")
    private String importer;
    @Column(name ="importer_address")
    private String importer_address;
    @Column(name ="register_agent")
    private String register_agent;
    @Column(name ="register_address")
    private String register_address;
    @Column(name ="package_company")
    private String package_company;
    @Column(name ="package_address")
    private String package_address;
    @Column(name ="service_sector")
    private String service_sector;
    @Column(name ="service_address")
    private String service_address;
    @Column(name ="code")
    private String code;
    @Column(name ="pass_time")
    private Date pass_time;
    @Column(name ="company_user")
    private String company_user;
    @Column(name ="area_id")
    private String area_id;
    @Column(name ="info_pic")
    private String info_pic;
    @Column(name ="ingredient")
    private String ingredient;
    @Column(name ="taboo")
    private String taboo;
    @Column(name ="indication")
    private String indication;
    @Column(name ="adverse")
    private String adverse;
    @Column(name ="usage")
    private String  usage;
    @Column(name ="attention")
    private String attention;
    @Column(name ="performance")
    private String performance;
    @Column(name ="package_specification")
    private String package_specification;
    @Column(name ="barcode")
    private String barcode;
    @Column(name ="text_manual")
    private String text_manual;
    @Column(name ="woman_usage")
    private String woman_usage;
    @Column(name ="child_usage")
    private String child_usage;
    @Column(name ="older_usage")
    private String older_usage;
    @Column(name ="drug_interaction")
    private String drug_interaction;
    @Column(name ="clinical_trials")
    private String clinical_trials;
    @Column(name ="toxicology")
    private String toxicology;
    @Column(name ="pharmacokinetics")
    private String pharmacokinetics;
    @Column(name ="storage")
    private String storage;
    @Column(name ="technology_description")
    private String technology_description;
    @Column(name ="execution_standard")
    private String execution_standard;
    @Column(name ="medicare_type")
    private int medicare_type;
    @Column(name ="reg_type")
    private int reg_type;
    @Column(name ="small_pic")
    private String small_pic;
    @Column(name ="external_links")
    private String external_links;
    @Column(name ="template_id")
    private int template_id;
    @Column(name ="brand_awards_files")
    private String brand_awards_files;
    @Column(name ="brand_mark_files")
    private String brand_mark_files;
    @Column(name ="after_sale_service")
    private String after_sale_service;
    @Column(name ="unit")
    private String unit;
    @Column(name ="images")
    private String images;
    @Column(name ="production_license_file")
    private String production_license_file;
    @Column(name ="production_license_valid_date")
    private Date production_license_valid_date;
    @Column(name ="production_license_expire_date")
    private Date production_license_expire_date;
    @Column(name ="additive")
    private String additive;
    @Column(name ="crops_type")
    private String crops_type;
    @Column(name ="crops_name")
    private String crops_name;
    @Column(name ="feeding_scale")
    private String feeding_scale;
    @Column(name ="metal_material")
    private String metal_material;
    @Column(name ="metal_use")
    private String metal_use;
    @Column(name ="metal_usage")
    private String metal_usage;
    @Column(name ="metal_weight")
    private String metal_weight;
    @Column(name ="product_size")
    private String product_size;
    @Column(name ="metal_surface_treatment")
    private String metal_surface_treatment;
    @Column(name ="metal_torque_inertia")
    private String metal_torque_inertia;
    @Column(name ="service_content")
    private String service_content;
    @Column(name ="rank_certification_files")
    private String rank_certification_files;
    @Column(name ="service_product_sales")
    private String service_product_sales;
    @Column(name ="service_phone")
    private String service_phone;
    @Column(name ="production_license_number")
    private String production_license_number;
    @Column(name ="withdrawal_period")
    private String withdrawal_period;
    @Column(name ="manu_date")
    private Date manu_date;
    @Column(name ="use")
    private String use;
    @Column(name ="register_license_number")
    private String register_license_number;
    @Column(name ="register_license_file")
    private String register_license_file;
    @Column(name ="register_license_valid_date")
    private Date register_license_valid_date;
    @Column(name ="register_license_expire_date")
    private Date register_license_expire_date;
    @Column(name ="parental_origin")
    private String parental_origin;
    @Column(name ="cip")
    private String cip;
    @Column(name ="content_introduction")
    private String content_introduction;
    @Column(name ="recommend_category")
    private String recommend_category;
    @Column(name ="author")
    private String author;
    @Column(name ="editor")
    private String editor;
    @Column(name ="translator")
    private String translator;
    @Column(name ="publishing_times")
    private String publishing_times;
    @Column(name ="print_times")
    private String print_times;
    @Column(name ="print_amount")
    private String print_amount;
    @Column(name ="uniform_price")
    private String uniform_price;
    @Column(name ="copyright")
    private String copyright;
    @Column(name ="danger_summary")
    private String danger_summary;
    @Column(name ="chemical_properties")
    private String chemical_properties;
    @Column(name ="disposal")
    private String disposal;
    @Column(name ="export_area")
    private String export_area;
    @Column(name ="appropriate_area")
    private String appropriate_area;
    @Column(name ="country_code")
    private String country_code;
    @Column(name ="permission_type")
    private int permission_type;
    @Column(name ="product_variety")
    private String product_variety;
    @Column(name ="location")
    private String location;
    @Column(name ="sync_time")
    private Date sync_time;
    @Column(name ="remote_id")
    private int remote_id;
    @Column(name ="antifake")
    private String antifake;
    @Column(name ="live_camera_serialno")
    private String live_camera_serialno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_source() {
        return product_source;
    }

    public void setProduct_source(int product_source) {
        this.product_source = product_source;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProducing_region() {
        return producing_region;
    }

    public void setProducing_region(String producing_region) {
        this.producing_region = producing_region;
    }

    public String getApproval_number() {
        return approval_number;
    }

    public void setApproval_number(String approval_number) {
        this.approval_number = approval_number;
    }

    public String getApproval_file() {
        return approval_file;
    }

    public void setApproval_file(String approval_file) {
        this.approval_file = approval_file;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
    }

    public String getGmp_number() {
        return gmp_number;
    }

    public void setGmp_number(String gmp_number) {
        this.gmp_number = gmp_number;
    }

    public String getGmp_file() {
        return gmp_file;
    }

    public void setGmp_file(String gmp_file) {
        this.gmp_file = gmp_file;
    }

    public Date getGmp_date() {
        return gmp_date;
    }

    public void setGmp_date(Date gmp_date) {
        this.gmp_date = gmp_date;
    }

    public String getAdministrative() {
        return administrative;
    }

    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }

    public String getAdministrative_file() {
        return administrative_file;
    }

    public void setAdministrative_file(String administrative_file) {
        this.administrative_file = administrative_file;
    }

    public Date getAdministrative_date() {
        return administrative_date;
    }

    public void setAdministrative_date(Date administrative_date) {
        this.administrative_date = administrative_date;
    }

    public String getQuality_report() {
        return quality_report;
    }

    public void setQuality_report(String quality_report) {
        this.quality_report = quality_report;
    }

    public Date getQuality_date() {
        return quality_date;
    }

    public void setQuality_date(Date quality_date) {
        this.quality_date = quality_date;
    }

    public String getManual_file() {
        return manual_file;
    }

    public void setManual_file(String manual_file) {
        this.manual_file = manual_file;
    }

    public int getPrescription_type() {
        return prescription_type;
    }

    public void setPrescription_type(int prescription_type) {
        this.prescription_type = prescription_type;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public String getAppropriate() {
        return appropriate;
    }

    public void setAppropriate(String appropriate) {
        this.appropriate = appropriate;
    }

    public String getNot_appropriate() {
        return not_appropriate;
    }

    public void setNot_appropriate(String not_appropriate) {
        this.not_appropriate = not_appropriate;
    }

    public String getHealth_function() {
        return health_function;
    }

    public void setHealth_function(String health_function) {
        this.health_function = health_function;
    }

    public String getRaw_material() {
        return raw_material;
    }

    public void setRaw_material(String raw_material) {
        this.raw_material = raw_material;
    }

    public String getEffect_content() {
        return effect_content;
    }

    public void setEffect_content(String effect_content) {
        this.effect_content = effect_content;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManu_address() {
        return manu_address;
    }

    public void setManu_address(String manu_address) {
        this.manu_address = manu_address;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public String getImporter_address() {
        return importer_address;
    }

    public void setImporter_address(String importer_address) {
        this.importer_address = importer_address;
    }

    public String getRegister_agent() {
        return register_agent;
    }

    public void setRegister_agent(String register_agent) {
        this.register_agent = register_agent;
    }

    public String getRegister_address() {
        return register_address;
    }

    public void setRegister_address(String register_address) {
        this.register_address = register_address;
    }

    public String getPackage_company() {
        return package_company;
    }

    public void setPackage_company(String package_company) {
        this.package_company = package_company;
    }

    public String getPackage_address() {
        return package_address;
    }

    public void setPackage_address(String package_address) {
        this.package_address = package_address;
    }

    public String getService_sector() {
        return service_sector;
    }

    public void setService_sector(String service_sector) {
        this.service_sector = service_sector;
    }

    public String getService_address() {
        return service_address;
    }

    public void setService_address(String service_address) {
        this.service_address = service_address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPass_time() {
        return pass_time;
    }

    public void setPass_time(Date pass_time) {
        this.pass_time = pass_time;
    }

    public String getCompany_user() {
        return company_user;
    }

    public void setCompany_user(String company_user) {
        this.company_user = company_user;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getInfo_pic() {
        return info_pic;
    }

    public void setInfo_pic(String info_pic) {
        this.info_pic = info_pic;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getAdverse() {
        return adverse;
    }

    public void setAdverse(String adverse) {
        this.adverse = adverse;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getPackage_specification() {
        return package_specification;
    }

    public void setPackage_specification(String package_specification) {
        this.package_specification = package_specification;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getText_manual() {
        return text_manual;
    }

    public void setText_manual(String text_manual) {
        this.text_manual = text_manual;
    }

    public String getWoman_usage() {
        return woman_usage;
    }

    public void setWoman_usage(String woman_usage) {
        this.woman_usage = woman_usage;
    }

    public String getChild_usage() {
        return child_usage;
    }

    public void setChild_usage(String child_usage) {
        this.child_usage = child_usage;
    }

    public String getOlder_usage() {
        return older_usage;
    }

    public void setOlder_usage(String older_usage) {
        this.older_usage = older_usage;
    }

    public String getDrug_interaction() {
        return drug_interaction;
    }

    public void setDrug_interaction(String drug_interaction) {
        this.drug_interaction = drug_interaction;
    }

    public String getClinical_trials() {
        return clinical_trials;
    }

    public void setClinical_trials(String clinical_trials) {
        this.clinical_trials = clinical_trials;
    }

    public String getToxicology() {
        return toxicology;
    }

    public void setToxicology(String toxicology) {
        this.toxicology = toxicology;
    }

    public String getPharmacokinetics() {
        return pharmacokinetics;
    }

    public void setPharmacokinetics(String pharmacokinetics) {
        this.pharmacokinetics = pharmacokinetics;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getTechnology_description() {
        return technology_description;
    }

    public void setTechnology_description(String technology_description) {
        this.technology_description = technology_description;
    }

    public String getExecution_standard() {
        return execution_standard;
    }

    public void setExecution_standard(String execution_standard) {
        this.execution_standard = execution_standard;
    }

    public int getMedicare_type() {
        return medicare_type;
    }

    public void setMedicare_type(int medicare_type) {
        this.medicare_type = medicare_type;
    }

    public int getReg_type() {
        return reg_type;
    }

    public void setReg_type(int reg_type) {
        this.reg_type = reg_type;
    }

    public String getSmall_pic() {
        return small_pic;
    }

    public void setSmall_pic(String small_pic) {
        this.small_pic = small_pic;
    }

    public String getExternal_links() {
        return external_links;
    }

    public void setExternal_links(String external_links) {
        this.external_links = external_links;
    }

    public int getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(int template_id) {
        this.template_id = template_id;
    }

    public String getBrand_awards_files() {
        return brand_awards_files;
    }

    public void setBrand_awards_files(String brand_awards_files) {
        this.brand_awards_files = brand_awards_files;
    }

    public String getBrand_mark_files() {
        return brand_mark_files;
    }

    public void setBrand_mark_files(String brand_mark_files) {
        this.brand_mark_files = brand_mark_files;
    }

    public String getAfter_sale_service() {
        return after_sale_service;
    }

    public void setAfter_sale_service(String after_sale_service) {
        this.after_sale_service = after_sale_service;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getProduction_license_file() {
        return production_license_file;
    }

    public void setProduction_license_file(String production_license_file) {
        this.production_license_file = production_license_file;
    }

    public Date getProduction_license_valid_date() {
        return production_license_valid_date;
    }

    public void setProduction_license_valid_date(Date production_license_valid_date) {
        this.production_license_valid_date = production_license_valid_date;
    }

    public Date getProduction_license_expire_date() {
        return production_license_expire_date;
    }

    public void setProduction_license_expire_date(Date production_license_expire_date) {
        this.production_license_expire_date = production_license_expire_date;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public String getCrops_type() {
        return crops_type;
    }

    public void setCrops_type(String crops_type) {
        this.crops_type = crops_type;
    }

    public String getCrops_name() {
        return crops_name;
    }

    public void setCrops_name(String crops_name) {
        this.crops_name = crops_name;
    }

    public String getFeeding_scale() {
        return feeding_scale;
    }

    public void setFeeding_scale(String feeding_scale) {
        this.feeding_scale = feeding_scale;
    }

    public String getMetal_material() {
        return metal_material;
    }

    public void setMetal_material(String metal_material) {
        this.metal_material = metal_material;
    }

    public String getMetal_use() {
        return metal_use;
    }

    public void setMetal_use(String metal_use) {
        this.metal_use = metal_use;
    }

    public String getMetal_usage() {
        return metal_usage;
    }

    public void setMetal_usage(String metal_usage) {
        this.metal_usage = metal_usage;
    }

    public String getMetal_weight() {
        return metal_weight;
    }

    public void setMetal_weight(String metal_weight) {
        this.metal_weight = metal_weight;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getMetal_surface_treatment() {
        return metal_surface_treatment;
    }

    public void setMetal_surface_treatment(String metal_surface_treatment) {
        this.metal_surface_treatment = metal_surface_treatment;
    }

    public String getMetal_torque_inertia() {
        return metal_torque_inertia;
    }

    public void setMetal_torque_inertia(String metal_torque_inertia) {
        this.metal_torque_inertia = metal_torque_inertia;
    }

    public String getService_content() {
        return service_content;
    }

    public void setService_content(String service_content) {
        this.service_content = service_content;
    }

    public String getRank_certification_files() {
        return rank_certification_files;
    }

    public void setRank_certification_files(String rank_certification_files) {
        this.rank_certification_files = rank_certification_files;
    }

    public String getService_product_sales() {
        return service_product_sales;
    }

    public void setService_product_sales(String service_product_sales) {
        this.service_product_sales = service_product_sales;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public String getProduction_license_number() {
        return production_license_number;
    }

    public void setProduction_license_number(String production_license_number) {
        this.production_license_number = production_license_number;
    }

    public String getWithdrawal_period() {
        return withdrawal_period;
    }

    public void setWithdrawal_period(String withdrawal_period) {
        this.withdrawal_period = withdrawal_period;
    }

    public Date getManu_date() {
        return manu_date;
    }

    public void setManu_date(Date manu_date) {
        this.manu_date = manu_date;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getRegister_license_number() {
        return register_license_number;
    }

    public void setRegister_license_number(String register_license_number) {
        this.register_license_number = register_license_number;
    }

    public String getRegister_license_file() {
        return register_license_file;
    }

    public void setRegister_license_file(String register_license_file) {
        this.register_license_file = register_license_file;
    }

    public Date getRegister_license_valid_date() {
        return register_license_valid_date;
    }

    public void setRegister_license_valid_date(Date register_license_valid_date) {
        this.register_license_valid_date = register_license_valid_date;
    }

    public Date getRegister_license_expire_date() {
        return register_license_expire_date;
    }

    public void setRegister_license_expire_date(Date register_license_expire_date) {
        this.register_license_expire_date = register_license_expire_date;
    }

    public String getParental_origin() {
        return parental_origin;
    }

    public void setParental_origin(String parental_origin) {
        this.parental_origin = parental_origin;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getContent_introduction() {
        return content_introduction;
    }

    public void setContent_introduction(String content_introduction) {
        this.content_introduction = content_introduction;
    }

    public String getRecommend_category() {
        return recommend_category;
    }

    public void setRecommend_category(String recommend_category) {
        this.recommend_category = recommend_category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublishing_times() {
        return publishing_times;
    }

    public void setPublishing_times(String publishing_times) {
        this.publishing_times = publishing_times;
    }

    public String getPrint_times() {
        return print_times;
    }

    public void setPrint_times(String print_times) {
        this.print_times = print_times;
    }

    public String getPrint_amount() {
        return print_amount;
    }

    public void setPrint_amount(String print_amount) {
        this.print_amount = print_amount;
    }

    public String getUniform_price() {
        return uniform_price;
    }

    public void setUniform_price(String uniform_price) {
        this.uniform_price = uniform_price;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDanger_summary() {
        return danger_summary;
    }

    public void setDanger_summary(String danger_summary) {
        this.danger_summary = danger_summary;
    }

    public String getChemical_properties() {
        return chemical_properties;
    }

    public void setChemical_properties(String chemical_properties) {
        this.chemical_properties = chemical_properties;
    }

    public String getDisposal() {
        return disposal;
    }

    public void setDisposal(String disposal) {
        this.disposal = disposal;
    }

    public String getExport_area() {
        return export_area;
    }

    public void setExport_area(String export_area) {
        this.export_area = export_area;
    }

    public String getAppropriate_area() {
        return appropriate_area;
    }

    public void setAppropriate_area(String appropriate_area) {
        this.appropriate_area = appropriate_area;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public int getPermission_type() {
        return permission_type;
    }

    public void setPermission_type(int permission_type) {
        this.permission_type = permission_type;
    }

    public String getProduct_variety() {
        return product_variety;
    }

    public void setProduct_variety(String product_variety) {
        this.product_variety = product_variety;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getSync_time() {
        return sync_time;
    }

    public void setSync_time(Date sync_time) {
        this.sync_time = sync_time;
    }

    public int getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(int remote_id) {
        this.remote_id = remote_id;
    }

    public String getAntifake() {
        return antifake;
    }

    public void setAntifake(String antifake) {
        this.antifake = antifake;
    }

    public String getLive_camera_serialno() {
        return live_camera_serialno;
    }

    public void setLive_camera_serialno(String live_camera_serialno) {
        this.live_camera_serialno = live_camera_serialno;
    }
}
