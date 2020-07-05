package com.qf.service.impl;

import com.qf.dao.TbSheetMapper;
import com.qf.pojo.TbSheet;
import com.qf.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.PrintConversionEvent;
import java.util.List;

@Service
public class SheetServiceImpl implements SheetService{
    @Autowired
    private TbSheetMapper tbSheetMapper;


    @Override
    public List<TbSheet> findAll() {
        return tbSheetMapper.selectByExample(null);
    }
}
