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
    /*const id = $('#id').val();
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
    }*/

    // const id = document.getElementById("id").value
    // const pwd = document.getElementById("pwd").value
    // const name = document.getElementById("name").value
    // const phone = document.getElementById("phone").value
    // const gender_man = document.getElementById("gender_man").value
    // const gender_woman = document.getElementById("gender_woman").value
    //
    // let check = true;
    //
    // //아이디
    // if(id===""){
    //     document.getElementById("idError").innerHTML="아이디를 입력해주세요."
    //     check = false
    // }else{
    //     document.getElementById("idError").innerHTML=""
    // }
    //
    // //비밀번호
    // // if(pwd===""){
    // //     document.getElementById("pwdError").innerHTML="비밀번호를 입력해주세요."
    // //     check = false
    // // }else{
    // //     document.getElementById("pwdError").innerHTML=""
    // // }
    //
    // //이름
    // if(name===""){
    //     document.getElementById("nameError").innerHTML="이름을 입력해주세요."
    //     check = false
    // }else{
    //     document.getElementById("nameError").innerHTML=""
    // }
    //
    // //폰 번호
    // if(phone===""){
    //     document.getElementById("phoneError").innerHTML="휴대폰 번호를 입력해주세요."
    //     check = false
    // }else {
    //     document.getElementById("phoneError").innerHTML = ""
    // }
    //
    // //성별
    // if(!gender_man && !gender_woman){
    //     document.getElementById("genderError").innerHTML="성별을 선택해주세요."
    //     check = false
    // }else{
    //     document.getElementById("genderError").innerHTML=""
    // }
    //
    // if(check) {
    //     document.getElementById("idError").innerHTML=""
    //     document.getElementById("pwdError").innerHTML=""
    //     document.getElementById("nameError").innerHTML=""
    //     document.getElementById("phoneError").innerHTML=""
    //     document.getElementById("genderError").innerHTML=""
    //
    //     alert("가입 완료");
    // }

    $(document).ready(function() {
        $('#joinForm').submit(function() {
            if (inputValid() === false) {
                return false;
            }
        });
    });

    function inputValid() {
        if ($('#pwd')==='') {
            $('#status')
                .attr('value', '비밀번호를 입력해주세요.')
                .addClass('has-danger');
            return false;
        }
        $('#status')
            .attr('value', '성공')
            .removeClass('has-danger')
            .addClass('has-success');
        return true;
    }

}
