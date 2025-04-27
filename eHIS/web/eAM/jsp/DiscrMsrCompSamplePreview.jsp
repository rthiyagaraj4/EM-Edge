<%@ page contentType="application/xml;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*"  %>
<?xml-stylesheet type="text/xsl" href="../../eCA/html/RecClinicalNotesTemplateRecordingView.xsl"?>
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm" >
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<CSS sStyle="<%=sStyle%>"/>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<STYLE type="text/css">
	.READONLY
	{
		BACKGROUND-COLOR: #C0C0C0;
	}
</STYLE>



<USER-TEMPLATE><ROW><COL>
<PARAGRAPH  COLSPAN='6' CLASS='LABEL'><PRE> </PRE><SHORT-TEXT-WTD CLASS='LABEL'  NAME='C_MRLAE0' 	 COMPTYPE='H' PROMPT='Abdominal+Examination' SIZE ='0' MANDATORY="N"  MAXLENGTH = "0" ></SHORT-TEXT-WTD><PRE> </PRE><HIDDEN-FIELD NAME="mandatory_fields_para" VALUE=""></HIDDEN-FIELD><HIDDEN-FIELD NAME="para_std_component_information" VALUE=""></HIDDEN-FIELD><PRE></PRE></PARAGRAPH>
</COL></ROW></USER-TEMPLATE>

</DOCUMENT>




