<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
07/11/2011    IN029477      Chowminya G      	Incident No: IN029477 -  <Dosage details in link notes option - incorrect> 
18/04/2013    IN038667      Chowminya G         Result Link In Clinical Notes ? To Include ?Route?
30/04/2013    IN038667.1    Chowminya G         Reopen - Result Link In Clinical Notes ? To Include ?Route?
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
27/06/2014	IN049863		Karthi L	27/06/2014		Akbar				Link Doc medication of record clinical note, system does not display list of medication.
25/07/2016	IN060688		Ramesh G										AAKH-CRF-0088.1
08/03/2018	IN066621		Ramesh G										ML-BRU-SCF-1770
27/01/20222	IN027665		Ramesh G 										MMS-DM-CRF-0199		
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="Bean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
		<title></title>
	<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p1.getProperty("LOCALE");
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- added by Kishore Kumar N on 10/12/2008  -->
		
		<!-- end here -->
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkMed.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>
<%
	String drug_name="";
	String generic_name=""; //IN060688
	//String dosage_detail="";
	String qty_value="";
	String qty_unit="";
	String freq_desc="";
	String durn_value="";
	String durn_desc="";
	String start_date="";
	String end_date="";
	//IN038667 - Start
	String route_desc="";
	String		width			=	"";
	double		col_width		=	0.0;
	//IN038667 - end
	StringBuffer strsql1 = new StringBuffer(" ");
	
	String from_date_time	=	request.getParameter("from_date_time")==null?"1/1/1900":request.getParameter("from_date_time");
	String to_date_time		=	request.getParameter("to_date_time")==null?"1/1/4000":request.getParameter("to_date_time");
	String from_date_time_th=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	String to_date_time_th	=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	String order			=	request.getParameter("order")==null?"":request.getParameter("order");
	String patient_class	=	request.getParameter("patient_class")==null?"A":request.getParameter("patient_class");
	String ord_status		=	request.getParameter("ord_status")==null?"A":request.getParameter("ord_status");
	String current_encounter=	request.getParameter("current_encounter")==null?"":request.getParameter("current_encounter");
	String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id		=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String from 			=	request.getParameter("from");
	String to 				= 	request.getParameter("to");
	//String whereclause		=	request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	
	String facility_id		=	(String)session.getValue("facility_id");//--[IN029477]
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String strOrderId = "";
	String strOrdLineNum = "";
	String strSliding_scale_yn = "";
	
	String pract_id=(String)session.getValue("ca_practitioner_id");
	String rowid="";

	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
	String col_field ="";
	//String col_val ="";
	int col_span=0;
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	PreparedStatement pstmt=null , stmt1 = null, stmt2 = null,stmt3 = null,stmt4 = null;//--[IN029477]
	ResultSet rset=null, rs1 = null, rs2 = null, rs3 = null, rs4 = null;//--[IN029477]

	int start = 0 ;
	int end = 0 ;
	int i = 1;
	int k = 0;
	int maxRecord = 0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

   	try
	{
		con =  ConnectionManager.getConnection(request);
		StringBuffer str=new StringBuffer();

		//str.append("SELECT COUNT(*) as total FROM   OR_ORDER A, OR_ORDER_LINE B, AM_FREQUENCY C, AM_DURATION_TYPE E, IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID = B.ORDER_ID AND C.FREQ_CODE  = B.FREQ_CODE AND E.DURN_TYPE= B.DURN_TYPE AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)+.9999   AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' ");
	 
		//str.append("SELECT COUNT(*) as total FROM   OR_ORDER A, OR_ORDER_LINE B,  IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID = B.ORDER_ID AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)   AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and a.order_type_code != 'MS' ");// commented for IN049863
		str.append("SELECT COUNT(*) as total FROM   OR_ORDER A, OR_ORDER_LINE B,  IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID = B.ORDER_ID AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)   AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and b.order_type_code != 'MS' "); // modified for IN049863
		if (!patient_class.equalsIgnoreCase("A"))
		{	
			// str.append("AND A.PATIENT_CLASS =?");
			str.append("AND A.encounter_id in (select encounter_id from pr_encounter where patient_id=? and patient_class=?)"); 
		}
		// else
		//	str.append(" AND  A.PATIENT_CLASS IN ('DC','EM','XT','IP','OP')");

		if (!ord_status.equalsIgnoreCase("A"))
			str.append(" AND B.ORDER_LINE_STATUS =?");
		else
			str.append(" AND B.ORDER_LINE_STATUS IN (select  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','35','36','56','58','45','50','93','99', '62', '64') )");   //IN027665  added 62, 64
		//str.append(" AND B.ORDER_LINE_STATUS IN (select ORDER_STATUS_CODE from OR_ORDER_STATUS_CODE)");
		//str.append(" AND B.ORDER_LINE_STATUS IN ('CD','CN','DC','IR','OS','AL')");
	
		//A.ORD_PRACT_ID
	
		if (order.equalsIgnoreCase("S"))
			str.append("AND A.ORD_PRACT_ID = ?");
	
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			str.append(" and a.encounter_id = ?");
	
		str.append(" ORDER BY B.CATALOG_DESC");

		stmt = con.prepareStatement(str.toString());	  
	  
	  
		//AND A.PATIENT_ID=?
		/* stmt.setString(1,from_date_time);
		stmt.setString(2,to_date_time);
		stmt.setString(3,patient_id);
		stmt.setString(4,pract_id);
		stmt.setString(5,encounter_id);*/

		int st1=0;

		stmt.setString(++st1,from_date_time_th);
        stmt.setString(++st1,to_date_time_th);
		stmt.setString(++st1,patient_id);

		if (!patient_class.equalsIgnoreCase("A"))
		{
			stmt.setString(++st1,patient_id);
			stmt.setString(++st1,patient_class);
		}
		if (!ord_status.equalsIgnoreCase("A"))
		    stmt.setString(++st1,ord_status);
		if (order.equalsIgnoreCase("S")) 
			stmt.setString(++st1,pract_id);
		
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			stmt.setString(++st1,encounter_id);		
	   
		rs = stmt.executeQuery();
		
		if(rs!=null && rs.next())
			maxRecord=rs.getInt("total");

		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();

		if (maxRecord== 0)
		{
	%>
	  	<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
	<%
		}
		
		//  if ( (whereclause == null || whereclause.equals("")) )
		//{
	  
		/*  strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,B.QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,C.FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,E.DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.SHORT_DESC,G.SHORT_DESC) LOCATION,B.ORDER_LINE_STATUS FROM   OR_ORDER A, OR_ORDER_LINE B, AM_FREQUENCY C, AM_DURATION_TYPE E, IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID   = B.ORDER_ID AND C.FREQ_CODE  = B.FREQ_CODE AND E.DURN_TYPE= B.DURN_TYPE AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)+.9999  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' ");
	
	
		if (!patient_class.equalsIgnoreCase("A"))
			strsql1.append("AND A.PATIENT_CLASS =?");
		//else
		//strsql1.append(" AND  A.PATIENT_CLASS IN ('DC','EM','XT','IP','OP')");
	
		if (!ord_status.equalsIgnoreCase("A"))
			strsql1.append(" AND B.ORDER_LINE_STATUS =?");
		else
			strsql1.append(" AND B.ORDER_LINE_STATUS IN (select  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','36','56','58','45','50','93','99')) ");
	
		if (order.equalsIgnoreCase("S"))
		strsql1.append("AND A.ORD_PRACT_ID = ?");

		//out.println("<script>alert('ord_status"+ord_status+"')</script>");
		//out.println("<script>alert('strsql1"')</script>");
	
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			strsql1.append(" and a.encounter_id = ?");
	
		strsql1.append(" ORDER BY DUP_DESC,B.CATALOG_DESC");*/
	
		//strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,decode(h.sliding_scale_yn,'Y','<font color=red>(Sliding Scale)</font>','') sliding_scale_yn,RTRIM (RTRIM (TO_CHAR (B.QTY_VALUE, '9999999999999990.999999999999'), '0'), '.') QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,AM_GET_DESC.AM_FREQUENCY(B.FREQ_CODE,?,'1') FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,AM_GET_DESC.AM_DURATION_TYPE(B.DURN_TYPE,?,'1') DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,(SELECT 'Route :'|| '<span style = background-color:'|| DECODE (SUBSTR (route_color, 7, 12),'', 'ffffff', SUBSTR (route_color, 7, 12)) || '>'|| '<font color='|| DECODE (substr(route_color,0,6),'','000000',substr(route_color,0,6)) || '>'|| route_desc|| '</font>'|| '</span>' FROM ph_route_lang_vw WHERE language_id = ? AND route_code = B.route_code) route_desc FROM   OR_ORDER A, OR_ORDER_LINE B, IP_NURSING_UNIT_LANG_VW  F, OP_CLINIC_LANG_VW G,or_order_line_ph h WHERE b.order_id = h.order_id and b.order_line_num = h.order_line_num and F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? and A.ORDER_ID   = B.ORDER_ID   AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and a.order_type_code != 'MS' ");//IN038667 Included route //added decode to route_color IN038667.1 // commented for IN049863
		//IN060688 Start.
		//strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,decode(h.sliding_scale_yn,'Y','<font color=red>(Sliding Scale)</font>','') sliding_scale_yn,RTRIM (RTRIM (TO_CHAR (B.QTY_VALUE, '9999999999999990.999999999999'), '0'), '.') QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,AM_GET_DESC.AM_FREQUENCY(B.FREQ_CODE,?,'1') FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,AM_GET_DESC.AM_DURATION_TYPE(B.DURN_TYPE,?,'1') DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,(SELECT 'Route :'|| '<span style = background-color:'|| DECODE (SUBSTR (route_color, 7, 12),'', 'ffffff', SUBSTR (route_color, 7, 12)) || '>'|| '<font color='|| DECODE (substr(route_color,0,6),'','000000',substr(route_color,0,6)) || '>'|| route_desc|| '</font>'|| '</span>' FROM ph_route_lang_vw WHERE language_id = ? AND route_code = B.route_code) route_desc FROM   OR_ORDER A, OR_ORDER_LINE B, IP_NURSING_UNIT_LANG_VW  F, OP_CLINIC_LANG_VW G,or_order_line_ph h WHERE b.order_id = h.order_id and b.order_line_num = h.order_line_num and F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? and A.ORDER_ID   = B.ORDER_ID   AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and b.order_type_code != 'MS' ");  // modified for IN049863
		strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,i.GENERIC_NAME GENERIC_NAME,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,decode(h.sliding_scale_yn,'Y','<font color=red>(Sliding Scale)</font>','') sliding_scale_yn,RTRIM (RTRIM (TO_CHAR (B.QTY_VALUE, '9999999999999990.999999999999'), '0'), '.') QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,AM_GET_DESC.AM_FREQUENCY(B.FREQ_CODE,?,'1') FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,AM_GET_DESC.AM_DURATION_TYPE(B.DURN_TYPE,?,'1') DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,(SELECT 'Route :'|| '<span style = background-color:'|| DECODE (SUBSTR (route_color, 7, 12),'', 'ffffff', SUBSTR (route_color, 7, 12)) || '>'|| '<font color='|| DECODE (substr(route_color,0,6),'','000000',substr(route_color,0,6)) || '>'|| route_desc|| '</font>'|| '</span>' FROM ph_route_lang_vw WHERE language_id = ? AND route_code = B.route_code) route_desc FROM   OR_ORDER A, OR_ORDER_LINE B, IP_NURSING_UNIT_LANG_VW  F, OP_CLINIC_LANG_VW G,or_order_line_ph h, PH_GENERIC_NAME_LANG_VW i WHERE b.order_id = h.order_id and b.order_line_num = h.order_line_num and h.GENERIC_ID = i.GENERIC_ID  and i.LANGUAGE_ID(+) = ? and F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? and A.ORDER_ID   = B.ORDER_ID   AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and b.order_type_code != 'MS' ");  // modified for IN049863
		//IN060688 End.
		/*if (!patient_class.equalsIgnoreCase("A"))
			strsql1.append("AND A.PATIENT_CLASS =?");*/
		if (!patient_class.equalsIgnoreCase("A"))
		{		
			strsql1.append(" AND A.encounter_id in (select encounter_id from pr_encounter where patient_id=? and patient_class=?)"); 
		}
		//else
		//strsql1.append(" AND  A.PATIENT_CLASS IN ('DC','EM','XT','IP','OP')");
	
		if (!ord_status.equalsIgnoreCase("A"))
			strsql1.append(" AND B.ORDER_LINE_STATUS =?");
		else
			strsql1.append(" AND B.ORDER_LINE_STATUS IN (select  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','35','36','56','58','45','50','93','99','62','64')) ");  //IN027665  added 62, 64
	
		if (order.equalsIgnoreCase("S"))
			strsql1.append(" AND A.ORD_PRACT_ID = ?");

		//out.println("<script>alert('ord_status"+ord_status+"')</script>");
		//out.println("<script>alert('strsql1"')</script>");
	
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			strsql1.append(" and a.encounter_id = ?");
	
		strsql1.append(" ORDER BY DUP_DESC,B.CATALOG_DESC");
		/*}
		else
		{
			strsql1.append(whereclause);
		}*/
	
		//shaiju new diag starts
		categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";
	
		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());
		}
		else
		{
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();
			}
		}
	    //shaiju new diag ends

		//AND A.PATIENT_ID=?
		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);//IN038667
		stmt.setString(++st,locale);//IN060688
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
         
		stmt.setString(++st,from_date_time_th);
        stmt.setString(++st,to_date_time_th);
	  
		stmt.setString(++st,patient_id);
       
		if (!patient_class.equalsIgnoreCase("A"))
		{
			stmt.setString(++st,patient_id);
			stmt.setString(++st,patient_class);
		}
		if (!ord_status.equalsIgnoreCase("A"))
		    stmt.setString(++st,ord_status);	   
		if (order.equalsIgnoreCase("S")) 
			stmt.setString(++st,pract_id);
	  
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			stmt.setString(++st,encounter_id);
		
    	rs = stmt.executeQuery();
	%>

