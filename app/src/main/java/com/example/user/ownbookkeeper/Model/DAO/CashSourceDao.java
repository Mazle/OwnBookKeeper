package com.example.user.ownbookkeeper.Model.DAO;

import com.example.user.ownbookkeeper.Model.DataModel.CashSource;

import java.util.ArrayList;

/**
 * Created by PalibinFamily on 01.10.2017.
 */

public interface CashSourceDao {
    public void insertCashSource(CashSource cs);

    public String updateCashSource(CashSource cs);
    public ArrayList<CashSource> fillStorage();
    CashSource getSourceById (String id); //возвращает источник по id
}
