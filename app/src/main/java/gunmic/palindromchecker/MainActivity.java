package gunmic.palindromchecker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView titleTextView;
        TextView inputTextView;
        final EditText inputText;
        final TextView outputText;

        titleTextView = findViewById(R.id.titleTextView);
        inputTextView = findViewById(R.id.inputTextView);
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        Button checkButton = (Button) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String inputString = inputText.getText().toString();

                if(!isEmpty(inputString)){
                    if(hasLength(inputString)){
                        if(isPalindrom(inputString)){
                            outputText.setText("Palindrom!");
                        }
                        else
                            outputText.setText("Kein Palindrom!");
                    }
                    else
                        outputText.setText("Text zu kurz (>=5)!");
                }
                else
                    outputText.setText("Kein Text eingegeben!");
            }
        });
    }

    public boolean isPalindrom(String inputString){
        return inputString.equals(new StringBuilder(inputString).reverse().toString());
    }

    public boolean hasLength(String inputString){
        return inputString.length() >= 5;
    }

    public boolean isEmpty(String inputString){
        return inputString.length() == 0;
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
}
