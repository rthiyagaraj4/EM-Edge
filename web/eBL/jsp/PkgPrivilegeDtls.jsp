<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="eBL.Common.BlRepository"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
  
<html>
<head>
<%
Connection con			= ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		try
		{
		String str_title="";
		String patientId = request.getParameter("patientId") == null ? "" :request.getParameter("patientId") ;
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;		
			str_title=request.getParameter("title");	
%>
<title>
	<%=str_title%>
</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
 

<script language="javascript" src="../../eBL/js/BLPrivilege.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		</style>


<% 
	
		
		ResultSet rs			= null;
		ResultSet rscurr			= null;
		Statement stmt				= null;
	
		String locale			= (String)session.getAttribute("LOCALE");		
		
		String patln="";
		String sqlCardDesc = BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_CARDDESC");
		try
		{			
			String sqlGetPatLine = BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_PATHDR");
			CallableStatement call = con.prepareCall(sqlGetPatLine);	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,patientId);
			call.setString(3,locale);
			call.execute();							
			patln = call.getString(1);
			
			call.close();
			if ( patln == null ) patln = "";
			int ind=patln.indexOf("#");
			patln=patln.substring(0,ind);
			if ( patln == null ) patln = "";
		}catch(Exception e)
			{
				System.out.println("Exception no. of patline :"+e);
				e.printStackTrace();
			}
		finally{
			ConnectionManager.returnConnection(con, request);
		}

%>

	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();" >
<form name='frmPkgSubs' id='frmPkgSubs' action="../../servlet/eBL.CardSubscriptionServlet" method="post" target="messageFrame" >	
	<!--div id="tbl-container" STYLE="overflow: auto; width: 1030px; height: 355px;   padding:3px; margin: 0px"-->	
	<br/>
	<br/>
	<table class='grid' width='100%' id="pkgSubs_tabId">
	<tr>
	<td  class='COLUMNHEADER' colspan='4' ><b><%=patln%><b></td>
	</tr>	


		</table>		
	
		
