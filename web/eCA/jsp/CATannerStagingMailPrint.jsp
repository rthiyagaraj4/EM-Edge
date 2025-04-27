<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id 		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id 	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String stageOfPuberty 	= request.getParameter("stageOfPuberty")==null?"":request.getParameter("stageOfPuberty");
String facility_id 		= (String)session.getAttribute("facility_id");
String login_practitioner_id	= (String) session.getValue("ca_practitioner_id");
String recorded_date = request.getParameter("recorded_date")==null?"":request.getParameter("recorded_date");//IN067402
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale 			= (String) p.getProperty("LOCALE");
String bean_id			= "@catannerStagingBean"+patient_id;
String bean_name		= "eCA.CATannerStagingBean";
int note_print_time_interval	=	1500;
eCA.CATannerStagingBean beanObj = (eCA.CATannerStagingBean)getObjectFromBean(bean_id,bean_name,session);
//JSONObject jsonObj = beanObj.getBallardScoreHeaderDetails(request, patient_id,facility_id,locale,login_practitioner_id);
JSONObject jsonObj = beanObj.getBallardScoreHeaderDetails(request, patient_id,facility_id,locale,login_practitioner_id,recorded_date);
note_print_time_interval=Integer.parseInt((String)jsonObj.get("NOTE_PRINT_TIME_INTERVAL"));

