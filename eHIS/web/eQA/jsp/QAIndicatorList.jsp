<!DOCTYPE html>
<html>
   <%@ page import =" java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/Common.js" language="javascript"> </script>
	<Script src="../../eQA/js/QADirRecordOfClinIndicators.js" language="JavaScript"></Script>
	
	<Script src="../../eQA/js/QAMessages.js" language="JavaScript"></Script>
	<!--<script src="../../eCommon/js/messages.js" language="javascript"></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown = 'lockKey()'>
<form name="QA_QIND_ENCOUNTER_TRN" id="QA_QIND_ENCOUNTER_TRN"  action="QAIndicatorList.jsp" method="post">

<%
	
	String strDescUserSystem="";
	String strUserSystem="";
	String strMasterUserSystem = "";
	String strClindId="";
	String strClindDes="";
	String strClindAnalysisStatus="";
	String strApplicableYN = "";
	String strInclusiveYN = "";
	String strApplicableText ="";
	//String strRadioSelected1="",strRadioSelected2="";
    String class_value				= "QRYEVEN";
	String jval=request.getParameter("k")==null?"0":request.getParameter("k");
	int k=Integer.parseInt(jval);

// Hidden Parameters to be stored

	String strEncounterId = "";
	String strPatientId = "";
	String strPatientName = "";
	String strPatientClass = "";
	String strFacilityId = "";
	String strQueryParam = "";
	String strInclProcCode = "";
	String strInclDiagCode = "";
	String StrDisciplineID="";
	String StrDisciplineDesc="";
	String classes="";
	
	int i=1;
	strEncounterId = request.getParameter("ENCOUNTER_ID");    
	strPatientId = request.getParameter("PATIENT_ID");      
	strPatientName = request.getParameter("PATIENT_NAME");    
	strPatientClass = request.getParameter("PATIENT_CLASS");   
	strFacilityId = request.getParameter("FACILITY_ID");    
	StrDisciplineID=request.getParameter("QIND_DISCIPLINE_ID"); 
	StrDisciplineDesc=request.getParameter("QIND_DISCIPLINE_DESC"); 

	strQueryParam = request.getQueryString();

	Connection conn                    = null;
	PreparedStatement pstmt            = null;
	ResultSet rset                     = null;
	StringBuffer sqlCountBuff          = new StringBuffer();
	StringBuffer sqlBuff               = new StringBuffer();
	int start = 0 ;
	int end = 0 ;
	int maxRecord=0;
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
try
 {
    conn = ConnectionManager.getConnection(request);
	if ( from==null)
	start = 1 ;
	else
	start = Integer.parseInt(from) ;
  	if (to==null)
	end = 14 ;
	else
	end = Integer.parseInt(to) ;
  
   sqlCountBuff.append(" SELECT  count(*) FROM ");
   sqlCountBuff.append(" (select X.FACILITY_ID FACILITY_ID,");
   sqlCountBuff.append(" QIND_CLIND_ID QIND_CLIND_ID,");
   sqlCountBuff.append(" SYS_USER_CREATED,CLIND_ANALYSIS_STATUS,");
   sqlCountBuff.append(" APPLICABLE_YN,nvl(INCL_DIAG_CODE,' ') INCL_DIAG_CODE ,");
   sqlCountBuff.append(" nvl(INCL_PROC_CODE,' ')  INCL_PROC_CODE, ");
   sqlCountBuff.append(" NVL(INCL_FOR_YES_YN,'E')  INCL_FOR_YES_YN ");
   sqlCountBuff.append(" from PR_ENCOUNTER X,QA_QIND_ENCOUNTER_CLIND_TRN XX ");
   sqlCountBuff.append(" where X.FACILITY_ID = XX.FACILITY_ID(+)  AND  ");
   sqlCountBuff.append(" X.ENCOUNTER_ID = XX.ENCOUNTER_ID(+)  AND  ");
   sqlCountBuff.append(" X.FACILITY_ID=?   AND  X.ENCOUNTER_ID=?) Y, ");
   sqlCountBuff.append(" QA_QIND_CLIND YY,QA_QIND_DISCIPLINE_CLIND YYY,");
   sqlCountBuff.append(" QA_QIND_FACILITY_CLIND YYYY ");
   sqlCountBuff.append(" WHERE YY.QIND_CLIND_ID = Y.QIND_CLIND_ID(+) AND ");
   sqlCountBuff.append(" YY.QIND_CLIND_ID = YYY.QIND_CLIND_ID(+) AND ");
   sqlCountBuff.append(" YY.QIND_CLIND_ID = YYYY.QIND_CLIND_ID AND ");
   sqlCountBuff.append(" QIND_DISCIPLINE_ID =?  AND ");
   sqlCountBuff.append(" YYYY.OPERATING_FACILITY_ID= ? ORDER BY YYY.QIND_SLNO ");

try
		{
			
			pstmt=conn.prepareStatement(sqlCountBuff.toString());
			pstmt.setString(1,request.getParameter("FACILITY_ID"));
			pstmt.setString(2,request.getParameter("ENCOUNTER_ID"));
			pstmt.setString(3,request.getParameter("QIND_DISCIPLINE_ID"));
			pstmt.setString(4,request.getParameter("FACILITY_ID"));
			rset=pstmt.executeQuery();
		}
		catch(Exception e)
		{
		out.println("e"+e);
		}
     while(rset.next())
	{	 
	maxRecord=rset.getInt(1);
	}if(rset!=null) rset.close();
	 if(pstmt!=null) pstmt.close();
	if (maxRecord==0)
	{

	%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));
		</script>
	<%
		return;
	}
	else
	{
	sqlBuff.append(" SELECT Y.PATIENT_CLASS, ");
	sqlBuff.append(" YYY.QIND_CLIND_ID QIND_CLIND_ID_DUMMY, ");
	sqlBuff.append(" YY.QIND_CLIND_ID QIND_CLIND_ID, ");
	sqlBuff.append(" YY.QIND_CLIND_DESC QIND_CLIND_DESC, ");
	sqlBuff.append(" NVL(CLIND_ANALYSIS_STATUS,'0') CLIND_ANALYSIS_STATUS , ");
	sqlBuff.append(" NVL(Y.SYS_USER_CREATED,'E') TRN_SYS_USER_CREATED, ");
	sqlBuff.append(" NVL(YY.SYS_USER_CREATED,'E') MASTER_SYS_USER_CREATED, ");
	sqlBuff.append(" NVL(APPLICABLE_YN,'E') APPLICABLE_YN ,nvl(INCL_DIAG_CODE,' ') "); sqlBuff.append(" INCL_DIAG_CODE,nvl(INCL_PROC_CODE,' ') INCL_PROC_CODE, ");
	sqlBuff.append(" NVL(INCL_FOR_YES_YN,'E')  INCL_FOR_YES_YN  ");
	sqlBuff.append(" FROM  (select   ");
	sqlBuff.append(" X.PATIENT_CLASS, X.FACILITY_ID FACILITY_ID,QIND_CLIND_ID QIND_CLIND_ID, ");
	sqlBuff.append(" SYS_USER_CREATED, CLIND_ANALYSIS_STATUS,");
	sqlBuff.append(" APPLICABLE_YN,nvl(INCL_DIAG_CODE,' ') INCL_DIAG_CODE, ");
	sqlBuff.append(" nvl(INCL_PROC_CODE,' ')  INCL_PROC_CODE, ");
	sqlBuff.append(" NVL(INCL_FOR_YES_YN,'E')  INCL_FOR_YES_YN ");
	sqlBuff.append(" from  PR_ENCOUNTER X,QA_QIND_ENCOUNTER_CLIND_TRN XX ");
	sqlBuff.append(" where  X.FACILITY_ID = XX.FACILITY_ID(+) AND ");
	sqlBuff.append(" X.ENCOUNTER_ID = XX.ENCOUNTER_ID(+) AND  ");
	sqlBuff.append(" X.FACILITY_ID=?  AND X.ENCOUNTER_ID=?) Y, ");
	sqlBuff.append(" QA_QIND_CLIND_VW YY,QA_QIND_DISCIPLINE_CLIND YYY, ");
	sqlBuff.append(" QA_QIND_FACILITY_CLIND YYYY ");
	sqlBuff.append(" WHERE YY.QIND_CLIND_ID = Y.QIND_CLIND_ID(+) AND ");
	sqlBuff.append(" YY.QIND_CLIND_ID = YYY.QIND_CLIND_ID(+) AND ");
	sqlBuff.append(" YY.QIND_CLIND_ID = YYYY.QIND_CLIND_ID AND ");
	sqlBuff.append(" QIND_DISCIPLINE_ID =? AND ");
	sqlBuff.append(" YYYY.OPERATING_FACILITY_ID= ?                 AND    'Y' = DECODE(?,'EM',PATIENT_CLASS_EM,'OP',PATIENT_CLASS_OP,'IP',PATIENT_CLASS_IP, 'DC',PATIENT_CLASS_DC )              	 ORDER BY to_number(YY.QIND_CLIND_ID)");

	}%>
 <P>
