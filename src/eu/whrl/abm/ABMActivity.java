package eu.whrl.abm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ABMActivity extends Activity {
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView resultText = (TextView) this.findViewById(R.id.result);
        
        // Get the reference to the start button
        Button startButton = (Button) this.findViewById(R.id.startbutton);
        
        // Attach the button's listener
        startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ABMAsyncTask task = new ABMAsyncTask(resultText);
				task.execute();
			}
		});
    }
    
    
}