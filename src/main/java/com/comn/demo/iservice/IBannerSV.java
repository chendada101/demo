package com.comn.demo.iservice;

import com.comn.demo.beans.ChannlBanner;
import com.comn.demo.beans.Task;

import java.util.List;
import java.util.Map;

public interface IBannerSV {
    List<ChannlBanner> selectBannerList(Map<String,Object> mapParam);

    int selectBannerToatal(Map<String,Object> mapParam);

    int insertBanner(ChannlBanner channlBanner);

    int deleteBanner(Long id);

    ChannlBanner selectBannerById(Long id);

    int updateBanner(ChannlBanner channlBanner);
}
