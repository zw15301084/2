package com.example.javaee.consumer.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HandlerRepository extends JpaRepository {


    @Query(value = "insert into course_customer values(?1,?2)", nativeQuery = true)
    void become_class_member(int class_id, int customer_id);

    @Query(value = "update course_customer set isVip=1 where id = ?1", nativeQuery = true)
    void become_vip_member( int customer_id);


}
