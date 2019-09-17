//package com.example.myapplication.database;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//import android.arch.persistence.room.Update;
//
//import com.atzcart.in.model.LocalDBCompareProductModel;
//
//import java.util.List;
//
//@Dao
//public interface ProductCompareDAO {
//
//    @Query("Select * from compare_product")
//    List<LocalDBCompareProductModel> getAllProduct();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    long insertProduct(LocalDBCompareProductModel product);
//
//    @Delete
//    void delete(LocalDBCompareProductModel product);
//
//    @Update
//    void update(LocalDBCompareProductModel model);
//
//    @Query("UPDATE compare_product SET is_selected = :isSelected")
//    void updateIsSelectedAll(boolean isSelected);
//
//    @Query("Delete from compare_product where product_id in (:idList)")
//    void deleteProducts(List<String> idList);
//
//    @Query("Select COUNT(product_id) from compare_product")
//    int getProductCount();
//}
