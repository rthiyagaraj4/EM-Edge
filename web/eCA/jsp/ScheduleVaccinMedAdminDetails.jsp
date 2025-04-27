<!DOCTYPE html>

 <!--This file is saved on 28/10/2005-->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
         request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	    String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String facility_id = (String)session.getAttribute("facility_id");
		//out.println("<br>Querstring     :   "+request.getQueryString()+"<br>");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>

	<!-- <body style="margin-top:10px"> -->
	<body style="margin-top:10px" onMouseDown="" onKeyDown="lockKey()">
<%
		//String  encounterid			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
//		String  schdate				=	request.getParameter("schedule_date")==null?"":request.getParameter("schedule_date");
		String  ord_drug_code		=	request.getParameter("ord_drug_code")==null?"":request.getParameter("ord_drug_code");
		String  order_id			=	request.getParameter("order_id")==null?"":request.getParameter("order_id");		
		String  adminyn				=	request.getParameter("adminyn")==null?"Y":request.getParameter("adminyn");
//		String patient_class		=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String  drug_desc			=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
//		String  admintime			=	request.getParameter("administered_date")==null?"":request.getParameter("administered_date");
		String  dose_no			=	request.getParameter("dose_no")==null?"":request.getParameter("dose_no");
		String  vaccine_desc			=	request.getParameter("vaccine_desc")==null?"":request.getParameter("vaccine_desc");
		boolean searched			=	request.getParameter( "searched" ) == null ? false : true  ;
		//out.println(request.getQueryString());
		try{			
			HashMap sqlMap		= new HashMap();
			ArrayList chkFields = new ArrayList();
		//include all the common parameters.
			StringBuffer sql=new StringBuffer();
			//out.println("adminyn    :   "+adminyn);
			if (adminyn.equals("Y")) {
			//	if(patient_class.equals("IP")||patient_class.equals("DC")){
				  //sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT3");
				  sql.append("SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADMIN_TIME,   A.ADMIN_BY,A.ADMIN_RECORDED_BY,D.PRACTITIONER_NAME,   e.drug_desc,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code,    A.ADMIN_REMARKS,  'Batch Id: '||NVL(B.BATCH_ID,'-- ')||' Expiry Date: '||    NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE    language_id=? and TRADE_ID=B.TRADE_ID ),'-- ')  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME,'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, ip_nursing_unit_lang_vw f, ph_medn_trn_reason_lang_vw g WHERE    F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND   A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id AND      A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND    E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND   A.FACILITY_ID=?  AND   A.ORD_DRUG_CODE=? AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id(+) = ? AND f.language_id = d.language_id AND g.language_id (+)= ? AND a.DOSAGE_SEQ_NO = ? AND c.SOURCE_TYPE='N' UNION "); 

			  // } else 
			 //  {
					//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT3A");
					sql.append(" SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADMIN_TIME,   A.ADMIN_BY,A.ADMIN_RECORDED_BY,D.PRACTITIONER_NAME,   e.drug_desc,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code,    A.ADMIN_REMARKS,  'Batch Id: '||NVL(B.BATCH_ID,'--')||' Expiry Date: '||    NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE    language_id=? and  TRADE_ID=B.TRADE_ID ),'-- ')  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME,'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, op_clinic_lang_vw f, ph_medn_trn_reason_lang_vw g WHERE    F.FACILITY_ID=A.FACILITY_ID AND F.clinic_code=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND   A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id AND      A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND    E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND   A.FACILITY_ID=?  AND  A.ORD_DRUG_CODE=? AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id (+)= ? AND f.language_id = d.language_id AND g.language_id (+)= ? AND a.DOSAGE_SEQ_NO = ? AND c.SOURCE_TYPE='C'");
			 //  }				 
			}

           //out.println("<br>sql    :   "+sql);
			chkFields.add(locale);   			  
			chkFields.add(facility_id);
			//chkFields.add(encounterid);
			//chkFields.add(schdate);
			//chkFields.add(admintime);
			chkFields.add(ord_drug_code);
			chkFields.add(order_id);
			chkFields.add(locale); 
			chkFields.add(locale);						 
			chkFields.add(locale); 
			chkFields.add(dose_no); 
			chkFields.add(locale);   			  
			chkFields.add(facility_id);
			//chkFields.add(encounterid);
			//chkFields.add(schdate);
			//chkFields.add(admintime);
			chkFields.add(ord_drug_code);
			chkFields.add(order_id);
			chkFields.add(locale); 
			chkFields.add(locale);						 
			chkFields.add(locale); 
			chkFields.add(dose_no); 
		
			//out.println("<br>chkFields    :   "+chkFields);
	
			//End of concatenating search conditions
			sqlMap.put( "sqlData",  sql.toString());
		
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			int namedisplayed=0;
			if (adminyn.equals("Y") ) {
				displayFields.add("DRUG_DESC");
				displayFields.add("ADMIN_DOSAGE_QTY");
				displayFields.add("ADMIN_TIME");
				displayFields.add("BATCH_DETAILS");
				displayFields.add("ADMIN_REMARKS");
				displayFields.add("ADMIN_DOSAGE_UOM_CODE");
				displayFields.add("PRACTITIONER_NAME");
				displayFields.add("ADMIN_BY");
				displayFields.add("SHORT_DESC");
				displayFields.add("REASON_DESC");
				displayFields.add("ADR_REMARKS");
				displayFields.add("ADR_RECORDED_DATE_TIME");
				displayFields.add("ADR_RECORDED_BY");
				displayFields.add("ADMIN_RECORDED_BY");
			}
			else{
				displayFields.add("NON_ADMIN_REMARKS");
				displayFields.add("PRACTITIONER_NAME");
				displayFields.add("ADMIN_BY");
				displayFields.add("SHORT_DESC");
				displayFields.add("reason_desc");
				displayFields.add("ADMIN_RECORDED_BY");
			}


			funcMap.put("displayFields", displayFields );
			funcMap.put("chkFields", chkFields );
	
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap,funcMap,request);
			//out.println("result   :   "+result);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<TABLE width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<td class='label' colspan='2'><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<b><%=vaccine_desc%><b></td>
					</tr>
					<TR>
						<Td ALIGN="LEFT"  STYLE="BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';" id="admin_dtls">
							<fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/>
						</Td>
						<Td ALIGN="right"  id="practname" Style="background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';">
						</Td>
					</TR>
				</TABLE>
