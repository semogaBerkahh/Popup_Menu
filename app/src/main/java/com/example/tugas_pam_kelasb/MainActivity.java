package com.example.tugas_pam_kelasb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    Button btnLogin;
    EditText etEmail, etPassword;
    String nama, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = etEmail.getText().toString();
                password = etPassword.getText().toString();

                String email = "admin@mail.com";
                String Pass ="123";

                if (nama.equals(email) && password.equals(password)) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses",
                            Toast.LENGTH_SHORT);

                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a",nama.trim());
                    b.putString("b",password.trim());
                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                    i.putExtras(b);
                    startActivity(i);



                } else{
                    Toast t = Toast.makeText(getApplicationContext(),
                            " Email dan Password wajib diisi", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });
    }
}