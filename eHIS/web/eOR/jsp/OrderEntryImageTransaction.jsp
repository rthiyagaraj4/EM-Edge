<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="eOR.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><!--IN072524-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
//	String disableOrderCategory = "";
//	String disableOrderType		= "";
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
%>
<html>
<head>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<SCRIPT>
//b					= (document.all)?1:0;
b					= (document.getElementById)?1:0;
var pos				= new Array();
var pos1			= new Array();
var db_values		= new Array();
var tmp_spotname	= new Array();

var image_id_arr	= new Array();
var hotspot_id_arr	= new Array();
 
function s(){
  	if(!b){
	/*	ww=window.innerWidth;
		wh=window.innerHeight;*/
	}if(b){
		ww=document.body.offsetWidth;
		wh=document.body.offsetHeight;
	}
	
 	cL('qD',0,0,0,0,''+cc+'*'+c2+'',"#FF3333",null,1,"","","");
	var y=0;
   	for(var x=0;x<db_values.length;x++){
		//alert(db_values[x]);
		var tmp_values		= db_values[x].split("~");
		if(tmp_values[2] != " "){
			tmp_spotname[y]		= tmp_values[0];
			//pos[y]				= tmp_values[2];
			//pos1[y]				= tmp_values[3];
			pos[y]				= eval(parseInt(tmp_values[2])+2);
			//alert(tmp_values[2]+"===="+eval(parseInt(tmp_values[2])+5));
			pos1[y]				= eval(parseInt(tmp_values[3])-10) ;
			image_id_arr[y]		= tmp_values[4];
			hotspot_id_arr[y]   = tmp_values[5];
			y++;
		}
	}
	for(var i=0;i<pos.length;i++){
		if(pos[i] != " "){
		x_arr[i]=pos[i];y_arr[i]=pos1[i];		
 		cL('q'+i+'D',parseInt(eval(pos[i])-2),parseInt(eval(pos1[i])+14),6,6,''+cc+'*'+c2+'',"#CC3300",null,1,tmp_spotname[i], image_id_arr[i], hotspot_id_arr[i]);
		}
	}
	kk=0;
 	for(var i=0;i<=to;i++){
	//	for(var j=0;j<o[i].length;j++){
			kk+=1;
		//	t=eval("o["+i+"].charAt("+j+")"); 
			t='';
			eval("cL('km"+i+"D',0,-50,6,6,'<font size=3 face=arial color=#FF0033 size=3>"+t+"</font>','#FF0033',null,1,'','','');km"+i+"=new DL('km"+i+"D');");
	//	}
	}
 //	document.getElementById("tb1").onmousedown=mouseDown;
 /*	var doc_val="document.all.";
	for(var i =0 ;i<document.getElementById("tb1").rows.length;i++){
		for(var j=0;j<document.getElementById("tb1").rows(i).cells.length;j++){
			var id_val = document.getElementById("tb1").rows(i).cells(j).id;
  			if( id_val != ""){
				eval(doc_val+id_val).onmousedown=mouseDown;
			}
		}
	}
  */	
}
 

function cL(id,lf,tp,w,h,c,bg,vi,z,spot_nm,image_id,hotspot_id){
 	if(!b){
	}
	else{
		st='\n<DIV id='+id+' align="center" style="position:absolute; left:'+lf+'px; top:'+tp+'px; width:'+w;
		if(h!=null){
			st+='; height:'+h+'px';
			st+='; clip:rect(0,'+w+'px,'+h+'px,0)';
		}
 
		if(bg!=null)	
			st+='; background-color:'+bg;
		if(z!=null)
			st+='; z-index:'+z;
		if(vi)
			st+='; visibility:'+vi;
		st+='; "><a href="javascript:callLink('+lf+','+tp+')" title="'+spot_nm+'">'+((c)?c:'')+'</a></DIV>';
 		document.body.insertAdjacentHTML("beforeend",st);
 	}
}
 
