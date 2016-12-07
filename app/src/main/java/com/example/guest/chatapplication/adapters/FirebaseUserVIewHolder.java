package com.example.guest.chatapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.chatapplication.Constants;
import com.example.guest.chatapplication.R;
import com.example.guest.chatapplication.ConversationActivity;
import com.example.guest.chatapplication.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseUserViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindUser(User user) {
        ImageView userImageView = (ImageView) mView.findViewById(R.id.userImageView);
        TextView userTextView = (TextView) mView.findViewById(R.id.UserTextView);

        Picasso.with(mContext)
                .load(user.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(userImageView);

        userTextView.setText(user.getName());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<User> users = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_USERS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    users.add(snapshot.getValue(User.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ConversationActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("users", Parcels.wrap(users));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}