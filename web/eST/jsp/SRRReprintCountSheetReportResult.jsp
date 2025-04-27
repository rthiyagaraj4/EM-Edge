<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");

		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		ReprintCountSheetBean bean = (ReprintCountSheetBean)getBeanObject( "ReprintCountSheetBean", "eST.ReprintCountSheetBean",request ) ; 	
		Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
		htFormValues = (Hashtable) htFormValues.get ("SEARCH");
		//boolean searched = (request.getParameter("searched") == null) ?false:true;
%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
			type='text/css' ></link>
			<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
					<script language="JavaScript" src="../../eCommon/js/messages.js"></script> 
		<!--	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		 	<script language="JavaScript" src="../../eST/js/StHeader.js"></script> 
			<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eST/js/SRRReprintCountSheet.js"></script> 
			<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</head>
			<body >
			<form name="SRRReprintCountSheetReportResult" id="SRRReprintCountSheetReportResult" >
			<br>
			
      <%
		try {
			String facility_id=(String)session.getValue("facility_id");
			//String phy_id	  =	request.getParameter("phy_id");
			String cnt_date        = request.getParameter("cnt_date");
		//	String p_item_desc        =request.getParameter("p_item_desc");	
		//	String p_report_id        =request.getParameter("p_report_id");	
			String p_item_code = CommonBean.checkForNull(request.getParameter("p_item_code"),"%");
			String p_st_code = CommonBean.checkForNull(request.getParameter("p_st_code"),"%");
			String p_created_By = CommonBean.checkForNull(request.getParameter("p_created_By"),"%");
			String phy_id = CommonBean.checkForNull(request.getParameter("phy_id"),"%");
			ArrayList alTemp = new ArrayList();
			String []stParameters = {facility_id,cnt_date,p_item_code,p_st_code,p_created_By,phy_id};
			alTemp	=	bean.fetchRecords("SELECT DISTINCT hdr.phy_inv_id, mm.SHORT_DESC store_desc, f_user.appl_user_name,TO_CHAR (param.count_sheet_date, 'DD/MM/YYYY' ) count_sheet_date FROM ST_PHY_INV_HDR hdr, ST_PHY_INV_PARAM param,sm_appl_user f_user,mm_store mm WHERE hdr.facility_id = ? AND param.count_sheet_date BETWEEN NVL (TO_DATE (?,  'dd/mm/yyyy' ), TO_DATE ('01/01/1800', 'dd/mm/yyyy' )) AND NVL (TO_DATE ('', 'dd/mm/yyyy'),TO_DATE ('31/12/5000','dd/mm/yyyy')) AND hdr.item_code LIKE ? AND hdr.store_code LIKE ? AND hdr.added_by_id LIKE ? AND param.phy_inv_id LIKE ? AND param.phy_inv_id = hdr.phy_inv_id AND param.posted_date IS NULL AND hdr.added_by_id = f_user.appl_user_id AND hdr.STORE_CODE = mm.STORE_CODE",stParameters);
		  if(alTemp.size()<=0){
              %>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[2].location.href = "../../eCommon/html/blank.html";
				</script>
		    <%

		  }else{

			%>
	<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1" id="reprint_rep">
				<tr>
			<th  ><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></th>
			<th  ><fmt:message key="Common.CountSheetDate.label" bundle="${common_labels}"/></th>
			<th  ><fmt:message key="Common.Store.label" bundle="${mm_labels}"/></th>
			<th  ><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
				</tr>
		   <%
			String classValue			= "";
			for(int i=0;i<alTemp.size();i++ ){  
			
			if(i%2==0)
		classValue		=	"QRYEVEN";
	else
		classValue		=	"QRYODD";

		   HashMap hmTemp = new HashMap();
			hmTemp = (HashMap)alTemp.get(i);

		String	docdate = com.ehis.util.DateUtils.convertDate((String)hmTemp.get("COUNT_SHEET_DATE"),"DMY","en",locale);
		   %>
		<tr>
		<td class="<%=classValue%>" >
			  <label style="cursor:pointer;color:blue" 
onClick="callReport('<%=(String)hmTemp.get("PHY_INV_ID")%>')" align='center' ><%=(String)hmTemp.get("PHY_INV_ID")%></label></td>
		<td class="<%=classValue%>" align='center'>  <%=docdate%></td>
		<td class="<%=classValue%>"    align='center'>
			    <%=bean.checkForNull((String)hmTemp.get("STORE_DESC"))%></td>
		<td class="<%=classValue%>" align='center' >
			   <%=bean.checkForNull((String)hmTemp.get("APPL_USER_NAME"))%></td>	
         </tr>
        <% } %>
     	</table>
		
		<%
	} 
		
 }catch (Exception exception) {
		
		exception.printStackTrace();
	}
	finally{
	}
%>

<%
putObjectInBean("ReprintCountSheetBean",bean,request);
%>
</form>
</body>
</html>

