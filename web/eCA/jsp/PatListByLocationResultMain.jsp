<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date      	 Edit History   Name        	Description
-----------------------------------------------------------------------------------------------
?             	100         	?           	created
18/11/2011    	IN29412     	Dinesh T    	AMS CRF
06/04/2015	IN048704    	Nijitha S	HSA-CRF-0175	
14/11/2023	51215		Ramesh		ML-MMOH-CRF-1930.2
-----------------------------------------------------------------------------------------------
-->
<%@page import="webbeans.eCommon.*, java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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

	String  allowSecondLevel="Y";
	String tab_menu_yn  = (request.getParameter("tab_menu_yn")==null)?"":request.getParameter("tab_menu_yn");
	String groupByLocn	= request.getParameter("groupByLocn");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType			= request.getParameter("locationType");
	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
		
	
	if(groupByLocn			== null || groupByLocn=="")groupByLocn="N"; 
	if(groupByEpisode	== null || groupByEpisode == "") groupByEpisode ="N";  
	if(locationType			== null || locationType =="") locationType="";

	String frameSize		= "0,0,0,*";
	
	String urlForTitleFrame="";
	String URL="";
	String url_hid="";
	String qryLoctionType		=   request.getParameter("locationType");
	String qryLoctionCode	=   request.getParameter("locationCode");
    String qryViewList			=   request.getParameter("viewList");
	String qryadm_fromdate =  request.getParameter("adm_fromdate");
	String qryadm_todate		=   request.getParameter("adm_todate"); 
    String qryPatientId			=	 request.getParameter("patientId");
    String qryQueueId			=	 request.getParameter("queueId");
	String nationID					=	 request.getParameter("nationID");
    String qryQueueStatus   =	 request.getParameter("queueStatus");
	String qryUnSheduled    =	 request.getParameter("unscheduled_yn");
    String qryPastVisit		    =	 request.getParameter("past");
    String qryFromDate1		=	 request.getParameter("from_visit_date");
	String qryToDate1	=	 request.getParameter("to_visit_date");
    String qryDischarge    =	 request.getParameter("discharged");
    String qryFromDate2	=	 request.getParameter("from_discharge_date");
    String qryToDate2	=	 request.getParameter("to_discharge_date");
	String qrySortOrder			 =	 request.getParameter("sortOrder");
    String qryGroByEpisode =	 request.getParameter("groupByEpisode");
    String qryGrpByLocn       =	 request.getParameter("groupByLocn");
	String qryCheckedOut     =	 request.getParameter("checked_out");
	String attend_practId     =	 request.getParameter("attend_practId");
	String speciality     =	 request.getParameter("speciality");
	String relnreqyn     =	 request.getParameter("reln_req_yn");
	String visitType     =	 request.getParameter("visitType");
	String bedNo = (String)request.getParameter("bedNo")==""?"%":request.getParameter("bedNo");//IN29412
	String assign_confirm_referral_yn     =	 request.getParameter("assign_confirm_referral_yn");//IN048704
	String virtualConsultation_yn=	 request.getParameter("virtualConsultation_yn"); //51215
	
	String iFrameSize0 = "", iFrameSize1 = "", iFrameSize2 = "", iFrameSize3 = "";

	/*String RP_chk     =	 request.getParameter("RP_chk")==null?"N":request.getParameter("RP_chk");
	String OVR_chk     =	 request.getParameter("OVR_chk")==null?"N":request.getParameter("OVR_chk");
	String OCIP_chk     =	 request.getParameter("OCIP_chk")==null?"N":request.getParameter("OCIP_chk");
	String CBSR_chk     =	 request.getParameter("CBSR_chk")==null?"N":request.getParameter("CBSR_chk");
	String UCBSR_chk     =	 request.getParameter("UCBSR_chk")==null?"N":request.getParameter("UCBSR_chk");
	String OA_chk     =	 request.getParameter("OA_chk")==null?"N":request.getParameter("OA_chk");
	String OAP_chk     =	 request.getParameter("OAP_chk")==null?"N":request.getParameter("OAP_chk");*/
	
	 if(qryLoctionType		  == null || qryLoctionType.equals(""))	qryLoctionType	="";
	 if(qryLoctionCode	  == null || qryLoctionCode.equals(""))	qryLoctionCode	=""; 
	 if(qryViewList			  == null || qryViewList.equals(""))			qryViewList		="";	 
	 if (qryadm_fromdate ==null || qryadm_fromdate.equals("")) qryadm_fromdate="";
	 if (qryadm_todate		  ==null || qryadm_todate.equals("")) qryadm_todate="";
	 if(qryPatientId			== null || qryPatientId.equals(""))			qryPatientId	="";	  
	 if(qryQueueId			== null || qryQueueId.equals(""))			qryQueueId	 	="";	 
	 if(nationID==null || nationID.equals("")) nationID="";
	 if(qryQueueStatus	== null || qryQueueStatus.equals(""))	qryQueueStatus  ="";	 
	 if(qryUnSheduled	== null || qryUnSheduled.equals(""))	qryUnSheduled   ="";	 
	 if(qryPastVisit			== null || qryPastVisit.equals(""))			qryPastVisit	="";	  
	 if(qryFromDate1		== null || qryFromDate1.equals(""))		qryFromDate1	="";	  
	 if(qryToDate1		== null || qryToDate1.equals(""))		qryToDate1	="";	  
	 if(qryDischarge		== null || qryDischarge.equals(""))		qryDischarge    ="";	 
	 if(qryFromDate2		== null || qryFromDate2.equals(""))		qryFromDate2	="";	  
	 if(qryToDate2		== null || qryToDate2.equals(""))		qryToDate2	="";	  
	 if(qrySortOrder			== null || qrySortOrder.equals(""))			qrySortOrder	="";
	 if(qryGroByEpisode== null || qryGroByEpisode.equals(""))	qryGroByEpisode ="";
	 if(qryGrpByLocn		== null || qryGrpByLocn.equals(""))		qryGrpByLocn    ="";
	 if(qryCheckedOut	== null || qryCheckedOut.equals(""))	qryCheckedOut    ="";
	 if(attend_practId	== null || attend_practId.equals(""))	attend_practId    ="";
	 if(speciality	== null || speciality.equals(""))	speciality    ="";
	 if(relnreqyn	== null || relnreqyn.equals(""))
         if(visitType	== null || visitType.equals(""))	relnreqyn    ="";

     HashMap qryStrHash			 =	 new HashMap();
     qryStrHash.put("LoctionType",qryLoctionType);
     qryStrHash.put("LoctionCode",qryLoctionCode);
     qryStrHash.put("ViewList",qryViewList); 
	 qryStrHash.put("adm_fromdate",qryadm_fromdate);
	 qryStrHash.put("adm_todate",qryadm_todate);
     qryStrHash.put("PatientId"	,	qryPatientId); 
     qryStrHash.put("QueueId"   ,	qryQueueId);
	 qryStrHash.put("nationID",nationID);
     qryStrHash.put("QueueStatus"	,	qryQueueStatus);
     qryStrHash.put("UnSheduled"	,	qryUnSheduled);
     qryStrHash.put("PastVisit"		,	qryPastVisit); 
     qryStrHash.put("FromDate1"		,	qryFromDate1); 
	 qryStrHash.put("ToDate1"		,	qryToDate1); 
     qryStrHash.put("Discharge"     ,	qryDischarge);
     qryStrHash.put("FromDate2"     ,	qryFromDate2); 
     qryStrHash.put("ToDate2"		,	qryToDate2); 
     qryStrHash.put("SortOrder"     ,	qrySortOrder); 
     qryStrHash.put("GroByEpisode"  ,	qryGroByEpisode);
     qryStrHash.put("GrpByLocn"     ,	qryGrpByLocn);
	 qryStrHash.put("checked_out"   ,	qryCheckedOut);
	 qryStrHash.put("attend_practId"   ,	attend_practId);
	 qryStrHash.put("speciality"   ,	speciality);
     qryStrHash.put("visitType"   ,	visitType);
	 qryStrHash.put("relnreqyn"    ,	relnreqyn);
	 qryStrHash.put("bedNo"    ,	bedNo);//IN29412
	 qryStrHash.put("assign_confirm_referral_yn"    ,	assign_confirm_referral_yn);//IN048704
	 qryStrHash.put("virtualConsultation_yn"    ,	virtualConsultation_yn);//51215
	 
	// added for CRF 464 by Shaiju 
	 /*qryStrHash.put("RP_chk"   ,	RP_chk);
	 qryStrHash.put("OVR_chk"   ,	OVR_chk);
	 qryStrHash.put("OCIP_chk"   ,	OCIP_chk);
	 qryStrHash.put("CBSR_chk"   ,	CBSR_chk);
	 qryStrHash.put("UCBSR_chk"   ,	UCBSR_chk);
	 qryStrHash.put("OA_chk"   ,	OA_chk);
	 qryStrHash.put("OAP_chk"   ,	OAP_chk);*/
	
	try
	{
		if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL"))
		{
			con = ConnectionManager.getConnection(request);

			String pract_id		= (String)session.getValue("ca_practitioner_id");
			String facility_id	= (String)session.getValue("facility_id");
			PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash,"ByLocation",locale);
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
		if(con!=null) ConnectionManager.returnConnection(con,request);
		out.println("<script>parent.PatCriteriaFr.document.getElementById('searchID').disabled = false;</script>");
	}

	if(groupByLocn.equals("Y") && groupByEpisode.equals("Y")){
			if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && 						qryLoctionCode.equals("*ALL")){
				if(tab_menu_yn.equals("Y")) 
				{	
					//frameSize = "0%,8%,4.5%,*";
					frameSize = "0%,5.5%,4.5%,*";
					//frameSize = "0%,6%,10%,*";					
					//ameSize = "0%,8%,5.5%,*";
					
					iFrameSize0		= "height:0vh;width:100vw";
					iFrameSize1		= "height:7vh;width:100vw";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					

				}
				else 
				{
					/*if(RP_chk.equals("Y"))
					{
						frameSize = "4.5%,4.5%,5.5%,*";
					}
					else
					{*/
						frameSize = "0%,5.6%,6%,*";		
					iFrameSize0		= "height:0vh;width:100vw";
					iFrameSize1		= "height:7vh;width:100vw";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					//}
				}
			}else if(locationType.equals("Z")){
				
				if(tab_menu_yn.equals("Y")) {
					//frameSize = "10%,8%,4.5%,*";
									frameSize = "5.5%,5.5%,5.5%,*";		
									iFrameSize0		= "height:7vh;width:100vw";
									iFrameSize1		= "height:7vh;width:100vw";
									iFrameSize2		= "height:7vh;width:100vw";
									iFrameSize3		= "height:75vh;width:100vw";
				}

				else{ 
					//frameSize ="4.5%,4.5%,5.5%,*";

				frameSize ="4.5%,5.75%,6.15%,*"; //6.8%,6.8%,9.5%,*
				iFrameSize0		= "height:7vh;width:100vw;display:none";
				iFrameSize1		= "height:7vh;width:100vw";
				iFrameSize2		= "height:7vh;width:100vw";
				iFrameSize3		= "height:75vh;width:100vw";
				}
				//URL = "../../eCommon/html/blank.html";
			}else{
				if(tab_menu_yn.equals("Y")) {
					//frameSize = "10%,8%,4.5%,*";
				frameSize = "0%,0%,5.5%,*";
				iFrameSize0		= "height:0vh;width:100vw";
				iFrameSize1		= "height:0vh;width:100vw";
				iFrameSize2		= "height:7vh;width:100vw";
				iFrameSize3		= "height:91vh;width:100vw";
				
				}
				else
				{
						frameSize ="0%,0%,4.5%,*";
						iFrameSize0		= "height:0vh;width:100vw";
						iFrameSize1		= "height:0vh;width:100vw";
						iFrameSize2		= "height:7vh;width:100vw";
						iFrameSize3		= "height:91vh;width:100vw";
						
				}
					
					urlForTitleFrame = "../../eCA/jsp/PatListByLocationTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";
				

			}
	}else if(groupByLocn.equals("N") && groupByEpisode.equals("Y")){
			allowSecondLevel = "N"; 
			 if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM")){
					/*if(RP_chk.equals("Y"))
					{
						frameSize = "4.5%,0%,0%,*";
					}
					else
					{*/
						frameSize = "0%,0%,0%,*";
					iFrameSize0		= "display:none";
					iFrameSize1		= "display:none";
					iFrameSize2		= "display:none";
					iFrameSize3		= "height:88vh;width:100vw";
					//}
					
			}else{
					if(tab_menu_yn.equals("Y")) {
						frameSize = "5.5%,0%,0%,*";
						iFrameSize0		= "height:7vh;width:100vw";
						iFrameSize1		= "display:none";
						iFrameSize2		= "display:none";
						iFrameSize3		= "height:91vh;width:100vw";
					}
					else{ 
						frameSize ="4.5%,0%,0%,*";
						iFrameSize0		= "height:7vh;width:100vw";
						iFrameSize1		= "display:none";
						iFrameSize2		= "display:none";
						iFrameSize3		= "height:91vh;width:100vw";
						}


			}
			URL = "PatListByLocationResult.jsp?"+request.getQueryString();
			url_hid=request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";					
	}
	else
	{
		iFrameSize0		= "display:none";
		iFrameSize1		= "display:none";
		iFrameSize2		= "display:none";
		iFrameSize3		= "height:98vh;width:100vw";
	}
		

