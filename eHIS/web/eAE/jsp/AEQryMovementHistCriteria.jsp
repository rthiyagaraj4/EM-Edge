<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AEQryMovementHistory.js'></script>
  <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


  
</head>
<%
	    request.setCharacterEncoding("UTF-8");
        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
		String patient_id_length	 = "";
		String sysDate				 = "";
		String locale				= (String)session.getAttribute("LOCALE");

		try{
                con                  = ConnectionManager.getConnection(request);
				StringBuffer patLength = new StringBuffer();
				patLength.append("select PATIENT_ID_LENGTH, to_char(sysdate,'dd/mm/yyyy') from MP_PARAM  ");
				pstmt   = con.prepareStatement(patLength.toString());
				rset = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{   
					patient_id_length = rset.getString(1);
					sysDate = rset.getString(2);
				} 
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				sysDate=DateUtils.convertDate(sysDate,"DMY","en",locale);

%>
	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
	 <form name="Qry_Movement_Hist_Criteria" id="Qry_Movement_Hist_Criteria">
	   <table border="0" cellpadding="0" cellspacing="0" align='center' width='80%'>
	     <tr><td colspan='4'></td></tr> 
         <tr>
	            <td class='LABEL'  width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
  		        <td class='field'  width='25%'>
 				<input type='text'  tabindex=1 name='patient_id' id='patient_id'  value="" maxLength='<%=patient_id_length%>' size='20' onKeyPress="return(CheckForSpecChars(event))"  onBlur='changeCase(this);if(this.value !="")searchPatient(document.forms[0].patient_id);' ><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callPatientSearch()" ><img src='../../eCommon/images/mandatory.gif' align='center'></img>	
                </td>
				<td class='field' width='25%'>
				<td class='field' width='25%'>
		</tr>
		<tr><td colspan='4'></td></tr>
		<tr>
			    <td class='LABEL'  width='25%'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
  		        <td class='field' width='25%' >
 				<input type='text'  tabindex=2 name='visit_date_time' id='visit_date_time'  value="" maxLength='10' size='10' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){if(checkDate(this)){ComparePeriodFromToTime(this,visit_date_to)}}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visit_date_time');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img></td>

				<!--Added by Ashwini on 04-Oct-2018 for ML-MMOH-CRF-1042-->
				<td class='LABEL' width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
  		        <td class='field' width='25%'>
 				<input type='text' tabindex=3 name='visit_date_to' id='visit_date_to'  value="" maxLength='10' size='10' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){if(checkDate(this)){ComparePeriodFromToTime(visit_date_time,this)}}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visit_date_to');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img></td>

		</tr>
		<tr>
		   <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
		   <td class='button' align="right"><input tabindex=4 type="button" name="search" id="search" class=BUTTON value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="CallMoveHistDtl()"><input tabindex=5 type="button" name="clear" id="clear" class=BUTTON value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="clearAll()"></td>
	    </tr>	
		<tr><td colspan='4'></td></tr> 
   	   </table> 
	 <script>
		//	parent.frames[0].document.forms[0].reset.disabled=true;
	</script>
	 </form> 
	 </body>
<%
         if(rset!=null)  rset.close();
		 if(pstmt!=null)  pstmt.close();
		
    }              
    catch(Exception e)
    {
        //out.print(e.toString());
		e.printStackTrace();
    }
    finally
    {
        if(con!=null)
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

