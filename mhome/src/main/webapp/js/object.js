/**
 * 
 */
const obj = {
	name: "홍길동",
	age: 20,
	showInfo: function(){
		return `이름: ${this.name}, 나이: ${this.age}`
	},
	
	// then 매개값 : 함수
	empList: function(){
		// Ajax
		fetch('../empList.json')
		.then(function(result){
			return result.json(); // json() : json 문자열 -> 객체 변환.
		})
		.then(function(result){
			console.log(result); // 변환된 객체 출력
			result.forEach(function(member){
				let tr = document.createElement('tr');
				let tbody = document.querySelector('tbody');
				for(let prop in member)
				{
					let td = document.createElement('td');
					td.innerText = member[prop];
					tr.appendChild(td);
				}
				tbody.appendChild(tr);
			})
		}) 
	}
} // 객체 생성 방법 (=new Object())

/*console.log(`이름: ${obj.name}, 나이: ${obj["age"]}`);
console.log(obj.showInfo());*/

//console.log(window);
//alert('확인');

for(let prop in obj){console.log(`속성: ${prop} 값: ${obj[prop]}`)}
console.clear();
obj.empList();
// http://localhost:8080/mhome/myinfo/object.html
// object.js 실행경로