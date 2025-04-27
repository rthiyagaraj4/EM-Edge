<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Created By		:	Bangarraju
*	Created On		:	10 Jan 2007
--%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<head>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eMR/js/EquivalentTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	Statement stmt=null;
	ResultSet rset=null ;
//	ResultSet rset1=null ;
	ResultSet rs_c = null;
	Statement st_c = null;
	PreparedStatement psmt=null;
	String cd_lvl = request.getParameter("codelevel");
	if(cd_lvl==null||cd_lvl.equals("")) cd_lvl="1";
	int code_level = Integer.parseInt(cd_lvl);
	String className= request.getParameter("className");
	if(className==null) className = "";
	String classValue = "";
	String status="";
	String termsetid="";
	String type_set = "";
	
	String alphalink = request.getParameter("alphalink")==null?"All":request.getParameter("alphalink"); 

	

	String status1 =request.getParameter("status")==null?"N":request.getParameter("status");
	termsetid = checkForNull(request.getParameter("termsetid"));



	String Terminology = checkForNull(request.getParameter("Terminology"));
	String termset_id = checkForNull(request.getParameter("termset_id"));
	type_set = checkForNull(request.getParameter("type_set"));
	String termcode_text = checkForNull(request.getParameter("termcode_text"));

	String FirstConbox=Terminology;
	String SecondValue=termset_id;
	String ThirdConbox=termsetid;
	String termdescription = request.getParameter("termdesc")==null?"":request.getParameter("termdesc");
	String search_criteria = checkForNull(request.getParameter("search_criteria"));
	String search_text = checkForNull(request.getParameter("search_text"));

	String callres = checkForNull(request.getParameter("callres"));
	String codeResult = checkForNull(request.getParameter("codeResult"));

	String termcode = checkForNull(request.getParameter("termcode"));
	String termcode1 = checkForNull(request.getParameter("termcode"));


	String mr_term_set=request.getParameter("mr_term_set")==null?"":request.getParameter("mr_term_set");


	String chked_factor = "";
	String factor_val = "";
	ArrayList ListAll= new ArrayList();
	
	HashMap ListValues= new HashMap();
	String whereclause = "";
	
	String sqltermcoderesult = "";
//	String desc = "";
//	String defnlevelSql = "";
	String from = checkForNull(request.getParameter("from") );
	String to = checkForNull(request.getParameter("to") );
	String termset_desc="";
	String eff_status="";
	
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
			whereclause = "upper(short_desc) like upper('"+termdescription + "%')";
		}
		else if(search_criteria.equals("E"))
		{
			whereclause =  "upper(short_desc) like  upper('%" + termdescription +"')";
		}
		else if(search_criteria.equals("C"))
		{
			whereclause = "upper(short_desc) like  upper('%"+ termdescription + "%')";
		}
		else
		{
			whereclause = "upper(short_desc) like  upper('"+termdescription + "%')";
		}
	
		if(termdescription.equals("OT"))
		{
			whereclause = whereclause +" and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
		}


		if(!type_set.equals(""))
		{
			if(type_set.equals("DA")){
				whereclause = whereclause +" and cross_ref_type like '%D' and diagnosis_yn = 'Y'";
			}else if(type_set.equals("CO")){
				whereclause = whereclause +" and cross_ref_type like '%C' and diagnosis_yn = 'Y'";
			}else if(type_set.equals("EQ")){
				//whereclause = whereclause +" and cross_ref_type is NULL";
			}else if(type_set.equals("AS")){
				/*Wednesday, January 27, 2010 , modified for SRR20056-CRF-0303.2 [IN:015597] to list dagger dependent Astrisk Codes */
				//whereclause = "cross_ref_type like '%A'";
					whereclause = whereclause +" and cross_ref_type like '%A' ";
			}else if(type_set.equals("EC")){
				whereclause = whereclause +" and cross_ref_type like '%E'";
			}
		}
		if(!termcode_text.equals(""))
		{
			whereclause= whereclause +" and upper(term_code) like '"+termcode_text + "%'";
		}


		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;
		int start_check = 1;
		int end_check = 0;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 7 ; }   else {  end = Integer.parseInt( to ) ; }
		i = 1;
		/*String cntSql="";
		if(termcode.equals(""))
		{
			if(alphalink.equals("All")){
			cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" order by short_desc";
	        }
			else if (alphalink.equals("OT"))	{

			 cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";
	  
	          }
			else {
			cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and UPPER (short_desc) like '"+alphalink+"%' order by short_desc";
	   
	      }
		}
		else
		{
			cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+"order by short_desc";
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
		} */

		/*if(code_level==1)
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

		*/ // the entire block commented on 1-4-2010 as the variable desc was noot used any where..
		
