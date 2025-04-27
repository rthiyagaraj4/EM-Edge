<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!--, eCommon.Common.*, java.sql.*, webbeans.eCommon.* added for ML-MMOH-CRF-1126 -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/TPNConsGroup.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<body>
<br>
<%
	//Search Criteria's from Query Criteria page

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;


try{
	String classvalue			= "";
	//added for ML-MMOH-CRF-1126 start
	 Connection con			= null;
     con				= ConnectionManager.getConnection(request);
     
	boolean assesment_req_yn =CommonBean.isSiteSpecific(con,"PH","ASSESMENT_REQ_YN");//added for ML-MMOH-CRF-1126 end
	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GROUP_QUERY"));
//added for ML-MMOH-CRF-1126 start
	if(assesment_req_yn){
    sqlMap.put( "sqlData", "SELECT CONST_GROUP_CODE,CONST_GROUP_NAME,DISP_SRL_NO,EFF_STATUS FROM PH_TPN_CONST_GRP_LANG_VW PH_TPN_CONSTITUENT_GROUP WHERE LANGUAGE_ID = ?");//added for ML-MMOH-CRF-1126
}
//added for ML-MMOH-CRF-1126 end
			//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "CONST_GROUP_CODE" );
	displayFields.add( "CONST_GROUP_NAME" );
	displayFields.add( "DISP_SRL_NO" );
	//added for ML-MMOH-CRF-1126 start
	if(assesment_req_yn){
	displayFields.add( "EFF_STATUS" );
	}
	//added for ML-MMOH-CRF-1126 end
	ArrayList chkFields = new ArrayList();
	chkFields.add(locale);
	
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
		<th  style="width:13%"><fmt:message key="ePH.ConstituentGroupCode.label" bundle="${ph_labels}"/></th>
		<th style="width:25%"><fmt:message key="ePH.ConstituentGroupName.label" bundle="${ph_labels}"/></th>
		<th style="width:9%"><fmt:message key="ePH.DisplaySerialNo.label" bundle="${ph_labels}"/></th>
	<!-- added for ML-MMOH-CRF-1126 start -->
		<%if(assesment_req_yn){ %>	
		<th  style="width:9%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	     <% }%>
		<!-- added for ML-MMOH-CRF-1126 end -->
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


				if(dkVal == null)	dkVal = "&nbsp" ;
				if(dkVal.equals("")) dkVal = "&nbsp;";

				if(colCount==2){
 						out.println("<td class='"+classvalue+"' align=\"right\">");
						out.println(dkVal);
						out.println("</td>");
					}//if
				else if(colCount==3 && assesment_req_yn){//added for ML-MMOH-CRF-1126 start
						if(dkVal.equals("E")){
							dkVal="<img src=\"../../eCommon/images/enabled.gif\">";
							out.println("<td class='"+classvalue+"' align=\"right\">");
							out.println(dkVal);
							out.println("</td>");
						}else{
							dkVal="<img src=\"../../eCommon/images/disabled.gif\">";
							out.println("<td class='"+classvalue+"' align=\"right\">");
							out.println(dkVal);
							out.println("</td>");
						}
						
					}//added for ML-MMOH-CRF-1126 end
				else if (colCount==0)
				{
						out.println("<td class='"+classvalue+"'><font class='HYPERLINK' style='cursor:pointer' onClick=\"modifyGroup('"+dkVal+"')\"	  > "); 
						out.println(dkVal);
						out.println("</td>");
				}
				else
				{
						out.println("<td class='"+classvalue+"'>"); 
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PHTPNConsGroupQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

