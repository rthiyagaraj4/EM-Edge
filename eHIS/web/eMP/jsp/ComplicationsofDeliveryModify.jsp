<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
 <script src="../js/ComplicationsofDelivery.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%
String complndelycode="";String longdesc="";String shortdesc="";String effdatefrom="";String effdateto="";String effstatus="";//String regioncodecompare; 
complndelycode = request.getParameter("compln_dely_code");
//Connection conn = (Connection) session.getValue( "connection" );
String type_of_complication = "";
String stage1="";
String stage2="";
String stage3="";
String chk1="";
String chk2="";
String chk3="";
String dis="";
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;

//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
Boolean isModifyLongShortDescAppl = false;

try{
	conn = ConnectionManager.getConnection(request);

	isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109

	pstmt = conn.prepareStatement("select compln_dely_code,long_desc,short_desc,COMPLN_DELY_TYPE,COMPLNS_IN_1ST_STAGE_LABOUR_YN,COMPLNS_IN_2ND_STAGE_LABOUR_YN,COMPLNS_IN_3RD_STAGE_LABOUR_YN,eff_date_from,eff_date_to,eff_status from mp_compln_delivery where compln_dely_code='"+complndelycode+"'");

	
	rset = pstmt.executeQuery();
	if(rset != null) {
		rset.next();
		complndelycode = rset.getString("compln_dely_code");
		longdesc = rset.getString("long_desc");
		shortdesc = rset.getString("short_desc");
		type_of_complication = rset.getString("COMPLN_DELY_TYPE");
		stage1=rset.getString("COMPLNS_IN_1ST_STAGE_LABOUR_YN");
		stage2=rset.getString("COMPLNS_IN_2ND_STAGE_LABOUR_YN");
		stage3=rset.getString("COMPLNS_IN_3RD_STAGE_LABOUR_YN");
        if(stage1==null )stage1="N";     
        if(stage2==null )stage2="N";     
        if(stage3==null )stage3="N"; 	
		
        if(stage1.equals("Y")) chk1="checked";
		else chk1="";
		if(stage2.equals("Y")) chk2="checked";
		else chk2="";
		if(stage3.equals("Y")) chk3="checked";
		else chk3="";        

		if(rset.getString("eff_date_from")==null) {
			effdatefrom = "" ;
		}
		else {
			String temp = rset.getString("eff_date_from");
			effdatefrom = temp.substring(8,10)+ "/" + temp.substring(5,7) + "/" + temp.substring(0,4);
		}
		if(rset.getString("eff_date_to")==null) {
			effdateto = "";
		}
		else {
			String temp1 = rset.getString("eff_date_to");
			effdateto = temp1.substring(8,10)+ "/" + temp1.substring(5,7) + "/" + temp1.substring(0,4);
		}
		effstatus = rset.getString("eff_status");
		//regioncodecompare = rset.getString("region_code");
	}

    if(type_of_complication.equals("F")) {
	  dis  = "disabled";
	}else if (type_of_complication.equals("M")) {
	  dis  = "";
	}else{
		 dis  = "";
	}
	
%>
	<form name='res_town_form' id='res_town_form' action='../../servlet/eMP.ComplicationsofDeliveryServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='60%' align='center'>
		<tr class='label'><td class='label' colspan='2' >&nbsp;</td></tr>
		<tr>
			<td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  class='fields'><input type='text' name='compln_dely_code' id='compln_dely_code' value='<%=complndelycode%>' size='10' readonly ><img src='../images/mandatory.gif'></img>
<%
		if ( effstatus.equals("E") )
		{
%>
		</td></tr>
		<tr>
			<td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
			<td class='fields'><input type='text' name='long_desc' id='long_desc' <%if(isModifyLongShortDescAppl){%>size='75' maxlength='75'<%}else{%>size='30' maxlength='30'<%}%> onBlur='makeValidString(this)' value="<%=longdesc%>"><img src='../images/mandatory.gif'></img>
		</td>
		</tr>
		<tr>
				<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
				<td class='fields'><input type='text' name='short_desc' id='short_desc' <%if(isModifyLongShortDescAppl){%>size='35' maxlength='30'<%}else{%>size='15' maxlength='15'<%}%> onBlur='makeValidString(this)' value="<%=shortdesc%>"><img src='../images/mandatory.gif'></img></td>
		<!-- </tr>
			<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%=effdatefrom%>' >
			<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%=effdateto%>'>
		<tr> -->
   <tr>
      <td class="label"><fmt:message key="eMP.TypeofComplication.label" bundle="${mp_labels}"/></td>
      <td class="fields"><select name='type_of_complication' id='type_of_complication' onchange='checkStage(this);'>
			 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			 <%if (type_of_complication.equals("M")){%>
				 <option value='M' selected><fmt:message key="Common.Mother.label" bundle="${common_labels}"/>
  			   <%}else {%>
					 <option value='M' ><fmt:message key="Common.Mother.label" bundle="${common_labels}"/>
			  <%}if (type_of_complication.equals("F")){%>
					 <option value='F' selected><fmt:message key="eMP.Foetus.label" bundle="${mp_labels}"/>
			   <%}else {%>
				     <option value='F' ><fmt:message key="eMP.Foetus.label" bundle="${mp_labels}"/>
			   <%}%>
			 </select><img src='../images/mandatory.gif'></img>
	    </td>
	</tr>
		<tr>
			<td class="label"><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td>
			<td  class="fields" ><input type="checkbox" name="stage1" id="stage1" value="Y" <%=chk1%> <%=dis%>></td>	
	   </tr>
		<tr>
			<td class="label"><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td>
			<td  class="fields" ><input type="checkbox" name="stage2" id="stage2" value="Y" <%=chk2%> <%=dis%>></td>	
		</tr>
		 <tr>
			<td class="label"><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td>
			<td  class="fields" ><input type="checkbox" name="stage3" id="stage3" value="Y" <%=chk3%> <%=dis%>></td>	
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type='checkbox' name='eff_status' id='eff_status' value='E'

<%
		if  ( effstatus.equals("E") )
			out.println("checked >&nbsp;");
		else
			out.println(">&nbsp;");
%>
			</td></tr> <tr class='label'><td class='label' colspan='2'>&nbsp;</td></tr>
		</table></div>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
		<input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
<%
	}
	if ( effstatus.equals("D") )
	{
		//String rgncode="";
%>		
		</td></tr>
		<tr>
			<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
			<td class='fields'><input type='text' name='long_desc' id='long_desc' <%if(isModifyLongShortDescAppl){%>size='75' maxlength='75'<%}else{%>size='30' maxlength='30'<%}%> onBlur='makeValidString(this)' value="<%=longdesc%>" readonly><img src='../images/mandatory.gif'></img>
		</td>
		</tr>
		<tr>
				<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
				<td class='fields'><input type='text' name='short_desc' id='short_desc' <%if(isModifyLongShortDescAppl){%>size='35' maxlength='30'<%}else{%>size='15' maxlength='15'<%}%> onBlur='makeValidString(this)' value="<%=shortdesc%>" readonly><img src='../images/mandatory.gif'></img></td>
		</tr>
		<!-- <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%= effdatefrom%>' readonly>
		<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%= effdateto%>' readonly> -->
            <tr>
      <td class="label"><fmt:message key="eMP.TypeofComplication.label" bundle="${mp_labels}"/></td>
      <td class="fields"><select name='type_of_complication' id='type_of_complication'  disabled>
			 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			 <%if (type_of_complication.equals("M")){%>
				 <option value='M' selected><fmt:message key="Common.Mother.label" bundle="${common_labels}"/>
  			   <%}else {%>
					 <option value='M' ><fmt:message key="Common.Mother.label" bundle="${common_labels}"/>
			  <%}if (type_of_complication.equals("F")){%>
					 <option value='F' selected><fmt:message key="eMP.Foetus.label" bundle="${mp_labels}"/>
			   <%}else {%>
				     <option value='F' ><fmt:message key="eMP.Foetus.label" bundle="${mp_labels}"/>
			   <%}%>
			 </select><img src='../images/mandatory.gif'></img>
	    </td>
	</tr>

		<tr>
			<td class="label"><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td>
			<td  class="fields" ><input type="checkbox" name="stage1" id="stage1" value="Y" <%=chk1%> disabled></td>	
	   </tr>
		<tr>
			<td class="label"><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td>
			<td  class="fields" ><input type="checkbox" name="stage2" id="stage2" value="Y" <%=chk2%> disabled></td>	
		</tr>
		 <tr>
			<td class="label"><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td>
			<td  class="fields" ><input type="checkbox" name="stage3" id="stage3" value="Y" <%=chk3%> disabled></td>	
		</tr> 

		<tr><td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td class='fields' ><input type='checkbox' name='eff_status' id='eff_status' value='E'

<%
		if  ( effstatus.equals("E") )
			out.println("checked >&nbsp;");
		else
			out.println(">&nbsp;");
%>
		</td></tr><tr class='label'><td class='label' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>

<%	}
}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}
finally{
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
	if (conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
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

