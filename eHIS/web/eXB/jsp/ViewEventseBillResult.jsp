<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import   ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXB.XBDBAdapter,java.sql.*,java.util.*,java.util.regex.Pattern,java.io.*,eXB.*,eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8"); %> 
<% String locale = ((String)session.getAttribute("LOCALE")); 
locale = "en"; 
		 int g=0;
		 int acccount=1;
		 %>
<% 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css' type='text/css'></link>
<style>																	   					   
	div {float: left}									 									   
	.testSty																				   
	{
		width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}

	input.bigcheck { 																     
		height: 11px; 
		width: 12px; 
		} 

</style>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script> 		 
<script Language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>									    
<script Language="javascript" src="../../eXH/js/Validate.js" ></script>						    
<script Language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="javascript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eXH/js/jquery-1.7.min.js'></script>
<script language='javascript' src='../../eXH/js/GatewayServer.js'></script>
<script language='javascript' src='../../eXB/js/ViewEventsOutbound.js'></script>
<script language='javascript' src='../../eXB/js/ViewEvents.js'></script>
<script language="javascript">

//function callForOrderBy
function callForOrderBy(obj,order)															 
{	
//	alert("order : "+order);
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXB/jsp/ViewEventseBillResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod_dtl";
	this.document.forms[0].submit();
}

</script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%
Connection con=null;
Statement stmt1=null;
ResultSet rs1=null;
int rsCount = 0;
String QryCols = "";
String emptyString = "";
float Tot_Inv_Amount = 0.00f;
//String disabled = "disabled";
String msg_status= null;
String eventtype= null;
String protocolLinkID = null;
String applnname = null;
String facility = null;
String styleExport = "display:none";
String orderBy = null;
String order = null;															     
String whereClause =" ";
String DataLinestr="";
%>
<form name="ApplicationEventListForMessageTypeForm" id="ApplicationEventListForMessageTypeForm" target='messageFrame' method='post' >

<%	
Pattern Regex1=null;
//String qry_id = "VIEW_GENERAL_EVENTS_EBILL";
 String totalMsgList=XBDBAdapter.checkNull(request.getParameter("totalMsgList")); 
  try{
			Regex1 = Pattern.compile("\\$!",Pattern.MULTILINE);
		}
		catch(Exception e)
		{
			System.out.println("erorr"+e);
		}															    

try			 	
{
	boolean boolToggle =  true;	
	String strTDClass = "";

	String msg_dt1= null;
	String msg_dt2= null;
	String msg_id1= null;
	String msg_id2= null;	
	String comm_mode= null;
	String event_status = null;
	String protocol_link_name= null;
//	String purge_status= null;						    
	String dispMode= null;
	String interface_module= null;
	
	msg_dt1			= XBDBAdapter.checkNull(request.getParameter("msg_dt1"));
	msg_dt2			= XBDBAdapter.checkNull(request.getParameter("msg_dt2"));
	msg_id1			= XBDBAdapter.checkNull(request.getParameter("msg_id1"));
	msg_id2			= XBDBAdapter.checkNull(request.getParameter("msg_id2"));
	applnname		= XBDBAdapter.checkNull(request.getParameter("applnname"));
	eventtype			= XBDBAdapter.checkNull(request.getParameter("eventtype"));
	comm_mode		= XBDBAdapter.checkNull(request.getParameter("comm_mode"));
	facility				= XBDBAdapter.checkNull(request.getParameter("facility"));
	event_status		= XBDBAdapter.checkNull(request.getParameter("event_status"));
	msg_status		= XBDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
	protocol_link_name	= XBDBAdapter.checkNull(request.getParameter("protocol_link_name"));
	dispMode					= XBDBAdapter.checkNull(request.getParameter("dispMode"));
	interface_module		= XBDBAdapter.checkNull(request.getParameter("interface_module"));
	orderBy			= XBDBAdapter.checkNull(request.getParameter("orderBy"));
	order				= XBDBAdapter.checkNull(request.getParameter("order"));
    String accVal	=  XBDBAdapter.checkNull(request.getParameter("acccount"));
	String gVal		=  XBDBAdapter.checkNull(request.getParameter("g"));
	protocolLinkID = new XHUtil().singleParamExeQry("SELECT DISTINCT protocol_link_id FROM xh_data_group_detail WHERE event_type = '" + eventtype + "'");	

	if(!accVal.equals("") && !accVal.equals("null") && !accVal.equals(null) ) 
		acccount		=	Integer.parseInt(accVal);
	if(!gVal.equals("") && !gVal.equals("null") && !gVal.equals(null) ) 
		g					=	Integer.parseInt(gVal);

	if(msg_status.equals("H") && !eventtype.equals("") ){
	//	disabled = "";
		styleExport="display:block";
	}

	String NewColList = XBDBAdapter.checkNull(request.getParameter("NewColList"));
	//	System.out.println("NewColList : "+NewColList);
	con=ConnectionManager.getConnection();
//	String qry = "SELECT * FROM XB_EVENT_APPL_MESSAGE_XL_VW  ";				   

	String ResultQry = "";
	Pattern Regex=null;
//	String Colstatus = "";
//	String ColVal = "";
	String EvntStatusColor = "../../eXH/images/black_square.jpg";
	String MsgStatusColor = "../../eXH/images/blue_square.jpg";

	 try{

		 File file1 = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );

           if(NewColList.length()>0){
		 			FileOutputStream fileoutput = new FileOutputStream(file1);
					fileoutput.write(NewColList.getBytes());
					if (fileoutput != null)  fileoutput.close();	
		   }
	   		 File file2 = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );
