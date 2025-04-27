/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Input 0
function _gel(a){
	return document.getElementById?document.getElementById(a):null
}
function _gelstn(a){
	return document.getElementsByTagName?document.getElementsByTagName(a):new Array()
}
function _uc(a){
	return a.toUpperCase()
}
function _trim(a){
	return a.replace(/^\s*|\s*$/g,"")
}
function _esc(a){
	return window.encodeURIComponent?encodeURIComponent(a):escape(a)
}
var aO=function(a){return window.decodeURIComponent?decodeURIComponent(a):unescape(a)}
;var _unesc=aO;function _hesc(a){return a.replace(/</g,"&lt;").replace(/>/g,"&gt;")}
var aN=0;function _uid(){return"obj"+aN++}
function _min(a,aa){return a<aa?a:aa}
function _max(a,aa){return a>aa?a:aa}
var aI=navigator.userAgent.indexOf("Safari")>=0;function _sendx(a,aa){var ab=aP();if(!ab||aI&&!aa){(new Image()).src=a}else{ab.open("GET",a,true);if(aa){ab.onreadystatechange=function(){if(ab.readyState==4){aa(ab.responseText)}}
}ab.send(null)}}
function _uhc(a,aa,ab){var ac="m_"+a+"_"+aa;var ad=_gel(ac);if(!ad){ad=document.createElement("INPUT");ad.type="hidden";ad.disabled=true;ad.name=ac;_gel("m_"+a+"_form").appendChild(ad)}ad.value=ab;ad.disabled=false}
function aP(){var a=null;if(window.ActiveXObject){a=new ActiveXObject("Msxml2.XMLHTTP");if(!a){a=new ActiveXObject("Microsoft.XMLHTTP")}}else if(window.XMLHttpRequest){a=new XMLHttpRequest()}return a}
var _et="";
var _pid="";
//var as="/ig/setp";
var as = "../../eOR/html/RDDrag.html"
function an(a,aa,ab){var ac=document.createElement("input");ac.type="hidden";ac.name=aa;ac.value=ab;a.appendChild(ac)}
function aF(){var a=new Object();var aa=document.location.search.substring(1);var ab=aa.split("&");for(var ac=0;ac<ab.length;ac++){var ad=ab[ac].indexOf("=");if(ad==-1)continue;var ae=ab[ac].substring(0,ad);var af=ab[ac].substring(ad+1);af=af.replace(/\+/g," ");a[ae]=_unesc(af)}return a}
function ar(){
		var a={
				pid:1,host:1,hl:1
			  };
			  var aa=aF();
			  var ab="?";
			  for(var ac in aa){
				  if(a[ac]){
					ab+=ac+"="+_esc(aa[ac])+"&"
				  }
			  }
			  return ab
}

