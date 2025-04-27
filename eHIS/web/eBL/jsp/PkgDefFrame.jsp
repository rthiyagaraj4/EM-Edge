<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
		String bean_id1			= "bl_PkgDefCustBean" ;
		String bean_name1		= "eBL.PkgDefCustBean";
		PkgDefCustBean bean1	= (PkgDefCustBean)getBeanObject( bean_id1, bean_name1, request ) ;//comment this and send patch to yoga
		//Added By Shikha For GHL-CRF-0520.1
		String bean_id2			= "bl_PkgDefBlngGrpBean" ;
		String bean_name2		= "eBL.PkgDefBlngGrpBean";
		PkgDefBlngGrpBean bean2	= (PkgDefBlngGrpBean)getBeanObject( bean_id2, bean_name2, request ) ;
		//Ended By Shikha For GHL-CRF-0520.1
		String params = request.getQueryString();
		String from	= request.getParameter("from")== null ? "PACKAGE" : request.getParameter("from"); 
		String rowS = "26%,16%,4%,54%,0%";
		if(from.equals("CUSTOMER"))
		rowS = "9%,19%,18%,4%,52%,0%";
		else if(from.equals("BILLINGGROUP")) //Added By Shikha For GHL-CRF-0520.1
			rowS = "9%,19%,18%,4%,52%,0%";
		else if(from.equals("DISCOUNT"))
		rowS = "9%,46%,45%";		
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefDiscount.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        <% if(from.equals("PACKAGE")){%>
		    <iframe name='PkgDefHeader' id='PkgDefHeader'	src="PkgDefHeader.jsp?<%=params%>"  frameborder=0 scrolling='auto' noresize style='height:26vh;width:100vw'></iframe>
			<iframe name='PkgDefBaseDateMain' id='PkgDefBaseDateMain'	src="PkgDefBaseDateMain.jsp?<%=params%>"  frameborder=0 scrolling='no' noresize style='height:16vh;width:100vw' ></iframe>
			<iframe name='PkgDefTabFrame' id='PkgDefTabFrame'	src="PkgDefTab.jsp?<%=params%>"  frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>

			<iframe name='PkgDefDetailFrame' id='PkgDefDetailFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:54vh;width:100vw'></iframe>
		<%}else if(from.equals("BILLINGGROUP")){%>
			<iframe name='PkgDefBlngGrpHeader' id='PkgDefBlngGrpHeader'	src="PkgDefBlngGrpHeader.jsp?<%=params%>"  frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
			<iframe name='PkgDefBlngGrpDtlsFrame' id='PkgDefBlngGrpDtlsFrame'	src="PkgDefBlngGrpDtlsFrame.jsp?<%=params%>"  frameborder=0 scrolling='auto' noresize style='height:19vh;width:100vw'></iframe>
			<iframe name='PkgDefBlngGrpBaseDateMain' id='PkgDefBlngGrpBaseDateMain'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' noresize style='height:18vh;width:100vw'></iframe>
			<iframe name='PkgDefBlngGrpTabFrame' id='PkgDefBlngGrpTabFrame'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
			<iframe name='PkgDefBlngGrpDetailFrame' id='PkgDefBlngGrpDetailFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:52vh;width:100vw'></iframe>	
		  <%}else if(from.equals("CUSTOMER")){%>
			<iframe name='PkgDefCustHeader' id='PkgDefCustHeader'	src="PkgDefCustHeader.jsp?<%=params%>"  frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
			<iframe name='PkgDefCustDtlsFrame' id='PkgDefCustDtlsFrame'	src="PkgDefCustDtlsFrame.jsp?<%=params%>"  frameborder=0 scrolling='no' noresize style='height:19vh;width:100vw'></iframe>
			<iframe name='PkgDefCustBaseDateMain' id='PkgDefCustBaseDateMain'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' noresize style='height:18vh;width:100vw'></iframe>
			<iframe name='PkgDefCustTabFrame' id='PkgDefCustTabFrame'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
			<iframe name='PkgDefCustDetailFrame' id='PkgDefCustDetailFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:52vh;width:100vw'></iframe>
			<%}else if(from.equals("DISCOUNT")){%>
			<iframe name='PkgDefDiscountHeader' id='PkgDefDiscountHeader'	src="PkgDefDiscountHeader.jsp?<%=params%>"  frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
			<iframe name='PkgDefCustDiscountFrame' id='PkgDefCustDiscountFrame'	src="PkgDefCustDiscountMain.jsp?<%=params%>"  frameborder=0 scrolling='no' noresize style='height:46vh;width:100vw'></iframe>
			<iframe name='PkgDefBlngGrpDiscountFrame' id='PkgDefBlngGrpDiscountFrame'	src="PkgDefBlngGrpDiscountMain.jsp?<%=params%>"  frameborder=0 scrolling='no' noresize style='height:45vh;width:100vw'></iframe>
			
		  <%}%>
			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize></iframe>
		
</HTML>

 <%putObjectInBean(bean_id1,bean1,request);
putObjectInBean(bean_id2,bean2,request); //Added By Shikha For GHL-CRF-0520.1
 %>

