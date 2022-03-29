package com.mhw.rabc.service;

import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.FormData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @className: FormDataService
 * @description: FormDataService
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
public interface FormDataService {
    /**
     * 列表
     *
     * @param formId formId
     * @return List<Form>
     */
    List<FormData> findAll(String formId);

    /**
     * 分页列表
     *
     * @param pageable 分页参数
     * @return List<Form>
     */
    Page<FormData> findAll(Pageable pageable);

    /**
     * 分页列表
     *
     * @param formId    formId
     * @param pageable 分页参数
     * @return List<Form>
     */
    Page<FormData> findAll(Pageable pageable, String formId);

    /**
     * 根据id查询form
     *
     * @param formId id
     * @return Form
     */
    Optional<FormData> findById(String formId);

    /**
     * 根据id删除form
     *
     * @param formId id
     */
    void deleteById(String formId);

    /**
     * 新增删除form
     *
     * @param formData form
     * @return form
     */
    FormData save(FormData formData);

}
