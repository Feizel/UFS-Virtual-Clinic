package wolvesofwallstreet.UFS.ufsclinic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.slider_1,R.drawable.slider_2,R.drawable.slider_3, R.drawable.slider_4};
    private Integer [] texts = {R.string.sliderText1, R.string.sliderText2, R.string.sliderText3, R.string.sliderText4};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_carousel_layout, null);

        TextView txtCaraousel = (TextView) view.findViewById(R.id.txtCarousel);
        ImageView imgCarousel = (ImageView) view.findViewById(R.id.imgCarousel);

        imgCarousel.setImageResource(images[position]);
        txtCaraousel.setText(texts[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}