/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Input 0
function bk(b){var ba="";var bb=this.e(b,ba);return bb!=null?bb+"":ba}
function bh(b){var ba=0;var bb=parseInt(this.e(b,ba));return isNaN(bb)?ba:bb}
function bg(b){return this.getInt(b,false)?true:false}
function bi(){return parseInt(this.b(_IG_Prefs.g))}
function bj(){return parseInt(this.b(_IG_Prefs.h))}
function bl(b,ba){return this.b(_IG_Prefs.d+b,ba)}
function bn(b,ba){this.a[_IG_Prefs.d+b]=ba;var bb="m_"+this.i+"_up_"+b+"="+_esc(ba);if(_IG_Prefs.f){_xsetp(bb)}else{}}
function bm(b,ba){if(typeof ba=="undefined"){ba=null}var bb=this.a[b];return typeof bb!="undefined"?bb:ba}
function bf(){document.write("<pre>");for(var b in this.a){document.writeln(b+" = "+this.b(b))}document.write("</pre>")}
function _IG_Prefs(b){this.getString=bk;this.getInt=bh;this.getBool=bg;this.getModuleHeight=bi;this.getModuleWidth=bj;this.set=bn;this.dump=bf;this.a=_IG_Prefs.a[_IG_Prefs.c+b]||new Object();this.b=bm;this.e=bl;this.i=b}
_IG_Prefs.g="h";_IG_Prefs.h="w";_IG_Prefs.c="m_";_IG_Prefs.d="up_";_IG_Prefs._parseURL=function(b){_IG_Prefs.f=false;var ba=window.location.search.substring(1).split("&");for(var bb=0;bb<ba.length;bb++){var bc=ba[bb].indexOf("=");if(bc==-1)continue;var be=ba[bb].substring(0,bc);be=be.replace(/\+/g," ");var bd=ba[bb].substring(bc+1);bd=bd.replace(/\+/g," ");bd=_unesc(bd);_IG_Prefs._add(b,be,bd)}}
;_IG_Prefs._add=function(b,ba,bb){var bc=_IG_Prefs.c+b;if(typeof _IG_Prefs.a[bc]!="object"){_IG_Prefs.a[bc]=new Object()}_IG_Prefs.a[bc][ba]=bb}
;_IG_Prefs.a=new Object();_IG_Prefs.f=true;function _IG_FetchContent(b,ba){var bb="/ig/proxy?url="+escape(b);if(_et!=""){bb+="&et="+_et}_sendx(bb,ba)}
function _IG_RegisterOnloadHandler(b){remote_module_load_hooks.push(b)}
;

	
