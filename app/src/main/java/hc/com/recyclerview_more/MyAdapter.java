package hc.com.recyclerview_more;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YU on 2017/9/8.
 * 多布局适配器
 * 1.创建一个类继承RecyclerView的Adapter
 * 2.定义RecyclerView.ViewHolder以方便多布局
 * 3.创建三种类型的ITem布局及Viewholder
 * 4.使用getitemViewType方法
 * 5.在OnCreateViewHolder和OnBindViewHolder进行ViewHolder的创建，数据的判断加载
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Data> list;
    public static final int TYPE_ONE=1;
    public static final int TYPE_TWO=2;
    public static final int TYPE_THREE=3;
    public MyAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建不同的 ViewHolder
        View view;
        //根据viewtype来创建条目
        if (viewType==TYPE_ONE){
            view=View.inflate(context,R.layout.item1,null);
            return new TypeOneViewHolder(view);
        }else if (viewType==TYPE_TWO){
            view=View.inflate(context,R.layout.item2,null);
            return new TypeTwoViewHolder(view);
        }else if (viewType==TYPE_THREE){
            view=View.inflate(context,R.layout.item3,null);
            return new TypeThreeViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type=getItemViewType(position);
        Data bean=list.get(position);
        if (type==TYPE_ONE){
            TypeOneViewHolder one= (TypeOneViewHolder) holder;
            one.imagel.setImageResource(bean.image);
            one.name.setText(bean.name);
        }else if (type==TYPE_TWO){
            TypeTwoViewHolder two= (TypeTwoViewHolder) holder;
            two.imagel.setImageResource(bean.contentImage);
            two.name.setText(bean.name);
            two.content.setText(bean.content);
        }else {
            TypeThreeViewHolder three= (TypeThreeViewHolder) holder;
            three.imagel.setImageResource(bean.image);
            three.name.setText(bean.name);
            three.content.setText(bean.content);
            three.image2.setImageResource(bean.contentImage);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
    //根据不同的Position位置，返回不同类型
    @Override
    public int getItemViewType(int position) {
        Data data=list.get(position);
        if (data.type==1){
            return TYPE_ONE;
        }else if (data.type==2){
            return TYPE_TWO;
        }else if (data.type==3){
            return TYPE_THREE;
        }
        return super.getItemViewType(position);
    }
    static class TypeOneViewHolder extends RecyclerView.ViewHolder{
        ImageView imagel;
        TextView name;
        public TypeOneViewHolder(View itemView) {
            super(itemView);
            imagel=itemView.findViewById(R.id.avatar);
            name=itemView.findViewById(R.id.name);
        }
    }
    static class TypeTwoViewHolder extends RecyclerView.ViewHolder{
        ImageView imagel;
        TextView name;
        TextView content;
        public TypeTwoViewHolder(View itemView) {
            super(itemView);
            imagel=itemView.findViewById(R.id.avatar);
            name=itemView.findViewById(R.id.name);
            content=itemView.findViewById(R.id.content);
        }
    }
    static class TypeThreeViewHolder extends BaseRecyclerViewHolder{
        ImageView imagel,image2;
        TextView name,content;
        public TypeThreeViewHolder(View itemView) {
            super(itemView);
            imagel=itemView.findViewById(R.id.avatar);
            image2=itemView.findViewById(R.id.contentImage);
            name=itemView.findViewById(R.id.name);
            content=itemView.findViewById(R.id.content);


        }

        @Override
        public void bindHolder(Data data) {

        }
    }
}
