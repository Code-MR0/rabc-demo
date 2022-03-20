package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.FormItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @className: FormItemMapper
 * @description: FormItemMapper
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
@Component
@SuppressWarnings("all")
public interface FormItemMapper extends MongoRepository<FormItem, String> {

    public List<FormItem> findByOwnerLike(String name);

    public Page<FormItem> findAllByOwnerLike(Pageable pageable, String owner);

    public Page<FormItem> findAllByOwnerAndType(Pageable pageable, String owner, String type);

}
