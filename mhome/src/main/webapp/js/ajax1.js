/**
 * 
 */

 const xhtp = new XMLHttpRequest();
 xhtp.open('get','../empList.json');
 xhtp.send();
 xhtp.onload=function(){
	console.log(xhtp);
	let jsonObj = JSON.parse(xhtp.responseText);
	console.log(jsonObj);
	jsonObj.forEach(obj=>console.log(obj['empName']))
 };
 


