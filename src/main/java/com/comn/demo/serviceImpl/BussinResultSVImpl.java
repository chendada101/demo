package com.comn.demo.serviceImpl;

import com.comn.demo.beans.BussinResult;
import com.comn.demo.dao.BussinResultDAO;
import com.comn.demo.iservice.IBussinResultSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BussinResultSVImpl implements IBussinResultSV {
    @Autowired
    private BussinResultDAO bussinResultDAO;
    @Override
    public List<BussinResult> selectWaitList(Map map) {
        return bussinResultDAO.selectWaitList(map);
    }

    @Override
    public int selectWaitListTotal(Map map) {
        return bussinResultDAO.selectWaitListTotal(map);
    }

    @Override
    public int insertBussinResult(BussinResult bussinResult) {
        return bussinResultDAO.insertSelective(bussinResult);
    }

    @Override
    public int updateBussinResult(BussinResult bussinResult) {
        return bussinResultDAO.updateByPrimaryKeySelective(bussinResult);
    }

    @Override
    public BussinResult selectBussinResultById(int callId) {
        return bussinResultDAO.selectByPrimaryKey(callId);
    }
}
