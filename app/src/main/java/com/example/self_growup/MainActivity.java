package com.example.self_growup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView TimeTextView, MySalary;
    int StudyTime;
    int HourTimeMoney = 30000;
    String shared = "file";
    Button TimeInput, TimeEdit;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //화면 오른쪽 상단의 현재시간을 표시하는 텍스트뷰
        TimeTextView = (TextView) findViewById(R.id.Today);
        TimeTextView.setText((getTime()));

        //시간입력버튼
        TimeInput = (Button)findViewById(R.id.TimeInputButton);
        TimeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setMessage("수정할 시간을 입력하세요.");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                //시간입력팝업창에서 확인 눌렀을때 동작 구현
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                //시간입력팝업창에서 취소 눌렀을때 동작 구현
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
               ad.show();

            }
        });


        //시간수정버튼
        TimeEdit = (Button)findViewById(R.id.TimeEditButton);
        TimeEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){

                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setMessage("수정할 시간을 입력하세요.");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                //시간수정팝업창에서 확인 눌렀을때 동작 구현
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                //시간수정팝업창에서 취소 눌렀을때 동작 구현
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //연봉의 금액 값, 이 값에 따라 티어이미지도 바뀌고 프로그레스바도 바뀐다.
        MySalary = (TextView) findViewById(R.id.MySalaryTextView);
        MySalary.setText("0");



    }

    //현재 시간을 가져오는 함수
    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        String getTime = dateFormat.format(date);
        return getTime;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}