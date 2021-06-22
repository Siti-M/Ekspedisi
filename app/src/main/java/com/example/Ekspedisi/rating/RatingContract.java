package com.example.Ekspedisi.rating;

import android.view.View;

import com.example.Ekspedisi.entity.AppDatabase;
import com.example.Ekspedisi.entity.DataDiri;

import java.util.List;

public interface RatingContract {

    // inrterface view digunakan untuk kodingan Activity
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataDiri> list);
        void editData(DataDiri item);
        void deleteData(DataDiri item);
    }

    // interfaace presenter digunakan untuk kodingan database nya
    interface presenter {
        void insertData(String nama, String rating, String komentar, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String rating, String komentar, int id, AppDatabase database);
        void deleteData(DataDiri dataDiri, AppDatabase database);
    }
}
