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
------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------
05/12/2017	IN065956		Raja S			 	05/12/2017		Ramesh G		ARYU-SCF-0018
------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,eOR.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../../eOR/js/HotSpot.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String image_id				= request.getParameter("image_id");
	String image_url			= request.getParameter("image_url");
 	if(image_url==null) image_url = "";
 	String mode					= request.getParameter( "mode" ) ;
	//String function_id			= request.getParameter( "function_id" ) ;
	String bean_id				= "Or_ImageHotSpot" ;
	String bean_name			= "eOR.ImageHotSpotBean";
	//String readOnly				= "readOnly" ;

	String hotspot_pos     ="";
	String hotspot_name ="";
	String hotspot_xpos ="";
	String hotspot_ypos ="";
//	String hotspot_id        ="";

	////////////bean initialization start////////
	ImageHotSpotBean  bean = (ImageHotSpotBean)getBeanObject( bean_id,  bean_name, request ) ;


	////////////bean initialization end////////

	ArrayList idList=new 	ArrayList();
	try{
			idList=(ArrayList)bean.getHotspotImage(image_id);
	}catch(Exception e)	{
		System.out.println("Ex. Here :"+e);
	}

 %>
<head>
<SCRIPT>
b=(document.length)?1:0;
var pos			= new Array();
var pos1		= new Array();
var db_values	= new Array();
var tmp_spotname= new Array();
function s(){
	if(!b){
	/*	ww=window.innerWidth;
		wh=window.innerHeight;*/
	}if(b){
		ww=document.body.offsetWidth;
		wh=document.body.offsetHeight;
	}
	
	//cL('qD',0,0,0,0,''+cc+'*'+c2+'',"#FF3333",null,1,"");

	//alert(db_values.length);
	for(var x=0;x<db_values.length;x++){
		var tmp_values = db_values[x].split("~");
		tmp_spotname[x]=tmp_values[0];
		pos[x] = tmp_values[2];
		pos1[x] = tmp_values[3];
	}
	
	for(var i=0;i<pos.length;i++){
		if(pos[i] != " "){
			cL('q'+i+'D',pos[i],pos1[i],6,6,''+cc+'*'+c2+'',"#66FF33",null,1,tmp_spotname[i]);
		}
	}
	kk=0;
	for(var i=0;i<=to;i++){
		kk+=1;
		t='';
		eval("cL('km"+i+"D',0,-50,6,6,'<font size=3 face=arial color=#FF0033 size=3 style=\"display: block;\">"+t+"</font>','#FF0033',null,1,'');km"+i+"=new DL('km"+i+"D');");
	}
	
	//document.getElementById("tb1").onmousedown=mouseDown;
	//document.onmousedown=mouseDown;

	var doc_val="document";
	for(var i =0 ;i<document.getElementById("tb1").rows.length;i++){
		for(var j=0;j<document.getElementById("tb1").rows[i].cells.length;j++){
			var id_val = document.getElementById("tb1").rows[i].cells[j].id;
			if( id_val != ""){
				eval(doc_val+id_val).onmousedown=mouseDown;
			}
		}
	}
}

