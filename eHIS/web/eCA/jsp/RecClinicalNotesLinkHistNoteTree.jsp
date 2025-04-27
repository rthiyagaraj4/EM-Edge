
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
14/08/2012	IN034385	Dinesh T	To eradicate the script error in the history page
26/12/2013	IN045993	Ramesh G	Bru-HIMS-CRF-391-42552/10
-----------------------------------------------------------------------------------------------
--> 
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!--      <link rel="stylesheet" type="text/css" href="../../eCA/html/CAMainMenu.css"></link>
 -->
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
    <script src='../../eCA/js/Encounters.js' language='javascript'></script>
    <script src='../../eCA/js/dTree.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<body class='CA_COMMON' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'> 
<script language=javascript>
    var obj;
    obj = new dTree('obj');
    obj.add(0,-1,'<font size=1 style=font-weight:bold style=color:#333><fmt:message key="eCA.AllNotes.label" bundle="${ca_labels}"/></font>');
    obj.config.useStatusText=true;
    <%
	Connection con    = null;
	PreparedStatement stmt    = null;
	ResultSet rs            = null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String clinian_id=(String)session.getValue("ca_practitioner_id");
	String facility_id=(String)session.getValue("facility_id");
	String  patient_id			= "";
    String  encounter_id		= "";

	patient_id			=	(request.getParameter("patient_id")==null)		?	""	:	request.getParameter("patient_id");
    encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
    
	String	from_date_time		=	"";
	String  to_date_time		=	"";
	String  note_group			= "";
	String  note_type			= "";
	String  section				= "";
    String  current_encounter	= "";
    String  order_by1			= ""; //possible values are "D"-by Document Date "N" By Note Type
    String  order_by2			= "";
    String  author				= "";
		
	from_date_time		=	(request.getParameter("from_date_time")==null)		?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)		?	""	:	request.getParameter("to_date_time");
    note_group			=	(request.getParameter("note_group")==null)			?	""	:	request.getParameter("note_group");
	note_type			=	(request.getParameter("note_type")==null)			?	""	:	request.getParameter("note_type");
	section				=	(request.getParameter("section")==null)				?	""	:	request.getParameter("section");
	current_encounter	=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	order_by1			=	(request.getParameter("order_by1")==null)			?	""	:	request.getParameter("order_by1");
	order_by2			=	(request.getParameter("order_by2")==null)			?	""	:	request.getParameter("order_by2");
	author				=	(request.getParameter("author")==null)				?	""	:	request.getParameter("author");
	
	from_date_time		=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	//Other Variables
	String groupId1Col		="";
	String groupDesc1Col	="";
	String groupId2Col		="";
	String groupDesc2Col	="";
	
	String groupId1			="";
	String groupDesc1		="";
	String groupId2			="";
	String groupDesc2		="";
	String groupId3			="";
	String groupDesc3		="";
	String groupId4			="";
	String groupDesc4		="";
	String transFacilityId	="";
	String accessionNum		="";

	String prevGroupId1		="";
	String prevGroupId2		="";
	String prevGroupId3		="";

	
	StringBuffer query= new StringBuffer();

	if (order_by1.equals("D"))
	{	
		groupId1Col		=" TO_CHAR(A.EVENT_DATE_TIME,'YYYYMMDD') ";
		groupDesc1Col	=" TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY') ";
		groupId2Col		=" A.ACCESSION_NUM ";
		groupDesc2Col	=" TO_CHAR(A.EVENT_DATE_TIME,'HH24:MI')||' - '||C.NOTE_TYPE_DESC  ";
	}
	else
	{
		groupId1Col		=" A.NOTE_TYPE ";
		groupDesc1Col	=" C.NOTE_TYPE_DESC  ";
		groupId2Col		=" A.ACCESSION_NUM  ";
		groupDesc2Col	=" TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') ";

	}
	query.append(" SELECT A.EVENT_DATE_TIME, "+groupId1Col+" GROUP_ID1, "+groupDesc1Col+" GROUP_DESC1, "+groupId2Col+"	GROUP_ID2,"+groupDesc2Col+" GROUP_DESC2 ");
	query.append("	, B.SEC_HDG_CODE	GROUP_ID3 	, CA_GET_DESC.CA_SECTION_HDG(B.SEC_HDG_CODE,?,'1') GROUP_DESC3	, B.SUBSEC_HDG_CODE	GROUP_ID4	, CA_GET_DESC.CA_SECTION_HDG(B.SUBSEC_HDG_CODE,?,'1') 	GROUP_DESC4 	, A.FACILITY_ID 	, A.ACCESSION_NUM FROM 	  CA_ENCNTR_NOTE A 	, CA_ENCNTR_NOTE_SECTION B 	, CA_NOTE_TYPE_LANG_VW C  WHERE 	C.LANGUAGE_ID = ? AND A.PATIENT_ID=?   AND EVENT_DATE_TIME BETWEEN TO_DATE(NVL(?,'1/1/1900 00:00'),'DD/MM/YYYY HH24:MI') AND  TO_DATE(NVL(?,'1/1/4000 00:00'),'DD/MM/YYYY HH24:MI') AND  C.NOTE_TYPE=A.NOTE_TYPE    AND   B.FACILITY_ID  =A.FACILITY_ID    AND  B.ACCESSION_NUM=A.ACCESSION_NUM          and ( a.EVENT_STATUS  in ('4','5') or (a.EVENT_STATUS='3' and  c.PUBLISH_LEVEL='3')) ");

	//IN045993 Start.
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
	String resp_id			= (String)session.getValue("responsibility_id") == null ? "" : (String) session.getValue("responsibility_id");
	query.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");
	//IN045993 End.
		
	if (!note_group.equals(""))
		query.append(" and c.NOTE_GROUP_ID=? ");
	if (!note_type.equals(""))
		query.append(" and c.NOTE_TYPE=? ");
	if (!section.equals(""))
		query.append(" and b.sec_hdg_code=? "); 
	if (!current_encounter.equals("N"))
		query.append(" and a.facility_id=? and a.encounter_id=? ");
	if (author.equals("S"))
		query.append(" and a.PERFORMED_BY_ID=? ");

	if  (order_by2.equals("AS"))
	{	
			if (order_by1.equals("D"))
			{
				query.append(" ORDER BY  2, 1,4, B.NOTE_SEC_SEQ_NUM");			
			}
			else
			{
				query.append(" ORDER BY  3,2, 1,4, B.NOTE_SEC_SEQ_NUM");			
			}
			
	}
	else
	{
			
			if (order_by1.equals("D"))
			{
				query.append(" ORDER BY 2 desc ,1 desc ,4, B.NOTE_SEC_SEQ_NUM");
			}
			else
			{
				query.append(" ORDER BY 3 DESC, 2 DESC ,4 desc,1 desc, B.NOTE_SEC_SEQ_NUM");
			}

	}
