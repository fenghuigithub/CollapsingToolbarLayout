package com.example.collapsingtoolbarlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fenghui on 7/29/16.
 */
public class Advertise extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertise);

        TextView text1 = (TextView)findViewById(R.id.text1);
        String textStr1 = "<font color=\"#123569\">First Color,</font>";
        String textStr2 = "<font color=\"#00ff00\"> Second Color</font>";
        text1.setText(Html.fromHtml(textStr1+textStr2));

        TextView text2 = (TextView) findViewById(R.id.text2);
        text2.setMovementMethod(LinkMovementMethod.getInstance());
        String s = "Different colors and styles ! Hey! YOO! What's up!";
        int start = s.indexOf("colors");
        int mid1 = s.indexOf("and");
        int mid2 = s.indexOf("YOO");
        int end = s.length();

        Spannable textSpan = new SpannableStringBuilder(s);
        textSpan.setSpan(new AbsoluteSizeSpan(16),0,start, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textSpan.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Log.e("click","OK");
                startActivity(new Intent(Advertise.this,Instruction.class));
            }
        },start,mid1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textSpan.setSpan(new UnderlineSpan(),mid1,mid2,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(30),mid2,end,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        text2.setText(textSpan);

    }
}
