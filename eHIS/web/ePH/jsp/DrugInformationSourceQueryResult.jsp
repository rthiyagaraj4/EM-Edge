<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
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
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	

function Modify(obj)
	{
	var code			=obj.cells[0].innerText;
	var description		=obj.cells[1].innerText;
	var seq_no			=obj.cells[2].innerText;
	var eff_status		=obj.cells[3].children[1].value;

document.location.href="../../ePH/jsp/DrugInformationSourceFrames.jsp?mode=2&code="+code+"&description="+description+"&display_sequence_no="+seq_no+"&eff_status="+eff_status;

	}

</script>
</head>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%

	
	//Search Criteria's from Query Criteria page
	String code= request.getParameter( "code" ) ;
	String description	= request.getParameter( "description" ) ;
	String display_sequence_no	= request.getParameter( "display_sequence_no" ) ;
	String eff_status	= request.getParameter( "eff_status" ) ;
	
	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;


try{
	String classvalue			= "";

	code= CommonBean.checkForNull( code );
	description  = CommonBean.checkForNull( description );
	display_sequence_no	 = CommonBean.checkForNull( display_sequence_no );
	eff_status	 = CommonBean.checkForNull( eff_status );

	if (eff_status.equals("B")){
		eff_status="";
	}


	//Common parameters.
	
	HashMap sqlMap = new HashMap();

	//include all the common parameters.


sqlMap.put("sqlData","SELECT INFO_CAT_CODE  CODE, SHORT_DESC DESCRIPTION, SEQ_NO SEQUENCE, EFF_STATUS  FROM PH_DRUG_INFO_ENQ_HDR_LANG_VW PH_DRUG_INFO_ENQ_HDR WHERE UPPER(INFO_CAT_CODE ) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?)AND LANGUAGE_ID = ? ");

//sqlMap.put("sqlData"," SELECT INFO_CAT_CODE  CODE, SHORT_DESC DESCRIPTION, SEQ_NO SEQUENCE, EFF_STATUS  FROM PH_DRUG_INFO_ENQ_HDR WHERE UPPER(INFO_CAT_CODE ) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?)");


	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add( "CODE" );
	displayFields.add( "DESCRIPTION");
	displayFields.add( "SEQUENCE" );
	displayFields.add( "EFF_STATUS" );

	ArrayList chkFields = new ArrayList();

	
	chkFields.add( code.trim()+ "%" );
	chkFields.add( description.trim()+ "%" );
	chkFields.add( eff_status.trim() + "%" );
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
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/> </th><th><fmt:message key="Common.description.label" bundle="${common_labels}"/> </th><th><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			
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
				
					if(colCount == 3 )//to display gif image
					dkVal=getImage(fieldValue);
					
					%>

	<td class="<%=classvalue%>" onclick="disableClick(event); "><%=dkVal%></td>
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugInformationSourceQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
%>