%>
<script>
if ("<%=Summary%>"=="Summary")
{
	
	parent.PatCriteriaFr.PatCriteriaFrm.url.value =' <%=url_hid%> ';
}else{
	
	top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value =' <%=url_hid%> ';
}
</script>
<html>
	<head>
<%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<title></title>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	 <%-- <frameset rows="<%=frameSize%>" framespacing='0' id='resultFrameSet'> --%>

<%if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL")){ 
	System.out.println(" Inside PatListByLocationResultMain JSP 317 iFrameSize0 : "+iFrameSize0+" iFrameSize1 : "+iFrameSize1+" iFrameSize2 : "+iFrameSize2+" iFrameSize3 : "+iFrameSize3);
	%>
				<%-- <frame name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCA/jsp/PatListByLocationPatClass.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' frameborder=0 scrolling=no noresize></frame>
				<frame name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize></frame>
				<frame name='LocnResultTitle' id='LocnResultTitle' src='<%//=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize > </frame>
				<frame name='LocnResult' id='LocnResult'  src='<%//=URL%>' frameborder=0 scrolling='auto' noresize></frame> --%>

				<iframe name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCA/jsp/PatListByLocationPatClass.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' frameborder=0 scrolling=no noresize style='<%=iFrameSize0%>'></iframe>
				<iframe name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='<%=iFrameSize1%>'></iframe>
				<iframe name='LocnResultTitle' id='LocnResultTitle' src='<%//=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize style='<%=iFrameSize2%>'> </iframe>
				<iframe name='LocnResult' id='LocnResult'  src='<%//=URL%>' frameborder=0 scrolling='auto' noresize style='<%=iFrameSize3%>'></iframe>
				
<%}else{
	System.out.println(" Inside PatListByLocationResultMain JSP 330 iFrameSize0 : "+iFrameSize0+" iFrameSize1 : "+iFrameSize1+" iFrameSize2 : "+iFrameSize2+" iFrameSize3 : "+iFrameSize3);
%>
			<%-- <frame name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize></frame>
			<frame name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize></frame>
			<frame name='LocnResultTitle' id='LocnResultTitle' src='<%=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize > </frame>
			<frame name='LocnResult' id='LocnResult'  src='<%=URL%>' frameborder=0 scrolling='auto' noresize ></frame> --%>
			
			<iframe name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='<%=iFrameSize0%>'></iframe>
			<iframe name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='<%=iFrameSize1%>'></iframe>
			<iframe name='LocnResultTitle' id='LocnResultTitle' src='<%=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize style='<%=iFrameSize2%>'> </iframe>
			<iframe name='LocnResult' id='LocnResult'  src='<%=URL%>' frameborder=0 scrolling='auto' noresize style='<%=iFrameSize3%>'></iframe>
<%}%>
	<!-- </frameset> -->
</html>

