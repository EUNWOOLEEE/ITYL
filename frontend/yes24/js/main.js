// 아이디/비밀번호 예외처리
const $loginBtn = document.querySelector('.login_button > input');
const $loginID = document.querySelector('#input_id');
const $loginPWD = document.querySelector('#input_pwd');
const $loginIDMsg = document.querySelector('.login_error_msg.input_id');
const $loginPWDMsg = document.querySelector('.login_error_msg.input_pwd');

$loginBtn.addEventListener('click', () => {
	if ($loginID.value == '') {
		$loginID.style = 'border: 1px solid red';
		$loginPWD.style = 'border: 1px solid lightgray';
		$loginIDMsg.style = 'display: block';
		$loginPWDMsg.style = 'display: none';
	}
	else if ($loginPWD.value == '') {
		$loginID.style = 'border: 1px solid lightgray';
		$loginPWD.style = 'border: 1px solid red';
		$loginIDMsg.style = 'display: none';
		$loginPWDMsg.style = 'display: block';
	}
	else {
		$loginID.style = 'border: 1px solid lightgray';
		$loginPWD.style = 'border: 1px solid lightgray';
		$loginIDMsg.style = 'display: none';
		$loginPWDMsg.style = 'display: none';
	}
})

// 주문번호/주문비밀번호 예외처리
const $guestBtn = document.querySelector('.guest_button > input');
const $orderNum = document.querySelector('#order_number');
const $orderPWD = document.querySelector('#order_pwd');
const $orderNumMsg = document.querySelector('.login_error_msg.order_number');
const $orderPWDMsg = document.querySelector('.login_error_msg.order_pwd');

$guestBtn.addEventListener('click', () => {
	if ($orderNum.value == '') {
		$orderNum.style = 'border: 1px solid red';
		$orderPWD.style = 'border: 1px solid lightgray';
		$orderNumMsg.style = 'display: block';
		$orderPWDMsg.style = 'display: none';
	}
	else if ($orderPWD.value == '') {
		$orderNum.style = 'border: 1px solid lightgray';
		$orderPWD.style = 'border: 1px solid red';
		$orderNumMsg.style = 'display: none';
		$orderPWDMsg.style = 'display: block';
	}
	else {
		$orderNum.style = 'border: 1px solid lightgray';
		$orderPWD.style = 'border: 1px solid lightgray';
		$orderNumMsg.style = 'display: none';
		$orderPWDMsg.style = 'display: none';
	}
})

// 회원, 비회원 탭 전환
const $tabMember = document.querySelector('.member');
const $tabGuest = document.querySelector('.guest');
const $localMember = document.querySelector('.local_member');
const $localGuest = document.querySelector('.local_guest');

function clickLoginTab(clickedTab, anotherTab, clickedDiv, anotherDiv) {
	clickedTab.classList.add('clicked');
	clickedTab.classList.remove('unclicked');
	anotherTab.classList.add('unclicked');
	anotherTab.classList.remove('clicked');

	clickedDiv.style = 'display: block';
	anotherDiv.style = 'display: none';

	$loginID.value = '';
	$loginPWD.value = '';
	$loginID.style = 'border: 1px solid lightgray';
	$loginPWD.style = 'border: 1px solid lightgray';
	$loginIDMsg.style = 'display: none';
	$loginPWDMsg.style = 'display: none';
	
	$orderNum.value = '';
	$orderPWD.value = '';
	$orderNum.style = 'border: 1px solid lightgray';
	$orderPWD.style = 'border: 1px solid lightgray';
	$orderNumMsg.style = 'display: none';
	$orderPWDMsg.style = 'display: none';
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