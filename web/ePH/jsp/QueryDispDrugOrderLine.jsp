<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/QueryDispDrug.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	//Search Criteria's from Query Criteria page
	//Search Criteria's from Query Criteria page
	//String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	//String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";

	String order_id=request.getParameter("order_id");
	String disp_no=request.getParameter("disp_no");
	String order_line_num=request.getParameter("order_line_num");
	String patient_details=request.getParameter("patient_details");
    String facility_id		= (String) session.getValue("facility_id");//Modified for CRF--0749 INC-13640
	String patient_id =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");// patiend id added for SCF No : 0892 Inc No:[40991] 
    String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";
	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request);

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

	String sql="";

	int orderDetails=0;

	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		order_id	 = CommonBean.checkForNull( order_id );
		disp_no	 = CommonBean.checkForNull( disp_no );
		order_line_num = CommonBean.checkForNull( order_line_num);
	
		//include all the common parameters.
		//Function Parameters
		HashMap funcMap = new HashMap();

	//The fields are going to be display
		ArrayList displayFields = new ArrayList();
	
		if ((disp_no=="")||(disp_no.equals(""))||(disp_no==null)||(disp_no.equals("null")))
		{
			orderDetails=1;
			//sql=PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT3");
			sql = "SELECT   B.DRUG_DESC,B.STRENGTH_VALUE||' '||B.STRENGTH_UOM STRENGTH,  decode (d.SLIDING_SCALE_YN ,'Y','Sliding Scale',a.qty_value || ' ' || a.qty_unit) dosage, (SELECT ROUTE_DESC FROM PH_ROUTE_LANG_VW WHERE ROUTE_CODE=A.ROUTE_CODE and language_id = ?) ROUTE, (SELECT FREQ_DESC FROM AM_FREQUENCY_LANG_VW WHERE FREQ_CODE=A.FREQ_CODE and language_id = ?) FREQUENCY, A.DURN_VALUE||' '||(SELECT DURN_DESC  FROM AM_DURATION_TYPE_LANG_VW WHERE DURN_TYPE=A.DURN_TYPE and language_id = ?) DURATION,A.ORDER_QTY||' '||A.ORDER_UOM ORDERQTY FROM OR_ORDER_LINE A,PH_DRUG_LANG_VW B,PH_ROUTE C ,or_order_line_ph d WHERE A.ORDER_CATALOG_CODE=B.DRUG_CODE and a.order_id =d.order_id  and a.order_line_num =d.ORDER_LINE_NUM AND A.ROUTE_CODE=C.ROUTE_CODE(+) AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=? and b.language_id = ? "; //Query modified to get Thai conversions for drug_desc, route, freq, durn for IN26128 --01/02/2011-- priya
			chkFields.add( locale );
			chkFields.add( locale );
			chkFields.add( locale );
			chkFields.add( order_id.trim() );
			chkFields.add( order_line_num.trim() );
			chkFields.add( locale );
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
			//sql=PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT4");
			sql = "SELECT DISTINCT (a.batch_id), c.drug_desc, a.disp_no,TO_CHAR (b.added_date, 'DD/MM/YYYY') disp_date,d.short_name tradename,a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,a.disp_qty, b.disp_uom_code disp_qty_uom     FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_drug_lang_vw c,am_trade_name d WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.drug_code = b.disp_drug_code AND a.drug_code = c.drug_code AND a.disp_no = ? and c.language_id =? and a.trade_id= d.trade_id AND b.disp_drug_code = ?";
			chkFields.add( disp_no.trim() );
			chkFields.add( locale );
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
    <FORM name="QueryDispDrugOrderLineForm" id="QueryDispDrugOrderLineForm" >
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
				<tr><th colspan=7><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> (<%=patient_id%>,<%=clval%>)</th></tr><!-- patiend id added for SCF No : 0892 Inc No:[40991] -->
				<tr>
				<th width="30%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/>	
				</th>
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
				<tr><th colspan=7 > <fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>(<%=patient_id%>,<%=clval%>)</th></tr><!-- patiend id added for SCF No : 0892 Inc No:[40991] -->
				<tr>
				<th width="10%" ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
				<th width="15%"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
			<th width="30%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>	
				</th>
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
		
					out.println("<td class='"+classvalue+"' >");
					if ((orderDetails==1)&&(colCount==1 ||colCount==2 ||colCount==6))//Modified for CRF--0749 INC-13640
					{
						String qty= "";
						String uom="";
						ArrayList quantityANDuom = new ArrayList();
						if(!dkVal.equals("Sliding Scale")){
							StringTokenizer stk = new StringTokenizer(dkVal," ");
							while(stk.hasMoreTokens()){
								  quantityANDuom.add(stk.nextToken());
							}
							if(quantityANDuom.size()==2){
							//Modified for decimal crf 537.12   -- 21-Jan -2010 --   shyampriya
								qty	=	dfToInteger.format( Double.parseDouble((String)quantityANDuom.get(0))); 						
								uom	=	(String)quantityANDuom.get(1);
												
								out.println(qty+" "+bean.getUomDisplay(facility_id,uom));
							}
						}else{
							out.println(dkVal);
						}
					}else{
						out.println(dkVal);
					}
					out.println("</td>");
			
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPresVsDispOrder.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>
	</FORM><!-- Modified for CRF--0749 INC-13640 -->
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