//			 boolean exists = file2.exists();	
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
			 DataLinestr = br.readLine();
			 br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
       }
	//		System.out.println("ViewEventseBillDtlsResultPage.jsp DataLinestr :"+DataLinestr);
		try{
			Regex = Pattern.compile("\\,",Pattern.MULTILINE);
// System.out.println("ViewEventseBillDtlsResultPage.jsp Regex :"+Regex);

		}
		catch(Exception e)
		{
			System.out.println("ViewEventseBillResult.jsp erorr"+e);
		}															    
																				    
		String[] array=Regex.split(DataLinestr);

//		int lastElementIndex=(array.length-1);
//	    System.out.println("array.length : "+array.length);
		for(int i=0;i<array.length;i++)
		{
// String name=array[i].replaceFirst("_"," ");					 
	if(array[i].equals("INV_NO")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)-1)  INV_NO,";
			}
			else  if(array[i].equals("INV_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)-1)  INV_DATE,";
			}
			else if(array[i].equals("INV_AMOUNT")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)-1) INV_AMOUNT,";
			}
			else if(array[i].equals("VISIT_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)-1)  VISIT_DATE,";
			}
			else if(array[i].equals("PATIENT_NAME")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)-1)  PATIENT_NAME,";
			}
			else if(array[i].equals("PATIENT_TYPE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)-1) PATIENT_TYPE,";
			}
			else if(array[i].equals("CARD_ID")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)-1)  CARD_ID,";
			}
			else if(array[i].equals("CARD_ISSUE_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)-1)  CARD_ISSUE_DATE,";
			}
			else if(array[i].equals("CITIZEN_ID")){
//				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1)  CITIZEN_ID,";
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,13) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)-1) CITIZEN_ID,";
			}
			else{									  
				QryCols = QryCols+array[i]+",";	
			}
		}
		QryCols = QryCols.substring(0,QryCols.length()-1);


