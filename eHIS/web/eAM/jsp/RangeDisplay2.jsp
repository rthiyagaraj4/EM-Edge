<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");	
	String  range_id = request.getParameter("range_id");
		if(range_id == null) range_id="";
	String range_type = request.getParameter("range_type");
		if(range_type == null || range_type.equals("")) range_type="";
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null;
	String eff_status="";
	String functionVal="";
String range_1_fr ="",range_1_fr_unit="",range_1_to ="",range_1_to_unit ="";                    
String range_2_fr ="",range_2_fr_unit="",range_2_to ="",range_2_to_unit ="";
String range_3_fr ="",range_3_fr_unit="",range_3_to ="",range_3_to_unit ="";
String range_4_fr ="",range_4_fr_unit="",range_4_to ="",range_4_to_unit ="";
String range_5_fr ="",range_5_fr_unit="",range_5_to ="",range_5_to_unit ="";
String range_6_fr ="",range_6_fr_unit="",range_6_to ="",range_6_to_unit ="";
String range_7_fr ="",range_7_fr_unit="",range_7_to ="",range_7_to_unit ="";
String range_8_fr ="",range_8_fr_unit="",range_8_to ="",range_8_to_unit ="";
String range_9_fr ="",range_9_fr_unit="",range_9_to ="",range_9_to_unit ="";
String range_10_fr ="",range_10_fr_unit="",range_10_to ="",range_10_to_unit ="";
String range_11_fr ="",range_11_fr_unit="",range_11_to ="",range_11_to_unit ="";
String range_12_fr ="",range_12_fr_unit="",range_12_to ="",range_12_to_unit ="";
String range_13_fr ="",range_13_fr_unit="",range_13_to ="",range_13_to_unit ="";
String range_14_fr ="",range_14_fr_unit="",range_14_to ="",range_14_to_unit ="";
String range_15_fr ="",range_15_fr_unit="",range_15_to ="",range_15_to_unit ="";
String range_16_fr ="",range_16_fr_unit="",range_16_to ="",range_16_to_unit ="";
String range_17_fr ="",range_17_fr_unit="",range_17_to ="",range_17_to_unit ="";
String range_18_fr ="",range_18_fr_unit="",range_18_to ="",range_18_to_unit ="";
String range_19_fr ="",range_19_fr_unit="",range_19_to ="",range_19_to_unit ="";
String range_20_fr ="",range_20_fr_unit="",range_20_to ="",range_20_to_unit ="";
String range_21_fr ="",range_21_fr_unit="",range_21_to ="",range_21_to_unit ="";
String range_22_fr ="",range_22_fr_unit="",range_22_to ="",range_22_to_unit ="";
String range_23_fr ="",range_23_fr_unit="",range_23_to ="",range_23_to_unit ="";
String range_24_fr ="",range_24_fr_unit="",range_24_to ="",range_24_to_unit ="";
String range_25_fr ="",range_25_fr_unit="",range_25_to ="",range_25_to_unit ="";




