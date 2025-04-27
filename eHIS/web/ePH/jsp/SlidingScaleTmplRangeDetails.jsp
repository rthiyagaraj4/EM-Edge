<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale= (String)session.getAttribute("LOCALE");
       String sStyle=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String )session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
     request.setCharacterEncoding("UTF-8");
	String	mode			=	request.getParameter("mode") ;
	String	bean_id			=	"SlidingScaleTmpl" ;
	String	bean_name		=	"ePH.SlidingScaleTmplBean";
	//String eff_status1 = "E";
	//String informPractitioner = "E";
	String cheked = "";
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */
	/* Initialize Function specific start */
	SlidingScaleTmplBean bean = (SlidingScaleTmplBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	//bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//String facility_id			=		(String)session.getValue( "facility_id" );
	HashMap ht					=		new HashMap();
	ArrayList alDtlRecords		=		new ArrayList();
	alDtlRecords				=		bean.getDtlRecords();
	String to_uom				=       new String("0");	
	String rangeUnite		    =		"";
	String andimUnite		    =		"";
	
	String classValue			=		"";
	        rangeUnite		=		request.getParameter("rangeUOM_desc")==null?"":"( "+request.getParameter("rangeUOM_desc")+" )";
			andimUnite		=		request.getParameter("adminUnitUOM_desc")==null?"":"( "+request.getParameter("adminUnitUOM_desc")+" )";

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			String template_id			= request.getParameter("template_id")==null?"":request.getParameter("template_id");

			/*rangeUnite		=		request.getParameter("rangeUOM_desc")==null?"":request.getParameter("rangeUOM_desc");
			andimUnite		=		request.getParameter("adminUnitUOM_desc")==null?"":request.getParameter("adminUnitUOM_desc");*/

			if(alDtlRecords.size()<=0){
				bean.loadData(template_id);
				alDtlRecords		=		bean.getDtlRecords();
			}
		}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<FORM name="formSlidingScaleTmplRangeDetails" id="formSlidingScaleTmplRangeDetails" id="formSlidingScaleTmplRangeDetail">

	<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
		<tr>
			<th align="left"  class="label"><fmt:message key="ePH.TemplateRangelDetails.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr align="left"> <td align="left">
	  <table cellpadding="0" cellspacing="0" width="60%"  border="1">
		<tr >
		    <th >&nbsp;</th>
			<th ><fmt:message key="Common.from.label" bundle="${common_labels}"/><BR>
			<label id="rangeUnit"><%=rangeUnite%></label></th>
            <th ><fmt:message key="Common.to.label" bundle="${common_labels}"/><BR>
			<label id="rangeUnit"><%=rangeUnite%></label></th>
			 <th ><fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/><BR>
			 <label id="adminUnit"><%=andimUnite%></label></th>
			 <th><fmt:message key="ePH.InformPractitioner.label" bundle="${ph_labels}"/></th>
			  <th ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </th>
			 <th><fmt:message key="Common.status.label" bundle="${common_labels}"/> </th></tr>
		      <%
					for(int i=0;i<alDtlRecords.size();i++){
						ht					=	(HashMap)alDtlRecords.get(i);
					if(i%2==0) classValue	=	"QRYEVEN";
					else		classValue	=	"QRYODD"; 

				%>
				<tr onclick="ModifyData('<%=i%>',this,'<%=(String)ht.get("from_uom")%>','<%=(String)ht.get("to_uom")%>','<%=(String)ht.get("admin_units")%>','<%=(String)ht.get("informPractitioner")%>','<%=(String)ht.get("remarks")%>')"  align="right">
					<td class="<%=classValue%>" onmouseover="changeCursor(this);" align="right"><font class='HYPERLINK' align="right">
					<!-- <%=i+1%> -->Edit</font>&nbsp;&nbsp;</td>
                   
					<td class="<%=classValue%>"  onclick='disableClick(event);' align="right">
					<%=(String)ht.get("from_uom")%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);' align="right">
					<%  to_uom=(String)ht.get("to_uom");
						if(to_uom==null || to_uom.equalsIgnoreCase("0"))
						to_uom="---";
					    else
							to_uom=(String)ht.get("to_uom");
						%>
						<%=(String)to_uom%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);' align="right">
					<%=(String)ht.get("admin_units")%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);' align="right">
					
                    <%if(ht.get("informPractitioner").equals("Y")){%>

						<img src="../../eCommon/images/enabled.gif"/>
						<%}else{%>
						<img src="../../eCommon/images/disabled.gif"/>
						<%}%>
					</td>
								
					<td class="<%=classValue%>" onclick='disableClick(event);' align="right">
					<%=(String)ht.get("remarks")%>&nbsp;</td>
					<td class="<%=classValue%>" onclick='disableClick(event);'align="center">
					<%if(ht.get("eff_status").equals("E")){
				        cheked  =new String("checked");
					}
					else if(ht.get("eff_status").equals("D")){
                        cheked= new String(" ");
						}%>
					 <input type="checkBox" name="eff_status" id="eff_status" value="<%=(String)ht.get("eff_status")%>" onclick="assignValueTobean(this,'<%=i%>');" <%=cheked%> > 
				  
				</td>
				</tr>
					<%}%>					
</table>
</td></tr>
</table>
   <input type="hidden" name="records" id="records" value="<%=alDtlRecords.size()%>">
  
</FORM>
</BODY>
</HTML>


