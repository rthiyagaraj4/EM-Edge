<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>                     
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
	
%>
<html>
<head>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<!--Added against MMS-QH-CRF-0199-->
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<style>
		TD.OS{
		BACKGROUND-COLOR:#6666FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.PR{
		BACKGROUND-COLOR:#FF99FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.IN{
		BACKGROUND-COLOR:#CC0099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.PO{
		BACKGROUND-COLOR:#FFCC33;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.FN{
		BACKGROUND-COLOR:#990099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

</style>
<form name="RecordAnesthesiaPatientDetailsForm" id="RecordAnesthesiaPatientDetailsForm" >
<table class='grid' cellpadding="3" cellspacing="0" width="100%" border="1" scrolling="no">
	<tr>
		<th  class="columnHeader" nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class="columnHeader" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.name.label"  bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key= "Common.Procedure.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="eOT.AnaesthesiaOrderedDate.Label" bundle="${ot_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.speciality.label"  bundle="${common_labels}"/></th>
	</tr>
<%
	String facility_id=checkForNull(request.getParameter("facility_id"));
	String patient_id1= checkForNull(request.getParameter("patient_id")); 
	String patient_name1= checkForNull(request.getParameter("patient_name"));
	String accession_num= checkForNull(request.getParameter("accession_num"));
	String surgery_date1=checkForNull(request.getParameter("surgery_date"));
	String surgeon_code1= checkForNull(request.getParameter("surgeon_code"));
	String speciality_code1= checkForNull(request.getParameter("speciality_code"));
	String order_date= checkForNull(request.getParameter("order_date"));
	//String anesthesia_srl_no_new= checkForNull(request.getParameter("anesthesia_srl_no"));//49942
	String strTempOperation="";
	StringBuilder whereClause=new StringBuilder();
	//AAKH CRF-00069
	String surgery_date2=checkForNull(request.getParameter("surgery_date2"));
	String order_date2= checkForNull(request.getParameter("order_date2"));
	//AAKH CRF-00069

	//String sql_anesthesia_patient_details="SELECT SOURCE_ORDER_ID,PATIENT_ID, PATIENT_NAME PATIENT_NAME1, SEX, STATUS ,PREOP_ASSE_DONE_YN, NO_OF_PREOP_ASSE, REJECTED_YN, NVL(INTRAOP_DONE_YN,'N') INTRAOP_DONE_YN, POSTOP_DONE_YN,ANAESTHESIA_SERIAL_NUM, 	PROC_MODULE_ID,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,ORDER_ID,ORDER_CATALOG_CODE, ORDER_CATALOG_DESC,TO_CHAR(SURGERY_DATE,'DD/MM/YYYY') SURGERY_DATE,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') REQUEST_DATE, SPECIALITY_CODE, SPECIALITY_DESC, SURGEON_CODE, SURGEON_NAME,ACCESSION_NUM FROM AT_PRE_INTRA_OPER_VW A WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND A.LANGUAGE_ID='"+locale+"' ";
	//Below query is changed against 50585 /* ot_pending_order */
	//commented against MMS-QH-CRF-0199
	/*String sql_anesthesia_patient_details="SELECT SOURCE_ORDER_ID,a.PATIENT_ID, PATIENT_NAME PATIENT_NAME1, SEX, STATUS ,PREOP_ASSE_DONE_YN, NO_OF_PREOP_ASSE, REJECTED_YN, NVL(INTRAOP_DONE_YN,'N') INTRAOP_DONE_YN, POSTOP_DONE_YN,ANAESTHESIA_SERIAL_NUM, 	PROC_MODULE_ID,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,a.ORDER_ID,ORDER_CATALOG_CODE, ORDER_CATALOG_DESC,TO_CHAR(SURGERY_DATE,'DD/MM/YYYY') SURGERY_DATE,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') REQUEST_DATE, a.SPECIALITY_CODE, SPECIALITY_DESC, NVL (b.team_doctor_code, c.performing_team_surgeon) surgeon_code,(SELECT d.short_name FROM am_practitioner_lang_vw d WHERE d.practitioner_id(+) = NVL (b.team_doctor_code, c.performing_team_surgeon) AND d.language_id = 'en') surgeon_name,ACCESSION_NUM FROM AT_PRE_INTRA_OPER_VW A, ot_booking_hdr b, ot_pending_order c WHERE A.OPERATING_FACILITY_ID= '"+facility_id+"' AND A.LANGUAGE_ID='"+locale+"' AND a.source_order_id = c.order_id   AND a.source_order_id = b.order_id(+)";*/
	//Added against MMS-QH-CRF-0199
	String sql_anesthesia_patient_details="SELECT source_order_id, a.patient_id, patient_name patient_name1, sex, a.status,preop_asse_done_yn, no_of_preop_asse, rejected_yn, NVL (intraop_done_yn, 'N') intraop_done_yn, postop_done_yn,anaesthesia_serial_num, proc_module_id,TO_CHAR (date_of_birth, 'DD/MM/YYYY') date_of_birth, a.order_id,       a.order_catalog_code, d.long_desc oper_desc,TO_CHAR (surgery_date, 'DD/MM/YYYY') surgery_date,TO_CHAR (request_date, 'DD/MM/YYYY') request_date, a.speciality_code,       speciality_desc,NVL (b.team_doctor_code, c.performing_team_surgeon) surgeon_code,(SELECT d.short_name FROM am_practitioner_lang_vw d WHERE d.practitioner_id(+) =                 NVL (b.team_doctor_code,c.performing_team_surgeon) AND d.language_id = 'en') surgeon_name,accession_num FROM at_pre_intra_oper_vw a, ot_booking_hdr b, ot_pending_order c, OT_OPER_MAST_LANG_VW d WHERE a.operating_facility_id = '"+facility_id+"'  AND a.language_id = '"+locale+"' AND a.source_order_id = c.order_id AND a.ORDER_CATALOG_CODE = d.ORDER_CATALOG_CODE  and d.LANGUAGE_ID = '"+locale+"' AND a.source_order_id = b.order_id(+)";

	String sql_desc="SELECT B.LONG_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM  = ? AND A.OPER_CODE  = B.OPER_CODE ORDER BY 1";	
//	String sql_enctr_patient="SELECT PATIENT_CLASS, ENCOUNTER_ID FROM OR_ORDER WHERE ORDER_ID=?"; 
	ArrayList pstmt_params = new ArrayList();
	whereClause.append(sql_anesthesia_patient_details);
	if(!(patient_id1.equals(""))){
		pstmt_params.add(patient_id1);
		whereClause.append(" AND A.PATIENT_ID=? ");
	}

	if(!(patient_name1.equals(""))) {
		pstmt_params.add(patient_name1);
		whereClause.append(" AND A.PATIENT_NAME LIKE ? ");
	}
	//AAKH CRF-0069 START
	if(!(surgery_date1.equals(""))){
		pstmt_params.add(surgery_date1);
		if(!(surgery_date2.equals(""))){
			pstmt_params.add(surgery_date2);	
		}else{
			//pstmt_params.add(surgery_date1);
			pstmt_params.add("31/12/9999");
		}
		//whereClause.append(" AND A.SURGERY_DATE=to_date(?,'DD/MM/YYYY') ");
		whereClause.append(" AND A.SURGERY_DATE BETWEEN TO_DATE(?||' 00:00','DD/MM/YYYY HH24:MI')  AND TO_DATE(?||' 23:59','DD/MM/YYYY HH24:MI')  ");
	}
	if(!(order_date.equals(""))){
		pstmt_params.add(order_date);
		if(!(order_date2.equals(""))){	
		pstmt_params.add(order_date2);
		}else{//pstmt_params.add(order_date);
			pstmt_params.add("31/12/9999");
		}
		//whereClause.append(" AND REQUEST_DATE=to_date(?,'DD/MM/YYYY') ");
		whereClause.append(" AND A.REQUEST_DATE BETWEEN TO_DATE(?||' 00:00','DD/MM/YYYY HH24:MI')  AND TO_DATE(?||' 23:59','DD/MM/YYYY HH24:MI')  ");
	}
	//AAKH CRF-00069 END
	if(!(surgeon_code1.equals(""))){
		pstmt_params.add(surgeon_code1);
		//whereClause.append(" AND A.SURGEON_CODE=? ");//54370
		whereClause.append("	AND NVL (b.team_doctor_code, c.performing_team_surgeon)=?");//54370
	}
	if(!(speciality_code1.equals(""))){
		pstmt_params.add(speciality_code1);
		whereClause.append(" AND A.SPECIALITY_CODE=? ");
	}
	//AAKH-CRF-0069
	whereClause.append("	order by a.surgery_date desc,a.request_date,a.patient_id");
	sql_anesthesia_patient_details=whereClause.toString();
	whereClause.setLength(0);
	String patient_id = "",patient_name	= "",sex = "",status = "",intraop_done_yn = "",anesthesia_srl_no= "",proc_module_id	= "",classValue = "",date_of_birth	= "",order_catalog_code ="",order_catalog_desc ="",surgery_date = "",request_date = "",speciality_code ="",speciality_desc ="",surgeon_code ="",surgeon_name="",order_id="",patient_class="",encounter_id="",src_order_id="";
	String patientNameMenu = ""; //49942
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	PreparedStatement pstmt1 = null ;
	ResultSet resultSet1     = null ;
	int i=0;
	try{
			connection			= ConnectionManager.getConnection(request);
			pstmt = connection.prepareStatement(sql_anesthesia_patient_details) ;
			if(pstmt_params.size()>0)
			{
				int size = pstmt_params.size();
				for(int j=0;j<size;j++)
				{
					pstmt.setString(j+1,""+pstmt_params.get(j));
				}
			}
			resultSet			= pstmt.executeQuery();
			while(resultSet.next()){
				i++;
				src_order_id = resultSet.getString("SOURCE_ORDER_ID");
				patient_id = resultSet.getString("PATIENT_ID");
				//patient_name = resultSet.getString("PATIENT_NAME1");
				// By Dilip
				ResultSet rs=null;
				String sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1         FROM MP_PATIENT  WHERE PATIENT_ID =? ";
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,patient_id);
				rs=pstmt.executeQuery();
				if(rs.next())
					patient_name=checkForNull(rs.getString("SHORT_NAME1"));
				    patientNameMenu = patient_name.replace("'",""); //49942
				
				rs.close();
				pstmt.close();
				// End by Dilip
				sex = resultSet.getString("SEX");
				if(sex.equals("M")){
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}else if(sex.equals("F")){
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				status = resultSet.getString("STATUS");
				intraop_done_yn = resultSet.getString("INTRAOP_DONE_YN");
				anesthesia_srl_no = resultSet.getString("ANAESTHESIA_SERIAL_NUM");
				proc_module_id = resultSet.getString("PROC_MODULE_ID");
				date_of_birth = com.ehis.util.DateUtils.convertDate(resultSet.getString("DATE_OF_BIRTH"),"DMY","en",locale);
				order_id = resultSet.getString("ORDER_ID");
				order_catalog_code = resultSet.getString("ORDER_CATALOG_CODE");
				if(order_catalog_code==null) order_catalog_code="";
				//order_catalog_desc = resultSet.getString("ORDER_CATALOG_DESC"); //Commented against MMS-QH-0199
				order_catalog_desc = resultSet.getString("oper_desc");//Added against MMS-QH-0199
				if(order_catalog_desc==null) order_catalog_desc="&nbsp;";
				surgery_date = com.ehis.util.DateUtils.convertDate(resultSet.getString("SURGERY_DATE"),"DMY","en",locale);
				if(surgery_date==null) surgery_date="&nbsp;";
				request_date = com.ehis.util.DateUtils.convertDate(resultSet.getString("REQUEST_DATE"),"DMY","en",locale);
				if(request_date==null) request_date="&nbsp;";
				speciality_code = resultSet.getString("SPECIALITY_CODE");
				if(speciality_code==null) speciality_code="";
				speciality_desc = resultSet.getString("SPECIALITY_DESC");
				if(speciality_desc==null) speciality_desc="&nbsp;";
				surgeon_code = resultSet.getString("SURGEON_CODE");
				if(surgeon_code==null) surgeon_code="";
				surgeon_name = resultSet.getString("SURGEON_NAME");
				if(surgeon_name==null) surgeon_name="&nbsp;";
				accession_num=resultSet.getString("ACCESSION_NUM");
		if(accession_num==null) accession_num="";
		if(!accession_num.equals("")){	
			pstmt1=connection.prepareStatement(sql_desc);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,facility_id);
			pstmt1.setString(3,accession_num);
			resultSet1=pstmt1.executeQuery();
			strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			whereClause.append(strTempOperation);
			whereClause.append(",").append(order_catalog_desc);
			while(resultSet1.next()){
					whereClause.append(",").append(resultSet1.getString(1));
			}
		}else{
			String sql_proc="SELECT B.LONG_DESC FROM OR_ORDER_LINE A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID =? AND A.ORDER_ID = ? AND A.ORDER_CATALOG_CODE  = B.ORDER_CATALOG_CODE";	
			pstmt1=connection.prepareStatement(sql_proc);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,src_order_id);
			resultSet1=pstmt1.executeQuery();
			strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			whereClause.append(strTempOperation);
			whereClause.append(",").append(order_catalog_desc);
		while(resultSet1.next())
			{
				whereClause.append(",").append(resultSet1.getString(1));
			}
		
		}
			strTempOperation = whereClause.toString();
			whereClause.setLength(0);
			resultSet1.close();
			classValue =(i%2==0)?"gridData":"gridData";	 
			//accession_num is oper_num and src_order_id is order_id
			String sql2 = null;
			//to get the latest Encounter ID when accession_num is not null
			if(accession_num!=null && !(accession_num.equals("")) && !(accession_num.equals("null"))){
				sql2="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_NUM = '"+accession_num+"' ";
			} 
			//to get the latest Encounter ID when order Id is not equal to null
			else if(src_order_id!=null && !(src_order_id.equals("")) && !(src_order_id.equals("null"))){
				sql2="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OR_ORDER WHERE ORDERING_FACILITY_ID = '"+facility_id+"' AND ORDER_ID = '"+src_order_id+"' ";
			}
			pstmt = connection.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				encounter_id=rs.getString("encounter_id");
				patient_class=rs.getString("patient_class");
			}
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
		%>