<body onScroll=" scrollTitle()" onKeyDown="lockKey()">

<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<form name="RecClinicalNotesLinkMedResultForm" id="RecClinicalNotesLinkMedResultForm">	
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr >
<%
	if ( !(start <= 1) )
	{
		out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
		out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkMedResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_class="+patient_class+"&ord_status="+ord_status+"&order="+order+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&current_encounter="+current_encounter+"&from="+(start-14)+"&to="+(end-14)+"&result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	else
	{
		out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
	}

	//out.println("<script>alert('start"+start+"')</script>");
	
	if ( !( (start+14) > maxRecord ) )
	{
		out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkMedResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_class="+patient_class+"&ord_status="+ord_status+"&order="+order+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&current_encounter="+current_encounter+"&from="+(start+14)+"&to="+(end+14)+"&result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
%>	
</td>
</tr>
</table>

<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr>
<th class='columnheadercenter' width="5%" style="font-size:10"><fmt:message key="Common.all.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></th>
<%
	if(fields.size()>0)
	{
		for(int l=0;l<fields.size();++l)
		{
			//IN038667 - Start
			col_span = fields.size();
			col_width= 100/col_span;
			width = col_width+"%";
			//IN038667 - end Included width in all 4 fields
			col_field = (String)fields.get(l);
			if(col_field.equals("DRUGNAME"))
			{
%>
				<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>				
<%
			}
			//IN060688 Start.
			else if("GENERICNAME".equals(col_field))
			{
%>				
				<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th> 
<%
			}
			//IN060688 End.
			else if(col_field.equals("DOSAGEDETAILS"))
			{
%>
				<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="eCA.DosageDetails.label" bundle="${ca_labels}"/></th>
<%
			}
			else if(col_field.equals("STARTDATE"))
			{
%>
				<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
<%
			}
			else if(col_field.equals("ENDDATE"))
			{
%>
				<th class='columnheadercenter' width='<%=width%>'  style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
<%
			}
		}
	}
	else
	{
	//IN038667 - Start
		col_width= 100/5;
		width = col_width+"%";
		//IN038667 - end Included width in all 4 fields
%>
		<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><!-- IN060688 -->
		<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="eCA.DosageDetails.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='<%=width%>' style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter' width='<%=width%>'style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
<%
	}
%>
</tr>
</table>
</div>
<table width="100%" class='grid' name="resultTable" id="resultTable" id="resultTable">
<% 	
    if ( start != 1 )
	{
		for( int j=1; j<start; i++,j++ )
		{
			 rs.next() ;
		}
	}
	String classValue="gridData";

	StringBuffer sbDivided		=	new StringBuffer();
	StringBuffer sbDosageDtl	=	new StringBuffer();

	String strSplitQry =	"";
	String strQtyQry =	"";//--[IN029477]
	String strQtyQry1 =	"";//--[IN029477]
	String uom_Dis = "D";//--[IN029477]
	String strSplitDosageFlag = "N", strDosageQry ="";
	
	int	p =	0, nMinVal =	0,	nMaxVal	= 0;

	strSplitQry	=	"select MIN(ORDER_LINE_DOSE_QTY_VALUE) min_val,max(ORDER_LINE_DOSE_QTY_VALUE) max_val from OR_ORDER_LINE_FIELD_VALUES where ORDER_ID = ? and ORDER_LINE_NUM =? AND ORDER_LINE_SEQ_NUM >= 200 and ORDER_LINE_FIELD_MNEMONIC = 'SCHED_ADMIN_TIME'";
	//--[IN029477] - Start
	strQtyQry	=	"select uom_display_in_trans from PH_FACILITY_PARAM where facility_id=?";
	stmt3 = con.prepareStatement(strQtyQry);
	stmt3.clearParameters();

				stmt3.setString(1,facility_id);

				rs3 = stmt3.executeQuery();

				if(rs3 != null && rs3.next() )
				{
					uom_Dis = rs3.getString("uom_display_in_trans");
				}
	//--[IN029477] - End
	
	stmt1 = con.prepareStatement(strSplitQry);
	//IN066621 Start.
	//strDosageQry	=	" SELECT Ph_Splitdose_NEW(?,?,'NOTES') dosagedtl FROM DUAL ";
	strDosageQry	=	" SELECT PH_SPLITDOSE_NEW(?,?,?,?,'NOTES') dosagedtl FROM DUAL ";
	//IN066621 End.
	stmt2	=	con.prepareStatement(strDosageQry);
		
	while(rs!=null && rs.next() && i<=end)
	{
		sbDivided.delete(0,sbDivided.length());
		sbDosageDtl.delete(0,sbDosageDtl.length());

		drug_name		=	rs.getString("CATALOG_DESC")==null?" ":rs.getString("CATALOG_DESC");
		rowid			=	rs.getString("row_id")==null?" ":rs.getString("row_id");
		qty_value		=	rs.getString("QTY_VALUE")==null?" ":rs.getString("QTY_VALUE");
		qty_unit		=	rs.getString("QTY_UNIT")==null?" ":rs.getString("QTY_UNIT");
		freq_desc		=	rs.getString("FREQ_DESC")==null?" ":rs.getString("FREQ_DESC");
		durn_value		=	rs.getString("DURN_VALUE")==null?" ":rs.getString("DURN_VALUE");
		durn_desc		=	rs.getString("DURN_DESC")==null?" ":rs.getString("DURN_DESC");
		start_date		=	rs.getString("START_DATE")==null?" ":rs.getString("START_DATE");
		end_date		=	rs.getString("END_DATE")==null?" ":rs.getString("END_DATE");
		strOrderId		=	rs.getString("ORDER_ID")==null?" ":rs.getString("ORDER_ID");
		strOrdLineNum	=	rs.getString("ORDER_LINE_NUM")==null?" ":rs.getString("ORDER_LINE_NUM");
		strSliding_scale_yn	=	rs.getString("sliding_scale_yn")==null?" ":rs.getString("sliding_scale_yn");
		route_desc      =	rs.getString("route_desc")==null?" ":rs.getString("route_desc");//IN038667
		generic_name	= 	rs.getString("GENERIC_NAME")==null?" ":rs.getString("GENERIC_NAME");//IN060688
		if(!start_date.equals(" " ))
			start_date		= com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale);

		if(!end_date.equals(" " ))
			end_date		= com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);

		stmt1.setString(1,strOrderId);
		stmt1.setString(2,strOrdLineNum);
		
		rs1 = stmt1.executeQuery();

		if( rs1 != null && rs1.next() )
		{
			nMinVal		= rs1.getInt("min_val");
			nMaxVal		= rs1.getInt("max_val");

			if(nMinVal != nMaxVal) 
			{
				strSplitDosageFlag	=	"Y";

				sbDivided.append(" - (Divided Dose) ");
				stmt2.clearParameters();

				stmt2.setString(1,strOrderId);
				stmt2.setString(2,strOrdLineNum);
				stmt2.setString(3,facility_id);  //IN066621
				stmt2.setString(4,locale);  //IN066621
				rs2 = stmt2.executeQuery();

				if(rs2 != null && rs2.next() )
				{
					sbDivided.append(rs2.getString(1));	
				}
			}
			else
			{
				sbDivided.delete(0,sbDivided.length());
				sbDivided.append("");
				strSplitDosageFlag	=	"N";
			}
		}
				
		if( rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.clearParameters();
		
		if( rs2 != null) rs2.close();
		if(stmt2 != null) stmt2.clearParameters();

		if( rs3 != null) rs3.close();
		if(stmt3 != null) stmt3.clearParameters();
		/*if(qty_value.trim().indexOf(".")==0)
		{
			out.println("qty_value "+qty_value.trim().indexOf("."));
			qty_value="0"+qty_value;
		}  */

		if(!strSliding_scale_yn.trim().equals("")) //Modified --[IN029477]
		{
			sbDosageDtl.append(strSliding_scale_yn);
		}
		else
		{
			sbDosageDtl.append(qty_value.trim()); //Modified --[IN029477]
			sbDosageDtl.append(" ");
			if(uom_Dis.equals("D")) //--[IN029477] - start
			{
				strQtyQry1	=	"select am_get_desc.am_uom(?,'en','2') descc from dual";
				stmt4 = con.prepareStatement(strQtyQry1);
				stmt4.clearParameters();

				stmt4.setString(1,qty_unit);

				rs4 = stmt4.executeQuery();

				if(rs4 != null && rs4.next() )
				{
					qty_unit = rs4.getString("descc");
				}
				
				if( rs4 != null) rs4.close();
				if(stmt4 != null) stmt4.clearParameters();
				if(qty_unit!=null && !qty_unit.equals("")) //IN038667
					sbDosageDtl.append(qty_unit);
			}
			else
			{
				if(qty_unit!=null && !qty_unit.equals("")) //IN038667
					sbDosageDtl.append(qty_unit);
			}		//--[IN029477] - end
		}
		//sbDosageDtl.append(" ");
		sbDosageDtl.append(sbDivided.toString());
		sbDosageDtl.append(" - ");
		sbDosageDtl.append(freq_desc);
		sbDosageDtl.append(" for ");
		sbDosageDtl.append(durn_value);
		sbDosageDtl.append(" ");
		sbDosageDtl.append(durn_desc);
		sbDosageDtl.append(" ");//IN038667
		sbDosageDtl.append(route_desc);//IN038667
		sbDosageDtl.append(" ");//IN038667

		//dosage_detail=qty_value+" "+qty_unit+" - "+freq_desc+" for "+durn_value+" "+durn_desc;
		/*if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;*/
	    
		String beankey="";		
		String checkstatus="";		
         
		for(int m=0;m<Bean.getSize();m+=2)
		{
			beankey=Bean.getObject(m).toString();
					
  			if(rowid.equalsIgnoreCase(beankey))
			{
				checkstatus="checked";
                p++; 
				break;
			}					
 		}
				
        if(p == maxRecord || p == 14)
		{
%>
			<script>document.forms[0].ctrlChkBox.checked = true</script> 
<%
		}
%>
		<tr>
			<td class="<%=classValue%>"  width='5%'><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>" <%=checkstatus%> ><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>">
			<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=drug_name%>|<%=generic_name%>|<%=sbDosageDtl.toString()%>|<%=start_date%>|<%=end_date%>'></td>
				
<%
			if(fields.size()>0)
			{
				col_span = fields.size();
				//IN038667 - Start
				col_width= 100/col_span;
				width = col_width+"%";
				//IN038667 - end Included width in all 4 fields
				
				for(int n=0;n<fields.size();++n)
				{
					col_field = (String)fields.get(n);
						
					if(col_field.equals("DRUGNAME"))
					{
%>
						<td class="<%=classValue%>" width='<%=width%>'><%=drug_name%></td>
<%		
					}
					//IN060688 Start.
					else if("GENERICNAME".equals(col_field))
					{
%>
						<td class="<%=classValue%>" width='<%=width%>'><%=generic_name%></td>
<%		
					}
					//IN060688 End.
					else if(col_field.equals("DOSAGEDETAILS"))
					{
						//dosage value changed from (strSliding_scale_yn sbDivided.toString() - freq_desc for durn_value durn_desc route_desc) to sbDosageDtl.toString()
						if(!strSliding_scale_yn.trim().equals("")) //Modified --[IN029477]
						{
%>
							<td class="<%=classValue%>" width='<%=width%>'><%=sbDosageDtl.toString()%></td><!--IN038667 -->
<%
						}
						else
						{
%>
							<td class="<%=classValue%>" width='<%=width%>'><%=sbDosageDtl.toString()%></td><!--IN038667 -->
<%
						}
					}
					else if(col_field.equals("STARTDATE"))
					{
%>
						<td class="<%=classValue%>" width='<%=width%>' ><%=start_date%></td>
<%
					}
					else if(col_field.equals("ENDDATE"))
					{
%>
						<td class="<%=classValue%>" width='<%=width%>' ><%=end_date%></td>
<%
					}
				}
			}
			else
			{
%>
				<td class="<%=classValue%>" width='<%=width%>'><%=drug_name%></td>
				<td class="<%=classValue%>" width='<%=width%>'><%=generic_name%></td><!-- IN060688 -->
<%
				if(!strSliding_scale_yn.equals(""))
				{
%>
					<td class="<%=classValue%>" width='<%=width%>'><%=sbDosageDtl.toString()%></td><!--IN038667 -->
<%
				}
				else
				{
%>
					<td class="<%=classValue%>" width='<%=width%>'><%=sbDosageDtl.toString()%></td><!--IN038667 -->
<%
				}
%>
				<td class="<%=classValue%>" width='<%=width%>' ><%=start_date%></td>
				<td class="<%=classValue%>" width='<%=width%>' ><%=end_date%></td>
<%
			}
%>
				
			</tr>
<%
			i++;
			k++;
		}

		if( rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
			
		if( rs2 != null) rs2.close();
		if(stmt2 != null) stmt2.close();

		if(maxRecord == 0)
		{
%>
			<script>document.forms[0].ctrlChkBox.disabled = true</script> 
<%
		}
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();		 	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in RecClinicalNotesLinkMedResult.jsp" + e);//COMMON-ICN-0181
	}
	finally 
	{
		
		ConnectionManager.returnConnection(con,request);
	}
%>
	<input type="hidden" name="drug_name" id="drug_name" value="<%=drug_name%>">
	<input type="hidden" name="ord_status" id="ord_status" value="<%=ord_status%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="count" id="count" value="<%=k%>">
</table>

</form>
</body>
</script>
</html>

