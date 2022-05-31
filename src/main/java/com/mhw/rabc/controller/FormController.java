package com.mhw.rabc.controller;

import com.mhw.rabc.dto.MangoPageDTO;
import com.mhw.rabc.dto.PageDTO;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Form;
import com.mhw.rabc.entity.TemplateForm;
import com.mhw.rabc.service.FormService;
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
 * @className: FormController
 * @description: FormController
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
@Api(tags = "FormController")
@RestController
@RequestMapping("/form")
@SuppressWarnings("rawtypes")
public class FormController {

    private final FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }
    /**
     * 列表
     *
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public Result getAllForms() {
        List<Form> formList = formService.findAll();
        return Result.check(formList);
    }

    /**
     * 分页列表
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("")
    public Result pageList(PageDTO pageDTO) {
        MangoPageDTO mangoPageDTO = new MangoPageDTO(pageDTO.getPage(), pageDTO.getLimit(), Sort.by(Sort.Direction.ASC, "gmtCreate"));
        Page<Form> formItemList = formService.findAll(mangoPageDTO,SecurityContextHolder.getContext().getAuthentication().getName());
        return Result.check(formItemList);
    }

    /**
     * 根据id查询form
     *
     * @param formId formId
     */
    @ApiOperation(value = "根据id查询form")
    @GetMapping("/{formId}")
    public Result getByFormId(@PathVariable String formId) {
        Form form = formService.findById(formId).orElse(new Form());
        return Result.check(form);
    }

    /**
     * 新增form
     *
     * @param form form
     */
    @ApiOperation(value = "新增form")
    @PostMapping("")
    public Result addNewForm(@RequestBody Form form) {
        String id = UUID.randomUUID().toString();
        form.setId(id);
        form.setGmtCreate(LocalDateTime.now());
        form.setStatus(false);
        form.setUrl("http://mhw.free.idcfengye.com/#/from/myForms" +id);
        form.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        Form res = formService.save(form);
        return Result.check(res);
    }

    /**
     * 根据id删除form
     *
     * @param formId formId
     */
    @ApiOperation(value = "删除form")
    @DeleteMapping("/{formId}")
    public Result delete(@PathVariable String formId) {
        Form form = new Form();
        form.setId(formId);
        formService.deleteById(formId);
        return Result.success();
    }

    /**
     * 根据id删除form
     *
     * @param formList formList
     */
    @ApiOperation(value = "批量删除Form")
    @DeleteMapping("")
    public Result delete(@RequestBody List<Form> formList) {
        formService.deleteByIds(formList);
        return Result.success();
    }


    /**
     * 更新form
     *
     * @param form form
     */
    @ApiOperation(value = "更新form")
    @PutMapping("")
    public Result update(@RequestBody Form form) {
        Form res = formService.save(form);
        return Result.check(res);
    }
}
