package umcStudy.springStudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.converter.MemberConverter;
import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.service.MemberService.MemberCommandService;
import umcStudy.springStudy.web.dto.request.MemberRequestDTO;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}