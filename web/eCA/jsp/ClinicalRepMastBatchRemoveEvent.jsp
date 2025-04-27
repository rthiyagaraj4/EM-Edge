<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="BatchBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCA/js/ClinicalRepMast.js"></script>

</head>

<%
	StringBuffer strsql1 = new StringBuffer(" ");
 	StringBuffer where = new StringBuffer(" ");
 	StringBuffer countsql = new StringBuffer(" ");
    
		
    String histype=request.getParameter("histype")==null?"":request.getParameter("histype");
	String contr=request.getParameter("contr")==null?"":request.getParameter("contr");
	String searchby=request.getParameter("searchby")==null?"":request.getParameter("searchby");
	String criteria=request.getParameter("criteria")==null?"":request.getParameter("criteria");
	String text=request.getParameter("text")==null?"":request.getParameter("text");
	
	//out.println("<script>alert('searchby"+searchby+"')</script>");
	//out.println("<script>alert('criteria"+criteria+"')</script>");
	//out.println("<script>alert('text"+text+"')</script>");
		
	String from 			= 
	request.getParameter("from");
	//out.println("<script>alert('from"+from+"')</script>");
	String to 	= 
	request.getParameter("to");
	//out.println("<script>alert('to"+to+"')</script>");
	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	//String pract_id=(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('pract_id"+pract_id+"')</script>");
	
	String code="";
	String description=""; 
			
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		StringBuffer strbuf= new StringBuffer("");

    if(histype.equals("CLNT") && contr.equals("CA"))
	{
    strsql1.append("SELECT rowid row_id,NOTE_GROUP EVENT_GROUP_CODE, REPLACE(NOTE_GROUP_DESC,'''','') SHORT_DESC FROM CA_NOTE_GROUP A WHERE EFF_STATUS='E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.NOTE_GROUP AND EVENT_GROUP_TYPE=?)");



	 if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and NOTE_GROUP like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and NOTE_GROUP like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and NOTE_GROUP like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and NOTE_GROUP_DESC like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and NOTE_GROUP_DESC like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and NOTE_GROUP_DESC like '%"+text+"%'");
		}

	countsql.append("SELECT count(*) total FROM CA_NOTE_GROUP A WHERE EFF_STATUS='E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.NOTE_GROUP AND EVENT_GROUP_TYPE=?)");

   	strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());

	
    }
	else if((histype.equals("PTCR") && contr.equals("OR")) || (histype.equals("TRET") && contr.equals("OR")) || (histype.equals("LBIN") && contr.equals("OR")) || (histype.equals("RDIN" ) && contr.equals("OR")) || (histype.equals("SUNT") && contr.equals("OR")))
	{
     strsql1.append("SELECT rowid row_id,discr_msr_id EVENT_GROUP_CODE,replace(short_desc,'''','') short_desc from am_discr_msr  A where eff_status = 'E' and result_type in ('Z','V','G') AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.discr_msr_id AND EVENT_GROUP_TYPE=?)");

	 countsql.append("SELECT count(*) total from am_discr_msr A where eff_status = 'E' and result_type in ('Z','V','G') AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.discr_msr_id AND EVENT_GROUP_TYPE=?)");

	  if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and discr_msr_id like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and discr_msr_id like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and discr_msr_id like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and short_desc like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and short_desc like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and short_desc like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());
      		
	}
	else if(histype.equals("RDIN") && contr.equals("RD"))
	{
		 strsql1.append("SELECT rowid row_id,EXAM_CODE EVENT_GROUP_CODE,replace(short_desc,'''','') short_desc from rd_examination A where NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.EXAM_CODE AND EVENT_GROUP_TYPE=?)");

		 countsql.append("SELECT count(*) total from rd_examination a where NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.EXAM_CODE AND EVENT_GROUP_TYPE=?)");

		  if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and EXAM_CODE like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and EXAM_CODE like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and EXAM_CODE like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and short_desc like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and short_desc like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and short_desc like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());
		
	}
	else if(histype.equals("LBIN") && contr.equals("LB"))
	{
    
	strsql1.append("SELECT rowid row_id,test_code EVENT_GROUP_CODE, short_desc from rl_test_code a where group_test_yn = 'Y' and nvl(status,'E') = 'E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.TEST_CODE AND EVENT_GROUP_TYPE=?)");
    
	 countsql.append("SELECT count(*) total from rl_test_code A where group_test_yn = 'Y' and nvl(status,'E') = 'E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.TEST_CODE AND EVENT_GROUP_TYPE=?)");

	   if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and test_code like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and test_code like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and test_code like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and short_desc like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and short_desc like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and short_desc like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());

	
	}

   	try
	{
       con =  ConnectionManager.getConnection(request);

	   stmt = con.prepareStatement(countsql.toString());

	   int s=0;

		
        stmt.setString(++s,histype);
		stmt.setString(++s,contr);
		
				
    	rs = stmt.executeQuery();

		if(rs.next())
		{
          maxRecord = Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));
		}

		if(rs != null)rs.close();
		if(stmt != null)stmt.close();

	    if ( (whereclause == null || whereclause.equals("")) )
	    {
       
        
        where.append(" order by 3");
	    strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);

	    }

		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		
        stmt.setString(++st,histype);
		stmt.setString(++st,contr);
		
				
    	rs = stmt.executeQuery();
	    
	 %>