//	try
//	{  
		//facility	
		if((facility != null ) && (!(facility.equals(""))))			
		{
			whereClause =whereClause + " FACILITY_ID = NVL('"+facility+"',FACILITY_ID)";
//			flag=true;
		} 

		//application_id
		if( (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " AND APPLICATION_ID = NVL('"+applnname+"',APPLICATION_ID) ";
		}																   

		//msgstatus
		if( (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" AND MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" AND MESSAGE_STATUS = "+"NVL('"+msg_status+"',MESSAGE_STATUS)";
		}  

		//msg_id1
		if((msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"'',20),message_id)";
			}
			else
			{
				whereClause =whereClause +" AND message_id BETWEEN"+ 	
								"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
			}
		} 

		//msg_id2
		if( (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND message_id <"+ 	
								"  nvl('"+msg_id2+"',message_id)";
			}
		} 

		//msg_dt1

		String messageDateFrom = msg_dt1;
		String messageDateTo = msg_dt2;
		// Converting the message date from thai to english locale
		if("th".equalsIgnoreCase(locale) && ((msg_dt1 != null) && (!(msg_dt1.equals("")))))
		{
			messageDateFrom = com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			if(!("".equals(msg_dt2)))
			{
				messageDateTo = com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
			}
		}

		if( (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +" AND TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 


		//msg_dt2
		if( (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		}		

		if((order != null) && (order.equals("A")))
		{
			order="D";
		}
		else
		{
			order="A";
		}	

		if(orderBy != null && !orderBy.equals("")) {
				ResultQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+"  ORDER BY "+orderBy; 
		}else {
  			    orderBy = " MESSAGE_ID";
				ResultQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+"  ORDER BY "+orderBy; 
		}

	System.out.println("ResultQry : "+ResultQry);
	request.setAttribute("Query",ResultQry);	  
//  request.setAttribute("selectAll",selectAll);					 
	request.setAttribute("action_attr","");	     
	XHElectronicBillsControllerBean	xhBean = XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);	   
	xhBean.action(request,con);					    
	HashMap resultsQry = xhBean.getResultSet(); 	
	ArrayList  arrRow = (ArrayList)resultsQry.get("qry_result"); 
		
//	System.out.println("ViewEventseBillResult.jsp QryCols : "+QryCols);
/*	request.setAttribute(XBQueryRender.strQueryId,qry_id);
	request.setAttribute(XBQueryRender.maxRec,"12");
	request.setAttribute(XBQueryRender.vwEvntsQuery,ResultQry);				  
	request.setAttribute(XBQueryRender.col,array.length);
	HashMap resultsQry = XBQueryRender.getResults(request,session,con);		  
*/
//	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
//	System.out.println("arrRow.size() : "+arrRow.size());  
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = "Previous"; 
				String strNext  = "Next"; 
				if (boolPrevious == true)
				{
					strPrevious = "Previous"; 
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = "Next"; 
				}
				else
				{
					strNext  = " ";
				}																   
			
if(arrRow.size()==0)
{  																	 
//	System.out.println("if arrRow.size() : "+arrRow.size());
%>

<script>
alert(getMessage("XH1021","XH"));history.go(-1);
</script>  

<% } else {
//	System.out.println("else arrRow.size() : "+arrRow.size());
	%>
<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td colspan="10" align="center" class="COLUMNHEADER"><fmt:message key="eXH.OutboundEvents.label" bundle="${xh_labels}"/></td>
</tr>
<tr>	   
	<td align="left" class="CAGROUP" colspan="5">
		<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="editQuery();" TITLE="Edit Query">
			EditQuery
		</A>																    
	<% // if(authToRebuild || authToReplay){ %>
		<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="refreshResults('ViewEventseBillResult');" TITLE="Refresh Events">
			Refresh
		</A>
	<% // } %>												   
	</td>
	<!--<td align="right" class="CAGROUP"> 
		<A class='label' style='cursor:pointer' onClick="funAction('P')">Previous</A>
		<A class='label' onClick="funAction('N')" style='cursor:pointer'>Next</A>
	</td> -->
<!--</tr>
<tr> -->
	<td colspan="5" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
</tr> 									    
</table>

<div id="left_child" style="display:none;"> 
<table id="table1" cellspacing=0 cellpadding=3 border=1 width='60%'>	
    <tr>
	    <% if( !eventtype.equals("") && msg_status.equals("H") ) { %>
			<td class='COLUMNHEADER' nowrap style="height:10px"> <input type=checkbox  name='SelectAll' id='SelectAll' value='' onClick='selectAll();'> 
			
			</td>
		<% }	%>
<%	for(int i=0;i<array.length;i++)
		{
//				String name=array[i].replaceFirst("_"," ");					   
				String name=array[i].replace("_"," ");
// System.out.println("name : "+name);
		
//	if(name.equals("EVENT STATUS")) { %>
<!--		<td class='COLUMNHEADER'  style="height:26px" title="Event Status" nowrap>
			$ </td> -->
		<%// }
		if(name.equals("MESSAGE STATUS")) {%>
		<td class='COLUMNHEADER' title="Message Status"  style="height:10px" nowrap>
			# </td>
		<% } if(name.equals("MESSAGE ID")) {  %>
		<td class='COLUMNHEADER'  style="height:24px" nowrap> <a id='a001' href="javascript:callForOrderBy('lpad(Message_ID,20)','<%=order%>');" onclick=''><font color=white>MessageID</td>		
		<% //} if(name.equals("APPLICATION ID")) { %>
<!--		<td class='COLUMNHEADER'>ApplicationID</td> -->
		<% }  if((name.trim()).equals("EVENT TYPE")) {%>
		<td class='COLUMNHEADER' nowrap style="height:24px"> <a id='a001' href="javascript:callForOrderBy('EVENT_TYPE','<%=order%>');"onclick=''><font color=white>Event Type</td>
		<% } if(name.equals("MESSAGE DATE")) { %>
		<td class='COLUMNHEADER'  style="height:24px" nowrap><a id='a001' href="javascript:callForOrderBy('MESSAGE_DATE','<%=order%>');"onclick=''><font color=white>MessageDate</td>		
		<% }  if(name.equals("FACILITY ID")) { %>
		<td class='COLUMNHEADER' style="height:24px" nowrap><a id='a001' href="javascript:callForOrderBy('FACILITY_ID','<%=order%>');"onclick=''><font color=white>FacilityID</td>

<%} if(name.equals("ACCESSION NUM")) { %>
		<td class='COLUMNHEADER' style="height:24px" nowrap><a id='a001' href="javascript:callForOrderBy('ACCESSION_ NUM','<%=order%>');"onclick=''><font color=white>Accession Number</td>

<%
		}
	}
%>
 </tr>
<%
		float amount = 0.00f;	
		String acc_nu_field="";
		String event_stat = "";
		String msg_stat = "";
		 String accnum="";
//		 int g=0;
//		 int acccount=1;
//		while(rs1.next()) {
			for (int j=0; j<arrRow.size();j++){
			   	
				String[] acc_number;
				arrCol = (ArrayList)arrRow.get(j);
//				System.out.println("arrcol(0) : "+XBDBAdapter.checkNull((String)arrCol.get(0)));
				String acc_num=XBDBAdapter.checkNull((String)arrCol.get(8));
			   if(acc_num.equals(""))
			   {

				}
				else
				{
			
//				 System.out.println("acc_num :"+acc_num);
				 acc_number=Regex1.split(acc_num);
				 accnum=acc_number[2].substring(1,acc_number[2].length());
//				   int accnumbers=Integer.parseInt(accnum);
//				 System.out.println(" accnumbers   "+accnumbers);

				 acc_nu_field=acc_number[0]+"$!"+acc_number[1]+"$!";	     
			
				   if(acccount==1)
					{
					   g=0;
					   String accQry="select  count(*) from XB_EVENT where ACCESSION_NUM like ('%"+acc_nu_field+"%') and EVENT_TYPE = NVL('"+(String)arrCol.get(5)+"',EVENT_TYPE) and event_status='S'";
//					   System.out.println("accQry 687 : "+accQry);
					   stmt1 = con.createStatement();		 
					   rs1 = stmt1.executeQuery(accQry);	
					  																									 
						 while(rs1.next()) { 	
							  acccount=rs1.getInt(1);		  										   
						 }
					}
					else
					{
						  if(acccount==1)
						{
						   g=0;
						}
						else
						{

						   acccount--;
						   g++;
						}
					}
				}
					   
				if (boolToggle == true)
				{
					strTDClass = "class='QRYEVEN'";
					boolToggle =  false;
				}
				else
				{
					strTDClass = "class='QRYODD'";
					boolToggle =  true;
				}

//			event_stat = XBDBAdapter.checkNull(rs1.getString("EVENT_STATUS"));
			event_stat = (String)arrCol.get(1);

//			msg_stat = XBDBAdapter.checkNull(rs1.getString("MESSAGE_STATUS"));
			msg_stat = (String)arrCol.get(2);

			if(event_stat.equalsIgnoreCase("S"))  EvntStatusColor="../../eXH/images/green_square.jpg" ;
			if(event_stat.equalsIgnoreCase("N"))  EvntStatusColor="../../eXH/images/black_square.jpg" ;
			if(event_stat.equalsIgnoreCase("E"))  EvntStatusColor="../../eXH/images/red_square.jpg" ;
			if(event_stat.equalsIgnoreCase("A"))  EvntStatusColor = "../../eXH/images/yello_square.jpg" ;
			if(event_stat.equalsIgnoreCase(""))  EvntStatusColor = "../../eXH/images/blue_square.jpg" ; 

			if(msg_stat.equalsIgnoreCase("S"))  MsgStatusColor="../../eXH/images/green_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("A"))  MsgStatusColor="../../eXH/images/yello_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("R"))  MsgStatusColor="../../eXH/images/black_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("F"))  MsgStatusColor="../../eXH/images/pink_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("E"))  MsgStatusColor="../../eXH/images/red_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("H"))  MsgStatusColor="../../eXH/images/brown_square.gif" ;
 %>
		<tr>
			    <% if( !eventtype.equals("") && msg_status.equals("H") ) { %>	 				   
						<td class='QRYODD' style="height:25px">		
						
				   <%if(g==0)
				   { %>
					   <input class="bigcheck" type=checkbox id='<%="select_yn_"+rsCount%>'    value='<%=(String)arrCol.get(0)%>' onClick="dispAmount(this,'<%=rsCount%>','<%=acccount%>');"         <%=((String)arrCol.get(0)).equals("Y")?"checked":""%> >       
				<input type='hidden'  id='<%="select_yn_dubli"+rsCount%>' name='<%=arrCol.get(3)+"_check"%>'  value='<%=(String)arrCol.get(0)%>' >	 			
				   <%}else
	 {%>
			 <input class="bigcheck" type=checkbox id='<%="select_yn_"+rsCount%>'    value='<%=(String)arrCol.get(0)%>' onClick="dispAmount(this,'<%=rsCount%>','<%=acccount%>');"<%=((String)arrCol.get(0)).equals("Y")?"checked":""%> disabled >      
				<input type='hidden'  id='<%="select_yn_dubli"+rsCount%>' name='<%=arrCol.get(3)+"_check"%>'  value='<%=(String)arrCol.get(0)%>' >	
	  <%}%>

							 	   
								 <input type='hidden' name='<%="acc_no_"+rsCount%>' id='<%="acc_no_"+rsCount%>' value='<%=acc_nu_field+"^"%>' >
						</td>
				<% } %>
																	    	   
		<%	for(int i=0;i<array.length;i++)
		{																	   
		String name=array[i].replaceFirst("_"," ");							  
		// System.out.println("name : "+name); MsgStatusColor width='3%' 
	//	if(name.equals("EVENT STATUS")) {
			%>
	<!--	<td nowrap class='QRYEVEN' style="height:25px"> <img src='<%=EvntStatusColor%>'  height=10> </img> </td>  	-->
		<% //}
			if(name.equals("MESSAGE STATUS")) {
				%>
		<td nowrap class='QRYODD'  style="height:25px" ><img src='<%=MsgStatusColor%>'  height=10 width='10'> </img> </td>
		<% } if(name.equals("MESSAGE ID")) {  
					%>
		<td class='QRYEVEN' style="height:25px" nowrap><font size=1><%=arrCol.get(3) %>
		<input type=hidden name='<%="msg_id_"+rsCount%>' id='<%="msg_id_"+rsCount%>' value='<%=arrCol.get(3).equals("")?"&nbsp;":arrCol.get(3)%>' > </td>

		<% //} if(name.equals("APPLICATION ID")) {		 
							%>
	<!--	<td class='QRYEVEN' ><font size=1><%=arrCol.get(3) %></td> -->
		<% } if((name.trim()).equals("EVENT TYPE")) { 
								%>
		<td class='QRYODD' style="height:25px" nowrap> <font size=1><%=arrCol.get(5)%></td>
		<% } if((name.trim()).equals("MESSAGE DATE")) { 
									%>
		<td class='QRYEVEN' nowrap style="height:25px"><font size=1><%=arrCol.get(6) %></td>		
		<% }  if(name.equals("FACILITY ID")) { 
											%>
		<td class='QRYODD' style="height:10px" nowrap><font size=1><%=arrCol.get(7) %></td>
<%
		}  if(name.equals("ACCESSION NUM")) { 
											%>
		<td class='QRYODD' style="height:10px" nowrap><font size=1><%=arrCol.get(8) %></td>

<%
		} 											   



	}
	%>
	</tr>
	<%
	rsCount++;
} // end of rs.next() end of for
 %>
 </table>
 </div>

<div id="right_child" class="testSty" style="overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:none;">
<table id="table2" cellspacing=0 cellpadding=3 border=1 width='50%'> 
 <tr> 
<%	for(int i=8;i<array.length;i++)
		{
//				String name=array[i].replaceFirst("_"," ");
				String name=array[i].replace("_"," ");
															   
		 if(name.equals("FACILITY NAME")) { %>
		<td class='COLUMNHEADER'  style="height:26px"><a id='a001' href="javascript:callForOrderBy('FACILITY_NAME','<%=order%>');"onclick=''><font color=white>FacilityName</td>
		<% } else if(name.equals("INV NO")) { %>
		<td class='COLUMNHEADER'  style="height:26px" ><a id='a001' href="javascript:callForOrderBy('INV_NO','<%=order%>');"onclick=''><font color=white>InvNo</td>
		<% }else  if(name.equals("INV DATE")) { %>
		<td class='COLUMNHEADER'  style="height:26px" ><a id='a001' href="javascript:callForOrderBy('INV_DATE','<%=order%>');"onclick=''><font color=white>InvDate</td>
		<% }else if(name.equals("PATIENT ID")) { %>
		<td class='COLUMNHEADER'  style="height:26px"><a id='a001' href="javascript:callForOrderBy('PATIENT_ID','<%=order%>');"onclick=''><font color=white>HospitalNo</td>
		<% } else if(name.equals("INV AMOUNT")) { 		%>
		<td class='COLUMNHEADER'  style="height:26px"><a id='a001' href="javascript:callForOrderBy('INV_AMOUNT','<%=order%>');"onclick=''><font color=white>InvAmount</td>
		<% }else if(name.equals("VISIT DATE")) { %>
		<td class='COLUMNHEADER' style="height:26px"><a id='a001'															   href="javascript:callForOrderBy('VISIT_DATE','<%=order%>');"onclick=''><font color=white>VisitDate</td>
		<% }else if(name.equals("PATIENT NAME")) { %>
		<td class='COLUMNHEADER' style="height:26px"><a id='a001' href="javascript:callForOrderBy('PATIENT_NAME','<%=order%>');"onclick=''><font color=white>PatientName</td>
		<% }else if(name.equals("PATIENT TYPE")) { 		%>
		<td class='COLUMNHEADER'  style="height:26px"><a id='a001' href="javascript:callForOrderBy('PATIENT_TYPE','<%=order%>');"onclick=''><font color=white>PatientType</td>
		<% }else if(name.equals("CARD ID")) { %>
		<td class='COLUMNHEADER'  style="height:26px"><a id='a001' href="javascript:callForOrderBy('CARD_ID','<%=order%>');"onclick=''><font color=white>CardId</td>
		<% }else if(name.equals("CARD ISSUE DATE")) { %>
		<td class='COLUMNHEADER' style="height:25px"><a id='a001' href="javascript:callForOrderBy('CARD_ISSUE_DATE','<%=order%>');"onclick=''><font color=white>CardIssueDate</td>
		<% }else if(name.equals("CITIZEN ID")) { 		%>
		<td class='COLUMNHEADER'  style="height:26px"><a id='a001' href="javascript:callForOrderBy('CITIZEN_ID','<%=order%>');"onclick=''><font color=white>CitizenID</td>	
		<%	} else if(name.equals("STATUS TEXT")) {  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white>Status Text</td>	
		<% }else if(name.equals("LAST COMM START TIME")) {  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white>Last Comm Start Time</td>	
		<% } 
		 else if(name.equals("QUERY ID")) {  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white>Query Id</td>	 
		<% } else if(name.equals("EPISODE TYPE")) {  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white>Episode Type</td>	
		<% } 
		 else if(name.equals("EPISODE ID")) {  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white>Episode Id</td>	
		<% } else if(name.equals("APPLICATION NAME")) {  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white>Application Name</td>	
		<% }  else{  %>
		<td class='COLUMNHEADER'  nowrap style="height:26px"><a id='a001' href="javascript:callForOrderBy('<%=(name.trim()).toLowerCase()%>','<%=order%>');"onclick=''><font color=white><%=(name.trim())%></td>	
		<% } 
		 }
%>			   																								   
 </tr>
 <%
//		 rs1.beforeFirst();
/*		stmt1 = con.createStatement();		 
		 rs1 = stmt1.executeQuery(ResultQry);	
		 rsCount = 0;
		 while(rs1.next()) { */
		 rsCount = 0;

		for (int j=0; j<arrRow.size();j++){
				arrCol = (ArrayList)arrRow.get(j);
//				System.out.println("878 arrCol :"+arrCol);

 %>
		<tr>

		<%	for(int i=8;i<array.length;i++)
		{
		
//		 String name=array[i].replaceFirst("_"," ");
 		 String name=array[i].replace("_"," ");	

		 if(name.equals("FACILITY NAME")) {    
						%>
		<td class='QRYEVEN'  nowrap style="height:25px"><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<%
			} else if(name.equals("INV NO")) { 
						%>
		<td class='QRYEVEN'  nowrap style="height:25px" ><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<% }else if(name.equals("INV DATE")) { 
										%>
		<td class='QRYODD' nowrap style="height:25px" ><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<% }else if(name.equals("PATIENT ID")) { 
										%>													  
		<td class='QRYEVEN'  nowrapstyle="height:25px" ><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<% }else if(name.equals("INV AMOUNT")) { 
										%>		
		<td class='QRYODD' nowrap  style="height:25px">
		<font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1))%></td>
				<input type=hidden name='<%="inv_amnt_"+rsCount%>' id='<%="inv_amnt_"+rsCount%>' value='<%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1))%>' > </td>
		<%	if(!arrCol.get((i+1)).equals("")) { amount = Float.parseFloat((String)arrCol.get((i+1)));
				 Tot_Inv_Amount = Tot_Inv_Amount+amount; }
		 } else if(name.equals("VISIT DATE")) { 
										%>
		<td class='QRYEVEN'  nowrap style="height:25px"><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<% }else if(name.equals("PATIENT NAME")) { 
			if(((String)arrCol.get((i+1))).length()>15) {
										%>
				<td class='QRYODD'  nowrapstyle="height:25px"><font size=1><%= arrCol.get((i+1)).equals("")?"&nbsp;":((String)arrCol.get((i+1))).substring(0,14) %></td>
			<% } else { %>
				<td class='QRYODD'nowrap  style="height:25px"><font size=1><%= arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
    		<% } 
		}else if(name.equals("PATIENT TYPE")) { 
										%>
		<td class='QRYEVEN'  nowrap style="height:25px"><font size=1><%= arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<% }else if(name.equals("CARD ID")) { 
										%>
		<td class='QRYODD' nowrap  style="height:25px"><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<%
			}else if(name.equals("CARD ISSUE DATE")) { 
										%>							    
		<td class='QRYEVEN'  nowrap style="height:25px"><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) %></td>
		<% }else if(name.equals("CITIZEN ID")) { 
										%>
		<td class='QRYODD' nowrap  style="height:25px"><font size=1><%=arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1))  %> </td>
		<%	} else { %>
		<td class='QRYODD' nowrap  style="height:25px"><font size=1><%= arrCol.get((i+1)).equals("") || arrCol.get(i).equals("null")?"&nbsp;":arrCol.get((i+1))  %> </td>
		<%		
			}
		}
			%>
	</tr>
	<%
	rsCount++;
} // end of rs.next()
 %>
 </table>							  
