package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.FormItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @className: FormItemMapper
 * @description: FormItemMapper
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/
@Component
public interface FormItemMapper extends MongoRepository<FormItem, String> {
}
