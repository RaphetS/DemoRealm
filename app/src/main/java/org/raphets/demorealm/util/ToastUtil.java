package org.raphets.demorealm.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by RaphetS on 2016/10/21.
 */

public class ToastUtil {
    private  static Toast mToast;

    public static void showShortToast(Context context,String msg){
        if (mToast==null){
            mToast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
