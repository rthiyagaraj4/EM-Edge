<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.*,java.sql.Connection,webbeans.eCommon.ConnectionManager" %> <!-- Connection and ConnectionManager  Added for ML-MMOH-CRF-1126 -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>

<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
		//Added  for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
	//
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/TPNConsGeneric.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<br>
<%
	//Search Criteria's from Query Criteria page

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

	Connection con=null; // Added for ML-MMOH-CRF-1126

try{
	String classvalue			= "";

	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	
	con = ConnectionManager.getConnection(request);	// Added for ML-MMOH-CRF-1126 - Start
	boolean display_enable_yn = CommonBean.isSiteSpecific(con, "PH", "ASSESMENT_REQ_YN");
	
    if(display_enable_yn){  
	  sqlMap.put( "sqlData","SELECT a.CONST_GENERIC_CODE, a.CONST_GENERIC_NAME, a.DISP_SRL_NO, a.CONST_GROUP_CODE, b.CONST_GROUP_NAME, a.UOM_SETUP_LEVEL_IND,a.EFF_STATUS FROM ph_tpn_const_gen_name_lang_vw a, ph_tpn_const_grp_lang_vw b WHERE b.CONST_GROUP_CODE = a.CONST_GROUP_CODE AND a.language_id = b.language_id AND a.language_id = ? ORDER BY DISP_SRL_NO"); // Added for ML-MMOH-CRF-1126
    } //  Added for ML-MMOH-CRF-1126 - End
    else{
	  sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_GENERIC_QUERY"));
    }
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add( "CONST_GENERIC_CODE" );
	displayFields.add( "CONST_GENERIC_NAME" );
	displayFields.add( "DISP_SRL_NO" );
	displayFields.add( "CONST_GROUP_NAME" );
	displayFields.add( "UOM_SETUP_LEVEL_IND" );
   if(display_enable_yn){ // if Added for ML-MMOH-CRF-1126 - Start 
	 displayFields.add( "EFF_STATUS" ); 
   } // if Added for ML-MMOH-CRF-1126 - End


	ArrayList chkFields = new ArrayList();
	chkFields.add(locale);
    // out.println("locale--->"+locale);
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
		<th  style="width:13%"><fmt:message key="ePH.ConstituentGenericCode.label" bundle="${ph_labels}"/></th>
		<th style="width:25%"><fmt:message key="ePH.ConstituentGenericName.label" bundle="${ph_labels}"/></th>
		<th style="width:9%"><fmt:message key="ePH.DisplaySerialNo.label" bundle="${ph_labels}"/></th>	
		<th  style="width:13%"><fmt:message key="ePH.ConstituentGroup.label" bundle="${ph_labels}"/></th>
		<th  style="width:9%"><fmt:message key="ePH.UOMLevel.label" bundle="${ph_labels}"/></th>
		<%if(display_enable_yn){ // Added for ML-MMOH-CRF-1126 - Start %>
		<th  style="width:8%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 
		<%} // Added for ML-MMOH-CRF-1126 - End %>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else              
				classvalue = "QRYEVEN" ;
	%>
	<tr >
	<%

			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
			
				String dkVal = (String)records.get( colCount );

				if(dkVal == null)
					dkVal = "&nbsp" ;
				if(dkVal.equals(""))
					dkVal = "&nbsp;";

				if(colCount==2){
					out.println("<td class='"+classvalue+"' align=\"right\">");
					out.println(dkVal);
					out.println("</td>");
				}//if
				else if (colCount==0){
					out.println("<td class='"+classvalue+"'><font class='HYPERLINK' style='cursor:pointer' onClick=\"modifyGeneric('"+dkVal+"')\"	  > "); 
					out.println(dkVal);
					out.println("</td>");
				}
				else{
					out.println("<td class='"+classvalue+"'>"); 
					if(colCount == 4){
						if(dkVal.equals("I"))
							dkVal = "Individual";
						else if(dkVal.equals("G"))
							dkVal="General";
					}
					else if(colCount == 5 && display_enable_yn){ // Added for ML-MMOH-CRF-1126 - Start
						if(dkVal.equalsIgnoreCase("E"))
							dkVal= "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
						else
							dkVal= "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
					} // Added for ML-MMOH-CRF-1126 - End
					out.println(dkVal);
					out.println("</td>");
				}
			}// end of col count
	%>
			</tr>
	<%
		}// end of rec count
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PHTPNConsGenericQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
finally{ // Added for ML-MMOH-CRF-1126 - Start
	ConnectionManager.returnConnection(con,request);
} // Added for ML-MMOH-CRF-1126 - End
%>
</body>
</html>

