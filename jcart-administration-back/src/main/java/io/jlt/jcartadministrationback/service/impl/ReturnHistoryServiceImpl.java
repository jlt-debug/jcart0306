package io.jlt.jcartadministrationback.service.impl;

import io.jlt.jcartadministrationback.dao.ReturnHistoryMapper;
import io.jlt.jcartadministrationback.po.Return;
import io.jlt.jcartadministrationback.po.ReturnHistory;
import io.jlt.jcartadministrationback.service.ReturnHistoryService;
import io.jlt.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories =  returnHistoryMapper.selectListByReturnId(returnId);
        return returnHistories;
    }

    @Override
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());

        returnService.update(aReturn);


        return returnHistoryId;
    }
}
