<!DOCTYPE html>
<!-- 
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.  
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description  
--------------------------------------------------------------------------------------------------------------
?				100					?                created
02/07/2021		TFS-20824         Prabha			ML-MMOH-SCF-1853
---------------------------------------------------------------------------------------------------------------
*/ 
-->
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff"); 
//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientsBySpecificDrug.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String dt_from		= request.getParameter("dt_from");
	String dt_to		= request.getParameter("dt_to");
	String generic_name = request.getParameter("generic_name");
	String generic_id	= request.getParameter("generic_id");
	//String drug_name	= request.getParameter("drug_name");//Commented for ML-MMOH-SCF-0755
	String drug_code	= request.getParameter("drug_code");
	String pat_class	= request.getParameter("pat_class");
	String status		=	request.getParameter("status");
	String facility_id	=  (String) session.getValue("facility_id");//21/10/09
	String	bean_id			=	"QueryPatientsBySpecificDrugBean" ;
	String	bean_name		=	"ePH.QueryPatientsBySpecificDrugBean";
	String order_id = ""; //Added for ML-MMOH-SCF-1853 
	String dis_ind = ""; //Added for ML-MMOH-SCF-1853
	String patient_class = ""; //Added for ML-MMOH-SCF-1853
	QueryPatientsBySpecificDrugBean bean = (QueryPatientsBySpecificDrugBean)getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		String classvalue			=	"";
		//String details				=	"";
		//String strength				=	"";
		//int count					=	0;
	
		dt_from		 = CommonBean.checkForNull( dt_from);
		dt_to		 = CommonBean.checkForNull( dt_to );
		generic_name = CommonBean.checkForNull( generic_name );
		generic_id	 = CommonBean.checkForNull( generic_id );
		//drug_name	 = CommonBean.checkForNull( drug_name );//Commented for ML-MMOH-SCF-0755
		drug_code	 = CommonBean.checkForNull( drug_code );
		pat_class	 = CommonBean.checkForNull( pat_class );
		StringBuffer sql_search_criteria =new StringBuffer(); 
		
		ArrayList chkFields = new ArrayList();
		chkFields.add( dt_from.trim());
		chkFields.add( dt_to.trim() );
		//chkFields.add( dt_from.trim());commented for ML-BRU-SCF-1791
		//chkFields.add( dt_to.trim() );commented  for ML-BRU-SCF-1791
		
		if(pat_class!=null&&!pat_class.equals("")){//added for performance tuning start
			chkFields.add( pat_class.trim() );
		//	chkFields.add( pat_class.trim() ); //commented for ML-BRU-SCF-1930

			/*if(pat_class.equals("XT")) //if else condition added for ML-BRu-SCF-1930
				sql_search_criteria.append(" AND a.PATIENT_CLASS =  NVL (?, '!') ");
			else
				sql_search_criteria.append(" AND P.PATIENT_CLASS =  NVL (?, '!') ");*/ //Commented for ML-MMOH-SCF-1853 - Start
				
		 //Added for ML-MMOH-SCF-1853 - Start
		 
		 if(pat_class.equals("EM"))
			sql_search_criteria.append(" AND p.PATIENT_CLASS =  NVL (?, '!') ");
		 else if(pat_class.equals("OP"))
		 {
			 sql_search_criteria.append(" AND a.PATIENT_CLASS =  NVL (?, '!') ");
			 sql_search_criteria.append("  AND p.patient_class IN ('OP','IP','DC') ");
		 }
		 else if(pat_class.equals("IP") || pat_class.equals("DC"))
		 {
			 sql_search_criteria.append(" AND p.PATIENT_CLASS =  NVL (?, '!') ");
			 sql_search_criteria.append(" AND a.patient_class ='IP' ");
		 }
		 else
		 {
			 sql_search_criteria.append(" AND a.PATIENT_CLASS =  NVL (?, '!') ");
		 }
		
		//Added for ML-MMOH-SCF-1853 - End
		}
		if(generic_id!=null&&!generic_id.equals("")){
			chkFields.add( generic_id.trim() );
			chkFields.add( generic_id.trim() );
			sql_search_criteria.append("AND a.generic_id BETWEEN (?) and (?) ");
        }
		if(drug_code!=null&&!drug_code.equals("")){
			chkFields.add( drug_code.trim() );
			chkFields.add( drug_code.trim() );
			sql_search_criteria.append("AND a.drug_code BETWEEN (?) and (?) ");
		}//added for performance tuning end

		//String sql_active_orders = " AND TRUNC(SYSDATE) BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
		//String sql_check_at_generic_level = " AND A.DRUG_CODE IN (SELECT DRUG_CODE FROM PH_DRUG WHERE GENERIC_ID = A.GENERIC_ID)";
		//Common parameters.
		HashMap sqlMap = new HashMap();
		//include all the common parameters.
		if (status.equals("A")){
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_PACT_BY_SPEC_DRUG_QUERY_SELECT1")+sql_search_criteria.toString()+" AND TRUNC(SYSDATE) BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND A.DRUG_CODE = C.DRUG_CODE AND F.ROUTE_CODE = C.ROUTE_CODE AND G.UOM_CODE = A.DOSAGE_UOM_CODE ORDER BY A.START_DATE DESC");//sql_search_criteria added for performance tunning//AND A.facility_id=p.facility_id added for MOHE-SCF-0017 //Removed AND A.facility_id=p.facility_id for ML-MMOH-SCF-1853  
		}
		else{
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_PACT_BY_SPEC_DRUG_QUERY_SELECT1")+sql_search_criteria.toString()+" AND A.DRUG_CODE = C.DRUG_CODE AND F.ROUTE_CODE = C.ROUTE_CODE AND G.UOM_CODE = A.DOSAGE_UOM_CODE ORDER BY A.START_DATE DESC");//sql_search_criteria added for performance tunning //AND A.facility_id=p.facility_id added for MOHE-SCF-0017   //Removed AND A.facility_id=p.facility_id for ML-MMOH-SCF-1853
		}
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("TRN_TYPE_IND");
	displayFields.add("STATUS");
	displayFields.add("PATIENT_ID");
	displayFields.add("PATIENT_NAME");
	displayFields.add("AGE");
	displayFields.add("GENDER");
	displayFields.add("DRUG_CODE");
	displayFields.add("ORIG_ORDER_ID");
	displayFields.add("START_DATE");
	displayFields.add("PRESCRIBED_QTY");
	displayFields.add("DOSAGE_UOM_CODE");
	displayFields.add("PATIENT_CLASS");
	displayFields.add("PRACTITIONER_NAME");
	displayFields.add("LOCATION");
	displayFields.add("FACILITY_NAME");
	displayFields.add("ORIG_ORDER_LINE_NO");
	displayFields.add("SRL_NO");
	displayFields.add("DRUG_DESC");
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
	<table cellpadding=0 cellspacing=0 width="98%" align="center">
		<tr>
		<td width="78%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="98%" align="center">
		<th style="border:none">&nbsp;</th>
		<th style="border:none">&nbsp;</th>
		<th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></th>
		<th ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th> 
		<th ><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th> 
		<th ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>		
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;
	%>
		<tr>
	<%
			records=(ArrayList) result.get( recCount );
	
			//Added for ML-MMOH-SCF-1853 - Start
			
				 order_id	  = (String)records.get(7);
				 dis_ind = bean.getDischargeInd(order_id);
				 patient_class = (String)records.get(11);
				
				if(dis_ind.equals("D") && (patient_class.equals("IP") || patient_class.equals("DC")))
				{
					patient_class = "OP";
				}
		
			//Added for ML-MMOH-SCF-1853 - End		
				
			String drug_desc = (String)records.get( 17 );
			for(int colCount=0; colCount<records.size(); colCount++){
				if (colCount==0 ){
					String trn_type_ind_color = "#CC9933";
					if (records.get( colCount ) != null && records.get( colCount ).equals("D")){
						trn_type_ind_color = "#FF0000";
					}
	%>
					<td  style="background-color:<%=trn_type_ind_color%>">&nbsp;&nbsp;</td>
	<%
				}else if (colCount==5){
					%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<% 
				out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(String)records.get( colCount)+".label","common_labels")); 

				out.println("</td>"); 
				}
				else if(colCount==8){
					String date	=	com.ehis.util.DateUtils.convertDate((String)records.get(8),"DMY","en",locale);
					out.println("<td class='"+classvalue+"'>"); 
					out.println(date); 
					out.println("</td>");
				}
				else if (colCount == 1){
					String drug_status = "";
					if ((((String)records.get( colCount )).trim()).equals("CANCEL")){
						drug_status = "#990000";
					}
					else if ((((String)records.get( colCount )).trim()).equals("DIS-CONTINUED")){
						drug_status = "ADD8E6";
					}
					else if ((((String)records.get( colCount )).trim()).equals("HOLD")){
						drug_status = "66CCFF";
					}
					else if((((String)records.get( colCount )).trim()).equals("ACTIVE")){
						drug_status = "#33CC00";
					}
					else if((((String)records.get( colCount )).trim()).equals("INACTIVE")){//Added Color for InActive State. SCF.No-0237 & IN33170
						drug_status = "#000099";
					}

	%>
					<td  style="background-color:<%=drug_status%>">&nbsp;&nbsp;</td>
	<%
				}else if (colCount==6 || colCount==10 || colCount==15 || colCount==16 ){				
	%>			
					<td class="<%=classvalue%>" style="display:none"><%=(String)records.get( colCount )%></td>
	<%
				}else if (colCount==7 ){
	%>	
					<td class="<%=classvalue%>" ><%=drug_desc%></td>			
	<%
				}else if (colCount==9 ){
	%>	
					<td class="<%=classvalue%>" ><%=(String)records.get( colCount )%>&nbsp;<%=bean.getUomDisplay(facility_id ,(String)records.get(10))%></td>			
	<%
				}else if(colCount==17){
	%>
	<%			
				}else{
					if(colCount==11) ////Added for ML-MMOH-SCF-1853 - Start
					{
						%>
						<td class="<%=classvalue%>"><%=patient_class==null?"&nbsp;":patient_class%></td>
						<%
					}else{
	%>				
		<td class="<%=classvalue%>"><%=(String)records.get(colCount)==null?"&nbsp;":(String)records.get(colCount)%></td>
				
	<%
				} //Added for ML-MMOH-SCF-1853 - End
			  }
			}
	%>
		</tr>
	<%
		}
	%>
		</table>
	<%
		out.flush();
	%>
	<script language="javascript">
		parent.f_query_status.location.href="../../ePH/jsp/QueryPatientsBySpecificDrugStatus.jsp";
	</script>
	<%
	} else{
	%>
	<script language="javascript">
		if(parent.f_query_status.PatientsBySpecificDrugStatus != null){
			parent.f_query_status.document.getElementById('patientsbyspecificdrugtable').style.visibility="hidden";
		}
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	</script>



	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPatientsBySpecificDrugResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace();
}
%>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

