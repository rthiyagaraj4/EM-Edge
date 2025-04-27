<!DOCTYPE html>
<%@page import="webbeans.eCommon.*, java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);
%>

<%
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	Connection con = null;

	String allowSecondLevel="Y";
	
	String tab_menu_yn  = (request.getParameter("tab_menu_yn")==null)?"":request.getParameter("tab_menu_yn");
	String groupByLocn		= request.getParameter("groupByMedService");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType		= request.getParameter("encounterType");
	String medServiceCode	= request.getParameter("medServiceCode");
			if(groupByLocn			== null || groupByLocn=="")groupByLocn="N"; 
			if(groupByEpisode		== null || groupByEpisode == "") groupByEpisode ="N";  
			if(locationType			== null || locationType =="") locationType="";
			if(medServiceCode		== null || medServiceCode =="") medServiceCode="";
	String frameSize	= "0,0,0,*";
	String URL			= "";
	String url_hid="";
	
	String urlForTitleFrame="";
	String qryLoctionType	=    request.getParameter("encounterType");
	String qryLoctionCode	=    request.getParameter("medServiceCode");
    String qryViewList	    =    request.getParameter("viewList");
	String qryNoOfDays	    =    request.getParameter("noOfDays");
    String qryPatientId		=	 request.getParameter("patientId");
    String qryQueueId	    =	 request.getParameter("queueId");
    String qryQueueStatus	=	 request.getParameter("queueStatus");
    String qryUnSheduled	=	 request.getParameter("unscheduled_yn");
    String qryPastVisit		=	 request.getParameter("past");
    String qryFromDate1		=	 request.getParameter("from_visit_date");
    String qryDischarge		=	 request.getParameter("discharged");
    String qryFromDate2		=	 request.getParameter("from_discharge_date");
    String qrySortOrder		=	 request.getParameter("sortOrder");
    String qryGroByEpisode	=	 request.getParameter("groupByEpisode");
    String qryGrpByLocn		=	 request.getParameter("groupByMedService");
	String qryCheckedOut   =	 request.getParameter("checked_out");
   	String qryadm_fromdate =  request.getParameter("adm_fromdate");
	String qryadm_todate		=   request.getParameter("adm_todate"); 
	String nationID					=	 request.getParameter("nationID");
	String qryToDate1	=	 request.getParameter("to_visit_date");
    String qryToDate2	=	 request.getParameter("to_discharge_date");
	String attend_practId     =	 request.getParameter("attend_practId");
	String speciality     =	 request.getParameter("speciality");
	String visitType     =	 request.getParameter("visitType");
	
	String iFrameSize0 = "", iFrameSize1 = "", iFrameSize2 = "", iFrameSize3 = "";

			if(qryadm_fromdate	== null || qryadm_fromdate.equals("") )	qryadm_fromdate  ="";
			if(qryadm_todate	== null || qryadm_todate.equals("") )	qryadm_todate  ="";
			if(nationID	== null || nationID.equals("") )	nationID  ="";
			if(qryToDate1	== null || qryToDate1.equals("") )	qryToDate1  ="";
			if(qryToDate2	== null || qryToDate2.equals("") )	qryToDate2  ="";
			if(qryLoctionType	== null || qryLoctionType.equals("") )	qryLoctionType  ="";
			if(qryLoctionCode	== null || qryLoctionCode.equals("") )	qryLoctionCode	=""; 
			if(qryViewList		== null || qryViewList.equals("")	 )	qryViewList	    ="";	 
			if(qryNoOfDays		== null || qryNoOfDays.equals("")	 )	qryNoOfDays	    ="";	  
			if(qryPatientId		== null || qryPatientId.equals("")	 )	qryPatientId	="";	  
			if(qryQueueId	    == null || qryQueueId.equals("")	 )	qryQueueId	 	="";	 
			if(qryQueueStatus	== null || qryQueueStatus.equals("") )	qryQueueStatus  ="";	 
			if(qryUnSheduled	== null || qryUnSheduled.equals("")	 )	qryUnSheduled   ="";	 
			if(qryPastVisit		== null || qryPastVisit.equals("")	 )	qryPastVisit	="";	  
			if(qryFromDate1		== null || qryFromDate1.equals("")	 )	qryFromDate1	="";	  
			if(qryDischarge		== null || qryDischarge.equals("")	 )	qryDischarge    ="";	 
			if(qryFromDate2		== null || qryFromDate2.equals("")	 )	qryFromDate2	="";	  
			if(qrySortOrder		== null || qrySortOrder.equals("")	 )	qrySortOrder	="";
			if(qryGroByEpisode	== null || qryGroByEpisode.equals(""))	qryGroByEpisode ="";
			if(qryGrpByLocn		== null || qryGrpByLocn.equals("")	 )	qryGrpByLocn    ="";
			if(qryCheckedOut	== null || qryCheckedOut.equals("")  )  qryCheckedOut   ="";
			if(attend_practId	== null || attend_practId.equals(""))	attend_practId   ="";
			if(speciality	== null || speciality.equals(""))	speciality    ="";
			if(visitType	== null || visitType.equals(""))	visitType    ="";


    HashMap qryStrHash		  =	 new HashMap();
    qryStrHash.put("LoctionType"		, qryLoctionType  );
    qryStrHash.put("LoctionCode"		, qryLoctionCode  );
    qryStrHash.put("ViewList"			, qryViewList	  ); 
	qryStrHash.put("adm_fromdate",qryadm_fromdate);
	qryStrHash.put("adm_todate",qryadm_todate);
	qryStrHash.put("nationID",nationID);
	qryStrHash.put("PatientId"			, qryPatientId	  ); 
    qryStrHash.put("QueueId"			, qryQueueId	  );
    qryStrHash.put("QueueStatus"		, qryQueueStatus  );
    qryStrHash.put("UnSheduled"			, qryUnSheduled	  );
    qryStrHash.put("PastVisit"			, qryPastVisit	  ); 
    qryStrHash.put("FromDate1"			, qryFromDate1	  ); 
    qryStrHash.put("Discharge"			, qryDischarge	  );
    qryStrHash.put("FromDate2"			, qryFromDate2	  ); 
    qryStrHash.put("SortOrder"			, qrySortOrder	  ); 
    qryStrHash.put("GroByEpisode"		, qryGroByEpisode );
    qryStrHash.put("GroupByMedService"  , qryGrpByLocn    );
	qryStrHash.put("checked_out"        , qryCheckedOut   );
	 qryStrHash.put("ToDate1"    ,	qryToDate1); 
     qryStrHash.put("ToDate2"    ,	qryToDate2);
	 qryStrHash.put("attend_practId"   ,	attend_practId);
	 qryStrHash.put("speciality"   ,	speciality);
	 qryStrHash.put("visitType"   ,	visitType);

		try{
				if(qryLoctionType.equals("Z") || qryLoctionCode.equals("ALL")){
						con = ConnectionManager.getConnection(request);
						String pract_id		= (String)session.getValue("ca_practitioner_id");
						String facility_id	= (String)session.getValue("facility_id");
						// PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash, "ByService");
						PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash, "ByService",locale);

				}else{
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
				out.println("<script>parent.PatCriteriaFr.document.getElementById(\"search\").disabled = false;</script>");
		}
		
		if(groupByLocn.equals("Y") && groupByEpisode.equals("Y")){
				if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && qryLoctionCode.equals("ALL")){
						
				if(tab_menu_yn.equals("Y")) 
					//frameSize = "0%,8%,4.5%,*";
					{
						//frameSize = "0%,8%,4.5%,*";
					iFrameSize0		= "height:0vh;width:100vw;display:none";
					iFrameSize1		= "height:7vh;width:100vw";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					}
				else 
					//frameSize = "0%,6.8%,9.5%,*";
					{
						//frameSize = "0%,8%,8%,*";
					iFrameSize0		= "height:0vh;width:100vw;display:none";
					iFrameSize1		= "height:7vh;width:100vw";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					
					}
					
				}
				else if(locationType.equals("Z")){
					if(tab_menu_yn.equals("Y")) 
						//frameSize = "10%,8%,4.5%,*";
					{
						//frameSize = "5.5%,8%,5.5%,*";
						iFrameSize0		= "height:10vh;width:100vw";
						iFrameSize1		= "height:8vh;width:100vw";
						iFrameSize2		= "height:7vh;width:100vw";
						iFrameSize3		= "height:75vh;width:100vw";
					
					}
					else 
					{	//frameSize ="6.8%,6.8%,9.5%,*";
						//frameSize ="5.5%,8%,8%,*";
						iFrameSize0		= "height:7vh;width:100vw";
						iFrameSize1		= "height:7vh;width:100vw";
						iFrameSize2		= "height:7vh;width:100vw";
						iFrameSize3		= "height:75vh;width:100vw";
						
					}
				//URL = "../../eCommon/html/blank.html";
				}
				else
				{
					if(tab_menu_yn.equals("Y")) 
						//frameSize = "0%,0%,4.5%,*";
					{	frameSize = "0%,0%,8.5%,*";
					iFrameSize0		= "height:0vh;width:100vw;display:none";
					iFrameSize1		= "height:0vh;width:100vw;display:none";
					iFrameSize2		= "height:0vh;width:100vw;display:none";
					iFrameSize3		= "height:75vh;width:100vw";
					
					}
					else
						//frameSize ="0%,0%,9.5%,*";
					{	frameSize ="0%,0%,7.5%,*";
					iFrameSize0		= "height:0vh;width:100vw;display:none";
					iFrameSize1		= "height:0vh;width:100vw;display:none";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					
					}
				urlForTitleFrame = "PatListByMedServicePatTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";
				}
		}
		else if(groupByLocn.equals("N") && groupByEpisode.equals("Y"))
		{
				allowSecondLevel = "N"; 
				 if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM")){
						frameSize = "0%,0%,0%,*";// 0%,0%,0%,*
						iFrameSize0		= "height:0vh;width:100vw;display:none";
						iFrameSize1		= "height:10vh;width:100vw;display:none";
						iFrameSize2		= "height:0vh;width:100vw;display:none";
						iFrameSize3		= "height:90vh;width:100vw";
				
		}
			else
			{
				if(tab_menu_yn.equals("Y")) 
				{frameSize = "5.5%,0%,0%,*";
				iFrameSize0		= "height:7vh;width:100vw";
				iFrameSize1		= "height:0vh;width:100vw;display:none";
				iFrameSize2		= "height:0vh;width:100vw;display:none";
				iFrameSize3		= "height:75vh;width:100vw";
				
				}
					else 
				{		frameSize ="5.5%,0%,0%,*";
				iFrameSize0		= "height:7vh;width:100vw";
				iFrameSize1		= "height:0vh;width:100vw;display:none";
				iFrameSize2		= "height:0vh;width:100vw;display:none";
				iFrameSize3		= "height:75vh;width:100vw";
				}
			}
				URL = "PatListByMedServiceResult.jsp?"+request.getQueryString();
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
top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value =' <%=url_hid%> ';
</script>
	<html>
			<head>