try{

if(!range_id.equals(""))
{
	conn = ConnectionManager.getConnection(request);
	functionVal ="modify";
	
	String sql="select * from am_summ_range where range_id='"+range_id+"' and range_type='"+range_type+"'";
	stmt = conn.createStatement();
	rset = stmt.executeQuery(sql);
	rset.next();



eff_status = rset.getString("eff_status");
if(eff_status == null) eff_status="E";


range_1_fr =rset.getString("range_1_fr");
range_1_fr_unit=rset.getString("range_1_fr_unit");
range_1_to =rset.getString("range_1_to");
range_1_to_unit =rset.getString("range_1_to_unit");           
if(range_1_fr == null) range_1_fr="";
if(range_1_fr_unit == null) range_1_fr_unit="";
if(range_1_to == null) range_1_to="";
if(range_1_to_unit == null) range_1_to_unit="";

range_2_fr =rset.getString("range_2_fr");range_2_fr_unit=rset.getString("range_2_fr_unit");range_2_to =rset.getString("range_2_to");range_2_to_unit =rset.getString("range_2_to_unit");
if(range_2_fr == null) range_2_fr="";if(range_2_fr_unit == null) range_2_fr_unit="";if(range_2_to == null) range_2_to="";if(range_2_to_unit == null) range_2_to_unit="";

range_3_fr =rset.getString("range_3_fr");range_3_fr_unit=rset.getString("range_3_fr_unit");range_3_to =rset.getString("range_3_to");range_3_to_unit =rset.getString("range_3_to_unit");
if(range_3_fr == null) range_3_fr="";if(range_3_fr_unit == null) range_3_fr_unit="";if(range_3_to == null) range_3_to="";if(range_3_to_unit == null) range_3_to_unit="";

range_4_fr =rset.getString("range_4_fr");range_4_fr_unit=rset.getString("range_4_fr_unit");range_4_to =rset.getString("range_4_to");range_4_to_unit =rset.getString("range_4_to_unit");
if(range_4_fr == null) range_4_fr="";if(range_4_fr_unit == null) range_4_fr_unit="";if(range_4_to == null) range_4_to="";if(range_4_to_unit == null) range_4_to_unit="";

range_5_fr =rset.getString("range_5_fr");range_5_fr_unit=rset.getString("range_5_fr_unit");range_5_to =rset.getString("range_5_to");range_5_to_unit =rset.getString("range_5_to_unit");
if(range_5_fr == null) range_5_fr="";if(range_5_fr_unit == null) range_5_fr_unit="";if(range_5_to == null) range_5_to="";if(range_5_to_unit == null) range_5_to_unit="";

range_6_fr =rset.getString("range_6_fr");range_6_fr_unit=rset.getString("range_6_fr_unit");range_6_to =rset.getString("range_6_to");range_6_to_unit =rset.getString("range_6_to_unit");
if(range_6_fr == null) range_6_fr="";if(range_6_fr_unit == null) range_6_fr_unit="";if(range_6_to == null) range_6_to="";if(range_6_to_unit == null) range_6_to_unit="";

range_7_fr =rset.getString("range_7_fr");range_7_fr_unit=rset.getString("range_7_fr_unit");range_7_to =rset.getString("range_7_to");range_7_to_unit =rset.getString("range_7_to_unit");
if(range_7_fr == null) range_7_fr="";if(range_7_fr_unit == null) range_7_fr_unit="";if(range_7_to == null) range_7_to="";if(range_7_to_unit == null) range_7_to_unit="";

range_8_fr =rset.getString("range_8_fr");range_8_fr_unit=rset.getString("range_8_fr_unit");range_8_to =rset.getString("range_8_to");range_8_to_unit =rset.getString("range_8_to_unit");
if(range_8_fr == null) range_8_fr="";if(range_8_fr_unit == null) range_8_fr_unit="";if(range_8_to == null) range_8_to="";if(range_8_to_unit == null) range_8_to_unit="";


range_9_fr =rset.getString("range_9_fr");range_9_fr_unit=rset.getString("range_9_fr_unit");range_9_to =rset.getString("range_9_to");range_9_to_unit =rset.getString("range_9_to_unit");
if(range_9_fr == null) range_9_fr="";if(range_9_fr_unit == null) range_9_fr_unit="";if(range_9_to == null) range_9_to="";if(range_9_to_unit == null) range_9_to_unit="";


range_10_fr =rset.getString("range_10_fr");range_10_fr_unit=rset.getString("range_10_fr_unit");range_10_to =rset.getString("range_10_to");range_10_to_unit =rset.getString("range_10_to_unit");
if(range_10_fr == null) range_10_fr="";if(range_10_fr_unit == null) range_10_fr_unit="";if(range_10_to == null) range_10_to="";if(range_10_to_unit == null) range_10_to_unit="";

range_11_fr =rset.getString("range_11_fr");range_11_fr_unit=rset.getString("range_11_fr_unit");range_11_to =rset.getString("range_11_to");range_11_to_unit =rset.getString("range_11_to_unit");
if(range_11_fr == null) range_11_fr="";if(range_11_fr_unit == null) range_11_fr_unit="";if(range_11_to == null) range_11_to="";if(range_11_to_unit == null) range_11_to_unit="";

range_12_fr =rset.getString("range_12_fr");range_12_fr_unit=rset.getString("range_12_fr_unit");range_12_to =rset.getString("range_12_to");range_12_to_unit =rset.getString("range_12_to_unit");
if(range_12_fr == null) range_12_fr="";if(range_12_fr_unit == null) range_12_fr_unit="";if(range_12_to == null) range_12_to="";if(range_12_to_unit == null) range_12_to_unit="";

range_13_fr =rset.getString("range_13_fr");range_13_fr_unit=rset.getString("range_13_fr_unit");range_13_to =rset.getString("range_13_to");range_13_to_unit =rset.getString("range_13_to_unit");
if(range_13_fr == null) range_13_fr="";if(range_13_fr_unit == null) range_13_fr_unit="";if(range_13_to == null) range_13_to="";if(range_13_to_unit == null) range_13_to_unit="";

range_14_fr =rset.getString("range_14_fr");range_14_fr_unit=rset.getString("range_14_fr_unit");range_14_to =rset.getString("range_14_to");range_14_to_unit =rset.getString("range_14_to_unit");
if(range_14_fr == null) range_14_fr="";if(range_14_fr_unit == null) range_14_fr_unit="";if(range_14_to == null) range_14_to="";if(range_14_to_unit == null) range_14_to_unit="";

range_15_fr =rset.getString("range_15_fr");range_15_fr_unit=rset.getString("range_15_fr_unit");range_15_to =rset.getString("range_15_to");range_15_to_unit =rset.getString("range_15_to_unit");
if(range_15_fr == null) range_15_fr="";if(range_15_fr_unit == null) range_15_fr_unit="";if(range_15_to == null) range_15_to="";if(range_15_to_unit == null) range_15_to_unit="";

range_16_fr =rset.getString("range_16_fr");range_16_fr_unit=rset.getString("range_16_fr_unit");range_16_to =rset.getString("range_16_to");range_16_to_unit =rset.getString("range_16_to_unit");
if(range_16_fr == null) range_16_fr="";if(range_16_fr_unit == null) range_16_fr_unit="";if(range_16_to == null) range_16_to="";if(range_16_to_unit == null) range_16_to_unit="";


range_17_fr =rset.getString("range_17_fr");range_17_fr_unit=rset.getString("range_17_fr_unit");range_17_to =rset.getString("range_17_to");range_17_to_unit =rset.getString("range_17_to_unit");
if(range_17_fr == null) range_17_fr="";if(range_17_fr_unit == null) range_17_fr_unit="";if(range_17_to == null) range_17_to="";if(range_17_to_unit == null) range_17_to_unit="";

range_18_fr =rset.getString("range_18_fr");range_18_fr_unit=rset.getString("range_18_fr_unit");range_18_to =rset.getString("range_18_to");range_18_to_unit =rset.getString("range_18_to_unit");
if(range_18_fr == null) range_18_fr="";if(range_18_fr_unit == null) range_18_fr_unit="";if(range_18_to == null) range_18_to="";if(range_18_to_unit == null) range_18_to_unit="";

range_19_fr =rset.getString("range_19_fr");range_19_fr_unit=rset.getString("range_19_fr_unit");range_19_to =rset.getString("range_19_to");range_19_to_unit =rset.getString("range_19_to_unit");
if(range_19_fr == null) range_19_fr="";if(range_19_fr_unit == null) range_19_fr_unit="";if(range_19_to == null) range_19_to="";if(range_19_to_unit == null) range_19_to_unit="";

range_20_fr =rset.getString("range_20_fr");range_20_fr_unit=rset.getString("range_20_fr_unit");range_20_to =rset.getString("range_20_to");range_20_to_unit =rset.getString("range_20_to_unit");
if(range_20_fr == null) range_20_fr="";if(range_20_fr_unit == null) range_20_fr_unit="";if(range_20_to == null) range_20_to="";if(range_20_to_unit == null) range_20_to_unit="";

range_21_fr =rset.getString("range_21_fr");range_21_fr_unit=rset.getString("range_21_fr_unit");range_21_to =rset.getString("range_21_to");range_21_to_unit =rset.getString("range_21_to_unit");
if(range_21_fr == null) range_21_fr="";if(range_21_fr_unit == null) range_21_fr_unit="";if(range_21_to == null) range_21_to="";if(range_21_to_unit == null) range_21_to_unit="";

range_22_fr =rset.getString("range_22_fr");range_22_fr_unit=rset.getString("range_22_fr_unit");range_22_to =rset.getString("range_22_to");range_22_to_unit =rset.getString("range_22_to_unit");
if(range_22_fr == null) range_22_fr="";if(range_22_fr_unit == null) range_22_fr_unit="";if(range_22_to == null) range_22_to="";if(range_22_to_unit == null) range_22_to_unit="";

range_23_fr =rset.getString("range_23_fr");range_23_fr_unit=rset.getString("range_23_fr_unit");range_23_to =rset.getString("range_23_to");range_23_to_unit =rset.getString("range_23_to_unit");
if(range_23_fr == null) range_23_fr="";if(range_23_fr_unit == null) range_23_fr_unit="";if(range_23_to == null) range_23_to="";if(range_23_to_unit == null) range_23_to_unit="";

range_24_fr =rset.getString("range_24_fr");range_24_fr_unit=rset.getString("range_24_fr_unit");range_24_to =rset.getString("range_24_to");range_24_to_unit =rset.getString("range_24_to_unit");
if(range_24_fr == null) range_24_fr="";if(range_24_fr_unit == null) range_24_fr_unit="";if(range_24_to == null) range_24_to="";if(range_24_to_unit == null) range_24_to_unit="";

range_25_fr =rset.getString("range_25_fr");range_25_fr_unit=rset.getString("range_25_fr_unit");range_25_to =rset.getString("range_25_to");range_25_to_unit =rset.getString("range_25_to_unit");
if(range_25_fr == null) range_25_fr="";if(range_25_fr_unit == null) range_25_fr_unit="";if(range_25_to == null) range_25_to="";if(range_25_to_unit == null) range_25_to_unit="";

	

}else
{
functionVal="insert";

if(range_type.equals("A") || range_type.equals("") && range_1_fr_unit.equals("")) range_1_fr_unit="D";else if(range_type.equals("W")  && range_1_fr_unit.equals("")) range_1_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_1_to_unit.equals("")) range_1_to_unit="D";else if(range_type.equals("W") && range_1_to_unit.equals("")) range_1_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_2_fr_unit.equals("")) range_2_fr_unit="D";else if(range_type.equals("W")  && range_2_fr_unit.equals("")) range_2_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_2_to_unit.equals("")) range_2_to_unit="D";else if(range_type.equals("W") && range_2_to_unit.equals("")) range_2_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_3_fr_unit.equals("")) range_3_fr_unit="D";else if(range_type.equals("W")  && range_3_fr_unit.equals("")) range_3_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_3_to_unit.equals("")) range_3_to_unit="D";else if(range_type.equals("W") && range_3_to_unit.equals("")) range_3_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_4_fr_unit.equals("")) range_4_fr_unit="D";else if(range_type.equals("W")  && range_4_fr_unit.equals("")) range_4_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_4_to_unit.equals("")) range_4_to_unit="D";else if(range_type.equals("W") && range_4_to_unit.equals("")) range_4_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_5_fr_unit.equals("")) range_5_fr_unit="D";else if(range_type.equals("W")  && range_5_fr_unit.equals("")) range_5_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_5_to_unit.equals("")) range_5_to_unit="D";else if(range_type.equals("W") && range_5_to_unit.equals("")) range_5_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_6_fr_unit.equals("")) range_6_fr_unit="D";else if(range_type.equals("W")  && range_6_fr_unit.equals("")) range_6_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_6_to_unit.equals("")) range_6_to_unit="D";else if(range_type.equals("W") && range_6_to_unit.equals("")) range_6_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_7_fr_unit.equals("")) range_7_fr_unit="D";else if(range_type.equals("W")  && range_7_fr_unit.equals("")) range_7_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_7_to_unit.equals("")) range_7_to_unit="D";else if(range_type.equals("W") && range_7_to_unit.equals("")) range_7_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_8_fr_unit.equals("")) range_8_fr_unit="D";else if(range_type.equals("W")  && range_8_fr_unit.equals("")) range_8_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_8_to_unit.equals("")) range_8_to_unit="D";else if(range_type.equals("W") && range_8_to_unit.equals("")) range_8_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_9_fr_unit.equals("")) range_9_fr_unit="D";else if(range_type.equals("W")  && range_9_fr_unit.equals("")) range_9_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_9_to_unit.equals("")) range_9_to_unit="D";else if(range_type.equals("W") && range_9_to_unit.equals("")) range_9_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_10_fr_unit.equals("")) range_10_fr_unit="D";else if(range_type.equals("W")  && range_10_fr_unit.equals("")) range_10_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_10_to_unit.equals("")) range_10_to_unit="D";else if(range_type.equals("W") && range_10_to_unit.equals("")) range_10_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_11_fr_unit.equals("")) range_11_fr_unit="D";else if(range_type.equals("W")  && range_11_fr_unit.equals("")) range_11_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_11_to_unit.equals("")) range_11_to_unit="D";else if(range_type.equals("W") && range_11_to_unit.equals("")) range_11_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_12_fr_unit.equals("")) range_12_fr_unit="D";else if(range_type.equals("W")  && range_12_fr_unit.equals("")) range_12_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_12_to_unit.equals("")) range_12_to_unit="D";else if(range_type.equals("W") && range_12_to_unit.equals("")) range_12_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_13_fr_unit.equals("")) range_13_fr_unit="D";else if(range_type.equals("W")  && range_13_fr_unit.equals("")) range_13_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_13_to_unit.equals("")) range_13_to_unit="D";else if(range_type.equals("W") && range_13_to_unit.equals("")) range_13_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_14_fr_unit.equals("")) range_14_fr_unit="D";else if(range_type.equals("W")  && range_14_fr_unit.equals("")) range_14_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_14_to_unit.equals("")) range_14_to_unit="D";else if(range_type.equals("W") && range_14_to_unit.equals("")) range_14_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_15_fr_unit.equals("")) range_15_fr_unit="D";else if(range_type.equals("W")  && range_15_fr_unit.equals("")) range_15_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_15_to_unit.equals("")) range_15_to_unit="D";else if(range_type.equals("W") && range_15_to_unit.equals("")) range_15_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_16_fr_unit.equals("")) range_16_fr_unit="D";else if(range_type.equals("W")  && range_16_fr_unit.equals("")) range_16_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_16_to_unit.equals("")) range_16_to_unit="D";else if(range_type.equals("W") && range_16_to_unit.equals("")) range_16_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_17_fr_unit.equals("")) range_17_fr_unit="D";else if(range_type.equals("W")  && range_17_fr_unit.equals("")) range_17_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_17_to_unit.equals("")) range_17_to_unit="D";else if(range_type.equals("W") && range_17_to_unit.equals("")) range_17_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_18_fr_unit.equals("")) range_18_fr_unit="D";else if(range_type.equals("W")  && range_18_fr_unit.equals("")) range_18_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_18_to_unit.equals("")) range_18_to_unit="D";else if(range_type.equals("W") && range_18_to_unit.equals("")) range_18_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_19_fr_unit.equals("")) range_19_fr_unit="D";else if(range_type.equals("W")  && range_19_fr_unit.equals("")) range_19_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_19_to_unit.equals("")) range_19_to_unit="D";else if(range_type.equals("W") && range_19_to_unit.equals("")) range_19_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_20_fr_unit.equals("")) range_20_fr_unit="D";else if(range_type.equals("W")  && range_20_fr_unit.equals("")) range_20_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_20_to_unit.equals("")) range_20_to_unit="D";else if(range_type.equals("W") && range_20_to_unit.equals("")) range_20_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_21_fr_unit.equals("")) range_21_fr_unit="D";else if(range_type.equals("W")  && range_21_fr_unit.equals("")) range_21_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_21_to_unit.equals("")) range_21_to_unit="D";else if(range_type.equals("W") && range_21_to_unit.equals("")) range_21_to_unit="K";


