<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../js/QueryDispSpecialDrug.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
        <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
<%
	//Search Criteria's from Query Criteria page
	String dt_from	=	request.getParameter("dt_from");
	String  dt_to	=	request.getParameter("dt_to");
	String  drug_code	=	request.getParameter("drug_code");
	String  fromSummary	=	request.getParameter("fromSummary");
	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	
	String bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	 bean_name		=	"ePH.QueryPresVsDispDrugsBean";
	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request ) ;
	
	bean.setLanguageId(locale);

	try{
	
		dt_from		 = CommonBean.checkForNull( dt_from);
		dt_to		 = CommonBean.checkForNull( dt_to );
		drug_code	 = CommonBean.checkForNull( drug_code );
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	ArrayList chkFields = new ArrayList();

	//include all the common parameters.
	//String sql=PhRepository.getPhKeyValue("SQL_QUERY_DISP_SPECIAL_DRUG_SELECT2");
	String sql = "SELECT A.DISP_NO, A.DISP_QTY, A.ORDER_ID, TO_CHAR (TO_DATE (C.ADDED_DATE, 'DD/MM/RRRR HH24:MI'), 'DD/MM/YYYY HH:MI') ADDED_DATE, B.DRUG_DESC, TO_CHAR (TO_DATE (C.ORD_DATE_TIME, 'DD/MM/RRRR HH24:MI'), 'DD/MM/YYYY HH:MI' ) ORD_DATE_TIME, D.PRACTITIONER_NAME, PH_ORDER_SOURCE (C.SOURCE_CODE, C.PATIENT_CLASS, C.ORDERING_FACILITY_ID, C.SOURCE_TYPE,B.LANGUAGE_ID) SOURCE, C.PATIENT_ID, E.PATIENT_NAME || ' ,   ' || GET_AGE (E.DATE_OF_BIRTH) || ',   ' || DECODE (E.SEX, 'M', 'male', 'F', 'female', 'unknown')  PATIENTDETAILS, A.ORDER_LINE_NO, B.DRUG_DESC, PH_GET_UOM_DISPLAY(?,B.PRES_BASE_UOM,?) PRES_BASE_UOM FROM PH_DISP_DTL A, PH_DRUG_LANG_VW B, OR_ORDER C, AM_PRACTITIONER_LANG_VW D, MP_PATIENT E WHERE A.DISP_DRUG_CODE = B.DRUG_CODE AND A.ORDER_ID = C.ORDER_ID AND C.ORD_PRACT_ID = D.PRACTITIONER_ID(+) AND C.PATIENT_ID = E.PATIENT_ID AND C.ORDER_CATEGORY = 'PH' AND EXISTS ( SELECT B1.ORDER_CATALOG_CODE  FROM OR_ORDER_CATALOG A1, OR_ORDER_CATALOG_BY_PTCL B1 WHERE A1.ORDER_CATALOG_CODE = B1.ORDER_CATALOG_CODE   AND B1.ORD_SPL_APPR_REQD_YN = 'Y'   AND A1.ORDER_CATEGORY = 'PH' AND B1.ORDER_CATALOG_CODE = A.DISP_DRUG_CODE) AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ?";
	chkFields.add(bean.getLoginFacilityId());
	chkFields.add(locale);
	chkFields.add(locale);
	chkFields.add(locale);

	// If drug_code is specified

	if ( (!(dt_from.equals("")))&&(dt_from!=null))
	{
		//if from date is specified
		if ( (!(dt_to.equals("")))&&(dt_to!=null))
		{
		
			sql=sql+" AND TO_DATE(C.added_date,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR')";
			chkFields.add( dt_from.trim() );
			chkFields.add( dt_to.trim() );
		}
		else
		{
			// if todate is not specified
			sql=sql+" AND TO_DATE(C.added_date,'DD/MM/RRRR')>= TO_DATE(?,'DD/MM/RRRR') ";
			chkFields.add( dt_from.trim() );
		}

	}
	else
	{
		if ( (!(dt_to.equals("")))&&(dt_to!=null))
		{
		//if only  to date is  specified
			sql=sql+" AND TO_DATE(C.added_date,'DD/MM/RRRR') <= TO_DATE(?,'DD/MM/RRRR') ";
			chkFields.add( dt_to.trim() );

		}
	

	}
	if ( (!(drug_code.equals("")))&&(drug_code!=null))
	{
			sql=sql+" AND B.DRUG_CODE=?";
			chkFields.add( drug_code.trim() );
	}  
	sql=sql+" ORDER BY C.added_date";
	sqlMap.put( "sqlData",  sql);
	
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("PATIENTDETAILS");
	displayFields.add("DISP_QTY");
	displayFields.add("DISP_NO");
	displayFields.add("ADDED_DATE");
	displayFields.add("ORDER_ID");
	displayFields.add("ORD_DATE_TIME");
	displayFields.add("PRACTITIONER_NAME");
	displayFields.add("SOURCE");
	displayFields.add("ORDER_LINE_NO");
	displayFields.add("DRUG_DESC");
	displayFields.add("PRES_BASE_UOM");



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
				<th width="25%"><fmt:message key="ePH.PatientNameAgeSex.label" bundle="${ph_labels}"/></th>
				<th width="5%" ><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></th>
				<th width="5%"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
				<th width="15%"><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></th>
				<th width="10%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.source.label" bundle="${common_labels}"/></th>
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
			if (recCount==2)
			{
				//out.println(records.size());
				out.println("<script>loadDrugDetails(\"+(String)records.get(9)+\",'+(String)records.get(10)+','+drug_code+');</script>");
			}
		
		%>
 
		</tr>
		<tr>
	<%
			
			for(int colCount=0; colCount<records.size(); colCount++){

					
					String dkVal = (String)records.get( colCount );
						
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					if(fromSummary ==null) fromSummary ="";
					if (colCount==4)
					{
					if (fromSummary.equals("0"))
					{
						//summary loaded is false
							out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue\" onClick=\"loadOrderDetails('"+dkVal+"','"+(String)records.get(8 )+"','"+(String)records.get(0)+"',0)\">");
					}
					else
					{
							out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue\" onClick=\"loadOrderDetails('"+dkVal+"','"+(String)records.get(8 )+"','"+(String)records.get(0)+"',1)\">");
					}
					
					
						out.println(dkVal);
						out.println("</td>");

				}
				else  if (colCount==3 || colCount==5)
				{
				String dtdkval = com.ehis.util.DateUtils.convertDate((String)dkVal,"DMYHM","en",locale);

				out.println("<td class='"+classvalue+"','"+dtdkval+"','"+(String)records.get(0)+"',0)\">");
				out.println(dtdkval);
				out.println("</td>");
				}
					
				
				else  if (colCount==2)
				{

							if (fromSummary.equals("0"))
					{
			
							//summary loaded is false
						out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue\" onClick=\"loadBatchDetails('"+dkVal+"','"+(String)records.get(0 )+"',0)\">");
					}
					else
					{
						out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue\" onClick=\"loadBatchDetails('"+dkVal+"','"+(String)records.get(0 )+"',1)\">");
					}
					out.println(dkVal);
					out.println("</td>");

				}
					else
				{
					if (colCount>7)
					{
						continue;
					}



					if(colCount==0)
					{
						
						String gender_String="";
						String comp_str1="";
						String patdesc="";
						StringBuffer sb=new StringBuffer();
						java.util.StringTokenizer st = new java.util.StringTokenizer(dkVal.trim(),",");
												
						while( st.hasMoreTokens()){
							String comp_str = st.nextToken();
							
							if((! (comp_str.trim().equals("female") || comp_str.trim().equals("male") || comp_str.trim().equals("unknown") )))
							{
								
							sb.append(comp_str.trim()+" ");
							}
							 
							
							if(comp_str.trim().equals("female"))
							{
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							
							}
							if(comp_str.trim().equals("male"))
							{
								gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
								
							}
							if(comp_str.trim().equals("unknown"))
							{
								gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
								
							}
							
							patdesc=sb.toString()+" "+gender_String;
							dkVal=patdesc;					
					}
					}
					out.println("<td class='"+classvalue+"'>");
					out.println(dkVal);
					out.println("</td>");

				}
				}
				
					}			//end of record count
			}
			else{
			%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); </script>
			<%
			} 
			%>
	
		</tr>
	<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryDispSpecialDrugOrder.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
</html>

