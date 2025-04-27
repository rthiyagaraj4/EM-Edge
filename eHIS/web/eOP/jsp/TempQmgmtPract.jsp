<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String   locale = (String)session.getValue("LOCALE");
	/*end SS-CRF-0010 [IN034516]*/
	String chkval=request.getParameter("list_name111");
	String step=request.getParameter("step");
	if(step == null)
	step="";
	
	StringBuffer sql=new StringBuffer();
    Connection con = null;
    String fac_id  =  (String) session.getValue( "facility_id" ) ;
    String locn_code        = request.getParameter("LAssign1");
    String p_pract_id       = request.getParameter("p_pract_id");
   	String str1="";
	String str2="";
	String IDENT_AT_CHECKIN="";
	//int rcnt=0;
	
	//Statement stmt3=null;
    //ResultSet rs3 = null;

	PreparedStatement pstmt =null;
	ResultSet rs = null;
	StringBuffer rstr=new StringBuffer();

	rstr.setLength(0);
	
	
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<html><HEAD><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown ='lockKey()'><script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><form name='testform' id='testform'>");

	try{
		con = ConnectionManager.getConnection(request);
		if(step.equals("2"))
		{
        if (p_pract_id == null)
        {
        %>
            <script>
                				
                var opt = parent.parent.frames[1].document.createElement('OPTION');
                opt.text = '-----'+getLabel("Common.defaultSelect.label","Common")+'-----';
                opt.value= '';
                opt.selected='true'
                parent.parent.frames[1].document.forms[0].VAssign.add(opt);

            </script>
        <%
            sql.append(" select open_to_all_pract_yn ass_open_to_all_pract_yn, speciality_code ass_speciality_code, pract_type ass_pract_type,IDENT_AT_CHECKIN ");
            sql.append(" from op_clinic where clinic_code = '"+locn_code+"' and facility_id = '"+fac_id+"' ");

			 pstmt = con.prepareStatement(sql.toString());
             rs = pstmt.executeQuery();
          
            sql.setLength(0);
			
            if (rs != null)
            {
                if(rs.next())
                {
                    String p_ass_open_to_all_pract_yn   =   rs.getString("ass_open_to_all_pract_yn");
                    String p_ass_pract_type         =   rs.getString("ass_pract_type");
                    String p_ass_speciality_code        =   rs.getString("ass_speciality_code");
                    String p_ass_locn_code = locn_code;
                    p_ass_pract_type = rs.getString("ass_pract_type");

					IDENT_AT_CHECKIN=rs.getString("IDENT_AT_CHECKIN");

                    if (p_ass_pract_type == null) p_ass_pract_type="";
                                      
                    if ((p_ass_open_to_all_pract_yn).equals("Y"))
                    {
                        sql.append(" select practitioner_id ass_pract_id, practitioner_name, pract_type_desc from am_pract_for_facility_vw ");
                        sql.append(" where nvl(pract_type,'X') = nvl('"+p_ass_pract_type+"', nvl(pract_type,'X')) and primary_speciality_code = '"+p_ass_speciality_code+"' and " );
                        sql.append(" eff_status='E' and operating_facility_id = '"+fac_id+"'");
                        sql.append(" union select b.practitioner_id ass_pract_id,b.practitioner_name, nvl(DESC_USERDEF,DESC_SYSDEF)  pract_type_desc from am_pract_specialities a, am_practitioner b, op_clinic c,am_pract_type d where c.facility_id = a.facility_id and ");
                        sql.append(" b.practitioner_id = a.practitioner_id and c.clinic_code='"+p_ass_locn_code+"' and b.pract_type =  nvl(c.pract_type,b.pract_type) and a.facility_id='"+fac_id+"' and d.pract_type=b.pract_type ");               
                        sql.append(" and  a.speciality_code= c.speciality_code order by 2" );
                    }
                    else
                    {
                        sql.append("select b.practitioner_id ass_pract_id, b.practitioner_name, c.pract_type_desc from op_pract_for_clinic a, am_practitioner b ,am_pract_for_facility_vw c,");
                        sql.append("(select day_no from sm_day_of_week where day_of_week = rtrim(to_char(sysdate,'DAY')))d where decode(d.day_no,'1',a.working_day_1,'2',a.working_day_2,'3',a.working_day_3,'4',a.working_day_4,'5',a.working_day_5,'6',a.working_day_6,a.working_day_7)='Y' and ");
                        sql.append("  a.practitioner_id = b.practitioner_id and a.clinic_code = '"+p_ass_locn_code+"' and b.pract_type = nvl('"+p_ass_pract_type+"',b.pract_type) and a.facility_id = '"+fac_id+"' ");
                        sql.append(" and c.practitioner_id = a.practitioner_id and c.operating_facility_id = '"+fac_id+"' order by 2");
                    }
                }
            }

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

             String str3 = "";
	
		   %>
			  <script>
			parent.parent.frames[1].document.forms[0].IDENT_AT_CHECKIN.value='<%=IDENT_AT_CHECKIN%>';
			  </script>
			 <%
			 pstmt = con.prepareStatement(sql.toString());
             rs = pstmt.executeQuery();

            if( rs != null )
            {
                while( rs.next() )
                {
                    str1 = rs.getString( "practitioner_name" ) ;
                    str2 = rs.getString( "ass_pract_id" );
                    str3 = rs.getString( "pract_type_desc" );
				%>
                    <script>
                        var element = parent.parent.frames[1].document.createElement('OPTION');
                            element.text = "<%=str1%>";
                            element.value= "<%=str2%>"+"|"+"<%=str3%>";
                            parent.parent.frames[1].document.forms[0].pract_id.add(element);

                    </script>
			    <%
                }
            }

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			sql.setLength(0);

        }
        else
        {
			String sqlType = "Select pract_type_desc from am_practitioner_vw where practitioner_id='"+p_pract_id+"'";
			
            pstmt = con.prepareStatement(sqlType);
            rs = pstmt.executeQuery();

            if (rs != null)
            {
                while(rs.next())
				{
		%>
				<script>        
					parent.parent.frames[1].document.getElementById("practtype").innerHTML="&nbsp;<%=rs.getString(1)%>";
		        </script>
        <%
				}
			}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
          }
		}
		else
		{
			rstr.append("<option value=''> ----- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----- </option>");
			
			if(chkval.equals("LAssign1"))
			{
				    /*stmt3 = con.createStatement();
					String Sql3  = "select count(*) as total from op_pract_for_clinic where facility_id='"+fac_id+"' and clinic_code='"+locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id ";

					rs3 = stmt3.executeQuery(Sql3);
					rs3.next();
					rcnt=rs3.getInt("total");

					if(rs3 != null) rs3.close();
					if(stmt3 != null) stmt3.close();*/
	            
				/*below query was modified by venkatesh.s on 07-Nov-2012 against 36094*/
					 pstmt   = con.prepareStatement( "select practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id, '"+locale+"', 2) room_desc from op_pract_for_clinic a  where facility_id='"+fac_id+"' and clinic_code='"+locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id");

					rs = pstmt.executeQuery();
				
						boolean flagvalue=false;
                        String room_desc="";
						while( rs.next())
						{
							flagvalue=true;
							str2 = rs.getString( "ROOM_NO" );	
                             room_desc=rs.getString("room_desc" );	
                             							 
							rstr.append("<option value='"+str2+"' >"+str2+" "+room_desc+"</option>");	   
						}
					 	

					 if(rs != null) rs.close();
					 if(pstmt != null) pstmt.close();

					 if(flagvalue)
					 {	
					  String robj="<select name='room_numsel' id='room_numsel' onChange='chgvalue(this);'>"+rstr.toString()+"</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>";
                      /*end 36094*/					 
					  %>
						<script>
						  parent.frames[1].document.getElementById("room_value").innerHTML="<%=robj%>";
						</script>
					 <%					
				     }
					else
					{					
					String robj="<select name='room_numsel' id='room_numsel' onChange='chgvalue(this);'><option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option></select>";
					%>
						<script>
					parent.frames[1].document.getElementById("room_num").value ="NoRoom";
					parent.frames[1].document.getElementById("room_value").innerHTML="<%=robj%>";
					</script>
					<%	
					}				
				}  
		 }
 rstr.setLength(0);
}
catch(Exception e)
{
   e.printStackTrace();
}
finally{

	if(con != null) ConnectionManager.returnConnection(con,request);
}

%>
</form>
</body>
</html>