%>
<script>
function submitPrevNext(from, to,obj)
{       

		var alphalink=document.term_code_result.alphalink.value;
	    document.term_code_result.from.value = from;
	    document.term_code_result.to.value = to; 
	    var termcode = document.term_code_result.termsetid.value;
		var termdescription = document.term_code_result.termdesc.value;
	    var termsetid = document.term_code_result.termsetid.value; 
		var search_criteria = document.term_code_result.search_criteria.value;
	    codelevel = document.term_code_result.codelevel.value;
		var FirstConbox = document.term_code_result.FirstConbox.value;
		var SecondValue = document.term_code_result.SecondValue.value;
		var ThirdConbox = document.term_code_result.ThirdConbox.value;
		var type_set    = document.term_code_result.type_set.value;
		
	
		if(document.term_code_result.mr_term_set.value=='N')
	    {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			//if(confirm('Do you want to submit the current page'))
			if(confirm(getMessage('SUBMIT_CURR_PAGE','MR')))
			{					
				parent.f_batch_result.document.term_code_result.action = "../../servlet/eMR.EquivalentTermCodeServlet?msg=n&obj="+obj+"&type_set="+type_set;
				parent.f_batch_result.document.term_code_result.target = "messageFrame";
				parent.f_batch_result.document.term_code_result.submit();
				
			}	
			var search_text=parent.f_query_criteria.document.forms[0].search_text.value;
		     	parent.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?search_text="+search_text+"&termcode="+termcode+"&termsetid="+termsetid+"&termdesc="+termdescription+"&codelevel="+codelevel+"&search_criteria="+search_criteria+"&from="+from+"&to="+to+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&ThirdConbox="+ThirdConbox+"&alphalink="+alphalink+"&type_set="+type_set+"&mr_term_set=N";
			
		} 
		else
		{  
			 parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";   
			parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&termdesc="+termdescription+"&codelevel="+codelevel+"&search_criteria="+search_criteria+"&alphalink="+alphalink+"&from="+from+"&to="+to+"&type_set="+type_set;
			parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
			
		}


}

