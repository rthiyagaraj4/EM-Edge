<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="webbeans.eCommon.*, java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);
%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String  allowSecondLevel = "Y";

	String groupByLocn		= request.getParameter("groupByLocn");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType		= request.getParameter("locationType");

	if(groupByLocn		== null || groupByLocn=="")groupByLocn = "N"; 
	if(groupByEpisode	== null || groupByEpisode == "") groupByEpisode = "N";  
	if(locationType		== null || locationType =="") locationType = "";

	String frameSize		= "0%,0%,*";
	String height1 = "";
	String height2 = "";
	String height3 = "";
	String URL = "ReferralPatListResult.jsp?"+request.getQueryString();
	//String urlForTitleFrame = "";
	String url_hid = "";
	String qryLoctionType	=	request.getParameter("locationType");
	String qryLoctionCode	=	request.getParameter("locationCode");
	String qryFromDate		=	request.getParameter("fromDate");
	String qryToDate		=	request.getParameter("toDate"); 
    String qryPatientId		=	request.getParameter("patientId");
    String qryGroByEpisode	=	request.getParameter("groupByEpisode");
    String qryGrpByLocn     =	request.getParameter("groupByLocn");
	String qryUnAssigned    =	request.getParameter("unAssigned");
	String qryPendingRef    =	request.getParameter("pendingRef");
	//IN064836 start
	/*String qryClosed		=	request.getParameter("closed");
	String qryOpen			=	request.getParameter("open");*/
	String refStatus		=	request.getParameter("refStatus");
	String refRegSiteYN		=	request.getParameter("refRegSiteYN");
	//IN064836 ends
	 
	 if(qryLoctionType	== null || qryLoctionType.equals(""))	qryLoctionType	= "";
	 if(qryLoctionCode	== null || qryLoctionCode.equals(""))	qryLoctionCode	= ""; 
	 if(qryFromDate		== null || qryFromDate.equals(""))		qryFromDate		= "";
	 if(qryToDate		== null || qryToDate.equals(""))		qryToDate		= "";
	 if(qryPatientId	== null || qryPatientId.equals(""))		qryPatientId	= "";	  
	 if(qryGroByEpisode	== null || qryGroByEpisode.equals(""))	qryGroByEpisode = "";
	 if(qryGrpByLocn	== null || qryGrpByLocn.equals(""))		qryGrpByLocn    = "";
	 if(qryUnAssigned	== null || qryUnAssigned.equals(""))	qryUnAssigned   = "";
	 if(qryPendingRef	== null || qryPendingRef.equals(""))	qryPendingRef   = "";
	 //IN064836 start
	 /*if(qryClosed		== null || qryClosed.equals(""))		qryClosed		= "";
	 if(qryOpen			== null || qryOpen.equals(""))			qryOpen			= "";*/
	 if(refStatus		== null || refStatus.equals(""))		refStatus		= "";
	 if(refRegSiteYN	== null || refRegSiteYN.equals(""))		refRegSiteYN	= "";
	 //IN064836 ends

     HashMap qryStrHash	= new HashMap();

     qryStrHash.put("LoctionType",qryLoctionType);
     qryStrHash.put("LoctionCode",qryLoctionCode);
	 qryStrHash.put("FromDate",qryFromDate);
	 qryStrHash.put("ToDate",qryToDate);
     qryStrHash.put("PatientId",qryPatientId); 
     qryStrHash.put("GroByEpisode",qryGroByEpisode);
     qryStrHash.put("GrpByLocn",qryGrpByLocn);
	 qryStrHash.put("unAssigned",qryUnAssigned);
	 qryStrHash.put("pendingRef",qryPendingRef);
	 //IN064836 start
	 /*qryStrHash.put("closed",qryClosed);
	 qryStrHash.put("open",qryOpen);*/
	 qryStrHash.put("refStatus",refStatus);
	 qryStrHash.put("refRegSiteYN",refRegSiteYN);
	 //IN064836 ends
	
	
	try
	{
		if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL"))
		{
			con = ConnectionManager.getConnection(request);

			String pract_id		= (String)session.getValue("ca_practitioner_id");
			String facility_id	= (String)session.getValue("facility_id");
			PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash,"ReferralList",locale);
		}
		else
		{
			session.removeAttribute("PatSearch");
			allowSecondLevel = "N";
		}

		putObjectInBean("PatSearch",PatSearch,session);
	}
	catch(Exception e)
	{
		out.println("<script>alert("+e+");</script>");		
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
		out.println("<script>parent.PatCriteriaFr.document.getElementById('searchID').disabled = false;</script>");
	}


	if(groupByLocn.equals("Y") && groupByEpisode.equals("Y"))
	{
		if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && 						qryLoctionCode.equals("*ALL"))
		{
			//frameSize = "4.5%,4.5%,*";(commented as result page not able to view)
			//frameSize = "100%,0%,*";
			height1 = "90vh";
			height2 = "0vh";
			height3 = "0vh";
		}
		else if(locationType.equals("Z"))
		{
			//frameSize = "100%,0%,*"; 
			height1 = "90vh";
			height2 = "0vh";
			height3 = "0vh";
		}
		else
		{
			//frameSize = "0%,0%,*";
			height1 = "0vh";
			height2 = "0vh";
			height3 = "90vh";
			//urlForTitleFrame = "../../eCA/jsp/ReferralPatListTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";
		}
	}
	else if(groupByLocn.equals("N") && groupByEpisode.equals("Y"))
	{
		
		allowSecondLevel = "N"; 
		if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM"))
		{
			//frameSize = "0%,0%,*";
			height1 = "0vh";
			height2 = "0vh";
			height3 = "90vh";
		}
		else
		{
			//frameSize = "4.5%,0%,*";
			height1 = "4.5vh";
			height2 = "0vh";
			height3 = "80vh";
		}
		URL = "ReferralPatListResult.jsp?"+request.getQueryString();
	}
	url_hid = request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";
%>

<script>
	top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value = '<%=url_hid%>';
</script>

<html>
	<head>
<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<title></title>
	</head>

	 <div   id='resultFrameSet'>
	<!-- <script>alert('<%=frameSize%>');</script>
	<frameset rows="60%,25%,*" framespacing='0' id='resultFrameSet'> -->
<%
		if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL"))
		{ 
%>
			<iframe name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCA/jsp/ReferralPatListResult.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' style='height:<%=height1%>;width:100vw' frameborder=0 scrolling="auto" noresize></iframe>
			<iframe name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:<%=height2%>;width:100vw'></iframe>
			<iframe name='LocnResult' id='LocnResult'  src='<%//=URL%>' frameborder=0 scrolling='auto' noresize style='height:<%=height3%>;width:100vw'></iframe>
<%
		}
		else
		{
%>

			<iframe name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:<%=height1%>;width:100vw'></iframe>
			<iframe name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:<%=height2%>;width:100vw'></iframe>
			<iframe name='LocnResult' id='LocnResult'  src='<%=URL%>' frameborder=0 scrolling='auto' noresize style='height:<%=height3%>;width:100vw'></iframe>

<%		
		}
%>
	</div>
</html>

