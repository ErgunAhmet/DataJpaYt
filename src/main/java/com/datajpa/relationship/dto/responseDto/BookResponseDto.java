package com.datajpa.relationship.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private List<String> authorNames;
    private String categoryName;
}