<tr>
	<td class='<%=status%>' width='5%'></td>

	<td width='10%' nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTipAnaesDetails('<%=facility_id%>','<%=patient_id%>','<%=patientNameMenu%>','<%=sex%>','<%=anesthesia_srl_no%>','<%=proc_module_id%>','<%=date_of_birth%>','<%=patient_class%>','<%=encounter_id%>','<%=order_id%>','<%=accession_num%>','<%=intraop_done_yn%>',this,'imgArrow<%=i%>')" onMouseOver='hideToolTip();'><a href='javascript:void(0);' style='color: blue; text-decoration: underline;'><%=patient_id%></a><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>' id='imgArrow<%=i%>'></td>
	
	<td class='<%=classValue%>' width='20%' ><%=patient_name%></td>
	<td class='<%=classValue%>' width='7%' ><%=sex%></td>
<!-- Modified against MMS-QH-CRF-0199 -->
	<%
	out.println("<td class='gridData'   nowrap ><img src='../../eOT/images/drugInfo.gif' OnMouseOver=\"Tip(reasonToolTip('"+src_order_id+"'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onMouseOut='UnTip();' >"+order_catalog_desc+"</td>");
	%>
	<td class='<%=classValue%>' width='8%' nowrap><%=surgery_date%></td>
	<td class='<%=classValue%>' width='8%' nowrap><%=request_date%></td>
	<td class='<%=classValue%>' width='13%' nowrap><%=surgeon_name%></td>
	<td class='<%=classValue%>' width='15%' nowrap><%=speciality_desc%></td>
</tr>
	<%
	    } //While loop closing
	if(i==0)
		 out.println("<script>callNoRecord();</script>");

	}catch(Exception e) {
		    e.printStackTrace();
            System.err.println("Exception=="+e);
	}finally{
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(resultSet1!=null) resultSet1.close();
				if(pstmt1!=null) pstmt1.close();
				whereClause.setLength(0);
				if(connection!=null) 
					ConnectionManager.returnConnection(connection,request);
    }
%>

</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
</form>
</body>
</html>

