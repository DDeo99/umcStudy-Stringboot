package umcStudy.springStudy.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import umcStudy.springStudy.apiPayload.code.BaseErrorCode;
import umcStudy.springStudy.apiPayload.code.status.ErrorStatus;
import umcStudy.springStudy.apiPayload.exception.handler.FoodCategoryHandler;
import umcStudy.springStudy.converter.MemberConverter;
import umcStudy.springStudy.converter.MemberPreferConverter;
import umcStudy.springStudy.domain.FoodCategory;
import umcStudy.springStudy.domain.Mapping.MemberPrefer;
import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.repository.FoodCategoryRepository;
import umcStudy.springStudy.repository.MemberRepository;
import umcStudy.springStudy.web.dto.request.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberCommnandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    public Member findById(Long memberId) {
        Member member= memberRepository.findById(memberId)
                .orElseThrow(()->new NotFoundException("해당하는 유저가 없습니다."));

        return member;
    }
}
