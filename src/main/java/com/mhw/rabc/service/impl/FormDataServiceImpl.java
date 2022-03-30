package com.mhw.rabc.service.impl;

import com.mhw.rabc.entity.FormData;
import com.mhw.rabc.mapper.FormDataMapper;
import com.mhw.rabc.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @className: FormDataServiceImpl
 * @description: FormDataServiceImpl
 * @author: mhw
 * @date: 2022/3/28
 * @version: 1.0
 **/
@Service
public class FormDataServiceImpl implements FormDataService {
    FormDataMapper formDataMapper;

    @Autowired
    public FormDataServiceImpl(FormDataMapper formDataMapper) {
        this.formDataMapper = formDataMapper;
    }

    @Override
    public List<FormData> findAll(String formId) {
        return formDataMapper.findAllByFormIdLike(formId);
    }

    @Override
    public Page<FormData> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<FormData> findAll(Pageable pageable, String formId) {
        return formDataMapper.findAllByFormIdLike(pageable, formId);
    }

    @Override
    public Optional<FormData> findById(String formId) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {
        formDataMapper.deleteById(id);
    }

    @Override
    public FormData save(FormData formData) {
        return formDataMapper.save(formData);
    }

    @Override
    public void deleteByIds(List<FormData> formData) {
        formDataMapper.deleteAll(formData);
    }
}
