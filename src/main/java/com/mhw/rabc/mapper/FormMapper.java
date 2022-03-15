package com.mhw.rabc.mapper;


import com.mhw.rabc.entity.Form;
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
public interface FormMapper extends MongoRepository<Form, String> {
}
