<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath() %>/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
   var data = {"gameName" : "jason","description" : "hello","icon" : "test.png"};
   $.ajax({
	  url : "<%=request.getContextPath()%>/game/json",
	  type : "POST",
	  data : JSON.stringify(data),
	  dataType : "json",
	  success : function(){
	  }
  });
})

</script>
</body>
</html>