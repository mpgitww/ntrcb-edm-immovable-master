package com.ntrcb.common.mapper;


import com.ntrcb.immovable.entity.PushEntity;
import com.ntrcb.immovable.entity.XmidEntity;
import com.ntrcb.immovable.entity.immovableToProvince.req.PlanPushBdcEq;
import com.ntrcb.immovable.entity.immovableToProvince.req.PlanQueryegisterEq;
import com.ntrcb.immovable.entity.immovableToProvince.req.XmidDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOfficePushMapper {

    @Insert("" +
            "INSERT INTO zyapi.qy_ds_edsp_bjjdts(slbh, action_time,bjzt, dyzmh, bjztsbyy, xzqdm) " +
            "VALUES (#{planPushBdcEq.centerNumber},#{planPushBdcEq.actionTime},#{planPushBdcEq.result},#{planPushBdcEq.cardNumber},#{planPushBdcEq.message},#{planPushBdcEq.xzqdm})" +
            "")
    Integer insertPush(@Param("planPushBdcEq") PlanPushBdcEq planPushBdcEq);

//    @Insert("UPDATE zyapi.qy_ds_edsp_bjjdts set bjzt = #{planPushBdcEq.result} where slbh = #{planPushBdcEq.slbh} and xzqdm = #{planPushBdcEq.qydm}")
    @Insert("UPDATE zyapi.qy_ds_edsp_bjjdts set bjzt = #{planPushBdcEq.result} where slbh = #{planPushBdcEq.slbh}")
    Integer updatePush(@Param("planPushBdcEq") PlanPushBdcEq planPushBdcEq);

//    @Select("select * from  zyapi.qy_ds_edsp_bjjdts where slbh = #{planQueryegisterEq.slbh} and xzqdm = #{planQueryegisterEq.qydm}")
    @Select("select * from  zyapi.qy_ds_edsp_bjjdts where slbh = #{planQueryegisterEq.slbh} ")
    List<PushEntity>  queryOfficePushList(@Param("planQueryegisterEq") PlanQueryegisterEq planQueryegisterEq);

    @Select("select * from  zyapi.qy_ds_edsp_xmid where cqzh = #{xmidDTO.cqzh}")
    List<XmidEntity>  queryXmidhList(@Param("xmidDTO") XmidDTO xmidDTO);

    @Insert("INSERT INTO zyapi.qy_ds_edsp_xmid(cqzh, xmid) VALUES(#{xmidDTO.cqzh}, #{xmidDTO.xmid})")
    Integer insertXmid(@Param("xmidDTO") XmidDTO xmidDTO);
}
