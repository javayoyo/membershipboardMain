<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-09
  Time: 오후 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="nav">

    <ul>
        <li>
            <a href="/">홈</a>
        </li>
        <li>
            <a href="/member/save">회원가입</a>
        </li>
        <li>
            <a href="/member/login">로그인</a>
        </li>
        <li>
            <a href="/board/list">글목록</a>
        </li>


        <li class="login-name" id="login-area">

        </li>

    </ul>


</div>

<script>
    const loginArea = document.getElementById("login-area");
    const loginEmail = '${sessionScope.loginEmail}';
    console.log(loginEmail.length);

    if(loginEmail.length != 0) {
        loginArea.innerHTML = "<a href='/member/mypage' style='color:black;'>"+loginEmail + "님 마이페이지</a>"+
            "<a href='/member/logout'>logout</a>";

    } else {

        loginArea.innerHTML = "<a href='/member/login'>login</a>";


    }

</script>