if(range_type.equals("A") || range_type.equals("") && range_22_fr_unit.equals("")) range_22_fr_unit="D";else if(range_type.equals("W")  && range_22_fr_unit.equals("")) range_22_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_22_to_unit.equals("")) range_22_to_unit="D";else if(range_type.equals("W") && range_22_to_unit.equals("")) range_22_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_23_fr_unit.equals("")) range_23_fr_unit="D";else if(range_type.equals("W")  && range_23_fr_unit.equals("")) range_23_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_23_to_unit.equals("")) range_23_to_unit="D";else if(range_type.equals("W") && range_23_to_unit.equals("")) range_23_to_unit="K";


if(range_type.equals("A") || range_type.equals("") && range_24_fr_unit.equals("")) range_24_fr_unit="D";else if(range_type.equals("W")  && range_24_fr_unit.equals("")) range_24_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_24_to_unit.equals("")) range_24_to_unit="D";else if(range_type.equals("W") && range_24_to_unit.equals("")) range_24_to_unit="K";


if(range_type.equals("A") || range_type.equals("") && range_25_fr_unit.equals("")) range_25_fr_unit="D";else if(range_type.equals("W")  && range_25_fr_unit.equals("")) range_25_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_25_to_unit.equals("")) range_25_to_unit="D";else if(range_type.equals("W") && range_25_to_unit.equals("")) range_25_to_unit="K";
}

