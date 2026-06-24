package com.example.demo.mapper;

import com.example.demo.dto.SampleDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Mapper interface for menu queries. The actual SQL is defined in
 * {@code menu.xml} and mapped by MyBatis via the namespace
 * {@code com.example.demo.mapper.SampleMapper}.
 */
@Mapper
public interface SampleMapper {

    /**
     * Executes the <select id="fetchMenu"/> query defined in {@code menu.xml}.
     *
     * @return a list of {@link SampleDto} representing the menu hierarchy.
     */
    List<SampleDto> fetchMenu();
}
