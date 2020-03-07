package io.jlt.jcartstoreback.service;

import io.jlt.jcartstoreback.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);

}
