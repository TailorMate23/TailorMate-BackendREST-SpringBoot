package com.example.tailormate.repository;

import com.example.tailormate.model.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Integer> {
}
