<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String applicationid = XHDBAdapter.checkNull(request.getParameter("applicationid"));
String elementid	  = XHDBAdapter.checkNull(request.getParameter("nontabelementid"));
String	slctd_Master_Val =	 XHDBAdapter.checkNull(request.getParameter("slctd_Master_Val"));
//System.out.println("XHTranslationNonTableValuesSetupQueryResult.jsp applicationid : "+applicationid+", Elementid :"+elementid);

String eHiscode = XHDBAdapter.checkNull(request.getParameter("eHiscode"));
String crossrefcode = XHDBAdapter.checkNull(request.getParameter("crossrefcode"));
String crossRefdesc = XHDBAdapter.checkNull(request.getParameter("crossRefdesc"));
String act_mode = XHDBAdapter.checkNull(request.getParameter("act_mode"));
//	System.out.println("act_mode"+act_mode);
String ehis_code = XHDBAdapter.checkNull(request.getParameter("crossrefcode"));
String ehis_desc = XHDBAdapter.checkNull(request.getParameter("ehis_desc"));
//	System.out.println("slctd_Master_Val"+slctd_Master_Val);

Connection con            = null;
Statement stmt				= null;
ResultSet rs					= null;		
	
//String ehis_code = "";
//String ehis_desc = "";
String look_qry = "";
String lookupFlag = "false";
String qryEnbl = "";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='javascript' src='../js/XHTranslationManagerN.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<Script>

function funMasterCode()
{
	this.document.forms[0].submit();
}

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	var act = '../../eXH/jsp/XHTranslationNonTableValuesSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="applnontablecode";
	this.document.forms[0].submit();
}


function hide()
{
	
	if(this.document.forms[0].mode.value=='U')
	{
		
		document.forms[0].nontabmedicomcode1.disabled=true;
	}
}


</Script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload='hide();'>
<form name="application_element_setup_form1" id="application_element_setup_form1" method='post' target='messageFrame'  action="../../servlet/eXH.XHTranslationNonTableValuesServlet">
<input type=hidden name=action_type>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>	
	<td class=label ><fmt:message key="eXH.ExtCode.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=nontabmedicomcode1 id="nontabmedicomcode1" size=25 value='<%=eHiscode%>'  > <img					src='../../eCommon/images/mandatory.gif' align=middle><input type=hidden name=nontabmedicomcode value='<%=eHiscode%>'>
	</td><td></td><td></td>
</tr>

<%
			try{
			   con = ConnectionManager.getConnection(request);		   
			   stmt= con.createStatement();
	
			   String sql = "SELECT lookup_qry FROM xh_mapping WHERE column_id = UPPER('"+slctd_Master_Val+"') ";
	//				System.out.println("XHPopulateTransMasterN.jsp sql 122 : "+sql.toString());
				rs = stmt.executeQuery(sql) ;
				while (rs.next()){
					look_qry = XHDBAdapter.checkNull(rs.getString(1));		
	//				System.out.println("Look Up Query : "+look_qry);
				}
			}
			catch(Exception e){
				System.out.println("XHTranslationNonTableValuesSetupQueryResult.jsp : "+e.toString());
			}
			finally{
					if(rs != null)	   rs.close();
					if(stmt !=null)   stmt.close();
					if(con != null)  ConnectionManager.returnConnection(con,request); 	
			}

			if(act_mode.equals("I")) {
				if(look_qry.equals("")){
					qryEnbl = "N";
				}
				else{
					qryEnbl = "Y";
				}
			}

			
			if(act_mode.equals("U")) {
				if(ehis_desc.equals("")){
					qryEnbl = "N";
				}
				else{
					qryEnbl = "Y";
				}
			}
//			System.out.println(" qryEnbl :  "+qryEnbl);
//			if(look_qry.equals("") || ehis_desc.equals("")){
			if(qryEnbl.equals("N")){
//			System.out.println(" Look Up Query :  null");
			lookupFlag ="false";
			%>
			<tr>	
				<td class=label ><fmt:message key="eXH.ibaehisCode.Label" bundle="${xh_labels}"/></td>
				<td align=left><input type=text name='nontabcrosscode' id='nontabcrosscode' id="nontabcrosscode" size=25 value='<%=crossrefcode%>'  > <img src='../../eCommon/images/mandatory.gif' align=middle></td><td></td><td></td>
			</tr>
			
			<tr><td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td align=left><input type=text name=nontabcrossdesc id="nontabcrossdesc" size=25 value='<%=crossRefdesc.equals("")?"&nbsp;":crossRefdesc%>'  ></td>
				<td></td><td></td>
			</tr>
			<%
		}
		else if(qryEnbl.equals("Y")) {
//		System.out.println(" look_qry not null");
		lookupFlag = "true";
		%>
		<tr>
		<!-- <fmt:message key="eXH.ibaehisCode.Label" bundle="${xh_labels}"/> -->
		<td class=label >Cross Reference</td>
		<td align=left>
			<input type="hidden" name="ehis_code" id="ehis_code" size=10 maxlength=6  value="<%=XHDBAdapter.checkNull(ehis_code)%>">
			<input type=text id="ehis_desc"  name ='ehis_desc' size=35 value='<%=XHDBAdapter.checkNull(ehis_desc)%>' onBlur="searcheHISCode('<%=look_qry%>');"> <input  type="button"  name=eHISCodeSearch value='?'    onClick="searcheHISCode('<%=look_qry%>');">
			<img src='../../eCommon/images/mandatory.gif' align=middle>
		</td>
		</tr>

<% }%>

<tr>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label></dt>
<td class="BUTTON">
	<% if(act_mode.equals("U")) { %>
		<input class='button' type='button'  name='Delete' id='Delete' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick="deleteRecord('<%=lookupFlag%>')">&nbsp;&nbsp;&nbsp; <input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="addRecord('<%=lookupFlag%>')"><% } else { %><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="addRecord('<%=lookupFlag%>')">
		<% } %> </td></tr>
</table>

<input type=hidden name='applicationid' id='applicationid' value='<%=applicationid%>'>
<input type=hidden name='nontabelementid' id='nontabelementid' value='<%=elementid%>'>
<input type=hidden name='mode' id='mode' value='<%=act_mode%>'>
<input type=hidden name='lookupFlag' id='lookupFlag' value='<%=lookupFlag%>'>

</form>
</BODY>
</HTML>

