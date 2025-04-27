<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	12 Jan 2005
--%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<head>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language="JavaScript" src="../../eMR/js/TerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
Connection con			= null;
Statement stmt			= null;
PreparedStatement psmt=null;
ResultSet rset			= null ;
ResultSet rset1			= null ;
String cd_lvl			= request.getParameter("codelevel");
if(cd_lvl==null || cd_lvl.equals("")) cd_lvl="1";
int code_level			= Integer.parseInt(cd_lvl);
String className		= request.getParameter("className");
if(className==null) className = "";
String classValue		= "";
String termsetid		= request.getParameter("termsetid");
String diag_spec_yn		= request.getParameter("diag_spec_yn");
String proc_spec_yn		= request.getParameter("proc_spec_yn");
String termdescription	= request.getParameter("termdesc");
String search_criteria	= request.getParameter("search_criteria");
String search_text		= request.getParameter("search_text");
String termcode			= request.getParameter("termcode");
String termcode1		= request.getParameter("termcode");
String search_flag		= request.getParameter("search_flag");
String last_reloded_from	= checkForNull(request.getParameter("last_reloded_from"));
String termdescription_new	= "";

String whereclause		= "";
//String cntSql = "";
String sqltermcoderesult	= "";
String desc				= "";
String defnlevelSql		= "";
String from				= request.getParameter("from") ;
String to				= request.getParameter("to") ;
//String classificationDescriptionLink = "";


if(termcode==null) termcode = "";
if(termcode1==null) termcode1 = "";
if(termsetid==null) termsetid = "";
if(code_level==1)
	termcode			= "";
if((termdescription==null)||(termdescription.equals("All"))) termdescription="";
termdescription_new=termdescription;
if(search_criteria==null) search_criteria="";
if(search_text==null) search_text="";
if(search_flag==null) search_flag="";


