<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String eventDescDisplay = "";
	
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="JavaScript" src ="../../eCA/js/RecMaternityCons.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
		<form name="specialityeventaddmodifyForm" id="specialityeventaddmodifyForm"  method ='post' target='messageFrame' >
		<!-- Modified by kishore kumar N on 22/12/2008 for the CRF 0387, applied new GRID CSS -->
		   	<table class='grid' width='100%' align='center'>
	<%
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	String classValue="";
	try
	{    
			con = ConnectionManager.getConnection(request);
			String cycle = "";
			String prevCycle = "";
			String eventdesc = "";
			String eventcode = "";
			String outcomecode = "";
			String outcomedesc= "";
			String outcomeAccNum= "";
			String status = "";
			String startdate = "";
			String enddate = "";
			
           sql = "SELECT  CYCLE_NO,TO_CHAR(SPLTY_EVENT_START_DATE,'DD/MM/YYYY HH24:MI')	 SPLTY_EVENT_START_DATE,TO_CHAR(SPLTY_EVENT_END_DATE,'DD/MM/YYYY HH24:MI') SPLTY_EVENT_END_DATE ,SPLTY_EVENT_CODE	 ,CA_GET_DESC.CA_SPLTY_EVENT(SPLTY_EVENT_CODE,?,'1')||decode(ADDITIONAL_EVENT_YN,'Y','#','') SPLTY_EVENT_DESC	,SPLTY_EVENT_STATUS ,OUTCOME_CODE ,CA_GET_DESC.CA_SPLTY_OUTCOME(OUTCOME_CODE,?,'1') SPLTY_OUTCOME_DESC,OUTCOME_ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_EVENT  where patient_id=? and  module_id=? Order by CYCLE_NO desc,ADDITIONAL_EVENT_YN,SPLTY_EVENT_START_DATE";
		     ps = con.prepareStatement(sql);
			 ps.setString(1,locale);
			 ps.setString(2,locale);
			 ps.setString(3,patient_id);
			 ps.setString(4,module_id);
		     rs = ps.executeQuery();
			 classValue = "gridData";
			while(rs.next())
		   {			
			 cycle=rs.getString("CYCLE_NO") == null ? "" : rs.getString("CYCLE_NO");
			/*if (Integer.parseInt(cycle)% 2 == 0 )
		  	classValue = "QRYEVENSMALL" ;
		   else
		  	classValue = "QRYODDSMALL" ;*/
			 eventcode=rs.getString("SPLTY_EVENT_CODE")== null ? "" :  rs.getString("SPLTY_EVENT_CODE");
			 eventdesc=rs.getString("SPLTY_EVENT_DESC")== null ? "" :  rs.getString("SPLTY_EVENT_DESC");
			 outcomecode=rs.getString("OUTCOME_CODE")== null ? "" : rs.getString("OUTCOME_CODE");
			 outcomeAccNum=rs.getString("OUTCOME_ACCESSION_NUM")== null ? "" : rs.getString("OUTCOME_ACCESSION_NUM");
			 outcomedesc=rs.getString("SPLTY_OUTCOME_DESC")== null ? "&nbsp;" :  rs.getString("SPLTY_OUTCOME_DESC");
			 status=rs.getString("SPLTY_EVENT_STATUS")== null ? "" :  rs.getString("SPLTY_EVENT_STATUS");

			 if(status.equals("C")) eventDescDisplay = eventdesc;
			 else if(!status.equals("C")) eventDescDisplay = "<b>"+eventdesc+"</b>";

			 if(status.equals("C"))
				  status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
			 else
			   {
				 status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			   }
			 startdate=rs.getString("SPLTY_EVENT_START_DATE")== null ? "" :  rs.getString("SPLTY_EVENT_START_DATE");
			 startdate= DateUtils.convertDate(startdate,"DMYHM","en",locale);
			 enddate=rs.getString("SPLTY_EVENT_END_DATE")== null ? "" :  rs.getString("SPLTY_EVENT_END_DATE");
			 enddate= DateUtils.convertDate(enddate,"DMYHM","en",locale);

			  if(enddate==null || enddate.equals("") )enddate=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.tilldate.label","ca_labels");  
			   
			   %>
				
				<tr>
				<%
				 if(!prevCycle.equals(cycle))
			   {
				  %>
					   <tr>
						<td colspan = '5' class='CAGROUPHEADING'><a name='<%=cycle%>'><fmt:message key="eCA.Cycle.label" bundle="${ca_labels}"/> <%=cycle%></a></td>
					  </tr>
			  <% }
				
				//outcomeAccNum= "MC1810";				
				 %>
               <td class='<%=classValue%>'  nowrap  width='25%'><%=eventDescDisplay%></td>
               <td class='<%=classValue%>'  nowrap width='20%'> <%=outcomedesc%><%if(outcomeAccNum!=null && !outcomeAccNum.equals("")){%><img src="../../eCommon/images/flow_text.gif" align=middle  onClick="showDetial('<%=outcomeAccNum%>','<%=outcomedesc%>','<%=patient_id%>')"><%}%></td>
               <td class='<%=classValue%>'  nowrap width='20%'> <%=status%></td>
               <td class='<%=classValue%>'  nowrap  width='35%'><%=startdate%>&nbsp;-&nbsp;<%=enddate%></td>
			 <tr>
			  
	<%
		
		prevCycle = cycle;
		}
	%>
	 
</table>	
</form>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
		 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
				if(rs != null) rs.close();
		       if(ps != null) ps.close();
			  }
			}
		catch(Exception e){
		//	out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>
</body>
</html>

