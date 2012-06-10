package com.mobilelibrary.adapter;

import com.mobilelibrary.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonInformationAdapter extends BaseAdapter {
	
	private Context context;
	
	public PersonInformationAdapter(Context context){
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.person_imfomation_item, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.item_img);
			holder.textView = (TextView) convertView.findViewById(R.id.item_content);
			holder.contentTextView = (TextView) convertView.findViewById(R.id.item_text);
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		if (position == 0) {
			holder.imageView.setImageResource(R.drawable.modi_pwd);
			holder.textView.setText(context.getResources().getString(R.string.person_id));
			holder.contentTextView.setText("GS1121000");
			convertView.setBackgroundResource(R.drawable.listview_top_bg);
		}else if (position == 1) {
			holder.imageView.setImageResource(R.drawable.about);
			holder.textView.setText(context.getResources().getString(R.string.person_academy));
			holder.contentTextView.setText("软件学院");
			convertView.setBackgroundResource(R.drawable.listview_middle_bg);
		}else if (position == 2) {
			holder.imageView.setImageResource(R.drawable.feedback);
			holder.textView.setText(context.getResources().getString(R.string.person_class));
			holder.contentTextView.setText("移动云计算A5");
			convertView.setBackgroundResource(R.drawable.listview_bottom_bg);
		}
		
		return convertView;
	}
	
	private class ViewHolder{
		private ImageView imageView;
		private TextView textView;
		private TextView contentTextView;
	}

}
