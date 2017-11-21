package com.hanbat.football.Model;

import javax.persistence.*;

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "id.team",
                joinColumns = @JoinColumn(name = "team_name")),
        @AssociationOverride(name = "id.player",
                joinColumns = @JoinColumn(name = "player_pid")) })
public class TeamPlayer implements java.io.Serializable {

    @EmbeddedId
    private TeamPlayerID id = new TeamPlayerID();

    public TeamPlayer() {
    }

    public TeamPlayerID getId() {
        return id;
    }

    public void setId(TeamPlayerID id) {
        this.id = id;
    }

    @Transient
    public Team getTeam(){
        return getId().getTeam();
    }

    public void setTeam(Team team){
        getId().setTeam(team);
    }

    @Transient
    public Player getPlayer(){
        return getId().getPlayer();
    }

    public void setPlayer(Player player){
        getId().setPlayer(player);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TeamPlayer that = (TeamPlayer) o;

        if (getId() != null ? !getId().equals(that.getId())
                : that.getId() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getId() != null ? getId().hashCode() : 0);
    }
}
