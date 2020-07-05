package com.qf.controller;

import com.qf.pojo.TbSheet;
import com.qf.service.SheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sheet")
@Api(tags = "歌单接口")
public class SheetController {
    @Autowired
    private SheetService sheetService;

    @RequestMapping("findAll")
    @ApiOperation("查询全部歌单")
    public List<TbSheet> findAll(){
        return sheetService.findAll();
    }

}
