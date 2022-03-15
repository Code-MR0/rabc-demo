package com.mhw.rabc.service.impl;

import com.mhw.rabc.entity.Form;
import com.mhw.rabc.mapper.FormMapper;
import com.mhw.rabc.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @className: FormServiceImpl
 * @description: TODO
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
@Service
public class FormServiceImpl implements FormService {
    private final FormMapper formMapper;

    @Autowired
    public FormServiceImpl(FormMapper formMapper) {
        this.formMapper = formMapper;
    }

    @Override
    public List<Form> findAll() {
        return formMapper.findAll();
    }

    @Override
    public Page<Form> findAll(Pageable pageable) {
        return formMapper.findAll(pageable);
    }

    @Override
    public Optional<Form> findById(String formId) {
        return formMapper.findById(formId);
    }

    @Override
    public void deleteById(String formId) {
        formMapper.deleteById(formId);
    }

    @Override
    public Form save(Form form) {
        return formMapper.save(form);
    }
}
