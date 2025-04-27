<!DOCTYPE html>
<!--
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201016            74223         SKR-SCF-1448			MuthukumarN
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	String strSetInd = ""; 
	String strAdmFlag = "";
	String strFamIn = ""; 
	String strFamAss  = "";
	String strNoDep = ""; 	
	String strNonInsBlGrId = ""; 	
	String strNonInsCustCode = "";
	String strGLHol  = ""; 
	String strPatRel  = "";
	String strBillGrp = "";
	String strPatRelGL = "";
	String strCrdDocRef = ""; 	
	String strCrDocRefStDate = "";
	String strCrDocRefEndDate = "";	
	String strResPay  = ""; 	
	String strPatRelnRespPers=""; 	 

	String strepisodetype=""; 
	String strepisodeid=""; 
	String strvisitid="";
	String strpatientid="";
	String streffFromDate ="";  	
	String streffToDate=""; 
	String strfinRemarks="";
	int noofdecimal = 2;
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs3 = null;
	String sqlrem=""; 	

	String locale	= (String)session.getAttribute("LOCALE");	
	request.setCharacterEncoding("UTF-8");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
		strBillGrp =	request.getParameter("strBillGrp");		
		if(strBillGrp==null) strBillGrp="";
		strSetInd =	request.getParameter("strSetInd");	
		if(strSetInd==null) strSetInd="";
		strAdmFlag =	request.getParameter("strAdmFlag");	
		if(strAdmFlag==null) strAdmFlag="";
		strFamIn =	request.getParameter("strFamIn");	
		if(strFamIn==null) strFamIn="";
		strFamAss =	request.getParameter("strFamAss");	
		if(strFamAss==null) strFamAss="";
		strNoDep =	request.getParameter("strNoDep");	
		if(strNoDep==null) strNoDep="";
		strNonInsBlGrId =	request.getParameter("strNonInsBlGrId");	
		if(strNonInsBlGrId==null) strNonInsBlGrId="";
		strNonInsCustCode =	request.getParameter("strNonInsCustCode");	
		if(strNonInsCustCode==null) strNonInsCustCode="";
		strGLHol =	request.getParameter("strGLHol");
		if(strGLHol==null) strGLHol="";
		strPatRel =	request.getParameter("strPatRel");	
		if(strPatRel==null) strPatRel="";
		strPatRelGL =	request.getParameter("strPatRelGL");	
		if(strPatRelGL==null) strPatRelGL="";
		strCrdDocRef =	request.getParameter("strCrdDocRef");
		if(strCrdDocRef==null) strCrdDocRef="";
		strCrDocRefStDate =	request.getParameter("strCrDocRefStDate");
		if(strCrDocRefStDate==null) strCrDocRefStDate="";
		strCrDocRefEndDate =	request.getParameter("strCrDocRefEndDate");
		if(strCrDocRefEndDate==null) strCrDocRefEndDate="";
		strResPay =	request.getParameter("strResPay");
		if(strResPay==null) strResPay="";
		strPatRelnRespPers =	request.getParameter("strPatRelnRespPers");
		if(strPatRelnRespPers==null) strPatRelnRespPers="";
		strepisodetype = request.getParameter("episodetype");
		if(strepisodetype==null) strepisodetype="";
		strepisodeid = request.getParameter("episodeid");
		if(strepisodeid==null) strepisodeid="";
		strvisitid = request.getParameter("visitid");
		if(strvisitid==null) strvisitid="";
		strpatientid= request.getParameter("patientid");
		if(strpatientid==null) strpatientid="";
		strpatientid=strpatientid.trim();			
		
		try
		{	
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs3 = pstmt.executeQuery();	
			while(rs3.next())
			{
				noofdecimal  =  rs3.getInt(1);		
			}
			pstmt.close();
			rs3.close();
			CurrencyFormat cf = new CurrencyFormat();
			strFamIn = cf.formatCurrency(strFamIn, noofdecimal);
			strFamAss = cf.formatCurrency(strFamAss, noofdecimal);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in Currency Conversion="+e.toString());
		}
%>
<html>
  <head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<style>
textarea {
  resize: none;
}
</style>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<tr>
<%
	try
	{		
		sqlrem="SELECT distinct TO_CHAR(a.eff_from_date,'dd/mm/yyyy') eff_from_date, "+
			   " TO_CHAR(a.eff_to_date,'dd/mm/yyyy') eff_to_date,"+
			   " a.fin_remarks fin_remarks "+
				" FROM bl_patient_fin_remarks a "+
				" WHERE a.operating_facility_id = '"+facility_id+"' "+
				" AND a.episode_type = '"+strepisodetype+"' "+
				" AND ((a.patient_id = '"+strpatientid+"' AND a.episode_type = 'R') OR "+
				" (a.episode_id = '"+strepisodeid+"' AND a.visit_id = '"+strvisitid+"' AND a.episode_type IN ('O','E')) OR "+
				" (a.episode_id = '"+strepisodeid+"' AND a.episode_type IN ('I','D')))";//V201016

		pstmt = con.prepareStatement(sqlrem);
		rs3 = pstmt.executeQuery() ;
	
		if(rs3!=null)
		{
%>
<td class='COLUMNHEADER'><fmt:message key="eBL.FINANCIAL_REMARKS.label" bundle="${bl_labels}"/>
</tr>
</table>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' >
<%
	}
	else
	{
%>
<td class='COLUMNHEADER'></td>
<%
	}			
	while(rs3.next())
	{
		streffFromDate = rs3.getString(1);
		if(streffFromDate==null) streffFromDate="";
		if(!streffFromDate.equals(""))
		{
			streffFromDate=com.ehis.util.DateUtils.convertDate(streffFromDate,"DMY","en",locale);
		}
		streffToDate=rs3.getString(2);
		if(streffToDate==null) streffToDate="";
		if(!streffToDate.equals(""))
		{
			streffToDate=com.ehis.util.DateUtils.convertDate(streffToDate,"DMY","en",locale);
		}
		strfinRemarks=rs3.getString(3);	

		if (streffFromDate == null) streffFromDate = "";
		if (streffToDate == null) streffToDate = "";
		if (strfinRemarks == null) strfinRemarks = "";			

		out.println("<tr>");
		out.println("<td width='25%' class='data'>"+streffFromDate+"</td>");
		out.println("<td width='25%' class='fields'>"+streffToDate+"</td>");
		out.println("<td width='25%' class='fields'>"+"<TextArea name='' tabindex='0' cols='70' readonly value=''> "+strfinRemarks+"</TextArea></td>");
		out.println("<td width='25%' class='label' size='30' > </td>");
		out.println("</tr>");
	}//while closing	
	if((streffFromDate.equals("")) && (streffToDate.equals("")) && (strfinRemarks.equals("")))
	{
%>	
		<tr><td colspan=6>&nbsp;</td></tr>
		<tr><td colspan=6>&nbsp;</td></tr>
		<!-- <tr><td colspan=6>&nbsp;</td></tr>
		<tr><td colspan=6>&nbsp;</td></tr>
		<tr><td colspan=6>&nbsp;</td></tr>
		<tr><td colspan=6>&nbsp;</td></tr>
		<tr><td colspan=6>&nbsp;</td></tr>	 -->	
<%
		}//if
	}//try closing
	catch(Exception sql)
	{
		sql.printStackTrace();
		System.out.println("Exception in Currency Conversion="+sql.toString());			
	}
%>
</table>
</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Main Exception:"+e);
	}
	finally
	{
		if (rs3 != null)   rs3.close();
		if (pstmt != null) pstmt.close();
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</html>

