package org.example.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.mp.domain.dto.PageDTO;
import org.example.mp.domain.po.User;
import org.example.mp.domain.query.UserQuery;
import org.example.mp.domain.vo.UserVO;

import java.util.List;

public interface IUserService extends IService<User> {
    void deductBalance(Long id, Integer money);

    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);

    UserVO queryUserAndAddressById(Long id);

    List<UserVO> queryUserAndAddressByIds(List<Long> ids);

    PageDTO<UserVO> queryUsersPage(UserQuery query);
}
