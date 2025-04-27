<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,eCommon.Common.*,java.sql.*, java.util.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../js/MOMannerOfDeath.js" language="javascript"></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");
   String code="";
   String short_desc="";
   String long_desc="";
   //Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096
   String death_case=""; 
   String Accident="";
   String Murder="";
   String Suicide="";
   String Natural="";
   String Undetermined="";
   String Unclassified="";
   String Pending="";
   String Others="";
   Boolean isDeathCasesAppl;
   //END
   String effstatus="";
   String codeTextAttribute="";
   
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String enblothrs="";
   boolean newcomplaint=false;
   StringBuffer sql=new StringBuffer();
   Connection conn = ConnectionManager.getConnection(request);
   isDeathCasesAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MO","DEATH_CASES_APPL");//Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096
   code=request.getParameter("body_cond_code");
   if(code==null){
	code="";
	long_desc="";
	short_desc="";
	death_case=""; //Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096
	effstatus="E";
	codeTextAttribute="";
	checkBoxAttribute="CHECKED";
	newcomplaint=true;
	eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
    }else{
   
   PreparedStatement pstmt=null;
   ResultSet rset=null;
   try{
	     
   sql.append("select DEATH_MANNER_CODE,LONG_DESC,SHORT_DESC,DEATH_CASE,EFF_STATUS from mo_manner_of_death where DEATH_MANNER_CODE=?");
   pstmt = conn.prepareStatement(sql.toString());
   pstmt.setString(1,code);
   rset = pstmt.executeQuery();
   rset.next();
   code=rset.getString("DEATH_MANNER_CODE");
   long_desc=rset.getString("LONG_DESC");
   short_desc=rset.getString("SHORT_DESC");
   death_case=rset.getString("DEATH_CASE"); death_case = (death_case == null)?"":death_case; //Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096
   effstatus=rset.getString("EFF_STATUS");
   
   if(death_case.equals("A")){
	   Accident="selected";
   }else if(death_case.equals("M")){
	    Murder="selected";
   }else if(death_case.equals("S")){
	    Suicide="selected";
   }else if(death_case.equals("N")){
	    Natural="selected";
   }else if(death_case.equals("UD")){
	    Undetermined="selected";
   }else if(death_case.equals("UC")){
	    Unclassified="selected";
   }else if(death_case.equals("P")){
	    Pending="selected";
   }else if(death_case.equals("O")){
	    Others="selected";
   }
   
   
   if(effstatus.equals("D")){
   enblothrs="READONLY";
	checkBoxAttribute="";
   }else{
		checkBoxAttribute="CHECKED";
	}
     sql.setLength(0);
	}catch(Exception e){
	 e.toString();
	 }
	 finally{
	 if(rset!=null) 	rset.close();
	 if(pstmt!=null) 	pstmt.close();
	 ConnectionManager.returnConnection(conn,request);
	 }
	 codeTextAttribute="READONLY";
	 newcomplaint=false;
	eventFunctionForCase="";
	}

%>
<form name="MOMannerOfDeath_form" id="MOMannerOfDeath_form"  action='../../servlet/eMO.MOMannerOfDeathServlet' method='post' target='messageFrame'>
<br><br><br><br><br><br>

	<table cellspacing=0 cellpadding=0 align="center" width="80%" border="0">	
	<tr>
		<td class="label" width="50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields' width="50%"><input type="text" name="body_cond_code" id="body_cond_code" size="4" maxlength="4" value="<%=code%>"  onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="long_desc" id="long_desc" size="40" maxlength="40" value="<%=long_desc%>" <%=enblothrs%> onBlur=""><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>	
	<tr>
		<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=short_desc%>" <%=enblothrs%> onBlur=""><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<%if(isDeathCasesAppl){%>
	<!--Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096-->
	<tr>
		<td class="label"><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="eAE.Cases.label" bundle="${ae_labels}"/></td>
		<td class='fields'  size="15" maxlength="15"><select name="death_case" id="death_case">
		<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
		<option value="A"<%=Accident%>><fmt:message key="eIP.Accident.label" bundle="${ip_labels}"/></option>
		<option value="M"<%=Murder%>><fmt:message key="eMO.murder.label" bundle="${mo_labels}"/></option>
		<option value="S"<%=Suicide%>><fmt:message key="eMO.suicide.label" bundle="${mo_labels}"/></option>
		<option value="N"<%=Natural%>><fmt:message key="eMO.natural.label" bundle="${mo_labels}"/></option>
		<option value="UD"<%=Undetermined%>><fmt:message key="eMO.undetermined.label" bundle="${mo_labels}"/></option>
		<option value="UC" <%=Unclassified%>><fmt:message key="eMO.unclassified.label" bundle="${mo_labels}"/></option>
		<option value="P" <%=Pending%>><fmt:message key="eMO.pending.label" bundle="${mo_labels}"/></option>
		<option value="O" <%=Others%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	</tr>
	<!--END-->
	<%}%>
	<tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
	</tr>	
	</table>

 <%  if(newcomplaint){%>
      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
</form>
</body>
</html>

