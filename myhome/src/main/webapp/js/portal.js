
const showTitles = ['id', 'centerName', 'address', 'sido', 'phoneNumber'];
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=3oXa0kTfi0xWo%2Bv2lTc2sCwzSvL5vROmzCAwvoHkm1ANe8UzjU%2BIz7NN9wFE%2B4aY3JhZcW3F4VA1oCEVfYRgTw%3D%3D';
let totalData = [];


//api 호출
fetch(url)
	.then(result => result.json())
	.then(data => {
		console.log(data)
		totalData = data.data;
		showPaging(12);

		/*
		pagingList();
		data.data.forEach(center=>{
			let tr = makeRow(center);
			document.querySelector('#list').appendChild(tr);
		})
		*/
	})
	.catch();

/*// 링크 클릭하면 페이지 호출.
document.querySelectorAll('.pagination a').forEach(aTag => {
	console.log(aTag);
	aTag.addEventListener('click', function(e) {
		e.preventDefault(); // a 페이지이동 차단
		let page = this.innerText;
		showPaging(page);
	})
})*/
let totalCnt = 284;
function pagingList(page = 1) {
	let pagination = document.querySelector('.pagination');
	pagination.innerHTML = '';
	let startPage, endPage;
	let prev, next;
	let realEnd = Math.ceil(totalCnt / 10);

	endPage = Math.ceil(page / 10) * 10;
	endPage = endPage > realEnd ? realEnd : endPage;
	startPage = endPage - 9;

	next = endPage < realEnd ? true : false;
	prev = startPage > 1;
	console.log('next: ' + next);
	console.log('prev: ' + prev);
	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.setAttribute('data-page', startPage - 1);
		aTag.innerHTML = '&laquo;';
		aTag.addEventListener('click', function(e) {
			let page = e.target.dataset.page;
			showPaging(page);
		})
		pagination.appendChild(aTag);
	}

	// aTag 생성, 이벤트 추가
	for (let n = startPage; n <= endPage; n++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.innerHTML = n;
		if (page == n) { aTag.className = 'active'; }
		aTag.addEventListener('click', function(e) {
			let page = e.target.innerHTML;
			//console.log(e.target.parentElement);
			//			this.className='active';
			showPaging(page);
		})
		pagination.appendChild(aTag);
	}
	if (next) {
		console.log(endPage - 1);
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.setAttribute('data-page', endPage + 1);
		aTag.innerHTML = '&raquo;';
		aTag.addEventListener('click', function(e) {
			let page = e.target.dataset.page;

			showPaging(page);
		})
		pagination.appendChild(aTag);
	}
}

function showPaging(page = 1) {
	let startNo = (page - 1) * 10; let endNo = page * 10;
	let fAry = totalData.filter((_, idx) => idx >= startNo && idx < endNo);
	document.querySelector('#list').innerHTML = '';
	fAry.forEach(center => {
		let tr = makeRow(center);
		document.querySelector('#list').appendChild(tr);
	})
	pagingList(page);
}


function makeRow(center = {}) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', function(e){
		// jsp로 넘기는 것이 더 편함. 추후 실습
		window.open('daum.html?x='+center.lat+'&y='+center.lng+'&loc='+(center.centerName+ '').replace('코로나19', '')); 
	})
	showTitles.forEach(title => {
		let td = document.createElement('td');
		let name = center[title];
		td.innerHTML = (name + '').replace('코로나19', '');
		tr.appendChild(td);
	});
	return tr;
}