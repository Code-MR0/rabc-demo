package com.mhw.rabc.controller;

import com.mhw.rabc.dto.MangoPageDTO;
import com.mhw.rabc.dto.PageDTO;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.FormItem;
import com.mhw.rabc.entity.Industry;
import com.mhw.rabc.entity.TemplateForm;
import com.mhw.rabc.service.TemplateFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @className: TemplateFormController
 * @description: TemplateFormController
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Api(tags = "TemplateFormController")
@RestController
@RequestMapping("/templateForm")
@SuppressWarnings("rawtypes")
public class TemplateFormController {

    private final TemplateFormService templateFormService;

    @Autowired
    public TemplateFormController(TemplateFormService templateFormService) {
        this.templateFormService = templateFormService;
    }
    /**
     * 列表
     *
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public Result getAllTemplateForms() {
        List<TemplateForm> templateFormList = templateFormService.findAll();
        return Result.check(templateFormList);
    }


    
    /**
     * 列表
     *
     */
    @ApiOperation(value = "列表")
    @PostMapping("/list/industry")
    public Result getAllTemplateFormsBy(@RequestBody(required = false)Industry industry) {
        List<TemplateForm> templateFormList;
        if (industry==null){
            templateFormList = templateFormService.findAll();
        } else {
            templateFormList = templateFormService.findAll(industry);
        }
        return Result.check(templateFormList);
    }

    /**
     * 分页列表
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("")
    public Result pageList(PageDTO pageDTO) {
        MangoPageDTO mangoPageDTO = new MangoPageDTO(pageDTO.getPage(), pageDTO.getLimit(), Sort.by(Sort.Direction.ASC, "gmtCreate"));
        Page<TemplateForm> templateFormItemList = templateFormService.findAll(mangoPageDTO, SecurityContextHolder.getContext().getAuthentication().getName());
        return Result.check(templateFormItemList);
    }

    /**
     * 根据id查询templateForm
     *
     * @param templateFormId templateFormId
     */
    @ApiOperation(value = "根据id查询templateForm")
    @GetMapping("/{templateFormId}")
    public Result getByTemplateFormId(@PathVariable String templateFormId) {
        TemplateForm templateForm = templateFormService.findById(templateFormId).orElse(new TemplateForm());
        return Result.check(templateForm);
    }

    /**
     * 新增templateForm
     *
     * @param templateForm templateForm
     */
    @ApiOperation(value = "新增templateForm")
    @PostMapping("")
    public Result addNewTemplateForm(@RequestBody TemplateForm templateForm) {
        templateForm.setId(UUID.randomUUID().toString());
        templateForm.setGmtCreate(LocalDateTime.now());
        templateForm.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        TemplateForm res = templateFormService.save(templateForm);
        return Result.check(res);
    }

    /**
     * 根据id删除templateForm
     *
     * @param templateFormId templateFormId
     */
    @ApiOperation(value = "删除templateForm")
    @DeleteMapping("/{templateFormId}")
    public Result delete(@PathVariable String templateFormId) {
        TemplateForm templateForm = new TemplateForm();
        templateForm.setId(templateFormId);
        templateFormService.deleteById(templateFormId);
        return Result.success();
    }

    /**
     * 根据id删除TemplateForm
     *
     * @param templateForms templateForms
     */
    @ApiOperation(value = "批量删除TemplateForm")
    @DeleteMapping("")
    public Result delete(@RequestBody List<TemplateForm> templateForms) {
        templateFormService.deleteByIds(templateForms);
        return Result.success();
    }

    /**
     * 更新templateForm
     *
     * @param templateForm templateForm
     */
    @ApiOperation(value = "更新templateForm")
    @PutMapping("")
    public Result update(@RequestBody TemplateForm templateForm) {
        TemplateForm res = templateFormService.save(templateForm);
        return Result.check(res);
    }
}
