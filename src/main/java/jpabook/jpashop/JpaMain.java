package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.Team;
//import jpabook.jpashop.domain.Order;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

            EntityManager em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try{

                /*
                Order order = em.find(Order.class, 1L);
                Long memberId = order.getMemberId();

//                Member member = em.find(Member.class, memberId); // 객체지향적이지 않음
                Member member = order.getMember();
                */

      /*
                // 팀 저장
                Team team = new Team();
                team.setName("TeamA");
                em.persist(team);

                // 회원 저장
                Member member = new Member();
                member.setUsername("member1");
                member.setTeamId(team.getId()); // 객체지향스럽지 X
                em.persist(member);

                // 조회
                Member findMember = em.find(Member.class, member.getId());

                Long findTeamId = findMember.getTeamId();
                Team findTeam = em.find(Team.class, findTeamId); // 연관관계가 없음 -> 객체지향스럽지 않은 방식
                */

            /*
                // 팀 저장
                Team team = new Team();
                team.setName("TeamA");
                em.persist(team);

                // 회원 저장
                Member member = new Member();
                member.setUsername("member1");
                member.setTeam(team); // 단방향 연관관계 설정, 참조 저장
                em.persist(member);

                em.flush(); // DB에서 가져오기 위해 강제 호출
                em.clear();

                // 조회
                Member findMember = em.find(Member.class, member.getId());

                Team findTeam = findMember.getTeam();
                System.out.println("findTeam = " + findTeam.getName());

                Team newTeam = em.find(Team.class, 100L);
                findMember.setTeam(newTeam); // 외래 키 값 update됨
            */

            /*
                // 팀 저장
                Team team = new Team();
                team.setName("TeamA");
                em.persist(team);

                // 회원 저장
                Member member = new Member();
                member.setUsername("member1");
                member.setTeam(team); // 단방향 연관관계 설정, 참조 저장
                em.persist(member);

                em.flush(); // DB에서 가져오기 위해 강제 호출
                em.clear();


                // 조회
                Member findMember = em.find(Member.class, member.getId());

                List<Member> members = findMember.getTeam().getMembers(); // 역방향 조회

                for (Member m : members) {
                    System.out.println("m = " + m.getUsername());

                }
                */

                // 팀 저장
                Team team = new Team();
                team.setName("TeamA");
                em.persist(team);

/*
                // 회원 저장
                Member member = new Member();
                member.setUsername("member1");
//                member.changeTeam(team);
                em.persist(member);

                team.addMember(member); // changeTeam, addMember 연관관계 메서드 2개중 하나 선택해서 하면 됨, 2개 다 생성하면 무한 루프 발생할 수 잇으니 조심

//                team.getMembers().add(member); // 2개 같이 넣어야함 -> 실수할 가능성 있음


//                team.getMembers().add(member);
                // members에 값을 넣어도 값이 변하지 않음(members는 가짜 매핑, 읽기 전용)
                // 순수한 객체 관계를 고려하면 넣어주는게 좋음

//                em.flush();
//                em.clear();

                Team findTeam = em.find(Team.class, team.getId()); // flush하면 select 쿼리 출력, 1차 캐시 로딩 되어있으면 select 쿼리 출력 X
                List<Member> members = findTeam.getMembers(); // select 쿼리 출력되지 않으면 안에 값이 없음 -> 양쪽에 값을 세팅 해주는 것이 좋다.

                System.out.println("======");
//                for (Member m : members) { // 쿼리 날림 연관된 멤버 가져옴, members 안넣어줘도 출력은 됨
//                    System.out.println("m = " + m.getUsername()); //  flush, clear 하지 않으면 출력 안됨
//                }
//                System.out.println("members = " + findTeam); // 무한루프
                System.out.println("======");
*/

                // 양방 연관관계 아니여도 상관은 X
                Order order = new Order();
                em.persist(order);

                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);

                em.persist(orderItem);


                tx.commit();
            }catch(Exception e){
                tx.rollback();
            } finally{
            em.close();
            }
            emf.close();
        }
    }

