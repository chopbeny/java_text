package com.xzsd.pc.driver.service;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.driver.entity.DriverSettingDTO;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;


/**
 * @DescriptionDemo 实现类
 * @Author 邓嘉豪
 * @Date 2020-03-27
 */
@Service
public class DriverService {
/*
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private JmsTemplate jmsTemplate;
*/


    @Resource
    private DriverDao driverDao;


    /**
     * demo 新增司机
     *
     * @param driverInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveDriver(DriverInfo driverInfo) {
        // 校验账号是否存在
        int countDriverLogin = driverDao.countDriverLogin(driverInfo);

        if (0 != countDriverLogin) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }

        driverInfo.setisDeleted(0);
        // 新增用户
        int count = driverDao.saveDriver(driverInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");

    }



/*
    public AppResponse saveDriver(DriverInfo driverInfo){
        driverInfo.setDriverNo(UUIDUtils.getUUID());
        driverInfo.setdriverLogin(AuthUtils.getCurrentUserId());
        driverInfo.setdriverPassword(AuthUtils.getCurrentUserId());
        int drive = driverDao.saveDriver(driverInfo);

        try{
            //发送ActiveMQ消息（对象）
            jmsTemplate.send(this.queue.getQueueName(), new MessageCreator() {
                //Session 对象是一个包含消息生产和消费的上下文应用（简而言之就是包含了生产者和消费者各种信息）
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage(driverInfo);//将自定义对象包裹进ActiveMQObjectMessage对象中
                }
            });
        }catch (Exception e){
            System.out.println("消息队列保存失败");
        }

        if(drive > 0){
            return AppResponse.success("新增成功");
        }else{
            return AppResponse.bizError("新增失败");
        }

    }


*/


    /**
     * driver 查询司机列表（分页）
     *
     * @param driverInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-30
     */
    public AppResponse listDriver(DriverInfo driverInfo) {
        PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
        List<DriverInfo> driverInfoList = driverDao.listDriversByPage(driverInfo);
        // 包装Page对象
        PageInfo<DriverInfo> pageData = new PageInfo<DriverInfo>(driverInfoList);
        return AppResponse.success("查询成功！", pageData);
    }


    /**
     * demo 查询司机详情
     *
     * @param driverNo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    public AppResponse getDriverBydriverNo(String driverNo) {
        DriverInfo userInfo = driverDao.getDriverBydriverNo(driverNo);
        return AppResponse.success("查询成功！", userInfo);
    }


    /**
     * demo 修改司机
     *
     * @param driverInfo
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countDriverAcct = driverDao.countDriverLogin(driverInfo);
        if (0 != countDriverAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = driverDao.updateDriver(driverInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }


    /**
     * 删除司机
     * @return
     * @Author 邓嘉豪
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(DriverSettingDTO driverSettingDTO) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = driverDao.deleteDriver(driverSettingDTO);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }



}
