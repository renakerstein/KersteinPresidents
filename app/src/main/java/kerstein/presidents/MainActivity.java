package kerstein.presidents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    int [] photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        photos= new int[]{R.drawable.washington, R.drawable.adams, R.drawable.jefferson, R.drawable.madison, R.drawable.monroe, R.drawable.qadams,
                R.drawable.jackson, R.drawable.vanburen, R.drawable.wharrison, R.drawable.tyler, R.drawable.polk, R.drawable.taylor, R.drawable.fillmore,
                R.drawable.pierce, R.drawable.buchanan, R.drawable.lincoln, R.drawable.johnson, R.drawable.grant, R.drawable.hayes, R.drawable.garfield,
                R.drawable.arthur, R.drawable.cleveland, R.drawable.bharrison,  R.drawable.cleveland,R.drawable.mckinley, R.drawable.troosevelt, R.drawable.taft, R.drawable.wilson,
                R.drawable.harding, R.drawable.coolidge, R.drawable.hoover, R.drawable.fdroosevelt, R.drawable.truman, R.drawable.eisenhower, R.drawable.kennedy,
                R.drawable.johnson, R.drawable.nixon, R.drawable.ford, R.drawable.carter, R.drawable.reagan, R.drawable.bush, R.drawable.clinton,
                R.drawable.gwbush, R.drawable.obama};

        InputStream in=getResources().openRawResource(R.raw.presidents);

      President[] presidents= gson.fromJson(new InputStreamReader(in), President[].class);

        PresidentRecycleViewAdapter adapter=new PresidentRecycleViewAdapter(presidents, photos);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
