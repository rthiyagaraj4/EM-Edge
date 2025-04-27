<!--<!DOCTYPE html>-->
 <%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<title><fmt:message key="eST.ManufacturingFormulary.label" bundle="${st_labels}"/> </title>
	<%
	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eST/js/AssemblyDetail.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String classvalue="";
	String item_code = request.getParameter("item_code");
	String prep_type = request.getParameter("prep_type");
	String prep_mode = request.getParameter("prep_mode");
	String process_loss_percent = request.getParameter("process_loss_percent");
	String item = request.getParameter("item");
	String baseqty = request.getParameter("baseqty");
	String stock_uom_desc = request.getParameter("stock_uom_desc");
	
	ArrayList recordSet		= new ArrayList();
	HashMap hmRecord=new HashMap();
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean)getBeanObject( "ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean" , request );
	bean.setLanguageId(locale);
	bean.setItem_code(item_code);
	bean.getDtlData();
	recordSet=bean.getDataModifyList();

	  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	  String dflt_mfg_mode		=	 bean.checkForNull(request.getParameter("dflt_mfg_mode"),"R");
	  if(dflt_mfg_mode.equals("D")){
		/*if (prep_type.equals("P"))
			prep_type		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PrePacking.label","st_labels");
		else if (prep_type.equals("S"))
			prep_type		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StandardFormulary.label","st_labels");
		else if(prep_type.equals("E"))
			prep_type		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Extemporaneous.label","st_labels");
		else
			prep_type		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");*/
	  
		if (prep_mode.equals("S"))
			prep_mode	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Sterile.label","st_labels");
		else if (prep_mode.equals("N"))
			prep_mode	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonSterile.label","st_labels");
		 else
		 prep_mode	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
		 
		 }
		   //ends
		 
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
	   String ACC_ENTITY_ID = "ZZ";
	   HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
		
	    String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
	    String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
	    String prep_extemp   =   bean.checkForNull((String)hmTemp.get("PREP_EXTEMP_LG"));
	    String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
	    
	    if(prep_prepack.equals("") && prep_standard.equals("") && prep_extemp.equals("") && prep_others.equals("") ){
	   	 
	   	    prep_prepack  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PrePacking.label","st_labels");
	       prep_standard = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StandardFormulary.label","st_labels");
	        prep_extemp   = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Extemporaneous.label","st_labels");
	        prep_others   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	    }
	    if (prep_type.equals("P"))
			prep_type		=		prep_prepack;
		else if (prep_type.equals("S"))
			prep_type		=		prep_standard;
		else if(prep_type.equals("E"))
			prep_type		=		prep_extemp;
		else
			prep_type		=		prep_others;
	  
   //ends

	%>
	<body scroll = "yes" >
	<form name='AssemblyDetailResultForm' id='AssemblyDetailResultForm' method='post' >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
	<tr>
		<td colspan=6 >&nbsp;</td>
	</tr>
	<tr>
		<td  class="label" > <fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</td>
		<td   class="QUERYDATA" > &nbsp;<%=bean.checkForNull(item,"")%></td>
		<td  class="label" > <fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/>&nbsp;</td>
		<td   class="QUERYDATA" nowrap>&nbsp;<%=bean.checkForNull(stock_uom_desc,"")%>&nbsp;&nbsp;</td>
		<td  class="label" > <fmt:message key="eST.BaseQuantity.label" bundle="${st_labels}"/>&nbsp;</td>
		<td  class="QUERYDATA" >&nbsp;<%=bean.checkForNull(baseqty,"")%>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/>&nbsp;</td>
		<td  class="QUERYDATA">&nbsp;<%=bean.checkForNull(prep_type,"")%></td>
		<td  class="label"><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/>&nbsp;</td>
		<td  class="QUERYDATA">&nbsp;<%=bean.checkForNull(prep_mode,"")%>&nbsp;&nbsp;</td>
		<td  class="label"><fmt:message key="eST.ProcessLoss.label" bundle="${st_labels}"/>%&nbsp;</td>
		<td  class="QUERYDATA">&nbsp;<%=bean.checkForNull(process_loss_percent,"")%>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td colspan='6' >&nbsp;</td>
	</tr>
	</table>
	<table border='1' cellpadding=0 cellspacing=0 width='100%' id='tb1' align=center>

	<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eST.MFGUOM.label" bundle="${st_labels}"/></th>
	<th><fmt:message key="Common.Component.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th>
	<%
	int i=0;
	for	(i	=0;	i<recordSet.size();i++){
		hmRecord	=(HashMap)	recordSet.get(i);
		//bean.initialize(hmRecord);
		
		classvalue	=	((i%2)==0)?"QRYODD":"QRYEVEN";
	%>
	<tr>
		<td class="<%=classvalue%>"    nowrap><font size=1><%=(String)hmRecord.get("CHILD_ITEM_CODE")%></font></td>
		<td class="<%=classvalue%>"    nowrap><font size=1><%=(String)hmRecord.get("SHORT_DESC")%></font></td>
		<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity.				
					-->
		<td class="<%=classvalue%>"    nowrap style="TEXT-ALIGN:right"><font size=1><%=(String)hmRecord.get("COMPONENT_QTY")%></font>&nbsp;</td>
		<td class="<%=classvalue%>"    nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_DESC"),"&nbsp;")%></font></td>
		<td class="<%=classvalue%>"   nowrap><font size=1><%if(((String)hmRecord.get("COMPONENT")).equals("Y")){%><img  src='../../eCommon/images/enabled.gif'></img><%}else{%><img  src='../../eCommon/images/disabled.gif'></img><%}%></td>
		<td class="<%=classvalue%>"   nowrap><%if(((String)hmRecord.get("MANDATORY")).equals("Y")){%><img  src='../../eCommon/images/enabled.gif'></img><%}else{%><img  src='../../eCommon/images/disabled.gif'></img><%}%></td>
	</tr>
	<%
	}
	%>
	</table>
	<input type=hidden name="totalRecords" id="totalRecords"  value="<%=recordSet.size()%>">
	</form>
	</center>
	<%
putObjectInBean("ManufacturingReceiptsBean",bean,request);
%>
	</body>
	</html>

