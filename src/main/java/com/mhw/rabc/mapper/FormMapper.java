package com.mhw.rabc.mapper;


import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.FormItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @className: FormMapper
 * @description: FormMapper
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
@Component
@SuppressWarnings("all")
public interface FormMapper extends MongoRepository<Form, String> {
    public Page<Form> findAllByOwnerLike(Pageable pageable, String owner);
}
