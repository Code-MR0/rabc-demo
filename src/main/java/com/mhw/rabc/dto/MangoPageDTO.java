package com.mhw.rabc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;

/**
 * @className: MangoPageDTO
 * @description: TODO
 * @author: mhw
 * @date: 2022/3/15
 * @version: 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangoPageDTO implements Pageable {
    private Integer number;
    private Integer size;
    private Sort mySort;


    @Override
    public int getPageNumber() {
        return getNumber();
    }

    @Override
    public int getPageSize() {
        return getSize();
    }

    @Override
    public long getOffset() {
        return (long) (getPageNumber() - 1) * getPageSize();
    }

    @Override
    public Sort getSort() {
        return getMySort();
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
