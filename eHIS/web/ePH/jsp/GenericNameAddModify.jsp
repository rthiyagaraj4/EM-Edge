<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<head>
<%
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../js/PhCommon.js"></script>
	<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> 
	<script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../js/GenericNameByATC.js"></script>		
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	Connection con			= null;   
	try{

	

	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "GenericNameByATC" ;
	String bean_name = "ePH.GenericNameByATCBean";
	
	String resultByATC=request.getParameter( "resultByATC" ) ;
	if (resultByATC==null || resultByATC.equals(" ")){
			resultByATC="N";
	}
	
	String generic_id= request.getParameter( "generic_id" ) ;

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	GenericNameByATCBean bean = (GenericNameByATCBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
    bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
//added for NMC-JD-CRF-0119 - start
    con				= ConnectionManager.getConnection(request);
    boolean generic_name_max_len_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","GENERIC_NAME_MAX_LEN_APP");

	String max_length = "";	
	String max_size = "";

	if(generic_name_max_len_app){
		max_length = "100";
		max_size   = "102";
	}
	else{
		max_length = "40";
		max_size   = "42";	
	}
	//added for NMC-JD-CRF-0119 - end
	/* Initialize Function specific end */
%>
<form name="frmGenericNameAddModify" id="frmGenericNameAddModify" id="Generic Name Add Modify" >
<%
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
%>
	<br> 
	<table cellpadding=0 cellspacing=0 width="80%" border="0" align="center" >
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td  colspan="2" >&nbsp;&nbsp;
				<input type="text" id="Generic Name" name="generic_name" id="generic_name" onBlur="makeValidString(this)" size="42" maxlength="<%=max_length%>" >
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td  colspan="2">&nbsp;&nbsp;
				<select name="drug_name" id="drug_name">
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td >&nbsp;&nbsp;
				<input type="checkbox" name="eff_status" id="eff_status" value="E" checked >
			</td>
			
			<td align= "right"> 
				<input type="button" class="BUTTON" name="btnSelect" id="btnSelect" value='<fmt:message key="ePH.AssociationATCClass.label" bundle="${ph_labels}"/>' onClick="callAssociateATC()">
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
<% } 
   if( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && (resultByATC.equals("N"))){

	String narcotic_select="", general_select="", controlled_select="";
	String drugclass=request.getParameter( "drugclass" ) ;
	String genericName="";

	if (drugclass !=null) {
		if (drugclass.equals("Narcotics")){
			narcotic_select = "selected";
		}
		else if (drugclass.equals("General")){
			general_select  = "selected";
		}
		else if (drugclass.equals("Controlled")){
			controlled_select = "selected";
		}
	}	
	ArrayList arrList= bean.getAllValuesForModify(generic_id,locale);	
	String select="";
	String enableDisable="";
	if (arrList.size() > 0){
			String record[]=(String[])arrList.get(0);
			if (record[4].equals("E")){
				select = "checked";
			}
			else {
				select = "";
				enableDisable="disabled";
			}
			genericName = record[2];
	}
	else{
		if ((bean.getEffStatus()).equals("E")){
			select = "checked";		
		}
		else{
			select = "";
			enableDisable="disabled";
		}
		genericName = bean.getGenericName();
	}

%>
	<br> 
	<table cellpadding=0 cellspacing=0 width="80%" align="center" >
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td  colspan="2" >&nbsp;&nbsp;
				<input type="text" id="Generic Name" name="generic_name" id="generic_name" size="<%=max_size%>" maxlength="<%=max_length%>" value="<%= genericName %>" disabled onBlur="makeValidString(this);">
				<input type="hidden" value="<%=genericName%>" name="generic_name_with_no_modification"></td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td  colspan="2" >&nbsp;&nbsp;
				<select name="drug_name" id="drug_name"  disabled>
					<option value="G" <%=general_select%>><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N" <%=narcotic_select%>><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C" <%=controlled_select %>><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<%
			String result=	bean.checkForAssociation(generic_id);
			String disabledCheckBox = "";
			if(result.equals("N")){
				disabledCheckBox = "disabled";
			}
		%>
			<td>&nbsp;&nbsp;
				<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=select %> <%=disabledCheckBox%> onClick="controlDelete(this)">
			</td>
			<td align= "right">
				<input type="button" class="BUTTON" name="btnSelect" id="btnSelect" value='<fmt:message key="ePH.AssociationATCClass.label" bundle="${ph_labels}"/>' onClick="callAssociateATC()" <%=enableDisable %> >
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
<%
			
%>
	<script language="javascript">
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
   }
   else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && (resultByATC.equals("Y")))
   {

		String codes=request.getParameter("atcclassification");
		
		String from="";
		String to="";
		String disp_codes="";
		String disp_code_tmp="";
		String disp_desc="";
		int disp_count=0;

		StringTokenizer stCodes1 = new StringTokenizer(codes,"|");
		while(stCodes1.hasMoreTokens())
		 {
			disp_code_tmp="";
			disp_code_tmp=stCodes1.nextToken();
			
			if(!disp_code_tmp.equals(" "))
			 {	
				disp_count++;
				disp_codes+=disp_code_tmp+"|";
			 }

			disp_desc+=stCodes1.nextToken();

		 }

		ArrayList arrList= bean.getAllValuesForDisplay1(disp_codes,from,to,locale);		
		//StringTokenizer stCodes = new StringTokenizer(codes,"|");
	
		String lev1desc="",lev2desc="",lev3desc="",lev4desc="",lev5desc="";

		if (arrList.size()>=1){	
			if(disp_count>=1)
				lev1desc =(String) arrList.get(0);
			if(disp_count>=2)
				lev2desc = (String) arrList.get(1);
			if(disp_count>=3)
				lev3desc = (String) arrList.get(2);
			if(disp_count>=4)
				lev4desc = (String) arrList.get(3);
			if(disp_count>=5)
				lev5desc = (String) arrList.get(4);
		
		

%>
	<br>
	<table cellpadding=0 cellspacing=0 width="84%" border="1" align="center">	
	<thead >
		<tr>
			<th colspan="3"  style="font-size:xx-small"><fmt:message key="ePH.QueryResultByATCClassification.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<th  style="font-size:xx-small" width="30%"><fmt:message key="ePH.ATCClass.label" bundle="${ph_labels}"/></th>
		    <th colspan="2"  style="font-size:xx-small" width="70%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>			
		</tr>
	</thead>
	</table>
	<table cellpadding=0 cellspacing=0 width="84%" border="0" align="center">
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<fmt:message key="ePH.AnatomicalClass.label" bundle="${ph_labels}"/></td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<%= lev1desc %>&nbsp;</td>
		</tr>
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/>(<fmt:message key="ePH.MainClass.label" bundle="${ph_labels}"/>)</td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<%= lev2desc %>&nbsp;</td>
		</tr>
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/>(<fmt:message key="Common.SubClass.label" bundle="${common_labels}"/>)</td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<%= lev3desc %>&nbsp;</td>
		</tr>
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/>(<fmt:message key="ePH.MainClass.label" bundle="${ph_labels}"/>)</td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<%= lev4desc %>&nbsp;</td>
		</tr>
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/>(<fmt:message key="Common.SubClass.label" bundle="${common_labels}"/>)</td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">
			<%= lev5desc %>&nbsp;</td>
		</tr>
	</table>
<%
		}
		else {
%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
<%
	   }
   }
%>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="generic_id" id="generic_id" value="<%= generic_id %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
</form>
<% if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
{
%>
<script>
	document.frmGenericNameAddModify.generic_name.focus() ;
</script>
<%}%>
</body>
</HTML>

	<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%>

