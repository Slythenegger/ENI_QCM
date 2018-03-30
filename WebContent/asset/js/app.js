window.onload = init;
var username="";


function setUsername(){
	username = this.value;
	console.log(username);
	getListeUsers()
}
function init(){
	
	document.getElementById("stagname").onkeyup = setUsername;
	document.getElementById("candiname").onkeyup = setUsername;
	getListeUsers();
	
	
}

function getListeUsers(){
	var xhr = createXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				console.log(xhr.responseText)
				afficheListeCAN(xhr.responseText);
				afficheListeSTA(xhr.responseText);
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



function afficheListeCAN(rep){
	var repJson = JSON.parse(rep);
	var chaine = "<table class='table table-striped'>";
	chaine += "<tr><th></th><th>Nom</th><th>Prenom</th><th>Mail</th></tr>";
	for (var i = 0 ; i < repJson.length; i++){
		if(repJson[i].role=="CAN" && repJson[i].nom.indexOf(username)==0){
			chaine += "<tr>"		
				chaine +="<td><input type='radio' name='userid' value='"+repJson[i].idUser+ "' id='lib"+"'></td><td>"+repJson[i].nom+"</td><td>"+repJson[i].prenom+"</td>";
				chaine +="<td>"+repJson[i].email + "</td>";
				chaine +="</tr>";
		
		}
		
	}
	
	chaine += "</table>";
	document.getElementById("liste").innerHTML=chaine;

}
function afficheListeSTA(rep){
	var repJson = JSON.parse(rep);
	var chaine = "<table class='table table-striped'>";
	chaine += "<tr><th></th><th>Nom</th><th>Prenom</th><th>Mail</th></tr>";
	for (var i = 0 ; i < repJson.length; i++){
		if(repJson[i].role=="STA" && repJson[i].nom.indexOf(username)==0){
			chaine += "<tr>"		
				chaine +="<td><input type='radio' name='userid' value='"+repJson[i].idUser+ "' id='lib"+"'></td><td>"+repJson[i].nom+"</td><td>"+repJson[i].prenom+"</td>";
				chaine +="<td>"+repJson[i].email + "</td>";
				chaine +="</tr>";
		}
		
	}
	
	chaine += "</table>";
	document.getElementById("liste2").innerHTML=chaine;

}

function afficheNb(rep){
	document.getElementById("nb").innerHTML=rep;
//	document.getElementById("echec").innerHTML="";
}
function searchStagiaire(rep){
	
}
