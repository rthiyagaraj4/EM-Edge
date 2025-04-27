<!DOCTYPE html>
 <!--
Fine Tuning
-->
<!-- 
	This sample function explains how to develop the Query Result Page for Type 2.
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%
        request.setCharacterEncoding("UTF-8");
			//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
			request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
			response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
			response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			//endss
 	    String locale			= (String)session.getAttribute("LOCALE");
	  	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		
		
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugSchedule.js"></script>
<!-- 		<script language="Javascript" src="../../eCommon/js/CommonXMLResult.js"></script>
 -->		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String licenceRights = PhLicenceRights.getKey();
	//Search Criteria's from Query Criteria page
/////////////////////////////////////////////////////////////////
String schedule_id					= request.getParameter( "schedule_id" ) ;
String schedule_desc				= request.getParameter( "schedule_desc" ) ;
String order_auth_reqd_yn     		= request.getParameter( "order_auth_reqd_yn" ) ;
String order_auth_level     		= request.getParameter( "order_auth_level" ) ;
String order_cosign_reqd_yn     	= request.getParameter( "order_cosign_reqd_yn" ) ;
String order_cosign_level			= request.getParameter( "order_cosign_level" ) ;
String spl_appr_reqd_yn     		= request.getParameter( "spl_appr_reqd_yn" ) ;
String spl_appr_level     			= request.getParameter( "spl_appr_level" ) ;
String repeat_single_cont_order_yn = request.getParameter( "repeat_single_cont_order_yn");
String disp_auth_reqd_yn     		= request.getParameter( "disp_auth_reqd_yn" ) ;
String eff_status     				= request.getParameter( "eff_status" ) ;
///////////////////////////////////////////////////////////
//String ord[]				= request.getParameterValues("orderbycolumns");
boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	
try{
	String classvalue			= "";

	schedule_id					= CommonBean.checkForNull( schedule_id );
	schedule_id = ( (schedule_id == null) ?  "vin":schedule_id ) ;
	schedule_desc				= CommonBean.checkForNull( schedule_desc );
	schedule_desc = (schedule_desc == null ?"":schedule_desc) ;

	order_auth_reqd_yn			= CommonBean.checkForNull( order_auth_reqd_yn );
  // out.println("order_auth_reqd_yn---->"+order_auth_reqd_yn);
	order_auth_reqd_yn = (order_auth_reqd_yn.equals("B") ?"":order_auth_reqd_yn) ;
	
	
	order_auth_level			= CommonBean.checkForNull( order_auth_level );
	order_auth_level = (order_auth_level == null ?"":order_auth_level) ;
	
//////////////////////////////////////////////////////////////////////////////////////
	order_cosign_reqd_yn		=CommonBean.checkForNull( order_cosign_reqd_yn );
	order_cosign_reqd_yn = (order_cosign_reqd_yn.equals("B") ?"":order_cosign_reqd_yn) ;
		
	order_cosign_level			= CommonBean.checkForNull( order_cosign_level );
	order_cosign_level = (order_cosign_level == null ?"":order_cosign_level) ;
////////////////////////////////////////////////////////////////////////////////////	
	spl_appr_reqd_yn			= CommonBean.checkForNull( spl_appr_reqd_yn );
	spl_appr_reqd_yn = ( spl_appr_reqd_yn.equals("B") ?"":spl_appr_reqd_yn) ;
	
	spl_appr_level				=CommonBean.checkForNull( spl_appr_level );	
	spl_appr_level = (spl_appr_level == null ?"":spl_appr_level) ;
	repeat_single_cont_order_yn = CommonBean.checkForNull( repeat_single_cont_order_yn );
	repeat_single_cont_order_yn = (repeat_single_cont_order_yn.equals("B") ?"":repeat_single_cont_order_yn) ;

	disp_auth_reqd_yn			=CommonBean.checkForNull( disp_auth_reqd_yn );
	disp_auth_reqd_yn = ( disp_auth_reqd_yn.equals("B") ?"":disp_auth_reqd_yn) ;
	eff_status					= CommonBean.checkForNull( eff_status );
	eff_status = (eff_status.equals("B") ? (""):(eff_status )   )  ;

	
	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_SCHEDULE_SELECT1"));

      
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "schedule_id" );
	displayFields.add( "schedule_desc" );
	displayFields.add( "order_auth_reqd_yn" );
	displayFields.add( "order_auth_level" );
	displayFields.add( "order_cosign_reqd_yn" );
	displayFields.add( "order_cosign_level" );
	displayFields.add( "spl_appr_reqd_yn" );
	displayFields.add( "spl_appr_level" );
	displayFields.add( "repeat_single_cont_order_yn" );
	displayFields.add( "disp_auth_reqd_yn" );
	displayFields.add( "eff_status" );
	

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	
	
	chkFields.add( schedule_id.trim() + "%" );
	chkFields.add( schedule_desc.trim() + "%" );
	chkFields.add( order_auth_reqd_yn.trim() + "%" );
	chkFields.add( order_auth_level.trim() + "%" );
	chkFields.add( order_cosign_reqd_yn.trim() + "%" );
	chkFields.add( order_cosign_level.trim() + "%" );
	chkFields.add( spl_appr_reqd_yn.trim() + "%" );
	chkFields.add( spl_appr_level.trim() + "%" );
	chkFields.add( repeat_single_cont_order_yn.trim() + "%" );
	chkFields.add( disp_auth_reqd_yn.trim() + "%" );
	chkFields.add( eff_status.trim() + "%" );
	chkFields.add(locale);


	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

     //out.println("chkFields---->"+chkFields);
     //out.println("sqlMap---->"+sqlMap);

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<form name="queryResultForm" id="queryResultForm">
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

		<table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="ePH.ScheduleID.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.ScheduleDescription.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.AuthorizationRequiredForOrdering.label" bundle="${ph_labels}"/></th>
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
		<th><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
	<%
		}
	%>
		<th><fmt:message key="ePH.CosignRequiredForOrdering.label" bundle="${ph_labels}"/></th>
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
		<th><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
	<%
		}
	%>
		<th>Special Approval Required</th>
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
		<th><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
	<%
		}
	%>
		<th><fmt:message key="ePH.AllowRefill.label" bundle="${ph_labels}"/></th>
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
		<th><fmt:message key="ePH.AuthorizationRequiredForDispensing.label" bundle="${ph_labels}"/></th>
	<%
		}
	%>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				
		
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr onClick="Modify(this);" >
	<%

			String link_columns = "1";

			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else{
					
				
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
					
	<%	
				String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					
					if((colCount==9 )&& !licenceRights.equals("PHBASIC")){
						out.println("align=\"center\">");  
						out.println(getImage(dkVal)); 
						out.println("</td>"); 
					}else if((colCount==2)||(colCount==4)||(colCount==6)||(colCount==8)||(colCount==10)){
						out.println("align=\"center\">");  
						out.println(getImage(dkVal)); 
						out.println("</td>"); 
					}else if((colCount==3 || colCount==5 || colCount==7 || colCount==9 ) && 		licenceRights.equals("PHBASIC")){
						continue;
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
%>
	</form>
<%
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugScheduleQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

<%!
public String getImage(String value){
	if( (value.equalsIgnoreCase("E"))|| (value.equalsIgnoreCase("Y")) )
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
}
%>
</body>
</html>

