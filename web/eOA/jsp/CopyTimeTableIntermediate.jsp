 
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=utf-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<% 
Connection con = null;
ResultSet rs=null;
PreparedStatement pstmt =null;


try{
	request.setCharacterEncoding("utf-8");
con = ConnectionManager.getConnection(request);
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

	String facilityId	=(String) session.getValue("facility_id");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	
	
	String steps     =(String) hash.get("steps");
	String clinic_code     =(String) hash.get("clinic_code");
	
     
    if(steps.equals("1")){
	
		StringBuffer sql=new StringBuffer("");
		String pract_id="";
		String care_locn_type_ind= "";
		String day_no ="";
		String time_table_type="";
		String time_table_type_no="";
		String practitioner_name="";
		String day_of_week="";
		String resource_class="";
		String start_time="";
		String end_time="";
		
		/*Below query commented by venkatesh against GHL-SCF-992 on 18-02-2016 */
		//	sql.append("select care_locn_type_ind,CARE_LOCN_TYPE_DESC, clinic_code,clinic_name,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,nvl(practitioner_id,'')practitioner_id,nvl(practitioner_id,'') pract_id,nvl(PRACTITIONER_FULL_NAME,'')practitioner_name,day_no,day_of_week,decode(time_table_type,'1','Slot','2','Slab','3','Free Format') time_table_type,time_table_type time_table_type_no,TO_CHAR (start_time, 'HH24:mi') start_time, TO_CHAR (end_time, 'HH24:mi') end_time from oa_clinic_time_table_vw where facility_id ='"+facilityId+"' and clinic_code = '"+clinic_code+"' and practitioner_id is not null ");
			 /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
			sql.append("select care_locn_type_ind,CARE_LOCN_TYPE_DESC, clinic_code,clinic_name,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,nvl(practitioner_id,'')practitioner_id,nvl(practitioner_id,'') pract_id,nvl(PRACTITIONER_FULL_NAME,'')practitioner_name,day_no,day_of_week,decode(time_table_type,'1','Slot','2','Slab','3','Free Format') time_table_type,time_table_type time_table_type_no,TO_CHAR (start_time, 'HH24:mi') start_time, TO_CHAR (end_time, 'HH24:mi') end_time from oa_clinic_time_table_vw where facility_id ='"+facilityId+"' and clinic_code = '"+clinic_code+"' and practitioner_id is not null AND (EFF_STATUS!='D' OR EFF_STATUS IS NULL)");
					
		
			pstmt=con.prepareStatement(sql.toString());
		//	if (rs!=null) rs.close();
			rs = pstmt.executeQuery() ;
			sql.setLength(0);
			%>
			
			
			 var i=2;
			 var len=parent.frames[0].document.forms[0].Time_Table_Details.options.length;
			 var lBox=parent.frames[0].document.forms[0].Time_Table_Details; 
			 lBox.remove(lBox.options[0]);
			 var opt=parent.frames[0].document.createElement('OPTION');
			 opt.value='';
		     opt.text='------------------------'+getLabel("Common.defaultSelect.label","Common")+'------------------------';
			 lBox.add(opt);

			 while(i<= len){
				 lBox.remove(lBox.options[i]);
				 i+=1;
			}   
			
			<%
			if (rs != null){
						
				while(rs.next()){
					 pract_id=rs.getString("pract_id");
					 	care_locn_type_ind= rs.getString("care_locn_type_ind");
					 	day_no = rs.getString("day_no");
					 		time_table_type=rs.getString("time_table_type");
					 		time_table_type_no=rs.getString("time_table_type_no");
					 		practitioner_name=rs.getString("practitioner_name");
					 		day_of_week=rs.getString("day_of_week");
					 		resource_class=rs.getString("resource_class");
					 		start_time=rs.getString("start_time");
					 		end_time=rs.getString("end_time");
			
					%>
					var element = parent.frames[0].document.createElement('OPTION');
					element.value="<%=pract_id%>|<%=time_table_type_no%>|<%=day_no%>|<%=resource_class%>|<%=start_time%>|<%=end_time%>";
					element.text = "<%=practitioner_name%>/<%=day_of_week%>/<%=time_table_type%>";
					parent.frames[0].document.forms[0].Time_Table_Details.add(element);

					<%
				}
			}
		

	}

	if(rs !=null) rs.close();	
	if(pstmt !=null)pstmt.close();
	hash.clear();

}catch( Exception e ){
	System.out.println("Exception Steps :"+e);
	e.printStackTrace();

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>	