<table  width='90%' align='center' >	
<tr >
		<%if (!(start <= 1) || !( (start+14) > maxRecord ))
		{%>
        
	   <td class='white' width='95%'>&nbsp;</td>
    	<td  align='right' nowrap>
		<%}else{%>
	    
		<td class='white'>

	   <%}%>

<%
if ( !(start <= 1) )
		{
%>
	<a HREF='javascript:submitPrevNext(<%=start-14%>, <%=end-14%>);' text-decoration='none'>Previous</a>
<%
		}

	if ( !( (start+14) > maxRecord ) )
	{
%>
	<a HREF='javascript:submitPrevNext(<%=start+14%>, <%=end+14%>);'  text-decoration='none'>Next</a>
<%
	}
%>
</td>
</tr>
</table>

	<table  width='100%' style="Color:blue" border=1  CELLSPACING=0 CELLPADDING=0>
    <font face="Verdana" color="white" size="2">

   <tr>
	<td Class="PATIENTLINECOLOR" align='left' colspan='8'><%=request.getParameter("PATIENT_NAME")%>&nbsp;&nbsp;,
	Patient Id:<%=request.getParameter("PATIENT_ID")%></td>
  </tr>  

  <tr>
<td class="label" >
	<U>
	<b class="label">
	<%=request.getParameter("QIND_DISCIPLINE_DESC")%>
	</b>
	</U>
