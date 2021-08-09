package com.example.glidetest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glidetest.model.DataModeOne;
import com.example.glidetest.model.DataModeThree;
import com.example.glidetest.model.DataModeTwo;
import com.example.glidetest.model.DataModel;
import com.example.glidetest.R;
import com.example.glidetest.widget.TypeOneViewHolder;
import com.example.glidetest.widget.TypeThreeViewHolder;
import com.example.glidetest.widget.TypeTwoViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    private LayoutInflater mLayoutInflater;

    public DemoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    private ArrayList<DataModeOne> list1;
    private ArrayList<DataModeTwo> list2;
    private ArrayList<DataModeThree> list3;
    private ArrayList<Integer> types = new ArrayList<>();
    private Map<Integer, Integer> mPosition = new HashMap<>();

    /**
     * 创建一个方法供外面操作此数据
     */
    public void addList(ArrayList<DataModeOne> list1, ArrayList<DataModeTwo> list2, ArrayList<DataModeThree> list3) {
        addListByType(TYPE_ONE, list1);
        addListByType(TYPE_TWO, list2);
        addListByType(TYPE_THREE, list3);

        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }

    private void addListByType(int type, ArrayList list) {
        mPosition.put(type, types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - mPosition.get(viewType);
        switch (viewType) {
            case DataModel.TYPE_ONE:
                ((TypeOneViewHolder) holder).bindHolder(list1.get(realPosition));
                break;
            case DataModel.TYPE_TWO:
                ((TypeTwoViewHolder) holder).bindHolder(list2.get(realPosition));
                break;
            case DataModel.TYPE_THREE:
                ((TypeThreeViewHolder) holder).bindHolder(list3.get(realPosition));
                break;
        }
    }

    /**
     * 多种布局时候至关重要的方法
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //得到不同的布局类型
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
