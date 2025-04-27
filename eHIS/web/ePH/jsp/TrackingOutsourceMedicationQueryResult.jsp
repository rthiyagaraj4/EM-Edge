<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<html>
	<head>
		<title></title>
<%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String	bean_id			=	"TrackingOutsourceMedicationBean" ;
		String	bean_name		=	"ePH.TrackingOutsourceMedicationBean";
		TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject(bean_id,bean_name ,request);
		String mode			= request.getParameter("mode");
		bean.clearOutSourceDtls();
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		String facility_id					= (String) session.getValue("facility_id");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/TrackingOutsourceMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String patient_id 		=	request.getParameter( "patient_id" )==null?"":request.getParameter( "patient_id" );
		String drug_code 		=	request.getParameter( "drug_code" )==null?"":request.getParameter( "drug_code" );
		String order_date_from 		=	request.getParameter( "order_date_from" )==null?"":request.getParameter( "order_date_from" );
		String order_date_to 		=	request.getParameter( "order_date_to" )==null?"":request.getParameter( "order_date_to" );
		String order_type 		=	request.getParameter( "order_type" )==null?"":request.getParameter( "order_type" );
		String tracingStatus 		=	request.getParameter( "tracingStatus" )==null?"":request.getParameter( "tracingStatus" );
		String ref_facility 		=	request.getParameter( "ref_facility" )==null?"":request.getParameter( "ref_facility" );
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		ArrayList qeuryrecord=new ArrayList();
		String classvalue= "", restrict_yn, intr_remarks, Optionval="";
		String severity_level 		=	request.getParameter( "Severity_Level" )==null?"":request.getParameter( "Severity_Level" );
		String significant_level 		=	request.getParameter( "Significant_level" )==null?"":request.getParameter( "Significant_level" );
		String probability 		=	request.getParameter( "Probability" )==null?"":request.getParameter( "Probability" );
		String nature 		=	request.getParameter( "nature" )==null?"":request.getParameter( "nature" );

		try{
			
			HashMap sqlMap = new HashMap();
			StringBuffer sbSql = new StringBuffer();
			if(tracingStatus.equals("P")){
				sbSql.append("SELECT a.patient_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang ), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, drug.drug_desc drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.ord_date_time order_date, a.IV_PREP_YN order_type, a.source_type, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, f.practitioner_name, b.order_line_status status FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, LANGUAGE_ID FROM ph_drug_lang_vw  WHERE DISCONTINUED_YN !='Y' UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, LANGUAGE_ID FROM ph_tpn_regimen_lang_vw  WHERE DISCONTINUED_YN !='Y') drug, am_practitioner_lang_vw f WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num AND c.complete_order_reason = '*SE' AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND B.ORDER_LINE_STATUS IN('DF','DE') AND A.PERFORMING_DEPTLOC_CODE =? AND upper(b.order_catalog_code) like upper(?)");//DE ADDED FOR MMS-KH-CRF-0014
			}
			else{
				sbSql.append("SELECT a.patient_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, drug.drug_desc drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.ord_date_time order_date, a.iv_prep_yn order_type, a.source_type, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, f.practitioner_name, b.order_line_status status, om.outsource_id, om.facility_id, om.referral_facility, (select facility_name from sm_facility_param_lang_vw where facility_id=om.referral_facility and language_id =f.language_id) referral_facility_name, (SELECT practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = om.outsourced_by AND language_id = f.language_id) outsourced_pract_name, TO_CHAR (om.outsourced_date, 'DD/MM/YYYY HH24:MI') outsourced_date FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, language_id FROM ph_drug_lang_vw WHERE discontinued_yn != 'Y' UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, language_id FROM ph_tpn_regimen_lang_vw WHERE discontinued_yn != 'Y') drug, am_practitioner_lang_vw f, ph_outsource_medn om WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num AND b.order_id = om.order_id(+) AND b.order_line_num = om.order_line_num(+) AND c.complete_order_reason = '*SE' AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND a.PERFORMING_DEPTLOC_CODE= ? AND upper(b.order_catalog_code) like upper(?)");

				if(tracingStatus.equals("S"))
					sbSql.append(" AND b.order_line_status = 'SE' ");
				else if(tracingStatus.equals("R"))
					sbSql.append(" AND b.order_line_status = 'RC' ");
				else if(tracingStatus.equals("D"))
					sbSql.append(" AND b.order_line_status = 'IS' ");
				else
					sbSql.append(" AND b.order_line_status in('DF','DE','SE','RC', 'IS') ");//DE ADDED FOR MMS-KH-CRF-OO14
				if( !ref_facility.equals(""))
					sbSql.append(" and om.REFERRAL_FACILITY = ? ");
			}
			if(patient_id!=null && !patient_id.equals(""))
				sbSql.append(" AND a.patient_id=? ");

			if(!order_date_from.equals("") && !order_date_to.equals(""))
				sbSql.append(" AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY' ) AND TO_DATE (?, 'DD/MM/YYYY' )+.99999  "); 
			else if(!order_date_from.equals(""))
				sbSql.append(" AND a.ord_date_time  >= TO_DATE(?,'DD/MM/YYYY') ");
			else if(!order_date_to.equals(""))
				sbSql.append(" AND a.ord_date_time  <= TO_DATE(?,'DD/MM/YYYY')+ 0.99999   ");
			
			if(order_type.equals("NOR")) {
				sbSql.append(" AND (A.IV_PREP_YN IS NULL OR A.IV_PREP_YN='N') ");
			}
			else if(order_type.equals("IVAD")) {
				sbSql.append(" AND A.IV_PREP_YN IN('1') ");
			}
			else if(order_type.equals("IVAA")) {
				sbSql.append(" AND A.IV_PREP_YN IN('2') ");
			}
			else if(order_type.equals("IVWA")) {
				sbSql.append( " AND A.IV_PREP_YN IN('5') ");
			}
			else if(order_type.equals("IVID")) {
				sbSql.append(" AND A.IV_PREP_YN IN('3') ");
			}
			else if(order_type.equals("IVIA")) {
				sbSql.append(" AND A.IV_PREP_YN IN('4') ");
			}
			else if(order_type.equals("TD")) {
				sbSql.append( " AND A.IV_PREP_YN ='7' ");
			}
			else if(order_type.equals("TA")) {
				sbSql.append(" AND A.IV_PREP_YN ='8' ");
			}
			else if(order_type.equals("CD")) {
				sbSql.append(" AND A.IV_PREP_YN = '9' ");
			}
			else if(order_type.equals("CA")) {
				sbSql.append( " AND A.IV_PREP_YN = '0' ");
			}
			else if(order_type.equals("CO")) {
				sbSql.append( " AND A.IV_PREP_YN = '6' ");
			}

			sbSql.append(" AND drug.language_id = ? AND f.language_id = ? ");
			sqlMap.put("sqlData", sbSql.toString() );
			if(drug_code.equals("")){
				drug_code  = "%";	
			}

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "patient_id" ); //0
			displayFields.add( "patient_name" );
			displayFields.add( "age" );
			displayFields.add( "sex" );
			displayFields.add( "order_id" ); //4
			displayFields.add( "order_line_num" ); //5
			displayFields.add( "drug_desc" );
			displayFields.add( "ord_date_time" );
			//displayFields.add( "order_type" );
			displayFields.add( "source_type" );
			displayFields.add( "source_desc" );
			displayFields.add( "practitioner_name" ); //10
			displayFields.add( "status" ); //11
			if(!tracingStatus.equals("P")){
				displayFields.add( "outsource_id" ); 
				displayFields.add( "facility_id" ); 
				displayFields.add( "referral_facility" ); 
				displayFields.add( "referral_facility_name" ); 
				displayFields.add( "outsourced_pract_name" ); 
				displayFields.add( "outsourced_date" ); //17
			}

			ArrayList chkFields = new ArrayList();
			chkFields.add( locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(bean.getDispLocnCode());
			chkFields.add(drug_code);
			if(!tracingStatus.equals("P") &&  !ref_facility.equals(""))
				chkFields.add( ref_facility.trim());
			if(patient_id!=null && !patient_id.equals(""))
				chkFields.add( patient_id.trim());
			if(!order_date_from.equals("") && !order_date_to.equals("")){
				chkFields.add( com.ehis.util.DateUtils.convertDate(order_date_from.trim(),"DMY",locale,"en"));
				chkFields.add( com.ehis.util.DateUtils.convertDate(order_date_to.trim(),"DMY",locale,"en"));
			}
			else if(!order_date_from.equals(""))
				chkFields.add( com.ehis.util.DateUtils.convertDate(order_date_from.trim(),"DMY",locale,"en"));
			else if(!order_date_to.equals(""))
				chkFields.add(com.ehis.util.DateUtils.convertDate(order_date_to.trim(),"DMY",locale,"en") );
			chkFields.add( locale);
			chkFields.add( locale);
			
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			String 	prevPatID="" ,currPatId="", source_type="", status="",  outsourceId, orderId, orderLineNum, outsource_pract_name, outsource_date ;

			int colCounts = 12;
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr>
						<td width="80%" class="white">&nbsp;</td>
						<td width="20%" class="white">&nbsp;
<%
							out.println(result.get(1)); // For display the previous/next link
%>
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center">
					<tr>
						<td class="COLUMNHEADER" width="8%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" width="15%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" width="*%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" width="10%"><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" width="15%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" width="15%"><fmt:message key="ePH.OrderedPractitioner.label" bundle="${ph_labels}"/></td>
<%
						if(!tracingStatus.equals("P")){ 
							colCounts = 18;
%>
							<td class="COLUMNHEADER" width="8%"><fmt:message key="ePH.Outsource.label" bundle="${ph_labels}"/></td>
<%
						}
%>
						<td class="COLUMNHEADER" width="8%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
<%
						ArrayList records=new ArrayList();
						for(int recCount=2; recCount<result.size(); recCount++) {
							int colCount = 0;
							if ( recCount % 2 == 0 )
								classvalue = "QRYODDSMALL" ;
							else
								classvalue = "QRYEVENSMALL" ;
%>
<%
							records=(ArrayList) result.get( recCount );
							//for(int colCount=0; colCount<records.size(); colCount++){
								currPatId = (String)records.get( colCount);
								source_type = records.get( colCount+8)==null?"": (String)records.get( colCount+8);
								status = (String)records.get( colCount+11);
								order_type = (String)records.get( colCount+7);
								if(!currPatId.equals(prevPatID)){
									prevPatID = currPatId;
%>
									<tr >
										<td class="<%=classvalue%>" ><%=currPatId%></td>
										<td class="<%=classvalue%>" ><%=(String)records.get( colCount+1)%>&nbsp;,&nbsp;<%=(String)records.get( colCount+2)%></font>
										</td>
<%
								}
								else{
%>
									<tr >
										<td class="<%=classvalue%>" >&nbsp;
										<td class="<%=classvalue%>" >&nbsp;
										</td>
<%
								}
%>
								<td class="<%=classvalue%>" ><%=(String)records.get( colCount+6)%></td>
								<td class="<%=classvalue%>" ><%=com.ehis.util.DateUtils.convertDate((String)records.get( colCount+7),"DMYHM","en",locale)%></td>
								<td class="<%=classvalue%>" ><%=records.get( colCount+9)==null?"":(String)records.get( colCount+9)%>&nbsp;
<%
									if(source_type.equals("C") || source_type.equals("E")){
%>
										<b>/</b>&nbsp;<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
<%
									}
									else if(source_type.equals("N") ) {
%>
										<b>/</b>&nbsp;<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
<%
									}
%>
								</td>
								<td class="<%=classvalue%>" ><%=(String)records.get( colCount+10)%></td>
<%
								if(!tracingStatus.equals("P")){
									if(!status.equals("DF")){ 
										outsourceId = (String)records.get( colCount+12);
										orderId = (String)records.get( colCount+4);
										orderLineNum = (String)records.get( colCount+5);
										ref_facility = (String)records.get( colCount+15);
										outsource_pract_name = (String)records.get( colCount+16);
										outsource_date = (String)records.get( colCount+17);
%>
										<td class="<%=classvalue%>" align='center' ><label style='color:blue;cursor:pointer;' onclick='viewOutsourceDtls("<%=outsourceId%>","<%=orderId%>","<%=orderLineNum%>","<%=status%>");' title='<fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/>: <%=ref_facility%>&#xA;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>: <%=outsource_pract_name%>&#xA;<fmt:message key="Common.date.label" bundle="${common_labels}"/>: <%=com.ehis.util.DateUtils.convertDate(outsource_date,"DMYHM","en",locale)%>'><fmt:message key="Common.details.label" bundle="${common_labels}"/></label></td> <!-- &&#xA; used for new line in title tooltip-->
<%
									}
									else{
%>
										<td class="<%=classvalue%>" >&nbsp;</td>
<%
									}
								}
%>
								<td class="<%=classvalue%>" >
<%
								if(status.equals("DF")){
%>
									<fmt:message key="Common.Pending.label" bundle="${common_labels}"/>
<%
								}
								else if(status.equals("SE")){
%>
									<fmt:message key="ePH.Sent.label" bundle="${ph_labels}"/>
<%
								}
								else if(status.equals("RC")){
%>
									<fmt:message key="Common.received.label" bundle="${common_labels}"/>
<%
								}
								else if(status.equals("IS")){
%>
									<fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/>
<%
								}
%>
								</td>
<%
							//}
%>
						</tr>
<%
					}
%>
					</table>
<%
					out.flush();
				}
				else{
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
				}
				out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TrackingOutsourceMedicationQueryResult.jsp", searched) );
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
%>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

