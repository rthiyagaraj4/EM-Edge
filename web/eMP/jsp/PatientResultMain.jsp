<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String locale			= (String)session.getAttribute("LOCALE");
String logged_facility = (String) session.getValue("facility_id");
String resp_name = (String) session.getValue("responsibility_name");
Connection conn = ConnectionManager.getConnection(request);
java.sql.Statement stmt = conn.createStatement();
java.sql.Statement stmt_new = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
PreparedStatement pstmt_new = null;
ResultSet rsnew = null;
java.sql.Statement stmt_7 = conn.createStatement();
java.sql.Statement stmt8=conn.createStatement();
java.sql.Statement stmtx=conn.createStatement();
java.sql.Statement stmtk=conn.createStatement();
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
ResultSet rs4=null;
ResultSet rs5=null;
ResultSet rs6=null;
ResultSet rs7=null;
ResultSet rsx=null;
ResultSet rsk=null;

String union_sql = "";  
String union_main_sql = ""; 
String valid_values_sql = "";
String valid_values_sql_d = "";
String op_install_yn="N";
String ip_install_yn="N";
String valid_patient_id = "";

int TotalNoRecords = 0;

String TotalNoRec=request.getParameter("TotalNoRecords");
if (TotalNoRec==null) TotalNoRec="0";

TotalNoRecords = Integer.parseInt(TotalNoRec);

int percent=0;
int totalpercent=100; 
int patient_id_length=0;

double maxDisplay = 0;
double maxDisplay1 = 0;
int searchThreshold = 11;

String allow_nb_review="N";
String sql;
String photo[]=null;

double Hit=0;
double Hit_for_buttons=0;

String mode = "";
String view_pat_photo_yn = "N";
//outer try to close connections
try{
try
{

try
    {
        rsk=stmtk.executeQuery("select review_nb_links_bef_reg_yn, patient_id_length  from mp_param");
        if(rsk.next())
		{
            allow_nb_review=rsk.getString(1);
			patient_id_length=rsk.getInt(2);
		}
    }
catch(Exception e)
    {
        allow_nb_review="N";
       // out.println("Exception : "+e);
	   e.printStackTrace();
    }
    finally
    {
        if(rsk!=null)rsk.close();
		if (stmtk!=null) stmtk.close();
    }
rsx=stmtx.executeQuery("select nvl(install_yn,'N') from sm_module where module_id='OP'");
if(rsx.next())
    {
        op_install_yn=rsx.getString(1);
        if(op_install_yn==null)op_install_yn="N";
    }

rsx=stmtx.executeQuery("select nvl(install_yn,'N') from sm_module where module_id='IP'");
if(rsx.next())
    {
        ip_install_yn=rsx.getString(1);
        if(ip_install_yn==null)ip_install_yn="N";
    }

mode = request.getParameter("mode");
if(mode==null || mode.equals("null")) mode = "";
}catch (Exception e)
{
    //out.println("exception "+e);
	e.printStackTrace();
} 

String countsql = request.getParameter("countSQL");
if (countsql==null) countsql = "";

String countsql1= "";
if (countsql.indexOf("^") >=0)
    countsql = countsql.replace('^','%');
    
	
//Added for including pref facility id in the select if pref facility is not selected as part of result
String cntPrefFac = request.getParameter("cntPrefFac");
if (cntPrefFac==null || cntPrefFac.equals("null")) cntPrefFac = "0";

String usePatIDIndex =request.getParameter("usePatIDIndex");
if (usePatIDIndex==null || usePatIDIndex.equals("null")) usePatIDIndex = "N";

String from = request.getParameter( "From" );

String to = request.getParameter( "To" );

String orderby =  request.getParameter( "orderby" );

String enablegenderyn = request.getParameter( "enablegenderyn" );
if (enablegenderyn==null) enablegenderyn = "Y";
String jsp_name =  request.getParameter( "jsp_name" );
if (jsp_name==null || jsp_name.equals("null")) jsp_name = "";
String p_no =  request.getParameter("p_no");
String na_no =  request.getParameter( "na_no" );
if (na_no==null || na_no.equals("null")) na_no = "";
String win_height   =request.getParameter("win_height");
String win_width    =request.getParameter("win_width");
String win_top      =request.getParameter("win_top");
String srr = request.getParameter("srr");
String func_act = request.getParameter("func_act");
if (func_act == null || func_act.equals("null")) func_act = "";

String func_idpassed = request.getParameter("func_idpassed");
if (func_idpassed == null || func_idpassed.equals("null")) func_idpassed = "";

String old_file_no_where = request.getParameter("old_file_no_where");
if (old_file_no_where==null || old_file_no_where.equals("null")) old_file_no_where = "";
String file_no_where = request.getParameter("file_no_where");
if (file_no_where==null || file_no_where.equals("null")) file_no_where = "";

String dr_file_no_where = "";
String main_select_sql  = "";
String main_select_sql_both  = "";
String j_mrn_where1 = "";
String j_mrn_where2 = "";

if(old_file_no_where !=null)
{
    if(!old_file_no_where.equals(""))
        old_file_no_where=" and "+old_file_no_where;
}
else
    old_file_no_where ="";  
        
if(file_no_where !=null)
{
    if(!file_no_where.equals(""))
        file_no_where=" and "+file_no_where;
}
else
    file_no_where ="";


String maxDisp = request.getParameter("maxdisplay");
String maxDisp1 = request.getParameter("maxdisplay1");

if (maxDisp==null ||maxDisp.equals("0.0")) maxDisp = "0";
if (maxDisp1==null ||maxDisp1.equals("0.0")) maxDisp1 = "0";

maxDisplay = Integer.parseInt(maxDisp);
maxDisplay1 = Integer.parseInt(maxDisp1);




String j_select     =request.getParameter("j_select");

String j_new_select =  request.getParameter( "j_new_select" );

String j_from       =request.getParameter("j_from");
String apply_oth_name =  request.getParameter("apply_oth_name");
String alignment =  (apply_oth_name == null ||  apply_oth_name.equals("null")) ?"left" : "left" ;
String othlang = (apply_oth_name == null ||  apply_oth_name.equals("null")) ?"N" : "Y" ;
if (j_select==null || j_select.equals("null")) j_select = "";
if (j_new_select==null || j_new_select.equals("null")) j_new_select = "";
if (j_from==null || j_from.equals("null")) j_from = "";

String j_where      = request.getParameter("j_where");

if (j_where==null || j_where.equals("null")) j_where = "";
String j_where_dr       = request.getParameter("j_where_dr");
if (j_where_dr==null || j_where_dr.equals("null")) j_where_dr = "";
String j_where_dr_valid     = request.getParameter("j_where_dr_valid");
if (j_where_dr_valid==null || j_where_dr_valid.equals("null")) j_where_dr_valid = "";
String j_where_addl_field       = request.getParameter("j_where_addl_field");
if (j_where_addl_field==null || j_where_addl_field.equals("null")) j_where_addl_field = "";
String j_where_addl_field_dr    = request.getParameter("j_where_addl_field_dr");
if (j_where_addl_field_dr==null || j_where_addl_field_dr.equals("null")) j_where_addl_field_dr = "";
String j_where_addl_field_dr_valid  = request.getParameter("j_where_addl_field_dr_valid");
if (j_where_addl_field_dr_valid==null || j_where_addl_field_dr_valid.equals("null")) j_where_addl_field_dr_valid = "";

String search_in = request.getParameter("search_in");
if (search_in==null || search_in.equals("") || search_in.equals("null")) search_in = "P";


//Added by kumar on 8/3/2002 for DR functions.
String function_id      = request.getParameter("function_id");


if (function_id==null || function_id.equals("null") || function_id.equals("")) function_id = "";

String dr_merge_valid = request.getParameter("dr_merge_valid");
if (dr_merge_valid==null || dr_merge_valid.equals("null") || dr_merge_valid.equals("")) dr_merge_valid = "";

int drpos = 0;
int drpos1 = 0;
String MRN="";
String OldFileNo="";

String continue_yn = "Y";

MRN=request.getParameter("MRN");
if (MRN==null || MRN.equals("null")) MRN="";
OldFileNo=request.getParameter("OldFileNo");
if (OldFileNo==null || OldFileNo.equals("null")) OldFileNo="";

//Added by kumar on 7/3/2002 if file no specified as criteria.
if(!(MRN.equals("")) || !(OldFileNo.equals("")))
{

	if (!OldFileNo.equals(""))
    {
        if (j_where.equals(""))
        {
            if (!MRN.equals(""))
            {
                j_where = " where A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
                j_where_dr = j_where;
                dr_file_no_where = " and file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"'";
                j_mrn_where1 = " where A.duplicate_patient_id = (select duplicate_patient_id from dr_mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
                j_mrn_where2 = " where B.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
            }
            else
            {
                j_where = " where A.patient_id in (select patient_id from mr_pat_file_index where old_file_no = '"+OldFileNo+"')";          
                j_where_dr = j_where;
                dr_file_no_where = " and old_file_no = '"+OldFileNo+"'";
                j_mrn_where1 = " where A.duplicate_patient_id in (select duplicate_patient_id from dr_mr_pat_file_index where old_file_no = '"+OldFileNo+"')";           
                j_mrn_where2 = " where B.patient_id in (select patient_id from mr_pat_file_index where old_file_no = '"+OldFileNo+"')";         
            }
        }
        else
        {
            j_mrn_where1 = j_where_dr;
            j_mrn_where2 = j_where_dr_valid;
            if (!MRN.equals(""))
            {
                j_where = j_where +" and A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
                j_where_dr = j_where_dr +" and A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
                dr_file_no_where = " and file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"'";
                j_mrn_where1 = j_mrn_where1 +" and A.duplicate_patient_id = (select duplicate_patient_id from dr_mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
                j_mrn_where2 = j_mrn_where2 +" and B.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"')";
            }
            else
            {
                j_where = j_where +" and A.patient_id in (select patient_id from mr_pat_file_index where old_file_no = '"+OldFileNo+"')";
                j_where_dr = j_where_dr +" and A.patient_id in (select patient_id from mr_pat_file_index where old_file_no = '"+OldFileNo+"')";
                dr_file_no_where = " and old_file_no = '"+OldFileNo+"'";
                j_mrn_where1 = j_mrn_where1 +" and A.duplicate_patient_id in (select duplicate_patient_id from dr_mr_pat_file_index where old_file_no = '"+OldFileNo+"')";
                j_mrn_where2 = j_mrn_where2 +" and B.patient_id in (select patient_id from mr_pat_file_index where old_file_no = '"+OldFileNo+"')";
            }
        }
    }
    else
    {
        if (j_where.equals(""))
        {
            j_where = " where A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"')";
            j_where_dr = " where A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"')";
            j_mrn_where1 = " where A.duplicate_patient_id = (select duplicate_patient_id from dr_mr_pat_file_index where file_no = '"+MRN+"')";
            j_mrn_where2 = " where B.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"')";
        }
        else
        {
            j_mrn_where1 = j_where_dr;
            j_mrn_where2 = j_where_dr_valid;
            j_where = j_where +" and A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"')"; 
            j_mrn_where1 = j_mrn_where1 +" and A.duplicate_patient_id = (select duplicate_patient_id from dr_mr_pat_file_index where file_no = '"+MRN+"')";  
            j_mrn_where2 = j_mrn_where2 +" and B.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"')";    
        }
    }
}
else
{
    j_mrn_where1 = j_where_dr;
    
        
	if (!search_in.equals("D")&&(function_id.equals("") || function_id.equals("PAT_REG") ||func_act.equals("DuplicateRegistration") || 	function_id.equals("NEWBORN_REG")))
	{
		pstmt_new = conn.prepareStatement("select valid_patient_id from dr_mp_patient where duplicate_patient_id = ?");
		pstmt_new.setString(1,p_no);
		rsnew = pstmt_new.executeQuery();
		if (rsnew.next())
			valid_patient_id = rsnew.getString("valid_patient_id");
		if (valid_patient_id==null) valid_patient_id = "";
		if (search_in.equals("P") && !valid_patient_id.equals(""))
		{
			out.println("<script>");
			out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
			out.println("parent.frames[2].document.forms[0].Search.disabled = false;");
			out.println("if(parent.frames[1].document.forms[0].maintain_doc_or_file.value == 'D') {");
			out.println("parent.frames[1].document.forms[0].MRN.disabled = true;");
			out.println("parent.frames[1].document.forms[0].OldFileNo.disabled = true; }");
			out.println("parent.document.frames[1].enableRegister()");
			out.println("</script>");
			if (enablegenderyn.equals("N"))	
				out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");
			if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || 										function_id.equals("DR_ENTER_DUPLICATES") || 												function_id.equals("DR_MERGED_PATIENT_ID") || 												function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| 										function_id.equals("DR_EXCLUDED_PATIENT_ID"))
				out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");
			
			//Added by kumar on 16/03/2003 for disabling the searchby when soundex is selected.
			out.println("<script>if (parent.frames[1].document.forms[0].searchby !=null) if (parent.frames[1].document.forms[0].searchby.value =='') parent.frames[1].document.forms[0].searchby.disabled=true;</script>");
			out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");			
			out.println("<script>var msg = parent.frames[1].getMessage('PAT_MERGED_VALID','MP');msg= msg.replace('#','"+valid_patient_id+"');alert(msg);</script>");			out.println("<script>parent.frames[1].document.forms[0].Patient_Id.value='"+valid_patient_id+"';parent.frames[2].document.forms[0].Search.focus();</script>");
			continue_yn = "N";			
		}
		
		if (!p_no.equals("") && !valid_patient_id.equals("") && dr_merge_valid.equals(""))
		{			
			j_where_dr_valid = j_where_dr_valid.substring(0,j_where_dr_valid.indexOf(p_no))+valid_patient_id+j_where_dr_valid.substring(j_where_dr_valid.indexOf(p_no)+p_no.length());
			dr_merge_valid = j_where_dr_valid;
		}
	    j_mrn_where2 = j_where_dr_valid;
	}
}
 //End of File No condition
