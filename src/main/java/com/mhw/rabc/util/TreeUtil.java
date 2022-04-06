package com.mhw.rabc.util;

import com.mhw.rabc.entity.Organization;
import com.mhw.rabc.entity.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: OrgTreeUtil
 * @description: 组织架构树形组装
 * @author: mhw
 * @date: 2022/3/30
 * @version: 1.0
 **/
public class TreeUtil {
    public static List<Organization> createOrgTree(List<Organization> original, Long pid){
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
            i.setChildren(createOrgTree(temp, i.getId()));
        });
        return tree;
    }

    public static List<Permission> createPreTree(List<Permission> original, Long pid){
        List<Permission> tree = new ArrayList<>(original.size());
        List<Permission> temp = new ArrayList<>(original.size());
        original.forEach(i->{
            if (i.getPid().equals(pid)){
                tree.add(i);
            }else {
                temp.add(i);
            }
        });
        tree.forEach(i->{
            i.setChildren(createPreTree(temp, i.getId()));
        });
        return tree;
    }

}
