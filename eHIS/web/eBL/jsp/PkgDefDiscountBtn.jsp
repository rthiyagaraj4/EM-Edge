<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src='../../eBL/js/PkgDefDiscount.js'></script> 
<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode") ;

	String table_name	   = request.getParameter("table_name") ;
	String bean_id = "Bl_PkgDefBean" ;
	String bean_name = "eBL.PkgDefBean";
	String locale			= (String)session.getAttribute("LOCALE");
	String colNum="";
	String key="";
	String deleteOption="Y";
	
	/* Added V190424-Aravindh/GHL-CRF-0502/Starts */
	boolean siteAgeSpecialty = false;
	Connection con = null;
	try {
		con = ConnectionManager.getConnection();
		siteAgeSpecialty = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_SPECIALITY_APP_FOR_DISC");
	} catch (Exception ex) {
		System.err.println("Error in PkgDefDiscountBtn while getting siteSpec: "+ex);
		ex.printStackTrace();
	}
	/* Added V190424-Aravindh/GHL-CRF-0502/Ends */
	
	if(table_name.equals("blng_grp_discount_tbl")){
		if(siteAgeSpecialty) {//Added V190424-Aravindh/GHL-CRF-0502/if-else condition
			colNum="8";
		} else {			
			colNum="6";
		}
		 key="blng_grp_discount";
		 deleteOption="Y";
	}else if(table_name.equals("cust_discount_tbl")){
		if(siteAgeSpecialty) {//Added V190424-Aravindh/GHL-CRF-0502/if-else condition
			colNum="9";
		} else {
			colNum="7";			
		}
		 key="cust_discount";
		 deleteOption="Y";
	}
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
	
%>

<form name='discount_btn' id='discount_btn'  target='messageFrame' >

<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
<table width='100%' id="discount_btn_tbl">
<tr>
<td>&nbsp;</td>
<td width='20%' align='right'>
<INPUT type="button" class='button'   <%=modifyStatus%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('<%=table_name%>','<%=key%>');" /><%if(deleteOption.equals("Y")){%><input type="button" class="button"	  <%=modifyStatus%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%>" onClick="deleteRowDiscount('<%=table_name%>','<%=colNum%>','');"><%}%></td>

</tr>

 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
  </form>
 </body>
</html>

