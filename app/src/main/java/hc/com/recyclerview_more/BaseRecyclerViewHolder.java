package hc.com.recyclerview_more;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 抽取基类原则
 * 1.子类共有，且实现相同的逻辑，抽取到基类
 * 2.子类共有，但实现不同的逻辑，以抽象方法形式定义到基类中
 *
 * Created by YU on 2017/9/8.
 */

public abstract class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindHolder(Data data);
}
