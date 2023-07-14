package com.example.demo.controller;


import com.example.demo.domain.Files;
import com.example.demo.dto.FilesPagingDto;
import com.example.demo.service.FilesService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/files")
public class FileController {

    private final FilesService filesService;
    @GetMapping("/fileList.do")
    public FilesPagingDto getFileList(@PageableDefault(size=20, sort="fid", direction = Sort.Direction.DESC) Pageable pageable){
        pln("getFileList in");
        FilesPagingDto filesPagingDto = filesService.getFilesPagingDto(pageable);
        pln("filesPagingDto: " + filesPagingDto);
        return filesPagingDto;
    }

    @PostMapping("/fileUpload.do")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        boolean successFlag = filesService.insert(file);
        if (!successFlag) {
            String errorMsg = "업로드에 실패했습니다.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
        }
        return ResponseEntity.ok("업로드가 완료되었습니다.");
    }

    void pln(String str){
        System.out.println(str);
    }

}
