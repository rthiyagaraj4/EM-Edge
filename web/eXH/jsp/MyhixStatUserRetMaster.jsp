<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../OP/js/messages.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>


<script language="javascript">


function Report()
{
	
		var event = "";
		var checkBoxes = document.getElementsByName('checkbox');

		for(var i = 0; i < checkBoxes.length; i++)
		{
			if(checkBoxes[i].checked)
			{
				document.getElementById("p_detail_rep").value = "Y";
			}
			else
			{
				document.getElementById("p_detail_rep").value = "N";
			}
		}
	var event =  document.getElementById("p_summ_type").value;
		
		parent.resultFrame.location.href='../../eCommon/html/blank.html';
		parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = '../../eCommon/jsp/report_options.jsp';
	    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="messageFrame";
	    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();
		
}
function clearSearch()
{
   
   parent.f_query_add_mod.location.reload();
   parent.resultFrame.location.href='../../eCommon/html/blank.html';	
}


function clearSearchResult()
{
   parent.resultFrame.location.href='../../eCommon/html/blank.html';
}

function getPatID()
{					  
	var pat_id=PatientSearch('','','','','','','','','','VIEW');
	if( pat_id != null )						
		document.forms[0].patient_id.value = pat_id ;					
}

async function getUserID(){
			var tdesc="";
            var tcode="";

			clearSearchResult();
			
			var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "User Group";			
            var target=this.document.getElementById("P_APPL_ID");
            var User_desc=this.document.getElementById("User_desc");

			//sql="SELECT CUST_GROUP_CODE code, SHORT_DESC description FROM AR_CUST_GROUP WHERE UPPER(CUST_GROUP_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";
			sql="SELECT APPL_USER_ID code, APPL_USER_NAME description FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) ORDER BY 1";

			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                User_desc.value=arr[1];
                target.value=arr[0];
            }
            else{
                target.value=tdesc;
                User_desc.value=tcode;
            }

						
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >

<%
		String p_fm_date = "";
		String p_to_date = "";
		String status_code = "",status_desc = "";
		String str = "";
		String p_module_id      = "XH" ;
		String p_facility_id    = (String) session.getValue( "facility_id" ) ;
		String p_user_name      = (String) session.getValue( "login_user" ) ;
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		java.util.Date da = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(da);
		cal.add(Calendar.MONTH, -1);
		da = cal.getTime();
		p_fm_date =dateFormat.format(da) ;
		p_to_date = dateFormat.format(new java.util.Date()) ;

		String pid_length="10";
		String uid_length="20";

		Connection conn = null;
		try
		{ 
			pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));	
			uid_length =  (XHUtil.singleParamExeQry("SELECT USER_ID_LENGTH FROM MP_PARAM"));
		%>


<form name="PAYER_CHECK_QUERY_FORM" id="PAYER_CHECK_QUERY_FORM" method="get" action="">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class=label width="15%"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<input type=text name=p_fm_date id="p_fm_date" value="<%=p_fm_date %>" size=11  > <input type='image' id="p_fm_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_date','dd/mm/y');"  >
		</td>	
        
        <td class=label width="15%"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<input type=text name=p_to_date id="p_to_date" value="<%=p_to_date %>" size=11  > <input type='image' id="p_to_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_date','dd/mm/y');">
		</td>		
</tr>
<tr>

	<td class=label width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<INPUT TYPE="text" id="patient_id" name="p_patient_id" id="p_patient_id" align="left" size='20' maxlength='<%=pid_length%>'  value="" onBlur="ChangeUpperCase(this);" >
		<input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
	</td>
	<td class=label width="10%"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type="hidden" id="User_desc" >
			<INPUT TYPE="text" id="P_APPL_ID" name="P_APPL_ID" id="P_APPL_ID" onBlur='getUserID()'  value="">
			<input class="BUTTON" type="button"  name=customerGroupIDSearch id=customerGroupIDSearch value='?' onClick="getUserID()">
		</td>

 </tr>
<tr>
	<td class=label width="10%"><fmt:message key="eXH.SummaryType.label" bundle="${xh_labels}"/></td>

	<%

	Connection con=null;
	Statement stmt=null;
	ResultSet rset=null;
	ArrayList ds_summary = new ArrayList();
	ArrayList ds_summary_test = new ArrayList();// Kapil
	con=ConnectionManager.getConnection(request);
	String sql1="Select  EVENT_NAME,EVENT_TYPE from xh_event_type where EVENT_TYPE in(select event_type from XH_APPLICATION_EVENT_TYPE where application_id = 'MYHIX2' and event_type in ('X01','X02','X04','X05'))";
	stmt=con.createStatement();
	rset=stmt.executeQuery(sql1);

	 while(rset.next()){
		  ds_summary.add(rset.getString("EVENT_NAME"));
		  ds_summary_test.add(rset.getString("EVENT_TYPE"));
		  
	 }
	 if(rset!=null) rset.close();
	 if(stmt!=null) stmt.close();
	 if(con!=null) con.close();
	  
	  %>
	
	<td class='fields'>
				<select id="p_summ_type" name="p_summ_type" id="p_summ_type" style="width: 150px" >
					<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%for(int i=0;i<ds_summary.size();i++){%>			
					<option value = "<%=ds_summary_test.get(i)%>"><%=ds_summary.get(i)%></option>
	<%}%>
					
				</select>
			</td>      
	 
    <td class=label width="10%" >Show Details</td>
    <td><input type='checkbox' id='checkbox' value = 'N'> </td>
</tr>

</table>

<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<!--<input class='BUTTON' type="button"  ID="query" name="query" id="query" value='Search' onClick="Query()">-->
		<input class='BUTTON' type="button"  ID="report" name="report" id="report" value='Report' onClick="Report()">
		<input class='BUTTON' type="button"  ID="clear" name=clear value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>




    <input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"							value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id"		id="p_report_id"	value="XHUSRTSUM">
	<input type="hidden" name="p_detail_rep" id="p_detail_rep"	id="p_detail_rep"   value="N">
	<input type="hidden" name="p_language_id" id="p_language_id"	id="p_language_id"	value="en">
	<input type="hidden" name="p_user_id" id="p_user_id"		value="<%= p_user_name %>">


</fieldset>
<%
}catch(Exception e1)
			{
			 out.println("(MyHixStatFailedSendMaster.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>

</form>
</body>
</html>

