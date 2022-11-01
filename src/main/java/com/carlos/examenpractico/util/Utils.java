package com.carlos.examenpractico.util;

import java.util.Date;

public class Utils {

    public static boolean checkIfDateIsPrior(Date startDate, Date endDate){
        return startDate.before(endDate);
    }
}
