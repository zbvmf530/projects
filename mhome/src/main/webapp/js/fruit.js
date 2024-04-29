/**
 * 
 */
		let button = document.querySelector('button');
		let btn2 = document.querySelector('button:nth-of-type(2)');

		let name = document.querySelector('input');
		let val = document.querySelector('input:nth-of-type(2)');
		console.log(btn2);

		button.addEventListener('click', 
				function() {
			
			// 요소생성(createElement)
			let li = document.createElement('li');
			li.innerText = name.value+'('+val.value+')';
			// 자식요소(appendChild)
			document.querySelector('ul').appendChild(li);
		});

		btn2.addEventListener('click', 
				function() {
			// 요소생성(createElement)
			let p = document.querySelector('p');
//			let inputlabel = document.createElement('input');
//			inputlabel.innerText = '망고';
//			document.querySelector('body').appendChild(inputlabel);
			p.innerText = '변경됨';
			
			});
			

		let list = document.querySelectorAll('li');
		for(li of list)
		{
		let btn_del = document.createElement('button');
		btn_del.innerText = '삭제';
			li.appendChild(btn_del);
			btn_del.addEventListener('click',function(){btn_del.parentNode.style.display="none"})
		}
		console.log(list);
	
		