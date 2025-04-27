
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%
	 request.setCharacterEncoding("UTF-8");
	 String locale=(String)session.getAttribute("LOCALE");
	String note_id = request.getParameter("note_id");

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String[] record1=null;
	String assess_note_desc="";
	String inpatient="";
	String outpatient="";
	String emergency = "";
	String external="";
	String pat_class_appl="";
	String pat_class_appl1="";
	String sql = "";
	

try
{
	con = ConnectionManager.getConnection(request);
	
   	sql="select  note_type_desc,inpatient_yn,outpatient_yn,daycare_yn,emergency_yn from ca_note_type_lang_vw where  note_type=? and language_id=?";
	pstmt= con.prepareStatement(sql);	
	pstmt.setString(1,note_id);
	pstmt.setString(2,locale);
    rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{     
				record1 = new String[5];		
				
				assess_note_desc = rs.getString("note_type_desc")==null ? "": rs.getString("note_type_desc");	
				record1[0]=assess_note_desc;
					
				inpatient = rs.getString("inpatient_yn")==null ? "": rs.getString("inpatient_yn");	

				if(inpatient.equals("Y"))
				{
				pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				record1[1]=pat_class_appl;
				}
				else
				{
					pat_class_appl="";
					record1[1]=pat_class_appl;
				}
			
				outpatient = rs.getString("outpatient_yn")==null ? "": rs.getString("outpatient_yn");	
				if(outpatient.equals("Y"))
				{
					pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
					record1[2]=pat_class_appl;
				}
				else
				{
						pat_class_appl="";
						record1[2]=pat_class_appl;
				}
						
				emergency = rs.getString("daycare_yn")==null ? "": rs.getString("daycare_yn");	
				if(emergency.equals("Y"))
				{
					pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
					record1[3]=pat_class_appl;
							
				}
				else
				{
						pat_class_appl="";
						record1[3]=pat_class_appl;
				}		
									
				external =rs.getString("emergency_yn")==null ? "": rs.getString("emergency_yn");	
				if(external.equals("Y"))
				{
							pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
							record1[4]=pat_class_appl;
							
				}
				else
				{
						pat_class_appl="";
						record1[4]=pat_class_appl;
				}

				pat_class_appl1=record1[1]+" "+record1[2]+" "+record1[3]+" "+record1[4]+" ";
				

			out.println( "assignDateRange(\"" + record1[0] + "\",\"" + pat_class_appl1 + "\") ; " ) ;
		}

		}catch(Exception e) {
			//out.println("Main : "+e.toString());//COMMON-ICN-0181
                           e.printStackTrace();//COMMON-ICN-0181
			}
	finally
	{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request); 
	}

%>

	
