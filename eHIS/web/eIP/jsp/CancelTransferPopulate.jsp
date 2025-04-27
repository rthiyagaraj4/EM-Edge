<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>
<script src='../../eCommon/js/common.js' language='Javascript'></script>


<%
		request.setCharacterEncoding("UTF-8");
		String strFacilityId			=	(String)session.getValue("facility_id");
		String strNursingCode    =	 request.getParameter("hdnNursingUnit") ;     
		String strFrBedno	   		 = request.getParameter("hdnBedNo"); 
		String	strRoomNo = "";
		Connection			con			=	null;
		Statement			stmt		=	null;
		ResultSet			rset		=	null;
		con					=	ConnectionManager.getConnection(request);
		String sql="";
		try
		{		
		if(!strFrBedno.equals(""))
			{
				sql		=	"select a.room_no, a.bed_type_code,b.bed_class_code,b.short_desc,a.specialty_code,a.CURRENT_STATUS from ip_nursing_unit_bed a,ip_bed_class b where a.nursing_unit_code = '"+strNursingCode+"' and a.bed_no='"+strFrBedno+"' and a.facility_id = '"+strFacilityId+"'AND a.bed_class_code = b.bed_class_code  ";

				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql);

				if(rset != null)
				{
					if(rset.next())
					{
						strRoomNo					=	rset.getString("room_no");
						String bedShortDesc	=	rset.getString("short_desc");
						String strStatus			=  rset.getString("CURRENT_STATUS");
						if(strStatus.equals("A"))
						{
						out.println("<script>	 	parent.frames[1].document.getElementById('frroomno').innerHTML='"+strRoomNo+"';parent.frames[1].document.getElementById('frbedclass').innerHTML='"+bedShortDesc+"';</script>");
						}
						else
						{
							out.println("<script>alert(getMessage('OCCUPIED_BED','IP')); parent.frames[1].document.forms[0].cont.value=\"N\";parent.frames[1].document.forms[0].fr_bed_no.select();  parent.frames[1].document.forms[0].fr_bed_no.focus();</script>");
						}
					}				
					else
					{
%>
							<script>
							alert(getMessage('INVALID_BED','Common'));							parent.frames[1].document.forms[0].fr_bed_no.select(); 
							parent.frames[1].document.forms[0].fr_bed_no.focus(); 	
							parent.frames[1].document.forms[0].cont.value="N";
							</script>							
	<%
					}
				}
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
			}
			}catch(Exception e){
		out.print("Exception :"+e);
		}
	finally {
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
			ConnectionManager.returnConnection(con,request);
		}
		%>

