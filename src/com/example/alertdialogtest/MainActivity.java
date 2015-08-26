package com.example.alertdialogtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] unitArray = { "1", "2", "3", "4" };
	private ArrayAdapter<String> unitList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		unitList = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_spinner_item, unitArray);
		showAlert();

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

	private void showAlert() {
		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		final View view1 = inflater.inflate(R.layout.dialog_view, null);

		final EditText editText = (EditText) view1.findViewById(R.id.edittext);
		final Spinner sp_unit = (Spinner) view1.findViewById(R.id.sp_unit);
		final TextView et_choose = (TextView) view1
				.findViewById(R.id.et_choose);

		sp_unit.setAdapter(unitList);

		editText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				String unit = sp_unit.getSelectedItem().toString();
				String amount;
				
				if (editText.getText().toString() != ""
						&& editText.getText().toString() != null) {
					amount = editText.getText().toString();
				} else {
					amount = "";
				}
				
				String text = "unit = " + unit + ", amount = " + amount;
				et_choose.setText(text);
			}
		});
		
		sp_unit.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String unit = sp_unit.getSelectedItem().toString();
				String amount;
				
				if (editText.getText().toString() != ""
						&& editText.getText().toString() != null) {
					amount = editText.getText().toString();
				} else {
					amount = "";
				}
				
				String text = "unit = " + unit + ", amount = " + amount;
				et_choose.setText(text);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});

		new AlertDialog.Builder(MainActivity.this).setTitle("選取1")
				.setMessage("請輸入數量").setView(view1)
				.setPositiveButton("確定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).show();

	}

}
