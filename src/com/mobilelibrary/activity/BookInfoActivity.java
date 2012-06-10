package com.mobilelibrary.activity;

import java.util.HashMap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mobilelibrary.R;
import com.mobilelibrary.dao.StoredBookDAO;
import com.mobilelibrary.entity.BookStoredEntity;
import com.umeng.api.sns.UMSnsService;
import com.umeng.api.exp.UMSNSException;
import com.umeng.api.sns.UMSnsService.DataSendCallbackListener;
import com.umeng.api.sns.UMSnsService.RETURN_STATUS;

public class BookInfoActivity extends BaseActivity{
	
    private ListView personInformationListView;
    private ImageButton btn_store;
    private ImageButton btn_share;
    private ImageView bookImageView;
    int bookBorrowedEntity;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info_layout);      
        setTopTitle(this, R.string.book_info);
        
        
        setBackButton(this, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BookInfoActivity.this.finish();
			}
		});
        
        bookImageView = (ImageView) this.findViewById(R.id.viewBook_cover);
        bookBorrowedEntity = (Integer)getIntent().getSerializableExtra("bookinfo");
        
        if (bookBorrowedEntity==1 ) {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.book_recommend_default);
        	bookImageView.setImageBitmap(bmp);
		}
        if (bookBorrowedEntity==2) {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.book6);
        	bookImageView.setImageBitmap(bmp);
		}
        if (bookBorrowedEntity==3) {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.book2);
        	bookImageView.setImageBitmap(bmp);
		}
        btn_store = (ImageButton)findViewById(R.id.btn_status_bar_store);
        
        btn_store.setOnClickListener(mStoreClickListener);
        
        btn_share = (ImageButton)findViewById(R.id.btn_status_bar_share_book);
        
        btn_share.setOnClickListener(mShareClickListener);
   
    }
private OnClickListener mShareClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub]
			HashMap map = new HashMap<String, String>();
			map.put("bookname", "<<J2EE>>");
			UMSnsService.share(BookInfoActivity.this, map, null);
			
	}

};
	private OnClickListener mStoreClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub]
			
			StoredBookDAO storeBookDAO = new StoredBookDAO(BookInfoActivity.this);
			
			if (bookBorrowedEntity == 1) {
				BookStoredEntity testBookBorrowedEntity1 = new BookStoredEntity();
				testBookBorrowedEntity1.setBookId("1");
				testBookBorrowedEntity1.setBookText("Android鍏ラ棬涓庢彁楂");
				testBookBorrowedEntity1.setBookImageUrl("android");
				testBookBorrowedEntity1.setBookPress("android");
				testBookBorrowedEntity1.setBookPressTime("android");
				storeBookDAO.insert(testBookBorrowedEntity1);
			}
			if (bookBorrowedEntity == 2) {
				BookStoredEntity testBookBorrowedEntity1 = new BookStoredEntity();
				testBookBorrowedEntity1.setBookId("2");
				testBookBorrowedEntity1.setBookText("IOS寮�彂瀹炴垬瀹濆吀");
				testBookBorrowedEntity1.setBookImageUrl("android");
				testBookBorrowedEntity1.setBookPress("android");
				testBookBorrowedEntity1.setBookPressTime("android");
				storeBookDAO.insert(testBookBorrowedEntity1);
			}
			if (bookBorrowedEntity == 3) {
				BookStoredEntity testBookBorrowedEntity1 = new BookStoredEntity();
				testBookBorrowedEntity1.setBookId("3");
				testBookBorrowedEntity1.setBookText("JavaEE鍏ラ棬鍒扮簿閫");
				testBookBorrowedEntity1.setBookImageUrl("android");
				testBookBorrowedEntity1.setBookPress("android");
				testBookBorrowedEntity1.setBookPressTime("android");
				storeBookDAO.insert(testBookBorrowedEntity1);
			}
			
			
			Toast.makeText(BookInfoActivity.this, R.string.storesuccess, Toast.LENGTH_SHORT).show();
		}
	};
	

}

