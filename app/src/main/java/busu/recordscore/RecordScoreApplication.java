package busu.recordscore;

import android.app.Application;

import com.siimkinks.sqlitemagic.SqliteMagic;

/**
 * Created by adrianbusuioc on 12/27/16.
 */

public class RecordScoreApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SqliteMagic.init(this);
        SqliteMagic.setLoggingEnabled(true);
    }
}
