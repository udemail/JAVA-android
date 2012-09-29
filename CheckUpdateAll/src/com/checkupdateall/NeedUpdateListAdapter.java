package com.checkupdateall;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NeedUpdateListAdapter extends BaseAdapter {

	Context context;
	ArrayList<ApplicationInfo> needUpdateList = new ArrayList<ApplicationInfo>();
	public NeedUpdateListAdapter(Context context, ArrayList<ApplicationInfo> newNeedUpdateList){
		this.context = context;
		needUpdateList.clear();
		for(int i = 0; i<newNeedUpdateList.size(); i++){
			needUpdateList.add(newNeedUpdateList.get(i));
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return needUpdateList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return needUpdateList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View newView = convertView;
		final ApplicationInfo appItem = needUpdateList.get(position);
		if(newView == null){
			LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			newView = vi.inflate(R.layout.check_update_list_item, null);
			//newView.setClickable(true);加上此句ListViewi点击无响应，不知道是为什么
		}
		TextView appName = (TextView)newView.findViewById(R.id.appName);
		ImageView appIcon=(ImageView)newView.findViewById(R.id.icon);
		if(appName != null)
			appName.setText(appItem.appName);
		if(appIcon != null)
			appIcon.setImageDrawable(appItem.appIcon);
		return newView;
	}
	
	public  boolean remove(String packageName){
		boolean flag = false;
		for(int i = 0; i < needUpdateList.size(); i++){
			if(needUpdateList.get(i).packageName.equals(packageName)){
				needUpdateList.remove(i);
				flag = true;
				Log.i("RemovePack", packageName);
				notifyDataSetChanged();
			}
		}
		if(flag){
			flag = false;
			return true;
		}
		return false;
	}
	public void removeAll(){
		needUpdateList.clear();
		notifyDataSetChanged();
	}
}
