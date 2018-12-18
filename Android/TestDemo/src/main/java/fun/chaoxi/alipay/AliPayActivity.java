package fun.chaoxi.alipay;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import fun.chaoxi.testdemo.R;

/**
 * Create by Wing Gao on 2018/11/6 18:32
 */
public class AliPayActivity extends Activity {
    @butterknife.BindView(R.id.qr_code_web_view)
    WebView qrCodeWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alipay_main);
        butterknife.ButterKnife.bind(this);

        qrCodeWebView.loadData("<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=GBK&method=alipay.trade.page.pay&sign=qoRbNRIQxLkAbYYnkI6QJRjLaBten5WR%2F%2Ff3hKgkPnOGvxGLLjsmE4Y5SiPdNuhE%2FBCMrKk2mfsQfFawZRs%2BSj6y46mlzLVQntKLx2YsrFi0nwKVNWCl38LT%2B4mA%2FIL%2BK3b%2F5OVY7wQnRlmjTAKTlCGulNFQsP%2BSIwGSwzfkSx399ld6yOrQ6EZkc%2FgbNI0A5YF%2BH9BHtC5t%2BW%2B7ZK0dvyInfuJaH4MD97LOfIvZduRLWYVxHfq%2B9iSIzlLypSBrErz40kqSo1DuCEh586lgG%2BQ7pqTtax2eeq4NK6m3%2FmgpgFpyGqxkh7WtXDqcwukDeM2YPGftB7AeGygNW%2BkOOw%3D%3D&return_url=http%3A%2F%2Fdomain.com%2FCallBack%2Freturn_url.jsp&notify_url=http%3A%2F%2Fdomain.com%2FCallBack%2Fnotify_url.jsp&version=1.0&app_id=2018082061013959&sign_type=RSA2&timestamp=2018-11-06+15%3A40%3A43&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n" +
                "<input type=\"hidden\" name=\"biz_content\" value=\"{    &quot;qr_pay_mode&quot;:&quot;4&quot;,    &quot;qrcode_width&quot;:&quot;400&quot;,    &quot;out_trade_no&quot;:&quot;20181104010101003&quot;,    &quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;,    &quot;total_amount&quot;:0.01,    &quot;subject&quot;:&quot;Iphone6 16G&quot;,    &quot;body&quot;:&quot;Iphone6 16G&quot;,    &quot;extend_params&quot;:{    &quot;sys_service_provider_id&quot;:&quot;2088231351705904&quot;    }  }\">\n" +
                "<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n" +
                "</form>\n" +
                "<script>document.forms[0].submit();</script>", "text/html", "UTF-8");

//        qrCodeWebView.loadUrl("https://blog.csdn.net/lowprofile_coding/article/details/77928614");
        qrCodeWebView.getSettings().setJavaScriptEnabled(true);

        qrCodeWebView.getSettings().setSavePassword(false);
        qrCodeWebView.setVerticalScrollBarEnabled(false);
        qrCodeWebView.setHorizontalScrollBarEnabled(false);
        // 设置可以支持缩放
        qrCodeWebView.getSettings().setSupportZoom(true);
        // 扩大比例的缩放
        qrCodeWebView.getSettings().setUseWideViewPort(true);
        // 自适应屏幕
        qrCodeWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        qrCodeWebView.getSettings().setLoadWithOverviewMode(true);

        qrCodeWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }
}
