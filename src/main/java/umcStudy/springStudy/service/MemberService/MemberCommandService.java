package umcStudy.springStudy.service.MemberService;

import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.web.dto.request.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Member findById(Long memberId);
}