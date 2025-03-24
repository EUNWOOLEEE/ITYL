function setInputErrorStyle(errorInput, anotherInput, errorMsg, anotherMsg) {
	errorInput.style = 'border: 1px solid red';
	anotherInput.style = 'border: 1px solid lightgray';
	errorMsg.style = 'display: block';
	anotherMsg.style = 'display: none';
}

function setInputResetStyle(input, msg) {
	input.style = 'border: 1px solid lightgray';
	msg.style = 'display: none';
}

// 아이디/비밀번호 예외처리
const $loginBtn = document.querySelector('.login_button > input');
const $loginID = document.querySelector('#input_id');
const $loginPWD = document.querySelector('#input_pwd');
const $loginIDMsg = document.querySelector('.login_error_msg.input_id');
const $loginPWDMsg = document.querySelector('.login_error_msg.input_pwd');

$loginBtn.addEventListener('click', () => {
	if ($loginID.value == '')
		setInputErrorStyle($loginID, $loginPWD, $loginIDMsg, $loginPWDMsg);
	else if ($loginPWD.value == '')
		setInputErrorStyle($loginPWD, $loginID, $loginPWDMsg, $loginIDMsg);
	else {
		setInputResetStyle($loginID, $loginIDMsg);
		setInputResetStyle($loginPWD, $loginPWDMsg);
	}
})

// 주문번호/주문비밀번호 예외처리
const $guestBtn = document.querySelector('.guest_button > input');
const $orderNum = document.querySelector('#order_number');
const $orderPWD = document.querySelector('#order_pwd');
const $orderNumMsg = document.querySelector('.login_error_msg.order_number');
const $orderPWDMsg = document.querySelector('.login_error_msg.order_pwd');

$guestBtn.addEventListener('click', () => {
	if ($orderNum.value == '')
		setInputErrorStyle($orderNum, $orderPWD, $orderNumMsg, $orderPWDMsg);
	else if ($orderPWD.value == '')
		setInputErrorStyle($orderPWD, $orderNum, $orderPWDMsg, $orderNumMsg);
	else {
		setInputResetStyle($orderNum, $orderNumMsg);
		setInputResetStyle($orderPWD, $orderPWDMsg);
	}
})

// 회원, 비회원 탭 전환
const $tabMember = document.querySelector('.member');
const $tabGuest = document.querySelector('.guest');
const $localMember = document.querySelector('.local_member');
const $localGuest = document.querySelector('.local_guest');

function clickLoginTab(clickedTab, anotherTab, clickedDiv, anotherDiv) {
	cleanTabs();
	
	clickedTab.classList.add('clicked');
	clickedTab.classList.remove('unclicked');
	anotherTab.classList.add('unclicked');
	anotherTab.classList.remove('clicked');

	clickedDiv.style = 'display: block';
	anotherDiv.style = 'display: none';
}

function cleanTabs() {
	$loginID.value = '';
	$loginPWD.value = '';
	setInputResetStyle($loginID, $loginIDMsg);
	setInputResetStyle($loginPWD, $loginPWDMsg);
	
	$orderNum.value = '';
	$orderPWD.value = '';
	setInputResetStyle($orderNum, $orderNumMsg);
	setInputResetStyle($orderPWD, $orderPWDMsg);
}

$tabMember.addEventListener('click', () => {
	clickLoginTab($tabMember, $tabGuest, $localMember, $localGuest);
})
$tabGuest.addEventListener('click', () => {
	clickLoginTab($tabGuest, $tabMember, $localGuest, $localMember);
})

// 로그인 상태 유지 알림창
const $checkboxLoginStateNotice = document.querySelector('#remain_login_state');
const $btnLoginStateNoticeClose = document.querySelector('.login_state_notice_over > button');
const $loginStateNotice = document.querySelector('.login_state_notice');

$checkboxLoginStateNotice.addEventListener('click', () => {
	if ($checkboxLoginStateNotice.checked == true)
		$loginStateNotice.style = 'display: block';
	else
		$loginStateNotice.style = 'display: none';
})

$btnLoginStateNoticeClose.addEventListener('click', () => {
	$loginStateNotice.style = 'display: none';
	$checkboxLoginStateNotice.checked = false;
})