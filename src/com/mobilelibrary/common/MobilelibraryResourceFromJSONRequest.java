package com.mobilelibrary.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import com.mobilelibrary.entity.BookRecommendEntity;
import com.mobilelibrary.entity.BookSearchEntity;
import com.mobilelibrary.entity.UserEntity;
import com.mobilelibrary.handlerexception.WSError;
import com.mobilelibrary.net.HttpRequest;
import com.mobilelibrary.parse.PersonInformationParser;

/*
 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟阶癑SON锟斤拷锟襟及得碉拷锟斤拷应锟斤拷源
 */
public class MobilelibraryResourceFromJSONRequest  {
	
	
	//login
	public UserEntity loginAuthentication(String userID ,String password) throws JSONException, WSError{
		// TODO Auto-generated method stub
		
		//generate JSON object
		JSONObject param = new JSONObject();
		param.put("userId", userID);
		param.put("password", password);

		InputStream   inputStream  = HttpRequest.requestByXML("url",param.toString());
		
		//		UserEntity  userEntity = (UserEntity)new PersonInformationParser().executeToObject(inputStream, null);

		//test
		UserEntity  userEntity = (UserEntity)new PersonInformationParser().executeToObject(new ByteArrayInputStream(param.toString().getBytes()), null);
		
		return userEntity;
	}
    
	//锟剿凤拷锟斤拷锟斤拷锟斤拷锟斤拷取锟狡硷拷锟斤拷锟斤拷锟斤拷
	public BookRecommendEntity[] getBooksRecommend() throws JSONException, WSError{
		// TODO Auto-generated method stub
		
		//锟斤拷锟斤拷拇锟斤拷锟侥壳爸伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		BookRecommendEntity[] books = new BookRecommendEntity[5];
		BookRecommendEntity  book = null;
		for (int i = 0; i < 5; i++) {
			
			if (i == 0) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android寮�彂瀹炶返");
			}
			if (i == 1) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JaveEE 5");
			}
			if (i == 2) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("鏁版嵁缁撴瀯涓庣畻娉");
			}
			if (i == 3) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JavaEE鍏ラ棬鍒扮簿閫");
			}
			if (i == 4) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android瀹炶返涓庢彁楂");
			}
			books[i]=book;
			
		}
		//锟斤拷锟斤拷拇锟斤拷锟街伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		
		
		return books;
	}
	
	//锟剿凤拷锟斤拷锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public BookSearchEntity[] getBooksSearch(String query) throws JSONException, WSError{
		// TODO Auto-generated method stub
		
		//锟斤拷锟斤拷拇锟斤拷锟侥壳爸伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		BookSearchEntity[] books = new BookSearchEntity[5];
		BookSearchEntity  book = null;
		
		for (int i = 0; i < 5; i++) {
			
			if (i == 0) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android寮�彂瀹炶返");
			}
			if (i == 1) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JaveEE 5");
			}
			if (i == 2) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("鏁版嵁缁撴瀯涓庣畻娉");
			}
			if (i == 3) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JavaEE鍏ラ棬鍒扮簿閫");
			}
			if (i == 4) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android瀹炶返涓庢彁楂");
			}
			books[i]=book;
		}
		
		return books;
	}

}
