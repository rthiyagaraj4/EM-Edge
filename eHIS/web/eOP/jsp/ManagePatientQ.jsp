<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>


<%  
    request.setCharacterEncoding("UTF-8");     
	String oper_id 		= request.getParameter("operstnid");
	String objval= request.getParameter("objval");
	String loginuser    = (String) session.getValue( "login_user" ) ;	
	String locale=(String) session.getValue( "LOCALE" ) ;	
	String spec_code =request.getParameter("spec_code")==null?"":request.getParameter("spec_code");
	String sql		= "";
	Connection con 	= null;
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	try{
	con=ConnectionManager.getConnection(request);
	String fac_id    	= (String) session.getValue( "facility_id" );
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript'>");

	sql ="SELECT a.clinic_code, a.long_desc FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and b.oper_stn_id = '"+oper_id+"' and b.manage_queue_yn = 'Y'";

		if(!spec_code.equals(""))
		{
		sql=sql+" and a.speciality_code='"+spec_code+"' ORDER BY  2";
		}else
		{
		sql=sql+"  ORDER BY  2";
		}


		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";

		if( rs != null )
		{
			while( rs.next() )
			{
				str1 = rs.getString( "long_desc" ) ;
				str2 = rs.getString( "clinic_code" );

				out.println("var element = parent.frame1.document.createElement('OPTION');"+
						"element.text = \""+str1+"\";"+
						"element.value= \""+str2+"\";"+
						"parent.frames[1].document.frames[0].document.manage_patient.Qloc.add(element);");
			}
		}		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
    
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");

	}catch(Exception e){}
	finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);	
	}
%>

