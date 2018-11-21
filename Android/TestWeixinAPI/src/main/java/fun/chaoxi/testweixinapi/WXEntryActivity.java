package fun.chaoxi.testweixinapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/** 微信客户端回调activity示例 */
public class WXEntryActivity extends Activity  implements IWXAPIEventHandler {

    private Context context;
    private IWXAPI iwxapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        iwxapi = WXAPIFactory.createWXAPI(this, "wx855341fea96c1b84", true);
        iwxapi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq req) {//发送请求时调用
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        iwxapi.handleIntent(intent, this);//必须调用此句话

    }

    @Override
    public void onResp(BaseResp resp) {
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                //分享成功
                Log.e("aaa", "成功");
                Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                //分享取消
                Log.e("aaa", "错误");
                Toast.makeText(context, "分享取消", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                //分享拒绝
                Log.e("aaa", "分享拒绝");
                Toast.makeText(context, "分享拒绝", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
        }
    }

}