function call(termcode,termdesc)
{
	var termsetid = document.term_code_result.termsetid.value; 
	var className = "";
	document.term_code_result.className.value = "";
	parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.class_lvl.value = parent.f_term_result_header.document.term_code_result_header.class_lvl.value;
	parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value = "";
	parent.f_term_result_header.document.term_code_result_header.className.value = "";
	parent.f_term_add_modify.document.term_code_addmodify.mode.value="";
	var codelvl = eval(document.term_code_result.codelevel.value); 
	cdlvl = eval(parent.f_term_code_set.document.forms[0].dyanmic_level.value)+1;
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
		parent.f_term_add_modify.document.term_code_addmodify.term_code.value="";
		parent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly=false;
		parent.f_term_add_modify.document.term_code_addmodify.short_desc.value="";
		parent.f_term_add_modify.document.term_code_addmodify.long_desc.value="";
		parent.f_term_add_modify.document.term_code_addmodify.eff_status.checked=true;
		parent.f_term_add_modify.document.term_code_addmodify.selectable.checked=false;
		parent.f_term_add_modify.document.term_code_addmodify.selectable.disabled=false;
		parent.f_term_add_modify.document.term_code_addmodify.proc_diag.value="";
		parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.f_term_add_modify.document.term_code_addmodify.termsetid.value = termsetid;
		parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		// This part dynamic rows are generated for final frame selected value based on click of result page.
 		var rowvar = parent.f_term_selected_frms.f_term_selected_values.document.getElementById("tableId").insertRow();
		var cellvar = rowvar.insertCell();
		termdesc    =  unescape(termdesc);
		for(var i= 0 ; i < termdesc.length;i++)
		{
			termdesc = 	termdesc.replace('|',' ');
		}
		cellvar.insertAdjacentHTML("BeforeEnd",termdesc);
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
			className = "className";
			document.term_code_result.className.value = "className";
			parent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value = "className";
			parent.f_term_result_header.document.term_code_result_header.className.value = "className";
		}
		parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&codelevel="+codelevel+"&className="+className+"";
		var htmlvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_value' id='dynamic_value' method='post' action='../../eMR/jsp/EquivalentTermCodeDynamicValues.jsp'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='codelevel' id='codelevel' value='"+codelevel+"'><input type='hidden' name='termcode' id='termcode' value='"+termcode+"'></form></body></html>"
		parent.f_term_selected_frms.document.write(htmlvalue);
		parent.f_term_selected_frms.document.dynamic_value.submit();
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
	
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
function checkVal(termset_id){

	
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	var termsetid = document.term_code_result.termsetid.value;
	var type_set = document.term_code_result.type_set.value;

	parent.f_term_selected_frms.location.href="../../eMR/jsp/EquivalentTermCode1.jsp?termsetid="+termsetid+"&termset_id="+termset_id+"&type_set="+type_set+" ";
	document.term_code_result.equalform.value='Y';
	parent.frames[1].frm_terminology_code.termcode_text.value=termset_id;
}


</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'> 
<FORM METHOD='POST' name='term_code_result' id='term_code_result' target='f_term_selected_frms' ACTION="">
<%
	if (maxRecord==0)
		{
%>
<table width='95%'>
<tr>
<table align='right'>
<tr>
<!--<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>-->
<%
	if ( !(start <= 1))
	{
		%>
			<td id='prev'><a href='javascript:submitPrevNext("<%=(start-7)%>","<%=(end-7)%>","Previous")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<%
	}
	//if ( !((start+7) > maxRecord ))
	//{
		
	//}%>
		<td id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("<%=(start+7)%>","<%=(end+7)%>","Next")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
</tr>
</table>
</tr>
</table>
<br>
<br>
<%
		}
%>

