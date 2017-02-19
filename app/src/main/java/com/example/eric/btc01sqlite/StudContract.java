package com.example.eric.btc01sqlite;

import android.provider.BaseColumns;

/**
 * Created by Eric on 2017/2/18.
 */

public class StudContract {
    public static class StudInfo implements BaseColumns{
        public final static String TABLE_NAME="studinfo";
        public final static String COLUMN_NAME_AGE="age";
        public final static String COLUMN_NAME_NAME="stuname";
        public final static String COLUMN_NAME_HEIGHT="height";

    }
}
