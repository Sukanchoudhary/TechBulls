package com.example.techbulls.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techbulls.R;
import com.example.techbulls.model.MovieModel;
import com.example.techbulls.model.SearchModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    Context context;
    MovieModel movieModel;
    String title,type,year;

    public MovieAdapter(Context context, MovieModel movieModel) {
        this.context = context;
        this.movieModel = movieModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movielist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        title=context.getString(R.string.Title_name);
        type=context.getString(R.string.txt_type);
        year=context.getString(R.string.txt_year);

        List<SearchModel> searchModels=movieModel.getSearch();
        holder.title.setText(String.format(title,searchModels.get(position).getTitle()));
        holder.type.setText(String.format(type,searchModels.get(position).getType()));
        holder.year.setText(String.format(year,searchModels.get(position).getYear()));
    }

    @Override
    public int getItemCount() {
        return movieModel.getSearch().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,type,year;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txt_moviename);
            type=itemView.findViewById(R.id.txt_type);
            year=itemView.findViewById(R.id.txt_year);
        }
    }
}