function cL(id,lf,tp,w,h,c,bg,vi,z,spot_nm){
	if(!b){
	}
	else{
	
		st='\n<DIV id='+id+' style="position:absolute; left:'+lf+'px; top:'+tp+'px; width:'+w+'px';
		if(h!=null){
			st+='; height:'+h+'px';
			//st+='; clip:rect(0,'+w+','+h+',0)';
		}
		if(bg!=null)	
			st+='; background-color:'+bg;
		if(z!=null)
			st+='; z-index:'+z;
		if(vi)
			st+='; visibility:'+vi;
		st+='; "><a href="#" onClick="callLink('+lf+','+tp+')" title="'+spot_nm+'" style="display: block;width: 100%;height: 100%; text-align: center;">'+((c)?c:'')+'</a></DIV>';
		document.body.insertAdjacentHTML("BeforeEnd",st);
		
	}
}
function callLink(x_pos,y_pos){
	//alert("here===x=="+x_pos+"-y---"+y_pos);
	var tmp_x ;
	var tmp_y ;
	
	var flag = false;
	for(var c=0;c<pos.length;c++){
		tmp_x = pos[c];
		tmp_y = pos1[c];
	
		var j =0,k=0;
		while(j<3){
			k=0;
			while(k<3){
				if( (x_pos == parseInt(eval(tmp_x+j))) && (y_pos == parseInt(eval(tmp_y+k))) ){
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
	//alert("Call the link ...........");alert("===x_pos=="+x_pos+"-y_pos---"+y_pos);

	var hotspot_pos = "NOPOSTN";
	var tmp_name_values;
	var tmp_pos_values;
	var tmp_xpos_values;
	var tmp_ypos_values;

	for(var x=0;x<db_values.length;x++){
		tmp_values = db_values[x].split("~");
		tmp_xpos_values = tmp_values[2];
		tmp_ypos_values = tmp_values[3];
		if(x_pos == tmp_xpos_values && y_pos == tmp_ypos_values){
			hotspot_pos = tmp_values[1];
			break;
		}
		
	}

parent.frames[0].location.href='../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos='+hotspot_pos+'&image_id='+document.forms[0].image_id.value+"&mode=2&status=modify&function_id=&x_pos="+x_pos+"&y_pos="+y_pos;

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
		this.elm=this.event=document.getElementById(id);
		this.css=document.getElementById(id).style;
		this.doc=document.getElementById(id);
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
//alert(x+"============,"+y)
	if(x!=null){
		this.x=x;
		if(!b)
			this.css.left=this.x + "px"; 
		else {
			this.css.left=this.x + "px";
			//css.pixelLeft = this.x;
		}
	}
	if(y!=null){
		this.y=y;
		if(!b)
			this.css.top=this.y + "px";
		else {
			this.css.top=this.y + "px";
			//css.pixelTop=this.y;
			}
	}

parent.frames[0].location.href="ImageHotspotAddModify.jsp?image_id=<%=image_id%>&hotspot_pos=NOPOSTN&mode=<%=mode%>&status=insert&function_id=&x_pos="+x+"&y_pos="+y;
	
}
DL.prototype.mTo=DLMoveTo;



function DLW(html){
	if(!b){
	//	this.doc.open();
	//	this.doc.write(html);
	//	this.doc.close();
	}else if(b);
		//this.event.innerHTML=html;
}
DL.prototype.write=DLW;

var	o=new Array();
for(var i=0;i<100;i++)
	o[i]="*";

var to=100;
var tt=0;
var cc="<font size=1 face=arial color=red style='display: block;'>";
var c2="</font>";


var g	= 0;
var vk	= 0;
var t	= "";
var sp	= 0;
var ak	= true;

var hot	= 0;


function mouseDown(e){
hot +=1;
//IN065956 starts
//var x=(!b)?e.pageX:(event.x+document.body.scrollLeft);
//var y=(!b)?e.pageY:(event.y+document.body.scrollTop);
var x=(!b)?e.pageX:(event.clientX+document.body.scrollLeft);
var y=(!b)?e.pageY:(event.clientY+document.body.scrollTop);
//IN065956 ends
//alert("x::"+x+" ,y::"+y);
var temp=hot -1;

if(ak){
	if(g<to){
		g+=1
		t="";
		ak=false;
		// Abdelhamid: resetting the last spot
		document.getElementById("km"+sp+"D").style.left="0px";
		document.getElementById("km"+sp+"D").style.top="-50px";
		//q.write('');
		for(var i=0;i<=o[vk].length-1;i++){
			sp+=1;
			setTimeout("km"+sp+".mTo("+x+","+y+");",0);
		}
		vk+=1;ak=true;
	}else{
		//q.write('');li=true;
	}
}
return true;
}

</SCRIPT>
<script>
var obj2;
	function changeColor(Obj){
		var id=Obj.id;
		//alert(Obj.id);
		if( Obj.innerHTML.indexOf("<a href") !=-1);
		else{
			if(obj2 == null)
			Obj.innerHTML="<td    valign='center'></td>"
			else
			obj2.innerHTML="<td    valign='center'></td>"
//alert("obj2::"+obj2+" Obj::"+Obj);
			obj2=Obj;
			Obj.innerHTML="<font color='red'>*</font>"

			 present=1;
			parent.frames[0].location.href="ImageHotspotAddModify.jsp?image_id="+document.forms[0].image_id.value+"&hotspot_pos="+id+"&mode="+document.forms[0].mode.value+"&status=insert&function_id="+function_id;
		}
		
	}

var val;

function aa(val) {
	parent.frames[0].location.href='../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos='+val+'&image_id='+document.forms[0].image_id.value+"&mode=2&status=modify&function_id="+function_id;
	//alert("comes here");
}
</script>
	<style>
	TD.DATA
	{
	 COLOR:navy;
	  FONT-SIZE: 8pt;
	  FONT-WEIGHT: BOLDER
	  }

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
<body topmargin=0  onload='FocusFirstElement();s();' onMouseDown="CodeArrest()" onKeyDown="lockKey()" ><!-- bgcolor="#E6E6FA" -->
 <form name='image_form_check' id='image_form_check'  method='post' target='messageFrame'>
 <br><br>
		<input type='hidden' value='<%=image_id%>'  name='image_id'  id='image_id'>
		<input type="hidden" name='mode' id='mode' value="<%=mode%>">
		<%

if(!image_id.equals("") && !image_url.equals("") ) { %>

<table  height = '350vh'  width="200vw"  align='left' background="../../eOR/images/<%=image_url%>"   cellspacing="0" cellpadding="0" id='tb1' border='0'  >
<% } else {  %>
	<table  height = '380vh'  width="200vw"  align='left'   background="../../eOR/images/skeleton_front.gif"   cellspacing="0" cellpadding="0" id='tb1' border='3'  >
<% } %>

<tr>
	<td  width="6%"></td>
    <td  width="6%"  valign="bottom"></td>
    <td  width="6%"  valign="center" id='A5' onclick='mouseDown(this);'></td>
    <td  width="6%"  valign="center" id='A6' onclick='mouseDown(this);'></td>
    <td  width="6%"  id="A1" onClick='mouseDown(this)'></td>
    <td  width="6%"  id="A2" onClick='mouseDown(this)'></td>
    <td  width="6%"  id="A3" onClick='mouseDown(this)'></td>
    <td  width="6%"  id="A4" onClick='mouseDown(this)'></td>
    <td  width="6%"></td>
    <td  width="6%"></td>
    <td  width="6%"></td>
 </tr>
 <tr>
     <td ></td>
     <td ></td>
     <td ></td>
     <td id="B5" onClick='mouseDown(this)'></td>
     <td id="B1" onClick='mouseDown(this)'></td>
     <td id="B2" onClick='mouseDown(this)'></td>
     <td id="B3" onClick='mouseDown(this)'></td>
     <td id="B4" onClick='mouseDown(this)'></td>
     <td ></td>
     <td ></td>
     <td ></td>
 </tr>
 <tr>
     <td ></td>
     <td id='C8' onClick='mouseDown(this)'></td>
     <td id='C9' onClick='mouseDown(this)'></td>
     <td id="C1" onClick='mouseDown(this)' ></td>
     <td id="C2" onClick='mouseDown(this)' ></td>
     <td id="C3" onClick='mouseDown(this)' ></td>
     <td id="C5" onClick='mouseDown(this)' ></td>
     <td id="C6" onClick='mouseDown(this)' ></td>
     <td id="C7" onClick='mouseDown(this)' ></td>
     <td ></td>
     <td ></td>
 </tr>
 <tr >
    <td ></td>
    <td id="D8" onClick='mouseDown(this)'></td>
    <td  id="D1" onClick='mouseDown(this)'></td>
    <td  id="D2" onClick='mouseDown(this)'></td>
    <td  id="D3" onClick='mouseDown(this)'></td>
    <td  id="D4" onClick='mouseDown(this)'></td>
    <td  id="D5" onClick='mouseDown(this)'></td>
    <td  id="D6" onClick='mouseDown(this)' ></td>
    <td  id="D7" onClick='mouseDown(this)'></td>
    <td ></td>
    <td ></td>
  </tr>
 <tr >
    <td ></td>
    <td id='E8' onClick='mouseDown(this)'></td>
    <td id="E1"  onClick='mouseDown(this)'></td>
    <td id="E2"  onClick='mouseDown(this)'></td>
    <td id="E3"  onClick='mouseDown(this)'></td>
    <td id="E4"  onClick='mouseDown(this)'></td>
    <td id="E5"  onClick='mouseDown(this)'></td>
    <td id="E6"  onClick='mouseDown(this)' ></td>
    <td id="E7"  onClick='mouseDown(this)'></td>
    <td ></td>
    <td ></td>
  </tr>
 <tr>
    <td id="F7" onClick='mouseDown(this)'></td>
    <td id="F1"  onClick='mouseDown(this)'></td>
    <td id="F2"  onClick='mouseDown(this)'></td>
    <td id='F8' onClick='mouseDown(this)'></td>
    <td id="F3"  onClick='mouseDown(this)'></td>
    <td id="F4"  onClick='mouseDown(this)'></td>
    <td id="F5"  onClick='mouseDown(this)'></td>
    <td id="F6"  onClick='mouseDown(this)'></td>
    <td ></td>
    <td id="F7"  ></td>
    <td ></td>
  </tr>
   <tr >
      <td id="G1"  onClick='mouseDown(this)'></td>
      <td id="G2"  onClick='mouseDown(this)'></td>
      <td id="G8"  onClick='mouseDown(this)'></td>
      <td id="G3"  onClick='mouseDown(this)'></td>
      <td id="G4"  onClick='mouseDown(this)'></td>
      <td id="G5"  onClick='mouseDown(this)'></td>
      <td id="G6"  onClick='mouseDown(this)'></td>
      <td id="G7"  onClick='mouseDown(this)'></td>
      <td id="G10"  onClick='mouseDown(this)'></td>
      <td id="G8"  onClick='mouseDown(this)'></td>
      <td id="G9"  onClick='mouseDown(this)'></td>
   </tr>
    <tr >
       <td id="H1"  onClick='mouseDown(this)'></td>
       <td id="H2"  onClick='mouseDown(this)'></td>
       <td id="H10"  onClick='mouseDown(this)'></td>
       <td id="H3" onClick='mouseDown(this)' ></td>
       <td id="H4"  onClick='mouseDown(this)'></td>
       <td id="H5"  onClick='mouseDown(this)'></td>
       <td id="H6"  onClick='mouseDown(this)'></td>
       <td id="H7"  onClick='mouseDown(this)'></td>
       <td ></td>
       <td id="H8"  onClick='mouseDown(this)'></td>
       <td id="H9"  onClick='mouseDown(this)'></td>
   </tr>
    <tr>
       <td ></td>
       <td id="I6"  onClick='mouseDown(this)'></td>
       <td id="I5"  onClick='mouseDown(this)' ></td>
       <td id="I1"  onClick='mouseDown(this)'></td>
       <td id="I2"  onClick='mouseDown(this)'></td>
       <td id="I3"  onClick='mouseDown(this)'></td>
       <td id="I4"  onClick='mouseDown(this)'></td>
       <td ></td>
       <td ></td>
	   <td ></td>
       <td ></td>
  </tr>
  <tr >
      <td ></td>
      <td ></td>
      <td id="J6"  onClick='mouseDown(this)'></td>
      <td id="J1"  onClick='mouseDown(this)'></td>
      <td id="J2"  onClick='mouseDown(this)'></td>
      <td id="J3"  onClick='mouseDown(this)'></td>
      <td id="J4"  onClick='mouseDown(this)'></td>
      <td id='J5'  onClick='mouseDown(this)'></td>
      <td ></td>
      <td ></td>
      <td ></td>
  </tr>
  <tr>
      <td ></td>
      <td ></td>
      <td id="K4"  onClick='mouseDown(this)'></td>
      <td id="K1"  onClick='mouseDown(this)'></td>
      <td id="K2"  onClick='mouseDown(this)'></td>
      <td id="k5"  onClick='mouseDown(this)'></td>
      <td id="K3"  onClick='mouseDown(this)'></td>
      <td ></td>
      <td ></td>
      <td ></td>
      <td ></td>
  </tr>
   <tr>
      <td ></td>
      <td id="L7"  onClick='mouseDown(this)'></td>
      <td id="L6"  onClick='mouseDown(this)'></td>
	  <td id="L1"  ></td> 
      <td id="L2"  onClick='mouseDown(this)'></td>
      <td id="L3"  onClick='mouseDown(this)'></td>
      <td id="L5" onClick='mouseDown(this)'></td>
      <td id="L4"  onClick='mouseDown(this)'></td>
      <td ></td>
      <td ></td>
      <td ></td>
 </tr>
 <tr>
     <td ></td>
     <td id="M7"  onClick='mouseDown(this)'></td>
     <td id="M1"  onClick='mouseDown(this)'></td>
     <td id="M2"  onClick='mouseDown(this)'></td>
     <td id="M8"  onClick='mouseDown(this)'></td>
     <td id="M3"  onClick='mouseDown(this)'></td>
     <td id="M4"  onClick='mouseDown(this)'></td>
     <td id="M5"  onClick='mouseDown(this)'></td>
     <td id="M6"  onClick='mouseDown(this)'></td>
    <!--  <td id="M6"  onClick='changeColor(this);mouseDown();'></td> -->
     <td id="M7"  onClick='mouseDown(this)'></td>
     <td id="M8"  onClick='mouseDown(this)' ></td>
 </tr>
</table>
<br><br>
<script>
	document.getElementById("tb1").style.backgroundRepeat="no-repeat";
	if(document.body.offsetWidth > 240)
	{
	//	document.getElementById("tb1").height	= "70%"
	//	document.getElementById("tb1").width	= "74%"
		document.getElementById("tb1").height	= "350vh"
		document.getElementById("tb1").width	= "200vw"
	}

</script>

<%
String [] hotspotPosition=null;
  for(int i=0;i<idList.size();i++)
{
hotspotPosition=(String [])idList.get(i);
//hotspot_id=  hotspotPosition[0];
hotspot_name = hotspotPosition[1];
hotspot_pos  = hotspotPosition[2];
hotspot_xpos = hotspotPosition[3];
hotspot_ypos = hotspotPosition[4];
if(hotspot_xpos == null)
	hotspot_xpos = " ";
if(hotspot_ypos == null)
	hotspot_ypos = " ";

%>
<script>
//alert('<%=hotspot_xpos%>');	
db_values['<%=i%>'] = '<%=hotspot_name%>'+"~"+'<%=hotspot_pos%>'+"~"+'<%=hotspot_xpos%>'+"~"+'<%=hotspot_ypos%>';
//var t=eval('<%=hotspot_pos%>');
//val ='<%=hotspot_pos%>';

//t.innerHTML="<a href='javascript:aa(\"<%=hotspot_pos%>\")'><font color='CHARTREUSE'>*</font></a>";
//t.title= '<%=hotspot_name%>';
</script>
<%}idList=null;%>
</form>
</body>

</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


