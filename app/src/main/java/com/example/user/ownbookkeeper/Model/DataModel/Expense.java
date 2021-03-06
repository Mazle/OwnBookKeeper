package com.example.user.ownbookkeeper.Model.DataModel;



import com.example.user.ownbookkeeper.Model.DAO.DriverDao;

import java.util.GregorianCalendar;

/**
 * Created by Palibin
 * Объект расходов
 */

public class Expense {
    private Decreasable source; //объект списания средств
    private Usage usage; //Назначение траты
    private long cost; //Стоимость траты
    private GregorianCalendar payDate; //Дата совершение платежа
    private String id;
    private static long count = 0;

    public Expense(Decreasable source, long cost, GregorianCalendar Date , Usage usage) {
        this.source = source;
        this.cost = cost;
        this.payDate=Date;
        this.usage = usage;
        this.id = generateid();
        count++;
        DriverDao.insertRecordInJournal(
                new JournalRecord(cost,usage.getName(),
                        /*В поле AdditionalSettings попадает наименование расхода. Нужно для
                        дальнейшего добавления категории долгов в приложение*/
                        source.getName(),
                        id)
        );
        DriverDao.decreaseFreeCashOfBallance(cost);
        source.decrease(cost);
    }
public String getId() {
        return id;
    }

    private String generateid(){
        return Long.toString(count+1);
    }
}
