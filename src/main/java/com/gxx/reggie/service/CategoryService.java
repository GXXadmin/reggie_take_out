package com.gxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gxx.reggie.entity.Category;

/**
 * @author GXX
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
