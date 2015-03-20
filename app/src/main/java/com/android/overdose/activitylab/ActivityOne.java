package com.android.overdose.activitylab;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

	// Lifecycle counters
    int mCreate = 0;
    int mRestart = 0;
    int mStart = 0;
    int mResume = 0;

    EditText mTvCreate = null;
    EditText mTvRestart = null;
    EditText mTvStart = null;
    EditText mTvResume = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

        mTvCreate = (EditText) findViewById(R.id.create_counter);
        mTvRestart = (EditText) findViewById(R.id.restart_counter);
        mTvStart =  (EditText) findViewById(R.id.start_counter);
        mTvResume = (EditText) findViewById(R.id.resume_counter);

        disableEditText(mTvCreate);
        disableEditText(mTvRestart);
        disableEditText(mTvStart);
        disableEditText(mTvResume);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to
				// start


				// Launch the Activity using the intent

			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable


		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method

	}

    // Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");

	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface

    }

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable

	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {

		mTvCreate.setText(String.valueOf(mCreate));
		mTvStart.setText(String.valueOf(mStart));
		mTvResume.setText(String.valueOf(mResume));
		mTvRestart.setText(String.valueOf(mRestart));

	}

    /**
     * Disables the EditText so that it only shows the text but can't be edited
     * @param mEditText The EditText to be disables
     */
    private void disableEditText(EditText mEditText) {
        mEditText.setFocusable(false);
        mEditText.setEnabled(false);
        mEditText.setClickable(false);
        mEditText.setFocusable(false);
        mEditText.setInputType(0);
    }
}
