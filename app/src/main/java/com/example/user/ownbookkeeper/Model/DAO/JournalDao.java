package com.example.user.ownbookkeeper.Model.DAO;


import com.example.user.ownbookkeeper.Model.DataModel.JournalRecord;
import com.example.user.ownbookkeeper.Model.DataModel.TypesOfCashObjects;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by PalibinFamily on 03.10.2017.
 */

public interface JournalDao {

    void insertJournalRecordByDate(JournalRecord record);

    HashMap<GregorianCalendar, ArrayList<JournalRecord>> getCustomMapFromStorage
            (GregorianCalendar startDate,
             GregorianCalendar endDate,
             TypesOfCashObjects type);

}
