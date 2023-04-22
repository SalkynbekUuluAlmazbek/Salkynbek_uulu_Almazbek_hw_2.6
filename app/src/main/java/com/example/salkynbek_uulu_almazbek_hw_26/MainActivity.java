package com.example.salkynbek_uulu_almazbek_hw_26;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText mEditEmailText;
    private EditText mEditPasswordText;
    private Button mButtonInsert;
    private TextView mTextViewInsert;
    private TextView mTextViewRegistry;
    private TextView mTextViewForget;
    private TextView mTextViewWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditEmailText = findViewById(R.id.edit_text_mail);
        mEditPasswordText = findViewById(R.id.password);
        mButtonInsert = findViewById(R.id.button_insert);
        mTextViewInsert = findViewById(R.id.inter);
        mTextViewWelcome = findViewById(R.id.welcom);
        mTextViewRegistry = findViewById(R.id.registry);
        mTextViewForget = findViewById(R.id.forget);


        mButtonInsert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForColorStateLists")
            @Override
            public void onClick(View view) {
                String email = mEditEmailText.getText().toString();
                String password = mEditPasswordText.getText().toString();

                if (email.equals("admin") && password.equals("admin")) {

                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT).show();
                    mTextViewWelcome.setText("Добро пожаловать!");
                    mEditEmailText.setVisibility(View.GONE);
                    mEditPasswordText.setVisibility(View.GONE);
                    mButtonInsert.setVisibility(View.GONE);
                    mTextViewForget.setVisibility(View.GONE);
                    mTextViewInsert.setVisibility(View.GONE);
                    mTextViewRegistry.setVisibility(View.GONE);

                    mButtonInsert.setBackgroundTintList(getColorStateList(R.color.orange));
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный пароль и логин!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mEditEmailText.setOnKeyListener((view, i, keyEvent) -> {

            if (mEditEmailText.getText().toString().equals("")) {
                mButtonInsert.setBackgroundTintList(getColorStateList(R.color.grey));
            } else {
                mButtonInsert.setBackgroundTintList(getColorStateList(R.color.orange));
            }
            return false;
        });

    }
}