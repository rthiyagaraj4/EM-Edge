<!DOCTYPE html>
  <!--This file is saved on 28/10/2005--> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

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
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  

	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/QueryDispDrugPatient.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
 
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		 <script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
<%
	//Search Criteria's from Query Criteria page
	String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";

	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	
	int no_decimals =bean.getNoOfDecimals() ;
	
		String decimalStringFormat = "#.";
		// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
		if(no_decimals == 0)
			decimalStringFormat = "#";
		for (int i=0;i<no_decimals;i++)
			{
				decimalStringFormat += "#";
			}

		 DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	


	String patient_id=request.getParameter("patient_id");
	String dt_from	=	request.getParameter("dt_from");
	String  dt_to	=	request.getParameter("dt_to");
	String  drug_code	=	request.getParameter("drug_code");

	ArrayList patientDetails = new ArrayList();
	patientDetails=bean.getPatientDetails(patient_id);

	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;

	int patientDisplayed=0;

	try{
	
		dt_from		 = CommonBean.checkForNull( dt_from);
		dt_to		 = CommonBean.checkForNull( dt_to );
		patient_id = CommonBean.checkForNull( patient_id );
		drug_code	 = CommonBean.checkForNull( drug_code );
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	ArrayList chkFields = new ArrayList();

	//include all the common parameters.
	//String sql=PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT1");
	//String sql="SELECT   A.DISP_NO,  A.DISP_QTY,  A.ORDER_ID,A.DISP_DRUG_CODE, TO_CHAR(a.added_date,'dd/mm/yyyy hh24:mi') added_date , B.DRUG_DESC,  TO_CHAR(c.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ord_date_time,  D.practitioner_name,  Ph_Order_Source(c.source_code,  c.patient_class,  c.ordering_facility_id,  c.source_type,b.language_id) SOURCE,  c.patient_id,  e.patient_name,  get_age(e.date_of_birth) age ,  DECODE(e.sex,  'M',  'male',  'F',  'female',  'unknown')   gender,A.ORDER_LINE_NO FROM   PH_DISP_DTL A,   PH_DRUG_LANG_VW B,   OR_ORDER c,   AM_PRACTITIONER_LANG_VW D,   MP_PATIENT e, ph_disp_hdr f WHERE   A.disp_drug_code=b.drug_code AND   A.order_id=c.order_id AND   c.ord_pract_id=D.practitioner_id(+)   AND   c.patient_id=e.patient_id    AND   order_category='PH'    AND   c.patient_id=? AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ?";

//Changed Query---for geting Dispensed Records correctly for the incident num:24009 on 28/sept/2010 ---By Sandhya
//Modified Query regarding incident num:26234==By Sandhya==01/FEB/2011 
	String sql="SELECT   A.DISP_NO,  A.DISP_QTY,  A.ORDER_ID,A.DISP_DRUG_CODE, TO_CHAR(a.added_date,'dd/mm/yyyy hh24:mi') added_date , B.DRUG_DESC,  TO_CHAR(c.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ord_date_time,  D.practitioner_name,  Ph_Order_Source(c.source_code,  c.patient_class,  c.ordering_facility_id,  c.source_type,b.language_id) SOURCE,  c.patient_id,  e.patient_name,  get_age(e.date_of_birth) age ,  DECODE(e.sex,  'M',  'male',  'F',  'female',  'unknown')   gender,A.ORDER_LINE_NO FROM   PH_DISP_DTL A,   PH_DRUG_LANG_VW B,   OR_ORDER c,   AM_PRACTITIONER_LANG_VW D,   MP_PATIENT e, ph_disp_hdr f  WHERE   A.disp_drug_code=b.drug_code AND  a.DISP_NO = f.DISP_NO AND   A.order_id=c.order_id AND   c.ord_pract_id=D.practitioner_id(+)   AND   c.patient_id=e.patient_id    AND   order_category='PH'    AND   c.patient_id=? AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ?";
	
	chkFields.add( patient_id.trim() );
	chkFields.add(locale);
	chkFields.add(locale);

	// If drug_code is specified

	if ( (!(drug_code.equals("")))&&(drug_code!=null))
	{
	sql=sql+" AND UPPER(A.disp_drug_code)=UPPER(?)";
	chkFields.add( drug_code.trim() );
	}
	
	if ( (!(dt_from.equals("")))&&(dt_from!=null))
	{
		//if from date is specified
		if ( (!(dt_to.equals("")))&&(dt_to!=null))
		{
		//if to date is also  specified
			sql=sql+" AND TO_DATE(f.DISP_DATE_TIME,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR')";
			chkFields.add( dt_from.trim() );
			chkFields.add( dt_to.trim() );
			
		}
		else
		{
			// if todate is not specified
			//sql=sql+" AND TO_DATE(C.added_date,'DD/MM/RRRR')>= TO_DATE(?,'DD/MM/RRRR') ";
			sql=sql+" AND TO_DATE(f.DISP_DATE_TIME,'DD/MM/RRRR')>= TO_DATE(?,'DD/MM/RRRR') ";
			chkFields.add( dt_from.trim() );
			
		}

	}
	else
	{
		if ( (!(dt_to.equals("")))&&(dt_to!=null))
		{
		//if only  to date is  specified
			sql=sql+" AND TO_DATE(f.DISP_DATE_TIME,'DD/MM/RRRR') <= TO_DATE(?,'DD/MM/RRRR') ";
			chkFields.add( dt_to.trim() );
			
		}
	
			 System.err.println("sql--135-->"+sql);
	}
  
	sql=sql+" ORDER BY C.added_date";
	//System.err.println("sql======>135====>" +sql);

	//End of concatenating search conditions

	sqlMap.put( "sqlData",  sql);
		
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("DRUG_DESC");
	displayFields.add("DISP_QTY");
	displayFields.add("DISP_NO");
	displayFields.add("ADDED_DATE");
	displayFields.add("ORDER_ID");
	displayFields.add("ORD_DATE_TIME");
	displayFields.add("PRACTITIONER_NAME");
	displayFields.add("SOURCE");
	displayFields.add("PATIENT_NAME");
	displayFields.add("AGE");
	displayFields.add("GENDER");
	displayFields.add("ORDER_LINE_NO");
	displayFields.add("DISP_DRUG_CODE");

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){

	%>
	<table cellpadding=0 cellspacing=0 width="100%" align="center" topmargin='0'>
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" topmargin='0'>
				<th width="20%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
				<th width="5%" ><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></th>
				<th width="5%"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
				<th width="15%"><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></th>
				<td width="1%" class="white" style="border-top:0;border-bottom:0;border-left:0;border-right:0">&nbsp;</td>
				<th width="10%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></th>
				<th width="14%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.source.label" bundle="${common_labels}"/></th>
				</tr>
 
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String classvalue="";
		for(int recCount=2; recCount<result.size(); recCount++) 
			{
			if ( recCount % 2 == 0 )
			{classvalue = "QRYODDSMALL" ;
			}
			else
			{	classvalue = "QRYEVENSMALL" ;
			}
			records=(ArrayList) result.get( recCount );
			if (patientDisplayed==0)
			{
				patientDisplayed=1;
				String patient_name=(String)patientDetails.get(0);
				String age=(String)patientDetails.get(1);
				String gender=(String)patientDetails.get(2);
				out.println("<script>loadPatientDetails('"+patient_id+"','"+patient_name+"','"+age+"','"+gender+"');</script>");

			}

		%>

		</tr>
		<tr>
	<%
				
			for(int colCount=0; colCount<records.size(); colCount++){

				
					if (colCount>7)
					{
						continue;
					}
					if (colCount==4)
					{
					out.println("<td class=\"white\" style=\"border-top:0;border-bottom:0;border-left:0;border-right:0\">&nbsp;</td>");
					}
					String dkVal = (String)records.get( colCount );
					String drug_code_db=(String)records.get( records.size()-1 );
			//out.println(drug_code1);	
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					
					if (colCount==4)
				{		
						out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue;border-left:0\" onClick=\"loadOrderDetails('"+dkVal+"','"+(String)records.get(11 )+"')\">");
						out.println(dkVal);
						out.println("</td>"); 

				}else  if (colCount==2)
				{
						out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue\" onClick=\"loadBatchDetails('"+dkVal+"','"+drug_code_db+"')\">");
						out.println(dkVal);
						out.println("</td>");

				}
				else  if (colCount==3 || colCount==5)
				{
			String dtdkval = com.ehis.util.DateUtils.convertDate((String)dkVal,"DMYHM","en",locale);

out.println("<td class='"+classvalue+"' onClick=\"loadOrderDetails('"+dtdkval+"','"+(String)records.get(11 )+"')\">");
						out.println(dtdkval);
						out.println("</td>");


/*	out.println("<td class='"+classvalue+"' style=\"border-right:0\" >");
	out.println(dkVal);
	out.println("</td>");
*/
				}
				else if(colCount==1)
				{
					
					out.println("<td class='"+classvalue+"'>");
					out.println(dfToInteger.format( Double.parseDouble(dkVal))); //Modified for decimal crf 537.12 -- 21-Jan-2010 -- shyampriya
					
					out.println("</td>");
				}
					else
				{
					out.println("<td class='"+classvalue+"'>");
					out.println(dkVal);
					out.println("</td>");

				}
				}
				
					}			//end of record count
			}
			else{
			%>
		<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			    parent.parent.parent.reset();
		</script>
			<%
			}
			%>
	
		</tr>
	<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryDispDrugPatientOrder.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
<% 
  putObjectInBean(bean_id,bean,request);
%>
</html>

