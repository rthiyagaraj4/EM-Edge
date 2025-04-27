<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,javax.servlet.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,javax.imageio.*, java.awt.image.*, java.awt.*, javax.swing.*, java.awt.geom.*, java.awt.image.BufferedImage" contentType=" text/html;charset=UTF-8"%>
<html>
<head>	

<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>


<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%

//System.out.println ("eBT ManageLISImageSpecimen  2 ");
Connection con = null;
PreparedStatement pstmtImgView = null;
PreparedStatement pstmtImgViewOthers = null;
PreparedStatement pstmt = null;
ResultSet res = null;
ResultSet resImgView = null;

//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 STARTS
PreparedStatement pstmtSampleCount = null;
ResultSet resSampleCount = null;
int iSampleCount = 0;
//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 ENDS

//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
PreparedStatement pstmtIntervalTest = null;
ResultSet resIntervalTest = null;
PreparedStatement pstmtTestMasters = null;
ResultSet resTestMasters = null;
int recCountTestMasters = 0;

String test = "";
String testCode = "";
String sampleId = "";
String anatomy = "";
String anatomyCode = "";
String tissueDesc = "";
String anatomyInd = "";
String section_ind = "";
String oper_facilityId="";//Added by Nandhini against GHL-SCF-1354 on 26/June/2018
String specNum = "";//Added by Nandhini against GHL-SCF-1354 on 26/June/2018
int count = 0;
int recCount = 0;
String classValue = "QRYEVEN";

String calledFrom = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
String accessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
String p_resp_id = request.getParameter("p_resp_id") == null ? "RL_MANAGER" : request.getParameter("p_resp_id");
String p_test_code = request.getParameter("p_test_code") == null ? "" : request.getParameter("p_test_code");
String test_code = request.getParameter("test") == null ? "" : request.getParameter("test"); //Added against ML-MMOH-SCF-1797 on 08/nov/2021 Starts
String colSpan = "1";
String applServerURL = "";
System.out.println("p_test_code ::"+p_test_code);
System.out.println("test_code ::"+test_code);

if(facilityId.equals(""))
facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

if(!p_resp_id.equals("RL_MANAGER"))
	con = ConnectionManager.getConnection(request);
else if(p_resp_id.equals("RL_MANAGER"))
	con = ConnectionManager.getConnection();	
	
	

if(accessionNum.equals(""))
	specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");

//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 

			try
			{
			
			pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM rl_request_header where SPECIMEN_NO=? and ORDERED_FACILITY_ID=?");
			pstmt.setString(1,specNum);
			pstmt.setString(2,facilityId);
			res = pstmt.executeQuery();	
			System.out.println("res::"+res);	

			if(res.next()  )
			{
				oper_facilityId = res.getString("OPERATING_FACILITY_ID") == null ? "" : res.getString("OPERATING_FACILITY_ID");
				facilityId=oper_facilityId;
				System.out.println("ManageLISSpecimenImageServlet.java facilityId:" +facilityId);
			}
			
			}
			catch(Exception e1)
		{
			System.out.println("Ex1:"+e1);
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 
		}


//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) STARTS here
if(p_test_code.length()>0)
{
	String sqlTestMasters = "select count(*) from rl_test_code where test_code = ?";	
	pstmtTestMasters = con.prepareStatement(sqlTestMasters);	
	pstmtTestMasters.setString(1,p_test_code);
	resTestMasters = pstmtTestMasters.executeQuery();	
	recCountTestMasters = 0;
	while(resTestMasters.next())
	{
		recCountTestMasters = resTestMasters.getInt(1);		
	}	
	if(resTestMasters != null) resTestMasters.close();
	if(pstmtTestMasters != null) pstmtTestMasters.close();
	if(recCountTestMasters == 0)
		p_test_code = p_test_code.substring(0, p_test_code.length()-4);
}
//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) ENDS here

