package ru.pasha.yetAnotherDiskRepeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemHistory;

@Repository
public interface SystemItemHistoryRepository extends JpaRepository<SystemItemHistory, Long> {
}
