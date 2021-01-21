package com.company.menusandtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.img);
        button=findViewById(R.id.btn);
        toolbar=findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);


        registerForContextMenu(imageView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu=new PopupMenu(MainActivity.this,button);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(MainActivity.this,"Item 1",Toast.LENGTH_SHORT).show();break;
            case R.id.item2:
                Toast.makeText(MainActivity.this,"Item 2",Toast.LENGTH_SHORT).show();break;
            case R.id.item3:
                Toast.makeText(MainActivity.this,"Item 3",Toast.LENGTH_SHORT).show();break;
            case R.id.item4:
                Toast.makeText(MainActivity.this,"Item 4",Toast.LENGTH_SHORT).show();break;
            case R.id.item5:
                Toast.makeText(MainActivity.this,"Item 5",Toast.LENGTH_SHORT).show();break;

        }
        return super.onOptionsItemSelected(item);
    }

}