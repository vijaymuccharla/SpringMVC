
function formvalidate(frm){
//	clear all error messages
	document.getElementById("patNameErr").innerHTML="";
	document.getElementById("patAgeErr").innerHTML="";
	document.getElementById("locationErr").innerHTML="";
	document.getElementById("hospitalErr").innerHTML="";

	//get form data
	let pname=frm.patName.value;
	let page=frm.patAge.value;
	let plocation=frm.location.value;
	let phospital=frm.hospital.value;
	let flag=false;
	//write client side form validations logic
	if(pname==""){
		document.getElementById("patNameErr").innerHTML="<b> *Reuired field </b>";
//		frm.patName.focus();
		flag=true;
	}
	if(page==""){
		document.getElementById("patAgeErr").innerHTML="<b> *Reuired field </b>";
//		frm.patAge.focus();
		flag=true;
	}
	else if(isNaN(page)){
		document.getElementById("patAgeErr").innerHTML="<b> *Age must be numeric </b>";
//		frm.patAge.focus();
		flag=true;
	}
	else if(page<18 || page>100){
		document.getElementById("patAgeErr").innerHTML="<b> *Age must be between 18 and 100</b>";
//		frm.patAge.focus();
		flag=true;
	}
	if(plocation==""){
		document.getElementById("locationErr").innerHTML="<b> *Reuired field </b>";
//		frm.location.focus();
		flag=true;
	}
	if(phospital==""){
		document.getElementById("hospitalErr").innerHTML="<b> *Required field </b>";
//		frm.hospital.focus();
		flag=true;
	}
	if(phospital.length<4){
		document.getElementById("hospitalErr").innerHTML="<b> *Hospital name is too short</b>";
//		frm.hospital.focus();
		flag=true;
	}
	else if(phospital.length>20){
		document.getElementById("hospitalErr").innerHTML="<b> *Hospital name is too long</b>";
//		frm.hospital.focus();
		flag=true;
	}
	//modify vflag value to YES to indicate client side validations are DONE
	frm.vflag.value="yes";
	
	if(flag)
		return false;
	else
		return true;

}