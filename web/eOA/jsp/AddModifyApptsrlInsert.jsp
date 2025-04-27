<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script language="javascript" src="../../eCommon/js/common.js"> 		</script>
<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
<script language="javascript" src="../../eOA/js/AddModifyApptsrlnum.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con = null;
	Statement stmt1=null;
	ResultSet rset1=null ;
try{
	request.setCharacterEncoding("UTF-8");	

	con=ConnectionManager.getConnection(request);
	String facilityid=(String)session.getValue("facility_id");

	String next_srl_no = "";
	String max_srl_no = "";

%>

	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()';>
	<form name='appt_form' id='appt_form' action='../../servlet/eOA.AppointmentSrlNoServlet' method='post' target='messageFrame'>
	<div>
	<br>
	<br>
	<br>
	<br>
	<br><br><br>
	<br>
	<br><br><br>
	<br>
	<br>
	<table border='0' cellpadding='0' cellspacing='0' align='center' width='auto'>
	<tr>
		<td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
	</tr>

	<%				
	String readOnly="";
	stmt1=con.createStatement();
	String sql2="select next_srl_no,max_srl_no from oa_appt_srl_no where facility_id='"+facilityid+"'";

	rset1=stmt1.executeQuery(sql2);

	if(rset1!=null){
		if(rset1.next()){
			readOnly="readOnly";
			
			next_srl_no = rset1.getString("next_srl_no");
			max_srl_no = rset1.getString("max_srl_no");
		}else{
			next_srl_no = "";
			max_srl_no = "";
		}
	}else{
		next_srl_no = "";
		max_srl_no = "";
	}
	
	if(readOnly.equals("readOnly")){
		out.println("<input type='hidden' name='function_name' id='function_name' value='modify'>");
	}else{
		out.println("<input type='hidden' name='function_name' id='function_name' value='insert'>");
	}
	
	%>

	<tr>
		<td  width='40%'  class=label><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/></td>
		<td width='60%' colspan='2' class='fields'>
		<input type='text' name='next_srl_no1' id='next_srl_no1' size='8' maxlength='8' <%=readOnly%> value="<%=next_srl_no%>" onKeyPress='return  allowValidNumber(this,event,8,0);' >						    
		<img src='../../eMP/images/mandatory.gif' align='center'></img>
		</td><input type='hidden' name='next_srl_no' id='next_srl_no'  value="" ><input type='hidden' name='h_next_srl_no' id='h_next_srl_no'  value="<%=next_srl_no%> " >
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td  width='40%'  class=label><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></td>
		<td width='60%' colspan='2' class='fields'>
		<input type='text' name='max_srl_no1' id='max_srl_no1' size='8' <%=readOnly%>  maxlength='8' value="<%=max_srl_no%>" onKeyPress='return  allowValidNumber(this,event,8,0);'; >
		 <input type='hidden' name='max_srl_no' id='max_srl_no'  value="" ><img src='../../eMP/images/mandatory.gif' align='center'></img></td>
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>


	</table>
	</div>

	<input type='hidden' name='old_srl_no' id='old_srl_no' value='<%=next_srl_no %>' >
	<input type='hidden' name='old_max_no' id='old_max_no' value='<%=max_srl_no %>' >

	<input type='hidden' name='remark' id='remark' value="">

<%
	if (rset1 != null) rset1.close();
	if (stmt1 != null) stmt1.close();
	

} catch(Exception e){
	//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
	</form>
</body><script>document.forms[0].next_srl_no1.focus();</script>
</html>

