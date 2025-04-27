<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
	<title><fmt:message key="eCA.ClinicEventParam.label" bundle="${ca_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<form name='clinic_event_param_form' id='clinic_event_param_form' action='../../servlet/eCA.ClinicEventParamServlet' method='post' target='messageFrame'>
<input type=hidden name='high_value' id='high_value' >
<input type=hidden name='low_value' id='low_value' >
<input type=hidden name='abnml_value' id='abnml_value' >
<input type=hidden name='crtcl_value' id='crtcl_value' >
<input type=hidden name='crtcl_low_value' id='crtcl_low_value' >
<input type=hidden name='crtcl_high_value' id='crtcl_high_value' >
<input type=hidden name='delta_value' id='delta_value'>
<input type=hidden name='mode' id='mode' >
<input type=hidden name='high_value_desc' id='high_value_desc' >
<input type=hidden name='high_value_color' id='high_value_color' >
<input type=hidden name='high_value_imageurl' id='high_value_imageurl' >
<input type=hidden name='low_value_desc' id='low_value_desc' >
<input type=hidden name='low_value_color' id='low_value_color' >
<input type=hidden name='abnml_value_desc' id='abnml_value_desc' >
<input type=hidden name='abnml_value_color' id='abnml_value_color' >
<input type=hidden name='crtcl_value_desc' id='crtcl_value_desc' >
<input type=hidden name='crtcl_value_color' id='crtcl_value_color' >
<input type=hidden name='crtcl_low_value_desc' id='crtcl_low_value_desc' >
<input type=hidden name='crtcl_low_value_color' id='crtcl_low_value_color' >
<input type=hidden name='crtcl_high_value_desc' id='crtcl_high_value_desc' >
<input type=hidden name='crtcl_high_value_color' id='crtcl_high_value_color' >


<input type=hidden name='high_value_symbol' id='high_value_symbol' >
<input type=hidden name='low_value_symbol' id='low_value_symbol' >
<input type=hidden name='abnormal_value_symbol' id='abnormal_value_symbol' >
<input type=hidden name='critical_value_symbol' id='critical_value_symbol' >
<input type=hidden name='criticallow_value_symbol' id='criticallow_value_symbol' >
<input type=hidden name='criticalhigh_value_symbol' id='criticalhigh_value_symbol' >
<input type=hidden name='symbol_colour' id='symbol_colour' >





<%
conlCon = ConnectionManager.getConnection(request);
StringBuffer sblQry = new StringBuffer();
try{
%>
<!-- <table cellpadding=3 cellspacing=0 border=1 width='90%' align=center> -->
<table class='grid' width='90%' align=center  > 
<tr>
	<th class='COLUMNHEADERCENTER'><fmt:message key="eCA.HistoryRecordTypes.label" bundle="${ca_labels}"/></th>
	<th class='COLUMNHEADERCENTER'><fmt:message key="Common.OrderingPract.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADERCENTER'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></th>
	
</tr>
<%
sblQry = new StringBuffer();
String slHist_rec_type = "";
String slShort_desc = "";
String slOrd_phys_yn = "";
String slAtn_ohys_yn = "";
//String slClassValue = "";
String slClassValue = "gridData";
int ilRow = 0;
int ilCount = 0;
sblQry.append("SELECT hist_rec_type hist_rec_type, short_desc, ");
sblQry.append("nvl(create_review_ord_phys_yn,'N') create_review_ord_phys_yn, ");
sblQry.append("nvl(create_review_atn_phys_yn,'N') create_review_atn_phys_yn ");
sblQry.append("FROM cr_hist_rec_type where hist_rec_type in ('RXIN','DIET','LBIN','NCIN','PTCR','RDIN','SUNT','TRET')");

pstmt = conlCon.prepareStatement(sblQry.toString());
rslRst = pstmt.executeQuery();
if(rslRst.next())
{
	do
	{
		slHist_rec_type		= rslRst.getString("hist_rec_type");
		slShort_desc		= rslRst.getString("short_desc");
		slOrd_phys_yn		= rslRst.getString("create_review_ord_phys_yn");
		slAtn_ohys_yn		= rslRst.getString("create_review_atn_phys_yn");

            /*if(ilRow % 2 == 0)
			  slClassValue = "QRYEVEN";
            else
              slClassValue = "QRYODD";*/

			ilRow ++;
%>
	<input type='hidden' name='hist_rec_type<%=ilCount%>' id='hist_rec_type<%=ilCount%>' value="<%= slHist_rec_type %>">
<tr>
	<td width='50%'  class='<%=slClassValue %>'><%=slShort_desc%></td>
	<td width='25%' class='<%=slClassValue %>'><input type='checkbox' name= 'Ord_phys_yn<%=ilCount%>' <% if(slOrd_phys_yn.equals("Y")){ out.println("checked");}%> ></td>
	<td width='25%' class='<%=slClassValue %>'><input type='checkbox' name='Atn_phys_yn<%=ilCount%>' id='Atn_phys_yn<%=ilCount%>' <% if(slAtn_ohys_yn.equals("Y")){ out.println("checked");}%>></td>
</tr>

<%
		ilCount++;
	}
	while(rslRst.next());
}
ilCount = ilCount-1;

%>
</table>
<input type='hidden' name='count' id='count' value="<%= ilCount %>">
</form>

	<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in addClinicEventParameter.jsp :"+e.toString());//COMMON-ICN-0181
     e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);
}
%>

</body>
</html>

