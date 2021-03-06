package com.example.Ekspedisi.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDiriDAO {
    @Insert
    Long insertData(DataDiri dataDiri);

    @Query("Select * from user_db")
    List<DataDiri> getData();

    @Update
    int updateData(DataDiri item);

    @Delete
    void deleteData(DataDiri item);
}
