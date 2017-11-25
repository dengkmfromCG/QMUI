package dkm.gdut.com.textdemo.viewmodule;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import dkm.gdut.com.qmuigrouplist.QMUICommonListItemView;

/**
 * Created by dkmfromCG on 2017/11/15.
 * function:
 */

public class GroupListViewModule implements ViewModel  {
    private static final String TAG = "GroupListViewModule";

    private AppCompatActivity activity;

    public final CompoundButton.OnCheckedChangeListener itemSwitchListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast.makeText(activity, "checked = " + isChecked, Toast.LENGTH_SHORT).show();
        }
    };

    public final  View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v instanceof QMUICommonListItemView) {
                CharSequence text = ((QMUICommonListItemView) v).getText();
                Toast.makeText(activity, text + " is Clicked", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public GroupListViewModule(AppCompatActivity activity){
        this.activity=activity;
    }

    @Override
    public void destroy() {

    }




}