<body onScroll="scrollTitle()" onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>





<form name="ClinicalEventGroupBatchEventSearchResultForm" id="ClinicalEventGroupBatchEventSearchResultForm">	
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="0" cellspacing="0" width="100%" align="center">
<tr >
<%
if ( !(start <= 1) )
		{
out.println("<td width='85%' class='CAGROUP' align=center><b><font size='2'>Search Result</b></td><td width='10%' align=right nowrap>");
out.println("<A HREF='../../eCA/jsp/ClinicalEventGroupBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>Previous</A>");
		}
		else
		{
out.println("<td width='100%' class='CAGROUP' align=center><b><font size='2'>Search Result</b></td><td width='10%' align=right nowrap>");
		}

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A HREF='../../eCA/jsp/ClinicalEventGroupBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>Next</A>");
		}
	%>	
</td>
</tr>
</table>

<table border="1" cellpadding="0" cellspacing="0" width="100%"  name="resultTable" id="resultTable" id="resultTable">
<tr>
 <th style="font-size:10" align=center width="26%">Code</th>
 <th style="font-size:10" align=center width="64%" colspan=2>Description</th>
<th style="font-size:10" align=center width="10%">All<input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></th> 
</tr>
</table>
</div>
<table border="1"  cellpadding="0" cellspacing="0" width="100%"  name="resultTable2" id="resultTable2" id="resultTable2">
	<% 
	//out.println("<script>alert('start"+start+"')</script>");
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
      if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
	//out.println("<script>alert('rs.next()="+rs.next()+"')</script>");

		String classValue="";
		String rowid="";
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		
		 rowid=rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 code=rs.getString("EVENT_GROUP_CODE")==null?" ":rs.getString("EVENT_GROUP_CODE");
		 description=rs.getString("SHORT_DESC")==null?" ":rs.getString("SHORT_DESC");
		 
		
		 	 
		 if ( i % 2 == 0 )
		 classValue = "QRYODD" ;
		 else
		 classValue = "QRYEVEN" ;
	  	
	    
		 String beankey="";		
	 	 String checkstatus="";		
         
		for(int m=0;m<BatchBean.getSize();m+=2)
				{
					beankey=BatchBean.getObject(m).toString();
					
  					if(rowid.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					
                   

				}
				
			%>
                <tr>
				<td class="<%=classValue%>" width="26%"><%=code%></td>
				<td class="<%=classValue%>" colspan=2 width="64%"><%=description%></td>
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaignbatch(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>"></td>
				<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=code%>|<%=description%>'> 
				</tr>
			
				
				
		<%
				i++;
				k++;
		}
		 if((p+1) == i || p == 14)
					{
					%>
					<script>document.forms[0].ctrlChkBox.checked = true</script> 
					<%}
		if(i == 1)
		{
   		%>
        <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));</script>
		<script>document.forms[0].ctrlChkBox.disabled = true</script> 
		<%}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkFutureEventResult.jsp" + e);//common-icn-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}

%>
			
			
			
			<input type="hidden" name="count" id="count" value="<%=k%>">
			
			
</table>

</form>
</body>
</script>
</html>

