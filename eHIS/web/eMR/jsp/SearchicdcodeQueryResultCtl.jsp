<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"  %>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale=checkForNull((String)session.getAttribute("LOCALE")); 
%>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 	<script src='../../eMR/js/PatProblemSearch.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

<script>
var codeArr = new Array();

function loadDefaultPage()
{
	var from = 0;
	var to = 1;
	var totalIndex = eval(parent.prevnextframe.document.forms[0].totalIndex.value - 1);
	if(totalIndex == 0)
		totalIndex = 1;
	var displstart = 1;
	parent.prevnextframe.document.forms[0].label_cap.value = displstart + " of " + totalIndex;
	parent.prevnextframe.document.forms[0].CurIndex.value = 0;
	populateData(from,to)
}

function populateData(from_code, to_code)
{
	var queryString	= parent.prevnextframe.document.forms[0].queryString.value;
	var from_val = codeArr[from_code];
	
	var to_val = codeArr[to_code];
	
parent.frames[2].location.href="SearchicdcodeQueryResult.jsp?"+queryString+"&from_code="+from_val+"&to_code="+to_val;
}
function disabledDefaultPage(){
	parent.frames[2].location.href="SearchicdcodeQueryResult.jsp?&clearResultPage=y";

}

function loadPrevNext(obj)
{
	var NxtBtn		= parent.prevnextframe.document.forms[0].next;
	var PrvBtn		= parent.prevnextframe.document.forms[0].prev;

	var curindex = eval(parent.prevnextframe.document.forms[0].CurIndex.value);
	var totalIndex = eval(parent.prevnextframe.document.forms[0].totalIndex.value) -1;

	var fromindex = 0;
	var toindex = 0;

	var displstart	= 1;
	var displend = totalIndex ; 

	if(obj.name == "next")
	{
		if(curindex < totalIndex)
		{
			curindex++;
			fromindex = curindex;
			toindex = eval(curindex) + 1;

		if((curindex+1) == (totalIndex) ) 
			NxtBtn.disabled = true;
	//	else
			PrvBtn.disabled = false;

		displstart	= eval(curindex) +1;
		}
	}
	else if(obj.name == "prev")
	{
		if(curindex > 0)
		{

			toindex = curindex;
			fromindex = eval(curindex) - 1;
			curindex--;

		if((curindex ) == 0 ) 
				PrvBtn.disabled = true;
//		else
				NxtBtn.disabled = false;

			 displstart	= eval(curindex) + 1;
		}
	}

	parent.prevnextframe.document.forms[0].label_cap.value = displstart + " of " + displend;
	parent.prevnextframe.document.forms[0].CurIndex.value = curindex;
	populateData(fromindex,toindex);
	
}

