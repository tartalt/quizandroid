package com.example.myapplicationf;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class classement extends AppCompatActivity {
//     private ListView listViewRanking;
//    private FirebaseDatabase firebaseDatabase;
//    private DatabaseReference databaseReference;
//    private List<User> userList; // List to store user data
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);
//
////        // Initialize Firebase components
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("users"); // Assuming "users" is your data node
//
//        listViewRanking = findViewById(R.id.listViewRanking);
//        userList = new ArrayList<>();
////
//         Create custom adapter for ListView
////        final UserListAdapter adapter = new UserListAdapter(this, userList);
////        listViewRanking.setAdapter(adapter);
////
//         Read data from Firebase Realtime Database
////        databaseReference.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                userList.clear(); // Clear existing data before populating
////                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                    User user = snapshot.getValue(User.class); // Assuming User class has "nom" and "score" fields
////                    if (user != null) {
////                        userList.add(user);
////                    }
//                }
////                adapter.notifyDataSetChanged(); // Update ListView adapter
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
//                 Handle database errors (optional)
//                Log.w("RankingActivity", "Failed to read data", error.toException());
//            }
//        });
    }
}