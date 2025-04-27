package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotescomputedateformula extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesComputeDateFormula.jsp", 1709116119887L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n</head>\n<body class=\"message\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tif(top.content!=null && top.content.workAreaFrame.RecClinicalNotesFrame != null){\n\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".value= \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\t}else if(parent.RecClinicalNotesTemplateFrame != null){\n\t\t\t\t\tparent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t}else if(parent.recMatConsDetailsFrame != null){\n\t\t\t\t\tparent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\t}else if(top.content.workAreaFrame.recMatConsDetailsFrame != null){\n\t\t\t\t\ttop.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t\t// Added by Sridhar Reddy on 19/10/2009 PMG20089-CRF-0690\n\t\t\t\t\tvar formObj = top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm;\n\t\t\t\t\tvar nodeList = formObj.elements.length;\n\t\t\t\t\tvar EddCompID = ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =".substring(0,9);\t\t\t\n\t\t\t\t\tfor (var i=0; i<nodeList;i++ ){\t\t\t\n\t\t\t\t\t\tif (formObj.elements[i].type == \'text\' && formObj.elements[i].name.length >= 17 &&   formObj.elements[i].name.substring(0,17) == \'C_MC01CORRECTDEDD\' && EddCompID==\'C_MC01EDD\'){\t\t\n\t\t\t\t\t\t\tformObj.elements[i].value =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
14/12/2012		IN030681		ChowminyaG		ARTIMIS:The formula logic which is used to calculate certain values in the notes is not working
28/04/2017		INC61905		Dinesh T		The Scoring functionality In Notes should work in the similar manner as in 														Charts i.e on selection of individual variable, the score gets automatically 													calculated
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
08/05/2017	IN063962		Dinesh T									ML-MMOH-CRF-0557_UT1
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
	String  locale = (String) p.getProperty("LOCALE");
	String firstComponent		= request.getParameter("firstComponent")==null?"":request.getParameter("firstComponent");
	String secondComponent	= request.getParameter("secondComponent")==null?"":request.getParameter("secondComponent");
	String formulaResultUnit		= request.getParameter("formulaResultUnit")==null?"":request.getParameter("formulaResultUnit");
	String formulaCompID		= request.getParameter("formulaCompID")==null?"":request.getParameter("formulaCompID");
	String formula_result_type	= request.getParameter("formula_result_type")==null?"":request.getParameter("formula_result_type");
	String mcOnBlur	= request.getParameter("mcOnBlur")==null?"N":request.getParameter("mcOnBlur");
	String formula_operator		= request.getParameter("formula_operator")==null?"":request.getParameter("formula_operator");
	String l_sys_date_time_in_en_yn		= request.getParameter("sysDateTimeInEnYN")==null?"":request.getParameter("sysDateTimeInEnYN");//IN063962

	String temp_secondComponent ="";

	String unit_of_gest_nb = "";
	int ga_weeks = 0;
	int ga_days = 0;
	
	
	//INC61905, starts - Comments : Refreshing the formula component, when the main component value is removed.
	out.println("<script>");
				
	out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");
	out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
	out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");
	out.println("}else if(parent.recMatConsDetailsFrame != null){");
	
	out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");
	out.println("} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null)");
	
	out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");

	out.println("</script>");
	//INC61905, ends
	
	if(!firstComponent.equals("") && !secondComponent.equals(""))
	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		
		//StringBuffer qry = new StringBuffer();
		StringBuilder qry = new StringBuilder();
		String formulaResult = "";
		
		
		try
		{		
		 con = ConnectionManager.getConnection(request);
			
		  if(mcOnBlur.equals("Y"))
		  {
			 String temp2[]= new String[4];
			 String strs[] = formulaCompID.split("%");
			 if(strs.length>0)
			 {
			  int i =0;
			  while(i<2)
			   {
				 temp2 = strs[i].split("~");
				 formulaCompID = temp2[0];	
				 formula_result_type = temp2[1];
				 formulaResultUnit = temp2[2];
				 formula_operator = temp2[3];

				 if(formula_result_type.equals("N"))
			    {
					if(formulaResultUnit.equals("Years"))
						qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))/12) FROM DUAL");
					else if (formulaResultUnit.equals("Months"))
						qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))) FROM DUAL");
					else if(formulaResultUnit.equals("Weeks"))
						qry.append("SELECT  trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))/7) FROM DUAL");
					else if(formulaResultUnit.equals("Days"))
						qry.append("SELECT trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI')) FROM DUAL");
					else if(formulaResultUnit.equals("Hours"))
						qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*24) FROM DUAL");
					else if(formulaResultUnit.equals("Minutes"))
						qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*1440) FROM DUAL");
					
					
					//temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");
					String dateTime[] = secondComponent.split(" ");//IN063962
					if(dateTime.length==1){
						temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");
					}else{
						temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMYHM", locale, "en");
					}

					stmt = con.prepareStatement(qry.toString());
					stmt.setString(1, firstComponent);
					stmt.setString(2, temp_secondComponent);
					rs = stmt.executeQuery();
					if(rs.next())
						formulaResult = rs.getString(1);



					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				else if(formula_result_type.equals("D"))
				{
					qry.setLength(0);
					
					//formulaResultUnit = "Weeks";
					firstComponent= secondComponent ;
					secondComponent = "40";

					if(formulaResultUnit.equals("Minutes") || formulaResultUnit.equals("Hours") || formulaResultUnit.equals("Days") || formulaResultUnit.equals("Weeks"))
					{
						qry.append("select to_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')");
						if(formula_operator.equals("MINUS"))
							qry.append("-");
						else
							qry.append("+");
						qry.append(" ? * DECODE(?,'Minutes',(1/1440),'Hours',(1/24),'Days',1,'Weeks',7,0 ), 'DD/MM/YYYY hh24:mi') from dual");
					}
					else
					{
						qry.append("SELECT  to_char(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");
						if(formula_operator.equals("MINUS"))
							qry.append("-");
						else
							qry.append("+");
						qry.append("? *(decode(?,'Years',12,1)) ),'dd/mm/yyyy hh24:mi') FROM DUAL");
					}


					stmt = con.prepareStatement(qry.toString());
					stmt.setString(1, firstComponent);
					stmt.setString(2, secondComponent);
					stmt.setString(3, formulaResultUnit);			

					
					rs = stmt.executeQuery();
					if(rs.next())
						formulaResult = rs.getString(1);
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();				
					int index = formulaResult.lastIndexOf("00:00");
					if(index != -1)
					{
						//StringBuffer temp = new StringBuffer(formulaResult);
						StringBuilder temp = new StringBuilder(formulaResult);
						formulaResult = temp.substring(0, 10);
					}				
			    }
			//out.println("formulaResult=" + formulaResult);
				out.println("<script>");
				
				out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
				out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
				out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
				out.println("}else if(parent.recMatConsDetailsFrame != null){");
				
				out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
				out.println("} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null)");
				
				out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");

				out.println("</script>");

				i++;
			   }
		     }
			

		  }
			else{

			if(formula_result_type.equals("N"))
			{
				if(formulaResultUnit.equals("Years"))
					qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))/12) FROM DUAL");
				else if (formulaResultUnit.equals("Months"))
					qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))) FROM DUAL");
				else if(formulaResultUnit.equals("Weeks"))
					qry.append("SELECT  trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))/7) FROM DUAL");
				else if(formulaResultUnit.equals("Days"))
					qry.append("SELECT trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI')) FROM DUAL");
				else if(formulaResultUnit.equals("Hours"))
					qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*24) FROM DUAL");
				else if(formulaResultUnit.equals("Minutes"))
					qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*1440) FROM DUAL");

				//temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");
				String dateTime[] = secondComponent.split(" ");//IN063962
				if(dateTime.length==1){
					temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");
				}else{
					temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMYHM", locale, "en");
				}

				stmt = con.prepareStatement(qry.toString());
				stmt.setString(1, firstComponent);
				stmt.setString(2, temp_secondComponent);
				rs = stmt.executeQuery();
				if(rs.next())
					formulaResult = rs.getString(1)==null?"": rs.getString(1);

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

				String ges_comp_id ="";
				if (formulaCompID.length() >= 16)
				{
					ges_comp_id = formulaCompID.substring(2,14);
				}

				if(ges_comp_id.equals("MC01GESTNAGE") && !formulaResult.equals(""))
				{												

					String sqlQry = "SELECT NVL(UNIT_OF_GEST_NB,'D')  UNIT_OF_GEST_NB,NVL(max_gestation,0) max_gestation,NVL(min_gestation,0) min_gestation FROM MP_PARAM";
					stmt = con.prepareStatement(sqlQry);
					rs = stmt.executeQuery();
					if(rs.next()){
						unit_of_gest_nb = rs.getString("UNIT_OF_GEST_NB")==null?"D": rs.getString("UNIT_OF_GEST_NB");						
					}
					

					if(unit_of_gest_nb.equalsIgnoreCase("W"))
					{
						ga_weeks = Integer.parseInt(formulaResult)/7;
						ga_days = Integer.parseInt(formulaResult)%7;						
						String weekLabel = "";
						String daysLabel = "";
						if(ga_weeks == 1)
							weekLabel  = ga_weeks + " Week";
						else if(ga_weeks > 1)
							weekLabel  = ga_weeks + " Weeks";

						if(ga_days == 1)
							daysLabel  = ga_days+" Day";
						else if(ga_days > 1)
							daysLabel  = ga_days+" Days";

						if(weekLabel.equals("") && daysLabel.equals(""))
							formulaResult = "0";
						else
							formulaResult =weekLabel+" "+daysLabel;
					}else if(unit_of_gest_nb.equalsIgnoreCase("D")){
							if(Integer.parseInt(formulaResult) == 1)
								formulaResult = formulaResult + " Day";
							else
								formulaResult = formulaResult + " Days";
					}

					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}

				
			}
			else if(formula_result_type.equals("D"))
			{

				String dateTime[] = firstComponent.split(" ");//IN063962

				if(formulaResultUnit.equals("Minutes") || formulaResultUnit.equals("Hours") || formulaResultUnit.equals("Days") || formulaResultUnit.equals("Weeks"))
				{
					qry.append("select to_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')");
					if(formula_operator.equals("MINUS"))
						qry.append("-");
					else
						qry.append("+");
					qry.append(" ? * DECODE(?,'Minutes',(1/1440),'Hours',(1/24),'Days',1,'Weeks',7,0 ), 'DD/MM/YYYY hh24:mi') from dual");
				}
				else
				{
					qry.append("SELECT  to_char(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");
					if(formula_operator.equals("MINUS"))
						qry.append("-");
					else
						qry.append("+");
					qry.append("? *(decode(?,'Years',12,1)) ),'dd/mm/yyyy hh24:mi') FROM DUAL");
				}
				//out.println("qry ="+qry.toString()+"=");
				//out.println("firstComponent ="+firstComponent+"=");
				//out.println("secondComponent ="+secondComponent+"=");
				stmt = con.prepareStatement(qry.toString());
				stmt.setString(1, firstComponent);
				stmt.setString(2, secondComponent);
				stmt.setString(3, formulaResultUnit);				
				rs = stmt.executeQuery();
				if(rs.next())
					formulaResult = rs.getString(1);
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();				
				//IN063962, starts
				/*int index = formulaResult.lastIndexOf("00:00");
				if(index != -1)
				{
					StringBuffer temp = new StringBuffer(formulaResult);
					formulaResult = temp.substring(0, 10);
				}*/
				if(dateTime.length == 1)
				{
					StringBuilder temp = new StringBuilder(formulaResult);
					formulaResult = temp.substring(0, 10);
					
					if("Y".equals(l_sys_date_time_in_en_yn))
						formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMY", "en",locale);
				}
				else
				{
					if("Y".equals(l_sys_date_time_in_en_yn))
						formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMYHM", "en",locale);
				}
				//IN063962, ends
			}
			//-Start -[IN030681] - Updated Artimis 
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(formulaCompID ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(formulaResult ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(formulaCompID ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(formulaResult ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(formulaCompID ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(formulaResult ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(formulaCompID ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(formulaResult ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formulaCompID ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(formulaResult ));
            _bw.write(_wl_block15Bytes, _wl_block15);

			//-End -[IN030681] - Updated Artimis 
			//-Commentted -[IN030681] - Updated Artimis 
			/*out.println("<script>");
			
			out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");	
			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
			out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else if(parent.recMatConsDetailsFrame != null){");
			out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null){");
			out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			// Added by Sridhar Reddy on 19/10/2009 PMG20089-CRF-0690
			out.println("var formObj = top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm;");
			out.println("var nodeList = formObj.elements.length;");
			out.println("var EddCompID = '"+formulaCompID.substring(0,9)+"'");			
			out.println("for (var i=0; i<nodeList;i++ ){");			
			out.println("if (formObj.elements[i].type == 'text' && formObj.elements[i].name.length >= 17 &&   formObj.elements[i].name.substring(0,17) == 'C_MC01CORRECTDEDD' && EddCompID=='C_MC01EDD'){");			
			out.println("	formObj.elements[i].value ='"+formulaResult+"';}}");	
			
			//End	

			out.println("}");
			out.println("</script>");*/ //-Commentted -[IN030681] - Updated Artimis 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception --->" + e);//common-icn-0181
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		}
	}	

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
