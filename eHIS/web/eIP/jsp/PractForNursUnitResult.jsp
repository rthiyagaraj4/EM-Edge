<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--
	Developed by 	:	Prakash.S
	Created on 		:	20/08/2002
	Module			:	IP
-->
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, webbeans.eCommon.RecordSet" %>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<jsp:useBean id="PractNursRecordSet" scope="session" class="webbeans.eCommon.RecordSet" /> 
<jsp:useBean id="SimplifyPractNurs" scope="session" class="webbeans.eCommon.RecordSet" />
<jsp:useBean id="NextPrevPractNurs" scope="session" class="webbeans.eCommon.RecordSet" /> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../js/NursUnitPract.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function assignVal(obj, i)
{
	if(obj.checked)
		eval("document.forms[0].removeCode"+i).value = "N";
	else
		eval("document.forms[0].removeCode"+i).value = "Y";
}

</script>
<%
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
 	Statement stmt3		= null;
 	ResultSet rstlRs3	= null;
	PreparedStatement pstmt=null;
	con = 	ConnectionManager.getConnection(request);
	
	try
	{
		
		stmt	=	con.createStatement();
		String facility_id  =	(String)session.getAttribute("facility_id");
		//String req_start    =   "", req_end     =   "";
		//String checkedOnes  =   "";
		String practype     = "";
		boolean is_all_selected = true;
		boolean isSimplifyPractNursUnit = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","SIMPLIFY_PRACT_FOR_NURS_RES"); //Added by Ajay Hatwate for ML-MMOH-CRF-2121		
		int existingCount = 0;
		
		String search_by    = request.getParameter("search_by") ;
		if(search_by == null || search_by.equals("null")) search_by="";

			
	
		String search_txt   = request.getParameter("search_txt") ;
		if(search_txt == null || search_txt.equals("null")) search_txt="";

		

		String from			= request.getParameter("from") ;
		String to			= request.getParameter("to") ;

		int maxRecord = 0;
		int start     = 0;
		int end       = 0;
		int i         = 1;

		if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }

		



		//req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
		//req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
		
		String mode			=	request.getParameter("mode") ;
		if(mode == null || mode.equals("null")) mode="";

		String function_code=request.getParameter("function_code");
		if(function_code==null)function_code="";

		String operation = request.getParameter("operation");
			if(operation==null)operation="";

		String Function = request.getParameter("Function");
			if(Function==null)Function="";

		//for first time if session exists then removing attribute for capturing current results.
		String is_origin = request.getParameter("is_origin");
		if(is_origin==null)is_origin="true";
		Boolean fromSession = false;
		
		if(is_origin.equals("true") && session.getAttribute("PractForNurseUnit") != null){
			session.removeAttribute("PractForNurseUnit");
		}else{
			int page1 = end/14;
			HashMap<String, String> map = (HashMap<String, String>)(session.getAttribute("PractForNurseUnit")) ;
			if(map != null){
				String c_code = map.get("c_clinic_id"+page1);
				if(c_code != null){
					NextPrevPractNurs.clearAll();
					String[] NextPrevCodes = c_code.split(",");
						
					for(String npCode : NextPrevCodes){
						NextPrevPractNurs.putObject(npCode);	
					}
					fromSession = true;
				}
			}
		}
		String function_desc="";

		if(Function.equals("pract"))
			function_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		else if(Function.equals("nurs"))
			function_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");

		StringBuffer result_query = new StringBuffer();
		//String flagSelect = request.getParameter("fromSelect");
		String search_criteria	= "";
		String search_criteria2 = "";
		String search_criteria3 = "";
		//String removeCode		= "";

		if(search_by != null && !search_by.equals(""))
		{
		  if(search_txt != null && !search_txt.equals(""))
		  {
			if(Function.equals("pract"))
			{
				if(search_by.equals("01"))
				{
				  search_criteria = " and NURSING_UNIT_CODE like upper('"+search_txt+"%') ";
				  search_criteria2 = " and NURSING_UNIT_CODE like upper('"+search_txt+"%') ";
				  search_criteria3 = " and b.NURSING_UNIT_CODE like upper('"+search_txt+"%') ";
				}
				else if(search_by.equals("02"))
				{
				  search_criteria = " and UPPER(NURSING_UNIT_SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
				}
			}
			else if(Function.equals("nurs"))
			{
				if(search_by.equals("01"))
				  search_criteria = " and UPPER(PRACTITIONER_ID) like UPPER('"+search_txt+"%') ";
				else if(search_by.equals("02"))
				  search_criteria = " and UPPER(PRACTITIONER_NAME) like UPPER('"+search_txt+"%') ";
			}
		  }
		}

		//if(flagSelect !=null)
		//{
			PractNursRecordSet.clearAll();

			if(Function.equals("nurs"))
			{
				result_query.append(" select practitioner_id from IP_NURSING_UNIT_FOR_PRACT_VW where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"'"); 
				result_query.append(search_criteria); 

			}
			else if(Function.equals("pract"))
			{
				result_query.append(" select nursing_unit_code from IP_NURSING_UNIT_FOR_PRACT_VW where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"' ");
				result_query.append(search_criteria); 
			}	
			stmt3=con.createStatement();
			rstlRs3 = stmt3.executeQuery(result_query.toString());

			if(rstlRs3 !=null)
			{
				 while(rstlRs3.next())
				 {
					PractNursRecordSet.putObject(rstlRs3.getString(1));
				 }
			}	
			if(rstlRs3!=null)rstlRs3.close();
			if(stmt3!=null)stmt3.close();
			
			//Added by Ajay Hatwate for ML-MMOH-CRF-2121	
			SimplifyPractNurs.clearAll();
			if(isSimplifyPractNursUnit && Function.equals("pract")){
				result_query.setLength(0);
				
				result_query.append("select count(*) from IP_NURSING_UNIT_FOR_PRACT where practitioner_id = ? and facility_id = ?");
				pstmt = con.prepareStatement(result_query.toString());
				pstmt.setString(1, function_code);
				pstmt.setString(2, facility_id);
				rstlRs3 = pstmt.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						 existingCount = rstlRs3.getInt(1);
					 }
				}	
				
				
				if(existingCount == 0){
				result_query.setLength(0);
				
				result_query.append("SELECT locn_code FROM am_locn_for_oper_stn WHERE oper_stn_id = (SELECT oper_stn_id	FROM am_user_for_oper_stn WHERE appl_user_id = (SELECT appl_user_id FROM sm_appl_user WHERE func_role_id = '"+function_code+"') AND (TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (eff_date_from, 'DD/MM/YYYY') AND (eff_date_to IS NULL OR TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (eff_date_to, 'DD/MM/YYYY'))))");	
				stmt3 = con.createStatement();
				rstlRs3 = stmt3.executeQuery(result_query.toString());
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						SimplifyPractNurs.putObject(rstlRs3.getString(1));
					 }
				}	
			}
			}//End of ML-MMOH-CRF-2121
	

		/*if(from != null && to != null)
		{
			 int j=0;
			 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			 {
				 if(request.getParameter("select_yn"+(i)) != null)
				 {
					 checkedOnes = request.getParameter("select_yn"+(i));
					 if(!(PractNursRecordSet.containsObject(checkedOnes)))
						 PractNursRecordSet.putObject(checkedOnes);
						 j++;
				 }
				
				removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))
				{
					String Code = request.getParameter("Code"+(i));
					if((PractNursRecordSet.containsObject(Code)))
					{
						int removeCodeIndex = PractNursRecordSet.indexOfObject(Code);
							PractNursRecordSet.removeObject(removeCodeIndex);
					}
				}
			 }

			 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		 }*/

	        i = 1 ;
			String classValue="";
			String chkAttribute="";
			StringBuffer sql = new StringBuffer();

			if(Function.equals("nurs"))
			{

				sql.append("select a.practitioner_id \"code\", a.practitioner_name \"desc\",a.pract_type practype, 'Y',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"' )and a.pract_type = b.pract_type "+search_criteria+" UNION select practitioner_id \"code\", practitioner_name \"desc\",a.pract_type,'N',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and 	a.eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') and a.pract_type = b.pract_type "+search_criteria+" order by 2"); 
			}
			else if(Function.equals("pract"))
			{
				sql.append("select nursing_unit_code \"code\", short_desc \"desc\", 'N' from ip_nursing_unit where facility_id='"+facility_id+"' AND eff_status='E' and locn_type = 'N' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"') "+search_criteria2+" union select a.nursing_unit_code, short_desc,'Y' from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facility_id+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code "+search_criteria3+" order by 2");
			}
  try{
        //stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql.toString());
	  }
	  catch(Exception e)
		  {
			  //out.println(e);
			  e.printStackTrace();
			  }
  

	if(existingCount == 0 && Function.equals("pract")){ // Added for ML-MMOH-SCF-3045 start
	 	Statement stmt4		= null;
	 	ResultSet rs4	= null;
	 	String c_clinic_id="";
	 	HashMap<String, String> map1 = (HashMap<String, String>)(session.getAttribute("PractForNurseUnit")==null ? new HashMap<String, String>() : session.getAttribute("PractForNurseUnit"));
		stmt4=con.createStatement();
		rs4=stmt4.executeQuery(sql.toString());
		int mapcnt=0;
		int prevPageno=1;
		// System.err.println("288 in PractForNursUnitResult.jsp");
		while(rs4.next()){
			++mapcnt;
			int pageno = (int) Math.ceil(mapcnt/14.0);
			if(pageno<=prevPageno){
				prevPageno=pageno;
			}else{
				c_clinic_id="";
				prevPageno=pageno;
			}
			// System.err.println("298 in PractForNursUnitResult.jsp");
			if(SimplifyPractNurs.containsObject(rs4.getString(1))){
				if(c_clinic_id.equals(""))
					c_clinic_id=rs4.getString(1);
				else
					c_clinic_id=c_clinic_id+","+rs4.getString(1);
			}
			// System.err.println("305 in PractForNursUnitResult.jsp");
			if(map1.get("page")!=null){
				int page1 = Integer.parseInt(map1.get("page"));	
				if(pageno > page1){
						map1.put("c_clinic_id"+pageno, c_clinic_id);
					}
				}else{
					map1.put("c_clinic_id"+pageno, c_clinic_id);
				}
			// System.err.println("313 in PractForNursUnitResult.jsp");
		} // while end
		map1.put("existingCount",Integer.toString(existingCount));
		map1.put("prevPageno",Integer.toString(prevPageno));
		session.setAttribute("PractForNurseUnit", map1);
		if(stmt3!= null)stmt3.close();
		if(rs4!=null)rs4.close();
		// System.err.println("321 in PractForNursUnitResult.jsp");
		
	} // count end 
	// Added for ML-MMOH-SCF-3045 end

		  if (start != 0)
		{
		   for(int j=1; j<=start; i++,j++)
			{
				rs.next() ;
			}
		}

	while(i<=end && rs.next())
	{
	  if(maxRecord==0)
		{
%>
<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='CONTENT' >
<form name='FMAssnStrLocnMainResultForm' id='FMAssnStrLocnMainResultForm' action='../../eIP/jsp/PractForNursUnitResult.jsp' method='post' >

<input type=hidden name='function_code' id='function_code' value='<%=function_code%>'>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name='operation' id='operation' value='<%=operation%>'>
<input type=hidden name='Function' id='Function' value='<%=Function%>'>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type=hidden name='function_name' id='function_name' value='insert'>
<input type=hidden name='isOnApply' id='isOnApply' value='N'>
<input type="hidden" name="search_by" id="search_by" value='<%=search_by%>'>
<input type="hidden" name="search_txt" id="search_txt" value='<%=search_txt%>'>
<input type="hidden" name="isSimplifyPractNursUnit" id="isSimplifyPractNursUnit" value="<%=isSimplifyPractNursUnit%>">
<input type="hidden" name="is_origin" id="is_origin" value="<%=is_origin%>">

<P>
<table width='90%' align='center'>
<tr>
<!--<td class = 'white' width = '95%'></td>
<td align = 'right' nowrap>-->
<table width='90%' align='center'>
<tr align="right">

<%
    if ( !(start <= 1)) {

    out.println("<td align='right' style='WIDTH: 95%;' id='prev'><a href='javascript:submitPrevNext("+(start-14)+","+(end-14)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	%>
    <input type="hidden" name='whichPage' id='whichPage' value='prev'>

</td>

<%
    }
    out.println("<td id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+14)+","+(end+14)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	%>
    <input type="hidden" name='whichPage' id='whichPage' value='next'>

</td>
<%
    //}
%>
	</tr>
	</table>
	<br>
	<br>
	</tr>
	</table>

    <table cellpadding='0' cellspacing='0' border='1' width='90%' align='center' >
	<%if(Function.equals("nurs")){%><th>&nbsp;</th><%}%>
	<th width=''><%=function_desc%></th>
<%	if(Function.equals("nurs"))
	{
%>
	<th width=''><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
<%
	}
%>
	
	<th width=''><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick="selectAll(this,<%=start%>,<%=end%>);"></th>
	<%	 
		}
	/*if (start != 0)
	{
	   for(int j=1; j<=start; i++,j++)
		{
			rs.next() ;
		}
	}*/
	//while(rs.next() && i<=end)
	//{
		String id=  rs.getString(1);
		String desc = rs.getString(2);
		String removeCode_YN = "";
		if(Function.equals("nurs"))
		{
			practype = rs.getString("desc_userdef");
		}	
		if(PractNursRecordSet.containsObject(id)) 
		{
			chkAttribute = "CHECKED";
			removeCode_YN = "N";
		}
		else
		{
			chkAttribute="";
			removeCode_YN = "Y";
			is_all_selected = false;
		}
		
		//Added by Ajay Hatwate for ML-MMOH-CRF-2121
				// if(Function.equals("pract") && isSimplifyPractNursUnit && SimplifyPractNurs.containsObject(id) && existingCount == 0){		
				if(isSimplifyPractNursUnit && SimplifyPractNurs.containsObject(id) && existingCount == 0){		// modified for ML-MMOH-SCF-3045
					chkAttribute = "CHECKED";
					removeCode_YN = "N";
				}
		if(fromSession){
//			if(Function.equals("pract") && isSimplifyPractNursUnit){
			if(isSimplifyPractNursUnit){ // modified for ML-MMOH-SCF-3045
				if(NextPrevPractNurs.containsObject(id)){
					chkAttribute = "CHECKED";
					removeCode_YN = "N";
				}else{	
					chkAttribute = "";
					removeCode_YN = "Y";
					is_all_selected = false;
				}
			}
		}
		

		if( i%2 == 0)  
			classValue="QRYEVEN";
		else
			classValue="QRYODD";
		%>

		<tr>
			<%if(Function.equals("nurs")){%><td class='<%=classValue%>' align='center' width='1%'>
				
			<a href='javascript:showPractWindow("<%=id%>");'>+</a></td><%}%>
			<td class='<%=classValue%>' align='left'><%=desc%></td>
		<%	if(Function.equals("nurs"))
			{	%>
				<td class='<%=classValue%>' align='left'><%=practype%></td>
		<%	}	%>
			<td class='<%=classValue%>' align='center'>
			<input type='checkbox' <%=chkAttribute%>  name='select_yn<%=i%>' onclick="assignVal(this, <%=i%>);" value="<%=id%>"><input type='hidden' name='removeCode<%=i%>' value="<%=removeCode_YN%>"><input type='hidden' name='Code<%=i%>' value="<%=id%>"></td>
		</tr>

		<input type="hidden" name=pract_id id=pract_id value='<%=function_code%>'>
		<input type="hidden" name="hddselect" id="hddselect" value="Tru">
		
<%		i++;
		maxRecord++;
	}

		if(is_all_selected)
		{
			%>
				<script>document.getElementById("chkAll").checked=true;</script>
			<%
		}
		else
		{%>
			<script>document.getElementById("chkAll").checked=false;</script>
		<%
		}

		if(maxRecord<14 || (!rs.next()))
		{%>
			<script>
				if(document.getElementById('next'))
					document.getElementById('next').style.visibility='hidden';
			</script>
		<%
		}
		else
		{%>
			<script>
				if(document.getElementById('next'))
					document.getElementById('next').style.visibility='visible';
			</script>
		<%
		}

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			
		}
		if(stmt != null)	stmt.close();
		if(stmt3 != null)	stmt3.close();
		if(pstmt != null)	pstmt.close();
		if(rstlRs3 != null) rstlRs3.close();

	}catch(Exception e)
	{
		//out.println("Exception in fetching connection"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("PractNursRecordSet", PractNursRecordSet);
	}
	%>

	</body>
</html>
	

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