<table border='1' cellpadding='0' cellspacing='0' align='center'  width='95%' >
<%
//	if(termcode.equals("") && search_text.equals(""))
	if(termcode.equals(""))
	{    
		if(search_text.equals(""))
		{	
			
				   if(alphalink.equals("All")){				  
					   
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" order by short_desc";
					
					// query modified on 4-1-2010 to make it level independent.
					sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' order by short_desc";

				   }
				   else if (alphalink.equals("OT"))	{				  
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";

					// query modified on 4-1-2010 to make it level independent.	
				    sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";
					
				   }
				   else {					
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and UPPER (short_desc) like '"+alphalink+"%' order by short_desc";		

					// query modified on 4-1-2010 to make it level independent.
   					sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and UPPER (short_desc) like '"+alphalink+"%' order by short_desc";		
				   }
		}else{				
							
			if(callres.equals("search")){
			
					if(search_criteria.equals("S"))
						 search_text = search_text +"%";
					 else if(search_criteria.equals("E"))
								 search_text ="%"+search_text;
					 else if(search_criteria.equals("C"))
								 search_text = "%"+search_text+"%";
					 else
								 search_text = "%";		
					 
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and  Upper(short_desc) like Upper('"+search_text+"') order by short_desc";

					// query modified on 4-1-2010 to make it level independent.
					sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and  Upper(short_desc) like Upper('"+search_text+"') order by short_desc";

			}
			else{

								
				 if(alphalink.equals("All")){

						 if(search_criteria.equals("S")){
							 search_text = "upper(short_desc) like '"+ search_text.toUpperCase() + "%'";			
							 }
							 else if(search_criteria.equals("E")){
										 search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "'";
										 
							 }
							 else if(search_criteria.equals("C")){
										  search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "%'";
							 }
							 else{
										 search_text = "%";	
							 }
									 String typeSet="";

							if(!type_set.equals(""))
								{
									if(type_set.equals("DA"))
										typeSet = "cross_ref_type like '%D'";
									else if(type_set.equals("EC"))
										typeSet = "cross_ref_type like '%E'";
									else if(type_set.equals("EQ"))
										typeSet = "cross_ref_type is NULL";
									else if(type_set.equals("AS"))
										/*Wednesday, January 27, 2010 , modified for SRR20056-CRF-0303.2 [IN:015597] to list dagger dependent Astrisk Codes */
										//whereclause = "cross_ref_type like '%A'";
										typeSet = "cross_ref_type like '%A' ";
									else if(type_set.equals("CO"))
										typeSet = "cross_ref_type like '%C'";
								}
								  
								   if(codeResult.equals("result")){

									  /* if(search_criteria.equals("S"))
										 search_text = search_text +"%";
									 else if(search_criteria.equals("E"))
												 search_text ="%"+search_text;
									 else if(search_criteria.equals("C"))
												 search_text = "%"+search_text+"%";
									 else
												 search_text = "%";	

										String typeSet="";
										*/	 




								
									//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where   term_set_id='"+termsetid+"' and "+typeSet+"  and  code_level="+code_level+" and  "+search_text+" order by short_desc";

									// query modified on 4-1-2010 to make it level independent.

									sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where   term_set_id='"+termsetid+"' and "+typeSet+"  and  SELECT_YN='Y' and  "+search_text+" order by short_desc";
								   }
								   else
									 {
									   
										//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and    "+search_text+" and term_set_id='"+termsetid+"' and code_level="+code_level+"  order by short_desc";
	
										// query modified on 4-1-2010 to make it level independent.

										sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and    "+search_text+" and term_set_id='"+termsetid+"' and SELECT_YN='Y'  order by short_desc";

										
									 }

							   }
							   else if (alphalink.equals("OT"))	{
								   
									   //sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and  term_set_id='"+termsetid+"' and code_level="+code_level+" and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";

					   					// query modified on 4-1-2010 to make it level independent.


									   sqltermcoderesult="select term_code,short_desc,eff_status from,dagger_independent_yn mr_term_code where "+whereclause+" and  term_set_id='"+termsetid+"' and SELECT_YN='Y' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";

									   
							
							   }
							   else {
										   if(search_criteria.equals("S")){
												 search_text = "upper(short_desc) like '"+ search_text.toUpperCase() + "%' AND upper(short_desc) like '"+alphalink+"%'";							 

										   }
											 else if(search_criteria.equals("E")){
														 search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "' AND upper(short_desc) like '"+alphalink+"%'";
														 
											 }
											 else if(search_criteria.equals("C")){
														  search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "%' AND upper(short_desc) like '"+alphalink+"%'";
											 }
											 else{
														 search_text = "%"+alphalink+"%";
											 }
											 
											
										//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where  "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and  "+search_text+" order by short_desc";

										// query modified on 4-1-2010 to make it level independent.

										sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where  "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and  "+search_text+" order by short_desc";
										
								
							   
							   }




								/*
								sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and  upper(short_desc) like '"+search_text+"%' order by short_desc";
								*/
							}
						}
	}
	else
	{
		
		//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+"order by short_desc";

		// query modified on 4-1-2010 to make it level independent.


		sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and SELECT_YN='Y' order by short_desc";

		


	}

	stmt = con.createStatement();
	rset=stmt.executeQuery(sqltermcoderesult);
    String tempString  = "";
	String classValmod = "";

	
	ArrayList ar_c = new ArrayList();

	if(FirstConbox != null && SecondValue !=null && ThirdConbox != null)
	{
		String sq = "select EQUIVALENT_TERM_CODE from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID=? and TERM_CODE=? and EQUIVALENT_TERM_SET_ID=?";	

	
		//st_c = con.createStatement();
		psmt = con.prepareStatement(sq);
		psmt.setString(1,FirstConbox);
		psmt.setString(2,SecondValue);
		psmt.setString(3,ThirdConbox);
		rs_c = psmt.executeQuery();

		while(rs_c.next())
		{
			ar_c.add(rs_c.getString(1));		
		}

	}

	if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rset.next() ;
			}
		}
		start_check = i;

	String dagger_independent_yn="";
	String hide_mand="hidden";
	while(i<=end && rset.next() )
		{

			if(maxRecord==0)
			{   
			%>		<th class="COLUMNHEADER"><fmt:message key="Common.code.label" bundle="${common_labels}" /></th>
					<th class="COLUMNHEADER"><fmt:message key="Common.description.label" bundle="${common_labels}" /></th>
				<%	if(mr_term_set.equals("N"))
				{%>
					<th class="COLUMNHEADER"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /><INPUT TYPE="hidden" name="chkall" id="chkall"onclick='chkallvall(this,<%=start%>,<%=end%>)'></th>
			<%}
			}%>
			
		<% 
		/*if((maxRecord==0)&&status1.equals("Y"))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			*/%>
		   
		
			<!--<th align='left'>Code</th>
			<th align='center'>Description</th>-->
		<%	/*if(mr_term_set.equals("N"))
		{*/%>
		<!--<th align='left'>Select &nbsp;<INPUT TYPE="hidden" name="chkall" id="chkall"onclick='chkallvall(this,<%=start%>,<%=end%>)'></th>-->
		
		
		<%/*
		}}*/%>
	
	<%
	
	/*ResultSet rs_c = null;
	ArrayList ar_c = new ArrayList();
	
	if(FirstConbox != null && SecondValue !=null && ThirdConbox != null)
	{
		String sq = "select EQUIVALENT_TERM_CODE from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID='"+FirstConbox+"' and TERM_CODE='"+SecondValue+"' and EQUIVALENT_TERM_SET_ID='"+ThirdConbox+"'";		
		Statement st_c = con.createStatement();
		rs_c = st_c.executeQuery(sq);
		while(rs_c.next())
		{
			ar_c.add(rs_c.getString(1));		
		}

	}*/
//if(rset!=null)
	//{
		/*if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rset.next() ;
			}
		}
		start_check = i;*/
		//while(rset.next() && i<=end )
		//{


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
				
				tempString = tempString.replace(' ','|');
				tempString = java.net.URLEncoder.encode(tempString);
				status = rset.getString("eff_status");
				termset_id = rset.getString("term_code")==null ? "":rset.getString("term_code");
				termset_desc = rset.getString("short_desc")==null ? "":rset.getString("short_desc");
				eff_status = rset.getString("eff_status")==null ? "":rset.getString("eff_status");
				dagger_independent_yn = rset.getString("dagger_independent_yn")==null ? "":rset.getString("dagger_independent_yn");
				if(dagger_independent_yn.equals("Y")){
					hide_mand="visible";
				}else{
					hide_mand="hidden";
				}

				%>

				<td class='<%=classValue%>'><%=termset_id%>
				</td>
			
	<%if(mr_term_set.equals("N")){%>
				<td class=<%=classValue%>><%=termset_desc%>&nbsp; <img src='../../eCommon/images/mandatory.gif' style="visibility:<%=hide_mand%>"></td> 
		<%}else{%>
				<td class=<%=classValue%>><a HREF="javascript:onClick=checkVal('<%=termset_id%>')"> <%=termset_desc%></a></td> 
			<%}%>
			<%	if(mr_term_set.equals("N")){
					 ListValues.put("termset_id",termset_id);
			         ListValues.put("termset_desc",termset_desc);
			         ListValues.put("eff_status",eff_status);
                     ListAll.add(ListValues);
			 for(int k=0; k<ListAll.size(); k++){
				   HashMap DoseHashMap=new HashMap();
					DoseHashMap = (HashMap)ListAll.get(k);
                   
                     for(int x = 0;x<ar_c.size();x++)
				     { 
				   if(termset_id.equals(ar_c.get(x)))
					  {  

						chked_factor = "checked";
						factor_val = "E";
						
						break;
					}
					else
					{
						chked_factor = "";
						factor_val = "D";
				  	}
                 
				 }

            }

			
			
			  end_check = i;
			%> 
				<td class=<%=classValue%>><input type ="checkbox"  id="check_id" name='chks_factor<%=i%>' id='chks_factor<%=i%>' value='<%=factor_val%>' <%=chked_factor%> onclick="remchk(this)"  ></td>
				<%out.println("<input type='hidden' name=factor_code"+i+" value='"+rset.getString(1)+"'>");%>
				<INPUT TYPE="hidden" name="namecheck<%=i%>" id="namecheck<%=i%>" value='<%=i%>'>

				
				</tr>
			  <%}
			
			i++;
			maxRecord++;			
		}

				
		if ( maxRecord < 7 || (!rset.next()) )
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

		if((maxRecord==0)&&status1.equals("Y"))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(rs_c!=null) rs_c.close();
	if(st_c!=null) st_c.close();
	if(psmt!=null) psmt.close();
	//}
