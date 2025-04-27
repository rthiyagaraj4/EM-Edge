<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
// added by Arvind @ 03-12-08 
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src="../../eCA/js/DateValidation.js"></script>
<script Language="JavaScript" src='../js/ProcedureList.js'></script>
<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../js/GlobalArray.js'></script>		
<script language=javascript>
 /*function checkProcedure(obj){
	 if(obj.value=="") return false;	 
			var s_scheme=top.content.workAreaFrame.procedurelistquery.document.forms[0].s_scheme.value;
			var s_scheme_desc=top.content.workAreaFrame.procedurelistquery.document.forms[0].s_scheme_desc.value;
			var search_text=obj.value;
			var retVal = 	""; //new String();
			var dialogHeight	= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			retVal = window.showModalDialog("../../eCA/jsp/ProcSearchMain.jsp?s_scheme="+s_scheme+"&s_scheme_desc="+s_scheme_desc+"&search_text="+search_text,arguments,features);

			if (!(retVal == null)){
				var vals=retVal.split("/");
				top.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.value=vals[0];
			}else{
						top.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.value="";
						top.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.focus();
			}
}*/


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection con			=null;
PreparedStatement stmt			=null;
ResultSet rset			=null;
String patient_id		="";
String s_scheme			="";
String s_scheme_desc	="";
String today				="";
String operating_facility_id="";
String practitioner_id1 ="";
String practitioner_type ="";
String encounter_id="";
StringBuffer sql_proc=new StringBuffer(); 
String locale="";
String modal_yn="";
String called_mod="";

