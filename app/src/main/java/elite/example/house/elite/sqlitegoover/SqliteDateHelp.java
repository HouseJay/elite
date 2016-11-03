package elite.example.house.elite.sqlitegoover;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by House on 2016/10/29.
 */

public class SqliteDateHelp extends SQLiteOpenHelper {
    public static final String TABLENAME = "person";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String CLASS = "class";

    public SqliteDateHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL("create table "+TABLENAME+" ("+NAME +" varchar not null ," +
                AGE+ " integer not null , "+ CLASS+" varcher )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
