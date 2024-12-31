package com.example.digilocker_safest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<String> cardTitles, cardDescreptions;
    private List<Integer> cardImages; // List of image resource IDs

    private List<Integer> cardID ;

    Context context ;

    public CardAdapter(Context context, List<String> cardTitles, List<String>cardDescreptions , List<Integer> cardImages, List<Integer> id) {
        this.cardTitles = cardTitles;
        this.cardImages = cardImages;
        this.cardDescreptions = cardDescreptions ;
        this.cardID = id ;
        this.context = context ;
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
        holder.card.setId(cardID.get(position));

        Toast.makeText(context, "called", Toast.LENGTH_SHORT).show();
        holder.card.setOnClickListener(v -> {
            Toast.makeText(context, "clicked" + holder.card.getId(), Toast.LENGTH_SHORT).show();

            switch (holder.card.getId()){
                case 1 :
                    //aadhar
                    break ;
                case 2 :
                    // covid
                    break ;
                case 3 :
                    Intent i = new Intent(context, DrivingLicenseActivityy.class);
                    context.startActivity(i);
                case 4 :
                    //pan card
                    break ;
            }

        });

    }

    @Override
    public int getItemCount() {
        return cardTitles.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescreption;
        ImageView cardImage, cardImage2;

        LinearLayout card ;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardtype) ;
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescreption = itemView.findViewById(R.id.descreption) ;
            cardImage = itemView.findViewById(R.id.cardImage); // Reference to the ImageView
            cardImage2 = itemView.findViewById(R.id.cardImageCopy) ;
        }
    }
}
