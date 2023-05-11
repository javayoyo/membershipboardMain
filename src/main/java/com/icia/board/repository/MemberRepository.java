package com.icia.board.repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.MemberDTO;
import com.icia.board.dto.MemberProfileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSessionTemplate sql;

    public MemberDTO save(MemberDTO memberDTO) {
        System.out.println("insert 전 memberDTO = " + memberDTO);
        sql.insert("Member.save",memberDTO);
        System.out.println("insert 후 memberDTO = " + memberDTO);
        return memberDTO;
    }

    public void saveFile(MemberProfileDTO memberProfileDTO) {
        sql.insert("Member.saveFile", memberProfileDTO);
    }



    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login",memberDTO);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public void update(MemberDTO memberDTO) {
        sql.update("Member.update" , memberDTO);

    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }
}