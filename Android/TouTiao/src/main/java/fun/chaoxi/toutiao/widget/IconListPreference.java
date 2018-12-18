package fun.chaoxi.toutiao.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import fun.chaoxi.toutiao.R;
import fun.chaoxi.toutiao.module.base.BaseActivity;

/**
 * @author Wing Gao
 * @date 2018/12/17 14:03
 * @description
 */
public class IconListPreference extends ListPreference {

    private List<Drawable> drawableList = new ArrayList<>();

    public IconListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.IconListPreference, 0, 0);
        CharSequence[] drawables;
        try {
            drawables = typedArray.getTextArray(R.styleable.IconListPreference_iconsDrawables);
        } finally {
            typedArray.recycle();
        }
        for (CharSequence drawable : drawables) {
            int id = context.getResources().getIdentifier(drawable.toString(), "mipmap", context.getPackageName());
            Drawable draw = context.getResources().getDrawable(id);
            drawableList.add(draw);
        }
        setWidgetLayoutResource(R.layout.item_icon_listpreference_preview);
    }

    private ListAdapter createListAdapter() {
        final String selectedValue = getValue();
        int indexOfValue = findIndexOfValue(selectedValue);
        return new IconArrayAdapter(getContext(), R.layout.item_icon_listpreference,
                getEntries(), drawableList, indexOfValue);
    }

    private class IconArrayAdapter extends ArrayAdapter<CharSequence> {

        private List<Drawable> list = null;
        private int selectedIndex = 0;

        IconArrayAdapter(Context context, int textViewResourceId,
                         CharSequence[] objects, List<Drawable> imageDrawables,
                         int selectedIndex) {
            super(context, textViewResourceId, objects);
            this.selectedIndex = selectedIndex;
            this.list = imageDrawables;
        }

        /*@Override
        protected void onBindView(View view) {
            super.onBindView(view);

            String selectedValue = getValue();
            int selectedIndex = findIndexOfValue(selectedValue);

            Drawable drawable = drawableList.get(selectedIndex);
            ((ImageView) view.findViewById(R.id.iv_preview)).setImageDrawable(drawable);
        }

        @Override
        protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
            builder.setAdapter(createListAdapter(), this);
            builder.setNegativeButton(getContext().getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
            super.onPrepareDialogBuilder(builder);
        }*/

        @NonNull
        @Override
        @SuppressLint("ViewHolder")
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = ((BaseActivity) getContext()).getLayoutInflater();
            View view = inflater.inflate(R.layout.item_icon_listpreference, parent, false);

            CheckedTextView textView = view.findViewById(R.id.label);
            textView.setText(getItem(position));
            textView.setChecked(position == selectedIndex);

            ImageView imageView = view.findViewById(R.id.icon);
            imageView.setImageDrawable(list.get(position));
            return view;
        }
    }
}
