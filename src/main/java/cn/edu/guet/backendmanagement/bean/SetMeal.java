package cn.edu.guet.backendmanagement.bean;

import lombok.Data;

/**
 * @Author yj
 * @Date    2022/7/30 19:00
 * @version: 1.0
 */
@Data
public class SetMeal {
    private Integer id;
    private String meal_name;
    private Double price;
    private String contain;
    private String description;
    public Integer sale;
    private String flavor;

    public SetMeal() {
    }

    public SetMeal(Integer id, String meal_name, Double price, String contain, String description, Integer sale, String flavor) {
        this.id = id;
        this.meal_name = meal_name;
        this.price = price;
        this.contain = contain;
        this.description = description;
        this.sale = sale;
        this.flavor = flavor;
    }
}
