document.addEventListener('DOMContentLoaded', initForm);

function initForm() {
	// Ajax호출
	fetch('../empJson.json') // 반환값 : Promise객체
		.then(result=>result.json())// 출력스트림(json) -> 객체 변환
		.then(data => {console.log('data: ', data);
			data.forEach(emp => {
				let tr = makeRow(emp);
				document.querySelector('#elist').appendChild(tr);})
		})
		.catch(err=>console.log('err: ', err));

	document.querySelector('#addBtn').addEventListener('click',addRow);
}
function makeRow(ary = {}) {
		let props = ['empNo', 'empName', 'email', 'salary'];

		let tr = document.createElement('tr');
		tr.setAttribute('data-no', ary.empNo);

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

function addRow(){
	//db insert & 화면 출력	
	
	let ename = document.querySelector('#ename').value;
	let ephone = document.querySelector('#ephone').value;
	let email = document.querySelector('#email').value;
	let esal = document.querySelector('#esalary').value;
	let edate = document.querySelector('#edate').value;
	let tbody = document.querySelector('#elist');
	let param=`job=add&name=${ename}&phone=${ephone}&email=${email}&salary=${esal}&hire=${edate}`;
	// 사원이름(ename), 연락처(phone), 급여(salary), 입사일자(hire), 이메일(email)
	fetch('../empsave.json?',{
		method: 'post',
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		body: param
	})
		.then(result=> result.json())
		.then(data =>{
			if (data.retCode == 'OK') {
				let tr = makeRow(data.retVal);
				tbody.appendChild(tr);
			}
			else if (data.retCode == 'NG') { alert('처리중 에러발생'); }
		})
		.catch(err=>{console.log(err)})
}

function deleteRow(){
	let eno = this.parentElement.parentElement.dataset.no;
	let tr = this.parentElement.parentElement;
	fetch('../empsave.json?job=delete&empNo='+eno)
	.then(result=>result.json())
	.then(data =>{
		if(data.retCode=='OK'){
			tr.remove();
		}
		else if(data.retCode=='NG'){
			alert('처리실패!');
		}
	})
	.catch(err=>console.log(err));
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
	oldTr.parentElement.replaceChild(newTr,oldTr); // 바꿀요소,기존요소
}

function updateRow()
{
	let oldTr = this.parentElement.parentElement;
	const empNo = this.parentElement.parentElement.dataset.no;
	let email = this.parentElement.parentElement.children[2].children[0].value;
	let salary = this.parentElement.parentElement.children[3].children[0].value;
	
	fetch(`../empsave.json?job=edit&empNo=${empNo}&email=${email}&salary=${salary}`)
	.then(result=>result.json())
	.then(data =>{
		if(data.retCode == 'OK'){
		let newTr = makeRow(data.retVal);
		oldTr.parentElement.replaceChild(newTr,oldTr);
		}else if(data.retCode == 'NG'){
			alert('처리중 에러발생');
		}else{
			alert('처리코드 확인하세요');
		}
	})
	.catch(err=>console.log(err));
}
	