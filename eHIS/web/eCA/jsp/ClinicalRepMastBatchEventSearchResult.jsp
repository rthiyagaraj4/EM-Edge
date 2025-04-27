<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Review Date	Reviewer	Description
--------------------------------------------------------------------------------------------------------
20/4/2015	IN055043		  Karthi								CA-Parameter Setup - Event Setup - System does not respond.
--------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.util.*, java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
		<!-- <modifeid by Archana  @08-12-2008> -->
        
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCA/js/ClinicalRepMast.js"></script>
	</head>
<%
	StringBuffer strsql1	= new StringBuffer(" ");
 	StringBuffer where		= new StringBuffer(" ");
 	StringBuffer countsql	= new StringBuffer(" ");
	StringBuffer strbuf		= new StringBuffer("");
    
    String histype		=	request.getParameter("histype")==null?"":request.getParameter("histype");
	String contr		=	request.getParameter("contr")==null?"":request.getParameter("contr");
	String searchby		=	request.getParameter("searchby")==null?"":request.getParameter("searchby");
	String criteria		=	request.getParameter("criteria")==null?"":request.getParameter("criteria");
	String text			=	request.getParameter("text")==null?"":request.getParameter("text");
	String from 		= 	request.getParameter("from");
	String to 			= 	request.getParameter("to");
	String whereclause	=	request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	String code			=	"";
	String description	=	""; 
			
	Connection con			=	null;
	PreparedStatement stmt	=	null;
	ResultSet rs			=	null;
	
	int start		=	0;
	int end			=	0;
	int i			=	1;
	int k			=	0;
	int maxRecord	=	0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	if(histype.equals("BLTF") && contr.equals("BT") )
	{
		strsql1.append("SELECT rowid row_id,PRODUCT_CODE EVENT_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC ,nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.PRODUCT_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn  FROM BT_PRODUCT_MAST A  WHERE NVL(STATUS,'E') ='E' ");

		if(searchby.equals("C"))
		{	// added text to upper case for existing PRODUCT_CODE condition - 55043
			if(criteria.equals("S"))
				strbuf.append(" and upper(PRODUCT_CODE) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(PRODUCT_CODE) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(PRODUCT_CODE) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	// added text to upper case for existing LONG_DESC condition - 55043
			if(criteria.equals("S"))
				strbuf.append(" and upper(LONG_DESC) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(LONG_DESC) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(LONG_DESC) like upper('%"+text+"%')");
		}

		countsql.append("SELECT count(*) total FROM BT_PRODUCT_MAST A WHERE NVL(STATUS,'E')='E' ");
		
   		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}

	if((histype.equals("CLNT") && contr.equals("CA"))||(histype.equals("LBIN") && contr.equals("CA")) ||      (histype.equals("TRET") && contr.equals("CA"))||(histype.equals("TRET") && contr.equals("CA")) || (histype.equals("RDIN") && contr.equals("CA"))||(histype.equals("SUNT") && contr.equals("CA")) || (histype.equals("PTCR") && contr.equals("CA")))
	{
		strsql1.append("SELECT rowid row_id,NOTE_TYPE EVENT_CODE, NOTE_TYPE_DESC SHORT_DESC, NOTE_TYPE_DESC LONG_DESC,	nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.NOTE_TYPE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM CA_NOTE_TYPE A WHERE EFF_STATUS ='E'");

		if(searchby.equals("C"))
		{	// added text to upper case for existing NOTE_TYPE_DESC condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(NOTE_TYPE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				strbuf.append(" and upper(NOTE_TYPE) like upper('"+text+"%')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(NOTE_TYPE) like upper('"+text+"%')");
		}
	    else if(searchby.equals("D"))
		{	// added text to upper case for existing NOTE_TYPE_DESC condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(NOTE_TYPE_DESC) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(NOTE_TYPE_DESC) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(NOTE_TYPE_DESC) like upper('%"+text+"%')");
		}

		countsql.append("SELECT count(*) total FROM CA_NOTE_TYPE A WHERE EFF_STATUS='E' ");

   		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
    }
	else if((histype.equals("PTCR") && contr.equals("OR")) || (histype.equals("TRET") && contr.equals("OR")) || (histype.equals("LBIN") && contr.equals("OR")) || (histype.equals("RDIN" ) && contr.equals("OR")) || (histype.equals("SUNT") && contr.equals("OR"))||(histype.equals("FDOC") && contr.equals("OR")))
	{
	 strsql1.append("SELECT rowid row_id,discr_msr_id EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.discr_msr_id AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM am_discr_msr A WHERE EFF_STATUS ='E' and result_type in ('Z','V','G')");
	 countsql.append("SELECT count(*) total from am_discr_msr A where eff_status = 'E' and result_type in ('Z','V','G') ");

	  if(searchby.equals("C"))
	  {	//added text to upper case for existing discr_msr_id condition - 55043
		 if(criteria.equals("S"))
		   strbuf.append(" and upper(discr_msr_id) like upper('"+text+"%')");
		 else if(criteria.equals("E"))
			 strbuf.append(" and upper(discr_msr_id) like upper('%"+text+"')");
		 else if(criteria.equals("C"))
			strbuf.append(" and upper(discr_msr_id) like upper('%"+text+"%')");
	  }
	  else if(searchby.equals("D"))
	  {	//added text to upper case for existing short_desc condition - 55043
		 if(criteria.equals("S"))
			strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
		 else if(criteria.equals("E"))
			strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
		 else if(criteria.equals("C"))
			strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
	   }
    
	   strsql1.append(strbuf.toString());
	   countsql.append(strbuf.toString());
	}
	else if((histype.equals("TRET") && contr.equals("MC")) || (histype.equals("RDIN") && contr.equals("MC")) || (histype.equals("SUNT") && contr.equals("MC")))
	{
     
		strsql1.append("SELECT rowid row_id,CPT_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.CPT_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM MR_CPT_CODE A WHERE EFF_STATUS ='E'");
		countsql.append("SELECT count(*) total from MR_CPT_CODE A where eff_status = 'E' ");

		 if(searchby.equals("C"))
		 {	//added text to upper case for existing CPT_CODE condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(CPT_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(CPT_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(CPT_CODE) like upper('%"+text+"%')");
		 }
		 else if(searchby.equals("D"))
		 {	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		 }
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if((histype.equals("TRET") && contr.equals("M9")) || (histype.equals("RDIN") && contr.equals("M9")) || (histype.equals("SUNT") && contr.equals("M9")))
	{
		 strsql1.append("SELECT rowid row_id,DIAG_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.DIAG_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM MR_ICD_CODE A WHERE EFF_STATUS ='E'");
		 countsql.append("SELECT count(*) total from MR_ICD_CODE A where eff_status = 'E' ");

		if(searchby.equals("C"))
		{	//added text to upper case for existing DIAG_CODE condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(DIAG_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(DIAG_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				 strbuf.append(" and upper(DIAG_CODE) like upper('%"+text+"%')");
		}
	    else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}

		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if(histype.equals("RDIN") && contr.equals("RD"))
	{	//added text to upper case for existing short_desc condition - 55043
		 strsql1.append("SELECT rowid row_id,EXAM_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.EXAM_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM rd_examination A WHERE nvl(status,'E')='E'");
		 countsql.append("SELECT count(*) total from rd_examination WHERE 1=1 ");

		 if(searchby.equals("C"))
		 {	//added text to upper case for existing EXAM_CODE condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(EXAM_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				strbuf.append(" and upper(EXAM_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(EXAM_CODE) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				 strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if(histype.equals("SUNT") && contr.equals("OT"))
	{
		 strsql1.append("SELECT rowid row_id,OPER_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.OPER_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM OT_OPER_MAST A WHERE nvl(STATUS,'E') ='E'");
		 countsql.append("SELECT count(*) total from OT_OPER_MAST a where nvl(STATUS,'E') = 'E' ");
  	     
		 if(searchby.equals("C"))
		 {	//added text to upper case for existing OPER_CODE condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(OPER_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(OPER_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				 strbuf.append(" and upper(OPER_CODE) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if(histype.equals("LBIN") && contr.equals("LB"))
	{
		strsql1.append("SELECT rowid row_id,test_code EVENT_CODE, short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.test_code AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM rl_test_code A WHERE NVL(STATUS,'E') ='E' AND  group_test_yn = 'Y' ");
		countsql.append("SELECT count(*) total from rl_test_code A where group_test_yn = 'Y' and nvl(status,'E') = 'E' ");

		if(searchby.equals("C"))
		{	//added text to upper case for existing test_code condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(test_code) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(test_code) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(test_code) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}

   	try
	{
		
		con =  ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(countsql.toString());
		rs = stmt.executeQuery();

		if(rs.next())
          maxRecord = Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));

		if(rs != null)rs.close();
		if(stmt != null)stmt.close();

	    if ( (whereclause == null || whereclause.equals("")) )
	    {
		    where.append(" order by 3");
			strsql1.append(where.toString()); 
	    }
	    else
			strsql1.append(whereclause);
	
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="ClinicalEventGroupBatchEventSearchResultForm" id="ClinicalEventGroupBatchEventSearchResultForm">	
<div id='divDataTitle' style='postion:relative'>
<table border="0" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr >
<%
	//out.println("<td width='90%' class='CAGROUP' align=center><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='90%' class='CAGROUP' ></td>");
 %>
</tr>
	 <tr>
	 <td  colspan = 4 width='100%' align='right'>
	 <%
	if ( !(start <= 1) )
	{
		
		out.println("<A class='gridLink' HREF='../../eCA/jsp/ClinicalRepMastBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	
	if ( !( (start+14) > maxRecord ) )
		{
		out.println("<A class='gridLink' HREF='../../eCA/jsp/ClinicalRepMastBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
%>	
</td>
</tr>
</table>
<table border="1" cellpadding="3" cellspacing="0" width="100%" align='center' name="resultTable" id="resultTable" id="resultTable">
<tr>
 <td class='COLUMNHEADERCENTER' style="font-size:10" width="25%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
 <td class='COLUMNHEADERCENTER' style="font-size:10" width="75%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<!--<th style="font-size:10" align=center width="10%">All<input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></th> -->
</tr>
</table>
</div>

<table class='grid' width="100%" align='center' name="resultTable2" id="resultTable2" id="resultTable2">
<% 
	String classValue	=	"";
	String rowid		=	"";
	String beankey1		=	"";
//	String beankey2		=	"";
	String checkstatus	=	"";	
	String strExists	=	"N";
	String code1="";
	String description1="";
	
	int p				=	0; 

	if ( start != 1 )
	{
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}
	}
	
	
	while(rs!=null && rs.next() && i<=end)
	{	
		 rowid			=	rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 code			=	rs.getString("EVENT_CODE")==null?" ":rs.getString("EVENT_CODE");
		 description	=	rs.getString("SHORT_DESC")==null?" ":rs.getString("SHORT_DESC");
		 strExists		=	rs.getString("exist_yn")==null?"N":rs.getString("exist_yn");

		 if ( i % 2 == 0 )
			classValue = "gridData" ;
		 else
			classValue = "gridData" ;
         
		 checkstatus = "";
		 for(int m=0;m<BatchBean.getSize();m+=2)
		 {

			//beankey=BatchBean.getObject(m).toString();
			beankey1=BatchBean.getObject(m+1).toString();
			//beankey2=BatchBean.getObject(m+2).toString();
			

			StringTokenizer valCodes = new StringTokenizer(beankey1,"|");

			while(valCodes.hasMoreTokens())
			{
					
				   code1=valCodes.nextToken();
				   
	               description1=valCodes.nextToken();

			
					
				if(code.equalsIgnoreCase(code1))
				{
				checkstatus="checked";
                p++; 
				break;
				}
			}
		 }
		 
		%>
		<tr>
		<td class="<%=classValue%>" width="25%"><%=code%></td>
		<td class="<%=classValue%>" width="60%"><%=description%></td>
		<td class="<%=classValue%>" width="15%"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" <%=checkstatus%> onClick="Reassaignbatch(this);chkunchk(this)" value="<%=k%>"><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>"></td>
		<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=code%>|<%=description%>'> 
			<input type=hidden name='code_res<%=k%>' id='code_res<%=k%>' value="<%=code%>">
		</tr>
		<%
			i++;
			k++;
		}
		//IN055043 - Start
		if(i==1)
		{	
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')); location.href='../../eCommon/html/blank.html'</script>");
		}
		// End	
		/*
		if((p+1) == i || p == 14)
		{
		
			<script>document.forms[0].ctrlChkBox.checked = true</script> 
			<%
		}
			
		
		if(i == 1)
		{
   			
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));</script>
				<script>document.forms[0].ctrlChkBox.disabled = true</script> 
			<%
		}*/
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();		 	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in ClinicalRepMastBatchEventSearchResult.jsp" + e);//COMMON-ICN-0181
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

