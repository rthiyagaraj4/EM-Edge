<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="AdminRouteCategoryRoutes" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
 request.setCharacterEncoding("UTF-8");
Connection con			= null;
PreparedStatement pstmt	= null;
ResultSet rs			= null;
String select			= request.getParameter("select");
ArrayList TabList		= null;
String admin_route_categ_code=request.getParameter("admin_route_categ_code");
con = ConnectionManager.getConnection(request);
String flag				="";
String sql_associated	="";
String alphalink		="";	
String short_desc		="";	
String search_criteria	="";	
String search_text		="%";	
String code				="";
String temp_code		="";
try
{	
	if(select.equals("SELECTALL"))
	{
		flag			=	request.getParameter("flag");
		sql_associated	=	"";
		alphalink		=	request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		short_desc		=	request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
		search_criteria	=	request.getParameter("search_criteria")==null ? "":request.getParameter("search_criteria");
		alphalink		=	alphalink.trim();
		search_criteria	=	search_criteria.trim();
		
		 if(search_criteria.equals("S"))
			search_text = short_desc +"%";
		 else if(search_criteria.equals("E"))
			search_text ="%"+short_desc;
		 else if(search_criteria.equals("C"))
			search_text = "%"+short_desc+"%";
		 else
			search_text = "%";	
		if(alphalink.equals("Associated"))
		{			
			 sql_associated="SELECT a.route_code, b.route_desc short_desc,'U' db_action FROM ph_admin_route_catg_dtl a, ph_route b WHERE a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code ORDER BY 2";						
		}
		else
		{							 
			// sql_associated="select route_code, route_desc short_desc, 'I' db_action from ph_route where (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"'))                                                    or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z')                                                     or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"'                     ))) and route_code not in (select route_code from ph_admin_route_catg_dtl where admin_route_catg_code = '"+admin_route_categ_code+"') UNION ALL select a.route_code, b.route_desc short_desc, 'U' db_action from ph_admin_route_catg_dtl a, ph_route b where a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"')                                                    )or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z'                                                    ) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"'                     ))) ORDER BY 2 ";  
			   sql_associated="select route_code, route_desc short_desc, 'I' db_action from ph_route where (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"') and upper(route_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z' and upper(route_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and route_code not in (select route_code from ph_admin_route_catg_dtl where admin_route_catg_code = '"+admin_route_categ_code+"') UNION ALL select a.route_code, b.route_desc short_desc, 'U' db_action from ph_admin_route_catg_dtl a, ph_route b where a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"') and upper(route_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z' and upper(route_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"' || '"+search_text+"'))) ORDER BY 2 ";
		}
		pstmt	=		con.prepareStatement(sql_associated);
		rs	= pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next()){
				 code	=	rs.getString("route_code");		
				int index=-1;

				if(AdminRouteCategoryRoutes != null){
					for(int i=0;i<AdminRouteCategoryRoutes.getSize();i++){
						TabList=new ArrayList();
						TabList=(ArrayList)AdminRouteCategoryRoutes.getObject(i);
						temp_code=(String)TabList.get(0);
						if(temp_code.equals(code)){
							index=i;
							break;
						}
					}
					if(index != -1){
						if(!flag.equals("1"))
							AdminRouteCategoryRoutes.removeObject(index);
					}
					else{
						if(flag.equals("1")){
							TabList = new ArrayList();
							TabList.add(code);					
							AdminRouteCategoryRoutes.putObject(TabList);
						}
					}
				}	
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	else if(select.equals("SELECTONE"))
	{
		flag	=	request.getParameter("flag");
		code	=	request.getParameter("code");
		int index=-1;
		if(AdminRouteCategoryRoutes != null){
			for(int i=0;i<AdminRouteCategoryRoutes.getSize();i++){
				TabList=new ArrayList();
				TabList=(ArrayList)AdminRouteCategoryRoutes.getObject(i);
				temp_code=(String)TabList.get(0);
				index=-1;
				if(temp_code.equals(code)){
					index=i;
					break;
				}
			}
			if(index != -1){
				if(!flag.equals("1")){
					AdminRouteCategoryRoutes.removeObject(index);
				}
			}
			else{
				if(flag.equals("1")){
					TabList = new ArrayList();
					TabList.add(code);					
					AdminRouteCategoryRoutes.putObject(TabList);
				}
			}
		}
	}
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	  if(rs!=null)
		  rs.close();
	  if(pstmt!=null) 
		  pstmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
