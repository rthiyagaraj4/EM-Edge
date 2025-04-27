<!DOCTYPE html>
<%
/* 
-----------------------------------------------------------------------
Date       	Edit History      	Name        		Description
-----------------------------------------------------------------------
?             	100            	?           		created
21/02/2012	IN036181	Chowminya G			 reports which has special characters such as an airstrisk or a semicolon
28/04/2014	IN048844	Chowminya			 Issue with result linking a laboratory result  with a decimal point
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory� results in a clinical note section template does not display neatly .	
27/11/2014	  IN052716	Ramesh G	Akbar S		27/11/2014			Result Link In Template Based Section In  Clinical Notes For �Table� And �Text�.
18/01/2017	  IN061882	Karthi L										ML-MMOH-CRF-0534 [IN061882]
23/02/2017	  IN063645	Karthi L										ML-MMOH-CRF-0534 [IN061882]
24/02/2017	  IN063640	Karthi L										ML-MMOH-CRF-0534 [IN061882]
10/05/2017    IN063865      Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
30/08/2017    IN065040		 Raja S		30/08/2017		Ramesh Goli			ML-MMOH-SCF-0787
19/03/2019    IN069927		 Raja S		19/03/2019		Ramesh Goli			ML-MMOH-SCF-1181
----------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="webbeans.eCommon.*,eCommon.Common.*,java.sql.*, java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="PatientCareBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkRep.js'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll="scrollTitle1()">
<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>	

<%
	String  patient_id				= "";
    String  hist_rec_type			= "";
	String  event_date_str			= "";
    String  event_date_str_prev		= "";
    String  event_group_desc		= "";
    String  event_group_desc_prev	= "";
    String  event_time_str			= "";
    String  event_desc				= "";
    String  result_num				= "";
    String  result_num_uom			= "";
    String  normalcy_str			= "";
	String  normalcy				= "";
    String  normal_low_value_str	= "";
    String  normal_high_value_str	= "";
    String  result_str				= "";
    String  hist_data_type			= "";
    String  hist_data_exists		= "";
	String  ret_str					= "";
	String  temp					= "";
	String  flag					= "";
    String return_format			= "";
	//IN069927 Start.
	//String strsql1					= "";
	StringBuffer strsql1 = new StringBuffer(" ");
	//IN069927 End.
	String event_time_str_prev		= ""; // ML-MMOH-CRF-0534
	Clob  hist_data	 = null;
	String  order_by1	 = "";	//IN069927
    String  order_by2	 = "";	//IN069927

	String		sec_hdg_code	=	"";

	ArrayList	fields			=	new ArrayList();
	String		categ_sec_qry	=	"";
	String		field_ref		=	"";
	String		col_field		=	"";
	//String		col_val			=	"";
	String		width			=	"";
	int			col_span		=	0;
	double		col_width		=	0.0;
	String 	disable_spec_type_yn = ""; //ML-MMOH-CRF-0534 [IN061882]
	String  disable_ref_range_yn = ""; //ML-MMOH-CRF-0534 [IN061882]
	String  resultLinkQry	= ""; //ML-MMOH-CRF-0534 [IN061882]
	String  dateTimeAlign   = "N"; //IN063865
	PreparedStatement pstmt=null;
	ResultSet rset=null;


	StringBuffer innerhtml_header = new StringBuffer();
	StringBuffer temp_new = new StringBuffer();
	
	StringBuffer textFormat		=	new StringBuffer("");
	StringBuffer displaydata	=	new StringBuffer();
	StringBuffer htmlData		=	new StringBuffer(); //IN041284
	StringBuffer htmlText		= 	new StringBuffer(); //IN052716
	int k=0;

	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
    flag				=	(request.getParameter("flag")==null)?"":request.getParameter("flag");
	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");	
	sec_hdg_code		=	(request.getParameter("sec_hdg_code")==null)	?	""	:	request.getParameter("sec_hdg_code");	
	//IN069927 Start.
	order_by1			=	(request.getParameter("order_by1")==null)	?	""	:	request.getParameter("order_by1");
	order_by2			=	(request.getParameter("order_by2")==null)	?	""	:	request.getParameter("order_by2");
	//IN069927 End.
	if(!flag.equals("f"));
	    ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"); 
    
	ret_str=ret_str.substring(1,ret_str.length());

	

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	try
	{
		
		con =  ConnectionManager.getConnection(request);
		
		categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,hist_rec_type);
		pstmt.setString(3,hist_rec_type);

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
			pstmt.setString(1,hist_rec_type);
			pstmt.setString(2,hist_rec_type);

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
		//ML-MMOH-CRF-0534 [IN061882] - Start
		resultLinkQry = "select disable_ref_range_yn, disable_spec_type_yn, DIS_REP_DATETIME_YN from ca_note_param";
		pstmt = con.prepareStatement(resultLinkQry);
		rset = pstmt.executeQuery();
		while(rset.next()){
			disable_ref_range_yn = rset.getString("disable_ref_range_yn")==null?"":rset.getString("disable_ref_range_yn");
			disable_spec_type_yn = rset.getString("disable_spec_type_yn")==null?"":rset.getString("disable_spec_type_yn");
			dateTimeAlign		 = rset.getString("DIS_REP_DATETIME_YN")==null?"N":rset.getString("DIS_REP_DATETIME_YN"); //IN063865
		}
		if (rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		//ML-MMOH-CRF-0534 [IN061882] - End
	//IN065040 Changes starts
		if(!ret_str.equals("")){
			String tempStr="";
			String tempStr1="";
			String tempStr2="";

			
		StringTokenizer strtCodes1 = new StringTokenizer(ret_str,",");

		while(strtCodes1.hasMoreTokens())
		{
			if(strtCodes1.hasMoreElements()){
				tempStr= (String) strtCodes1.nextToken();
				if(tempStr1.equals(""))
					tempStr1= "'"+tempStr+"',";
				else
					tempStr1= tempStr1 +"'"+tempStr+"',";
					
			}
			
		}
		tempStr1=tempStr1.substring(0,tempStr1.length()-1);
		//IN069927 Start.
		//String testSql="SELECT A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A WHERE A.PATIENT_ID = ? AND A.HIST_REC_TYPE = ? AND A.ROWID in ("+tempStr1+") ORDER BY A.EVENT_DATE";//commented for IN069927
		StringBuffer testSql = new StringBuffer(" ");
		testSql.append("SELECT A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_GRP_LANG_VW C WHERE C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE	AND C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND C.language_id(+) = ? AND A.PATIENT_ID = ? AND A.HIST_REC_TYPE = ? AND A.ROWID in ("+tempStr1+") ");
		
		if(order_by1.equals("D")){
			if(order_by2.trim().equals("AS")){
					testSql.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
			}else{
				testSql.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
			}
		}else if (order_by1.equals("N")){
			if(order_by2.trim().equals("AS")){
				testSql.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
			}else{
			   testSql.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
			}
		}		
		
		//pstmt = con.prepareStatement(testSql);	
		//pstmt.setString(1,patient_id);
		//pstmt.setString(2,hist_rec_type);
		
		pstmt = con.prepareStatement(testSql.toString());		
		pstmt.setString(1,locale);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,hist_rec_type);		
		//IN069927 End.
		rset = pstmt.executeQuery();
		while(rset.next()){
			if(tempStr2.equals(""))
			tempStr2 = rset.getString("ROW_ID");
			else
			tempStr2 = tempStr2+","+rset.getString("ROW_ID");
		}
		ret_str=tempStr2;
		if (rset != null) rset.close();
		if(pstmt != null) pstmt.close();
	
		}
		//IN065040 Changes Ends
	
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagSelectedText.jsp" + e);//COMMON-ICN-0181
}
/*finally 
{
	
	ConnectionManager.returnConnection(con,request);
}*/



	%>
		<form name="RecClinicalNotesLinkMedSelectedTextForm" id="RecClinicalNotesLinkMedSelectedTextForm">
		<div id='divDataTitle' style='postion:relative'>
	<%
		if(!ret_str.equals(""))
		{
			%>
			<table border="1" id="finalDiv1"  cellpadding="0" cellspacing="0" width="100%">
			<tr>
			<%
				if(fields.size()>0)
				{
					col_span = fields.size();
					col_width= 100/col_span;
					width = col_width+"%";
					

					for(int l=0;l<fields.size();++l)
					{
						col_field = (String)fields.get(l);
						if(col_field.equals("DATEANDTIME"))
						{
						%>
							<td class='columnheader'  width="15%" style="font-size:10"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
						<%
						 innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"</b></td>");
						}
						else if(col_field.equals("EVENT"))
						{
						%>
							<td class='columnheader' width="25%" style="font-size:10" ><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
						<%
						innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Event.label","common_labels")+"</b></td>");
						}
						else if(col_field.equals("VALUE"))
						{
						%>
							<td class='columnheader'  width="60%" style="font-size:10"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
						<%
						innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Value.label","common_labels")+"</b></td>");
						}


					}
				}
				else
				{

			%>	
				<td class='columnheader'  width="15%" style="font-size:10"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width="25%" style="font-size:10"><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
				<td class='columnheader'  width="60%" style="font-size:10"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td> 
				<%
				}
				%>
			</tr>
			</table> 
			<%
		}				
	%>
	</div>
	<div id='inhtml'>
	
	 <table id="finalDiv" border="1" cellpadding="0" cellspacing="0"  width="100%">
	<tr> 
	<%
		htmlData.append("<table id='finalDiv' border='1' cellpadding='0' cellspacing='0'  width='100%'>"); //IN041284
		htmlText.append("<table id='finalDiv' border='0' cellpadding='0' cellspacing='0'  width='100%'>"); //IN052716
		try
		{
			if(!flag.equals("f"))
			{
			if(ret_str!=null || (!ret_str.equals(" ")))
			{
				StringTokenizer strtCodes = new StringTokenizer(ret_str,",");
				
				//con =  ConnectionManager.getConnection(request);
				
				//strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,'ABNORMAL',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =? AND A.ROWID=? ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3 ";				
				//IN069927 Start.
				//strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.short_desc EVENT_GROUP_DESC,C.EVENT_GROUP,B.short_desc EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(a.normalcy_ind,HIGH_STR,'A',LOW_STR,'A',CRIT_STR,'C',ABN_STR,'A',CRIT_HIGH_STR,'C',CRIT_LOW_STR,'C','')FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM 	CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_MST_LANG_VW B ,CR_CLN_EVT_GRP_LANG_VW C WHERE 	B.HIST_REC_TYPE=A.HIST_REC_TYPE AND 	B.EVENT_CODE=A.EVENT_CODE and B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and B.language_id = ?  AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND 	C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE 	AND 	C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND C.language_id(+) = ? and A.PATIENT_ID=? 	AND 	A.HIST_REC_TYPE =? 	AND 	A.ROWID=? 	ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3";
				strsql1.append("SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.short_desc EVENT_GROUP_DESC,C.EVENT_GROUP,B.short_desc EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(a.normalcy_ind,HIGH_STR,'A',LOW_STR,'A',CRIT_STR,'C',ABN_STR,'A',CRIT_HIGH_STR,'C',CRIT_LOW_STR,'C','')FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM 	CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_MST_LANG_VW B ,CR_CLN_EVT_GRP_LANG_VW C WHERE 	B.HIST_REC_TYPE=A.HIST_REC_TYPE AND 	B.EVENT_CODE=A.EVENT_CODE and B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and B.language_id = ?  AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND 	C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE 	AND 	C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND C.language_id(+) = ? and A.PATIENT_ID=? 	AND 	A.HIST_REC_TYPE =? 	AND 	A.ROWID=? ");
				if(order_by1.equals("D")){
					if(order_by2.trim().equals("AS")){
							strsql1.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
					}else{
						strsql1.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
					}
				}else if (order_by1.equals("N")){
					if(order_by2.trim().equals("AS")){
						strsql1.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
					}else{
					   strsql1.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
					}
				}		
				strsql1.append(" ,6,7,8,9,3");
				
				//stmt = con.prepareStatement(strsql1);
				stmt = con.prepareStatement(strsql1.toString());
				// IN069927 End.
				
				String formet	=	"";
				while(strtCodes.hasMoreTokens())
				{
					if(strtCodes.hasMoreElements())
						temp= (String) strtCodes.nextToken();

					stmt.setString(1,locale);
					stmt.setString(2,locale);
					stmt.setString(3,patient_id);
					stmt.setString(4,hist_rec_type);
					stmt.setString(5,temp);

					rs = stmt.executeQuery();
					
					while(rs!=null && rs.next())
					{
						 event_date_str			=		rs.getString("EVENT_DATE_STR")==null?"":rs.getString("EVENT_DATE_STR");
						 event_group_desc		=		rs.getString("EVENT_GROUP_DESC")==null?"":rs.getString("EVENT_GROUP_DESC");
						 event_time_str			=		rs.getString("EVENT_TIME_STR")==null?"":rs.getString("EVENT_TIME_STR");
						 event_desc				=		rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
						 result_num				=		rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
						 result_num_uom			=		rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					     //normalcy_str			=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 normalcy				=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 hist_data_type			=		rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
						 normal_low_value_str	=		rs.getString("normal_low_value_str")==null?"":rs.getString("normal_low_value_str");//IN048844 "0" to ""
						 normal_high_value_str	=		rs.getString("normal_high_value_str")==null?"":rs.getString("normal_high_value_str");//IN048844 "0"to""
						 result_str				=		rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
						 hist_data				=		rs.getClob("HIST_DATA");
						 hist_data_exists		=		rs.getString("HIST_DATA_EXISTS")==null?"":rs.getString("HIST_DATA_EXISTS");
						 //Date conversion is done by Archana Dhal on 10/15/2010 related to incident IN024498.
						 event_date_str	=	com.ehis.util.DateUtils.convertDate(event_date_str,"DMY","en",locale);

						if(normalcy.equals("A"))
							normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");										
						else if(normalcy.equals("C"))
							normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
						else
							normalcy_str = "";
						//IN048844 - Commentted Start
						 //int normal_low_value=(int)Float.parseFloat(normal_low_value_str);
						 //normal_low_value_str=String.valueOf(normal_low_value);
						 //int normal_high_value=(int)Float.parseFloat(normal_high_value_str);
						 //normal_high_value_str=String.valueOf(normal_high_value);
						//IN048844 - Commentted End
						 displaydata.setLength(0);
						
						 if(hist_data!=null)
						 {
							java.io.BufferedReader r = new java.io.BufferedReader(hist_data.getCharacterStream());
							String line = null;
					
							while((line=r.readLine()) != null) 
							{
								displaydata.append(line+"\n");
							}
						 }
			
						 formet = "";

						if(return_format.equals("TEXT"))
							formet="\n";
						else
							formet="<br>";
		
						textFormat.append(formet);
						htmlData.append(formet); //IN041284
						//IN063865 starts
						if("Y".equals(dateTimeAlign))
						event_date_str = event_date_str+ "-" + event_time_str;
						//IN063865 Ends
						
						//out.println("event_date_str    :   "+event_date_str);
						if(!event_date_str_prev.equals(event_date_str))
						{	
							textFormat.append(event_date_str);
							textFormat.append(formet);
							
							%>
								<tr>
			                    <td  class='gridData' colspan="3">
									<font size=2><%=event_date_str%></font>
								</td>								
								</tr>        
							<%
							//IN041284 Start.
							htmlData.append("<tr><td  class='gridData' colspan='3'><font size=2>");
							htmlData.append(event_date_str);
							htmlData.append("</font></td></tr>");
							htmlData.append(formet);
							//IN041284 End.
							//IN052716 Start
							htmlText.append("<tr><td  class='' colspan='3'><font size=2>");
							htmlText.append(event_date_str);
							htmlText.append("</font></td></tr>");
							htmlText.append(formet);
							//IN052716 End.
							event_group_desc_prev="";
						}

						//if(!event_group_desc_prev.equals(event_group_desc))
						if(!event_group_desc_prev.equals(event_group_desc) && !"".equals(event_group_desc))
						{
							if(return_format.equals("TEXT"))
						    {	
								textFormat.append("             "+event_group_desc);
								textFormat.append(formet);
							}
							else
							{	
								textFormat.append("             "+event_group_desc);
								textFormat.append(formet);	
							}
							%>	
				
							<tr>
							<td   class='gridData'>&nbsp;</td>	
							<td   class='gridData'  colspan="2">
								<font size=2><%=event_group_desc%></font>
							</td>							
							</tr>
							<%
							//IN041284 Start.
							htmlData.append("<tr><td   class='gridData'>&nbsp;</td> <td   class='gridData'  colspan='2'><font size=2>");
							htmlData.append(event_group_desc);
							htmlData.append("</font></td></tr>");
							//IN041284 End.
							////IN052716 Start.
							htmlText.append("<tr><td   class=''>&nbsp;</td> <td   class=''  colspan='2'><font size=2>");
							htmlText.append(event_group_desc);
							htmlText.append("</font></td></tr>");
							//IN052716 End.
						}
						%>
						<tr>	
						<% 
							htmlData.append("<tr>"); //IN041284
							htmlText.append("<tr>");  //IN052716
						%>
						<%
						//IN063865 starts
						if(return_format.equals("TEXT")){
							if("Y".equals(dateTimeAlign))
								textFormat.append("                    "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");	
							else
								textFormat.append("   "+event_time_str+"                 "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");	

						}else{
							if("Y".equals(dateTimeAlign))
								textFormat.append("                              "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");
							else
								textFormat.append("   "+event_time_str+"                           "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");
								
						}
						//IN063865 Ends
						%>
						<%
						
						if(fields.size()>0)
						{
							for(int n=0;n<fields.size();++n)
							{
								col_field = (String)fields.get(n);
								

								if(col_field.equals("DATEANDTIME")) {
								//IN063865 starts
								if("N".equals(dateTimeAlign)) { 
								%>
									<td  class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")%>' width="15%" >
									<font size=2><%=event_time_str%></font></td>
								<%
								} else { %>
									<td   class='gridData'>&nbsp;</td>	
									</td>	
									<%
								} // ML-MMOH-CRF-0534 [IN061882] - End
								//IN063865 Ends
								htmlData.append("<td  class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"' width='15%' >"); //IN041284
								if("N".equals(dateTimeAlign)) { 
									htmlData.append("<font size=2>"+event_time_str+"</font></td>"); //IN041284
									htmlText.append("<td  class='' width='15%' >"); //IN052716
									htmlText.append("<font size=2>"+event_time_str+"</font></td>"); //IN052716
									temp_new.append(""+event_time_str+"");
								}	
								//innerhtml.append("<td style='font-size:12'>&nbsp;"+event_time_str+"</td>");
								}
								else if(col_field.equals("EVENT"))
								{
								%>
									<td  class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")%>' width="25%" ><font size=2><%=event_desc%></font></td>
								<%
								htmlData.append("<td  class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"' width='25%' ><font size=2>"+event_desc+"</font></td>"); //IN041284
								htmlText.append("<td  class='' width='25%' ><font size=2>"+event_desc+"</font></td>"); //IN052716
								temp_new.append(","+event_desc);	
								//innerhtml.append("<td style='font-size:12'>&nbsp;"+event_desc+"</td>");
								}
								else if(col_field.equals("VALUE"))
								{
								%>
									<!-- <td class='gridData' width="<%=width%>" ><font size=2> -->
									<%

									if (hist_data_type.equals("NUM") || hist_data_type.equals("TXT") || hist_data_type.equals("STR"))
									{	
										if("N".equals(disable_ref_range_yn)) {
										%>
										<td class='gridData' width="60%" ><font size=2>	<%=result_num%>&nbsp;<%=result_num_uom%>&nbsp;&nbsp;&nbsp;<%=normalcy_str%>
										<%
											htmlData.append("<td class='gridData' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN041284
											htmlText.append("<td class='' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN052716
									
										} else {
											%>
											<td class='gridData' width="60%" ><font size=2>	<%=result_num%>&nbsp;<%=result_num_uom%>
											<%
												htmlData.append("<td class='gridData' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN041284
												htmlText.append("<td class='' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN052716
												
										}
										//if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0")) //IN048844	
										if("N".equals(disable_ref_range_yn)){ //IN063645
											if(!normal_low_value_str.equals("") && !normal_high_value_str.equals("")) //IN048844
											{
												textFormat.append("("+normal_low_value_str+"-"+normal_high_value_str+") ");
												
											 %>
												(<%=normal_low_value_str%>-<%=normal_high_value_str%>)
											<%
												htmlData.append("("+normal_low_value_str+"-"+normal_high_value_str+")");   //IN041284
												htmlText.append("("+normal_low_value_str+"-"+normal_high_value_str+")");  //IN052716
											}
										}
										if (!result_str.equals(""))
										{	
											if("N".equals(disable_spec_type_yn))  { // ML-MMOH-CRF-0534 [IN061882] 
											%>&nbsp;<%=result_str%>&nbsp; 
											<% 
											htmlData.append("&nbsp;"+result_str+"&nbsp;"); //IN041284
											htmlText.append("&nbsp;"+result_str+"&nbsp;");  //IN052716
											textFormat.append("   "+result_str+"  ");
											}// ML-MMOH-CRF-0534 [IN061882]
										}
										
										if(hist_data_exists.equals("Y"))
										{
											   %></font></td></tr><tr><td class='gridData' colspan="3" ><font size=2> <fmt:message key="eCA.Comment.label" bundle="${ca_labels}"/>:<br><br><%=displaydata.toString()%>
											   <%
											   htmlData.append("</font></td></tr><tr><td class='gridData' colspan='3' ><font size=2>"); //IN041284
											   htmlData.append("Comment");	//IN041284
											   htmlData.append(":<br><br>"+displaydata.toString()); //IN041284
											   //IN052716 Start. 
											   htmlText.append("</font></td></tr><tr><td class='' colspan='3' ><font size=2>"); 
											   htmlText.append("Comment");	
											   htmlText.append(":<br><br>"+displaydata.toString()); 
											   //IN052716 End.
										}
									 }
									 else if (hist_data_type.equals("HTM") )
									 {
										 %>
											<td class='gridData' width="60%" >&nbsp;</td><tr><td class='gridData' colspan="3"  ><font size=2><%=result_str%>&nbsp;
										<% 
											htmlData.append("<td class='gridData' width='60%' >&nbsp;</td><tr><td class='gridData' colspan='3'  ><font size=2>"+result_str+"&nbsp;"); //IN041284
											htmlText.append("<td class='' width='60%' >&nbsp;</td><tr><td class='' colspan='3'  ><font size=2>"+result_str+"&nbsp;");//IN052716
											textFormat.append("   "+result_str+"  ");
											
											
											if(hist_data_exists.equals("Y"))
											{
												%></font></td></tr><tr><td class='gridData' colspan="3" ><font size=2> <fmt:message key="eCA.Comment.label" bundle="${ca_labels}"/>:<br><%=displaydata.toString()%>
												<%
												htmlData.append("</font></td></tr><tr><td class='gridData' colspan='3' ><font size=2>");  //IN041284
												htmlData.append("Comment"); //IN041284
												htmlData.append(":<br>"+displaydata.toString()); //IN041284
												//IN052716 Start.
												htmlText.append("</font></td></tr><tr><td class='' colspan='3' ><font size=2>"); 
												htmlText.append("Comment"); 
												htmlText.append(":<br>"+displaydata.toString()); 
												//IN052716 End.
											}
									 }

									 if(hist_data_exists.equals("Y"))
									 {
										if (hist_data_type.equals("TXT"))
												textFormat.append(displaydata.toString()+formet); 	
										else if(hist_data_type.equals("STR"))
											textFormat.append(formet+"Comment:"+displaydata.toString()+formet); 

										
									 }
									
									 %>
								   </font></td></tr>
								<%
								htmlData.append("</font></td></tr>");  //IN041284
								htmlText.append("</font></td></tr>"); //IN052716
								temp_new.append(","+displaydata.toString());	
								//innerhtml.append("<td style='font-size:12'>&nbsp;"+displaydata.toString()+"</td>");
								}
						
							
							}

						}
						else
						{
						
						%>
												
						<td width="15%" class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")%>' >
						<%if("Y".equals(dateTimeAlign)){%> <!--IN063865 added if condition -->
						</td><td width="25%" class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")%>'><font size=2><%=event_desc%></font></td>
						<%}else{%>
						<font size=2><%=event_time_str%></font></td><td width="25%" class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")%>'><font size=2><%=event_desc%></font></td>
				    <%		}
						htmlData.append("<td width='15%' class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"' >");  //IN041284
						if("Y".equals(dateTimeAlign)) // IN063865 added if condition 
						htmlData.append("</td><td width='25%' class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"'><font size=2>"+event_desc+"</font></td>"); //IN041284
						else
						htmlData.append("<font size=2>"+event_time_str+"</font></td><td width='25%' class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"'><font size=2>"+event_desc+"</font></td>"); //IN041284

						htmlText.append("<td width='15%' class='' >");   //IN052716
						if("Y".equals(dateTimeAlign)) //IN063865 added if condition
							htmlText.append(" </td><td width='25%' class=''><font size=2>"+event_desc+"</font></td>"); //IN052716
						else
							htmlText.append("<font size=2>"+event_time_str+"</font></td><td width='25%' class=''><font size=2>"+event_desc+"</font></td>"); 

					if (hist_data_type.equals("NUM") || hist_data_type.equals("STR") || hist_data_type.equals("TXT"))
					{	
						if("N".equals(disable_ref_range_yn)) {
						%>
						<td  width="60%" class='gridData'><font size=2>	<%=result_num%>&nbsp;<%=result_num_uom%>&nbsp;&nbsp;&nbsp;<%=normalcy_str%>
						<%
							htmlData.append("<td  width='60%' class='gridData'><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN041284
							htmlText.append("<td  width='60%' class=''><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN052716
						} else {
							%>
							<td  width="60%" class='gridData'><font size=2>	<%=result_num%>&nbsp;<%=result_num_uom%>
							<%
							htmlData.append("<td  width='60%' class='gridData'><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN041284
							htmlText.append("<td  width='60%' class=''><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN052716
						}
						//if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0"))//IN048844
					    if("N".equals(disable_ref_range_yn)) {
							if(!normal_low_value_str.equals("") && !normal_high_value_str.equals("")) //IN048844
							{	
								textFormat.append("("+normal_low_value_str+"-"+normal_high_value_str+") ");
							 %>
								(<%=normal_low_value_str%>-<%=normal_high_value_str%>)
							 <%
							 htmlData.append("("+normal_low_value_str+"-"+normal_high_value_str+")"); //IN041284
							 htmlText.append("("+normal_low_value_str+"-"+normal_high_value_str+")"); //IN052716
							}
					    }	
						if (!result_str.equals("") && "N".equals(disable_spec_type_yn )) //IN063865
						{
							%>&nbsp;<%=result_str%>&nbsp; 
							<% 
								textFormat.append("   "+result_str+"  ");
							htmlData.append("&nbsp;"+result_str+"&nbsp;"); //IN041284
							htmlText.append("&nbsp;"+result_str+"&nbsp;"); //IN052716
						}
						
						if(hist_data_exists.equals("Y"))
						{
						  %></font></td></tr><tr><td colspan="3"  class='gridData'><font size=2> <fmt:message key="eCA.Comment.label" bundle="${ca_labels}"/>:<%=displaydata.toString()%>
						  </td></tr>
						  <%
						  htmlData.append("</font></td></tr><tr><td colspan='3'  class='gridData'><font size=2>"); //IN041284
						  htmlData.append("Comment"); //IN041284
						  htmlData.append(":"+displaydata.toString()+"</td></tr>"); //IN041284
						  //IN052716 Start.
						  htmlText.append("</font></td></tr><tr><td colspan='3'  class=''><font size=2>"); 
						  htmlText.append("Comment"); 
						  htmlText.append(":"+displaydata.toString()+"</td></tr>"); 
						  //IN052716 End.
						}
						   
					 }
					 else if (hist_data_type.equals("HTM") )
					 {
						 %>
							</font></td><td width="60%" class='gridData'></td></tr><tr><td colspan="3"  class='gridData'><font size=2>
							&nbsp;<%=result_str%>&nbsp;
						<% 
							htmlData.append("</font></td><td width='60%' class='gridData'></td></tr><tr><td colspan='3'  class='gridData'><font size=2>&nbsp;"+result_str+"&nbsp;"); //IN041284
							htmlText.append("</font></td><td width='60%' class=''></td></tr><tr><td colspan='3'  class='gridData'><font size=2>&nbsp;"+result_str+"&nbsp;"); //IN052716
							textFormat.append("   "+result_str+" ");
													
							if(hist_data_exists.equals("Y"))
							{
								%></font></td></tr><tr><td colspan="3"  class='gridData'><font size=2><fmt:message key="eCA.Comment.label" bundle="${ca_labels}"/>:<%=displaydata.toString()%>
								</td></tr>
								<%
								htmlData.append("</font></td></tr><tr><td colspan='3'  class='gridData'><font size=2>"); //IN041284
								htmlData.append("Comment"); //IN041284
								htmlData.append(":"+displaydata.toString()+"</td></tr>"); //IN041284
								//IN052716 Start.
								htmlText.append("</font></td></tr><tr><td colspan='3'  class=''><font size=2>"); 
								htmlText.append("Comment"); 
								htmlText.append(":"+displaydata.toString()+"</td></tr>"); 
								//IN052716 End.
							}
							
					 }
					//	out.println("hist_data_exists    :   "+hist_data_exists+"     textFormat   :   "+textFormat);
					 if(hist_data_exists.equals("Y"))
					 {
						if (hist_data_type.equals("TXT"))
							textFormat.append(displaydata.toString()+formet); 	
						else if(hist_data_type.equals("STR"))
						    textFormat.append(formet+"Comment:"+displaydata.toString()+formet); 

						
					 }
					
					 %>
				   </font></td></tr>
				   <%
					htmlData.append("</font></td></tr>"); //IN041284
					htmlText.append("</font></td></tr>");  //IN052716
					}
				   %>
				 <!--   </tr> -->
						
					 <%
					 k++;
					 if("Y".equals(dateTimeAlign)) //<!--IN063865 added if condition -->
					 event_date_str_prev = event_date_str;
					 else
					 event_date_str_prev = event_date_str;
					 event_group_desc_prev=event_group_desc;
					 event_time_str_prev=event_time_str; //ML-MMOH-CRF-0534
				}

				if(rs!=null) rs.close();	
		}
			
	}
}

if(stmt!=null)stmt.close();		 	

}
	
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkHistRepSelectedText.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
htmlData.append("</table>"); //IN041284
htmlText.append("</table>"); //IN052716
%>		 

</table>
</div>
<input type="hidden" name="temp" id="temp" value="">
<input type="hidden" name="count" id="count" value="">
<%
String cat="";
String catHtml="";
String catText = ""; //IN052716
if(!return_format.equals("TEXT"))
{
	cat = "<font size=2>"+textFormat.toString()+"</font>";

}
else
{
	cat = textFormat.toString();
}
cat = java.net.URLEncoder.encode(cat,"UTF-8"); //IN036181
catHtml=htmlData.toString(); //IN041284
catHtml = catHtml.replaceAll("<BR>","");
catHtml = catHtml.replaceAll("<br>","");
catHtml = java.net.URLEncoder.encode(catHtml,"UTF-8"); //IN041284
//IN052716 Start
catText=htmlText.toString(); 
catText = catText.replaceAll("<BR>","");
catText = catText.replaceAll("<br>","");
catText = java.net.URLEncoder.encode(catText,"UTF-8"); 
//IN052716 End.
%>
<input type="hidden" name="temptext" id="temptext" value="<%=cat.trim()%>"> 
<input type="hidden" name="tempHtml" id="tempHtml" value="<%=catHtml.trim()%>">  <!-- IN041284 -->
<input type="hidden" name="tempHtmlText" id="tempHtmlText" value="<%=catText.trim()%>">  <!-- IN052716 -->
</form>
</body>

