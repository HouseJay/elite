package elite.example.house.elite.sqlitegoover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import elite.example.house.elite.R;
import elite.example.house.elite.databinding.ActivitySqliteBinding;

/**
 * Created by House on 2016/10/29.
 */

public class SqliteDateAcitivty extends AppCompatActivity {
    ActivitySqliteBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_sqlite);
        binding.setOnClick(new OnClick());
    }


    public class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.insert:

                    break;
                case R.id.delete:

                    break;
                case R.id.update:

                    break;
                case R.id.select:

                    break;
            }
        }
    }
}
