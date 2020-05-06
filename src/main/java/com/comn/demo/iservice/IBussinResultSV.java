package com.comn.demo.iservice;

import com.comn.demo.beans.BussinResult;

import java.util.List;
import java.util.Map;

public interface IBussinResultSV {
    List<BussinResult> selectWaitList(Map map);

    int selectWaitListTotal(Map map);

    int insertBussinResult(BussinResult bussinResult);

    int updateBussinResult(BussinResult bussinResult);

    BussinResult selectBussinResultById(int callId);
}
