package dkm.gdut.com.textdemo.viewmodule;

import android.app.Activity;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dkm.gdut.com.qmuibottomsheet.QMUIBottomSheet;

/**
 * Created by dkmfromCG on 2017/11/16.
 * function:
 */

public class BottomSheetViewModel implements ViewModel {
    @Override
    public void destroy() {
        data=null;
    }

    public ObservableArrayList<String> data;

    public final QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener listItemClick=
            new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                @Override
                public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                    dialog.dismiss();
                    Toast.makeText(activity, "Item " + (position + 1), Toast.LENGTH_SHORT).show();
                }
            };

    public final void actionA(){
        Toast.makeText(activity, "分享到微信", Toast.LENGTH_SHORT).show();
    }

    public final void actionB(){
        Toast.makeText(activity, "分享到朋友圈", Toast.LENGTH_SHORT).show();
    }

    public final void actionC(){
        Toast.makeText(activity, "分享到微博", Toast.LENGTH_SHORT).show();
    }

    public final void actionD(){
        Toast.makeText(activity, "分享到私信", Toast.LENGTH_SHORT).show();
    }

    public final void actionE(){
        Toast.makeText(activity, "保存到本地", Toast.LENGTH_SHORT).show();
    }

    private Activity activity;
    public BottomSheetViewModel(Activity activity){
        this.activity=activity;

        String[] listItems = new String[]{
                "BottomSheetList",
                "BottomSheetGrid",
        };
        List<String> d = new ArrayList<>();
        Collections.addAll(d, listItems);
        this.data=new ObservableArrayList<>();
        this.data.addAll(d);

    }
}
