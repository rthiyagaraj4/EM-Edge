<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

		String	bean_id			=	"DrugDetailsBean" ;
		String	bean_name		=	"ePH.DrugDetailsBean";

		DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id,bean_name, request ) ;
		String temp_string = "";
		String img_string = "";
		String classValue = "";
		ArrayList AgeGroupList = bean.getAgeGroupList();
		HashMap hmRecord = null;

//bean.getDrugDetails();
%>
		<form name="DiscontinueDrugForm" id="DiscontinueDrugForm" >
			<BR>
			<table cellpadding="1" cellspacing="0" width="99%"  align="center" border="1">
<% 
				if(AgeGroupList!=null && AgeGroupList.size()>0){
%>
					<tr>
						<th class="COLUMNHEADER"  nowrap rowspan='2'  width="20%"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
						<th class="COLUMNHEADER"  nowrap rowspan='2'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
						<th class="COLUMNHEADER"  nowrap rowspan='2'><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></th>
						<th class="COLUMNHEADER"  nowrap rowspan='2'><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></th>
						<th class="COLUMNHEADER"  nowrap rowspan='2'><fmt:message key="ePH.DrugApplicable.label" bundle="${ph_labels}"/></th>
						<th class="COLUMNHEADER"  nowrap colspan='2'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th> <!-- changed for Bru-HIMS-CRF-079 IN[029945]-->
						<th class="COLUMNHEADER"  nowrap rowspan='2'><fmt:message key="Common.EffStatus.label" bundle="${common_labels}"/></th>
					</tr>
					<!--added for Bru-HIMS-CRF-079 IN[029945]-- start -->
					<tr >
						<th  class="COLUMNHEADER"  nowrap width="8%"><fmt:message key="Common.weight.label" bundle="${common_labels}"/></th>
						<th  class="COLUMNHEADER"  nowrap width="8%"><fmt:message key="Common.height.label" bundle="${common_labels}"/></th>
					</tr>
					<!-- added for Bru-HIMS-CRF-079 IN[029945] -end -->
<%
					for(int i=0; i<AgeGroupList.size(); i++){
						hmRecord = (HashMap)AgeGroupList.get(i);
						if(i%2 == 0)
							classValue = "QRYEVEN";
						else 
							classValue = "QRYODD";
%>
						<tr>
							<td  class='<%=classValue%>'  nowrap width='20%'><%=(String)hmRecord.get("SHORT_DESC")%>&nbsp;</td>
							<td  class='<%=classValue%>'  nowrap ><%=(String)hmRecord.get("GENDER")%>&nbsp;</td>
							<td  class='<%=classValue%>'  nowrap ><%=(String)hmRecord.get("MIN_AGE")%> <%=(String)hmRecord.get("MIN_AGE_UNIT")%>&nbsp;</td>
							<td  class='<%=classValue%>'  nowrap ><%=(String)hmRecord.get("MAX_AGE")%> <%=(String)hmRecord.get("MAX_AGE_UNIT")%>&nbsp;</td>
<%
							temp_string =(String)hmRecord.get("DRUG_APPL_YN"); 
							if(temp_string!=null && temp_string.equals("Y"))
								img_string ="<img src=\"../../eCommon/images/enabled.gif\"></img>";
							else if(temp_string!=null && temp_string.equals("N"))
								img_string ="<img src=\"../../eCommon/images/disabled.gif\"></img>";
							else 
								img_string = "&nbsp";
%>							
							<td  class='<%=classValue%>' style='TEXT-ALIGN:center;'  nowrap ><%=img_string%>&nbsp;</td>
<%
							temp_string =(String)hmRecord.get("WT_MAND_YN"); 
							if(temp_string!=null && temp_string.equals("Y"))
								img_string ="<img src=\"../../eCommon/images/enabled.gif\"></img>";
							else if(temp_string!=null && temp_string.equals("N"))
								img_string ="<img src=\"../../eCommon/images/disabled.gif\"></img>";
							else 
								img_string = "&nbsp";
%>							
							<td  class='<%=classValue%>' style='TEXT-ALIGN:center;' nowrap ><%=img_string%>&nbsp;</td>
							<!--//added for Bru-HIMS-CRF-079 IN[029945] --start-->
<%
							temp_string =(String)hmRecord.get("HT_MAND_YN"); 
							if(temp_string!=null && temp_string.equals("Y"))
								img_string ="<img src=\"../../eCommon/images/enabled.gif\"></img>";
							else if(temp_string!=null && temp_string.equals("N"))
								img_string ="<img src=\"../../eCommon/images/disabled.gif\"></img>";
							else 
								img_string = "&nbsp";
%>							
							<td  class='<%=classValue%>' style='TEXT-ALIGN:center;' nowrap ><%=img_string%>&nbsp;</td>
							<!-- //added for Bru-HIMS-CRF-079 IN[029945] --end -->
<%
							temp_string =(String)hmRecord.get("EFF_STATUS"); 
							if(temp_string!=null && temp_string.equals("E"))
								img_string ="<img src=\"../../eCommon/images/enabled.gif\"></img>";
							else if(temp_string!=null && temp_string.equals("D"))
								img_string ="<img src=\"../../eCommon/images/disabled.gif\"></img>";
							else 
								img_string = "&nbsp";
%>							
							<td  class='<%=classValue%>' style='TEXT-ALIGN:center;' nowrap ><%=img_string%>&nbsp;</td>
						</tr>
<%
					}
				}
%>
			</table>
		</FORM>
	</BODY>
</HTML>

<%
	putObjectInBean(bean_id,bean,request);
%>

