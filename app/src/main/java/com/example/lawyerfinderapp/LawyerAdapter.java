package com.example.lawyerfinderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lawyerfinderapp.models.Lawyer;

import java.util.List;

public class LawyerAdapter extends ArrayAdapter<Lawyer> {
    private final Context context;
    private final List<Lawyer> lawyerList;

    /**
     * Constructor for LawyerAdapter
     * @param context Application context
     * @param lawyers List of Lawyers
     */
    public LawyerAdapter(Context context, List<Lawyer> lawyers) {
        super(context, 0, lawyers);
        this.context = context;
        this.lawyerList = lawyers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            // Initialize ViewHolder
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get Current Lawyer
        Lawyer lawyer = lawyerList.get(position);

        // Set Lawyer Name, Specialty, Rating, and Location
        holder.tvName.setText(lawyer.getName());
        holder.tvType.setText(lawyer.getSpecialty());
        holder.ratingBar.setRating(lawyer.getRating());
        holder.tvLocation.setText(lawyer.getLocation());

        // Set Lawyer Image
        holder.lawyerImage.setImageResource(lawyer.getImageResId());

        return convertView;
    }

    /**
     * ViewHolder class to hold references to layout views
     */
    private static class ViewHolder {
        final TextView tvName, tvType, tvLocation;
        final ImageView lawyerImage;
        final RatingBar ratingBar;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.listName); // Fixed: Matches list_item.xml
            tvType = view.findViewById(R.id.listLawyerType);
            lawyerImage = view.findViewById(R.id.listImage);
            ratingBar = view.findViewById(R.id.Rating);
            tvLocation = view.findViewById(R.id.listTime);
        }
    }
}
