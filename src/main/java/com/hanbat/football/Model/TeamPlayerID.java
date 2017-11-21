package com.hanbat.football.Model;

import javax.persistence.*;

@Embeddable
public class TeamPlayerID implements java.io.Serializable {

    @ManyToOne
    private Team team;

    @ManyToOne
    private Player player;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TeamPlayerID() {
    }

    public TeamPlayerID(Team team, Player player) {
        this.team = team;
        this.player = player;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamPlayerID that = (TeamPlayerID) o;

        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (player != null ? player ==(that.player) : that.player != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (team != null ? team.hashCode() : 0);
        result = 31 * result + (player != null ? player.hashCode() : 0);
        return result;
    }
}