package com.example.demo.dto;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
public class FilesDto {
    private Long fid;
    private Integer fileSize;
    private String fileType;
    private String thumbnail;
    private byte[] file;
    private String path;
    @CreationTimestamp
    private Date rdate;
    @CreationTimestamp
    private Date udate;
}
