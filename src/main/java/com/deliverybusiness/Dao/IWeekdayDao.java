package com.deliverybusiness.Dao;

import com.deliverybusiness.model.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeekdayDao extends JpaRepository<Weekday, Integer> {

}
