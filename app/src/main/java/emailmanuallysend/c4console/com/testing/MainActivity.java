package emailmanuallysend.c4console.com.testing;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button manuallyEmailbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manuallyEmailbutton=(Button)findViewById(R.id.manuallyEmailbutton);

        // Email send Manually
        manuallyEmailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manuallyEmailSend();
            }
        });

    }

    private void manuallyEmailSend(){
        String[] TO = {"sender@gmail.com"};
        String[] CC = {"receiver@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is a Subject Line.");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello Team,\n\n This is a body message.\n\n Thanks,\nTeam");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            // Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
