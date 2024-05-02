 // html -> Servlet ->EmpDAO -> DB
 // emp.html empJson.json EmpDAO jsp.emp
document.addEventListener("DOMContentLoaded",initForm);

// 화면 로딩 후 처음 실행할 함수
function initForm(){
	// Ajax호출
	const xhtp = new XMLHttpRequest();
	xhtp.open('get','../empJson.json');
	xhtp.send();
	xhtp.onload = function(){
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
		data.forEach(emp => {
			let tr = makeRow(emp);
			document.querySelector('#elist').appendChild(tr);
		})
	}
	document.querySelector('#addBtn').addEventListener('click',addRow);
}

function addRow(){
	//db insert & 화면 출력	
	const addHtp = new XMLHttpRequest();
	let ename = document.querySelector('#ename').value;
	let ephone = document.querySelector('#ephone').value;
	let email = document.querySelector('#email').value;
	let esal = document.querySelector('#esalary').value;
	let edate = document.querySelector('#edate').value;
	let tbody = document.querySelector('#elist');
	// 사원이름(ename), 연락처(phone), 급여(salary), 입사일자(hire), 이메일(email)
	let param=`../empsave.json?job=add&name=${ename}&phone=${ephone}&email=${email}&salary=${esal}&hire=${edate}`;
	addHtp.open('get',param);
	addHtp.send();
	addHtp.onload=function(){
		let result = JSON.parse(addHtp.responseText);
		if(result.retCode == 'OK'){
			console.log(result.retVal)
			let tr = makeRow(result.retVal);
			tbody.appendChild(tr);
		}else if(result.retCode == 'NG'){
			alert('처리중 에러발생');
		}else{
			alert('처리코드 확인하세요');
		}
		console.log(result);
	} 
	
}

function makeRow(ary = {}) {
	let props = ['empNo', 'empName', 'email', 'salary'];

	let tr = document.createElement('tr');
	tr.setAttribute('data-no',ary.empNo);
	
	tr.addEventListener('dblclick',modifyRow);
	props.forEach(prop => {
		let td = document.createElement('td');
		td.innerHTML = ary[prop];
		tr.appendChild(td);
	});
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

// 화면 수정 함수()
function modifyRow()
{
	let originMail = this.children[2].innerText;
	let originSalary = this.children[3].innerText;
	let oldTr = this;
	let newTr = this.cloneNode(true); // 매개값 true : 하위요소 까지 복제해줌
	newTr.querySelector('td:nth-of-type(3)').innerHTML = '<input value="'+originMail+'">';
	newTr.querySelector('td:nth-of-type(4)').innerHTML = '<input value="'+originSalary+'">';
	newTr.querySelector('button').innerText = '수정';
	newTr.querySelector('button').addEventListener('click',updateRow);
	console.log(newTr);
	oldTr.parentElement.replaceChild(newTr,oldTr); // 바꿀요소,기존요소
}


function updateRow(){
	const editHtp = new XMLHttpRequest();
	let oldTr = this.parentElement.parentElement;
	const empNo = this.parentElement.parentElement.dataset.no;
	let email = this.parentElement.parentElement.children[2].children[0].value;
	let salary = this.parentElement.parentElement.children[3].children[0].value;
	console.log(empNo);
	console.log(email);
	console.log(salary);
	let param=`../empsave.json?job=edit&empNo=${empNo}&email=${email}&salary=${salary}`;
	editHtp.open('get',param);
	editHtp.send();
	editHtp.onload = function(){
		let result = JSON.parse(editHtp.responseText);
		console.log(result.retCode);
		if(result.retCode == 'OK'){
		let newTr = makeRow(result.retVal);
		oldTr.parentElement.replaceChild(newTr,oldTr);
		}else if(result.retCode == 'NG'){
			alert('처리중 에러발생');
		}else{
			alert('처리코드 확인하세요');
		}
	}
}


function deleteRow(){
	const delNo = this.parentElement.parentElement.children[0].innerText;
	let tr = this.parentElement.parentElement;
	//서블릿 실행(삭제) -> OK 반환 -> 화면처리	
	const delHtp = new XMLHttpRequest();
	delHtp.open('get','../empsave.json?job=delete&empNo='+delNo);
	delHtp.send();
	delHtp.onload = function(){
		let result = JSON.parse(delHtp.responseText);// retCode:OK or NG
		if(result.retCode == 'OK'){
			tr.remove();
		}else if(result.retCode == 'NG'){
			alert('처리중 에러발생');
		}else{
			alert('처리코드 확인하세요');
		}
	}	
}