%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>	
		<link rel='StyleSheet' href='../html/CATannerStaging.css' type='text/css'>	
		<script language='javascript' src='../js/json2.js'></script>	
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../js/CATannerStaging.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.Hospital_name {
	font-size: 25px;
	font-weight: bold;
}
.Hospital_name_sub {
	font-size: 18px;
	font-weight: bold;
}
.lablebold {
	font-weight: bold;
	padding-left: 5px;
}
.divborder {
	border: 1px solid #ccc;
}
.Em_box_Dis {
	padding-left: 5px;
}
.Em_box_Select {
	border: 3px solid #000;
}
</style>
	</head>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='TannerStagingForm' id='TannerStagingForm' method ='post' target='messageFrame'>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" valign="top" class="Hospital_name"><%=jsonObj.get("SITE_NAME") %></td>
        </tr>
        <tr>
          <td align="center" valign="top" class="Hospital_name_sub"><%=jsonObj.get("FACILITY_NAME") %></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="5">
        <tr>
          <td width="7%" align="left" valign="top" class="lablebold">Patient ID</td>
          <td width="49%" align="left" valign="top">: &nbsp;<%=patient_id %></td>
          <td width="7%" align="left" valign="top" class="lablebold">Recorded Date</td>
          <td width="37%" align="left" valign="top">: &nbsp; <%=jsonObj.get("EVENT_DATE_TIME") %></td>
        </tr>
        <tr>
          <td align="left" valign="top" class="lablebold">Patient Name</td>
          <td align="left" valign="top">:  &nbsp;<%=jsonObj.get("PATIENT_NAME") %></td>
          <td align="left" valign="top" class="lablebold">Practitioner Name</td>
          <td align="left" valign="top">: &nbsp; <%=jsonObj.get("PRACTITIONER_NAME") %></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="9%" align="left" valign="top" class="divborder lablebold">Stages of puberty</td>
          <td width="44%" align="left" valign="top" class="divborder lablebold"><fmt:message key="eCA.GenitalDevelopment.label" bundle="${ca_labels}"/></td>
          <td width="47%" align="left" valign="top" class="divborder lablebold"><fmt:message key="eCA.PubicHair.label" bundle="${ca_labels}"/></td>
        </tr>
        <tr>
          <td align="left" valign="middle"  class="divborder lablebold">Stage 01</td>
          <td colspan="2" align="left" valign="top" class="divborder" ><div id="SP1" class="Em_box"  onClick="selectTannerStaging('SP','1');">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr class="Em_box_H">
                  <td width="9%" align="left" valign="top"><img src="../../eCA/images/B_H_Stage01.PNG" width="144" height="80" /></td>
                  <td width="37%" align="left" valign="top" class="Em_box_Dis">Pre-adolescent, testes, scrotum and penis are of about the same size and proportion as in early childhood.</td>
                  <td width="54%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Pre-adolescent. The vellus over the pubes is not further developed than that over the abdominal wall, i.e. no pubic hair.</td>
                </tr>
              </table>
            </div></td>
        </tr>
        <tr>
          <td align="left" valign="middle" class="divborder lablebold">Stage 02</td>
          <td colspan="2" align="left" valign="top" class="divborder" ><div id="SP2" class="Em_box" onClick="selectTannerStaging('SP','2');">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr class="Em_box_H" >
                  <td width="9%" align="center" valign="top" bgcolor="#FFFFFF"><img src="../../eCA/images/B_H_Stage02.PNG" width="144" height="80" /></td>
                  <td width="37%" align="left" valign="top" class="Em_box_Dis">Enlargement of scrotum and testes. Skin of scrotum reddens and changes in texture. Little or no enlargement of penis at this stage.</td>
                  <td width="54%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Sparse growth of long, slightly pigmented downy hair, straight or slightly curled at the base of the penis.</td>
                </tr>
              </table>
            </div></td>
        </tr>
        <tr>
          <td align="left" valign="middle"  class="divborder lablebold">Stage 03</td>
          <td colspan="2" align="left" valign="top" class="divborder" ><div id="SP3" class="Em_box"  onClick="selectTannerStaging('SP','3');">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr class="Em_box_H">
                  <td width="9%" align="center" valign="top" bgcolor="#FFFFFF"><img src="../../eCA/images/B_H_Stage03.PNG" width="144" height="80" /></td>
                  <td width="37%" align="left" valign="top" class="Em_box_Dis">Enlargement of the penis which occurs at first mainly in length. Further growth of the testes and scrotum.</td>
                  <td width="54%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Considerably darker, coarser and more curled. The hair spreads sparsely over the junction of the pubes.</td>
                </tr>
              </table>
            </div></td>
        </tr>
        <tr>
          <td align="left" valign="middle" class="divborder lablebold">Stage 04</td>
          <td colspan="2" align="left" valign="top" class="divborder" ><div id="SP4" class="Em_box_Select"  onClick="selectTannerStaging('SP','4');">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr class="Em_box_H">
                  <td width="9%" align="center" valign="top" bgcolor="#FFFFFF"><img src="../../eCA/images/B_H_Stage04.PNG" width="144" height="80" /></td>
                  <td width="37%" align="left" valign="top" class="Em_box_Dis">Increased size of penis with growth in breadth and development of glans. Testes and scrotum larger, scrotal skin darkened.</td>
                  <td width="54%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Hair now adult in type, but area covered is still considerably smaller then in the adult, No spread to the medial surface of thighs.</td>
                </tr>
              </table>
            </div></td>
        </tr>
        <tr>
          <td align="left" valign="middle"  class="divborder lablebold">Stage 05</td>
          <td colspan="2" align="left" valign="top" class="divborder" ><div id="SP5" class="Em_box"  onClick="selectTannerStaging('SP','5');">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr class="Em_box_H">
                  <td width="9%" align="center" valign="top" bgcolor="#FFFFFF"><img src="../../eCA/images/B_H_Stage05.PNG" width="144" height="80" /></td>
                  <td width="37%" align="left" valign="top" class="Em_box_Dis">Genitalia adult in size and shape.</td>
                  <td width="54%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Adult in quantity and type with distribution of the horizontal (or classically feminine) pattern. Spread to medial surface of thighs but not up linea alba or elsewhere above the base of the inverse triangle (spread up linea alba occurs late and is rated stage 6).</td>
                </tr>
              </table>
            </div></td>
        </tr>
        
      </table></td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="right" valign="middle">(<%=jsonObj.get("LOGIN_PRACTITIONER_NAME") %> ) </td>
        <td align="right" valign="middle">&nbsp;</td>
      </tr>
      <tr>
        <td width="89%" align="right" valign="middle">Signed By.</td>
        <td width="11%" align="right" valign="middle">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="left" valign="top">&nbsp;</td>
  </tr>
</table>
			<!-- </div> -->
			<input type="hidden" name="stageOfPuberty" id="stageOfPuberty" value=""/>
			<input type="hidden" name="pubicHair" id="pubicHair" value=""/>
			<SCRIPT>			
				selectTannerStaging('SP','<%=stageOfPuberty%>','D');
				window.print();
				setTimeout(function() { window.close(); }, <%=note_print_time_interval %>);
			</SCRIPT>
		</form>
	</body>
</html>

