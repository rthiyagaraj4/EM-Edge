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
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="FlowSheetBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	

%>
		<!-- Added by Arvind @ 07-12-08 -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/FlowSheetCompDetail.js'></script>


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

<form name="FlowSheetCompDetailResultForm" id="FlowSheetCompDetailResultForm" action='../../servlet/eCA.FlowSheetCompDetailServlet' method="post" target="messageFrame">
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr ><th colspan=2  class='columnHeader' align='left'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></th></tr>
<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable">
<tr>
<th class='columnHeadercenter' nowrap width="26%" style="font-size:10" align='left'><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></th>
<th class='columnHeadercenter' nowrap width="26%" style="font-size:10" align='left'><fmt:message key="eCA.EventCode.label" bundle="${ca_labels}"/></th>
<th class='columnHeadercenter' nowrap width="38%" style="font-size:10" align='left'><fmt:message key="Common.EventDescription.label" bundle="${common_labels}"/></th>
<th class='columnHeadercenter' nowrap width="10%" style="font-size:10" align='left'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
</table>
</div>



<div id="finalDiv1">
<table class="grid" width="100%">



<%
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String code="";
	String description="";
	//String rowid="";
	String beanvalins="";
	//String eventgrouptype="";
	
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";
	String key="";
	String histtype="";

	String eventcode="";
	String eventdesc="";
	String histrectype="";
	String event_code_type="";

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

   try
   {
    con =  ConnectionManager.getConnection(request);
	String flow_sheet_id=request.getParameter("flow_sheet_id")==null?"":request.getParameter("flow_sheet_id");
	//String history_type_id=request.getParameter("history_type_id")==null?"":request.getParameter("history_type_id");
	//String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		
	String classValue="";
	int w=0;
	return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	
	//String formet="";
					//out.println("return_format :" +return_format);
	
	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");


	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	if(mode.equals("insert"))
    FlowSheetBean.clearAll();
	

	if(sel_all.equals("select"))
	{	
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	//String cat = "";
	int i=0;
   if(flag.equals("clear"))
	{
		
      
		FlowSheetBean.clearAll();
	}
	
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
					key= tempCodes.nextToken();
					value=tempCodes.nextToken();

				 FlowSheetBean.putObject(key);
				 FlowSheetBean.putObject(value);
				 
			}
 					
		}
		 
	}		
				
				for(i=1;i<FlowSheetBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;
				//out.println("<script>alert('classValue"+classValue+"')</script>");
		
					key=FlowSheetBean.getObject(i-1).toString();
					disbean=FlowSheetBean.getObject(i).toString();
					
					StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
				   histtype=valCodes.nextToken();  	
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
				   valCodes.nextToken();  
	               
 	              %> 
              <tr>
				<td class="<%=classValue%>" width="26%"><%=histtype%></td>
				<td class="<%=classValue%>" width="26%"><%=code%></td>
				<td class="<%=classValue%>" width="38%" colspan=2><%=description%></td>   
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=key%>">
				</tr>
				
				
					<%
				
				//	cat=formet+textbuffer.toString();
				//	cat=cat.replace('|' , ',');
                    //cat=cat.replace('|' , '');  
				}
				}
				%>
		   	
		<%
	}

				