function callLink(x_pos,y_pos){
	x_pos = parseInt(eval(x_pos)+2);
	y_pos = parseInt(eval(y_pos)-14);
  	var x=x_pos;var y= y_pos;
	var tmp_x ;
	var tmp_y ;
 
	var flag = false;
	for(var c=0;c<pos.length;c++){
		tmp_x		= pos[c];
		tmp_y		= pos1[c];
		 
		var j =0,k=0;
		while(j<3){
			k=0;
			while(k<3){
				if( (x == parseInt(eval(tmp_x+j))) && (y == parseInt(eval(tmp_y+k))) ){
					flag = true;
					if(flag)
						break;
				}
				k++;
			}
			j++;
			if(flag)
				break;
		}
	}
var hotspot_pos = "NOPOSTN";var tmp_name_values;var tmp_pos_values;var tmp_xpos_values;var tmp_ypos_values;var image_id,hotspot_id;
x_pos = eval(parseInt(x_pos)-2);
y_pos = eval(parseInt(y_pos)+10);
for(var x=0;x<db_values.length;x++){
	var tmp_values		= db_values[x].split("~");
	var tmp_xpos_values = tmp_values[2];
	var tmp_ypos_values = tmp_values[3];
	var tmp_ypos_values = tmp_values[3];

 	if(x_pos == tmp_xpos_values && y_pos == tmp_ypos_values){
		hotspot_pos		= tmp_values[1];
		image_id		= tmp_values[4];
		hotspot_id		= tmp_values[5];
		break;
	}
	
}
 	populatePanels(image_id,hotspot_id);
	
 	//parent.frames[1].location.href='../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos='+hotspot_pos+'&image_id='+document.forms[0].image_id.value+"&status=modify&function_id=&x_pos="+x_pos+"&y_pos="+y_pos;

}

DL.set=false;
function DL(id){

	if(!DL.set){
		DLInit();
	}if(!b){
		/*this.css=document.layers[id];
		this.elm=this.event=this.css;
		this.doc=this.css.document;
		this.x=this.css.left;
		this.y=this.css.top;*/
	}else{
		this.elm=this.event=document.all[id];
		css=document.all[id].style;
		this.doc=document;
		this.x=this.elm.offsetLeft;
		this.y=this.elm.offsetTop;
	}
	this.id=id;
	this.obj=id+"DL";
	eval(this.obj+"=this");
}

function DLInit(){
	if(!DL.set)
		DL.set=true;
	if(!b){/*
		ref=document;
		for(var i=0;i<ref.layers.length;i++){
			dn=ref.layers[i].name;ix=dn.indexOf("D");
			if(ix>0)
				eval(dn.substr(0,ix)+' = new DL("'+dn+'")');
		}*/
	}else{
		for(var i=0;i<document.getElementsByTagName("DIV").length;i++){
			dn=document.getElementsByTagName("DIV")[i].id;
			ix=dn.indexOf("D");
			if(ix>0)
				eval(dn.substr(0,ix)+' = new DL("'+dn+'")');
		}
	}
	return true;
}

function DLMoveTo(x,y){
 	if(x!=null){
		this.x=x;
		if(!b)
			this.css.left=this.x;
		else {
 			css.pixelLeft = this.x;
		}
	}
	if(y!=null){
		this.y=y;
		if(!b)
			this.css.top=this.y;
		else {
 			css.pixelTop=this.y;
			}
	}

			//parent.frames[1].location.href="ImageHotspotAddModify.jsp?hotspot_pos=NOPOSTN&status=insert&function_id=&x_pos="+x+"&y_pos="+y;
	
}
DL.prototype.mTo=DLMoveTo;

function DLW(html){
	if(!b){
	//	this.doc.open();
	//	this.doc.write(html);
	//	this.doc.close();
	}else if(b);
		 
}
DL.prototype.write=DLW;

var	o=new Array();
for(var i=0;i<100;i++)
	o[i]="*";

//var to=100;
var to=1;
var tt=0;
//var cc="<center><font size=1 face=arial color=red>";
//var c2="</font></center>";

var cc="<span style='display: flex;justify-content: center; align-items: center; height: 100%;'><span style='font-size: 1em;font-family: Arial, sans-serif; color: red;'>";
var c2="</span></span>";

var g=0;
var vk=0;
var t="";
var sp=0;
var ak=true;
var x_arr = new Array();
var y_arr = new Array();
var hot=0;


