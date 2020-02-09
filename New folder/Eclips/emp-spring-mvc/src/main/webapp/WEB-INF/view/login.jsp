<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<form action="./login" style="padding-left:40%; margin-top: 20% "
		method="post">
		<table title="Login">
			<tbody>
				<tr>
					<td style="color: red;">${msg }</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>