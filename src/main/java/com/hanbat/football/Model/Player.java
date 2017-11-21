package com.hanbat.football.Model;

import com.hanbat.football.Model.Enum.FootType;
import com.hanbat.football.Model.Enum.Position;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_pid", unique = true, nullable = false)
    private int pid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(
            name = "sex",
            nullable = false
    )
    private boolean isMale;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;

    @Column(nullable = false)
    private FootType footType;

    @Column(nullable = false)
    private Position position;

    @OneToMany(mappedBy = "id.player", cascade = CascadeType.REFRESH, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<TeamPlayer> teamPlayers = new HashSet<TeamPlayer>(0);

    private double height;

    private double weight;

    private String filePath;

    public Player() {
    }

    public Player(String name, int age, boolean isMale, Country country, FootType footType, Position position, String filePath, Set<TeamPlayer> teamPlayers) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.country = country;
        this.footType = footType;
        this.position = position;
        this.filePath = filePath;
        this.teamPlayers = teamPlayers;
    }

    public Player(String name, int age, boolean isMale, Country country, FootType footType, Position position, double height, double weight, String filePath, Set<TeamPlayer> teamPlayers) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.country = country;
        this.footType = footType;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.filePath = filePath;
        this.teamPlayers = teamPlayers;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public FootType getFootType() {
        return footType;
    }

    public void setFootType(FootType footType) {
        this.footType = footType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<TeamPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(Set<TeamPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}