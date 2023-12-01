package umcStudy.springStudy.service.MemberService;

import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.web.dto.request.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Member findById(Long memberId);

    Page<Review> getReviewList(Long MemberId, Integer page);
}