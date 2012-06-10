package com.mobilelibrary.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.mobilelibrary.R;
import com.mobilelibrary.adapter.BookBorrowedAdapter;
import com.mobilelibrary.common.LoadingDialog;
import com.mobilelibrary.dao.BorrowedBookDAO;
import com.mobilelibrary.entity.BookBorrowedEntity;

public class BookBorrowedActivity extends BaseActivity{
	
    private ViewFlipper mViewFlipper;
	private ListView mBorrowedListView;
	ArrayList<BookBorrowedEntity> books = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrowed_book);
		setTopTitle(this,R.string.my_borrowedbook);
		setBackButton(this, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BookBorrowedActivity.this.finish();
			}
		});
		
		mViewFlipper = (ViewFlipper)findViewById(R.id.ViewFlipper);
		
		mBorrowedListView = (ListView)findViewById(R.id.borrowedListView);
		
		new NewTaskGetBorrowedBookFromDB(BookBorrowedActivity.this,
				R.string.wait_msg,
				R.string.wait_msg).execute((Void)null);	
		//if  borrowed book is null
//		if(mBorrowedListView.getCount()==0){
//			mViewFlipper.setDisplayedChild(0);
//		}


    }
	
	// get borrowed book from db
	private class NewTaskGetBorrowedBookFromDB extends LoadingDialog<Void, Integer>{

		private Integer mSearchMode;
		private BaseAdapter mAdapter;

		public NewTaskGetBorrowedBookFromDB(Activity activity, int loadingMsg, int failMsg) {
			super(activity, loadingMsg, failMsg);
		}

		@Override
		public Integer doInBackground(Void... params) {
			
			//get the  books from borrowed DB
			bookSearch();
			return 1;
		}

		@Override
		public void doStuffWithResult(Integer result) {

			mBorrowedListView.setAdapter(mAdapter);
			
			if(mBorrowedListView.getCount() > 0){
				mViewFlipper.setDisplayedChild(0); 
			} else {
				mViewFlipper.setDisplayedChild(1); 
			}
			mBorrowedListView.setOnItemClickListener(mBookClickListener);
		
		}

		private void bookSearch(){
			
			BorrowedBookDAO  borrowedBookDAO = new BorrowedBookDAO(BookBorrowedActivity.this);
			//閿熸枻鎷烽敓鏂ゆ嫹鎷囬敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
			BookBorrowedEntity testBookBorrowedEntity = new BookBorrowedEntity();
			testBookBorrowedEntity.setBookId("1");
			testBookBorrowedEntity.setBookText("Android鍏ラ棬涓庢彁楂");
			testBookBorrowedEntity.setBookImageUrl("1");
			testBookBorrowedEntity.setBookPress("android");
			testBookBorrowedEntity.setBookPressTime("android");
			BookBorrowedEntity testBookBorrowedEntity1 = new BookBorrowedEntity();
			testBookBorrowedEntity1.setBookId("2");
			testBookBorrowedEntity1.setBookText("IOS寮�彂瀹炴垬瀹濆吀");
			testBookBorrowedEntity1.setBookImageUrl("2");
			testBookBorrowedEntity1.setBookPress("android");
			testBookBorrowedEntity1.setBookPressTime("android");
			BookBorrowedEntity testBookBorrowedEntity2 = new BookBorrowedEntity();
			testBookBorrowedEntity2.setBookId("2");
			testBookBorrowedEntity2.setBookText("JavaEE鍏ラ棬鍒扮簿閫");
			testBookBorrowedEntity2.setBookImageUrl("3");
			testBookBorrowedEntity2.setBookPress("android");
			testBookBorrowedEntity2.setBookPressTime("android");
//			borrowedBookDAO.insert(testBookBorrowedEntity);
//			borrowedBookDAO.insert(testBookBorrowedEntity1);
//			borrowedBookDAO.insert(testBookBorrowedEntity2);
			books = new ArrayList<BookBorrowedEntity>();
			books.add(testBookBorrowedEntity);
			books.add(testBookBorrowedEntity1);
			books.add(testBookBorrowedEntity2);
//			books = borrowedBookDAO.query(null, null ,null,null);
			BookBorrowedAdapter bookAdapter = new BookBorrowedAdapter(BookBorrowedActivity.this); 
			bookAdapter.setList(books);
			bookAdapter.setListView(mBorrowedListView);
			mAdapter = bookAdapter;

		
		}

	}
	
	//borrowed book Listener
	private OnItemClickListener mBookClickListener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position,
				long time) {
			Intent   book_info_intent = new Intent(BookBorrowedActivity.this, BookInfoActivity.class);
			book_info_intent.putExtra("bookinfo", position+1);
			startActivity(book_info_intent);
		}

	};

}
