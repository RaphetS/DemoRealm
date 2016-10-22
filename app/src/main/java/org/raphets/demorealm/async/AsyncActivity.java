package org.raphets.demorealm.async;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.raphets.demorealm.R;
import org.raphets.demorealm.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AsyncActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_async;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar,"异步操作");
    }

    @OnClick({R.id.btn_add_delete,R.id.btn_update_query})
    void onClick(View view){
        switch (view.getId()){
            case R.id.btn_add_delete:
                startActivity(new Intent(AsyncActivity.this,AddDeleteActivity.class));
                break;
            case R.id.btn_update_query:
                startActivity(new Intent(AsyncActivity.this,AsyncQueryActivity.class));

                break;
            default:
                break;

        }

    }
}
