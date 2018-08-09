package com.emailxl.deviceid.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.emailxl.deviceid.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Output> {
    private LayoutInflater mInflater;
    private List<Output> mOutputs;
    private int mViewResourceId;

    public ListAdapter(Context context, int viewResourceId, List<Output> outputs) {
        super(context, viewResourceId, outputs);

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = viewResourceId;
        mOutputs = outputs;
    }

    @Override
    public @NonNull View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(mViewResourceId, null);

            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.name);
            holder.tvValue = convertView.findViewById(R.id.value);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Output output = mOutputs.get(position);

        holder.tvName.setText(output.getName());
        holder.tvValue.setText(output.getValue());

        return convertView;
    }

    private static class ViewHolder {
        TextView tvName;
        TextView tvValue;
    }
}
