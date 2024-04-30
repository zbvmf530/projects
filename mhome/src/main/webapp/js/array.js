/**
 * 
 */

 const ary = [];
 
 ary.push('apple');
 ary.push(['banana','cherry']);
 ary.push({name: "홍길동",age: 20});
 
 ary.forEach(function(item){console.log(item)})
 
 const fruits = [];
 fruits.push({name: "사과",price: 1000});
 fruits.push({name: "수박",price: 5000});
 //console.log(fruits);
 fruits.pop();
 //console.log(fruits);
 fruits.unshift({name: "수박",price: 5000});
 console.log(fruits);