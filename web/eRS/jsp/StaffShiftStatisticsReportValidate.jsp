<!DOCTYPE html>


<%-- JSP Page specific attributes start --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>


<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	
	String role_type	= request.getParameter( "role_type" )==null?"":request.getParameter("role_type");
	String p_staff_type	= request.getParameter( "p_staff_type" )==null?"":request.getParameter("p_staff_type");
	String p_position_code = request.getParameter( "p_position_code" )==null?"":request.getParameter("p_position_code");
	String locale = request.getParameter( "locale" )==null?"":request.getParameter("locale");
	String func_mode = request.getParameter( "func_mode" )==null?"":request.getParameter("func_mode");
	String sql			="";
	ArrayList Staff		= new ArrayList() ;
	String[] record		= null;
	String pos_code = "";
	String pos_desc = "";
		
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;

	try{
			Con = ConnectionManager.getConnection(request);
			if(func_mode.equals("Staff"))
				{
					if(role_type.equalsIgnoreCase("P"))
						{
							sql="SELECT pract_type, desc_userdef FROM am_pract_type WHERE eff_status = 'E' ORDER BY desc_userdef";
			
							pstmt=Con.prepareStatement(sql);
							rslRst = pstmt.executeQuery();
		
							while(rslRst.next())
								{
									record = new String[2];
									record[0]	=rslRst.getString("pract_type");
									record[1]	=rslRst.getString("desc_userdef");
									Staff.add(record) ;
								}
							if (pstmt != null) pstmt.close();
							if (rslRst != null) rslRst.close();
						}
					else if(role_type.equalsIgnoreCase("O"))
						{
							sql="SELECT other_staff_type, short_desc FROM am_other_staff_type WHERE eff_status = 'E' ORDER BY short_desc";
			
							pstmt=Con.prepareStatement(sql);
							rslRst = pstmt.executeQuery();
		
							while(rslRst.next())
								{
									record = new String[2];
									record[0]	=rslRst.getString("other_staff_type");
									record[1]	=rslRst.getString("short_desc");
									Staff.add(record) ;
								}
							if (pstmt != null) 
								pstmt.close();
							if (rslRst != null) 
								rslRst.close();
						}

					for( int i=0 ; i< Staff.size(); i++ ) 
						{
							String[] record1 = (String[])Staff.get(i);
							out.println( "addStaffType(\"" + record1[0] + "\",\"" + record1[1] + "\") ; " ) ;			
						}
				}
			else if(func_mode.equals("Position"))
				{

					sql="select position_code code ,position_desc description from am_position_lang_vw where eff_status = 'E'  and upper(role_type) like upper('"+role_type+"') and upper(staff_type) like upper('"+p_staff_type+"') and upper(position_code) like upper('"+p_position_code+"') and  language_id ='"+locale+"' order by position_desc";
					pstmt=Con.prepareStatement(sql);
					rslRst = pstmt.executeQuery();
	
					while(rslRst.next())
						{
							pos_code	=rslRst.getString("code");
							pos_desc	=rslRst.getString("description");
						}
					if (pstmt != null) 
						pstmt.close();
					if (rslRst != null) 
						rslRst.close();
					out.println( "addPosition(\"" + pos_code + "\",\"" + pos_desc + "\") ; " ) ;		
				}

		}catch(Exception e)
			{
				e.printStackTrace() ;
				throw e ;
			}
		finally 
			{
				if (pstmt != null) pstmt.close();
				if (rslRst != null) rslRst.close();
				ConnectionManager.returnConnection(Con,request);
			}

%>