function _fsetp(a,aa,ab){a.action=as;a.method="get";an(a,"url",document.location);an(a,"et",_et);an(a,"pid",_pid);an(a,"m_"+aa+"_t",ab);return true}
function _xsetp(a){_sendx(as+ar()+"et="+_et+"&pid="+_pid+"&"+a,null)}
function _dlsetp(a,aa){
	if(!aa){
		aa=_esc(document.location)
	}
 	//document.location=as+ar()+"et="+_et+"&pid="+_pid+"&url="+aa+"&"+a
}
function _ssbc(a,aa,ab){var ac=_gelstn("*");for(var ad=0;ad<ac.length;ad++){if(ac[ad].className==a){ac[ad].style[aa]=ab}}}
function _edit(a,aa){
	_gel("m_"+a).className="modbox_e";
	if(aa){
		aa()
	}
	return false
}
function _cedit(a){_gel("m_"+a).className="modbox";_gel("m_"+a+"_form").reset();return false}
function _del(a,aa){
	_dlsetp("m_"+a+"_enab=0&m_"+a+"_t="+aa);
	return false
}
var aE="https://www.google.com/accounts";
function _enableGS(a,aa){
	a.action=aE+"/CheckCookie";a.method="get";
	an(a,"service",aa);
	an(a,"continue",document.location);
	an(a,"skipvpage",true);
return true}
function aM(a){_xsetp("pnlo="+(a?1:0))}
var _uli;var _pnlo;var _pl;var _mod;var az=false;var _cols=new Array();
function _upc(){
	_ssbc("medit","display",_pnlo||_uli?"":"none");
	_ssbc("panelo","display",_pnlo?"":"none");
	_ssbc("panelc","display",_pnlo?"none":"");
	_ssbc("mod","display",_mod?"":"none");
	_ssbc("unmod","display",_mod?"none":"");
	if(_pl&&(_uli||_pnlo)){
		if(!az){
			aH(_cols);
			az=true
		}
		_ssbc("mttl","cursor","move")
	}
}
var aq=0;function _tp(a){if(aq>0)clearInterval(ap);_pnlo=a;_mod=true;aM(a);_upc();var aa=_gel("cpnl");var ab=_gel("cpnls");var ac=_gel("cpnlc");var ad=_gel("nhdr");var ae=_gel("ehdr");var af=aa.offsetWidth;var ah;var ai;if(a){ah=ac.offsetWidth;ai="visible";ae.style.display="";ad.style.display="none"}else{ah=1;ai="hidden";ae.style.display="none";ad.style.display=""}aa.style.overflow="hidden";var ak=100;var at=10;var au=0;aq=setInterval(function(){var av=au/at;var aA=af+(ah-af)*av;ab.width=(aa.style.width=aA);au++;if(av>=1){clearInterval(aq);aq=0;ab.width=(aa.style.width=ah);aa.style.overflow=ai}}
,ak/at);return false}
function _ts(a,aa){var ab=_gel(a+aa);var ac;if(ab.className=="mlist_open"){ab.className="mlist_closed";ac="pnlsc"}else{ab.className="mlist_open";ac="pnlso"}_xsetp(ac+"="+_esc(aa));return false}
function _add_m(a){_dlsetp(a)}
function _add_m_confirm(a,aa){if(confirm(aa)){_add_m(a)}}
function _add_f(a){_dlsetp("n_25="+_esc("url="+_esc(a)))}
var aw=/^_add_m(_confirm)?\(\"[^"]+\"(, *\"[^"]+\")?\)$/;function _find_feed(a){if(!a){var aa=_gelstn("div");if(aa){for(var ab=0;ab<aa.length;ab++){if(aa[ab].id&&aa[ab].id.indexOf("ps")==0&&aa[ab].className=="mlist_open"){_ts("ps",aa[ab].id.substring(2))}}}a=_gel("add_custom").value}_sendx("/ig/feeds"+ar()+"q="+_esc(a),aD);return false}
function aD(a){var aa=_gel("ffresults");if(a.length>0&&a.charAt(0)=="<"){aa.innerHTML=a}else if(a.match(aw)!=null){eval(a)}}
function _add_remote_module(a,aa){_sendx("/ig/feeds"+ar()+"module=1&q="+_esc(a),function(ab){aa();aB(ab)}
);return false}
function aB(a){var aa=/^alert\(\"[^"]+\"\)$/;if(a.match(aw)!=null||a.match(aa)!=null){eval(a)}}
var aj=[];var ap=0;var am=null;function ag(){if(!am){am=document.createElement("DIV");am.style.display="none";am.style.position="absolute";am.style.cursor="move";am.style.backgroundColor="#ffffff";am.style.paddingBottom="0px";document.body.appendChild(am)}return am}
var al={obj:null,init:function(a){a.onmousedown=al.start;if(isNaN(parseInt(ag().style.left)))ag().style.left="0px";if(isNaN(parseInt(ag().style.top)))ag().style.top="0px";a.onDragStart=new Function();a.onDragEnd=new Function();a.onDrag=new Function()}
,start:function(a){var aa=al.obj=this;a=al.fixE(a);var ab=parseInt(ag().style.top);var ac=parseInt(ag().style.left);aa.onDragStart(ac,ab,a.clientX,a.clientY);aa.lastMouseX=a.clientX;aa.lastMouseY=a.clientY;document.onmousemove=al.drag;document.onmouseup=al.end;return false}
,drag:function(a){a=al.fixE(a);var aa=al.obj;var ab=a.clientY;var ac=a.clientX;var ad=parseInt(ag().style.top);var ae=parseInt(ag().style.left);var af,ah;af=ae+ac-aa.lastMouseX;ah=ad+ab-aa.lastMouseY;ag().style.left=af+"px";ag().style.top=ah+"px";aa.lastMouseX=ac;aa.lastMouseY=ab;aa.onDrag(af,ah,a.clientX,a.clientY);return false}
,end:function(){document.onmousemove=null;document.onmouseup=null;al.obj.onDragEnd(parseInt(ag().style.left),parseInt(ag().style.top));al.obj=null}
,fixE:function(a){if(typeof a=="undefined")a=window.event;if(typeof a.layerX=="undefined")a.layerX=a.offsetX;if(typeof a.layerY=="undefined")a.layerY=a.offsetY;return a}
};var ax=false;function aH(a){if(ax)return;ax=true;aj=a;for(var aa=0;aa<aj.length;aa++){for(var ab=0;ab<aj[aa].childNodes.length-1;ab++){var ac=aj[aa].childNodes[ab];var ad=_gel(ac.id+"_h");if(!ad)continue;ad.module=ac;al.init(ad);var ae=_gel(ac.id+"_url");if(ae){ae.h=ad;ae.onmousedown=function(){this.h.href=this.href;this.h.target=this.target}
}ad.onDragStart=function(af,ah){clearInterval(ap);var ai=this.module;aC(ai);ai.origNextSibling=ai.nextSibling;var ak=ag();ak.style.left=ao(ai,true);ak.style.top=ao(ai,false);ak.style.height=ai.offsetHeight;ak.style.width=ai.offsetWidth;ak.style.display="block";ak.style.opacity=0.8;ak.style.filter="alpha(opacity=80)";ak.innerHTML=ai.innerHTML;ak.className=ai.className;this.dragged=false}
;ad.onDrag=function(af,ah){aJ(this.module,af,ah);this.dragged=true}
;ad.onDragEnd=function(af,ah){if(this.dragged){ap=aG(this.module,150,15)}else{ay();if(this.href){if(this.target){window.open(this.href,this.target)}else{document.location=this.href}}}this.target=null;this.href=null;if(this.module.nextSibling!=this.module.origNextSibling){aL()}}
}}}
function ay(){ag().style.display="none"}
function aG(a,aa,ab){var ac=parseInt(ag().style.left);var ad=parseInt(ag().style.top);var ae=(ac-ao(a,true))/ab;var af=(ad-ao(a,false))/ab;return setInterval(function(){if(ab<1){clearInterval(ap);ay();return}ab--;ac-=ae;ad-=af;ag().style.left=parseInt(ac)+"px";ag().style.top=parseInt(ad)+"px"}
,aa/ab)}
function aC(a){for(var aa=0;aa<aj.length;aa++){var ab=0;for(var ac=0;ac<aj[aa].childNodes.length;ac++){var ad=aj[aa].childNodes[ac];if(ad==a)ab=ad.offsetHeight;ad.pagePosLeft=ao(ad,true);ad.pagePosTop=ao(ad,false)-ab}}}
function ao(a,aa){var ab=0;while(a!=null){ab+=a["offset"+(aa?"Left":"Top")];a=a.offsetParent}return ab}
function aJ(a,aa,ab){var ac=null;var ad=100000000;for(var ae=0;ae<aj.length;ae++){for(var af=0;af<aj[ae].childNodes.length;af++){var ah=aj[ae].childNodes[af];if(ah==a)continue;var ai=Math.sqrt(Math.pow(aa-ah.pagePosLeft,2)+Math.pow(ab-ah.pagePosTop,2));if(isNaN(ai))continue;if(ai<ad){ad=ai;ac=ah}}}if(ac!=null&&a.nextSibling!=ac){ac.parentNode.insertBefore(a,ac);aK(a)}}
function aK(a){a.parentNode.style.display="none";a.parentNode.style.display=""}
function aL(){var a="";for(var aa=0;aa<aj.length;aa++){for(var ab=0;ab<aj[aa].childNodes.length-1;ab++){var ac=aj[aa].childNodes[ab];a+=a!=""?":":"";a+=ac.id.substring(2)+"_"+ac.parentNode.id.substring(2)}}_xsetp("&mp="+_esc(a))}
function _ListApp(a,aa,ab){this.items=a;this.deleted=[];this.item_constructor=aa;this.module_id=ab;this.app_name="m_"+ab+"_App";this.display_area=_gel("m_"+ab+"_disp");this.value_input_field=_gel("m_"+ab+"_val");this.name_input_field=_gel("m_"+ab+"_name");if(!this.name_input_field){this.name_input_field=this.value_input_field}this.default_name=this.name_input_field.value;this.default_value=this.value_input_field.value}
_ListApp.prototype.sort=function(a,aa){return a.b(aa)}
;_ListApp.prototype.f=function(){var a="<table cellspacing=0 cellpadding=0 border=0>";var aa="";var ab=this.items;for(var ac=0;ac<ab.length;ac++){if(!ab[ac]){this.items.splice(ac,1);ac--}else{a+="<tr><td><font size=-1>"+ab[ac].e()+"</font></td><td>"+'<a href="#" onclick="'+this.app_name+".del("+ac+')">'+'<img src="/ig/images/x.gif" width=16 height=13 border=0></a></td></tr>';if(parseInt(ab[ac]._uid)<0){aa+=ab[ac].a(ac)}}}var ad=this.deleted;var ae="";for(var ac=0;ac<ad.length;ac++){if(parseInt(ad[ac]._uid)>=0){ae+=","+ad[ac]._uid}}a+="</table><input type=hidden name=m_"+this.module_id+"_add "+'value="'+aa+'">'+"<input type=hidden name=m_"+this.module_id+"_del "+'value="'+ae+'">';return a}
;_ListApp.prototype.refresh=function(){this.items.sort(this.sort);this.display_area.innerHTML="<font size=-1>"+this.f()+"</font>"}
;_ListApp.prototype.add=function(a,aa){if(!a){a=_trim(this.name_input_field.value)}if(!aa){aa=_trim(this.value_input_field.value)}var ab=new this.item_constructor(a,aa,-1);if(!ab.d())return;this.items[this.items.length]=ab;this.refresh();this.name_input_field.value=this.default_name;this.value_input_field.value=this.default_value}
;_ListApp.prototype.del=function(a){this.deleted[this.deleted.length]=this.items[a];this.items.splice(a,1);this.refresh()}
;function _ListItem(a,aa){this.init(a,aa)}
_ListItem.prototype.init=function(a,aa,ab){this._n=a;this._v=aa;this._uid=ab}
;_ListItem.prototype.d=function(){return this._n!=""}
;_ListItem.prototype.b=function(a){return 0}
;_ListItem.prototype.e=function(){return _hesc(this._n)}
;_ListItem.prototype.a=function(a){return"&"+_esc(this._n)+"="+_esc(this._v)}
;_BMListItem.prototype=new _ListItem();_BMListItem.prototype.constructor=_ListItem;_BMListItem.superclass=_ListItem.prototype;function _BMListItem(a,aa,ab){this.init(a,aa,ab)}
_BMListItem.prototype.d=function(){return _BMListItem.superclass.d.call(this)&&this._n!="http://"}
;_BMListItem.prototype.c=function(){if(this._v){return this._v}else{var a=this._n;if(a.indexOf("http://")==0){a=a.substring(7)}if(a.indexOf("www.")==0){a=a.substring(4)}return a}}
;_BMListItem.prototype.e=function(){return'<a href="'+this._n+'" target=bmwindow>'+_hesc(this.c())+"</a>"}
;_BMListItem.prototype.a=function(a){return"&b"+a+"="+_esc(this._n)+"&t"+a+"="+_esc(this._v)}
;_BMListItem.prototype.b=function(a){var aa=_uc(this.c());var ab=_uc(a.c());if(aa==ab)return 0;return aa<ab?-1:1}
;_WthrListItem.prototype=new _ListItem();_WthrListItem.prototype.constructor=_ListItem;_WthrListItem.superclass=_ListItem.prototype;function _WthrListItem(a,aa,ab){this.init(a,aa,ab)}
_WthrListItem.prototype.a=function(a){var aa="&"+_esc(this._n);if(this._v){aa+="="+_esc(this._v)}return aa}
;_FListItem.prototype=new _ListItem();_FListItem.prototype.constructor=_ListItem;_FListItem.superclass=_ListItem.prototype;function _FListItem(a,aa,ab,ac){this.init(a,aa,ab);if(ac){this._s=ac}else{this._s=0}}
_FListItem.prototype.a=function(a){return"&"+_esc(this._n)}
;_FListItem.prototype.b=function(a){
	var aa=this;
	if(aa._s<a._s) return-1;
	if(aa._s>a._s) return 1;
	var ab=_uc(aa._v);
	var ac=_uc(a._v);
	if(ab<ac)
		return-1;
	if(ab>ac)
		return 1;
	return 0};


function openPreview() {
 
	var preview_text		= document.getElementById("div_text").innerHTML;
 	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
//	xmlStr					+= "bean_id=\"" +bean_id +"\" ";
//	xmlStr					+= "bean_name=\"" +bean_name +"\" ";
 	xmlStr					+= "preview_text=\"" +checkSpl(preview_text) +"\" ";
 	xmlStr 					+=" /></root>" ;
 
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/RDDragValidate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
 	
 	//parent.editor.RTEditor0.document.body.innerHTML = RTEText;
} // End of openPreview


function showPreview(){
 	var dialogHeight ='100' ;
	var dialogWidth = '70' ;
	var dialogTop	= '189';
	var dialogLeft	= '167' ;

	var title	 = ''
	var features	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments	= "";
	var retVals = window.showModalDialog("../../eOR/jsp/RDPreview.jsp",arguments,features);
} // End of preview

function disableItem(){
//	if (window.event.shiftKey)
 
 

for(i=0;i<document.drag_form.elements.length;i++)
{
	document.drag_form.elements(i).readOnly  = true;
	document.drag_form.elements(i).disabled  = true;
} 
//window.event.cancelBubble = true;
//alert(window.event.cancelBubble);
//		window.event.shiftKey = true;
//		window.event.mouseClick = true;
//}
}

