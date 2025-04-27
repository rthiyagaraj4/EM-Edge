<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

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

	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends

    String locale			= (String)session.getAttribute("LOCALE");
 
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>

 <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String order_id=request.getParameter("order_id");
	String disp_no=request.getParameter("disp_no");
	String order_line_num=request.getParameter("order_line_num");
	String patient_details=request.getParameter("patient_details");
	//Common parameters.
	HashMap sqlMap = new HashMap();
	ArrayList chkFields = new ArrayList();
	String sql="";
	int orderDetails=0;

	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		order_id	 = CommonBean.checkForNull( order_id );
		disp_no	 = CommonBean.checkForNull( disp_no );
		order_line_num = CommonBean.checkForNull( order_line_num);
		//Function Parameters
		HashMap funcMap = new HashMap();

	//The fields are going to be display
		ArrayList displayFields = new ArrayList();
	
		if ((disp_no=="")||(disp_no.equals(""))||(disp_no==null)||(disp_no.equals("null")))
		{
			orderDetails=1;
			sql=PhRepository.getPhKeyValue("SQL_DISP_TRIAL_DRUG_BY_PATIENT_SELECT3");
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add( order_id.trim() );
			chkFields.add( order_line_num.trim() );
			chkFields.add(locale);
			chkFields.add(locale);
			displayFields.add("DRUG_DESC");
			displayFields.add("STRENGTH");
			displayFields.add("DOSAGE");
			displayFields.add("ROUTE");
			displayFields.add("FREQUENCY");
			displayFields.add("DURATION");
			displayFields.add("ORDERQTY");

		}
		else
		{
			orderDetails=0;
			sql=PhRepository.getPhKeyValue("SQL_DISP_TRIAL_DRUG_BY_PATIENT_SELECT4");
			chkFields.add(locale);
			chkFields.add( disp_no.trim() );
			chkFields.add(locale);
			displayFields.add("DISP_NO");
			displayFields.add("DISP_DATE");
			displayFields.add("TRADENAME");
			displayFields.add("BATCH_ID");
			displayFields.add("EXPIRY_DATE");
			displayFields.add("DISP_QTY");
			displayFields.add("DISP_QTY_UOM");
			displayFields.add("DRUG_DESC");
			
		}
	
	
	sqlMap.put( "sqlData",  sql);
		


	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
	<table cellpadding=0 cellspacing=0 width="99%" align="center" topmargin="0" >
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<%
		if (orderDetails==1)
		{
		%>
				<tr><th colspan=7 align="left"> <fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>(<%=patient_details%>)</th>		</tr>
				<tr>
				<th width="30%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></th>
				</tr>


			<%
		}

			//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String classvalue="";
		for(int recCount=2; recCount<result.size(); recCount++) {
			records=(ArrayList) result.get( recCount );
			if ((orderDetails==0)&&(recCount==2))
			{
				%>
				<tr><th colspan="7" align="left"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> (<%=patient_details%>)</th>		</tr>
				<tr>
				<th width="10%" ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
				<th width="15%"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th width="30%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></th>
				</tr>

			<%
				}


			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;
	%>
		</tr>
		<tr>
	<%
			
		
			for(int colCount=0; colCount<records.size(); colCount++){

				if ((orderDetails==0)&&(colCount>6))
				{
					continue;
				}
				
					String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

				if(colCount==1 || colCount==4) 
				{
          
			
					if( !disp_no.equals("")){
						 dkVal=com.ehis.util.DateUtils.convertDate((String)dkVal,"DMY","en",locale);
					}
					out.println("<td>"); 
					out.println(dkVal); 
					out.println("</td>"); 
				}

				else{
					out.println("<td class='"+classvalue+"' >");
					out.println(dkVal);
					out.println("</td>");
				}  
				} 
				
				}			//end of record count for loop
			}
			else{
			%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
			<%
			}
			%>
	
		</tr>
	<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryDispTrialDrugOrderLine.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
</html>

