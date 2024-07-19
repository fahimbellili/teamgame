package com.fbe.controller;

import com.fbe.team.Team;
import com.fbe.team.TeamService;
import com.fbe.team.TeamSpecificationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller to manage teams.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    /**
     * Create a new team.
     *
     * @param team team
     * @return the save Team
     */
    @PostMapping
    public ResponseEntity<Long> addTeam(@RequestBody Team team) {
        Team savedTeam = teamService.saveTeam(team);
        return ResponseEntity.ok(savedTeam.getId());
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamId(@PathVariable("teamId") Long teamId) {
        Team team = teamService.getTeamById(teamId).orElse(null);
        return ResponseEntity.ok(team);
    }

    /**
     * Get all teams with pagination and sorting.
     *
     * @param name name
     * @param acronym acronym
     * @param budget budget
     * @return a page of teams
     */
    @GetMapping
    public Page<Team> getAllTeams(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "acronym", required = false) String acronym,
            @RequestParam(value = "budget", required = false) Double budget,
            Pageable pageable) {

        Page<Team> teams = teamService.getAllTeams(TeamSpecificationFactory.getTeams(name, acronym, budget), pageable);

        return ResponseEntity.ok(teams).getBody();
    }
}
