<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/02/2018		IN063837		Ramesh Goli											ML-MMOH-CRF-0812
10/09/2018		IN067564		Ramya Maddena		10/09/2018		Ramesh Goli		ML-MMOH-CRF-1186
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
//IN067564 starts
String Recorded_date = request.getParameter("Recorded_date")==null?"":request.getParameter("Recorded_date");
String isAuditYN = request.getParameter("isAuditYN")==null?"":request.getParameter("isAuditYN");
//IN067564 ends
String facility_id = (String)session.getAttribute("facility_id");
String login_practitioner_id	= (String) session.getValue("ca_practitioner_id");
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String bean_id="@caballardscore"+patient_id;
String bean_name="eCA.CABallardScoreBean";
int note_print_time_interval	=	1500;
eCA.CABallardScoreBean beanObj = (eCA.CABallardScoreBean)getObjectFromBean(bean_id,bean_name,session);
JSONObject jsonObj = beanObj.getBallardScoreHeaderDetails(request, patient_id,facility_id,locale,login_practitioner_id,isAuditYN,encounter_id,Recorded_date);//IN067564
note_print_time_interval=Integer.parseInt((String)jsonObj.get("NOTE_PRINT_TIME_INTERVAL"));
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EM</title>
<link rel='StyleSheet' href='../html/CABallardScore.css' type='text/css'/>
<script language='javascript' src='../js/CABallardScore.js'></script>
<script language='javascript' src='../js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>


</script>
</head>

