<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eCommon.Common.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> --> 
	<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/ConstituentPrecipitationLimit.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>

<%

ArrayList Constituent_Generic=new ArrayList();
ArrayList const_generic_uom=new ArrayList();


String bean_id					= "ConstituentPrecipitationLimitBean";
String bean_name				= "ePH.ConstituentPrecipitationLimitBean";

String decilitre = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Perdecilitre.label","ph_labels");
int count=7;
//String mol_code				= "";

//Connection connection	= null;
//PreparedStatement pstmt	= null;
//PreparedStatement pstmt1	= null;
//ResultSet resultSet		= null;
//ResultSet resultSet1		= null;
//ArrayList mol_result=new ArrayList();

String mode			= request.getParameter("mode") ;



//String func_name			= request.getParameter("func_name") ;
//String func_name			= "QUERY" ;


int t=0;

	int prevCode=0;
	String butnFlag="";




if ( mode == null || mode.equals("") )
       return ;
if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
       return ;

ConstituentPrecipitationLimitBean bean			= (ConstituentPrecipitationLimitBean)getBeanObject( bean_id,bean_name,request);
bean.setLanguageId(locale);
//if(func_name.equals("QUERY"))
//{

//}else
//{
Constituent_Generic=bean.getConstituentGenericName();
const_generic_uom=bean.getUOM();
//}
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<br>
<form name="FormConstituentPresLimitAddmodify" id="FormConstituentPresLimitAddmodify" >
<table cellpadding="0" cellspacing="0" width="200%"  border="1" id="ConstPrescLimit">
	<tr>
	
	<th width="15%"><fmt:message key="ePH.ConstituentGenericNameLimitingFrom.label" bundle="${ph_labels}"/></th>
	<th width="10%"><fmt:message key="ePH.MoleculeNameLimitingFrom.label" bundle="${ph_labels}"/></th>
	<th width="15%"><fmt:message key="ePH.ConstituentGenericNameLimitedTo.label" bundle="${ph_labels}"/></th>
	<th width="10%"><fmt:message key="ePH.MoleculeNameLimitedTo.label" bundle="${ph_labels}"/></th>
	<th width="20%"><fmt:message key="ePH.ConstituentConcentrationFrom.label" bundle="${ph_labels}"/><br><fmt:message key="ePH.RangeBetween.label" bundle="${ph_labels}"/></th>
	<th width="20%"><fmt:message key="ePH.ConstituentConcentrationTo.label" bundle="${ph_labels}"/><br><fmt:message key="ePH.RangeBetween.label" bundle="${ph_labels}"/></th>
	<th width="35%"><fmt:message key="ePH.PrecipitationIndicator .label" bundle="${ph_labels}"/></th>
	<th width="55%"><fmt:message key="ePH.PrecipitationAlertMessage.label" bundle="${ph_labels}"/></th>
	<th width="5%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	
	</tr>
	<%
		for(t=0;t<count;t++){
	%>
	<tr>

		<td >
		<SELECT name="Gen_Name_Limit_From_<%=t%>" id="Gen_Name_Limit_From_<%=t%>" onChange = "getMolName(this,'F',<%=t%>);"  ><OPTION value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
		<%	if (Constituent_Generic.size()>0)
				{
				for (int i=0;i<Constituent_Generic.size();i=i+2)
						{
							%>
								<option value="<%=Constituent_Generic.get(i)%>"><%=Constituent_Generic.get(i+1)%>
								<%
						}
				}

			 if (prevCode==0) butnFlag="Y";
			 else if(prevCode>0) butnFlag="N";
			 else butnFlag="Y";

		%>
		</SELECT>
		
		</td> 
		<td>
		<SELECT name="Mol_Name_From_<%=t%>" id="Mol_Name_From_<%=t%>" ><OPTION value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
	
		</SELECT>
		
		</td> 
		<td >
		<SELECT name="Gen_Name_Limit_To_<%=t%>" id="Gen_Name_Limit_To_<%=t%>" onChange = "getMolName(this,'T',<%=t%>);" ><OPTION value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
		<%	if (Constituent_Generic.size()>0)
				{
				for (int i=0;i<Constituent_Generic.size();i=i+2)
						{
							%>
								<option value="<%=Constituent_Generic.get(i)%>"><%=Constituent_Generic.get(i+1)%>
								<%

								
						}
				}

		%>
		</SELECT>
		
		</td> 
		<td >
		<SELECT name="Mol_Name_To_<%=t%>" id="Mol_Name_To_<%=t%>" ><OPTION value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
	
		</SELECT>
		
		</td> 
		<td>
		<input type="text" name="Con_ConCen_From_Min_<%=t%>" id="Con_ConCen_From_Min_<%=t%>" maxlength="8" size="4" value="" onKeyPress="return allowValidNumber(this,event,5,2);" onBlur = "chkOverLap(Con_ConCen_From_Min_<%=t%>,Con_ConCen_From_Max_<%=t%>,<%=t%>,'F',Con_ConCen_From_UOM_<%=t%>);">-<input type="text" name="Con_ConCen_From_Max_<%=t%>" id="Con_ConCen_From_Max_<%=t%>" maxlength="8" size="4" value="" onKeyPress="return allowValidNumber(this,event,5,2);" onBlur="checkRange(Con_ConCen_From_Min_<%=t%>,Con_ConCen_From_Max_<%=t%>);chkOverLap(Con_ConCen_From_Min_<%=t%>,Con_ConCen_From_Max_<%=t%>,<%=t%>,'F',Con_ConCen_From_UOM_<%=t%>);validateOverlapRange(<%=t%>,'F',Con_ConCen_From_UOM_<%=t%>);">&nbsp;<SELECT name="Con_ConCen_From_UOM_<%=t%>" id="Con_ConCen_From_UOM_<%=t%>" onChange = "getConstGenericUom(this,<%=t%>);validateOverlapRange(<%=t%>,'F',Con_ConCen_From_UOM_<%=t%>);chkOverLap(Con_ConCen_From_Min_<%=t%>,Con_ConCen_From_Max_<%=t%>,<%=t%>,'F',Con_ConCen_From_UOM_<%=t%>);">
		<%
		if (const_generic_uom.size()>0)
				{
				for (int i=0;i<const_generic_uom.size();i=i+2)
						{	
		%>
		<option value="<%=const_generic_uom.get(i)%>"><%=const_generic_uom.get(i+1)%>
		<%

								
						}
				}

		%>
		</SELECT>&nbsp;&nbsp;<input type="text" name="Con_ConCen_From_UOM_Conv_<%=t%>" id="Con_ConCen_From_UOM_Conv_<%=t%>" size="6" value="<%=decilitre%>" readonly>
		
		</td>
		<td>
		<input type="text" name="Con_ConCen_To_Min_<%=t%>" id="Con_ConCen_To_Min_<%=t%>" maxlength="8" size="4" value="" onKeyPress="return allowValidNumber(this,event,5,2);" onBlur="checkRange(Con_ConCen_To_Min_<%=t%>,Con_ConCen_To_Max_<%=t%>);chkOverLap(Con_ConCen_To_Min_<%=t%>,Con_ConCen_To_Max_<%=t%>,<%=t%>,'T',Con_ConCen_From_UOM_<%=t%>);">-<input type="text" name="Con_ConCen_To_Max_<%=t%>" id="Con_ConCen_To_Max_<%=t%>" maxlength="8" size="4" value="" onKeyPress="return allowValidNumber(this,event,5,2);"onBlur="checkRange(Con_ConCen_To_Min_<%=t%>,Con_ConCen_To_Max_<%=t%>);validateOverlapRange(<%=t%>,'T',Con_ConCen_From_UOM_<%=t%>);chkOverLap(Con_ConCen_To_Min_<%=t%>,Con_ConCen_To_Max_<%=t%>,<%=t%>,'T',Con_ConCen_From_UOM_<%=t%>);">&nbsp;<input type="text" name="Con_ConCen_To_UOM_<%=t%>" id="Con_ConCen_To_UOM_<%=t%>" size="3" value="<%=const_generic_uom.get(1)%>" readonly>&nbsp;&nbsp;<input type="text" name="Con_ConCen_To_UOM_Conv_<%=t%>" id="Con_ConCen_To_UOM_Conv_<%=t%>" size="6" value="<%=decilitre%>" readonly>
		

		</td>

		<td align="left" class="QRYODD" width="25%"  >
		<SELECT name="precipitation_indicator_<%=t%>" id="precipitation_indicator_<%=t%>"><OPTION value="W">Warning</option>
		<OPTION value="E">Error</option><OPTION value="N">Information</option>
	
		</SELECT>
		
		</td>
		<td>
		<input type="text" name="precipitation_alert_msg_<%=t%>" id="precipitation_alert_msg_<%=t%>" maxlength="300" size="80" value="" onBlur="iconEnable(this,<%=t%>);">
		</td>
		<td>
		<input type="checkbox" name="Con_Alert_YN_<%=t%>" id="Con_Alert_YN_<%=t%>" value="E" onChange="changeValue(this);" checked>
		<input type='button' name="addRow_<%=t%>" id="addRow_<%=t%>" class='button' align="right" onclick="generateRow(this,<%=t%>)" value=' V ' disabled > 

	
		

		 

		</td>
	</tr>
<%}
		prevCode = Constituent_Generic.size(); 
		%>
</table>


<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="cnt" id="cnt" VALUE="<%=t%>">
</form>
</body>
</html>