<!--   <br/>
   <br/>
   <br/> -->
	
	   <TABLE align='center' border='0' class='grid' cellpadding='1' cellspacing='0' width='100%'> 

      <tr id="heading">
	     <td class="COLUMNHEADER" ><fmt:message key="eBL.CARD_TYPE.label"   bundle="${common_labels}"/></td>					   
		 <td class="COLUMNHEADER" ><fmt:message key="eBL.PRICE_CLASS.label"   bundle="${common_labels}"/></td>					   
         <td class="COLUMNHEADER" ><fmt:message key="Common.fromdate.label"   bundle="${common_labels}"/></td>	
         <td class="COLUMNHEADER" ><fmt:message key="Common.todate.label"   bundle="${common_labels}"/></td>	
		 <td class="COLUMNHEADER" ><fmt:message key="eBL.MEMBER_SHIP_FEES.label"   bundle="${common_labels}"/></td>	
		 
       </tr>
	   <tr>
     <td class="fields" >
     	<INPUT TYPE="TEXT"  name="card_type" id="card_type" id="card_type" SIZE="17" maxlength='12' VALUE=''  onKeyPress='changeToUpper()' onBlur="if(this.value!=''){return callPackageServiceCode(card_type);} else{clearCard();}" >
     	<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return callPackageServiceCode(card_type)" tabindex='2'>
     	<img src='../../eCommon/images/mandatory.gif'> 
     	<input type="hidden" id="card_type_id"/>
     </td>         
	 <td class="fields" ><INPUT TYPE="TEXT"  id="price_class" SIZE="12" maxlength='12' VALUE=''  onKeyPress='changeToUpper()' onBlur="" disabled />
	 <INPUT TYPE="TEXT"  id="price_desc" SIZE="25" maxlength='25' VALUE=''  onKeyPress='changeToUpper()' onBlur="" disabled /></td>         
	 <td  class="fields"><input type='text' id='from_date' size='10' maxlength='10' style='text-align:right' value='' onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);setToDate(this);'  disabled /> 
	 <img src='../../eCommon/images/CommonCalendar.gif' id='calendar_ctrl' onClick="return showCalendar('from_date');" disabled>
	 <img src='../../eCommon/images/mandatory.gif'></img>
	  </td> 
	  <td  class="fields"><input type='text' id='to_date' size='10' maxlength='10' style='text-align:right' value=''   onBlur="" disabled /> 
	  <img src='../../eCommon/images/CommonCalendar.gif' disabled />
	  </td> 
	   <td  class="fields"><input type='text' id='member_fees' size='12' maxlength='12' style='text-align:right' value=''   onBlur="" disabled /> 
	  </td> 	
	</tr>
    </table>
 		
 		
 		<br/> <br/><br/><br/>
		<table  cellpadding='3' cellspacing=0   border='0' id='Mapping_Code_Heading' width='100%'>		
				<tr>	
					<td class='COLUMNHEADER'  align='left' ><fmt:message key="eBL.PRIVILIEGE_CARD_MEMBER.label" bundle="${bl_labels}"/></th>
				</tr>
			</table>
	<!--	<br/>	   
		<br/>
    <!--  table border='1' cellspacing="5"-->    
    <div style="overflow:scroll;height:250px;width:100%;overflow:auto">
    <TABLE align='center' class='grid' id='billing_group_category_table' border='0' cellpadding='1' cellspacing='0' width='100%' > 
    <tr>
    <td class="COLUMNHEADER" ><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>
    <td class="COLUMNHEADER" ><fmt:message key="Common.PatientName.label"   bundle="${common_labels}"/></td>
    <td class="COLUMNHEADER" ><fmt:message key="Common.age.label"   bundle="${common_labels}"/></td>	
    <td class="COLUMNHEADER" ><fmt:message key="eBL.PRICE_CLASS.label"   bundle="${common_labels}"/></td>
    </tr>
   
    <tr>
	    	
		<td class="fields" >
		<INPUT TYPE="TEXT"  name="patientids" id="patientids" SIZE="15" maxlength='12' VALUE='' id='billing_group_by_category_code0' onKeyPress='changeToUpper()' onBlur="callPatValidationSub(this,0);" ><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="getnewPatID();callPatValidationSub(billing_group_by_category_code0,0);" tabindex='2'></td>
	 	
			
		<td class="fields" ><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="50" maxlength='12' VALUE='' disabled="disabled" id='billing_group_by_category_long_desc0'  onKeyPress='changeToUpper()' onBlur="" /></td>
		
		
		<td class="fields" ><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="15" maxlength='12' VALUE='' id='billing_group_by_category_short_desc0'   onKeyPress='changeToUpper()' onBlur="" disabled /></td>
		
			
		<td class="fields" ><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="35" maxlength='12' VALUE='' id='billing_group_by_category_price_class0' onKeyPress='changeToUpper()' onBlur="" disabled /></td>

		<td class="label">
		<input type='button' id='add_button0' class='button'name='Add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>'  onclick="addnew('billing_group_category_table');"  />	
		</td>
	    	
	</tr>  
    </table>
	</div>



		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='patientId' id='patientId' value="<%=patientId%>" >
		<input type='hidden' name='strMessageId' id='strMessageId' value="" >
		<input type='hidden' name='strErrorText' id='strErrorText' value="" >
		<input type='hidden' name = 'valid_days' >
		<input type='hidden' name = 'errCheck' value='no'>
		<input type='hidden' name = 'effFromHdn'>
		<input type='hidden' name = 'effFromMaster'>
		<input type='hidden' name = 'effToMaster'>
		<input type='hidden' name = 'sqlCardDesc' value="<%=sqlCardDesc%>">

</form>
</body>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package subscription  :"+e);
	e.printStackTrace();
}finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

