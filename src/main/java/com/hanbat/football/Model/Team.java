package com.hanbat.football.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team implements java.io.Serializable {

    @Id
    @Column(name = "team_name", unique = true, nullable = false)
    private String name;

    @Column(name = "coach", nullable = false)
    private String coach;

    @Column(name = "rank", nullable = false)
    private int rank;

    @Column(name = "logo_filepath", nullable = true)
    private String logoFilePath;

    @Temporal(TemporalType.DATE)
    @Column(name = "foundation_day")
    private Date foundationDay;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(nullable = false)
    private League league;

    @OneToMany(mappedBy = "id.team", cascade = CascadeType.REFRESH, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<TeamPlayer> teamPlayers = new HashSet<TeamPlayer>(0);

    public Team() {
    }

    public Team(String name, String coach, int rank, String logoFilePath, Country country, League league, Set<TeamPlayer> teamPlayers) {
        this.name = name;
        this.coach = coach;
        this.rank = rank;
        this.logoFilePath = logoFilePath;
        this.country = country;
        this.league = league;
        this.teamPlayers = teamPlayers;
    }

    public Team(String name, String coach, int rank, Date foundationDay, Country country, Stadium stadium, League league, Set<TeamPlayer> teamPlayers) {
        this.name = name;
        this.coach = coach;
        this.rank = rank;
        this.foundationDay = foundationDay;
        this.country = country;
        this.stadium = stadium;
        this.league = league;
        this.teamPlayers = teamPlayers;
    }

    public Team(String name, String coach, int rank, String logoFilePath, Date foundationDay, Country country, Stadium stadium, League league, Set<TeamPlayer> teamPlayers) {
        this.name = name;
        this.coach = coach;
        this.rank = rank;
        this.logoFilePath = logoFilePath;
        this.foundationDay = foundationDay;
        this.country = country;
        this.stadium = stadium;
        this.league = league;
        this.teamPlayers = teamPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLogoFilePath() {
        return logoFilePath;
    }

    public void setLogoFilePath(String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }

    public Date getFoundationDay() {
        return foundationDay;
    }

    public void setFoundationDay(Date foundationDay) {
        this.foundationDay = foundationDay;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Set<TeamPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(Set<TeamPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }
}