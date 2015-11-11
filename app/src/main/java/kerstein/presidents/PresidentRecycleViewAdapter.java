package kerstein.presidents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PresidentRecycleViewAdapter
        extends RecyclerView.Adapter<PresidentViewHolder>{

    private President[]presidents;
    private int[]photos;

    //pass it through the constructor if need something from another class
    public PresidentRecycleViewAdapter(President[] presidents, int[]photos){
        this.presidents=presidents;
        this.photos=photos;
    }
    @Override
    //creates view holder and the views
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.president_list_item,parent,false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    //set the actual data
    public void onBindViewHolder(final PresidentViewHolder holder, final int position) {
    holder.bind(presidents[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Context context= holder.itemView.getContext();
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("PRESIDENTS", presidents);
                intent.putExtra("POSITION", position);
                intent.putExtra("PHOTOS", photos);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
