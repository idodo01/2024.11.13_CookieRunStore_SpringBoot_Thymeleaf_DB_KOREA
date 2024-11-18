const idInput = document.getElementById('id');
const pwInput = document.getElementById('password');
const pwReInput = document.getElementById('password-re');
const telHead = document.querySelector('.tel-input-container select');
const [telMiddle, telTail] = document.querySelectorAll('.tel-input-container input');
const [emailHead, emailTail] = document.querySelectorAll('.email-input-container input');
const emailSelect = document.querySelector('.email-input-container select');
const emailAuthBtn = document.querySelector('.email-input-container button');
const emailAuthConfirmInput = document.querySelector('.email-auth-input-container input');
const emailAuthConfirmBtn = document.querySelector('.email-auth-input-container button');
const [joinBtn, cancelBtn] = document.querySelectorAll('.join-btn-section > button');
/************************************************************************/
const [idInputError, pwInputError, telInputError, emailInputError] = document.querySelectorAll('.error-container');

///// ********** 입력 검사
function check_input_values(){
    pwInputError.removeAttribute('active');
    idInputError.removeAttribute('active');




    //// 1. 아이디 체크
    const id = idInput.value.trim(); // 공백제거

    // ^[a-z][0-9a-zA-Z]*
    // ^ (시작해야한다) [a-z] (영어로)
    // (그다음으로) [0-9a-zA-Z] (숫자와 문자가 들어갈 수 있다)
    // (그리고) * (끝난다)

    // 길이도 정규식으로 표현할 수 있는데, 보기에 깔끔하지 않아서 따로 할 거임
    if(!((/^[a-z][0-9a-zA-Z]*$/.test(id)) && (id.length >= 4) && (id.length <= 15))){
        idInputError.setAttribute('active', '');
        return false;
    }

    //// 2. 비밀번호 체크
    const pw = pwInput.value.trim();
    const pwRe = pwReInput.value.trim();

    const pwErrorSpan = pwInputError.querySelector('span');

    // 패스워드 잘못적음
    if(!/^[0-9a-zA-Z~!@#$%^&*()_=+.-]{4,10}$/.test(pw)){
        pwInputError.setAttribute('active', '');
        pwErrorSpan.textContent = '비밀번호 형식이 잘못되었습니다';
        return false;
    }
    // 패스워드 재입력과 다름
    if(pw !== pwRe){
        pwInputError.setAttribute('active', '');
        pwErrorSpan.textContent = '기존 입력한 비밀번호와 재입력한 비밀번호가 다릅니다';
        return false;
    }
    // 3. 전화번호 검사
    const telHeadValue = telHead.value.trim();
    const telMiddleValue = telMiddle.value.trim();
    const telTailValue = telTail.value.trim();
    const tel = `${telHeadValue}-${telMiddleValue}-${telTailValue}`;
    if(!/^(010|011|017|019|018)-[0-9]{3,4}-[0-9]{4}$/.test(tel)){
        telInputError.setAttribute('active', '');
        return false;
    }

    // 4. 이메일 검사
    const emailHeadValue = emailHead.value.trim();
    const emailTailValue = emailTail.value.trim();
    const email = `${emailHeadValue}@${emailTailValue}`;
    if(!/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)){
        emailInputError.setAttribute('active', '');
        return false;
    }



    return true;

}


///// ********** 회원가입 버튼 클릭 시
// 1) submit 버튼에서 event의 기본 동작 취소하기
joinBtn.onclick = (event) => {
    // input 값들 중 하나라도 잘못 적었다면
    if(!check_input_values()){
        event.preventDefault();
        return;
    }
}
// // 2) form의 submit event의 기본 동작 취소하기
// document.forms[0].onsubmit = event => {
//     // input 값들 중 하나라도 잘못 적었다면
//     if(!check_input_values()){
//         alert('실행안함///');
//         event.preventDefault();
//     }
// }




