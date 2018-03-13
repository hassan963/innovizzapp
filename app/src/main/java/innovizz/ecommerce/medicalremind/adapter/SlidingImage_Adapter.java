package innovizz.ecommerce.medicalremind.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import innovizz.ecommerce.medicalremind.R;

/**
 * Created by YTC on 3/7/2018.
 */

public class SlidingImage_Adapter extends PagerAdapter {

    private ArrayList<Integer> IMAGES;
    private LayoutInflater inflater;
    private Context context;

    public SlidingImage_Adapter(Context context,ArrayList<Integer> IMAGES) {
        this.context = context;
        this.IMAGES = IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, container, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);


        //imageView.setImageResource(IMAGES.get(position));


//        Glide.clear(imageView);
//        Glide.with(context).load(IMAGES.get(position)).placeholder(R.drawable.p).into(imageView);

        container.addView(imageLayout, 0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("%%%%%%%   ",position+"");
            }
        });

        return imageLayout;
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        //super.restoreState(state, loader);
    }


}
