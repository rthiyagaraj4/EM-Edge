/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ecis.utils;

import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class CommonQueryPage
{

    public CommonQueryPage()
    {
    }

    public StringBuffer getQueryPage(Properties properties, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, String s5, String as[], String as1[], String s6, boolean flag)
    {
        Connection connection = null;
        StringBuffer stringbuffer = null;

        try
        {
            if(flag)
                connection = ConnectionManager.getConnection();
            stringbuffer = getQueryPage(connection, arraylist, s, s1, s2, s3, s4, s5, as, as1, s6);
        }
        catch(Exception exception) { }
        finally
        {
            ConnectionManager.returnConnection(connection);
        }
        return stringbuffer;
    }

    public StringBuffer getQueryPage(Connection connection, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, String s5, String as[], String as1[], String s6)
    {
		// java.util.Properties p;
		// String locale =p.getProperty("LOCALE");
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("<html><head>");
        stringbuffer.append("<title>" + s + "</title>");
        stringbuffer.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>");
		//stringbuffer.append("<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script><Script src='../../eCommon/js/common.js' language='JavaScript'></Script><script  language='javascript'>function focusObject(){document.forms(0).elements[0].focus();}  function addOrderByCol()    {       var i=0; var from = document.all.item('orderbycols'); if ( from.options.length > 0 ) { var to = document.all.item('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element);          from.remove(from.selectedIndex); if(from.options[i])  from.options[i].selected=true ; i++; } } function removeOrderByCol()  {  var j=0; var from = document.all.item('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.all.item('orderbycols');var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);    from.remove(from.selectedIndex); if(from.options[j]) from.options[j].selected=true; j++;   } }  function SelectAll(){var i = 0; document.all.orderbycolumns.selectedIndex=0; while ( i < document.all.orderbycolumns.length) {  document.all.orderbycolumns.options[i].selected=true; i++; }}  function execQuery(){  if(document.all.orderbycolumns.options.length >0 ){SelectAll();document.query_form.submit();}else{alert(getMessage('ORDERBY_NOT_BLANK','Common'))}}</script> ");
        stringbuffer.append("<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script><Script src='../../eCommon/js/common.js' language='JavaScript'></Script><script  language='javascript'>function focusObject(){document.forms[0].elements[0].focus();}  function addOrderByCol()    {       var i=0; var from = document.getElementById('orderbycols'); if ( from.options.length > 0 ) { var to = document.getElementById('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element);          from.remove(from.selectedIndex); if(from.options[i])  from.options[i].selected=true ; i++; } } function removeOrderByCol()  {  var j=0; var from = document.getElementById('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.getElementById('orderbycols');var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);    from.remove(from.selectedIndex); if(from.options[j]) from.options[j].selected=true; j++;   } }  function SelectAll(){var i = 0; document.getElementById('orderbycolumns').selectedIndex=0; while ( i < document.getElementById('orderbycolumns').length) {  document.getElementById('orderbycolumns').options[i].selected=true; i++; }}  function execQuery(){ if(document.getElementById('orderbycolumns').options.length >0 ){ SelectAll(); if (document.query_form.action.includes('blank.html') && typeof(originalFormAction) != 'undefined' && originalFormAction != null) { document.query_form.action = originalFormAction; document.query_form.target='';} document.query_form.submit();}else{alert(getMessage('ORDERBY_NOT_BLANK','Common'))}}</script> ");
		stringbuffer.append("</head><body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='focusObject()'><form id='query_form' name='query_form' method='post' action='");
        stringbuffer.append(s1 + "' onsubmit='SelectAll()'>");
        stringbuffer.append("<Script src='../../eCommon/js/common.js' language='JavaScript'></Script><Script src='../../eCommon/js/DateUtils.js' language='JavaScript'></Script><table width='100%' align='center' cellspacing='0' cellpadding='0'><tr><th align='left' width='20%'>" + s3 + "</th><tr><td width='60%' ><p title='" + s3 + "'><table width='100%'>");
        ArrayList arraylist1 = new ArrayList();
        for(int i = 0; i < arraylist.size(); i++)
        {
            ArrayList arraylist2 = (ArrayList)arraylist.get(i);
            if(arraylist2.get(0).equals("Text"))
                stringbuffer.append("<tr><td  width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  class='fields' width='60%'><input type=text id = '" + arraylist2.get(2) + "' name = '" + arraylist2.get(2) + "' size='" + arraylist2.get(3) + "' maxlength='" + arraylist2.get(4) + "' onBlur='makeValidQueryCriteria(this);'></td></tr>");
            else if(arraylist2.get(0).equals("Date"))
               // stringbuffer.append("<tr><td  width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  class='fields' width='60%'><input type=text name = '" + arraylist2.get(2) + "' size='10' maxlength='10' onBlur='CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.all." + arraylist2.get(2) + ".focus();return showCalendar('" + arraylist2.get(2) + "');\"  tabIndex=-1></td></tr>");
                stringbuffer.append("<tr><td  width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  class='fields' width='60%'><input type=text id = '" + arraylist2.get(2) + "' name = '" + arraylist2.get(2) + "' size='10' maxlength='10' onBlur='fnCovertDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.getElementById('" + arraylist2.get(2) + "').focus();return showCalendar('" + arraylist2.get(2) + "');\"  tabIndex=-1></td></tr>");
            else if(arraylist2.get(0).equals("List"))
            {
                String s7 = (String)arraylist2.get(3);
                if(s7.substring(0, 6).equalsIgnoreCase("SELECT"))
                {
                    Object obj = null;
                    if(arraylist2.size() > 4)
                        obj = arraylist2.get(4);
                    String s9 = getDynamicValues(s7, connection, obj);
					String sec_val1 =(String)arraylist2.get(2);
					//java.util.Hashtable enc_message = MessageManager.getMessage(locale,"ENCOUNTER_ID","IP");
					//String enc_msg = (String) enc_message.get("message");
					stringbuffer.append("<tr><td  width='40%' class='label'>" + arraylist2.get(1) + "</td><td width='60%' class='fields' ><select id='"+arraylist2.get(2)+"' name='"+arraylist2.get(2)+"'><option value=''>----Select----</option>" + s9 + "&nbsp;</td></tr><script>var selc_val='---'+getLabel('Common.defaultSelect.label','Common')+'---';	document.forms[0]."+(String)arraylist2.get(2)+"[0].text=selc_val;</script>");
                }
                else
                {
                    String s8 = getDelimitedValue(s7);
                    stringbuffer.append("<tr><td  width='40%' class='label'>" + arraylist2.get(1) + "</td><td width='60%' class='fields' ><select id='" + arraylist2.get(2) + "' name='" + arraylist2.get(2) + "'>" + s8 + "&nbsp;</td></tr>");
                }
            }
            else if(arraylist2.get(0).equals("Check"))
                stringbuffer.append("<tr><td  class='label'>" + arraylist2.get(1) + "</td><td width='60%'  class='fields'><input type='checkbox' id='" + arraylist2.get(2) + "' name='" + arraylist2.get(2) + "' ></td></tr>");
            else if(arraylist2.get(0).equals("Hidden"))
                stringbuffer.append("<input type='hidden' id='" + arraylist2.get(1) + "' name='" + arraylist2.get(1) + "' value='" + arraylist2.get(2) + "' >");
        }

        stringbuffer.append("</table>");
        stringbuffer.append("</td></tr></table></p>");
        stringbuffer.append("<table width='100%' align='center'><th width='20%' align='left'>" + s2 + "</td><tr><td width='60%' > <p  title='" + s2 + "'><table width='100%'><td align='center'><b>" + s4 + "</td><td>&nbsp;</td><td align='center'><b>" + s5 + "</td><tr><td width='45%'  align='center'><select id='orderbycols' name='orderbycols' size='5' >");
        for(int j = 1; j < as.length; j++)
            stringbuffer.append("<option value='" + as1[j] + "'>" + as[j] + "</option>");
        stringbuffer.append("</select></td>");
        stringbuffer.append("<td align='center' width='3%' ><input type='button' id='add' name='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' id='add' name='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>");
        stringbuffer.append("<td width='45%' align='center'><select id='orderbycolumns' name='orderbycolumns' size='5' multiple='true'>");
        stringbuffer.append("<option value='" + as1[0] + "'>" + as[0] + "</option></select></td></tr></table></p></td></tr></table>");
        stringbuffer.append("<br><table border='0' width='100%' align='center'><tr><td width='100%' align='center' class='white'><input type='button' id='ExecuteQuery' name='ExecuteQuery' class='Button' onclick='execQuery()' ></td></tr></table> <script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>");
        stringbuffer.append("</form></body></html>");
		//System.out.println("stringbuffer :" +stringbuffer);
        return stringbuffer;
    }

    public String getDelimitedValue(String s)
    {
        String s1 = "";
        String s3 = "";
        String s5 = "";
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens();)
        {
            String s4 = stringtokenizer.nextToken();
            String s2 = stringtokenizer.nextToken();
            s5 = s5 + "<option value='" + s4 + "'>" + s2 + "</option>";
        }

        s5 = s5 + "</select>";
        return s5;
    }

    public PreparedStatement setPreparedValues(PreparedStatement preparedstatement, ArrayList arraylist) throws SQLException
    {
        if(arraylist != null)
        {
            for(int i = 0; i < arraylist.size(); i++)
            {
                Object obj = arraylist.get(i);
                if(obj instanceof String)
                    preparedstatement.setString(i + 1, (String)obj);
                else if(obj instanceof Integer)
                    preparedstatement.setInt(i + 1, ((Integer)obj).intValue());
                else if(obj instanceof Long)
                    preparedstatement.setLong(i + 1, ((Long)obj).longValue());
                else if(obj instanceof Float)
                    preparedstatement.setFloat(i + 1, ((Float)obj).floatValue());
                else if(obj instanceof Double)
                    preparedstatement.setDouble(i + 1, ((Double)obj).doubleValue());
                i++;
            }
        }
        return preparedstatement;
    }

    private String getDynamicValues(String s, Connection connection, Object obj)
    {
        ArrayList arraylist = null;
        if(obj == null)
            arraylist = new ArrayList();
        else
            arraylist = (ArrayList)obj;
        String s1 = "";
        String s3 = "";
        String s5 = "";
        try
        {
            PreparedStatement preparedstatement = connection.prepareStatement(s);
            preparedstatement = setPreparedValues(preparedstatement, arraylist);
            for(ResultSet resultset = preparedstatement.executeQuery(); resultset.next();)
            {
                String s2 = resultset.getString(1);
                String s4 = resultset.getString(2);
                s5 = s5 + "<option value='" + s2 + "'>" + s4 + "</option>";
            }

            s5 = s5 + "</select>";
        }
        catch(Exception exception)
        {
            s5 = s5 + exception.toString();
        }
        return s5;
    }

    public StringBuffer getMultiColumnQueryPage(Properties properties, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, String s5, String as[], String as1[], String s6, boolean flag)
    {
        Connection connection = null;
        StringBuffer stringbuffer = null;
        try
        {
            if(flag)
                connection = ConnectionManager.getConnection();
            stringbuffer = getMultiColumnQueryPage(connection, arraylist, s, s1, s2, s3, s4, s5, as, as1, s6);
        }
        catch(Exception exception) { }
        finally
        {
            ConnectionManager.returnConnection(connection);
        }
        return stringbuffer;
    }

    public StringBuffer getMultiColumnQueryPage(Connection connection, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, String s5, String as[], String as1[], String s6)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("<html><head>");
        stringbuffer.append("<title>" + s + "</title>");
        stringbuffer.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>");
        stringbuffer.append("<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script><Script src='../../eCommon/js/common.js' language='JavaScript'></Script><script  language='javascript'>function focusObject(){document.forms[0].elements[0].focus();}    function addOrderByCol()    {       var i=0; var from = document.getElementById('orderbycols'); if ( from.options.length > 0 ) { var to = document.getElementById('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element);          from.remove(from.selectedIndex); if(from.options[i])  from.options[i].selected=true ; i++; } } function removeOrderByCol()  {  var j=0; var from = document.getElementById('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.getElementById('orderbycols');var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);    from.remove(from.selectedIndex); if(from.options[j]) from.options[j].selected=true; j++;   } }      function SelectAll(){var i = 0; document.getElementById('orderbycolumns').selectedIndex=0; while ( i < document.getElementById('orderbycolumns').length) {  document.getElementById('orderbycolumns').options[i].selected=true; i++; }}  function execQuery(){  if(document.getElementById('orderbycolumns').options.length >0 ){SelectAll();  if (document.query_form.action.includes('blank.html') && typeof(originalFormAction) != 'undefined' && originalFormAction != null) { document.query_form.action = originalFormAction; document.query_form.target=''; }document.query_form.submit();}else{alert(getMessage('ORDERBY_NOT_BLANK','Common'))}}</script> ");
        stringbuffer.append("</head><body onLoad='focusObject()' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' ><form id='query_form' name='query_form' method='post' action='");
        stringbuffer.append(s1 + "' onsubmit='SelectAll()'>");
        stringbuffer.append("<Script src='../../eCommon/js/common.js' language='JavaScript'></Script><table width='100%' align='center'><tr><th align='left' width='30%'>" + s3 + "</th></tr><tr><td  width='60%' ><p class='' ><table width='100%'  border='0' >");
        ArrayList arraylist1 = new ArrayList();
        int i = arraylist.size();
        String s7 = "";
        if(i % 2 != 0)
        {
            i = arraylist.size() - 1;
            s7 = "span";
        }
        for(int j = 0; j < i; j += 2)
        {
            stringbuffer.append("<tr>");
            for(int k = j; k < j + 2 && k < i; k++)
            {
                ArrayList arraylist2 = (ArrayList)arraylist.get(k);
                if(arraylist2.get(0).equals("Text"))
                    stringbuffer.append("<td nowrap  width='25%' class='label'>" + arraylist2.get(1) + "</td>" + "<td nowrap class='fields' width='25%'><input type=text id = '" + arraylist2.get(2) + "' name = '" + arraylist2.get(2) + "' size='" + arraylist2.get(3) + "' maxlength='" + arraylist2.get(4) + "' onBlur='makeValidQueryCriteria(this);'></td>");
                else if(arraylist2.get(0).equals("Date"))
                    stringbuffer.append("<td  width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  class='fields' width='60%'><input type=text id = '" + arraylist2.get(2) + "' name = '" + arraylist2.get(2) + "' size='10' maxlength='10' onBlur='CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.getElementById('" + arraylist2.get(2) + "').focus();return showCalendar('" + arraylist2.get(2) + "');\" tabIndex=-1></td>");
                else if(arraylist2.get(0).equals("List"))
                {
                    String s9 = (String)arraylist2.get(3);
                    if(s9.substring(0, 6).equalsIgnoreCase("SELECT"))
                    {
                        Object obj1 = null;
                        if(arraylist2.size() > 4)
                            obj1 = arraylist2.get(4);
                        String s13 = getDynamicValues(s9, connection, obj1);
                        stringbuffer.append("<td nowrap  width='25%' class='label'>" + arraylist2.get(1) + "</td><td nowrap width='25%' class='fields'><select id='" + arraylist2.get(2) + "' name='" + arraylist2.get(2) + "'><option value=''>----Select----</option>" + s13 + "&nbsp;</td><script>var selc_val='---'+getLabel('Common.defaultSelect.label','Common')+'---';	document.forms[0]."+(String)arraylist2.get(2)+"[0].text=selc_val;</script>");
                    }
                    else
                    {
                        String s11 = getDelimitedValue(s9);
                        stringbuffer.append("<td nowrap  width='25%' class='label'>" + arraylist2.get(1) + "</td><td nowrap width='25%' class='fields' ><select id='" + arraylist2.get(2) + "' name='" + arraylist2.get(2) + "'>" + s11 + "&nbsp;</td>");
                    }
                }
                else if(arraylist2.get(0).equals("Check"))
                    stringbuffer.append("<td nowrap width='25%'  class='label'>" + arraylist2.get(1) + "</td><td nowrap width='25%'  class='fields'><input type='check' id='" + arraylist2.get(2) + "' name='" + arraylist2.get(2) + "' ></td>");
                else if(arraylist2.get(0).equals("Hidden"))
                    stringbuffer.append("<input type='hidden' id='" + arraylist2.get(1) + "' name='" + arraylist2.get(1) + "' value='" + arraylist2.get(2) + "' >");
            }

            stringbuffer.append("</tr>");
        }

        if(s7.equals("span"))
        {
            ArrayList arraylist3 = (ArrayList)arraylist.get(i);
            if(arraylist3.get(0).equals("Text"))
                stringbuffer.append("<tr><td nowrap  width='25%' class='label' >" + arraylist3.get(1) + "</td>" + "<td nowrap  class='fields' width='25%'><input type=text id = '" + arraylist3.get(2) + "' name = '" + arraylist3.get(2) + "' size='" + arraylist3.get(3) + "' maxlength='" + arraylist3.get(4) + "' onBlur='makeValidQueryCriteria(this);'></td></tr>");
            else if(arraylist3.get(0).equals("Date"))
                stringbuffer.append("<tr><td  width='40%' class='label' >" + arraylist3.get(1) + "</td>" + "<td  class='fields' width='60%'><input type=text id = '" + arraylist3.get(2) + "' name = '" + arraylist3.get(2) + "' size='10' maxlength='10' onBlur='CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.getElementById('" + arraylist3.get(2) + "').focus();return showCalendar('" + arraylist3.get(2) + "');\"  tabIndex=-1></td></tr>");
            else if(arraylist3.get(0).equals("List"))
            {
                String s8 = (String)arraylist3.get(3);
                if(s8.substring(0, 6).equalsIgnoreCase("SELECT"))
                {
                    Object obj = null;
                    if(arraylist3.size() > 4)
                        obj = arraylist3.get(4);
                    String s12 = getDynamicValues(s8, connection, obj);
                    stringbuffer.append("<tr><td nowrap width='25%' class='label'>" + arraylist3.get(1) + "</td><td nowrap width='25%' class='fields' ><select id='" + arraylist3.get(2) + "' name='" + arraylist3.get(2) + "'><option value=''>----Select----</option>" + s12 + "&nbsp;</td></tr><script>var selc_val='---'+getLabel('Common.defaultSelect.label','Common')+'---';	document.forms[0]."+(String)arraylist3.get(2)+"[0].text=selc_val;</script>");
                }
                else
                {
                    String s10 = getDelimitedValue(s8);
                    stringbuffer.append("<tr><td nowrap width='25%' class='label' >" + arraylist3.get(1) + "</td><td nowrap  class='fields' width='25%'><select id='" + arraylist3.get(2) + "' name='" + arraylist3.get(2) + "'>" + s10 + "&nbsp;</td></tr>");
                }
            }
            else if(arraylist3.get(0).equals("Check"))
                stringbuffer.append("<tr><td nowrap  width='25%' class='label' >" + arraylist3.get(1) + "</td><td nowrap  class='fields' width='25%'><input type='check' id='" + arraylist3.get(2) + "' name='" + arraylist3.get(2) + "' ></td></tr>");
            else if(arraylist3.get(0).equals("Hidden"))
                stringbuffer.append("<input type='hidden' id='" + arraylist3.get(1) + "' name='" + arraylist3.get(1) + "' value='" + arraylist3.get(2) + "' >");
        }
        stringbuffer.append("</table>");
        stringbuffer.append("</td></tr></table></p>");
        stringbuffer.append("<table width='100%' align='center'><th width='20%' align='left'>" + s2 + "</td><tr><td   width='60%' > <p  title='" + s2 + "'><table width='100%'><td nowrap align='center'><b>" + s4 + "</td><td>&nbsp;</td><td nowrap align='center'><b>" + s5 + "</td><tr><td nowrap width='45%'  align='center'><select id='orderbycols' name='orderbycols' size='5' >");
        for(int l = 1; l < as.length; l++)
            stringbuffer.append("<option value='" + as1[l] + "'>" + as[l] + "</option>");

        stringbuffer.append("</select></td>");
        stringbuffer.append("<td align='center' width='3%' ><input type='button' id='add' name='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' id='add' name='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>");
        stringbuffer.append("<td nowrap width='45%' align='center'><select id='orderbycolumns' name='orderbycolumns' size='5' multiple='true'>");
        stringbuffer.append("<option value='" + as1[0] + "'>" + as[0] + "</option></select></td></tr></table></p></td></tr></table>");
        stringbuffer.append("<br><table border='0' width='100%' align='center'><tr><td nowrap width='100%' align='center' class='white'><input type='button' id='ExecuteQuery' name='ExecuteQuery' class='Button' onclick='execQuery()' Value='Execute'></td></tr></table><script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script> ");
        stringbuffer.append("</form></body></html>");
        return stringbuffer;
    }
}
