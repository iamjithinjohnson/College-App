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


public class recycleAdapterquest extends RecyclerView.Adapter<recycleAdapterquest.ViewHolder> {
    Context context;
    List<QuestData> staff;

    public recycleAdapterquest(Context Questions, List<QuestData> dataModelList) {
        this.context = Questions;
        this.staff = dataModelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        //  View view = inflater.inflate(R.layout.list_staff, null);
        // return new ViewHolder(view);
        View rootView = LayoutInflater.from(context).inflate(R.layout.question_list, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootView.setLayoutParams(lp);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.paper.setText(staff.get(position).getPaper());
        holder.subject.setText(staff.get(position).getSubject());
        holder.code.setText(staff.get(position).getCode());
        holder.semester.setText(staff.get(position).getSemester());




        //  holder.image.glid(Integer.parseInt(staff.get(position).getImage()));
        //  Picasso.with(this.context).load(staff.get(position).getImage()).into(holder.image);

        holder.lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestData p = staff.get(position);
                String id = p.getId();
                String url = p.getUrl();


                Intent i=new Intent(context,QuestionShow.class);
                i.putExtra("url",url);
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
        TextView paper, subject, code, semester;
        LinearLayout lyt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            paper = itemView.findViewById(R.id.paper);
            subject = itemView.findViewById(R.id.subject);
            code = itemView.findViewById(R.id.code);
            semester = itemView.findViewById(R.id.semester);
            lyt = itemView.findViewById(R.id.questlayout);
        }

    }

}