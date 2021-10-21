package com.example.examen_02_t3_videoj_real.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_02_t3_videoj_real.MapActivity;
import com.example.examen_02_t3_videoj_real.R;
import com.example.examen_02_t3_videoj_real.entities.Repository;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.NameViewHolder>{


    private List<Repository> data;

    public RepositoryAdapter(List<Repository> data){
        this.data = data;
    }



    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name,parent,false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position) {

        TextView tvId = holder.itemView.findViewById(R.id.tvId);
        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        Repository repo = data.get(position);
        tvId.setText(String.valueOf(repo.getId()));
        tvName.setText(repo.getName());

        //Button btnCall = holder.itemView.findViewById(R.id.btnCall);
       // btnCall.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
       //         Toast.makeText(holder.itemView.getContext(), value , Toast.LENGTH_SHORT).show();
        //        Intent intent = new Intent(holder.itemView.getContext(), MapActivity.class);
        //        intent.putExtra("value", value);
       //         holder.itemView.getContext().startActivity(intent);*/
       //         Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", value, null));
       //         v.getContext().startActivity(intent);
       //     }
       // });

      //  Button btnSms = holder.itemView.findViewById(R.id.btnSms);
      //  btnSms.setOnClickListener(new View.OnClickListener() {
       //     @Override
      //      public void onClick(View v) {
      //          Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", value, null));
      //          v.getContext().startActivity(intent);
      //      }
      //  });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}