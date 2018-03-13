package innovizz.ecommerce.medicalremind.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import innovizz.ecommerce.medicalremind.R;

/**
 * Created by no0ne on 3/10/18.
 */

public class TestNameSliderAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    private String[] mTestNames = {"TestName 1", "TestName 2", "TestName 3"};

    public TestNameSliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mTestNames.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.test_name_slider, null);

        TextView testNameTextView = view.findViewById(R.id.text_view_test_name);
        testNameTextView.setText(mTestNames[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
