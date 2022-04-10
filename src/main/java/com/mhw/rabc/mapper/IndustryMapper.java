package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.FormItem;
import com.mhw.rabc.entity.Industry;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @className: IndustryMapper
 * @description: IndustryMapper
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Mapper
@SuppressWarnings("all")
public interface IndustryMapper extends MongoRepository<Industry,String> {
}
