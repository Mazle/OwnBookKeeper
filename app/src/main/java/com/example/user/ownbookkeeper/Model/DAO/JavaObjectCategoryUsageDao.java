package com.example.user.ownbookkeeper.Model.DAO;


import com.example.user.ownbookkeeper.Model.DataModel.Usage;
import com.example.user.ownbookkeeper.Model.TestStorageForDataObjects.UsageCategoryStorage;

import java.util.ArrayList;

/**
 * Created by Palibin
 */

public class JavaObjectCategoryUsageDao extends JavaObjectDaoFactory implements CategoryUsageDao {

    private static ArrayList<Usage> getStorage() {
        return UsageCategoryStorage.getUsageStorage().getStorageList();
    }

    @Override
    public ArrayList<Usage> getCategoryUsageList() {
        return getStorage();
    }

    @Override
    public void addUsageInList(Usage usage) {
        getStorage().add(usage);
    }
}
