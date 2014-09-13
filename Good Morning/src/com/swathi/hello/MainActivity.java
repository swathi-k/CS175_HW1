package com.swathi.hello;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	boolean buttonspike = false;
	boolean buttonring = false;
	boolean buttonteeth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button spikebutton = (Button) findViewById(R.id.SpikeButton);
        Button ringbutton = (Button) findViewById(R.id.RingButton);
        Button teethbutton = (Button) findViewById(R.id.TeethButton);

        OnClickListener onclickbuttons = new OnClickListener() {
            @Override
            public void onClick(View v) {
            	switch(v.getId()) {	
            		case R.id.SpikeButton:
            			chooseImage(1);
            			break;
            		case R.id.RingButton:
        				chooseImage(2);
        				break;            			
            		case R.id.TeethButton:
        				chooseImage(3);
        				break;
            }
        } };

        spikebutton.setOnClickListener(onclickbuttons);
        ringbutton.setOnClickListener(onclickbuttons);
        teethbutton.setOnClickListener(onclickbuttons);
        
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void chooseImage(int button){
    	ImageView image = (ImageView) findViewById(R.id.faceImage);

    	TextView text = (TextView) findViewById(R.id.wokeUp);

    	
    	//button =1 (spike), =2 (ring), =3 (teeth)
    	if(button == 1) 								  //spike button clicked
    	{
    		buttonspike = !buttonspike;
    		if(buttonspike)
    			text.setText(R.string.JustSpike);
    		else
    			text.setText(R.string.UndoSpike);
    	}
    	else if(button == 2) 							  //ring button clicked
    	{
    		buttonring = !buttonring;
    		if(buttonring)
    			text.setText(R.string.JustRing);
    		else
    			text.setText(R.string.UndoRing);
    	}
    	else 				 							  //teeth button clicked
    	{
    		buttonteeth = !buttonteeth;
    		if(buttonteeth)
    			text.setText(R.string.JustTeeth);
    		else
    			text.setText(R.string.UndoTeeth);
    	}
    	
    	if(buttonspike & buttonring & buttonteeth) 		  //all three buttons clicked
    		image.setImageResource( R.drawable.spikeringteeth);
    	else if(buttonspike & buttonring & !buttonteeth)  // spike button and ring button clicked
    		image.setImageResource( R.drawable.spikering);
    	else if(buttonspike & !buttonring & buttonteeth)  //spike button and teeth button clicked
    		image.setImageResource( R.drawable.spiketeeth);
    	else if(!buttonspike & buttonring & buttonteeth)  //ring button and teeth button clicked
    		image.setImageResource( R.drawable.ringteeth);
    	else if(buttonspike & !buttonring & !buttonteeth) //spike button clicked
    		image.setImageResource( R.drawable.spike);
   		else if(!buttonspike & buttonring & !buttonteeth) //ring button clicked
   			image.setImageResource( R.drawable.ring);
   		else if(!buttonspike & !buttonring & buttonteeth) //teeth button clicked
   			image.setImageResource( R.drawable.teeth);
   		else											  //nothing clicked
   			image.setImageResource( R.drawable.wakeup);
    	
    }
    
}
