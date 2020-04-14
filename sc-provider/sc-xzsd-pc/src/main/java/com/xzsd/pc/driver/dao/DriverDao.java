package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverSettingDTO;
import com.xzsd.pc.user.entity.UserSettingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName Driver
 * @Description driver
 * @Author 邓嘉豪
 * @Date 2020-03-27
 */
@Mapper
public interface DriverDao {
    /**
     * 统计用户账号数量
     *
     * @param driverInfo 司机信息
     * @return
     */
    int countDriverLogin(DriverInfo driverInfo);

    /**
     * 新增用户
     *
     * @param driverInfo 用户信息
     * @return
     */
    int saveDriver(DriverInfo driverInfo);


    /**
     * 获取所有司机信息
     *
     * @param driverInfo 司机信息
     * @return 所有用户信息
     */
    List<DriverInfo> listDriversByPage(DriverInfo driverInfo);

    /**
     * 查询司机信息
     *
     * @param driverNo 司机编号
     * @return 修改结果
     */
    DriverInfo getDriverBydriverNo(@Param("driverNo") String driverNo);


    /**
     * 修改司机信息
     *
     * @param driverInfo 用户信息
     * @return 修改结果
     */
    int updateDriver(DriverInfo driverInfo);


    /**
     * 删除司机信息
     * @param driverSettingDTO 选中的用户信息
     * @return
     */
    int deleteDriver(DriverSettingDTO driverSettingDTO);


}
