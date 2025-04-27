<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eBL.* " %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<%	   

	String params = request.getQueryString();
	String bean_id			= "bl_PkgDefBean" ;
	String bean_name		= "eBL.PkgDefBean";
	PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clearBean();
	String bean_id1			= "bl_PkgDefCustBean" ;
	String bean_name1		= "eBL.PkgDefCustBean";
	PkgDefCustBean bean1			= (PkgDefCustBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.clearBean();
	String bean_id2			= "bl_PkgDefDiscountBean" ;
	String bean_name2		= "eBL.PkgDefDiscountBean";
	PkgDefDiscountBean bean2			= (PkgDefDiscountBean)getBeanObject( bean_id2, bean_name2, request ) ;
	bean2.clearBean();
	//Added By Shikha For GHL-CRF-0520.1
	String bean_id3			= "bl_PkgDefBlngGrpBean" ;
	String bean_name3		= "eBL.PkgDefBlngGrpBean";
	PkgDefBlngGrpBean bean3	= (PkgDefBlngGrpBean)getBeanObject( bean_id3, bean_name3, request ) ;
	bean3.clearBean();		
	//Ended By Shikha For GHL-CRF-0520.1
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	String packageCode		=	request.getParameter("packageCode")==null?"":request.getParameter("packageCode");
	String pkgApprovedYN = bean.packageApprovedYN(packageCode,facilityId);
	pkgApprovedYN = pkgApprovedYN == null ?"N":pkgApprovedYN;
	String isUserCanAcess	= (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	String mode				= request.getParameter("mode") == null ?"insert" :request.getParameter("mode");		
%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefDiscount.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%if((isUserCanAcess.equals("Y") && mode.equals("insert")) || mode.equals("modify") )  {%>
		<iframe name='PkgDefMainTab' id='PkgDefMainTab'	src='PkgDefMainTab.jsp?<%=params%>&pkgApprovedYN=<%=pkgApprovedYN%>'  frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>

		<iframe name='PkgDefDetailMainFrame' id='PkgDefDetailMainFrame'		src='PkgDefFrame.jsp?<%=params%>&pkgApprovedYN=<%=pkgApprovedYN%>' frameborder=0 noresize scrolling='no' noresize style='height:96vh;width:100vw'></iframe>
		
		<%}
		else
		{%>
		 <script>alert(getMessage("BL8662",'BL'));</script>
		<%}%>
</HTML>
 <%

 putObjectInBean(bean_id1,bean1,request);
 putObjectInBean(bean_id2,bean2,request);
 putObjectInBean(bean_id3,bean3,request); //Added By Shikha For GHL-CRF-0520.1
 %>

