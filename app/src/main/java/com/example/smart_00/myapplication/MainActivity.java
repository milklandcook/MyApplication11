package com.example.smart_00.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 연습");

        //id 찾기
        btn1 = (Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.button2);
        btn3=(Button) findViewById(R.id.button3);
        btn4 =(Button) findViewById(R.id.button4);

        //전화걸기
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:01059554216");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivityForResult(intent, 0);
          //Action_DIAL : 전화걸기 화면
            }
        });

        //홈페이지 보기
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivityForResult(intent, 0);
            }
        });
       //구글 지도
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("http://maps.google.com/maps?q="+37.554263+","+126.913598);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivityForResult(intent, 0);
            }
        });

        //문자 보내기
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕");
                intent.setData(Uri.parse("smsto:" + uri.encode("010-5955-4216")));
                startActivity(intent);
                startActivityForResult(intent, 0);
            }
        });
//AndroidManifest.xml ==>intent사용 기능 추가

    }
}
