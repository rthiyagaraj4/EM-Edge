<!DOCTYPE html>

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
	 request.setCharacterEncoding("UTF-8"); 
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;
	Statement stmt1 = null;
	ResultSet rs1 =null;

	try
	{
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
        con = ConnectionManager.getConnection(request); 
        String encounter_id = request.getParameter( "encounter_id" ) ;
		if(encounter_id == null) encounter_id = "";
        String patient_id = request.getParameter( "patient_id" ) ;
		if(patient_id == null) patient_id = "";
        String facility_id = (String)  session.getValue ( "facility_id" ) ;
        String value = request.getParameter("value");
		if(value == null) value = "";

		if(encounter_id.equals("")) encounter_id  = (String) hash.get("encounter_id" ) ;
		if(patient_id.equals("")) patient_id =(String) hash.get("patient_id" ) ;
		if(value.equals("")) value =(String) hash.get("value");

        String sql = "";
		String str = "";
		int p_count = 0;
    %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<body class = 'message' onMouseDown='CodeArrest()' onKeyDown='lockKey()'> 
    
    <%
        if(value.equals("Patient"))
        {
            sql = "select nvl(patient_name,' ') patient_name ,nvl(ADDR1_LINE1,' ') resi_addr_line1,nvl(ADDR1_LINE2,' ') resi_addr_line2, nvl(ADDR1_LINE3,' ') resi_addr_line3, nvl(ADDR1_LINE4,' ') resi_addr_line4, nvl(CONTACT2_NO,' ') orn_tel_no, nvl(CONTACT1_NO,' ') prn_tel_no, sex , a.DECEASED_YN DECEASED_YN, a.SUSPEND_YN SUSPEND_YN ,a.ACTIVE_YN ACTIVE_YN FROM MP_PATIENT A ,MP_PAT_ADDRESSES B where A.patient_id='"+patient_id+"' and A.patient_id=B.patient_id ";
            
        boolean result = true;
            try
            {
                stmt = con.createStatement () ;
                rs = stmt.executeQuery( sql );
                if(rs!=null)
                {
                    if(rs.next())
                    {
                        if(rs.getString("DECEASED_YN").equals("Y")) {
                            result = false; 
							
							out.print("alert(getMessage('IP_DECEASED_NOT_ALLOWED','IP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
                            }
                        if(result)
                        {
                            if(rs.getString("SUSPEND_YN").equals("Y")) {
                             result  = false;
                                
                                out.print("alert(getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
                            }
                        }

						if(result)
                        {
                            if(rs.getString("ACTIVE_YN").equals("N")) {
                             result  = false;
                                 out.print("alert(getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
                            }
                        }

						if (result)
						{
							str= "select count(*) total from ip_open_encounter where facility_id='"+facility_id+"' and patient_id='"+patient_id+"' ";

							stmt1 = con.createStatement();
							rs1   = stmt1.executeQuery(str);

							while (rs1.next())
							{
								p_count = rs1.getInt("total");
							}

							if (p_count > 0)
							{
								result = false;
								
								out.print("alert(getMessage('CURRENTLY_IN_PATIENT','IP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
							}
						}
						
						String patient_name =  rs.getString("patient_name");
						String resi_addr_line1 = rs.getString("resi_addr_line1");
						String resi_addr_line2 = rs.getString("resi_addr_line2");
						String resi_addr_line3 = rs.getString("resi_addr_line3");
						String resi_addr_line4 = rs.getString("resi_addr_line4");
						String orn_tel_no = rs.getString("orn_tel_no");
						String prn_tel_no = rs.getString("prn_tel_no");
						String sex = rs.getString("sex");
						
                        if(result)
                        {
							out.print("if(document.forms[0].lodger_name){document.forms[0].lodger_name.value ='"+patient_name+"'; document.forms[0].lodger_name.readOnly= true;}");
							out.print("if(document.forms[0].reln_with_patient) document.forms[0].reln_with_patient.focus(); else document.forms[0].ln1_lodger_add.focus();");
							out.print("if(document.forms[0].ln1_lodger_add) document.forms[0].ln1_lodger_add.value ='"+resi_addr_line1.trim()+"' ;");
							out.print("if(document.forms[0].ln2_lodger_add) document.forms[0].ln2_lodger_add.value ='"+resi_addr_line2.trim()+"' ;");
							out.print("if(document.forms[0].ln3_lodger_add) document.forms[0].ln3_lodger_add.value ='"+resi_addr_line3.trim()+"';");                             
							out.print("if(document.forms[0].ln4_lodger_add) document.forms[0].ln4_lodger_add.value ='"+resi_addr_line4.trim()+"';");
							out.print("if(document.forms[0].off_tel_no) document.forms[0].off_tel_no.value ='"+orn_tel_no.trim()+"'; ");
							out.print("if(document.forms[0].res_tel_no) document.forms[0].res_tel_no.value ='"+prn_tel_no.trim()+"' ;	");
							out.print("if(document.forms[0].gender){document.forms[0].gender.value ='"+sex+"' ; document.forms[0].gender.disabled= true;}");
						%>
                         <script>
                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)
                        {
                            parent.frames[1].frames[2].document.forms[0].lodger_name.value ="<%= rs.getString("patient_name")%>" 
                            parent.frames[1].frames[2].document.forms[0].lodger_name.readOnly= true;
                        }
                           if(parent.frames[1].frames[2].document.forms[0].reln_with_patient)
                           	parent.frames[1].frames[2].document.forms[0].reln_with_patient.focus();
                           	else
                           	parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.focus();
                           	
                           if(parent.frames[1].frames[2].document.forms[0].ln1_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.value ="<%= rs.getString("resi_addr_line1").trim()%>" 
                            if(parent.frames[1].frames[2].document.forms[0].ln2_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln2_lodger_add.value ="<%= rs.getString("resi_addr_line2").trim()%>" 
                            if(parent.frames[1].frames[2].document.forms[0].ln3_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln3_lodger_add.value ="<%= rs.getString("resi_addr_line3").trim()%>" 
                            if(parent.frames[1].frames[2].document.forms[0].ln4_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln4_lodger_add.value ="<%= rs.getString("resi_addr_line4").trim()%>"
                            if(parent.frames[1].frames[2].document.forms[0].off_tel_no)
                            parent.frames[1].frames[2].document.forms[0].off_tel_no.value ="<%= rs.getString("orn_tel_no").trim()%>"
                            if(parent.frames[1].frames[2].document.forms[0].res_tel_no)
                            parent.frames[1].frames[2].document.forms[0].res_tel_no.value ="<%= rs.getString("prn_tel_no").trim()%>" 
                            if(parent.frames[1].frames[2].document.forms[0].gender)
                        {
                            parent.frames[1].frames[2].document.forms[0].gender.value ="<%= rs.getString("sex")%>" 
                            parent.frames[1].frames[2].document.forms[0].gender.disabled= true;
                        }
                      
                        </script> 
                        <%
                        }
                        else
                        { 
							
							out.print("if(document.forms[0].lodger_name){document.forms[0].lodger_name.value =''; document.forms[0].lodger_name.readOnly= false;}");
							out.print("if(document.forms[0].ln1_lodger_add) document.forms[0].ln1_lodger_add.value ='' ;");
							out.print("if(document.forms[0].ln2_lodger_add) document.forms[0].ln2_lodger_add.value ='' ;");
							out.print("if(document.forms[0].ln3_lodger_add) document.forms[0].ln3_lodger_add.value ='';");                             
							out.print("if(document.forms[0].ln4_lodger_add) document.forms[0].ln4_lodger_add.value ='';");
							out.print("if(document.forms[0].off_tel_no) document.forms[0].off_tel_no.value =''; ");
							out.print("if(document.forms[0].res_tel_no) document.forms[0].res_tel_no.value ='' ;	");
							out.print("if(document.forms[0].gender){document.forms[0].gender.value ='' ;}");
							out.print("document.forms[0].nursing_unit_desc.value=''; document.forms[0].lodger_nursing_unit.value='';");
							
							%>
                   <script>
                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)
                            parent.frames[1].frames[2].document.forms[0].lodger_name.readOnly= false;
                            
                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)
                            parent.frames[1].frames[2].document.forms[0].lodger_name.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln1_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln2_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln2_lodger_add.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln3_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln3_lodger_add.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln4_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln4_lodger_add.value =""
                            if(parent.frames[1].frames[2].document.forms[0].off_tel_no)
                            parent.frames[1].frames[2].document.forms[0].off_tel_no.value =""
                            if(parent.frames[1].frames[2].document.forms[0].res_tel_no)
                            parent.frames[1].frames[2].document.forms[0].res_tel_no.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].gender)
                            parent.frames[1].frames[2].document.forms[0].gender.value ="" 
                            
				parent.frames[1].frames[2].document.forms[0].nursing_unit_desc.value='';
				parent.frames[1].frames[2].document.forms[0].lodger_nursing_unit.value='';

                        </script> 
                    <%  }
                    }
                    else
                    {
						out.print("alert(getMessage('INVALID_PATIENT','MP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
						out.print("if(document.forms[0].lodger_name){document.forms[0].lodger_name.value =''; document.forms[0].lodger_name.readOnly= false;}");
							out.print("document.forms[0].lodger_patient_id.focus(); document.forms[0].lodger_patient_id.select(); ");
							out.print("if(document.forms[0].ln2_lodger_add) document.forms[0].ln2_lodger_add.value ='' ;");
							out.print("if(document.forms[0].ln3_lodger_add) document.forms[0].ln3_lodger_add.value ='';");                             
							out.print("if(document.forms[0].ln4_lodger_add) document.forms[0].ln4_lodger_add.value ='';");
							out.print("if(document.forms[0].off_tel_no) document.forms[0].off_tel_no.value =''; ");
							out.print("if(document.forms[0].res_tel_no) document.forms[0].res_tel_no.value ='' ;	");
							out.print("if(document.forms[0].gender){document.forms[0].gender.value ='' ;}");
							out.print("document.forms[0].nursing_unit_desc.value=''; document.forms[0].lodger_nursing_unit.value='';");
                        %>
                         <script>
                            alert(getMessage('INVALID_PATIENT','MP'));
                            
                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)
                            parent.frames[1].frames[2].document.forms[0].lodger_name.readOnly= false;
                            
                            parent.frames[1].frames[2].document.forms[0].lodger_patient_id.focus();
                            parent.frames[1].frames[2].document.forms[0].lodger_patient_id.select();

                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)
                            parent.frames[1].frames[2].document.forms[0].lodger_name.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln1_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln2_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln2_lodger_add.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln3_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln3_lodger_add.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].ln4_lodger_add)
                            parent.frames[1].frames[2].document.forms[0].ln4_lodger_add.value =""
                            if(parent.frames[1].frames[2].document.forms[0].off_tel_no)
                            parent.frames[1].frames[2].document.forms[0].off_tel_no.value =""
                            if(parent.frames[1].frames[2].document.forms[0].res_tel_no)
                            parent.frames[1].frames[2].document.forms[0].res_tel_no.value ="" 
                            if(parent.frames[1].frames[2].document.forms[0].gender)
                            parent.frames[1].frames[2].document.forms[0].gender.value ="" 
                            
                            parent.frames[1].frames[2].document.forms[0].nursing_unit_desc.value='';
                            parent.frames[1].frames[2].document.forms[0].lodger_nursing_unit.value='';
                            
                        </script> 
                        
                        <%                      
                    }
                } //end of if rs!=null
            } // end of try
            catch (Exception e)
            {
                out.println(e.toString());
            }
            finally
            {
                if(stmt != null)    stmt.close() ; 
                if(rs != null)      rs.close ();
            }
        } // end of if value.equals("Patient")
        else
        {
            if(value.equals("Bed"))
            {
                String nursing_unit = request.getParameter("nursing_unit") ;
				if(nursing_unit == null) nursing_unit = "";
				if(nursing_unit.equals("")) nursing_unit =(String) hash.get("nursing_unit") ;
                String bed_no = request.getParameter("bed_no") ;
				if(bed_no == null) bed_no = "";
				if(bed_no.equals("")) bed_no =(String) hash.get("bed_no") ;

                sql = " select count(*) from ip_nursing_unit_bed where nursing_unit_code= '"+ nursing_unit +"' and bed_no = '"+ bed_no +"' and facility_id ='"+ facility_id +"'" ;
                try
                {
                    stmt = con.createStatement () ;
                    rs = stmt. executeQuery ( sql ) ;
                    if( rs != null )
                    {
                        if(rs.next())
                        {
                            if( rs.getInt(1) == 0 )
                            {
                                  
                                out.println ( "alert(parent.parent.frames[0].getMessage('INVALID_BED','Common'));parent.frames[1].frames[2].document.forms[0].lodger_bed_no.select();parent.frames[1].frames[2].document.forms[0].lodger_bed_no.focus();" ) ;   
                            }
                        }
                    }
                } //end of try
                catch (Exception e)
                {
                    out.println(e.toString());
                }
                finally
                {
                     if(stmt != null)   stmt.close() ; 
                    if(rs != null)      rs.close ();
                }
            } // end of if value.equals("Bed")
        } // end of else part of value.equals("Patient")
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
    finally
    {
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		if(stmt1 != null) stmt1.close();
		if(rs1 != null) rs1.close();

		ConnectionManager.returnConnection(con,request);
    }
    %>
 </body>
</html> 
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

