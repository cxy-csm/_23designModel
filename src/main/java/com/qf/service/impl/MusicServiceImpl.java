package com.qf.service.impl;

import com.qf.dao.TbMusicMapper;
import com.qf.pojo.TbMusic;
import com.qf.pojo.TbMusicExample;
import com.qf.service.MusicService;
import com.sun.xml.internal.txw2.output.IndentingXMLFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService{
    //这里要调用dao层里面的方法 所有注入进来
    @Autowired
    private TbMusicMapper tbMusicMapper;

    @Override
    public List<TbMusic> findAll() {
        return tbMusicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(String musicId) {
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(String musicId) {
     //根据当前歌曲的id，找到歌曲的下标，从而找到上一首歌曲的对象
        List<TbMusic> tbMusics = tbMusicMapper.selectByExample(null);
        //先记录一下当前播放歌曲的下标的变量
        int index = 0;
        //遍历所有的歌曲
        for(int i=0;i<tbMusics.size();i++){
            //比较id
           if(musicId.equals(tbMusics.get(i).getMusicId())){
               //确定当前对象
                index=i;
                break;
           }
        }
        //计算上一首歌曲的下标
        int prevIndex= index == 0?tbMusics.size()-1:index-1;
        System.out.println(prevIndex);
        //返回上一首歌曲对象
        return tbMusics.get(prevIndex);
    }

    @Override
    public TbMusic nextSong(String musicId) {
        //根据当前歌曲的id，找到歌曲的下标，从而找到下一首歌曲的对象
        List<TbMusic> tbMusics = tbMusicMapper.selectByExample(null);
        //记录一下当前播放歌曲的下标
        int index = 0;
        //遍历所有的歌曲
        for(int i=0;i<tbMusics.size();i++){
            //比较id
            if(musicId.equals(tbMusics.get(i).getMusicId())){
                //当前对象
                index=i;
                break;
            }
        }
        //计算下一首歌曲的下标
        int nextIndex= index == tbMusics.size()-1?0:index+1;
        //返回下一首歌曲对象
        return tbMusics.get(nextIndex);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();
        //获取添加条件查询的对象criteria
        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();
        //设置查询条件,这里为什么只能按一个条件来，而不能多个条件一起查询？
        criteria.andMusicNameLike("%"+keyword+"%");
//        criteria.andMusicArtistNameLike("%"+keyword+"%");
//        criteria.andMusicAlbumNameLike("%"+keyword+"%");
        List<TbMusic> tbMusics = tbMusicMapper.selectByExample(tbMusicExample);
        return tbMusics;
    }
}
