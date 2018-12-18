package fun.chaoxi.toutiao.widget;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

import com.afollestad.materialdialogs.color.CircleView;

import fun.chaoxi.toutiao.R;
import fun.chaoxi.toutiao.util.SettingUtils;

/**
 * @author Wing Gao
 * @date 2018/12/17 13:52
 * @description
 */
public class IconPreference extends Preference {

    private CircleView circleImageView;

    public IconPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.item_icon_preference_preview);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        int color = SettingUtils.getInstance().getColor();
        circleImageView = view.findViewById(R.id.iv_preview);
        circleImageView.setBackgroundColor(color);
    }

    public void setView() {
        int color = SettingUtils.getInstance().getColor();
        circleImageView.setBackgroundColor(color);
    }
}
