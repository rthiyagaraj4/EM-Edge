<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import   ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXB.XBDBAdapter,java.sql.*,java.util.*,java.util.regex.Pattern,java.io.*,eXB.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE")); 
locale = "en"; %>
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
</style>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script> 		 
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>									    
<script Language="JavaScript"  src="../../eXH/js/Validate.js" ></script>						    
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eXB/js/ViewEventsOutbound.js'></script>
<script language='javascript' src='../../eXB/js/ViewEvents.js'></script>
<script language="JavaScript">		

</script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%
Connection con=null;
Statement stmt1=null;
ResultSet rs1=null;
int rsCount = 0;
String QryCols = "";
String emptyString = "";
int Tot_Inv_Amount = 0;
//String disabled = "disabled";
String styleExport = "display:none";
//String strBeanName = XBUnsolicitedEventsControllerBean.strBeanName;  

%>
<form name="ApplicationEventListForMessageTypeForm" id="ApplicationEventListForMessageTypeForm" target='messageFrame' method='post' >

<%																	 	    
try			 	
{
	String msg_dt1= null;
	String msg_dt2= null;
	String msg_id1= null;
	String msg_id2= null;
	String applnname= null;
	String eventtype= null;
	String comm_mode= null;
	String facility= null;
	String event_status = null;
	String msg_status= null;
	String protocol_link_name= null;
//	String purge_status= null;
	String dispMode= null;
	String interface_module= null;

	msg_dt1 = XBDBAdapter.checkNull(request.getParameter("msg_dt1"));
	msg_dt2 = XBDBAdapter.checkNull(request.getParameter("msg_dt2"));
	msg_id1 = XBDBAdapter.checkNull(request.getParameter("msg_id1"));
	msg_id2 = XBDBAdapter.checkNull(request.getParameter("msg_id2"));
	applnname = XBDBAdapter.checkNull(request.getParameter("applnname"));
	eventtype = XBDBAdapter.checkNull(request.getParameter("eventtype"));
//		System.out.println("eventtype : "+eventtype);
	comm_mode = XBDBAdapter.checkNull(request.getParameter("comm_mode"));
	facility = XBDBAdapter.checkNull(request.getParameter("facility"));
	event_status = XBDBAdapter.checkNull(request.getParameter("event_status"));
	msg_status = XBDBAdapter.checkNull(request.getParameter("msg_status"));
	protocol_link_name = XBDBAdapter.checkNull(request.getParameter("protocol_link_name"));
	dispMode = XBDBAdapter.checkNull(request.getParameter("dispMode"));
	interface_module = XBDBAdapter.checkNull(request.getParameter("interface_module"));

//		System.out.println("msg_status : "+msg_status);
	if(msg_status.equals("R") && !eventtype.equals("") ){
	//	disabled = "";
		styleExport="display:block";
	}
    
	String NewColList = XBDBAdapter.checkNull(request.getParameter("NewColList"));
//		System.out.println("NewColList : "+NewColList);
	con=ConnectionManager.getConnection();
//	String qry = "SELECT * FROM XB_EVENT_APPL_MESSAGE_XL_VW  ";				   

	String ResultQry = "";
	String DataLinestr="";
	Pattern Regex=null;
//	String Colstatus = "";
//	String ColVal = "";
//	String EvntStatusColor = "../../eXH/images/black_square.jpg";
//	String MsgStatusColor = "../../eXH/images/blue_square.jpg";

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
//			System.out.println("ViewEventseBillDtlsResultPage.jsp DataLinestr :"+DataLinestr);
		try{
			Regex = Pattern.compile("\\,",Pattern.MULTILINE);
// System.out.println("ViewEventseBillDtlsResultPage.jsp Regex :"+Regex);

		}
		catch(Exception e)
		{
			System.out.println("erorr"+e);
		}															    

		String[] array=Regex.split(DataLinestr);
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
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1)  CITIZEN_ID,";
			}
			else{
				QryCols = QryCols+array[i]+",";	
			}
		}
		QryCols = QryCols.substring(0,QryCols.length()-1);

//		System.out.println("ViewEventsBillFooter.jsp QryCols : "+QryCols);
		ResultQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE  EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  /* AND MESSAGE_STATUS = NVL('H',MESSAGE_STATUS) AND EPISODE_TYPE='O'  AND PATIENT_ID like 'E%' AND ROWNUM<=3  */ ORDER BY MESSAGE_ID"; 
	// AND EVENT_STATUS = NVL('S',EVENT_STATUS)
		System.out.println("ResultQry : "+ResultQry);
		stmt1 = con.createStatement();		 
		 rs1 = stmt1.executeQuery(ResultQry);	
		
		int amount = 0;

		while(rs1.next()) {
	
		for(int i=0;i<array.length;i++)
		{
			String name=array[i].replaceFirst("_"," ");
			
			if(name.equals("INV AMOUNT")) { 
			%>
			<input type=hidden name='<%="inv_amnt_"+rsCount%>' id='<%="inv_amnt_"+rsCount%>' value='<%=rs1.getString("INV_AMOUNT") %>' > </td>
			<% 
					amount = Integer.parseInt(rs1.getString("INV_AMOUNT"));
					 Tot_Inv_Amount = Tot_Inv_Amount+amount;
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
			<td width='55%' > </td> <td class=label >Cumulative Sum  <input type = "text" size="10"  name='cum_amount' id='cum_amount' value = '0' >	&nbsp;&nbsp; <input type = "button" name="Show Total Sum" id="Show Total Sum" value=' Show Total Sum '  title='Show Total Sum' onClick='ShowTotal();'> 	</td>
		</tr>
   <tr> </tr>
</table>	 

<div id='export' style=<%=styleExport%>>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
		<td class="CAGROUP" width='5%'> <A class='linkClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='cursor:pointer' onClick="genExport();" TITLE="Export" > Export	</A> </td>
	</tr>
</table>	 
<div>

<%
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

<input type=hidden name=message_type value=<%= emptyString %>>
<input type=hidden name=rsCount value=<%=rsCount%>>
<input type=hidden name=QryCols value=<%=java.net.URLEncoder.encode(QryCols)%>>
<input type=hidden name=Tot_Inv_Amount value=<%=Tot_Inv_Amount%>>

</form>
</body>
</html>

