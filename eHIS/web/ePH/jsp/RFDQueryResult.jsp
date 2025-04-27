<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/RFD.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	//Search Criteria's from Query Criteria page
	String Rf_Id		= request.getParameter( "RF_Id" );
	String Rf_Name		= request.getParameter( "RF_Name" ) ;
	String Drug_Code	= request.getParameter( "DrugCode" ) ;
	String Drug_Desc	= request.getParameter( "drug_desc" ) ;
   	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;	
//Added bean_id,facility_id  on 9/April/2010 for the incident num:20584
	String facility_id	= (String) session.getValue("facility_id");
	String bean_id		= "RFDBean" ;
	String bean_name	= "ePH.RFDBean";
	RFDBean bean = (RFDBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);




try{
	String classvalue			= "";

	Rf_Id = CommonBean.checkForNull( Rf_Id );
	Rf_Name = CommonBean.checkForNull( Rf_Name );
	Drug_Code = CommonBean.checkForNull( Drug_Code );
	Drug_Desc = CommonBean.checkForNull( Drug_Desc );

	//Common parameters.
	HashMap sqlMap = new HashMap();
//	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_RFD_QUERY"));
   
	String sqlQuery = "SELECT A.RF_ID, A.DRUG_CODE, B.DRUG_DESC, A.RF_QTY, A.RF_QTY_UOM, C.RF_NAME,A.DEFAULT_YN FROM PH_RECONST_FLUID_FOR_DRUG A, PH_DRUG B, PH_RECONST_FLUID C WHERE A.DRUG_CODE = B.DRUG_CODE  AND A.RF_ID = C.RF_ID AND UPPER(B.DRUG_CODE) LIKE NVL (UPPER(?), '%')   AND UPPER(B.DRUG_DESC) LIKE NVL (UPPER(?), '%') AND UPPER(A.RF_ID) LIKE NVL (UPPER(?), '%')  AND UPPER(C.RF_NAME) LIKE NVL (UPPER(?), '%')";
	
	sqlMap.put( "sqlData", sqlQuery);

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "RF_ID" );
	displayFields.add( "RF_NAME" );
	displayFields.add( "DRUG_CODE" );
	displayFields.add( "DRUG_DESC" );
	displayFields.add( "RF_QTY" );
	displayFields.add( "RF_QTY_UOM" );
	displayFields.add( "DEFAULT_YN" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( Drug_Code.trim() + "%" );
	chkFields.add( Drug_Desc.trim() + "%" );
	chkFields.add( Rf_Id.trim() + "%" );
	chkFields.add( Rf_Name.trim() + "%" );
	
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
  
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
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
		<th  style="width:15%"><fmt:message key="ePH.FluidID.label" bundle="${ph_labels}"/></th><th style="width:20%"><fmt:message key="Common.FluidName.label" bundle="${common_labels}"/></th>
		<th style="width:15%"><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/> </th><th style="width:20%">
		<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th><th style="width:10%"><fmt:message key="ePH.RFQuantity.label" bundle="${ph_labels}"/> 
		</th><th style="width:10%"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th><th style="width:10%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<!-- <tr onClick="Modify(this);" > --><tr>
	<%

			String link_columns = "";
			records=(ArrayList) result.get( recCount );			
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					
	%>
			<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%>   </font></td>
	<%
				}else{
					
					//out.println("(String)records.get( colCount )=====126=====>" +(String)records.get( colCount ));
					
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=records.get( colCount ).toString()%>"
	<%
				
				String dkVal = (String)records.get( colCount );
               
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					if((colCount==6)){
 						out.println("align=\"center\">");
						out.println(getImage(dkVal));
						out.println("</td>");
					}//if
					//Added Else if condition to convert UOM value to code & description 												according to parameter facility set up for the incident Num:20584  on 09-April-2010.
					else if (colCount==5){
						
					out.println("align=\"left\">");
					dkVal =	bean.getUomDisplay(facility_id,records.get( colCount ).toString());
					out.println(dkVal);
					out.println("</td>");
					}
					else
					{
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
					}
					dkVal = "";
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
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/RFDQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
}
%>
</body>
</html>

