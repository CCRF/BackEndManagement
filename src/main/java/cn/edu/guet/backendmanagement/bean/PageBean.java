package cn.edu.guet.backendmanagement.bean;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T>  {
    private int totalCount;

    private List<T> rows;
}
