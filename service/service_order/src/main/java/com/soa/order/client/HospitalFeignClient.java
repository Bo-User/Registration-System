package com.soa.order.client;

import com.soa.order.model.Doctor;
import com.soa.order.model.Schedule;
import com.soa.order.views.ReservationVo;
import com.soa.order.views.ScheduleVo;
import com.soa.utils.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "service-hospital",fallback = HospitalDegradeFeignClient.class)
@Component
public interface HospitalFeignClient {

    //根据医生id查询医生schedule列表
    @GetMapping("/hospital/schedules/getSchedule/{doctorId}")
    public Result getSchedule(@PathVariable("doctorId") String doctorId);

    @GetMapping("/hospital/schedules/inner/getScheduleVo/{scheduleId}")
    public Result<ScheduleVo> getScheduleVo(@PathVariable("scheduleId") int scheduleId);

    @PostMapping("/hospital/schedules/updateSchedule")
    public Result updateSchedule(@RequestBody ScheduleVo scheduleVo);
}
