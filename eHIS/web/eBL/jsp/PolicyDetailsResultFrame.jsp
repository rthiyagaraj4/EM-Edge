<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.net.*,java.lang.*,eBL.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<html>
<head>
<title> <%= request.getParameter("title")%></title>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params=request.getQueryString();		
		System.err.println("*********************"+params+"*********************");
		
		String priorityKey=request.getParameter("priorityKey");		
		String episodeId=request.getParameter("episodeId");	
		if(episodeId!=null && !episodeId.equals("") &&  !episodeId.equals("null") )
		{		
		String prevEpiID= (session.getAttribute("PREV_EPI_ID_SESS_REF")==null) ? "" : (String)session.getAttribute("PREV_EPI_ID_SESS_REF");	
		System.err.println(episodeId);
		System.err.println(prevEpiID);
		if(!prevEpiID.equals(episodeId))
			{			
			String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
			String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
			PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, request ) ;
		
			HashMap<String, PolicyInsuranceMasterBean> masterMap = new HashMap<String, PolicyInsuranceMasterBean>();
			masterMap=pol_bean.getMasterMap();
 			System.err.println("Removing Key from Session"+priorityKey);
			System.err.println("Before Removal="+masterMap);
				if( masterMap!=null ){
				masterMap.remove(priorityKey);
				}
			pol_bean.setMasterMap(masterMap);
			System.err.println("After Removal="+pol_bean.getMasterMap());		
			}
		
		/* Sets Current Patient id in session for future Reference  */
		session.setAttribute("PREV_EPI_ID_SESS_REF", episodeId);
		}

	%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<iframe name='PolicyCoverageMain' id='PolicyCoverageMain'	src='CommonPolicyCoverageMain.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:56vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsTab' id='PolicyDetailsTab'	src='CommonPolicyDetailsTab.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='PolicyDetailsPage' id='PolicyDetailsPage'	src='CommonPolicyDetailsInclExcl.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:30vh;width:100vw'></iframe>	
		<iframe name='PolicyDetailsAdd' id='PolicyDetailsAdd'	src='CommonPolicyDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:6vh;width:100vw'></iframe>


</head>

</html>