%>


 <html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eAM/js/AgeRange.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<script>

function test(num)
	{
		for(var cnt=0;cnt<num;cnt++)
		{
 		 if(parent.frames[0].document.forms[0].no_of_ranges.value < num)
 		 {
			parent.frames[0].document.forms[0].no_of_ranges.select();
			parent.frames[0].document.forms[0].no_of_ranges.focus();
		 }
		}
	}

function checkNoDecimal(fld,event)
{
	//alert("here");
	var retVal;
	if (parent.frames[0].document.forms[0].range_type.value =="A")
	{
		//alert("a");
		fld.maxLength=3;
		retVal=allowValidNumber(fld,event,3, 0);
	}
	else if (parent.frames[0].document.forms[0].range_type.value =="W")
	{
		//alert("w");
		fld.maxLength=6;
 		retVal==allowValidNumber(fld, event, 2,3);
	}
	return retVal;
}

	
	
	function func()
	{
		if (agerange_form.range_type.value == 'A')
		{
			if (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >25)
			{
				if(agerange_form.no_of_ranges.value.length >0)
				{
					alert(getMessage("NO_OF_AGE_RANGE","AM"));
					agerange_form.no_of_ranges.select();
					agerange_form.no_of_ranges.focus();
				}
			}
		}
		else if (agerange_form.range_type.value == 'W')
		{
			if (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >5)
			{
				if(agerange_form.no_of_ranges.value.length >0)
				{
					alert(getMessage("NO_OF_WEIGHT_RANGE","AM"));
					agerange_form.no_of_ranges.select();
					agerange_form.no_of_ranges.focus();
				}
			}
		}
		var arr1= new Array ("document.agerange_form.range_1_fr","document.agerange_form.range_1_to", 						"document.agerange_form.range_2_fr","document.agerange_form.range_2_to", 						"document.agerange_form.range_3_fr","document.agerange_form.range_3_to",
							"document.agerange_form.range_4_fr","document.agerange_form.range_4_to",
							"document.agerange_form.range_5_fr","document.agerange_form.range_5_to",
							"document.agerange_form.range_6_fr","document.agerange_form.range_6_to");
		var noofrange = parseInt(agerange_form.no_of_ranges.value);
		for(var k=noofrange*2; k< arr1.length;k++)
		{
			eval(arr1[k]).value="";
		}
	}

	function ChkOverLap(obj)
	{
		var Fr_unit="";
		var To_unit="";

		/*if(obj.name =="range_1_to_unit" ||obj.name =="range_1_fr_unit"||obj.name =="range_1_to"||obj.name =="range_1_fr" )
			{
		*/
			Fr_unit=agerange_form.range_1_fr_unit.value;
			To_unit=agerange_form.range_1_to_unit.value;
		/*	}
		else if(obj.name =="range_2_to_unit")
		{
			Fr_unit=agerange_form.range_2_fr_unit.value;
			To_unit=agerange_form.range_2_to_unit.value;
		}*/

		var FrVal=0;
		var ToVal=0;

			FrVal=agerange_form.range_1_fr.value;
			ToVal=agerange_form.range_1_to.value;

			if(Fr_unit=="D" && To_unit=="M")
			{
				FrVal=agerange_form.range_1_fr.value;
				ToVal=agerange_form.range_1_to.value*30;
			}
			else if(Fr_unit=="M" && To_unit=="D")
			{

				FrVal=agerange_form.range_1_fr.value*30;
				ToVal=agerange_form.range_1_to.value;
			}
			else if(Fr_unit=="M" && To_unit=="Y")
			{

				FrVal=agerange_form.range_1_fr.value*30;
				ToVal=agerange_form.range_1_to.value*365;
			}
			else if(Fr_unit=="Y" && To_unit=="M")
			{

				FrVal=agerange_form.range_1_fr.value*365;
				ToVal=agerange_form.range_1_to.value*30;
			}
			else if(Fr_unit=="D" && To_unit=="Y")
			{

				FrVal=agerange_form.range_1_fr.value;
				ToVal=agerange_form.range_1_to.value*365;
			}
			else if(Fr_unit=="Y" && To_unit=="D")
			{

				FrVal=agerange_form.range_1_fr.value*365;
				ToVal=agerange_form.range_1_to.value;
			}
				var nam=parseInt(FrVal,10);
				var nam1=parseInt(ToVal,10);

			if(nam > nam1)
						alert("Range OverLapping");
				//obj.focus();
	}

