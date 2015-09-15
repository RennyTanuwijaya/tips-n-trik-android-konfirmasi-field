package com.example.rennytanuwijaya.blog2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {


    private EditText mPassword;
    private EditText mPasswordConfirm;
    private TextView txtConfirmPass;
    private boolean passwordSame = false;
    private Button btnChangePass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mPasswordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);
        txtConfirmPass = (TextView) findViewById(R.id.PasswordNotMatch);
        btnChangePass = (Button) findViewById(R.id.btnChangePassword);
        btnChangePass.setOnClickListener(this);
        mPasswordConfirm.addTextChangedListener(
                new TextWatcher() {
                    public void afterTextChanged(Editable s) {
                        String strPass1 = mPassword.getText().toString();
                        String strPass2 = mPasswordConfirm.getText().toString();
                        if (strPass1.equals(strPass2)) {
                            txtConfirmPass.setVisibility(TextView.INVISIBLE);
                            passwordSame = true;
                        } else {
                            txtConfirmPass.setVisibility(TextView.VISIBLE);
                            passwordSame = false;
                        }
                    }

                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChangePassword:
                Log.i("button cliked" , passwordSame + "");
                if (passwordSame){
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("Confirm~");
                    alertDialog.setMessage("words match");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,
                            "OK", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else if(!passwordSame){
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("Not Confirmed");
                    alertDialog.setMessage("words not match");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,
                            "OK", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                break;
        }
    }
}