%>
</td>
</tr>
<%

	if(removebean.equals("Y"))
	{
	// String beankey="";
	// String code2="";
	  for(int l=0;l<FlowSheetBean.getSize();l+=2)
	   {
			key=FlowSheetBean.getObject(l).toString();  

           
			if(remval.equalsIgnoreCase(key))
			{
					FlowSheetBean.removeObject(l);
					FlowSheetBean.removeObject(l);
					break;
			}
		}

				/*ArrayList d=new ArrayList();
				d=FlowSheetBean.getRecordSetHandle();
				int size=0;
				size=d.size();
				d.clear();*/
				w=0;
				for( i=1;i<FlowSheetBean.getSize();i+=2)
				{
					
					//beanval=d.get(i).toString();
				    if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;

					key=FlowSheetBean.getObject(i-1).toString();
					beanval=FlowSheetBean.getObject(i).toString();
					
					StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
				{
				   histtype=valCodes.nextToken();  	
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
				   valCodes.nextToken();  
				%>
				<tr>
				<td class="<%=classValue%>" width="26%"><%=histtype%></td>
				<td class="<%=classValue%>" width="26%"><%=code%></td>
				<td class="<%=classValue%>" width="38%" colspan=2><%=description%></td>   
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=key%>">
				</tr>
				<%
						//cat=formet+textbuffer.toString();
						//cat=cat.replace('|' , ',');
                       // cat=cat.replace('|' , ' ');  
					}
		
	}
}
if(mode.equals("insert"))
		{	

//Commented for IN063542 Starts
/*
			//int count=0;
			//String sqlupdate="select A.HIST_REC_TYPE, A.LONG_DESC HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLIN_EVENT_MAST D ,CA_FLOW_SHEET_ITEM B WHERE B.FLOW_SHEET_ID=? AND  B.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.EVENT_CODE=B.EVENT_CODE AND D.EVENT_CODE_TYPE=B.EVENT_CODE_TYPE " ; 
			String sqlupdate="select A.HIST_REC_TYPE, CR_GET_DESC.CR_HIST_REC_TYPE(A.HIST_REC_TYPE,?,'1') HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLN_EVT_MST_LANG_VW D ,CA_FLOW_SHEET_ITEM B WHERE B.FLOW_SHEET_ID=? AND  B.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.LANGUAGE_ID = ? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.EVENT_CODE=B.EVENT_CODE AND D.EVENT_CODE_TYPE=B.EVENT_CODE_TYPE";
			pstmt=con.prepareStatement(sqlupdate,ResultSet.TYPE_SCROLL_INSENSITIVE,
											  ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,locale);
			pstmt.setString(2,flow_sheet_id);
			pstmt.setString(3,locale);
*/
//Commented for IN063542 Ends

// Added changes starts IN063542
			StringBuffer updateSqlBuffer = new StringBuffer();

			updateSqlBuffer.append("select A.HIST_REC_TYPE, CR_GET_DESC.CR_HIST_REC_TYPE(A.HIST_REC_TYPE,?,'1') HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLN_EVT_MST_LANG_VW D ,CA_FLOW_SHEET_ITEM B WHERE B.FLOW_SHEET_ID=? AND  B.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.LANGUAGE_ID = ? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.EVENT_CODE=B.EVENT_CODE AND D.EVENT_CODE_TYPE=B.EVENT_CODE_TYPE");

			updateSqlBuffer.append( " UNION SELECT B.HIST_REC_TYPE, DECODE (C.ORDER_CATEGORY, 'LB', 'Laboratory', 'RD', 'Radiology', '')  HIST_REC_TYPE_DESC,b.Event_code,D.LONG_DESC EVENT_DESC,C.ORDER_CATEGORY EVENT_CODE_TYPE  FROM CA_FLOW_SHEET_ITEM b, OR_ORDER_CATALOG c ,OR_ORDER_CATALOG_LANG d WHERE b.flow_sheet_id = ? AND b.Event_code = c.contr_msr_panel_id and C.ORDER_CATALOG_CODE= d.order_catalog_code and D.language_id=? and C.ORDER_CATALOG_NATURE='P'");
			
			pstmt=con.prepareStatement(updateSqlBuffer.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			int j=1;
			pstmt.setString(j++,locale);
			pstmt.setString(j++,flow_sheet_id);
			pstmt.setString(j++,locale);
			pstmt.setString(j++,flow_sheet_id);
			pstmt.setString(j++,locale);
// IN063542 Added Changes ends 
			rs=pstmt.executeQuery();
			while( rs.next())
			{
		 eventcode=rs.getString("EVENT_CODE")==null?" ":rs.getString("EVENT_CODE");
		 eventdesc=rs.getString("EVENT_DESC")==null?" ":rs.getString("EVENT_DESC");
		 histrectype=rs.getString("HIST_REC_TYPE")==null?" ":rs.getString("HIST_REC_TYPE");
		 event_code_type=rs.getString("EVENT_CODE_TYPE")==null?" ":rs.getString("EVENT_CODE_TYPE");
              
               key = histrectype+eventcode+event_code_type;
			   beanvalins = histrectype+"|"+eventcode+"|"+eventdesc+"|"+event_code_type;

				FlowSheetBean.putObject(key);
				FlowSheetBean.putObject(beanvalins);
				
				
			}if(rs!=null) rs.close();
			  if(pstmt!=null) pstmt.close();
		

		for(i=1;i<FlowSheetBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;
			
		
					key=FlowSheetBean.getObject(i-1).toString();

					beanvalins=FlowSheetBean.getObject(i).toString();

										
					StringTokenizer valCodes = new StringTokenizer(beanvalins,"|");
					if(valCodes.hasMoreTokens())
				{
					
				   histtype=valCodes.nextToken();  	
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
                   valCodes.nextToken(); 
 	              %> 
               <tr>
				<td class="<%=classValue%>" width="26%"><%=histtype%></td>
				<td class="<%=classValue%>" width="26%"><%=code%></td>
				<td class="<%=classValue%>" width="38%" ><%=description%></td>   
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=key%>">
				</tr> 
				
				
					<%
				
				
				}   
				} 
				}  

   
%>


</table>
</div>

<input type="hidden" name="count" id="count" value="<%=i-2%>">
	<%
   }
catch(Exception e)
			{
				//out.println("Exception in try :"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
	
			finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
	%>
<input type="hidden" name="flow_sheet_id" id="flow_sheet_id" value="">
</form>
</body>
</html>

