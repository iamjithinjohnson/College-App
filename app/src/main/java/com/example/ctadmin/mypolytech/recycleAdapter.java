package com.example.ctadmin.mypolytech;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jithin on 4/10/2020.
 */
public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.ViewHolder> {
    Context context;
    List<StaffData> staff;
    private int lastPosition = -1;
    public recycleAdapter(Context friendsactivity, List<StaffData> dataModelList) {
        this.context = friendsactivity;
        this.staff = dataModelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //LayoutInflater inflater = LayoutInflater.from(context);
      //  View view = inflater.inflate(R.layout.list_staff, null);
       // return new ViewHolder(view);
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_staff, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootView.setLayoutParams(lp);
        return new ViewHolder(rootView);

    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.name.setText(staff.get(position).getName());
        holder.dept.setText(staff.get(position).getDept());
        holder.charge.setText(staff.get(position).getCharge());
        holder.mob.setText(staff.get(position).getMob());
        //  holder.image.glid(Integer.parseInt(staff.get(position).getImage()));
        Picasso.with(this.context).load(staff.get(position).getImage()).into(holder.image);
        setAnimation(holder.lyt,position);





       /* holder.lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaffData p = staff.get(position);
                String id = p.getId();
                String name = p.getName();
                String phone = p.getDept();
                String type = p.getCharge();

                Intent i=new Intent(context,viewfriend.class);
                i.putExtra("type",type);
                i.putExtra("no",phone);
                i.putExtra("name",name);
                i.putExtra("id",id);
                context.startActivity(i);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return staff.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, dept, charge, mob;
        ImageView image;
        LinearLayout lyt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            dept = itemView.findViewById(R.id.dept);
            charge = itemView.findViewById(R.id.charge);
            mob = itemView.findViewById(R.id.mob);
            lyt = itemView.findViewById(R.id.layout);
            image = itemView.findViewById(R.id.imagee);

        }


    }

}