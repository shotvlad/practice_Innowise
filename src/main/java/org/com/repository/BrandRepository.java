package org.com.repository;

import org.com.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByNameContaining(String name);
    List<Brand> findByStatusContaining(String status);
}
