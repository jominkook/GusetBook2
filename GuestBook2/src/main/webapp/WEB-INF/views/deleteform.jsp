<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		
		
	%>	
	<form method="post" action="/GuestBook2/gb">
	<input type='hidden' name="no" value="<%=no%>">
	<input type='hidden' name="a" value="delete">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/GuestBook2/gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>

</body>
</html>