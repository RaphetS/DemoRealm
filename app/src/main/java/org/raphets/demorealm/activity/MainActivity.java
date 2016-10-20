package org.raphets.demorealm.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import org.raphets.demorealm.R;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar.setTitle("DemoRealm");
        setSupportActionBar(mToolbar);
        
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }



    @OnClick({R.id.btn_add,  R.id.btn_update, R.id.btn_query})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                startActivity(new Intent(MainActivity.this,DogListActivity.class));
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_query:
                startActivity(new Intent(MainActivity.this,QueryActivity.class));
                break;
            default:
                break;
        }
    }
}
