/*
* 비동기식 방식(코드의 비순차적 실행)
* ajax(Asynchronous JavaScript and XML)
*/
setTimeout(function(){
	console.log("step 1");
},1000);

setTimeout(function(){
	console.log("step 2");
},3000);

setTimeout(function(){
	console.log("step 3");
},2000);