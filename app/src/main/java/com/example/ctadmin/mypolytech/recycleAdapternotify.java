package com.example.ctadmin.mypolytech;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jithin on 4/10/2020.
 */
public class recycleAdapternotify extends RecyclerView.Adapter<recycleAdapternotify.ViewHolder> {
    Context context;
    List<NotiData> staff;

    public recycleAdapternotify(Context Notifications, List<NotiData> dataModelList) {
        this.context = Notifications;
        this.staff = dataModelList;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        //  View view = inflater.inflate(R.layout.list_staff, null);
        // return new ViewHolder(view);
        View rootView = LayoutInflater.from(context).inflate(R.layout.notification_list, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootView.setLayoutParams(lp);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.topic.setText(staff.get(position).getTopic());
        holder.date.setText(staff.get(position).getDate());


        //  holder.image.glid(Integer.parseInt(staff.get(position).getImage()));
      //  Picasso.with(this.context).load(staff.get(position).getImage()).into(holder.image);

        holder.lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotiData p = staff.get(position);
                String id = p.getId();
                String topic = p.getTopic();
                String message = p.getMessage();
                String date = p.getDate();

                Intent i=new Intent(context,Notificationshow.class);
                i.putExtra("topic",topic);
                i.putExtra("message",message);
                i.putExtra("date",date);
                i.putExtra("id",id);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return staff.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topic, date;
        LinearLayout lyt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.topics);
            date = itemView.findViewById(R.id.date);
            lyt = itemView.findViewById(R.id.notifylayout);
        }

    }

}