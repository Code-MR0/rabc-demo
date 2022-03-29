package com.mhw.rabc.controller;

import com.mhw.rabc.dto.MangoPageDTO;
import com.mhw.rabc.dto.PageDTO;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.FormData;
import com.mhw.rabc.service.FormDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @className: FormDataController
 * @description: FormDataController
 * @author: mhw
 * @date: 2022/3/28
 * @version: 1.0
 **/
@Api(tags = "FormDataController")
@RestController
@RequestMapping("/formData")
@SuppressWarnings("rawtypes")
public class FormDataController {
    FormDataService formDataService;

    @Autowired
    public FormDataController(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    /**
     * 新增formdata
     *
     * @param formData form
     */
    @ApiOperation(value = "新增formdata")
    @PostMapping("")
    public Result addNewForm(@RequestBody FormData formData) {
        // todo 根据用户名查询id
        formData.setFormId(formData.getId());
        formData.setId(UUID.randomUUID().toString());
        formData.setGmtCreate(LocalDateTime.now());
        formData.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        FormData res = formDataService.save(formData);
        return Result.check(res);
    }

    /**
     * 分页列表
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("")
    public Result pageList(FormData formData) {
        MangoPageDTO mangoPageDTO = new MangoPageDTO(formData.getPage(), formData.getLimit(), Sort.by(Sort.Direction.ASC, "gmtCreate"));
        Page<FormData> formItemList = formDataService.findAll(mangoPageDTO,formData.getFormId());
        return Result.check(formItemList);
    }

    /**
     * 列表
     *
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list/{formId}")
    public Result getAllFormData(@PathVariable String formId) {
        List<FormData> formList = formDataService.findAll(formId);
        return Result.check(formList);
    }
}