</td>
<td class="label" align='right'>System Indicator</td>
<td class="brown" align='left'>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class="label" align='right'>Partially Analyzed</td>
<td class="Yellow" align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>	
<td class="label" align='right'>Completed</td>	
<td class="Green" align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</table> 

<table border="1" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr>
		<th width='5%'>Status</th>
		<th width='2%'>Clinical Indicator</th>		
		<th width='70%'>Clinical Indicator Desc</th>		
		<th width='2%'>Creation</th>
		<th width='2%'>Applicability</th>
		<th width='15%'>Inclusive Status</th>		 
</tr>

<% try
		{ 	 if(pstmt!=null) pstmt.close();
			pstmt=conn.prepareStatement(sqlBuff.toString());
			pstmt.setString(1,request.getParameter("FACILITY_ID"));
			pstmt.setString(2,request.getParameter("ENCOUNTER_ID"));
			pstmt.setString(3,request.getParameter("QIND_DISCIPLINE_ID"));
			pstmt.setString(4,request.getParameter("FACILITY_ID"));
			pstmt.setString(5,strPatientClass);
			rset=pstmt.executeQuery();
	
	      if( start != 1 )
	      for( int j=1; j<start; i++,j++ )
		  {
	         rset.next() ;
          }
			
		 while(rset.next()&& i<=end)
		 {	 
			strClindId = rset.getString("QIND_CLIND_ID");
			strClindDes = rset.getString("QIND_CLIND_DESC");
			strUserSystem = rset.getString("TRN_SYS_USER_CREATED");
			strMasterUserSystem = rset.getString("MASTER_SYS_USER_CREATED");
			strClindAnalysisStatus = rset.getString("CLIND_ANALYSIS_STATUS");
			strApplicableYN = rset.getString("APPLICABLE_YN");
			strInclProcCode	= rset.getString("INCL_PROC_CODE");
			strInclDiagCode = rset.getString("INCL_DIAG_CODE");
			strInclusiveYN =  rset.getString("INCL_FOR_YES_YN");
			if(class_value.equals("QRYEVEN"))
			class_value = "QRYODD";
		 	else
			class_value = "QRYEVEN";

			if(strClindAnalysisStatus.equals("5"))
			classes=" class='Yellow'";
			else if(strClindAnalysisStatus.equals("9"))
			classes=" class='Green'";
			else if (strMasterUserSystem.equalsIgnoreCase("S"))
			classes=" class='brown'";
			else
			classes="";
            
			if(strUserSystem.equalsIgnoreCase("S"))
		    strDescUserSystem="System";
			else if(strUserSystem.equalsIgnoreCase("D"))
			strDescUserSystem="User";
			else
			strDescUserSystem="&nbsp;";

			if (strInclusiveYN.equalsIgnoreCase("Y"))
			{
			    	//strRadioSelected1 = "checked";
					//strRadioSelected2="";
			}
			else if (strInclusiveYN.equalsIgnoreCase("N"))
			{
			    	//strRadioSelected1 = "";
					//strRadioSelected2="checked ";
			}
			else
			{
			    	//strRadioSelected1 = " ";
					//strRadioSelected2=" ";
			}


          	if(strApplicableYN.equalsIgnoreCase("E"))
			{
					strApplicableText = "NA";
			}
				else
				{
					strApplicableText = " ";
				}
				String tempString = strClindId+"||"+strMasterUserSystem+"||"+strUserSystem+"||"+strClindDes+"||"+strInclProcCode+"||"+strInclDiagCode+"||"+strClindAnalysisStatus+"||"+k;
				%>
	   <tr>
	   <td  '<%=classes%>' >&nbsp;</td>
       <td class="<%=class_value%>"  style='cursor:pointer;color:blue' onClick='fun1(this)'  id='qind_clind_id<%=k++%>' value=''  align=center><%=strClindId%></td>
<script>
       var index = parseInt("<%=k%>");
       index = index - 1;
	   var tdId = eval("document.getElementById("qind_clind_id")"+index);
       tdId.value = escape("<%=tempString%>")
</script>	
	<td class="<%=class_value%>"  nowrap><%=strClindDes%></td>
    <td class="<%=class_value%>"; ><%=strDescUserSystem%></td>
	<td class="<%=class_value%>" ><%=strApplicableText%></td>
	<td class=label nowrap>	Yes&nbsp;
	<input type='Radio'  name='INCL_FOR_YES<%=k%>' id='INCL_FOR_YES<%=k%>' value=Y  disabled>
		No&nbsp;
	<input type='Radio'  name='INCL_FOR_NO<%=k%>' id='INCL_FOR_NO<%=k%>' value='N' disabled >
   </td>		
	<%i++;	}
	 if(rset!=null) rset.close();
	 if(pstmt!=null) pstmt.close();
	}catch(Exception e)
		{
		}
	if((sqlCountBuff != null) && (sqlCountBuff.length() > 0))
	{
		sqlCountBuff.delete(0,sqlCountBuff.length());
	}
	if((sqlBuff != null) && (sqlBuff.length() > 0))
	{
		sqlBuff.delete(0,sqlBuff.length());
	}
  }
  catch(Exception e)
  {
		out.println("Err="+e);
  }
  finally
  {
	    ConnectionManager.returnConnection(conn, request);
  }
