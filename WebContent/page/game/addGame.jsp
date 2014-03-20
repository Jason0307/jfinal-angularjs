<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/uploadify.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="<%=request.getContextPath()%>/css/semantic.min.css"
	rel="stylesheet" type="text/css" media="screen" />
<title>Add Game</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/game/save" method="POST">
		<div class="ui form">
			<div class="field">
				<label>Name</label> <input type="text" name="game.gameName">
			</div>
		</div>

		<div class="ui form">
			<div class="field">
				<label>Description</label> <input type="text" name="game.description">
			</div>
		</div>
		<div class="ui form">
			<div class="field">
				<input id="upload" type="file">
			</div>
		</div>
		<input type="hidden" name="game.icon" id="icon">
		<input type="submit" class="ui blue submit button" value="Add">
	</form>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-2.1.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.uploadify.min.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/semantic.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$('#upload').uploadify({
				'fileSizeLimit':'50kb',
				'swf'      : '<%=request.getContextPath()%>/swf/uploadify.swf',
				'uploader' : '<%=request.getContextPath()%>/game/upload',
				'onUploadSuccess': function (file, data, response) {
			       $("#icon").val(data);
				}
			});
		});
	</script>
</body>
</html>