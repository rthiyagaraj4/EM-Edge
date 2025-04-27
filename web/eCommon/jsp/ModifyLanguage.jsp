<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="CommonInclude.jsp"%>



<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = (String)session.getAttribute("PREFERRED_STYLE");
	sStyle= (sStyle==null?"IeStyle.css":sStyle); 
	String currlang = (String)session.getValue("LOCALE");
%>
<%

	Connection con =null;
	con = ConnectionManager.getConnection(request);

	String language_id="";
	String short_name="";
	String clang= "";
	String appl_user_id="";
	PreparedStatement pstmt=null ;
	PreparedStatement  pstmt2=null;
	PreparedStatement  pstmt3=null;
	ResultSet reset=null;
	ResultSet reset1=null;
	String called_from=request.getParameter("called_from");



	int count=0;
	

	
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


<script >


function change(called_from)
{


	var switchlang = document.ModifyLang_form.switch_lang.value;
	var cssName = document.ModifyLang_form.cssName.value;
	/* var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ; */
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	
	xmlStr	="<root></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UpdateLang.jsp?language_id="+switchlang+"&called_from="+called_from+"&cssName="+cssName,false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText)
	//alert(responseText);

	//if(document.forms[0].called_from.value='CA_PATIENT_CHART'){
		//window.close();
		//retval='Success';
	//}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()' onload="disab()" >

<%
	String cssName		= "";
	try{
		if(sStyle.contains("_bu")){
			String[] arrSplit = sStyle.split("\\.");
			cssName	= arrSplit[0];
		}else{
			cssName	= sStyle.replace(".css","");
		}
%>

<form name="ModifyLang_form" id="ModifyLang_form" >

<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<center>
<table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>
<tr><td class="NONE" width="100%">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>

<tr>
				<td COLSPAN=2>&nbsp; </td>
			</tr>
			<tr>
			<td align="right" class="label" nowrap><fmt:message key="Common.CurrentLanguage.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
			 <td align="left"  id="curlang" class="data" nowrap>&nbsp;&nbsp; </td>
			</tr>

			<tr></tr>

			<tr>
			<!--td>&nbsp; </td-->
				<td class="label" align="right" nowrap><fmt:message key="Common.SelectLanguage.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
				<td  align="left"  nowrap><select name='switch_lang' id='switch_lang'  >
				
				<%
				try{
					//con = ConnectionManager.getConnection(request);
					//pstmt = con.prepareStatement("select language_id, short_name from sm_language where EFF_STATUS='E' and LANGUAGE_DIRECTION !='R' order by 2");
					pstmt = con.prepareStatement("select language_id, short_name from sm_language where EFF_STATUS='E'order by 2");
					
					
					reset=pstmt.executeQuery();

						if( reset != null )
						{
						   while( reset.next() )
							{
								 language_id = reset.getString( "language_id" ) ;
								 short_name=reset.getString("short_name");
								 if(language_id.equals(currlang)){

									 clang=short_name;

								 }else{
								
									%><OPTION VALUE='<%= language_id%>' ><%= short_name%></option>
									<%
								 }
							}
							
						}

						pstmt2 = con.prepareStatement("Update sm_appl_user set language_id=? where appl_user_id=?");
						if(reset.next()){
							pstmt2.setString(1,language_id);
							pstmt2.setString(2,appl_user_id);
							
							pstmt2.executeUpdate();
					}

					
					}catch(Exception e) {
						//out.println(e.toString());
						out.println("failed at ModifyLanguage.jsp ==>"+e.toString());
						e.printStackTrace();
					}
				/*	finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					} */
			%>
				</select>
				
			<!--td>&nbsp; </td-->
			</tr>
				<tr>
			   
				<td colspan=2>&nbsp;</td>

			</tr>
				<tr>
			   
				<td colspan=2>&nbsp;</td>

			</tr>
			<tr>
			   
				<td >&nbsp;</td><td align=left><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>' class='button' onclick="sub_mit()"><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' class='button' onclick="res_et()"></td>

			</tr>


</table>

</td></tr>
</table>
<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
<input type="hidden" name="cssName" id="cssName" value="<%=cssName%>">
</form>
<script>
document.getElementById("curlang").innerText = "<%=clang%>";



function disab(){
	if(parent.frames[0].document.forms[0]){
		parent.frames[0].document.forms[0].apply.style.visibility="hidden";
		parent.frames[0].document.forms[0].reset.style.visibility="hidden";
	}else{
		setTimeout("disab()",10);
	}
}

function sub_mit(){
	parent.apply();
}

function res_et(){
	parent.reset();
}
</script>

<% 
if (reset != null) reset.close();
if (reset1 != null) reset1.close();
if (pstmt != null) pstmt.close();
if (pstmt2 != null) pstmt2.close();
if (pstmt3 != null) pstmt3.close();

}
catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}
finally	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
</body>
</html>

