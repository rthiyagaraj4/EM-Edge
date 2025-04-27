<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

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
//ends

	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		
		<script language="Javascript" src="../../ePH/js/FormOfDrug.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String form_code			= request.getParameter( "form_code" ) ;
	String form_desc			= request.getParameter( "form_desc" ) ;
	String eff_status			= request.getParameter( "eff_status" ) ;
	//String ord[]				= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

	String bean_id = "FormOfDrug" ;
	String bean_name = "ePH.FormOfDrugBean";
	FormOfDrugBean bean = (FormOfDrugBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList check = bean.displayCheck();
	int localLangCheck = Integer.parseInt((String)check.get(0));
try{
	String classvalue			= "";

	form_code			 = CommonBean.checkForNull( form_code );
	form_desc			 = CommonBean.checkForNull( form_desc );
	eff_status			 = CommonBean.checkForNull( eff_status );

	if (eff_status.equals("B")){
		eff_status="";
	}

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_FORM_SELECT1"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "form_code" );
	displayFields.add( "form_desc" );
	if(localLangCheck != 0){
		displayFields.add( "form_code_loc_lang" );
		displayFields.add( "form_desc_loc_lang" );
	}
	displayFields.add( "eff_status" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( form_code.trim() + "%");
	chkFields.add( form_desc.trim() + "%");
	chkFields.add( eff_status.trim() + "%");
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
		<th width="15%"><fmt:message key="ePH.FormCode.label" bundle="${ph_labels}"/></th>
		<%	if(localLangCheck != 0){	%>
		<th width="20%"><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.FormCodeinLocalLanguage.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.FormDescriptioninLocalLanguage.label" bundle="${ph_labels}"/></th>
		<%
			}else{
		%>
			<th><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></th>
		<%
			}
		%><th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
	<%
				String dkVal = (String)records.get( colCount );

					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					int colCountEql	=	2;
					if(localLangCheck != 0){
						colCountEql	=	4;
					}
					if((colCount==colCountEql)){
						out.println("align=\"center\">");
						out.println(getImage(dkVal));
						out.println("</td>");
					}//if
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
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/FormOfDrugQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
%>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