</div>


<table width='100%' >
    <tr> </tr>	  <tr> </tr>	    <tr> </tr>
		<tr>
			<td  class=label >Count  </td> <td> <%=rsCount%> </td>
			<td width='25%' > </td> <td class=label >Cumulative Sum  &nbsp;<input type = "text" size="10"  name='cum_amount' id='cum_amount' value = '0' disabled> </td>
			<td width='15%' > </td>		<td  class=label >Total Sum  </td> <td> <%=Tot_Inv_Amount%> </td>
<!--			<input type = "button" name="Show Total Sum" id="Show Total Sum" value=' Show Total Sum '  title='Show Total Sum' onClick='ShowTotal();'> 	</td> -->
		</tr>
   <tr> </tr>
</table>	 

<div id='export' style=<%=styleExport%>>						    
<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
		<td class="CAGROUP" width='5%'>
			<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="genExport();" TITLE="Export"> Export	</A> &nbsp;&nbsp; 
			<A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="genExcel();" TITLE="WriteToExcel" > WriteToExcel	</A> 
		</td>
	</tr>
</table>	 
<div>																	   

 <SCRIPT>
	
	document.getElementById("left_child").style.display = "block";
	 document.getElementById("right_child").style.display = "block";
// alert("Footer");
 parent.f_query_add_mod_footer.location.href = "../../eXB/jsp/ViewEventsOutboundFooter.jsp?commType=outbound";
