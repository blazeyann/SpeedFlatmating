package com.example.speedflatmating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.ViewHolder> {

    private List<Venue> mListItems;
    private OnItemClickListener onItemClickListener;

    //This interface is to allow clicking action inside the recyclerview
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public VenueAdapter(List<Venue> mListItems) {
        this.mListItems = mListItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_venues, parent, false);
        return new ViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Venue venue = mListItems.get(position);

        holder.venue.setText(venue.getVenue());
        holder.location.setText(venue.getLocation());
        holder.startTime.setText(venue.getStartTime());
        holder.endTime.setText(venue.getEndTime());
        holder.cost.setText(venue.getCost());

        Picasso.get().
        load(venue.getImageUrl()).
        into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView venue;
        public TextView location;
        public TextView startTime;
        public TextView endTime;
        public TextView cost;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            venue = (TextView) itemView.findViewById(R.id.venue);
            location = (TextView) itemView.findViewById(R.id.location);
            startTime = (TextView) itemView.findViewById(R.id.start_time);
            endTime = (TextView) itemView.findViewById(R.id.end_time);
            cost = (TextView) itemView.findViewById(R.id.cost);
            imageView = (ImageView) itemView.findViewById(R.id.venue_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {

                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }

                }
            });

        }
    }
}
