

document.addEventListener('DOMContentLoaded', initForm);

function initForm() {
	// Ajax호출
	svc.empList(
		function(result) {
			console.log('success: ', result);
			result.forEach(emp=>{
				let tr = makeRow(emp);
				document.querySelector('#elist').appendChild(tr);
				})
		},//successCall
		err=> console.log('fail: ', err)
		);

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
	// 사원이름(ename), 연락처(phone), 급여(salary), 입사일자(hire), 이메일(email)

	let tbody = document.querySelector('#elist');
	
	let paramObj = {
		job: 'add',
		name: document.querySelector('#ename').value,
		phone: document.querySelector('#ephone').value,
		email: document.querySelector('#email').value,
		salary: document.querySelector('#esalary').value,
		hire: document.querySelector('#edate').value
	}
	svc.addEmp(paramObj,
		data => {
			if (data.retCode == 'OK') {
				let tr = makeRow(data.retVal);
				tbody.appendChild(tr);
			}
			else if (data.retCode == 'NG') { alert('처리중 에러발생'); }
		},
		err => console.log(err)
	)
	
}

function deleteRow(){
	let eno = this.parentElement.parentElement.dataset.no;
	let tr = this.parentElement.parentElement;
	
	
	svc.deleteEmp(eno,
		data => {
			if (data.retCode == 'OK') {tr.remove();}
			else if (data.retCode == 'NG') {alert('처리실패!');}
		},
		err=>console.log(err)
	);
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
	
	let paramObj={
		empNo,
		salary,
		email
	}
	svc.editEmp(paramObj,
		data => {
			if (data.retCode == 'OK') {
				let newTr = makeRow(data.retVal);
				oldTr.parentElement.replaceChild(newTr, oldTr);
			}
			else if (data.retCode == 'NG') {
				alert('처리중 에러발생');
			} else {
				alert('처리코드 확인하세요');
			}
		}
		,err=>console.log(err)
	)
}
	