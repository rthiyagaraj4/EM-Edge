<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eMP/js/ftiens4.js"></script>
<script src="../../eMP/js/photosturism.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="test()" onKeyDown='lockKey()'>
<form name="vpfm" id="vpfm">

<%
String patient = request.getParameter("Patient_ID");
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1= null;
PreparedStatement pstmt2= null;


ResultSet rs =null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;

int one=0;
int two=0;
int three=0;
int four=0;

try{

	con = ConnectionManager.getConnection(request);

	String sql="select patient_id, family_link_no, decode(patient_id,?,2,3),sex  from mp_patient "+
	"where patient_id = ? or  "+
	"family_link_no = ? "+
	"union "+
	"select patient_id, family_link_no, 1,sex "+
	"from mp_patient "+
	"where patient_id = (select family_link_no from mp_patient where patient_id = ?) "+
	"union "+
	"select patient_id, family_link_no, 4,sex "+
	"from mp_patient "+
	"where family_link_no = (select family_link_no from mp_patient "+
				"where patient_id = ?) "+
	"and patient_id <> ? "+
	"order by 3,1 ";

	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,patient);
	pstmt.setString(2,patient);
	pstmt.setString(3,patient);
	pstmt.setString(4,patient);
	pstmt.setString(5,patient);
	pstmt.setString(6,patient);
	rs=pstmt.executeQuery();

	while(rs.next()) 
	{
		
		if(rs.getInt(3)==1) one++;
		if(rs.getInt(3)==2) two++;
		if(rs.getInt(3)==3) three++;
		if(rs.getInt(3)==4) four++;
	}
	
	int z=one + two + three + four;
	
	if(z<2){
		out.println("<script>alert(getMessage('NO_FAMILY_MEMBERS','MP'));</script>");   		
		out.println("<script>parent.plineFrame.location.href ='../../eCommon/html/blank.html'</script>");
		out.println("<script>parent.f_query_add_mod.location.href ='../../eMP/jsp/blank.jsp?step_1=6'</script>");

		for(int b=0;b<z;b++){
			out.println("<input type='hidden'  name='h"+b+"' id='h"+b+"'  >");
		}

		for(int s=0;s<z;s++){
			out.println("<input type='hidden'  name='p"+s+"' id='p"+s+"'  >");
		}

		for(int v=0;v<z;v++){
		out.println("<input type='hidden'  name='k"+v+"' id='k"+v+"'  >");
		}

		out.println("<input type='hidden'  name='hiddenid' id='hiddenid'  >");	
		out.println("<input type='hidden' name='oneu' id='oneu' >");
		out.println("<input type='hidden' name='twou' id='twou' >");
		out.println("<input type='hidden' name='threeu' id='threeu' >");
		out.println("<input type='hidden' name='fouru' id='fouru' >");
		out.println("<input type='hidden' name='zval' id='zval' >");
		//out.println("<input type='hidden' name='p_det' id='p_det' >");
		out.println("<input type='hidden' name='p_id' id='p_id' >");
	}
	else
	{

		/*String sql4;
		String Pat_Details="";
		sql4 = "select get_patient_line(?,?) from dual";
		pstmt1 = con.prepareStatement(sql4);
		pstmt1.setString(1,patient);
		pstmt1.setString(2,localeName);
		rs2 = pstmt1.executeQuery();
		rs2.next();
		Pat_Details = rs2.getString(1);*/
		String s1[]=new String[z];
		String s2[]=new String[z];
		String s3[]=new String[z];
		rs1=pstmt.executeQuery();
		int i=0;
		while(rs1.next()){
		s2[i]=rs1.getString(1);
		s1[i]=rs1.getString(2);
		s3[i]=rs1.getString(4);
		i++;
		}

		String pat_info="";
		String get[]=new String[z];

		for(int k=0;k<z;k++){
		pat_info="select get_patient_reln(?) from dual";
		if(patient.equals(s2[k])) out.println("<input type='hidden'  name='hiddenid' id='hiddenid'  value=" + k + ">");
		pstmt2 = con.prepareStatement(pat_info);
		pstmt2.setString(1,s2[k]);
		rs3=pstmt2.executeQuery();
		while(rs3.next()){
		get[k]=rs3.getString(1);
		
		}
	}

	for(int b=0;b<z;b++){
		out.println("<input type='hidden'  name='h"+b+"' id='h"+b+"'  value=\""+get[b]+"\">");
	}

	for(int s=0;s<z;s++){
		out.println("<input type='hidden'  name='p"+s+"' id='p"+s+"'  value=\""+s2[s]+"\">");
	}

	for(int v=0;v<z;v++){
		out.println("<input type='hidden'  name='k"+v+"' id='k"+v+"'  value=\""+s3[v]+"\">");
	}

	out.println("<input type='hidden' name='oneu' id='oneu' value="+one+">");
	out.println("<input type='hidden' name='twou' id='twou' value="+two+">");
	out.println("<input type='hidden' name='threeu' id='threeu' value="+three+">");
	out.println("<input type='hidden' name='fouru' id='fouru' value="+four+">");
	out.println("<input type='hidden' name='zval' id='zval' value="+z+">");
	//out.println("<input type='hidden' name='p_det' id='p_det' value=\""+Pat_Details+"\">");
	out.println("<input type='hidden' name='p_id' id='p_id' value=\""+patient+"\">");
	
	}
	%><input type='hidden' name='s_Style' id='s_Style' value="<%=sStyle%>"><%
}
catch(Exception e){
	out.println("<script>alert(getMessage('NO_FAMILY_MEMBERS','MP'));</script>"); 
	out.println("<script>parent.plineFrame.location.href ='../../eCommon/html/blank.html'</script>");
	out.println("<script>parent.f_query_add_mod.location.href ='../../eMP/jsp/blank.jsp?step_1=6'</script>");
} 
finally
{
	if(pstmt != null) pstmt.close();
	if(pstmt1 != null) pstmt1.close();
	if(pstmt2 != null) pstmt2.close();
	if(rs3 != null) rs3.close();
	if(rs2 != null) rs2.close();
	if(rs1 != null) rs1.close();
	if(rs != null) rs.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body> 
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

