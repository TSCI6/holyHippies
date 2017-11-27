$(document).ready(
		function() {
			$("#login").click(
					function(event) {
						event.preventDefault();
						var username = $("#nam").val();
						var password = $("#pass").val();
						$.ajax({
							type : "POST",
							contentType : "application/json; charset=utf-8",
							url : "whichcontact/login?username=" + username
									+ "&password=" + password,
							data : {
								username : username,
								password : password
							},
							success : function(response) {
								data = response.status;
								printResponse(data);
							},
							error : function(e) {
								alert("error while trying to authenticate")
							}
						});
					});
		});
$(document).ready(
		function() {
			$("#signupForm").click(
					function(event) {
						event.preventDefault();
						var username = $("#uname").val();
						var mailId = $("#usermailid").val();
						var password = $("#firstPassword").val();
						var company = $("#userCompany").val();
						var designation = $("#userDesignation").val();

						$.ajax({
							type : "POST",
							contentType : "application/json; charset=utf-8",
							url : "whichcontact/addUser?username=" + username
									+ "&mailId=" + mailId + "&password="
									+ password + "&company=" + company
									+ "&designation=" + designation,
							data : {
								username : username,
								mailId : mailId,
								password : password,
								company : company,
								designation : designation
							},
							success : function(response) {
								data = response;
								handleRegistrationResponse(data);
							},
							error : function(e) {
								alert("error while trying to save data")
							}
						});
					});
		});

function handleRegistrationResponse(data) {

	if (data.status == 400) {

		 
         $('#signupForm').append("<p> User already exist </p>");
	}

	else if (data.status == 200) {
		 
        top.location.href="Welcome.html";

	}
}