//if order_by1


int    currIndex=0;
//int    count=1;


StringBuffer buf = new StringBuffer();
try
{
	con    = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(query.toString());
	stmt.setString(++currIndex,locale);
	stmt.setString(++currIndex,locale);
	stmt.setString(++currIndex,locale);
	stmt.setString(++currIndex,patient_id);
	stmt.setString(++currIndex,from_date_time);
	stmt.setString(++currIndex,to_date_time);
	if (!note_group.equals(""))
		stmt.setString(++currIndex,note_group);
	if (!note_type.equals(""))
		stmt.setString(++currIndex,note_type);
	if (!section.equals(""))
		stmt.setString(++currIndex,section);
	if (!current_encounter.equals("N"))
	{
		stmt.setString(++currIndex,facility_id);
		stmt.setString(++currIndex,encounter_id);
	}
	if (author.equals("S"))
		stmt.setString(++currIndex,clinian_id);
	
	rs = stmt.executeQuery();
    while(rs.next())
    {
        groupId1		=rs.getString("GROUP_ID1");
		groupDesc1		=rs.getString("GROUP_DESC1").replaceAll("\'","");//IN034385

		if (order_by1.equals("D"))
			groupDesc1 = com.ehis.util.DateUtils.convertDate(groupDesc1,"DMY","en",locale);

		groupId2		=rs.getString("GROUP_ID2");
		groupDesc2		=rs.getString("GROUP_DESC2").replaceAll("\'","");//IN034385
		groupId3		=rs.getString("GROUP_ID3");
		groupDesc3		=rs.getString("GROUP_DESC3").replaceAll("\'","");//IN034385
		groupId4		=rs.getString("GROUP_ID4");
		groupDesc4		=rs.getString("GROUP_DESC4").replaceAll("\'","");//IN034385
		transFacilityId	=rs.getString("FACILITY_ID");
		accessionNum	=rs.getString("ACCESSION_NUM");
		
	  // buf = new StringBuffer();
	   buf.setLength(0);
	   buf.append("?facility_id=" + transFacilityId);
	   buf.append("&accession_num=" + accessionNum);
	   buf.append("&patient_id=" + patient_id);
	   buf.append("&encounter_id=" + encounter_id);
	  
	   if(!groupId1.equals(prevGroupId1))
        {
            out.println("obj.add('G1"+groupId1+"',0,'"+groupDesc1+"');");
 			out.println("obj.add('G2"+groupId2+"','G1"+groupId1+"','"+groupDesc2+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc2+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
 			if (!groupId3.equals(groupId4))
			{
				
				buf.append("&section_hdg_code=" + groupId3);
	  	  		out.println("obj.add('G3"+groupId3+groupId2+"','G2"+groupId2+"','"+groupDesc3+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
			}
			prevGroupId1=groupId1;
			prevGroupId2=groupId2;
			prevGroupId3=groupId3;
			//count++;
        }		
		
		if(!groupId2.equals(prevGroupId2))
        {
			
      		out.println("obj.add('G2"+groupId2+"','G1"+groupId1+"','"+groupDesc2+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc2+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
 			if (!groupId3.equals(groupId4))
			{	
				
				buf.append("&section_hdg_code=" + groupId3);
				out.println("obj.add('G3"+groupId3+groupId2+"','G2"+groupId2+"','"+groupDesc3+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
			
			}
 			prevGroupId2=groupId2;
			prevGroupId3=groupId3;
        }
		if(!groupId3.equals(prevGroupId3))
        {
			if (!groupId3.equals(groupId4))
			{
					buf.append("&section_hdg_code=" + groupId3);
			  		out.println("obj.add('G3"+groupId3+"','G2"+groupId2+"','"+groupDesc3+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
			}
 			prevGroupId3=groupId3;
        }
		
		if (!groupId3.equals(groupId4))
		{
			buf.append("&section_hdg_code=" + groupId3);
			buf.append("&subsection_hdg_code=" + groupId4);

			out.println("obj.add('G4"+groupId4+"','G3"+groupId3+groupId2+"','"+groupDesc4+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
		}
		else
		{	buf.append("&section_hdg_code=" + groupId3);

			out.println("obj.add('G4"+groupId4+"','G2"+groupId2+"','"+groupDesc4+"','" + "../../eCA/jsp/RecClinicalNotesDocSectionDisplay.jsp"  + buf+  "','" +  groupDesc3+"','RecClinicalNotesLinkHistNoteAddTextHdrFrame');");
		}
		
       	

			   /*out.println("    ");
			   out.println("    ");
			   out.println("    ");*/
	}//end of while 
	
	if(rs != null) rs.close();
    if(stmt != null) stmt.close();
}
catch(SQLException sqle)
{
   // out.println("Exception:" + sqle);//COMMON-ICN-0181
	sqle.printStackTrace();
}

finally
{
    
    if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
document.write(obj);
obj.openAll();
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</BODY>
</HTML>

