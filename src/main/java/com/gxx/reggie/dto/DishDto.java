package com.gxx.reggie.dto;

import com.gxx.reggie.entity.Dish;
import com.gxx.reggie.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GXX
 */
@Data
public class DishDto extends Dish {

    // 菜品的口味数据
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
