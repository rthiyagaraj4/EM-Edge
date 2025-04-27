<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	  String locale = checkForNull((String)session.getAttribute("LOCALE")); 
	  %>
 
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<style>
	.container {
		width:630px;
	}

	.container table {
		width: 620px;
		table-layout: fixed;
	}

	.inner_table { 
		width:100%; 
		height: 170px;
		overflow-y: auto;
	}

	.inner_table_site { 
		width:100%; 
		height: 100px;
		overflow-y: auto;
	}
	</style>
</HEAD>

<SCRIPT LANGUAGE="JavaScript">
function Checkdiagcode(obj)
{
	var convals = document.form1.convals.value;  
	if(obj.checked)
	{
		parent.frames[1].document.daggar_buttons.OK.disabled=false;
		if(convals != "")
			convals += "|";
		var obj_temp = obj.name.split("~");
		convals += obj_temp[0].replace('+','%2B') + "~" + obj_temp[1];
		document.form1.convals.value = convals;
	}
	else
	{
		var diag_code = obj.name.split("~");
		var delconvals = "";
		var del_code = unescape(diag_code[0]);
		var convals1 = unescape(document.form1.convals.value);
		var convals_array = convals1.split('|');		
		if(convals_array.length > 0)
		{
			for(i=0;i<convals_array.length;i++)
			{				
				var temp_conval = convals_array[i].split('|');
				for(j=0;j<temp_conval.length;j++)
				{
					var temp_conval_code = temp_conval[j].split('~');
					if(temp_conval_code[0] != del_code)
					{
						if(delconvals != '')
							delconvals += "|";
						delconvals += (temp_conval[j].replace('+', '%2B'));
					}
				}
			}
		}
		document.form1.convals.value = delconvals;
		if(document.form1.convals1.value !='')
		{
			if(document.form1.convals.value =='')
			{
				alert(getMessage("MR_EX_SELECT_ONE_DIAG",'MR'));
				parent.frames[1].document.daggar_buttons.OK.disabled=true;
				//obj.focus;
				return false;
			}
			else
				parent.frames[1].document.daggar_buttons.OK.disabled=false;
		}
	}
}

function formValidate(obj)
{
	var convals = document.form1.convals.value;  
	if(obj.checked)
	{
		if(convals != "")
			convals += "|";
		var obj_temp = obj.name.split("~");
		convals += obj_temp[0].replace('+','%2B') + "~" + obj_temp[1];
		document.form1.convals.value = convals;
	}
	else
	{
		var diag_code = obj.name.split("~");
		var delconvals = "";
		var del_code = unescape(diag_code[0]);
		var convals1 = unescape(document.form1.convals.value);
		var convals_array = convals1.split('|');		
		if(convals_array.length > 0)
		{
			for(i=0;i<convals_array.length;i++)
			{				
				var temp_conval = convals_array[i].split('|');
				for(j=0;j<temp_conval.length;j++)
				{
					var temp_conval_code = temp_conval[j].split('~');
					if(temp_conval_code[0] != del_code)
					{
						if(delconvals != '')
							delconvals += "|";
						delconvals += (temp_conval[j].replace('+', '%2B'));
					}
				}
			}
		}
		document.form1.convals.value = delconvals;
		if(document.form1.convals.value =='')
		{
			alert(getMessage("MR_EX_SELECT_ONE_DIAG","MR"));
			obj.focus;
			return false;
		}
	}
}

//Added by sangeetha for ML-MMOH-CRF-0733  -- START
function storeVal(currad){
		radioval = currad.value;
	}

function CheckForSpecChars_event(event){
	if(event.keyCode!='13'){
		var strCheck = '"';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return true;  
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return false ;
	}else{
		return false;
	}
}

