package fun.chaoxi.toutiao.module.setting;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import fun.chaoxi.toutiao.R;
import fun.chaoxi.toutiao.widget.IconPreference;

/**
 * @author Wing Gao
 * @date 2018/12/14 9:14
 * @description
 */
public class GeneralPreferenceFragment extends PreferenceFragment {
    private IconPreference colorPreview;
    private SettingActivity context;

    public static GeneralPreferenceFragment newInstance() {
        return new GeneralPreferenceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
        context = (SettingActivity) getActivity();
        setHasOptionsMenu(true);
        setText();
    }

    private void setText() {

    }

}
