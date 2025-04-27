<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="RelinkBean" class="webbeans.eCommon.RecordSet" scope="session"/>

<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll="scrollTitle1()">

<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>	

<form name="ClinicalEventGroupRelinkBeanForm" id="ClinicalEventGroupRelinkBeanForm">

<div id='divDataTitle' style='postion:relative'>

<table border="1" id="finalDiv" cellpadding="0" cellspacing="0" width="100%" align="center">
<tr>
	<td colspan=2 class='CAGROUP' align=center><b><font size='2'>Selected Items</b></td></tr>
	<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr>
<th nowrap width="26%" style="font-size:10">Code</th>
<th nowrap width="64%" style="font-size:10">Description</th>
<th nowrap width="10%" style="font-size:10">Select</th>
</tr>
</table>
</div>

<div id="finalDiv1">
<table  border="1"  cellpadding="0" cellspacing="0" width="100%">
<%
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String code="";
	String description="";
	String rowid="";
	String beanvalins="";
	String eventgrouptype="";
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";

	int i=0;

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	try
	{
		con =  ConnectionManager.getConnection(request);
		String histype=request.getParameter("histype")==null?"":request.getParameter("histype");
		String contr=request.getParameter("contr")==null?"":request.getParameter("contr");
		String eventgroup=request.getParameter("groupcode")==null?"":request.getParameter("groupcode");
		String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
			
		String classValue="";
		int w=0;
		return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");

		String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
		ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
		
		remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");
		removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
		flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

		if(mode.equals("ins"))
			RelinkBean.clearAll();

		if(sel_all.equals("select"))
		{	
			ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
			ret_str = ret_str.substring(0, ret_str.length()-1);
		}



		if(flag.equals("clear"))
			RelinkBean.clearAll();
		
		if(!removebean.equals("Y"))
		{
			if(ret_str!=null && ret_str!="")
			{
				StringTokenizer strtCodes = new StringTokenizer(ret_str,"@");

				while(strtCodes.hasMoreTokens())
				{
					temp= (String) strtCodes.nextToken();
					StringTokenizer tempCodes = new StringTokenizer(temp,"~");
					
					while(tempCodes.hasMoreTokens())
					{
						String key= tempCodes.nextToken();
						value=tempCodes.nextToken();
						RelinkBean.putObject(key);
						RelinkBean.putObject(value);
					}
				}
			}		
			
			for(i=1;i<RelinkBean.getSize();i+=2)
			{
				if ( w % 2 == 0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;
		
				 w++;
				
				 disbean=RelinkBean.getObject(i).toString();
						
				StringTokenizer valCodes = new StringTokenizer(disbean,"|");
				
				while(valCodes.hasMoreTokens())
				{
				   code=valCodes.nextToken(); 
				   description=valCodes.nextToken();  
				   valCodes.nextToken();  
					%> 
					<tr>
						<td class="<%=classValue%>" width="26%"><%=code%></td>
						<td class="<%=classValue%>" width="64%" colspan=2><%=description%></td>   
						<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selTextrelink(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=code%>">
					</tr>
					<%
				}
			}
		}
	%>
	</td>
	</tr>
	<%

		if(removebean.equals("Y"))
		{
			 String beankey="";
			 String code2="";
		
			 for(int l=0;l<RelinkBean.getSize();l+=2)
			 {
				beankey=RelinkBean.getObject(l+1).toString();  

				StringTokenizer valCodes = new StringTokenizer(beankey,"|");
				
				if(valCodes.hasMoreTokens())
				{
					code2=valCodes.nextToken(); 
					valCodes.nextToken();  
					valCodes.nextToken();  
				}

				if(remval.equalsIgnoreCase(code2))
				{
						RelinkBean.removeObject(l);
						RelinkBean.removeObject(l);
						break;
				}
		}
		
		w=0;
		
			for( i=1;i<RelinkBean.getSize();i+=2)
			{
				if ( w % 2 == 0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;
					
				w++;

				beanval=RelinkBean.getObject(i).toString();  

				StringTokenizer valCodes = new StringTokenizer(beanval,"|");
				
				while(valCodes.hasMoreTokens())
				{
					code=valCodes.nextToken(); 
					description=valCodes.nextToken();  
					valCodes.nextToken();  			
					%>
					<tr>
						<td class="<%=classValue%>" width="26%"><%=code%></td>
						<td class="<%=classValue%>" width="64%" colspan=2><%=description%></td>   
						<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selTextrelink(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=code%>">
					</tr>
					<%
				}
			}
		}
		
		if(mode.equals("ins"))
		{	
			String sqlupdate="select a.rowid row_id,a.CONTR_SYS_ID,a.CONTR_SYS_EVENT_group,b.short_desc from cr_clin_event_group_link a,cr_clin_event_group b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.EVENT_GROUP_TYPE and a.CONTR_SYS_EVENT_GROUP =b.EVENT_GROUP and a.HIST_REC_TYPE=? and a.CONTR_SYS_ID=?  and a.EVENT_GROUP =?"; 
		
			pstmt=con.prepareStatement(sqlupdate,ResultSet.TYPE_SCROLL_INSENSITIVE,
												  ResultSet.CONCUR_UPDATABLE);
				
			pstmt.setString(1,histype);
			pstmt.setString(2,contr);
			pstmt.setString(3,eventgroup);
			rs=pstmt.executeQuery();

			while( rs.next())
			{
				rowid=rs.getString("row_id")==null?" ":rs.getString("row_id");
				code=rs.getString("CONTR_SYS_EVENT_group")==null?" ":rs.getString("CONTR_SYS_EVENT_group");
				description=rs.getString("short_desc")==null?" ":rs.getString("short_desc");
				eventgrouptype= rs.getString("CONTR_SYS_ID")==null?" ":rs.getString("CONTR_SYS_ID");
			  
				beanvalins = code+"|"+description+"|"+eventgrouptype;
				
				RelinkBean.putObject(rowid);
				RelinkBean.putObject(beanvalins);
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		
			for(i=1;i<RelinkBean.getSize();i+=2)
			{
				if ( w % 2 == 0 )
					classValue = "QRYODD" ;
				else
				   classValue = "QRYEVEN" ;
			
				w++;

				disbean=RelinkBean.getObject(i).toString();
				
				StringTokenizer valCodes = new StringTokenizer(disbean,"|");
				
				while(valCodes.hasMoreTokens())
				{
					code=valCodes.nextToken(); 
					description=valCodes.nextToken();  
					valCodes.nextToken();  
					%> 
					<tr>
						<td class="<%=classValue%>" width="26%"><%=code%></td>
						<td class="<%=classValue%>" width="64%" colspan=2><%=description%></td>   
						<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selTextrelink(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=code%>">
					</tr> 
					<%
				}   
			} 
		}  
	}
	catch (Exception ee)
	{
		//out.println("Exception in FlowSheetApplicabilityIntermediate.jsp:"+ee.toString());//COMMON-ICN-0181
                ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
</table>
</div>
<input type="hidden" name="count" id="count" value="<%=i-2%>">
</form>
</body>
</html>

