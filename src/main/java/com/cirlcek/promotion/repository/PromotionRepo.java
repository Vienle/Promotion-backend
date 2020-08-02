package com.cirlcek.promotion.repository;

import com.cirlcek.promotion.entities.PromotionObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
//
//@Repository
//public interface PromotionRepo extends JpaRepository<PromotionObject, Long> {
////    @Procedure(procedureName = "sp_SELECT_ALL_PROMOTION_FROM_TO_90DAY")
//    @Query(value = "EXECUTE sp_SELECT_ALL_PROMOTION_FROM_TO_90DAY",nativeQuery = true)
//    List<PromotionObject> getAll();
//}
