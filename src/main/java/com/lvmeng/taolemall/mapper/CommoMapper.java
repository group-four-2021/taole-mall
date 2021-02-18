package com.lvmeng.taolemall.mapper;

import com.lvmeng.taolemall.Commo;
import org.springframework.stereotype.Repository;

/**
 * 商品查看接口
 * author : 成佳骏
 */
@Repository
public interface CommoMapper {
    Commo showCommo(int commo_id);  // 根据商品 id 查看商品信息
}
