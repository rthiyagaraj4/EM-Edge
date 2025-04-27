<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../js/QueryDispTrialDrug.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
<%
	//Search Criteria's from Query Criteria page
		String dt_from	=	request.getParameter("dt_from");
	String  dt_to	=	request.getParameter("dt_to");
	String  drug_code	=	request.getParameter("drug_code");
	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	try{
	
		dt_from		 = CommonBean.checkForNull( dt_from);
		dt_to		 = CommonBean.checkForNull( dt_to );
		drug_code	 = CommonBean.checkForNull( drug_code );
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	ArrayList chkFields = new ArrayList();

	//include all the common parameters.
	String sql=PhRepository.getPhKeyValue("SQL_QUERY_DISP_TRIAL_DRUG_SUMMARY");
	// If drug_code is specified

	if ( (!(dt_from.equals("")))&&(dt_from!=null))
	{
		//if from date is specified
		if ( (!(dt_to.equals("")))&&(dt_to!=null))
		{
		//if to date is also  specified
			sql=sql+" AND TO_DATE(A.added_date,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR')";
			chkFields.add( dt_from.trim() );
			chkFields.add( dt_to.trim() );
		}
		else
		{
			// if todate is not specified
			sql=sql+" AND TO_DATE(A.added_date,'DD/MM/RRRR')>= TO_DATE(?,'DD/MM/RRRR') ";
			chkFields.add( dt_from.trim() );
		}

	}
	else
	{
		if ( (!(dt_to.equals("")))&&(dt_to!=null))
		{
		//if only  to date is  specified
			sql=sql+" AND TO_DATE(A.added_date,'DD/MM/RRRR') <= TO_DATE(?,'DD/MM/RRRR') ";
			chkFields.add( dt_to.trim() );

		}
	

	}
	if ( (!(drug_code.equals("")))&&(drug_code!=null))
	{
			sql=sql+" AND B.DRUG_CODE=?";
			chkFields.add( drug_code.trim() );
	}  
	sql=sql+" group by b.drug_code,b.drug_desc,b.pres_base_uom";
	sqlMap.put( "sqlData",  sql);
		
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("DRUG_DESC");
	displayFields.add("PATIENTS");
	displayFields.add("DISP_QTY");
	displayFields.add("RETURNED_QTY");
	displayFields.add("PRES_BASE_UOM");
	displayFields.add("DRUG_CODE");
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){

	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center" topmargin='0'>
		<tr>
		<th align="left"><fmt:message key="ePH.TrialDrugs.label" bundle="${ph_labels}"/></th>
		</tr>
		</table>
<%
	if (  ( (String)result.get(1)!=null ) && ( (String)result.get(1)!="" ) )
		{
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
		<%
		}
	%>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" topmargin='0'>
				<th width="30%">Drug Name</th>
				<th width="20%" ><fmt:message key="ePH.NoofPatients.label" bundle="${ph_labels}"/></th>
				<th width="30%">Qty Dispensed</th>
				<th width="20%">Returned Qty</th>
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
		
		%>

		</tr>
		<tr>
	<%
			for(int colCount=0; colCount<records.size(); colCount++){

					if (colCount>3)
				{
					 continue;
				}
					String dkVal = (String)records.get( colCount );
				
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					

				 if (colCount==0)
				{
						out.println("<td class='"+classvalue+"' style=\"cursor:pointer;color:blue\" onClick=\"loadDetailsfromSummary('"+(String)records.get(5)+"','"+dt_from+"','"+dt_to+"','"+dkVal+"','"+"','"+(String)records.get(4)+"')\">");
						out.println(dkVal);
						out.println("</td>");

				}
				else if ((colCount==2)||(colCount==3))
				{
				out.println("<td class='"+classvalue+"'>");
				out.println(dkVal+' '+(String)records.get(4));
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
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));parent.parent.parent.reset(); </script>
			<%
			}
			%>
	
		</tr>
	<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryDispTrialDrugSummary.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
</html>

