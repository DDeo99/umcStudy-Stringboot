package umcStudy.springStudy.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.web.dto.request.ReviewRequest;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;
import umcStudy.springStudy.web.dto.response.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewRequest.AddReivewDTO request) {
        return Review.builder()
                .head(request.getReviewHead())
                .body(request.getReviewBody())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }



    public static MemberResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO2(Review review){
        return MemberResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResponseDTO.ReviewDTO reviewDTO(Review review){
        return MemberResponseDTO.ReviewDTO.builder()
                .name(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static MemberResponseDTO.ReviewListDTO reviewListDTO(Page<Review> reviewList){

        List<MemberResponseDTO.ReviewDTO> reviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewDTOList.size())
                .reviewList(reviewDTOList)
                .build();
    }
    public static MemberResponseDTO.ReviewListDTO reviewListDTO(List<Review> reviewList){
        return null;
    }


}
