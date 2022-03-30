package com.mhw.rabc.util;

import com.mhw.rabc.entity.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: OrgTreeUtil
 * @description: 组织架构树形组装
 * @author: mhw
 * @date: 2022/3/30
 * @version: 1.0
 **/
public class OrgTreeUtil {
    public static List<Organization> createTree(List<Organization> original,Long pid){
        List<Organization> tree = new ArrayList<>(original.size());
        List<Organization> temp = new ArrayList<>(original.size());
        original.forEach(i->{
            if (i.getPid().equals(pid)){
                tree.add(i);
            }else {
                temp.add(i);
            }
        });
        tree.forEach(i->{
            i.setChildren(createTree(temp, i.getId()));
        });
        return tree;
    }
}
