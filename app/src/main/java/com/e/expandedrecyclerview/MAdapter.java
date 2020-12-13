package com.e.expandedrecyclerview;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewholder> {
     List<movie> movieList;

    public MAdapter(List<movie> movieList){
       this.movieList=movieList;
    }
    @NonNull
    @Override
    public MAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MAdapter.MyViewholder holder, int position) {
        holder.title.setText(movieList.get(position).getTitle());
        holder.year.setText(movieList.get(position).getYear());
        holder.rating.setText(movieList.get(position).getRating());
        holder.plot.setText(movieList.get(position).getPlot());
        // to expand the layout in recyclerview
        // we should define visibility in xml as gone then we check here
        // there is another logic to do the same
        holder.moreLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.expanded.getVisibility()==View.GONE){
                    // the below line of code is only for delaying the transition it is not mandatory you can delete it
                    TransitionManager.beginDelayedTransition(holder.cardView,new AutoTransition());
                    holder.moreLess.setImageResource(R.drawable.ic_expand_less);
                    holder.expanded.setVisibility(View.VISIBLE);
                }else{
                    // the below line of code is only for delaying the transition it is not mandatory you can delete it
                    TransitionManager.beginDelayedTransition(holder.cardView,new AutoTransition());
                    holder.expanded.setVisibility(View.GONE);
                    holder.moreLess.setImageResource(R.drawable.ic_expand_more);
                }
            }
        });

        // another logic is to define visibility in xml as gone
        // then add boolean variable expand in movie class and set it as false in the constructor
        // then in MyViewholder set cliclinster to the moreLess button
        // and set the value of the expand variable to not equal the initial value
        // then notify the adapter for the changes

      /*  boolean isExpanded = movieList.get(position).isExpand();
        holder.expanded.setVisibility(isExpanded ? View.VISIBLE : View.GONE); */



    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

  class MyViewholder extends RecyclerView.ViewHolder{
        public TextView title, rating,year,plot;
        public ImageButton moreLess;
        public ConstraintLayout expanded;
        public CardView cardView;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.titleTextView);
            rating=itemView.findViewById(R.id.ratingTextView);
            year=itemView.findViewById(R.id.yearTextView);
            plot=itemView.findViewById(R.id.plotTextView);
            moreLess=itemView.findViewById(R.id.more);
            expanded=itemView.findViewById(R.id.expandableLayout);
            cardView=itemView.findViewById(R.id.cardview);

            // for another logic to expand layout
           /* moreLess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movie m =movieList.get(getAdapterPosition());
                    m.setExpand(!m.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });*/
        }
    }
}
