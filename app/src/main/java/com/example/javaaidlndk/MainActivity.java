package com.example.javaaidlndk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.javaaidlndk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'javaaidlndk' library on application startup.
    static {
        System.loadLibrary("javaaidlndk");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        TextView ndkTv = binding.ndkText;
        ndkTv.setText(process());
    }

    public String processInJava() {
        return "Processed In Java";
    }

    /**
     * A native method that is implemented by the 'javaaidlndk' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String process();
}