package com.fenxiang.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by C罗 on 2017/7/15.
 */

public class BanKuaiLunBo implements Serializable{

    /**
     * result_code : 200
     * result_message : 请求成功
     * result_data : {"section":1,"adsense_middle":{"ads_heigth":200,"ads_index":"middle","ads_name":"超级反中心图1","ads_width":200,"id":21,"img_kb":0,"img_layout":"","remark":"","status":1},"advert_middle":[{"adv_name":"超级反中心图","end_date":"2017-07-21","id":12,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/ba3fcf27-41f2-4eac-a5c8-bf31a9712a9f.png","link_type_id":2,"link_url":"2","remark":"","start_date":"2017-06-29","status":1}],"adsense_banner":{"ads_heigth":246,"ads_index":"banner","ads_name":"超级返banner","ads_width":750,"id":6,"img_kb":0,"img_layout":"","remark":"","status":1},"advert_banner":[{"adv_name":"超级返banner","end_date":"2017-07-05","id":10,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/4a81ffe9-8015-482b-8251-a8860ad9d0c0.jpg","link_type_id":3,"link_url":"1","remark":"","start_date":"2017-07-12","status":1},{"adv_name":"超级返banner","end_date":"2017-07-05","id":11,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/e59cf957-b0ec-4087-adf2-71c748c6a772.jpg","link_type_id":3,"link_url":"1","remark":"2","start_date":"2017-07-12","status":1},{"adv_name":"超级返banner3","end_date":"2017-07-26","id":13,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/8f1ebf91-9416-48f3-936e-34ccefe3f4d4.jpg","link_type_id":3,"link_url":"1","remark":"3","start_date":"2017-07-12","status":1}]}
     */

    private int result_code;
    private String result_message;
    private ResultDataBean result_data;

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public ResultDataBean getResult_data() {
        return result_data;
    }

    public void setResult_data(ResultDataBean result_data) {
        this.result_data = result_data;
    }

    public static class ResultDataBean {
        /**
         * section : 1
         * adsense_middle : {"ads_heigth":200,"ads_index":"middle","ads_name":"超级反中心图1","ads_width":200,"id":21,"img_kb":0,"img_layout":"","remark":"","status":1}
         * advert_middle : [{"adv_name":"超级反中心图","end_date":"2017-07-21","id":12,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/ba3fcf27-41f2-4eac-a5c8-bf31a9712a9f.png","link_type_id":2,"link_url":"2","remark":"","start_date":"2017-06-29","status":1}]
         * adsense_banner : {"ads_heigth":246,"ads_index":"banner","ads_name":"超级返banner","ads_width":750,"id":6,"img_kb":0,"img_layout":"","remark":"","status":1}
         * advert_banner : [{"adv_name":"超级返banner","end_date":"2017-07-05","id":10,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/4a81ffe9-8015-482b-8251-a8860ad9d0c0.jpg","link_type_id":3,"link_url":"1","remark":"","start_date":"2017-07-12","status":1},{"adv_name":"超级返banner","end_date":"2017-07-05","id":11,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/e59cf957-b0ec-4087-adf2-71c748c6a772.jpg","link_type_id":3,"link_url":"1","remark":"2","start_date":"2017-07-12","status":1},{"adv_name":"超级返banner3","end_date":"2017-07-26","id":13,"img_url":"http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/8f1ebf91-9416-48f3-936e-34ccefe3f4d4.jpg","link_type_id":3,"link_url":"1","remark":"3","start_date":"2017-07-12","status":1}]
         */

        private int section;
        private AdsenseMiddleBean adsense_middle;
        private AdsenseBannerBean adsense_banner;
        private List<AdvertMiddleBean> advert_middle;
        private List<AdvertBannerBean> advert_banner;

        private List<Advert_Right> advert_right;
        private List<Advert_Left> advert_left;

        public List<Advert_Right> getAdvert_right() {
            return advert_right;
        }

        public void setAdvert_right(List<Advert_Right> advert_right) {
            this.advert_right = advert_right;
        }

        public List<Advert_Left> getAdvert_left() {
            return advert_left;
        }

        public void setAdvert_left(List<Advert_Left> advert_left) {
            this.advert_left = advert_left;
        }

        public int getSection() {
            return section;
        }

        public void setSection(int section) {
            this.section = section;
        }

        public AdsenseMiddleBean getAdsense_middle() {
            return adsense_middle;
        }

        public void setAdsense_middle(AdsenseMiddleBean adsense_middle) {
            this.adsense_middle = adsense_middle;
        }

        public AdsenseBannerBean getAdsense_banner() {
            return adsense_banner;
        }

        public void setAdsense_banner(AdsenseBannerBean adsense_banner) {
            this.adsense_banner = adsense_banner;
        }

        public List<AdvertMiddleBean> getAdvert_middle() {
            return advert_middle;
        }

        public void setAdvert_middle(List<AdvertMiddleBean> advert_middle) {
            this.advert_middle = advert_middle;
        }

        public List<AdvertBannerBean> getAdvert_banner() {
            return advert_banner;
        }

        public void setAdvert_banner(List<AdvertBannerBean> advert_banner) {
            this.advert_banner = advert_banner;
        }

        public static class AdsenseMiddleBean {
            /**
             * ads_heigth : 200
             * ads_index : middle
             * ads_name : 超级反中心图1
             * ads_width : 200
             * id : 21
             * img_kb : 0
             * img_layout :
             * remark :
             * status : 1
             */

            private int ads_heigth;
            private String ads_index;
            private String ads_name;
            private int ads_width;
            private int id;
            private int img_kb;
            private String img_layout;
            private String remark;
            private int status;

