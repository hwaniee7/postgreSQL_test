package com.example.demo.dto;

import com.example.demo.domain.Files;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;


@NoArgsConstructor
@Data
public class FilesPagingDto {
    private Page<Files> list;
    // 현재 페이지
    private int pageNum;

    // 한 페이지당 게시글 수
    private int pageSize;
    // 전체 게시글 수
    private long totalCount;

    // 전체 페이지수
    private long totalPageCount;

    //MyBatis ROWNUM 조건에 들어갈 변수
    private int startRow;
    private int endRow;

    public FilesPagingDto(int pageNum, int pageSize, long totalCount, Page<Files> list){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        this.totalPageCount= calTotalcount();
        this.list = list;
    }

    private long calTotalcount() {
        long totalPageCount = totalCount/pageSize;
        if(totalCount%pageSize !=0) totalPageCount++;
        return totalPageCount;
    }

}
