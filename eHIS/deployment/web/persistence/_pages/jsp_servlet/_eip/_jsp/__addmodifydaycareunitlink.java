package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;

public final class __addmodifydaycareunitlink extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eip/jsp/addModifyDayCareUnitLink.jsp", 1709117692301L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../js/DayCareUnitLink.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'//chkForSelectAll(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =");\' class=\'CONTENT\' >\n<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eIP/jsp/addModifyDayCareUnitLink.jsp\' method=\'post\' >\n\n<table  width=\'90%\' border=0 align=\'center\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n<input type=hidden name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=hidden name=\'clinic_code\' id=\'clinic_code\' value=\'\'>\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n<input type=hidden name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=hidden name=\'allValues\' id=\'allValues\' value=\'\'>\n<input type=\"hidden\" name=\"search_by\" id=\"search_by\" value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n<input type=\"hidden\" name=\"search_txt\" id=\"search_txt\" value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</td>\n</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<th width=\'60%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <br><!-- <input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =");\'> --></th>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" name=\'chk";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onclick=\"checkdis(this);RemSelectAll(this, ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'removeCode";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' value=\"\"><input type=\'hidden\' name=\'spclCode";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'spclCode";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"nextval\").innerHTML=\" \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet DayCareUnitSpeciality= null;synchronized(session){
                DayCareUnitSpeciality=(webbeans.eCommon.RecordSet)pageContext.getAttribute("DayCareUnitSpeciality",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(DayCareUnitSpeciality==null){
                    DayCareUnitSpeciality=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("DayCareUnitSpeciality",DayCareUnitSpeciality,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 request.setCharacterEncoding("UTF-8"); String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String req_start = "", req_end  = "";
        String checkedOnes  = "";
        String from	= request.getParameter("from") ;
        String to	= request.getParameter("to") ;
        //int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
        String removeCode = "";

       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus    ="";
	Connection con      = null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	Statement stmt		= null;
	ResultSet rs		= null ;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";

	try{
	con = ConnectionManager.getConnection(request);

	String facility_id			= (String)session.getValue("facility_id");
	String nursing_unit_code	= request.getParameter("nursing_unit_code");
	String flagSelect			= request.getParameter("fromSelect");

	String search_by		= (request.getParameter("search_by"));
	String search_txt		= (request.getParameter("search_txt"));
	
	String search_criteria	=  "";
	String search_criteria2	=  "";
	String search_criteria3	=  "";

	if(search_by.equals("ID")) search_by = "01";
	if(search_by.equals("DESC")) search_by = "02";
	if(search_by.equals("")||(search_by == null)) search_by = "00";

	if(search_by != null && !search_by.equals("00"))
	{
	  if(search_txt != null && !search_txt.equals(""))
	  {
		if(search_by.equals("01"))
		  {
			  search_criteria  = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
			  search_criteria2 = " and UPPER(b.CLINIC_CODE) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
		  }
		 else if(search_by.equals("02"))
		  {	
			  search_criteria  = " and UPPER(CLINIC_SHORT_DESC) like UPPER('"+search_txt+"%')  ";
			  search_criteria2 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
		  }
	  }
	}

//CLINIC_SHORT_DESC -- CLINIC_CODE

//CLINIC_CODE -- SHORT_DESC

	if(flagSelect !=null)
	{
		DayCareUnitSpeciality.clearAll();
		StringBuffer sqlinsVals = new StringBuffer();
		sqlinsVals.append( " select clinic_code from ip_dc_unit_for_nurs_unit_vw   where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facility_id+"' ");
		sqlinsVals.append(search_criteria);

		stmt3=con.createStatement();
		rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());
		if(rstlRs3 !=null)
		{
			 while(rstlRs3.next())
			 {
				DayCareUnitSpeciality.putObject(rstlRs3.getString(1));
			 }
		if(rstlRs3!=null) rstlRs3.close();
		if(stmt3!=null) stmt3.close();
		}
	}
             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(DayCareUnitSpeciality.containsObject(checkedOnes)))
                                 DayCareUnitSpeciality.putObject(checkedOnes);
                             j++;
                         }

						removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclCode = request.getParameter("spclCode"+(i));
							if((DayCareUnitSpeciality.containsObject(spclCode)))
							{
								int removeCodeIndex = DayCareUnitSpeciality.indexOfObject(spclCode);
								DayCareUnitSpeciality.removeObject(removeCodeIndex);
							}
						}
                     }

                 out.println("<input type= hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type= hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
		int cnt = 0;
		int nextOfRes = 1;
			String classValue="";
			String chkAttribute="";
			StringBuffer sql = new StringBuffer();
			
	  sql.append("select a.facility_id,a.nursing_unit_code,a.clinic_code dc_cliniccode,b.clinic_code op_cliniccode, b.short_desc from ip_dc_unit_for_nurs_unit a, op_clinic b where a.facility_id  = '"+facility_id+"' and a.nursing_unit_code = '"+nursing_unit_code+"' and  a.facility_id (+) = b.facility_id  and a.clinic_code (+) = b.clinic_code and   b.eff_status = 'E' ");
	  sql.append(search_criteria2);
	  sql.append(" union select facility_id, null, null ,clinic_code op_cliniccode ,  short_desc from op_clinic where facility_id = '"+facility_id+"' and care_locn_type_ind = 'D' and eff_status = 'E'  and clinic_code not in ( select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') ");
	  sql.append(search_criteria3);
	  sql.append(" order by short_desc ");

/*try{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql.toString());
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();

	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		return;
	}

	}catch(Exception e){out.println(e);}*/

	//out.println(sql.toString());

	

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	
	if (start != 0){
	    for(int j=1; j<=start; i++,j++){
		rs.next() ;
		}
	}

	while( i<=end && rs.next() ){ 
		if(cnt == 0)
		{


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block19Bytes, _wl_block19);

    if ( !(start <= 1)) {

    out.println("<a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	
            _bw.write(_wl_block20Bytes, _wl_block20);

    }
    if ( nextOfRes == 1 ){

    out.println("<a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none' id='nextval'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	
            _bw.write(_wl_block21Bytes, _wl_block21);

    }

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block25Bytes, _wl_block25);
	 
		}
		/*if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ */
			String speciality_code=rs.getString("op_cliniccode");
			String short_desc=rs.getString("short_desc");

			if(DayCareUnitSpeciality.containsObject(speciality_code))  
				chkAttribute = "CHECKED";
			else
				chkAttribute = "";

			int recordIndex = DayCareUnitSpeciality.indexOfObject(speciality_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED")){
				DayCareUnitSpeciality.removeObject(recordIndex);
			}
		
				if( i%2 == 0)  
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block38Bytes, _wl_block38);

			i++;
			cnt++;
			}	
			if(cnt == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				return;
			}

			if( !rs.next() && cnt!=0 )
			{
				nextOfRes = 0;
			
            _bw.write(_wl_block39Bytes, _wl_block39);

			}
			if(rs!=null) rs.close();
			if(rstlRs3 != null)rstlRs3 = null; 
			if(stmt!=null) stmt.close();
			 if(stmt3 != null)	stmt3 = null; 
		 }catch(Exception e)
		 {
			 out.println(e);
		 }
		 finally
		 {
			ConnectionManager.returnConnection(con,request);
			session.setAttribute("DayCareUnitSpeciality", DayCareUnitSpeciality);
		 }
            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DaycareUnit.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
