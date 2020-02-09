<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<a href="./home" style="text-decoration: none">Home</a>
	<a href="./logout" style="float: right;text-decoration: none">Logout</a>
	
	<form action="./register" style="margin-left: 50%; margin: 10%"
		method="post">
		<table title="Login">
			<tbody>
				<tr>
					<td>${msg }</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
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
					<td>Mobile</td>
					<td><input type="number" name="mobile" maxlength="10"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><select name="role">
							<option value="user">User</option>
							<option value="admin">Admin</option>
					</select></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Register"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>