package com.fbe.team;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for the Team entity.
 * Allows CRUD and pagination/sorting operations on teams.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, UUID>, PagingAndSortingRepository<Team, UUID> {

    Page<Team> findAll(Specification<Team> specification, org.springframework.data.domain.Pageable pageable);

    Optional<Team> findById(Long id);

    void deleteById(Long id);
}
