function disable() {
	document.getElementById("promo").disabled = true;
}
function enable() {
	document.getElementById("promo").disabled = false;
}
function changeEvent() {
	if (document.getElementById("role").value == "STA")
		enable();
	else
		disable();

}