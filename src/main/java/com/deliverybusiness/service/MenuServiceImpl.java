package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IMenuDao;
import com.deliverybusiness.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements IMenuService{
    private IMenuDao iMenuDao;

    public MenuServiceImpl() {
    }
    @Autowired
    public MenuServiceImpl(IMenuDao iMenuDao) {
        this.iMenuDao = iMenuDao;
    }

    @Override
    public List<Menu> findAll() {
        return this.iMenuDao.findAll();
    }
}
