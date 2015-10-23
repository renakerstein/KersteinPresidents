package kerstein.presidents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PresidentViewHolder extends RecyclerView.ViewHolder{

    private TextView name;

    //itemView is president list item text view
    public PresidentViewHolder(View itemView) {
        super(itemView);
        name=(TextView) itemView.findViewById(R.id.name);
    }

    //set the data in the text view
    public void bind(President president){
        name.setText(president.getPresident());
    }
}
