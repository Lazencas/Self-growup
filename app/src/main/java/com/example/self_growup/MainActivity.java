package com.example.self_growup;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView TimeTextView, MySalary, MyTotalTime;
    int StudyTime;
    int HourTimeMoney = 30000;
    String shared = "file";
    Button TimeInput, TimeEdit;
    String salary;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();



        //화면 오른쪽 상단의 현재시간을 표시하는 텍스트뷰
        TimeTextView = (TextView) findViewById(R.id.Today);
        TimeTextView.setText((getTime()));

        //누적시간 표시
        MyTotalTime = (TextView)findViewById(R.id.MyTotalTime);
        //쉐어드프리퍼런스에서 누적시간 불러와서 표시
        String value = sharedPreferences.getString("StackTime", "");
        MyTotalTime.setText(value);

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
                        //에디터텍스트에 입력된값을 가져와서 정수형으로 바꾼다.
                        int plus1 = parseInt(et.getText().toString());

                        //더할값을 쉐어드프리퍼런스에서 가져와서 정수형으로 바꾼다.
                        String value2 = sharedPreferences.getString("StackTime", "");
                        int plus2 = parseInt(value2);

                        //두 값을 더하여서 나온값을 문자열로 바꾸고 쉐어드프리퍼런스에 저장하고, 불러온다.
                        int newplus = plus1 + plus2;
                        String newvalue = String.valueOf(newplus);
                        editor.putString("StackTime",newvalue);
                        editor.commit();

                        //계산을위해 시간값을 쉐어드프리퍼런스에서 불러와서 정수형으로 바꾼다
                        String value33 = sharedPreferences.getString("StackTime", "");
                        int salaryplus = parseInt(value33);
                        int sal =  salaryplus * HourTimeMoney;
                        //계산후 다시 문자열로 변환
                        salary = String.valueOf(sal);
                        MySalary.setText(salary);

                        //수정된 값의 새로고침을 위하여 바로 쉐어드프리퍼런스에서 값을 불러와서 세팅한다.
                        String value11 = sharedPreferences.getString("StackTime", "");
                        MyTotalTime.setText(value11);


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
                       //에디트텍스트에 입력한 값을 받아서 문자값으로 저장하고 그대로 쉐어드프리퍼런스에 푸시로 넣음
                        String value = et.getText().toString();
                        editor.putString("StackTime",value);
                        editor.commit();

                        //계산을위해 시간값을 쉐어드프리퍼런스에서 불러와서 정수형으로 바꾼다
                        String value33 = sharedPreferences.getString("StackTime", "");
                        int salaryplus = parseInt(value33);
                        int sal =  salaryplus * HourTimeMoney;
                        //계산후 다시 문자열로 변환
                        salary = String.valueOf(sal);
                        MySalary.setText(salary);

                        //수정된 값의 새로고침을 위하여 바로 쉐어드프리퍼런스에서 값을 불러와서 세팅한다.
                        String value1 = sharedPreferences.getString("StackTime", "");
                        MyTotalTime.setText(value1);
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
        //계산을위해 시간값을 쉐어드프리퍼런스에서 불러와서 정수형으로 바꾼다
        String value33 = sharedPreferences.getString("StackTime", "");
        int salaryplus = parseInt(value33);
        int sal =  salaryplus * HourTimeMoney;
        //계산후 다시 문자열로 변환
        salary = String.valueOf(sal);
        MySalary.setText(salary);



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
    protected void onStart() {
        super.onStart();


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}