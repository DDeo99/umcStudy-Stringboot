package umcStudy.springStudy.domain.Mapping;

import jakarta.persistence.*;
import lombok.*;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.domain.common.BaseEntity;
import umcStudy.springStudy.domain.Member;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name="member_mission")
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memebr_id")
    private Member member;
}
