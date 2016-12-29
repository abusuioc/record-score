package busu.recordscore.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.view.RxView;

import busu.recordscore.R;
import busu.recordscore.db.data.PlayingTable;
import busu.recordscore.mvvm.AddRecordModelView;
import rx.functions.Action1;

public class AddRecordActivity extends BaseActivity {

    private final AddRecordModelView mModelView = new AddRecordModelView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        init();

    }

    private void init() {
        RxView.clicks(findViewById(R.id.add_commit)).compose(this.<Void>bindToLifecycle()).subscribe(mModelView.onAddButtonClicked);

//        RxAdapterView.itemSelections(mSpinner).distinctUntilChanged()
//                .doOnNext(new Action1<Integer>() {

        mModelView.doGetBack.compose(this.bindToLifecycle()).compose(observeForUi).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.d(TAG, "Done!");
            }
        });

        initTables();
    }


    private void initTables() {
        ViewGroup tables = (ViewGroup) findViewById(R.id.add_table);
        tables.findViewById(R.id.spinner_add).setOnClickListener(v -> openAddTableDialog());
    }

    private void openAddTableDialog() {
        new AddTableDialog().show(getSupportFragmentManager(), null);
    }

    @Override
    public void onPlayerTableAdded(PlayingTable table) {

    }
}
