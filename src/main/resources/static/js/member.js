//연도 설정
$(document).ready(function(){
    let date = new Date();
    let selYear = date.getFullYear();

    //현재년도를 기준으로 호출
    getYears(selYear);

    //현재년도를 select 함
    $('#year').val(selYear);

    //바뀐년도를 기준으로 다시 option 세팅
    $('#year').change(function() {
        let chgYear = $(this).val();
        getYears(chgYear);
        $('#year').val(chgYear);
    });
});

function getYears(getY) {

    //기존 option을 삭제
    //$("#year option").remove();

    //올해 기준으로 -70부터 올해까지 보여줌
    let stY = Number(getY)-70;
    let enY = Number(getY);
    for(let y = stY; y <= enY; y++) {
        $('#year').append("<option value='"+y+"'>" + y +"</option>");
    }
}

function getBirth() {
    const year = $("#year option:selected").text();
    const month = $("#month option:selected").text();
    const day = $("#day option:selected").text();

    return year.concat('-').concat(month).concat('-').concat(day);
}

function getGender() {
    const gender = document.getElementsByName("gender");
    const selected = Array.from(gender).find(radio => radio.checked);

    return selected
}

//입력 값 받기
function checkValid(id, pwd, name, phone) {

    if (id === '') {
        alert('아이디를 입력해주세요.');
        $('#id').focus();
        return false;
    }

    if (pwd === '') {
        alert('비밀번호를 입력해주세요');
        $('#pwd').focus();
        return false;
    }

    if (name === '') {
        alert('이름을 입력해주세요');
        $('#name').focus();
        return false;
    }

    if (phone === '') {
        alert('핸드폰 번호를 입력해주세요');
        $('#phone').focus();
        return false;
    }

    return true;
}

$( '#btnJoin' ).click( function() { //회원가입 버튼 누르면 값 가져와서
    let id = $('#id').val();
    let pwd = $('#pwd').val();
    let name = $('#name').val();
    let phone = $('#phone').val();
    let email = $('#email').val();

    if (checkValid(id, pwd, name, phone, email) === true) { //위의 조건들 다 충족하면 true로 되어서 if문 실행, ajax 실행
        const data = {
            memberId: id,
            memberPwd: pwd,
            memberName: name,
            memberPhone: phone,
            memberEmail: email,
            memberBirth: getBirth(), //위 함수에서 셀렉트 박스 값 가져옴
            memberGender: getGender()
        }


        $.ajax({
            url: '/geonju/joinform',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (res) { //성공 시 성공 알러트+메인 화면으로 넘어감
                alert("join success");
                location.href = "/geonju/"
            },
            error: function (err) { //실패 시 실패 알러트+에러 알러트
                alert("회원가입 실패");
                alert(JSON.stringify(err));
            }
        })
    }
});

