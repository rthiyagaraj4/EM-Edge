<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet QuickLinkResp = (webbeans.eCommon.RecordSet)getObjectFromBean("QuickLinkResp","webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet QuickLinkResp1 = (webbeans.eCommon.RecordSet)getObjectFromBean("QuickLinkResp1","webbeans.eCommon.RecordSet",session);
	//out.println("QuickLinkResp "+QuickLinkResp.getRecordSetHandle()+"<br>"+" QuickLinkResp1 "+QuickLinkResp1.getRecordSetHandle());
%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added by Arvind @ 08-12-08 -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../js/QuickLinksForResp.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='' onKeyDown="lockKey()">
<form name="QuickLinkResp_Form" id="QuickLinkResp_Form" action="QuickLinksForRespResult.jsp?<%=request.getQueryString()%>" method="post">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	StringBuffer sql = new StringBuffer();
	String checkStatus = "";
	String df_checkStatus = "";
	String df_disabled = "";
	String checkProp = "";
	String df_checkProp = "";
	String checkedOnes	= "";
	int i = 0;
	int maxCount = 0;
	int start = 0 ;
    int end = 0 ;
	int ilCkeckedYN = 0;
	
	String ql_type = request.getParameter("ql_type") == null ? "" : request.getParameter("ql_type");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String resp_id = request.getParameter("resp_id") == null ? "" : request.getParameter("resp_id");
	String ql_ref = "", ql_desc = "";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	String req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	String req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");
	//out.println("Query String "+request.getQueryString()+"<br>");
	//out.println("from "+from+""+"to "+to+"<br>");
	//out.println("start "+start+""+"end "+end+"<br>");
	//out.println("req_start "+req_start+""+"req_end "+req_end+"<br>");
	if(from != null && to != null)
	{
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i-1)) != null)
			{
				checkedOnes = request.getParameter("chk"+(i-1));
				if(!(QuickLinkResp.containsObject(checkedOnes)))
				{
					QuickLinkResp.putObject(checkedOnes);
				}
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");

		if(ql_type.equals("F") && !function_id.equals(""))
		{
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("default_chk"+(i-1)) != null)
				{
					checkedOnes = request.getParameter("default_chk"+(i-1));
					if(QuickLinkResp1.getSize() > 0)
					{
						QuickLinkResp1.removeObject(0);
						QuickLinkResp1.putObject(checkedOnes);
					}
					else
						QuickLinkResp1.putObject(checkedOnes);
				}
			}
		}
	}
	putObjectInBean("QuickLinkResp", QuickLinkResp,session);
	putObjectInBean("QuickLinkResp1", QuickLinkResp1,session);
	//out.println("QuickLinkResp "+QuickLinkResp.getRecordSetHandle()+"<br>"+" QuickLinkResp1 "+QuickLinkResp1.getRecordSetHandle());
	i = 0;

	try
	{
		con = ConnectionManager.getConnection(request);

		sql.append("select a.QUICK_LINK_REF, a.QUICK_LINK_DESCRIPTION from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
		if(ql_type.equals("Q"))
			sql.append(" and a.GLOBAL_YN='Y'  ");
		else if(ql_type.equals("F"))
		{
			sql.append(" and a.OPTION_ID = ? ");
			sql.append(" and a.FUNCTION_SPEC_YN ='Y' ");
		}
		sql.append(" order by 2");

		pstmt = con.prepareStatement(sql.toString());
		if(ql_type.equals("F"))
			pstmt.setString(1,function_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			maxCount = maxCount+1;
		}
		if(rs!=null) rs.close();

		if(maxCount > 0)
		{
%>
			<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
			<tr>
			<td class='white' width='85%'></td> 
			<td  align='right' width='15%'>
<%
			if ( !(start <= 1) )
			{
%>
				<A class="gridLink" HREF='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)'  text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%
			}
			if ( !( (start+14) > maxCount ) )
			{
%>
				<A class="gridLink" HREF='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)'  text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
			
			}
%>
			</td>
			</tr>
			</table>
<%
			rs = pstmt.executeQuery();
			if ( start != 0 )
			{
				for( int j=1; j<start; i++,j++ )
					rs.next() ;
				ilCkeckedYN += start;
				--ilCkeckedYN ;
			}
			String classValue= "";
%>
			<div style="display: flex; justify-content: center;">
			<table class='grid' border=1 cellspacing=0 cellpadding='3' width='90%' align='center'>
				<tr>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><center><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type=checkbox name='checkAll' id='checkAll' value='' title='Select All' onclick='selectAll(this)'></center></td>
<%
					if(ql_type.equals("F"))
					{
%>
						<td class='COLUMNHEADERCENTER'><center><fmt:message key="Common.Default.label" bundle="${common_labels}"/></center>
<%
					}

%>
				</tr>
<%
			while ( rs.next() && i<end  )
			{
				if ( i % 2 == 0 )
					classValue = "gridData" ;
				else
					classValue = "gridData" ;

				ql_ref = rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
				ql_desc = rs.getString("QUICK_LINK_DESCRIPTION") == null ? "" : rs.getString("QUICK_LINK_DESCRIPTION");
				try
				{
					if(QuickLinkResp.containsObject(ql_ref))
						checkStatus = "Y";
					else
						checkStatus = "N";
				
					int recordIndex = QuickLinkResp.indexOfObject(ql_ref);
					if(recordIndex != -1)
					{
						if(checkStatus.equals("Y"))
						{
							QuickLinkResp.removeObject(recordIndex);
						}
					}
					if(QuickLinkResp1.containsObject(ql_ref))
						df_checkStatus = "Y";
					else
						df_checkStatus = "N";

					int recordIndex1 = QuickLinkResp1.indexOfObject(ql_ref);
					if(recordIndex1 != -1)
					{
						if(df_checkStatus.equals("Y"))
						{
							QuickLinkResp1.removeObject(recordIndex1);
						}
					}
				}
				catch(Exception e)
				{
					//out.println("Exception@containsObject in QuickLinksForRespResult.jsp: "+e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
				}
				
				if(checkStatus.trim().equals("Y"))
				{
					checkProp = "CHECKED "; 
					df_disabled = "";
				}
				else
				{
					checkProp = "";
					df_disabled ="disabled";
				}
				if(df_checkStatus.trim().equals("Y"))
					df_checkProp = "checked";
				else
					df_checkProp = "";
					
%>
			
				<tr>
					<td class='<%=classValue%>'><%=ql_desc%></td>
					<td class='<%=classValue%>'><center><input type=checkbox name='chk<%=ilCkeckedYN%>' id='chk<%=ilCkeckedYN%>' value='<%=ql_ref%>' <%=checkProp%> onclick="enableDefault(this,'<%=ilCkeckedYN%>')"></center></td>
<%
					if(ql_type.equals("F"))
					{
						
%>
						<td class='<%=classValue%>'><center><input type=checkbox name='default_chk<%=ilCkeckedYN%>' id='default_chk<%=ilCkeckedYN%>' value='<%=ql_ref%>' onclick='defaultSelect(this)' <%=df_checkProp%> <%=df_disabled%>></center></td>
<%
					}
%>
				</tr>
<%
				ilCkeckedYN = ilCkeckedYN + 1;
				i++;
			}
%>
			</table>
			</div>
<%
		}
		else
		{
%>
			<script>
				var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");	
				alert(msg);
			</script>
<%
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
		<input type='hidden' name='count' id='count' value='<%=ilCkeckedYN%>'>
		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='ql_type' id='ql_type' value='<%=ql_type%>'>
		<input type=hidden name='function_id' id='function_id' value='<%=function_id%>'>
		<input type=hidden name='resp_id' id='resp_id' value='<%=resp_id%>'>
	</form>
</body>
<script>
	function submitPrevNext(from, to)
	{
		document.QuickLinkResp_Form.from.value = from;
        document.QuickLinkResp_Form.to.value = to; 
        document.QuickLinkResp_Form.target = "resultFrame"
        document.QuickLinkResp_Form.submit();
	}
</script>
</html>

