package com.xzsd.pc.client.dao;

import java.util.List;
import com.xzsd.pc.client.entity.ClientInfo;
public interface ClientDao {

    /**
     * 获取所有客户信息
     * @param clientInfo 用户信息
     * @return 所有用户信息
     */
    List<ClientInfo> listClientsByPage(ClientInfo clientInfo);
}


