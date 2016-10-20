package org.raphets.demorealm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.raphets.demorealm.R;
import org.raphets.demorealm.adapter.LikeDogAdapter;
import org.raphets.demorealm.bean.Dog;
import org.raphets.demorealm.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 条件查询
 */
public class ConditionQueryActivity extends BaseActivity {
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    private RealmHelper mRealmHelper;
    private List<Dog> mDogs=new ArrayList<>();
    private LikeDogAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_condition_query;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar, "条件查询");
        initData();
    }



    @OnClick({R.id.btn_query_id, R.id.btn_query_age})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query_id:
                queryById();
                break;
            case R.id.btn_query_age:
                queryByAge();
                break;
            default:
                break;
        }

    }
    private void initData() {
        mRealmHelper=new RealmHelper(this);
        mAdapter=new LikeDogAdapter(this,mDogs,R.layout.item_dog);

        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void queryById() {
        String id=etId.getText().toString().trim();
        if (TextUtils.isEmpty(id)){
            Toast.makeText(ConditionQueryActivity.this,"请输入Id",Toast.LENGTH_SHORT).show();
        }
        


    }

    private void queryByAge() {

    }

}
