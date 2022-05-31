package com.mhw.rabc.service;

import com.mhw.rabc.entity.Industry;
import com.mhw.rabc.entity.TemplateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @className: TemplateFormService
 * @description: TemplateFormService
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
public interface TemplateFormService {
    /**
     * 列表
     * @return List<TemplateForm>
     */
    List<TemplateForm> findAll();

    /**
     * 列表
     * @param industry  industry
     * @return List<TemplateForm>
     */
    List<TemplateForm> findAll(Industry industry);

    /**
     * 分页列表
     * @param pageable 分页参数
     * @return List<TemplateForm>
     */
    Page<TemplateForm> findAll(Pageable pageable);

    /**
     * 分页列表
     *
     * @param owner    所有者
     * @param pageable 分页参数
     * @return List<TemplateForm>
     */
    Page<TemplateForm> findAll(Pageable pageable, String owner);

    /**
     * 根据id查询form
     * @param formId id
     * @return TemplateForm
     */
    Optional<TemplateForm> findById(String formId);

    /**
     * 根据id删除form
     * @param formId id
     */
    void deleteById(String formId);

    /**
     * 新增删除form
     * @param form form
     * @return form
     */
    TemplateForm save( TemplateForm form);

    /**
     * 批量删除
     * @param templateForms templateForms
     */
    void deleteByIds(List<TemplateForm> templateForms);
}
