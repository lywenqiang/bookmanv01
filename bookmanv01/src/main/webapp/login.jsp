<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
	<link href="bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<style type="text/css">
	.container-fluid{
		width:40%;
		position:absolute;
		top:50%;
		left:50%;
		margin-left: -307px;
		margin-top: -101px;
	}
	</style>
</head>
<body>
		<div class="container-fluid well">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post"
					action="login" id="loginFm">
					<div class="form-group">
					<%if(request.getAttribute("msg") != null){ %>
						<div class="alert alert-warning" role="alert"><%=request.getAttribute("msg")%></div>
						<%} %>

						<label for="inputName" class="col-sm-2 control-label">
							用户名： </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name"
								value="<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputPwd" class="col-sm-2 control-label"> 密码：
						</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPwd"
								name="pwd" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputVcode" class="col-sm-2 control-label"> 验证码：
						</label>
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

							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.min.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js">
	</script>
	<script type="text/javascript">
		$(function() {
			$("#vcodeImg").click(function() {
				this.src="vcode.png?t="+Math.random();//加一个触发事件，用于点一下验证码，就换一个验证码,不加随机数不会换图片
			})
			//验证
			$("#loginFm").validate({
				rules: {
				name: { required: true},
				pwd: {required: true}
				},
				messages: {
				name: "用户名必填",
				pwd:"密码必填"
				},
				tooltip_options: {
				name: {placement:'bottom'},
				pwd:{placement:'bottom'}
				},
				});
		})
	</script>
</body>
</html>