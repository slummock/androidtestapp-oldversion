package mobile.computing.assignment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MobileComputingAssignmentPart2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMainlayout();
    }
    private void initEventlayout() {
		setContentView(R.layout.events);
		final Button button = (Button) findViewById(R.id.backbutton);
		button.setOnClickListener(new View.OnClickListener(){
	        	public void onClick(View v) 
	        	{
	        		initMainlayout();
	        	}
	    });
		
	}
    private void initFacilitylayout() {
		setContentView(R.layout.facilities);
		final Button button = (Button) findViewById(R.id.backbutton);
		
		final Spinner spinner = (Spinner)findViewById(R.id.spinnerFacilities);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		                this, R.array.facilityNames, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter); 
		final TextView textFacilityDesc = (TextView)findViewById(R.id.facilityDesc);
		final String[] strArrFacDesc = getResources().getStringArray(R.array.facilityDesc);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		       textFacilityDesc.setText(strArrFacDesc[position]);
		    }


			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		button.setOnClickListener(new View.OnClickListener(){
	        	public void onClick(View v) 
	        	{
	        		initMainlayout();
	        	}
	    });
		
	}
    private void initOpenTimeslayout() {
		setContentView(R.layout.opentimes);
		
		final Button button = (Button) findViewById(R.id.backbutton);
		button.setOnClickListener(new View.OnClickListener(){
	        	public void onClick(View v) 
	        	{
	        		initMainlayout();
	        	}
	    });
		
	}
    private void initMainlayout() {
        setContentView(R.layout.main);  
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() 
        {
        	public void onClick(View v) 
        	{
        		final RadioGroup radiogroup = (RadioGroup)findViewById(R.id.radioGroup1);
                final int radioID = radiogroup.getCheckedRadioButtonId();
                
                switch(radioID)
                {
                case R.id.radioEvents:
                	initEventlayout();
                break;
                case R.id.radioFacilities:
                	initFacilitylayout();
                break;
                case R.id.radioOpenTimes:
                	initOpenTimeslayout();
                break;
                }
        	}

			
        });      
    }
}