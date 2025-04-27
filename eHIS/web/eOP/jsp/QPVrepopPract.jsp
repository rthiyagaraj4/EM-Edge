<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con  =  null;
	ResultSet rs = null;
	Statement stmt = null;
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

try{

	String Facility_Id=(String)session.getValue("facility_id");
    String cln_code=request.getParameter("cln_code");
    String pract_yn=request.getParameter("pract_yn");
    String pract_type=request.getParameter("pract_type");
    StringBuffer sql = new StringBuffer();
    String locale = (String) session.getValue("LOCALE");
	con  =  ConnectionManager.getConnection(request);
	stmt = con.createStatement();

    if(pract_type.equals("null")) pract_type="";
    if(cln_code.equals(""))
		{
       // sql.append("select practitioner_id,practitioner_name,pract_type from am_pract_for_facility_vw where operating_facility_id = '"+Facility_Id+"' and eff_status='E' order by 2");
		sql.append(" SELECT   a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name,		  pract_type	FROM 	  am_pract_for_facility a,am_practitioner b		WHERE 	  facility_id ='"+Facility_Id+"' AND a.practitioner_id=b.practitioner_id AND	 a.eff_status='E'			ORDER BY 2");
		
		}
	else 
        if(pract_yn.equals("Y"))
		{
            sql.append( "select b.practitioner_id,b.practitioner_name,b.pract_type from am_pract_for_facility a,am_practitioner b, op_clinic c ");
            sql.append( "where a.practitioner_id=b.practitioner_id and b.pract_type=c.pract_type(+) and c.clinic_code = '"+cln_code+"' ");
            sql.append( "and b.pract_type=nvl('"+pract_type+"',b.pract_type) and a.facility_id='"+Facility_Id+"' and a.eff_status='E' order by 2");
        }
        else {
            sql.append( "select b.practitioner_id,b.practitioner_name,b.pract_type from op_pract_for_clinic a,am_practitioner b ");
            sql.append("where a.clinic_code = '"+cln_code+"' ");
            sql.append("and b.pract_type=nvl('"+pract_type+"',b.pract_type) and ");
            sql.append("b.practitioner_id = a.practitioner_id and ");
            sql.append("a.facility_id='"+Facility_Id+"' and a.eff_status='E' order by 2");
           
        }
       
    rs = stmt.executeQuery(sql.toString());
    String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
    +"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>";
    out.println(a1);

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
    
<%  if(rs != null) {    
        while( rs.next() ) 
        {
            String str1 = rs.getString("practitioner_id") ;
            String str2 = rs.getString("practitioner_name");
            out.println("<script>var element = parent.frames[1].document.frames[0].document.createElement('OPTION');"+
                    "element.text = \""+str2+"\";"+ 
                    "element.value= \""+str1+"\";"+
                    "parent.frames[1].document.frames[0].document.forms[0].oppract .add(element);</script>");
        }
    }

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	
	sql.setLength(0);
        
}
catch(Exception e){
	out.println(e);
}
finally{
	try{
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
	}catch(Exception e){}
	if(con!=null) ConnectionManager.returnConnection(con,request); 
}
%>




