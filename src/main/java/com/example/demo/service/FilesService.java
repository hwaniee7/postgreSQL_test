package com.example.demo.service;

import com.example.demo.domain.Files;
import com.example.demo.dto.FilesDto;
import com.example.demo.dto.FilesPagingDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;

public interface FilesService {

    Page<Files> listAll(Pageable pageable);

    FilesPagingDto getFilesPagingDto(Pageable pageable);

    Boolean insert(MultipartFile file);


}
