package org.com.service;

import org.com.entity.Brand;

import java.util.List;

public interface BrandService extends Service<Brand> {
    List<Brand> readByName(String name);
    List<Brand> readByStatus(String email);
}
