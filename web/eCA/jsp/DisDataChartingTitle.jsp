<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100				?           	created
02/06/2014		IN037701		Nijitha			SKR-CRF-0036
-----------------------------------------------------------------------------------------------

*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
	<head>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" /> 
		<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCA/js/DisDataCharting.js'></SCRIPT>
		<script language='javascript' src='../../eCommon/js/common.js'></script>

	</head>
	
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
	Connection con = null;
	try
	{
		con = ConnectionManager.getConnection(request);

		Properties p = (Properties)session.getValue("jdbc");
		//String locale	= (String) p.getProperty("LOCALE");	//Checkstyle 4.0 Beta 6

		PreparedStatement pstmt = null;
		ResultSet rset	= null;

		String qs = request.getQueryString();
		String a = "";
		//String lastrecorddate = request.getParameter("last_record_date")==null?"":request.getParameter("last_record_date");	//Checkstyle 4.0 Beta 6
		
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

		String amerepMode = request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
		String sql = "";
%>
	
		<script language="JavaScript">
			var prev = 0;
			function  change_row_color(obj)
			{
				document.getElementById("t").rows(prev).cells(0).style.backgroundColor = obj.bgColor
				obj.cells(0).style.backgroundColor = "#B2B6D7"
				prev = obj.rowIndex
			}

			function loadMainPageFirst(check)
			{	
				var qs = "<%=qs%>";
				qs = qs+'&out_mode=showpage';
				if(check == 'Error')
					qs += '&new_last_record_date='+document.forms[0].date.value+' '+document.forms[0].time.value;
				parent.frames[1].location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs
			}

			async function loadMainPage(check,dat1,tim1,index)
			{
				var retVal = new String();
				var dialogHeight = "10" ;
				var dialogWidth	= "20" ;
				var status = "no";
				var arguments	= "" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

				retVal =await  window.showModalDialog("DisDataChartAmendReplace.jsp",arguments,features);
				if (retVal=='cancel')
				{
					//cancel part
				}
				else if(retVal=='A' || retVal=='R')
				{
					change_row_color(eval(document.getElementById('a'+index)));
					var qs = "<%=qs%>";
					qs = qs+'&out_mode=showpage';
					
					if (retVal == 'A')
						qs = qs+'&amendMode=Y';
					else if (retVal == 'R')
						qs = qs+'&replaceMode=Y';

					if(check=='Error')
						qs += '&new_last_record_date='+dat1+' '+tim1;
					parent.frames[1].location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs
				}
				else if(retVal !=null  || retVal!=''){}
			}
	
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<form name="DisDataChartingTitle_form" id="DisDataChartingTitle_form">

<%
	/*	// Modification Start. for IN035857	PMG2012-CRF-0017
		if(amerepMode.equals("N"))
		{
		if(lastrecorddate.equals(""))
				a = "New";
			else
				a = "<a href='javascript:loadMainPageFirst()' >"+com.ehis.util.DateUtils.convertDate(lastrecorddate,"DMYHMS","en",locale)+"</a>";
	*/	
%>
		<!--	
		<table class='grid' border="0" width="100%" cellspacing='0' cellpadding='0' align='center'>
			<tr>
				<td class=label ><b><fmt:message key="eCA.LastRecordedDateTime.label" bundle="${ca_labels}"/>:</td>
				<td  class=label id=td1 colspan=4><b><%=a%></b></td>
			</tr>
			<tr>
				<td class='COLUMNHEADERCENTER' width='28%'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></font></td>
				<td class='COLUMNHEADERCENTER' width='28%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="eCA.NormalRange.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='17%'><fmt:message key="eCA.NormalInd.label" bundle="${ca_labels}"/>.</font></td>	
			</tr>
		</table>
		-->
<%		//}
		//else
		if(!amerepMode.equals("N")){ 
		// Modification End. for IN035857	PMG2012-CRF-0017		
			sql="select distinct to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy') dat ,to_char(TEST_OBSERV_DT_TM,'hh24:mi:ss') time ,TEST_OBSERV_DT_TM from ca_encntr_discr_msr where patient_id=? order by TEST_OBSERV_DT_TM";
				
			pstmt=con.prepareStatement(sql);

			String dateValue = "";
			String tempDateValue = "";
			String timeValue = "";
			String displayDate = "";
			String classValue = "";
		
			int i = 0;
			boolean flag = true;
				
			pstmt.setString(1,patient_id);
			rset = pstmt.executeQuery();
			if(rset != null)
			{
%>
			<table border="1"  id='t' width='99%' cellpadding="3" cellspacing="0">
<%
			while(rset.next())
			{
				if ((i%2)==0) classValue = "QRYEVEN";
				else classValue = "QRYODD";
				
				dateValue = rset.getString("dat");
				displayDate = dateValue;

				if(tempDateValue.equals(dateValue))
				{
					displayDate = "";
					flag = false;
				}
				else
					flag=true;
							
				tempDateValue=dateValue;
				timeValue=rset.getString("time");
				
				if(flag == true)
				{ 
%>
					<tr><td><b>&nbsp;<%=displayDate %></b></td></tr>
<%	
				}
%>
					<tr id='a<%=i%>' ><td  class='<%=classValue%>' >&nbsp;&nbsp;&nbsp;&nbsp;<b><a href="javascript:loadMainPage('Error','<%=dateValue %>','<%=timeValue%>','<%=i%>');" >-&nbsp;<%=rset.getString("time")%></b></a></td></tr>
<%
					i++;
			}
%>
			</table>
<%
			}
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println("Error "+e);//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
	<input type=hidden name=in_error value='Y'>
	<input type=hidden name=in_replace value='Y'>
	</form>
	</body>
</html>
<!--IN037701 Starts-->
<SCRIPT LANGUAGE="JavaScript">
	loadMainPageFirst();		
</SCRIPT>
<!--IN037701 Ends-->

