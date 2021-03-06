package com.example.myapplication1;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView item_read, item_books, item_find, item_mine;
    private ViewPager vp;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FouthFragment fouthFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;


    String[] items = new String[]{"阅读", "我的书籍", "发现", "我的"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        item_read.setTextColor(Color.parseColor("#00CCFF"));

        //ViewPager的监听事件
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*此方法在页面被选中时调用*/
//                item_books.setText(items[position]);
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0 ==1的时辰默示正在滑动，
                arg0==2的时辰默示滑动完毕了，
                arg0==0的时辰默示什么都没做。*/
            }
        });
    }

    /**
     * 初始化布局View
     */
    private void initViews() {

        item_read = (TextView) findViewById(R.id.item_read);
        item_books = (TextView) findViewById(R.id.item_my_books);
        item_find = (TextView) findViewById(R.id.item_find);
        item_mine = (TextView) findViewById(R.id.item_mine);

        item_read.setOnClickListener(this);
        item_books.setOnClickListener(this);
        item_find.setOnClickListener(this);
        item_mine.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.mainViewPager);
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fouthFragment = new FouthFragment();

        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
        mFragmentList.add(threeFragment);
        mFragmentList.add(fouthFragment);
    }

    /**
     * 点击底部Text 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_read:
                vp.setCurrentItem(0, true);
                break;
            case R.id.item_my_books:
                vp.setCurrentItem(1, true);
                break;
            case R.id.item_find:
                vp.setCurrentItem(2, true);
                break;
            case R.id.item_mine:
                vp.setCurrentItem(3, true);
                break;
        }
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */

    private void changeTextColor(int position) {
        if (position == 0) {
            item_read.setTextColor(Color.parseColor("#00CCFF"));
            item_books.setTextColor(Color.parseColor("#000000"));
            item_find.setTextColor(Color.parseColor("#000000"));
            item_mine.setTextColor(Color.parseColor("#000000"));

            Drawable read = getResources().getDrawable(R.mipmap.book_on);
            read.setBounds(0, 0, read.getMinimumWidth(), read.getMinimumHeight());
            item_read.setCompoundDrawables(null, read, null, null);
            Drawable books = getResources().getDrawable(R.mipmap.books_off);
            books.setBounds(0, 0, books.getMinimumWidth(), books.getMinimumHeight());
            item_books.setCompoundDrawables(null, books, null, null);
            Drawable find = getResources().getDrawable(R.mipmap.find_off);
            find.setBounds(0, 0, find.getMinimumWidth(), find.getMinimumHeight());
            item_find.setCompoundDrawables(null, find, null, null);
            Drawable mine = getResources().getDrawable(R.mipmap.mine_off);
            mine.setBounds(0, 0, mine.getMinimumWidth(), mine.getMinimumHeight());
            item_mine.setCompoundDrawables(null, mine, null, null);
        } else if (position == 1) {
            item_books.setTextColor(Color.parseColor("#00CCFF"));
            item_read.setTextColor(Color.parseColor("#000000"));
            item_find.setTextColor(Color.parseColor("#000000"));
            item_mine.setTextColor(Color.parseColor("#000000"));
            Drawable read = getResources().getDrawable(R.mipmap.book_off);
            read.setBounds(0, 0, read.getMinimumWidth(), read.getMinimumHeight());
            item_read.setCompoundDrawables(null, read, null, null);
            Drawable books = getResources().getDrawable(R.mipmap.books_on);
            books.setBounds(0, 0, books.getMinimumWidth(), books.getMinimumHeight());
            item_books.setCompoundDrawables(null, books, null, null);
            Drawable find = getResources().getDrawable(R.mipmap.find_off);
            find.setBounds(0, 0, find.getMinimumWidth(), find.getMinimumHeight());
            item_find.setCompoundDrawables(null, find, null, null);
            Drawable mine = getResources().getDrawable(R.mipmap.mine_off);
            mine.setBounds(0, 0, mine.getMinimumWidth(), mine.getMinimumHeight());
            item_mine.setCompoundDrawables(null, mine, null, null);
        } else if (position == 2) {
            item_find.setTextColor(Color.parseColor("#00CCFF"));
            item_read.setTextColor(Color.parseColor("#000000"));
            item_books.setTextColor(Color.parseColor("#000000"));
            item_mine.setTextColor(Color.parseColor("#000000"));
            Drawable read = getResources().getDrawable(R.mipmap.book_off);
            read.setBounds(0, 0, read.getMinimumWidth(), read.getMinimumHeight());
            item_read.setCompoundDrawables(null, read, null, null);
            Drawable books = getResources().getDrawable(R.mipmap.books_off);
            books.setBounds(0, 0, books.getMinimumWidth(), books.getMinimumHeight());
            item_books.setCompoundDrawables(null, books, null, null);
            Drawable find = getResources().getDrawable(R.mipmap.find_on);
            find.setBounds(0, 0, find.getMinimumWidth(), find.getMinimumHeight());
            item_find.setCompoundDrawables(null, find, null, null);
            Drawable mine = getResources().getDrawable(R.mipmap.mine_off);
            mine.setBounds(0, 0, mine.getMinimumWidth(), mine.getMinimumHeight());
            item_mine.setCompoundDrawables(null, mine, null, null);
        } else if (position == 3) {
            item_mine.setTextColor(Color.parseColor("#00CCFF"));
            item_read.setTextColor(Color.parseColor("#000000"));
            item_books.setTextColor(Color.parseColor("#000000"));
            item_find.setTextColor(Color.parseColor("#000000"));
            Drawable read = getResources().getDrawable(R.mipmap.book_off);
            read.setBounds(0, 0, read.getMinimumWidth(), read.getMinimumHeight());
            item_read.setCompoundDrawables(null, read, null, null);
            Drawable books = getResources().getDrawable(R.mipmap.books_off);
            books.setBounds(0, 0, books.getMinimumWidth(), books.getMinimumHeight());
            item_books.setCompoundDrawables(null, books, null, null);
            Drawable find = getResources().getDrawable(R.mipmap.find_off);
            find.setBounds(0, 0, find.getMinimumWidth(), find.getMinimumHeight());
            item_find.setCompoundDrawables(null, find, null, null);
            Drawable mine = getResources().getDrawable(R.mipmap.mine_on);
            mine.setBounds(0, 0, mine.getMinimumWidth(), mine.getMinimumHeight());
            item_mine.setCompoundDrawables(null, mine, null, null);
        }
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();      //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }

}


