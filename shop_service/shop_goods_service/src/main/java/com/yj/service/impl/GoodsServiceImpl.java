package com.yj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.yj.dao.GoodsMapper;
import com.yj.entity.Goods;
import com.yj.service.IGoodsService;
import com.yj.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user ken
 * @date 2019/5/20 14:53
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Reference
    private ISearchService searchService;

    @Override
    public List<Goods> queryList() {
        List<Goods> goods = goodsMapper.selectList(null);
        return goods;
    }

    @Override
    public int addGoods(Goods goods) {
        //保存商品到数据库中
        goodsMapper.insert(goods);
        //同步商品到索引库中
        searchService.addGoods(goods);
        return 1;
    }

    @Override
    public Integer deleteGoods(Integer id) {
        Integer i = goodsMapper.deleteById(id);
        searchService.deleteGood(id);
        return i;
    }

    @Override
    public Goods getByGoodId(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    @Override
    public Goods queryById(Integer id) {
        return goodsMapper.selectById(id);
    }
}
