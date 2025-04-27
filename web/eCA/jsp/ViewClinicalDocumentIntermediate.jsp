
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 <%
		request.setCharacterEncoding("UTF-8");	
		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String patient_id =hash.get("patient_id")==null?"":(String) hash.get("patient_id");
		String fromDate =hash.get("fromDate")==null?"":(String) hash.get("fromDate");
		String toDate =hash.get("toDate")==null?"":(String) hash.get("toDate");
		String locale =hash.get("locale")==null?"":(String) hash.get("locale");		

		fromDate=com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM",locale,"en");		
		toDate=com.ehis.util.DateUtils.convertDate(toDate,"DMYHM",locale,"en");
		
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;	 

	

	StringBuffer sqlEncounter=new StringBuffer();
	String encounter_id="";
	String selLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	
		out.println("clearEncounterList()");	
		out.println("addEncounterList('-----"+selLabel+"-------');");
		
	
	sqlEncounter.append("select encounter_id from pr_encounter where PATIENT_ID=? AND nvl(VISIT_STATUS,'01') !='09' AND nvl(ADT_STATUS,'01') !='09' ");

			try{
					if(!fromDate.equals("")){
						sqlEncounter.append("AND VISIT_ADM_DATE_TIME >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
					}
					if(!toDate.equals("")){

						sqlEncounter.append("AND VISIT_ADM_DATE_TIME <=to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 ");
					}
					sqlEncounter.append(" order by VISIT_ADM_DATE_TIME DESC ");

					con=ConnectionManager.getConnection();
					
					pstmt=con.prepareStatement(sqlEncounter.toString());		

					int count=0;
					pstmt.setString(++count,patient_id);

					if(!fromDate.equals(""))
						pstmt.setString(++count,fromDate);

					if(!toDate.equals(""))
						pstmt.setString(++count,toDate);

					rs=pstmt.executeQuery();

					while(rs.next()) 
		  			 {							
		  				encounter_id=rs.getString("encounter_id");		
						out.println("addEncounterList('"+encounter_id+"')");											
					}		  			
					if(rs!=null) rs.close();		
					if(pstmt!=null) pstmt.close();
					 			
				}
					catch(Exception e){
						//out.println("exception in encounter**"+e);//COMMON-ICN-0181
						e.printStackTrace();
				}
				finally
				{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				} 
	%>
