package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
//    @Column(name = "USERNAME")
//    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne // 다대일 (많은 멤버가 하나의 팀)
//    @JoinColumn(name = "TEAM_ID")
//    private Team team; // 객체 지향 모델링

    private String name;
//    private String city;
//    private String street;
//    private String zipcode;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); // 관례상 ArrayList 많이 사용, 데이터 없이 nullPointException 생기는 등 좋음

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

/*
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
   */



//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team.toString() +
//                '}';
//    }
    //    public void changeTeam(Team team) { // 이름 바꿔서 중요도 높은걸 알림
//        this.team = team;
//        team.getMembers().add(this); // 양쪽에 연관관계 설정해줌(연관관계 편의 메서드)
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }


    public Address getAddress() {
        return address;
    }
}
