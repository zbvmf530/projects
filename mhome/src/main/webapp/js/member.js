let btnAdd = document.getElementById('#addMember');
let btnMod = document.getElementById('#modMember');
let name = document.getElementById('#memberName');
let num = document.getElementById('#memberNo');
let score = document.getElementById('#memberPoint');

let chkhead = document.getElementById('#chkAll');

let tbody = document.querySelectorAll('table').item(1).getElementsByTagName('tbody');



const members = [
	{ memNo: 1001, memName: '홍길동', memPnt: 90 },
	{ memNo: 1002, memName: '김길동', memPnt: 100 },
	{ memNo: 1003, memName: '박길동', memPnt: 95 }
];
console.log(btnAdd);
btnAdd.addEventListener('click',addMember);
chkhead.addEventListener('change',changeRow);

//수정 버튼 핸들러 연결
btnMod.addEventListener('click',modMember);
function modMember()
{
	let datas = tbody.item(0).getElementsByTagName('td');
	Array.from(datas).forEach(
		function(item,idx,arr) {
			if (item.innerText == num.value) {
				arr[idx+1].innerText = name.value;
				arr[idx+2].innerText = score.value;				
			}
		}
	);
	console.log(datas);
}



//members 배열의 개수만큼 tr 생성
members.forEach(function(item) {
	let tr = makeRow(item);
	tbody.item(0).appendChild(tr);
});

//member 정보를 활용 tr 반환
function makeRow(member = { memNo, memName, memPnt }) {

	let tr = document.createElement('tr');
	tr.addEventListener('click',inputclickedele);
	//addEventListener(이벤트 유형, 핸들러함수, propagation 옵션(true,false))
	for (let prop in member) {
		let tdele = document.createElement('td');
		tdele.innerText = member[prop];
		tr.appendChild(tdele);
	}
	let button = document.createElement('button');
	button.innerText = '삭제';
	button.addEventListener('click',deleteMember);
	
	// 삭제버튼
	let tdele = document.createElement('td');
	tdele.appendChild(button);
	
	tr.appendChild(tdele);

	// 체크박스
	let tdchk = document.createElement('td');
	let chk = document.createElement('input');
	chk.setAttribute('type', 'checkbox');
	tdchk.appendChild(chk);
	
	tr.appendChild(tdchk);
	
	return tr;
	//td button 삭제 
}

function addMember() {
	console.log(tbody.item(0));
	tbody.item(0).appendChild(makeRow([num.value, name.value, score.value]));
	}
function deleteMember(evnt){this.parentNode.parentNode.remove();evnt.stopPropagation();}

function changeRow()
{
	let chkRows = tbody.item(0).getElementsByTagName('input');
	console.log(chkRows);
	Array.from(chkRows).forEach(function(item){item.checked = chkhead.checked});	
}

// tr에 연결할 클릭이벤트
function inputclickedele()
{
	let inputs = [num,name,score];let td = this.childNodes;let i = 0;
	Array.from(inputs).forEach(function(item){item.value = td[i].innerText;i++;});
}
