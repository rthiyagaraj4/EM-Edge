<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
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
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/QueryPresVsDispDrug.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	//Search Criteria's from Query Criteria page

	String order_id=request.getParameter("order_id");
	String disp_locn=request.getParameter("disp_locn");
	String disp_locn_code=request.getParameter("disp_locn_code");
	String login_facility_id = (String)session.getValue( "facility_id" );
	
	if(disp_locn==null)
	   disp_locn	=	"";
	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;

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

	try{
		order_id	 = CommonBean.checkForNull( order_id );


%>

	<%
	//Common parameters.
	HashMap sqlMap = new HashMap();
	ArrayList chkFields = new ArrayList();

	//include all the common parameters.
	//String sql=PhRepository.getPhKeyValue("SQL_PH_PRESVSDISP_ORDER_LINE_SELECT");


	//String sql = "SELECT  A.ORDER_LINE_NUM, C.DRUG_DESC||' '||  '('||(RTRIM(rtrim(to_char(A.QTY_VALUE, '999999990.999999'),'0'),'.'))||' '||(SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE=A.QTY_UNIT)||' '||(CASE WHEN C.DRUG_YN='Y' THEN D.FREQ_DESC ELSE '' END) ||')' DOSAGE,  A.ORDER_QTY, (SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE=A.ORDER_UOM) QTYUNIT , (SELECT DRUG_DESC FROM PH_DRUG WHERE DRUG_CODE=B.DISP_DRUG_CODE) DISP_DRUG,  B.DISP_QTY, (SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE=B.DISP_UOM_CODE) DISPUNIT, B.DISP_NO, TO_CHAR(TO_DATE(B.ADDED_DATE,'DD/MM/RRRR HH24:MI'),'DD/MM/RRRR')  RECORD_DATE_TIME  FROM    OR_ORDER_LINE A,   PH_DISP_DTL B,   PH_DRUG C,   AM_FREQUENCY D   WHERE   A.ORDER_ID=B.ORDER_ID(+) AND A.ORDER_LINE_NUM=B.ORDER_LINE_NO(+)   AND A.ORDER_CATALOG_CODE=C.DRUG_CODE   AND A.FREQ_CODE=D.FREQ_CODE(+)   AND A.ORDER_ID=?";
	//String sql = "SELECT  A.ORDER_LINE_NUM, C.DRUG_DESC||' '||  '('||(RTRIM(rtrim(to_char(A.QTY_VALUE, '999999990.999999'),'0'),'.'))||' '||PH_GET_UOM_DISPLAY(?,A.QTY_UNIT,?)||' '||(CASE WHEN C.DRUG_YN='Y' THEN D.FREQ_DESC ELSE '' END) ||')' DOSAGE,  A.ORDER_QTY, PH_GET_UOM_DISPLAY(?,A.ORDER_UOM,?) QTYUNIT , (SELECT DRUG_DESC FROM PH_DRUG WHERE DRUG_CODE=B.DISP_DRUG_CODE) DISP_DRUG,  B.DISP_QTY,PH_GET_UOM_DISPLAY(?,B.DISP_UOM_CODE,?) DISPUNIT, B.DISP_NO, TO_CHAR(TO_DATE(B.ADDED_DATE,'DD/MM/RRRR HH24:MI'),'DD/MM/RRRR')  RECORD_DATE_TIME  FROM    OR_ORDER_LINE A,   PH_DISP_DTL B,   PH_DRUG C,   AM_FREQUENCY D   WHERE   A.ORDER_ID=B.ORDER_ID(+) AND A.ORDER_LINE_NUM=B.ORDER_LINE_NO(+)   AND A.ORDER_CATALOG_CODE=C.DRUG_CODE   AND A.FREQ_CODE=D.FREQ_CODE(+)   AND A.ORDER_ID=?";

	//Modified Above Query for getting Drug name into Thai Language Regarding incident num:25317 on 6/DEC/2010==By Sandhya
	String sql = "SELECT  A.ORDER_LINE_NUM, C.DRUG_DESC||' '||  '('||(RTRIM(rtrim(to_char(A.QTY_VALUE, '999999990.999999'),'0'),'.'))||' '||PH_GET_UOM_DISPLAY(?,A.QTY_UNIT,?)||' '||(CASE WHEN C.DRUG_YN='Y' THEN D.FREQ_DESC ELSE '' END) ||')' DOSAGE,  A.ORDER_QTY, PH_GET_UOM_DISPLAY(?,A.ORDER_UOM,?) QTYUNIT , (SELECT DRUG_DESC FROM PH_DRUG_LANG_VW WHERE DRUG_CODE=B.DISP_DRUG_CODE AND LANGUAGE_ID=?) DISP_DRUG,  B.DISP_QTY,PH_GET_UOM_DISPLAY(?,B.DISP_UOM_CODE,?) DISPUNIT, B.DISP_NO, TO_CHAR(TO_DATE(B.ADDED_DATE,'DD/MM/RRRR HH24:MI'),'DD/MM/RRRR')  RECORD_DATE_TIME  FROM    OR_ORDER_LINE A,   PH_DISP_DTL B,   PH_DRUG_LANG_VW C,   AM_FREQUENCY D   WHERE   A.ORDER_ID=B.ORDER_ID(+) AND A.ORDER_LINE_NUM=B.ORDER_LINE_NO(+)   AND A.ORDER_CATALOG_CODE=C.DRUG_CODE   AND A.FREQ_CODE=D.FREQ_CODE(+)   AND A.ORDER_ID=? AND C.LANGUAGE_ID=?";



   chkFields.add( login_facility_id );
   chkFields.add( locale );
   chkFields.add( login_facility_id );
   chkFields.add( locale );
   chkFields.add( locale ); //added 
   chkFields.add( login_facility_id );
   chkFields.add( locale );
	chkFields.add( order_id.trim() );
	chkFields.add( locale );

	
	sqlMap.put( "sqlData",  sql);
		
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("ORDER_LINE_NUM");
	displayFields.add("DOSAGE");
	displayFields.add("ORDER_QTY");
	displayFields.add("QTYUNIT");
	displayFields.add("DISP_DRUG");
	displayFields.add("DISP_QTY");
	displayFields.add("DISPUNIT");
	displayFields.add("DISP_NO");
	displayFields.add("RECORD_DATE_TIME");

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
		<tr>
		<th colspan=4 align="left"><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/>  (<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>:<%=order_id%>)</th>
		<td class="white" style="border-top:0;border-bottom:0">&nbsp;</td>
		<th colspan=5 align="left"><fmt:message key="ePH.DispenseDetail.label" bundle="${ph_labels}"/>
( <fmt:message key="ePH.DispensedAt.label" bundle="${ph_labels}"/>:<%=disp_locn_code%>)
	
	</th>
		</tr>
		<tr>
		<th width="7%" ><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></th>
		<th width="25%"><fmt:message key="ePH.Drug/dose.label" bundle="${ph_labels}"/></th>
		<th width="4%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<th width="11%"><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></th>
		<td class="white" style="border-top:0;border-bottom:0">&nbsp;&nbsp;</td>
		<th width="25%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
		<th width="4%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<th width="11%"><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></th>
		<th width="8%"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
		<th width="5%"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
		</tr>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String classvalue="";
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;
	%>
		</tr>
		<tr>
	<%
			records=(ArrayList) result.get( recCount );
			System.out.println("records debug added for AMS-SCF-0403"+records);
		
			for(int colCount=0; colCount<records.size(); colCount++){

					String dkVal = (String)records.get( colCount );

					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					if(colCount==2)
					{
						//Modified for decimal crf 537.12   -- 21-Jan -2010 --   shyampriya
						String ord_qty	=	dfToInteger.format( Double.parseDouble((String)records.get(2)));
						out.println("<td class='"+classvalue+"'>"); 
						out.println(ord_qty); 
						out.println("</td>");
					}
					else if(colCount==5)
					{
						String disp_qty	="";
						if((String)records.get(5)!=null) {
						    disp_qty	=	dfToInteger.format( Double.parseDouble((String)records.get(5)));
						}
						out.println("<td class='"+classvalue+"'>"); 
						out.println(disp_qty); 
						out.println("</td>");
					}
					else if(colCount==8){
						String date	="";
                        if((String)records.get(8)!=null) {
						    date	=	com.ehis.util.DateUtils.convertDate((String)records.get(8),"DMY","en",locale);
						}
						out.println("<td class='"+classvalue+"'>"); 
						out.println(date); 
						out.println("</td>");
					}else{
						out.println("<td class='"+classvalue+"' >");
						out.println(dkVal);
						out.println("</td>");
					}
					if (colCount==3)
					{
						out.println("<td class=\"white\" style=\"border-top:0;border-bottom:0\">&nbsp;</td>");
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPresVsDispOrder.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
</html>

