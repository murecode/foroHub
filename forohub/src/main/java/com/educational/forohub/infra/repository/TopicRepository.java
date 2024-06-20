package com.educational.forohub.infra.repository;

import com.educational.forohub.bussines.topic.Topic;
import com.educational.forohub.bussines.topic.TopicStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

  Page<Topic> findByTopicStatus(TopicStatus status, Pageable pageable);

//  List<Topic> findByCourse();

}
