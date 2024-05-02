let genderAry = [];
let obj = {id: 1, first_name: '', last_name: '', email: '', gender: '', salary: ''};
let props = ['id','first_name','email','salary'];

let selects = document.querySelector('#genderList');
selects.addEventListener('change', function(){
	console.log(this.value);
	const result = empList.filter(function (value) {
		return value['gender']==this.value; 
	});
	makeList(result);
});
empList.forEach((item)=>{
	if(genderAry.indexOf(item.gender) == -1){genderAry.push(item.gender);}
});
//console.log(`성별 종류 : ${genderAry}`);

genderAry.forEach(gender=>{
	let opt = document.createElement('option');
	opt.innerHTML = gender;
	document.querySelector('#genderList').appendChild(opt);
	
})


/*window.onload = function() {
  empList.forEach(emp => {
		let tr = document.createElement('tr');
		props.forEach(prop => {
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td);
		});
		document.querySelector('#show tbody').appendChild(tr);
	});
}*/
makeList(empList);

//함수 (배열)
function makeList(ary = []){
	document.querySelectorAll('#show tbody').item(0).innerHTML="";

	ary.forEach(emp => {
		let tr = document.createElement('tr');
		props.forEach(prop => {
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td);
		});
		document.querySelector('#show tbody').appendChild(tr);
	});
}