try
	{
		con				= ConnectionManager.getConnection(request);
		from			= request.getParameter("from") ;
		to				= request.getParameter("to") ;

		if(search_flag.equals("C"))
		{
			//search_criteria="C"; commented by S.Sathish for IN021712 on Tuesday, June 01, 2010
			termdescription = "";
		}

		if(!search_text.equals(""))
		{
			
			termdescription = search_text;
		}
		if(search_criteria.equals("S") && termdescription_new !="")
		{
			if(termdescription_new.equals("OT")){
				 whereclause = "upper(short_desc) like '"+termdescription + "%' and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
			}
			else{

		    whereclause = "upper(short_desc) like '"+termdescription + "%' AND upper(short_desc) like '"+termdescription_new+"%'";	
			}
		}
		else if(search_criteria.equals("E") && termdescription_new !="")
		{

			if(termdescription_new.equals("OT")){
				 whereclause ="upper(short_desc) like '%" + termdescription +"' and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
			}
			else{
			whereclause = "upper(short_desc) like '%" + termdescription +"' AND upper(short_desc) like '"+termdescription_new+"%'";
			}
		}
		else if(search_criteria.equals("C") && termdescription_new !="")
		{

			if(termdescription_new.equals("OT")){
				 whereclause ="upper(short_desc) like '%"+ termdescription + "%' and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
			}
			else{
			whereclause = "upper(short_desc) like '%"+ termdescription + "%' AND upper(short_desc) like '"+termdescription_new+"%'";
			}
		}         
		else if(search_criteria.equals("S"))
		{
			whereclause = "upper(short_desc) like '"+termdescription + "%'";
		}
		else if(search_criteria.equals("E"))
		{
			whereclause =  "upper(short_desc) like '%" + termdescription +"'";
		}
		else if(search_criteria.equals("C"))
		{
			whereclause = "upper(short_desc) like '%"+ termdescription + "%'";
		}
		else
		{
			whereclause = "upper(short_desc) like '"+termdescription + "%'";
		}
		if(termdescription.equals("OT"))
		{
			
			whereclause = "(UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
		}
		
		int maxRecord	= 0;
		int start		= 0 ;
		int end			= 0 ;
		int i			= 1;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
		i				= 1;
		/*if(termcode.equals(""))
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"order by short_desc";
		}
		else
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+" order by short_desc";
		}
		stmt=con.createStatement();
		rset1 = stmt.executeQuery(cntSql);
		if(rset1!=null)
		{
			if(rset1.next())
			{
				maxRecord = rset1.getInt(1);
			}
			if(rset1!=null) rset1.close();
			if(stmt!=null) stmt.close();
		}*/

		if(code_level==1)
		{
			defnlevelSql	= "select level_1_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==2)
		{
			defnlevelSql	= "select level_2_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==3)
		{
			defnlevelSql	= "select level_3_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==4)
		{
			defnlevelSql	= "select level_4_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==5)
		{
			defnlevelSql	= "select level_5_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==6)
		{
			defnlevelSql	= "select level_6_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==7)
		{
			defnlevelSql	= "select level_7_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==8)
		{
			defnlevelSql	= "select level_8_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==9)
		{
			defnlevelSql	= "select level_9_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==10)
		{
			defnlevelSql	= "select level_10_desc from mr_term_set where term_set_id=?";
		}
		//stmt				= con.createStatement();
		psmt = con.prepareStatement(defnlevelSql);
		psmt.setString(1,termsetid);
		rset1				= psmt.executeQuery();

		
		if(rset1!=null)
		{
			if(rset1.next())
			{
				desc = rset1.getString(1);
				if(rset1!=null) rset1.close();
				if(psmt!=null) psmt.close();
			}
		}
%>
<script>
function submitPrevNext(from, to)
{
		document.term_code_result.from.value	= from;
	    document.term_code_result.to.value		= to; 
	    var termcode		= document.term_code_result.termcode.value; 
	    var termcode1		= document.term_code_result.termcode1.value; 
	    var termsetid		= document.term_code_result.termsetid.value; 
	    codelevel			= document.term_code_result.codelevel.value; 
	    var search_text		= document.term_code_result.search_text.value; 
		var search_criteria = document.term_code_result.search_criteria.value;
		var search_flag		= document.term_code_result.search_flag.value;
		var last_reloded_from	= document.term_code_result.last_reloded_from.value;
		var termdescription	=document.term_code_result.termdescription.value;
		var alphalink		= "";
		/*if(search_flag!='C'){
			alphalink=parent.frames[2].document.getElementById("alphalink").value;
		}*/
		/*
			The Above code was commented on 10/26/2010 for the issue IN024671  Issue 1
			The following code was modified.
		*/
		 if( last_reloded_from=="L"){
				alphalink	= parent.frames[2].document.getElementById("alphalink").value;
		}else{
				alphalink	= '';
		}
		parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+alphalink+"&termcode="+termcode1+"&termsetid="+termsetid+"&codelevel="+codelevel+"&from="+from+"&to="+to+"&search_text="+search_text+"&search_flag="+search_flag+"&search_criteria="+search_criteria+"&diag_spec_yn=<%=diag_spec_yn%>&proc_spec_yn=<%=proc_spec_yn%>&last_reloded_from="+last_reloded_from+"";

}

function call(termcode,termdesc)
{
	var termsetid			= document.term_code_result.termsetid.value; 
	var className			= "";
	document.term_code_result.className.value	= "";
	parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.class_lvl.value	= parent.f_term_result_header.document.term_code_result_header.class_lvl.value;
	parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value	= "";
	parent.f_term_result_header.document.term_code_result_header.className.value			= "";
	parent.f_term_add_modify.document.term_code_addmodify.mode.value						= "";
	var codelvl				= eval(document.term_code_result.codelevel.value); 
	cdlvl					= eval(parent.f_term_code_set.document.forms[0].dyanmic_level.value)+1;
	codelevel				= codelvl + 1;

	if(cdlvl!=codelevel)
	{
		if(codelevel==2)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode2.value = termcode;
		}
		else if(codelevel==3)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode3.value = termcode;
		}
		else if(codelevel==4)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode4.value = termcode;
		}
		else if(codelevel==5)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode5.value = termcode;
		}
		else if(codelevel==6)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode6.value = termcode;
		}
		else if(codelevel==7)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode7.value = termcode;
		}
		else if(codelevel==8)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode8.value = termcode;
		}
		else if(codelevel==9)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode9.value = termcode;
		}
		else if(codelevel==10)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode10.value = termcode;
		}
		parent.f_term_add_modify.document.term_code_addmodify.term_code.value		= "";
		parent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly	= false;
		parent.f_term_add_modify.document.term_code_addmodify.short_desc.value		= "";
		parent.f_term_add_modify.document.term_code_addmodify.long_desc.value		= "";
		parent.f_term_add_modify.document.term_code_addmodify.eff_status.checked	= true;
		parent.f_term_add_modify.document.term_code_addmodify.selectable.checked	= false;
		parent.f_term_add_modify.document.term_code_addmodify.selectable.disabled	= false;
		parent.f_term_add_modify.document.term_code_addmodify.proc_diag.value		= "";
		parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.f_term_add_modify.document.term_code_addmodify.termsetid.value		= termsetid;
		parent.f_term_add_modify.document.term_code_addmodify.codelevel.value		= codelevel;
		parent.f_term_add_modify.document.term_code_addmodify.termcode.value		= termcode;
		// This part dynamic rows are generated for final frame selected value based on click of result page.
 		var rowvar		= parent.f_term_selected_frms.f_term_selected_values.document.getElementById("tableId").insertRow();
		var cellvar		= rowvar.insertCell();
		termdesc		=  unescape(termdesc);
		for(var i= 0 ; i < termdesc.length;i++){
			termdesc = 	termdesc.replace('|',' ');
		}
		/*
			Modified On 10/26/2010 for the issue IN024671 Issue 2
		*/
		while(termdesc.indexOf("$")!=-1){
			termdesc	= termdesc.replace('$' ,"'");
		}
		cellvar.insertAdjacentHTML("beforeend",termdesc);
		if(codelevel%2==0)
		{
			cellvar.className = 'QRYEVEN';
		}
		else
		{
			cellvar.className = 'QRYODD';
		}
		// End of dynamic rows creation.
		if(codelevel==(cdlvl-1))
		{
			className		  = "className";
			document.term_code_result.className.value = "className";
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value = "className";
			parent.f_term_result_header.document.term_code_result_header.className.value = "className";
		}
		parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&codelevel="+codelevel+"&className="+className+"&diag_spec_yn=<%=diag_spec_yn%>&proc_spec_yn=<%=proc_spec_yn%>&last_reloded_from=DES";
		var htmlvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_value' id='dynamic_value' method='post' action='../../eMR/jsp/TerminologyCodeDynamicValues.jsp'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='codelevel' id='codelevel' value='"+codelevel+"'><input type='hidden' name='termcode' id='termcode' value='"+termcode+"'></form></body></html>"
		parent.blankFrame.document.write(htmlvalue);
		parent.blankFrame.document.dynamic_value.submit();
	}
	else
	{
		
		// This part dynamic rows are generated for final frame seleted value based on click of result page last level.
		if(document.forms[0].last_level.value=="")
		{
			var rowvar = parent.f_term_selected_frms.f_term_selected_values.document.getElementById("tableId").insertRow();
			var cellvar = rowvar.insertCell();
			termdesc    =  unescape(termdesc);
			
			for(var i= 0 ; i < termdesc.length;i++)
			{
				termdesc = 	termdesc.replace('|',' ');
			}		
			/*Wednesday, February 23, 2011 , SRR20056-SCF-6970 [IN:026635] issue 2 */
			while(termdesc.indexOf("$")!=-1){
				termdesc=termdesc.replace('$' ,"'");
			}
			/**/
			cellvar.insertAdjacentHTML("beforeend",termdesc);
			if(codelevel%2==0)
			{
				cellvar.className='QRYEVEN';
			}
			else
			{
				cellvar.className='QRYODD';
			}
			document.forms[0].last_level.value = "lastlevel";
		}
		// End of dynamic rows creation at last level.
	
	}

	 
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}	
function addmod(mode,termcode)
{
	var termsetid = document.term_code_result.termsetid.value; 
	var codelevel = document.term_code_result.codelevel.value; 
	if(document.term_code_result.className.value == "className")
		className = "className";
	else
		className = "";
	
	parent.f_term_add_modify.location.href="../../eMR/jsp/TerminologyCodeAddModify.jsp?termcode="+termcode+"&mode="+mode+"&termsetid="+termsetid+"&codelevel="+codelevel+"&className="+className+"";
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'> 
<FORM METHOD='POST' name='term_code_result' id='term_code_result'>
<% 
	if (maxRecord==0)
		{%>
			<table width='95%'>
			<tr>
			<table align='right'>
			<tr>
<!--<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>-->
<%
			if ( !(start <= 1))
			{
				//out.println("<td align ='right' id='prev'  class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-11)+","+(end-11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
				/*Tuesday, February 22, 2011 , modified for SRR20056-SCF-6970 [IN:026635] issue 1*/
				out.println("<td align ='right' id='prev'  class='BODYCOLORFILLED'><a href='../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+termdescription+"&termcode="+termcode1+"&termsetid="+termsetid+"&codelevel="+code_level+"&from="+(start-11)+"&to="+(end-11)+"&search_text="+search_text+"&search_flag="+search_flag+"&search_criteria="+search_criteria+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"&last_reloded_from="+last_reloded_from+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
			}
			//if ( !((start+11) > maxRecord ))
			//{

				//out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+11)+","+(end+11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
				/*Tuesday, February 22, 2011 , modified for SRR20056-SCF-6970 [IN:026635] issue 1*/
				out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+termdescription+"&termcode="+termcode1+"&termsetid="+termsetid+"&codelevel="+code_level+"&from="+(start+11)+"&to="+(end+11)+"&search_text="+search_text+"&search_flag="+search_flag+"&search_criteria="+search_criteria+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"&last_reloded_from="+last_reloded_from+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
			//}
%>
			</tr>
			</table >
			</tr>
			</table>
			<br>
			<br>
<%
		}		
	%>
			<table border='1' cellpadding='0' cellspacing='0' align='center'  width='95%' >
<%
	
			if(termcode.equals(""))
			{
				sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and (diagnosis_yn='"+diag_spec_yn+"' or procedure_yn='"+proc_spec_yn+"' ) order by short_desc";
			}
			else
			{
				//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+" order by short_desc";

				sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code ='"+termcode+"' and code_level="+code_level+" and (diagnosis_yn='"+diag_spec_yn+"' or procedure_yn='"+proc_spec_yn+"' ) order by short_desc";
			}
			stmt = con.createStatement();
			rset=null;
			rset=stmt.executeQuery(sqltermcoderesult);
			String tempString  = "";
			String classValmod = "";
			
		       if ( start != 0 )
				{
					for( int j=1; j<start; i++,j++ )
					{
						rset.next() ;
					}
				}
			

				boolean isRecordFound = false;
				//while(rset.next() && i<=end )
				while( i<=end  && rset.next())
				{
                   	if(!isRecordFound)
					{
						isRecordFound = true;
                      %><tr>
							<td class="COLUMNHEADER"><%=desc%></td>
							<td class="COLUMNHEADER"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER"></td></tr>
						<%
					}
/*				if(className.equals(""))
			{
				if((i%2) == 1)
				{
					classValue = "QRYODD";
					classValmod = "QRYODD";
				}
				else
				{
					classValue ="QRYEVEN";
					classValmod = "QRYEVEN";
				}
			}
			else
*/
					if((i%2) == 1)
					{
						classValue = "QRYODD";
						classValmod = "QRYODD";
					}
					else
					{
						classValue ="QRYEVEN";
						classValmod = "QRYEVEN";
					}
					out.println("<tr>");
					tempString=rset.getString("short_desc");
					tempString = tempString.replace(' ','|');
					tempString = tempString;
					tempString =tempString.replace("'", "$");//	Modified On 10/26/2010 for the issue IN024671 Issue 2
					termcode   = rset.getString("term_code");
					String status = rset.getString("eff_status");
					if(status.equals("E"))
						status = "&nbsp;";
					else if(status.equals("D"))
						status = "D";

					//classificationDescriptionLink = "call('"+termcode+"','"+tempString+"')";

					//out.println("<td class='"+classValue+"' width='75%' onclick="+classificationDescriptionLink+"; >"+rset.getString("short_desc")+"</td>");



					%>	
					<td class='<%=classValue%>' width='75%'><a href='javascript:call("<%=termcode%>","<%=tempString%>")'><%=rset.getString("short_desc")%></a></td>
					<td class='<%=classValue%>' width='5%'><%=status%></td>
					<td class='<%=classValue%>' width='7%'> <a href='javascript:addmod("Modify","<%=termcode%>")'><fmt:message key="Common.Modify.label" bundle="${common_labels}"/></a></td>
					</tr>
				  <%			
					i++;
					maxRecord++;
				}
				
				if ( maxRecord < 11 || (!rset.next()) )
					{
						%>
						<script >
							if (document.getElementById("next"))
								document.getElementById("next").style.visibility='hidden';
						</script>
						<% 
					}
					else
					{%>
						<script >
							if (document.getElementById("next"))
								document.getElementById("next").style.visibility='visible';
						</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

					<%
					}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
           
	if(isRecordFound==false)
		{
		     out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			 //out.println("<script>parent.frames[2].document.forms[0].search_text.value='';</script>");
			 out.println("<script>parent.frames[4].frames[1].document.location.reload();</script>");
		}
	
%>	
	</table>
<INPUT TYPE="hidden" name="termsetid" id="termsetid" value="<%=termsetid%>">
<INPUT TYPE="hidden" name="termcode" id="termcode" value="<%=termcode%>">
<INPUT TYPE="hidden" name="termcode1" id="termcode1" value="<%=termcode1%>">
<INPUT TYPE="hidden" name="codelevel" id="codelevel" value="<%=code_level%>">
<INPUT type="hidden" name="from" id="from" value="<%=start%>">
<INPUT type="hidden" name="to" id="to" value="<%=end%>">
<INPUT type="hidden" name="start" id="start" value="<%=start%>">
<INPUT type="hidden" name="end" id="end" value="<%=end%>">
<INPUT TYPE="hidden" name="desc" id="desc" value="">
<INPUT TYPE="hidden" name='className' id='className' value='<%=className%>'>	
<INPUT TYPE="hidden" name='last_level' id='last_level' value=''>
<INPUT TYPE="hidden" name='search_text' id='search_text' value='<%=search_text%>'>
<INPUT TYPE="hidden" name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>
<INPUT TYPE="hidden" name='search_flag' id='search_flag' value='<%=search_flag%>'>
<INPUT TYPE="hidden" name='last_reloded_from' id='last_reloded_from' value='<%=last_reloded_from%>'>
<INPUT TYPE="hidden" name='termdescription' id='termdescription' value='<%=termdescription%>'>

<%	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</form>
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

