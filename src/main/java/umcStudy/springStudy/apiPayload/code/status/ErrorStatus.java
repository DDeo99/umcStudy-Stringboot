package umcStudy.springStudy.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umcStudy.springStudy.apiPayload.code.BaseErrorCode;
import umcStudy.springStudy.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),


    // 멤버 관련 응답

    // Food Category 관련
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "404","해당 음식 카테고리는 존재하지 않습니다."),

    // 멤버 미션 관련
    MISSION_IS_INPROGRESS(HttpStatus.CONFLICT , "409","해당 미션은 이미 수행중입니다."),

    // Store 관련
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"400","해당 가게는 존재하지 않습니다."),

    // Pagine 관련
    PAGING_BAD_REQUEST(HttpStatus.BAD_REQUEST,"400","페이지 번호는 1부터 입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;

    }
}