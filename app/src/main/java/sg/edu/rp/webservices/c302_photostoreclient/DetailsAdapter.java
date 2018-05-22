package sg.edu.rp.webservices.c302_photostoreclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsAdapter extends ArrayAdapter{
    private ArrayList<Details> details;
    private Context context;
    private TextView tvName, tvDesc;

    public DetailsAdapter(Context context, int resource, ArrayList<Details> objects) {
        super(context, resource, objects);
        details = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.detail_row, parent, false);
        tvName = rowView.findViewById(R.id.tvName);
        tvDesc = rowView.findViewById(R.id.tvDesc);
        Details currDetail = details.get(position);
        tvName.setText(currDetail.getTitle());
        String desc = currDetail.getDescription() + "\nCreated By: " + currDetail.getCreated_by() + "\n" + currDetail.getImage();
        tvDesc.setText(desc);

        return rowView;
    }
}
