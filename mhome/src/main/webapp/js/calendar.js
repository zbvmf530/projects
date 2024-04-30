/**
 * 
 */
document.addEventListener("DOMContentLoaded",initForm);

function initForm()
{
let show = document.querySelector('#show');
show.appendChild(svc.makeTable());
document.querySelector('#show>table').appendChild(svc.makeHeader2());
document.querySelector('#show>table').appendChild(svc.makeBody());
}

const svc = {
	makeTable: function(){
		let tbl = document.createElement('table');
		tbl.setAttribute('border',2);
		return tbl;
	},
	makeHeader: function(){
		const days = ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'];
		let thd = document.createElement('thead');
		let tr = document.createElement('tr');
		
		days.forEach((day) => {
			let th = document.createElement('th');
			th.innerHTML = day;
			tr.appendChild(th);
		});
		
		thd.appendChild(tr);
		return thd;
	},
	makeHeader2: function(){
		const days = ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'];
		let thd = document.createElement('thead');
		
		thd.appendChild(days.reduce((acc, cur) => {
			let th = document.createElement('th');
			th.innerHTML = cur;
			acc.appendChild(th);
			return acc;
		}, document.createElement('tr')));  // 초기값:<thead></thead>
		
		return thd;
		
		
		/*days.forEach((day) => {
			let th = document.createElement('th');
			th.innerHTML = day;
			tr.appendChild(th);
		});
		
		thd.appendChild(tr);
		return thd;*/
	},
	makeBody: function(){
		let tbd = document.createElement('tbody');
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		td.innerHTML =' ';
		tr.appendChild(td);
		tbd.appendChild(tr);
		for(let d = 1; d<=30;d++)
		{
			
			let td = document.createElement('td');
			td.innerHTML = d;
			if(d%7==0)
			{
				tbd.appendChild(tr);
				tr = document.createElement('tr');
			}

			tr.appendChild(td);
		}
/*		days.forEach((day) => {
			let th = document.createElement('th');
			th.innerHTML = day;
			tr.appendChild(th);
		});*/
		
		tbd.appendChild(tr);
		return tbd;
	}
}
