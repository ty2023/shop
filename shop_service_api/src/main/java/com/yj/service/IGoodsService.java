package com.yj.service;

import com.yj.entity.Goods;

import java.util.List;

public interface IGoodsService {

    List<Goods> queryList();

    int addGoods(Goods goods);

    Integer deleteGoods(Integer id);

    Goods getByGoodId(Integer id);

    Integer updateGoods(Goods goods);

    Goods queryById(Integer gid);
}
