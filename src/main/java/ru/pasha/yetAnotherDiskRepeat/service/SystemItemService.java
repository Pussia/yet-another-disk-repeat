package ru.pasha.yetAnotherDiskRepeat.service;

import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemHistory;

import java.util.Date;
import java.util.List;

public interface SystemItemService {

    List<SystemItem> saveAll(List<SystemItem> systemItems);

    void update(SystemItem newSystemItem, SystemItem oldSystemItem);
    SystemItem deleteById(String id, String date);
    void updateDateForParents(SystemItem leaf, Date date);
    void updateSizeForParents(SystemItem leaf, Long size);
    void deleteHistory(SystemItemHistory systemItemHistory);
    SystemItem findById(String id);
}
