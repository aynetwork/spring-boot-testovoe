package com.example.demo.repo;

import com.example.demo.domain.PurchaseInfo;
import com.example.demo.domain.dto.InfoDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.OrderBy;
import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseInfoRepo extends CrudRepository<PurchaseInfo, Long> {
    PurchaseInfo findByName(String name);
    PurchaseInfo getOne(Long id);



    @OrderBy("id DESC ")
    List<PurchaseInfo> findAll();

    @Query("from PurchaseInfo p where creationDate > :lastWeek")
    List<PurchaseInfo> findLastWeek(@Param("lastWeek") LocalDateTime lastWeek);

    List<PurchaseInfo> findFirstByOrderByCountDesc();

    @Query(value = "SELECT name, SUM(count) FROM purchase_info GROUP BY name", nativeQuery = true)
    PurchaseInfo sumHalfYear();

//    @Query(value="SELECT purchase_id, SUM(count) as sumer FROM purchase_info GROUP BY purchase_id ORDER BY sumer DESC  LIMIT 1", nativeQuery = true)
//    @Query(value="SELECT new com.example.demo.domain.dto.InfoDto(p, age)  FROM PurchaseInfo p GROUP BY p", nativeQuery = false)
//    InfoDto mostBuy();
}
