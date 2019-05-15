
function onLoad(){ 
	// Block scroll when mouseover to flat (flipster).
	document.getElementById('flat').addEventListener('mouseover', function(){
		var container = document.getElementById('container');
		var body = document.body;
		body.style.overflowY = 'hidden';
		container.style.overflowY = 'scroll';
	});
	document.getElementById('flat').addEventListener('mouseleave', function(){
		var container = document.getElementById('container');
		var body = document.body;
		body.style.overflowY = 'initial';
		container.style.overflowY = 'initial';
	});
}