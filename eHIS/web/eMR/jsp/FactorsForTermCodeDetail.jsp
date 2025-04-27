<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<!--  <jsp:useBean id="FactorsForTermCodebn" class="webbeans.eCommon.RecordSet" scope="session"/>   -->
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 
%>

<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../js/FactorsForTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
Statement pstmt = null;
PreparedStatement pstmt1=null;
ResultSet rs = null;
String term_set_id = request.getParameter("term_set_id");
String term_code = request.getParameter("term_code");
//String flagSelect=request.getParameter("flagSelect");
//String from = request.getParameter("from") ;
//String to = request.getParameter("to") ;
String className = "";
String chked_factor = "";
String factor_val = "";
int maxRecord = 0;
int start = 1 ;
int end = 1 ;
int j = 1;
//int rec_index = -1;
try
{
	con = ConnectionManager.getConnection(request);
	ArrayList arr_factor = null;
	ArrayList arr_main = new ArrayList();

	//FactorsForTermCodebn.clearAll();
	String sql_factors_for_bean = "select a.factor_code factor_code ,b.defn_characteristic_yn defn_characteristic_yn,b.related_factor_yn related_factor_yn,b.risk_factor_yn risk_factor_yn  from mr_factor_for_term_code a, mr_factor_lang_vw b where a.term_set_id =? and a.term_code =? and b.factor_code=a.factor_code and b.language_id=?";
	//pstmt = con.createStatement();
	pstmt1 = con.prepareStatement(sql_factors_for_bean);
	pstmt1.setString(1,term_set_id);
	pstmt1.setString(2,term_code);
	pstmt1.setString(3,locale);
	rs = pstmt1.executeQuery();
	if(rs!=null)
	{
		while(rs.next())
		{
			arr_factor = new ArrayList();
			arr_factor.add(rs.getString("factor_code"));
			arr_factor.add(rs.getString("defn_characteristic_yn"));
			arr_factor.add(rs.getString("related_factor_yn"));
			arr_factor.add(rs.getString("risk_factor_yn"));
			arr_main.add(arr_factor);
			//FactorsForTermCodebn.putObject(arr_factor);
		}
		if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
	}
	
	
	String sql_factors = "select factor_code, long_desc factor_desc,	decode(defn_characteristic_yn,'Y','Defining Characteristics',		decode(related_factor_yn||risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor'))factor_type,defn_characteristic_yn,related_factor_yn,risk_factor_yn,'I' db_action from mr_factor where factor_code not in (select factor_code from mr_factor_for_term_code where term_set_id = '"+term_set_id+"' and term_code ='"+term_code+"') and eff_status = 'E' union all select a.factor_code, b.long_desc factor_desc, decode(b.defn_characteristic_yn,'Y','Defining Characteristic',		decode(b.related_factor_yn||b.risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor')) factor_type,b.defn_characteristic_yn,b.related_factor_yn,b.risk_factor_yn,'U' db_action  from mr_factor_for_term_code a, mr_factor_lang_vw b where a.term_set_id = '"+term_set_id+"' and a.term_code = '"+term_code+"' and b.factor_code=a.factor_code and b.language_id='"+locale+"' order by factor_desc";
	try
	{
		pstmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=pstmt.executeQuery(sql_factors);
		rs.last();
		maxRecord = rs.getRow();
		end=maxRecord;
		rs.beforeFirst();
	}
	catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}
%>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad='chkForSelectAll(<%=start%>,<%=end%>)''>
<form name='FactorsForTermCodeDetail' id='FactorsForTermCodeDetail' method='post' action=''>
<table width='95%'>

</table>
<table border="1" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<TR>
		<TH width='60%' align='left'><fmt:message key="eMR.Factors.label" bundle="${mr_labels}"/></TH>
		<TH width='25%' align='left'><fmt:message key="eMR.FactorTypes.label" bundle="${mr_labels}"/></TH>
		<TH><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>&nbsp;<INPUT TYPE="checkbox" name="chkall" id="chkall" onclick='chkallvall(this,<%=start%>,<%=end%>)'></TH>
	</TR>
<%
	if(rs!=null)
	{
		while(rs.next() && j<=maxRecord)
		{
			chked_factor="";
			if ( j % 2 == 0 )
				className = "QRYEVEN" ;
			else
				className = "QRYODD" ;
			out.println("<tr>");
			out.println("<td class='"+className+"' align='left'>"+rs.getString(2)+"</td>");
			out.println("<td class='"+className+"' align='left'>"+rs.getString(3)+"</td>");
			//rec_index=-1;
			int iSize = arr_main.size();
			for(int l=0;l<iSize;l++)
		    {
				ArrayList fact_arr=new ArrayList();
				//fact_arr=(ArrayList)FactorsForTermCodebn.getObject(l);
				fact_arr = (ArrayList)arr_main.get(l);
				String fact_code = (String) fact_arr.get(0);
				if(fact_code.equals(rs.getString(1)))
				{
					chked_factor = "checked";
					factor_val = "U";
					//rec_index=l;
					break;
				}
				else
				{
					chked_factor = "";
					factor_val = "I";
				}
			}
/*			if(rec_index!=-1)
			if(chked_factor.equals("checked"))   	 
				//FactorsForTermCodebn.removeObject(rec_index);
				arr_main.remove(rec_index);
				*/
%>
			<td class='<%=className%>' align='center'><INPUT TYPE='checkbox' name='chks_factor<%=j%>' id='chks_factor<%=j%>'  onclick='remchk(this);' value='<%=factor_val%>' <%=chked_factor%> ></td>
<%
			out.println("</tr>");
			out.println("<input type='hidden' name=factor_code"+j+" value='"+rs.getString(1)+"'>");
			out.println("<input type='hidden' name=defn_characteristic_yn"+j+" value='"+rs.getString(4)+"'>");
			out.println("<input type='hidden' name=related_factor_yn"+j+" value='"+rs.getString(5)+"'>");
			out.println("<input type='hidden' name=risk_factor_yn"+j+" value='"+rs.getString(6)+"'>");
			j++;
		}
		--j;
	}
%>
</table>
<%
}
catch(Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con);
	//session.setAttribute("FactorsForTermCodebn", FactorsForTermCodebn);
}
%>
<INPUT type=hidden name="from" id="from" value="<%=start%>">
<INPUT type=hidden name="to" id="to" value="<%=end%>">
<INPUT type=hidden name="start" id="start" value="<%=start%>">
<INPUT type=hidden name="end" id="end" value="<%=end%>">
<INPUT type=hidden name="selectall" id="selectall" value="">
<INPUT type=hidden name="term_set_id" id="term_set_id" value="<%=term_set_id%>">
<INPUT type=hidden name="term_code" id="term_code" value="<%=term_code%>">
<INPUT type=hidden name="total_count" id="total_count" value="<%=j%>">
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

