package fun.chaoxi.wing.module.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import fun.chaoxi.wing.R;
import fun.chaoxi.wing.module.LabContract;
import fun.chaoxi.wing.module.lab.GridViewActivity;
import fun.chaoxi.wing.module.lab.QueryMobilePhoneNumberAttributionActivity;
import fun.chaoxi.wing.module.lab.RecyclerGridActivity;

/**
 * @author Wing Gao
 * @date 2018/12/18 15:56
 * @description
 */
public class LabFragment extends Fragment implements LabContract.View, View.OnClickListener {

    View labView;

    private LabContract.Presenter labPresenter;

    public static LabFragment getInstance() {
        return new LabFragment();
    }

    @Override
    public void setPresenter(LabContract.Presenter presenter) {
        this.labPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        labView = inflater.inflate(R.layout.home_fragment_lab_tab, container, false);
        initView();
        return labView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_grid_view_btn :
                startActivity(new Intent(getActivity(), GridViewActivity.class));
                break;
            case R.id.test_recycler_grid_btn :
                startActivity(new Intent(getActivity(), RecyclerGridActivity.class));
                break;
            case R.id.test_query_mobile_phone_number_attribution :
                startActivity(new Intent(getActivity(), QueryMobilePhoneNumberAttributionActivity.class));
                break;
            default:break;
        }
    }

    private void initView() {
        ((Button) labView.findViewById(R.id.test_grid_view_btn)).setOnClickListener(this);
        ((Button) labView.findViewById(R.id.test_recycler_grid_btn)).setOnClickListener(this);
        ((Button) labView.findViewById(R.id.test_query_mobile_phone_number_attribution)).setOnClickListener(this);
    }
}
