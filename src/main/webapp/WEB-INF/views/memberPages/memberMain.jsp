<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-09
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>마이페이지</title>
  <link rel="stylesheet" href="/resources/css/main.css">


</head>
<body>
<%@include file="../component/header.jsp"%>
<%@include file="../component/nav.jsp"%>

<div id="section">
  ${sessionScope.loginEmail} 님 마이페이지 입니다 <br>

  <button onclick="update()">회원정보수정</button>
  <button>회원탈퇴</button>
</div>



<%@include file="../component/footer.jsp"%>
</body>
<script>

  const update = () => {
    location.href = "/member/update";


  }

</script>
</html>