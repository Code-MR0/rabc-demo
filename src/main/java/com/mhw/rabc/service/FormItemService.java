package com.mhw.rabc.service;


import com.mhw.rabc.entity.FormItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @className: FormItemService
 * @description: FormItemService
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
public interface FormItemService {

    /**
     * 列表
     *
     * @return List<FormItem>
     */
    List<FormItem> findAll();

    /**
     * 列表
     *
     * @param owner 所有者
     * @return List<FormItem>
     */
    List<FormItem> findAll(String owner);

    /**
     * 分页列表
     *
     * @param pageable 分页参数
     * @return List<FormItem>
     */
    Page<FormItem> findAll(Pageable pageable);

    /**
     * 分页列表
     *
     * @param owner    所有者
     * @param pageable 分页参数
     * @return List<FormItem>
     */
    Page<FormItem> findAll(Pageable pageable, String owner);

    /**
     * 分页列表
     *
     * @param type 选项类型
     * @param owner    所有者
     * @param pageable 分页参数
     * @return List<FormItem>
     */
    Page<FormItem> findAll(Pageable pageable, String owner,String type);

    /**
     * 根据id查询formItem
     *
     * @param formItemId id
     * @return FormItem
     */
    Optional<FormItem> findById(String formItemId);

    /**
     * 根据id删除formItem
     *
     * @param formItemId id
     */
    void deleteById(String formItemId);

    /**
     * 根据id删除formItem
     *
     * @param formItems formItems
     */
    void deleteByIds(List<FormItem> formItems);

    /**
     * 新增删除formItem
     *
     * @param formItem formItem
     * @return formItem
     */
    FormItem save(FormItem formItem);
}