%>	
</table>
 
<INPUT TYPE="hidden" name="FirstConbox" id="FirstConbox" value="<%=FirstConbox%>">
<INPUT TYPE="hidden" name="SecondValue" id="SecondValue" value="<%=SecondValue%>">
<INPUT TYPE="hidden" name="ThirdConbox" id="ThirdConbox" value="<%=ThirdConbox%>">
<INPUT TYPE="hidden" name="termsetid" id="termsetid" value="<%=termsetid%>">
<INPUT TYPE="hidden" name="termcode" id="termcode" value="<%=termcode%>">
<INPUT TYPE="hidden" name="termcode1" id="termcode1" value="<%=termcode1%>">
<INPUT TYPE="hidden" name="codelevel" id="codelevel" value="<%=code_level%>">
<INPUT TYPE="hidden" name="termdesc" id="termdesc" value="<%=termdescription%>">
<INPUT TYPE="hidden" name="search_criteria" id="search_criteria" value="<%=search_criteria%>">
<INPUT type="hidden" name="from" id="from" value="<%=start_check%>">
<INPUT type="hidden" name="to" id="to" value="<%=end_check%>">
<INPUT type="hidden" name="start" id="start" value="<%=start%>">
<INPUT type="hidden" name="end" id="end" value="<%=end%>">
<INPUT TYPE="hidden" name="desc" id="desc" value="">
<INPUT TYPE="hidden" name="selectall" id="selectall" value="">
<INPUT TYPE="hidden" name='className' id='className' value='<%=className%>'> 
<INPUT TYPE="hidden" name="mr_term_set" id="mr_term_set" value="<%=mr_term_set%>">
<INPUT TYPE="hidden" name="alphalink" id="alphalink" value="<%=alphalink%>">
<INPUT TYPE="hidden" name="equalform" id="equalform" value="N">
<INPUT TYPE="hidden" name="type_set" id="type_set" value="<%=type_set%>">

<%	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(rs_c!=null) rs_c.close();
		if(st_c!=null) st_c.close();
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