function tt(){
	alert("Range ");
}


function ageWeightOption(Obj)
{
	
	

	var	objName =Obj.name;
	var whichObj="document.agerange_form."+ objName;
	
	
	var arr1= new Array ("document.agerange_form.range_1_fr","document.agerange_form.range_1_to", "document.agerange_form.range_2_fr","document.agerange_form.range_2_to", "document.agerange_form.range_3_fr","document.agerange_form.range_3_to",
	"document.agerange_form.range_4_fr","document.agerange_form.range_4_to",
	"document.agerange_form.range_5_fr","document.agerange_form.range_5_to",
	"document.agerange_form.range_6_fr","document.agerange_form.range_6_to");

	for(var k=0; k< arr1.length;k++)
	{

		eval(arr1[k]).value="";
	
	}

	
	var arr= new Array ("document.agerange_form.range_1_fr_unit","document.agerange_form.range_1_to_unit", "document.agerange_form.range_2_fr_unit","document.agerange_form.range_2_to_unit", "document.agerange_form.range_3_fr_unit","document.agerange_form.range_3_to_unit",
	"document.agerange_form.range_4_fr_unit","document.agerange_form.range_4_to_unit",
	"document.agerange_form.range_5_fr_unit","document.agerange_form.range_5_to_unit",
	"document.agerange_form.range_6_fr_unit","document.agerange_form.range_6_to_unit");

	for(j =0; j < arr.length;j++)
	{

		var len=eval(arr[j]).length;

		
		if(document.agerange_form.range_type.value =="W")
		{
			
			
			for(var i=0;i<len ;i++)
			{
				
				eval(arr[j]).options[i]=null;
			}

			eval(arr[j]).options[0] =new Option("Kgs","K");;
			eval(arr[j]).options[1] =new Option("Lbs","L");


		}

		if(document.agerange_form.range_type.value =="A")
		{
					
			for(var i=0;i<len ;i++)
			{
				eval(arr[j]).options[i]=null;
			}
			eval(arr[j]).options[0] =new Option("Days","D");
			eval(arr[j]).options[1] =new Option("Months","M");
			eval(arr[j]).options[2] =new Option("Years","Y");
		}
	}

}

     

      	
</script>