async function showLongDescription(a)
{
	var dialogHeight= "20vh" ;
    var dialogWidth = "23vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}

function closewindow(Dcode)
{
	window.parent.parent.returnValue=Dcode;
	window.parent.parent.close();
}
function scrollTitle(){
   var y = parent.TermCodeSearchKWResultFrame.document.body.scrollTop;
   //alert(y);
   if(y == 0){
		parent.TermCodeSearchKWResultFrame.document.getElementById("divDataTitle").style.position = 'static';
   }else{
		parent.TermCodeSearchKWResultFrame.document.getElementById("divDataTitle").style.position = 'relative';
		parent.TermCodeSearchKWResultFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
   }

}

function alignWidth()
{
	var totalRows =  parent.TermCodeSearchKWResultFrame.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.TermCodeSearchKWResultFrame.document.getElementById("dataTitleTable").rows[0].cells.length;
	for(var i=0;i<temp;i++) 
	{
		parent.TermCodeSearchKWResultFrame.document.getElementById("dataTitleTable").rows[0].cells[i].width=parent.TermCodeSearchKWResultFrame.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
}
</script>

</head>
<%	request.setCharacterEncoding("UTF-8");
	StringBuffer sql= new StringBuffer();
	
	String disablePrev="";
	String disableNext="";
	String no_data = "";
	int indxKey = 0;
	String term_code = "";
	String term_set_id = "";
	String searchby=(request.getParameter("Search_By")==null)?"":request.getParameter("Search_By");
    String searchcriteria=(request.getParameter("Search_Criteria")==null)?"":request.getParameter("Search_Criteria");
    String searchtext=(request.getParameter("Search_Text")==null)?"":request.getParameter("Search_Text");
	String sensitive_yn =(request.getParameter("sensitive_yn")==null)?"":request.getParameter("sensitive_yn");
	String notifiable_yn =(request.getParameter("notifiable_yn")==null)?"":request.getParameter("notifiable_yn");
	//modified on 15-07-08 for SCR 4827
	String title = request.getParameter("title")==null?"":request.getParameter("title");
	
	if(title.equals("ICD10 Code List"))
	{
		term_set_id =(request.getParameter("p_diag_scheme_desc")==null)?"":request.getParameter("p_diag_scheme_desc");
	}
	else
		{
		term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
	}
	String code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");
	String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
	term_set_id = term_set_id.trim();
	searchtext = searchtext.toUpperCase();
	Connection conn = null; 
	PreparedStatement stmt  = null;
	ResultSet rs = null;
	//int i = 0;
try
{
	conn = ConnectionManager.getConnection(request);

	/*
	
	if(searchby.equals("D")) 
	{
	//Maheshwaran added for the HSA-CRF-0234
	if(diagnosis_by_long_desc_yn.equals("Y"))
	sql.append(" upper(long_desc)  like upper(?)");
	else
	sql.append(" upper(short_desc)  like upper(?)");
	}
	else 
		sql.append(" term_code  like ");

	if(searchcriteria.equals("S"))  
		sql.append("'"+searchtext+"%'");
	else if(searchcriteria.equals("E"))
		sql.append("'%"+searchtext+"'");
	else if(searchcriteria.equals("C"))
		sql.append("'%"+searchtext+"%'");

	*/


	if(searchby.equals("D")){ 
		if(diagnosis_by_long_desc_yn.equals("Y"))
		sql.append(" upper(long_desc)  like upper(?)");
		else
		sql.append(" upper(short_desc)  like upper(?)");
	}else{
		sql.append(" upper(term_code)  like upper(?)");	
	}
	//8/20/2009 Free Text Diagnosis
	sql.append(" AND FREE_TEXT_YN = 'N' ");


	if(sensitive_yn.equals("Y")) {
		sql.append(" and  SENSITIVE_YN = 'Y' ");
	}else if (sensitive_yn.equals("N")) {
		sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");
	}
	if(notifiable_yn.equals("Y")){
		sql.append(" and NOTIFIABLE_YN = 'Y'");
	}else if (notifiable_yn.equals("N")){
		sql.append(" and nvl(NOTIFIABLE_YN,'N') ='N'");
	}
	if(!code_indicator.equals(""))	{
		sql.append(" and  code_indicator = ?");
	}else{
		sql.append(" and ( code_indicator in ('C','D','E','A') or code_indicator is null ) ");	
	}
	sql.append("and language_id=?");// Language Id is added for IN023648 	
	//sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");		
	sql.append(" )  where mod(order_rank,25)=1  or TERM_CODE = last_rank ");


	sql.append(" order by order_rank ");
			/*
				The following query was modified for IN023648.
				Modified On:10/5/2010.
			*/

	StringBuffer searchKW_sql = new StringBuffer("select TERM_CODE  from (select TERM_CODE,rank() over( order by TERM_CODE) order_rank ,max(TERM_CODE) over ( order by TERM_CODE desc) last_rank from  MR_D_"+term_set_id+"_LANG_VW where ");
	

	stmt = conn.prepareStatement(searchKW_sql.toString()+sql.toString());

	if(searchcriteria.equals("S")) {  
		stmt.setString(1,searchtext+"%");		
	} else if(searchcriteria.equals("E")) {
		stmt.setString(1,"%"+searchtext);		
	} else if(searchcriteria.equals("C")) {
		stmt.setString(1,"%"+searchtext+"%");		
	} 

	if(!code_indicator.equals("")){
		stmt.setString(2,code_indicator);
		stmt.setString(3,locale);		
	}else{
		stmt.setString(2,locale);
	}
			
		rs = stmt.executeQuery();
		indxKey = 0;
		while(rs.next())
		{
			term_code = rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
			//out.println("term_code :"+term_code);
			
				%>
					<script>
						codeArr["<%=indxKey%>"] = "<%=term_code%>";
						//alert(codeArr);
					</script>
				<%

				indxKey++;
				//out.println("<script>alert(\""+indxKey+"\");</script>");
		}

	 /*Below line commented for this incident [IN:040385]*/			
	 /*if(indxKey == 0)
		{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				out.println("<script>parent.frames[0].document.forms[0].Search.disabled = false</script>");
				out.println("<script>parent.frames[2].href='../../eCommon/html/blank.html' </script>");
				
		}*/
      //End this incident [IN:040385]	
	
	if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();
	if(indxKey == 0)
		no_data = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NoDataFound.label","mr_labels");
	//{"eMR.NoDataFound.label","No Data Found"}
//		no_data = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NoDataFound.label","mr_labels");


}catch(Exception e){
	e.printStackTrace();
}finally{
		if(conn!=null){
			ConnectionManager.returnConnection(conn,request);
		}
 }
	%>
	<%
	if(indxKey!=0){
	%>
				<body  onScroll='scrollTitle()' onKeyDown='lockKey()'>
				<form name = "SearchicdcodeQueryResultCtlForm" >
				<table border=0 cellpadding=0 cellspacing=0 width="100%" align='center' id='tablePrevNext' style='display:inline'>
					<tr>
						<td  width='85%' align='right' CLASS =LABEL><fmt:message key="Common.DisplayResult.label" bundle="${common_labels}"/></td>
						<td align='right' width='5%'><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext(this)' align='right'></td>
						<td align ='center' class = 'QRYEVEN'><input type ='label' readonly class="LABEL" name = 'label_cap' size='15' value=<%=no_data%>></td>
						<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext(this)' ></td>
					</tr>
				</table>
				<input type= "hidden" name= "CurIndex" value="0">
				<input type= "hidden" name= "totalIndex" value=<%=indxKey%> - 1>
				<input type= "hidden" name= "queryString" value=<%=request.getQueryString()%>>


					<script>
						document.forms[0].prev.disabled = true;
						if("<%=indxKey%>" <= 2)
						{
							document.forms[0].next.disabled = true;
						}
						if("<%=indxKey%>" > 0)
							loadDefaultPage();
					</script>
				</form>
				</body>
<%}else{%>
			<script>
					disabledDefaultPage();
			</script>
<%}%>

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

