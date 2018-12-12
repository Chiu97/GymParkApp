package com.example.a97rea.gymparkapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.TrainerHolder>{
    List<Trainer> trainerList;
    private  Context context;
    public TrainerAdapter(List<Trainer> list,Context context){
        this.context=context;
        trainerList=list;
    }
    @NonNull
    @Override
    public TrainerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_trainer,viewGroup,false);
        TrainerHolder holder=new TrainerHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TrainerHolder trainerHolder, int i) {
        trainerHolder.email.setText(trainerList.get(i).getEmail());
        trainerHolder.img.setImageResource(trainerList.get(i).getTrainerPic());
        trainerHolder.name.setText(trainerList.get(i).getName());
        trainerHolder.phone.setText(trainerList.get(i).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return trainerList.size();
    }
    class TrainerHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView phone;
        TextView name;
        TextView email;
        CardView parent_layout;
        public TrainerHolder(@NonNull View itemView){
            super(itemView);
            img=itemView.findViewById(R.id.trainer_picture);
            phone=itemView.findViewById(R.id.trainer_phone_number);
            name=itemView.findViewById(R.id.trainer_name);
            email=itemView.findViewById(R.id.trainer_email);
            parent_layout=itemView.findViewById(R.id.card_view);
            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phone_no=phone.getText().toString();
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+phone_no));
                    context.startActivity(intent);
                }
            });
        }
    }

}
