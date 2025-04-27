<!DOCTYPE html>
 <!--This file is saved on 07/04/2007-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.Common.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<html>
	<head>
		<title></title>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicalItem.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	//Search Criteria's from Query Criteria page
	String drug_code = request.getParameter("item_code");
	
	String drug_desc = request.getParameter("drug_desc");
	String disp_alt_form_yn	  = request.getParameter( "disp_alt_form_yn" ) ;
	//String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;


	try
	{
		String classvalue			= "";

		drug_code	= CommonBean.checkForNull( drug_code );
		drug_desc = CommonBean.checkForNull( drug_desc );
		disp_alt_form_yn		= CommonBean.checkForNull( disp_alt_form_yn );

		if (disp_alt_form_yn.equals("B"))
		{
			disp_alt_form_yn="B";
		}

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_MEDICAL_ITEM_NONDRUG_SELECT")); 
	//sqlMap.put( "sqlData","SELECT drg.drug_code, drg.item_code, drg.drug_desc, drg.in_formulary_yn,      disp_alt_form_yn, generic_name, drg.generic_id, drg.discontinued_yn FROM ph_drug_lang_vw drg,       mm_item_lang_vw itm,ph_generic_name_lang_vw genname WHERE drg.item_code = itm.item_code(+) AND drg.generic_id = genname.generic_id(+) AND drg.language_id = itm.language_id(+) AND drg.drug_yn = 'N' AND drg.drug_code LIKE NVL (?, drg.drug_code) AND drg.drug_desc LIKE NVL (?, drg.drug_desc)   AND drg.discontinued_yn = DECODE (?, 'B', drg.discontinued_yn, ?) AND drg.language_id = ? AND genname.language_id(+) = ?"); 
	



	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "drug_code" );
	displayFields.add( "drug_desc" );
	displayFields.add( "in_formulary_yn" );
	displayFields.add( "disp_alt_form_yn" );
	displayFields.add( "generic_name" );

	ArrayList chkFields = new ArrayList();
	chkFields.add(drug_code.trim()+"%" );
	chkFields.add( drug_desc.trim()+"%" );
	
	chkFields.add(disp_alt_form_yn);
	chkFields.add( disp_alt_form_yn);
	chkFields.add(locale);
	chkFields.add(locale);
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
		<%
				// For display the previous/next link
				out.println(result.get(1));
		%>
				</td>
			</tr>
			</table>
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
			<th><fmt:message key="ePH.MedicalItemCode.label" bundle="${ph_labels}"/></th>
			<th><fmt:message key="ePH.MedicalItemDescription.label" bundle="${ph_labels}"/></th>
			<th><fmt:message key="ePH.FormularyItem.label" bundle="${ph_labels}"/></th>
			<th><fmt:message key="ePH.DispenseAlternate.label" bundle="${ph_labels}"/></th>
			<th><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
			
			<%
				//Retriving the records from result arraylist
				ArrayList records=new ArrayList();
				for(int recCount=2; recCount<result.size(); recCount++) 
				{
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
					%>
				<tr>
					<%
					records=(ArrayList) result.get( recCount );
		
					for(int colCount=0; colCount<records.size(); colCount++)
					{
							
						if(colCount==0)
						{
							String dkVal = (String)records.get( colCount );
							%>
							<input type="hidden" name="adr_code<%=recCount%>" id="adr_code<%=recCount%>" value="<%=records.get( colCount )%>">
							<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);"
					onClick="Modify('<%=records.get(0)%>')">  <%=dkVal%></font></td>
							<%
						}
						else if(colCount==1 )
						{
							String dkVal = (String)records.get( colCount );
							%>
							<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=records.get( 0 )%>')">  <%=dkVal%></font></td>
							<%
						}	
						else if((colCount==2)||(colCount==3 ) )
						{		
							String fieldValue=((String)records.get( colCount ));
							String dkVal =fieldValue ;
							%>
							<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">
							<%
							out.println(getImage(dkVal));
							out.println("</td>");
						}
						else if(colCount==4)
						{%>
							<td class="<%=classvalue%>" ><%=(String)records.get(4)%></td>		
						<%}
	
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/MedicalItemQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='Y'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='N'>";
}
%>

</body>
</html>

	

