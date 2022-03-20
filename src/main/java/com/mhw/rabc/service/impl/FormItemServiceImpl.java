package com.mhw.rabc.service.impl;

import com.mhw.rabc.entity.FormItem;
import com.mhw.rabc.mapper.FormItemMapper;
import com.mhw.rabc.service.FormItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * @className: FormItemServiceImpl
 * @description: FormItemServiceImpl
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
@Service
public class FormItemServiceImpl implements FormItemService {

    private final FormItemMapper formItemMapper;

    @Autowired
    public FormItemServiceImpl(FormItemMapper formItemMapper) {
        this.formItemMapper = formItemMapper;
    }

    @Override
    public List<FormItem> findAll() {
        return formItemMapper.findAll();
    }

    @Override
    public List<FormItem> findAll(String owner) {
        return formItemMapper.findByOwnerLike(owner);
    }

    @Override
    public Page<FormItem> findAll(Pageable pageable) {
        return formItemMapper.findAll(pageable);
    }

    @Override
    public Page<FormItem> findAll(Pageable pageable, String owner) {
        return formItemMapper.findAllByOwnerLike(pageable, owner);
    }

    @Override
    public Page<FormItem> findAll(Pageable pageable, String owner, String type) {
        return formItemMapper.findAllByOwnerAndType(pageable,owner,type);
    }

    @Override
    public Optional<FormItem> findById(String formItemId) {
        return formItemMapper.findById(formItemId);
    }

    @Override
    public void deleteById(String formItemId) {
        formItemMapper.deleteById(formItemId);
    }

    @Override
    public void deleteByIds(List<FormItem> formItems) {
        formItemMapper.deleteAll(formItems);
    }

    @Override
    public FormItem save(FormItem formItem) {
        return formItemMapper.save(formItem);
    }
}
