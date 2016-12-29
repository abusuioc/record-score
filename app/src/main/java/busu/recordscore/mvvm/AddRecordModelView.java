package busu.recordscore.mvvm;

import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by adrianbusuioc on 12/27/16.
 */

public class AddRecordModelView implements ModelView{

    //inputs
    public final Action1<Void> onAddButtonClicked = new Action1<Void>() {
        @Override
        public void call(Void o) {

        }
    };


    //outputs
    public final PublishSubject doGetBack = PublishSubject.create();

    @Override
    public void consolidate() {

    }
}
