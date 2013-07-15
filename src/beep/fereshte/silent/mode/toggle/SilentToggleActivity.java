package beep.fereshte.silent.mode.toggle;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.widget.Button;

public class SilentToggleActivity extends Activity {

	private AudioManager mAudioManager;
	private boolean mPhoneIsSilent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silent_toggle);
      
        mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        checkIfPhoneIsSilent();
        setButtonClickListener();
     
        
    }    
        
    // Does not detect phones current status and just displays to activate Silent Mode 
    
        private void setButtonClickListener() {
    
        final Button toggleButton = (Button)findViewById(R.id.silent);
        toggleButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		
        	if (mPhoneIsSilent) {
        		//change back to normal mode
        		
        		mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        		mPhoneIsSilent = false;
        		toggleButton.setText("Activate Silent Mode");
        		
        		Toast.makeText(getBaseContext(), "Vibration Mode Activated", 
               		 Toast.LENGTH_LONG).show();
        	}
        		else
        		{
        			//change to silent mode
        			mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        			mPhoneIsSilent = true;
        			toggleButton.setText("Activate Vibration Mode");
        			
        			Toast.makeText(getBaseContext(), "Silent Mode Activated",
                            Toast.LENGTH_LONG).show();
        		}
        		
        	}
        	});
    }
        private void checkIfPhoneIsSilent() {
        	int ringermode = mAudioManager.getRingerMode();
        	if (ringermode == AudioManager.RINGER_MODE_SILENT) {
        		mPhoneIsSilent = true;
        	}
        	else
        	{
        		mPhoneIsSilent = false;
        	}
        }

}