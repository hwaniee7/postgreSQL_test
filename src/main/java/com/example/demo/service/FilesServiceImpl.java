package com.example.demo.service;

import com.example.demo.domain.Files;
import com.example.demo.dto.FilesDto;
import com.example.demo.dto.FilesPagingDto;
import com.example.demo.repository.FilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FilesServiceImpl implements FilesService{
    private final FilesRepository filesRepository;

    @Override
    public Page<Files> listAll(Pageable pageable) {

        return filesRepository.findAll(pageable);
    }

    @Override
    public FilesPagingDto getFilesPagingDto(Pageable pageable) {
        Page<Files> list = listAll(pageable);
        int page = pageable.getPageNumber();
        long totalCount = filesRepository.count();
        int size = pageable.getPageSize();
        return new FilesPagingDto(page, size, totalCount, list);
    }

    @Override
    public Boolean insert(MultipartFile file) {
        pln("File insert in");
        pln("file: " + file);
        try {
            long fileSize = file.getSize();
            String fileType = file.getContentType();
            String ofname = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString(); // 파일 이름으로 쓸 uuid 생성
            String extension = ofname.substring(ofname.lastIndexOf(".")); // 확장자 추출(ex : .png)
            String fname = uuid + extension; // uuid와 확장자 결합
            byte[] fileBytes = file.getBytes();
            pln("-------------------------");
            pln("fileSize: " + fileSize);
            pln("fileType: " + fileType);
            pln("ofname: " + ofname);
            pln("fname: " + fname);
            pln("fileBytes: " + fileBytes);
            pln("-------------------------");

            String filePath = "/var/lib/postgresql/data";

            Files files = new Files();
            files.setFileSize((int)fileSize);
            files.setFileType(fileType);
            files.setThumbnail(""); // 썸네일 정보 설정
            files.setFile(fileBytes);
            files.setPath(filePath);
            files.setOfname(ofname);
            files.setFname(fname);

            files.setRdate(new Date()); // 현재 시간 설정
            files.setUdate(new Date()); // 현재 시간 설정

            filesRepository.save(files);


        } catch (Exception exception) {
            pln("Error: " + exception);
            return false;

        }
        return true;
    }



    void pln(String str){
        System.out.println(str);
    }
}
