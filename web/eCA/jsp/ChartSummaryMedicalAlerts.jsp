<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/11/2012	  IN035950		Nijitha		 CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										 more appealing. Keeping the display of information more clear and visible.												 
-------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------
24/05/2018		IN065341	Prakash C	25/05/2018		Ramesh G		MMS-DM-CRF-0115
-------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
//String content_ID = request.getParameter("content_ID"); checkstyle
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
%>
<title><%=title %></title><!--IN035950-->
<%-- <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> --%>

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCA/js/ResearchPatient.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	String patientid=request.getParameter("patient_id");
	String context=request.getParameter("context");
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
%>
     	<script>
			var Highrisk_Status="N";
			
			async function HighRisk(patientid,authorize){
				
				if(authorize == "Y")
				{
					//window.location.href='ChartSummaryMedicalAlerts.jsp?patient_id='+patientid+'&authorize=N';//CHL_CRF
					window.location.href='ChartSummaryMedicalAlerts.jsp?patient_id='+patientid+'&title='+'<%=title%>'+'&authorize=N';//CHL_CRF
				}
				else
				{
					var val1 = 'V' ;
					var val2 = 'HR' ;
					var val3='C'
					if('<%=context%>'=="PatientQueue")
						val3="O";
					var val = val1+'/'+val2+'/'+val3+'/';

					var retVal = 	new String();
					var dialogHeight= "70vh" ;
					var dialogWidth	= "70vw" ;
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
					var arguments	= "" ;
					
					retVal = await window.showModalDialog("AuthorizeMRAccess.jsp?constr="+val,arguments,features);
						
					if(retVal=="T"){						
						//alert("succ");
						//window.location.href='ChartSummaryMedicalAlerts.jsp?patient_id='+patientid+'&authorize=Y';//CHL_CRF
						window.location.href='ChartSummaryMedicalAlerts.jsp?patient_id='+patientid+'&title='+'<%=title%>'+'&authorize=Y';//CHL_CRF
					}
					else{	
						//alert("unn");
						//window.location.href='ChartSummaryMedicalAlerts.jsp?patient_id='+patientid+'&authorize=N';//CHL_CRF
						window.location.href='ChartSummaryMedicalAlerts.jsp?patient_id='+patientid+'&title='+'<%=title%>'+'&authorize=N';//CHL_CRF
					}
				}

			}
			
		/*	function showToolTip()
			{
				
			}

		function showToolTip(obj,authorizeyn)
		{
			var displayText = '<table cellpadding=0 cellspacing=0 border=0><td class=YELLOW>'
			if(authorizeyn == 'Y')
			{
				displayText += 'Click to Normalize';
			}
			else
			{
				displayText += 'Click to Authorize';
			}
			displayText += '</td></table>';
			document.getElementById("authorizeMode").innerHTML = displayText;
			document.getElementById("authorizeMode").style.top  = obj.offsetTop+15; 
			document.getElementById("authorizeMode").style.left  = obj.offsetLeft-20 ;
			document.getElementById("authorizeMode").style.visibility='visible' ;
		}

		function hideToolTip()
		{
			document.getElementById("authorizeMode").style.visibility='hidden' ;
		}*/


		/*	function HighRisk(){
			   	var P_access_type=document.forms[0].P_access_type.value;
				var P_access_data=document.forms[0].P_access_data.value;
				var Context=document.forms[0].Context.value;
				if (Highrisk_Status=="N") {
				document.location.href='AuthorizeHRC.jsp?patientid=<%=patientid%>&Context=<%=context%>&jsp_name=QryPatSumHRC.jsp&B_jsp_name=QryPatSHRCblank.jsp&context=<%=context%>'
				}
			}*/
     	</script>
</head>
<%
	Connection con= null;
	PreparedStatement stmt =null;
	ResultSet rs	 =null;

	
	

	PreparedStatement stmt1 =null;
	ResultSet rs1	 =null;
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");//IN065341
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");//IN065341

try
	{
		String query_high_risk_condition ="";
		String high_risk_desc ="",classValue="";
		int i =0;
		String sqlhighriskcount="";
		int maxrecord = 0;

	//out.println(request.getQueryString());
	//IN065341 starts
		String authorize ="";
		if(called_from.equals("CDR")){
			authorize="Y";
		}else{
			 authorize = (request.getParameter("authorize")==null)?"N":request.getParameter("authorize");
		}	
	
	con = ConnectionManager.getConnection(request);

	//sqlhighriskcount = "select count(*) as total from pr_high_risk_condition a where patient_id=? and rownum=1 ";
	sqlhighriskcount = "select count(*) as total from pr_high_risk_condition ##REPDB## a where patient_id=? and rownum=1 ";//IN065341
	sqlhighriskcount=sqlhighriskcount.replaceAll("##REPDB##",RepDb);//IN065341
	stmt1 = con.prepareStatement(sqlhighriskcount);
	stmt1.setString(1,patientid);
	rs1=stmt1.executeQuery();
	rs1.next();
	maxrecord = rs1.getInt("total");

	if(maxrecord>0)
	{
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="HRCblank" id="HRCblank">
 <!-- <%
	
	
	
%> -->
<%if(!called_from.equals("CDR")){ //IN065341 %>
<center>
		<a class=class='gridLink' href="javascript:HighRisk('<%=patientid%>','<%=authorize%>')" onMouseOver="showToolTip(this,'<%=authorize%>')" onMouseOut="javascript:hideToolTip()"> <font size='2' color='red'> [<fmt:message key="Common.HighRisk.label" bundle="${common_labels}"/>]</font></a> 
		<br><%} //IN065341%>

<%
		if(authorize.equals("Y"))
		{
	%><table align='center' class='grid' width='100%'><br><%
			//query_high_risk_condition = "Select distinct b.SHORT_DESC high_risk_desc from pr_high_risk_condition a, mr_high_risk b where patient_id =? and b.high_risk_code = a.high_risk_code";
			
			//query_high_risk_condition = "Select distinct b.short_desc high_risk_desc from pr_high_risk_condition a,mr_high_risk_lang_vw b where patient_id =? and a.close_date is null and b.high_risk_code = a.high_risk_code and b.language_id = ?";
			query_high_risk_condition = "Select distinct b.short_desc high_risk_desc from pr_high_risk_condition ##REPDB## a,mr_high_risk_lang_vw ##REPDB## b where patient_id =? and a.close_date is null and b.high_risk_code = a.high_risk_code and b.language_id = ?";//IN065341
			query_high_risk_condition=query_high_risk_condition.replaceAll("##REPDB##",RepDb);//IN065341
			stmt = con.prepareStatement(query_high_risk_condition);

			stmt.setString(1,patientid);
			stmt.setString(2,locale);

			rs = stmt.executeQuery();
			while(rs.next())
					{
						if ( i%2 == 0 )
							classValue="QRYODD";
						else
							classValue="QRYEVEN";

						i++;
						high_risk_desc	= rs.getString("high_risk_desc");

						out.println("<tr><td class='gridData'>"+high_risk_desc+"</td></tr>");
					}
			if(i == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
			}
		}
	}
	//IN035950  Starts
	if(maxrecord==0)
	out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
	//IN035950  Ends
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
		//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
	        e.printStackTrace();//COMMON-ICN-0181
}
finally
{
				
if(con!=null) ConnectionManager.returnConnection(con,request);
}


%>

</center>
</table>
</form>
<div id='authorizeMode' style='position:absolute; visibility:hidden;overflow:overflow'></div>
</body>
</html>


