package com.example.guest.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.guest.chatapplication.R;
import com.example.guest.chatapplication.models.User;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConversationActivity extends AppCompatActivity {
    private String TAG = ConversationActivity.class.getSimpleName();
    private DatabaseReference mPostsRefrence;
    private List<User> mCategories = new ArrayList<>();
//    private PostListAdapter mAdapter;
//    private ArrayList<Texts> mTexts = new ArrayList<>();
    private User mUser;
    private int position;

    @Bind(R.id.imageUrlView)ImageView mImageUrlLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(this);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
    }
}
