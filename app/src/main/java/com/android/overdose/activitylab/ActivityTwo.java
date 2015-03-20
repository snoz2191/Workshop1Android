package com.android.overdose.activitylab;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

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
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

        disableEditText(mTvCreate);
        disableEditText(mTvRestart);
        disableEditText(mTvStart);
        disableEditText(mTvResume);

        Button closeButton = (Button) findViewById(R.id.bClose);
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				
			
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


        checkForPermissions();
	}

    // Lifecycle callback methods overrides

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
		// Save counter state information with a collection of key-value pairs
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
     * Checks if the internet permission is granted and shows a message accordingly
     */
    private void checkForPermissions() {
        PackageManager pm = this.getPackageManager();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        int hasPermission = pm.checkPermission(
                Manifest.permission.INTERNET,
                this.getPackageName());


        if (hasPermission == PackageManager.PERMISSION_GRANTED) {
            alert.setTitle("Permission Granted!");
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.big_hero);
            alert.setView(imageView);
        } else {
            alert.setTitle("Permission Denied!");
            alert.setMessage("You don't have the necessary permissions to access the Internet!");
        }

        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.show();
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
