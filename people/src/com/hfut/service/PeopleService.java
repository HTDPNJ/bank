package com.hfut.service;

import com.hfut.pojo.People;

import java.io.IOException;
import java.util.List;

public interface PeopleService {
    List<People>show() throws IOException;
}
