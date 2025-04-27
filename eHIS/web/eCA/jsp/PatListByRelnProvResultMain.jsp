<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*, java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);
%><%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String allowSecondLevel="Y" ;
	String groupByReln		= request.getParameter("groupByReln");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType		= request.getParameter("locationType");
	if(groupByReln			== null || groupByReln=="")groupByReln="N"; 
	if(groupByEpisode		== null || groupByEpisode == "") groupByEpisode ="N";  
	if(locationType			== null || locationType =="") locationType="";
	String frameSize		= "0,0,0,*";
	String url_hid="";
	//String URL				= "";

	String urlForTitleFrame="";
	//out.println("<script>alert('main URL : "+request.getQueryString()+"');</script>");
	/** To Pass the QueryString
	 *  Values to the Bean.
	 */ 
	 String qryLoctionType  =    request.getParameter("locationType");
	 String relationshipCode  =    request.getParameter("relationshipCode");
	 String qryPatientId	=	 request.getParameter("patientId");
     String qryQueueId	    =	 request.getParameter("queueId");
     String qryFromDate		=	 request.getParameter("fromDate");
	 String qryToDate		=	 request.getParameter("toDate");
     String qrySortOrder	=	 request.getParameter("sortOrder");
     String qryGroByEpisode =	 request.getParameter("groupByEpisode");
     String qryGrpByReln    =	 request.getParameter("groupByReln");
     String qrycheckedOut    =	 request.getParameter("checkedOut");
     String qrydischarged    =	 request.getParameter("discharged");
     String qrynonencspec    =	 request.getParameter("nonencspec");
	 String attend_practId     =	 request.getParameter("attend_practId");
	 String speciality     =	 request.getParameter("speciality");
	 String visitType		=	 request.getParameter("visitType");

	 if(qryLoctionType		== null || qryLoctionType.equals(""))	qryLoctionType	="";
	 if(relationshipCode	== null || relationshipCode.equals(""))	relationshipCode	="";	    	  
	 if(qryPatientId		== null || qryPatientId.equals(""))		qryPatientId	="";	  
	 if(qryQueueId			== null || qryQueueId.equals(""))		qryQueueId	 	="";	 
	 if(qryFromDate			== null || qryFromDate.equals(""))		qryFromDate	="";	  
	 if(qryToDate			== null || qryToDate.equals(""))		qryToDate	="";	  
	 if(qrySortOrder		== null || qrySortOrder.equals(""))		qrySortOrder	="";
	 if(qryGroByEpisode		== null || qryGroByEpisode.equals(""))	qryGroByEpisode ="";
	 if(qryGrpByReln		== null || qryGrpByReln.equals(""))		qryGrpByReln    ="";
	 if(qrycheckedOut		== null || qrycheckedOut.equals(""))	qrycheckedOut    ="";
	 if(qrydischarged		== null || qrydischarged.equals(""))	qrydischarged    ="";
	 if(qrynonencspec		== null || qrynonencspec.equals(""))	qrynonencspec    ="";
	 if(attend_practId	== null || attend_practId.equals(""))	attend_practId    ="";
	 if(speciality	== null || speciality.equals(""))	speciality    ="";
	 if(visitType	== null || visitType.equals(""))	visitType    ="";

     HashMap qryStrHash			 =	 new HashMap();
     qryStrHash.put("LoctionType"  ,    qryLoctionType  );
     qryStrHash.put("RelationshipCode"  ,    relationshipCode  );
     qryStrHash.put("PatientId"    ,	qryPatientId	); 
     qryStrHash.put("QueueId"      ,	qryQueueId	 	);
     qryStrHash.put("FromDate"    ,	qryFromDate 	); 
     qryStrHash.put("ToDate"       ,    qryToDate		); 
     qryStrHash.put("SortOrder"    ,	qrySortOrder	); 
     qryStrHash.put("GroByEpisode" ,	qryGroByEpisode );
     qryStrHash.put("GrpByReln"    ,	qryGrpByReln    );
     qryStrHash.put("checkedOut"    ,	qrycheckedOut    );
     qryStrHash.put("discharged"    ,	qrydischarged    );
     qryStrHash.put("nonencspec"    ,	qrynonencspec    );
	 qryStrHash.put("attend_practId"   ,	attend_practId);
	 qryStrHash.put("speciality"   ,	speciality);
	 qryStrHash.put("visitType"   ,	visitType);
	 	   
	try{

			if(qryLoctionType.equals("Z") || relationshipCode.equals("ALL")){

				con = ConnectionManager.getConnection(request);
				String pract_id		= (String)session.getValue("ca_practitioner_id");
				String facility_id	= (String)session.getValue("facility_id");
				//String resp_id = (String)session.getValue("responsibility_id");
			    //String user_id = (String)session.getValue("login_user");
				 PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash, "ByPPRelation",locale);
// 				 PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash, "ByPPRelation");

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
			out.println("<script>parent.PatCriteriaFr.document.getElementById(\"search\").disabled = false;</script>");
	}

if(groupByReln.equals("Y") && groupByEpisode.equals("Y")){
			if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && (relationshipCode.equals("ALL"))){
				frameSize = "0%,9%,10%,*";
			}else if(locationType.equals("Z")){
				frameSize ="9%,9%,12%,*";
				//URL = "../../eCommon/html/blank.html";
			}else{
					frameSize ="0%,0%,10%,*";
			//		out.println(qryLoctionType+"   "+relationshipCode);
					urlForTitleFrame = "PatListByRelnProvTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+relationshipCode+"&fromMain=Y";
			}
	}else if(groupByReln.equals("N") && groupByEpisode.equals("Y")){
			allowSecondLevel = "N";
			 if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM")){
		//		 	allowSecondLevel = "Y";
					frameSize = "0%,0%,0%,*";
			}else{
					frameSize ="9%,0%,0%,*";
			}
			//URL = "PatListByLocationResult.jsp?"+request.getQueryString();
			//url_hid=request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+relationshipCode+"&fromMain=Y";
			
	}
	url_hid=request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+relationshipCode+"&fromMain=Y";
			
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
		
			 <frameset rows="<%=frameSize%>" framespacing='0' id='resultFrameSet' >
	
		<%	if(qryLoctionType.equals("Z") || relationshipCode.equals("ALL")){  %>
					<frame name='RelnResultPatClass' id='RelnResultPatClass' src='PatListByRelnProvClass.jsp?<%=request.getQueryString()%>&allowSecondLevel=<%=allowSecondLevel%>' frameborder=0 scrolling=no noresize></frame>
					<frame name='RelnResultLocation' id='RelnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize></frame>
					<frame name='RelnResultTitle' id='RelnResultTitle' src='<%//=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no' noresize></frame>
					<frame name='LocnResult' id='LocnResult'  src='' frameborder=0 scrolling='auto' noresize></frame> 
<%		}else { 		
						%>
					<frame name='RelnResultPatClass' id='RelnResultPatClass'  src='../../eCommon/html/blank.html' frameborder=0 scrolling=no  noresize></frame>
					<frame name='RelnResultLocation' id='RelnResultLocation' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'  noresize></frame>
					<frame name='RelnResultTitle' id='RelnResultTitle' src='<%=urlForTitleFrame%>'  frameborder=0 marginheight=0 marginwidth=0  scrolling='no'  noresize>
					<frame name='LocnResult' id='LocnResult' src='' frameborder=0 scrolling='auto'  noresize></frame>
<%		}	%>
	</frameset>
</html>


