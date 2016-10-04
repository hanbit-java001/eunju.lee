$(function() {
	$(".btnApply").on("click", function() {

		// Validation
		var name = $("#txtName").val();
		var email = $("#txtEmail").val();
		var password = $("#txtPassword").val();
		var passwordConfirm = $("#txtPasswordConfirm").val().trim();
		var imgProfile = $("#imgProfile").get(0);

		if(name == "") {
			alert("이름을 입력하세요.");
			$("#txtName").focus();
			return;
		}
		else if(email == "") {
			alert("이메일을 입력하세요.");
			$("#txtEmail").focus();
			return;
		}
		else if(password == "") {
			alert("비밀번호를 입력하세요.");
			$("#txtPassword").focus();
			return;
		}
		else if(password != passwordConfirm) {
			alert("동일한 비밀번호를 입력하세요.");
			$("#txtPasswordConfirm").focus();
			return;
		}

		var data = new FormData();

		data.append("name", name);
		data.append("email", email);
		data.append("password", password);

		for (var i=0; i<imgProfile.files.length; i++) {
			var file = imgProfile.files[i];

			data.append("imgProfile", file);
		}

		// send Data to server
		$.ajax({
			uri: "/api/member/join",
			method: "POST",
			data: data,
			contentType: false,
			processData: false
		}).done(function(result) {

		});
	});
});