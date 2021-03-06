package com.soa.order.service;

import com.soa.order.repository.ReservationRepository;
import com.soa.order.views.StatisticResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ program: demo
 * @ description:
 * @ author: ShenBo
 * @ date: 2021-12-28 11:12:16
 */
@Service
public class StatisticService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<StatisticResult> getSystemMoney(String fromDate,String endDate){
        List systemTimeReservation = reservationRepository.findSystemTimeReservation(fromDate, endDate);
        List<StatisticResult> ans=new ArrayList<>();//结果
        for(Object tmp:systemTimeReservation){
            Object[] cells = (Object[])tmp;
            StatisticResult statisticResult = new StatisticResult
                    (((Date)cells[0]).toString(),Integer.parseInt(String.valueOf(cells[1])));
            ans.add(statisticResult);
        }
        return ans;
    }

    public List<StatisticResult> getHospitalMoney(String fromDate, String endDate, String hospitalId){
        List systemTimeReservation = reservationRepository.findHospitalTimeReservation(fromDate, endDate, hospitalId);
        List<StatisticResult> ans=new ArrayList<>();//结果
        for(Object tmp:systemTimeReservation){
            Object[] cells = (Object[])tmp;
            StatisticResult statisticResult = new StatisticResult
                    (((Date)cells[0]).toString(),Integer.parseInt(String.valueOf(cells[1])));
            ans.add(statisticResult);
        }
        return ans;
    }
}
