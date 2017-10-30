package com.epam.app.Chief.Dao;

import com.epam.app.Chief.Enums.Taste;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public interface DataDAO {

    public Double getWeightrById(String id);

    public Taste getTasteById(String id);

}
