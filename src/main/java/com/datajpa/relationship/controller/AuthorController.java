package com.datajpa.relationship.controller;

import com.datajpa.relationship.dto.requestDto.AuthorRequestDto;
import com.datajpa.relationship.dto.responseDto.AuthorResponseDto;
import com.datajpa.relationship.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(
            @RequestBody final AuthorRequestDto authorRequestDto) {
        AuthorResponseDto authorResponseDto = authorService.addAuthor(authorRequestDto);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable final Long id) {
        AuthorResponseDto authorResponseDto = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors() {
        List<AuthorResponseDto> authorResponseDtos = authorService.getAuthors();
        return new ResponseEntity<>(authorResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable final Long id) {
        AuthorResponseDto authorResponseDto = authorService.deleteAuthor(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    private ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable final Long id,
                                                         @RequestBody final AuthorRequestDto authorRequestDto) {
        AuthorResponseDto authorResponseDto = authorService.editAuthor(id, authorRequestDto);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
    private ResponseEntity<AuthorResponseDto> addZipcode(@PathVariable final Long zipcodeId,
                                                         @PathVariable final Long authorId) {
        AuthorResponseDto authorResponseDto = authorService.addZipcodeToAuthor(authorId, zipcodeId);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PostMapping("/removeZipcode/{id}")
    private ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable final Long id) {
        AuthorResponseDto authorResponseDto = authorService.deleteZipcodeFromAuthor(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }
}
