function CallDescFrame(){ 
    
	var radioValue="";	
	if(document.form1.search_by[0].checked) radioValue=document.form1.search_by[0].value;	
	if(document.form1.search_by[1].checked) radioValue=document.form1.search_by[1].value;	
	
	var HTMLVal = new String();  
	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='formDummy' action='../../eMR/jsp/AddDaggerCodeAddModify.jsp'>"+
			  "<input type= 'hidden' name= 'search_by' value='" +radioValue+"'>"+
			  "<input type= 'hidden' name= 'Search_criteria' value='" + document.forms[0].Search_criteria.value +"'>"+
		      "<input type= 'hidden' name= 'Search_text' value='" + document.forms[0].Search_text.value +"'>"+
			  "<input type= 'hidden' name= 'associate_codes_modify' value='"+decodeURIComponent(document.forms[0].associate_codes_modify.value)+"'>"+
			  "<input type= 'hidden' name= 'code_indicator' value='"+ document.forms[0].code_indicator.value +"'>"+
			  "<input type= 'hidden' name= 'diag_code' value='"+ document.forms[0].diag_code.value +"'>"+
			  "<input type= 'hidden' name= 'mode' value='" + document.forms[0].mode.value +"'>"+
			  "<input type= 'hidden' name= 'associate_codes' value='"+ decodeURIComponent(document.forms[0].convals1.value)+"'>"+
			  "<input type= 'hidden' name= 'convals1' value='"+ decodeURIComponent(document.forms[0].convals1.value)+"'>"+
			  "<input type= 'hidden' name= 'code_set' value='" + document.forms[0].term_set_id.value +"'></form></BODY></HTML>";

	document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	document.formDummy.submit();

}

function CallReset()
{
	document.form1.search_by[0].checked=true;
	document.form1.Search_criteria.options[1].selected=true;
	document.form1.Search_text.value="";
	CallDescFrame();
}
//Added by sangeetha for ML-MMOH-CRF-0733  -- END

/*Below line added for this CRF ML-MMOH-CRF-0792*/
function onMMove(obj,e,diagTemp,code) {
		var treat1=unescape(document.getElementById('supprtDiag'+diagTemp).value);
		var Totalcount=document.getElementById("Totalcount").value;
		var diagcode =code;
		if(treat=!""){
		obj.style.left=e.x+10;
		if(parseInt(diagTemp)>5 && parseInt(diagTemp)!=parseInt(Totalcount)){		
		  obj.style.top=e.y-30;
		}else if(parseInt(diagTemp)>5 && parseInt(diagTemp)==parseInt(Totalcount)){		
		  obj.style.top=e.y-90;
		}else{		
		  obj.style.top=e.y;
		}		
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=560;
		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top'>"+diagcode+"/"+treat1+"</td></tr></table>";
		}
		else
			return false;
			
}

function onMOut(obj){

		if(treat=!""){
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
		}
		else
			return false;
}

//End this CRF ML-MMOH-CRF-0792
</SCRIPT>
<BODY onKeyDown = 'lockKey()'>

<%


String convals  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
String associate_codes_modify  = request.getParameter("associate_codes_modify")==null?"":request.getParameter("associate_codes_modify");
String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
String term_set_id = request.getParameter("code_set")==null?"":request.getParameter("code_set");
String code_indicator1 ="";
String splitvalsDB ="";
String codeDB = "";
String codeDBdesc = "";
String searchTxt="";    //Added by Sangeetha for ML-MMOH-CRF-0733
ArrayList tempConvals			= new ArrayList();


if((code_indicator.equals("A")) || (code_indicator.equals("D")))
	code_indicator1="AS";
else if(code_indicator.equals("E") || (code_indicator.equals("C")))
	code_indicator1="EC";

Connection con = null;
PreparedStatement stmt = null;
ResultSet rs= null;
PreparedStatement stmt1 = null;
ResultSet rs1= null;
String diag_code=""; //Added for this CRF GDOH-CRF-0082
//Below line added for this CRF GDOH-CRF-0082
String mode="",old_diagcode="";

String searchby="",searchcriteria="",searchtext="";

