<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src='../js/TranslatorConfig.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");	
 String locale=(String)session.getAttribute("LOCALE");
 String facilityid=(String)session.getValue("facility_id");
 String language_id="";
 String language_desc="";
 String srl_no="";
 String eff_date_from="";
 String eff_date_to="";
 String no_of_translator="";
 String multiply_factor="";
 String eff_status="";
 String otherTextAttribute="";
 String checkBoxAttribute="";
 String codeTextAttribute="";
 String dateAttribute="";
 boolean function_check=false;
 language_id=request.getParameter("language_id");
 srl_no=request.getParameter("srl_no");
 if(language_id==null){
	 function_check=true;
	 language_id="";
	 language_desc="";
	 eff_status="E";
	 codeTextAttribute="";
	 otherTextAttribute="";
	 checkBoxAttribute="checked";
	 dateAttribute="";
 }else{
	 Connection conn = ConnectionManager.getConnection(request);
	 Statement stmt=null;
	 ResultSet rset=null;
	 PreparedStatement pstmt=null;
	 try{
				stmt = conn.createStatement();
			//	String sql ="select language_id, mp_get_desc.mp_language(language_id,'"+locale+"', 1) language_desc, srl_no, to_char(eff_date_from, 'dd/mm/yyyy')eff_date_from, to_char(eff_date_to, 'dd/mm/yyyy')eff_date_to,no_of_translator,multiply_factor,eff_status from oa_translator_configuration where facility_id='"+facilityid+"' and language_id='"+language_id+"' and srl_no='"+srl_no+"'";
				String sql ="select language_id, mp_get_desc.mp_language(language_id,?, 1) language_desc, srl_no, to_char(eff_date_from, 'dd/mm/yyyy')eff_date_from, to_char(eff_date_to, 'dd/mm/yyyy')eff_date_to,no_of_translator,multiply_factor,eff_status from oa_translator_configuration where facility_id=? and language_id=? and srl_no=?";
				//rset = stmt.executeQuery(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityid);
				pstmt.setString(3,language_id);
				pstmt.setString(4,srl_no);
				rset = pstmt.executeQuery();				
				rset.next();
				language_desc=rset.getString("language_desc");
				srl_no=rset.getString("srl_no");
				eff_date_from=rset.getString("eff_date_from");
				eff_date_to=rset.getString("eff_date_to");
				no_of_translator=rset.getString("no_of_translator");
				multiply_factor=rset.getString("multiply_factor");
				eff_status=rset.getString("eff_status");								
				if(eff_status.equals("D"))
				{
					otherTextAttribute="READONLY";
					checkBoxAttribute="";
					dateAttribute="Disabled";
				}else
				{
					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
					dateAttribute="";
				}
					if (rset!= null) rset.close();
					if (stmt != null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();

			}finally{					
					ConnectionManager.returnConnection(conn,request);				
			}  					
					function_check=false;	
					codeTextAttribute="Disabled";
		}

%>
<form name="TranslatorMaster_form" id="TranslatorMaster_form" action="../../servlet/eOA.TranslatorConfigServlet" method="post" target="messageFrame">
<table border="0" cellpadding="0" cellspacing="0" width="60%" align='center'>
<br><br>
<tr>
	<td class='label' nowrap><fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>	
	<td class='fields' colspan='3'>
		<input type='text' name='language_desc' id='language_desc' size='20' maxlength='20'  onblur='if(this.value!="")searchLanguage(this);' value="<%=language_desc%>" <%=codeTextAttribute%>><input type='button' name='language_button' id='language_button' value='?' class='button' onclick='if(this.value!="")searchLanguage(this);' <%=codeTextAttribute%>><img src='../../eCommon/images/mandatory.gif' align='center' ></img>
		<input type='hidden' name='language_code' id='language_code' value="<%=language_id%>">
	</td>	
</tr>
<tr>	
	<td>&nbsp;</td>	
	<td class="querydata"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
	<td class="querydata" colspan='3'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>	
</tr>
<tr>
	<td class="label" nowrap><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="date_range_from" id="date_range_from" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName);checkDateAlert(this);" value="<%=eff_date_from%>" <%=otherTextAttribute%>><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_range_from');" <%=dateAttribute%>><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
	<td class='fields' colspan='2'> <input type="text" name="date_range_to" id="date_range_to"  size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName);checkDateAlert(this);" value="<%=eff_date_to%>" <%=otherTextAttribute%>><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_range_to');" <%=dateAttribute%>><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>	
	<td class='label' nowrap><fmt:message key="eOA.NoofTranslators.label" bundle="${oa_labels}"/></td>
	<td  class='fields'><input type='text' name='no_of_translator' id='no_of_translator' size='10' maxlength='2' value='<%=no_of_translator%>' onblur='CheckNum(this);if(this.value!="")checkValue(this)' onKeyPress='return allowPositiveNumber();' <%=otherTextAttribute%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td class='label' nowrap><fmt:message key="eOA.NoofPatperTranslator.label" bundle="${oa_labels}"/></td>
	<td  class='fields'><input type='text' name='factor' id='factor' size='10' maxlength='2' value='<%=multiply_factor%>' onblur='CheckNum(this);if(this.value!="")checkValue(this)' onKeyPress='return allowPositiveNumber();' <%=otherTextAttribute%>><img src='../../eCommon/images/mandatory.gif'></img></td>	
<tr>
<tr>	
	<td class='label' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class='fields' colspan='3'><input type='checkbox' name='eff_status' id='eff_status' value="<%=eff_status%>" <%=checkBoxAttribute%> onclick='check_eff(this);'></td>	
<tr>
</table>
<% if(function_check){%>
	<input type='hidden' name='function_name' id='function_name' value='insert'>
<%}else{%>
	<input type='hidden' name='function_name' id='function_name' value='modify'>
	<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>'>	
 <%}%>
 <input type='hidden' name='date_from' id='date_from' value='<%=eff_date_from%>'>
<input type='hidden' name='date_to' id='date_to' value='<%=eff_date_to%>'>
<input type='hidden' name='change_flag' id='change_flag' value=''>
</form>
</body>
</html>

