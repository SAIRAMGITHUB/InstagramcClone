package android.sairam.instagramcclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void helloWorldTapped(View view) {
//        ParseObject boxer = new ParseObject("Boxer");
//        boxer.put("punch_speed", 200);
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Toast.makeText(SignUpActivity.this, "boxer save scuccess", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        try {

            ParseObject boxer = new ParseObject("KickBoxer");
            boxer.put("punch_speed", 100);
            boxer.put("name", "Sairam");
            boxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUpActivity.this,"kick boxer save success",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                    }
                    else {
                        FancyToast.makeText(SignUpActivity.this,e.getMessage(), FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();


                    }
                }
            });
        }
        catch (Exception e) {
            FancyToast.makeText(SignUpActivity.this,e.getMessage(), FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();

        }

    }
}