try
{
	diag_code	= 	request.getParameter("diag_code"); //Modified for this CRF GDOH-CRF-0082
	
	//Below line added for this CRF GDOH-CRF-0082
	mode=request.getParameter("mode");	
	if(mode ==null || mode.equals("null") || mode.equals("")) mode="insert";	
	if(mode.equals("insert")){	
	  if((String )session.getAttribute("diagnosis_code")==null){
	       session.setAttribute("diagnosis_code",diag_code);
	   }else if((String )session.getAttribute("diagnosis_code")!=null){
	      old_diagcode=(String )session.getAttribute("diagnosis_code");		 
		  if(!old_diagcode.equals(diag_code)){
		  convals="";		  
		  session.setAttribute("diagnosis_code",diag_code);
		  		  
		  }
	   }	 	   
	 } 
	// End this CRF GDOH-CRF-0082
	
	con  = ConnectionManager.getConnection(request);

    //Added by Sangeetha for ML-MMOH-CRF-0733
	boolean SearchCritSiteSpecific	=  eCommon.Common.CommonBean.isSiteSpecific(con, "MR","SUPPORT_DIAG_SEARCH_CRITERIA");
	
	//Below line added for this CRF ML-MMOH-CRF-0792
	boolean support_diagnosis	=  eCommon.Common.CommonBean.isSiteSpecific(con, "MR","SUPPORTING_DIAGNOSIS");
	
	
	StringBuffer WhereCodn	=   new StringBuffer();
	 searchby			=	request.getParameter("search_by"); 
	 searchcriteria	=	request.getParameter("Search_criteria"); 
	 searchtext		=	request.getParameter("Search_text");  
	 if(searchtext==null || searchtext.equals("null")) searchtext="";
		
			if(!(searchby == null)) {
				if(searchby.equals("D")){ 
					WhereCodn.append(" and upper(bb.SHORT_DESC) like upper(?)");	
				}else{
					WhereCodn.append(" and upper(aa.EQUIVALENT_TERM_CODE) like upper(?)");
				}
			}
			
		
	StringTokenizer strDB = new StringTokenizer(associate_codes_modify, "|");
		if(!associate_codes_modify.equals(""))
		{
			
			while(strDB.hasMoreTokens())
			{
				splitvalsDB = strDB.nextToken();
				StringTokenizer str2DB = new StringTokenizer(splitvalsDB,"~");
				while(str2DB.hasMoreTokens())
				{
					codeDB = str2DB.nextToken();
					codeDBdesc = str2DB.nextToken();
					codeDBdesc = codeDBdesc.replace(' ','+');
					tempConvals.add(codeDB);
				}
			}
		}

	//String query = "select a.DAG_DIAG_CODE, a.ASTK_DIAG_CODE, b.SHORT_DESC  from  mr_icd_code_dtl a, mr_icd_code b where a.ASTK_DIAG_CODE = b.DIAG_CODE and a.DAG_DIAG_CODE = ?  and b.DIAG_CODE_SCHEME = (select diag_code_scheme from mr_parameter)";

	//Commented By Sangeetha
	//String query = "SELECT TERM_CODE,EQUIVALENT_TERM_CODE FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_CODE=? AND CROSS_REF_TYPE='"+code_indicator1+"' and term_set_id = '"+term_set_id+"'";

	//Added by Sangeetha for ML-MMOH-CRF-0733
	String query = "SELECT aa.term_code, aa.equivalent_term_code, bb.short_desc, bb.long_desc FROM mr_equivalent_term_code aa, MR_D_"+term_set_id+"_LANG_VW bb WHERE aa.term_code = ? AND aa.term_set_id = '"+term_set_id+"' AND aa.equivalent_term_code = bb.term_code AND bb.language_id = ? and  aa.CROSS_REF_TYPE = '"+code_indicator1+"' ";
	
	String order_by = " order by aa.equivalent_term_code asc "; 	
	//Above query modified for this CRF ML-MMOH-CRF-0792
	
		if(SearchCritSiteSpecific){
				stmt = con.prepareStatement(query + WhereCodn.toString() + order_by);
		}else{
				stmt = con.prepareStatement(query + order_by);
		}
	
	stmt.setString(1, diag_code);
	stmt.setString(2, locale);

	if(!(searchcriteria == null)) {
		if(searchcriteria.equals("S")) {  
			stmt.setString(3,searchtext+"%");		
		} else if(searchcriteria.equals("E")) {
			stmt.setString(3,"%"+searchtext);		
		} else if(searchcriteria.equals("C")) {
			stmt.setString(3,"%"+searchtext+"%");		
		}
	}

	rs = stmt.executeQuery();
%>
<form name="form1" id="form1">
	
	<!-- Below code added by Sangeetha for ML_MMOH-CRF-733 -->
	
	<% if(SearchCritSiteSpecific){ %>
	&nbsp;&nbsp;&nbsp;
	
	<table align=center border="0" width=100% cellspacing='0' cellpadding='3'>

	  <tr>
		<td colspan='2' class="label">
		<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		</td>
		<td class="label" colspan="1" width = '25%'>
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>	
		</td>
		<td class ='fields' >
		<select name="Search_criteria" id="Search_criteria">
		<option value="C" ><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
		<option value="S" selected><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
		</select>
		</td>
     </tr>

	<tr>
		<td class='label' colspan=1  width = '25%' nowrap ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
			<input class = fields' type="text"  name="Search_text" id="Search_text" onkeypress="return CheckForSpecChars_event(event)" value='<%=searchTxt%>' width=30% align="left" size='20' maxlength='20' >
			
		</td>
		<td colspan = 2 width = '25%' align = 'right'>
			<input type="button" width='6%' align="right" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="CallDescFrame()" class='button' >
		</td>
		<td colspan = 2 width = '25%' align = 'left'>
			<input type="button" width='6%' align="right" name="Reset" id="Reset" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%> ' onClick="CallReset()" class='button' >
		</td>
   </tr> 
 <!--Added by Sangeetha for ML-MMOH-CRF-0733 -->  
<script>  
if('<%=searchtext%>'!=null && document.form1.Search_text!=null){
 document.form1.Search_text.value="<%=searchtext%>";
 }
if("<%=searchby%>"=="D" && document.form1.search_by!=null){ 
document.form1.search_by[0].checked=true;
document.form1.search_by[0].value="<%=searchby%>"
}
if("<%=searchby%>"=="C" && document.form1.search_by!=null){ 
document.form1.search_by[1].checked=true;
document.form1.search_by[1].value="<%=searchby%>"
}

if('<%=searchcriteria%>'=="C" && document.form1.Search_criteria!=null){
document.form1.Search_criteria.options[0].selected=true;
}

if('<%=searchcriteria%>'=="S" && document.form1.Search_criteria!=null){
document.form1.Search_criteria.options[1].selected=true;
}
if('<%=searchcriteria%>'=="E" && document.form1.Search_criteria!=null){
document.form1.Search_criteria.options[2].selected=true;
}
</script>
</table>


	<%}%>

     &nbsp;&nbsp;&nbsp;
	<!--<div class="container">-->
	<table class="head" width="100%"  border="1" cellpadding="0" cellspacing="0" style="border:1px #83aab4">
	<tr>
				
	<td class="COLUMNHEADER"width="15%" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"width="75%" ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER"width="10%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
	
		<% if(SearchCritSiteSpecific){ %>
		<div class="inner_table_site">
		<% } else{ %>
		<div class="inner_table">
	    <%}%>
		
		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:1px solid #83aab4">
		
<%	
	String classval ="";
	String short_desc ="";
	int i= 0;
	int flag = 0;
	
	//Added for this CRF ML-MMOH-CRF-0792
	String suportlong_desc=""; 
	int temp=0;
   //End this CRF ML-MMOH-CRF-0792

	while(rs.next())
	{
		flag = 1;
		String astk_diag_code = rs.getString("EQUIVALENT_TERM_CODE");
		//String short_desc = rs.getString("SHORT_DESC");
		String checked = "";
		String disVal = "";

//		String sql="SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_CODE =? AND TERM_SET_ID=?";
		
		//Commented by Sangeetha for ML-MMOH-CRF-0733
		/*String sql="SELECT SHORT_DESC FROM MR_D_"+term_set_id+"_LANG_VW WHERE TERM_CODE =? AND TERM_SET_ID=? AND LANGUAGE_ID=?";
		
		stmt1 = con.prepareStatement(sql);

		stmt1.setString(1, astk_diag_code);
		stmt1.setString(2, term_set_id);
		stmt1.setString(3, locale);
		rs1 = stmt1.executeQuery();
		while(rs1.next())
		{
			short_desc = rs1.getString("SHORT_DESC");
		}

		if(rs1!= null) rs1.close();
		if(stmt1 != null) stmt1.close();*/



		//Added by Sangeetha for ML-MMOH-CRF-0733
		short_desc = rs.getString("SHORT_DESC");
		
		//Below line added for this CRF ML-MMOH-CRF-0792
		suportlong_desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");

		if(i%2 == 0)
				classval = "QRYODD";
			else
				classval = "QRYEVEN";
		StringTokenizer str1 = new StringTokenizer(convals, "|");
		if(!convals.equals(""))
		{
			String code = "";
			String codeDesc = "";
			while(str1.hasMoreTokens())
			{
				String splitvals = str1.nextToken();
				StringTokenizer str2 = new StringTokenizer(splitvals,"~");
				while(str2.hasMoreTokens())
				{
					code = str2.nextToken();
					codeDesc = str2.nextToken();
					codeDesc = codeDesc.replace(' ','+');
					if(code.equals(astk_diag_code))
					{
						checked = "Checked";
					}
					if(tempConvals.contains(astk_diag_code))
					{
						disVal	= "disabled";
					}else
					{
						disVal	= "";
					}
				}
			}
		}
		%>	
	
	<!--Below line added for this CRF ML-MMOH-CRF-0792-->  
		<tr>
			<td width="15%"><%if(support_diagnosis){out.println("<a onMouseover='javascript:onMMove(msg,event,\""+i+"\",\""+java.net.URLEncoder.encode(astk_diag_code)+"\");'  onMouseout='javascript:onMOut(msg);'>"); out.println(astk_diag_code);%><%}else{ out.println(astk_diag_code);%> <%}%></a></td>
			<td width="75%"><%=short_desc%></td>
			<td width="10%"><input type="checkbox" name="<%=astk_diag_code+"~"+short_desc.replaceAll("\'","")	%> " Onclick="Checkdiagcode(this)" <%=checked%> <%=disVal%>><td>
			<input type="hidden" name="supprtDiag<%=i%>" id="supprtDiag<%=i%>"  value="<%=suportlong_desc%>"> <!--Added for this CRF ML-MMOH-CRF-0792-->			
		</tr>
		
		<%
		temp=i; //added for this CRF ML-MMOH-CRF-0792
		i++;
	}%>
	<input type="hidden" name="Totalcount" id="Totalcount" id="Totalcount" value="<%=temp%>"> <!--Added for this CRF ML-MMOH-CRF-0792-->
</table>
</div>
</div>
		<!--</div>
		</td>
		</tr> -->
	<%if(rs != null) rs.close();
	if(stmt != null) stmt.close();

	if(flag == 0)
	{
		//Added by Sangeetha for ML-MMOH-CRF-0733
		if(SearchCritSiteSpecific){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}else{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
			out.println("window.close();</script>");   
		}
	}
	
}
catch(Exception e)
{
	//out.println("Exception in AddDaggerCodeAddModify.jsp " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<input type="hidden" name="convals" id="convals" value="<%=java.net.URLEncoder.encode((String)convals)%>"></input>
<input type="hidden" name="convals1" id="convals1" value="<%=java.net.URLEncoder.encode((String)convals)%>"></input>

<!-- Added by Sangeetha for ML-MMOH-CRF-0733 -->
<input type= "hidden" name= "associate_codes_modify" value="<%=associate_codes_modify%>">
<input type= "hidden" name= "code_indicator" value="<%=code_indicator%>">
<input type= "hidden" name= "term_set_id" value="<%=term_set_id%>">
<input type= "hidden" name= "diag_code" value="<%=diag_code%>">
<input type= "hidden" name= "mode" value="<%=mode%>">

<%
//Added below line for GDOH-CRF-0082
if(mode.equals("insert")){	
	if(!old_diagcode.equals(diag_code)){ 
	    out.println("<script>document.form1.convals.value='';</script>");
	    out.println("<script>document.form1.convals1.value='';</script>");
	} 
}	
//End GDOH-CRF-0082

%> 
<!--Below line added for this CRF ML-MMOH-CRF-0792-->
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 100; top: 62">
</div>
<!--End this CRF ML-MMOH-CRF-0792-->
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

