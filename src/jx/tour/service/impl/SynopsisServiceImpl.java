package jx.tour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jx.tour.mapper.SynopsisMapper;
import jx.tour.pojo.Synopsis;
import jx.tour.service.SynopsisService;

@Service
public class SynopsisServiceImpl implements SynopsisService {
    
    @Autowired
    private SynopsisMapper synopsisMapper;

    @Override
    public void add(Synopsis synopsis) {
    	
        synopsisMapper.add(synopsis);
    }

    @Override
    public void updateById(Synopsis synopsis) {
    	
        synopsisMapper.updateById(synopsis);
    }
    
    

}
