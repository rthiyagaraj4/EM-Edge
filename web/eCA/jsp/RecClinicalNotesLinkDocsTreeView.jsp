<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!--      <link rel="stylesheet" type="text/css" href="../../eCA/html/CAMainMenu.css"></link>
 -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCA/js/Encounters.js' language='javascript'></script>
    <script src='../../eCA/js/dTree.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<body class='CA_COMMON' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
    var obj;
    obj = new dTree('obj');
    obj.add(0,-1,'<font size=1 style=font-weight:bold style=color:#333><fmt:message key="eCA.AllNotes.label" bundle="${ca_labels}"/></font>');
    obj.config.useStatusText=true;
    <%
Connection con    =  null;
PreparedStatement stmt    = null;
ResultSet rs            = null;
String patient_id = (request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
//String query="Select a.EVENT_DATE , to_char(a.event_date,'dd/mm/yyyy') e_date ,a.hist_rec_type hist_rec_type ,b.short_desc hist_rec_type_desc ,translate(a.event_class,'!@#$%^&*()','1234567890') event_class ,a.event_class event_class_original ,c.long_desc event_class_desc ,translate(a.event_group,'!@#$%^&*()','1234567890') event_group ,a.event_group event_group_original ,e.long_desc event_group_desc ,translate(a.event_code,'!@#$%^&*()','1234567890') event_code ,a.event_code event_code_original ,d.long_desc event_code_desc ,hist_data_type ,a.accession_num ,a.contr_sys_id ,a.contr_sys_event_code ,count(*) rec_count ,f.sec_hdg_code ,g.content_type sec_content_type ,g.sec_hdg_desc ,f.SUBSEC_HDG_CODE ,h.content_type subsec_content_type ,h.sec_hdg_desc subsec_hdg_desc From cr_encounter_detail a ,cr_hist_rec_type b ,cr_event_class c   ,cr_clin_event_mast d ,cr_clin_event_group e ,ca_encntr_note_section f ,ca_section_hdg g      ,ca_section_hdg h where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and c.event_class= a.event_class and d.hist_rec_type=a.hist_rec_type and d.event_code=a.event_code and e.hist_rec_type(+)=a.hist_rec_type and e.event_group(+)=a.event_group and f.accession_num = a.accession_num and a.hist_rec_type = 'CLNT' and g.sec_hdg_code=f.sec_hdg_code and h.sec_hdg_code(+)=f.SUBSEC_HDG_CODE and  a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA',NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E') group by a.EVENT_DATE ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') ,a.event_class ,a.event_code ,f.sec_hdg_code ,h.sec_hdg_desc ,a.hist_rec_type ,b.short_desc ,c.long_desc ,a.event_group ,d.long_desc ,e.long_desc ,hist_data_type ,a.accession_num ,a.contr_sys_id ,a.contr_sys_event_code ,g.content_type  ,g.sec_hdg_desc ,f.SUBSEC_HDG_CODE ,h.content_type  order by e_date, b.short_desc,a.hist_rec_type,c.long_desc,a.event_class,e.long_desc ,a.event_group,d.long_desc,a.event_code  ";
String query="Select a.EVENT_DATE , to_char(a.event_date,'dd/mm/yyyy') e_date ,a.hist_rec_type hist_rec_type ,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'2') hist_rec_type_desc ,translate(a.event_class,'!@#$%^&*()','1234567890') event_class ,a.event_class event_class_original ,c.long_desc event_class_desc ,translate(a.event_group,'!@#$%^&*()','1234567890') event_group ,a.event_group event_group_original ,e.long_desc event_group_desc ,translate(a.event_code,'!@#$%^&*()','1234567890') event_code ,a.event_code event_code_original ,d.long_desc event_code_desc ,hist_data_type ,a.accession_num ,a.contr_sys_id ,a.contr_sys_event_code ,count(*) rec_count ,f.sec_hdg_code ,g.content_type sec_content_type ,g.sec_hdg_desc ,f.SUBSEC_HDG_CODE ,h.content_type subsec_content_type ,h.sec_hdg_desc subsec_hdg_desc From cr_encounter_detail a ,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d ,CR_CLN_EVT_GRP_LANG_VW e ,ca_encntr_note_section f ,ca_section_hdg g ,ca_section_hdg h where c.language_id = ? and d.language_id = ? and e.language_id = ? and c.hist_rec_type=a.hist_rec_type and c.event_class= a.event_class and d.hist_rec_type=a.hist_rec_type and d.event_code=a.event_code and e.hist_rec_type(+)=a.hist_rec_type and 	e.event_group(+)=a.event_group and 	f.accession_num = a.accession_num and a.hist_rec_type = 'CLNT' and g.sec_hdg_code=f.sec_hdg_code and h.sec_hdg_code(+)=f.SUBSEC_HDG_CODE and a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR (nvl(PROTECTION_IND,'N')='Z' and 	GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA',NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E') group by a.EVENT_DATE ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') ,a.event_class ,a.event_code ,f.sec_hdg_code ,h.sec_hdg_desc ,a.hist_rec_type ,b.short_desc ,c.long_desc ,a.event_group ,d.long_desc ,e.long_desc ,hist_data_type ,a.accession_num ,a.contr_sys_id ,a.contr_sys_event_code ,g.content_type  ,g.sec_hdg_desc ,f.SUBSEC_HDG_CODE ,h.content_type  order by e_date, a.hist_rec_type,c.long_desc,a.event_class,e.long_desc ,a.event_group,d.long_desc,a.event_code  ";

String e_date = "";
String hist_rec_type = "";

String event_class = "";

String event_class_desc = "";



String event_code = "";

String event_code_desc = "";
String hist_data_type = "";
String accession_num = "";
String contr_sys_id = "";
String contr_sys_event_code = "";

String sec_hdg_code = "";

String sec_hdg_desc = "";
String subsec_hdg_code = "";

String subsec_hdg_desc = "";
String nodeId = "";
String prevNodeId = "";
String dateId = "";
String prevDateId = "";
String prevEventClassId = "";
String prevEventCodeId = "";
String prevSectionId = "";
String prevSubSectionId = "";

StringBuffer buf = new StringBuffer();
try
{
	con    = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(query);
    stmt.setString(1,locale);
	stmt.setString(2,locale);
	stmt.setString(3,locale);
	stmt.setString(4,locale);
	stmt.setString(5,patient_id);
    rs = stmt.executeQuery();
    while(rs.next())
    {
        
        e_date = rs.getString("e_date");
        hist_rec_type = (rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type"));

        event_class = (rs.getString("event_class")==null?"":rs.getString("event_class"));

        event_class_desc = (rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc"));



        event_code = (rs.getString("event_code")==null?"":rs.getString("event_code"));

        event_code_desc = (rs.getString("event_code_desc")==null?"":rs.getString("event_code_desc"));
        hist_data_type = (rs.getString("hist_data_type")==null?"":rs.getString("hist_data_type"));
        accession_num = (rs.getString("accession_num")==null?"":rs.getString("accession_num"));
        contr_sys_id = (rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id"));
        contr_sys_event_code = (rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code"));

        sec_hdg_code = (rs.getString("sec_hdg_code")==null?"":rs.getString("sec_hdg_code"));

        sec_hdg_desc = (rs.getString("sec_hdg_desc")==null?"":rs.getString("sec_hdg_desc"));
        subsec_hdg_code = (rs.getString("subsec_hdg_code")==null?"":rs.getString("subsec_hdg_code"));
        
        subsec_hdg_desc = (rs.getString("subsec_hdg_desc")==null?"":rs.getString("subsec_hdg_desc"));
        dateId = e_date;
		//additions of nodes starts from here
        if(!prevDateId.equals(dateId))
        {
            nodeId = e_date.trim();
            out.println("obj.add('"+nodeId+"',0,'"+e_date+"');");
            prevDateId = e_date;
			prevNodeId = e_date;
        }		
        nodeId = e_date.trim() + event_class.trim();
		if(!prevEventClassId.equals(nodeId))
		{
			out.println("obj.add('"+nodeId+"','"+e_date+"','"+event_class_desc+"');");
			prevEventClassId = nodeId;
		}
        prevNodeId = nodeId;

        buf = new StringBuffer();
        buf.append("?data_type=" + hist_data_type);
        buf.append("&hist_type=" + hist_rec_type);
        buf.append("&accession_num=" + accession_num);
        buf.append("&from=B");
        buf.append("&contr_sys_id=" + contr_sys_id);
        buf.append("&contr_sys_event_code=" + contr_sys_event_code);
		//query string construction for this event_code node
        nodeId += event_code.trim() + accession_num.trim();
        if(!prevEventCodeId.equals(nodeId))
        {
            out.println("obj.add('"+nodeId+"','"+prevNodeId+"','"+event_code_desc+"','" + "../../eCA/jsp/EncountersDocDisplay.jsp" + buf + "','" + event_code_desc +"','RecClinicalNotesLinkDocsPreviewFrame');");
            prevEventCodeId = nodeId;
			//function signature
			//obj.add(id, parentid, name, url, title, target, icon, iconOpen, open)
			//default icons are taken when those parameters are not specified 
        }
        prevNodeId = nodeId;
        nodeId += sec_hdg_code.trim();
        buf = new StringBuffer();
        buf.append("?accession_num=" + accession_num);
        buf.append("&section_hdg_code=" + sec_hdg_code);
        buf.append("&subsec_hdg_code=" + subsec_hdg_code);
        
        if(!subsec_hdg_code.equals(""))
            buf.append("&display_code=" + "FullSection");
        if(!prevSectionId.equals(nodeId))
        {
            String image = "";
            if(subsec_hdg_code.equals(""))
                image = "../../eCA/images/view.gif";
            out.println("obj.add('"+nodeId+"','"+prevNodeId+"','"+sec_hdg_desc.replace('\'',' ')+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp" + buf + "','" + sec_hdg_desc.replace('\'',' ') +"','RecClinicalNotesLinkDocsPreviewFrame','" + image + "');");
            prevSectionId = nodeId;
        }
        prevNodeId = nodeId;
		//if subsection does not exist further addition are not made.
        if(!subsec_hdg_code.equals(""))
        {
            buf = new StringBuffer();
            buf.append("?accession_num=" + accession_num);
            buf.append("&section_hdg_code=" + sec_hdg_code);
            buf.append("&subsec_hdg_code=" + subsec_hdg_code);
            nodeId += subsec_hdg_code.trim();			
            if(!prevSubSectionId.equals(nodeId))
            {

                out.println("obj.add('"+nodeId+"','"+prevNodeId+"','"+subsec_hdg_desc.replace('\'',' ')+"','" + "../../eCA/jsp/RecClinicalNotesDocDisplay.jsp" + buf + "','" + subsec_hdg_desc.replace('\'',' ') +"','RecClinicalNotesLinkDocsPreviewFrame','../../eCA/images/view.gif');");
                prevSubSectionId = nodeId;
            }
        }
	    prevNodeId = nodeId;
		out.println("    ");
		out.println("    ");
		out.println("    ");
    }//end of while 

	if(rs != null) rs.close();
    if(stmt != null) stmt.close();
}
catch(SQLException sqle)
{
  //  out.println("Exception:" + sqle);//COMMON-ICN-0181
       sqle.printStackTrace();//COMMON-ICN-0181
}
finally
{
    
    if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
document.write(obj);
obj.openAll();
</script>
</BODY>
</HTML>

