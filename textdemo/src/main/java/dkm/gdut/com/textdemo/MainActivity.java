package dkm.gdut.com.textdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dkm.gdut.com.textdemo.view.BottomSheetActivity;
import dkm.gdut.com.textdemo.view.GroupListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnGroupList;
    Button btnDialog;
    Button btnBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGroupList= (Button) findViewById(R.id.btn_group_list);
        btnDialog= (Button) findViewById(R.id.btn_dialog);
        btnBottomSheet= (Button) findViewById(R.id.btn_bottom_sheet);
        btnGroupList.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
        btnBottomSheet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_group_list:
                startActivity(new Intent(MainActivity.this,GroupListActivity.class));
                break;
            case R.id.btn_dialog:
                startActivity(new Intent(MainActivity.this,DialogActivity.class));
                break;
            case R.id.btn_bottom_sheet:
                startActivity(new Intent(MainActivity.this,BottomSheetActivity.class));
                break;
        }
    }
}
