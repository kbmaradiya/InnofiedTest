//package com.example.myapplication.database;
//
///*
// * Created by: Bharat S
// * Created on: 09-04-2019
// * Modified by: Your Name
// * Modified on: Modified Date
// */
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//
//import com.atzcart.in.model.LocalProductDetailsModel;
//
//import java.util.List;
//
//@Dao
//public interface BrowsingHistoryDAO {
//
//    @Query("SELECT * FROM browsing_history")
//    List<LocalProductDetailsModel> getAllViewedProducts();
//
//    @Query("SELECT seller_id FROM browsing_history GROUP BY seller_id HAVING COUNT(seller_id) < 10 ORDER BY product_view_date")
//    List<String> getSellerIds();
//
//    @Query("SELECT COUNT() FROM browsing_history")
//    int getNumberOfRows();
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insert(LocalProductDetailsModel productModel);
//
//    @Delete
//    void delete(LocalProductDetailsModel productModel);
//
//    @Query("Delete from browsing_history")
//    void deleteAll();
//}