</head>
<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="agerange_form" id="agerange_form" action="../../servlet/eAM.AgeRangeServlet" method="post" target="messageFrame">
<center>



				<tr>
					<td width="40%"  class="label"><fmt:message key="Common.Range.label" bundle="${common_labels}"/> 23</td>
					<td width="15%"  class="fields">&nbsp;&nbsp; <input type="text" name="range_23_fr" id="range_23_fr" size="6" maxlength="6" value="" onKeyPress="return checkNoDecimal(this,event);" onFocus="test(23)"  onBlur="CheckNum(this)" ></td>
					<td width="15%"  class="fields">&nbsp;<select name="range_23_fr_unit" id="range_23_fr_unit" onFocus="test(23)" >
   	    				<% if(range_type.equals("W")) { %>
						<OPTION  VALUE="K"><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
						<OPTION VALUE="L"><fmt:message key="Common.Lbs.label" bundle="${common_labels}"/></option>
						<% } else { %>
						<OPTION VALUE="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
						<OPTION VALUE="W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
						<OPTION VALUE="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/>
						<OPTION VALUE="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>

					<% } %>
					 </select></td>

					<td width="15%"  class="fields"><input type="text" name="range_23_to" id="range_23_to" size="6" maxlength="6"  value="" onFocus="test(23)" onKeyPress="return checkNoDecimal(this,event);"  onBlur="CheckNum(this)"></td>
					<td width="15%"  class="fields">&nbsp;<select name="range_23_to_unit" id="range_23_to_unit" onFocus="test(23)">
   	    				<% if(range_type.equals("W")) { %>
						<OPTION  VALUE="K"><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
						<OPTION VALUE="L"><fmt:message key="Common.Lbs.label" bundle="${common_labels}"/></option>
						<% } else { %>
						<OPTION VALUE="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
						<OPTION VALUE="W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
						<OPTION VALUE="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/>
						<OPTION VALUE="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>

					<% } %>
					 </select>
					 </td>

	   	    	</tr>

