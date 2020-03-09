package io.jlt.jcartadministrationback.service;

import io.jlt.jcartadministrationback.po.ReturnHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnHistoryService {
    List<ReturnHistory> getListByReturnId(Integer returnId);

    Long create(ReturnHistory returnHistory);
}
