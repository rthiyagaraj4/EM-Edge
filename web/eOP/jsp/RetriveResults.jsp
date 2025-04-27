<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>

<%
	request.setCharacterEncoding("UTF-8");
	Statement stmt = null;
	ResultSet rs=null;
	Connection con= null;
	String sql="";

	try{
			String Facility_Id=(String)session.getValue("facility_id");
			String serv_code=request.getParameter("serv_code");
            String locale=(String)session.getAttribute("LOCALE");
			con=ConnectionManager.getConnection(request); 
			stmt = con.createStatement();

	if(serv_code.equals(""))
		{
		
		sql="select clinic_code,long_desc from op_clinic_lang_vw where language_id='"+locale+"' and facility_id = '"+Facility_Id+"' and eff_status='E' order by 2";
		}
	else
		{
		
		sql="select clinic_code,long_desc from op_clinic_lang_vw where  language_id='"+locale+"' and facility_id = '"+Facility_Id+"' and eff_status='E' and service_code='"+serv_code+"' order by 2";
		}

		rs = stmt.executeQuery(sql);
	
           String sStyle	=
        (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></link><script>"
		+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>";
		out.println(a1);
	%>
    <script>
    var n=parent.frames[1].document.frames[0].document.forms[0].opclinic.options.length;
    for(var i=0;i<n;i++)
    {
        parent.frames[1].document.frames[0].document.forms[0].opclinic.remove("opclinic");  
    }
    var tp ="---------- "+getLabel("Common.defaultSelect.label","Common")+" ----------";
    var opt=parent.frames[1].document.frames[0].document.createElement("OPTION");
    opt.text=tp;
    opt.value="";
    parent.frames[1].document.frames[0].document.forms[0].opclinic.add(opt);
    </script>           
    
<%  if(rs != null) {    
        while( rs.next() ) 
        {
            String str1 = rs.getString("clinic_code") ;
            String str2 = rs.getString("long_desc");
            out.println("<script>var element = parent.query_frame.document.frames[0].document.createElement('OPTION');"+
                    "element.text = \""+str2+"\";"+ 
                    "element.value= \""+str1+"\";"+
                    "parent.query_frame.document.frames[0].document.forms[0].opclinic.add(element);</script>");
        }
    }
        
  if(rs != null) rs.close();
  if(stmt != null) stmt.close();

}   
catch(Exception e)
	{
	out.println(e);
	}
finally{
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

%>



