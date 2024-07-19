package com.fbe.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface TeamService {

    /**
     * Gets all teams bien filtering and paging.
     *
     * @param specification specification
     * @param pageable      pageable
     * @return teams by page
     */
    Page<Team> getAllTeams(Specification<Team> specification, Pageable pageable);

    /**
     * Gets a team by its id.
     *
     * @param id the id of the team
     * @return the team, if it exists
     */
    Optional<Team> getTeamById(Long id);

    /**
     * Saves a new team or updates an existing team.
     *
     * @param team the team to save
     * @return the saved team
     */
    Team saveTeam(Team team);

    /**
     * Deletes a team by its id.
     *
     * @param id the id of the team to delete
     */
    void deleteTeam(Long id);
}
