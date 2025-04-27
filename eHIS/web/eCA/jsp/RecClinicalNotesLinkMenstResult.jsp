<%
/*
Date		   Edit History	         Name		     Rev.Date	  Rev.Name		     Description
------------------------------------------------------------------------------------------------------------------------------
22/10/2024	      70704 	 Gunasekar R     22/10/2024 	Ashwini Ragupathi  	ML-MMOH-CRF-1759
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eCA.CAMenstrualHistDtlTransBean,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<%Beannew.clearAll();%>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	   %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkMenstHistDtl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
</head> 
<%
    int k = 0;
    String rowid = "";
 	String lmp="";
    String edd="";
    String lmp_gestation_poa="";
 	String lmp_delivery_date="";
    String lmp_miscarriage_date="";
 	String lmp_remarks="";
    String lmp_event_status="";
    String scan_gestation="";
    String usod_lmp="";
    String redd="";
    String usod_gestation_pog="";
 	String usod_delivery_date = "";
 	String usod_miscarriage_date="";
    String usod_remarks="";
 	String usod_event_status = "";
    String checkstatus = "";
 	String categ_sec_qry ="";
 	String rslt_lnk_sensidiag_yn ="";
 	String field_ref ="";
 	String col_field ="";
 	StringBuffer sql = new StringBuffer(" ");
 	StringBuffer sqlwhere = new StringBuffer(" ");
 	ArrayList  fields	=	new ArrayList();
 	ArrayList  result   =   new ArrayList();
 	
 	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
 	String locale = (String) p1.getProperty("LOCALE");
	String facility_id	=	(String) session.getValue( "facility_id" ) ;
 	
  	String bean_id = "@CAMenstrualHistDtlTransBean" ;
 	String bean_name = "eCA.CAMenstrualHistDtlTransBean";
 	
 	CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean) getBeanObject( bean_id, bean_name ,  request) ;

 	String patient_id		=	java.net.URLDecoder.decode(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));

	boolean searched			  =		(request.getParameter("searched") == null) ?false:true;
 	String result_linked_rec_type =	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
 	String sec_hdg_code			  =	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
 	String result_sub_category	  =	request.getParameter("result_sub_category")==null?"":request.getParameter("result_sub_category");
 	String event_status_a 		  = request.getParameter("event_status_a")==null?"":request.getParameter("event_status_a");
 	String event_status_ac 		  = request.getParameter("event_status_ac")==null?"":request.getParameter("event_status_ac");
 	String event_status_c 		  = request.getParameter("event_status_c")==null?"":request.getParameter("event_status_c");
 	String p_from_date 			  = request.getParameter("p_from_date")==null?"":request.getParameter("p_from_date");
 	String p_to_date 			  = request.getParameter("p_to_date")==null?"":request.getParameter("p_to_date");
 	String order_by 			  = request.getParameter("order_by")==null?"":request.getParameter("order_by");
 	String call_from_link_doc_btn = request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");
 	String eveStsAllUnchecked = request.getParameter("eveStsAllUnchecked")==null?"":request.getParameter("eveStsAllUnchecked");
	
 	HashMap allParam = new HashMap();
 	HashMap resultParam = new HashMap();

 
 	try {
 		allParam.put("result_sub_category", result_sub_category);
 		allParam.put("event_status_a", event_status_a);
 		allParam.put("event_status_ac", event_status_ac);
 		allParam.put("event_status_c", event_status_c);
 		allParam.put("p_from_date", p_from_date);
 		allParam.put("p_to_date", p_to_date);
 		allParam.put("order_by", order_by);
 		allParam.put("patient_id", patient_id);
 		allParam.put("facility_id", facility_id);

 		HashMap sqlMap = new HashMap();
 		HashMap funcMap = new HashMap();
 		ArrayList displayFields = new ArrayList();
 		ArrayList chkFields = new ArrayList();

 		resultParam = bean.getRecClinicialNoteLinkMenstResult(allParam);
 		
 		sqlMap = (HashMap) resultParam.get("sqlMap");
 		funcMap = (HashMap) resultParam.get("funcMap");
 		
 		if(eveStsAllUnchecked.equals("")){
	    result= (ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
 			
 		fields = bean.getFields(sec_hdg_code, result_linked_rec_type, result_sub_category);
           if(fields.size()==0)
     	fields = bean.getFields(result_linked_rec_type, result_sub_category );
 		}
	  %>
<body onScroll="scrollTitle()" onKeyDown="lockKey()"> 
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<form name="RecClinicalNotesLinkMentsResultForm" id="RecClinicalNotesLinkMentsResultForm">	
<div id='authorizeMode' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<div id='divDataTitle' style='postion:relative'>
<table  id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr>
<td width='75%' class='CAGROUP' ><b><font size='2'><fmt:message key="Common.searchresult.label" bundle="${common_labels}"/></b></td><td class='CAGROUP'  width='10%' ><%=result.get(1)%></td>
</tr>
</table>
</div>

<table width="100%" class='grid' name="resultTable" id="resultTable" id="resultTable">
<tr><td class='columnheadercenter' width="5%" style="font-size:10"><fmt:message key="Common.all.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></td>
	<%
	if(fields.size()>0)
	{
		if(result_sub_category.equals("LMP")){
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 
			 if(col_field.equals("LMP"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("EDD"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.EDD.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("GESTATION(POA)"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.GestationPOA.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("DELIVERYDATE"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.DeliveryDate.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("MISCARRIAGEDATE"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.MiscarriageDate.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("REMARKS"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("EVENTSTATUS"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
					<%
					}
		   }
		}
		else 
		{//for USOD

			for(int l=0;l<fields.size();++l)
			{
				 col_field = (String)fields.get(l);
				 
				        if(col_field.equals("LMP"))
					    {
					    %>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
					    <%
					    }
				        else if(col_field.equals("SCANGESTATION"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.ScanGestation.label" bundle="${ca_labels}"/></td>
						<%
						}
						else if(col_field.equals("REED"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.REDD.label" bundle="${ca_labels}"/></td>
						<%
						}
						else if(col_field.equals("GESTATION(POG)"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.GestationPOG.label" bundle="${ca_labels}"/></td>
						<%
						}
						else if(col_field.equals("DELIVERYDATE"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.DeliveryDate.label" bundle="${ca_labels}"/></td>
						<%
						}
						else if(col_field.equals("MISCARRIAGEDATE"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.MiscarriageDate.label" bundle="${ca_labels}"/></td>
						<%
						}
						else if(col_field.equals("REMARKS"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
						<%
						}
						else if(col_field.equals("EVENTSTATUS"))
						{
						%>
							<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
						<%
						}
						
			   }			
		}
	}
	else
	{
	    if(result_sub_category.equals("LMP")){%>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.EDD.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.GestationPOA.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.DeliveryDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.MiscarriageDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
	<%}
	    else if(result_sub_category.equals("USOD")){%> 
	    <td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.ScanGestation.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.REDD.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.GestationPOG.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.DeliveryDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.MiscarriageDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
	<%}
	}
	%>
		</tr>
			<%
			int p=0;
			String beankey="";	
			String classValue="gridData";
			
			ArrayList records = new ArrayList();
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))) && eveStsAllUnchecked.equals(""))
			{
				for(int recCount=2; recCount<result.size(); recCount++, k++) {
			
					records=(ArrayList) result.get( recCount );
					
					if(result_sub_category.equals("LMP")){
						 rowid=(String)records.get(0);
						 rowid = rowid.replace('+','$');
						 lmp = CommonBean.checkForNull((String)records.get(1));
					     edd = CommonBean.checkForNull((String)records.get(2));
					     lmp_gestation_poa = CommonBean.checkForNull((String)records.get(3));
						 lmp_delivery_date = CommonBean.checkForNull((String)records.get(4));
					     lmp_miscarriage_date = CommonBean.checkForNull((String)records.get(5));
						 lmp_remarks = CommonBean.checkForNull((String)records.get(6));
						 lmp_event_status = CommonBean.checkForNull((String)records.get(7));
						 %>
	                     <input type='hidden' name='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(lmp,"UTF-8")%>|<%=java.net.URLEncoder.encode(edd,"UTF-8")%>|<%=java.net.URLEncoder.encode(lmp_gestation_poa,"UTF-8")%>|<%=java.net.URLEncoder.encode(lmp_delivery_date,"UTF-8")%>|<%=java.net.URLEncoder.encode(lmp_miscarriage_date,"UTF-8")%>|<%=java.net.URLEncoder.encode(lmp_remarks,"UTF-8")%>|<%=java.net.URLEncoder.encode(lmp_event_status,"UTF-8")%>'></td>				                  
					     <%
					}else if(result_sub_category.equals("USOD")){		
						 rowid=(String)records.get(0);
						 rowid = rowid.replace('+','$');
					     scan_gestation = CommonBean.checkForNull((String)records.get(1));
					     usod_lmp = CommonBean.checkForNull((String)records.get(2));
					     redd = CommonBean.checkForNull((String)records.get(3));
					     usod_gestation_pog = CommonBean.checkForNull((String)records.get(4));
						 usod_delivery_date = CommonBean.checkForNull((String)records.get(5));
						 usod_miscarriage_date = CommonBean.checkForNull((String)records.get(6));
					     usod_remarks = CommonBean.checkForNull((String)records.get(7));
						 usod_event_status = CommonBean.checkForNull((String)records.get(8));
						 %>
	                     <input type='hidden' name='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(scan_gestation,"UTF-8")%>|<%=java.net.URLEncoder.encode(usod_lmp,"UTF-8")%>|<%=java.net.URLEncoder.encode(redd,"UTF-8")%>|<%=java.net.URLEncoder.encode(usod_gestation_pog,"UTF-8")%>|<%=java.net.URLEncoder.encode(usod_delivery_date,"UTF-8")%>|<%=java.net.URLEncoder.encode(usod_miscarriage_date,"UTF-8")%>|<%=java.net.URLEncoder.encode(usod_remarks,"UTF-8")%>|<%=java.net.URLEncoder.encode(usod_event_status,"UTF-8")%>'></td>				                  
					     <%
					}
					
					for(int m=0;m<Beannew.getSize();m+=2)
					{
						beankey=Beannew.getObject(m).toString();
	  					if(rowid.equalsIgnoreCase(beankey))
						{
						checkstatus="checked";
	                    p++; 
						break;
						}
						beankey="";
					}
				
					 if(p == 14)
						{
						%>
						<script>document.forms[0].ctrlChkBox.checked = true;</script> 
						<%}
						
					     %><tr>
						<td class="<%=classValue%>" align="center"><input type="checkbox" name="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"  <%=checkstatus%> ><input type='hidden' name='chk_value<%=k%>' value="<%=rowid%>"></td>
				        <%
					 
					
				if(fields.size()>0)
				{
					if(result_sub_category.equals("LMP")){
					
			
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);
						
						if(col_field.equals("LMP"))
						{
						%>
						  	<td class="<%=classValue%>"><%=lmp%></td>
						<%
						}
						else if(col_field.equals("EDD"))
						{
						%>
							<td class="<%=classValue%>"><%=edd%></td>
						<%
						}
						else if(col_field.equals("GESTATION(POA)"))
						{
						%>
							<td class="<%=classValue%>"><%=lmp_gestation_poa%></td>
						<%
						}
						else if(col_field.equals("DELIVERYDATE"))
						{
						%>
							<td class="<%=classValue%>"><%=lmp_delivery_date%></td>
						<%
						}
						else if(col_field.equals("MISCARRIAGEDATE"))
						{
						%>
							<td class="<%=classValue%>"><%=lmp_miscarriage_date%></td>
						<%
						}
						else if(col_field.equals("REMARKS"))
						{
						%>
							<td class="<%=classValue%>"><%=lmp_remarks%></td>
						<%
						}
						else if(col_field.equals("EVENTSTATUS"))
						{
						%>
							<td class="<%=classValue%>"><%=lmp_event_status%></td>
						<%
						}
                  }
					}
					else if(result_sub_category.equals("USOD")){
						
						
						for(int n=0;n<fields.size();++n)
						{
							col_field = (String)fields.get(n);
       
							if(col_field.equals("SCANGESTATION"))
							{
							%>
							  	<td class="<%=classValue%>"><%=scan_gestation%></td>
							<%
							}
							else if(col_field.equals("LMP"))
							{
							%>
							  	<td class="<%=classValue%>"><%=usod_lmp%></td>
							<%
							}
							else if(col_field.equals("REED"))
							{
							%>
								<td class="<%=classValue%>"><%=redd%></td>
							<%
							}
							else if(col_field.equals("GESTATION(POG)"))
							{
							%>
								<td class="<%=classValue%>"><%=usod_gestation_pog%></td>
							<%
							}
							else if(col_field.equals("DELIVERYDATE"))
							{
							%>
								<td class="<%=classValue%>"><%=usod_delivery_date%></td>
							<%
							}
							else if(col_field.equals("MISCARRIAGEDATE"))
							{
							%>
								<td class="<%=classValue%>"><%=usod_miscarriage_date%></td>
							<%
							}
							else if(col_field.equals("REMARKS"))
							{
							%>
								<td class="<%=classValue%>"><%=usod_remarks%></td>
							<%
							}
							else if(col_field.equals("EVENTSTATUS"))
							{
							%>
								<td class="<%=classValue%>"><%=usod_event_status%></td>
							<%
							}
	                    }
					}
				}
				
				else
				{
					if(result_sub_category.equals("LMP")){
				%>
				<td class="<%=classValue%>"><%=lmp%></td>
				<td class="<%=classValue%>"><%=edd%></td>
				<td class="<%=classValue%>"><%=lmp_gestation_poa%></td>
				<td class="<%=classValue%>"><%=lmp_delivery_date%></td>
				<td class="<%=classValue%>"><%=lmp_miscarriage_date%></td>
				<td class="<%=classValue%>"><%=lmp_remarks%></td>
				<td class="<%=classValue%>"><%=lmp_event_status%></td>
				<%
					} else if(result_sub_category.equals("USOD")) {
				%>
				<td class="<%=classValue%>"><%=scan_gestation%></td>
				<td class="<%=classValue%>"><%=usod_lmp%></td>
				<td class="<%=classValue%>"><%=redd%></td>
				<td class="<%=classValue%>"><%=usod_gestation_pog%></td>
				<td class="<%=classValue%>"><%=usod_delivery_date%></td>
				<td class="<%=classValue%>"><%=usod_miscarriage_date%></td>
				<td class="<%=classValue%>"><%=usod_remarks%></td>
				<td class="<%=classValue%>"><%=usod_event_status%></td>
				<%
					}
			 	}
				%>
				</tr>
			<%
			}
			}
			else{
				%>
				<script>
				document.forms[0].ctrlChkBox.disabled = true
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
				<%
				}
%>
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="count" id="count" value="<%=k%>">
			<input type="hidden" name="result_sub_category" id="result_sub_category" value="<%=result_sub_category%>">	
</table>
</form>
<%
out.println(CommonBean.setForm (request ,"../../eCA/jsp/MenstrualHistPatListResult.jsp", searched));
}
catch(Exception m)
{
	m.printStackTrace();
}
%>
</body>
</script>
</html>