/*function mouseDown(e){ 
hot +=1;
var x=(!b)?e.pageX:(event.x+document.body.scrollLeft);
var y=(!b)?e.pageY:(event.y+document.body.scrollTop);
var temp=hot -1;

temp= x_arr.length;
x_arr[2]=x;
y_arr[2]=y;
 

if(ak){
	if(g<to){
		g+=1
		t="";
		ak=false;
		q.write('');
		for(var i=0;i<=o[vk].length-1;i++){
			sp+=1;
			//v=Math.round(Math.random()*20)+1;
			setTimeout("km"+sp+".mTo("+x+","+y+");",0);
		}
	vk+=1;ak=true;
 	} 
}
return true;
}
*/

</SCRIPT>
 

<style>
 
	A:link {
		COLOR: blue;
		text-decoration : none ;
	}
	A:visited {
		COLOR:blue;
		text-decoration : none ;
	}
</style>
</head>
<!--bgcolor="#E6E6FA"-->
<body topmargin=0 onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="s()">
    <form name="image_form" id="image_form"  method="post" target="messageFrame">
<%
	//String image_position = bean.checkForNull(request.getParameter("image_position"),"FRNT");
	String image_url 		= bean.checkForNull(request.getParameter("image_url"),"skeleton_front.gif");
	String image_id 		= bean.checkForNull(request.getParameter("image_id"),"");
	String image_link_id 	= bean.checkForNull(request.getParameter("image_link_id"),"");
	
 	String order_category 	= bean.checkForNull(request.getParameter("order_category"),"");
	String order_type_code 	= bean.checkForNull(request.getParameter("order_type_code"),"");
	String activity_type 	= bean.checkForNull(request.getParameter("activity_type"),"");
	String order_category_yn= bean.checkForNull(request.getParameter("order_category_yn"),"");
	String order_type_yn	= bean.checkForNull(request.getParameter("order_type_yn"),"");
	String priv_applicable_yn	= bean.checkForNull(request.getParameter("priv_applicable_yn"),"");
	OrderEntryBean bean1					= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;//IN072524
	String fpp_patient_yn =bean1.getFpp_patient_yn();//IN072524 Starts
	//String hotspot			= order_category+image_position;
    //String tick_sheet_id	= "";
 	String hotspot_name		= "";
	String hotspot_id		= "", hotspot_pos		= "";
	String hotspot_xpos		= "", hotspot_ypos		= "";
	
	if(image_id.equals("") && !order_category.equals(""))
		image_id  = order_category+"FRNT";
	
//out.println("order_category=="+order_category+"=="+image_id);
//out.println("BACK=="+image_id.indexOf("BACK"));
  	String[] record			= null;
%>

<table border='0'>
	<tr>
	<!--background-color:#E2E3F0;-->
	<td nowrap style='color=navy;font-size:9pt;border:0' align="left" colspan='2'><fmt:message key="Common.BodyPart.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<select name="image" id="image"    width="15"  onChange="changeImage(this)" style='font-size:7pt;'>
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
			
			bean.setLanguageId(localeName);

		//ArrayList ImageList = bean.getImageLink(properties,image_id,order_category);
		ArrayList ImageList = bean.getImageLink(properties,image_id,order_category,fpp_patient_yn);//IN072524 
		for(int i=0; i<ImageList.size(); i++)
		{
			record = (String[])ImageList.get(i);
			if(image_link_id.equals(record[1]))
				out.println("<option value=\""+record[0]+"||"+record[1]+"||"+record[2]+"\" selected> "+record[1]+" </option>");
			else 
				out.println("<option value=\""+record[0]+"||"+record[1]+"||"+record[2]+"\" > "+record[1]+" </option>");
		}
	
		if(ImageList!=null) {
			ImageList.clear();
			ImageList	= null;  
		}
