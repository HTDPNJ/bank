package com.hfut.Service;

import com.hfut.pojo.PageInfo;

import java.io.IOException;


public interface PeopleService  {
    /*分页显示*/
    PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
