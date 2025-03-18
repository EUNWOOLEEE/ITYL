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