%>
		</select>	
 	</td>
	</tr>
	<tr>
	<td    nowrap style='color=navy;font-size:9pt;border:0' align="center"><input type=radio     name="front" id="front"  onClick="changeImage(this)" style="width:10;height:14" <%if(image_id.equals("") ||image_id.indexOf("FRNT")!=-1){ out.println("checked");}%>>&nbsp;&nbsp;<fmt:message key="eOR.Front.label" bundle="${or_labels}"/></td><td nowrap style='color=navy;font-size:9pt;border:0' align="left"><input type=radio name="back" id="back" style="width:10;height:14" onClick="changeImage(this)" <%if(image_id.indexOf("BACK")!=-1){ out.println("checked");}%>>&nbsp;&nbsp;<fmt:message key="Common.Back.label" bundle="${common_labels}"/>	
 	</td>
	</tr>
</table>

<%
if(!image_url.equals("")) { %>
	<!-- <table border="2"  height = '100%'  width="92%"  align="left" style='background-position:0px -2px' background="../../eOR/images/<%=image_url%>" bordercolorlight="#FFFFFF" cellspacing="0" cellpadding="0" id="tb1" > -->
	<table border="0"  style="width: 240px;height: 480px; background-position:0px -2px;" background="../../eOR/images/<%=image_url%>" bordercolorlight="#FFFFFF" cellspacing="0" cellpadding="0" id="tb1" >
<% } else { %>
	<table border="0"  height = "86.5%"  width="92%"  align="left"  background="" bordercolorlight="#FFFFFF" cellspacing="0" cellpadding="0" id="tb1" >  <!-- No Image -->
<% } %>
<!--
 <tr>
    <td  width="6%">&nbsp;</td>
    <td  width="6%"  valign="bottom">&nbsp;</td>
    <td  width="6%"  valign="center">&nbsp;</td>
    <td  width="6%"  valign="center">&nbsp;</td>
    <td  width="6%"  id="A1">&nbsp;</td>
    <td  width="6%"  id="A2">&nbsp;</td>
    <td  width="6%"  id="A3">&nbsp;</td>
    <td  width="6%"  id="A4">&nbsp;</td>
    <td  width="6%">&nbsp;</td>
    <td  width="6%">&nbsp;</td>
    <td  width="6%">&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="B1" >&nbsp;</td>
    <td id="B2" >&nbsp;</td>
    <td id="B3" >&nbsp;</td>
    <td id="B4" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="C1" >&nbsp;</td>
    <td id="C2" >&nbsp;</td>
    <td id="C3" >&nbsp;</td>
    <td id="C5" >&nbsp;</td>
    <td id="C6" >&nbsp;</td>
    <td id="C7" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td  id="D1" >&nbsp;</td>
    <td  id="D2" >&nbsp;</td>
    <td  id="D3" >&nbsp;</td>
    <td  id="D4" >&nbsp;</td>
    <td  id="D5" >&nbsp;</td>
    <td  id="D6" >&nbsp;</td>
    <td  id="D7" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="E1"  >&nbsp;</td>
    <td id="E2" >&nbsp;</td>
    <td id="E3" >&nbsp;</td>
    <td id="E4" >&nbsp;</td>
    <td id="E5" >&nbsp;</td>
    <td id="E6" >&nbsp;</td>
    <td id="E7" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td id="F1"  >&nbsp;</td>
    <td id="F2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="F3"  >&nbsp;</td>
    <td id="F4"  >&nbsp;</td>
    <td id="F5"  >&nbsp;</td>
    <td id="F6"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="F7"  >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td id="G1"  >&nbsp;</td>
    <td id="G2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="G3"  >&nbsp;</td>
    <td id="G4"  >&nbsp;</td>
    <td id="G5"  >&nbsp;</td>
    <td id="G6"  >&nbsp;</td>
    <td id="G7"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="G8"  >&nbsp;</td>
    <td id="G9"  >&nbsp;</td>
   </tr>
  <tr>
    <td id="H1"  >&nbsp;</td>
    <td id="H2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="H3"  >&nbsp;</td>
    <td id="H4"  >&nbsp;</td>
    <td id="H5"  >&nbsp;</td>
    <td id="H6"  >&nbsp;</td>
    <td id="H7"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="H8"  >&nbsp;</td>
    <td id="H9"  >&nbsp;</td>
   </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="I1"  >&nbsp;</td>
    <td id="I2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="I3"  >&nbsp;</td>
    <td id="I4"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="J1"  >&nbsp;</td>
    <td id="J2"  >&nbsp;</td>
    <td id="J3"  >&nbsp;</td>
    <td id="J4"  >&nbsp;</td>
    <td id='J5'  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="K1"  >&nbsp;</td>
    <td id="K2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="K3"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="L1"  >&nbsp;</td>
    <td id="L2"  >&nbsp;</td>
    <td id="L3"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="L4"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="M1"  >&nbsp;</td>
    <td id="M2"  >&nbsp;</td>
    <td>&nbsp;</td>
    <td id="M3"  >&nbsp;</td>
    <td id="M4"  >&nbsp;</td>
    <td id="M5"  >&nbsp;</td>
    <td id="M6"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 -->
 
 <tr>
    <td style="width: 6%; vertical-align: top;">&nbsp;</td>
    <td style="width: 6%; vertical-align: bottom;">&nbsp;</td>
    <td style="width: 6%; vertical-align: middle;">&nbsp;</td>
    <td style="width: 6%; vertical-align: middle;">&nbsp;</td>
    <td style="width: 6%;" id="A1">&nbsp;</td>
    <td style="width: 6%;" id="A2">&nbsp;</td>
    <td style="width: 6%;" id="A3">&nbsp;</td>
    <td style="width: 6%;" id="A4">&nbsp;</td>
    <td style="width: 6%; vertical-align: top;">&nbsp;</td>
    <td style="width: 6%; vertical-align: top;">&nbsp;</td>
    <td style="width: 6%; vertical-align: top;">&nbsp;</td>
