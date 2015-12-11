package kerstein.presidents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail); //fragment gets created when we call setContentView

        PresidentDetailFragment fragment = (PresidentDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);


        President presidents[] = (President[]) getIntent().getSerializableExtra("PRESIDENTS");
        int photos[] = (int[]) getIntent().getSerializableExtra("PHOTOS");
        PresidentPagerAdapter adapter =
                new PresidentPagerAdapter(presidents, photos);
        int position = getIntent().getIntExtra("POSITION", 0);

        fragment.showPresidentDetail(presidents, position, photos);

       
    }
}
