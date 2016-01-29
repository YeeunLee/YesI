package com.yesi.couple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SubActivity2_1 extends Activity {

	private TextView resultTxt;
	private String myName;
	private String yourName;
	private Algorithm al;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub2_1);
		
		Intent intent = this.getIntent();
		myName = intent.getStringExtra("myName");
		yourName = intent.getStringExtra("yourName");
		resultTxt = (TextView)findViewById(R.id.percentTxt);
		
		al = new Algorithm();

		int myPercent = al.percent(myName, yourName);
		int yourPercent = al.percent(yourName, myName);
		String result;

		SQLiteDBListHelper helper = new SQLiteDBListHelper(this);
		
		if(myPercent>yourPercent)
		{
			result = myName+"(��)�� "+yourName+"��/�� \n�� ����������~";
			
		}
		else if(myPercent==yourPercent)
		{
			result="õ�������̳� \n��ȥ��";
		}
		else
		{
			result = yourName+"(��)�� "+myName+"��/�� \n�� ����������~";
		}	

		resultTxt.setText(result);
		helper.insertSub2(new TableSub2(myName,yourName,result));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity2_1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
