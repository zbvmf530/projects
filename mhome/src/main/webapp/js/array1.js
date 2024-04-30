
//console.log(empList);
empList.forEach((item,idx)=>
{	
	if(item.gender=="Female" && item.first_name.indexOf('G') > 0)
	{console.log(item);}	
});

let newAry = empList.filter((item,idx,arr)=>{
			
	return (idx+1)==arr.length;
	
});

newAry = empList.map((item,idx,arr)=>{
	const obj = {
		no: item.id,
		name: item.first_name+" "+item.last_name,
		email: item.email
	}
	return obj;
});


const array1 = [1, 7, 2, 9, 3, 4];
const initialValue = array1[0];
const sumWithInitial = array1.reduce(
  (acc, currentValue) => {
   console.log(`acc => ${acc}, currentValue => ${currentValue}`)
   return acc > currentValue?currentValue:acc;
   }, initialValue);

console.log(sumWithInitial);




const array2 = ['Shae', 'Mozelle', 'Huntley', 'Donalt'];
const initialValue2 = '';
const sumWithInitial2 = array2.reduce((acc, currentValue) => {return acc + currentValue.toLowerCase();}, '');
   
console.log(sumWithInitial2);




let result = empList.reduce((acc,curVal)=>{
	if(curVal.gender == 'Male') acc.push(curVal);
	return acc;
},[])

console.log(result);

let genderAry = [];

empList.forEach((item,idx)=>{
	if(genderAry.length==0){genderAry.push(item.gender);}
	else {
		let checked=false;
		for (let gnd of genderAry) {
			if(item.gender == gnd){checked=true;}
		}
		if(checked==false){genderAry.push(item.gender);}
	}
	
	
});

console.log(`성별 종류 : ${genderAry}`);

   