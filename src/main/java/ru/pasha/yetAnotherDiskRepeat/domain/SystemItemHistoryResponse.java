package ru.pasha.yetAnotherDiskRepeat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SystemItemHistoryResponse {

    private List<SystemItemHistory> items;
}
