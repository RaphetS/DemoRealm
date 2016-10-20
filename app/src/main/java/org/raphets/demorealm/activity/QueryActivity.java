package org.raphets.demorealm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.raphets.demorealm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QueryActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar,"查询");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_query;
    }

    @OnClick({R.id.btn_query, R.id.btn_condition_query})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query:
                startActivity(new Intent(QueryActivity.this,AllDogActivity.class));
                break;
            case R.id.btn_condition_query:
                break;
            default:
                break;

        }

    }
}