</tr>
<tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="B1" >&nbsp;</td>
    <td id="B2" >&nbsp;</td>
    <td id="B3" >&nbsp;</td>
    <td id="B4" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="C1" >&nbsp;</td>
    <td id="C2" >&nbsp;</td>
    <td id="C3" >&nbsp;</td>
    <td id="C5" >&nbsp;</td>
    <td id="C6" >&nbsp;</td>
    <td id="C7" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td  id="D1" >&nbsp;</td>
    <td  id="D2" >&nbsp;</td>
    <td  id="D3" >&nbsp;</td>
    <td  id="D4" >&nbsp;</td>
    <td  id="D5" >&nbsp;</td>
    <td  id="D6" >&nbsp;</td>
    <td  id="D7" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="E1"  >&nbsp;</td>
    <td id="E2" >&nbsp;</td>
    <td id="E3" >&nbsp;</td>
    <td id="E4" >&nbsp;</td>
    <td id="E5" >&nbsp;</td>
    <td id="E6" >&nbsp;</td>
    <td id="E7" >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td id="F1"  >&nbsp;</td>
    <td id="F2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="F3"  >&nbsp;</td>
    <td id="F4"  >&nbsp;</td>
    <td id="F5"  >&nbsp;</td>
    <td id="F6"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="F7"  >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td id="G1"  >&nbsp;</td>
    <td id="G2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="G3"  >&nbsp;</td>
    <td id="G4"  >&nbsp;</td>
    <td id="G5"  >&nbsp;</td>
    <td id="G6"  >&nbsp;</td>
    <td id="G7"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="G8"  >&nbsp;</td>
    <td id="G9"  >&nbsp;</td>
   </tr>
  <tr>
    <td id="H1"  >&nbsp;</td>
    <td id="H2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="H3"  >&nbsp;</td>
    <td id="H4"  >&nbsp;</td>
    <td id="H5"  >&nbsp;</td>
    <td id="H6"  >&nbsp;</td>
    <td id="H7"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="H8"  >&nbsp;</td>
    <td id="H9"  >&nbsp;</td>
   </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="I1"  >&nbsp;</td>
    <td id="I2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="I3"  >&nbsp;</td>
    <td id="I4"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="J1"  >&nbsp;</td>
    <td id="J2"  >&nbsp;</td>
    <td id="J3"  >&nbsp;</td>
    <td id="J4"  >&nbsp;</td>
    <td id='J5'  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="K1"  >&nbsp;</td>
    <td id="K2"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="K3"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="L1"  >&nbsp;</td>
    <td id="L2"  >&nbsp;</td>
    <td id="L3"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="L4"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>
 <tr>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td id="M1"  >&nbsp;</td>
    <td id="M2"  >&nbsp;</td>
    <td>&nbsp;</td>
    <td id="M3"  >&nbsp;</td>
    <td id="M4"  >&nbsp;</td>
    <td id="M5"  >&nbsp;</td>
    <td id="M6"  >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
 </tr>

