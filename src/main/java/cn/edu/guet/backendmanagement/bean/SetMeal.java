package cn.edu.guet.backendmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yj
 * @Date    2022/8/4 18:40
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetMeal {
    private Integer id;
    private String name;
    private Double price;
    private String contain;
    private String description;
    public Integer sale;
    private String flavor;
    private String picture;

}
