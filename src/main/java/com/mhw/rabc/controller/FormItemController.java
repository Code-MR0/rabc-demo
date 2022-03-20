package com.mhw.rabc.controller;

import com.mhw.rabc.dto.MangoPageDTO;
import com.mhw.rabc.dto.PageDTO;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.FormItem;
import com.mhw.rabc.service.FormItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @className: FormItemController
 * @description: FormItemController
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
@Api(tags = "FormItemController")
@RestController
@RequestMapping("/formItem")
@SuppressWarnings("rawtypes")
public class FormItemController {

    private final FormItemService formItemService;

    @Autowired
    public FormItemController(FormItemService formItemService) {
        this.formItemService = formItemService;
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list/")
    public Result getAllFormItems() {
        List<FormItem> formItemList = formItemService.findAll();
        return Result.check(formItemList);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表/{owner}")
    @GetMapping("/list/{owner}")
    public Result getAllFormItemsByOwner(@PathVariable String owner) {
        List<FormItem> formItemList = formItemService.findAll(owner);
        return Result.check(formItemList);
    }

    /**
     * 分页列表
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("")
    public Result pageList(FormItem formItem) {
        MangoPageDTO mangoPageDTO = new MangoPageDTO(formItem.getPage(), formItem.getLimit(), Sort.by(Sort.Direction.ASC, "id"));
        Page<FormItem> formItemList;
        if (formItem.getType()==null){
            formItemList = formItemService.findAll(mangoPageDTO,SecurityContextHolder.getContext().getAuthentication().getName());
        }else {
            formItemList = formItemService.findAll(mangoPageDTO,SecurityContextHolder.getContext().getAuthentication().getName(),formItem.getType());
        }
        return Result.check(formItemList);
    }

    /**
     * 根据id查询formItem
     *
     * @param formItemId formItemId
     */
    @ApiOperation(value = "根据id查询formItem")
    @GetMapping("/{formItemId}")
    public Result getByFormItemId(@PathVariable String formItemId) {
        Optional<FormItem> formItem = formItemService.findById(formItemId);
        return Result.check(formItem);
    }

    /**
     * 新增formItem
     *
     * @param formItem formItem
     */
    @ApiOperation(value = "新增formItem")
    @PostMapping("")
    public Result addNewFormItem(@RequestBody FormItem formItem) {
        formItem.setId(UUID.randomUUID().toString());
        formItem.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        FormItem res = formItemService.save(formItem);
        return Result.check(res);
    }

    /**
     * 根据id删除formItem
     *
     * @param formItemId formItemId
     */
    @ApiOperation(value = "删除formItem")
    @DeleteMapping("/{formItemId}")
    public Result delete(@PathVariable String formItemId) {
        FormItem formItem = new FormItem();
        formItem.setId(formItemId);
        formItemService.deleteById(formItemId);
        return Result.success();
    }

    /**
     * 根据id删除formItem
     *
     * @param formItems formItems
     */
    @ApiOperation(value = "批量删除formItem")
    @DeleteMapping("")
    public Result delete(@RequestBody List<FormItem> formItems) {
        formItemService.deleteByIds(formItems);
        return Result.success();
    }

    /**
     * 更新formItem
     *
     * @param formItem formItem
     */
    @ApiOperation(value = "更新formItem")
    @PutMapping("")
    public Result update(@RequestBody FormItem formItem) {
        FormItem res = formItemService.save(formItem);
        return Result.check(res);
    }
}
