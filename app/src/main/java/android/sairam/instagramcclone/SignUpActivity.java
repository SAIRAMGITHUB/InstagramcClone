package android.sairam.instagramcclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

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


    public  void  getDataTextViewTapped(View view) {

//        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
//        parseQuery.getInBackground("vZH9T0BlA9", new GetCallback<ParseObject>() {
//            @Override
//            public void done(ParseObject object, ParseException e) {
//                if (object != null && e == null) {
//                    FancyToast.makeText(SignUpActivity.this, object.get("name") + "", FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
//                }
//                else {
//                    FancyToast.makeText(SignUpActivity.this,e.getMessage(), FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
//                }
//            }
//        });

        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                String names = "";
                for (ParseObject object:objects) {
                    names = names + object.get("name") + " ";
                }
                FancyToast.makeText(SignUpActivity.this, names, FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();

            }
        });


    }
}
