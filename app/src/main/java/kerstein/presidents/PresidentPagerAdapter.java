package kerstein.presidents;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {

    private President[] presidents;

    public PresidentPagerAdapter(President[] presidents) {
    this.presidents=presidents;
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
        TextView name= (TextView)view.findViewById(R.id.name);
        TextView number= (TextView)view.findViewById(R.id.number);
        TextView birthYear= (TextView)view.findViewById(R.id.birthYear);
        TextView deathYear= (TextView)view.findViewById(R.id.deathYear);
        TextView tookOffice= (TextView)view.findViewById(R.id.tookOffice);
        TextView leftOffice= (TextView)view.findViewById(R.id.leftOffice);
        TextView party= (TextView)view.findViewById(R.id.party);

        President president= presidents[position];
        name.setText(president.getPresident());
        number.setText("Number: "+String.valueOf(president.getNumber()));
        birthYear.setText("Birth Year: "+String.valueOf(president.getBirth_year()));
        deathYear.setText("Death Year: "+String.valueOf(president.getDeath_year()));
        tookOffice.setText("Took Office: "+president.getTook_office());
        leftOffice.setText("Left Office: "+president.getLeft_office());
        party.setText("Party: "+president.getParty());
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
