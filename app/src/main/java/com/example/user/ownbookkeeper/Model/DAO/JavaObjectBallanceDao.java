package com.example.user.ownbookkeeper.Model.DAO;


import com.example.user.ownbookkeeper.Model.TestStorageForDataObjects.Ballance;

/**
 * Created by PalibinFamily on 01.10.2017.
 */

public class JavaObjectBallanceDao extends JavaObjectDaoFactory implements BallanceDao {
    @Override
    public Ballance getBallance() {
        return Ballance.getSingleBallance();
    }
}
