package umcStudy.springStudy.domain.Mapping;

import jakarta.persistence.*;
import lombok.*;
import umcStudy.springStudy.domain.FoodCategory;
import umcStudy.springStudy.domain.common.BaseEntity;
import umcStudy.springStudy.domain.Member;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="MemberPrefer")
@Table(name="member_prefer")
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category",referencedColumnName = "id")
    private FoodCategory foodCategory;
}