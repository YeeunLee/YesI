package com.yesi.couple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubActivity1_1 extends Activity {

	LinearLayout capLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub1_1);
		Intent intent = this.getIntent();
		String myName = intent.getStringExtra("myName");
		String yourName = intent.getStringExtra("yourName");
		TextView resultTxt = (TextView) findViewById(R.id.resultTxt);
		Algorithm al = new Algorithm();
		String result = al.message(myName, yourName);

		resultTxt.setText(myName + "�� " + yourName + "��\n" + result);

		SQLiteDBListHelper helper = new SQLiteDBListHelper(this);

		helper.insertSub1(new TableSub1(myName, yourName, result));

		Button button = (Button) findViewById(R.id.captureBtn);
		capLayout = (LinearLayout) findViewById(R.id.linearLayout);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity1_1, menu);
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

	public void onClickCaptureBtn(View v) {

		try {
			String dirName = "YouAndI_Dir";
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

			String imgName = format.format(new Date());
			
			File sdCardPath = Environment.getExternalStorageDirectory();
			File dirs = new File(sdCardPath,dirName);

			if (!dirs.exists()) {
				dirs.mkdirs();
			}

			capLayout.buildDrawingCache();
			Bitmap captureView = capLayout.getDrawingCache();
			
			File img = new File(sdCardPath.getAbsolutePath() + "/" + dirName + "/" + imgName
					+ ".jpeg");

			FileOutputStream fos = new FileOutputStream(img);

			captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
			sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
					Uri.parse("file://"+ Environment.getExternalStorageDirectory())));

			shareImge(img);			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void shareImge(File img) {
		// TODO Auto-generated method stub
		
		Uri mSaveImageUri = Uri.fromFile(img); // file�� ��θ� uri�� ����
		Intent intent = new Intent(Intent.ACTION_SEND); // ���� �޼ҵ带 ȣ��.
														// Intent.ACTION_SEND
		intent.setType("image/jpeg"); // jpg �̹����� ���� �ϱ� ���� Type�� ����
		intent.putExtra(Intent.EXTRA_STREAM, mSaveImageUri); // ������ Uri�� ������ ��
		startActivity(Intent.createChooser(intent, "Choose")); // Activity�� �̿��Ͽ�
																// ȣ��
	}
}
