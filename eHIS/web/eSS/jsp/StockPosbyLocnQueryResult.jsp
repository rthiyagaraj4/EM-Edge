<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page  import=" eSS.TrayDtlBean, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,webbeans.eCommon.*, java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001  
---------------------------------------------------------------------------------------------------------------
*/ %>  

<html>
	<head>
		<title></title>
		<% 
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>


		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src='../../eSS/js/TrayDtls.js'> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()">
<%
	String owner_store_desc			=		"";
	String curr_store_desc			=		"";
	String group_type				=		request.getParameter( "group_type" ) ;
	String group_code				=		request.getParameter( "group_code" ) ;
	String owner_store_code			=		request.getParameter( "owner_store_code" ) ;
	String curr_store_code			=		request.getParameter( "curr_store_code" ) ;
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	
	//Added by Rabbani #INC no:32068 on 06/12/2012 Starts
	String blocked_qty =  "";
    String total_ster_tray = "";
    String pending_req_qty = "";
    String pending_ack_qty = "";
	String bean_id							=		"trayDtlBean";
	String bean_name						=		"eSS.TrayDtlBean";
	TrayDtlBean bean						=		(TrayDtlBean)getBeanObject( bean_id, bean_name, request ) ;
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn = false; //end  
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//bean.setLanguageId(locale);
	//ends

