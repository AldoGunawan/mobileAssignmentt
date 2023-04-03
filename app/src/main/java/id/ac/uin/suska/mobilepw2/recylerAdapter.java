package id.ac.uin.suska.mobilepw2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recylerAdapter extends RecyclerView.Adapter<recylerAdapter.MyViewHolder> {

    private final ArrayList<activity2> userList;
    private RecylerViewClickListener listener;
    public recylerAdapter(ArrayList<activity2> userList, RecylerViewClickListener listener){
            this.userList = userList;
            this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTXT;

        public MyViewHolder(final View v){
            super(v);
            nameTXT = v.findViewById(R.id.textView4);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

    @Override
    public recylerAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( recylerAdapter.MyViewHolder holder, int position) {
    String name = userList.get(position).getUsername();
    holder.nameTXT.setText(name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface RecylerViewClickListener{
        void onClick(View v, int position);
    }
}
