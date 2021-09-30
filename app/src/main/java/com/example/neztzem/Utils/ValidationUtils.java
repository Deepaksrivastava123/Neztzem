package com.example.neztzem.Utils;

import android.widget.EditText;
import android.widget.TextView;

import com.example.neztzem.R;

public class ValidationUtils {

    public static boolean blankValidation(EditText editText){
        String emailString = editText.getText().toString().trim();
        if (emailString.length()>0){
            editText.setError(null);
            return true;
        }
        else {
            editText.setError(editText.getContext().getString(R.string.error_text_blank));
            return false;
        }
    }

    public static boolean blankValidaton(TextView editText){
        String emailString = editText.getText().toString().trim();
        if (emailString.length()>0){
            editText.setError(null);
            return true;
        }else {
            editText.setError(editText.getContext().getString(R.string.error_text_blank));
            return false;
        }
    }
}
