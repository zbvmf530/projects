/**
 * 
 */

    // findBtn의 클릭이벤트를 생성.
    // input태그의 값을 확인.
    // span 요소 모두를 가져온다.
    // input값과  span의 값을 비교한다. 같으면 remove힌다.
    // 입력값을 지워준다.
    console.time();
    console.log(document.getElementById('findBtn'));
    document.getElementById('findBtn').addEventListener('click', function(e){
    	let keyword = document.getElementById('keyword');
    	let list = document.querySelectorAll('span');
    	list.forEach(function(item) {
    		if(item.innerText == keyword.value)
    			{item.remove();}
    	});
    });
    
    let sec = 100;
    setInterval(function(){
		sec--;
    document.getElementById('#remainCount')
    .innerText=sec+"초";
    console.log(document.querySelectorAll('span').length);
	},1000);
	
	
	let result = document.createElement('p');
	let body = document.getElementsByTagName('body');
	console.log(body.item(0));
	body.item(0).appendChild(result);
	if(sec==0 && document.querySelectorAll('span').length>0)
	{
		result.innerText = '실패';	
	}
	if(sec>0 && document.querySelectorAll('span').length<=0)
	{result.innerText = '성공';}
	