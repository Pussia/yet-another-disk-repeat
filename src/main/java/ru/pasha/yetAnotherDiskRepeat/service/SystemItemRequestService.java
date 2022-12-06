package ru.pasha.yetAnotherDiskRepeat.service;

import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemRequest;

import java.util.List;

public interface SystemItemRequestService {

    List<SystemItem> parseSystemItems(SystemItemRequest systemItemRequest);
}
