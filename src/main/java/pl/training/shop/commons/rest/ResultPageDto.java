package pl.training.shop.commons.rest;

import lombok.Data;

import java.util.List;

@Data
public class ResultPageDto<T> {

    private List<T> data;
    private int pageNumber;
    private long totalPages;

}