try{
	String classvalue				=		"";
	String facility_id				=		"";
	facility_id						=		(String) session.getAttribute("facility_id");
	
	group_type						=		CommonBean.checkForNull( group_type,"%" );
	group_code						=		CommonBean.checkForNull( group_code,"%" );
	owner_store_code				=		CommonBean.checkForNull( owner_store_code,"%" );
	curr_store_code					=		CommonBean.checkForNull( curr_store_code,"%" );
	boolean AckForReqyn				            =		false;
	AckForReqyn						            =		bean.getAckReqd();
	String other_store_desc ="";
	String other_store_code = "";
	
	con				= ConnectionManager.getConnection(request);//MMOH-CRF-1661 START
	linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN");  //end 

	
	//Common parameters.
	HashMap sqlMap					=		new HashMap();
	HashMap tray_dtls_data = new HashMap();
	String[]  grouparg = {group_code};
	tray_dtls_data =	bean.fetchRecord("SELECT   owner_store_code, blocked_by, curr_store_code    FROM ss_tray_dtls   WHERE group_code LIKE ?   and blocked_by is not null GROUP BY owner_store_code, blocked_by,curr_store_code",grouparg);
	String i_owner_store_code = CommonBean.checkForNull((String)tray_dtls_data.get("OWNER_STORE_CODE"));
	String i_blocked_by = CommonBean.checkForNull((String)tray_dtls_data.get("BLOCKED_BY"));
	String i_curr_store_code = CommonBean.checkForNull((String)tray_dtls_data.get("CURR_STORE_CODE"));

	//include all the common parameters.
	//sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_STOCK_STATUS_BY_STORE_QUERY"));
	
	//Commented by Rabbani #INC no:32068 on 06/12/2012
	//sqlMap.put( "sqlData"," SELECT   ms.short_desc owner_store_desc,         ms1.short_desc curr_store_desc,         DECODE (sg.group_type,                 'T', 'Tray',                 'S', 'Single',                 'P', 'Soft Pack',                 'E', 'Set') group_type,         st.group_code, owner_store_code,         NVL (curr_store_code, owner_store_code), COUNT (*) total,         SUM (CASE                 WHEN status = 'S' THEN 1                 ELSE 0              END) sterlized,         SUM (CASE                 WHEN status = 'U' THEN 1                 ELSE 0              END) unsterlized,         SUM (CASE                 WHEN status = 'R' THEN 1                 ELSE 0              END) serv_locn, sg.short_desc group_desc    FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg   WHERE st.status <> 'W'     AND st.owner_store_code = ms.store_code     AND NVL (curr_store_code, owner_store_code) = ms1.store_code     AND st.group_code = sg.group_code     AND st.owner_store_code LIKE (?)     AND NVL (curr_store_code, owner_store_code) LIKE (?)     AND sg.group_type LIKE (?)     AND st.group_code LIKE (?)	 AND ms.language_id = ms1.language_id 	 AND ms.language_id = sg.language_id	 AND ms.language_id =?GROUP BY st.group_code,         owner_store_code,         curr_store_code,         ms.short_desc,         ms1.short_desc,         sg.group_type, sg.short_desc");

	 //Added by Rabbani #INC no:32068 on 06/12/2012
	 
   // sqlMap.put( "sqlData"," SELECT   ms.short_desc owner_store_desc,         ms1.short_desc curr_store_desc,         DECODE (sg.group_type,                 'T', 'Tray',                 'S', 'Single',                 'P', 'Soft Pack',                 'E', 'Set') group_type,         st.group_code, owner_store_code,         NVL (curr_store_code, owner_store_code) curr_store_code, COUNT (*) total,         SUM (CASE                 WHEN status = 'S' THEN 1                 ELSE 0              END) sterlized,         SUM (CASE                 WHEN status = 'U' THEN 1                 ELSE 0              END) unsterlized,         SUM (CASE                 WHEN status = 'R' THEN 1                 ELSE 0              END) serv_locn, sg.short_desc group_desc    FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg   WHERE st.status <> 'W'     AND st.owner_store_code = ms.store_code     AND NVL (curr_store_code, owner_store_code) = ms1.store_code     AND st.group_code = sg.group_code     AND st.owner_store_code LIKE (?)     AND NVL (curr_store_code, owner_store_code) LIKE (?)     AND sg.group_type LIKE (?)     AND st.group_code LIKE (?)	 AND ms.language_id = ms1.language_id 	 AND ms.language_id = sg.language_id	 AND ms.language_id =?GROUP BY st.group_code,         owner_store_code,         curr_store_code,         ms.short_desc,         ms1.short_desc,         sg.group_type, sg.short_desc");

   if(i_owner_store_code.equals(i_blocked_by) || i_curr_store_code.equals(i_blocked_by)) {
	   if(linen_applicable_yn){
		   sqlMap.put( "sqlData"," SELECT   ms.short_desc owner_store_desc,         ms1.short_desc curr_store_desc,         DECODE (sg.group_type,                 'T', 'Tray',                 'S', 'Single',                 'P', 'Soft Pack',                 'E', 'Set' , 'L','Linen') group_type,         st.group_code, owner_store_code,         NVL (curr_store_code, owner_store_code) curr_store_code, COUNT (*) total,         SUM (CASE                 WHEN status = 'S' THEN 1                 ELSE 0              END) sterlized,         SUM (CASE                 WHEN status = 'U' THEN 1                 ELSE 0              END) unsterlized,         SUM (CASE                 WHEN status = 'R' THEN 1                 ELSE 0              END) serv_locn, sg.short_desc group_desc    FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg   WHERE st.status <> 'W'     AND st.owner_store_code = ms.store_code     AND NVL (curr_store_code, owner_store_code) = ms1.store_code     AND st.group_code = sg.group_code     AND st.owner_store_code LIKE (?)     AND NVL (curr_store_code, owner_store_code) LIKE (?)     AND sg.group_type LIKE (?)     AND st.group_code LIKE (?)	 AND ms.language_id = ms1.language_id 	 AND ms.language_id = sg.language_id	 AND ms.language_id =?GROUP BY st.group_code,         owner_store_code,         curr_store_code,         ms.short_desc,         ms1.short_desc,         sg.group_type, sg.short_desc");
	   }else{
		   sqlMap.put( "sqlData"," SELECT   ms.short_desc owner_store_desc,         ms1.short_desc curr_store_desc,         DECODE (sg.group_type,                 'T', 'Tray',                 'S', 'Single',                 'P', 'Soft Pack',                 'E', 'Set') group_type,         st.group_code, owner_store_code,         NVL (curr_store_code, owner_store_code) curr_store_code, COUNT (*) total,         SUM (CASE                 WHEN status = 'S' THEN 1                 ELSE 0              END) sterlized,         SUM (CASE                 WHEN status = 'U' THEN 1                 ELSE 0              END) unsterlized,         SUM (CASE                 WHEN status = 'R' THEN 1                 ELSE 0              END) serv_locn, sg.short_desc group_desc    FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg   WHERE st.status <> 'W'     AND st.owner_store_code = ms.store_code     AND NVL (curr_store_code, owner_store_code) = ms1.store_code     AND st.group_code = sg.group_code     AND st.owner_store_code LIKE (?)     AND NVL (curr_store_code, owner_store_code) LIKE (?)     AND sg.group_type LIKE (?)     AND st.group_code LIKE (?)	 AND ms.language_id = ms1.language_id 	 AND ms.language_id = sg.language_id	 AND ms.language_id =?GROUP BY st.group_code,         owner_store_code,         curr_store_code,         ms.short_desc,         ms1.short_desc,         sg.group_type, sg.short_desc");
	   }
    
	}else{
		if(linen_applicable_yn){
			sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_STOCK_STATUS_BY_STORE_QUERY_WITH_BLOCKED_BY_LINEN"));
		}else{
			sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_STOCK_STATUS_BY_STORE_QUERY_WITH_BLOCKED_BY"));

		} 
	}
	

	//Function Parameters
	HashMap funcMap					=		new HashMap();

	//The fields are going to be display
	ArrayList displayFields			=		new ArrayList();

	displayFields.add( "owner_store_desc" );
	displayFields.add( "curr_store_desc" );
	displayFields.add( "group_type"	);
	displayFields.add( "group_desc"	);
	displayFields.add( "total" );
	displayFields.add( "sterlized" );
	displayFields.add( "unsterlized" );
	displayFields.add( "serv_locn" );
	//Added by Rabbani #INC no:32068 on 06/12/2012 Starts
	displayFields.add( "owner_store_code" );  
	displayFields.add( "group_code" );
	displayFields.add( "curr_store_code" );
	if( (! i_owner_store_code.equals(i_blocked_by)) && (! i_curr_store_code.equals(i_blocked_by)) ) {
	displayFields.add( "other_store_desc" );
	displayFields.add( "other_store_code" );
	}
	//ends


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields				=		new ArrayList();
	chkFields.add( owner_store_code);	
	chkFields.add( curr_store_code);	
	chkFields.add( group_type );
	chkFields.add( group_code );
	chkFields.add( locale );
	
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,12);
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
		<th><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.TotalTray(s).label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Sterilized.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Unsterilized.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.InServiceLocation.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.PendingReqQty.label" bundle="${ss_labels}"/></th>
		<% if(AckForReqyn){%><!--Added by Rabbani #INC no:32068 on 06/12/2012-->
		<th><fmt:message key="eSS.UnderAcknowledgement.label" bundle="${ss_labels}"/>
		 <!-- <th><fmt:message key="eSS.PendingAcknowledgement.label" bundle="${ss_labels}"/> -->
		<th>Pending Ack. Confirmation</th> <!--Legend changed against PMG2014-CRF-0008 -->
		<%}%>
		
		
	<%
		//Retriving the records from result arraylist
		ArrayList records			=		new ArrayList();
		owner_store_desc			=		"";
		curr_store_desc				=		"";
		for(int recCount=2; recCount<result.size(); recCount++)
		{
			records=(ArrayList) result.get( recCount );
			
			if( !owner_store_desc.equals((String)records.get(0)) ) {
				owner_store_desc	=	(String)records.get(0) ;
				out.println("<tr><td class='ITEMSELECT'  colspan='9'><b>Owner Store: "+owner_store_desc+"</b></td></tr>");
			}

			if( (! i_owner_store_code.equals(i_blocked_by)) && (! i_curr_store_code.equals(i_blocked_by)) ) {
				if( !other_store_desc.equals(CommonBean.checkForNull((String)records.get(11))) ) {
					other_store_desc		=	CommonBean.checkForNull((String)records.get(11),"") ;
					other_store_code	= CommonBean.checkForNull((String)records.get(12));
					if(!other_store_code.equals("") ) {
						out.println("<tr><td class='ITEMSELECT'  colspan='9'><b>Other Store: "+other_store_desc+"</b></td></tr>");
					}
				}
			}

			if( !curr_store_desc.equals((String)records.get(1)) ) {
				curr_store_desc		=	(String)records.get(1) ;
				out.println("<tr><td class='ITEMSELECT'  colspan='9'><b>Current Store: "+curr_store_desc+"</b></td></tr>");
			}

			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
				
				//Added by Rabbani #INC no:32068 on 06/12/2012 Starts
				owner_store_code	= CommonBean.checkForNull((String)records.get(8));
				group_code			= CommonBean.checkForNull((String)records.get(9));
				curr_store_code		= CommonBean.checkForNull((String)records.get(10));
				
				if( (! i_owner_store_code.equals(i_blocked_by)) && (! i_curr_store_code.equals(i_blocked_by)) ) {
					
					blocked_qty			=  bean.getBlockedQty(owner_store_code,group_code,other_store_code);
				}else{
					blocked_qty			=  bean.getBlockedQty(owner_store_code,group_code,curr_store_code);
					}
				
				total_ster_tray     = CommonBean.checkForNull((String)records.get(5)); 
		
				//int new_total_ster_tray	= Integer.parseInt(total_ster_tray)-Integer.parseInt(blocked_qty); Comented for  Bru-HIMS-CRF-435

				pending_ack_qty			=  bean.getPendingAcknowledgeQty(owner_store_code,group_code,curr_store_code);
				pending_req_qty			=  bean.getPendingRequestQty(curr_store_code,group_code);
	%>
			<tr>
				<td class="<%=classvalue%>" ><%=records.get(2)%></td>
				<td class="<%=classvalue%>" ><%=records.get(3)%></td>				
				<td class="<%=classvalue%>" ><%=records.get(4)%></td>
				
				<td class="<%=classvalue%>" ><%=records.get(5)%></td>
				<td class="<%=classvalue%>" ><%=records.get(6)%></td>
				<td class="<%=classvalue%>"><%=records.get(7)%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull(pending_req_qty)%></td>
	<% if(AckForReqyn){%>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull(blocked_qty)%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull(pending_ack_qty)%></td>
	<%}%>
			</tr> 
	<%
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
		 <script>	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eSS/jsp/StockPosbyLocnQueryResult.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
finally{
	if(con != null)
			ConnectionManager.returnConnection(con,request);//END
}
%>
</body>
</html>

