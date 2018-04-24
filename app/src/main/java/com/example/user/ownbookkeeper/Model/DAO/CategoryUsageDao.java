package com.example.user.ownbookkeeper.Model.DAO;

import com.example.user.ownbookkeeper.Model.DataModel.Usage;

import java.util.ArrayList;

/**
 * Created by Palibin
 */

public interface CategoryUsageDao {

    ArrayList<Usage> getCategoryUsageList();

    void addUsageInList(Usage usage);
}
