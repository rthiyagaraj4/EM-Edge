<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           							created
12/02/2013		CHL_CRF			Nijitha									CHL_CRF   
21/03/2014	 	IN034513	  	Vijayakumar K 							SS-CRF-0007 In the patient Chart Clinician Access, 
																		the previous Encounters were grouped by specialty in eHIS version 5x. This enabled the doctors to view the details of their desired specialty. With the upgrade, this grouping has been removed.								 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
		<title>Widget Param</title>
		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src='../js/WidgetParameter.js'			language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' >


<form name="chartSummaryWidgetParamForm" id="chartSummaryWidgetParamForm"  action='../../servlet/eCA.WidgetParamServlet' method="post" target="messageFrame">
<%
	
	String widgetThemeIconChecked ="";
	String widgetThemeIconIndicator="N";
	String widgetThemeIndicator="";
	String widgetIconIndicator="";
	String widgetThemeChecked_YES ="";
	String widgetThemeChecked_NO ="";
	String widgetIconChecked ="";
	String widgetIconChecked_YES ="";
	String widgetIconChecked_NO ="";
	String widgetThemeIndicator_yes="Y";
	String widgetThemeIndicator_no="N";
	String widgetIconIndicator_yes="Y";
	String widgetIconIndicator_no="N";
	//IN034513 starts
	String enc_grp_by_splty_yn="N";
	String enc_grp_checked ="";
	//IN034513 ends
	try{
	conlCon = ConnectionManager.getConnection(request);
	StringBuilder sblQry = new StringBuilder();
	//IN034513 starts
	//sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN FROM CA_WIDGET_PARAM ");
	sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN,ENC_GRP_BY_SPLTY_YN FROM CA_WIDGET_PARAM ");
	//IN034513 ends
	pstmt = conlCon.prepareStatement( sblQry.toString());
	rslRst = pstmt.executeQuery();
	if(rslRst.next())
	{
		do
		{
			widgetThemeIconIndicator = rslRst.getString("WIDGET_THEME_ICON_YN");
			widgetThemeIndicator = rslRst.getString("WIDGET_THEME_YN");
			widgetIconIndicator = rslRst.getString("WIDGET_ICON_YN");
			enc_grp_by_splty_yn = rslRst.getString("ENC_GRP_BY_SPLTY_YN");//IN034513
			
			if("Y".equals(widgetThemeIconIndicator))
			{
				widgetThemeIconChecked="checked";
			}
			if("Y".equals(widgetThemeIndicator))
			{
				widgetThemeChecked_YES="checked";
				widgetThemeChecked_NO="";
				widgetThemeIndicator_yes="Y";
			}
			else
			{
				widgetThemeChecked_NO="checked";
				widgetThemeChecked_YES="";
				widgetThemeIndicator_no="N";
			}
			if("Y".equals(widgetIconIndicator))
			{
				widgetIconChecked_YES="checked";
				widgetIconChecked_NO="";
				widgetIconIndicator_yes="Y";
			}
			else
			{
				widgetIconChecked_NO="checked";
				widgetIconChecked_YES="";
				widgetIconIndicator_no="N";
			}
			//IN034513 starts
			if("Y".equals(enc_grp_by_splty_yn))
			{
				enc_grp_checked="checked";
			}
			else
			{
				enc_grp_checked = "unchecked";
			}
			//IN034513 ends
		}while(rslRst.next());
			out.println("<input type='hidden' name='mode' id='mode' value='update'>");
	}
	else
	{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
	}		
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();	


%>
	<BR><BR><BR><BR><BR><BR><BR><BR>
 <table cellpadding='3' cellspacing='0' border='0'  align='center''>
	<tr>
	  <td class="label" align='left'>Enable Widget Themes/Icons</td>
	  <td align='right'><input type="checkbox" name="EnableWidgetThemeOrIcon" id="EnableWidgetThemeOrIcon" value = '<%=widgetThemeIconIndicator%>' <%=widgetThemeIconChecked%> onclick ="enableDisableWidgetThemeOrIcon(this)"></td>
	  </td>
	</tr>
		
	<tr id="widgetThemes" style="display:none">
	  <td  class="label" align='left'>Widget Themes</td>
	  <td colspan="2" align='right' class="label"><input type="radio" name="widgetTheme" id="widgetTheme" value='<%=widgetThemeIndicator_yes%>' <%=widgetThemeChecked_YES%> id ='themerequired' onclick="defaultWidgetThemeSelection(this)">Yes</td>
	</tr>
	<tr id="widgetThemes1" style="display:none">
	  <td  class="label" align='left'></td>
	  <td colspan="2" align='right' class="label"><input type="radio" name="widgetTheme" id="widgetTheme" value='<%=widgetThemeIndicator_no%>' <%=widgetThemeChecked_NO%> id ='themenotrequired' onclick="defaultWidgetThemeSelection(this)">No</td>
	</tr>
	<tr id="widgetIcons" style="display:none">
	  <td  class="label" align='left'>Widget Icons</td>
	  <td colspan="2" align='right' class="label"><input type="radio" name="widgetIcons" id="widgetIcons" value='<%=widgetIconIndicator_yes%>' <%=widgetIconChecked_YES%> id ='iconsrequired' onclick="defaultWidgetIconSelection(this)">Yes</td>
	</tr>
	<tr id="widgetIcons1" style="display:none">
	  <td  class="label" align='left'></td>
	  <td colspan="2" align='right' class="label"><input type="radio" name="widgetIcons" id="widgetIcons" value='<%=widgetIconIndicator_no%>' <%=widgetIconChecked_NO%> id ='iconsnotrequired' onclick="defaultWidgetIconSelection(this)">No</td>
	</tr>
	<!-- IN034513 starts -->
	<tr>
	  <td class="label" align='left'><fmt:message key="eCA.EncGrpCurrSpeclty.label" bundle="${ca_labels}"/></td>
	  <td align='right'><input type="checkbox" name="EncntrGrpngCurrSpeclty" id="EncntrGrpngCurrSpeclty" value = '<%=enc_grp_by_splty_yn%>' <%=enc_grp_checked%> onclick ="enableEncounterGrpByCurrSpeclty(this)"></td>
	  </td>
	</tr>
	<!-- IN034513 ends -->
</table>
	<input type=hidden name="widget_ThemeIcon_yn" id="widget_ThemeIcon_yn" value=<%=widgetThemeIconIndicator %>>
	<input type=hidden name="widget_Theme_yn" id="widget_Theme_yn" value=<%=widgetThemeIndicator %>>
	<input type=hidden name="widget_Icon_yn" id="widget_Icon_yn" value=<%=widgetIconIndicator %>>
	<input type=hidden name="enc_grp_by_splty_yn" id="enc_grp_by_splty_yn" value=<%=enc_grp_by_splty_yn %>><!-- IN034513 -->
</form>
<script>
var enableThemeIcon_yn = document.chartSummaryWidgetParamForm.EnableWidgetThemeOrIcon.value;

if(enableThemeIcon_yn == 'Y'){	
	document.getElementById('widgetThemes').style.display='';
		document.getElementById('widgetThemes1').style.display='';
		document.getElementById("widgetIcons").style.display='';
		document.getElementById('widgetIcons1').style.display='';
	
}

</script> 
</body>
</html>		
<%
}
catch(Exception e)
{
//out.println("Exception in ChartSummaryWidgetParam.jsp:"+e.toString());//common-icn-0181
e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

}
%>

