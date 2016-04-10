
package cnc.org.zigbeeapp;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.List;

/**
 * Created by Jonas on 31.03.2016.
 */
public class LvAdapter extends ArrayAdapter<String> {

    public LvAdapter(Context context, int resource) {
        super(context, resource);
    }

    public LvAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public LvAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public LvAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public LvAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public LvAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

}
