<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History      Name       	Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           										created
07/03/2017	 IN063542		Raja S			10/03/2017		Ramesh G			GHL-CRF-0460
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="FlowSheetBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =	  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//IN063542 Starts
		Properties pr  =	  (Properties)session.getValue("jdbc");
		String locale =   (String) pr.getProperty("LOCALE");
		//IN063542 Ends
	%>
	<!-- Added by Arvind @ 07-12-08 -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCA/js/FlowSheetCompDetail.js"></script>
		

</head>

<%
	StringBuffer strsql1 = new StringBuffer(" ");
	StringBuffer strsql2 = new StringBuffer(" "); //Added for IN063542
 	StringBuffer where = new StringBuffer(" ");
 	StringBuffer countsql = new StringBuffer(" ");
    
		
    String flow_sheet_id=request.getParameter("flow_sheet_id")==null?"":request.getParameter("flow_sheet_id");
	String history_type_id=request.getParameter("history_type_id")==null?"":request.getParameter("history_type_id");
	String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
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
	
	//String rowid="";
	String eventcode="";
	String eventdesc="";
	String histrectype="";
	String event_code_type="";
	String key="";
			
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1;
	else
		start = Integer.parseInt(from);

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		StringBuffer strbuf= new StringBuffer("");
		StringBuffer strbuf1= new StringBuffer(""); //Added for IN063542

   
	    
	strsql1.append("select A.HIST_REC_TYPE, A.LONG_DESC HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC,NVL((SELECT 1 FROM CA_FLOW_SHEET_ITEM WHERE HIST_REC_TYPE=A.HIST_REC_TYPE and EVENT_CODE = D.EVENT_CODE AND EVENT_CODE_TYPE=D.EVENT_CODE_TYPE  AND FLOW_SHEET_ID=?),'0') EVENT_EXISTS  ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLIN_EVENT_MAST D WHERE   A.HIST_REC_TYPE=? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE");
	strsql2.append(" UNION select DECODE (C.ORDER_CATEGORY, 'LB', 'LBIN', 'RD', 'RDIN', '')  HIST_REC_TYPE, DECODE (C.ORDER_CATEGORY, 'LB', 'Laboratory', 'RD', 'Radiology', '')  HIST_REC_TYPE_DESC,c.contr_msr_panel_id EVENT_CODE,D.LONG_DESC EVENT_DESC,NVL((SELECT 1 FROM CA_FLOW_SHEET_ITEM WHERE HIST_REC_TYPE = ? AND EVENT_CODE = C.contr_msr_panel_id AND FLOW_SHEET_ID = ?),'0') EVENT_EXISTS,C.Order_category EVENT_CODE_TYPE from OR_ORDER_CATALOG c , OR_ORDER_CATALOG_LANG D WHERE ORDER_CATALOG_NATURE='P' AND C.ORDER_CATEGORY = ?  and C.ORDER_CATALOG_CODE= d.order_catalog_code and D.language_id=? "); //Added for IN063542

	//strsql1.append("select A.HIST_REC_TYPE, CR_GET_DESC.CR_HIST_REC_TYPE(A.HIST_REC_TYPE,?,'2') HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC,NVL((SELECT 1 FROM CA_FLOW_SHEET_ITEM WHERE HIST_REC_TYPE=A.HIST_REC_TYPE and EVENT_CODE = D.EVENT_CODE AND EVENT_CODE_TYPE=D.EVENT_CODE_TYPE  AND FLOW_SHEET_ID=?),'0') EVENT_EXISTS  ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLN_EVT_MST_LANG_VW D WHERE   D.LANGUAGE_ID = ? AND A.HIST_REC_TYPE=? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE");
	 countsql.append("SELECT count(*) total FROM  CR_HIST_REC_TYPE A, CR_CLIN_EVENT_MAST D WHERE   A.HIST_REC_TYPE=? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE");

	   if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and D.EVENT_CODE like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and D.EVENT_CODE like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and D.EVENT_CODE like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and D.SHORT_DESC like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and D.SHORT_DESC like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and D.SHORT_DESC like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());
	//Added for IN063542 starts
	if("LBIN".equals(history_type_id) || "RDIN".equals(history_type_id)) {
		strsql1.append(strsql2.toString());
			 if(searchby.equals("C"))
				{
			 	if(criteria.equals("S"))
	         	strbuf1.append(" and c.contr_msr_panel_id like '"+text+"%'");
			 	else if(criteria.equals("E"))
	         	strbuf1.append(" and c.contr_msr_panel_id like '%"+text+"'");
			 	else if(criteria.equals("C"))
	         	strbuf1.append(" and c.contr_msr_panel_id like '%"+text+"%'");
				}
		 	else if(searchby.equals("D"))
				{
			 	if(criteria.equals("S"))
	         	strbuf1.append(" and C.LONG_DESC like '"+text+"%'");
			 	else if(criteria.equals("E"))
	         	strbuf1.append(" and C.LONG_DESC like '%"+text+"'");
			 	else if(criteria.equals("C"))
	         	strbuf1.append(" and C.LONG_DESC like '%"+text+"%'");
				}
			 strsql1.append(strbuf1.toString());
	}
	//Added for IN063542 Ends
	

	
	
   	try
	{
       con =  ConnectionManager.getConnection(request);

	   stmt = con.prepareStatement(countsql.toString());

	   int s=0;

		
       stmt.setString(++s,history_type_id);
		
					
    	rs = stmt.executeQuery();

		if(rs.next())
		{
          maxRecord = Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));
		}
       //out.println("<script>alert('maxRecord"+maxRecord+"')</script>");
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();

	    if ( (whereclause == null || whereclause.equals("")) )
	    {
       
           strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);
		

	    }
		strsql1.append(" ORDER BY 2,1,4,3");


		stmt = con.prepareStatement(strsql1.toString());

		int st=0;

