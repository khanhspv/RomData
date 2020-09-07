package com.pvk.khanhpham.roomdata.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Bookmark")
public class BookmarkEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "tile")
    public String tile;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "url")
    public String url;

}
