package busu.recordscore.mvvm;

import android.text.TextUtils;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by adrianbusuioc on 12/28/16.
 */

public class AddTableModelView implements ModelView {

    //inputs
    final Action1<Void> onAddButtonClicked = new Action1<Void>() {
        @Override
        public void call(Void aVoid) {
        }
    };

    public Observable<CharSequence> inTeamNameChanged;

    public Observable<Integer> inTeam1ColorChanged;

    public Observable<Integer> inTeam2ColorChanged;


    //outputs
    public Observable<Boolean> outFormValid;


    @Override
    public void consolidate() {
        outFormValid = Observable.combineLatest(inTeamNameChanged, inTeam1ColorChanged, inTeam2ColorChanged, (name, color1, color2) -> !TextUtils.isEmpty(name));
    }
}
