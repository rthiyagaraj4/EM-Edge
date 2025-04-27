package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __maternityconsperformaction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MaternityConsPerformAction.jsp", 1709115930402L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n</head>\n<body class=\"message\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

 request.setCharacterEncoding("UTF-8");
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
	String  locale = (String) p.getProperty("LOCALE");
	
	String sec_hdg_code		= request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String action_item_code		= request.getParameter("action_item_code")==null?"":request.getParameter("action_item_code");
	String action_item_srlno		= request.getParameter("action_item_srlno")==null?"":request.getParameter("action_item_srlno");
	String action_item_val		= request.getParameter("action_item_val")==null?"":request.getParameter("action_item_val");
	String inputComp		= request.getParameter("inputComp")==null?"":request.getParameter("inputComp");
	
	String InComp[] = inputComp.split("~");


	
	String firstComponent		= "";
	String secondComponent		= "";
	String formulaResultUnit	= "";
	String formulaCompID		= "";
	String formula_result_type		= "";
	String formula_operator		= "";
	String target_item_code		= "";
	String target_item_srlno		= "";
	String action_type		= "";
	String dep_definition		= "";
	String tempDefComp[]= new String[3];

	StringBuffer qry  ;
	String formulaResult = "";
	String unit_of_gest_nb = "";
	int ga_weeks = 0;
	int ga_days = 0;
	
	   
	Connection con = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rs = null;		
	ResultSet rs1 = null;	
	
	//String Second_comp_Temp[];
	String sysdate="" ;

	String SqlGetActionList =" SELECT TRIM(A.TARGET_ITEM_CODE),TRIM(A.TARGET_ITEM_SRLNO),A.ACTION_TYPE, B.DEP_DEFINITION, B.FORMULA_RESULT_TYPE,FORMULA_RESULT_UNIT FROM CA_SPLTY_TEMP_ACTION_LIST A, CA_SECTION_TEMPLATE B WHERE A.SEC_HDG_CODE=? AND A.ACTION_ITEM_CODE=? AND A.ACTION_ITEM_SRLNO=? AND B.SEC_HDG_CODE(+)=A.SEC_HDG_CODE AND B.SRL_NO(+)=TARGET_ITEM_SRLNO "; 

	try
	{

		con = ConnectionManager.getConnection(request);
		String dateSql ="select to_char(sysdate, 'dd/mm/yyyy') systemDate  from dual";
		stmt		=	con.prepareStatement(dateSql);
		rs			=	stmt.executeQuery();

		if(rs.next())
		{
			sysdate			= rs.getString("systemDate");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

		stmt = con.prepareStatement(SqlGetActionList);		
		
		stmt.setString(1, sec_hdg_code);
		stmt.setString(2, action_item_code);
		stmt.setString(3, action_item_srlno);
		
		rs = stmt.executeQuery();
		
		
		while(rs.next())
		{
		
			
			target_item_code	= rs.getString(1);
			target_item_srlno	= rs.getString(2);
			action_type			= rs.getString(3);
			dep_definition		= rs.getString(4);
			formula_result_type = rs.getString(5);
			formulaResultUnit	= rs.getString(6);
			 
			formulaCompID ="C_"+target_item_code+target_item_srlno;

			if (dep_definition.indexOf("~") != -1)
			{
				tempDefComp = dep_definition.split("~");
				
				String First_temp = tempDefComp[0].substring(tempDefComp[0].indexOf("$$$")+3,tempDefComp[0].indexOf("###"));
				if (First_temp.indexOf("!") != -1)
				{
					String First_comp_Temp[] = First_temp.split("!");
					
					if(First_comp_Temp.length>1)
						firstComponent=First_comp_Temp[0] + First_comp_Temp[1];
					else 
						firstComponent=First_comp_Temp[0];
				}
									
				
				formula_operator = tempDefComp[1];
				
				String Second_temp = tempDefComp[2].substring(tempDefComp[2].indexOf("$$$")+3,tempDefComp[2].indexOf("###"));
				//if (Second_temp.indexOf("!") != -1)
				String Second_comp_Temp[] = Second_temp.split("!");
				
				if(Second_comp_Temp.length>1)
					secondComponent = Second_comp_Temp[0]+Second_comp_Temp[1];
				else 
					secondComponent = Second_temp;


				
				if(inputComp.equals(""))
				{
					
					if(firstComponent.equals(action_item_code+action_item_srlno))
					{
						firstComponent= action_item_val;
					}
					else if(secondComponent.equals(action_item_code+action_item_srlno))
					{
						secondComponent= action_item_val;	
					}

					if(firstComponent.equals("systemDate99999A"))
					{
						firstComponent=sysdate;
					}
					else if(secondComponent.equals("systemDate99999A"))
					{
						secondComponent=sysdate;
					}
								
				}
				else 
				{
					 for(int j=0;j<InComp.length;++j)
					
						{
							if(firstComponent.equals(InComp[j]))
								{
									firstComponent= request.getParameter(InComp[j]);
								}
							else if(firstComponent.equals("systemDate99999A"))
								{
									firstComponent=sysdate;
								} 

							if(secondComponent.equals(InComp[j]))
								{
									secondComponent= request.getParameter(InComp[j]);
								}
							else if (secondComponent.equals("systemDate99999A"))
								{
									secondComponent=sysdate;
								}
						}

				 }
 
			 }

						 

			if(formula_result_type.equals("N"))
			{
				qry = new StringBuffer();
				
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
				
				//String temp_firstComponent = com.ehis.util.DateUtils.convertDate(firstComponent, "DMY", locale, "en");
				String temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");

				stmt1 = con.prepareStatement(qry.toString());
				stmt1.setString(1, firstComponent);
				stmt1.setString(2, temp_secondComponent);
				rs1 = stmt1.executeQuery();
				if(rs1.next())
					formulaResult = rs1.getString(1);



				if(rs1!=null) rs1.close();
				if(stmt1!=null) stmt1.close();

				String ges_comp_id ="";
				if (formulaCompID.length() >= 16)
				{
					ges_comp_id = formulaCompID.substring(2,14);
				}

				if(ges_comp_id.equals("MC01GESTNAGE") && !formulaResult.equals(""))
				{		
					
					//String gestValidMsg = "";
					String sqlQry = "SELECT NVL(UNIT_OF_GEST_NB,'D')  UNIT_OF_GEST_NB,NVL(max_gestation,0) max_gestation,NVL(min_gestation,0) min_gestation FROM MP_PARAM";
					stmt1 = con.prepareStatement(sqlQry);
					rs1 = stmt1.executeQuery();
					if(rs1.next()){
						unit_of_gest_nb = rs1.getString("UNIT_OF_GEST_NB")==null?"D": rs1.getString("UNIT_OF_GEST_NB");					
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

					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
				}
				
			}
			else if(formula_result_type.equals("D"))
			{
				qry = new StringBuffer() ;
				if(formulaResultUnit.equals("Minutes") || formulaResultUnit.equals("Hours") || formulaResultUnit.equals("Days") || formulaResultUnit.equals("Weeks"))
				{
					qry.append("select to_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')");
					if(formula_operator.equals("-"))
						qry.append("-");
					else
						qry.append("+");
					qry.append(" ? * DECODE(?,'Minutes',(1/1440),'Hours',(1/24),'Days',1,'Weeks',7,0 ), 'DD/MM/YYYY hh24:mi') from dual");
				}
				else
				{
					qry.append("SELECT  to_char(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");
					if(formula_operator.equals("-"))
						qry.append("-");
					else
						qry.append("+");
					qry.append("? *(decode(?,'Years',12,1)) ),'dd/mm/yyyy hh24:mi') FROM DUAL");
				}
				
				stmt1 = con.prepareStatement(qry.toString());
				stmt1.setString(1, firstComponent);
				stmt1.setString(2, secondComponent);
				stmt1.setString(3, formulaResultUnit);				
				rs1 = stmt1.executeQuery();
				if(rs1.next())
					formulaResult = rs1.getString(1);
				if(rs1!=null) rs1.close();
				if(stmt1!=null) stmt1.close();				
				
				int index = formulaResult.lastIndexOf("00:00");
				if(index != -1)
				{
					StringBuffer temp = new StringBuffer(formulaResult);
					formulaResult = temp.substring(0, 10);
				}				
			}
			
			out.println("<script>");			
			out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
			out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else if(parent.recMatConsDetailsFrame != null){");
			out.println(" if(parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID+ " != null){");
			
			out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null){");
			out.println(" if(top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID +" != null){ ");			
			out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';}");

			// Added by Sridhar Reddy on 19/10/2009 PMG20089-CRF-0690

			out.println("var formObj = top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm;");
			out.println("var nodeList = formObj.elements.length;");
			out.println("var EddCompID = '"+formulaCompID.substring(0,9)+"'");			
			out.println("for (var i=0; i<nodeList;i++ ){");			
			out.println("if (formObj.elements[i].type == 'text' && formObj.elements[i].name.length >= 17 &&   formObj.elements[i].name.substring(0,17) == 'C_MC01CORRECTDEDD' && EddCompID=='C_MC01EDD'){");			
			out.println("	formObj.elements[i].value ='"+formulaResult+"';}}");		
			//End

			out.println("}");
			out.println("</script>");
			

		}

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	}
    catch(Exception e)
	{
		
		e.printStackTrace();
		out.println("Exception --->" + e);

	}
	finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		}
	
	

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
