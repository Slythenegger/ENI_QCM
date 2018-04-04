// Point d'entré
window.onload = function() {
	var page = $("body").attr("id");
	
	switch (page) {
		case "page-gt":  return pageGT();
	}
}




// Page Gestionnaire Test
function pageGT() {
	console.log("in")
}