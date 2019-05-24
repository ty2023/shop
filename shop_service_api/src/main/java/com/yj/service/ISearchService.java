package com.yj.service;

import com.yj.entity.Goods;

import java.util.List;

public interface ISearchService {

    List<Goods> queryByKeyWord(String keyword);

    int addGoods(Goods goods);

    void deleteGood(Integer id);
}
