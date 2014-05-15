package com.example.nfcpayload;


import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ReadPayLoadActivity extends Activity {
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_pay_load);
		
		tv = (TextView)findViewById(R.id.text_view);
		
		 // see if app was started from a tag and show superid
        Intent intent = getIntent();
        if(intent.getType() != null && intent.getType().equals(MimeType.NFC_DEMO)) {
        	Parcelable[] rawMsgs = getIntent().getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage msg = (NdefMessage) rawMsgs[0];
            NdefRecord cardRecord = msg.getRecords()[0];
            String superid = new String(cardRecord.getPayload());
            tv.setText(superid);
       }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_read_pay_load, menu);
		return true;
	}

}
