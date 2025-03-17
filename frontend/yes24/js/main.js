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