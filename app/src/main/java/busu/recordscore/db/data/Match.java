package busu.recordscore.db.data;

import com.google.auto.value.AutoValue;
import com.siimkinks.sqlitemagic.annotation.Id;
import com.siimkinks.sqlitemagic.annotation.Table;


/**
 * Created by adrianbusuioc on 12/27/16.
 */

@Table(persistAll = true)
@AutoValue
public abstract class Match {
    @Id
    public abstract long id();

    public abstract long date();

    public abstract PlayingTable table();

    public abstract Player team1Defense();

    public abstract Player team1Attack();

    public abstract Player team2Defense();

    public abstract Player team2Attack();

    public abstract int team1Score();

    public abstract int team2Score();

    public Match create(long dateMs,
                        PlayingTable table,
                        Player team1Defense,
                        Player team1Attack,
                        Player team2Defense,
                        Player team2Attack,
                        int team1Score,
                        int team2Score) {
        return new AutoValue_Match(0, dateMs, table, team1Defense, team1Attack, team2Defense, team2Attack, team1Score, team2Score);
    }

}
