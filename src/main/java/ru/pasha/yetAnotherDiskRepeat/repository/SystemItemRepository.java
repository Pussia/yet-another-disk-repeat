package ru.pasha.yetAnotherDiskRepeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;

@Repository
public interface SystemItemRepository extends JpaRepository<SystemItem, String> {
}