try
{
	con = ConnectionManager.getConnection(request);
	patient_id=request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")== null ? "N" : request.getParameter("encounter_id");	
	modal_yn=request.getParameter("modal_yn") == null ? "N" : request.getParameter("modal_yn");	
	called_mod=request.getParameter("called_mod") == null ? "N" : request.getParameter("called_mod");
	
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	if (patient_id==null) patient_id="";
	if (encounter_id==null) encounter_id="";
	operating_facility_id=(String) session.getValue("facility_id");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	locale = (String) p.getProperty("LOCALE");
	practitioner_type=(String)session.getValue("practitioner_type")==null?"":(String)session.getValue("practitioner_type");
	practitioner_id1=(String) session.getValue("ca_practitioner_id");

	String sql="Select proc_code_scheme scheme,decode(proc_code_scheme,'3','CPT4','4','ICD9-CM') scheme_desc from mr_parameter";
	stmt = con.prepareStatement(sql);
	rset = stmt.executeQuery();

	if(rset!=null)
		{
		while(rset.next())
			{
			s_scheme=rset.getString(1);
			s_scheme_desc =rset.getString(2);
			}
		}

		if (rset!=null) rset.close();
		if (stmt!=null) stmt.close();

		today	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
/*
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
		stmt=con.prepareStatement(sql);
		
		rset = stmt.executeQuery();
		if (rset.next())
		{
		today = rset.getString("today");
		}

		if(rset !=null) rset.close();
		if(stmt !=null) stmt.close();
*/	
	
%>


<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='Procedure_List' id='Procedure_List'>
<BR>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<!--.........................................................--> 
	<tr>
                    <td class='label' width="25%"><fmt:message key="eCA.ProcedureSet.label" bundle="${ca_labels}"/></td>
                    <td  class='fields' width="25%">
			<select name="code_set" id="code_set"  onChange="showTable(this);" ><option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		<%
			//stmt = con.createStatement();
			if(sql_proc.length() > 0) sql_proc.delete(0,sql_proc.length());
			sql_proc.append("select a.term_set_id,priority_appl_yn||'='||nature_appl_yn||'='||severity_appl_yn||'='||onset_type_appl_yn||'='||factors_appl_yn||'='||notification_appl_yn term_set_id1,term_set_desc "); 
			sql_proc.append("from mr_term_set a where exists (select 1 from mr_term_set_for_facility where FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from "); sql_proc.append("mr_term_set_for_pract_type where PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from mr_term_set_for_specialty where"); 
			sql_proc.append(" SPECIALTY_CODE in (select SPECIALTY_CODE from pr_encounter where "); sql_proc.append(" facility_id=? and encounter_id=?) AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND "); 
			sql_proc.append(" TERM_SET_ID=A.TERM_SET_ID or not exists (select 1 from "); 
			sql_proc.append(" mr_term_set_for_pract  where PRACTITIONER_ID=ib.PRACTITIONER_ID) ) and "); sql_proc.append(" Eff_status='E' and proc_spec_yn='Y' order by term_set_desc");
			
			stmt = con.prepareStatement(sql_proc.toString());
			stmt.setString(1,operating_facility_id);
			stmt.setString(2,practitioner_type);

			stmt.setString(3,operating_facility_id);
			stmt.setString(4,encounter_id);

			stmt.setString(5,practitioner_id1);

					
			rset = stmt.executeQuery();


			while(rset.next())
			{
				String proc_desc = rset.getString("term_set_desc");
				String proc_set_id = rset.getString("term_set_id")+"~"+proc_desc;
				
				//String proc_code1 = rset.getString("term_set_id1");
				String temp_proc_set = rset.getString("term_set_id");
				//String proc_sel = "";
				
				if(term_set_id.equals(temp_proc_set))
				{
					out.print("<option value='"+proc_set_id+"' selected >"+proc_desc+"</option>");
				}
				else
				{
					out.print("<option value='"+proc_set_id+"' >"+proc_desc+"</option>");
				}
			}
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();	
			
			}
	catch(Exception ee)
	{
	//out.println("Exception@Connection"+ee);//COMMON-ICN-0181
	ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
		%>
        </select><!-- <img align='center' src='../../eCommon/images/mandatory.gif'> -->
		<input type="hidden" name="proc_set" id="proc_set" value="">
		<input type="hidden" name="proc_set_desc" id="proc_set_desc" value="">
	</td>
       
	
		<td  width="25%" class='label' ><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%" >
				<input type='text' size=10 maxlength='10' name='proc_desc' id='proc_desc' value='' onBlur='getTermCode(this)' readOnly ><input type='hidden' value='' name='proc_code' id='proc_code'></input><input type="button" class='Button' name="searchcode_button1" id="searchcode_button1" title='search_code' value="?" onClick='callTermCode()' disabled>
		</td> 
	
		</tr><tr>

				
		<td  width="25%" class='label' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%">
		<input type='text' size=10 maxlength='10' name='from_date' id='from_date' value='' onblur='CheckDate(this);CheckSystemDateLesser(this,to_date, "<%=today%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');" > - <input type='text' size=10 maxlength='10' name='to_date' id='to_date' value='' onblur='CheckDate(this);CheckSystemDateLesser(from_date,this, "<%=today%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');" ></td>
			
		<td class='label' width="25%"  ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='fields'  width="25%" > 	
			<input type='hidden' size=10 maxlength='20' name='serv_code' id='serv_code' value=''><input type='hidden' name='locale' id='locale' value='<%=locale%>'><input type='text' size=10 maxlength='20' name='serv_code1' id='serv_code1' value='' onBlur='checkService(this)'><input type="button" class='Button' name="searchcode_button" id="searchcode_button" title='search_code' value="?" onClick='show_service_window()'> 
		</td>
		</tr><tr>
 		<td colspan=4 align='right'><input type="button" class='Button' name="searchresult_button" id="searchresult_button" title='search_result' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='search_result()'><input type="button" class='Button' name="clear_form" id="clear_form" title='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clear_result()'></td>
		
	</tr>
	<!-----------------------------....................-->
</table>

<!-- // added by Arvind @ 03-12-08  -->

<%  if(!imgUrl.equals("")){%>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>


				<!-- end here -->

<input type=hidden value='<%=patient_id%>' name='patient_id'></input>
<input type=hidden value='<%=s_scheme%>' name='s_scheme'></input>
<input type=hidden value='<%=s_scheme_desc%>' name='s_scheme_desc'></input>
<input type=hidden value='<%=modal_yn%>' name='modal_yn'></input>
<input type=hidden value='<%=encounter_id%>' name='encounter_id'></input>
<input type=hidden value='<%=called_mod%>' name='called_mod'></input>

<% 
	if(called_mod.equals("BL")){ %>
		<script>
			search_result();
		</script>
<% } %>
</form>
</body>
</html>

