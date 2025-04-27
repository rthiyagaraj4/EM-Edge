<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String pr_id = request.getParameter("clinic_code");

String from_item_chk = request.getParameter("from_item_chk");

if(pr_id == null || pr_id.equals("null")) pr_id = "";
if(from_item_chk == null || from_item_chk.equals("null")) from_item_chk = "";
Connection con = null;

Statement stmt = null;
ResultSet rs = null;
PreparedStatement pstmt1=null;
ResultSet rs1 = null;

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


try{

con=ConnectionManager.getConnection(request);

stmt = con.createStatement();
PreparedStatement pstmt; 
    String wd1="";
    String wd2="";
    String wd3="";
    String wd4="";
    String wd5="";
    String wd6="";
    String wd7="";
    
    String emergency="";
    String first="";
    String follow="";
    String routine="";
    String  series="";
    String consult="";
    
    String yes="Y";
    String no="N";
	String WORKING_WEEK_1_DAY_1 = "", WORKING_WEEK_2_DAY_1 = "",WORKING_WEEK_3_DAY_1 = "";
	String WORKING_WEEK_1_DAY_2 = "", WORKING_WEEK_2_DAY_2 = "",WORKING_WEEK_3_DAY_2 = "";
	String WORKING_WEEK_1_DAY_3 = "", WORKING_WEEK_2_DAY_3 = "",WORKING_WEEK_3_DAY_3 = "";
	String WORKING_WEEK_1_DAY_4 = "", WORKING_WEEK_2_DAY_4 = "",WORKING_WEEK_3_DAY_4 = "";
	String WORKING_WEEK_1_DAY_5 = "", WORKING_WEEK_2_DAY_5 = "",WORKING_WEEK_3_DAY_5 = "";
	String WORKING_WEEK_1_DAY_6 = "", WORKING_WEEK_2_DAY_6 = "",WORKING_WEEK_3_DAY_6 = "";
	String WORKING_WEEK_1_DAY_7 = "", WORKING_WEEK_2_DAY_7 = "",WORKING_WEEK_3_DAY_7 = "";
	
	String WORKING_WEEK_4_DAY_1 = "", WORKING_WEEK_5_DAY_1 = "";
	String WORKING_WEEK_4_DAY_2 = "", WORKING_WEEK_5_DAY_2 = "";
	String WORKING_WEEK_4_DAY_3 = "", WORKING_WEEK_5_DAY_3 = "";
	String WORKING_WEEK_4_DAY_4 = "", WORKING_WEEK_5_DAY_4 = "";
	String WORKING_WEEK_4_DAY_5 = "", WORKING_WEEK_5_DAY_5 = "";
	String WORKING_WEEK_4_DAY_6 = "", WORKING_WEEK_5_DAY_6 = "";
	String WORKING_WEEK_4_DAY_7 = "", WORKING_WEEK_5_DAY_7 = "";


    
  
    String facilityid="";
    facilityid=(String)session.getValue("facility_id");
  

  String sql1 = "SELECT WORKING_WEEK_1_DAY_1, WORKING_WEEK_1_DAY_2, WORKING_WEEK_1_DAY_3, WORKING_WEEK_1_DAY_4, WORKING_WEEK_1_DAY_5, WORKING_WEEK_1_DAY_6, WORKING_WEEK_1_DAY_7, WORKING_WEEK_2_DAY_1, WORKING_WEEK_2_DAY_2, WORKING_WEEK_2_DAY_3, WORKING_WEEK_2_DAY_4, WORKING_WEEK_2_DAY_5, WORKING_WEEK_2_DAY_6, WORKING_WEEK_2_DAY_7, WORKING_WEEK_3_DAY_1, WORKING_WEEK_3_DAY_2, WORKING_WEEK_3_DAY_3, WORKING_WEEK_3_DAY_4, WORKING_WEEK_3_DAY_5, WORKING_WEEK_3_DAY_6, WORKING_WEEK_3_DAY_7, WORKING_WEEK_4_DAY_1, WORKING_WEEK_4_DAY_2, WORKING_WEEK_4_DAY_3, WORKING_WEEK_4_DAY_4, WORKING_WEEK_4_DAY_5, WORKING_WEEK_4_DAY_6, WORKING_WEEK_4_DAY_7, WORKING_WEEK_5_DAY_1, WORKING_WEEK_5_DAY_2, WORKING_WEEK_5_DAY_3, WORKING_WEEK_5_DAY_4, WORKING_WEEK_5_DAY_5, WORKING_WEEK_5_DAY_6, WORKING_WEEK_5_DAY_7  FROM OP_CLINIC WHERE clinic_code = '"+pr_id+"' and facility_id = '"+facilityid+"'";
 pstmt1 = con.prepareStatement("sql1");
 rs1 = pstmt1.executeQuery(sql1);
 if (rs1!=null)
	{
		while(rs1.next())
		{
			WORKING_WEEK_1_DAY_1 = rs1.getString("WORKING_WEEK_1_DAY_1");
			WORKING_WEEK_1_DAY_2 = rs1.getString("WORKING_WEEK_1_DAY_2");
			WORKING_WEEK_1_DAY_3 = rs1.getString("WORKING_WEEK_1_DAY_3");
			WORKING_WEEK_1_DAY_4 = rs1.getString("WORKING_WEEK_1_DAY_4");
			WORKING_WEEK_1_DAY_5 = rs1.getString("WORKING_WEEK_1_DAY_5");
			WORKING_WEEK_1_DAY_6 = rs1.getString("WORKING_WEEK_1_DAY_6");
			WORKING_WEEK_1_DAY_7 = rs1.getString("WORKING_WEEK_1_DAY_7");
			WORKING_WEEK_2_DAY_1 = rs1.getString("WORKING_WEEK_2_DAY_1");
			WORKING_WEEK_2_DAY_2 = rs1.getString("WORKING_WEEK_2_DAY_2");
			WORKING_WEEK_2_DAY_3 = rs1.getString("WORKING_WEEK_2_DAY_3");
			WORKING_WEEK_2_DAY_4 = rs1.getString("WORKING_WEEK_2_DAY_4");
			WORKING_WEEK_2_DAY_5 = rs1.getString("WORKING_WEEK_2_DAY_5");
			WORKING_WEEK_2_DAY_6 = rs1.getString("WORKING_WEEK_2_DAY_6");
			WORKING_WEEK_2_DAY_7 = rs1.getString("WORKING_WEEK_2_DAY_7");
			WORKING_WEEK_3_DAY_1 = rs1.getString("WORKING_WEEK_3_DAY_1");
			WORKING_WEEK_3_DAY_2 = rs1.getString("WORKING_WEEK_3_DAY_2");
			WORKING_WEEK_3_DAY_3 = rs1.getString("WORKING_WEEK_3_DAY_3");
			WORKING_WEEK_3_DAY_4 = rs1.getString("WORKING_WEEK_3_DAY_4");
			WORKING_WEEK_3_DAY_5 = rs1.getString("WORKING_WEEK_3_DAY_5");
			WORKING_WEEK_3_DAY_6 = rs1.getString("WORKING_WEEK_3_DAY_6");
			WORKING_WEEK_3_DAY_7 = rs1.getString("WORKING_WEEK_3_DAY_7");

			WORKING_WEEK_4_DAY_1 = rs1.getString("WORKING_WEEK_4_DAY_1");
			WORKING_WEEK_4_DAY_2 = rs1.getString("WORKING_WEEK_4_DAY_2");
			WORKING_WEEK_4_DAY_3 = rs1.getString("WORKING_WEEK_4_DAY_3");
			WORKING_WEEK_4_DAY_4 = rs1.getString("WORKING_WEEK_4_DAY_4");
			WORKING_WEEK_4_DAY_5 = rs1.getString("WORKING_WEEK_4_DAY_5");
			WORKING_WEEK_4_DAY_6 = rs1.getString("WORKING_WEEK_4_DAY_6");
			WORKING_WEEK_4_DAY_7 = rs1.getString("WORKING_WEEK_4_DAY_7");

			WORKING_WEEK_5_DAY_1 = rs1.getString("WORKING_WEEK_5_DAY_1");
			WORKING_WEEK_5_DAY_2 = rs1.getString("WORKING_WEEK_5_DAY_2");
			WORKING_WEEK_5_DAY_3 = rs1.getString("WORKING_WEEK_5_DAY_3");
			WORKING_WEEK_5_DAY_4 = rs1.getString("WORKING_WEEK_5_DAY_4");
			WORKING_WEEK_5_DAY_5 = rs1.getString("WORKING_WEEK_5_DAY_5");
			WORKING_WEEK_5_DAY_6 = rs1.getString("WORKING_WEEK_5_DAY_6");
			WORKING_WEEK_5_DAY_7 = rs1.getString("WORKING_WEEK_5_DAY_7");

		}
	}

	if(rs1 != null) rs1.close();
	if(pstmt1 != null) pstmt1.close();

	
	if (WORKING_WEEK_1_DAY_1.equals("W")) {
   %>  <script>parent.frames[0].document.forms[0].working_week_1_day_1.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_1.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_1.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_1.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_1.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_1.disabled=false;
	</script><% }else {%><script>parent.frames[0].document.forms[0].working_week_1_day_1.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_1.checked=false;	parent.frames[0].document.forms[0].working_week_1_day_1.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_1.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_1.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_1.disabled=true;
	</script><%}
	if (WORKING_WEEK_1_DAY_2.equals("W")) {
	%><script>parent.frames[0].document.forms[0].working_week_1_day_2.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_2.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_2.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_2.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_2.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_2.disabled=false;
	</script><%	} else {
	%><script>parent.frames[0].document.forms[0].working_week_1_day_2.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_2.checked=false;
	parent.frames[0].document.forms[0].working_week_1_day_2.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_2.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_2.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_2.disabled=true;
	</script><%}
	if (WORKING_WEEK_1_DAY_3.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_1_day_3.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_3.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_3.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_3.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_3.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_3.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_1_day_3.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_3.checked=false;
	parent.frames[0].document.forms[0].working_week_1_day_3.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_3.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_3.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_3.disabled=true;
	</script><%}
	if (WORKING_WEEK_1_DAY_4.equals("W")){%><script>parent.frames[0].document.forms[0].working_week_1_day_4.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_4.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_4.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_4.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_4.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_4.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_1_day_4.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_4.checked=false;
	parent.frames[0].document.forms[0].working_week_1_day_4.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_4.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_4.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_4.disabled=true;
	</script><%}
	if (WORKING_WEEK_1_DAY_5.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_1_day_5.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_5.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_5.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_5.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_5.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_5.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_1_day_5.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_5.checked=false;
	parent.frames[0].document.forms[0].working_week_1_day_5.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_5.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_5.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_5.disabled=true;
	</script><%}	
  	if (WORKING_WEEK_1_DAY_6.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_1_day_6.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_6.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_6.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_6.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_6.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_6.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_1_day_6.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_6.checked=false;
	parent.frames[0].document.forms[0].working_week_1_day_6.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_6.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_6.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_6.disabled=true;
	</script><%}
	if (WORKING_WEEK_1_DAY_7.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_1_day_7.value='W';
	parent.frames[0].document.forms[0].working_week_1_day_7.checked=true;	
	parent.frames[0].document.forms[0].working_week_1_day_7.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_7.value='W';
	parent.frames[0].document.forms[0].pract_working_week_1_day_7.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_1_day_7.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_1_day_7.value='H';
	parent.frames[0].document.forms[0].working_week_1_day_7.checked=false;
	parent.frames[0].document.forms[0].working_week_1_day_7.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_1_day_7.value='H';
	parent.frames[0].document.forms[0].pract_working_week_1_day_7.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_1_day_7.disabled=true;
	</script><%}

//////////
if (WORKING_WEEK_2_DAY_1.equals("W")) {
   %>  <script>parent.frames[0].document.forms[0].working_week_2_day_1.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_1.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_1.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_1.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_1.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_1.disabled=false;
	</script><% }else {%><script>parent.frames[0].document.forms[0].working_week_2_day_1.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_1.checked=false;	parent.frames[0].document.forms[0].working_week_2_day_1.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_1.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_1.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_1.disabled=true;
	</script><%}
	if (WORKING_WEEK_2_DAY_2.equals("W")) {
	%><script>parent.frames[0].document.forms[0].working_week_2_day_2.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_2.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_2.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_2.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_2.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_2.disabled=false;
	</script><%	} else {
	%><script>parent.frames[0].document.forms[0].working_week_2_day_2.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_2.checked=false;
	parent.frames[0].document.forms[0].working_week_2_day_2.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_2.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_2.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_2.disabled=true;
	</script><%}
	if (WORKING_WEEK_2_DAY_3.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_2_day_3.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_3.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_3.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_3.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_3.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_3.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_2_day_3.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_3.checked=false;
	parent.frames[0].document.forms[0].working_week_2_day_3.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_3.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_3.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_3.disabled=true;
	</script><%}
	if (WORKING_WEEK_2_DAY_4.equals("W")){%><script>parent.frames[0].document.forms[0].working_week_2_day_4.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_4.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_4.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_4.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_4.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_4.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_2_day_4.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_4.checked=false;
	parent.frames[0].document.forms[0].working_week_2_day_4.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_4.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_4.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_4.disabled=true;
	</script><%}
	if (WORKING_WEEK_2_DAY_5.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_2_day_5.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_5.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_5.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_5.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_5.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_5.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_2_day_5.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_5.checked=false;
	parent.frames[0].document.forms[0].working_week_2_day_5.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_5.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_5.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_5.disabled=true;
	</script><%}	
  	if (WORKING_WEEK_2_DAY_6.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_2_day_6.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_6.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_6.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_6.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_6.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_6.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_2_day_6.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_6.checked=false;
	parent.frames[0].document.forms[0].working_week_2_day_6.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_6.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_6.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_6.disabled=true;
	</script><%}
	if (WORKING_WEEK_2_DAY_7.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_2_day_7.value='W';
	parent.frames[0].document.forms[0].working_week_2_day_7.checked=true;	
	parent.frames[0].document.forms[0].working_week_2_day_7.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_7.value='W';
	parent.frames[0].document.forms[0].pract_working_week_2_day_7.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_2_day_7.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_2_day_7.value='H';
	parent.frames[0].document.forms[0].working_week_2_day_7.checked=false;
	parent.frames[0].document.forms[0].working_week_2_day_7.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_2_day_7.value='H';
	parent.frames[0].document.forms[0].pract_working_week_2_day_7.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_2_day_7.disabled=true;
	</script><%}
//////////
if (WORKING_WEEK_3_DAY_1.equals("W")) {
   %>  <script>parent.frames[0].document.forms[0].working_week_3_day_1.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_1.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_1.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_1.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_1.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_1.disabled=false;
	</script><% }else {%><script>parent.frames[0].document.forms[0].working_week_3_day_1.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_1.checked=false;	parent.frames[0].document.forms[0].working_week_3_day_1.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_1.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_1.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_1.disabled=true;
	</script><%}
	if (WORKING_WEEK_3_DAY_2.equals("W")) {
	%><script>parent.frames[0].document.forms[0].working_week_3_day_2.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_2.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_2.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_2.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_2.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_2.disabled=false;
	</script><%	} else {
	%><script>parent.frames[0].document.forms[0].working_week_3_day_2.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_2.checked=false;
	parent.frames[0].document.forms[0].working_week_3_day_2.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_2.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_2.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_2.disabled=true;
	</script><%}
	if (WORKING_WEEK_3_DAY_3.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_3_day_3.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_3.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_3.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_3.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_3.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_3.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_3_day_3.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_3.checked=false;
	parent.frames[0].document.forms[0].working_week_3_day_3.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_3.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_3.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_3.disabled=true;
	</script><%}
	if (WORKING_WEEK_3_DAY_4.equals("W")){%><script>parent.frames[0].document.forms[0].working_week_3_day_4.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_4.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_4.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_4.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_4.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_4.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_3_day_4.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_4.checked=false;
	parent.frames[0].document.forms[0].working_week_3_day_4.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_4.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_4.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_4.disabled=true;
	</script><%}
	if (WORKING_WEEK_3_DAY_5.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_3_day_5.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_5.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_5.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_5.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_5.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_5.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_3_day_5.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_5.checked=false;
	parent.frames[0].document.forms[0].working_week_3_day_5.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_5.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_5.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_5.disabled=true;
	</script><%}	
  	if (WORKING_WEEK_3_DAY_6.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_3_day_6.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_6.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_6.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_6.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_6.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_6.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_3_day_6.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_6.checked=false;
	parent.frames[0].document.forms[0].working_week_3_day_6.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_6.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_6.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_6.disabled=true;
	</script><%}
	if (WORKING_WEEK_3_DAY_7.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_3_day_7.value='W';
	parent.frames[0].document.forms[0].working_week_3_day_7.checked=true;	
	parent.frames[0].document.forms[0].working_week_3_day_7.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_7.value='W';
	parent.frames[0].document.forms[0].pract_working_week_3_day_7.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_3_day_7.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_3_day_7.value='H';
	parent.frames[0].document.forms[0].working_week_3_day_7.checked=false;
	parent.frames[0].document.forms[0].working_week_3_day_7.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_3_day_7.value='H';
	parent.frames[0].document.forms[0].pract_working_week_3_day_7.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_3_day_7.disabled=true;
	</script><%}
/////////
if (WORKING_WEEK_4_DAY_1.equals("W")) {
   %>  <script>parent.frames[0].document.forms[0].working_week_4_day_1.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_1.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_1.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_1.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_1.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_1.disabled=false;
	</script><% }else {%><script>parent.frames[0].document.forms[0].working_week_4_day_1.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_1.checked=false;	parent.frames[0].document.forms[0].working_week_4_day_1.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_1.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_1.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_1.disabled=true;
	</script><%}
	if (WORKING_WEEK_4_DAY_2.equals("W")) {
	%><script>parent.frames[0].document.forms[0].working_week_4_day_2.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_2.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_2.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_2.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_2.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_2.disabled=false;
	</script><%	} else {
	%><script>parent.frames[0].document.forms[0].working_week_4_day_2.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_2.checked=false;
	parent.frames[0].document.forms[0].working_week_4_day_2.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_2.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_2.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_2.disabled=true;
	</script><%}
	if (WORKING_WEEK_4_DAY_3.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_4_day_3.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_3.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_3.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_3.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_3.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_3.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_4_day_3.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_3.checked=false;
	parent.frames[0].document.forms[0].working_week_4_day_3.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_3.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_3.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_3.disabled=true;
	</script><%}
	if (WORKING_WEEK_4_DAY_4.equals("W")){%><script>parent.frames[0].document.forms[0].working_week_4_day_4.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_4.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_4.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_4.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_4.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_4.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_4_day_4.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_4.checked=false;
	parent.frames[0].document.forms[0].working_week_4_day_4.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_4.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_4.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_4.disabled=true;
	</script><%}
	if (WORKING_WEEK_4_DAY_5.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_4_day_5.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_5.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_5.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_5.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_5.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_5.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_4_day_5.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_5.checked=false;
	parent.frames[0].document.forms[0].working_week_4_day_5.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_5.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_5.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_5.disabled=true;
	</script><%}	
  	if (WORKING_WEEK_4_DAY_6.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_4_day_6.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_6.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_6.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_6.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_6.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_6.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_4_day_6.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_6.checked=false;
	parent.frames[0].document.forms[0].working_week_4_day_6.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_6.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_6.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_6.disabled=true;
	</script><%}
	if (WORKING_WEEK_4_DAY_7.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_4_day_7.value='W';
	parent.frames[0].document.forms[0].working_week_4_day_7.checked=true;	
	parent.frames[0].document.forms[0].working_week_4_day_7.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_7.value='W';
	parent.frames[0].document.forms[0].pract_working_week_4_day_7.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_4_day_7.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_4_day_7.value='H';
	parent.frames[0].document.forms[0].working_week_4_day_7.checked=false;
	parent.frames[0].document.forms[0].working_week_4_day_7.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_4_day_7.value='H';
	parent.frames[0].document.forms[0].pract_working_week_4_day_7.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_4_day_7.disabled=true;
	</script><%}
/////////
if (WORKING_WEEK_5_DAY_1.equals("W")) {
   %>  <script>parent.frames[0].document.forms[0].working_week_5_day_1.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_1.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_1.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_1.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_1.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_1.disabled=false;
	</script><% }else {%><script>parent.frames[0].document.forms[0].working_week_5_day_1.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_1.checked=false;	parent.frames[0].document.forms[0].working_week_5_day_1.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_1.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_1.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_1.disabled=true;
	</script><%}
	if (WORKING_WEEK_5_DAY_2.equals("W")) {
	%><script>parent.frames[0].document.forms[0].working_week_5_day_2.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_2.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_2.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_2.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_2.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_2.disabled=false;
	</script><%	} else {
	%><script>parent.frames[0].document.forms[0].working_week_5_day_2.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_2.checked=false;
	parent.frames[0].document.forms[0].working_week_5_day_2.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_2.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_2.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_2.disabled=true;
	</script><%}
	if (WORKING_WEEK_5_DAY_3.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_5_day_3.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_3.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_3.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_3.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_3.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_3.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_5_day_3.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_3.checked=false;
	parent.frames[0].document.forms[0].working_week_5_day_3.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_3.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_3.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_3.disabled=true;
	</script><%}
	if (WORKING_WEEK_5_DAY_4.equals("W")){%><script>parent.frames[0].document.forms[0].working_week_5_day_4.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_4.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_4.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_4.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_4.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_4.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_5_day_4.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_4.checked=false;
	parent.frames[0].document.forms[0].working_week_5_day_4.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_4.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_4.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_4.disabled=true;
	</script><%}
	if (WORKING_WEEK_5_DAY_5.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_5_day_5.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_5.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_5.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_5.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_5.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_5.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_5_day_5.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_5.checked=false;
	parent.frames[0].document.forms[0].working_week_5_day_5.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_5.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_5.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_5.disabled=true;
	</script><%}	
  	if (WORKING_WEEK_5_DAY_6.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_5_day_6.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_6.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_6.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_6.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_6.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_6.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_5_day_6.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_6.checked=false;
	parent.frames[0].document.forms[0].working_week_5_day_6.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_6.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_6.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_6.disabled=true;
	</script><%}
	if (WORKING_WEEK_5_DAY_7.equals("W")) {%><script>parent.frames[0].document.forms[0].working_week_5_day_7.value='W';
	parent.frames[0].document.forms[0].working_week_5_day_7.checked=true;	
	parent.frames[0].document.forms[0].working_week_5_day_7.disabled=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_7.value='W';
	parent.frames[0].document.forms[0].pract_working_week_5_day_7.checked=true;	
	parent.frames[0].document.forms[0].pract_working_week_5_day_7.disabled=false;
	</script><%}else {%><script>parent.frames[0].document.forms[0].working_week_5_day_7.value='H';
	parent.frames[0].document.forms[0].working_week_5_day_7.checked=false;
	parent.frames[0].document.forms[0].working_week_5_day_7.disabled=true;
	parent.frames[0].document.forms[0].pract_working_week_5_day_7.value='H';
	parent.frames[0].document.forms[0].pract_working_week_5_day_7.checked=false;
	parent.frames[0].document.forms[0].pract_working_week_5_day_7.disabled=true;
	  
	</script><%}

  String sql="Select Working_Day_1,Working_Day_2,Working_Day_3,Working_Day_4,Working_Day_5,"+
    "Working_Day_6,Working_Day_7,Fi_Visit_Type_Appl_Yn,Fu_Visit_Type_Appl_Yn,"+
    "Rt_Visit_Type_Appl_Yn,Sr_Visit_Type_Appl_Yn,Cs_Visit_Type_Appl_Yn,"+
    "Em_Visit_Type_Appl_Yn from op_clinic where clinic_code = '"+pr_id+"' and facility_id = '"+facilityid+"'";
       // out.println(sql);
            
        rs = stmt.executeQuery(sql);
        while(rs.next()){
        wd1 = rs.getString("working_day_1");
        wd2 = rs.getString("working_day_2");
        wd3 = rs.getString("working_day_3");
        wd4 = rs.getString("working_day_4");
        wd5 = rs.getString("working_day_5");
        wd6 = rs.getString("working_day_6");
        wd7 = rs.getString("working_day_7");
        
        emergency=rs.getString("Em_Visit_Type_Appl_Yn");
		 first=rs.getString("fi_visit_type_appl_yn");
        follow=rs.getString("fu_visit_type_appl_yn");
        routine=rs.getString("rt_visit_type_appl_yn");
        series=rs.getString("sr_visit_type_appl_yn");
        consult=rs.getString("cs_visit_type_appl_yn");		

        }

		if(rs != null) rs.close();

        if(wd1.equals("Y"))
        {
        String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_1.disabled=false;"+
        "parent.frames[0].document.forms[0].i1.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_1.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_1.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown ='lockKey()'></body></html>";
        out.println(a1);
        }
        else{
        String a2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_1.disabled=true;"+
        "parent.frames[0].document.forms[0].i1.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_1.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_1.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a2);
        }
        
        if(wd2.equals("Y"))
        {
        String a3="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_2.disabled=false;" + 
        "parent.frames[0].document.forms[0].i2.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_2.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_2.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a3);
        }
        else{
        String a4="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_2.disabled=true;"+
        "parent.frames[0].document.forms[0].i2.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_2.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_2.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a4);
        }
        if(wd3.equals("Y"))
        {
        String a5="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_3.disabled=false;"+
        "parent.frames[0].document.forms[0].i3.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_3.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_3.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a5);
        }
        else{
        String a6="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_3.disabled=true;"+
        "parent.frames[0].document.forms[0].i3.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_3.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_3.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a6);
        }
        
        if(wd4.equals("Y"))
        {
        String a7="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_4.disabled=false;"+
        "parent.frames[0].document.forms[0].i4.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_4.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_4.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a7);
        }
        else{
        String a8="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_4.disabled=true;"+
        "parent.frames[0].document.forms[0].i4.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_4.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_4.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a8);
        }
        if(wd5.equals("Y"))
        {
        String a9="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_5.disabled=false;"+
        "parent.frames[0].document.forms[0].i5.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_5.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_5.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a9);
        }
        else{
        String a10="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_5.disabled=true;"+
        "parent.frames[0].document.forms[0].i5.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_5.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_5.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a10);
        }
        if(wd6.equals("Y"))
        {
        String a11="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_6.disabled=false;"+
        "parent.frames[0].document.forms[0].i6.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_6.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_6.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a11);
        }
        else{
        String a12="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_6.disabled=true;"+
        "parent.frames[0].document.forms[0].i6.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_6.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_6.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a12);
        }
        
        if(wd7.equals("Y"))
        {
        String a13="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_7.disabled=false;"+
        "parent.frames[0].document.forms[0].i7.src='../../eCommon/images/enabled.gif';"+
        "parent.frames[0].document.forms[0].working_day_7.checked=true;"+
        "parent.frames[0].document.forms[0].working_day_7.value='Y';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a13);
        }
        else{
        String a14="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].working_day_7.disabled=true;"+
        "parent.frames[0].document.forms[0].i7.src='../../eCommon/images/RRnwd.gif';"+
        "parent.frames[0].document.forms[0].working_day_7.checked=false;"+
        "parent.frames[0].document.forms[0].working_day_7.value='N';"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a14);
        }
        
        
        if(emergency.equals("N")) // || emergency.equals("null") || emergency.equals(""))
        {
        String a15="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+
        "parent.frames[0].document.forms[0].emergency.checked=false;"+
        "parent.frames[0].document.forms[0].emergency.disabled=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        
		
		out.println(a15);
            if(first.equals("N")) // || first.equals("null") || first.equals(""))
                {
                String d1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d1);
                }
            else if(first.equals("Y"))
                { 
                String d11="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=false;"+
                        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d11);
                String d2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d2);
                }
                
            if(follow.equals("N")) // || follow.equals("null") || follow.equals(""))
                {
                String d3="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=true;"+
                        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                    out.println(d3);
                        }
            else if(follow.equals("Y"))
                    { 
                    String d33="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=false;"+
                        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                    out.println(d33);
                    String d4="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.checked=true;"+
                    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                    out.println(d4);
                }
                
                
                
                
            
            if(routine.equals("N")) // || routine.equals("null") || routine.equals(""))
                {
                String d5="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].routine.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d5);
                }
            else if(routine.equals("Y"))
                {
                String d55="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].routine.disabled=false;"+
                                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d55);
                String d6="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].routine.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d6);
                }
            
            
            if(series.equals("N")) // || series.equals("null") || series.equals(""))
                {
                String d7="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d7);
                }
            else if(series.equals("Y"))
                {
                String d77="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=false;"+
                                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d77);
                String d8="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d8);
                }
            
            if(consult.equals("N")) // || consult.equals("null") || consult.equals(""))
                {
                String d9="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d9);
                }
                else if(consult.equals("Y"))
                {
                String d99="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=false;"+
                                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d99);
                String d10="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
                out.println(d10);
                }
            
        }
        else if(emergency.equals("Y")) {
        if(first.equals("N")) // || first.equals("null") || first.equals(""))
        {
        String a16="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=true;"+
            "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a16);          
		}
		else{
		String a16="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].first.disabled=false;parent.frames[0].document.forms[0].first.checked=true;"+
            "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a16); 
		
		}
	if(follow.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a17="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a17);          
	}
	else{
	String a17="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].follow.disabled=false;parent.frames[0].document.forms[0].follow.checked=true;"+
                "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a17);          
	
	
	}
    if(routine.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a18="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script> parent.frames[0].document.forms[0].routine.disabled=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a18); 
	}
	else{
	 String a18="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script> parent.frames[0].document.forms[0].routine.disabled=false;parent.frames[0].document.forms[0].routine.checked=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a18); 
	
	}
    
	 if(series.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a19="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a19);          
	}
	else{
	String a19="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].series.disabled=false;parent.frames[0].document.forms[0].series.checked=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a19);          
	
	}
	if(consult.equals("N")) // || follow.equals("null") || follow.equals(""))
    {
    String a20="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=true;"+
    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'>></body></html>";
        out.println(a20); 
	}
	else{
	String a20="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].consult.disabled=false;parent.frames[0].document.forms[0].consult.checked=true;"+
    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a20); 
	
	}
		
		
		String a21="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].emergency.disabled=false;"+
    "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a21);           
        String a22="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>parent.frames[0].document.forms[0].emergency.checked=true;"+
        "</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(a22);           
                
        }
        
        if(emergency.equals("Y"))
        {
        String k1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].emergency.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k1);
        
        }
        else
        {
        String k2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].emergency.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k2);
        }
        
        if(first.equals("Y"))
        {
        String k3="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].first.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k3);
        
        }
        else
        {
        String k4="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].first.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k4);
        }
        
        if(follow.equals("Y"))
        {
        String k5="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].follow.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k5);
        }
        else
        {
        String k6="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].follow.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k6);
        }
    
        if(routine.equals("Y"))
        {
        String k7="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
         "<script>parent.frames[0].document.forms[0].routine.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k7);
        }
        else
        {
        String k8="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].routine.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k8);
        }
        
        
        if(series.equals("Y"))
        {
        String k9="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].series.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k9);
        }
        else
        {
        String k10="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].series.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k10);
        }
        
        
        if(consult.equals("Y"))
        {
        String k11="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].consult.value='"+yes+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k11);
        }
        else
        {
        String k12="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
        "<script>parent.frames[0].document.forms[0].consult.value='"+no+"' </script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>";
        out.println(k12);
        }

		if(!from_item_chk.equals("Y"))
	    {
%>
                <script>
                    var n=parent.frames[0].document.forms[0].practitioner.options.length;
                    for(var i=0;i<n;i++)
                    {
                    parent.frames[0].document.forms[0].practitioner.remove("practitioner");             
                    }                   
                var tp =" --------"+getLabel('Common.defaultSelect.label','Common')+"-------- "
                var opt=parent.document.frames[0].document.createElement("OPTION");         
                opt.text=tp;
                opt.value="";
            parent.frames[0].document.forms[0].practitioner.add(opt);                   

                </script>           

    <%  
        String mysql = "Select a.practitioner_id,b.short_name from am_pract_for_facility a, "+
                " am_practitioner b , op_clinic c  where b.practitioner_id = a.practitioner_id  "+  
                " and a.eff_status = 'E' and a.facility_id = '"+facilityid+"'"+
                " and c.facility_id = a.facility_id and c.clinic_code = '"+pr_id+"'"+
                " and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id ))"+
                " and nvl(c.pract_type, b.pract_type) = b.pract_type ";
        
        pstmt   = con.prepareStatement( mysql);

        rs = pstmt.executeQuery() ;
        String str1 = "";
        String str2 = "";
        if( rs != null ) 
        {
            while( rs.next() ) 
            {
                str1 = rs.getString(2) ;
                str2 = rs.getString(1);
                
                out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
                "<script>var element = parent.frames[0].document.createElement('OPTION');"+
                        "element.text = \""+str1+"\";"+ 
                        "element.value= \""+str2+"\";"+
                        "parent.frames[0].document.clinic_form.practitioner.add(element);</script></head><body CLASS='MESSAGE' onKeyDown='lockKey();'></body></html>");
            }
        }
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close() ;             
		}
}catch(Exception e){out.println(e);}
finally { 
	//Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003
	if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();
	if(rs1!=null)rs1.close();
	if(pstmt1!=null)pstmt1.close();
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	
	%>
