package digitalsoftware.com.destinasiwisata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProfileAct extends AppCompatActivity {

    private String title = "Profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setActionBarTitle(title);


    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
