package com.qf.controller;

import com.qf.pojo.TbMusic;
import com.qf.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("music")
@Api(tags = "歌曲接口")
public class MusicController {
     @Autowired
     private MusicService musicService;

    @ApiOperation("查询全部歌曲") //api都是连接到swagger 上面的信息
    @RequestMapping("findAll")
    public List<TbMusic> findAll(){
       return musicService.findAll();
    }

    @ApiOperation("查询单个歌曲")
    @RequestMapping("findById")
    public TbMusic findById(String musicId){
        return musicService.findById(musicId);
    }
    @ApiOperation("查询上一首歌曲")
    @RequestMapping("prevSong")
    public TbMusic prevSong(String musicId){
        return musicService.prevSong(musicId);
    }
    @ApiOperation("查询下一首歌曲")
    @RequestMapping("nextSong")
    public TbMusic nextSong(String musicId){
        return musicService.nextSong(musicId);
    }
    @ApiOperation("搜索查询")
    @RequestMapping("search")
    public List<TbMusic> search(String keyword){
        return musicService.search(keyword);
    }
}
