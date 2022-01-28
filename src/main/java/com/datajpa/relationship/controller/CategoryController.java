package com.datajpa.relationship.controller;

import com.datajpa.relationship.dto.requestDto.CategoryRequestDto;
import com.datajpa.relationship.dto.responseDto.CategoryResponseDto;
import com.datajpa.relationship.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryResponseDto> addCategory(
            @RequestBody final CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.addCategory(categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable final Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getCategories() {
        List<CategoryResponseDto> categoryResponseDtos = categoryService.getCategories();
        return new ResponseEntity<>(categoryResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable final Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.deleteCategory(id);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<CategoryResponseDto> editCategory(
            @RequestBody final CategoryRequestDto categoryRequestDto,
            @PathVariable final Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.editCategory(id, categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }


}






























