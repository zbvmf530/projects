let genderAry = [];



empList.forEach((item)=>{
	if(genderAry.indexOf(item.gender) == -1){genderAry.push(item.gender);}
});
console.log(`성별 종류 : ${genderAry}`);

genderAry.forEach(gender=>{
	let opt = document.createElement('option');
	opt.innerHTML = gender;
	document.querySelector('#genderList').appendChild(opt);
	
})

//함수 (배열)
function makeList(ary = []){
	let obj = {id: 1, first_name: '', last_name: '', email: '', gender: '', salary: ''};
	let props = ['id','first_name','email','salary'];
	
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

makeList(empList);