package com.mobilelibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.mobilelibrary.R;
/**
 * my library 
 * @author Ryan
 *
 */
public class MainPageActivity extends BaseActivity {

	private Button btn_my_shelf;
	private Button btn_personal_information;
	private Button btn_book_borrowed;
	private Button btn_borrow_record;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page);
		
		setTopTitle(this,R.string.my_library);
		
		//�ҵ����
		btn_my_shelf = (Button)findViewById(R.id.btn_my_shelf);
		
		btn_my_shelf.setOnClickListener(mBookShelfListener);
		
		//������Ϣ
		btn_personal_information = (Button)findViewById(R.id.btn_personal_information);

		btn_personal_information.setOnClickListener(mPersonInfomationListener);
		
		//�ѽ���Ŀ
		btn_book_borrowed = (Button)findViewById(R.id.btn_book_borrowed);
		btn_book_borrowed.setOnClickListener(mBookBorrowedListener);
		
		
		btn_borrow_record = (Button) this.findViewById(R.id.btn_book_records);
		btn_borrow_record.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent person_information_intent = new Intent(MainPageActivity.this,BookBorrowRecordActivity.class);
				startActivity(person_information_intent);
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	//�ҵ���ܰ�ť������
	private OnClickListener  mBookShelfListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent book_shelf_intent = new Intent(MainPageActivity.this,BookShelfActivity.class);
			startActivity(book_shelf_intent);
		}
	};
	
	//������Ϣ��ť������
	private OnClickListener  mPersonInfomationListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent person_information_intent = new Intent(MainPageActivity.this,PersonInformation.class);
			startActivity(person_information_intent);
		}
	};
	
	// borrowed book listener
	private OnClickListener  mBookBorrowedListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent book_borrowed_intent = new Intent(MainPageActivity.this,BookBorrowedActivity.class);
			startActivity(book_borrowed_intent);
		}
	};
	
	

	
}
