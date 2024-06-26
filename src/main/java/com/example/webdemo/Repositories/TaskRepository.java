package com.example.webdemo.Repositories;

import com.example.webdemo.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "select * from tasks t where t.teamno = :teamno", nativeQuery = true)
    List<Task> getTasksUsingTeamNo(@Param("teamno") Long teamno);


    @Transactional
    @Modifying
    @Query(value = "delete from tasks t where t.teamno = :teamno", nativeQuery = true)
    void deleteTasksUsingTeamNo(@Param("teamno") Long teamno);

}
