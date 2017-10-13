package hc.com.recyclerview_more;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现Recyclerview多布局效果
 * 1.搭建环境（添加依赖，添加控件，初始化控件）
 * 2.初始化数据
 * 3.创建适配器
 * 4.设置布局管理器
 */
public class MainActivity extends AppCompatActivity {
    int colors[]=new int[]{android.R.color.holo_blue_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light};
    private List<Data> list=new ArrayList<>();
    private RecyclerView mRecycler;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();//初始化数据
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        //设置布局管理器，三个参数：1.上下文，  2.规定方向  3.正着还是反着
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycler.setLayoutManager(linearLayoutManager);
        //做了一个监听器，根据不同的类型，让其显示是一行还是两行

        final GridLayoutManager manager=new GridLayoutManager(this,2);
        mRecycler.setLayoutManager(linearLayoutManager);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                //拿一下当前Item是什么类型Type
//                int type=mRecycler.getAdapter().getItemViewType(position);
//                //根据类型，决定GridLayoutManager，一行占用几列
//                if (type==MyAdapter.TYPE_THREE){
//                    return  manager.getSpanCount();
//                }else {
//                    return 1;
//                }
//            }
//        });

        adapter = new MyAdapter(this, list);
        mRecycler.setAdapter(adapter);
    }


    //初始化数据

    /**
     * Type:分类型
     * String  name字符串  String content字符串  ImageView 图片
     */
    private void initData() {

        //创建20条Item
        for (int i = 0; i < 20; i++) {
//            int type = (int) (Math.random() * 3 + 1);
            int type = 0;
            if (i < 5 || (i > 15 && i < 20)) {

                type = 1;
            } else if (i >= 5 && i < 10) {
                type = 2;
            } else {
                type = 3;
            }

            //创建Bean类
            Data bean = new Data();
            //实际开发，则是解析服务器拿到的数据
            bean.image=colors[type-1];
            bean.type=type;
            bean.name="Name+"+i;
            bean.contentImage=colors[(type+1)%3];
            bean.content="hahaha+"+i;
            list.add(bean);

        }
    }
}
