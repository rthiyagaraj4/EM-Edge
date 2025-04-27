<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");	
	String lang_id = request.getParameter("language_id");
	String UserId  = (String)session.getValue("login_user");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String cssName = (request.getParameter("cssName")==null || request.getParameter("cssName")=="")?"IeStyle":request.getParameter("cssName");
int result=0;
	Connection con =null;
	//String short_name="";
	//PreparedStatement pstmt=null ;
	PreparedStatement  pstmt=null;
	//ResultSet reset=null;

	 try{
			con = ConnectionManager.getConnection(request);
			if(lang_id.equals("bu")){
				if(!cssName.contains("_bu")){
					cssName	= cssName+"_bu.css";
				}else{
					cssName	= cssName+".css";
				}
			}else{
				if(cssName.contains("_bu")){
					cssName	= cssName.replace("_bu",".css");
				}else{
					cssName	= cssName+".css";
				}
			}
		
			pstmt = con.prepareStatement("Update sm_appl_user set language_id=?,preferred_style='"+cssName+"' where appl_user_id=?");
						pstmt.setString(1,lang_id);
						pstmt.setString(2,UserId);
						
					result=pstmt.executeUpdate();
						con.commit();
						session.setAttribute("PREFERRED_STYLE",cssName);

			String sql = "select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+UserId+"' and language_id = '"+lang_id+"'" ;

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql) ;
				if(rs != null){
					if(rs.next()){
						session.setAttribute("appl_user_name",rs.getString("appl_user_name"));
					}
					rs.close();
				}

			sql = "select facility_name from sm_facility_param_lang_vw where facility_Id = '"+(String)session.getAttribute("facility_id")+"' and language_id = '"+lang_id+"'";
			rs = stmt.executeQuery(sql) ;
				if(rs != null){
					if(rs.next()){
						session.setAttribute("facility_name",rs.getString("facility_name"));
					}
					stmt.close();
					rs.close();
			}

			javax.servlet.jsp.jstl.core.Config.set(session, javax.servlet.jsp.jstl.core.Config.FMT_LOCALE, lang_id);
			javax.servlet.jsp.jstl.core.Config.set(session, javax.servlet.jsp.jstl.core.Config.FMT_FALLBACK_LOCALE, "en");

			session.putValue("LOCALE",lang_id) ;
			Properties p = (Properties)session.getAttribute("jdbc");
			p.setProperty("LOCALE", lang_id);
			session.putValue("jdbc", p);
			/* Added By Vinod - 6/23/2006 10:08 AM
				To remove Thai charset from session for English Language Interface
			*/
			if ( session.getAttribute("javax.servlet.jsp.jstl.fmt.locale.session") != null )
			{
				String val = (String)session.getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
				if (val.equalsIgnoreCase("en"))
				{
					if ( ( session.getAttribute("javax.servlet.jsp.jstl.fmt.request.charset") != null )  && 
						 ( ((String)session.getAttribute("javax.servlet.jsp.jstl.fmt.request.charset")).equalsIgnoreCase("TIS-620") ) )
					{
						  session.removeAttribute("javax.servlet.jsp.jstl.fmt.request.charset");
					}
				}
			}
for (java.util.Enumeration sessionVaules=session.getAttributeNames(); sessionVaules.hasMoreElements();){
	String name = (String)sessionVaules.nextElement();
	//Object value = session.getAttribute(name);					

}


			if (pstmt != null) pstmt.close();
			if (called_from.equals("CA_PATIENT_CHART"))
			{
				String  ca_practitioner_id =(String)session.getAttribute("ca_practitioner_id");
				pstmt = con.prepareStatement("SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID = ? AND LANGUAGE_ID = ?");
				pstmt.setString(1,ca_practitioner_id);
				pstmt.setString(2,lang_id);
				rs = pstmt.executeQuery();
				if(rs!= null && rs.next())
				{
					session.putValue("practitioner_name",rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME"));
				}
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			}
		}catch(Exception e) { 
			out.println(e.toString());
			e.printStackTrace();
		}
		 finally{ if(con!=null) ConnectionManager.returnConnection(con,request);	}
%>
