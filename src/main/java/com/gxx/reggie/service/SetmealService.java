package com.gxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gxx.reggie.dto.SetmealDto;
import com.gxx.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author GXX
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