<script>
	document.getElementById('range_23_fr').value="<%=range_23_fr%>";
	document.getElementById('range_23_fr_unit').value="<%=range_23_fr_unit%>";
	document.getElementById('range_23_to').value="<%=range_23_to%>";
	document.getElementById('range_23_to_unit').value="<%=range_23_to_unit%>";
</script>

				<tr>
					<td width="40%"  class="label"><fmt:message key="Common.Range.label" bundle="${common_labels}"/> 24</td>
					<td width="15%"  class="fields">&nbsp;&nbsp; <input type="text" name="range_24_fr" id="range_24_fr" size="6" maxlength="6" onFocus="test(24)" onKeyPress="return checkNoDecimal(this,event);"  onBlur="CheckNum(this)"></td>
						<td width="15%"  class="fields">&nbsp;<select name="range_24_fr_unit" id="range_24_fr_unit" onFocus="test(24)">
   	    				<% if(range_type.equals("W")) { %>
						<OPTION  VALUE="K"><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
						<OPTION VALUE="L"><fmt:message key="Common.Lbs.label" bundle="${common_labels}"/></option>
						<% } else { %>
						<OPTION VALUE="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
						<OPTION VALUE="W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
						<OPTION VALUE="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/>
						<OPTION VALUE="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>

					<% } %>
							 </select></td>

						<td width="15%"  class="fields"><input type="text" name="range_24_to" id="range_24_to" size="6" maxlength="6" onFocus="test(24)" onKeyPress="return checkNoDecimal(this,event);" onBlur="CheckNum(this)"></td>
						<td width="15%"  class="fields">&nbsp;<select name="range_24_to_unit" id="range_24_to_unit" onFocus="test(24)">
   	    				<% if(range_type.equals("W")) { %>
						<OPTION  VALUE="K"><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
						<OPTION VALUE="L"><fmt:message key="Common.Lbs.label" bundle="${common_labels}"/></option>
						<% } else { %>
						<OPTION VALUE="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>

						<OPTION VALUE="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/>
						<OPTION VALUE="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>

					<% } %>
						 </select>
						 </td>

	   	    	</tr>
