<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/05/2017	IN061907		Krishna Gowtham		02/05/2017	Ramesh G	ML-MMOH-CRF-0559
03/10/2017  IN061908		Krishna Gowtham		04/10/2017	Ramesh G	ML-MMOH-CRF-0560		
09/04/2023	   38981        Krishna Pranay   09/04/2023     Ramesh G     ML-MMOH-CRF-1986
------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection			con 	= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;

	String	query_title		=	"";
	String	short_desc		=	"";
	String result_linked_rec_type="";
	String include_Support_Diag="";//38981
	String  sec_hdg_code="";
	result_linked_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	sec_hdg_code=(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");


	String call_from_link_doc_btn 	= request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");//IN061907

	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_id = request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
	String practitioner_id = (String)session.getValue("ca_practitioner_id") == null ? "" : (String)session.getValue("ca_practitioner_id");
	String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	String toDate = "";
	String specialty_code = "";
	String dispResLinkHYMLYN="";//IN061907
	
	dispResLinkHYMLYN = (request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");//IN061907

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
	String locale = (String) p.getProperty("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
				/** added by kishore kumar n on 10/12/2008  */
		String imgUrl="";
		if(sStyle.equals("IeStyle.css"))
		 {
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
		 /** ends here*/
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type="text/javascript" src="../../eCA/js/RecClinicalNotesLinkDiag.js"></script>
<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

try
{
	con 	=	ConnectionManager.getConnection(request);

	toDate	=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

	String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date from mr_parameter ";

	String scheme				=		"";
	String scheme_desc			=		"";
	String term_set_id="";
	String term_set_desc="";
	String accuracy_code   ="";
	String accuracy_short_desc = "";

	pstmt = con.prepareStatement(sql);
	rs = pstmt.executeQuery();
        
	if(rs.next())
	{
		scheme      = rs.getString("scheme");
		out.print("<script>scheme='"+scheme+"'</script>");
		scheme_desc = rs.getString("scheme_desc");
	}

	if(rs!=null){rs.close();rs=null;}
	if(pstmt!=null){pstmt.close();pstmt=null;}

	pstmt = con.prepareStatement("select SPECIALTY_CODE from pr_encounter where ENCOUNTER_ID = ? and PATIENT_ID = ?");
	pstmt.setString(1,encounter_id);
	pstmt.setString(2,patient_id);

	rs = pstmt.executeQuery();
	while(rs.next())
	{
		specialty_code = rs.getString("SPECIALTY_CODE") == null ? "" : rs.getString("SPECIALTY_CODE");
	}

	if(rs!=null){rs.close();rs=null;}
	if(pstmt!=null){pstmt.close();pstmt=null;}

	query_title	="SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC  FROM DUAL";

	pstmt			=	con.prepareStatement(query_title);
	pstmt.setString(1,result_linked_rec_type);	
	pstmt.setString(2,locale);
	
	rs				=	pstmt.executeQuery();

	if(rs.next())
		short_desc	=	rs.getString("SHORT_DESC");
		
	if(rs!=null){rs.close();rs=null;}
	if(pstmt!=null){pstmt.close();pstmt=null;}

	%>
<form name="ProblemListForm" id="ProblemListForm">
<table align=center border='0' width='100%'  cellspacing='0' cellpadding='3'>
<tr>
	<td class='columnheader'  colspan=6><b><%=short_desc%></b></td>
</tr>
<tr>
		<td class='fields' colspan='5'><input type="radio" name="problems_radio" id="problems_radio" class="label" value="A" onClick="" checked ><font size='1'>&nbsp;&nbsp;<fmt:message key="eCA.ActiveOnly.label" bundle="${ca_labels}"/>
		<input type="radio" name="problems_radio" id="problems_radio" class="label" value="O" onClick=""><font size='1'>&nbsp;&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/></td>		
</tr>
<tr>
		<td class = label width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
        <td class = 'fields' colspan=4 >
		<select name="code_set" id="code_set"  onChange="enableCode(this);" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		
		<%
		String diagset_qry ="select a.term_set_id,term_set_desc from MR_TERM_SET a where eff_status = 'E' ";

		 try
		{
		  pstmt = con.prepareStatement(diagset_qry);
		  rs = pstmt.executeQuery();
		  while(rs!=null && rs.next())
		  {
			term_set_id   =rs.getString(1);
			term_set_desc =rs.getString(2);
			out.println("<option value='"+term_set_id+"' >"+term_set_desc+"</option>");
							
		  }
		  if(rs!=null) 
			  rs.close();
		  if(pstmt!=null) 
			  pstmt.close();
		}//try 
		catch(Exception eg)
		{
		   //out.println("Exception at diagset_qry  ="+eg.toString());//COMMON-ICN-0181
		   eg.printStackTrace();//COMMON-ICN-0181
		}


		%>
		
		</select>
		<input type="text" name="code" id="code" size=5 Onblur='show_descnew(this)' readOnly><input type="button" class='Button' name="search_button" id="search_button" title='Search' value="?" onClick="show_windownew('<%=scheme%>')" disabled>
         <input type='text' name='code_desc' id='code_desc' size=55 readOnly></input> 
        </td>
</tr>
<tr>
		<td class=label  width='10%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/>	</td>
		<td class='fields' width='15%' ><input type="text" name='txtFromDate' id='txtFromDate' value='' size=9 onBlur='CheckDate(this);doDateCheck(this,txtToDate,"DMY","<%=locale%>");'><input type='image'  src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtFromDate');" > -
		<input type="text" name="txtToDate" id="txtToDate" onBlur='CheckDate(this);doDateCheck(txtFromDate,this,"DMY","<%=locale%>");' size=9> <input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtToDate');" ></td>

        <td class=label  width='5%' ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
		<td class=fields  width='15%' colspan=2>
		<select name="diag_type" id="diag_type"  onChange="">
		<option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----

		<%
		String accuracy_qry ="select accuracy_code, short_desc from MR_ACCURACY_LANG_VW where language_id=? and eff_status='E' ORDER BY 2 ";

		 try
		{
		  pstmt = con.prepareStatement(accuracy_qry);
		  pstmt.setString(1,locale);
		  rs = pstmt.executeQuery();
		  while(rs!=null && rs.next())
		  {
			accuracy_code   =rs.getString(1);
			accuracy_short_desc =rs.getString(2);
			out.println("<option value='"+accuracy_code+"' >"+accuracy_short_desc+"</option>");
							
		  }
		  if(rs!=null) 
			  rs.close();
		  if(pstmt!=null) 
			  pstmt.close();
		}//try 
		catch(Exception eg)
		{
		   //out.println("Exception at accuracy_qry ="+eg.toString());//COMMON-ICN-0181
		   eg.printStackTrace();//COMMON-ICN-0181
		}


		%>		
		</select>
        </td>
 </tr>
 <tr>
        <td  class='label'width='10%'><fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/></td>
		<td class="fields"  width='10%'><input type='checkbox'  name='current_encounter' id='current_encounter' checked value="Y"></td>
 
		<td class="LABEL" width='5%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class="fields"  width='15%' colspan=2 >
		<select name="order_by1" id="order_by1" >
		<option value='O'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></option>
		<option value='D'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></option>
		</select>
        </td>
</tr>
<tr>
		<td class="LABEL" width='10%'><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
		<td class="fields"  width='25%'>
		<select name="order_by2" id="order_by2" >
		<option value='2'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value='1' selected><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></select>
        </td>
              <!-- 38981 start -->
                 <td class="fields" width='20%'><input type='checkbox'  name="include_Support_Diag" id="include_Support_Diag" unchecked value="N" >
                 <fmt:message key="eCA.includesupportdiagnosis.label" bundle="${ca_labels}"/></td>
        
		 <!-- 38981 end --> 
		
		
		<td width='5%'></td> 
	    <td  width='15%' align='right' colspan=2>
		<input type="button" class="button" name="btnSearch" id="btnSearch" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="funSearchnew();">	
		<input type="button" class="button" name="clearSearch" id="clearSearch" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="Clear_Allnew();">	
        </td>
</tr>
</table>
	<!-- added by kishore kumar n on 10/12/2008  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<input type="hidden" name="scheme" id="scheme" value="<%=scheme%>">
<input type="hidden" name="scheme_desc" id="scheme_desc" value="<%=scheme_desc%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="sex" id="sex" value="<%=request.getParameter("sex")%>">
<input type="hidden" name="Dob" id="Dob" value="<%=request.getParameter("Dob")%>">
<input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
<input type="hidden" name="result_linked_rec_type" id="result_linked_rec_type" value="<%=result_linked_rec_type%>">
<input type="hidden" name="call_from_link_doc_btn" id="call_from_link_doc_btn" value="<%=call_from_link_doc_btn%>"><!--IN061907-->
<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>"><!--IN061907-->
</form>
<!--IN061907 start-->
<%
if(call_from_link_doc_btn.equals("YES"))
{
%>
	<script>
		funSearchnew();
	</script>
<%
}
//IN061907
//IN061908 Start.
else{ 
%>
	<script>
		funSearchnew();
	</script>
<%
}
//IN061908 End.
%>
</body>
</html>

<%
}
catch(Exception e)
{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt !=null) pstmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>