<%
				if (result.get(1)!=""){
%>
					<table cellpadding=0 cellspacing=0 align="center" topmargin='0' >
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
						</tr>
					</table>
<%
				}
%>
				<table id="adminTable" name="PatientTable" id="PatientTable" border="1"  WIDTH="100%" cellpadding="0" cellspacing="0"  align="center" topmargin='0'>
<%		
					if (adminyn.equals("Y") ){
%>
						<tr id="header" name="header">
							<td  class='COLUMNHEADER' width="30%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width="5%" ><fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' width="18%"><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width="24%"><fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width="24%"><fmt:message key="ePH.AdministrationRemarks.label" bundle="${ph_labels}"/></td>
						</tr>
<%
					}
				/*	else{*/
%>
					<!-- 	<tr id="header" name="header">
							<td class='COLUMNHEADER' width="25%"><fmt:message key="ePH.NonAdministrationRemarks.label" bundle="${ph_labels}"/></td>
						</tr> -->
<%
				//	}
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String classvalue="";					
					for(int recCount=2; recCount<result.size(); recCount++){

						if ( recCount % 2 == 0 )
							classvalue = "QRYEVENSMALL" ;
						else
							classvalue = "QRYODDSMALL" ;
						
						records=(ArrayList) result.get( recCount );
%>
						<tr id=<%=recCount%> name=<%=recCount%>>
<%
						

						for(int colCount=0; colCount<records.size()-1; colCount++){
							if  (namedisplayed==0){
								namedisplayed=1;
								if (adminyn.equals("Y")) {
%>
									<script>
										document.getElementById("practname").innerHTML="Ordering Practitioner:<B><%=(String)records.get(6)%></B>";
										document.getElementById("admin_dtls").innerHTML="Administered By:<b><%=(String)records.get(13)%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered At:<b><%=(String)records.get(8)%></b>";
									</script>
<%
								}
		//						else {
%>
									<!-- <script>
									document.getElementById("practname").innerHTML='Ordering Practitioner:<B><%=(String)records.get(1)%></B>';
									document.getElementById("admin_dtls").innerHTML='Recorded  By:<b><%=(String)records.get(5)%></b>,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Recorded At:<b><%=(String)records.get(3)%></b>';
									</script> -->
<%
						//		}

							}
							if (adminyn.equals("Y")){
								if(colCount > 4 && colCount <9)
									continue;
							}
						/*	else{
								if (colCount>0)
									continue;
							}*/
							String dkVal = (String)records.get( colCount )==null?"":(String)records.get( colCount );
					
							if(dkVal == null || (dkVal.trim().equals(""))){	
								if(colCount==0)
								{
									dkVal = drug_desc+"&nbsp;" ;
								}
								else
									dkVal = "&nbsp;" ;
							}

							if (colCount==1){
								out.println("<td class='"+classvalue+"'>");
								if (adminyn.equals("Y"))
									out.println(dkVal+" "+(String)records.get(5));
								else
									out.println(dkVal);
								
								out.println("</td>");
							}else if (colCount==2){								
								out.println("<td class='"+classvalue+"'>");
								out.println(com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale));
								out.println("</td>");
							}
							else if (colCount==3){
								if (dkVal.equals("------")){	
									out.println("<td class='"+classvalue+"'>");
									out.println("&nbsp;");
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'><textarea readonly style='height:30px;width:2in'>");
									out.println(dkVal);
									out.println("</textarea></td>");
								}
							}
							else if (colCount==4){
							
								if (dkVal.equals("&nbsp;")){	
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal);
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'><textarea readonly style='height:30px;width:2in'>");
									out.println(dkVal);
									out.println("</textarea></td>");
								}
							}
							else if(colCount == 9 ){
								if( !dkVal.equals("&nbsp;")){
%>
									<tr>
									<td colspan='5' class='COLUMNHEADER'><fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>
									</td>
									<tr>
									<td class=<%=classvalue%>><b><fmt:message key="Common.reason.label" bundle="${common_labels}"/>:</B>&nbsp;&nbsp;<%=dkVal%></td>
<%
								}
							}
							else if(colCount == 10){
								if( !dkVal.equals("&nbsp;")){
%>
									<td class=<%=classvalue%> colspan='2'><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>:</b>&nbsp;&nbsp;<%=dkVal%></td>
<%
								}
							}
							else if(colCount == 11){
								if( !dkVal.equals("&nbsp;")){
%>
									<td class=<%=classvalue%>><b><fmt:message key="ePH.RecordedDateTime.label" bundle="${ph_labels}"/>:</b>&nbsp;&nbsp;<%=dkVal%></td>
<%
								}
							}
							else if(colCount == 12 ){
								if( !dkVal.equals("&nbsp;")){
%>
									<td class=<%=classvalue%>><b><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/>: </b>&nbsp;&nbsp;<%=dkVal%></td>
									</tr>
<%
								}
							}
							else {
								if(colCount == 0 && adminyn.equals("N") )
								{
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal+" &nbsp <br>Reason:"+(String)records.get(4));
									out.println("</td>");
								}
								else
								{
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal);
									out.println("</td>");
								}
							}
						}
					}			//end of record count
%>
					</tr>
				</table>
<%
			}
			else{  
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); </script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryMednAdminChartAdminDetails.jsp", searched) );
		}//end of try
		catch (Exception e){
			e.printStackTrace();
		}
%>
	</body>

</html>

