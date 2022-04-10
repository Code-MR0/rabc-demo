package com.mhw.rabc.service.impl;

import com.mhw.rabc.entity.Industry;
import com.mhw.rabc.mapper.IndustryMapper;
import com.mhw.rabc.service.IndustryService;
import com.mhw.rabc.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @className: IndustryServiceImpl
 * @description: IndustryServiceImpl
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Service
public class IndustryServiceImpl implements IndustryService {

    private final IndustryMapper industryMapper;

    @Autowired
    public IndustryServiceImpl(IndustryMapper industryMapper) {
        this.industryMapper = industryMapper;
    }

    @Override
    public List<Industry> findAll() {
        return industryMapper.findAll();
    }

    @Override
    public List<Industry> findAll(String owner) {
        return null;
    }


    @Override
    public Page<Industry> findAll(Pageable pageable) {
        return industryMapper.findAll(pageable);
    }

    @Override
    public Page<Industry> findAll(Pageable pageable, String owner) {
        return null;
    }

    @Override
    public Page<Industry> findAll(Pageable pageable, String owner, String type) {
        return null;
    }


    @Override
    public Optional<Industry> findById(String industryId) {
        return industryMapper.findById(industryId);
    }

    @Override
    public void deleteById(String industryId) {
        industryMapper.deleteById(industryId);
    }

    @Override
    public void deleteByIds(List<Industry> industrys) {
        industryMapper.deleteAll(industrys);
    }

    @Override
    public Industry save(Industry industry) {
        return industryMapper.save(industry);
    }
}
