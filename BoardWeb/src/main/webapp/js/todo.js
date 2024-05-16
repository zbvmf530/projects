/**
 * todo.js
 */
// Create a "close" button and append it to each list item
var myNodelist = $("#myUL").children().append($("<span>x<span/>").addClass('close'));
// Click on a close button to hide the current list item
$('.close').on('click',e=>$(e.target).parent().css('display','none'));


// Add a "checked" symbol when clicking on a list item
$('ul').on('click', 'li', function(){
      $(this).toggleClass('checked');   
   })

// Create a new list item when clicking on the "Add" button

function newElement() {
	var li = $("<li/>");
	var inputValue = $("#myInput").val();
	var t = document.createTextNode(inputValue);
	li.append(t);
	if (inputValue === '') {
		alert("You must write something!");
	} else {
		$("#myUL").append(li);
	}
	$("#myInput").val("");

	var span = document.createElement("SPAN");
	var txt = document.createTextNode("\u00D7");
	span.className = "close";
	span.appendChild(txt);
	li.appendChild(span);

	for (i = 0; i < close.length; i++) {
		close[i].onclick = function() {
			var div = this.parentElement;
			div.style.display = "none";
		}
	}
}