<body>
<form name='BallardScorePrintForm' id='BallardScorePrintForm' method ='post' target='messageFrame' >
  <!--div style="max-width:1200px"-->
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr><td colspan="2" align="center">&nbsp;</td>
          <tr>
          	<td colspan="2" align="center"><h1><%=jsonObj.get("SITE_NAME") %></h1></td>
          </tr>
          <tr>
          	<td colspan="2" align="center"><h2><%=jsonObj.get("FACILITY_NAME") %></h2></td>
          </tr>
          <tr><td colspan="2" align="center">&nbsp;</td>
          <tr>
            <td width="50%" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="158" align="left" valign="top" class="Em_L_title_lab">Patient ID</td>
                <td width="674" align="left" valign="top"><strong>: &nbsp;<%=patient_id %></strong></td>
              </tr>
              <tr><td colspan="2">&nbsp;</td></tr>
              <tr>
                <td align="left" valign="top" class="Em_L_title_lab">Patient Name</td>
                <td align="left" valign="top"><strong>:  &nbsp;<%=jsonObj.get("PATIENT_NAME") %></strong></td>
              </tr>
              <tr><td colspan="2">&nbsp;</td></tr>
            </table></td>
            <td width="50%" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="180" align="left" valign="top" class="Em_L_title_lab">Recorded Date</td>
                <td width="653" align="left" valign="top"><strong>: &nbsp; <%=jsonObj.get("EVENT_DATE_TIME") %></strong></td>
              </tr>
              <tr><td colspan="2">&nbsp;</td></tr>
              <tr>
                <td align="left" valign="top" class="Em_L_title_lab">Practitioner Name</td>
                <td align="left" valign="top"><strong>: &nbsp; <%=jsonObj.get("PRACTITIONER_NAME") %></strong></td>
              </tr>
              <tr><td colspan="2">&nbsp;</td></tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      
      <tr>
        <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="70%" align="center" valign="top" class="EM_TableAcontainer">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="EM_A_Border">
                  <tr>
                    <td align="right" valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-bottom:1px solid #9dbbc3">
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_B1 EM_Cell_height EM_Title labelhold" style="color:#000" id="td">Score</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >-1</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >0</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >1</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >2</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >3</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >4</td>
                          <td id="td" align="center" valign="middle"class="EM_Col_B1 EM_Cell_height EM_TableACell_Width" style="color:#000" >5</td>
                        </tr>
                        <tr>
                          <td colspan="8" align="left" valign="middle" bgcolor="#dbe6e8" class="EM_Sub_Header EM_Cell_height EM_TableAcontainerborder">Neuromuscular Maturity</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Posture</td>
                          <td id="PO-1" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                          <td id="PO0" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PO','0','Col_A');"><img src="../../eCA/images/Posture_0.PNG" width="90" height="55" /></td>
                          <td id="PO1" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PO','1','Col_A');"><img src="../../eCA/images/Posture_1.PNG" width="90" height="55" /></td>
                          <td id="PO2" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PO','2','Col_A');"><img src="../../eCA/images/Posture_2.PNG" width="90" height="55" /></td>
                          <td id="PO3" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PO','3','Col_A');"><img src="../../eCA/images/Posture_3.PNG" width="90" height="55" /></td>
                          <td id="PO4" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PO','4','Col_A');"><img src="../../eCA/images/Posture_4.PNG" width="90" height="55" /></td>
                          <td id="PO5" align="center" valign="middle" class="EM_Col_A EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" value="" valign="middle"class="EM_Col_B EM_Cell_height EM_Title labelhold">Square window(wrist)</td>
                          <td id="SQ-1" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SQ','-1','Col_B');"><img src="../../eCA/images/SquareW_-1.PNG" width="90" height="55" /></td>
                          <td id="SQ0" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SQ','0','Col_B');"><img src="../../eCA/images/SquareW_0.PNG" width="90" height="55" /></td>
                          <td id="SQ1" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SQ','1','Col_B');"><img src="../../eCA/images/SquareW_1.PNG" width="90" height="55" /></td>
                          <td id="SQ2" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SQ','2','Col_B');"><img src="../../eCA/images/SquareW_2.PNG" width="90" height="55" /></td>
                          <td id="SQ3" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SQ','3','Col_B');"><img src="../../eCA/images/SquareW_3.PNG" width="90" height="55" /></td>
                          <td id="SQ4" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SQ','4','Col_B');"><img src="../../eCA/images/SquareW_4.PNG" width="90" height="55" /></td>
                          <td id="SQ5" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Arm recoil</td>
                          <td id="AR-1" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                          <td id="AR0" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','AR','0','Col_A');"><img src="../../eCA/images/Armrecoil_0.PNG" width="90" height="55" /></td>
                          <td id="AR1" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','AR','1','Col_A');"><img src="../../eCA/images/Armrecoil_1.PNG" width="90" height="55" /></td>
                          <td id="AR2" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','AR','2','Col_A');"><img src="../../eCA/images/Armrecoil_2.PNG" width="90" height="55" /></td>
                          <td id="AR3" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','AR','3','Col_A');"><img src="../../eCA/images/Armrecoil_3.PNG" width="90" height="55" /></td>
                          <td id="AR4" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','AR','4','Col_A');"><img src="../../eCA/images/Armrecoil_4.PNG" width="90" height="55" /></td>
                          <td id="AR5" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_B EM_Cell_height EM_Title labelhold">Popliteal angle</td>
                          <td id="PA-1" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','-1','Col_B');"><img src="../../eCA/images/Popliteal_-1.PNG" width="90" height="55" /></td>
                          <td id="PA0" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','0','Col_B');"><img src="../../eCA/images/Popliteal_0.PNG" width="90" height="55" /></td>
                          <td id="PA1" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','1','Col_B');"><img src="../../eCA/images/Popliteal_1.PNG" width="90" height="55" /></td>
                          <td id="PA2" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','2','Col_B');"><img src="../../eCA/images/Popliteal_2.PNG" width="90" height="55" /></td>
                          <td id="PA3" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','3','Col_B');"><img src="../../eCA/images/Popliteal_3.PNG" width="90" height="55" /></td>
                          <td id="PA4" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','4','Col_B');"><img src="../../eCA/images/Popliteal_4.PNG" width="90" height="55" /></td>
                          <td id="PA5" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','PA','5','Col_B');"><img src="../../eCA/images/Popliteal_5.PNG" width="90" height="55" /></td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Scarf sign</td>
                          <td id="SS-1" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SS','-1','Col_A');"><img src="../../eCA/images/Scraf_-1.PNG" width="90" height="55" /></td>
                          <td id="SS0" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SS','0','Col_A');"><img src="../../eCA/images/Scraf_0.PNG" width="90" height="55" /></td>
                          <td id="SS1" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SS','1','Col_A');"><img src="../../eCA/images/Scraf_1.PNG" width="90" height="55" /></td>
                          <td id="SS2" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SS','2','Col_A');"><img src="../../eCA/images/Scraf_2.PNG" width="90" height="55" /></td>
                          <td id="SS3" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SS','3','Col_A');"><img src="../../eCA/images/Scraf_3.PNG" width="90" height="55" /></td>
                          <td id="SS4" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','SS','4','Col_A');"><img src="../../eCA/images/Scraf_4.PNG" width="90" height="55" /></td>
                          <td id="SS5" align="center" valign="middle"class="EM_Col_A EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_B EM_Cell_height EM_Title labelhold ">Heel to ear</td>
                          <td id="HE-1" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','HE','-1','Col_B');"><img src="../../eCA/images/Heel_-1.PNG" width="90" height="55" /></td>
                          <td id="HE0" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','HE','0','Col_B');"><img src="../../eCA/images/Heel_0.PNG" width="90" height="55" /></td>
                          <td id="HE1" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','HE','1','Col_B');"><img src="../../eCA/images/Heel_1.PNG" width="90" height="55" /></td>
                          <td id="HE2" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','HE','2','Col_B');"><img src="../../eCA/images/Heel_2.PNG" width="90" height="55" /></td>
                          <td id="HE3" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','HE','3','Col_B');"><img src="../../eCA/images/Heel_3.PNG" width="90" height="55" /></td>
                          <td id="HE4" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width" onClick="calScore('NE','HE','4','Col_B');"><img src="../../eCA/images/Heel_4.PNG" width="90" height="55" /></td>
                          <td id="HE5" align="center" valign="middle"class="EM_Col_B EM_Cell_height EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td colspan="8" align="left" valign="middle" bgcolor="#dbe6e8" class="EM_Sub_Header EM_Cell_height EM_TableAcontainerborder">Physical Maturity</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Skin</td>
                          <td id="SK-1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','-1','Col_A');">Sticky, friable, transparent</td>
                          <td id="SK0" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','0','Col_A');">Gelatinous, red, translucent</td>
                          <td id="SK1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','1','Col_A');">Smooth, pink, visible veins</td>
                          <td id="SK2" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','2','Col_A');">Superficial peeling and/or rash; few veins</td>
                          <td id="SK3" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','3','Col_A');">Cracking, pale areas; rare veins</td>
                          <td id="SK4" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','4','Col_A');">Parchment, deep cracking; no vessels</td>
                          <td id="SK5" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','SK','5','Col_A');">Leathery, cracked wrinkled</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_B EM_Cell_height EM_Title labelhold">Lanugo</td>
                          <td id="LA-1" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','LA','-1','Col_B');">None</td>
                          <td id="LA0" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','LA','0','Col_B');">Sparse</td>
                          <td id="LA1" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','LA','1','Col_B');">Abundant</td>
                          <td id="LA2" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','LA','2','Col_B');">Thinning</td>
                          <td id="LA3" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','LA','3','Col_B');">Bald areas</td>
                          <td id="LA4" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','LA','4','Col_B');">Mostly bald</td>
                          <td id="LA5" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Plantar surface</td>
                          <td id="PS-1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','PS','-1','Col_A');">Heel-toe<br>
                            40-50 mm: -1<br>
                           &lt; 40 mm: -2 </td>
                          <td id="PS0" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','PS','0','Col_A');">>50 mm, no crease</td>
                          <td id="PS1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','PS','1','Col_A');">Faint red marks</td>
                          <td id="PS2" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','PS','2','Col_A');">Anterior transverse crease only</td>
                          <td id="PS3" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','PS','3','Col_A');">creases anterior 2/3</td>
                          <td id="PS4" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','PS','4','Col_A');">Creases over entire sole</td>
                          <td id="PS5" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_B EM_Cell_height EM_Title labelhold">Breast</td>
                          <td id="BR-1" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','BR','-1','Col_B');">Imperceptible</td>
                          <td id="BR0" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','BR','0','Col_B');">Barely perceptible</td>
                          <td id="BR1" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','BR','1','Col_B');">Flat areola, no bud</td>
                          <td id="BR2" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','BR','2','Col_B');">Stippled areola, 1-2 mm bud</td>
                          <td id="BR3" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','BR','3','Col_B');">Raised areola, 3-4 mm bud</td>
                          <td id="BR4" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','BR','4','Col_B');">Full areola, 5-10 mm bud</td>
                          <td id="BR5" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Eye/Ear</td>
                          <td id="EE-1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','EE','-1','Col_A');">Lids fused<br>
                            loosely: -1 <br>
                            tightly: -2</td>
                          <td id="EE0" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','EE','0','Col_A');">Lids open; pinna flat; stays folded</td>
                          <td id="EE1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','EE','1','Col_A');">Slightly curved pinna; soft; slow recoil</td>
                          <td id="EE2" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','EE','2','Col_A');">Well curved pinna; soft but ready recoil</td>
                          <td id="EE3" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','EE','3','Col_A');">Formed and firm, instant recoil</td>
                          <td id="EE4" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','EE','4','Col_A');">Thick cartilage, ear stiff</td>
                          <td id="EE5" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_B EM_Cell_height EM_Title labelhold">Genitals(Male)</td>
                          <td id="GM-1" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GM','-1','Col_B');">Scrotum flat, smooth</td>
                          <td id="GM0" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GM','0','Col_B');">Scrotum empty, faint rugae</td>
                          <td id="GM1" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GM','1','Col_B');">Testes in upper canal, rare rugae</td>
                          <td id="GM2" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GM','2','Col_B');">Testes descending, few rugae</td>
                          <td id="GM3" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GM','3','Col_B');">Testes down, good rugae</td>
                          <td id="GM4" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GM','4','Col_B');">Testes pendulous, deep rugae</td>
                          <td id="GM5" align="center" valign="middle"class="EM_Col_B EM_Cell_height  EM_TableACell_Width">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="middle"class="EM_Col_A EM_Cell_height EM_Title labelhold">Genitals(Female)</td>
                          <td id="GF-1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GF','-1','Col_A');">Clitoris prominent, labia flat</td>
                          <td id="GF0" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GF','0','Col_A');">Clitoris prominent, small labia minora</td>
                          <td id="GF1" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GF','1','Col_A');">Clitoris prominent, enlarging minora</td>
                          <td id="GF2" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GF','2','Col_A');">Majora and minora equally prominent</td>
                          <td id="GF3" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GF','3','Col_A');">Majora large, minora small</td>
                          <td id="GF4" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width" onClick="calScore('PM','GF','4','Col_A');">Majora cover clitoris and minora</td>
                          <td id="GF5" align="center" valign="middle"class="EM_Col_A EM_Cell_height  EM_TableACell_Width">&nbsp;</td>
                        </tr>
                      </table>
                      <input type="hidden" id="NE" name="NE" id="NE" value=""/>
                      <input type="hidden" id="PO" name="PO" id="PO" value=""/>
                      <input type="hidden" id="SQ" name="SQ" id="SQ" value=""/>
                      <input type="hidden" id="AR" name="AR" id="AR" value=""/>
                      <input type="hidden" id="PA" name="PA" id="PA" value=""/>
                      <input type="hidden" id="SS" name="SS" id="SS" value=""/>
                      <input type="hidden" id="HE" name="HE" id="HE" value=""/>
                      <input type="hidden" id="PM" name="PM" id="PM" value=""/>
                      <input type="hidden" id="SK" name="SK" id="SK" value=""/>
                      <input type="hidden" id="LA" name="LA" id="LA" value=""/>
                      <input type="hidden" id="PS" name="PS" id="PS" value=""/>
                      <input type="hidden" id="BR" name="BR" id="BR" value=""/>
                      <input type="hidden" id="EE" name="EE" id="EE" value=""/>
                      <input type="hidden" id="GM" name="GM" id="GM" value=""/>
                      <input type="hidden" id="GF" name="GF" id="GF" value=""/>
                      <input type="hidden" id="TT" name="TT" id="TT" value=""/></td>
                  </tr>
                </table>
                </td>
              <td width="30%" id="" align="center" valign="top" class="EM_TableBcontainer">
              <table width="98%" border="0" cellspacing="0" cellpadding="0" class="EM_L_Total_count" style="border-right:2px solid #9dbbc3">
                  <tr>
                    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="left" valign="top"><div class="EM_L_header EM_L_Total_count">
                              <table width="140" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td align="center" valign="middle" class="EM_Sub_Header">&nbsp;</td>
                                </tr>
                                <tr>
                                  <td align="center" valign="middle" class="EM_Sub_Header">Neuromuscular</td>
                                </tr>
                                <tr>
                                  <td id="NESCORE" height="80" align="center" valign="middle" class="EM_L-Count">&nbsp;</td>
                                </tr>
                              </table>
                            </div></td>
                          <td align="left" valign="top"><div class="EM_L_header EM_L_Total_count">
                              <table width="140" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td align="center" valign="middle" class="EM_Sub_Header">&nbsp;</td>
                                </tr>
                                <tr>
                                  <td align="center" valign="middle" class="EM_Sub_Header">Physical</td>
                                </tr>
                                <tr>
                                  <td id="PMSCORE" height="80" align="center" valign="middle" class="EM_L-Count">&nbsp;</td>
                                </tr>
                              </table>
                          </div></td>
                      </tr>
                      </table></td>
                  </tr>
                  <tr>
                    <td align="center" valign="middle"><div class="EM_L_Total_count">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="center" valign="middle">Total Score</td>
                          </tr>
                          <tr>
                            <td id="TOTALSCORE" height="60" align="center" valign="middle" class="EM_L-Count">&nbsp;</td>
                          </tr>
                        </table>
                      </div></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top"><div class="EM_L_Guide">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left" valign="top" bgcolor="#dbe6e8"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td colspan="5" align="center" class="Em_L_border_Top"><!--   /* Font Definitions */   @font-face  	{font-family:"Cambria Math";  	panose-1:2 4 5 3 5 4 6 3 2 4;}  @font-face  	{font-family:Calibri;  	panose-1:2 15 5 2 2 2 4 3 2 4;}   /* Style Definitions */   p.MsoNormal, li.MsoNormal, div.MsoNormal  	{margin-top:0in;  	margin-right:0in;  	margin-bottom:8.0pt;  	margin-left:0in;  	line-height:107%;  	font-size:11.0pt;  	font-family:"Calibri",sans-serif;}  .MsoChpDefault  	{font-family:"Calibri",sans-serif;}  .MsoPapDefault  	{margin-bottom:8.0pt;  	line-height:107%;}   /* Page Definitions */   @page WordSection1  	{size:8.5in 11.0in;  	margin:1.0in 1.0in 1.0in 1.0in;}  div.WordSection1  	{page:WordSection1;}  --> 
                                    Maturity Rating</td>
                                </tr>
                                <tr>
                                  <td width="24%" align="center" valign="middle" class="Em_L_border">Score</td>
                                  <td width="24%" align="center" valign="middle" class="Em_L_border1"> weeks</td>
                                  <td width="4%" align="center" valign="middle" bgcolor="#9dbbc3" class="Em_L_border2" 	style"border-right: 2px solid #9dbbc3;">&nbsp;</td>
                                  <td width="24%" align="center" valign="middle" class="Em_L_border">Score</td>
                                  <td width="24%" align="center" valign="middle" class="Em_L_border1"> weeks</td>
                                </tr>
                              </table></td>
                          </tr>
                          <tr>
                            <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td width="24%" align="center" valign="top" class="Em_L_title"><table width="100%" border="0" cellspacing="0" cellpadding="11">
                                      <tr>
                                        <td align="center" valign="middle">-10</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">-5</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">0</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">5</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">10</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">15</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">20</td>
                                      </tr>
                                  </table></td>
                                  <td width="24%" align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="11">
                                      <tr>
                                        <td align="center" valign="middle">20</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">22</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">24</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">26</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">28</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">30</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">32</td>
                                      </tr>
                                  </table></td>
                                  <td width="4%" align="center" valign="top" bgcolor="#9dbbc3" style="	border-right: 2px solid #9dbbc3;">&nbsp;</td>
                                  <td width="24%" align="center" valign="top" class="Em_L_title"><table width="100%" border="0" cellspacing="0" cellpadding="11">
                                      <tr>
                                        <td align="center" valign="middle">25</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">30</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">35</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">40</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">45</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">50</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                  <td width="24%" align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="11">
                                      <tr>
                                        <td align="center" valign="middle">34</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">36</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">38</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">40</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">42</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">44</td>
                                      </tr>
                                      <tr>
                                        <td align="center" valign="middle">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                </tr>
                              </table></td>
                          </tr>
                        </table>
                    </div></td>
                  </tr>
                </table></td>
            </tr>
          </table></td>
      </tr>
      
      <tr>
        <td align="left" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="EM_Tablecontainer page"	>
            <tr>
              <td  align=right class="EM_L-Count1"></td>
              <td align="center">&nbsp;</td>
              <td></td>
            </tr>
            <tr>
              <td  align=right class="EM_L-Count1"></td>
              <td align="center">&nbsp;</td>
              <td></td>
            </tr>
            <tr>
              <td  align=right class="EM_L-Count1"></td>
              <td align="center">&nbsp;</td>
              <td></td>
            </tr>
            <tr>
              <td  align=right class="EM_L-Count1"></td>
              <td align="center">&nbsp;</td>
              <td></td>
            </tr>
            <tr>
              <td  align=right class="EM_L-Count1"></td>
              <td align="center">&nbsp;</td>
              <td></td>
            </tr>
            <tr>
              <td width="42%"  align=right class="EM_L-Count1"></td>
              <td width="35%" align="center" class="EM_Title" style="font-size:14px; font-weight:bold"> (<%=jsonObj.get("LOGIN_PRACTITIONER_NAME") %> ) </td>
              <td width="23%"></td>
            </tr>
            <tr>
              <td width="42%" align=right class="EM_L-Count1"></td>
              <td width="35%" align="center" class="EM_Title" style="font-size:14px; font-weight:bold"> Signed By.</td>
              <td width="23%"></td>
            </tr>
        </table></td>
      </tr>
    </table>
    
  <!--/div-->
  <input type="hidden" name="patientId" id="patientId" value="<%=patient_id%>"/>
  <input type="hidden" name="encounterId" id="encounterId" value="<%=encounter_id%>"/>
  <!--IN067564 starts -->
  <input type="hidden" name="isAuditYN" id="isAuditYN" value="<%=isAuditYN%>"/>
  <input type="hidden" name="Recorded_date" id="Recorded_date" value="<%=Recorded_date%>"/>
  <!--IN067564  ends-->
  <SCRIPT>
 // displayRecordScore('<%=patient_id%>','Print');commented for IN067564
	displayRecordScore('<%=patient_id%>','Print','<%=isAuditYN%>','<%=encounter_id%>','<%=Recorded_date%>');
	//window.print();//IN067564
	var printWindow = window;
	setTimeout(function() {  window.close(); printWindow.print() }, <%=note_print_time_interval %>);
</SCRIPT>
</form>
</body>
</html>

