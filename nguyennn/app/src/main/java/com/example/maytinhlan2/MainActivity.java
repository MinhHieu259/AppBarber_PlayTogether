package com.example.maytinhlan2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Integer so1 =0;
    Integer so2 =0;
    Character dau = null;

    Button btnthoat;


    ListView lvHistory;
    ArrayList<String>dskq;
    ArrayAdapter<String>adapterkqne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents ();
        ControlButton();
    }

    private void ControlButton() {
            btnthoat = (Button) findViewById(R.id.thoat);
            btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có muốn thoát khỏi ứng dụng ?");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    private void addEvents() {
        final TextView txtvkq = (TextView) findViewById(R.id.kq);
        Button So0 =(Button)findViewById(R.id.so0);So0.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"0");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So1 =(Button)findViewById(R.id.so1);So1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"1");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So2 =(Button)findViewById(R.id.so2);So2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"2");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So3 =(Button)findViewById(R.id.so3);So3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"3");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So4 =(Button)findViewById(R.id.so4);So4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"4");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So5 =(Button)findViewById(R.id.so5);So5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"5");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So6 =(Button)findViewById(R.id.so6);So6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"6");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So7 =(Button)findViewById(R.id.so7);So7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"7");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So8 =(Button)findViewById(R.id.so8);So8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"8");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});
        Button So9 =(Button)findViewById(R.id.so9);So9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { txtvkq.setText(txtvkq.getText().toString()+"9");if(dau == null) {so1 = Integer.parseInt(txtvkq.getText().toString());} else {so2 = Integer.parseInt(txtvkq.getText().toString());} }});


        Button Bo = (Button)findViewById(R.id.bo);
        Bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so2 =0;
                txtvkq.setText("");
            }
        });


        Button Cong =(Button)findViewById(R.id.cong);
        Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dau = '+';
                txtvkq.setText("");
            }
        });

        Button Tru =(Button)findViewById(R.id.tru);
        Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dau = '-';
                txtvkq.setText("");
            }
        });

        Button Nhan =(Button)findViewById(R.id.nhan);
        Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dau = 'X';
                txtvkq.setText("");
            }
        });

        Button Chia =(Button)findViewById(R.id.chia);
        Chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dau = '/';
                txtvkq.setText("");
            }
        });

        Button Bang =(Button)findViewById(R.id.bang);
        Bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dau!=null)
                {
                    Integer kqne =0;
                    switch (dau)
                    {
                        case '+':{

                            kqne = so1 + so2;
                            break;
                        }
                        case '-':{

                            kqne = so1 - so2;
                            break;
                        }
                        case 'X':{

                            kqne = so1 * so2;
                            break;
                        }
                        case '/':{

                            kqne = so1 / so2;
                            break;
                        }
                    }
                    txtvkq.setText(kqne.toString());
                    dskq.add(Integer.toString(so1) + " " + dau + " " + Integer.toString(so2) + " = " + String.valueOf(kqne));
                    so1 = kqne;
                    dau = null;
                    adapterkqne.notifyDataSetChanged();


                }
            }
        });

        Button Xoa = (Button)findViewById(R.id.xoa);
        Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so1 =0;
                so2 =0;
                dau =null;
                txtvkq.setText("");
            }
        });
    }



    private void addControls() {
        TabHost tabHost= (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setIndicator("Phép Tính");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);



        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setIndicator("History");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        lvHistory=(ListView) findViewById(R.id.lvHistory);
        dskq=new ArrayList<>();
        adapterkqne= new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dskq);
        lvHistory.setAdapter(adapterkqne);

    }


}