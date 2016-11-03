package elite.example.house.elite.sqlitegoover;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static elite.example.house.elite.sqlitegoover.SqliteDateHelp.AGE;
import static elite.example.house.elite.sqlitegoover.SqliteDateHelp.CLASS;
import static elite.example.house.elite.sqlitegoover.SqliteDateHelp.NAME;
import static elite.example.house.elite.sqlitegoover.SqliteDateHelp.TABLENAME;

/**
 * Created by House on 2016/10/29.
 */

public class SqliteRibHand {
    private Context context;
    public SqliteRibHand(Context context){
        this.context= context;
    }
    private SQLiteDatabase database;
    public void getSqlite(){
        SqliteDateHelp help = new SqliteDateHelp(context,"person",null,1);
        database  = help.getReadableDatabase();
    }
    public void add(String name ,int age,String pclass){
        database.execSQL("insert into "+ TABLENAME +" ("+NAME +","+
                AGE+","+CLASS+") values('"+name+"',"+age+",'"+pclass+"')");
    }

    public void delete(String name ){
        database.execSQL("delete from "+TABLENAME +" where "+NAME+"='"+name+"'");
    }
    public void delete(int age ){
        database.execSQL("delete from "+TABLENAME +" where "+AGE+"="+age);
    }
    public void delete2(String pclass ){
        database.execSQL("delete from "+TABLENAME +" where "+CLASS+"="+pclass);
    }
    public void update(String name,String oldname){
        database.execSQL("update "+TABLENAME+" set "+NAME+"='"+name+"' where "+
                NAME+"='"+oldname+"'");
    }
    public void update(int age,int oldage){
        database.execSQL("update "+TABLENAME+" set "+AGE+"="+age+"where "+
                AGE+"="+oldage);
    }
    public void update2(String pclass,String oldPclass){
        database.execSQL("update "+TABLENAME+" set "+CLASS+"="+pclass+"where "+
                CLASS+"="+oldPclass);
    }
    public Cursor query(){
        return database.rawQuery("select * from " + TABLENAME, null);
    }


}
