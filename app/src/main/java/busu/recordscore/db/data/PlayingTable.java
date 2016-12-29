package busu.recordscore.db.data;

import com.google.auto.value.AutoValue;
import com.siimkinks.sqlitemagic.annotation.Id;
import com.siimkinks.sqlitemagic.annotation.Table;


/**
 * Created by adrianbusuioc on 12/27/16.
 */

@Table(persistAll = true)
@AutoValue
public abstract class PlayingTable {

    @Id()
    public abstract long id();

    public abstract String name();

    public abstract int team1IdentifierColor();

    public abstract int team2IdentifierColor();

    @Override
    public String toString() {
        return name();
    }

    public static PlayingTable create(String name,
                                      int team1IdentifierColor,
                                      int team2IdentifierColor) {
        return new AutoValue_PlayingTable(0, name,
                team1IdentifierColor,
                team2IdentifierColor);
    }
}
