package com.hfut.service;

import com.hfut.pojo.PageInfo;

import java.io.IOException;

public interface LogService {
    /*实现分页*/
    PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
