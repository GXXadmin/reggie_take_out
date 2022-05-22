package com.gxx.reggie.dto;

import com.gxx.reggie.entity.Setmeal;
import com.gxx.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
