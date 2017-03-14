package com.alexoladele.resume;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.alex_oladele)
    ImageView mePic;
    @BindView(R.id.welcome_message)
    TextView welcome_msg;

    @BindView(R.id.rootView)
    ConstraintLayout rootView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
//        Blurry.with(getApplicationContext()).radius(25).sampling(2).onto((ViewGroup) rootView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.github:
                Toast.makeText(getApplicationContext(), "Github was clicked", Toast.LENGTH_SHORT).show();
                String githubUrl = "https://github.com/dragid10";
                loadGithub(githubUrl);
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Settings was clicked", Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }

    private void loadGithub(String githubUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(githubUrl));
        startActivity(intent);
//        webView.loadUrl(githubUrl);
    }
}
