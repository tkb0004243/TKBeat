var message=document.getElementById("message").value;
var redirect_url=document.getElementById("redirect_url").value;
var code=document.getElementById("code").value;
if(message&&code){
	alert(code+message);
}
document.location.href=redirect_url;