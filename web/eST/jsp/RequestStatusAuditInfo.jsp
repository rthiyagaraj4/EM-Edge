<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
18/6/2022	         	TFS:31394          		Shazana                                 					MO-CRF-20174-US006
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eST.RequestStatusBean, eST.RequestStatusBean,eCommon.XSSRequestWrapper"%>
<%@ page import="eST.RequestStatusDetailBean, eST.RequestStatusDetailBean"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* ,java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> 
		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/RequestStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%

	     Connection conn=null;
	     ResultSet rset=null;	
	    PreparedStatement pstmt=null;
	try{

		String bean_id						=		"RequestStatusBean";
		String bean_name					=		"eST.RequestStatusBean";
		String req_authorized_by_id			=		"";
		//pmd 29/01/05
//		String mode							=		request.getParameter("mode")==null?"":request.getParameter( "mode" ) ;
//		String function_id					=		request.getParameter("function_id")==null?"":request.getParameter( "function_id" ) ;
		String request_status				=		request.getParameter( "request_status" );
		String cancelled_by_id				=		request.getParameter("cancelled_by_id")==null?"":request.getParameter( "cancelled_by_id" ) ;
		String added_by_id					=		request.getParameter( "added_by_id" );
		String modified_by_id				=		request.getParameter( "modified_by_id" );
		String modified_date				=		request.getParameter( "modified_date" );
		String doc_type_desc				=		request.getParameter("doc_type_desc")==null?"":request.getParameter( "doc_type_desc" ) ;
		String doc_no						=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		req_authorized_by_id				=		request.getParameter("req_authorized_by_id")==null?"":request.getParameter( "req_authorized_by_id" ) ;
		String rejected_by_id				=		request.getParameter("rejected_by_id")==null?"":request.getParameter( "rejected_by_id" ) ; //MO-CRF-20174
		

		//Adding start for MO-CRF-20166
		String called_from                  =       request.getParameter("called_from")==null?"":request.getParameter( "called_from" ) ;
		String doc_type_code                =       request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		//Added for ML-BRU-SCF-2222 starts
        String req_on_store_name            =       request.getParameter("req_on_store_name")==null?"":request.getParameter( "req_on_store_name" ) ;
        String req_by_store_code            =       request.getParameter("req_by_store_code")==null?"":request.getParameter( "req_by_store_code" ) ;
        int i=1;

        //if(called_from.equals("ISS_HISTORY")){
	   
			   String sql ="select req_authorized_by_id,cancelled_by_id,REJECTED_BY_ID from st_request_hdr where doc_no =?";//MO-CRF-20174  
                  if(doc_type_code!="")
                  {
                    sql+=" and doc_type_code =?";
                  }
                  if(req_by_store_code !="")
                  {
                    sql+=" and req_by_store_code =?";
                  }
                  if(req_on_store_name !="")
                  {
                    sql+=" and req_on_store_code = (select store_code from mm_store where short_desc=?)";
                  }  
			   conn = ConnectionManager.getConnection(request);
			   pstmt = conn.prepareStatement( sql);
					 pstmt.setString(1,doc_no);
					// pstmt.setString(2,doc_type_code);//MO-CRF-20174
					 if(doc_type_code!="")
                      {
                         pstmt.setString(++i,doc_type_code);
                      }
                     if(req_by_store_code !="")
                       {
                          pstmt.setString(++i,req_by_store_code);
                       }
                     if(req_on_store_name !="")
                       {
                          pstmt.setString(++i,req_on_store_name);
                       }
		 //Added for ML-BRU-SCF-2222 ends
					 rset = pstmt.executeQuery() ;
					 if (rset !=null&& rset.next()){
						 
						req_authorized_by_id = rset.getString(1)==null?"":rset.getString(1);
						cancelled_by_id = rset.getString(2)==null?"":rset.getString(2);
						rejected_by_id = rset.getString(3)==null?"":rset.getString(3);//MO-CRF-20174  
						
					 }
			//}
		if(cancelled_by_id.equals("null"))
			{
				cancelled_by_id				=		"";
			
			}
			//Adding end for MO-CRF-20166
 
	  if(req_authorized_by_id.equals("null"))
	  {
		  req_authorized_by_id				=		"";
			
	  }
	  if(rejected_by_id.equals("null"))
		{
		  rejected_by_id				=		"";
		
		}//MO-CRF-20174  
		RequestStatusBean bean				=		(RequestStatusBean) getBeanObject(bean_id,bean_name, request);  
		bean.setLanguageId(locale);
	%>
	<title><fmt:message key="eST.AuditInformationfor.label" bundle="${st_labels}"/> <%=doc_type_desc%>/<%=doc_no%>&nbsp;&nbsp;</title>
	</head>
	<body >
		<table border="1" cellpadding="0" cellspacing="0" width="100%" height="100%" align="center">
			<tr>			
				<td class="OAQRYODD" align="right"><b><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></b></td>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%=added_by_id %></td>
			</tr>	
			<tr>	
				<td class="OAQRYEVEN" align="right"><b><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></b></td>
				<td class="OAQRYEVEN" align="left">&nbsp;&nbsp;<%=req_authorized_by_id%></td>
			</tr>	
			<tr>	
				<td class="OAQRYODD" align="right"><b><fmt:message key="eST.LastAccessedBy.label" bundle="${st_labels}"/></b></td>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%= modified_by_id%></td>
			</tr>	
			<tr>	
				<td class="OAQRYEVEN" align="right"><b><fmt:message key="eST.LastAccessedOn.label" bundle="${st_labels}"/></b></td>
				<td class="OAQRYEVEN" align="left">&nbsp;&nbsp;<%= com.ehis.util.DateUtils.convertDate(modified_date,"DMY","en",locale)%></td>
			</tr>	
			<tr>	
				<td class="OAQRYODD" align="right"><b><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></b></td>
				
				 
				
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%=request_status %></td>
				
			</tr>
			<tr>	
				<td class="OAQRYODD" align="right"><b><fmt:message key="eST.CancelRequestBy.label" bundle="${common_labels}"/> </b></td>
				<% if(request_status.equals("Force Closed")){ %>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;</td>
				<%}else{%>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%=cancelled_by_id %></td>
				<%}%>
				
			</tr>
			<tr>	<!-- MO-CRF-20174 -->
				<td class="OAQRYODD" align="right"><b><fmt:message key="eST.RejectRequestBy.label" bundle="${st_labels}"/></b></td>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%=rejected_by_id%></td> 
			</tr>	
		</table>
	<%
putObjectInBean(bean_id,bean,request);
		}catch(Exception e){
			e.printStackTrace();

		}finally{
                     if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();

					if (conn != null)
						ConnectionManager.returnConnection(conn, request);
		}
	%>
	</body>
</html>
	

