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


}
