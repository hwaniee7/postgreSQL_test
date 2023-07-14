package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.io.File;
import java.sql.Blob;
import java.util.Date;

@Entity
@Data
@Table(name="Files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fid;
    private Integer fileSize;
    private String fileType;
    private String thumbnail;
    @Column(columnDefinition = "BYTEA")
    private byte[] file;
    private String path;
    private String fname;
    private String ofname;
    @CreationTimestamp
    private Date rdate;
    @CreationTimestamp
    private Date udate;
}