<%
	
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
				<title><fmt:message key="eCA.ViewPatientListbyMedServiceResultMain.label" bundle="${ca_labels}"/></title>
			</head>
		
			<%--  <frameset rows="<%=frameSize%>" framespacing='0' id='resultFrameSet' > --%>

			<%if(qryLoctionType.equals("Z") || qryLoctionCode.equals("ALL")){  %>
			
					<%-- <frame name='MedServResultPatClass' id='MedServResultPatClass' src='PatListByMedServicePatClass.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' frameborder=0 scrolling=no ></frame>
					<frame name='MedServResultLocation' id='MedServResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' ></frame>
					<frame name='MedServResultTitle' id='MedServResultTitle' src='<%//=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' > </frame>
					<frame name='LocnResult' id='LocnResult'  src='<%//=URL%>' frameborder=0 scrolling='auto' ></frame>
					 --%>
					<iframe name='MedServResultPatClass' id='MedServResultPatClass' src='PatListByMedServicePatClass.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' frameborder=0 scrolling=no noresize style='<%=iFrameSize0%>'></iframe>
					<iframe name='MedServResultLocation' id='MedServResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='<%=iFrameSize1%>'></iframe>
					<iframe name='MedServResultTitle' id='MedServResultTitle' src='<%//=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize style='<%=iFrameSize2%>' > </iframe>
					<iframe name='LocnResult' id='LocnResult'  src='<%//=URL%>' frameborder=0 scrolling='auto' noresize style='<%=iFrameSize3%>' ></iframe>
			
					<%-- <iframe name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCA/jsp/PatListByLocationPatClass.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' frameborder=0 scrolling=no noresize style='<%=iFrameSize0%>'></iframe>
					<iframe name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='<%=iFrameSize1%>'></iframe>
					<iframe name='LocnResultTitle' id='LocnResultTitle' src='<%//=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize style='<%=iFrameSize2%>'> </iframe>
					<iframe name='LocnResult' id='LocnResult'  src='<%//=URL%>' frameborder=0 scrolling='auto' noresize style='<%=iFrameSize3%>'></iframe>  --%>
			<%}else { %>
					<%-- <frame name='MedServResultPatClass' id='MedServResultPatClass' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no ></frame>
					<frame name='MedServResultLocation' id='MedServResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' ></frame> 
					<frame name='MedServResultTitle' id='MedServResultTitle' src='<%=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' > </frame>
					<frame name='LocnResult' id='LocnResult'  src='<%=URL%>' frameborder=0 scrolling='auto' ></frame>
			 --%>
					<iframe name='MedServResultPatClass' id='MedServResultPatClass' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no style='<%=iFrameSize0%>' ></iframe>
					<iframe name='MedServResultLocation' id='MedServResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='<%=iFrameSize1%>'></iframe> 
					<iframe name='MedServResultTitle' id='MedServResultTitle' src='<%=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize style='<%=iFrameSize2%>' > </iframe>
					<iframe name='LocnResult' id='LocnResult'  src='<%=URL%>' frameborder=0 scrolling='auto' noresize style='<%=iFrameSize3%>' ></iframe>
			
					<%-- <iframe name='LocnResultPatClass' id='LocnResultPatClass' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='<%=iFrameSize0%>'></iframe>
					<iframe name='LocnResultLocation' id='LocnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='<%=iFrameSize1%>'></iframe>
					<iframe name='LocnResultTitle' id='LocnResultTitle' src='<%=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize style='<%=iFrameSize2%>'> </iframe>
					<iframe name='LocnResult' id='LocnResult'  src='<%=URL%>' frameborder=0 scrolling='auto' noresize style='<%=iFrameSize3%>'></iframe> --%>
			
			
			<%}%>
<!-- 	</frameset> -->
</html>

