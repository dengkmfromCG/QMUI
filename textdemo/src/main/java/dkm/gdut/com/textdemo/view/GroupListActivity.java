package dkm.gdut.com.textdemo.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import dkm.gdut.com.qmuigrouplist.QMUICommonListItemView;
import dkm.gdut.com.qmuigrouplist.QMUIGroupListView;
import dkm.gdut.com.textdemo.R;
import dkm.gdut.com.textdemo.databinding.ActivityGroupListBinding;
import dkm.gdut.com.textdemo.viewmodule.GroupListViewModule;

public class GroupListActivity extends AppCompatActivity {

    private ActivityGroupListBinding binding;
    private GroupListViewModule viewModule;
    private QMUIGroupListView mGroupListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_group_list);
        viewModule=new GroupListViewModule(this);
        binding.setViewModel(viewModule);
        mGroupListView=binding.groupListView;
        initGroupListView();
    }

    private void initGroupListView() {
        QMUICommonListItemView normalItem = mGroupListView.createItemView("Item 1");
        normalItem.setOrientation(QMUICommonListItemView.VERTICAL);

        QMUICommonListItemView itemWithDetail = mGroupListView.createItemView("Item 2");
        itemWithDetail.setDetailText("在右方的详细信息");

        QMUICommonListItemView itemWithDetailBelow = mGroupListView.createItemView("Item 3");
        itemWithDetailBelow.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithDetailBelow.setDetailText("在标题下方的详细信息");

        QMUICommonListItemView itemWithChevron = mGroupListView.createItemView("Item 4");
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView itemWithSwitch = mGroupListView.createItemView("Item 5");
        itemWithSwitch.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
        itemWithSwitch.getSwitch().setOnCheckedChangeListener(viewModule.itemSwitchListener);
/*
        QMUICommonListItemView itemWithCustom = mGroupListView.createItemView("Item 6");
        itemWithCustom.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CUSTOM);
        QMUILoadingView loadingView = new QMUILoadingView(getActivity());
        itemWithCustom.addAccessoryCustomView(loadingView);*/



        QMUIGroupListView.newSection(this)
                .setTitle("Section 1: 默认提供的样式")
                .setDescription("Section 1 的描述")
                .addItemView(normalItem, viewModule.onClickListener)
                .addItemView(itemWithDetail, viewModule.onClickListener)
                .addItemView(itemWithDetailBelow, viewModule.onClickListener)
                .addItemView(itemWithChevron, viewModule.onClickListener)
                .addItemView(itemWithSwitch, viewModule.onClickListener)
                .addTo(mGroupListView);

     /*   QMUIGroupListView.newSection(mContext)
                .setTitle("Section 2: 自定义右侧 View")
                .addItemView(itemWithCustom, onClickListener)
                .addTo(mGroupListView);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModule.destroy();
    }
}
