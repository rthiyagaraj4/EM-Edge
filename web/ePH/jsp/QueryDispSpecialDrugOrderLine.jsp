<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
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
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	 bean_name		=	"ePH.QueryPresVsDispDrugsBean";
	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request ) ;
	
	bean.setLanguageId(locale);
		
	String order_id=request.getParameter("order_id");
	String disp_no=request.getParameter("disp_no");
	String order_line_num=request.getParameter("order_line_num");
	String patient_details=request.getParameter("patient_details");
	
	/*==============================================================================================================*/
		java.util.StringTokenizer st = new java.util.StringTokenizer(patient_details,",");
		String clval="";
		StringBuffer sb=new StringBuffer();
		String gender_String="";
					while( st.hasMoreTokens()) {

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
						
						clval=sb.toString()+" "+gender_String;

					}
/*==============================================================================================================*/

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
	
		HashMap funcMap = new HashMap();

	//The fields are going to be display
		ArrayList displayFields = new ArrayList();
	
		if ((disp_no=="")||(disp_no.equals(""))||(disp_no==null)||(disp_no.equals("null")))
		{
			orderDetails=1;
			//sql=PhRepository.getPhKeyValue("SQL_DISP_SPECIAL_DRUG_BY_PATIENT_SELECT3");
			sql = "SELECT   B.DRUG_DESC,B.STRENGTH_VALUE||' '||PH_GET_UOM_DISPLAY(?,b.strength_uom,?) STRENGTH,  A.QTY_VALUE||' '||PH_GET_UOM_DISPLAY(?,a.qty_unit,?)  DOSAGE, (SELECT ROUTE_DESC FROM PH_ROUTE_LANG_VW PH_ROUTE WHERE ROUTE_CODE=A.ROUTE_CODE AND LANGUAGE_ID = ?) ROUTE, (SELECT FREQ_DESC FROM AM_FREQUENCY_LANG_VW AM_FREQUENCY WHERE FREQ_CODE=A.FREQ_CODE AND LANGUAGE_ID = ?) FREQUENCY, A.DURN_VALUE||' '||(SELECT DURN_DESC  FROM AM_DURATION_TYPE_LANG_VW AM_DURATION_TYPE WHERE DURN_TYPE=A.DURN_TYPE AND LANGUAGE_ID = ?) DURATION,A.ORDER_QTY||' '||PH_GET_UOM_DISPLAY(?,a.order_uom,?) ORDERQTY FROM OR_ORDER_LINE A,PH_DRUG_LANG_VW B,PH_ROUTE_LANG_VW C WHERE A.ORDER_CATALOG_CODE=B.DRUG_CODE AND A.ROUTE_CODE=C.ROUTE_CODE(+) AND A.ORDER_ID=?  AND A.ORDER_LINE_NUM=? AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID(+) = ?";
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(locale);
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(bean.getLoginFacilityId());
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
			//sql=PhRepository.getPhKeyValue("SQL_DISP_SPECIAL_DRUG_BY_PATIENT_SELECT4");
			sql = "SELECT   C.DRUG_DESC,A.DISP_NO,TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY') DISP_DATE,   (SELECT SHORT_NAME FROM AM_TRADE_NAME_LANG_VW WHERE TRADE_ID = A.TRADE_ID AND LANGUAGE_ID = ?) TRADENAME,   A.BATCH_ID, TO_CHAR(A.EXPIRY_DATE,'DD/MM/YYYY') EXPIRY_DATE, A.DISP_QTY,    B.DISP_UOM_CODE DISP_QTY_UOM FROM      PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DRUG_LANG_VW C WHERE A.DISP_NO=B.DISP_NO  AND A.DRUG_CODE=C.DRUG_CODE AND A.DISP_NO=? AND C.LANGUAGE_ID = ?";
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
				<tr><th colspan=7 align="left"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>(<%=clval%>)</th></tr>
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

			
		ArrayList records=new ArrayList();
		String classvalue="";
		for(int recCount=2; recCount<result.size(); recCount++) {
			records=(ArrayList) result.get( recCount );

			if ((orderDetails==0)&&(recCount==2))
			{
				%>
				<tr><th colspan=7 align="left"> <fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> (<%=clval%>)</th></tr>
				<tr>
				<th width="10%" ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
				<th width="15%"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
			<th width="30%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
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
/*===========================================================================================================*/
//added for IN26383 --10/02/2011-- priya
				else if(orderDetails==0 && colCount==6)
				{
					out.println("<td>"); 
					if(dkVal!= null && !(dkVal.equals("")))
					out.println(bean.getUomDisplay(bean.getLoginFacilityId(),(String) dkVal)); 
					out.println("</td>"); 
				}
/*===========================================================================================================*/

				else{
					out.println("<td class='"+classvalue+"' >");
					out.println(dkVal);
					out.println("</td>");
				}  
			
				}
				
				}			
			}
			else{
			%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
			<%
			}
			%>
	
		</tr>
	<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryDispSpecialDrugOrderLine.jsp", searched) );
		}
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
</html>

