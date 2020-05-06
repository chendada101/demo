package com.comn.demo.serviceImpl;

import com.comn.demo.beans.BussinResult;
import com.comn.demo.beans.ChannlBanner;
import com.comn.demo.beans.Task;
import com.comn.demo.dao.ChannlBannerDAO;
import com.comn.demo.iservice.IBannerSV;
import com.comn.demo.iservice.IBussinResultSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class BannerSVImpl implements IBannerSV {
    @Autowired
    private ChannlBannerDAO channlBannerDAO;

    @Override
    public List<ChannlBanner> selectBannerList(Map<String, Object> mapParam) {
        return channlBannerDAO.selectBannerList(mapParam);
    }

    @Override
    public int selectBannerToatal(Map<String, Object> mapParam) {
        return channlBannerDAO.selectBannerTotal(mapParam);
    }

    @Override
    public int insertBanner(ChannlBanner channlBanner) {
        return channlBannerDAO.insertSelective(channlBanner);
    }

    @Override
    public int deleteBanner(Long id) {
        return channlBannerDAO.deleteByPrimaryKey(id);
    }

    @Override
    public ChannlBanner selectBannerById(Long id) {
        return channlBannerDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateBanner(ChannlBanner channlBanner) {
        return channlBannerDAO.updateByPrimaryKeySelective(channlBanner);
    }
}
