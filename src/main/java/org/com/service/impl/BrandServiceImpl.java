package org.com.service.impl;

import org.com.entity.Brand;
import org.com.repository.BrandRepository;
import org.com.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repository;

    @Override
    public Brand read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Brand> read() {
        return repository.findAll();
    }

    @Override
    public void save(Brand entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Brand entity) {
        Brand brand = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        brand.setStatus(entity.getStatus());
        brand.setName(entity.getName());
        brand.setCars(entity.getCars());
        repository.save(brand);
    }

    @Override
    public List<Brand> readByName(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public List<Brand> readByStatus(String status) {
        return repository.findByStatusContaining(status);
    }
}
