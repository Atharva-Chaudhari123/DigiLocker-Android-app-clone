package com.example.digilocker_safest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<String> cardTitles, cardDescreptions;
    private List<Integer> cardImages; // List of image resource IDs

    public CardAdapter(List<String> cardTitles, List<String>cardDescreptions ,List<Integer> cardImages) {
        this.cardTitles = cardTitles;
        this.cardImages = cardImages;
        this.cardDescreptions = cardDescreptions ;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        // Set the title and image for each card
        holder.textViewTitle.setText(cardTitles.get(position));
        holder.textViewDescreption.setText(cardDescreptions.get(position));
        holder.cardImage.setImageResource(cardImages.get(position)); // Set the image dynamically
        holder.cardImage2.setImageResource(cardImages.get(position));
    }

    @Override
    public int getItemCount() {
        return cardTitles.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescreption;
        ImageView cardImage, cardImage2;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescreption = itemView.findViewById(R.id.descreption) ;
            cardImage = itemView.findViewById(R.id.cardImage); // Reference to the ImageView
            cardImage2 = itemView.findViewById(R.id.cardImageCopy) ;
        }
    }
}
