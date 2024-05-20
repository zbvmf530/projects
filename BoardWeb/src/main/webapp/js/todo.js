/**
 * todo.js
 */
// Create a "close" button and append it to each list item
var myNodelist = $("#myUL").children().append($("<span>x<span/>").addClass('close'));

// Click on a close button to hide the current list item
$('.close').on('click',e=>$(e.target).parent().css('display','none'));

// Add a "checked" symbol when clicking on a list item
$('ul').on('click', e => $(e.target).toggleClass('checked'));

// Create a new list item when clicking on the "Add" button

function newElement() {
	var li = $("<li/>");
	var inputValue = $("#myInput").val();
	li.text(inputValue);
	$("#myInput").val("");
	li.append($("<span>x<span/>").addClass('close'));
	li.find('.close').on('click',e=>$(e.target).parent().css('display','none'));
	inputValue === ''?alert("You must write something!"):$("#myUL").append(li);
}