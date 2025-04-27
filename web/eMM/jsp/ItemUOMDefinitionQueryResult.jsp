<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,eMM.Common.*, eMM.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<%	request.setCharacterEncoding("UTF-8");%>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eMM/js/ItemUOMDefinition.js"></script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<BODY>
<%

	try
	{
		
		String classvalue			=		"";
		String item_code			=		request.getParameter("item_code") ;
		String item_desc			=		request.getParameter("item_desc") ;
		String uom_code				=		request.getParameter("uom_code") ;
		String uom_desc				=		request.getParameter("uom_desc").trim() ;
		String equom_code			=		request.getParameter("equom_code") ;
		String equom_desc			=		request.getParameter("equom_desc").trim() ;
		String eff_status			=		request.getParameter("eff_status") ;

		item_code					=		CommonBean.checkForNull( item_code )+'%';
		item_desc					=		CommonBean.checkForNull( item_desc )+'%';
		uom_code					=		CommonBean.checkForNull( uom_code )+'%';
		uom_desc					=		CommonBean.checkForNull( uom_desc )+'%';
		equom_code					=		CommonBean.checkForNull( equom_code )+'%';
		equom_desc					=		CommonBean.checkForNull( equom_desc )+'%';
		eff_status					=		CommonBean.checkForNull( eff_status );

		boolean searched			=		(request.getParameter("searched") == null) ?false:true;

		HashMap sqlMap				=		new HashMap();
		
		sqlMap.put( "sqlData", eMM.Common.MmRepository.getMmKeyValue("SQL_MM_ITEM_UOM_DEFN_QUERYCRIT"));
			
		ArrayList displayFields		=		new ArrayList();
		displayFields.add( "ITEM_CODE" );
		displayFields.add( "ITEM_DESC" );
		displayFields.add( "UOM_CODE"	);
		displayFields.add( "UOM_DESC" );
		displayFields.add( "EQVL_UOM_CODE" );
		displayFields.add( "EQVL_UOM_DESC" );
		displayFields.add( "EQVL_VALUE" );
		displayFields.add( "EFF_STATUS" );
		
		//The fields are going to be in where condition * should match with the query
			
		ArrayList chkFields			=		new ArrayList();

		chkFields.add( item_code);
		chkFields.add( item_desc);
		chkFields.add( uom_code);
		chkFields.add( uom_desc);	
		chkFields.add( equom_code);	
		chkFields.add( equom_desc);	
		chkFields.add( eff_status);	

		HashMap funcMap				=		new HashMap();

		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap,funcMap,request);
		
		if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
		{
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					// For display the previous/next link
					 out.println(result.get(1));
					 
				%>
				</td></tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" height="10%" >
			<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.UOMCode.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eMM.UOMDescription.label" bundle="${mm_labels}"/></th>
			<th><fmt:message key="eMM.EquivalentUOMCode.label" bundle="${mm_labels}"/></th>
			<th><fmt:message key="eMM.EquivalentUOMDescription.label" bundle="${mm_labels}"/></th>
			<th><fmt:message key="Common.ConversionFactor.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
			<%
			//Retriving the records from result arraylist
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;

					
				else
					classvalue = "QRYODD" ;
			%>
			<tr onClick="Modify(this);" >
			<%
				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					{
					%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
					<%
					}else
					{
						%>
						<% if(colCount == 1) {%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);" style="font-size:9pt;WORD-BREAK:BREAK-ALL;"><%=(String)records.get( 1 )%></td>
					<%continue;}
							if(colCount == 7) 
							{%>
							<td class="<%=classvalue%>" onclick="disableClick(event);" align='center' >
							<font style='display:none'><%=records.get(colCount)%></font>
							<%
								
								if( ((String)records.get( colCount )).equals("E"))
										out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
										out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else 
							{%>
								<td class='<%=classvalue%>' onclick='disableClick(event);'>
							<%	out.println((String)records.get( colCount ));
							}


					%> </td>
					<%
					}
				}
				%>
			</tr>
		<%}	%>
		</table>
		<%
			out.flush();
		} else{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eMM/jsp/ItemUOMDefinitionQueryResult.jsp", searched) );
	} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>

