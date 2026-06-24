package com.example.demo.service;

import com.example.demo.dto.SampleDto;
import com.example.demo.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SampleService {

    private final SampleMapper sampleMapper;

    @Autowired
    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    /**
     * Retrieves the menu hierarchy using the SampleMapper.
     *
     * @return List of SampleDto representing menu items.
     */
    public List<SampleDto> getMenu() {
        return sampleMapper.fetchMenu();
    }
}
