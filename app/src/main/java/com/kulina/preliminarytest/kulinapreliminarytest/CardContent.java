package com.kulina.preliminarytest.kulinapreliminarytest;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CardContent extends Fragment{
    RecyclerView recyclerView;
    ContentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.recyclerview, container, false);
        adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView pictures;
        public TextView names;
        public TextView descs;
        public TextView price;
        Button button;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.cardview_package_meal, parent, false));
            pictures = itemView.findViewById(R.id.card_image);
            names = itemView.findViewById(R.id.card_title);
            descs = itemView.findViewById(R.id.card_text);
            price = itemView.findViewById(R.id.card_price);
            button = itemView.findViewById(R.id.action_button);
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int LENGTH = 3;
        private final String[] mPlaces;
        private final String[] mPlaceDescs;
        private final String[] mPrice;
        private final Drawable[] mPlacePictures;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.places);
            mPlaceDescs = resources.getStringArray(R.array.place_desc);
            mPrice = resources.getStringArray(R.array.package_price);
            TypedArray a = resources.obtainTypedArray(R.array.places_picture);
            mPlacePictures = new Drawable[a.length()];
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.pictures.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.names.setText(mPlaces[position % mPlaces.length]);
            holder.price.setText(mPrice [position % mPrice.length]);
            holder.descs.setText(mPlaceDescs[position % mPlaceDescs.length]);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentCalc = new Intent(view.getContext(), CalculateFees.class);
                    intentCalc.putExtra("PackagePrice", mPrice [position % mPrice.length]);
                    intentCalc.putExtra("BgCollapsBar", mPlacePictures[position % mPlacePictures.length].toString());
                    view.getContext().startActivity(intentCalc);
                }
            });
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
