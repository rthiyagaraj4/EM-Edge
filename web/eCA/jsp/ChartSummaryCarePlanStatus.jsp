<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/11/2012  IN035950      Nijitha        CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
					 more appealing. Keeping the display of information more clear and visible.
26/02/2013	IN035924	  Karthi L	 	CA View chart summary ?RESULT WIDGET? should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)
13/03/2013  IN038713	 Nijitha S				CRF-CA- CHL-CRF-0018/04- Scope for Data to be displayed in Widget defined->Other facility->we get exception error
---------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        	Rev.Date	Rev.Name	Description
---------------------------------------------------------------------------------------------------------
28/06/2018	IN065341	Prakash C	29/06/2018	Ramesh G	MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> <!-- added eCA.* IN035924 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>   
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}


%>
<!--<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> IN035950-->
<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />
<!--[IN035950] Ends-->
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
	<!--<title><fmt:message key="eCA.CARE_PEND_SCH.label" bundle="${ca_labels}"/></title>-->
	<title><%=title%></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	
		<form name='CAViewPatientAllergyForm' id='CAViewPatientAllergyForm' method='post'>
		<table  width='100%' class='grid'>
		<%  String care_plan_id = "", effective_date = "", care_plan_status = "",encounter_id	=	"",classValue = "";
			String status = "",  md_care_plan_id = "",facility_id ="";
			String term_set_desc="", prev_term_set_desc="",term_code_desc="",cp_term_dtl = "";
			int i=0, termcode_seq_no=0;
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			//facility_id=(String) session.getValue("facility_id"); // moved for CHL-CRF-018 IN035924 //commented for IN065341
			String P_patient_id = request.getParameter("patient_id"); // added for CHL-CRF-018 IN035924
			//IN065341 starts
			String scope_disp="D";
			int no_of_days=0;
			String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
			String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");//IN065341
			if(called_from.equals("CDR")){
				encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
				facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
			}else{//IN065341 ends
			   encounter_id = request.getParameter("encounter_id"); // IN035924
			   facility_id=(String) session.getValue("facility_id"); // moved for CHL-CRF-018 IN035924 
			}//IN065341
			// added below lines for CHL-CRF-018 IN035924 - START 
			StringBuffer encListBuf = new StringBuffer();
			ArrayList encounterList = null;
		//IN065341 starts
			if(!called_from.equals("CDR")){
			CAEncounterList oEncounterList = new CAEncounterList();
			HashMap encounterMap = oEncounterList.getPatEncounterList(P_patient_id, facility_id, content_ID);
			//String scope_disp = (String)encounterMap.get("SCOPE_DISP");//IN065341
			scope_disp = (String)encounterMap.get("SCOPE_DISP");//IN065341
			Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
			//int no_of_days = no_of_days_before.intValue();
			no_of_days = no_of_days_before.intValue();	
			encounterList = (ArrayList)encounterMap.get("ENC_LIST");
			
			if( no_of_days >= 1  &&  scope_disp.equalsIgnoreCase("P"))
			{
				Iterator iterator = encounterList.iterator();
				int index = 0;
				
				while(iterator.hasNext())
				{	
					index++;
					encListBuf.append("'");
					encListBuf.append(iterator.next());
					if(encounterList.size() >= index )
					{
						encListBuf.append("'");
					}
					
					if(encounterList.size() != index )
					{
						encListBuf.append(",");
					}
				}
			}
			else if(scope_disp.equalsIgnoreCase("P"))
			{
				encListBuf.append("'");
				encListBuf.append(encounter_id);
				encListBuf.append("'");
			}	
			//CHL-CRF-018 IN035924 - END
			//IN038713 Starts
			if(encListBuf.equals("") || null==encListBuf || encounter_id==null || encounter_id.equals(""))
			encListBuf.append("''");
			//IN038713 Ends
			}//IN065341
			Connection con = null;
			PreparedStatement pstmt = null,pstmt1 = null;;
			ResultSet	rs = null,rs1 = null;
		
			try	{
				//encounter_id = request.getParameter("encounter_id"); // moved for CHL-CRF-018 IN035924
				if (encounter_id==null) encounter_id="";
				//facility_id=(String) session.getValue("facility_id"); commented for CHL-CRF-018 IN035924
				if(scope_disp.equalsIgnoreCase("D")) // condition added for CHL-CRF-018 IN035924
				{
					//care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID=? ORDER BY OA.CARE_PLAN_START_DATE desc ";
					care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID=? ORDER BY OA.CARE_PLAN_START_DATE desc ";//IN065341
				}	
				else if(scope_disp.equalsIgnoreCase("P")) 
				{
					//care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID in ("+encListBuf+") ORDER BY OA.CARE_PLAN_START_DATE desc ";
					//IN065341 starts
					if(called_from.equals("CDR")){
						care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID in ("+encounter_id+") ORDER BY OA.CARE_PLAN_START_DATE desc ";//IN065341
					}else{//IN065341 ends
						care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID in ("+encListBuf+") ORDER BY OA.CARE_PLAN_START_DATE desc ";
					}
				}
				else if(scope_disp.equalsIgnoreCase("C"))
				{
					//care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID = ? AND oa.CARE_PLAN_START_DATE between (sysdate - ?) and sysdate  ORDER BY OA.CARE_PLAN_START_DATE desc ";
					care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID = ? AND oa.CARE_PLAN_START_DATE between (sysdate - ?) and sysdate  ORDER BY OA.CARE_PLAN_START_DATE desc ";//IN065341
				}
				// condition added/modified for CHL-CRF-018 IN035924 - END
				
				//cp_term_dtl = " SELECT DISTINCT B.TERM_SET_DESC , C.SHORT_DESC TERM_CODE_DESC FROM CP_PAT_CARE_PLAN_TERM_CODE A, MR_TERM_SET B, MR_TERM_CODE C WHERE A.MD_CARE_PLAN_ID=? AND A.CARE_PLAN_ID=? AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE =A.TERM_CODE  order by 1,2 ";
				cp_term_dtl = " SELECT DISTINCT B.TERM_SET_DESC , C.SHORT_DESC TERM_CODE_DESC FROM CP_PAT_CARE_PLAN_TERM_CODE ##REPDB## A, MR_TERM_SET ##REPDB## B, MR_TERM_CODE ##REPDB## C WHERE A.MD_CARE_PLAN_ID=? AND A.CARE_PLAN_ID=? AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE =A.TERM_CODE  order by 1,2 ";//IN065341
				care_plan_status=care_plan_status.replaceAll("##REPDB##",RepDb);//IN065341
				cp_term_dtl=cp_term_dtl.replaceAll("##REPDB##",RepDb);//IN065341

				con = ConnectionManager.getConnection(request);
				pstmt	=	con.prepareStatement(care_plan_status);
				pstmt1  =	con.prepareStatement(cp_term_dtl);
				pstmt.setString(1,facility_id);
				if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C")) //condition added for CHL-CRF-018 IN035924
				{	
					pstmt.setString(2,encounter_id);
				}
				if(scope_disp.equalsIgnoreCase("C")) // added for CHL-CRF-018 IN035924
				{	
					pstmt.setInt(3,no_of_days);	
				}		
				rs = pstmt.executeQuery();

				while(rs.next()){
					i++;
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					
					care_plan_id			=	rs.getString("CARE_PLAN_ID")== null ? "" : rs.getString("CARE_PLAN_ID");
					effective_date			=	rs.getString("EFFECTIVE_DATE")== null ? "" : rs.getString("EFFECTIVE_DATE");

					effective_date			=	com.ehis.util.DateUtils.convertDate(effective_date,"DMY","en",locale);
					status	=	rs.getString("status") == null ? "" : rs.getString("status");
					md_care_plan_id	=	rs.getString("MD_CARE_PLAN_ID") == null ? "" : rs.getString("MD_CARE_PLAN_ID");
					%>
						<tr>
								<td valign=top CLASS='gridData'  colspan="1" ><%=effective_date%></td>
								
					<%
					try	{
						pstmt1.setString(1,md_care_plan_id);
						pstmt1.setString(2,care_plan_id);
						rs1 = pstmt1.executeQuery();
						prev_term_set_desc="*";
						
						term_code_desc="";

						while(rs1.next())
						{
							
							term_set_desc	=	rs1.getString("term_set_desc") == null ? "" : rs1.getString("term_set_desc");
							if (prev_term_set_desc.equals("*"))
							{
								term_code_desc="<B>"+term_set_desc+"</B>";
								termcode_seq_no=1;
							}
							else if(!prev_term_set_desc.equals(term_set_desc))
							{
								term_code_desc = term_code_desc + "<BR><B>"+term_set_desc+"</B>";
								termcode_seq_no=1;
							}
							prev_term_set_desc=term_set_desc;
							term_code_desc	= term_code_desc +	rs1.getString("term_code_desc") == null ? "" : "<BR><I>"+termcode_seq_no +".</I>"+rs1.getString("term_code_desc");
							termcode_seq_no++;
						
						}

						if(rs1 != null) rs1.close();
						//if(pstmt1!=null) pstmt1.close();
					}
					catch(Exception e)
					{
							//out.println("Exception@in : "+e.getMessage());//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
					}  
					%>
					<td CLASS='gridData'  colspan="2" ><%=term_code_desc%></td>
					<td valign=top CLASS='gridData'  colspan="1" ><%=status%></td>
					</tr>

					<%	
					}
					//IN035950  Starts
					if(i==0)
					{
					out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
					}
					//IN035950  Ends
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(rs1!=null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
					}catch(Exception e){
						//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
						  e.printStackTrace();//COMMON-ICN-0181
					}finally
					{

						if(con!=null)ConnectionManager.returnConnection(con,request);
					}  	%>
				</table>
				</form>
			
		</body>
		</html>