%>
<input type="Hidden" name="from" id="from" value="<%=from%>">
<input type="Hidden" name="to" id="to" value="<%=to%>">
<input type="Hidden" name="k" id="k" value="<%=k%>">
<input type=hidden name='rowVal' id='rowVal'  value=''>
<input type=hidden name='PATIENT_ID' id='PATIENT_ID'  value='<%=strPatientId%>'>
<input type=hidden name='PATIENT_NAME' id='PATIENT_NAME'  value='<%=strPatientName%>'>
<input type=hidden name='ENCOUNTER_ID' id='ENCOUNTER_ID'   value='<%=strEncounterId%>'>
<input type=hidden name='FACILITY_ID' id='FACILITY_ID'   value='<%=strFacilityId%>'>
<input type=hidden name='PATIENT_CLASS' id='PATIENT_CLASS'   value='<%=strPatientClass%>'>
<input type=hidden name='QIND_DISCIPLINE_ID' id='QIND_DISCIPLINE_ID' value='<%=StrDisciplineID%>'>
<input type=hidden name='QUERY_PARAM' id='QUERY_PARAM' value='<%=strQueryParam%>'>
<input type=hidden name='QIND_DISCIPLINE_DESC' id='QIND_DISCIPLINE_DESC' value='<%=StrDisciplineDesc%>'>
<input type=hidden name='Analyzepart' id='Analyzepart' value=''>

</table>
</form>
</body>
</html>

