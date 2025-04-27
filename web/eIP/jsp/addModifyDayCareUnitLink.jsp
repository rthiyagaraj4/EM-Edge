<!DOCTYPE html>
 <html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="DayCareUnitSpeciality" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% request.setCharacterEncoding("UTF-8"); String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../js/DayCareUnitLink.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
		String req_start = "", req_end  = "";
        String checkedOnes  = "";
        String from	= request.getParameter("from") ;
        String to	= request.getParameter("to") ;
        //int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
        String removeCode = "";

       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus    ="";
	Connection con      = null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	Statement stmt		= null;
	ResultSet rs		= null ;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";

	try{
	con = ConnectionManager.getConnection(request);

	String facility_id			= (String)session.getValue("facility_id");
	String nursing_unit_code	= request.getParameter("nursing_unit_code");
	String flagSelect			= request.getParameter("fromSelect");

	String search_by		= (request.getParameter("search_by"));
	String search_txt		= (request.getParameter("search_txt"));
	
	String search_criteria	=  "";
	String search_criteria2	=  "";
	String search_criteria3	=  "";

	if(search_by.equals("ID")) search_by = "01";
	if(search_by.equals("DESC")) search_by = "02";
	if(search_by.equals("")||(search_by == null)) search_by = "00";

	if(search_by != null && !search_by.equals("00"))
	{
	  if(search_txt != null && !search_txt.equals(""))
	  {
		if(search_by.equals("01"))
		  {
			  search_criteria  = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
			  search_criteria2 = " and UPPER(b.CLINIC_CODE) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
		  }
		 else if(search_by.equals("02"))
		  {	
			  search_criteria  = " and UPPER(CLINIC_SHORT_DESC) like UPPER('"+search_txt+"%')  ";
			  search_criteria2 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
		  }
	  }
	}

//CLINIC_SHORT_DESC -- CLINIC_CODE

//CLINIC_CODE -- SHORT_DESC

	if(flagSelect !=null)
	{
		DayCareUnitSpeciality.clearAll();
		StringBuffer sqlinsVals = new StringBuffer();
		sqlinsVals.append( " select clinic_code from ip_dc_unit_for_nurs_unit_vw   where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facility_id+"' ");
		sqlinsVals.append(search_criteria);

		stmt3=con.createStatement();
		rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());
		if(rstlRs3 !=null)
		{
			 while(rstlRs3.next())
			 {
				DayCareUnitSpeciality.putObject(rstlRs3.getString(1));
			 }
		if(rstlRs3!=null) rstlRs3.close();
		if(stmt3!=null) stmt3.close();
		}
	}
             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(DayCareUnitSpeciality.containsObject(checkedOnes)))
                                 DayCareUnitSpeciality.putObject(checkedOnes);
                             j++;
                         }

						removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclCode = request.getParameter("spclCode"+(i));
							if((DayCareUnitSpeciality.containsObject(spclCode)))
							{
								int removeCodeIndex = DayCareUnitSpeciality.indexOfObject(spclCode);
								DayCareUnitSpeciality.removeObject(removeCodeIndex);
							}
						}
                     }

                 out.println("<input type= hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type= hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
		int cnt = 0;
		int nextOfRes = 1;
			String classValue="";
			String chkAttribute="";
			StringBuffer sql = new StringBuffer();
			
	  sql.append("select a.facility_id,a.nursing_unit_code,a.clinic_code dc_cliniccode,b.clinic_code op_cliniccode, b.short_desc from ip_dc_unit_for_nurs_unit a, op_clinic b where a.facility_id  = '"+facility_id+"' and a.nursing_unit_code = '"+nursing_unit_code+"' and  a.facility_id (+) = b.facility_id  and a.clinic_code (+) = b.clinic_code and   b.eff_status = 'E' ");
	  sql.append(search_criteria2);
	  sql.append(" union select facility_id, null, null ,clinic_code op_cliniccode ,  short_desc from op_clinic where facility_id = '"+facility_id+"' and care_locn_type_ind = 'D' and eff_status = 'E'  and clinic_code not in ( select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') ");
	  sql.append(search_criteria3);
	  sql.append(" order by short_desc ");

/*try{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql.toString());
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();

	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		return;
	}

	}catch(Exception e){out.println(e);}*/

	//out.println(sql.toString());

	

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	
	if (start != 0){
	    for(int j=1; j<=start; i++,j++){
		rs.next() ;
		}
	}

	while( i<=end && rs.next() ){ 
		if(cnt == 0)
		{

%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='//chkForSelectAll(<%=start%>,<%=end%>);' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eIP/jsp/addModifyDayCareUnitLink.jsp' method='post' >

<table  width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
<input type=hidden name='clinic_code' id='clinic_code' value=''>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type=hidden name='function_name' id='function_name' value='insert'>
<input type=hidden name='allValues' id='allValues' value=''>
<input type="hidden" name="search_by" id="search_by" value=<%=search_by%>>
<input type="hidden" name="search_txt" id="search_txt" value=<%=search_txt%>>


<%
    if ( !(start <= 1)) {

    out.println("<a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	%>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( nextOfRes == 1 ){

    out.println("<a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none' id='nextval'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	%>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='60%'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> <br><!-- <input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>);'> --></th>
		<%	 
		}
		/*if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ */
			String speciality_code=rs.getString("op_cliniccode");
			String short_desc=rs.getString("short_desc");

			if(DayCareUnitSpeciality.containsObject(speciality_code))  
				chkAttribute = "CHECKED";
			else
				chkAttribute = "";

			int recordIndex = DayCareUnitSpeciality.indexOfObject(speciality_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED")){
				DayCareUnitSpeciality.removeObject(recordIndex);
			}
		
				if( i%2 == 0)  
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=short_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>' onclick="checkdis(this);RemSelectAll(this, <%=i%>);" value='<%=speciality_code%>'><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='spclCode<%=i%>' id='spclCode<%=i%>' value="<%=speciality_code%>"></td>
			</tr>
			<%
			i++;
			cnt++;
			}	
			if(cnt == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				return;
			}

			if( !rs.next() && cnt!=0 )
			{
				nextOfRes = 0;
			%>
			<script>
				document.getElementById("nextval").innerHTML=" ";
			</script>
			<%
			}
			if(rs!=null) rs.close();
			if(rstlRs3 != null)rstlRs3 = null; 
			if(stmt!=null) stmt.close();
			 if(stmt3 != null)	stmt3 = null; 
		 }catch(Exception e)
		 {
			 out.println(e);
		 }
		 finally
		 {
			ConnectionManager.returnConnection(con,request);
			session.setAttribute("DayCareUnitSpeciality", DayCareUnitSpeciality);
		 }%>
</table>
</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

