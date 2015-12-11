package kerstein.presidents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

//putting all this logic from MainActivity into a fragment and out of the activity
public class PresidentListFragment extends Fragment {
    //fragment is a lot like an activity

    private RecyclerView recyclerView;
    private int []photos;

    @Nullable //check to see if return result is null
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_president_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView=(RecyclerView) view.findViewById(R.id.list);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this.getActivity());
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
}
