package ru.pasha.yetAnotherDiskRepeat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class SystemItemRequest {

    private List<SystemItem> items;

    private String updateDate;
}