</SCRIPT>

<%
 } // end of else
}catch(Exception e1)
{																							 
		System.out.println("ViewEventseBillResult.jsp Exc : "+e1.toString());
		e1.printStackTrace(System.err);
}
finally									 
{
			try{												  
			if(stmt1!=null)stmt1.close();							 						 
			if(rs1!=null)rs1.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("Exception in ViewEventseBillResult.jsp :  "+e);
				}			
}
		%>
																	  
<input type="hidden" name='message_type' id='message_type' value='<%= emptyString %>'>
<input type="hidden" name='rsCount' id='rsCount' value='<%= rsCount %>'>
<input type="hidden" name='QryCols' id='QryCols' value='<%= java.net.URLEncoder.encode(QryCols) %>'>
<input type="hidden" name='whereClause' id='whereClause' value='<%=java.net.URLEncoder.encode(whereClause)%>'>
<input type="hidden" name='Tot_Inv_Amount' id='Tot_Inv_Amount' value='<%=Tot_Inv_Amount%>'>
<input type="hidden" name='msg_status' id='msg_status' value='<%=msg_status%>'>
<input type="hidden" name='eventtype' id='eventtype' value='<%=eventtype%>'>
<input type="hidden" name="protocolLinkID" id="protocolLinkID" id="protocolLinkID" value="<%= protocolLinkID %>" >
<input type="hidden" name="applnname" id="applnname" id="applnname" value="<%= applnname %>" >
<input type="hidden" name="facilityID" id="facilityID" id="facilityID" value="<%= facility %>" >
<input type='hidden' name='action_type' id='action_type' value=''>
<input type='hidden' name='orderBy' id='orderBy' value='<%=orderBy %>'> 
<input type='hidden' name='order' id='order' value='<%=order%>'>
<input type='hidden' name='DataLinestr' id='DataLinestr' value='<%=DataLinestr%>'>
<input type='hidden' name='totalMsgList' id='totalMsgList' value='<%=totalMsgList%>'>
<input type='hidden' name='g' id='g' value='<%=g%>'>
<input type='hidden' name='acccount' id='acccount' value='<%=acccount%>'>
</form>
</body>
</html>

