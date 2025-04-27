<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>


<%
	request.setCharacterEncoding("UTF-8");
	Connection con  = null;
    Statement stmt = null;
    ResultSet rs = null;
	Statement stmt1 = null;
    ResultSet rs1 = null;

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


try{
	con  =  ConnectionManager.getConnection(request);
    stmt = con.createStatement();
    stmt1 = con.createStatement();
    
	String Facility_Id=(String)session.getValue("facility_id");
    String serv_code=request.getParameter("serv_code");   
	String locale = (String) session.getValue("LOCALE");
    String sql="";
    String sql1="";
    
    if(serv_code.equals("")) {
        sql="select clinic_code,long_desc ,open_to_all_pract_yn,pract_type  from op_clinic_lang_vw where facility_id = '"+Facility_Id+"' and eff_status='E' and language_id ='"+locale+"' order by 2";
       sql1= "SELECT    a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name,                pract_type     FROM  am_pract_for_facility a,am_practitioner b   WHERE   facility_id = '"+Facility_Id+"' AND a.practitioner_id=b.practitioner_id AND   a.eff_status='E'    ORDER BY 2";
	   	
		//sql1="select practitioner_id,practitioner_name,pract_type from am_pract_for_facility_vw where operating_facility_id = '"+Facility_Id+"' and eff_status='E' order by 2";
        rs1= stmt1.executeQuery(sql1);
        rs = stmt.executeQuery(sql);
    
	
	
	}
    else {
        sql="select clinic_code,long_desc ,open_to_all_pract_yn,pract_type  from op_clinic_lang_vw where facility_id = '"+Facility_Id+"' and eff_status='E' and service_code='"+serv_code+"' and language_id='"+locale+"' order by 2";
        rs = stmt.executeQuery(sql);
    }
    
    
    String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
    +"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>";
    out.println(a1);

    %>
    <script>
    var n=parent.frames[1].document.frames[0].document.forms[0].oplocation.options.length;
    for(var i=0;i<n;i++)
    {
        parent.frames[1].document.frames[0].document.forms[0].oplocation.remove("oplocation");  
    }
    var tp =" --- "+getLabel('Common.defaultSelect.label','Common')+" --- ";
    var opt=parent.frames[1].document.frames[0].document.createElement("OPTION");
    opt.text=tp;
    opt.value="";
    parent.frames[1].document.frames[0].document.forms[0].oplocation.add(opt);
    </script>

    <%
    if(serv_code.equals("")) { 
    %>
    <script>
    var n=parent.frames[1].document.frames[0].document.forms[0].oppract.options.length;
    for(var i=0;i<n;i++)
    {
        parent.frames[1].document.frames[0].document.forms[0].oppract.remove("oppract");
    }
    var tp =" --- "+getLabel('Common.defaultSelect.label','Common')+" --- ";
    var opt=parent.frames[1].document.frames[0].document.createElement("OPTION");
    opt.text=tp;
    opt.value="";
    parent.frames[1].document.frames[0].document.forms[0].oppract.add(opt);
    </script>
    <% } 
    if(rs != null) {
        while( rs.next() )
        {
            String str1 = rs.getString("clinic_code");
            String str2 = rs.getString("long_desc");
            String str3 = rs.getString("open_to_all_pract_yn");
            String str4 = rs.getString("pract_type");
            out.println("<script>var element = parent.frames[1].document.frames[0].document.createElement('OPTION');"+
                    "element.text = \""+str2+"\";"+ 
                    "element.value= '"+str1+"|"+str3+"|"+str4+"';"+
                    "parent.frames[1].document.frames[0].document.forms[0].oplocation.add(element);</script>");
        }
    }

	if(rs != null) rs.close();

    if(serv_code.equals("")) { 
        if(rs1 != null) {
            while( rs1.next() )
            {
                String str1 = rs1.getString("practitioner_id") ;
                String str2 = rs1.getString("practitioner_name");
                out.println("<script>var element = parent.frames[1].document.frames[0].document.createElement('OPTION');"+
                            "element.text = \""+str2+"\";"+ 
                            "element.value= \""+str1+"\";"+
                            "parent.frames[1].document.frames[0].document.forms[0].oppract .add(element);</script>");
            }
        }
		if(rs1 != null) rs1.close();
    }
        
}   
catch(Exception e){
 out.println(e);
}
finally{
if(stmt!=null)stmt.close();
if(rs!=null)rs.close();
if(stmt1!=null)stmt1.close();
if(rs1!=null)rs1.close();
if(con!=null) ConnectionManager.returnConnection(con,request); 
}

%>



