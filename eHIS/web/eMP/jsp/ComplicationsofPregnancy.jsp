<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../js/ComplicationsofPregnancy.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('compln_pregnancy_code')">

	<%
   request.setCharacterEncoding("UTF-8");

   String longdesc="",shortdesc="",effstatus="",codeTextAttribute="",otherTextAttribute="",otherAttribute="",checkBoxAttribute="",eventFunctionForCase="",sql="",related_to_pregnacy_yn="N",checkBoxAttribute1="";
   boolean newSpeciality		=	false;

   //Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	Boolean isModifyLongShortDescAppl = false;

	Connection conn			=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rset			=	null;
  
%>
<%
	String compln_pregnancy_code=request.getParameter("compln_pregnancy_code");

	try{
		conn = ConnectionManager.getConnection(request);

		isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109

	if(compln_pregnancy_code==null){
		compln_pregnancy_code		=	"";
		longdesc								=	"";
		shortdesc							=	"";
		related_to_pregnacy_yn		=	"Y";		
		effstatus							=	"E";		
		checkBoxAttribute		=	"CHECKED";
		checkBoxAttribute1		=	"CHECKED";
		codeTextAttribute		=	"";
		otherTextAttribute		=	"";	
		newSpeciality			=	true;
		eventFunctionForCase	=	"OnBlur='ChangeUpperCase(this)'";
	}else{
     
		stmt = conn.createStatement();
		sql =  "select compln_pregnancy_code,long_desc,short_desc,related_to_pregnacy_yn,eff_status  from mp_compln_pregnancy where compln_pregnancy_code='"+compln_pregnancy_code+"'";

		//out.println(sql);
		
		rset = stmt.executeQuery(sql);
		rset.next();
		compln_pregnancy_code				=	rset.getString("compln_pregnancy_code");
		longdesc				=	rset.getString("long_desc");
		shortdesc				=	rset.getString("short_desc");		
		related_to_pregnacy_yn				=	rset.getString("related_to_pregnacy_yn");	
		
		effstatus				=rset.getString("eff_status");
	
		if(effstatus.equals("D"))
		{
			otherTextAttribute	=	"READONLY";
			checkBoxAttribute	=	"";	
			otherAttribute			=	"disabled";	
		}else{

			otherTextAttribute		=	"";
			checkBoxAttribute		=	"CHECKED";
			
		}

		if(related_to_pregnacy_yn.equals("Y"))		 
				checkBoxAttribute1=	"CHECKED";
		else
			checkBoxAttribute1="";
			

		codeTextAttribute	=	"READONLY";	
		eventFunctionForCase=	"";
	}
	}catch(Exception e){
			e.toString();
	 }
	 finally
	 {     
		    if(rset!=null)    	rset.close();	 
	     	if(stmt!=null)    	stmt.close();
	     	ConnectionManager.returnConnection(conn,request);	
	 }
	
%>
	<form name="compln_preg_form" id="compln_preg_form" action="../../servlet/eMP.ComplicationsofPregnancyServlet" method="post" target="messageFrame">
	<BR><BR><BR><BR><BR><BR><BR><BR>
	<div align="left">
	  <table border="0" cellpadding="3" cellspacing="0" width="60%" align='center'>
  <tr class='label'>
	<td class='label' colspan='2'>&nbsp;</td>
	
</tr>

    <tr>
      <td  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  class="fields" ><input type="text" name="compln_pregnancy_code" id="compln_pregnancy_code" value="<%=compln_pregnancy_code%>" size="3" maxlength="3"  onKeyPress="return CheckSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>><img src='../images/mandatory.gif'></img></td>
    </tr>

    <tr>
      <td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	  <!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
      <td class="fields" ><input type="text" name="long_desc" id="long_desc" <%if(isModifyLongShortDescAppl){%>size='75' maxlength='75'<%}else{%>size="30" maxlength="30"<%}%> value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>

    <tr>
      <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	  <!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
      <td class="fields"><input type="text" name="short_desc" id="short_desc" <%if(isModifyLongShortDescAppl){%>size='35' maxlength='30'<%}else{%>size="15" maxlength="15"<%}%> value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
	<tr>
		<td class="label"><fmt:message key="eMP.RelatedtoPregnancy.label" bundle="${mp_labels}"/></td>
    	<td  class="fields" ><input type="checkbox" name="rel_to_preg" id="rel_to_preg" onclick='checkForRelPreg()' value="<%=related_to_pregnacy_yn%>" <%=checkBoxAttribute1%> <%=otherAttribute%> ></td>
	</tr>
     

	<tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    	<td  class="fields" ><input type="checkbox" name="eff_status" id="eff_status" onclick='Change1()' value="<%=effstatus%>" <%=checkBoxAttribute%> ></td>
	</tr>    

  </table>
</div>
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
 <%  if(newSpeciality){%>
      		<input type='hidden' name='function' id='function' value='insert'>
      		<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      		<input type='hidden' name='function' id='function' value='modify'>
      		<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

