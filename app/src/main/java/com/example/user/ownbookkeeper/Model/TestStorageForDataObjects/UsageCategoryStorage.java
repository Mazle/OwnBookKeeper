package com.example.user.ownbookkeeper.Model.TestStorageForDataObjects;



import com.example.user.ownbookkeeper.Model.DataModel.Usage;

import java.util.ArrayList;

/**
 * Created by Palibin
 */

public class UsageCategoryStorage {
    private static UsageCategoryStorage singleStorage;
    private ArrayList<Usage> storageList;

    public ArrayList<Usage> getStorageList() {
        return storageList;
    }

    private UsageCategoryStorage() {
        ArrayList<Usage> arrayList =
                new ArrayList<Usage>();
        /***************************
         *Инициализация временного хранилища для тестирования
         * TODO удалить на релизе
         **********************************/
            arrayList.add(new Usage("На бензин", null));
            arrayList.add(new Usage("На еду", null));
            arrayList.add(new Usage("Иппотека", null));
            arrayList.add(new Usage("To the sea",null));



        /****************************************************************/
        this.storageList = arrayList;
    }

    public static UsageCategoryStorage getUsageStorage(){
        if (singleStorage==null) {
            singleStorage = new UsageCategoryStorage();
        }
        return singleStorage;
    }
}
