<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
16/11/2011    IN029542      Chowminya G      	Incident No: IN029542 -  <Dosage details in link notes option - incorrect> 
18/06/2012    IN032774      Chowminya G      	Incident No: IN032774 -  <Med Certificate show ICD-10 in English even use thai menu.> 
18/09/2012	  IN033558		Nijithas  S			Link Doc in Record Clinical Note Displays Error.
11/02/2013	  IN037164		Chowminya G			No Prompt for password for sensitive diagnosis in result link section in clinical notes
05/04/2013	  IN039182		Chowminya G			Restrict all users from result linking all diagnosis which are sensitive only  in the clinical notes
-----------------------------------------------------------------------
Date		Edit History	Name				Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/05/2017	IN061907		Krishna Gowtham		02/05/2017	Ramesh G		ML-MMOH-CRF-0559
21/08/2018	IN067855		Ramya Maddena  		11/10/2018	Ramesh G 		ML-MMOH-CRF-1202
30/01/2019	IN069327		Prakash C  		    30/01/2019	Ramesh G 		ML-MMOH-CRF-1281.1
15/04/2023	   38981        Krishna Pranay   16/04/2023     Ramesh G     ML-MMOH-CRF-1986
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	   %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- added by Kishore Kumar N on 10/12/2008  -->
		
		<!-- end here -->
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkDiag.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
</head> 
<%
    //String sel="";
	String diagtypestr="";
    String onsetdate="";
    String diagdesc="";
	String diagdesc1="";//IN067855
    String diagstage=" ";
	String diagstage1="";
    String diagcodestr="";
    String curr_remarks="";//38981
    String support_exisist_yn_yn="";//38981
    String occur_srl_no="";//38981
	String diagtypestr1 = "";
    String diagcodescheme="";
	String from_date_time_en	=	"";
	String to_date_time_en		=	"";
	String sensitive_yn ="";//IN037164
	StringBuffer strsql1 = new StringBuffer(" ");
	StringBuffer sqlwhere = new StringBuffer(" ");
	StringBuffer sqlwhere1 = new StringBuffer(" ");
	StringBuffer countsql = new StringBuffer(" ");
	StringBuffer SqlFindSensitive = new StringBuffer(" ");//IN037164
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	
	String locale = (String) p1.getProperty("LOCALE");

	String from_date_time	=	java.net.URLDecoder.decode(request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time"));
	String to_date_time		=	java.net.URLDecoder.decode(request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time"));
    String prob_status		=	java.net.URLDecoder.decode(request.getParameter("radio")==null?"":request.getParameter("radio"));
	String diagcode			=	java.net.URLDecoder.decode(request.getParameter("diagcode")==null?"":request.getParameter("diagcode"));
	String diagtype			=	java.net.URLDecoder.decode(request.getParameter("diagtype")==null?"":request.getParameter("diagtype"));
	
	String orderby1			=	java.net.URLDecoder.decode(request.getParameter("orderby1")==null?"":request.getParameter("orderby1"));
	String orderby2			=	java.net.URLDecoder.decode(request.getParameter("orderby2")==null?"":request.getParameter("orderby2"));
	String encstatus		=	java.net.URLDecoder.decode(request.getParameter("encstatus")==null?"":request.getParameter("encstatus"));
	String includestatus	=	java.net.URLDecoder.decode(request.getParameter("includestatus")==null?"":request.getParameter("includestatus"));//38981
	String patient_id		=	java.net.URLDecoder.decode(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
    String encounter_id		=	java.net.URLDecoder.decode(request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id")); 
	//String whereclause		=	java.net.URLDecoder.decode(request.getParameter("whereclause")==null?"":request.getParameter("whereclause"));
	//String whereclause1		=	java.net.URLDecoder.decode(request.getParameter("whereclause1")==null?"":request.getParameter("whereclause1"));

	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

	from_date_time_en		=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMY",locale,"en");
	to_date_time_en			=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMY",locale,"en");

	String from 		= request.getParameter("from");
	String to 			= request.getParameter("to");
	String term_set_id  = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String authorize  = request.getParameter("authorize")==null?"N":request.getParameter("authorize");//IN037164
	String rowid="";
	
	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String rslt_lnk_qry ="";//IN039182
	String rslt_lnk_sensidiag_yn ="";//IN039182
	String field_ref ="";
	String col_field ="";
	//String col_val ="";
	String call_from_link_doc_btn = request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");//IN061907
	int col_span=0;
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	PreparedStatement pstmt1=null;
	ResultSet rset1=null;
	
	//IN037164 - Start
	String sensitive_exist_yn="N";
	SqlFindSensitive.append("Select 'Y' from PR_DIAGNOSIS A,MR_TERM_CODE D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N') ='Y' ");
	if(encstatus.equals("Y") )
	{
		SqlFindSensitive.append(" and a.CURR_ENCOUNTER_ID = ? ");
	}
	SqlFindSensitive.append(" AND ROWNUM=1");
	boolean isSiteSpecific=false;//IN069327
	try
	{
	
	//IN039182 - Start
	try
	{
		con =  ConnectionManager.getConnection(request);
		isSiteSpecific = CommonBean.isSiteSpecific(con, "MR","ALLOW_MULTI_DESC"); //IN069327
		pstmt = con.prepareStatement(SqlFindSensitive.toString());
		pstmt.setString(1,patient_id);
		if(encstatus.equals("Y") )
		{
			pstmt.setString(2,encounter_id);
		}
		
		rs = pstmt.executeQuery();
		while(rs.next())
			sensitive_exist_yn = rs.getString(1) == null ? "N" : rs.getString(1);
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//IN037164 - End
	
		rslt_lnk_qry ="select LINK_SENST_DIAG_YN from ca_note_param ";

		pstmt1 = con.prepareStatement(rslt_lnk_qry);

		rset1 = pstmt1.executeQuery();

		while(rset1.next())
		{
			rslt_lnk_sensidiag_yn =rset1.getString("LINK_SENST_DIAG_YN")==null?"":rset1.getString("LINK_SENST_DIAG_YN");
		}
		if (rset1 != null) rset1.close();
		if (pstmt1 != null) pstmt1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in RecClinicalNotesLinkDiagResult.jsp,top" + e);//COMMON-ICN-0181
	}
	finally 
	{
		
		//ConnectionManager.returnConnection(con,request); //checkstyle
	}
		
	//IN039182 - End
	
	countsql.append("SELECT COUNT(*) as total FROM pr_diagnosis a, MR_TERM_CODE b, MR_TERM_SET c where a.TERM_SET_ID=b.TERM_SET_ID AND A.TERM_CODE =B.TERM_CODE and c.term_set_id=b.term_set_id ");
	
	//Modified --[IN032774]
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, a.TERM_CODE_SHORT_DESC diag_desc ,'N' sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc ,'N' sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc , sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");//Modified IN037164
	//strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc , a.term_code_short_desc diag_desc1 ,sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");//IN067855
    strsql1.append("select DISTINCT a.rowid row_id, a.OCCUR_SRL_NO srl_no,a.CURR_STATUS problem_status,c.TERM_SET_DESC scheme,a.TERM_SET_ID diag_code_scheme,a.TERM_CODE diag_code, mr_get_desc.mr_term_code (a.term_set_id,a.term_code,?,'2') diag_desc , a.term_code_short_desc diag_desc1 ,sensitive_yn,mr_get_desc.MR_ACCURACY(a.CURR_ACCURACY_CODE,?,'2')  DIAG_TYPE,'N' PRIMARY_YN, to_char(a.ONSET_DATE,'dd/mm/yyyy') onset_date1, decode(a.CURR_STATUS,'A',null,to_char(a.CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,NVL ((SELECT 'Y' FROM pr_support_diagnosis d WHERE a.patient_id = d.patient_id AND a.term_set_id = d.term_set_id AND a.term_code = d.term_code AND a.occur_srl_no = d.occur_srl_no AND ROWNUM = 1), 'N' ) support_exisist_yn_yn,nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID ");//	38981
    
    if(encstatus.equals("Y") )
	{
		strsql1.append(" and encounter_id = a.CURR_ENCOUNTER_ID ");
	}else{
		strsql1.append(" and encounter_id = a.ONSET_ENCOUNTER_ID ");
	}
	
    
    
	//strsql1.append(" and rownum=1),'') diag_stage from pr_diagnosis a, MR_TERM_CODE b, MR_TERM_SET c where a.TERM_SET_ID=b.TERM_SET_ID AND A.TERM_CODE =B.TERM_CODE and c.term_set_id=b.term_set_id ");//In query '' is passed instead of passing as 'D' changed by Archana Dhal related to incident IN024424 on 10/14/2010.
	strsql1.append(" and rownum=1),'') diag_stage,a.curr_remarks ##SUPPORT_DIAG_DESC## from pr_diagnosis a, MR_TERM_CODE b, MR_TERM_SET c where a.TERM_SET_ID=b.TERM_SET_ID AND A.TERM_CODE =B.TERM_CODE and c.term_set_id=b.term_set_id ");//In query '' is passed instead of passing as 'D' changed by Archana Dhal related to incident IN024424 on 10/14/2010.//38981
	
	   	   
	   if(!term_set_id.equals(""))
		{
		   sqlwhere.append(" AND A.TERM_SET_ID = ? ");  
	       //sqlwhere1.append(" c.TERM_SET_ID = ? and  ");  
       }

       sqlwhere.append(" AND A.patient_id=? AND A.CURR_STATUS != 'E'");  //patient_id=?");
       //sqlwhere1.append(" patient_id=? and nvl(error_yn,'N') != 'Y'");
 
	  if (prob_status.equalsIgnoreCase("A"))
		{
		  // if(!diagtype.equals(""))
		  sqlwhere.append(" and CURR_STATUS = 'A'");
	      //sqlwhere1.append(" and problem_status != 'C'");

	    }
	  if(!diagtype.equals(""))
		{
		   sqlwhere.append(" and a.ONSET_ACCURACY_CODE = ?");
	      // sqlwhere1.append(" and DIAG_TYPE = ?");
          //sqlwhere.append(" and NVL(error_yn,'N') !='Y'");
	    }
	 

	  if((!encounter_id.equals("")) && encstatus.equals("Y") )
		{
		  sqlwhere.append(" and curr_encounter_id = ?"); //--[IN029542]
	     // sqlwhere1.append(" and onset_encounter_id = ?");
	    }
	  
        
       if(!diagcode.equals(""))
		{
		   sqlwhere.append(" AND a.TERM_CODE = nvl(?,a.TERM_CODE)");
	      // sqlwhere1.append(" AND DIAG_CODE = nvl(?,diag_code)");
	   }
	   

       if(!(from_date_time.equals("") && to_date_time.equals("")))
		{
		   sqlwhere.append(" AND ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999");
	       //sqlwhere1.append(" AND ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')");
	    }
		
		//IN037164 - Start
		sqlwhere.append(" and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N'))");
		//IN037164 - end	
		
		countsql.append(sqlwhere);	

	   if (orderby1.equals("O"))
	   {
			if(orderby2.equals("1"))
			{
					sqlwhere.append(" order by to_date(onset_date1,'dd/mm/yyyy') desc");
			}
			else
			{
					sqlwhere.append(" order by to_date(onset_date1,'dd/mm/yyyy')");
			}
	   }
	   else if (orderby1.equals("D"))
	   {
		   if(orderby2.equals("1"))
			   sqlwhere.append(" order by diag_desc desc");
		   else
			   sqlwhere.append(" order by diag_desc");
		}
	   else
		{
		   sqlwhere.append(" order by onset_date1, diag_desc");
		}
		strsql1.append(sqlwhere);	 
		
	

	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
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
      //con =  ConnectionManager.getConnection(request);  //checkstyle
	 
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
				if(stmt != null) stmt.close();

			}
		

		}

			  
		  
	  
	  
	  //shaiju new diag ends
	  
	  stmt = con.prepareStatement(countsql.toString());
	  
	   
	    int st=0;

		//stmt.setString(++st,"ICD10");
	  if(!term_set_id.equals("")) 
      {
		 stmt.setString(++st,term_set_id);
	  }
		
		stmt.setString(++st,patient_id);
          
       if(!diagtype.equals("")) 
      {
	   stmt.setString(++st,diagtype);
	   //out.println("<script>alert('diagtype"+diagtype+"')</script>");
	  }

        if((!encounter_id.equals("")) && encstatus.equals("Y") )
		{
		stmt.setString(++st,encounter_id);
   	    //out.println("<script>alert('encounter_id"+encounter_id+"')</script>");
		}

        if(!diagcode.equals(""))
        {stmt.setString(++st,diagcode);
		//out.println("<script>alert('diagcode"+diagcode+"')</script>");
		}

        if(!(from_date_time_en.equals("") && to_date_time_en.equals(""))) 
		{
			stmt.setString(++st,from_date_time_en);
            stmt.setString(++st,to_date_time_en);
	//out.println("<script>alert('from_date_time"+from_date_time+"')</script>");
	//out.println("<script>alert('to_date_time"+to_date_time+"')</script>");
		}
		//IN037164 - Start
		if(authorize.equals("N"))
			stmt.setString(++st,"N");
		else
			stmt.setString(++st,"Y");
		//IN037164 - End
		
	   rs = stmt.executeQuery();
	
		//out.println("here 1");

	   if(rs!=null && rs.next())
		{
			maxRecord=rs.getInt("total");
		}
   //  out.println("<script>alert('maxRecord"+maxRecord+"')</script>");
	  if(rs!=null) rs.close();
	  if(stmt!=null)stmt.close();

		//out.println("<script>alert('maxRecord"+maxRecord+"')</script>");
	  if (maxRecord== 0 && sensitive_exist_yn.equals("N") && rslt_lnk_sensidiag_yn.equals("Y"))// IN037164 //modified IN039182
		{
		%>
	  	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		
		</script>
		<%
			//IN061907 start
			if(call_from_link_doc_btn.equals("YES"))
			{
		%>
			<script>
				parent.window.close();
			</script>
		<%
			}
			//IN061907 ends
		}
		else if(maxRecord== 0 && rslt_lnk_sensidiag_yn.equals("N")) //IN039182
		{
		%>
	  	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		
		</script>
	  <%}
		
    
		st=0;
		  //38981 start
	String  finalQuery = strsql1.toString();
	
    if(includestatus.equals("Y") )
   	{
    	finalQuery= finalQuery.replaceAll("##SUPPORT_DIAG_DESC##", " , CA_SUPPORT_DIAG_DESC(A.patient_id,a.TERM_SET_ID,a.TERM_CODE,a.OCCUR_SRL_NO) supportDiagDesc ");
    	
   	}else{
   		finalQuery= finalQuery.replaceAll("##SUPPORT_DIAG_DESC##", " , '' supportDiagDesc ");
   	}
 
		stmt = con.prepareStatement(finalQuery);
		//38981 start
		stmt.setString(++st,locale); //--[IN032774]
		stmt.setString(++st,locale);
	
		if(!term_set_id.equals(""))
		{
			stmt.setString(++st,term_set_id);
		}
		stmt.setString(++st,patient_id);
          
        if(!diagtype.equals("")) 
		stmt.setString(++st,diagtype);

        if((!encounter_id.equals("")) && encstatus.equals("Y") )
		stmt.setString(++st,encounter_id);

        if(!diagcode.equals(""))
        stmt.setString(++st,diagcode);

        if(!(from_date_time_en.equals("") && to_date_time_en.equals(""))) 
		{
			stmt.setString(++st,from_date_time_en);
            stmt.setString(++st,to_date_time_en);
		}	
		//IN037164 - Start
		if(authorize.equals("N"))
			stmt.setString(++st,"N");
		else
			stmt.setString(++st,"Y");
		//IN037164 - End	
	
		rs = stmt.executeQuery();
		//out.println("here 2");
		%>




<body onScroll="scrollTitle()" onKeyDown="lockKey()"> 
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



<form name="RecClinicalNotesLinkDiagResultForm" id="RecClinicalNotesLinkDiagResultForm">	
<div id='authorizeMode' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<div id='divDataTitle' style='postion:relative'>
<table  id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr >
<%
	
if ( !(start <= 1) )
		{
	out.println("<td width='75%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td class='CAGROUP'  width='10%' >");
	out.println("<A class= 'gridLink' HREF='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp?from="+(start-14)+"&to="+(end-14)+"&patient_id="+patient_id+"&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&term_set_id="+term_set_id+"&diagtype="+diagtype+"&encounter_id="+encounter_id+"&diagcode="+diagcode+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&encstatus="+encstatus+"&authorize="+authorize+"&orderby1="+orderby1+"&orderby2="+orderby2+"&whereclause="+URLEncoder.encode(sqlwhere.toString())+"&whereclause1="+URLEncoder.encode(sqlwhere1.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
     else
		{
out.println("<td width='75%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td  class='CAGROUP' width='10%' >");
		}
//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A  class= 'gridLink' HREF='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp?from="+(start+14)+"&to="+(end+14)+"&patient_id="+patient_id+"&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&term_set_id="+term_set_id+"&diagtype="+diagtype+"&encounter_id="+encounter_id+"&diagcode="+diagcode+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&encstatus="+encstatus+"&authorize="+authorize+"&orderby1="+orderby1+"&orderby2="+orderby2+"&whereclause="+URLEncoder.encode(sqlwhere.toString())+"&whereclause1="+URLEncoder.encode(sqlwhere1.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	%>	
</td>
</tr>
</table>
</div>

<table width="100%" class='grid' name="resultTable" id="resultTable" id="resultTable">
<% //IN037164 - Start
	if (sensitive_exist_yn.equals("Y") && rslt_lnk_sensidiag_yn.equals("Y") ) //IN039182
	{%>
		&nbsp;<center>
		<a class='gridLink' href="javascript:CallAuathorize('<%=patient_id%>','V','N','<%=term_set_id%>','<%=diagtype%>','<%=encounter_id%>','<%=diagcode%>','<%=from_date_time_en%>','<%=to_date_time%>','<%=encstatus%>','<%=prob_status%>','<%=result_linked_rec_type%>','<%=sec_hdg_code%>','<%=orderby1%>','<%=orderby2%>')" onMouseOver="showToolTip(this,'Y')" onMouseOut="javascript:hideToolTip()" ><font size='2' color='red'> [<fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/>] </a></font></center>	
		
	<%	
	}//IN037164 - End
	%>
<tr>
<td class='columnheadercenter' width="8%" style="font-size:10"><fmt:message key="Common.all.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></td>
	<%
	if(fields.size()>0)
	{
		col_span = fields.size();
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 
			 if(col_field.equals("ACCURACY"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("ONSET DATE"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("DESCRIPTION"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("STAGE"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("CODE"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("SCHEME"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></td>
					<%
					}//38981 end
					
		   }
		//   38981 start
		 if(includestatus !=null && includestatus.equals("Y")){ %>
 		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.SupportingDiag.label" bundle="${ca_labels}"/></td><!-- 38981 -->
 		<%} 		//   38981 end
		}
	else
	{
	%>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></td><!-- 38981 -->
		
		
	<%
	}
	%>
		</tr>
	 
	<% 
		String onset_date1_th	="";
	if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}

		String classValue="";
		//String classValue="gridData";//IN037164
		int p=0; 
	
	 while(rs!=null && rs.next() && i<=end)
		{
		 		 
		 diagtypestr=rs.getString("DIAG_TYPE")==null?" ":rs.getString("DIAG_TYPE");
		 diagtypestr1=rs.getString("DIAG_TYPE")==null?" ":rs.getString("DIAG_TYPE");
		 String supportDiagDesc=rs.getString("supportDiagDesc")==null?" ":rs.getString("supportDiagDesc");//38981
		 rowid=rs.getString("row_id");
		 rowid = rowid.replace('+','$');
		 onsetdate		=	rs.getString("onset_date1")==null?" ":rs.getString("onset_date1");
		 onset_date1_th	=	com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);
		 diagdesc=rs.getString("diag_desc")==null?" ":rs.getString("diag_desc");
		 diagdesc1=rs.getString("diag_desc1")==null?" ":rs.getString("diag_desc1");//IN067855
		 //diagstage=rs.getString("diag_stage")==null?" ":rs.getString("diag_stage");
		 diagstage1=rs.getString("diag_stage")==null?" ":rs.getString("diag_stage");
		 diagcodestr=rs.getString("diag_code")==null?" ":rs.getString("diag_code");
		 diagcodescheme=rs.getString("scheme")==null?" ":rs.getString("scheme");
		 occur_srl_no =rs.getString("srl_no")==null?" ":rs.getString("srl_no");// 38981 
		 curr_remarks=rs.getString("curr_remarks")==null?" ":rs.getString("curr_remarks");// 38981 
		 support_exisist_yn_yn = rs.getString("support_exisist_yn_yn")==null?"":rs.getString("support_exisist_yn_yn"); //38981
		 if(curr_remarks.length()>200){
			 curr_remarks=curr_remarks.substring(0,200)+"...";
		 }
		 diagstage = rs.getString("diag_stage");
		 sensitive_yn = rs.getString("sensitive_yn");//IN037164
		 //IN037164 - Start
		if(sensitive_yn.equals("Y"))
				classValue="gridRed";
			else
				classValue="gridData";
		//IN037164 - end
		 if(diagstage == null || diagstage.equals("null") || diagstage.equals(""))diagstage="&nbsp";
		 
		 
		 if(diagtypestr1.equals("P"))
			diagtypestr= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
		 else if(diagtypestr1.equals("D"))
			diagtypestr= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
		 else if(diagtypestr1.equals("F"))
			diagtypestr= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
		 
		 if(diagstage1.equals("A"))
			diagstage= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
		 else if(diagstage1.equals("I"))
			diagstage= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
		 else if(diagstage1.equals("D"))
			diagstage= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");	 
		 
		 /*if ( i % 2 == 0 )
			 classValue = "QRYEVEN" ;
		 else
		  	classValue = "QRYODD" ;*/
	  
		
	    
		String beankey="";		
		String checkstatus="";		
         

		for(int m=0;m<Beannew.getSize();m+=2)
				{
					beankey=Beannew.getObject(m).toString();

  					if(rowid.equalsIgnoreCase(beankey))
					//if((java.net.URLDecoder.decode(rowid)).equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					beankey="";
                   

				}
				 
				 //out.println("<script>alert('p"+p+"')</script>");
                  if(p == maxRecord || p== 14)
					{
					%>
					<script>document.forms[0].ctrlChkBox.checked = true</script> 
					<%}%>
					
				<tr>
				<td class="<%=classValue%>" align="center"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>" <%=checkstatus%> ><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>">
				<!-- Instead if encoding and sending 'diagdesc' is passed directly modified by Archana Dhal on 10/14/2010 related to incident no IN024424. -->
				<!-- <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=diagtypestr%>|<%=onsetdate%>|<%=java.net.URLEncoder.encode(diagdesc)%>|<%=diagstage%>|<%=diagcodestr%>|<%=diagcodescheme%>'> -->
				<!--  <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=diagtypestr%>|<%=onsetdate%>|<%=diagdesc%>|<%=diagstage%>|<%=diagcodestr%>|<%=diagcodescheme%>'></td>-->
				<!--<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid)%>~<%=java.net.URLEncoder.encode(diagtypestr)%>|<%=java.net.URLEncoder.encode(onsetdate)%>|<%=java.net.URLEncoder.encode(diagdesc)%>|<%=java.net.URLEncoder.encode(diagstage)%>|<%=java.net.URLEncoder.encode(diagcodestr)%>|<%=java.net.URLEncoder.encode(diagcodescheme)%>'></td>--><!-- IN33558 -->
				<!--IN067855 Start..-->
			<%if(!isSiteSpecific){%><!--IN069327-->
				<%if("*OTH".equals(diagcodestr)){%>
               <%-- <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc1,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>'></td>--%>            
               <%--  <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc1,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>|<%=java.net.URLEncoder.encode(curr_remarks,"UTF-8")%>'></td>--%><!--38981-->
                      <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc1,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>|<%=java.net.URLEncoder.encode(curr_remarks,"UTF-8")%>|<%=java.net.URLEncoder.encode(support_exisist_yn_yn,"UTF-8")%>|<%=java.net.URLEncoder.encode(supportDiagDesc,"UTF-8")%>'></td><!--38981--> 
				<%}else{%>
               <%-- <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>'></td><!--IN067855--> 		 --%>
               <%-- <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>|<%=java.net.URLEncoder.encode(curr_remarks,"UTF-8")%>'></td>--%><!--38981-->
			       	<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>|<%=java.net.URLEncoder.encode(curr_remarks,"UTF-8")%>|<%=java.net.URLEncoder.encode(support_exisist_yn_yn,"UTF-8")%>|<%=java.net.URLEncoder.encode(supportDiagDesc,"UTF-8")%>'></td><!--38981--> 	
				<%}
			}else{%>
                <%-- <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc1,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>'></td><!--IN069327-->			 --%>				
                <%-- <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc1,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>|<%=java.net.URLEncoder.encode(curr_remarks,"UTF-8")%>'></td>--%><!--38981-->
                     <input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(rowid,"UTF-8")%>~<%=java.net.URLEncoder.encode(diagtypestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetdate,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagdesc1,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagstage,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodestr,"UTF-8")%>|<%=java.net.URLEncoder.encode(diagcodescheme,"UTF-8")%>|<%=java.net.URLEncoder.encode(curr_remarks,"UTF-8")%>|<%=java.net.URLEncoder.encode(support_exisist_yn_yn,"UTF-8")%>|<%=java.net.URLEncoder.encode(supportDiagDesc,"UTF-8")%>'></td><!--38981-->			                  
 
 <%}	
				if(fields.size()>0)
				{
					col_span = fields.size();
					
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);
						
						if(col_field.equals("ACCURACY"))
						{
						%>
						<td class="<%=classValue%>"><%=diagtypestr1%></td>

						<%
						}
						else if(col_field.equals("ONSET DATE"))
						{
						%>
							<td class="<%=classValue%>"><%=onset_date1_th%></td>
						<%
						}
						//IN067855 starts
						else if(col_field.equals("DESCRIPTION"))
						{	
							if(!isSiteSpecific){//IN069327
								 if("*OTH".equals(diagcodestr)){%>
						           <td class="<%=classValue%>"><%=diagdesc1%></td>
					       		<%}else{%>
						           <td class="<%=classValue%>"><%=diagdesc%></td>
				          		<%}
							}else{%><!--IN069327-->
									<td class="<%=classValue%>"><%=diagdesc1%></td><!--IN069327-->
							<%}
				
						}
						//IN067855  ends
						else if(col_field.equals("STAGE"))
						{
						%>
							<td class="<%=classValue%>"><%=diagstage%></td>
						<%
						}
						else if(col_field.equals("CODE"))
						{
						%>
							<td class="<%=classValue%>"><%=diagcodestr%></td>
						<%
						}
						else if(col_field.equals("SCHEME"))
						{
						%>
							<td class="<%=classValue%>"><%=diagcodescheme%></td>
						<%
						}
						else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
						{
						%>
							<td class="<%=classValue%>"><%=curr_remarks%></td>
						<%
						}//38981 end
                  }
					//38981 start
					if(includestatus !=null && includestatus.equals("Y")){
						if(support_exisist_yn_yn.equals("Y")){
						%>
						<td class="<%=classValue%>"><%=supportDiagDesc%></td>	
						<%
						}else{
						%>
						<td class="<%=classValue%>">&nbsp;</td>	
						<%	
						}
					
			    	}
				//38981 end
				}
				else
				{
				%>
				<td class="<%=classValue%>"><%=diagtypestr1%></td>
				<td class="<%=classValue%>"><%=onset_date1_th%></td>
				<%if(!isSiteSpecific){%><!--IN069327-->
					<!--IN067855 starts-->
					<%if("*OTH".equals(diagcodestr)){%>
						<td class="<%=classValue%>"><%=diagdesc1%></td>
					<%}else{%>
						<td class="<%=classValue%>"><%=diagdesc%></td>
					<!--IN067855 ends-->
					<%}
				}else{%><!--IN069327-->
					<td class="<%=classValue%>"><%=diagdesc1%></td><!--IN069327-->
				<%}//IN069327
			%>
				<td class="<%=classValue%>"><%=diagstage%></td>
				<td class="<%=classValue%>"><%=diagcodestr%></td>
				<td class="<%=classValue%>"><%=diagcodescheme%></td>
				<td class="<%=classValue%>"><%=curr_remarks%></td><!-- 38981 -->
				
			<%
				}
			%>
				
				</tr>
			<%
				
				i++;
				k++;
			}

		if(maxRecord == 0)
					{
						call_from_link_doc_btn = "NO";//IN061907
					%>
					<script>document.forms[0].ctrlChkBox.disabled = true</script> 
					<%}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		
	
	
	
	
}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagResult.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	//ConnectionManager.returnConnection(con,request); //checkstyle
}

%>
			
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="term_set_id" id="term_set_id" value="<%=term_set_id%>">
			<input type="hidden" name="count" id="count" value="<%=k%>">
			<input type="hidden" name="includestatus" id="includestatus" value="<%=includestatus%>"><!-- 38981 -->
			
			
			
			
</table>
<!--IN061907 start-->
<%
if(call_from_link_doc_btn.equals("YES"))
{
%>
	<script>
		selectall();
	</script>
<%
}
%>
<!--IN061907 Ends-->
</form>
<%}
catch(Exception m)
{
	m.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagResult.jsp" + m);//COMMON-ICN-0181
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</script>
</html>

