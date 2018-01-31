package com.example.kc.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

public class ThreeActivity extends BaseActivity {

    public EditText editText = null;
    public Button button = null;
    public Button button1 = null;
    public ImageView imageView = null;
    public Bitmap mBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        initView();
    }

    private void initView() {//初始化组件

        editText = (EditText) findViewById(R.id.edit_content);
        button = (Button) findViewById(R.id.button_content);//生成LOGO二维码图片
        button1 = (Button) findViewById(R.id.button1_content);//生成普通二维码图片
        imageView = (ImageView) findViewById(R.id.image_content);

        button.setOnClickListener(new View.OnClickListener() {//生成带LOGO的二维码图片
            @Override
            public void onClick(View v) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                mBitmap = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                imageView.setImageBitmap(mBitmap);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {//生成普通二维码图片
            @Override
            public void onClick(View v) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                mBitmap = CodeUtils.createImage(textContent, 400, 400, null);
                imageView.setImageBitmap(mBitmap);
            }
        });
    }

}
