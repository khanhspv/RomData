package com.pvk.khanhpham.roomdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import com.pvk.khanhpham.roomdata.database.AppDatabase;
import com.pvk.khanhpham.roomdata.database.BookmarkEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        insertBookmark();

        updateBookmark(2);

        getAllBookmark();

        findBookmark(1);
    }

    private void insertBookmark(){
        BookmarkEntity bm = new BookmarkEntity();
        bm.tile = " This is title";
        bm.content = "This is content";
        db.bookmarkDao().insertBookmark(bm);
    }

    private void updateBookmark (int id){
        BookmarkEntity bm = db.bookmarkDao().getBookmark(id);
        bm.tile = "this is title update";
        db.bookmarkDao().updateBookmark(bm);
    }

    private void getAllBookmark(){
        List<BookmarkEntity> list = db.bookmarkDao().getAllBookmark();
        for (BookmarkEntity model : list){
            Log.d("Tag","id" + model.id + "title" + model.tile);
        }
    }

    private void findBookmark(int id){
        BookmarkEntity model = db.bookmarkDao().getBookmark(id);
        Log.d("Tag","Find Bookmark With id: "  + model.id+"title" + model.tile);
    }

    private void deleteBookmark(int id){
        BookmarkEntity  model = db.bookmarkDao().getBookmark(id);;
        db.bookmarkDao().deleteBookmark(model);
    }

    private void deleteAllBookmark(){
        db.bookmarkDao().deleteAll();
    }

}
