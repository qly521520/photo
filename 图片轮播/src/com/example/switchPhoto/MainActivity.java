package com.example.switchPhoto;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import domain.Ad;

public class MainActivity extends Activity
{
	private ViewPager viewpager;
	TextView tv;
List<Ad> list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		initView();
		initData();
		
	}

	private void initData()
	{
		list=new ArrayList<Ad>();
		list.add(new Ad(R.drawable.a, "巩俐不低俗，我就不能低俗"));
		list.add(new Ad(R.drawable.b, "朴树又回来了，再唱经典老歌引百万人同唱啊"));
		list.add(new Ad(R.drawable.c, "揭秘北京电影如何升级"));
		list.add(new Ad(R.drawable.d, "乐视网TV版大放送"));
		list.add(new Ad(R.drawable.e, "热血屌丝的反杀"));
		viewpager.setAdapter(new MyPagerAdapter());
		  tv.setText(list.get(0).getTitle());
		viewpager.setOnPageChangeListener(new OnPageChangeListener()
		{
			
			@Override
			public void onPageSelected(int arg0)
			{
			   int    currentpage= viewpager.getCurrentItem();
			      tv.setText(list.get(currentpage).getTitle());
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initView()
	{
		setContentView(R.layout.activity_main);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		tv=(TextView) findViewById(R.id.tv);

	}

	class MyPagerAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1)
		{
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			View view=View.inflate(MainActivity.this, R.layout.item, null);
			   ImageView iamge=(ImageView) view.findViewById(R.id.iv);
			   iamge.setImageResource(list.get(position).getId());
			   container.addView(view);
			return view;
		}

		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			
			container.removeView((View)object);
			}

	

	}
}
