/*let index = {
    init: function() {
        $("#join-save").on("click", () => {
            this.save();
        });
    }
}


    save: function(){
        //alert('user의 save함수 호출됨');
        let data = {
            name: $("#name").val(),
            nickname: $("#nickname").val(),
            username: $("#username").val(),
            pw: $("#pw").val(),
            phone: $("#phone").val(),
            address: $("#address").val(),
            email: $("#email").val(),
            gender: $("#gender").val(),
            birth: $("#birth").val(),
            bank: $("#bank").val(),
            account: $("#account").val(),
        };*/

function btnJoin() {
    const id = $('#id').val();
    const pwd = $('#pwd').val();
    const name = $('#name').val();
    const phone = $('#phone').val();
    const gender_man = $('#gender_man').val();
    const gender_woman = $('#gender_woman').val();

    if(id === '') {
        $('#idError').val().innerHTML="아이디를 입력해주세요"
        $('#id').focus()
        check = false
    }

    if(pwd === '') {
        $('#pwdError').val().innerHTML="비밀번호를 입력해주세요"
        $('#pwd').focus()
        check = false
    } else if (!(pwd.includes("[a-zA-Z1-9]"))){
        $('#pwdError').val().innerHTML="비밀번호는 영어와 숫자로 포함해서 8~20자리 이내로 입력해주세요."
        $('#pwd').focus()
        check = false
    }

    if(name === '') {
        $('#nameError').val().innerHTML="이름을 입력해주세요"
        $('#name').focus()
        check = false
    }

    if(phone === '') {
        $('#phoneError').val().innerHTML="휴대폰 번호를 입력해주세요"
        $('#phone').focus()
        check = false
    } else if (phone.includes("-") ){
        $('#phoneError').val().innerHTML="-은 빼고 입력해주세요"
        $('#phone').focus()
        check = false
    }

    if(!gender_man && !gender_woman) {
        $('#genderError').val().innerHTML="성별을 선택해주세요"
        check = false
    }

    if(check) {
        $('#idError').val().innerHTML=""
        $('#pwdError').val().innerHTML=""
        $('#nameError').val().innerHTML=""
        $('#phoneError').val().innerHTML=""
        $('#genderError').val().innerHTML=""

        alert("가입 완료");
    }
}
