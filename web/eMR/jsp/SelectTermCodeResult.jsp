
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	07 Feb 2005
--%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");%> 
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 
%>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language="JavaScript" src="../../eMR/js/TerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt=null;
ResultSet rset=null ;
ResultSet rset1=null ;
String cd_lvl = request.getParameter("codelevel");
if(cd_lvl==null) cd_lvl="1";
int code_level = Integer.parseInt(cd_lvl);
String className= request.getParameter("className");
if(className==null) className = "";
String classValue = "";
String termsetid = request.getParameter("termsetid");
String termdescription = request.getParameter("termdesc");
String search_criteria = request.getParameter("search_criteria");
String search_text = request.getParameter("search_text");
String termcode = request.getParameter("termcode");
String termcode1 = request.getParameter("termcode");
String whereclause = "";
String cntSql = "";
String sqltermcoderesult = "";
String part_term_code=request.getParameter("termcode");
//String  req_start= "";
//String req_end = "";
//String select_yn = "";
String desc = "";
String defnlevelSql = "";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
if(termcode==null) termcode="";
if(termcode1==null) termcode1="";
if(termsetid==null) termsetid="";
if(code_level==1)
	termcode = "";
if((termdescription==null)||(termdescription.equals("All"))) termdescription="";
if(search_criteria==null) search_criteria="";
if(search_text==null) search_text="";
try
	{
		con = ConnectionManager.getConnection(request);
		from = request.getParameter("from") ;
		to = request.getParameter("to") ;
		if(!search_text.equals(""))
		{
			termdescription = search_text;
		}
		if(search_criteria.equals("S"))
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
		
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
		//req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
		//req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
		i = 1;
//out.println("<script>alert(\""+termcode+"\");</script>");
		if(termcode.equals(""))
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		}
		else
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code like'"+termcode+"%' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		}
/*Friday, January 22, 2010 , 18379 , added diagnosis_yn = 'Y' since procedure code also getting listed for Record Diagnosis */
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
		}
		if(code_level==1)
		{
			defnlevelSql = "select level_1_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==2)
		{
			defnlevelSql = "select level_2_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==3)
		{
			defnlevelSql = "select level_3_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==4)
		{
			defnlevelSql = "select level_4_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==5)
		{
			defnlevelSql = "select level_5_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==6)
		{
			defnlevelSql = "select level_6_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==7)
		{
			defnlevelSql = "select level_7_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==8)
		{
			defnlevelSql = "select level_8_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==9)
		{
			defnlevelSql = "select level_9_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==10)
		{
			defnlevelSql = "select level_10_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		stmt=con.createStatement();
		rset1 = stmt.executeQuery(defnlevelSql);
		if(rset1!=null)
		{
			if(rset1.next())
			{
				desc = rset1.getString(1);
				if(rset1!=null) rset1.close();
				if(stmt!=null) stmt.close();
			}
		}
%>
<script>
function submitPrevNext(from, to)
{
		document.term_code_result.from.value = from;
	    document.term_code_result.to.value = to; 
	   // var termcode = document.term_code_result.termsetid.value; 
	    var termcode = document.term_code_result.part_term_code.value; 
	    var termsetid = document.term_code_result.termsetid.value; 
	    var termdesc = document.term_code_result.termdesc.value; 
	    var search_criteria = document.term_code_result.search_criteria.value; 
	    codelevel = document.term_code_result.codelevel.value; 

		parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&codelevel="+codelevel+"&from="+from+"&to="+to+"&termdesc="+termdesc+"&search_criteria="+search_criteria;
}
function call(termcode,termdesc,select_yn)
{
	parent.f_sel_term_buttons.document.sel_term_code_button.termcode.value = termcode;
	parent.f_sel_term_buttons.document.sel_term_code_button.select_yn.value = select_yn;
	var termsetid = document.term_code_result.termsetid.value; 
	var className = "";
	var codelvl = eval(document.term_code_result.codelevel.value); 
	cdlvl = eval(parent.f_term_result_header.document.term_code_result_header.defn_levels.value)+1;
	codelevel = codelvl + 1;
	if(cdlvl!=codelevel)
	{
		if(codelevel==2)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode2.value=termcode;
		}
		else if(codelevel==3)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode3.value=termcode;
		}
		else if(codelevel==4)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode4.value=termcode;
		}
		else if(codelevel==5)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode5.value=termcode;
		}
		else if(codelevel==6)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode6.value=termcode;
		}
		else if(codelevel==7)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode7.value=termcode;
		}
		else if(codelevel==8)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode8.value=termcode;
		}
		else if(codelevel==9)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode9.value=termcode;
		}
		else if(codelevel==10)
		{	
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode10.value=termcode;
		}
		parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		// This part dynamic rows are generated for final frame seleted value based on click of result page.
 		var rowvar = parent.f_term_selected_frms.f_term_selected_value.document.getElementById("tableId").insertRow();
		var cellvar = rowvar.insertCell();
		cellvar.style.color = "#0000EE";
		for(var i= 0 ; i < termdesc.length;i++)
		{
			termdesc = 	termdesc.replace('|',' ');
		}

		for(var i= 0 ; i < termdesc.length;i++)
		{
			termdesc = 	termdesc.replace('$',"'");
		}
		cellvar.insertAdjacentHTML("beforeend",termdesc);
		if(codelevel%2==0)
		{
			cellvar.className='ATCQRYEVEN';
		}
		else
		{
			cellvar.className='ATCQRYODD';
		}
		// End of dynamic rows creation.
		if(codelevel==(cdlvl-1))
		{
			className = "className"
		}
		parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&codelevel="+codelevel+"&className="+className+"";
		
		var htmlvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_value' id='dynamic_value' method='post' action='../../eMR/jsp/SelectTermCodeDynamicValues.jsp'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='codelevel' id='codelevel' value='"+codelevel+"'><input type='hidden' name='termcode' id='termcode' value='"+termcode+"'></form></body></html>"
		parent.blankFrame.document.write(htmlvalue);
		parent.blankFrame.document.dynamic_value.submit();
	}
	else
	{
		// This part dynamic rows are generated for final frame seleted value based on click of result page last level.
		if(document.forms[0].last_level.value=="")
		{
			var rowvar = parent.f_term_selected_frms.f_term_selected_value.document.getElementById("tableId").insertRow();
			var cellvar = rowvar.insertCell();
			cellvar.style.color = "#0000EE";
			for(var i= 0 ; i < termdesc.length;i++)
			{
				termdesc = 	termdesc.replace('|',' ');
			}

			for(var i= 0 ; i < termdesc.length;i++)
			{
				termdesc = 	termdesc.replace('$',"'");
			}
			cellvar.insertAdjacentHTML("beforeend",termdesc);
			if(codelevel%2==0)
			{
				cellvar.className='ATCQRYEVEN';
			}
			else
			{
				cellvar.className='ATCQRYODD';
			}
			document.forms[0].last_level.value = "lastlevel";
		}
		// End of dynamic rows creation at last level.
	}
}	
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'> 
<FORM METHOD='POST' name='term_code_result' id='term_code_result' target='blankFrame' ACTION="">
<table width='95%'>
<tr>
<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
<%

	if ( !(start <= 1)){

		out.println("<a href='javascript:submitPrevNext("+(start-11)+","+(end-11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");

	}

	if ( !((start+11) > maxRecord )){

		out.println("<a href='javascript:submitPrevNext("+(start+11)+","+(end+11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");


	
	}
%>
</td>
</tr>
</table>

<table border='1' cellpadding='0' cellspacing='0' align='center'  width='95%' >
<%
	if(termcode.equals("")){
						/*
							The following query was modified for IN023648.
							Modified On:10/13/2010
						*/

//		sqltermcoderesult="select term_code,short_desc,select_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		sqltermcoderesult="select term_code,short_desc,select_yn from mr_d_"+termsetid+"_lang_vw where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and diagnosis_yn = 'Y' and language_id='"+locale+"' order by short_desc";
	}else{
//		sqltermcoderesult="select term_code,short_desc,select_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code like '"+termcode+"%' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		sqltermcoderesult="select term_code,short_desc,select_yn from mr_d_"+termsetid+"_lang_vw where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code like '"+termcode+"%' and code_level="+code_level+" and diagnosis_yn = 'Y' and language_id='"+locale+"' order by short_desc";

	}
	/*Friday, January 22, 2010 , 18379 , added diagnosis_yn = 'Y' since procedure code also getting listed for Record Diagnosis */
	//out.println(sqltermcoderesult);
	stmt = con.createStatement();
	rset=stmt.executeQuery(sqltermcoderesult);
	
	String tempString ="";
	String test = "";
	if(maxRecord!=0){%>
		<th align='left'><%=desc%></th>
	<%
		if(rset!=null){
			if ( start != 0 ){
				for( int j=1; j<start; i++,j++ )
				{
					rset.next() ;
				}
			}
			while(rset.next() && i<=end ){
				tempString=rset.getString("short_desc");
				tempString = tempString.replace(' ','|');	
				tempString = tempString.replace('\'','$');
				//if(rset.getString("SELECT_YN").equals("Y"))
				if((i%2) == 1)
					classValue = "ATCQRYODD";
				else
					classValue ="ATCQRYEVEN";
				test = "call('"+rset.getString("term_code")+"','"+tempString+"','"+rset.getString("SELECT_YN")+"')";
				out.println("<tr>");
					termcode = rset.getString("term_code");
					out.println("<td style='color: #0000EE;' class='"+classValue+"' width='75%' onclick="+test+"; >"+rset.getString("short_desc")+"</td>");
				out.println("</tr>");
				i++;
			}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	}else{
			out.println("<script>;alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
%>	
	</table>
<INPUT TYPE="hidden" name="termsetid" id="termsetid" value="<%=termsetid%>">
<INPUT TYPE="hidden" name="termcode" id="termcode" value="<%=termcode%>">
<INPUT TYPE="hidden" name="termcode1" id="termcode1" value="<%=termcode1%>">
<INPUT TYPE="hidden" name="codelevel" id="codelevel" value="<%=code_level%>">
<INPUT type=hidden name="from" id="from" value="<%=start%>">
<INPUT type=hidden name="to" id="to" value="<%=end%>">
<INPUT type=hidden name="start" id="start" value="<%=start%>">
<INPUT type=hidden name="end" id="end" value="<%=end%>">
<INPUT TYPE="hidden" name='desc' id='desc' value=''>
<INPUT TYPE="hidden" name='last_level' id='last_level' value=''>
<INPUT TYPE="hidden" name='part_term_code' id='part_term_code' value='<%=part_term_code%>'>
<INPUT TYPE="hidden" name='termdesc' id='termdesc' value='<%=termdescription%>'>
<INPUT TYPE="hidden" name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>
	
<%	}
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

