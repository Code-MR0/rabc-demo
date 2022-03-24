package com.mhw.rabc.service;

import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.FormItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @className: FormService
 * @description: FormService
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
public interface FormService {
    /**
     * 列表
     * @return List<Form>
     */
    List<Form> findAll();

    /**
     * 分页列表
     * @param pageable 分页参数
     * @return List<Form>
     */
    Page<Form> findAll(Pageable pageable);

    /**
     * 分页列表
     *
     * @param owner    所有者
     * @param pageable 分页参数
     * @return List<Form>
     */
    Page<Form> findAll(Pageable pageable, String owner);

    /**
     * 根据id查询form
     * @param formId id
     * @return Form
     */
    Optional<Form> findById(String formId);

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
    Form save( Form form);

}
