package com.icia.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberProfileDTO {

    private Long id;
    private String memberOriginalFileName;
    private String memberStoredFileName;
    private Long memberId;
}
