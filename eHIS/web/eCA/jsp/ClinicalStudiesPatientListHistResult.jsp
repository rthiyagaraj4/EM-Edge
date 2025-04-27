<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       		Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
02/01/2013		IN037059		Ramesh G		Clinical Studies Patient List-> For the Practitioner even after the Access is given in 
												?Access Rights for Research Studies? no Records are displayed
03/01/2013		IN037111		Ramesh G		Clinical Studies Patient List  ->When we Click on Patient ID Hyperlink the Practitioner Desktop opens instead of Patient Chart
--------------------------------------------------------------------------------------------------------------- 
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML><head>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/ClinicalStudiesPatientListHist.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

out.println("<BODY  class='CONTENT' onLoad=\"parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num= ';\" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	StringBuffer sql = new StringBuffer();
	StringBuffer sql1 = new StringBuffer();
	StringBuffer sql2 = new StringBuffer();
	String sqlbuild="";
	String orderby="";
   
	String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	String	patientId 	= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	
	String from 					= request.getParameter("from") ;
	String to 						= request.getParameter("to") ;

	String view			= (request.getParameter("view")==null)?"":request.getParameter("view");
    String spl			= (request.getParameter("spl")==null)?"":request.getParameter("spl");
	String rest			= (request.getParameter("rest")==null)?"":request.getParameter("rest");
	String from_date	= (request.getParameter("from_date")==null)?"":request.getParameter("from_date");
	String to_date		= (request.getParameter("to_date")==null)?"":request.getParameter("to_date");
	
	from_date			=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date				=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
	
	String diag1		= request.getParameter("diag");
	String diagnew1  = "";
	if (!diag1.equals("")) 
		diagnew1  =diag1.substring(0,diag1.indexOf("-"));
	
	String diag2		= request.getParameter("diag2");
		if (diag2==null)  diag2="";
	String diagnew2  = "";
	
	if (!diag2.equals(""))  
		diagnew2=diag2.substring(0,diag2.indexOf("-"));

	String diag3		= request.getParameter("diag3");
	if (diag3==null)  diag3="";
	
	String diagnew3  = "";
	
	if (!diag3.equals(""))  
	diagnew3=diag3.substring(0,diag3.indexOf("-"));
	String b_year		= request.getParameter("b_year")==null?"":request.getParameter("b_year");
	String b_months     = request.getParameter("b_months")==null?"":request.getParameter("b_months");
	String b_days		= request.getParameter("b_days")==null?"":request.getParameter("b_days");
	String b_year2		= request.getParameter("b_year2")==null?"":request.getParameter("b_year2");
	String b_months2    = request.getParameter("b_months2")==null?"":request.getParameter("b_months2");
	String b_days2      = request.getParameter("b_days2")==null?"":request.getParameter("b_days2");
 	String sex		    = request.getParameter("sex")==null?"": request.getParameter("sex");
 	String status		= request.getParameter("status")==null?"":request.getParameter("status");
 	String group		= request.getParameter("group")==null?"":request.getParameter("group");
 	String term_set_id		= request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String resePatcategory	=  request.getParameter("resePatcategory")==null?"":request.getParameter("resePatcategory");
	String reseCategoryFact =  request.getParameter("reseCategoryFact")==null?"":request.getParameter("reseCategoryFact");
	String fr_age="",to_age="";
	sql1.append(" SELECT COUNT(*) as total ");
	
	sql2.append("SELECT A.PATIENT_ID, b.PATIENT_NAME , C.PRACTITIONER_NAME,D.RESEARCH_CATEG_DESC,E.RESEARCH_CATEG_FACT_DESC,A.REMARKS,B.CURR_PATIENT_CLASS,TO_CHAR (A.ADDED_DATE, 'dd/mm/yyyy hh24:mi:ss') ADDED_DATE,");
	sql2.append("(SELECT COUNT(*) FROM MR_TERM_CODE_LANG_VW MTC,PR_DIAGNOSIS PD WHERE MTC.TERM_CODE=PD.TERM_CODE AND PD.PATIENT_ID=A.PATIENT_ID ");
	if(!diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
		sql2.append("AND MTC.TERM_CODE IN(");
		int i=0;
		if (!diagnew1.equals("")){
			sql2.append("'"+diagnew1+"'");
			i++;
		}  
		if (!diagnew2.equals("")){
			if(i>0)
				sql2.append(",");
			sql2.append("'"+diagnew2+"'");
			i++;
	    }
		if (!diagnew3.equals("")){
		 if(i>0)
				sql2.append(",");
			sql2.append("'"+diagnew3+"'");
			i++;
		}		
		sql2.append(")");	
	}
	if(!term_set_id.equals("")){
	sql2.append("AND MTC.TERM_SET_ID='"+term_set_id+"'");
	}
	sql2.append(" AND MTC.LANGUAGE_ID='"+locale+"')ACTIVDIAG");
	
	String whereClause				= request.getParameter("whereclause");
			 
	if ( (whereClause == null || whereClause.equals("")) )
	{	
		sql.append("  FROM CA_RESEARCH_PATIENT_DETAIL A,MP_PATIENT B,AM_PRACTITIONER C,CA_RESEARCH_CATEGORY D,CA_RESEARCH_CATEGORY_FACT E,SM_APPL_USER F WHERE ");
		sql.append(" A.PATIENT_ID=B.PATIENT_ID");
		sql.append(" AND A.ADDED_BY_ID=F.APPL_USER_ID");
		sql.append(" AND F.FUNC_ROLE_ID=C.PRACTITIONER_ID");
		sql.append(" AND A.RESEARCH_CATEG_ID=D.RESEARCH_CATEG_ID");
		sql.append(" AND A.RESEARCH_CATEG_FACT_ID=E.RESEARCH_CATEG_FACT_ID (+)");
		if("S".equals(view)){
			sql.append("AND A.ADDED_BY_ID='"+practitioner_id+"' ");
		}
		sql.append(" AND A.ADDED_FACILITY_ID='"+rest+"' ");
		sql.append(" AND A.ADDED_DATE >= TO_DATE ('"+from_date+"', 'dd/mm/yyyy') ");
		// IN037059 Start.
		//sql.append(" AND A.ADDED_DATE <= TO_DATE ('"+to_date+"', 'dd/mm/yyyy') ");
		sql.append(" AND A.ADDED_DATE <= TO_DATE ('"+to_date+"', 'dd/mm/yyyy')+.99 ");
		//IN037059 End.
		sql.append(" AND A.RESEARCH_CATEG_ID ='"+resePatcategory+"'");
		sql.append(" AND A.RESEARCH_CATEG_FACT_ID='"+reseCategoryFact+"'");
		if(!spl.equals("")){
		sql.append(" AND A.PATIENT_ID IN (select distinct PATIENT_ID from pr_encounter where  SPECIALTY_CODE = '"+spl+"')");
		}
		if(!sex.equals("")){
			sql.append(" AND b.sex = '"+sex+"'");
		}
		if("O".equals(status)){
			sql.append(" AND A.CLOSE_DATE IS NULL");
		}else if("C".equals(status)){
			sql.append(" AND A.CLOSE_DATE IS NOT NULL");
		}
		if(!term_set_id.equals("")|| !diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
			sql.append(" AND A.PATIENT_ID IN (SELECT DISTINCT PATIENT_ID FROM PR_DIAGNOSIS WHERE ");
			int j=0;
			if(!term_set_id.equals("")){
				j++;
				sql.append(" TERM_SET_ID='"+term_set_id+"'");
			}
			if(!diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
					if(j==0){
						sql.append(" TERM_CODE IN (");
					}else{
						sql.append(" AND TERM_CODE IN (");
					}
					int i=0;
					if (!diagnew1.equals("")){
						sql.append("'"+diagnew1+"'");
						i++;
					}  
					if (!diagnew2.equals("")){
						if(i>0)
							sql.append(",");
						sql.append("'"+diagnew2+"'");
						i++;
					}
					if (!diagnew3.equals("")){
					 if(i>0)
							sql.append(",");
						sql.append("'"+diagnew3+"'");
						i++;
					}		
					sql.append(")");	
			}
			sql.append(")");
		}
		if ((!b_year.equals("")) ||(!b_months.equals(""))||(!b_days.equals(""))){  
			if (b_year.equals(""))
			  b_year="0";
			if (b_months.equals(""))
			  b_months="0";
			if	(b_days.equals(""))
			  b_days="0";
			fr_age="("+b_year+"*365+"+b_months+"*30+"+b_days+")";
			sql.append(" AND SYSDATE- B.DATE_OF_BIRTH>"+fr_age+" ");
		}
		
		if ((!b_year2.equals("")) ||(!b_months2.equals(""))||(!b_days2.equals("")))
		{  
			if (b_year2.equals(""))
			  b_year2="0";
			else
			   b_year2="("+b_year2+"+1)";
			if (b_months2.equals(""))
			  b_months2="0";
			else
			   b_months2="("+b_months2+"+1)";
			if	(b_days2.equals(""))
			  b_days2="0";
			else
			   b_days2="("+b_days2+"+1)";
			to_age="("+b_year2+"*365+"+b_months2+"*30+"+b_days2+")";
			 
			 sql.append(" AND SYSDATE- B.DATE_OF_BIRTH<="+to_age+" " );
		}
		if("3".equals(group)){
			sql.append(" ORDER BY UPPER(PRACTITIONER_NAME) ASC");
		}else if("4".equals(group)){
			sql.append(" ORDER BY UPPER(RESEARCH_CATEG_DESC) ASC");
		}
		sqlbuild = sql.toString();
	}else
		sqlbuild=whereClause;
	
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 7 ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int maxRecord = 0;
	try
	{
		con =  ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql1.toString()+sqlbuild);
		rs = pstmt.executeQuery();

		while(rs!=null && rs.next()){
		  maxRecord = rs.getInt("total");
        }
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	  
		if (maxRecord== 0)
		{
		%>
		<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));

		</script>
		<%
		}
		else			
		{   
			
			pstmt = con.prepareStatement(sql2.toString()+sqlbuild);		  
			rs = pstmt.executeQuery();
		%>

			<table cellpadding='3' align='center' width='100%'>
				<tr>
					<td width='90%' class='white' ></td>
					<td width='10%'>
					<%
						if ( !(start <= 1) )
							out.println("<A HREF='../../eCA/jsp/ClinicalStudiesPatientListHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&term_set_id="+term_set_id+"&diag3="+diag3+"&group="+group+"&patient_id="+patientId+"&from="+(start-7)+"&to="+(end-7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

						if ( !( (start+7) > maxRecord ) ){
							out.println("<A HREF='../../eCA/jsp/ClinicalStudiesPatientListHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&diag3="+diag3+"&term_set_id="+term_set_id+"&group="+group+"&patient_id="+patientId+"&from="+(start+7)+"&to="+(end+7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none' class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						}
				
					%>
					</td>
				</tr>
			</table>

			<table  width="100%" class='grid'>
				<tr>
					<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='15%' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>				
					<td class='COLUMNHEADER' width='15%'>Recorded Practitioner</td>
					<td class='COLUMNHEADER' width='20%'><fmt:message key="eCA.ResearchCategory.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADER' width='20%'><fmt:message key="eCA.ResearchCategoryFactor.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADER' width='10%'>Active Diagnosis</td>				
					<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
				</tr>			
				<%
			if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){ rs.next() ; }

			while ( rs!=null && rs.next() && i<=end ){
				String patid = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
				String patname = (rs.getString("PATIENT_NAME")==null)?"":rs.getString("PATIENT_NAME");			
				String practName = (rs.getString("PRACTITIONER_NAME")==null)?"":rs.getString("PRACTITIONER_NAME");
				String reseCateDesc = (rs.getString("RESEARCH_CATEG_DESC")==null)?"":rs.getString("RESEARCH_CATEG_DESC");
				String reseCateFactDesc = (rs.getString("RESEARCH_CATEG_FACT_DESC")==null)?"":rs.getString("RESEARCH_CATEG_FACT_DESC");			
				int activeDiag = 0;
					activeDiag =rs.getInt("ACTIVDIAG");
				String details = (rs.getString("REMARKS")==null)?"":rs.getString("REMARKS");
				String addedDate = rs.getString("ADDED_DATE");
				String eid = ""; //(rs.getString("EID")==null)?"":rs.getString("EID");
				 String patclass= rs.getString("CURR_PATIENT_CLASS")==null?"":rs.getString("CURR_PATIENT_CLASS");
				
				out.println("<tr><td nowrap align=left  class='gridLink'><font size=2><a href=\"javascript:openHistory('"+patid+"','"+patclass+"' )\" class='gridLink'>"+patid+"</a></td>");
				out.println("<td nowrap align=left  class='gridLink'>"+patname+"</td>");
				out.println("<td nowrap align=left  class='gridLink'>"+practName+"</td>");
				out.println("<td nowrap align=left  class='gridLink'>"+reseCateDesc+"</td>");
				out.println("<td nowrap align=left  class='gridLink'>"+reseCateFactDesc+"</td>");
				if(activeDiag>0)
					out.println("<td nowrap align=left  class='gridLink'><font size=2><a href=\"javascript:showActiveDignosisDetails('"+patid+"','"+rest+"','"+locale+"','"+term_set_id+"','"+diagnew1+"','"+diagnew2+"','"+diagnew3+"')\" class='gridLink'><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td>");
				else
					out.println("<td nowrap align=left  class='gridLink'>&nbsp;</td>");
				if(!"".equals(details))
					out.println("<td nowrap align=left  class='gridLink'><font size=2><a href=\"javascript:showDetails('"+patid+"','"+rest+"','"+resePatcategory+"','"+reseCategoryFact+"','"+addedDate+"')\" class='gridLink'><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td>");
				else
					out.println("<td nowrap align=left  class='gridLink'>&nbsp;</td>");
				out.println("</tr>");
				i++;
			}
		}
		 %>		
		</table>	 
		<%

	}catch(Exception e){
		e.printStackTrace();
		e.toString();
		//out.println(e.toString());//COMMON-ICN-0181
	}
	finally   
	{
		 if(pstmt!=null)pstmt.close();
		 if(rs!=null)rs.close();
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
	}
%>
<form name="chartForm" id="chartForm" action="OpenChartWrapper.jsp">
	 <input type="hidden" name='insert_op' id='insert_op' value= 'N'>
	 <input type='hidden' name='encounter_id' id='encounter_id' value= ''>
	 <input type='hidden' name='episode_id' id='episode_id' value= ''>
	 <input type='hidden' name='patient_class' id='patient_class' value= ''>
	 <input type='hidden' name='patient_id' id='patient_id' value= ''>  <!-- IN037111 -->
	 <input type='hidden' name='called_function_id' id='called_function_id' value= 'REL_PAT_TREAT'> 
</form>
</BODY>
</HTML>