//String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE WHERE section_code = ?";
String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE_LANG_VW WHERE section_code = ? AND LANGUAGE_ID = ?";

//commented by Sanjay for ML-MMOH-CRF-0494[IN059242] on 31-03-2016
//String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ?   AND NVL(?, '!!') = 'AT'  AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND NVL(?, '!!') = 'SA' AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+)";

//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 31-03-2016
//removed two conditions (NVL(?, '!!') = 'SA') (NVL(?, '!!') = 'AT')
String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+)";

if(p_test_code.length()>0)		sql= sql+" and  A.test_code = '"+p_test_code+"'";

sql= sql+" ORDER BY 3, 4";
//System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp HI and CY sql:"+sql);//Sanjay
//System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp test_code.length():"+test_code.length());

//Modified by Manoj S for ML-MMOH-SCF-1078 //

String sqlO = "SELECT DISTINCT a.specimen_no, c.test_code, b.short_desc test_desc FROM rl_request_detail a, rl_test_code_lang_vw b, rl_test_result c WHERE a.specimen_no = c.specimen_no AND a.operating_facility_id = c.operating_facility_id AND a.test_code = c.group_test_code AND c.test_code = b.test_code AND a.specimen_no = ? AND a.operating_facility_id = ? AND b.language_id = ?";

//Added by Mohanapriya against ML-MMOH-SCF-1797 on 08/nov/2021  & 19/nov/2021 & V220327 Starts
/* 
if(calledFrom.equalsIgnoreCase("RL_REVIEW") ){
	sqlO= sqlO+" order by 2";  
}else{
	if(test_code.length()>0) { sqlO= sqlO+"  and ( c.test_code = '"+test_code+"') order by 2";  } 
	else if(test_code.length()==0) { sqlO= sqlO+" and ( nvl(c.STATUS,'O') = 'O' or nvl(c.STATUS,'A') = 'A')  order by 2"; } 
}
*/
if(calledFrom.equalsIgnoreCase("RL_REVIEW") && (p_test_code.length()==0)){
	sqlO= sqlO+" order by 2";  
}
if(!(calledFrom.equalsIgnoreCase("RL_REVIEW"))){
	if(test_code.length()>0) { sqlO= sqlO+"  and ( c.test_code = '"+test_code+"') order by 2";  } 
	else if(test_code.length()==0) { sqlO= sqlO+" and ( nvl(c.STATUS,'O') = 'O' or nvl(c.STATUS,'A') = 'A')  order by 2"; } 
}

//Added by Mohanapriya against ML-MMOH-SCF-1797 on 08/nov/2021  & 19/nov/2021 & V220327 Ends 
if(p_test_code.length()>0)		sqlO= sqlO+" and  c.test_code = '"+p_test_code+"'order by 2";
System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp Others sqlO:"+sqlO);//Sanjay
System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp Others specNum:"+specNum);//Sanjay
System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp Others calledFrom:"+calledFrom);//Sanjay

//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 STARTS
String sqlSampleCount="SELECT SUM(CNT_1) FROM (SELECT COUNT(1) AS CNT_1 FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT COUNT(1) AS CNT_1 FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+)";

if(p_test_code.length()>0)		sqlSampleCount= sqlSampleCount+" and  A.test_code = '"+p_test_code+"'";

sqlSampleCount= sqlSampleCount+ ")";
//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 ENDS

