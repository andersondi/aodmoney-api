package com.aod.aodmoney.api.repository;

import com.aod.aodmoney.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository< Category, Long > {
}