<script>
	document.getElementById('range_24_fr').value="<%=range_24_fr%>";
	document.getElementById('range_24_fr_unit').value="<%=range_24_fr_unit%>";
	document.getElementById('range_24_to').value="<%=range_24_to%>";
	document.getElementById('range_24_to_unit').value="<%=range_24_to_unit%>";
</script>

	   			<tr>
							<td width="40%"  class="label"><fmt:message key="Common.Range.label" bundle="${common_labels}"/> 25</td>
							<td width="15%"  class="fields">&nbsp;&nbsp; <input type="text" name="range_25_fr" id="range_25_fr" size="6" maxlength="6" onKeyPress="return checkNoDecimal(this,event);" onFocus="test(25)" onBlur="CheckNum(this)"></td>
								<td width="15%"  class="fields">&nbsp;<select name="range_25_fr_unit" id="range_25_fr_unit" onFocus="test(25)">
								<% if(range_type.equals("W")) { %>
									<OPTION  VALUE="K"><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
									<OPTION VALUE="L"><fmt:message key="Common.Lbs.label" bundle="${common_labels}"/></option>
									<% } else { %>
									<OPTION VALUE="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
									<OPTION VALUE="W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
									<OPTION VALUE="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/>
									<OPTION VALUE="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
								<% } %>
									 </select>
									 </td>

								<td class="fields"><input type="text" name="range_25_to" id="range_25_to" size="6" maxlength="6" onFocus="test(25)" onKeyPress="return checkNoDecimal(this,event);" onBlur="CheckNum(this)"></td>
								<td width="15%"  class="fields">&nbsp;<select name="range_25_to_unit" id="range_25_to_unit" onFocus="test(25)">
									<% if(range_type.equals("W")) { %>
										<OPTION  VALUE="K"><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
										<OPTION VALUE="L"><fmt:message key="Common.Lbs.label" bundle="${common_labels}"/></option>
										<% } else { %>
										<OPTION VALUE="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
										<OPTION VALUE="W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
										<OPTION VALUE="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/>
										<OPTION VALUE="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>

									<% } %>
									 </select>
									 </td>

	   	    	</tr>
			</table>
				</td>
			</tr>
<script>
	document.getElementById('range_25_fr').value="<%=range_25_fr%>";
	document.getElementById('range_25_fr_unit').value="<%=range_25_fr_unit%>";
	document.getElementById('range_25_to').value="<%=range_25_to%>";
	document.getElementById("range_25_to_unit").value="<%=range_25_to_unit%>";
</script>

	<input type="hidden" name="function" id="function" value="<%=functionVal%>">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value="<%=functionVal%>">
<input type='hidden' name='range_type' id='range_type' value=''>
<input type='hidden' name='range_id' id='range_id' value=''>
<input type='hidden' name='long_desc' id='long_desc' value=''>
<input type='hidden' name='short_desc' id='short_desc' value=''>
<input type='hidden' name='no_of_ranges' id='no_of_ranges' value=''>
<input type='hidden' name= 'eff_status' value=''>

<%
	if(eff_status.equals("D"))
		{
%>	
	<script>
	for(var i=0;i<document.forms[0].elements.length;i++)
			document.forms[0].elements[i].disabled=true;
	</script>
<%		}

%>
</form>
</center>
</body>
</html>

<%
}
catch ( Exception e ){ out.println(e);}

finally{

	if ( stmt != null ) stmt.close() ;
	if ( rset != null ) rset.close() ;
	ConnectionManager.returnConnection(conn,request);

	}
%>

