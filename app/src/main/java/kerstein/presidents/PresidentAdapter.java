package kerstein.presidents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PresidentAdapter
        extends RecyclerView.Adapter<PresidentViewHolder>{

    private President[]presidents;

    //pass it through the constructor if need something from another class
    public PresidentAdapter(President[]presidents){
        this.presidents=presidents;
    }
    @Override
    //creates view holder and the views
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.president_list_item,parent,false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    //set the actual data
    public void onBindViewHolder(final PresidentViewHolder holder, int position) {
    holder.bind(presidents[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Context context= holder.itemView.getContext();
                Intent intent=new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
