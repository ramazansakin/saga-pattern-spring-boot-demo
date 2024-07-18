package com.appsdeveloperblog.orders.dao.jpa.repository;

import com.appsdeveloperblog.orders.dao.jpa.entity.OrderHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistoryEntity, UUID> {
    List<OrderHistoryEntity> findByOrderId(UUID orderId);
}
