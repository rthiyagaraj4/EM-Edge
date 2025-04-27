<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	String facility_id		=	(String) session.getValue("facility_id");
	String sec_hdg_code=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	int		rowCnt					=	0 ;
	String reslnk_rec_type = "";
	String main_type = "";
	String main_type_desc = "";
	String sub_type = "";
	String sub_type_desc = "";
	String classValue = "";
	String reslnk_rec_type_prev = "";
	//String str_qry = "";
	String rec_type_desc = "";

%>
 <!-- <modifeid by Arvind @06-12-2008> -->
	
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCA/js/Section.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
		<base target="_self"></base>
		</head>
		<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
		<form name="MultiResCatDet_form" id="MultiResCatDet_form" action="../../servlet/eCA.SectionServlet" method="post" target="messageFrame">

	<%
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs   = null;
		ResultSet rs1   = null;
		
		//String details_qry ="select sr.RESULT_LINKED_REC_TYPE,si.SHORT_DESC REC_TYPE_DESC,sr.MAIN_TYPE,sr.SUB_TYPE from CA_SECTION_RESULT_CAT  sr,CR_HIST_REC_TYPE si where sr.RESULT_LINKED_REC_TYPE = si.HIST_REC_TYPE and sr.SEC_HDG_CODE= ? and sr.ADDED_FACILITY_ID= ? order by 1 ";
		String details_qry ="select sr.RESULT_LINKED_REC_TYPE,si.SHORT_DESC REC_TYPE_DESC,sr.MAIN_TYPE,case when sr.RESULT_LINKED_REC_TYPE in ('CLNT') then ca_get_desc.CA_NOTE_GROUP(sr.MAIN_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('RXIN','DIET','LBIN','MEDN','RDIN','PTCR','SUNT','TRET') then or_get_desc.OR_ORDER_type(sr.MAIN_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('ALGY') then mr_get_desc.MR_ADV_EVENT_TYPE(sr.MAIN_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('DIAG') then sr.MAIN_TYPE when sr.RESULT_LINKED_REC_TYPE in ('BLTF','NBDT') then 'ALL' end main_desc, sr.SUB_TYPE, case when sr.RESULT_LINKED_REC_TYPE in ('CLNT') then ca_get_desc.CA_NOTE_TYPE(sr.SUB_TYPE,?,1)  when sr.RESULT_LINKED_REC_TYPE in ('RXIN','DIET','LBIN','MEDN','RDIN','PTCR','SUNT','TRET') then or_get_desc.OR_ORDER_CATALOG (sr.SUB_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('ALGY','BLTF','FEVT','NBDT') then 'ALL' when sr.SUB_TYPE in ('ALL') then 'ALL' end sub_desc from CA_SECTION_RESULT_CAT  sr,CR_HIST_REC_TYPE si where sr.RESULT_LINKED_REC_TYPE = si.HIST_REC_TYPE and sr.SEC_HDG_CODE= ? and sr.ADDED_FACILITY_ID= ? order by 1 ";
		try
		{

			con = ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(details_qry);
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale);
			stmt.setString(6,sec_hdg_code);
			stmt.setString(7,facility_id);
			rs = stmt.executeQuery();
			

			

	%>

	<table class='grid' border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr><td class='columnheader' colspan=4><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td></tr>
	<tr>
	<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
	<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.DeSelect.label" bundle="${ca_labels}"/></td>

	</tr>
   <%
		while(rs.next())
			{
			rowCnt++;

			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
			
			
			
			reslnk_rec_type	= rs.getString("RESULT_LINKED_REC_TYPE")==null?"":rs.getString("RESULT_LINKED_REC_TYPE");
			main_type		= rs.getString("MAIN_TYPE")==null?"":rs.getString("MAIN_TYPE");
			sub_type		= rs.getString("SUB_TYPE")==null?"":rs.getString("SUB_TYPE");
			rec_type_desc		= rs.getString("REC_TYPE_DESC")==null?"":rs.getString("REC_TYPE_DESC");
			main_type_desc		= rs.getString("main_desc")==null?"":rs.getString("main_desc");
			sub_type_desc		= rs.getString("sub_desc")==null?"":rs.getString("sub_desc");

			if(reslnk_rec_type.equals("DIAG"))
			{
			if(sub_type.equals("A"))
				{
					sub_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				}
			else if(sub_type.equals("D"))
				{
					sub_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				}
			else if(sub_type.equals("I"))
				{
					sub_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				}
			}
			if(reslnk_rec_type.equals("FEVT"))
			{
			if(main_type.equals("FR"))
				{
					main_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FutureReferrals.label","ca_labels");
				}
			else if(main_type.equals("FA"))
				{
					main_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FutureAppointments.label","ca_labels");
				}
			else if(main_type.equals("FO"))
				{
					main_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FutureOrders.label","ca_labels");
				}
			}

			
			if(main_type.equals("ALL"))
				{
					main_type_desc ="ALL";
				}

			if(sub_type.equals("ALL"))
				{
					sub_type_desc ="ALL";
				}

			/*else if (reslnk_rec_type.equals("RXIN")||reslnk_rec_type.equals("DIET")||reslnk_rec_type.equals("LBIN")||reslnk_rec_type.equals("MEDN")||reslnk_rec_type.equals("RDIN")||reslnk_rec_type.equals("PTCR")||reslnk_rec_type.equals("SUNT")||reslnk_rec_type.equals("TRET"))
			{
			
			str_qry = "select oc.SHORT_DESC description,or_get_desc.OR_ORDER_CATEGORY(oc.ORDER_CATEGORY,?,1) order_categ_desc from OR_ORDER_CATALOG_LANG_VW oc where ORDER_CATALOG_CODE= ? and oc.LANGUAGE_ID =?";

			stmt1 = con.prepareStatement(str_qry);
			stmt1.setString(1,locale);
			stmt1.setString(2,sub_type);
			stmt1.setString(3,locale);
			rs1 = stmt.executeQuery();

			while(rs.next())
			{
				main_type_desc		= rs.getString("order_categ_desc")==null?"":rs.getString("order_categ_desc");
				sub_type_desc		= rs.getString("description")==null?"":rs.getString("description");

			}


//end
			} */

			
			//out.println("<option value='"+hist_rec_type+"'>"+short_desc+"</option>" );	
			//out.println("<tr><td class=><td></tr>" );	
			if(!reslnk_rec_type.equals(reslnk_rec_type_prev))
			{
			out.println("<tr><td class='CAGROUP' colspan='7'><font size=1>"+rec_type_desc+"</font></td></tr>");
			}
	%>
			
			<tr><td class='gridData'><%=main_type_desc%></td><td class='gridData'><%=sub_type_desc%></td><td class='gridData'><input type='checkbox' name ='select' value ='' onClick="removeRec('<%=sec_hdg_code%>','<%=reslnk_rec_type%>','<%=main_type%>','<%=sub_type%>')" checked ></td></tr>
	<%
		 reslnk_rec_type_prev = reslnk_rec_type ;
		
		}
		if(rs1 != null) rs1.close();
		if(stmt1 != null)stmt1.close();	
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();



		}
		catch(Exception e)
		{

		}
		finally
		{

			if(con!=null)
			ConnectionManager.returnConnection(con, request);
		}
	%>	
	</table>
	<input type=hidden value='<%=sec_hdg_code%>' name='sec_hdg_code'>
	<input type=hidden value='<%=locale%>' name='locale'>
	<input type=hidden value='' name='reslnk_rec_type' id='reslnk_rec_type'>
	<input type=hidden value='' name='main_type' id='main_type'>
	<input type=hidden value='' name='sub_type' id='sub_type'>
	<input type=hidden value='' name='mode' id='mode'>
	</form>
</body>

</html>

