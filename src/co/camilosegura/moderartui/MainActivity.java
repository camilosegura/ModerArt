/**
 * ModerArt
 * Copyright (C) 2015  Camilo Segura
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License,
 * with the "Linking Exception", which can be found at the license.txt
 * file in this program.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 */
package co.camilosegura.moderartui;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * 
 * @author Camilo Segura
 *
 */
public class MainActivity extends Activity implements OnSeekBarChangeListener {

	private static final String TAG = "MainActivity";
	private TextView tvYellow;
	private TextView tvGreen;
	private TextView tvRed;
	private TextView tvBlue;
	private SeekBar seekBar;
	private DialogFragment mDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvYellow = (TextView) findViewById(R.id.tvYellow);
        tvGreen = (TextView) findViewById(R.id.tvGreen);
        tvRed = (TextView) findViewById(R.id.tvRed);
        tvBlue = (TextView) findViewById(R.id.tvBlue);
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setMax(200);
        seekBar.setOnSeekBarChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            mDialog = ModerDialog.newInstance();
            mDialog.show(getFragmentManager(), getResources().getString(R.string.go_moma));
        }
        return super.onOptionsItemSelected(item);
    }


	public void onProgressChanged(SeekBar item, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onProgressChanged: " + progress );
		
		tvYellow.setBackgroundColor(getResources().getColor(R.color.yellow) + progress);
		tvGreen.setBackgroundColor(getResources().getColor(R.color.green) + progress);
		tvRed.setBackgroundColor(getResources().getColor(R.color.red) + progress);
		tvBlue.setBackgroundColor(getResources().getColor(R.color.blue) + progress);
		
	}


	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
}
