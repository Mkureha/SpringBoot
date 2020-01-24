<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>INDEX DEMO</title>
    </head>
    <body>
        //세션 스코프를 통해 m으로 선언된 변수명에 m_id를 찾아서 출력
        Hell!! ${sessionScope.m.m_id} <br>
        <a href = "/demo/logout">로그아웃</a>
    </body>
</html>