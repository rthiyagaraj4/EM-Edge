<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
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
<html>
	<head>
		<title></title>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/TPNStockItem.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	//Search Criteria's from Query Criteria page
	String strItemCode = request.getParameter("item_code");
	String strItemDesc = request.getParameter("item_desc");
	//String strUom	   = request.getParameter("gen_uom_code" ) ;
	String tpnItem	   = request.getParameter("tpn_item_yn" ) ;
	//String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;


	try
	{
		String classvalue			= "";

		strItemCode	 = CommonBean.checkForNull( strItemCode );
		strItemDesc  = CommonBean.checkForNull( strItemDesc );
		//strUom  	 = CommonBean.checkForNull( strUom );


	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	//sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_ITEM_UOM_VALUE"));
    sqlMap.put("sqlData",PhRepository.getPhKeyValue("SQL_PH_ITEM_UOM_VALUE1"));
	
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "ITEM_CODE" );
	displayFields.add( "SHORT_DESC" );
	displayFields.add( "GEN_UOM_CODE" );
	displayFields.add( "TPN_ITEM_YN" );
	
	
	ArrayList chkFields = new ArrayList();
	chkFields.add( strItemCode.trim()+"%" );
	chkFields.add( strItemDesc.trim() + "%" );
	chkFields.add((tpnItem.trim().equals("A")?"%":tpnItem.trim()) );
	chkFields.add(locale);
	
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	
	if (result==null||result.size()==0)
		{ 
%>
		<script	language="javascript">
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		history.go(-1);
		return;
		</script>

<%	
		}
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
			<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>	<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th> <th><fmt:message key="ePH.TPNItem.label" bundle="${ph_labels}"/></th>
			<%
				//Retriving the records from result arraylist
				ArrayList records=new ArrayList();
				for(int recCount=2;recCount<result.size() ; recCount++) 
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

							%>
							<input type="hidden" name="item_code<%=recCount%>" id="item_code<%=recCount%>" value="<%=records.get( colCount )%>">

							<td class="<%=classvalue%>" >
								<font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=records.get( 0 )%>')">  <%=(String)records.get( colCount )%></font>
							</td>
							<%
						}
						else 
						{


							%>
							<td class="<%=classvalue%>">
								  <%=(String)records.get( colCount )%>
							</td>
							<%
						}	
					}	
				}
			%>
			</tr>
		
		</table>
		<%
		out.flush();
		 %>
	<%
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TPNStockItemQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>



</body>
</html>

	

