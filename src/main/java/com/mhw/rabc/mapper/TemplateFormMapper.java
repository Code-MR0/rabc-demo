package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.Industry;
import com.mhw.rabc.entity.TemplateForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @className: TemplateFormMapper
 * @description: TemplateFormMapper
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Mapper
@SuppressWarnings("all")
public interface TemplateFormMapper extends MongoRepository<TemplateForm,String> {
    public Page<TemplateForm> findAllByOwnerLike(Pageable pageable, String owner);
    public List<TemplateForm> findAllByIndustry(Industry industry);
}
