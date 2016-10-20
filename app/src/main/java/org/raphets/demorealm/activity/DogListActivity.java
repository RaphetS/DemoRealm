package org.raphets.demorealm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.raphets.demorealm.R;
import org.raphets.demorealm.adapter.DogAdapter;
import org.raphets.demorealm.bean.Dog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DogListActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    private List<Dog> mDogs = new ArrayList<>();
    private DogAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbar(mToolbar, "查询");

        initData();

        initRecyclerView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add;
    }


    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new DogAdapter(this, mDogs, R.layout.item_dog);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void initData() {
        Dog dog1 = new Dog();
        dog1.setName("John");
        dog1.setAge(1);
        dog1.setId("001");

        Dog dog2 = new Dog();
        dog2.setName("Kate");
        dog2.setAge(2);
        dog2.setId("002");

        Dog dog3 = new Dog();
        dog3.setName("Amy");
        dog3.setAge(2);
        dog3.setId("003");

        Dog dog4 = new Dog();
        dog4.setName("Kim");
        dog4.setAge(3);
        dog4.setId("004");

        Dog dog5 = new Dog();
        dog5.setName("Mary");
        dog5.setAge(1);
        dog5.setId("005");


        Dog dog6 = new Dog();
        dog6.setName("Michael");
        dog6.setAge(2);
        dog6.setId("006");

        Dog dog7 = new Dog();
        dog7.setName("James");
        dog7.setAge(3);
        dog7.setId("007");

        Dog dog8 = new Dog();
        dog8.setName("Paul");
        dog8.setAge(1);
        dog8.setId("008");

        Dog dog9 = new Dog();
        dog9.setName("Lily");
        dog9.setAge(1);
        dog9.setId("009");

        mDogs.add(dog1);
        mDogs.add(dog2);
        mDogs.add(dog3);
        mDogs.add(dog4);
        mDogs.add(dog5);
        mDogs.add(dog6);
        mDogs.add(dog7);
        mDogs.add(dog8);
        mDogs.add(dog9);
    }
}