</table>
<script>
	document.getElementById("tb1").style.backgroundRepeat="no-repeat";
	if(document.body.offsetWidth > 240)
	{
		//document.getElementById("tb1").height	= "66%"
		//document.getElementById("tb1").width	= "74%"
		//document.getElementById("tb1").height	= "55.5%"
		//document.getElementById("tb1").width	= "70%"
	}
	if(document.body.offsetWidth <= 190)
	{
		//document.getElementById("tb1").height	= "83%"
		//document.getElementById("tb1").width	= "98%"
		//document.getElementById("tb1").height	= "75.5%"
		//document.getElementById("tb1").width	= "90%"
	}

</script>
<%
	//if( image_position.equals("FRNT") || image_position.equals(""))
	//	out.println("<script>document.image_form.front.checked = true </script>");
	//else
	//	out.println("<script> document.image_form.back.checked = true </script>");
	if(image_id.equals("") || image_id.indexOf("FRNT")!=-1){
		out.println("<script>document.image_form.front.checked = true </script>");
		out.println("<script>document.image_form.back.checked = false </script>");
	}else{
		out.println("<script> document.image_form.front.checked = false </script>");
		out.println("<script> document.image_form.back.checked = true </script>");
	}
%>
<%
try{
	 //Call the method to get the values for the population of the hot spot
	 //ArrayList HotSpot = bean.getHotSpot(properties, image_id, image_link_id, order_category);//IN072524
	ArrayList HotSpot = bean.getHotSpot(properties, image_id, image_link_id, order_category,fpp_patient_yn);//IN072524

	// System.err.println("=============================="+HotSpot.size());
	 for(int i=0; i<HotSpot.size(); i++)
	{
		record = (String[])HotSpot.get(i);

		hotspot_pos		= record[0];
		hotspot_name	= record[1];
		hotspot_id		= record[2];
		image_id		= record[3];
		hotspot_xpos	= bean.checkForNull(record[4]," ");
		hotspot_ypos	= bean.checkForNull(record[5]," ");
%>
<script>
	//var hot_spot_pos = eval("<%=hotspot_pos%>");
	//var hotspot_id	 = "<%=hotspot_id%>";
	//var order_type = "<%=order_type_code%>";
	//hot_spot_pos.innerHTML="<a href='javascript:populatePanels(\"<%=image_id%>\",\"<%=hotspot_id%>\")'><font color='ORANGERED'>*</font></a>";
	//hot_spot_pos.title= '<%=hotspot_name%>';
//alert("<%=hotspot_xpos%>")
//alert("<%=hotspot_ypos%>")
//alert("<%=image_id%>")
//alert("<%=hotspot_id%>")
 	db_values["<%=i%>"] = "<%=hotspot_name%>"+"~"+"<%=hotspot_pos%>"+"~"+"<%=hotspot_xpos%>"+"~"+"<%=hotspot_ypos%>"+"~"+"<%=image_id%>"+"~"+"<%=hotspot_id%>";


</script>
<%
	}
		if(HotSpot!=null) {
			HotSpot.clear();
			HotSpot	 = null;
		}
}catch(Exception e)
{
	//out.println("exception"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
 
%>
		<input type="hidden" name="order_category_yn" id="order_category_yn" value="<%=order_category_yn%>"><!--//bean.getOrderCategoryYn()-->
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
		<input type="hidden" name="activity_type" id="activity_type" value="<%=activity_type%>">
		<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
		<input type="hidden" name="order_category_yn" id="order_category_yn"	value="<%=order_category_yn%>">
		<input type="hidden" name="order_type_yn" id="order_type_yn"		value="<%=order_type_yn%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="priv_applicable_yn" id="priv_applicable_yn" value="<%=priv_applicable_yn%>">


<%
		// Nullifying the objects
		record		= null;

		// no need to set it back persistence
		//putObjectInBean(bean_id,bean,request);


%>
</form>
</body>

</html>