try
{
	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
	res = pstmt.executeQuery();
	while(res.next())
	{
		applServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String specNum = "";////Commented by Nandhini against GHL-SCF-1354 on 26/June/2018 
	String eventCode = "";
	String contrSysEventCode = "";
	String secCode = "";

	if(accessionNum.equals(""))
	{
		specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");
		secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
		
		//if(secCode.length()==0) //commented by Sanjay against ML-BRU-SCF-1502(52800) on 02-Mar-15 to handle flow from CA module
		{
			pstmt = con.prepareStatement("select section_code from rl_request_header where specimen_no =?  and operating_facility_id = ?");
			pstmt.setString(1,specNum);
			pstmt.setString(2,facilityId);
			res = pstmt.executeQuery();

			while(res.next())
			{
				secCode = res.getString(1);
				secCode = secCode == null?"":secCode;

			}

		}

	}
	else
	{
		String sqlAccessionNum = "select event_code, CONTR_SYS_EVENT_CODE, SUBSTR (?, (INSTR (?, '#') + 1), ( (INSTR (?, '@') - 1) - INSTR (?, '#'))) spec_num from cr_encounter_detail where ACCESSION_NUM = ? ";

		if(p_test_code.length()>0)		sqlAccessionNum= sqlAccessionNum+" and  event_code = '"+p_test_code+"'";


		String sqlTestCode = "select test_code from rl_test_code where ORDER_CATALOG_CODE = ? ";

		if(p_test_code.length()>0)		sqlTestCode= sqlTestCode+" and  test_code = '"+p_test_code+"'";

		pstmt = con.prepareStatement(sqlAccessionNum);
		pstmt.setString(1,accessionNum);
		pstmt.setString(2,accessionNum);
		pstmt.setString(3,accessionNum);
		pstmt.setString(4,accessionNum);
		pstmt.setString(5,accessionNum);
		res = pstmt.executeQuery();

		while(res.next())
		{
			eventCode = res.getString("event_code") == null ? "" : res.getString("event_code");
			contrSysEventCode = res.getString("CONTR_SYS_EVENT_CODE") == null ? "" : res.getString("CONTR_SYS_EVENT_CODE");
			specNum = res.getString("spec_num") == null ? "" : res.getString("spec_num");
		}

		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		pstmt = con.prepareStatement(sqlTestCode);
		pstmt.setString(1,eventCode);
		res = pstmt.executeQuery();

		while(res.next())
		{
			test = res.getString("test_code") == null ? "" : res.getString("test_code");
		}

		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		if(!accessionNum.equals(""))
		{	
			pstmt = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
			pstmt.setString(1,contrSysEventCode);
			res = pstmt.executeQuery();

			while(res.next())
			{
				secCode = res.getString("section_code") == null ? "" : res.getString("section_code");
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}
	}

	if(p_resp_id.equals("RL_MANAGER"))
	{
		%>
		<link rel='StyleSheet' href='<%=applServerURL%>eCommon/html/IeStyle.css' type='text/css' />
		<%
	}
	else
	{
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<%
	}
	pstmt = con.prepareStatement(sqlSecInd);
	pstmt.setString(1,secCode);
	pstmt.setString(2,locale);
	res = pstmt.executeQuery();
	while(res.next())
	{
		anatomyInd = res.getString("anatomy_ind") == null ? "" : res.getString("anatomy_ind");
		section_ind = res.getString("section_ind") == null ? "" : res.getString("section_ind");
	}


	if(res != null) res.close();
	if(pstmt != null) pstmt.close();
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 STARTS
	if (section_ind.equals("HI") || section_ind.equals("CY"))
	{
		try
		{
			pstmtSampleCount = con.prepareStatement(sqlSampleCount);
			pstmtSampleCount.setString(1,specNum);			
			pstmtSampleCount.setString(2,locale);
			pstmtSampleCount.setString(3,specNum);
			pstmtSampleCount.setString(4,locale);
			resSampleCount = pstmtSampleCount.executeQuery();
			while(resSampleCount.next())
			{
				iSampleCount = resSampleCount.getInt(1);		
			}
		}
		catch(Exception e1)
		{
			System.out.println("Ex1:"+e1);
			iSampleCount = 0;
		}
		finally
		{
			if(resSampleCount != null) resSampleCount.close();
			if(pstmtSampleCount != null) pstmtSampleCount.close();
		}
	}
	//System.out.println("iSampleCount:"+iSampleCount);
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 ENDS

	%>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src="../../eBT/js/ManageLISSpecimenImage.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body>
	<!-- Below Line added by Sanjay for automatic refresh of this jsp, so that page gets refreshed after Delete -->
	<!-- <meta http-equiv="REFRESH" content="3" url="../../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp"> ManageLISSpecimenImageUploadLinkForms.jsp -->
	<!-- <meta http-equiv="REFRESH" content="3" url="../../eBT/jsp/ManageLISSpecimenImageUploadLinkForms.jsp"> -->

	<form name='uploadLinkForm' id='uploadLinkForm'>
	<table border='1' width='100%' cellpadding='1' cellspacing='0' align='center'>
	<tr>
	<td class='CAGROUP' colspan='7'>SpecimenNo <%=specNum%></td>
	</tr>				
	<%
	//if (section_ind.equals("HI") || section_ind.equals("CY"))
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
	if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
	{					
		%>
		<tr>
		<th align='left'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></th>					
		<th align='left'><fmt:message key="eBT.SampleID.label" bundle="${bt_labels}"/></th>
		<th align='left'><fmt:message key="eBT.Anatomy.label" bundle="${bt_labels}"/></th>					
		<th align='left'><fmt:message key="eBT.TissueDescription.label" bundle="${bt_labels}"/></th>
		<!-- Added by Sanjay on 13-04-2016 against IN059924 STARTS -->
		<%
		if (!calledFrom.equalsIgnoreCase("RL_REVIEW")) {
		%>
			<th align='left'><fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/></th>
			<th align='left'><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
		<%
		} else {
		%>			
			<th align='left'><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
		</tr>
		<%
		}
		/* Added by Sanjay on 13-04-2016 against IN059924 ENDS */
	}
	else 
	{
		anatomyInd = "";//Sanjay
		sampleId = "";//Sanjay
		%>
		<tr>				
		<%
		if (!calledFrom.equalsIgnoreCase("RL_REVIEW")) {
			%>
			<th align='left'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></th>
			<th align='left'><fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/></th>
			<th align='left'><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
			</tr>
			<%
		} else {
			%>
			<th align='left'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></th>
			<th align='left'><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
			</tr>
			<%
		}
	}
	%>
	<tr>
	<%			
	
	

	pstmtImgView = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID = ? and ANATOMY_SITE_CODE = ?");

	pstmtImgViewOthers = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID is null and ANATOMY_SITE_CODE is null");
	//System.out.println("anatomyInd:"+anatomyInd+":");	
	//if (section_ind.equals("HI") || section_ind.equals("CY"))
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
	if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
	{
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,specNum);		
		pstmt.setString(2,locale);
		pstmt.setString(3,specNum);
		pstmt.setString(4,locale);
	}
	else {
		pstmt = con.prepareStatement(sqlO);
		pstmt.setString(1,specNum);
		pstmt.setString(2,facilityId);
		pstmt.setString(3,locale);				
	}

	res = pstmt.executeQuery();	
	while(res.next())
	{		
		//if (section_ind.equals("HI") || section_ind.equals("CY"))
		//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
		if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
		{
			test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
			testCode = res.getString("test_code") == null ? "" : res.getString("test_code");
			anatomy = res.getString("anatomy_desc") == null ? "" : res.getString("anatomy_desc");
			anatomyCode = res.getString("anatomy_site_code") == null ? "" : res.getString("anatomy_site_code");			
			sampleId = res.getString("sample_id") == null ? "" : res.getString("sample_id");
			tissueDesc = res.getString("tissue_desc") == null ? "&nbsp;" : res.getString("tissue_desc");

			if(count % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	
			
			if(p_resp_id.equals("RL_MANAGER"))
			{
				colSpan = "2";
			}
			else
			{
				colSpan = "1";				
			}
			
			out.println("<td class='"+classValue+"'>"+test+"</td>");
			out.println("<td class='"+classValue+"'>"+sampleId+"</td>");
			out.println("<td class='"+classValue+"'>"+anatomy+"</td>");
			//commented by Sanjay on 13-04-2016 against IN059924
			//out.println("<td class='"+classValue+"' colspan='"+colSpan+"'>"+tissueDesc+"</td>");
			out.println("<td class='"+classValue+"'>"+tissueDesc+"</td>");
			
		} else
		{
			if(count % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	
			
			if(p_resp_id.equals("RL_REVIEW"))
			{
				colSpan = "2";
			}
			else
			{
				colSpan = "1";				
			}

			test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
			testCode = res.getString("test_code") == null ? "" : res.getString("test_code");	
			out.println("<td class='"+classValue+"'>"+test+"</td>");				
		}
		
		//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) STARTS		
		String sqlIntervalTest = "SELECT test_code || '_' || SUBSTR ('000', 1, 3 - LENGTH (TO_CHAR (seq_no))) || to_char(seq_no) FROM rl_interval_test_specimens WHERE specimen_no = ? AND test_code = ? AND operating_facility_id = ?";
		pstmtIntervalTest = con.prepareStatement(sqlIntervalTest);
		pstmtIntervalTest.setString(1,specNum);
		pstmtIntervalTest.setString(2,testCode);
		pstmtIntervalTest.setString(3,facilityId);		
		resIntervalTest = pstmtIntervalTest.executeQuery();
		//System.out.println("sqlIntervalTest ::"+sqlIntervalTest);
		while(resIntervalTest.next())
		{			
			testCode = resIntervalTest.getString(1);
		}
		
		if(resIntervalTest != null) resIntervalTest.close();
		if(pstmtIntervalTest != null) pstmtIntervalTest.close();		
		//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) ENDS

		if (!calledFrom.equalsIgnoreCase("RL_REVIEW"))
		{
			if(accessionNum.equals(""))
			{
				//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
				out.println("<td class='"+classValue+"'><a href=\"javascript:showUploadPage('"+specNum+"','"+testCode+"','"+sampleId+"','"+secCode+"','"+anatomyCode+"')\">UpLoadFile</a></td>");
			}
		}

		//if (section_ind.equals("HI") || section_ind.equals("CY"))
		//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
		if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
		{
			pstmtImgView.setString(1,facilityId);
			pstmtImgView.setString(2,specNum);
			pstmtImgView.setString(3,testCode);
			pstmtImgView.setString(4,sampleId);
			pstmtImgView.setString(5,anatomyCode);
			resImgView = pstmtImgView.executeQuery();
		}
		else
		{
			pstmtImgViewOthers.setString(1,facilityId);
			pstmtImgViewOthers.setString(2,specNum);
			pstmtImgViewOthers.setString(3,testCode);
			resImgView = pstmtImgViewOthers.executeQuery();
		}				
		while(resImgView.next())
		{
			recCount = resImgView.getInt(1);
		}

		if(resImgView != null) resImgView.close();
		
		if(recCount > 0 )
		{
			//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
			out.println("<td class='"+classValue+"'><a href=\"javascript:viewUploadedImg('"+specNum+"','"+testCode+"','"+sampleId+"','"+secCode+"','"+anatomyCode+"','"+recCount+"','"+facilityId+"')\">View</a></td>");
		}
		else
		{
			out.println("<td class='"+classValue+"'>&nbsp;</td>");
		}
		
		out.println("</tr>");
		count++;
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();
	if(pstmtImgView != null) pstmtImgView.close();
}
catch(Exception e)
{
	//out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
	//System.out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</table>
<input type='hidden' name='p_resp_id' id='p_resp_id' value='<%=p_resp_id%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<!--added calledFromForms by Sanjay for removing Delete Option when viewed from Review -->
<input type='hidden' name='calledFromForms' id='calledFromForms' value='<%=calledFrom%>'>
</form>
</body>
</html>

