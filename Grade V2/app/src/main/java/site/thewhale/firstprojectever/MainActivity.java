package site.thewhale.firstprojectever;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set Title
        setTitle("GradeCalculator");

//        Edit Text Inputs
        final EditText editText1 = findViewById(R.id.qGrade);
        final EditText editText2 = findViewById(R.id.hGrade);
        final EditText editText3 = findViewById(R.id.mGrade);
        final EditText editText4 = findViewById(R.id.fGrade);

        //text view
        final TextView textView = findViewById(R.id.resultView);

//        reset btn and on click listener
        final Button reset = findViewById(R.id.resetBTN);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
                editText2.setText("");
                
                editText3.setText("");
                editText4.setText("");
                textView.setText("Result");
                textView.setTextColor(getResources().getColor(R.color.def));
            }
        });

//       calculate Button and on click listener
        final Button click = findViewById(R.id.calcBTN);
        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Strings of Inputs
                String e1 = editText1.getText().toString();
                String e2 = editText2.getText().toString();
                String e3 = editText3.getText().toString();
                String e4 = editText4.getText().toString();

//                check if everything is ok using try and catch
                try {
//                    Turn the strings above into double
                    double a = Double.parseDouble(e1);
                    double b = Double.parseDouble(e2);
                    double c = Double.parseDouble(e3);
                    double d = Double.parseDouble(e4);

//                    check if numbers are right
                    if (a > 15 || b > 25 || c > 30 || d > 30) {
                        Toast.makeText(MainActivity.this, "Wrong Input(s)!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //sum the grade then set it
                    double result = a + b + c + d;

//                    default grade value
                    String grade = "F";
                    if (result >= 60 && result <70) {
                        grade = "D";
                        textView.setTextColor(getResources().getColor(R.color.D));
                    } else if (result >= 70 && result <80) {
                        grade = "C";
                        textView.setTextColor(getResources().getColor(R.color.C));
                    } else if (result >= 80 && result <90) {
                        grade = "B";
                        textView.setTextColor(getResources().getColor(R.color.B));

                    } else if (result >= 90 && result <101) {
                        grade = "A";
                        textView.setTextColor(getResources().getColor(R.color.A));
                        if (player == null) {
                            player = MediaPlayer.create(MainActivity.this, R.raw.aster);
                            player.start();
                        }
                    } else {
                        textView.setTextColor(getResources().getColor(R.color.F));
                    }
                    textView.setText(String.valueOf(result) + "% | " + grade);
                } catch (Exception ex) {
//                    in case of big errors
                    Toast.makeText(MainActivity.this, "Something is wrong!", Toast.LENGTH_SHORT).show();
                    textView.setText("Something is wrong!");
                    textView.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });
    }


}