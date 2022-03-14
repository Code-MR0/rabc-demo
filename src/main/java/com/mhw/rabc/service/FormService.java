package com.mhw.rabc.service;

import com.mhw.rabc.entity.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @className: FormService
 * @description: FormService
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
public interface FormService extends MongoRepository<Form, String> {

}
