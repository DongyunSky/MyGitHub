package fun.chaoxi.testweixinapi;

import android.os.Bundle;
import android.util.Log;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String WX_APP_ID = "wx855341fea96c1b84";
    private IWXAPI iwxapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iwxapi = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);
        iwxapi.registerApp(WX_APP_ID);

        WXWebpageObject webpageObject = new WXWebpageObject();
        webpageObject.webpageUrl = "http://www.baidu.com";
        WXMediaMessage mWxMediaMessage = new WXMediaMessage(webpageObject);
        mWxMediaMessage.title = "title";
        mWxMediaMessage.description = "描述";
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());//transaction字段用于唯一标识一个请求
        req.message = mWxMediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneSession;
        Log.d("aaa","发送");
        iwxapi.sendReq(req);

    }
}
