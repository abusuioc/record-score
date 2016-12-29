package busu.recordscore.ui;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.veritas1.verticalslidecolorpicker.VerticalSlideColorPicker;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import busu.recordscore.R;
import busu.recordscore.mvvm.AddTableModelView;
import rx.subjects.PublishSubject;

/**
 * Created by adrianbusuioc on 12/28/16.
 */

public class AddTableDialog extends DialogFragment {

    private final AddTableModelView mModelView = new AddTableModelView();

    private ImageView mPlayer1, mPlayer2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_addtables, null);
        //

        mPlayer1 = (ImageView) view.findViewById(R.id.dialog_tables_team1_player);
        mPlayer1.setImageTintMode(PorterDuff.Mode.MULTIPLY);
        mPlayer2 = (ImageView) view.findViewById(R.id.dialog_tables_team2_player);
        mPlayer2.setImageTintMode(PorterDuff.Mode.MULTIPLY);

        RxView.clicks(view.findViewById(R.id.dialog_tables_add)).subscribe();

        mModelView.inTeamNameChanged = RxTextView.textChanges((TextView) view.findViewById(R.id.dialog_tables_name));

        final PublishSubject<Integer> team1Color = PublishSubject.create();
        ((VerticalSlideColorPicker) view.findViewById(R.id.dialog_tables_team1_cp)).setOnColorChangeListener(new VerticalSlideColorPicker.OnColorChangeListener() {
            @Override
            public void onColorChange(int i) {
                team1Color.onNext(i);
            }
        });
        mModelView.inTeam1ColorChanged = team1Color.skip(1).doOnNext(color -> {
            mPlayer1.setImageTintList(ColorStateList.valueOf(color));
        });

        final PublishSubject<Integer> team2Color = PublishSubject.create();
        ((VerticalSlideColorPicker) view.findViewById(R.id.dialog_tables_team2_cp)).setOnColorChangeListener(new VerticalSlideColorPicker.OnColorChangeListener() {
            @Override
            public void onColorChange(int i) {
                team2Color.onNext(i);
            }
        });
        mModelView.inTeam2ColorChanged = team2Color.skip(1).doOnNext(color -> {
            mPlayer2.setImageTintList(ColorStateList.valueOf(color));
        });

        mModelView.consolidate();

        mModelView.outFormValid.subscribe(b -> view.findViewById(R.id.dialog_tables_add).setEnabled(b));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setTitle(R.string.dialog_tables_title);
        builder.setCancelable(true);

        return builder.create();
    }

}
