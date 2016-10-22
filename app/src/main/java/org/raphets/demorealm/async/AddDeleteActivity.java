package org.raphets.demorealm.async;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.raphets.demorealm.R;
import org.raphets.demorealm.activity.BaseActivity;
import org.raphets.demorealm.adapter.AsyncCatAdapter;
import org.raphets.demorealm.bean.Cat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddDeleteActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<Cat> mCats=new ArrayList<>();
    private String[] letters=new String[]{"A","B","C","D","E","F","G","H","I","J","K","M","N","U","X","Y","Z"};
    private String[] letters1=new String[]{"a","c","u","p","q","y"};
    private AsyncCatAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_delete;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar,"异步增、删");
        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mAdapter=new AsyncCatAdapter(this,mCats,R.layout.item_dog);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i=0;i<15;i++){
            Cat cat=new Cat();
            String name=letters[i]+letters1[i%5]+letters1[i%3];
            cat.setName(name);
            cat.setAge(i%4);
            cat.setId("10"+i);
            mCats.add(cat);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.CancelTask();
    }
}
