package dkm.gdut.com.textdemo.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dkm.gdut.com.qmuibottomsheet.QMUIBottomSheet;
import dkm.gdut.com.textdemo.R;
import dkm.gdut.com.textdemo.databinding.ActivityBottomSheetBinding;
import dkm.gdut.com.textdemo.viewmodule.BottomSheetViewModel;

import static dkm.gdut.com.textdemo.R.id.listview;

public class BottomSheetActivity extends AppCompatActivity {

    ListView mListView;
    Context mContext;
    private ActivityBottomSheetBinding binding;
    private BottomSheetViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_bottom_sheet);
        model=new BottomSheetViewModel(this);
        binding.setViewModel(model);
        mListView= binding.listview;
        mContext=this;
        initListView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        model.destroy();
    }

    private void initListView() {

        mListView.setAdapter(new ArrayAdapter<>(mContext,android.R.layout.simple_list_item_1, model.data));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showSimpleBottomSheetList();
                        break;
                    case 1:
                        showSimpleBottomSheetGrid();
                        break;
                }
            }
        });
    }


    // ================================ 生成不同类型的BottomSheet
    private void showSimpleBottomSheetList() {
        new QMUIBottomSheet.BottomListSheetBuilder(mContext)
                .addItem("Item 1")
                .addItem("Item 2")
                .addItem("Item 3")
                .setOnSheetItemClickListener(model.listItemClick)
                .build()
                .show();
    }

    private void showSimpleBottomSheetGrid() {
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        final int TAG_SHARE_WEIBO = 2;
        final int TAG_SHARE_CHAT = 3;
        final int TAG_SHARE_LOCAL = 4;
        QMUIBottomSheet.BottomGridSheetBuilder builder = new QMUIBottomSheet.BottomGridSheetBuilder(mContext);
        builder.addItem(R.mipmap.ic_launcher_round, "分享到微信", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher_round, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher_round, "分享到微博", TAG_SHARE_WEIBO, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher_round, "分享到私信", TAG_SHARE_CHAT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher_round, "保存到本地", TAG_SHARE_LOCAL, QMUIBottomSheet.BottomGridSheetBuilder.SECOND_LINE)
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView) {
                        dialog.dismiss();
                        int tag = (int) itemView.getTag();
                        switch (tag) {
                            case TAG_SHARE_WECHAT_FRIEND:
                                model.actionA();
                                break;
                            case TAG_SHARE_WECHAT_MOMENT:
                                model.actionB();
                                break;
                            case TAG_SHARE_WEIBO:
                                model.actionC();
                                break;
                            case TAG_SHARE_CHAT:
                                model.actionD();
                                break;
                            case TAG_SHARE_LOCAL:
                                model.actionE();
                                break;
                        }
                    }
                }).build().show();
    }
}
