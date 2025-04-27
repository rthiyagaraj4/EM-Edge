<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
---------------------------------------------------------------------------------------------------------
1/7/2021  		TFS:19249        Shazana                      				ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------
*/
%>
 
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@	page import="eSS.*, eSS.Common.* ,java.util.*,java.sql.*, eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<title></title>
		
<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");

		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/TrayDtls.js"> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()">
<%
	String group_desc				=		"";
	String group_type				=		request.getParameter( "group_type" ) ;
	String group_code				=		request.getParameter( "group_code" ) ;
	String tray_no					=		request.getParameter( "tray_no" ) ;
	String owner_store_code			=		request.getParameter( "owner_store_code" ) ;
	String curr_store_code			=		request.getParameter( "curr_store_code" ) ;
	String status					=		request.getParameter( "status" ) ;
	String expiry_date				=		request.getParameter( "expiry_date" ) ==null?"":request.getParameter( "expiry_date" );

	boolean searched				=		(request.getParameter("searched") == null) ?false:true;

try{
	String classvalue				=		"";
	String facility_id				=		"";
	facility_id						=		(String) session.getAttribute("facility_id");
	
	group_type						=		CommonBean.checkForNull( group_type,"%" );
	group_code						=		CommonBean.checkForNull( group_code,"%" );
	tray_no							=		CommonBean.checkForNull( tray_no,"%" );
	owner_store_code				=		CommonBean.checkForNull( owner_store_code,"%" );
	curr_store_code					=		CommonBean.checkForNull( curr_store_code,"%" );
	status							=		CommonBean.checkForNull( status,"%" );
	//expiry_date					=		CommonBean.checkForNull( expiry_date,"%");
	if(!(locale.equals("en")))
		{
					 expiry_date	=		com.ehis.util.DateUtils.convertDate(expiry_date,"DMY",locale,"en");
								 
		}
	HashMap sqlMap					=		new HashMap();
	
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn=false; 
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN");    
		if(linen_applicable_yn){
			sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_STORE_TRAY_DTL_LINEN_CRITERIA"));
		}else{
			sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_STORE_TRAY_DTL_CRITERIA"));

		}//end 
	}
	catch(Exception e){
		e.printStackTrace();
		// System.out.println("Exception in TrayDtlsQueryResult.jsp");  
	}
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
	
	
	//Function Parameters
	HashMap funcMap					=		new HashMap();

	//The fields are going to be display
	ArrayList displayFields			=		new ArrayList();

	displayFields.add( "group_desc"	);
	displayFields.add( "tray_no"	);
	displayFields.add( "owner_store_desc" );
	displayFields.add( "curr_store_desc" );
	displayFields.add( "bin_location_desc" );
	displayFields.add( "expiry_date" );
	displayFields.add( "status" );
	displayFields.add( "group_type" );

	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields				=		new ArrayList();

	chkFields.add( facility_id );
	chkFields.add( group_type );
	chkFields.add( group_code );
	chkFields.add( tray_no);
	chkFields.add( owner_store_code);	
	chkFields.add( curr_store_code);	
	chkFields.add( status);	
	chkFields.add( expiry_date);	
	chkFields.add( locale);	
	chkFields.add( locale);	
	
	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
	//out.println((String) result.get(0));
	if( (result.size()>0) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	<%
		//Retriving the records from result arraylist
		ArrayList records		=		new ArrayList();
		group_desc				=		"";
		for(int recCount=2; recCount<result.size(); recCount++)
		{
			records=(ArrayList) result.get( recCount );
			String exp_date_disp	=	(String)records.get(5);
				if(exp_date_disp==null)exp_date_disp="";

				  if(!(locale.equals("en")))
				{
					 exp_date_disp		=	com.ehis.util.DateUtils.convertDate(exp_date_disp,"DMY","en",locale);
					 if(exp_date_disp==null)exp_date_disp="";
					 
				}
			if( !group_desc.equals((String)records.get(0)) ) {
				group_desc		=		(String)records.get(0) ;
				out.println("<tr><td class='ITEMSELECT'  colspan='7'><b>"+group_desc+"</b></td></tr>");
			}

			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr>
				<td class="<%=classvalue%>" ><%=records.get(7)%></td>
				<td class="<%=classvalue%>"><%=records.get(1)%></td>
				<td class="<%=classvalue%>"><%=records.get(2)%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
				<td class="<%=classvalue%>"><%=records.get(4)%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull(exp_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>"><%=records.get(6)%></td>
			</tr> 
	<%
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
		 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
		</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eSS/jsp/TrayDtlsQueryResult.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
</body>
</html>

