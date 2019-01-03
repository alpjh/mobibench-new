package com.example.esos.andctest.MobiBench;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.esos.andctest.R;

public class First extends Activity {


	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first);

		ImageButton btn = (ImageButton)findViewById(R.id.start_button);
		btn.setOnClickListener(new View.OnClickListener(){
			Intent intent;
			public void onClick(View v){
				Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				vibrator.vibrate(100);

				SharedPreferences prefs = getSharedPreferences("Setting", MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putBoolean("init_flag",false);
				editor.commit();

				intent = new Intent(First.this, TabMain.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);

			}

		});
	}

	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			setResult(RESULT_CANCELED);
			this.finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
