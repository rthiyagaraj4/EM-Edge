<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
	<%
         request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<html>
	<head>
		<title></title>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugType.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	//Search Criteria's from Query Criteria page
	String strDrugTypeCode = request.getParameter("drug_type");
	String strDrugTypeDesc = request.getParameter("drug_type_desc");
	String eff_status	  = request.getParameter( "eff_status" ) ;
	String ord[]			= request.getParameterValues("orderbycolumns");
boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;
try
	{
		String classvalue			= "";

		strDrugTypeCode	= CommonBean.checkForNull( strDrugTypeCode );
		strDrugTypeDesc  = CommonBean.checkForNull( strDrugTypeDesc );
		eff_status		= CommonBean.checkForNull( eff_status );

		if (eff_status.equals("B"))
		{
			eff_status="";
		}
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUGTYPE_SELECT1"));

	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "drug_type" );
	displayFields.add( "drug_type_desc" );
	displayFields.add( "eff_status" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( strDrugTypeCode.trim()+"%");
	chkFields.add( strDrugTypeDesc.trim()+"%" );
	chkFields.add( eff_status.trim());
	chkFields.add(locale);


	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);




if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
		%>
			<table  cellpadding=0 cellspacing=5  width="100%" align="center" >
			<tr>

				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;

		<%
//				 For display the previous/next link
				out.println(result.get(1));
		%>
				</td>
			</tr>
			</table>


<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.DrugTypeDescription.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
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
							<input type="hidden" name="drug_type<%=recCount%>" id="drug_type<%=recCount%>" value="<%=records.get( colCount )%>">
							<td class="<%=classvalue%>" ><font class='HYPERLINK'  onmouseover="changeCursor(this);" onClick="Modify('<%=records.get( 0 )%>')">  <%=dkVal%></font></td>
							<%
						}
						else if(colCount==1 )
						{
							String dkVal = (String)records.get( colCount );
							%>
							<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);"  onClick="Modify('<%=records.get( 0 )%>')">  <%=dkVal%></font></td>
							<%
						}	
						else 
						{		
							String fieldValue=((String)records.get( colCount ));
							String dkVal =fieldValue ;
							%>
							<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">
							<%
							out.println(getImage(dkVal));
							out.println("</td>");

						}
					}
			%>

			</tr>
		<%
		}
		%>
		</table>
			
		</form>

<%	out.flush();
	}	 else{
		%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugTypeQueryResult.jsp", searched) );
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


