<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");
	/** added by kishore kumar n on 12/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

		String bean_id = "Or_FutureOrder" ;
		String bean_name = "eOR.FutureOrder";
		
		eOR.FutureOrder bean = (eOR.FutureOrder)getBeanObject( bean_id, bean_name, request  ) ;
		eOR.OrderEntryBillingQueryBean billingbean				= (eOR.OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;

		 		
		 billingbean.clearBean();
		
		 bean.setOrderEntryBillBean(billingbean);

		 putObjectInBean(bean_id,bean,request); 

		// eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean(); 
		 



//java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
//String locale			= (String) p.getProperty("LOCALE");
String facility_id=((String) session.getValue("facility_id")).trim();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String cons_ref_id="";
		String cons_list_desc="";
		String practitionerId="";
		String speciality_code="";
		String catalog="";
		String cons_date="";

		practitionerId = request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId");


		speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		cons_date = request.getParameter("cons_date")==null?"":request.getParameter("cons_date");
		//Added By Archana Dhal on 5/3/2010 related to IN021047.
		cons_date	= com.ehis.util.DateUtils.convertDate(cons_date,"DMY",locale,"en");


%>
<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='IPConsultationListExistingListSelForm' id='IPConsultationListExistingListSelForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>

<tr>
 <td class='label' width='25%'><fmt:message key="eCA.Consults.label" bundle="${ca_labels}"/></td><td class='fields' width='25%'>
 <select name="cons_list" id="cons_list" onchange="consListChange();unloadButtons()" >
	<%
		try
		{
			
			
			con = ConnectionManager.getConnection(request);
			
			String consCatQuery =" select CA_GET_CONS_CATALOG(?,?) catalog from dual";
			pstmt = con.prepareStatement(consCatQuery);
			pstmt.setString(1,practitionerId);
			pstmt.setString(2,speciality_code);
			rset = pstmt.executeQuery();
			 while (rset.next())
			 {
				catalog = rset.getString("catalog")==null?"":rset.getString("catalog");	 
			 }
			
			 if(rset!=null)rset.close();
			 if(pstmt != null)pstmt.close();
			if(!catalog.equals(""))
			{
			
			String  sql = "select CONS_REF_ID,CONS_LIST_DESC from CA_CONS_LIST_HDR where FACILITY_ID=? and PRACTITIONER_ID = ? and CONS_DATE= to_date(?,'dd/mm/yyyy') order by 2 ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,practitionerId);
			pstmt.setString(3,cons_date);
			rset = pstmt.executeQuery();
			
			 while (rset.next())
			 {
				cons_ref_id= rset.getString("CONS_REF_ID")==null?"":rset.getString("CONS_REF_ID");
				cons_list_desc= rset.getString("CONS_LIST_DESC")==null?"":rset.getString("CONS_LIST_DESC");
				
				out.println("<option value="+cons_ref_id+">"+cons_list_desc+"</option>");
			 }
				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();
			}
			else
			{
				//out.println("<script>alert('Consultation catalog is not linked to current practitioner/primary speciality of current practitioner. Contact Admin');</script>");

				out.println("<script>alert(getMessage('NO_CONS_CATALOG','CA'));goNewList();</script>");
			}
		}
		catch(Exception e )
		{
			e.printStackTrace();
			//out.println("Exception caught in IPConsultationListExistListSelect.jsp" + e);//COMMON-ICN-0181
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}

	%>

 </select>
 </td>
 <td class='label' width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td><td class='fields' width='25%' >
 <select name="status" id="status" onchange="unloadButtons()">
	<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value="C"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
	<option value="P"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
 </select>
 </td>
 </tr>
 <tr><td class="label" colspan="3"></td><td class="button" align='right'><INPUT TYPE="button" name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='loadListDet(document.getElementById("status"))'></td></tr>
 </table>
				<!-- added by kishore kumar n on 27/11/2009  -->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
				<!--ends here -->
	<input type='hidden' name='catalog' id='catalog' value="<%=catalog%>">
 </form>
 </html>