if (continue_yn.equals("Y"))
{

if (countsql==null || countsql.equals("null")) countsql = "";

if (j_where==null || j_where.equals("null")) j_where = "";
if (j_where_dr==null || j_where_dr.equals("null")) j_where_dr = "";
if (j_where_dr_valid==null || j_where_dr_valid.equals("null")) j_where_dr_valid = "";
if (j_where_addl_field==null || j_where_addl_field.equals("null")) j_where_addl_field = "";
if (j_where_addl_field_dr==null || j_where_addl_field_dr.equals("null")) j_where_addl_field_dr = "";
if (j_where_addl_field_dr_valid==null || j_where_addl_field_dr_valid.equals("null")) j_where_addl_field_dr_valid = "";

j_where = j_where.replace('^','%');

j_where_dr = j_where_dr.replace('^','%');
j_where_dr_valid = j_where_dr_valid.replace('^','%');
j_where_addl_field = j_where_addl_field.replace('^','%');
j_where_addl_field_dr = j_where_addl_field_dr.replace('^','%');
j_where_addl_field_dr_valid = j_where_addl_field_dr_valid.replace('^','%');

if (j_mrn_where1==null || j_mrn_where1.equals("null")) j_mrn_where1 = "";
if (j_mrn_where2==null || j_mrn_where2.equals("null")) j_mrn_where2 = "";

j_mrn_where1 = j_mrn_where1.replace('^','%');
j_mrn_where2 = j_mrn_where2.replace('^','%');


//For Facility Name 

//For Multiple MRNS
String j_mrn_select = "";
String j_mrn_select_dup = "";
String j_mrn_new_select = ""; 
String j_mrn_new_select_dup = ""; 
String j_mrn_from = ""; 
String j_mrn_from_dup = ""; 
String j_mrn_where = "";
String full_sql = "";

//For Multiple MRNS
int pos=0;
int pos1=0;
int pos2= 0;
String tsql ="";
while (j_select.indexOf("B.",pos)>=0)
{
    pos1 = j_select.indexOf("B.", pos);
    tsql = tsql + j_select.substring(pos, pos1);
    pos2 = j_select.indexOf(",", pos1);
    tsql = tsql +"' ' "+j_select.substring(pos1+2, pos2);
    pos = pos2;
}
tsql = tsql + j_select.substring(pos);
j_select = tsql;
full_sql = "select"+j_select + " "+j_from+" "+j_where;
j_mrn_select = j_select;     
j_mrn_new_select = j_new_select ; 

j_mrn_from = j_from;       
j_mrn_where = j_where; 
j_mrn_new_select = j_mrn_new_select.toUpperCase();

j_mrn_select_dup = j_mrn_select.toUpperCase();
j_mrn_from_dup = j_mrn_from.toUpperCase();


// Added by kumar on 5/3/2002. Query constructed based on the crieteria. table mr_pat_file_index is not used in the main select
String j_mrn_new_select_outermost  = "";
String j_mrn_new_select_outermost_dup  = "";
String j_mrn_new_select_outermost1  = "";
String mrnwhere = "";
String mrnaccessyn="";
if(!MRN.equals("") || !OldFileNo.equals(""))
    mrnwhere = " and file_no = '"+MRN+"'";


if (search_in.equals("P"))
{
	
	j_mrn_new_select_outermost  = j_mrn_new_select; 
	//ADDED FOR FINE TUNING ON 02/10/2002. TO BE DONE FOR OTHER QUERIES. NOW DONE ONLY FOR SEARCH IN EQUALS PATIENTS MASTER

	if (j_mrn_new_select.indexOf("DATE_OF_BIRTH")>=0)
	{
		pos = j_mrn_new_select.indexOf("DATE_OF_BIRTH");
	    j_mrn_new_select = j_mrn_new_select.substring(0, pos)+ "TO_CHAR(DATE_OF_BIRTH, 'DD/MM/YYYY')  DATE_OF_BIRTH"+j_mrn_new_select.substring(pos+13);
	}
	if (j_mrn_new_select.indexOf("ALT_ID1_EXP_DATE")>=0)
	{
		pos = j_mrn_new_select.indexOf("ALT_ID1_EXP_DATE");
	    j_mrn_new_select = j_mrn_new_select.substring(0, pos)+ "TO_CHAR(ALT_ID1_EXP_DATE, 'DD/MM/YYYY')  ALT_ID1_EXP_DATE"+j_mrn_new_select.substring(pos+16);
	}
	//END OF ADDITION
    int addl_pos = 0;
    if (j_mrn_new_select_outermost.indexOf("ADDL_FIELD1",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("ADDL_FIELD1",0);

        j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+" "+j_mrn_new_select_outermost.substring(addl_pos);

    }
    if (j_mrn_new_select_outermost.indexOf("ADDL_FIELD2",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("ADDL_FIELD2",0);
        j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+" "+j_mrn_new_select_outermost.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost.indexOf("ADDL_FIELD3",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("ADDL_FIELD3",0);
        j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+" "+j_mrn_new_select_outermost.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost.indexOf("ADDL_FIELD4",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("ADDL_FIELD4",0);
        j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+" "+j_mrn_new_select_outermost.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost.indexOf("ADDL_FIELD5",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("ADDL_FIELD5",0);
        j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+" "+j_mrn_new_select_outermost.substring(addl_pos);
    } 
	
    if (j_mrn_new_select_outermost.indexOf("MOTHER_PATIENT_NAME",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("MOTHER_PATIENT_NAME",0);

        j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+"(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+j_mrn_new_select_outermost.substring(addl_pos);
    }   
	 
  if (j_mrn_new_select_outermost.indexOf("DOC_NUM",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("DOC_NUM",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+"(select doc1_num from mp_pat_documents where patient_id = a.patient_id) "+j_mrn_new_select_outermost.substring(addl_pos);
    }
	if (j_mrn_new_select_outermost.indexOf("DOC_TYPE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("DOC_TYPE",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos-3)+"(select short_Desc from mp_document_type_LANG_VW  where language_id = '"+locale+"' and doc_type in(select doc1_type from mp_pat_documents where patient_id = a.patient_id)) "+j_mrn_new_select_outermost.substring(addl_pos);
    }

	//added for Patient Category
  if (j_mrn_new_select_outermost.indexOf("PAT_CAT_CODE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("PAT_CAT_CODE",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos)+"(select short_Desc from mp_pat_category_LANG_VW where  language_id = '"+locale+"' and PAT_CAT_CODE in(select PAT_CAT_CODE from mp_patient where patient_id = a.patient_id)) "+j_mrn_new_select_outermost.substring(addl_pos);
    }
	//
 //added for Organization Main
  if (j_mrn_new_select_outermost.indexOf("FAMILY_ORG_ID",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("FAMILY_ORG_ID",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos)+"(select  FAMILY_ORG_NAME from MP_FAMILY_ORG_LANG_VW where language_id = '"+locale+"' and FAMILY_ORG_ID in(select FAMILY_ORG_ID from mp_patient where patient_id = a.patient_id)) "+j_mrn_new_select_outermost.substring(addl_pos);
    }
	//
	//added for Organization SubUnit
  if (j_mrn_new_select_outermost.indexOf("FAMILY_ORG_SUB_ID",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("FAMILY_ORG_SUB_ID",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos)+"(select  family_org_sub_name from mp_family_org_sub_LANG_VW where language_id = '"+locale+"' and family_org_sub_id in(select family_org_sub_id from mp_patient where patient_id = a.patient_id) and family_org_id in(select FAMILY_ORG_ID from mp_patient where patient_id = a.patient_id))  "+j_mrn_new_select_outermost.substring(addl_pos);
    }
	//
		//added for RelationShip
	 if (j_mrn_new_select_outermost.indexOf("RELATIONSHIP_TO_HEAD",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("RELATIONSHIP_TO_HEAD",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos)+"(select  short_desc from mp_relationship_LANG_VW  where language_id = '"+locale+"' and relationship_code in(select relationship_to_head from mp_patient where patient_id = a.patient_id)) "+j_mrn_new_select_outermost.substring(addl_pos);
    }
 
	//
	//added for other alt id
	if (j_mrn_new_select_outermost.indexOf("OTH_ALT_ID_TYPE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("OTH_ALT_ID_TYPE",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos)+"(select long_desc from mp_alternate_id_type_LANG_VW where language_id = '"+locale+"' and alt_id_type = a.oth_alt_id_type) "+j_mrn_new_select_outermost.substring(addl_pos);
    }
	//added for PAT_SER_GRP_CODE
		if (j_mrn_new_select_outermost.indexOf("PAT_SER_GRP_CODE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost.indexOf("PAT_SER_GRP_CODE",0);
		j_mrn_new_select_outermost = j_mrn_new_select_outermost.substring(0,addl_pos)+"mp_get_desc.MP_PAT_SER_GRP(pat_ser_grp_code,'"+locale+"',2) "+j_mrn_new_select_outermost.substring(addl_pos);
    }

}
else if (search_in.equals("D"))
{
    
	j_mrn_new_select_dup =  j_mrn_new_select;
    String indexval = "PATIENT_ID";
	//ADDED FOR FINE TUNING ON 02/10/2002. TO BE DONE FOR OTHER QUERIES. NOW DONE ONLY FOR SEARCH IN EQUALS PATIENTS MASTER
	if (j_mrn_new_select_dup.indexOf("DATE_OF_BIRTH")>=0)
	{
		pos = j_mrn_new_select_dup.indexOf("DATE_OF_BIRTH");
	    j_mrn_new_select_dup = j_mrn_new_select_dup.substring(0, pos)+ "TO_CHAR(DATE_OF_BIRTH, 'DD/MM/YYYY')  DATE_OF_BIRTH"+j_mrn_new_select_dup.substring(pos+13);
	}
	if (j_mrn_new_select_dup.indexOf("ALT_ID1_EXP_DATE")>=0)
	{
		pos = j_mrn_new_select_dup.indexOf("ALT_ID1_EXP_DATE");
	    j_mrn_new_select_dup = j_mrn_new_select_dup.substring(0, pos)+ "TO_CHAR(ALT_ID1_EXP_DATE, 'DD/MM/YYYY')  ALT_ID1_EXP_DATE"+j_mrn_new_select_dup.substring(pos+16);
	}
	//END OF ADDITION    
    
    if (j_mrn_new_select_dup.indexOf(indexval)>=0)
    {           
        drpos = j_mrn_new_select_dup.indexOf(indexval);     
        j_mrn_new_select_dup = j_mrn_new_select_dup.substring(0,drpos)+"DUPLICATE_"+j_mrn_new_select_dup.substring(drpos);
    }

    j_mrn_new_select_outermost_dup  = j_mrn_new_select; 
    int addl_pos = 0;
    if (j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD1",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD1",0);
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select addl_field1 from dr_mp_pat_oth_dtls where duplicate_patient_id = a.duplicate_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD2",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD2",0);
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select addl_field2 from dr_mp_pat_oth_dtls where duplicate_patient_id = a.duplicate_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD3",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD3",0);
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select addl_field3 from dr_mp_pat_oth_dtls where duplicate_patient_id = a.duplicate_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD4",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD4",0);
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select addl_field4 from dr_mp_pat_oth_dtls where duplicate_patient_id = a.duplicate_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
    if (j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD5",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("ADDL_FIELD5",0);
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select addl_field5 from dr_mp_pat_oth_dtls where duplicate_patient_id = a.duplicate_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }   
    if (j_mrn_new_select_outermost_dup.indexOf("MOTHER_PATIENT_NAME",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("MOTHER_PATIENT_NAME",0);
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
	if (j_mrn_new_select_outermost_dup.indexOf("DOC_NUM",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("DOC_NUM",0);
		j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select doc1_num from mp_pat_documents where patient_id = a.duplicate_patient_id) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
	if (j_mrn_new_select_outermost_dup.indexOf("DOC_TYPE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("DOC_TYPE",0);
		j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos-3)+"(select short_Desc from mp_document_type_LANG_VW where language_id = '"+locale+"' and doc_type in(select doc1_type from mp_pat_documents where patient_id = a.duplicate_patient_id)) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
	//added for other alt id
	if (j_mrn_new_select_outermost_dup.indexOf("OTH_ALT_ID_TYPE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("OTH_ALT_ID_TYPE",0);
		j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos)+"(select long_desc from mp_alternate_id_type_LANG_VW where language_id = '"+locale+"' and alt_id_type = a.oth_alt_id_type) "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
	//added for PAT_SER_GRP_CODE
		if (j_mrn_new_select_outermost_dup.indexOf("PAT_SER_GRP_CODE",0)>=0)
    {
        addl_pos = j_mrn_new_select_outermost_dup.indexOf("PAT_SER_GRP_CODE",0);
		j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,addl_pos)+"mp_get_desc.MP_PAT_SER_GRP(pat_ser_grp_code,'"+locale+"',2)  "+j_mrn_new_select_outermost_dup.substring(addl_pos);
    }
  
}

//Added by kumar on 8/3/2002 for DR functions.
String test = "";   
String testsql="";
String fld_name = "";
String dup_both = "";
String valid_both = "";
String valid_main = "";

if ((!function_id.equals("") && !func_act.equals("DuplicateRegistration") && !function_id.equals("PAT_REG") && !function_id.equals("NEWBORN_REG")) || search_in.equals("B"))
{
       	rs = stmt.executeQuery("Select field_name from mp_pat_search_result_lang_vw where language_id = '"+locale+"' and field_select='Y' order by field_order");
        if(rs != null) 
        {
            while (rs.next())
            {
                fld_name = rs.getString("field_name");
                
                if( !fld_name.equalsIgnoreCase("Pat_Photo"))
                {
                    
                        if (fld_name.equalsIgnoreCase("Patient_Id"))
                        {
                            if (!function_id.equalsIgnoreCase("DR_EXCLUDE_POSSIBLE_PATIENTS")                                                                               &&!function_id.equalsIgnoreCase("DR_EXCLUDED_PATIENT_ID")
                                &&!function_id.equalsIgnoreCase("DR_UNMERGED_PATIENT_IDS")
								&&!func_act.equals("DuplicateRegistration")
                                &&(!function_id.equals("") && !function_id.equals("PAT_REG") && !function_id.equals("NEWBORN_REG")))
                                test = test + "d." + fld_name + " ,";
                            else if (function_id.equalsIgnoreCase("DR_EXCLUDE_POSSIBLE_PATIENTS")||function_id.equals("DR_EXCLUDED_PATIENT_ID"))
                                test = test + "C." + fld_name + " ,";
                            else
                            {                               
                                dup_both = dup_both+ "A.duplicate_"+fld_name+" "+fld_name+", ";
                            }
                        }
                        else if (fld_name.equalsIgnoreCase("File_No")||fld_name.equalsIgnoreCase("Old_File_No")||fld_name.equalsIgnoreCase("Facility_Id"))
                        {
                            test = test + "B." + fld_name + " ,";
                            dup_both = dup_both +"C."+fld_name+",";
                        }
                        else
                        {
                            if (fld_name.equalsIgnoreCase("Date_Of_Birth"))
                            {
                                test = test + "to_char(A." + fld_name + ",'dd/mm/yyyy') "+fld_name+",";
                                dup_both = dup_both + "A." + fld_name +",";
                            }
                            else if (fld_name.equalsIgnoreCase("addl_field1") || fld_name.equalsIgnoreCase("addl_field2") || fld_name.equalsIgnoreCase("addl_field3") || fld_name.equalsIgnoreCase("addl_field4") || fld_name.equalsIgnoreCase("addl_field5"))
                            {
                                test = test + "'' "+ fld_name + " ,";
                                dup_both = dup_both + "dup." + fld_name + " "+fld_name+" ,";
                            }
                            else if (fld_name.equalsIgnoreCase("mother_patient_name"))
                            {
								test = test + "'' "+ fld_name + " ,";
                              //   test = test + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+ fld_name + " ,";
                                dup_both = dup_both + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) " + fld_name + " ,";

                            }						
							else if (fld_name.equalsIgnoreCase("oth_alt_id_type"))  //added for other alt id
							{
								
								//test = test + fld_name + " ,";
								if(function_id.equals("DR_MERGED_PATIENT_ID"))
									test = test + "a."+fld_name + " ,";
								else
									test = test + fld_name + " ,";
                                dup_both = dup_both + "dup." + fld_name + " "+fld_name+" ,";					
							}
                            else if(!fld_name.equalsIgnoreCase("doc_type") && !fld_name.equalsIgnoreCase("doc_num"))
                            {
                                test = test + "A." + fld_name + " ,";
                                dup_both = dup_both + "A." + fld_name + " ,";
                            }
                        }

                        if( !fld_name.equalsIgnoreCase("File_No"))
                        {
                            if (function_id.equals("DR_UNMERGED_PATIENT_IDS"))
                            {   
                                if (fld_name.equalsIgnoreCase("Old_File_No")||fld_name.equalsIgnoreCase("Facility_Id"))
                                {
                                    testsql = testsql +"E."+fld_name+" ,";
                                    valid_values_sql_d = valid_values_sql_d+"E."+fld_name+" v_"+fld_name+" ,";
                                    valid_values_sql = valid_values_sql+"E."+fld_name+" v_"+fld_name+" ,";
                                }
                                else if (!fld_name.equalsIgnoreCase("Patient_Id"))
                                {
                                    if (fld_name.equalsIgnoreCase("addl_field1") ||                         fld_name.equalsIgnoreCase("addl_field2") ||                         fld_name.equalsIgnoreCase("addl_field3") ||                         fld_name.equalsIgnoreCase("addl_field4") ||                         fld_name.equalsIgnoreCase("addl_field5"))   
                                    {
                                        testsql = testsql +"valid."+fld_name+" "+fld_name+" ,";
                                        valid_values_sql_d = valid_values_sql_d + "dup."+fld_name+ " v_"+fld_name+" ,";
                                        valid_values_sql = valid_values_sql + "valid."+fld_name+ " v_"+fld_name+" ,";
                                    }
                                    else if (fld_name.equalsIgnoreCase("mother_patient_name"))
                                    {
                                        testsql = testsql + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+ fld_name + " ,";
                                        valid_values_sql_d = valid_values_sql_d + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+ "v_"+fld_name+" ,";
                                        valid_values_sql = valid_values_sql + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+ "v_"+fld_name+" ,";

                                    }
									else if(!fld_name.equalsIgnoreCase("doc_type") && !fld_name.equalsIgnoreCase("doc_num"))
                                    {
                                        testsql = testsql +"A."+fld_name+" ,";
                                        valid_values_sql_d = valid_values_sql_d + "D."+fld_name+" v_"+fld_name+" ,";
                                        valid_values_sql = valid_values_sql + "A."+fld_name+" v_"+fld_name+" ,";
                                    }
                                }
                            }
                            else
                            {
                                if (fld_name.equalsIgnoreCase("addl_field1") ||                         fld_name.equalsIgnoreCase("addl_field2") ||                         fld_name.equalsIgnoreCase("addl_field3") ||                         fld_name.equalsIgnoreCase("addl_field4") ||                         fld_name.equalsIgnoreCase("addl_field5"))   
                                {
                                    testsql = testsql +"(select "+fld_name+" from mp_pat_oth_dtls where patient_id = a.patient_id) "+fld_name+" ,";
                                }
                                else if (fld_name.equalsIgnoreCase("mother_patient_name"))
                                {
									testsql = testsql + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) "+ fld_name + " ,";

                                }                                   
                                else if(!fld_name.equalsIgnoreCase("doc_type") && !fld_name.equalsIgnoreCase("doc_num"))
                                    testsql = testsql +"A."+fld_name+" ,";

                                if (fld_name.equals("Old_File_No")||fld_name.equals("Facility_Id"))
                                {
                                    valid_both = valid_both + "D."+fld_name+" v_"+fld_name+" ,";
                                    valid_main = valid_main + "D."+fld_name+" ,";
                                }
                                else
                                {                                   
                                    if (fld_name.equalsIgnoreCase("Date_Of_Birth"))
                                    {   
                                        valid_both = valid_both + "to_char(B." + fld_name + ",'dd/mm/yyyy') "+"v_"+fld_name+",";
                                        valid_main = valid_main + "B."+fld_name+" ,";   
                                    }
                                    else
                                    {
                                        if (fld_name.equalsIgnoreCase("addl_field1") ||                     fld_name.equalsIgnoreCase("addl_field2") ||                     fld_name.equalsIgnoreCase("addl_field3") ||                     fld_name.equalsIgnoreCase("addl_field4") ||                     fld_name.equalsIgnoreCase("addl_field5"))   
                                        {
                                            valid_both = valid_both + "valid."+fld_name+" v_"+fld_name+" ,";
                                            valid_main = valid_main + "valid."+fld_name+" ,";   
                                        }
                                        else if (fld_name.equalsIgnoreCase("mother_patient_name"))
                                        {
                                            valid_both = valid_both + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) v_" + fld_name + " ,";
                                            valid_main = valid_main + "(select patient_name from mp_patient where patient_id = a.mother_patient_id) " + fld_name + " ,";
											
                                        }
                                        else if(!fld_name.equalsIgnoreCase("doc_type") && !fld_name.equalsIgnoreCase("doc_num"))
                                        {
                                            valid_both = valid_both + "B."+fld_name+" v_"+fld_name+" ,";
                                            valid_main = valid_main + "B."+fld_name+" ,";   
                                        }
                                    }
                                }                               
                            }
                        }
                        else
                        {
                            if (function_id.equals("DR_UNMERGED_PATIENT_IDS"))
                            {
                                testsql = testsql +"E."+fld_name+" ,";
                                valid_values_sql_d = valid_values_sql_d + "F."+fld_name+" v_"+fld_name+" ,";
                                valid_values_sql = valid_values_sql + "E."+fld_name+" v_"+fld_name+" ,";
                            }
                            else
                            {
                                testsql = testsql +""+fld_name+" ,";                                    
                                valid_both = valid_both + "D."+fld_name+" v_"+fld_name+" ,";
                                valid_main = valid_main + "D."+fld_name+" ,";
                            }
                        }
                        if (fld_name.equalsIgnoreCase("Date_Of_Birth"))
                                main_select_sql = main_select_sql + "to_char("+ fld_name + ",'dd/mm/yyyy') "+fld_name+",";
                        else
                            if (fld_name.equalsIgnoreCase("addl_field1") ||                                 fld_name.equalsIgnoreCase("addl_field2") ||                                 fld_name.equalsIgnoreCase("addl_field3") ||                                 fld_name.equalsIgnoreCase("addl_field4") ||                                 fld_name.equalsIgnoreCase("addl_field5") ||                                 fld_name.equalsIgnoreCase("mother_patient_name"))
                                main_select_sql = main_select_sql + fld_name+",";
                            else if(!fld_name.equalsIgnoreCase("doc_type") && !fld_name.equalsIgnoreCase("doc_num")) 
							{
								
                                main_select_sql = main_select_sql +fld_name+",";
							}
                }

            }
		
			if (cntPrefFac.equals("0"))
			{
				
				if(function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") || function_id.equals("DR_EXCLUDED_PATIENT_ID"))	{
					test = test +" A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn, a.MOTHER_PATIENT_ID, a.CURR_PATIENT_CLASS,a.ENC_FACILITY_ID,a.CURR_ENCOUNTER_ID";
					testsql = testsql +"A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn, a.CURR_PATIENT_CLASS,a.ENC_FACILITY_ID,a.CURR_ENCOUNTER_ID";
				}
				else {
					test = test +" A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
					testsql = testsql +"A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
				}
				/*
				test = test +" A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
				testsql = testsql +"A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
				*/
				main_select_sql= main_select_sql+"pref_facility_id, Suspend_Yn, Deceased_Yn, Active_Yn, mother_patient_id ";               
				dup_both = dup_both +"A.pref_facility_id, A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
	            valid_main = valid_main +"B.pref_facility_id, B.Suspend_Yn, B.Deceased_Yn, B.Active_Yn";
			}
			else
			{
				if(function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") || function_id.equals("DR_EXCLUDED_PATIENT_ID"))	{
					test = test +" A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn, a.MOTHER_PATIENT_ID, a.CURR_PATIENT_CLASS,a.ENC_FACILITY_ID,a.CURR_ENCOUNTER_ID";
					testsql = testsql +"A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn, a.CURR_PATIENT_CLASS,a.ENC_FACILITY_ID,a.CURR_ENCOUNTER_ID";
				}
				else {
					test = test +" A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
					testsql = testsql +"A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
				}
				/*
				test = test +"A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
				testsql = testsql +" A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
				*/
				main_select_sql= main_select_sql+"CURR_PATIENT_CLASS,ENC_FACILITY_ID,CURR_ENCOUNTER_ID ,Suspend_Yn, Deceased_Yn, Active_Yn, mother_patient_id";               
				dup_both = dup_both +" A.Suspend_Yn, A.Deceased_Yn, A.Active_Yn";
	            valid_main = valid_main +"  B.Suspend_Yn, B.Deceased_Yn, B.Active_Yn";
			}
			j_mrn_new_select_outermost = test;
	            
    }
}
//Ends here for DR functions.   


    sql="select FIELD_NAME,field_length_perc from mp_pat_search_result_lang_vw where language_id = '"+locale+"' and field_select='Y' order by field_order ";
     rs1=stmt.executeQuery(sql);
     if(rs1 !=null ) 
       {
     while(rs1.next()) {
     if(rs1.getString(1).equals("File_No")) {
	 mrnaccessyn="Y";
	 
	 }
	 
	 percent= percent + rs1.getInt("field_length_perc");
     if(percent > 102) totalpercent= totalpercent + (percent-totalpercent);
     
	 }
    }

if (!function_id.equals("DR_UNMERGED_PATIENT_IDS"))
{  if(mrnaccessyn.equals("Y"))
	{
    j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", case when (select count(1) from mr_pat_file_index where patient_id=a.patient_id ) < 2 then (select file_no||','||old_file_no||','||c.facility_name from mr_pat_file_index b, sm_facility_param c where b.facility_id = '"+logged_facility+"' and b.facility_id = c.facility_id and patient_id = A.patient_id ) else '' end mr_section";
    j_mrn_new_select_outermost1 = j_mrn_new_select_outermost1 +" case when (select count(1) from mr_pat_file_index where patient_id=B.patient_id) < 2 then (select file_no||','||old_file_no||','||c.facility_name from mr_pat_file_index d, sm_facility_param c where d.facility_id = '"+logged_facility+"' and d.facility_id = c.facility_id and patient_id = B.patient_id ) else '' end mr_section";
    j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup +", case when (select count(1) from dr_mr_pat_file_index where duplicate_patient_id=a.duplicate_patient_id) < 2 then (select file_no||','||old_file_no||','||c.facility_name from dr_mr_pat_file_index b, sm_facility_param c where b.facility_id = '"+logged_facility+"' and b.facility_id = c.facility_id and duplicate_patient_id = A.duplicate_patient_id ) else '' end mr_section";
	if(function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS")||function_id.equals("DR_MERGED_PATIENT_ID")
		||function_id.equals("DR_EXCLUDED_PATIENT_ID"))
	{
		testsql = testsql +", A.mr_section";      
		main_select_sql_both = main_select_sql_both +",mr_section";
		
		/*
	    testsql = testsql +", A.curr_patient_class";	
		main_select_sql_both  = main_select_sql +",curr_patient_class";
	
		testsql = testsql +", A.curr_encounter_id";
		main_select_sql = main_select_sql +",curr_encounter_id";
		
		testsql = testsql +", A.enc_facility_id";
		main_select_sql = main_select_sql +",enc_facility_id";	
		*/
	}
	
	}
	if (j_mrn_new_select.indexOf("NATIONALITY_CODE")>=0)
    {
        j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select long_desc from mp_country_lang_vw where country_code = A.Nationality_code and language_id = '"+locale+"') nationality_desc";
        j_mrn_new_select_outermost1 = j_mrn_new_select_outermost1 +", (select long_desc from mp_country_lang_vw where country_code = B.Nationality_code and language_id = '"+locale+"') nationality_desc";
        j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup +", (select long_desc from mp_country_lang_vw where country_code = A.Nationality_code and language_id = '"+locale+"') nationality_desc";
        testsql = testsql +", A.nationality_desc";  
        main_select_sql_both = main_select_sql_both +",nationality_desc";
    }
     if (j_mrn_new_select.indexOf("RES_AREA_CODE")>=0)
    {
        j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select long_desc from mp_res_area_lang_vw where res_area_code = A.Res_Area_Code  and language_id = '"+locale+"') Res_Area_Desc";
        j_mrn_new_select_outermost1 = j_mrn_new_select_outermost1 +", (select long_desc from mp_res_area_lang_vw where res_area_code = B.Res_Area_Code  and language_id = '"+locale+"') Res_Area_Desc";
        j_mrn_new_select_outermost_dup  = j_mrn_new_select_outermost_dup  +", (select long_desc from mp_res_area_lang_vw where res_area_code = A.Res_Area_Code  and language_id = '"+locale+"') Res_Area_Desc";
        testsql = testsql +", A.Res_Area_Desc";
        main_select_sql_both = main_select_sql_both +",Res_Area_Desc";
    }
     if (j_mrn_new_select.indexOf("PREF_FACILITY_ID")>=0)
    {
        j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select facility_name from sm_facility_param_lang_vw where facility_id = A.Pref_Facility_Id  and language_id = '"+locale+"') Pref_Fac_Name";
        j_mrn_new_select_outermost1 = j_mrn_new_select_outermost1 +", (select facility_name from sm_facility_param_lang_vw where facility_id = B.Pref_Facility_Id  and language_id = '"+locale+"') Pref_Fac_Name";
        j_mrn_new_select_outermost_dup  = j_mrn_new_select_outermost_dup  +", (select facility_name from sm_facility_param_lang_vw where facility_id = A.Pref_Facility_Id  and language_id = '"+locale+"') Pref_Fac_Name";
        testsql = testsql +", A.Pref_Fac_Name";
        main_select_sql_both = main_select_sql_both +",Pref_Fac_Name";
    }
    if(mrnaccessyn.equals("Y"))
	{
    j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select count(1) from mr_pat_file_index where patient_id=a.patient_id) countMRNS";
	/*
    if(function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS"))
	{						j_mrn_new_select_outermost=j_mrn_new_select_outermost+",enc_facility_id,curr_encounter_id,curr_patient_class";}
	*/
	j_mrn_new_select_outermost1 = j_mrn_new_select_outermost1 +", (select count(1) from mr_pat_file_index where patient_id=B.patient_id) countMRNS ";
	if (search_in.equals("D"))
	    j_mrn_new_select_outermost_dup  =  j_mrn_new_select_outermost_dup  +",'D' dup_indicator, (select count(1) from dr_mr_pat_file_index where duplicate_patient_id=a.duplicate_patient_id) countMRNS ";
	else
		j_mrn_new_select_outermost_dup  = j_mrn_new_select_outermost_dup  +", (select count(1) from dr_mr_pat_file_index where duplicate_patient_id=a.duplicate_patient_id) countMRNS ";
     
    testsql = testsql +",  A.countMRNS ";

    if (function_id.equals("") || func_act.equals("DuplicateRegistration") || function_id.equals("PAT_REG") || function_id.equals("NEWBORN_REG"))
        main_select_sql = main_select_sql +main_select_sql_both+", dup_indicator, countMRNS ";
	}
	}
else
{
    if(mrnaccessyn.equals("Y"))
	{
	j_mrn_new_select_outermost  = ", case when (select count(1) from mr_pat_file_index where patient_id=a.duplicate_patient_id) < 2 then (select file_no||','||old_file_no||','||c.facility_name from mr_pat_file_index b, sm_facility_param  c where b.facility_id = c.facility_id and patient_id = A.duplicate_patient_id) else '' end mr_section";
    j_mrn_new_select_outermost1  = ", case when (select count(1) from mr_pat_file_index where patient_id=a.patient_id) < 2 then (select file_no||','||old_file_no||','||c.facility_name from mr_pat_file_index b, sm_facility_param c where b.facility_id = c.facility_id and patient_id = A.patient_id) else '' end mr_section";
    union_main_sql =  union_main_sql +"mr_section";
	
	}
	if (j_mrn_new_select.indexOf("NATIONALITY_CODE")>=0)
    {
        j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select long_desc from mp_country_lang_vw where country_code = A.Nationality_code and language_id = '"+locale+"') nationality_desc";
        j_mrn_new_select_outermost1  = j_mrn_new_select_outermost1  +", (select long_desc from mp_country_lang_vw where country_code = A.Nationality_code) nationality_desc";
        union_main_sql = union_main_sql +", nationality_desc";
    }
     if (j_mrn_new_select.indexOf("RES_AREA_CODE")>=0)
    {
        j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select long_desc from mp_res_area_lang_vw where res_area_code = A.Res_Area_Code and language_id = '"+locale+"') Res_Area_Desc";
        j_mrn_new_select_outermost1  = j_mrn_new_select_outermost1  +", (select long_desc from mp_res_area_lang_vw where res_area_code = A.Res_Area_Code and language_id = '"+locale+"') Res_Area_Desc";
        union_main_sql = union_main_sql +", Res_Area_Desc";
    }
    if (j_mrn_new_select.indexOf("PREF_FACILITY_ID")>=0)
    {
        j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select facility_name from sm_facility_param_lang_vw where facility_id = A.Pref_Facility_Id and language_id = '"+locale+"') Pref_Fac_Name";
        j_mrn_new_select_outermost1  =  j_mrn_new_select_outermost1  +", (select facility_name from sm_facility_param_lang_vw where facility_id = A.Pref_Facility_Id  and language_id = '"+locale+"') Pref_Fac_Name";
        union_main_sql = union_main_sql +", nationality_desc";
    }
    if(mrnaccessyn.equals("Y"))
	{
	j_mrn_new_select_outermost  = j_mrn_new_select_outermost  +", (select count(1) from mr_pat_file_index where patient_id=a.duplicate_patient_id) countMRNS ";
    j_mrn_new_select_outermost1  = j_mrn_new_select_outermost1  +", (select count(1) from mr_pat_file_index where patient_id=a.patient_id) countMRNS ";
    main_select_sql = main_select_sql +","+union_main_sql;
    main_select_sql = main_select_sql +", merge_trn_id, dup_indicator, countMRNS";
	}
}
//For DR functions 

    


boolean sql_append = true;

if(!MRN.equals("") || !OldFileNo.equals(""))
{
    if(!MRN.equals(""))
    {
        countsql = "select count(1) as total from mr_pat_file_index where file_no = '"+MRN+"'";
    }
    if(!OldFileNo.equals(""))
    {
        countsql = "select count(1) as total from mr_pat_file_index where old_file_no = '"+OldFileNo+"'";
    }
    if (!MRN.equals("") && !OldFileNo.equals(""))
        countsql = "select count(1) as total from mr_pat_file_index where file_no = '"+MRN+"' and old_file_no = '"+OldFileNo+"'";
    sql_append = false;
}
else
{ 
    if (search_in.equals("D"))
    {
        countsql1 = countsql.toUpperCase();
        if (countsql1.indexOf("MP_PATIENT",0)>=0)
        {
            drpos = countsql1.indexOf("MP_PATIENT",0);
            countsql1 = countsql1.substring(0,drpos)+"DR_"+countsql1.substring(drpos);
        }           
        if (countsql1.indexOf("PATIENT_ID",0)>=0)
        {
            drpos = countsql1.indexOf("PATIENT_ID",0);
            countsql1 = countsql1.substring(0,drpos)+"DUPLICATE_"+countsql1.substring(drpos);
        }       
    }
}
if (countsql1==null) countsql1="";
countsql = countsql.replace('^','%');
if (search_in.equals("D"))
    countsql1 = countsql1.replace('^','%');

String act_yn   =request.getParameter("act_yn");

String w_cls = "";
String w_flag = "N";
String pat_id="";


int start = 0 ;
int end = 0 ;


if ( from == null || from.equals(""))
    start = 1 ;
else
    start = Integer.parseInt( from ) ;

if ( to == null || to.equals(""))
    end = searchThreshold ;
else
    end = Integer.parseInt( to ) ;




double maxRecord = 0;
try 
{   
	if (search_in.equals("D"))
		rs = stmt.executeQuery(countsql1);
    else
        rs = stmt.executeQuery(countsql);
    if (rs.next())
    {
        maxRecord = rs.getDouble(1);
    }

	String Hit_limit = request.getParameter("Hit_Limit");
	if (Hit_limit.equals("undefined")) Hit_limit = "";
	if (Hit_limit.equals("null")) Hit_limit = "";

    if (!Hit_limit.equals("")) 
	{
		Hit=Double.parseDouble(request.getParameter("Hit_Limit"));	    
	}
	if(Hit==0) Hit = maxRecord ;
    if (maxRecord < Hit) Hit_for_buttons = maxRecord;
    else Hit_for_buttons = Hit;
}
catch( Exception e ) {Hit = maxRecord ; }

%>
";
					 
                     parent.frames[5].document.write(HTMLVal);
                     parent.frames[5].document.form1.submit(); 
                }
            

             async    function ViewPatDtl(Pat_id)
                {
					Pat_id=unescape(Pat_id)
                    var url         = "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Pat_id);
                    var dialogTop       = "65";
                    var dialogHeight    = "40"; //33.4
                    var dialogWidth     = "65";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval =await  window.showModalDialog( url, arguments, features ) ;
                }
				/*
                async function ViewPatDtlDup(Pat_id)
                {
                    var url         = "../jsp/ViewPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID="+Pat_id;
                    var dialogTop       = "65";
                    var dialogHeight    = "33.4";
                    var dialogWidth     = "50";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval = await window.showModalDialog( url, arguments, features ) ;
                }     
				*/
                function ordercols(field) 
                {   
                   
					var fsql = "<%=full_sql%>";
					parent.frames[1].document.forms[0].FULLSQL.value = fsql;
                    var fullsqlstr=parent.frames[1].document.forms[0].FULLSQL.value;
                    parent.frames[1].document.forms[0].ORDERBY.value=field;                    
                    if ((parent.frames[1].document.forms[0].apply_oth_name) &&                              (parent.frames[1].document.forms[0].search_in.value != "B"))
                    {
                        if (parent.frames[1].document.forms[0].apply_oth_name.checked)
                        {
                            field = field.toUpperCase();
                            if (field == "FIRST_NAME" || field ==  "SECOND_NAME" || field == "THIRD_NAME" || field ==  "FAMILY_NAME" || field == "PATIENT_NAME")
                                field = field+"_LOC_LANG";
                        }
                    }
                    document.forms[0].maxdisplay.value = parseInt(document.forms[0].maxdisplay.value); 
                    document.forms[0].maxdisplay1.value = parseInt(document.forms[0].maxdisplay1.value);
                    document.result_form.orderby.value=field;
                    document.forms[0].submit();
                }

                async function showMRNS(patientID)
                {
                    var url         = "../../eMP/jsp/MultipleMRN.jsp?Patient_Id="+escape(patientID);
                    var dialogTop       = "76";
                    var dialogHeight    = "15";
                    var dialogWidth     = "50";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval =await window.showModalDialog( url, arguments, features ) ;
                    //RETURN VALUE COMES BACK ONLY IF THE SEARCH IS TRIGGERED FROM MP ONLINE REPORTS
                    if (returnval){
                        parent.frames[1].document.forms[0].reset();
                        
                        parent.frames[3].location.href = '../../eCommon/html/blank.html';
                        parent.frames[4].location.href = '../../eCommon/html/blank.html';
                        var retValArray = returnval.split(":");
                        PrintOnlineReports(retValArray[0],retValArray[1]);                      
                    }
                }

                async function PrintOnlineReports(PatID,GenFN)
                {
                    var retVal =    new String();
                    var dialogHeight    = "30" ;
                    var dialogWidth = "70" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
                    var arguments   = "" ;
                    retVal =await window.showModalDialog("../../eCommon/jsp/InternalReportsReprint.jsp?module_id=MP&step=0&patient_id="+escape(PatID)+"&Gen_File_No="+escape(GenFN)+"&target=step2",arguments,features);                 
                }
            </Script>
            <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        </head>

<%
try 
{   
    String final_sql = "";
    String final_sql1 = "";
    String dr_order_by = ""; 	

    if (!function_id.equals("") && !function_id.equals("PAT_REG") &&  !function_id.equals("NEWBORN_REG") && !func_act.equals("DuplicateRegistration"))
    {
	
	 if (function_id.equals("DR_VALID_DUPLICATE_PATIENT")||function_id.equals("DR_ENTER_DUPLICATES")||function_id.equals("DR_MERGED_PATIENT_ID"))
        {
			
			final_sql = "select "+testsql+" from (select "+j_mrn_new_select_outermost+" "+j_mrn_from;
            if (j_where_dr.length() > 6)
                final_sql1 = final_sql1 +", dr_dup_group_dtls d, dr_dup_group_hdr c, mr_pat_file_index b "+j_where_dr+" and "+j_where_addl_field+" c.dup_group_id = d.dup_group_id and ";
            else
                final_sql1 = final_sql1 +", dr_dup_group_dtls d, dr_dup_group_hdr c, mr_pat_file_index b "+j_where_dr+" "+j_where_addl_field+" c.dup_group_id = d.dup_group_id and ";
            if (function_id.equals("DR_VALID_DUPLICATE_PATIENT"))
                final_sql1 = final_sql1 +"c.system_gen_yn = 'Y' and (c.group_status = 'U' or c.group_status = 'I') ";
            else if (function_id.equals("DR_ENTER_DUPLICATES"))
                final_sql1 = final_sql1 +"c.system_gen_yn = 'N' and c.group_status = 'I' ";
            else if (function_id.equals("DR_MERGED_PATIENT_ID"))
                final_sql1 = final_sql1 +"c.group_status = 'I' ";
                    
            if (orderby.equalsIgnoreCase("Patient_Id"))         
                dr_order_by = " order by d."+orderby+") A";
            else if (orderby.equalsIgnoreCase("File_No")||orderby.equalsIgnoreCase("Old_File_No")||orderby.equalsIgnoreCase("Facility_Id")) 
                dr_order_by = " order by B."+orderby+") A";
            else if (orderby.equals("Date_of_Birth"))
            {
                orderby= "to_date(A.date_of_birth,'dd/mm/yyyy')" ;
                dr_order_by = " order by "+orderby+") A";
            } else if(orderby.equals("X"))
				dr_order_by = " order by X) A";
            else
                dr_order_by = " order by A."+orderby+") A";

            final_sql1 =  final_sql1 +" and a.patient_id = d.patient_id and a.patient_id = b.patient_id(+) and nvl(B.File_no,'**')= nvl((select min(file_no) from mr_pat_file_index where patient_id=A.patient_id "+dr_file_no_where+"),nvl(B.File_no,'**')) ";
        }
        else if (function_id.equals("DR_UNMERGED_PATIENT_IDS"))
        {
            
				drpos = 0;
                j_where_dr = j_where_dr.toUpperCase();

                if  (j_where_dr.indexOf("PATIENT_ID",0)>=0)
                    drpos=j_where_dr.indexOf("PATIENT_ID");

                if (drpos > 0)
                {                   
                    
                    j_mrn_where1 = j_where_dr;
                    drpos =0;
                    while (j_mrn_where1.indexOf("A.PATIENT_ID",drpos)>=0)
                    {
                        drpos1 = j_mrn_where1.indexOf("A.PATIENT_ID", drpos);
                        if (j_mrn_where1.substring(drpos1,drpos1+12).equalsIgnoreCase("A.Patient_Id"))
                        {
                            j_mrn_where1 = j_mrn_where1.substring(drpos,drpos1) +   "A.Duplicate_Patient_Id"+j_mrn_where1.substring(drpos1+12);
                        }                                               
                    }
                }
                else
                    j_mrn_where1 = j_where_dr;
                    
            final_sql = "select A.duplicate_patient_id Patient_Id, d.patient_id v_patient_id, " +valid_values_sql_d+testsql+j_mrn_new_select_outermost+",B.merge_trn_id, B.dup_indicator from ";
            if (j_mrn_where1.length() > 6)
                final_sql1 = "(select d.patient_id, c.merge_trn_id, d.dup_indicator from dr_mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_mrn_where1+" and "+j_where_addl_field_dr+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'D' and d.patient_id = A.duplicate_patient_id union select d.patient_id, c.merge_trn_id, d.dup_indicator from mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_where_dr+" and "+j_where_addl_field+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'D' and d.patient_id = A.patient_id) B";
            else
                final_sql1 = "(select d.patient_id, c.merge_trn_id, d.dup_indicator from dr_mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_mrn_where1+" "+ j_where_addl_field_dr+" d.dup_indicator = 'D' and d.patient_id = A.duplicate_patient_id union select d.patient_id, c.merge_trn_id, d.dup_indicator from mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_where_dr+" "+j_where_addl_field+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'D' and d.patient_id = A.patient_id) B";

            final_sql1 = final_sql1 +",dr_mp_patient A, dr_mr_pat_file_index E, dr_merged_patient_dtls C, mp_patient D, mr_pat_file_index F, dr_mp_pat_oth_dtls dup, mp_pat_oth_dtls valid where B.dup_indicator = 'D' and B.merge_trn_id  = C.merge_trn_id and   A.duplicate_patient_id = C.patient_id and D.patient_id = A.valid_patient_id and A.duplicate_patient_id = dup.duplicate_patient_id and valid.patient_id = A.valid_patient_id and A.duplicate_patient_id = E.duplicate_patient_id(+)  and nvl(E.File_no,'**')= nvl((select min(file_no) from dr_mr_pat_file_index where duplicate_patient_id=A.duplicate_patient_id ),nvl(E.File_no,'**')) and D.patient_id = F.patient_id(+)  and nvl(F.File_no,'**')= nvl((select min(file_no) from mr_pat_file_index where patient_id=D.patient_id ),nvl(F.File_no,'**'))";
            union_sql = union_sql +" union select A.patient_id Patient_Id, A.patient_id v_patient_id," +valid_values_sql+testsql+j_mrn_new_select_outermost1+",B.merge_trn_id, B.dup_indicator from ";
            if (j_where_dr.length() > 6)
                union_sql = union_sql +"(select d.patient_id, c.merge_trn_id, d.dup_indicator from mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_where_dr+" and "+j_where_addl_field+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'V' and d.patient_id = A.patient_id union select d.patient_id, c.merge_trn_id, d.dup_indicator from mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_where_dr+" and "+j_where_addl_field+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'V' and d.patient_id =       A.patient_id) B";
            else
                union_sql = union_sql +"(select d.patient_id, c.merge_trn_id, d.dup_indicator from mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_where_dr+" "+j_where_addl_field+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'V' and d.patient_id = A.patient_id union select d.patient_id, c.merge_trn_id, d.dup_indicator from mp_patient a, dr_merged_patient_dtls d, dr_merged_patient_hdr c "+j_where_dr+" "+j_where_addl_field+" c.merge_trn_id = d.merge_trn_id and c.un_merged_yn = 'N' and d.dup_indicator = 'V' and d.patient_id =   A.patient_id) B";
            union_sql = union_sql +",mp_patient A, mr_pat_file_index E, dr_merged_patient_dtls C, mp_pat_oth_dtls valid where B.dup_indicator = 'V' and B.merge_trn_id  = C.merge_trn_id and  A.patient_id = C.patient_id and A.patient_id = valid.patient_id and C.Patient_id = valid.patient_id and A.patient_id = E.patient_id(+)  and nvl(E.File_no,'**')= nvl((select min(file_no) from mr_pat_file_index where  patient_id=A.patient_id ),nvl(E.File_no,'**')) ";

            if (orderby.equalsIgnoreCase("Date_of_Birth"))
            {
                orderby= "to_date(v_date_of_birth,'dd/mm/yyyy')" ;
                dr_order_by = "order by "+orderby;              
            }else if (orderby.equalsIgnoreCase("X"))
				dr_order_by = " order by X";
            else
                dr_order_by = "order by v_"+orderby;
            
            dr_order_by = dr_order_by +" , merge_trn_id, dup_indicator desc";   
            final_sql = final_sql +final_sql1+ union_sql;
            final_sql1 = "select "+main_select_sql + " from ( "+ final_sql +" )";
        }   
        else 
        {
			         
			final_sql = "select "+testsql+" from (select "+j_mrn_new_select_outermost+" "+j_mrn_from;
            if (j_where_dr.length() > 6)
                final_sql1 = final_sql1 +", ((select patient_id1 patient_id from dr_not_dup_patients) union (select patient_id2 patient_id from dr_not_dup_patients)) C, mr_pat_file_index b  "+j_where_dr+" and "+j_where_addl_field;
            else
                final_sql1 = final_sql1 +", ((select patient_id1 patient_id from dr_not_dup_patients) union (select patient_id2 patient_id from dr_not_dup_patients)) C, mr_pat_file_index b  "+j_where_dr+" "+j_where_addl_field;
            
            if (orderby.equalsIgnoreCase("Patient_Id"))
                dr_order_by = " order by C."+orderby+") A";
            else if (orderby.equalsIgnoreCase("File_No")||orderby.equalsIgnoreCase("Old_File_No")||
                    orderby.equalsIgnoreCase("Facility_Id"))    
                dr_order_by = " order by B."+orderby+") A";
            else if (orderby.equalsIgnoreCase("Date_of_Birth"))
            {
                orderby= "to_date(A.date_of_birth,'dd/mm/yyyy')" ;
                dr_order_by = " order by "+orderby+") A";
            }else if (orderby.equalsIgnoreCase("X"))
				dr_order_by = " order by X) A";
            else
                dr_order_by = " order by A."+orderby+") A";

            final_sql1 =  final_sql1 + " a.patient_id = C.patient_id and a.patient_id = b.patient_id(+) and nvl(B.File_no,'**')= nvl((select min(file_no) from mr_pat_file_index where patient_id=A.patient_id "+dr_file_no_where+"),nvl(B.File_no,'**')) ";
        }

		

        if (!function_id.equals("DR_UNMERGED_PATIENT_IDS"))
            final_sql = final_sql +final_sql1+dr_order_by;
        else
            final_sql1 = final_sql1 +dr_order_by;
        try 
        {   
            String dr_cnt_sql = "";
            if (!function_id.equals("DR_UNMERGED_PATIENT_IDS"))
            {
                dr_cnt_sql = "select count(1) total " + j_mrn_from +final_sql1;
            }
            else 
            {
                dr_cnt_sql = "select count(1) total from ("+final_sql+")";
                final_sql  = final_sql1;                
            }       
            rs = stmt.executeQuery(dr_cnt_sql);
            if (rs.next())
            {
                maxRecord = rs.getInt("total");
            }
            Hit=Integer.parseInt(request.getParameter("Hit_Limit"));
            if(Hit==0) Hit = maxRecord ;

            if (maxRecord < Hit) Hit_for_buttons = maxRecord;
            else Hit_for_buttons = Hit;
        }
        catch( Exception e ) { Hit = maxRecord ; }
    }
    else
    {               
        if (search_in.equals("B"))
        {
            
                drpos = 0;
                j_where_dr = j_where_dr.toUpperCase();

                
                    j_mrn_where1 = j_where_dr;
                    while (j_mrn_where1.indexOf("A.PATIENT_ID",drpos)>=0)
                    {
                        drpos1 = j_mrn_where1.indexOf("A.PATIENT_ID", drpos);
                        if (j_mrn_where1.substring(drpos1,drpos1+12).equalsIgnoreCase("A.Patient_Id"))
                        {
                            j_mrn_where1 = j_mrn_where1.substring(drpos,drpos1) +   "A.Duplicate_Patient_Id"+j_mrn_where1.substring(drpos1+12);
                        }                                               
                    }                   
                    
            if (j_mrn_where1.length()>6)
            {
                final_sql = "select "+dup_both+","+valid_both+j_mrn_new_select_outermost_dup.substring(1)
                +",'D' dup_indicator from dr_mp_patient A, mp_patient B, dr_mr_pat_file_index C, mr_pat_file_index D, dr_mp_pat_oth_dtls dup, mp_pat_oth_dtls valid "+j_mrn_where1+" and "+j_where_addl_field_dr+" dup.duplicate_patient_id = A.duplicate_patient_id and valid.patient_id = A.valid_patient_id and A.valid_patient_id  = B.patient_id and A.duplicate_patient_id = C.duplicate_patient_id(+)  and nvl(C.File_no,'**')= nvl((select   min(file_no) from dr_mr_pat_file_index where duplicate_patient_id = A.duplicate_patient_id), nvl(C.File_no,'**')) and B.patient_id = D.patient_id(+)  and nvl(D.File_no,'**')= nvl((select min(file_no)  from mr_pat_file_index  where patient_id=B.patient_id ),nvl(D.File_no,'**'))";
                final_sql = final_sql +"union all select "+valid_main+","+valid_both+j_mrn_new_select_outermost1+",'V' dup_indicator from mp_patient B, mr_pat_file_index D, mp_pat_oth_dtls valid "+ j_mrn_where2+" and "+j_where_addl_field_dr_valid+" valid.patient_id = B.patient_id and B.patient_id = D.patient_id(+)  and nvl(D.File_no,'**')= nvl((select min(file_no)    from mr_pat_file_index  where patient_id=B.patient_id ),nvl(D.File_no,'**'))";
            }
            else
            {
                final_sql = "select "+dup_both+","+valid_both+j_mrn_new_select_outermost_dup.substring(1)
                +",'D' dup_indicator from dr_mp_patient A, mp_patient B, mr_pat_file_index C, mr_pat_file_index D, dr_mp_pat_oth_dtls dup, mp_pat_oth_dtls valid "+j_mrn_where1+" "+j_where_addl_field_dr+" dup.duplicate_patient_id = A.duplicate_patient_id and valid.patient_id = A.valid_patient_id and A.valid_patient_id  = B.patient_id and A.duplicate_patient_id = C.patient_id(+)  and nvl(C.File_no,'**')= nvl((select   min(file_no)    from mr_pat_file_index where    patient_id=A.duplicate_patient_id ),nvl(C.File_no,'**')) and B.patient_id = D.patient_id(+)";
                final_sql = final_sql +" union all select "+valid_main+","+valid_both+j_mrn_new_select_outermost1+",'V' dup_indicator from mp_patient B, mr_pat_file_index D, mp_pat_oth_dtls valid "+ j_mrn_where2+" "+j_where_addl_field_dr_valid+" B.patient_id = valid.patient_id and B.patient_id = D.patient_id(+)";

            }
			String final_order_by = "";
			if (orderby.equalsIgnoreCase("NATIONALITY_CODE"))
				final_order_by = "order by nationality_desc";
			else if (orderby.equalsIgnoreCase("RES_AREA_CODE"))
				final_order_by = "order by res_area_desc";
			else if (orderby.equalsIgnoreCase("PREF_FACILITY_ID"))
				final_order_by = "order by pref_fac_name";			
			else if (orderby.equalsIgnoreCase("Date_of_Birth"))
            {
                
                final_order_by = "order by v_date_of_birth";              
            }else if (orderby.equalsIgnoreCase("X"))
				final_order_by = " order by X";
            else
                final_order_by = "order by v_"+orderby;

					
            try 
            {                   
				String dr_cnt_sql = "";
                dr_cnt_sql = "select count(1) total from ("+final_sql+")";  

                rs = stmt.executeQuery(dr_cnt_sql);             
                if (rs.next())
                {
                    maxRecord = rs.getInt("total");
                }		

                Hit=Integer.parseInt(request.getParameter("Hit_Limit"));

                if(Hit==0) Hit = maxRecord ;

                if (maxRecord < Hit)
				{
					Hit_for_buttons = maxRecord;
				}else
				{
					Hit_for_buttons = Hit;
				}
			
            }

            catch( Exception e ) { Hit = maxRecord ; }

			final_sql1 = "select "+main_select_sql + " from ( "+ final_sql +" )  where rownum < "+  (Hit +1) + " "+final_order_by+", v_patient_id, dup_indicator desc";
			final_sql = final_sql1;
        }
        else if (search_in.equals("P"))
        {
	
			String addl_order_by = "";
			String indexWhere = "";
			String hintIndex = "";
			
				if (orderby.equalsIgnoreCase("FIRST_NAME"))
				{

					indexWhere = " and first_name like '%%'";
				}

				if (orderby.equalsIgnoreCase("FAMILY_NAME"))
				{

					indexWhere = " and family_name like '%%'";
				}

				if (orderby.equalsIgnoreCase("ALT_ID1_NO"))
				{

					try
					{
						if (rs!=null) rs.close();
						if (stmt!=null) stmt.close();
						stmt = conn.createStatement();
						double cntAltID = 0;						
						rs = stmt.executeQuery(countsql+" and alt_id1_no is not null ");
						if (rs.next())
							cntAltID=rs.getDouble(1);
						if (cntAltID==maxRecord)
							indexWhere = " and alt_id1_no like '%%'";
						else
							indexWhere = " and nvl(alt_id1_no,'%') like '%%'";
					}
					catch(Exception cntexp){/* out.println(cntexp); */ cntexp.printStackTrace();}
				}

				if (orderby.equalsIgnoreCase("NATIONAL_ID_NO"))
				{

					try
					{
						if (rs!=null) rs.close();
						if (stmt!=null) stmt.close();
						stmt = conn.createStatement();
						double cntNatID = 0;						
						rs = stmt.executeQuery(countsql+" and national_id_no is not null ");
						if (rs.next())
							cntNatID=rs.getDouble(1);
						if (cntNatID==maxRecord)
							indexWhere = " and national_id_no like '%%'";
						else
							indexWhere = " and nvl(national_id_no,'%') like '%%'";
					}
					catch(Exception cntexp){/* out.println(cntexp); */ cntexp.printStackTrace();}
					
				}

				if (orderby.equalsIgnoreCase("DATE_OF_BIRTH"))
					hintIndex = "/*+ INDEX(A MP_PATIENT_I15) */ ";
				if (orderby.equalsIgnoreCase("SEX"))
					hintIndex = "/*+ INDEX(A MP_PATIENT_I31) */ ";

			if (j_mrn_where.indexOf("Alt_Id1_No") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I17) */ ";
			if (j_mrn_where.indexOf("Alt_Id2_No") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I20) */ ";
			if (j_mrn_where.indexOf("Alt_Id3_No") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I25) */ ";
			if (j_mrn_where.indexOf("Alt_Id4_No") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I19) */ ";

			if (j_mrn_where.indexOf("Date_Of_Birth") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I15) */ ";
			if (j_mrn_where.indexOf("Family_Link_No") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I18) */ ";

			if (j_mrn_where.indexOf("generic_sndx_first") > 0)
			hintIndex = "/*+ INDEX(A MP_PATIENT_I3) */ ";
			if (j_mrn_where.indexOf("generic_sndx_second") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I4) */ ";
			if (j_mrn_where.indexOf("generic_sndx_third") > 0)
			hintIndex = "/*+ INDEX(A MP_PATIENT_I5) */ ";
			if (j_mrn_where.indexOf("generic_sndx_family") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I6) */ ";
			if (j_mrn_where.indexOf("generic_sndx_first_second") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I7) */ ";
			if (j_mrn_where.indexOf("generic_sndx_first_family") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I8) */ ";
			if (j_mrn_where.indexOf("ethnic_sndx_first") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I9) */ ";
			if (j_mrn_where.indexOf("ethnic_sndx_second") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I10) */ ";
			if (j_mrn_where.indexOf("ethnic_sndx_third") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I11) */ ";
			if (j_mrn_where.indexOf("ethnic_sndx_family") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I12) */ ";
			if (j_mrn_where.indexOf("ethnic_sndx_first_second") > 0)
				hintIndex = "/*+ INDEX(A MP_PATIENT_I13) */ ";
			if (j_mrn_where.indexOf("ethnic_sndx_first_family") > 0)
			hintIndex = "/*+ INDEX(A MP_PATIENT_I14) */ ";


			if (j_mrn_where.indexOf("Nationality_code") > 0 && ((((maxRecord/TotalNoRecords)*100) < 5) && (TotalNoRecords > 0)))
				hintIndex = "/*+ INDEX(A MP_PATIENT_I24) */ ";

			if (j_mrn_where.indexOf("Res_Area_Code") > 0 && ((((maxRecord/TotalNoRecords)*100) < 5) && (TotalNoRecords > 0)))
				hintIndex = "/*+ INDEX(A MP_PATIENT_I28) */ ";

			String addlFromForNat = "", addlWhereForNat = "";	
			String orderbyText = " order by "+orderby;
			if (orderby.equalsIgnoreCase("NATIONALITY_CODE"))
			{
				orderbyText = "";
				addlFromForNat = ", MP_COUNTRY_VW ";
				addlWhereForNat = " and nationality_code = country_code ";
				addl_order_by = "";
				if ((((maxRecord/TotalNoRecords)*100) > 1) && (TotalNoRecords > 0))
					hintIndex = "/*+ INDEX(A MP_PATIENT_I24) */ ";
			}
			if (orderby.equalsIgnoreCase("RES_AREA_CODE"))
			{
				orderbyText = "";
				addlFromForNat = ", MP_RES_AREA_VW ";
				addlWhereForNat = " and A.RES_AREA_CODE = MP_RES_AREA_VW.RES_AREA_CODE(+) ";
				addl_order_by = "";
				if ((((maxRecord/TotalNoRecords)*100) > 1) && (TotalNoRecords > 0))
					hintIndex = "/*+ INDEX(A MP_PATIENT_I28) */ ";
			}
			if (orderby.equalsIgnoreCase("PREF_FACILITY_ID"))
			{
				orderbyText = "";
				addlFromForNat = ", SM_FACILITY_PARAM_FOR_SRCH_VW ";
				addlWhereForNat = " and PREF_FACILITY_ID = FACILITY_ID ";
				addl_order_by = "";
				if ((((maxRecord/TotalNoRecords)*100) > 1) && (TotalNoRecords > 0))
					hintIndex = "/*+ INDEX(A MP_PATIENT_I22) */ ";
			}

			if (orderby.equalsIgnoreCase("X"))
				orderbyText = " order by X";

			if (orderby.equalsIgnoreCase("PATIENT_ID") && j_mrn_where.indexOf("Date_Of_Birth") > 0 && j_mrn_where.indexOf("BETWEEN") > 0)
                hintIndex = "/*+ INDEX(A MP_PATIENT_PK) */ ";
			
			/*Based on the no of records and criteria patient id index is used for all&*/
			if (usePatIDIndex.equals("Y"))
				hintIndex = "/*+ INDEX(A MP_PATIENT_PK) */ ";

           if ((((maxRecord/TotalNoRecords)*100) < 1) && (TotalNoRecords > 0) && (j_mrn_where.indexOf("Patient_id like") > 0))
				hintIndex = "/*+ INDEX(A MP_PATIENT_PK) */ ";	

			final_sql = "select "+j_mrn_new_select_outermost+" from"+
                            "(select rownum srlno,"+j_mrn_new_select+" from"+
                                    "(select "+hintIndex+j_mrn_select+" "+j_mrn_from+addlFromForNat+ " "+j_mrn_where+ indexWhere + addlWhereForNat + orderbyText + " )"+
                                 "where rownum < "+ (Hit +1)  +//" )"+
                                ") A "+addl_order_by;
			
        }
        else // D duplicates master
        {
            if (j_mrn_new_select_outermost_dup.indexOf("PATIENT_ID",0)>=0)
            {
                drpos = j_mrn_new_select_outermost_dup.indexOf("PATIENT_ID",0);
                j_mrn_new_select_outermost_dup = j_mrn_new_select_outermost_dup.substring(0,drpos)+"DUPLICATE_"+j_mrn_new_select_outermost_dup.substring(drpos);
            }
            if (j_mrn_select_dup.indexOf("PATIENT_ID",0)>=0)
            {
                drpos = j_mrn_select_dup.indexOf("PATIENT_ID",0);
                j_mrn_select_dup = j_mrn_select_dup.substring(0,drpos)+"DUPLICATE_"+j_mrn_select_dup.substring(drpos);
            }
            if (j_mrn_from_dup.indexOf("MP_PATIENT",0)>=0)
            {
                drpos = j_mrn_from_dup.indexOf("MP_PATIENT",0);
                j_mrn_from_dup = j_mrn_from_dup.substring(0,drpos)+"DR_"+j_mrn_from_dup.substring(drpos);
            }           

            j_mrn_where1 = j_mrn_where1.toUpperCase();
            if (j_mrn_where1.indexOf("PATIENT_ID",0)>=0)
            {
                drpos = j_mrn_where1.indexOf("PATIENT_ID",0);
                j_mrn_where1 = j_mrn_where1.substring(0,drpos)+"DUPLICATE_"+j_mrn_where1.substring(drpos);
            } 

            if (orderby.equalsIgnoreCase("PATIENT_ID"))
                orderby = "DUPLICATE_"+orderby;
            if (orderby.equalsIgnoreCase("Date_of_Birth"))
                orderby= "to_date(date_of_birth,'dd/mm/yyyy')" ;                        

			String addl_order_by = "";
			if (orderby.equalsIgnoreCase("NATIONALITY_CODE"))
				addl_order_by = "order by nationality_desc";
			else if (orderby.equalsIgnoreCase("RES_AREA_CODE"))
				addl_order_by = "order by res_area_desc";
			else if (orderby.equalsIgnoreCase("PREF_FACILITY_ID"))
				addl_order_by = "order by pref_fac_name";

            if (j_mrn_where1.length() > 6)
            {
				if (orderby.equalsIgnoreCase("X")){
                final_sql = "select "+j_mrn_new_select_outermost_dup+" from"+
                            "(select rownum srlno,"+j_mrn_new_select_dup+" from"+
                                    "(select "+j_mrn_select_dup+" "+j_mrn_from_dup+" "+j_mrn_where1+" "+j_where_addl_field_dr+" order by duplicate_patient_id )"+
                                 "where rownum < "+ (Hit +1)  + " order by X" +
                                ") A "+addl_order_by;
				}else{
                final_sql = "select "+j_mrn_new_select_outermost_dup+" from"+
                            "(select rownum srlno,"+j_mrn_new_select_dup+" from"+
                                    "(select "+j_mrn_select_dup+" "+j_mrn_from_dup+" "+j_mrn_where1+" "+j_where_addl_field_dr+" order by duplicate_patient_id )"+
                                 "where rownum < "+ (Hit +1)  + " order by "+ orderby +
                                ") A "+addl_order_by;
				}
            }
            else
            {               
                String j_where_addl_field_dr_sub = j_where_addl_field_dr.substring(0,j_where_addl_field_dr.length()-4);
				if (orderby.equalsIgnoreCase("X")){
                final_sql = "select "+j_mrn_new_select_outermost_dup+" from"+
                            "(select rownum srlno,"+j_mrn_new_select_dup+" from"+
                                    "(select "+j_mrn_select_dup+" "+j_mrn_from_dup+" "+j_mrn_where1+" "+j_where_addl_field_dr_sub+" order by duplicate_patient_id )"+
                                 "where rownum < "+ (Hit +1)  + "  order by X"+ 
                                ") A "+addl_order_by;
				}else{
                final_sql = "select "+j_mrn_new_select_outermost_dup+" from"+
                            "(select rownum srlno,"+j_mrn_new_select_dup+" from"+
                                    "(select "+j_mrn_select_dup+" "+j_mrn_from_dup+" "+j_mrn_where1+" "+j_where_addl_field_dr_sub+" order by duplicate_patient_id )"+
                                 "where rownum < "+ (Hit +1)  + " order by "+ orderby +
                                ") A "+addl_order_by;
				}
            }
        }       
    } 

			
	String multiRec = "";
	if (function_id.equals("") && (search_in.equals("B")||search_in.equals("D")))
		multiRec = "Y";
	else
		multiRec = "N";

            if ((maxRecord == 1) && ((p_no.length()!=0) || (na_no.length()!=0 )) && (srr.equals("Y") && multiRec.equals("N")))
            {                
				if (p_no.length()!=0)
                {
                    w_cls = w_cls + "patient_id like '"+p_no+"%'";
                    w_flag="Y";
                }

                if (na_no.length()!= 0 )
                {
                    if (w_flag.equals("Y"))
                        w_cls= w_cls+" and NATIONAL_ID_NO like '"+na_no+"'";
                    else
                        w_cls= w_cls+" NATIONAL_ID_NO like '"+na_no+"'";
                }
             		
                rs7 = stmt_7.executeQuery("Select A.patient_id  patient_id, Deceased_Yn, Suspend_Yn, Active_Yn "+j_from+" "+j_where);
                rs7.next();
                pat_id = rs7.getString("patient_id");
                String deceased = rs7.getString("Deceased_Yn");
                if(deceased==null)deceased="N";
                String suspend  = rs7.getString("Suspend_Yn");
                if(suspend==null)suspend="N";
                String active = rs7.getString("Active_Yn");
                if(active==null)active="Y";

				if(deceased.equals("N"))
				{
					if(suspend.equals("Y") && !func_act.equals("SUSP") && !func_act.equals("RECD") && !func_act.equals("VIEW"))
					{
						out.println("<script>alert(getMessage('PATIENT_SUSPENDED','MP'));</script>");
					}
					else if(active.equals("N") && !func_act.equals("ACTV") && !func_act.equals("RECD") && !func_act.equals("VIEW"))
                    out.println("<script>alert(getMessage('PATIENT_INACTIVE','MP'));</script>");
					else
					{
						%>
						<script>
							setTimeout('aa()',70);
							function aa()
							{
								var flag='retback';
								if ( (parent.parent.frames[1].document.forms[0].Sex.disabled==true) && (parent.parent.frames[1].document.forms[0].func_idpassed.value!='MP_MAIN_NB_REG') )
									checkExpiry('<%=pat_id%>','<%=jsp_name%>','retback', 'NEWBORN_REG');
								else checkExpiry('<%=pat_id%>','<%=jsp_name%>','retback','');
							}
						</script>
                		<%
					}
				}
                else
                {
					%>
	                <script>
		                setTimeout('aa()',70);
			            function aa()
				        {
					        var flag='retback';
						  	if ( (parent.parent.frames[1].document.forms[0].Sex.disabled==true) && (parent.parent.frames[1].document.forms[0].func_idpassed.value!='MP_MAIN_NB_REG') )
		                        checkExpiry('<%=pat_id%>','<%=jsp_name%>','retback', 'NEWBORN_REG');
			                else checkExpiry('<%=pat_id%>','<%=jsp_name%>','retback','');
					    }
					</script>
                	<%
				}
				out.println("<script>");
				out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
				out.println("parent.frames[2].document.forms[0].Search.disabled = false;");
				out.println("if(parent.frames[1].document.forms[0].maintain_doc_or_file.value == 'D') { ");
				out.println("parent.frames[1].document.forms[0].MRN.disabled = true;");
				out.println("parent.frames[1].document.forms[0].OldFileNo.disabled = true; }");
				out.println("parent.document.frames[1].enableRegister()");
				out.println("</script>");
				if (enablegenderyn.equals("N"))	
					out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");

				//Added by kumar on 16/03/2003 for disabling the searchby when soundex is selected.
				out.println("<script>if (parent.frames[1].document.forms[0].searchby !=null) if (parent.frames[1].document.forms[0].searchby.value =='') parent.frames[1].document.forms[0].searchby.disabled=true;</script>");

				if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
					out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");	
				out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");			
            } // End of if 
            else if (maxRecord >= 1) 
            {
						
                 out.println("<script>");
		
		out.println("</script>");
		if (enablegenderyn.equals("N"))	
			out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");

		if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
		out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");
	out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");
if (patient_id_length<=10)
	{
	
	%>
		<frameset cols='*'>
	<%}
	else
	{

		%>
		<frameset cols='100%' BORDER=0 >
	<%}%>			
			<frame name='PatIdResult' id='PatIdResult' src="../../eCommon/html/blank.html" frameborder=0  framespacing=0 noresize scrolling='no'>
			<!-- <frame name='PatDtlsResult' id='PatDtlsResult' src="../../eCommon/html/blank.html" frameborder=15 framespacing=0 noresize scrolling='auto'> -->
		</frameset>
		<script>
			var htmlVal="<html><body onKeyDown='lockKey()'><form name='f1' id='f1' action='../../eMP/jsp/PatientIDDisplay.jsp' method='post'>"+
						"<input type='hidden' name='From' id='From' value='<%=start%>'>"+
						"<input type='hidden' name='To' id='To' value='<%=end%>'>"+
						"<input type='hidden' name='mode' id='mode' value=''>"+
						"<input type='hidden' name='maxdisplay' id='maxdisplay' value='<%=maxDisplay%>'>"+
						"<input type='hidden' name='maxdisplay1' id='maxdisplay1' value='<%=maxDisplay1%>'>"+
						"<input type='hidden' name='searchthreshold' id='searchthreshold' value='<%=searchThreshold%>'>"+
						"<input type='hidden' name='function_id' id='function_id' value=\"<%=function_id%>\">"+
						"<input type='hidden' name='search_in' id='search_in' value=\"<%=search_in%>\">"+
						"<input type='hidden' name='ip_install_yn' id='ip_install_yn' value='<%=ip_install_yn%>'>"+
						"<input type='hidden' name='op_install_yn' id='op_install_yn' value='<%=op_install_yn%>'>"+
						"<input type='hidden' name='sex' id='sex' value=''>"+
						"<input type='hidden' name='age' id='age' value=''>"+
						"<input type='hidden' name='min_age' id='min_age' value=''>"+
						"<input type='hidden' name='func_act' id='func_act' value=\"<%=func_act%>\">"+
						"<input type='hidden' name='func_idpassed' id='func_idpassed' value="+parent.parent.frames[1].document.forms[0].func_idpassed.value+
						"><input type='hidden' name='j_where_dr' id='j_where_dr' value=\"<%=j_where_dr%>\">"+
						"<input type='hidden' name='j_where_dr_valid' id='j_where_dr_valid' value=\"<%=j_where_dr_valid%>\">"+
						"<input type='hidden' name='j_where_addl_field' id='j_where_addl_field' value=\"<%=j_where_addl_field%>\">"+
						"<input type='hidden' name='j_where_addl_field_dr' id='j_where_addl_field_dr' value=\"<%=j_where_addl_field_dr%>\">"+
						"<input type='hidden' name='j_where_addl_field_dr_valid' id='j_where_addl_field_dr_valid' value=\"<%=j_where_addl_field_dr_valid%>\">"+
						"<input type='hidden' name='allow_nb_review' id='allow_nb_review' value=\"<%=allow_nb_review%>\">"+
						"<input type='hidden' name='j_select' id='j_select' value=\"<%=j_select%>\">"+
						"<input type='hidden' name='j_new_select' id='j_new_select' value=\"<%=j_new_select%>\">"+
						"<input type='hidden' name='j_from' id='j_from' value='<%=j_from%>'>"+
						"<input type='hidden' name='j_where' id='j_where' value=\"<%=j_where%>\">"+
						"<input type='hidden' name='countSQL' id='countSQL' value=\"<%=countsql%>\">"+
						"<input type='hidden' name='orderby' id='orderby' value=\"<%=orderby%>\">"+
						"<input type='hidden' name='Hit_Limit' id='Hit_Limit' value=\"<%=Hit%>\">"+
						"<input type='hidden' name='jsp_name' id='jsp_name' value=\"<%=jsp_name%>\">"+
						"<input type='hidden' name='p_no' id='p_no' value=\"<%=p_no%>\">"+
						"<input type='hidden' name='na_no' id='na_no' value=\"<%=na_no%>\">"+
						"<input type='hidden' name='win_top' id='win_top' value=\"<%=win_top%>\">"+
						"<input type='hidden' name='win_width' id='win_width' value=\"<%=win_width%>\">"+
						"<input type='hidden' name='win_height' id='win_height' value=\"<%=win_height%>\">"+
						"<input type='hidden' name='act_yn' id='act_yn' value=\"<%=act_yn%>\">"+
						"<input type='hidden' name='srr' id='srr' value=\"<%=srr%>\">"+
						"<input type='hidden' name='old_file_no_where' id='old_file_no_where' value=\"<%=old_file_no_where%>\">"+
						"<input type='hidden' name='file_no_where' id='file_no_where' value=\"<%=file_no_where%>\">"+
						"<input type='hidden' name='MRN' id='MRN' value=\"<%=MRN%>\">"+
						"<input type='hidden' name='OldFileNo' id='OldFileNo' value=\"<%=OldFileNo%>\">"+
						"<input type='hidden' name='apply_oth_name' id='apply_oth_name' value=\"<%=apply_oth_name%>\">"+
						"<input type='hidden' name='dr_merge_valid' id='dr_merge_valid' value=\"<%=dr_merge_valid%>\">"+
						"<input type='hidden' name='full_sql' id='full_sql' value=\"<%=full_sql%>\">"+
						"<input type='hidden' name='cntPrefFac' id='cntPrefFac' value=\"<%=cntPrefFac%>\">"+
						"<input type='hidden' name='usePatIDIndex' id='usePatIDIndex' value=\"<%=usePatIDIndex%>\">"+
						"<input type='hidden' name='view_pat_photo_yn' id='view_pat_photo_yn' value=\"<%=view_pat_photo_yn%>\">	"+
						"<input type='hidden' name='TotalNoRecords' id='TotalNoRecords' value=\"<%=TotalNoRecords%>\">"+
						"<input type='hidden' name='enablegenderyn' id='enablegenderyn' value=\"<%=enablegenderyn%>\">"+
						"<input type='hidden' name='maxRecord' id='maxRecord' value=\"<%=maxRecord%>\">"+"<input type='hidden' name='final_sql' id='final_sql' value=\"<%=final_sql%>\">"+ // Added on 08/11/2004
						"<input type='hidden' name='totalpercent' id='totalpercent' value=\"<%=totalpercent%>\">"+
						"<input type='hidden' name='photo' id='photo' value=\"<%=photo%>\">"+
						"<input type='hidden' name='alignment' id='alignment' value=\"<%=alignment%>\">"+
						"<input type='hidden' name='othlang' id='othlang' value=\"<%=othlang%>\">"+		// End addition on 08/11/2004
						"</form></body></html>"
			
			// Added on 08/11/2004
			
			//var htmlPatFrame = "<html><body><form name='f1' id='f1' action='../../eMP/jsp/PatientIDDisplay.jsp' method='post'>"+htmlVal
			PatIdResult.document.write(htmlVal);
			PatIdResult.document.f1.submit(); 
			
		/*	var htmlPatDtlFrame ="<html><body><form name='f2' id='f2' action='../../eMP/jsp/PatientDetailsDisplay.jsp' method='post'>"+htmlVal
			PatDtlsResult.document.write(htmlPatDtlFrame);
			PatDtlsResult.document.f2.submit();
			*/
			//End of addition on 08/11/2004
			
		</script>
  <%          }// End of else (final_sql)
			  else
			  {
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				out.println("<script>");
				out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
				out.println("parent.frames[2].document.forms[0].Search.disabled = false;");
				out.println("if(parent.frames[1].document.forms[0].maintain_doc_or_file.value == 'D') { ");
				out.println("parent.frames[1].document.forms[0].MRN.disabled = true;");
				out.println("parent.frames[1].document.forms[0].OldFileNo.disabled = true; }");
				out.println("if (parent.frames[2].document.forms[0].register !=null)				parent.frames[2].document.forms[0].register.disabled=false;");

				out.println("parent.document.frames[1].enableRegister()");
				out.println("</script>");
				//Added by kumar on 16/03/2003 for disabling the searchby when soundex is selected.
				out.println("<script>if (parent.frames[1].document.forms[0].searchby !=null) if (parent.frames[1].document.forms[0].searchby.value =='') parent.frames[1].document.forms[0].searchby.disabled=false;</script>");

				if (enablegenderyn.equals("N"))	
					out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");
				 if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
				out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");	
				out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");			
			  }
}
catch(Exception e) {
    e.printStackTrace();
    out.println("Error : " + e);
	out.println("<script>");
	out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
	out.println("parent.frames[2].document.forms[0].Search.disabled = false;");
	out.println("if(parent.frames[1].document.forms[0].maintain_doc_or_file.value == 'D') {");
	out.println("parent.frames[1].document.forms[0].MRN.disabled = true;");
	out.println("parent.frames[1].document.forms[0].OldFileNo.disabled = true; }");
	out.println("parent.document.frames[1].enableRegister()");
	out.println("</script>");
	//Added by kumar on 16/03/2003 for disabling the searchby when soundex is selected.
	out.println("<script>if (parent.frames[1].document.forms[0].searchby !=null) if (parent.frames[1].document.forms[0].searchby.value =='') parent.frames[1].document.forms[0].searchby.disabled=true;</script>");
	if (enablegenderyn.equals("N"))	
		out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");
	if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
		out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");
	out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");			
}
finally {    
    if(rs != null) rs.close();
	if(rsx != null) rsx.close();
    if(rs1 != null) rs1.close();
    if(rs2 != null) rs2.close();
    if(rs3 != null) rs3.close();
    if(rs4 != null) rs4.close();
    if(rs5 != null) rs5.close();
    if(rs6 != null) rs6.close();
	if(rsnew != null) rsnew.close();
	if(stmt != null) stmt.close();
	if (stmtx!=null) stmtx.close();
	if (stmt_7!=null) stmt_7.close();
	if (stmt8!=null) stmt8.close();
	if (stmt_new!=null) stmt_new.close();
	if (pstmt_new!=null) pstmt_new.close();	
    }

%>
<input type="hidden" name="From" id="From" value="<%=start%>">
<input type="hidden" name="To" id="To" value="<%=end%>">
<input type="hidden" name="mode" id="mode" value="">
<input type="hidden" name="maxdisplay" id="maxdisplay" value="<%=maxDisplay%>">
<input type="hidden" name="maxdisplay1" id="maxdisplay1" value="<%=maxDisplay1%>">
<input type="hidden" name="searchthreshold" id="searchthreshold" value="<%=searchThreshold%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="search_in" id="search_in" value="<%=search_in%>">
<input type="hidden" name="ip_install_yn" id="ip_install_yn" value="<%=ip_install_yn%>">
<input type="hidden" name="op_install_yn" id="op_install_yn" value="<%=op_install_yn%>">
<input type="hidden" name="sex" id="sex" value="">
<input type="hidden" name="age" id="age" value="">
<input type="hidden" name="min_age" id="min_age" value="">
<input type="hidden" name="func_act" id="func_act" value="<%=func_act%>">
<input type="hidden" name="j_where_dr" id="j_where_dr" value="<%=j_where_dr%>">
<input type="hidden" name="j_where_dr_valid" id="j_where_dr_valid" value="<%=j_where_dr_valid%>">
<input type="hidden" name="j_where_addl_field" id="j_where_addl_field" value="<%=j_where_addl_field%>">
<input type="hidden" name="j_where_addl_field_dr" id="j_where_addl_field_dr" value="<%=j_where_addl_field_dr%>">
<input type="hidden" name="j_where_addl_field_dr_valid" id="j_where_addl_field_dr_valid" value="<%=j_where_addl_field_dr_valid%>">
<input type="hidden" name="allow_nb_review" id="allow_nb_review" value="<%=allow_nb_review%>">


<input type="hidden" name="j_select" id="j_select" value="<%=j_select%>">
<input type="hidden" name="j_new_select" id="j_new_select" value="<%=j_new_select%>">
<input type="hidden" name="j_from" id="j_from" value="<%=j_from%>">

<input type="hidden" name="j_where" id="j_where" value="<%=j_where%>">
<input type="hidden" name="countSQL" id="countSQL" value="<%=countsql%>">
<input type="hidden" name="orderby" id="orderby" value="">
<input type="hidden" name="Hit_Limit" id="Hit_Limit" value="<%=Hit%>">
<input type="hidden" name="jsp_name" id="jsp_name" value="<%=jsp_name%>">
<input type="hidden" name="p_no" id="p_no" value="<%=p_no%>">
<input type="hidden" name="na_no" id="na_no" value="<%=na_no%>">
<input type="hidden" name="win_top" id="win_top" value="<%=win_top%>">
<input type="hidden" name="win_width" id="win_width" value="<%=win_width%>">
<input type="hidden" name="win_height" id="win_height" value="<%=win_height%>">
<input type="hidden" name="act_yn" id="act_yn" value="<%=act_yn%>">
<input type="hidden" name="srr" id="srr" value="<%=srr%>">
<input type="hidden" name="old_file_no_where" id="old_file_no_where" value="<%=old_file_no_where%>">
<input type="hidden" name="file_no_where" id="file_no_where" value="<%=file_no_where%>">
<input type="hidden" name="MRN" id="MRN" value="<%=MRN%>">
<input type="hidden" name="OldFileNo" id="OldFileNo" value="<%=OldFileNo%>">
<input type="hidden" name="apply_oth_name" id="apply_oth_name" value="<%=apply_oth_name%>">
<input type="hidden" name="dr_merge_valid" id="dr_merge_valid" value="<%=dr_merge_valid%>">
<input type="hidden" name="cntPrefFac" id="cntPrefFac" value="<%=cntPrefFac%>">	
<input type="hidden" name="usePatIDIndex" id="usePatIDIndex" value="<%=usePatIDIndex%>">	
<input type="hidden" name="view_pat_photo_yn" id="view_pat_photo_yn" value="<%=view_pat_photo_yn%>">	
<input type="hidden" name="TotalNoRecords" id="TotalNoRecords" value="<%=TotalNoRecords%>">	
<input type="hidden" name="enablegenderyn" id="enablegenderyn" value="<%=enablegenderyn%>">		
</CENTER></HTML>
<%}
}
catch(Exception e){/* out.println("Exception ::"+e); */ e.printStackTrace();}
finally{
if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

