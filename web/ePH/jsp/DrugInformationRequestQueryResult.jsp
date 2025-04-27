<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	
<% 
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="JavaScript" src="../../ePH/js/ADRReporting.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function Modify(obj){
	var code		=obj.cells[0].innerText;
	var description	=obj.cells[1].innerText;
	var seq_no		=obj.cells[2].innerText;


document.location.href="../../ePH/jsp/DrugInformationRequestAddmodify.jsp?mode=2&code="+code+"&description="+description+"&seq_no="+seq_no;
}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	
	//Search Criteria's from Query Criteria page
	String code= request.getParameter( "code" ) ;
	String description	= request.getParameter( "description" ) ;
	String display_sequence_no	= request.getParameter( "display_sequence_no" ) ;
	String eff_status	= request.getParameter( "eff_status" ) ;
	String sys_def	= request.getParameter( "sys_def" ) ;

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;
	
	String enabledGif	= "<img src='../../eCommon/images/enabled.gif'></img>";
	String disabledGif	= "<img src='../../eCommon/images/disabled.gif'></img>";

try{
	String classvalue			= "";

	code= CommonBean.checkForNull( code );
	description  = CommonBean.checkForNull( description );
	display_sequence_no	 = CommonBean.checkForNull( display_sequence_no );
	eff_status	 = CommonBean.checkForNull( eff_status );
	sys_def      = CommonBean.checkForNull( sys_def);

	if (eff_status.equals("B")){
		eff_status="";
	}
	
	if (sys_def.equals("A")){
		sys_def="";
	}	

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.

	

	//sqlMap.put("sqlData","SELECT REQ_CAT_CODE CODE, SHORT_DESC DESCRIPTION, SEQ_NO SEQUENCE, EFF_STATUS, SYSTEM_DEFINED_YN  FROM PH_DRUG_REQ_ENQ_LANG_VW PH_DRUG_REQ_ENQ WHERE UPPER(REQ_CAT_CODE ) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?)AND UPPER(SYSTEM_DEFINED_YN) LIKE UPPER(?) AND LANGUAGE_ID = ?");
	String sql ="SELECT REQ_CAT_CODE CODE, SHORT_DESC DESCRIPTION, ORDBY SEQUENCE, EFF_STATUS, SYSTEM_DEFINED_YN  FROM PH_DRUG_REQ_ENQ_LANG_VW PH_DRUG_REQ_ENQ WHERE UPPER(REQ_CAT_CODE ) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?)AND UPPER(SYSTEM_DEFINED_YN) LIKE UPPER(?) AND LANGUAGE_ID = ?";

	//sqlMap.put("sqlData",PhRepository.getPhKeyValue( "SQL_PH_DRUG_INFO_REQUEST"));
	sqlMap.put("sqlData",sql);
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


//	displayFields.add( "REQ_CAT_CODE" );
	displayFields.add( "CODE" );
	displayFields.add( "DESCRIPTION");
//	displayFields.add( "SHORT_DESC" );
	displayFields.add( "SEQUENCE" );
	displayFields.add( "EFF_STATUS" );
	displayFields.add( "SYSTEM_DEFINED_YN" );

	ArrayList chkFields = new ArrayList();
	
	chkFields.add( code+ "%" );
	chkFields.add( description+ "%" );
	chkFields.add( eff_status.trim() + "%" );
	chkFields.add( sys_def.trim() + "%" );
	chkFields.add(locale);

//	chkFields.add( eff_status );

	
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

			<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/> </td>
			<td class='COLUMNHEADER'><fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>
			<td class='COLUMNHEADER'><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></td>			
			
		
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
			<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else{
					String fieldValue=((String)records.get( colCount ));
					if (fieldValue==null) fieldValue = "";
					if (fieldValue.equals("*A")){
						fieldValue="*All";
					}

					String dkVal =fieldValue ;
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
				
					if(colCount == 3 )//to display Yes/ 
						dkVal=chkReturn("E",fieldValue,enabledGif,disabledGif);
					else if(colCount == 4)//to display Yes/ No (Enabled / Disabled)
						dkVal=chkReturn("Y",fieldValue,enabledGif,disabledGif);
					
				%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=dkVal%></td>

	<%
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugInformationRequestQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

<%!

public	String chkReturn(String str1, String str2 ,String str3 ,String str4)
{
	if(str1.trim().equalsIgnoreCase(str2.trim()))
	return str3;
	else
	return str4;
}
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
public String getImage1(String value){
	if(value. equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='Y'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='N'>";
}
%>


