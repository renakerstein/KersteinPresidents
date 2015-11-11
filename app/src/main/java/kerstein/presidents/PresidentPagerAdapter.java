package kerstein.presidents;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {

    private President[] presidents;
    private int[]photos;
    private Drawable drawable;

    public PresidentPagerAdapter(President[] presidents, int[]photos) {
        this.presidents=presidents;
        this.photos=photos;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater=LayoutInflater.from(container.getContext());
        View view= inflater.inflate(R.layout.president_pager_item, null);

        ImageView image= (ImageView) view.findViewById(R.id.image);
        image.setImageResource(photos[position]);
        TextView name= (TextView)view.findViewById(R.id.name);
        TextView number= (TextView)view.findViewById(R.id.number);
        TextView year= (TextView)view.findViewById(R.id.Year);
        TextView office= (TextView)view.findViewById(R.id.Office);
        TextView party= (TextView)view.findViewById(R.id.party);

        President president= presidents[position];

        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));
        if(president.getDeath_year()==null)
        {
            year.setText(String.valueOf(president.getBirth_year()) +" - null");
        }
        else{
            year.setText(String.valueOf(president.getBirth_year()) +" - "+String.valueOf(president.getDeath_year()));
        }
        office.setText(president.getTook_office()+" - "+president.getLeft_office());
        party.setText(president.getParty());

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
