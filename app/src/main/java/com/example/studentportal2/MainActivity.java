package com.example.studentportal2;

import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnItemTouchListener {

    public final static int REQUESTCODE = 1;
    private List<Website> mPortalObjects;
    private WebsiteAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private GestureDetector mGestureDetector;
    public final static String EXTRATEXT_NAME = "extratextName";
    public final static String EXTRATEXT_URL = "extratextUrl";
    public final static int GRIDCOLOUMS = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerView);
        mPortalObjects = new ArrayList<>();

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, GRIDCOLOUMS));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddWebsite.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
        mRecyclerView.addOnItemTouchListener(this);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });


        mPortalObjects.add(new Website("Email", "http://email.hva.nl"));
        mPortalObjects.add(new Website("Runescape", "http://runescape.com"));
        mPortalObjects.add(new Website("18+", "http://birthdaymessages.net/18th-birthday-wishes.html"));

        updateUI();

    }


    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        //Kijk welke view is aangeklikt
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        int mAdapterPosition = rv.getChildAdapterPosition(child);
        //Als het daarwerkelijk een label is, open een nieuwe pagina
        if(child != null && mGestureDetector.onTouchEvent(e)) {
            Intent intent = new Intent(MainActivity.this, WebsiteWebViewPage.class);
            intent.putExtra(EXTRATEXT_URL, mPortalObjects.get(mAdapterPosition).getmPortalUrl());
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Voegt items toe aan menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateUI(){
        if (mAdapter == null) {
            mAdapter = new WebsiteAdapter(mPortalObjects);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    //Dit wordt uitgevoerd na het klikken op de submit button
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == REQUESTCODE){
            if(resultCode == RESULT_OK) {
                mPortalObjects.add(new Website(data.getStringExtra(MainActivity.EXTRATEXT_NAME), data.getStringExtra(MainActivity.EXTRATEXT_URL)));
                updateUI();
            }
        }
    }
}