<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
				//Added by Himanshu for MMS-ME-SCF-0097 Starts 
				request= new XSSRequestWrapper(request); 
				response.addHeader("X-XSS-Protection", "1; mode=block"); 
				response.addHeader("X-Content-Type-Options", "nosniff"); 
				//Added by Himanshu for MMS-ME-SCF-0097 ends

		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String generic_id		= request.getParameter( "generic_id" );
	String generic_name		= request.getParameter( "generic_name" );
	String drug_class		= request.getParameter( "drug_class" ) ;
	String tot_recs     	= request.getParameter( "tot_recs" ) ;

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";
	int count					=	0;
	generic_id		= CommonBean.checkForNull( generic_id.trim() );
	generic_name	= CommonBean.checkForNull( generic_name.trim() );
	drug_class		= CommonBean.checkForNull( drug_class.trim() );
	tot_recs		= CommonBean.checkForNull( tot_recs.trim() );

	if(tot_recs.equals("")){
		tot_recs = "0";
	}


	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_QUERY_SELECT1"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("cnt");
	displayFields.add("generic_id");
	displayFields.add( "generic_name" );
	displayFields.add( "drug_class" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( generic_id.trim() + "");
	chkFields.add( generic_name.trim() + "%");
	chkFields.add( drug_class.trim() + "");
	chkFields.add(locale);
	chkFields.add(new Integer(Integer.parseInt(tot_recs)));
	


	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="95%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="95%" align="center">
		<th width="2%">&nbsp;</th>
		<th width="75%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
		<th width="23%"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr>

	<%


			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){


				if(colCount==0)	{
					count	=	Integer.parseInt((String) records.get( colCount));
					continue;
				}
				if(colCount==1)	{
					if(count!=0)	{
						count	=	0;
	%>
				<td class="<%=classvalue%>"><a href="javascript:parent.populate_generic_details('<%=(String)records.get( colCount )%>')">+</a></td>
	<%
					}	else	{
	%>
				<td class="<%=classvalue%>">&nbsp;</td>
	<%

					}
				}else if (colCount==3){
					%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<% 
				if(((String)records.get( colCount)).equals("General"))
						{
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels")); 
				        }else{
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+(String)records.get( colCount)+".label","ph_labels")); 
					    }
				out.println("</td>"); 
				}

				else	{
	%>

					<td class="<%=classvalue%>" value="<%=(String)records.get( colCount )%>"
	<%
				String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");

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
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	//history.go(-1);
	</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryGenericNameResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

