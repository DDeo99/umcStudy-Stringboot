package umcStudy.springStudy.domain.Mapping;

import jakarta.persistence.*;
import lombok.*;
import umcStudy.springStudy.domain.Terms;
import umcStudy.springStudy.domain.common.BaseEntity;
import umcStudy.springStudy.domain.Member;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="MemberAgree")
@Table(name="member_agree")
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="terms_id",referencedColumnName = "id")
    private Terms terms;

}