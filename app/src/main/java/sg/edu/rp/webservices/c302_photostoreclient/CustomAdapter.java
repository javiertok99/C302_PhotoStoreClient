package sg.edu.rp.webservices.c302_photostoreclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    private ArrayList<Categories> categories;
    private Context context;
    private TextView tvName, tvDesc;

    public CustomAdapter(Context context, int resource, ArrayList<Categories> objects) {
        super(context, resource, objects);
        categories = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvName = rowView.findViewById(R.id.tvCatName);
        tvDesc = rowView.findViewById(R.id.tvCatDesc);
        Categories currCat = categories.get(position);
        tvName.setText(currCat.getName());
        tvDesc.setText(currCat.getDesc());

        return rowView;
    }
}
