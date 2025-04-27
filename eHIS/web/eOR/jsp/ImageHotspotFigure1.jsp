<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
  <%@ page contentType="text/html;charset=UTF-8"%>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  <%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,eOR.*,eCommon.XSSRequestWrapper" %>
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
	String mode					= request.getParameter( "mode" ) ;
	//String function_id			= request.getParameter( "function_id" ) ;
	String bean_id				= "Or_ImageHotSpot" ;
	String bean_name		    = "eOR.ImageHotSpotBean";
	//String readOnly				= "readOnly" ;


	String hotspot_pos     ="";
	String hotspot_name ="";
	//String hotspot_id        ="";

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
  <script>
  var obj2;
	function changeColor(Obj){
		var id=Obj.id;
		 //alert(Obj.id);
		if( Obj.innerHTML.indexOf("<A href") !=-1);
		else{
			if(obj2 == null)
			Obj.innerHTML="<td    valign='center'></td>"
			else
			obj2.innerHTML="<td    valign='center'></td>"

			obj2=Obj;
			Obj.innerHTML="<font color='red'>*</font>"

			 present=1;	parent.frames[1].location.href="ImageHotspotAddModify.jsp?image_id="+document.forms[0].image_id.value+"&hotspot_pos="+id+"&mode="+document.forms[0].mode.value+"&status=insert&function_id="+function_id;
		}
	}

  var val;

  function aa(val) {
		parent.frames[1].location.href='../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos='+val+'&image_id='+document.forms[0].image_id.value+"&mode=2&status=modify&function_id="+function_id;
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
  <body topmargin=0 bgcolor="#E6E6FA" onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
   <form name='image_form_check' id='image_form_check'  method='post' target='messageFrame'>
   <br><br>
		<input type=hidden value='<%=image_id%>'  name='image_id'>
		<input type="hidden" name=mode value="<%=mode%>">
		<%

  if(image_id.equals("RDFRNT") ||image_id.equals("RXFRNT")||image_id.equals("")) { %>

  <table  height = '70%'  width="100%"  align='left'   background="../../eOR/images/skeleton_front.gif"   cellspacing="0" cellpadding="0" id='tb1'  bgcolor='#E6E6FA' border=0  >

  <% } else  if (image_id.equals("RDBACK") ||image_id.equals("RXBACK")){ %>

  <table   height = '70%'  width="98%"  align='left' background="../../eOR/images/skeleton_back.gif"   cellspacing="1" cellpadding="1" id='tb1'  bgcolor='#E6E6FA'  border=1>
  <%} %>
  <tr>
      <td  width="6%"></td>
      <td  width="6%"  valign="bottom"></td>
      <td  width="6%"  valign="center"></td>
      <td  width="6%"  valign="center"></td>
      <td  width="3%"  id="A1" onClick='changeColor(this)'></td>
      <td  width="3%"  id="A2" onClick='changeColor(this)'></td>
      <td  width="3%"  id="A3" onClick='changeColor(this)'></td>
      <td  width="3%"  id="A4" onClick='changeColor(this)'></td>
	<td  width="3%"  id="A5" onClick='changeColor(this)'></td>
      <td  width="3%"  id="A6" onClick='changeColor(this)'></td>
      <td  width="3%"  id="A7" onClick='changeColor(this)'></td>
      <td  width="3%"  id="A8" onClick='changeColor(this)'></td>
      <td  width="6%"></td>
      <td  width="6%"></td>
      <td  width="6%"></td>
   </tr>
   <tr>
       <td ></td>
       <td ></td>
       <td ></td>
       <td ></td>
       <td id="B1" onClick='changeColor(this)'></td>
       <td id="B2" onClick='changeColor(this)'></td>
       <td id="B3" onClick='changeColor(this)'></td>
       <td id="B4" onClick='changeColor(this)'></td>
       <td id="B5" onClick='changeColor(this)'></td>
       <td id="B6" onClick='changeColor(this)'></td>
       <td id="B7" onClick='changeColor(this)'></td>
       <td id="B8" onClick='changeColor(this)'></td>
       <td ></td>
       <td ></td>
       <td ></td>
   </tr>
   <tr>
       <td ></td>
       <td ></td>
       <td ></td>
       <td id="C1" onClick='changeColor(this)' ></td>
       <td id="C2"  onClick='changeColor(this)' ></td>
       <td id="C3" onClick='changeColor(this)' ></td>
       <td id="C5"  onClick='changeColor(this)' ></td>
       <td id="C6"  onClick='changeColor(this)' ></td>
       <td id="C7" onClick='changeColor(this)' ></td>
       <td ></td>
       <td ></td>
   </tr>
   <tr>
      <td ></td>
      <td ></td>
      <td  id="D1" onClick='changeColor(this)'></td>
      <td  id="D2" onClick='changeColor(this)'></td>
      <td  id="D3" onClick='changeColor(this)'></td>
      <td  id="D4" onClick='changeColor(this)'></td>
      <td  id="D5" onClick='changeColor(this)'></td>
      <td  id="D6" onClick='changeColor(this)' ></td>
      <td  id="D7" onClick='changeColor(this)'></td>
      <td ></td>
      <td ></td>
    </tr>
   <tr>
      <td ></td>
      <td ></td>
      <td id="E1"  onClick='changeColor(this)'></td>
      <td id="E2"  onClick='changeColor(this)'></td>
      <td id="E3"  onClick='changeColor(this)'></td>
      <td id="E4"  onClick='changeColor(this)'></td>
      <td id="E5"  onClick='changeColor(this)'></td>
      <td id="E6"  onClick='changeColor(this)' ></td>
      <td id="E7"  onClick='changeColor(this)'></td>
      <td ></td>
      <td ></td>
    </tr>
   <tr>
      <td ></td>
      <td id="F1"  onClick='changeColor(this)'></td>
      <td id="F2"  onClick='changeColor(this)'></td>
      <td ></td>
      <td id="F3"  onClick='changeColor(this)'></td>
      <td id="F4"  onClick='changeColor(this)'></td>
      <td id="F5"  onClick='changeColor(this)'></td>
      <td id="F6"  onClick='changeColor(this)'></td>
      <td ></td>
      <td id="F7"  ></td>
      <td ></td>
    </tr>
     <tr>
        <td id="G1"  onClick='changeColor(this)'></td>
        <td id="G2"  onClick='changeColor(this)'></td>
        <td ></td>
        <td id="G3"  onClick='changeColor(this)'></td>
        <td id="G4"  onClick='changeColor(this)'></td>
        <td id="G5"  onClick='changeColor(this)'></td>
        <td id="G6"  onClick='changeColor(this)'></td>
        <td id="G7"  onClick='changeColor(this)'></td>
        <td ></td>
        <td id="G8"  onClick='changeColor(this)'></td>
        <td id="G9"  onClick='changeColor(this)'></td>
     </tr>
      <tr>
         <td id="H1"  onClick='changeColor(this)'></td>
         <td id="H2"  onClick='changeColor(this)'></td>
         <td ></td>
         <td id="H3" onClick='changeColor(this)' ></td>
         <td id="H4"  onClick='changeColor(this)'></td>
         <td id="H5"  onClick='changeColor(this)'></td>
         <td id="H6"  onClick='changeColor(this)'></td>
         <td id="H7"  onClick='changeColor(this)'></td>
         <td ></td>
         <td id="H8"  onClick='changeColor(this)'></td>
         <td id="H9"  onClick='changeColor(this)'></td>
     </tr>
      <tr>
         <td ></td>
         <td ></td>
         <td ></td>
         <td id="I1"  onClick='changeColor(this)'></td>
         <td id="I2"  onClick='changeColor(this)'></td>
         <td ></td>
         <td id="I3"  onClick='changeColor(this)'></td>
         <td id="I4"  onClick='changeColor(this)'></td>
         <td ></td>
         <td ></td>
         <td ></td>
    </tr>
    <tr>
        <td ></td>
        <td ></td>
        <td ></td>
        <td id="J1"  onClick='changeColor(this)'></td>
        <td id="J2"  onClick='changeColor(this)'></td>
        <td id="J3"  onClick='changeColor(this)'></td>
        <td id="J4"  onClick='changeColor(this)'></td>
        <td id='J5'  onClick='changeColor(this)'></td>
        <td ></td>
        <td ></td>
        <td ></td>
    </tr>
    <tr>
        <td ></td>
        <td ></td>
        <td ></td>
        <td id="K1"  onClick='changeColor(this)'></td>
        <td id="K2"  onClick='changeColor(this)'></td>
        <td ></td>
        <td id="K3"  onClick='changeColor(this)'></td>
        <td ></td>
        <td ></td>
        <td ></td>
        <td ></td>
    </tr>
     <tr>
        <td ></td>
        <td ></td>
        <td id="L1"  onClick='changeColor(this)'></td>
        <td id="L2"  onClick='changeColor(this)'></td>
        <td id="L3"  onClick='changeColor(this)'></td>
        <td ></td>
        <td id="L4"  onClick='changeColor(this)'></td>
        <td ></td>
        <td ></td>
        <td ></td>
        <td ></td>
   </tr>
   <tr>
       <td ></td>
       <td ></td>
       <td id="M1"  onClick='changeColor(this)'></td>
       <td id="M2"  onClick='changeColor(this)'></td>
       <td></td>
       <td id="M3"  onClick='changeColor(this)'></td>
       <td id="M4"  onClick='changeColor(this)'></td>
       <td id="M5"  onClick='changeColor(this)'></td>
       <td id="M6"  onClick='changeColor(this)'></td>
       <td ></td>
       <td ></td>
   </tr>
  </table>
  <br><br>
  <script>
	document.getElementById("tb1").style.backgroundRepeat="no-repeat";

	if(document.body.offsetWidth > 303)
	{
		document.getElementById("tb1").height	= "65%"
		document.getElementById("tb1").width	= "65%"
	}

  </script>
  <%
  String [] hotspotPosition=null;
    for(int i=0;i<idList.size();i++)
  {
  hotspotPosition=(String [])idList.get(i);
 // hotspot_id=  hotspotPosition[0];
  hotspot_name = hotspotPosition[1];
  hotspot_pos = hotspotPosition[2];
  %>

  <script>
					var t=eval('<%=hotspot_pos%>');
					val ='<%=hotspot_pos%>';

					t.innerHTML="<a href='javascript:aa(\"<%=hotspot_pos%>\")'><font color='CHARTREUSE'>*</font></a>";
					t.title= '<%=hotspot_name%>';
  </script>
  <%}idList=null;%>
  </form>
  </body>

  </html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


