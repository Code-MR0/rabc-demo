package com.mhw.rabc.controller;

import com.mhw.rabc.dto.MangoPageDTO;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Industry;
import com.mhw.rabc.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @className: IndustryController
 * @description: IndustryController
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Api(tags = "IndustryController")
@RestController
@RequestMapping("/industry")
@SuppressWarnings("rawtypes")
public class IndustryController {

    private final IndustryService industryService;

    @Autowired
    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public Result getAllIndustries() {
        List<Industry> industryList = industryService.findAll();
        return Result.check(industryList);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表/{owner}")
    @GetMapping("/list/{owner}")
    public Result getAllIndustriesByOwner(@PathVariable String owner) {
        List<Industry> industryList = industryService.findAll(owner);
        return Result.check(industryList);
    }

    /**
     * 分页列表
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("")
    public Result pageList(Industry industry) {
        MangoPageDTO mangoPageDTO = new MangoPageDTO(industry.getPage(), industry.getLimit(), Sort.by(Sort.Direction.ASC, "id"));
        Page<Industry> industryList = industryService.findAll(mangoPageDTO);
        return Result.check(industryList);
    }

    /**
     * 根据id查询industry
     *
     * @param industryId industryId
     */
    @ApiOperation(value = "根据id查询industry")
    @GetMapping("/{industryId}")
    public Result getByIndustryId(@PathVariable String industryId) {
        Optional<Industry> industry = industryService.findById(industryId);
        return Result.check(industry);
    }

    /**
     * 新增industry
     *
     * @param industry industry
     */
    @ApiOperation(value = "新增industry")
    @PostMapping("")
    public Result addNewIndustry(@RequestBody Industry industry) {
        industry.setId(UUID.randomUUID().toString());
        industry.setGmtCreate(LocalDateTime.now());
        Industry res = industryService.save(industry);
        return Result.check(res);
    }

    /**
     * 根据id删除industry
     *
     * @param industryId industryId
     */
    @ApiOperation(value = "删除industry")
    @DeleteMapping("/{industryId}")
    public Result delete(@PathVariable String industryId) {
        Industry industry = new Industry();
        industry.setId(industryId);
        industryService.deleteById(industryId);
        return Result.success();
    }

    /**
     * 根据id删除industry
     *
     * @param industries industries
     */
    @ApiOperation(value = "批量删除industry")
    @DeleteMapping("")
    public Result delete(@RequestBody List<Industry> industries) {
        industryService.deleteByIds(industries);
        return Result.success();
    }

    /**
     * 更新industry
     *
     * @param industry industry
     */
    @ApiOperation(value = "更新industry")
    @PutMapping("")
    public Result update(@RequestBody Industry industry) {
        Industry res = industryService.save(industry);
        return Result.check(res);
    }
}
