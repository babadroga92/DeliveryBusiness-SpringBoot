package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IWeekdayDao;
import com.deliverybusiness.model.Weekday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeekdayServiceImpl implements IWeekdayService{
    private IWeekdayDao iWeekdayDao;

    @Autowired
    public WeekdayServiceImpl(IWeekdayDao iWeekdayDao) {
        this.iWeekdayDao = iWeekdayDao;
    }

    @Override
    public List<Weekday> findAll() {
        return this.iWeekdayDao.findAll();
    }
}
