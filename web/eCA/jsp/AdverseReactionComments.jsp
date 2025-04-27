<!--
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
16/04/2024	  32074	   Ranjith P R		17/04/2024		RAMESH G		ML-MMOH-CRF-1912.1
9/08/2024	  64856    HARIHARAN K	    9/08/2024				        ML-MMOH-SCF-2920
---------------------------------------------------------------------------------------------------------
-->
<!-- 32074 starts -->
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" %>
<html> 
<head> 
<style>
	TD.CAGREEN
	{
		FONT-SIZE: 10PT ;
		BACKGROUND-COLOR: #99CC00;
		BORDER-STYLE: SOLID;
		BORDER-LEFT-COLOR: #B2B6D7;
		BORDER-RIGHT-COLOR: #B2B6D7;
		BORDER-TOP-COLOR: #E2E3F0;
		BORDER-BOTTOM-COLOR: #E2E3F0;
	}
	TD.TD_BROWN
	{
		BACKGROUND-COLOR: BROWN;  
		COLOR = WHITE;
		FONT-SIZE: 10pt ;
		BORDER-STYLE: SOLID;
		border-left-color: #B2B6D7;
		border-right-color: #B2B6D7;
		border-top-color: #E2E3F0;
		border-bottom-color: #E2E3F0;
		height:18;	
	}
	PRE
		{
			font-size: 10pt ;
			/*IN043895 Start.*/
			/*Font-Family : Courier New;*/
			Font-Family : "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";
			/*IN043895 End.*/
			BACKGROUND-COLOR: #E2E3F0;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;	
		}
	<!-- IN042466 Start. -->
	DIV
		{
			white-space: normal;
			word-wrap: break-word;
			width	: 1000px;
		
		}
	ADDRESS
		{
			/*IN049424 Start.*/
			/*Font-Family : "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";*/  /*IN043895*/
			FONT-FAMILY: Verdana ;
			/* IN049424 End.*/
			white-space: normal;
			word-wrap: break-word;
			/*width	: 1000px;*/ <!-- IN059735 -->
		}
	<!-- IN042466 End. --> 
</style>
 <%
	  request.setCharacterEncoding("UTF-8");
	  String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>      
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
Properties p;
session 		= request.getSession(false);
p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
String locale 	= (String) p.getProperty("LOCALE");
String transfusion_remarks = "";
String patient_id	=request.getParameter("patient_id");
String unit_no	=request.getParameter("unit_no");
String specimen_num	=request.getParameter("specimen_num");
String product_code	=request.getParameter("product_code");
String encounter_id =request.getParameter("encounter_id1");//ML-MMOH-SCF-2920

String his_rec_type = "BLTF";
String bean_id = "ChartSummaryCriticalLabAlertDetailsBean";
String bean_name = "eCA.ChartSummaryCriticalLabAlertDetailsBean";
ChartSummaryCriticalLabAlertDetailsBean bean = (ChartSummaryCriticalLabAlertDetailsBean)getBeanObject(bean_id,bean_name,request) ; 
ArrayList searchData = new ArrayList();		
searchData = bean.getAdverseTransfusionDetails(p,locale,patient_id,unit_no,specimen_num,product_code,his_rec_type,encounter_id);//ML-MMOH-SCF-2920

%>
<title>Blood Transfusion - Adverse Reaction Details</title>
</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>


	<table width='100%' border='0' cellspacing='0' cellpadding='0'
		align=center scrolling='no'>
       
		<tr>
			<td>
			<%=searchData.get(0)%>
			</td>
			

		</tr>

	</table>


</body>

</html>
<!-- 32074 ends -->

