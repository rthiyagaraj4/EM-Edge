<!DOCTYPE html>
 <%@  page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>

 <!-- The following changes are done for Internationalisation Process
Added by Manivel Natarajan on 10/Aug/2006
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  <%
	String frame_size = "" /*,extra_frame="N"*/ ;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String style_frame_21 = "", style_frame_22 = "";
    //The following changes are done for Internationalisation Process
    //Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
   try
   {
		//con = (Connection) session.getValue("connection" );
		con	=	ConnectionManager.getConnection(request);
		String non_ins_settlement_ind ="";
		String credit_doc_yn="";
		

		//unused variable, commented on 09/06/05
		//String non_ins_adm_flag ="";
		//String slmt_type_code="", cash_slmt_flag="";

//		System.out.println("Inside 7:"+(String)request.getParameter("billing_group"));
		String non_insur_blng_grp= request.getParameter("non_insur_blng_grp");
		if( non_insur_blng_grp == null) non_insur_blng_grp="";
		

		String sql="select settlement_ind, adm_rec_flag,credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = ? ";
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "N";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		//out.println("sql :"+sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, non_insur_blng_grp);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				non_ins_settlement_ind = rs.getString("settlement_ind");
				credit_doc_yn=rs.getString("credit_doc_ref_reqd_yn");
				//unused variable, commented on 09/06/05
				//non_ins_adm_flag = rs.getString("adm_rec_flag");

			}
		}
		if (rs != null)   rs.close();
		pstmt.close();
		if(!(non_ins_settlement_ind.equals("C")))
		{
			frame_size = "100%,0%";//frame_size = "97%,03%";
			style_frame_21 = "height:88vh;width:100%;";
			style_frame_22 = "height:0vh;width:100%;";

		}
		else if(non_ins_settlement_ind.equals("C"))
		{
			if(credit_doc_yn.equals("Y"))
			{
				frame_size = "85%,15%";	
				style_frame_21 = "height:88vh;width:100%;";
				style_frame_22 = "height:5vh;width:100%;";
			}
			else
			{
				frame_size = "50%,50%";//frame_size = "35%,65%";
				style_frame_21 = "height:45vh;width:100%;";
				style_frame_22 = "height:50vh;width:100%;";
			}
		}

	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	
	%>

<html>
	<head>
	<script>
	
	</script>
		<title><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></title>
		<!--
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
			-->
			<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

			<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--The following changes are done for Internationalisation Process
Commented by Manivel Natarajan on 10/Aug/2006 -->
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->

			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>

<!-- <FRAMESET ROWS="<%=frame_size%>" framespacing=0>-->
<%
	String billing_mode = request.getParameter("billing_mode");
	if(billing_mode==null) billing_mode = "Add";

	String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

	String rtn_non_ins_inst_ref="";

	String reset_blng_grp=request.getParameter("reset_blng_grp");
	if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
	if(reset_blng_grp.equals("YES")) 
	{
//		session.removeAttribute("financial_details");
		billing_mode="Add";
		operation="Insert";
	}

	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			rtn_non_ins_inst_ref=((String)bl_data.get("non_ins_inst_ref")).trim();

		}

//	String cash_insmt_ref2 = request.getParameter("cash_insmt_ref2");
	String cash_insmt_ref2 = rtn_non_ins_inst_ref;
	if(cash_insmt_ref2==null) cash_insmt_ref2="";
%>
<!-- This JSP is going to be modified for billing_mode = Modify  -->
	<!-- <FRAME SRC='AddModifyPatFinDetails3.jsp?<%=request.getQueryString()%>' name='frame21' frameborder=0 scrolling='auto' noresize> -->
	<iframe SRC='AddModifyPatFinDetails3.jsp?<%=request.getQueryString()%>' name='frame21' id='frame21'  frameborder=0 style=<%=style_frame_21%> scrolling='auto' noresize></iframe>
<%
	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
		if(!(cash_insmt_ref2.equals("")))
		{
%>
			<!-- <FRAME SRC='AddModifyPatFinDetails8.jsp?<%=request.getQueryString()%>' frameborder=0 name='frame22' scrolling='no' noresize>-->
			<iframe SRC='AddModifyPatFinDetails8.jsp?<%=request.getQueryString()%>' frameborder=0 name='frame22' id='frame22' style=<%=style_frame_22%> scrolling='no' noresize></iframe>
<%	
		}

	}
	//else
	//{
%>
		<!-- <FRAME SRC='../../eCommon/html/blank.html' frameborder=0 name='frame22' id='frame22' scrolling='no' noresize>-->
		<iframe SRC='../../eCommon/html/blank.html' frameborder=0 name='frame22' id='frame22' style=<%=style_frame_22%> scrolling='no' noresize></iframe>
<%
	//}
%>
	
</FRAMESET>  
</html>

