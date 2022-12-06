package ru.pasha.yetAnotherDiskRepeat.validators;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemRequest;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemType;
import ru.pasha.yetAnotherDiskRepeat.repository.SystemItemRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class SystemItemRequestValidator implements Validator<SystemItemRequest> {

    private final DateParser dateParser;
    private final SystemItemRepository systemItemRepository;

    @Override
    public boolean validate(SystemItemRequest systemItemRequest) {
        // Date is not null
        if (systemItemRequest.getUpdateDate() == null) return false;

        Set<String> ids = new HashSet<>();

        for (SystemItem systemItem : systemItemRequest.getItems()) {
            // Check not-null fields
            if (systemItem.getType() == null) return false;

            // Id is not null
            if (systemItem.getId() == null) return false;

            // Parent is FOLDER
            if (systemItem.getParentId() != null) {
                Optional<SystemItem> optionalParent = systemItemRepository.findById(systemItem.getParentId());

                if (optionalParent.isPresent()) {
                    SystemItem parent = optionalParent.get();

                    if (parent.getType().equals(SystemItemType.FILE)) return false;
                }
            }

            if (systemItem.getType().equals(SystemItemType.FOLDER)) {
                // Url must be null for FOLDERs
                if (systemItem.getUrl() != null) return false;

                // Size must be 0 for FOLDERs
                if (systemItem.getSize() != 0) return false;
            } else {
                // Size must be > 0 for FILEs
                if (systemItem.getSize() <= 0) return false;

                // Url is not null
                if (systemItem.getUrl() == null) return false;

                // Url length must be <= 255
                if (systemItem.getUrl().length() > 255) return false;
            }

            ids.add(systemItem.getId());
            systemItem.setDate(dateParser.parse(systemItemRequest.getUpdateDate()));
        }

        // All ids in query must be unique
        if (ids.size() < systemItemRequest.getItems().size()) return false;

        return true;
    }
}