//		stmt.setString(++st,locale);
        stmt.setString(++st,flow_sheet_id);
//		stmt.setString(++st,locale);
		stmt.setString(++st,history_type_id);
		//Added for IN063542 starts
		if("LBIN".equals(history_type_id) || "RDIN".equals(history_type_id)) {
			stmt.setString(++st,history_type_id);
			stmt.setString(++st,flow_sheet_id);

			if("LBIN".equals(history_type_id))
				stmt.setString(++st,"LB");
			else if("RDIN".equals(history_type_id))
				stmt.setString(++st,"RD");
			stmt.setString(++st,locale);
		}	

		//Added for IN063542 ends
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





<form name="FlowSheetEventSearchResultForm" id="FlowSheetEventSearchResultForm">	
<div id='divDataTitle' style='postion:relative'>
<table border="0" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center" scrolling="no">
 
<!-- <table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
 -->
<td class='white' width='88%'></td> 
<td  align='right' width='12%'>
<%
//out.println("<script>alert('start"+start+"')</script>");
//out.println("<script>alert('end"+end+"')</script>");
if ( !(start <= 1) )
		{
out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetCompDetailList.jsp?flow_sheet_id="+flow_sheet_id+"&history_type_id="+history_type_id+"&event_item="+event_item+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
		

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetCompDetailList.jsp?flow_sheet_id="+flow_sheet_id+"&history_type_id="+history_type_id+"&event_item="+event_item+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	%>	
</td>
</tr>
</table>
<table border="1" cellpadding="3" cellspacing="0" width="100%"  name="resultTable" id="resultTable" id="resultTable">
<tr>
<th class='columnHeader' colspan=3 align="left"><fmt:message key="Common.searchresult.label" bundle="${common_labels}"/></td>
</tr><tr>
<th class='columnHeadercenter' style="font-size:10" width="26%" align="left"><fmt:message key="eCA.EventCode.label" bundle="${ca_labels}"/></td>
<th class='columnHeadercenter' style="font-size:10"width="64%" align="left"><fmt:message key="Common.EventDescription.label" bundle="${common_labels}"/></td>
<th class='columnHeadercenter' style="font-size:10" width="10%" align="left"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> 
</tr>
</table>
</div>
<table class="grid"  width="100%"  name="resultTable" id="resultTable" id="resultTable">
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
		
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		
			 
		 eventcode=rs.getString("EVENT_CODE")==null?" ":rs.getString("EVENT_CODE");
		 eventdesc=rs.getString("EVENT_DESC")==null?" ":rs.getString("EVENT_DESC");
		 histrectype=rs.getString("HIST_REC_TYPE")==null?" ":rs.getString("HIST_REC_TYPE");
		 event_code_type=rs.getString("EVENT_CODE_TYPE")==null?" ":rs.getString("EVENT_CODE_TYPE");
		 
		 key = histrectype+eventcode+event_code_type;
		
		 	 
		 if ( i % 2 == 0 )
		 classValue = "gridData" ;
		 else
		 classValue = "gridData" ;
	  	
	    
		 String beankey="";		
	 	 String checkstatus="";		
	 	// String code2="";		
	 	 //String code="";		
         
		for(int m=0;m<FlowSheetBean.getSize();m+=2)
				{
					beankey=FlowSheetBean.getObject(m).toString();
					 					
					if(key.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					
                   

				}
				
			%>
                <tr>
				<td class="<%=classValue%>" width="26%"><%=eventcode%></td>
				<td class="<%=classValue%>"  width="64%"><%=eventdesc%></td>
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=key%>"></td>
				<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=key%>~<%=histrectype%>|<%=eventcode%>|<%=eventdesc%>|<%=event_code_type%>'> 
				</tr>
			
				
				
		<%
				i++;
				k++;
		}
		 if((p+1) == i || p == 14)
					{
					%>
					<!-- <script>document.forms[0].ctrlChkBox.checked = true</script>  -->
					<%}
		if(i == 1)
		{
   		%>
        <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>
		<!-- <script>document.forms[0].ctrlChkBox.disabled = true</script>  -->
		<%}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in FlowSheetCompDetailListResult.jsp" + e);//COMMON-ICN-0181
	
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

