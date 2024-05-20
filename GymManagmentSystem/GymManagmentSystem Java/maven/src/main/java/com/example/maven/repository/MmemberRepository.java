package com.example.maven.repository;

import com.example.maven.pojo.Member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MmemberRepository extends CrudRepository<Member,Integer> {

}

