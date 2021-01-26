package com.atguigu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    private  CategoryDao categoryDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
//        查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
//        List<CategoryEntity> entities1 = categoryDao.selectList(null);
        List<CategoryEntity> levelMenus = entities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menus)->{
            menus.setChildren(getChildrens(menus,entities));
            return menus;
        }).sorted((menu1,menu2)->{
            return  (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

//        List<CategoryEntity> categoryParent1 = new ArrayList<>();
//        for (int i = 0; i < entities.size(); i++) {
//            if(entities.get(i).getParentCid()==0){
//                categoryParent1.add(entities.get(i));
//            }
//        }

        return levelMenus;
    }

    @Override
    public void removeMenuByIds(List<Long> longs) {
        //ToDo  检查当前删除的餐单，是否被其它地方引用
        baseMapper.deleteBatchIds(longs);
    }

    /*
    * 递归查找所有子菜单
    * */
    private List<CategoryEntity> getChildrens(CategoryEntity menus, List<CategoryEntity> entities) {
        List<CategoryEntity> childrensMenus = entities.stream().filter((entity) -> {
            return menus.getCatId() == entity.getParentCid();
        }).map((categoryEntity)->{
            categoryEntity.setChildren(getChildrens(categoryEntity,entities));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            return  (menu1.getSort() == null? 0: menu1.getSort())-(menu2.getSort() == null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return  childrensMenus;
    }

}