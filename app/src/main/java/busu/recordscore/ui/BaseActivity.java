package busu.recordscore.ui;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import busu.recordscore.db.data.PlayingTable;
import busu.recordscore.rx.ObserveForUITransformer;
import rx.Observable;

/**
 * Created by adrianbusuioc on 12/28/16.
 */

public abstract class BaseActivity extends RxAppCompatActivity implements DialogListener{

    public final static String TAG = "recS";

    protected final Observable.Transformer observeForUi = new ObserveForUITransformer();
}
