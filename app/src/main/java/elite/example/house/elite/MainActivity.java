package elite.example.house.elite;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import elite.example.house.elite.databinding.ActivityMainBinding;
import elite.example.house.elite.sqlitegoover.SqliteDateHelp;
import elite.example.house.elite.sqlitegoover.SqliteRibHand;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding MBinding;
    SqliteRibHand ribHand = new SqliteRibHand(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setSupportActionBar(MBinding.toolbar);
        ribHand.getSqlite();
        myListener();

    }
    int i = 1;
    private void myListener() {
        OnListener onListener = new OnListener();

        MBinding.myContentMain.butAdd.setOnClickListener(onListener);
        MBinding.myContentMain.butDelete.setOnClickListener(onListener);
        MBinding.myContentMain.butUpdate.setOnClickListener(onListener);
        MBinding.myContentMain.butQuery.setOnClickListener(onListener);

        MBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void setTextShow(String string){
        MBinding.myContentMain.tvShow.setText(string);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class OnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.but_add:
                    ribHand.add("A"+i,18+i,"Android八班");
                    Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    i++;
                    break;
                case R.id.but_delete:
                    i--;
                    ribHand.delete("A"+i);
                    Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.but_update:
                    ribHand.update("B"+i,"A"+i);
                    Toast.makeText(MainActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.but_query:
                    Cursor query = ribHand.query();
                    if(query != null){
                        StringBuilder builder = new StringBuilder();
                        query.moveToFirst();
                        while (query.moveToNext()){
                            int index = query.getColumnIndex(SqliteDateHelp.NAME);
                            builder.append(query.getString(index));
                        }
                        query.close();
                        setTextShow(builder.toString());
                    }
                    break;
            }
        }
    }
}
