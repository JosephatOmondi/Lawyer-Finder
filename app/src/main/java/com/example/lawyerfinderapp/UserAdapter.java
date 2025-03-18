package com.example.lawyerfinderapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;

import com.example.lawyerfinderapp.models.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> userList;
    private Database db;

    public UserAdapter(Context context, List<User> users, Database db) {
        super(context, 0, users); // ✅ No XML needed
        this.context = context;
        this.userList = users;
        this.db = db;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            // ✅ Create root LinearLayout
            LinearLayout layout = new LinearLayout(context);
            layout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setPadding(10, 10, 10, 10);

            // ✅ User Name TextView
            TextView tvName = new TextView(context);
            tvName.setLayoutParams(new LinearLayout.LayoutParams(
                    0, ViewGroup.LayoutParams.WRAP_CONTENT, 2)); // 2:1 ratio
            tvName.setTextSize(16);
            tvName.setPadding(5, 5, 5, 5);
            tvName.setTextColor(0xFF000000); // Black

            // ✅ Delete Button
            Button btnDelete = new Button(context);
            btnDelete.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            btnDelete.setText("Delete");
            btnDelete.setBackgroundColor(0xFFD32F2F); // Red
            btnDelete.setTextColor(0xFFFFFFFF); // White

            // ✅ Add Views to Layout
            layout.addView(tvName);
            layout.addView(btnDelete);
            convertView = layout;

            // ✅ Store references using setTag()
            convertView.setTag(new ViewHolder(tvName, btnDelete));
        }

        // ✅ Retrieve ViewHolder
        ViewHolder holder = (ViewHolder) convertView.getTag();
        User user = userList.get(position);
        holder.tvName.setText(user.getFirstname() + " " + user.getLastname()); // ✅ Fix


        // ✅ Set Delete Button Click Listener
        holder.btnDelete.setOnClickListener(v -> {
            db.deleteUser(user.getId());
            userList.remove(position);
            notifyDataSetChanged();
            Toast.makeText(context, "User Deleted!", Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }

    // ✅ ViewHolder for Efficient View Handling
    private static class ViewHolder {
        TextView tvName;
        Button btnDelete;

        ViewHolder(TextView tvName, Button btnDelete) {
            this.tvName = tvName;
            this.btnDelete = btnDelete;
        }
    }
}
