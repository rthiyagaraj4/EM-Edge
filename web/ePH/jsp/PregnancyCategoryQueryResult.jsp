<!DOCTYPE html>

<%@ page
	import="eST.*, eST.Common.* , ePH.Common.* , eCommon.Common.*, java.util.*,eCommon.XSSRequestWrapper"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale	= (String)session.getAttribute("LOCALE");
        
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script language="javascript" src="../../ePH/js/PregnancyCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()">
<%
	
	
	String category_group_code = request.getParameter("category_group_code");
	String category_group_desc = request.getParameter("category_group_desc");
	String eff_status	= request.getParameter("eff_status");

	//out.println (cgCode+" "+cgDesc+" "+cgStatus);
   
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

	

	try{
		 String classvalue = "";
		if (eff_status.equals("B"))
			eff_status="";
		
		category_group_code = CommonBean.checkForNull(category_group_code.trim())+"%";
		category_group_desc = CommonBean.checkForNull(category_group_desc.trim())+"%";
		eff_status = CommonBean.checkForNull(eff_status.trim())+"%";
		
		
		HashMap sqlMap = new HashMap();
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();

		String sqlQry = "SELECT CATEGORY_GROUP_CODE, CATEGORY_GROUP_DESC, EFF_STATUS FROM PH_PREGN_CAT_GROUP_HDR_LANG_VW WHERE  UPPER(CATEGORY_GROUP_CODE) LIKE UPPER(?) AND UPPER(CATEGORY_GROUP_DESC) LIKE UPPER(?) AND EFF_STATUS LIKE UPPER(?) AND LANGUAGE_ID = ?";

		sqlMap.put("sqlData",sqlQry);

		displayFields.add("CATEGORY_GROUP_CODE");
		displayFields.add("CATEGORY_GROUP_DESC");
		displayFields.add("EFF_STATUS");
		
		
		
		
		chkFields.add(category_group_code);
		chkFields.add(category_group_desc);
		chkFields.add(eff_status);
		chkFields.add(locale);	
		//chkFields.add(locale);	
		//chkFields.add(locale);	
		
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
<table cellpadding=0 cellspacing=0 width="100%" align=center>
	<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
	</tr>
</table>
<table border="1" cellpadding="0" cellspacing="0" width="99%"
	align=center>


	<th><fmt:message key="ePH.CategoryGroupCode.label" bundle="${ph_labels}" />  </th>
	<th><fmt:message key="ePH.CategoryGroupDesc.label"
		bundle="${ph_labels}" /> </th>
	<th> <fmt:message key="Common.Nature.label" bundle="${common_labels}" /> </th>
	
	<%
		
			ArrayList records=new ArrayList();		
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
					
				else
					classvalue = "QRYODD" ;
				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				 category_group_code = ((String)records.get( 0 ));
				 category_group_desc = ((String)records.get( 1 ));
				 eff_status=((String)records.get( 2 ));				
			%>

		<tr onClick="Modify(this);" >
		<%
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					{
					%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font
			class='HYPERLINK'> <%=(String)records.get( colCount )%> </font></td>
		<%
					}else
					{
						%>
		<td class="<%=classvalue%>" onclick="disableClick(event);"
			<% 
							if(colCount == 2) 
							{
									
								if( ((String)records.get( colCount )).equals("E"))
										out.println("align='center' ><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
										out.println("align='center' ><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							
							else 
							{
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp"));
							}

					%></td>
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
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PregnancyCategoryQueryResult.jsp", searched) );



	
	



	}//try
	catch(Exception e){
	out.print("Exception @ Result JSP :"+e.toString());
	}

	
%>
</body>
</html>

