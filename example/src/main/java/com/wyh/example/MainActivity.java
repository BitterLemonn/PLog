package com.wyh.example;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.wyh.plog.core.PLog;
import com.wyh.plog.upload.UploadListener;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void log(View view) {
        for (int i = 0; i < 100; i++) {
            PLog.d("wyh", "这是第%d条日志", i);
        }
        PLog.d("wyh", new String[]{"a", "b", "c"});
    }

    public void upload(View view) {
        PLog.upload(new UploadListener() {
            @Override
            public void upload(@NonNull List<File> files) {
                //上传到你的服务端


                //建议上传成功及时删除日志文件
                for (File file : files) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        });
    }
}
