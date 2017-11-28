function myFunc() {
	var pass = $("#psw").val();

	$.ajax({
		url : 'manage/auth',
		type : 'POST',
		data : {
			password : $("#psw").val()
		},

		success : function(response) {
			data = response;
			handle(data);
		},
		error : function(e) {
			alert("error while trying to save data" + e)
		}
	});
	function handle(data) {
		if (data.status == 400)
			{
			bootbox.alert("Wrong Password!");
			}
		else{
			top.location.href = data.message
		}
			

	}
}