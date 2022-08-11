package cn.edu.guet.backendmanagement.bean;

import lombok.Data;

import java.util.List;

/*
 * @Author zhh
 * @Date 2022-08-10 17:50
 * @version 1.0
 */
@Data
public class PageBean<T> {
    private int totalCount;

    private List<T> rows;
}
