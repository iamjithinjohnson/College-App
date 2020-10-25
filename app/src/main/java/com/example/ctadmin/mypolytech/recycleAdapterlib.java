package com.example.ctadmin.mypolytech;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jithin on 4/10/2020.
 */
public class recycleAdapterlib extends RecyclerView.Adapter<recycleAdapterlib.ViewHolder> {
    Context context;
    List<LibData> staff;

    public recycleAdapterlib(Context Library, List<LibData> dataModelList) {
        this.context = Library;
        this.staff = dataModelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        //  View view = inflater.inflate(R.layout.list_staff, null);
        // return new ViewHolder(view);
        View rootView = LayoutInflater.from(context).inflate(R.layout.library_list, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootView.setLayoutParams(lp);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(staff.get(position).getBookid());
        holder.dept.setText(staff.get(position).getBookname());
        holder.charge.setText(staff.get(position).getIssuedon());
        holder.mob.setText(staff.get(position).getIssuedtill());
        holder.on.setText(staff.get(position).getReturnedon());
        holder.image.setText(staff.get(position).getFine());
        //  holder.image.glid(Integer.parseInt(staff.get(position).getImage()));
       // Picasso.with(this.context).load(staff.get(position).getImage()).into(holder.image);





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
        TextView name, dept, charge, mob, on,image;

        LinearLayout lyt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bookid);
            dept = itemView.findViewById(R.id.bookname);
            charge = itemView.findViewById(R.id.issuedon);
            mob = itemView.findViewById(R.id.issuedtill);
            on = itemView.findViewById(R.id.returnedon);
            image = itemView.findViewById(R.id.fine);
            lyt = itemView.findViewById(R.id.liblayout);

        }

    }

}