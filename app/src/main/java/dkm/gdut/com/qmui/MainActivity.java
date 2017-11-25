package dkm.gdut.com.qmui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import dkm.gdut.com.qmuigrouplist.QMUICommonListItemView;
import dkm.gdut.com.qmuigrouplist.QMUIGroupListView;

public class MainActivity extends AppCompatActivity {

    QMUIGroupListView mGroupListView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGroupListView= (QMUIGroupListView) findViewById(R.id.groupListView);
        mContext=this;
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
        itemWithSwitch.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(mContext, "checked = " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
/*
        QMUICommonListItemView itemWithCustom = mGroupListView.createItemView("Item 6");
        itemWithCustom.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CUSTOM);
        QMUILoadingView loadingView = new QMUILoadingView(getActivity());
        itemWithCustom.addAccessoryCustomView(loadingView);*/

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof QMUICommonListItemView) {
                    CharSequence text = ((QMUICommonListItemView) v).getText();
                    Toast.makeText(mContext, text + " is Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        };

        QMUIGroupListView.newSection(mContext)
                .setTitle("Section 1: 默认提供的样式")
                .setDescription("Section 1 的描述")
                .addItemView(normalItem, onClickListener)
                .addItemView(itemWithDetail, onClickListener)
                .addItemView(itemWithDetailBelow, onClickListener)
                .addItemView(itemWithChevron, onClickListener)
                .addItemView(itemWithSwitch, onClickListener)
                .addTo(mGroupListView);

     /*   QMUIGroupListView.newSection(mContext)
                .setTitle("Section 2: 自定义右侧 View")
                .addItemView(itemWithCustom, onClickListener)
                .addTo(mGroupListView);*/
    }
}
