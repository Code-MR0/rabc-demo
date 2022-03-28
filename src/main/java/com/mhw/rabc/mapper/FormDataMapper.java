package com.mhw.rabc.mapper;


import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.FormData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @className: FormDataMapper
 * @description: FormDataMapper
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
@Component
@SuppressWarnings("all")
public interface FormDataMapper extends MongoRepository<FormData, String> {
}
