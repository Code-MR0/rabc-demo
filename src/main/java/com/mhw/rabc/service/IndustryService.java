package com.mhw.rabc.service;

import com.mhw.rabc.entity.Industry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @className: IndustryService
 * @description: IndustryService
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
public interface IndustryService {
    /**
     * 列表
     *
     * @return List<Industry>
     */
    List<Industry> findAll();

    /**
     * 列表
     *
     * @param owner 所有者
     * @return List<Industry>
     */
    List<Industry> findAll(String owner);

    /**
     * 分页列表
     *
     * @param pageable 分页参数
     * @return List<Industry>
     */
    Page<Industry> findAll(Pageable pageable);

    /**
     * 分页列表
     *
     * @param owner    所有者
     * @param pageable 分页参数
     * @return List<Industry>
     */
    Page<Industry> findAll(Pageable pageable, String owner);

    /**
     * 分页列表
     *
     * @param type 选项类型
     * @param owner    所有者
     * @param pageable 分页参数
     * @return List<Industry>
     */
    Page<Industry> findAll(Pageable pageable, String owner,String type);

    /**
     * 根据id查询industry
     *
     * @param industryId id
     * @return Industry
     */
    Optional<Industry> findById(String industryId);

    /**
     * 根据id删除industry
     *
     * @param industryId id
     */
    void deleteById(String industryId);

    /**
     * 根据id删除industry
     *
     * @param industries industries
     */
    void deleteByIds(List<Industry> industries);

    /**
     * 新增删除industry
     *
     * @param industry industry
     * @return industry
     */
    Industry save(Industry industry);
}
