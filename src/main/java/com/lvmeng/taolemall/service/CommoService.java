package com.lvmeng.taolemall.service;

import com.lvmeng.taolemall.Commo;
import com.lvmeng.taolemall.mapper.CommoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品查看逻辑类
 * author : 成佳骏
 */
@Service
public class CommoService {
    @Autowired
    CommoMapper commoMapper;
    /**
     * 根据商品id差看商品信息
     */
    public Commo showCommo(int commo_id) {
        return commoMapper.showCommo(commo_id);
    }
    public List<Commo> getAllCommo(){
        return commoMapper.getAllCommo();
    }
}
