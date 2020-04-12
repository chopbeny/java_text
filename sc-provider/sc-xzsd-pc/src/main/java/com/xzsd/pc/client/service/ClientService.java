package com.xzsd.pc.client.service;

import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;
@Service
public class ClientService {
    @Resource
    private ClientDao clientDao;
    /**
     * 功能：获取用户列表
     * 描述：略
     * 作成者：邓嘉豪
     * 作成时间：2020/4/11
     */
    public AppResponse listClient(ClientInfo clientInfo) {
        List<ClientInfo> userInfoList = clientDao.listClientsByPage(clientInfo);
        return AppResponse.success("查询成功！", getPageInfo(userInfoList));
    }
}
