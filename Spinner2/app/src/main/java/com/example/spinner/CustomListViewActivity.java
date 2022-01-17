package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    private ListView lvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        lvContact = (ListView) findViewById(R.id.lvContact);
        ArrayList<Contact> arrContact = new ArrayList<>();
        Contact contact1 = new Contact("Bùi Viết Hùng Anh","161250533502", Color.RED);
        Contact contact2 = new Contact("Nguyễn Quốc Cường","161250533405", Color.GREEN);
        Contact contact3 = new Contact("Nguyễn Khương Đào","151250533308", Color.GRAY);
        Contact contact4 = new Contact("Vy Văn Đô","161250533207", Color.YELLOW);
        Contact contact5 = new Contact("Phạm Nguyễn Hoài Duy","151250533113", Color.BLACK);
        Contact contact6 = new Contact("Đỗ Thiên Giang","131250532378", Color.BLUE);
        Contact contact7 = new Contact("Võ Hữu Hải","151250533116", Color.CYAN);
        arrContact.add(contact1);
        arrContact.add(contact2);
        arrContact.add(contact3);
        arrContact.add(contact4);
        arrContact.add(contact5);
        arrContact.add(contact6);
        arrContact.add(contact7);
        CustomAdapter customAdaper = new CustomAdapter(this,R.layout.activity_custom_list_view,arrContact);
        lvContact.setAdapter(customAdaper);
    }
}