            public int getAds_heigth() {
                return ads_heigth;
            }

            public void setAds_heigth(int ads_heigth) {
                this.ads_heigth = ads_heigth;
            }

            public String getAds_index() {
                return ads_index;
            }

            public void setAds_index(String ads_index) {
                this.ads_index = ads_index;
            }

            public String getAds_name() {
                return ads_name;
            }

            public void setAds_name(String ads_name) {
                this.ads_name = ads_name;
            }

            public int getAds_width() {
                return ads_width;
            }

            public void setAds_width(int ads_width) {
                this.ads_width = ads_width;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getImg_kb() {
                return img_kb;
            }

            public void setImg_kb(int img_kb) {
                this.img_kb = img_kb;
            }

            public String getImg_layout() {
                return img_layout;
            }

            public void setImg_layout(String img_layout) {
                this.img_layout = img_layout;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class AdsenseBannerBean {
            /**
             * ads_heigth : 246
             * ads_index : banner
             * ads_name : 超级返banner
             * ads_width : 750
             * id : 6
             * img_kb : 0
             * img_layout :
             * remark :
             * status : 1
             */

            private int ads_heigth;
            private String ads_index;
            private String ads_name;
            private int ads_width;
            private int id;
            private int img_kb;
            private String img_layout;
            private String remark;
            private int status;

            public int getAds_heigth() {
                return ads_heigth;
            }

            public void setAds_heigth(int ads_heigth) {
                this.ads_heigth = ads_heigth;
            }

            public String getAds_index() {
                return ads_index;
            }

            public void setAds_index(String ads_index) {
                this.ads_index = ads_index;
            }

            public String getAds_name() {
                return ads_name;
            }

            public void setAds_name(String ads_name) {
                this.ads_name = ads_name;
            }

            public int getAds_width() {
                return ads_width;
            }

            public void setAds_width(int ads_width) {
                this.ads_width = ads_width;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getImg_kb() {
                return img_kb;
            }

            public void setImg_kb(int img_kb) {
                this.img_kb = img_kb;
            }

            public String getImg_layout() {
                return img_layout;
            }

            public void setImg_layout(String img_layout) {
                this.img_layout = img_layout;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class AdvertMiddleBean {
            /**
             * adv_name : 超级反中心图
             * end_date : 2017-07-21
             * id : 12
             * img_url : http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/ba3fcf27-41f2-4eac-a5c8-bf31a9712a9f.png
             * link_type_id : 2
             * link_url : 2
             * remark :
             * start_date : 2017-06-29
             * status : 1
             */

            private String adv_name;
            private String end_date;
            private int id;
            private String img_url;
            private int link_type_id;
            private String link_url;
            private String remark;
            private String start_date;
            private int status;

            public String getAdv_name() {
                return adv_name;
            }

            public void setAdv_name(String adv_name) {
                this.adv_name = adv_name;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public int getLink_type_id() {
                return link_type_id;
            }

            public void setLink_type_id(int link_type_id) {
                this.link_type_id = link_type_id;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class AdvertBannerBean {
            /**
             * adv_name : 超级返banner
             * end_date : 2017-07-05
             * id : 10
             * img_url : http://192.168.2.130:8080/soukeAppService/uploads/images/20170717/4a81ffe9-8015-482b-8251-a8860ad9d0c0.jpg
             * link_type_id : 3
             * link_url : 1
             * remark :
             * start_date : 2017-07-12
             * status : 1
             */

            private String adv_name;
            private String ads_name;
            private String end_date;
            private int id;
            private String img_url;
            private int link_type_id;
            private String link_url;
            private String remark;
            private String start_date;
            private int status;

            public String getAds_name() {
                return ads_name;
            }

            public void setAds_name(String ads_name) {
                this.ads_name = ads_name;
            }

            public String getAdv_name() {
                return adv_name;
            }

            public void setAdv_name(String adv_name) {
                this.adv_name = adv_name;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public int getLink_type_id() {
                return link_type_id;
            }

            public void setLink_type_id(int link_type_id) {
                this.link_type_id = link_type_id;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class Advert_Left {

            /**
             * adv_name : 左图广告
             * end_date :
             * id : 4
             * img_url : http://192.168.2.130:8080/soukeAppService/uploads/images/20170718/7a8e116a-9c0b-413d-b819-a8b408930ba5.png
             * link_type_id : 1
             * link_url :
             * remark :
             * start_date :
             * status : 1
             */

            private String adv_name;
            private String end_date;
            private int id;
            private String img_url;
            private int link_type_id;
            private String link_url;
            private String remark;
            private String start_date;
            private int status;

            public String getAdv_name() {
                return adv_name;
            }

            public void setAdv_name(String adv_name) {
                this.adv_name = adv_name;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public int getLink_type_id() {
                return link_type_id;
            }

            public void setLink_type_id(int link_type_id) {
                this.link_type_id = link_type_id;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class Advert_Right {

            /**
             * adv_name : 左图广告
             * end_date :
             * id : 4
             * img_url : http://192.168.2.130:8080/soukeAppService/uploads/images/20170718/7a8e116a-9c0b-413d-b819-a8b408930ba5.png
             * link_type_id : 1
             * link_url :
             * remark :
             * start_date :
             * status : 1
             */

            private String adv_name;
            private String end_date;
            private int id;
            private String img_url;
            private int link_type_id;
            private String link_url;
            private String remark;
            private String start_date;
            private int status;

            public String getAdv_name() {
                return adv_name;
            }

            public void setAdv_name(String adv_name) {
                this.adv_name = adv_name;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public int getLink_type_id() {
                return link_type_id;
            }

            public void setLink_type_id(int link_type_id) {
                this.link_type_id = link_type_id;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
