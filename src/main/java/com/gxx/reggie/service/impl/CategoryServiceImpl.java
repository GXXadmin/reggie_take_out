package com.gxx.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxx.reggie.common.CustomException;
import com.gxx.reggie.entity.Category;
import com.gxx.reggie.entity.Dish;
import com.gxx.reggie.entity.Setmeal;
import com.gxx.reggie.mapper.CategoryMapper;
import com.gxx.reggie.service.CategoryService;
import com.gxx.reggie.service.DishService;
import com.gxx.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GXX
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);

        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        int count = dishService.count(dishLambdaQueryWrapper);
        if (count > 0) {
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper();
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        //添加查询条件，根据分类id进行查询
        int count1 = setmealService.count(setmealLambdaQueryWrapper);
        if (count1 > 0) {
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //正常删除分类
        super.removeById(id);
    }
}
