package com.example.guest.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.chatapplication.adapters.FirebaseUserViewHolder;
import com.example.guest.chatapplication.models.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactsListActivity extends AppCompatActivity {
    private DatabaseReference mUserReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        mUserReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_USERS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<User, FirebaseUserViewHolder>
                (User.class, R.layout.user_list_item, FirebaseUserViewHolder.class,
                        mUserReference) {

            @Override
            protected void populateViewHolder(FirebaseUserViewHolder viewHolder,
                                              User model, int position) {
                viewHolder.bindUser(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
