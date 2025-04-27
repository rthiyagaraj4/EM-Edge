<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>



<script>
async function showModal(code_ind,diag_srl_no,eff_status)
	{
			var retVal = 	new String();
			var dialogHeight= "350px" ;
			var dialogTop 	= "110";
			var dialogWidth	= "700px" ;
			var dialogLeft="218";
			var status = "no";
			var arguments	= "" ;
			var tit="";
			tit=getLabel("Common.ICDCode.label","Common");
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+"; dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop;
			retVal = await window.showModalDialog("../../eMR/jsp/ModifyICDCodeMain.jsp?diag_srl_no="+diag_srl_no+"&eff_status="+eff_status+"&code_ind="+code_ind+"&title="+encodeURIComponent(tit),arguments,features);
			if(retVal == 'cancel');
			else			
			document.location.reload();
	}

</script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='icdcode' id='icdcode' method='post' target='f_query_mod' action='ICDCodeQueryResult.jsp'>");

String whereClause = request.getParameter("whereclause");
StringBuffer sql = new StringBuffer();
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String orderBy=request.getParameter("orderBy");
	if(orderBy == null) orderBy="";

if ( (whereClause == null || whereClause.equals(""))&& orderBy.equals("") )
	{
	sql= new StringBuffer();
	String record_type_desc=request.getParameter("record_type_desc");
	if(record_type_desc == null) record_type_desc = "";
	String diag_code=request.getParameter("diag_code");
	String short_desc=request.getParameter("title");
	String gender_spec_ind_desc=request.getParameter("gender_spec_ind_desc");
	String age_spec_ind_desc=request.getParameter("age_spec_ind_desc");
	String tab_list=request.getParameter("tab_list");
	String sensitive_yn=request.getParameter("sensitive_yn");
	String notifiable_yn=request.getParameter("notifiable_yn");
	String diag_code_scheme_desc=request.getParameter("diag_code_scheme_desc");
	String code_ind=request.getParameter("code_ind");
	String order_by = request.getParameter("order_by");

	if(order_by == null) order_by="";

	int andCheck = 0;

	if ( !(record_type_desc == null || record_type_desc.equals("") || record_type_desc.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(record_type) =  upper('"+record_type_desc+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(record_type) = upper('"+record_type_desc+"')");
			andCheck = 1;
		}
	}
	if ( !(diag_code == null || diag_code.equals("") || diag_code.equals("null")) )
	{
		
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(diag_code) like  upper('"+diag_code+"%')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(diag_code) like upper('"+diag_code+"%')");
			andCheck = 1;
		}
	}
	if ( !(short_desc == null || short_desc.equals("") || short_desc.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(short_desc) like  upper('"+short_desc+"%')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(short_desc) like upper('"+short_desc+"%')");
			andCheck = 1;
		}
	}
	if ( !(gender_spec_ind_desc == null || gender_spec_ind_desc.equals("") || gender_spec_ind_desc.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(gender_spec_ind) =  upper('"+gender_spec_ind_desc+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(gender_spec_ind) = upper('"+gender_spec_ind_desc+"')");
			andCheck = 1;
		}
	}
	if ( !(age_spec_ind_desc == null || age_spec_ind_desc.equals("") || age_spec_ind_desc.equals("null")) )
	{		
		if ( andCheck == 1 )
		{	sql.append(" and ");
			if (age_spec_ind_desc.equals("O"))
				sql.append("nvl(age_spec_ind,'X') not in ('N', 'P', 'M', 'A')");
			else
				sql.append("upper(age_spec_ind) =  upper('"+age_spec_ind_desc+"')");
		}
		else
		{
			if (age_spec_ind_desc.equals("O"))
				sql.append( "where nvl(age_spec_ind,'X') not in ('N', 'P', 'M', 'A')") ;
			else{
				sql = new StringBuffer();
				sql.append("where upper(age_spec_ind) = upper('"+age_spec_ind_desc+"')");
			}
			andCheck = 1;
		}
	}
	if ( !(tab_list == null || tab_list.equals("") || tab_list.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(tab_list) like upper('"+tab_list+"'%)");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(tab_list) like upper('"+tab_list+"'%)");
			andCheck = 1;
		}
	}
	if ( !(sensitive_yn == null || sensitive_yn.equals("") || sensitive_yn.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(nvl(sensitive_yn,'N') ) = upper('"+sensitive_yn+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(nvl(sensitive_yn,'N') )   = upper('"+sensitive_yn+"')");
			andCheck = 1;
		}
	}
	if ( !(notifiable_yn == null || notifiable_yn.equals("") || notifiable_yn.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(nvl(notifiable_yn,'N') ) = upper('"+notifiable_yn+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(nvl(notifiable_yn,'N') )  = upper('"+notifiable_yn+"')");
			andCheck = 1;
		}
	}

	if ( !(diag_code_scheme_desc == null || diag_code_scheme_desc.equals("") || diag_code_scheme_desc.equals("null")) )
	{
	/*
ICD[2] - pro - 4
ICD[1] - pro - 1

ICD[2] - diag - 2
ICD[1] - diag - 1
		*/
		if ( andCheck == 1 )
		{	
			if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("1"))
				sql.append( " and diag_code_scheme = '1' ");
			//else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				//sql.append( " and diag_code_scheme = '4' ");
			else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				sql.append( " and diag_code_scheme = '2' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("1"))
				sql.append( " and diag_code_scheme = '1' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("2"))
				sql.append( " and diag_code_scheme = '4' ");
			else if(diag_code_scheme_desc.equals("2"))
				sql.append( " and diag_code_scheme in ('2','4')");
			else
				sql.append( " and upper(diag_code_scheme) = upper('"+diag_code_scheme_desc+"')");
		}
		else
		{
			sql = new StringBuffer();
			if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("1"))
				sql.append( " where diag_code_scheme = '1' ");
			//else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				//sql.append( " where diag_code_scheme = '4' ");
			else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				sql.append( " where diag_code_scheme = '2' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("1"))
				sql.append( " where diag_code_scheme = '1' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("2"))
				sql.append( " where diag_code_scheme = '4' ");
			else if(diag_code_scheme_desc.equals("2"))
				sql.append( " where diag_code_scheme in ('2','4')");
			else
				sql.append(" where upper(diag_code_scheme) = upper('"+diag_code_scheme_desc+"')");
			andCheck = 1;
		}
	}

	if ( !(code_ind == null || code_ind.equals("") || code_ind.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(CODE_INDICATOR) = upper('"+code_ind+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(CODE_INDICATOR) = upper('"+code_ind+"')");
			andCheck = 1;
		}
	}

		orderBy=" order by " + order_by;

} //end of where clause IF
else {
sql = new StringBuffer();
	sql.append(whereClause);
}

int start = 0 ;
int end = 0 ;
int i=1;

if ( from == null )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null )
	end = 6 ;
else
	end = Integer.parseInt( to ) ;


		Connection dbconn =null;

		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

try
{
	dbconn=ConnectionManager.getConnection(request);
	/*stmt = dbconn.createStatement();
	String strsql1="select count(1) as total from mr_icd_code "+sql.toString()+" "+orderBy;
	rs = stmt.executeQuery(strsql1);
	rs.next();
	maxRecord = rs.getInt("total");

	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");*/

	String strsql2="select diag_srl_no, DECODE(RECORD_TYPE,'D','Disease','O','Procedure',null) record_type_desc, "+
	" diag_code,short_desc,"+
	" decode(GENDER_SPEC_IND,'M','Male','F','Female','Common') gender_spec_ind_desc, decode(AGE_SPEC_IND ,'C','Common','N','Newborn','P','Pediatric','A','Adult','M','Maternity','Others') age_spec_ind_desc, "+
	" sensitive_yn,notifiable_yn,"+
	" decode(diag_code_scheme ,'1','ICD10','2','ICD9-CM','3','CPT4','4','ICD9-CM') diag_code_scheme_desc, "+
	" decode(CODE_INDICATOR ,'D','Dagger','E','External Cause','A','Asterik','C','Consequence') code_indicator, "+ 
	" CODE_INDICATOR code_ind, "+
	" eff_status from mr_icd_code "+ sql.toString()+" "+orderBy;

	//out.println(strsql2);

	stmt = dbconn.createStatement();
	rs = stmt.executeQuery(strsql2);

	if (start != 1)
	for( int j=1; j<start; i++,j++ ) 
	{
		rs.next() ;
	}

	while (i<=end && rs.next() )
	{
		if (maxRecord==0)
		{	%>

			<P>
			<table align='right'>
			<tr>
			<%
			if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/ICDCodeQueryResult.jsp?from="+(start-6)+"&to="+(end-6)+"&whereclause="+URLEncoder.encode(sql.toString())+"&orderBy="+URLEncoder.encode(orderBy)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			//if ( !( (start+6) > maxRecord ) )
				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ICDCodeQueryResult.jsp?from="+(start+6)+"&to="+(end+6)+"&whereclause="+URLEncoder.encode(sql.toString())+"&orderBy="+URLEncoder.encode(orderBy)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			%>
			</tr>
			</table>
			<br><br>
			</P>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eMR.ICDCodeType.label" bundle="${mr_labels}"/></th>
				<th><fmt:message key="Common.GenderSpecificInd.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eMR.AgeSpecificIndicator.label" bundle="${mr_labels}"/></th>
				<th><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
	<%	}
		/*if ( start != 1 )
		for( int j=1; j<start; i++,j++ ) {
		rs.next() ;
		}*/
		String classValue="";
		//while ( rs.next() && i<=end )
		//{
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		String d_diag_srl_no=rs.getString("diag_srl_no");
		String d_record_type_desc=rs.getString("record_type_desc");
		String d_diag_code=rs.getString("diag_code");
		String d_short_desc=rs.getString("short_desc");
		String d_gender_spec_ind_desc=rs.getString("gender_spec_ind_desc");
		String d_age_spec_ind_desc=rs.getString("age_spec_ind_desc");
		String d_sensitive_yn=rs.getString("sensitive_yn");
		String d_notifiable_yn=rs.getString("notifiable_yn");
		String d_diag_code_scheme_desc=rs.getString("diag_code_scheme_desc");
		String d_code_ind=rs.getString("code_indicator");
		String d_codeind=rs.getString("code_ind");
		String eff_status=rs.getString("eff_status");

		if (d_diag_srl_no == null || d_diag_srl_no.equals("null")) d_diag_srl_no="&nbsp;";
		if (d_record_type_desc == null || d_record_type_desc.equals("null")) d_record_type_desc="&nbsp;";
		if (d_diag_code == null || d_diag_code.equals("null")) d_diag_code="&nbsp;";
		if (d_code_ind == null || d_code_ind.equals("null")) d_code_ind="&nbsp;";
		if (d_short_desc == null || d_short_desc.equals("null")) d_short_desc="&nbsp;";
		if (d_gender_spec_ind_desc == null || d_gender_spec_ind_desc.equals("null")) d_gender_spec_ind_desc="&nbsp;";
		if (d_age_spec_ind_desc == null || d_age_spec_ind_desc.equals("null")) d_age_spec_ind_desc="&nbsp;";
		if (d_sensitive_yn == null || d_sensitive_yn.equals("null")) d_sensitive_yn="&nbsp;";
		if (d_notifiable_yn == null || d_notifiable_yn.equals("null"))
		d_notifiable_yn="&nbsp;";
		if (eff_status == null || eff_status.equals("null")) eff_status="&nbsp;";
		if (d_diag_code_scheme_desc == null || d_diag_code_scheme_desc.equals("null")) d_diag_code_scheme_desc="&nbsp;";

		out.println("<tr><td class='" + classValue + "'>");
		out.println("<a href=javascript:showModal('"+d_codeind+"','"+d_diag_srl_no+"','"+eff_status+"') </a>");
		out.println(d_diag_code+"</a></td><td class='" + classValue + "'>");
		out.println(d_short_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_diag_code_scheme_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_record_type_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_gender_spec_ind_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_age_spec_ind_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_code_ind);
		out.println("</td><td class='" + classValue + "' align='center' >");

		if (d_sensitive_yn.equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		out.println("&nbsp;");
		out.println("</td><td class='" + classValue + "' align='center' >");

		if (d_notifiable_yn.equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	
		out.println("&nbsp;");
		//out.println("</td></tr>");
		out.println("</td><td  class='" + classValue + "' align='center' >");

		i++;
		maxRecord++;
	}//endwhile

	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}

	if(maxRecord < 6 || (!rs.next()))
	{	%>
		<script>
			if(document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
		</script>
<% 	}
	else
	{	%>
		<script>
			if(document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
<%	}	%>
</table>
<br><center>
<%
	java.util.Enumeration eHISEnum = request.getParameterNames() ;
	while(eHISEnum.hasMoreElements())
	{
		 String name = (String)eHISEnum.nextElement() ;
		out.println("<input type='hidden' name=\""+request.getParameter(name)+"\" id=\""+request.getParameter(name)+"\">") ;
	}
}catch(Exception ce)
{
	//out.print("Exception @ "+ce.toString());
	ce.printStackTrace();
}
finally
{
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
ConnectionManager.returnConnection(dbconn,request);
}

%>

</center>
</form>
</BODY>
</HTML>
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

