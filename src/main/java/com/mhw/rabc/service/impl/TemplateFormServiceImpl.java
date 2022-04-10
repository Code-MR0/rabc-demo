package com.mhw.rabc.service.impl;

import com.mhw.rabc.entity.TemplateForm;
import com.mhw.rabc.mapper.TemplateFormMapper;
import com.mhw.rabc.service.TemplateFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @className: TemplateFormServiceImpl
 * @description: TemplateFormServiceImpl
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Service
public class TemplateFormServiceImpl implements TemplateFormService {
    private final TemplateFormMapper templateFormMapper;

    @Autowired
    public TemplateFormServiceImpl(TemplateFormMapper templateFormMapper) {
        this.templateFormMapper = templateFormMapper;
    }

    @Override
    public List<TemplateForm> findAll() {
        return templateFormMapper.findAll();
    }

    @Override
    public Page<TemplateForm> findAll(Pageable pageable) {
        return templateFormMapper.findAll(pageable);
    }

    @Override
    public Page<TemplateForm> findAll(Pageable pageable, String owner) {
        return templateFormMapper.findAllByOwnerLike(pageable, owner);
    }

    @Override
    public Optional<TemplateForm> findById(String templateFormId) {
        return templateFormMapper.findById(templateFormId);
    }

    @Override
    public void deleteById(String templateFormId) {
        templateFormMapper.deleteById(templateFormId);
    }

    @Override
    public TemplateForm save(TemplateForm templateForm) {
        return templateFormMapper.save(templateForm);
    }

    @Override
    public void deleteByIds(List<TemplateForm> templateForms) {
        templateFormMapper.deleteAll(templateForms);
    }
}
