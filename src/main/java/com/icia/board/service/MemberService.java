package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.MemberDTO;
import com.icia.board.dto.MemberProfileDTO;
import com.icia.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) throws IOException {
        // 파일 있음, 없음 확인하기
        if (memberDTO.getProfile().isEmpty()) {
            // 파일 없음
            System.out.println("파일없음");
            memberDTO.setMemberProfile(0);
            memberRepository.save(memberDTO);
        } else {
            // 파일 있음
   /*
   1. 파일첨부 여부 값 1로 세팅하고 DB에 제목 등 내용 board_table에 저장처리
     2. 파일의 이름을 가져오고 DTO 필드값에 세팅
     3. 저장용 파일 이름 만들고 DTO 필드값에 세팅
     4. 로컬에 파일 저장
     5. board_file_table 에 저장 처리
     */
            System.out.println("파일있음");
            memberDTO.setMemberProfile(1);
            MemberDTO dto = memberRepository.save(memberDTO);
            // 원본 파일 이름 가져오기
            String originalFilename = memberDTO.getProfile().getOriginalFilename();
            System.out.println("originalFilename = " + originalFilename);
            //저장용 이름 만들기
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
            System.out.println("storedFileName = " + storedFileName);
            // 저장을 위한 MemberFileDTO 세팅
            MemberProfileDTO memberProfileDTO = new MemberProfileDTO();
            memberProfileDTO.setMemberOriginalFileName(originalFilename);
            memberProfileDTO.setMemberStoredFileName(storedFileName);
            memberProfileDTO.setMemberId(dto.getId());
            // 로컬에 파일 저장
            // 저장할 경로 설정 (저장할폴더+저장할이름)
            String savePath = "D:\\springframework_img\\" + storedFileName;
            // 저장처리
            memberDTO.getProfile().transferTo(new File(savePath));
            memberRepository.saveFile(memberProfileDTO);



        }
    }

        public boolean login(MemberDTO memberDTO) {
        MemberDTO dto = memberRepository.login(memberDTO);
        if(dto != null) {
            return true;
        }else {
            return false;
        }
    }


    public MemberDTO findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail);
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.update(memberDTO);

    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

}