package ru.pasha.yetAnotherDiskRepeat.service;

import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemHistory;

import java.util.Date;
import java.util.List;

public interface SystemItemService {

    List<SystemItem> saveAllSystemItems(List<SystemItem> systemItems);

    void update(SystemItem newSystemItem, SystemItem oldSystemItem);
    SystemItem deleteSystemItemById(String id, String date);
    void updateDateForParents(SystemItem leaf, Date date);
    void updateSizeForParents(SystemItem leaf, Long size);
    void deleteHistory(SystemItemHistory systemItemHistory);
    SystemItem findSystemItemById(String id);
    List<SystemItem> findSystemItemByDate(String date);
    List<SystemItemHistory> findHistoryById(String id, String dateStart, String dateEnd);
}
