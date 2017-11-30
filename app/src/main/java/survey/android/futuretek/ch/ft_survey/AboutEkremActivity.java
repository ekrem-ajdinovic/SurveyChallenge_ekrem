/**
 * Copyright (C) futuretek AG 2016
 * All Rights Reserved
 *
 * @author Artan Veliju
 */
package survey.android.futuretek.ch.ft_survey;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AboutEkremActivity extends BaseActivity {
    private String userName;
    private Button nextBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(AboutEkremActivity.this, SkillsActivity.class));
            }
        });

    }

    protected void onResume() {
        super.onResume();
        nextBtn.setTextColor(Color.GRAY);
        nextBtn.setEnabled(false);
        ((ViewGroup)findViewById(R.id.textLayout)).removeAllViews();
        userName=getDatabase().get("usersName");
        List<String> textArray;

        textArray = new ArrayList<>();
        textArray.add("Ekrem is always learning and trying to stay up to date.");
        textArray.add("He is excited to try new stuff, and does not give up.");
        textArray.add("His only mistake is that he is trying to learn everything. Instead he should master one technology at a time.");
        textArray.add("Challenge was exited and very interesting.");
        animateText(textArray, new AnimationListDone() {
            public void done() {
                Button nextBtn = ((Button) findViewById(R.id.nextBtn));
                nextBtn.setTextColor(Color.GREEN);
                nextBtn.setEnabled(true);
            }
        });
    }
}