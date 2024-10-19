package org.example.mp.service.impl;

import org.example.mp.domain.po.Shop;
import org.example.mp.mapper.ShopMapper;
import org.example.mp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

}
