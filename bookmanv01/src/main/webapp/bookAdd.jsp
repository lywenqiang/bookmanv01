<%@page import="cn.edu.nyist.bookmanv01.vo.TypeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="container-fluid well">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post"
					action="bookAdd" id="loginFm" enctype="multipart/form-data">
					<%if(request.getAttribute("msg") != null){ %>
						<div class="alert alert-warning" role="alert"><%=request.getAttribute("msg")%></div>
						<%} %>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label"> 
						书名:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name" />
						</div>
					</div>

					<div class="form-group">
						<label for="textAreaDescri" class="col-sm-2 control-label">
							描述:</label>
						<div class="col-sm-10" >
							<textarea name="descri" class="form-control" id="textAreaDescri"></textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPhoto" class="col-sm-2 control-label">
							图片: </label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="inputPhoto"
								name="photo" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPrice" class="col-sm-2 control-label">
							价格:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPrice"
								name="price" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPubData" class="col-sm-2 control-label">
							出版时间:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPubData"
								name="pubDate" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputAuthor" class="col-sm-2 control-label">
							作者: </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputAuthor"
								name="author" />
						</div>
					</div>
					<div class="form-group">
						<label for="selectTid" class="col-sm-2 control-label"> 
						类型:</label>
						<div class="col-sm-10">
							<select class="form-control" name="tid" id="selectTid">
							
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputVcode" class="col-sm-2 control-label">
							验证码:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputVcode"
								name="vcode" maxlength="4" />
						</div>
						<div class="col-sm-4">
							<img alt="" src="vcode.png" id="vcodeImg" title="单击换图片">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">

							<button type="submit" class="btn btn-default">添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#vcodeImg").click(function() {
				this.src = "vcode.png?t=" + Math.random();//加一个触发事件，用于点一下验证码，就换一个验证码,不加随机数不会换图片
			})
			$('#inputPubData').datepicker({
			    format: 'yyyy-mm-dd',
			    language: 'zh-CN',
			    autoclose:true
			});
		})
	</script>
	<script type="text/javascript">
	function fillSel() {
		var sel=document.getElementById("selectTid");
		for (var i = 0; i < types.length; i++) {
			sel.appendChild(new Option(types[i].name,types[i].id));
		}
	}
	</script>
	<script type="text/javascript" src="findAllTypes" onload="fillSel()"></script>
</body>
</html>