package busu.recordscore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
    }


    class SpinnerAdapter extends ArrayAdapter<Object> {

        public SpinnerAdapter(Context context, int resource) {
            super(context, resource);
        }
    }
}
