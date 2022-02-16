package com.course.system.mapper;

import com.course.system.domain.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zzy
 * @date 2022/2/16
 */
public interface TestMapper {

    public List<Test> list();

}
