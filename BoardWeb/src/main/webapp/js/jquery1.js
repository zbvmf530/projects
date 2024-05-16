/*
* jquery1.js
 */

// js
// document.addEventListener("DOMContentLoaded", initForm);

// jquery
$(document).ready(initForm);





 function initForm(){
	console.log($('input[type=checkbox]:first').is(':checked'));
	$('input[type=checkbox]:first').on('change',function(){
		$('input[type=checkbox]').prop('checked',($('thead input[type=checkbox]').is(':checked')));
	})
	
	$('tbody button:contains(삭제)').on('click', delRow);
	
	$('#addBtn').on('click',function(){
		let inputName = $('input[name="name"]');
		let inputScore = $('input[name="score"]');
		if(!inputName.val() || !inputScore.val()){alert('값을 입력하세요');return;}
		
		let tr = $('<tr />').append($('<td />').append($('<input/>').attr('type','checkbox')),
									$('<td />').text(inputName.val()),
									$('<td />').text(inputScore.val()),
									$('<td />').append($('<button/>').text('삭제')).on('click', delRow)
									);
	
	
	$('#list tbody').append(tr);
	inputName.val('');inputScore.val('');
	});
	
	$('#delBtn').on('click',function(){
		if($('thead input[type=checkbox]').is(':checked')){
			$('tbody input[type=checkbox]').parent().parent().remove();
		}
		else{
			$('tbody input[type=checkbox]')
			.each((idx,item)=>{
								if($(item).is(':checked'))
								{$(item).parent().parent().remove();}
							  });
		}
	});
 }
 
 function delRow(e){
	// js
	//e.target.parentElement.parentElement.remove();
	// jquery
	console.log($(e.target).parent().parent());
	$(e.target).parent().parent().remove();
 }