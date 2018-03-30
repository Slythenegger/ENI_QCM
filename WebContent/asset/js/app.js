window.onload = init;

function init(){
	document.getElementById("stagname").onclick = searchStagiaire();
	
	getNbUsers();
	getListeUsers();
	
	
}

function ajoutNote(){
	var data = "note="+encodeURIComponent(document.getElementById("nouv").value);

	console.log(data);
	var xhr = createXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				afficheListeBS(xhr.responseText);
			}
			else{
				erreur(xhr.responseText);
			}
		}
	};
	xhr.open("POST", 
			"/TPPriseDeNotesCorrection/rest/notes", 
			true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	xhr.send(data);

	document.getElementById("nouv").value = "";
}

function getListeUsers(){
	var xhr = createXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				afficheListeBS(xhr.responseText);
			}
			else{
				erreur(xhr.responseText);
			}
		}
	};
	xhr.open("GET", 
			"/ENI_QCM/rest/users", 
			true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.send(null);

}

function getNbNotes(){
	var xhr = createXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				afficheNb(xhr.responseText);
			}
			else{
				erreur(xhr.responseText);
			}
		}
	};
	xhr.open("GET", 
			"/TPPriseDeNotesCorrection/rest/notes/nb", 
			true);
	xhr.send(null);

}

function createXHR(){
	var xhr = null;
	if (window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){
		xhr = new ActiveXObject("Msxml2.XMLHTTP");
	}
	
	
	return xhr;
}

function supprime(id){
	var xhr = createXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				afficheListeBS(xhr.responseText);
			}
			else{
				erreur(xhr.responseText);
			}
		}
	};
	var data = "id="+id;

	xhr.open("DELETE", 
			"/TPPriseDeNotesCorrection/rest/notes", 
			true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	xhr.send(data);

}

function modif(id){
	var ch = encodeURIComponent(document.getElementById("lib"+id).value);
	console.log(ch);
	var xhr = createXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				afficheListeBS(xhr.responseText);
			}
			else{
				erreur(xhr.responseText);
			}
		}
	};
	var data = "note="+ch+"&id="+id;

	xhr.open("PUT", 
			"/TPPriseDeNotesCorrection/rest/notes", 
			true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	xhr.send(data);

}

function afficheListe(rep){
	var repJson = JSON.parse(rep);
	var chaine = "<ul>";
	for (var i = 0 ; i < repJson.length; i++){
		chaine +="<li>"+repJson[i].ixd + " : " +repJson[i].libelle;
		chaine +="<input type='button' value='suppr' onClick='supprime("+repJson[i].id+")'>";
		chaine +="</li>";
	}
	
	chaine += "</ul>";
	document.getElementById("liste").innerHTML=chaine;
	getNbNotes();

}function afficheListeBS(rep){
	var repJson = JSON.parse(rep);
	var chaine = "<table class='table table-striped'>";
	chaine += "<tr><th>id</th><th>Note</th><th>Date</th><th>&nbsp;</th><th>&nbsp;</th></tr>";
	for (var i = 0 ; i < repJson.length; i++){
		chaine += "<tr>"
		chaine +="<td>"+repJson[i].id + "</td>";
		var ch = repJson[i].libelle;
		console.log("ch avant : " + ch);
		ch = ch.replace("'", "&apos;");
		ch = ch.replace("\"", "&quot;");
		console.log("ch apres : " + ch);
		chaine +="<td><input type='text' value='"+ch + "' id='lib"+repJson[i].id+"'></td>";
		
		var d = new Array();
		d = new Date(repJson[i].date).toISOString();
		
		var da = d.substring(8,10)+ "/" + d.substring(5,7)+ "/"+ d.substring(0,4);
		
		chaine +="<td>"+da + "</td>";
		chaine +="<td><button type='button'  class='btn btn-primary' onClick='modif("+repJson[i].id+")'>Modification</button></td>";
		chaine +="<td><button type='button'  class='btn btn-danger' onClick='supprime("+repJson[i].id+")'>Suppression</button></td>";
		chaine +="</tr>";
	}
	
	chaine += "</table>";
	document.getElementById("liste").innerHTML=chaine;
	getNbNotes();

}

function afficheNb(rep){
	document.getElementById("nb").innerHTML=rep;
//	document.getElementById("echec").innerHTML="";
}
