package eu.whrl.abm;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import eu.whrl.abm.examples.Fibonacci;

public class ABMAsyncTask extends AsyncTask<Void, Void, Long> {

	private TextView resultText;
	private String tag = "ABM";
	private boolean lastRunSuccessful = false;
	
	public ABMAsyncTask(View view) {
		resultText = (TextView) view;
	}
	
	protected void onPreExecute() {
		resultText.setText("Execution time: (running...)");
		Log.i(tag, "ABM Start");
	}
	
	protected Long doInBackground(Void... voids) {
		// 
		// !!! Change Fibonacci to your benchmark class. !!! 
		//
		// Instantiate your benchmark class
		ABM benchmark = new Fibonacci();
		
		// Do any benchmark-related setup that you don't want to be timed
		benchmark.prepare();
		
		long timeStart = System.currentTimeMillis();
		
		// Run your benchmark - everything within this method will be timed!
		benchmark.run();
		
		long timeEnd = System.currentTimeMillis();
		
		lastRunSuccessful = benchmark.verify();
		
		return (timeEnd - timeStart);
	}
	
	protected void onPostExecute(Long runtime) {
		if (lastRunSuccessful) {
			resultText.setText("Execution time: " + runtime + " ms");
			Log.i(tag, "ABM End - Time: " + runtime + " ms");
		} else {
			resultText.setText("Execution time: " + runtime + " ms\nVerify failed!");
			Log.i(tag, "ABM End - Time: " + runtime + " ms - Verify failed!");
		}
		
	}
}
