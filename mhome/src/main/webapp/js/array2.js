let genderAry = [];
let obj = {id: 1, first_name: '', last_name: '', email: '', gender: '', salary: ''};
let props = ['id','first_name','email','salary'];

let selects = document.querySelector('#genderList');
selects.addEventListener('change', makeList); // 매개변수로 필터링된 배열 넘겨주면 될듯?

empList.forEach((item)=>{
	if(genderAry.indexOf(item.gender) == -1){genderAry.push(item.gender);}
});
//console.log(`성별 종류 : ${genderAry}`);

genderAry.forEach(gender=>{
	let opt = document.createElement('option');
	opt.innerHTML = gender;
	document.querySelector('#genderList').appendChild(opt);
	
})


window.onload = function() {
  empList.forEach(emp => {
		let tr = document.createElement('tr');
		props.forEach(prop => {
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td);
		});
		document.querySelector('#show tbody').appendChild(tr);
	});
}
//makeList(empList);

//함수 (배열)
function makeList(){
	document.querySelectorAll('#show tbody').item(0).innerHTML="";
	let gender = selects.options[selects.selectedIndex].value;
	
	const result = empList.filter(function (value) {
		return value.gender==gender; 
	});

	result.forEach(emp => {
		let tr = document.createElement('tr');
		props.forEach(prop => {
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td);
		});
		document.querySelector('#show tbody').appendChild(tr);
	});
}