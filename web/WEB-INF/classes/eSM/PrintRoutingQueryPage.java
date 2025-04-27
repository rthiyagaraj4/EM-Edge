/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;

public class PrintRoutingQueryPage
{

    public PrintRoutingQueryPage()
    {
    }

    
/*	public StringBuffer getQueryPage(Properties properties, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, 
            String s5, String as[], String as1[], String s6, boolean flag,String selectLabel)
    {
        StringBuffer stringbuffer;
label0:
        {
            Connection connection = null;
            stringbuffer = null;
            try
            {
                if(flag)
                    connection = ConnectionManager.getConnection();
                stringbuffer = getQueryPage(connection, arraylist, s, s1, s2, s3, s4, s5, as, as1, s6);
            }
            catch(Exception exception)
            {
                ConnectionManager.returnConnection(connection);
                break label0;
            }
            finally
            {
                ConnectionManager.returnConnection(connection);
             //   throw exception1;
            }
            ConnectionManager.returnConnection(connection);
            break label0;
        }
        return stringbuffer;
    }*/

   /* public StringBuffer getQueryPage(Connection connection, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, 
            String s5, String as[], String as1[], String s6)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("<html><head>");
        stringbuffer.append("<title>" + s + "</title>");
        stringbuffer.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>");
        stringbuffer.append("<script src='../../eCommon/js/messages.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script><script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script><script src='../../eCommon/js/messages.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script><Script src='../../eCommon/js/common.js' language='JavaScript'></Script><script  language='javascript'>function focusObject(){document.forms(0).elements[0].focus();} function addOrderByCol()    {       var i=0; var from = document.all.item('orderbycols'); if ( from.options.length > 0 ) { var to = document.all.item('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element);          from.remove(from.selectedIndex); if(from.options[i])  from.options[i].selected=true ; i++; } } function removeOrderByCol()  {  var j=0; var from = document.all.item('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.all.item('orderbycols');var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);    from.remove(from.selectedIndex); if(from.options[j]) from.options[j].selected=true; j++;   } }  function SelectAll(){var i = 0; document.all.orderbycolumns.selectedIndex=0; while ( i < document.all.orderbycolumns.length) {  document.all.orderbycolumns.options[i].selected=true; i++; }}  function execQuery(){  if(document.all.orderbycolumns.options.length >0 ){SelectAll(); document.query_form.submit();}else{alert(getMessage('ORDERBY_NOT_BLANK'))}}</script> ");
		stringbuffer.append("<script> function selectPrinter1(desc,code){	if(desc.value == '')	{desc.value=''; code.value='';return ;}selectPrinter(desc,code)} function selectPrinter(desc,code)	{tar=desc.value;var retVal =    new String();var argumentArray  = new Array() ;var dataNameArray  = new Array() ;var dataValueArray = new Array() ;var dataTypeArray  = new Array() ;var tit=getLabel('eSM.Printers.label','SM');");
        stringbuffer.append("sql=\"Select printer_id code,printer_name description from sm_printer where  eff_status=\'E\'  and  upper(printer_id) like upper(?) and upper(printer_name) like upper(?) order by 2\";argumentArray[0] =sql;	argumentArray[1] = dataNameArray ;	argumentArray[2] = dataValueArray ;argumentArray[3] = dataTypeArray ;argumentArray[4] = '1,2';argumentArray[5] = tar;argumentArray[6] = DESC_LINK  ;argumentArray[7] = DESC_CODE ;	retVal = CommonLookup( tit, argumentArray );	if(retVal != null && retVal != '' )	  {    var ret1=unescape(retVal);	arr=ret1.split(',');	desc.value=arr[1];	code.value=arr[0];}else {code.value='';desc.value='';}	} </Script>");
        
		stringbuffer.append("</head><body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='focusObject()'><form name='query_form' method='post' action='");
        stringbuffer.append(s1 + "' onsubmit='SelectAll()'>");
        stringbuffer.append("<table width='98%' align='center' cellspacing='0' cellpadding='0'><tr><th align='left' width='20%'>" + s3 + "</th><tr><td width='60%' ><p title='" + s3 + "'><table width='100%'>");
        for(int i = 0; i < arraylist.size(); i++)
        {
            ArrayList arraylist2 = (ArrayList)arraylist.get(i);
            
			if(arraylist2.get(0).equals("Lookup"))
            {
			stringbuffer.append("<tr><td align='right' width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  align ='left' width='60%'>&nbsp;&nbsp;<input type=text name = '" + arraylist2.get(2) + "1' size='" + arraylist2.get(3) + "' maxlength='" + arraylist2.get(4) + "' onBlur='makeValidQueryCriteria(this);selectPrinter1(" + arraylist2.get(2) + "1,"+arraylist2.get(2)+");'><input type=button class=button value='?' name='printer2' onClick='selectPrinter(" + arraylist2.get(2) + "1,"+arraylist2.get(2)+");' ><INPUT TYPE='hidden'   name='"+arraylist2.get(2)+"'></td></tr>");
             continue;
			}
			
			if(arraylist2.get(0).equals("Text"))
            {
                stringbuffer.append("<tr><td align='right' width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  align ='left' width='60%'>&nbsp;&nbsp;<input type=text name = '" + arraylist2.get(2) + "' size='" + arraylist2.get(3) + "' maxlength='" + arraylist2.get(4) + "' onBlur='makeValidQueryCriteria(this);'></td></tr>");
                continue;
            }
            if(arraylist2.get(0).equals("Date"))
            {
                stringbuffer.append("<tr><td align='right' width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  align ='left' width='60%'>&nbsp;&nbsp;<input type=text name = '" + arraylist2.get(2) + "' size='10' maxlength='10' onBlur='CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.all." + arraylist2.get(2) + ".focus();return showCalendar('" + arraylist2.get(2) + "');\"  tabIndex=-1></td></tr>");
                continue;
            }
            if(arraylist2.get(0).equals("List"))
            {
                String s7 = (String)arraylist2.get(3);
                if(s7.substring(0, 6).equalsIgnoreCase("SELECT"))
                {
                    Object obj = null;
                    if(arraylist2.size() > 4)
                        obj = arraylist2.get(4);
                    String s9 = getDynamicValues(s7, connection, obj);
                    stringbuffer.append("<tr><td align='right' width='40%' class='label'>" + arraylist2.get(1) + "</td><td width='60%' align='left' >&nbsp;&nbsp;<select name='" + arraylist2.get(2) + "'><option value=''>----'"+selectLabel+"'----</option>" + s9 + "&nbsp;</td></tr>");
                } else
                {
                    String s8 = getDelimitedValue(s7);
                    stringbuffer.append("<tr><td align='right' width='40%' class='label'>" + arraylist2.get(1) + "</td><td width='60%' align='left' >&nbsp;&nbsp;<select name='" + arraylist2.get(2) + "'>" + s8 + "&nbsp;</td></tr>");
                }
                continue;
            }
            if(arraylist2.get(0).equals("Check"))
            {
                stringbuffer.append("<tr><td width='40%' align='right' class='label'>" + arraylist2.get(1) + "</td><td width='60%'  align='left' class='label'>&nbsp;&nbsp;<input type='check' name='" + arraylist2.get(2) + "' ></td></tr>");
                continue;
            }
            if(arraylist2.get(0).equals("Hidden"))
                stringbuffer.append("<input type='hidden' name='" + arraylist2.get(1) + "' value='" + arraylist2.get(2) + "' >");
        }

        stringbuffer.append("</table>");
        stringbuffer.append("</td></tr></table></p>");
        stringbuffer.append("<table width='98%' align='center'><th width='20%' align='left'>" + s2 + "</td><tr><td width='60%' > <p  title='" + s2 + "'><table width='100%'><td align='center'><b>" + s4 + "</td><td>&nbsp;</td><td align='center'><b>" + s5 + "</td><tr><td width='45%'  align='center'><select name='orderbycols' size='5' >");
        for(int j = 1; j < as.length; j++)
            stringbuffer.append("<option value='" + as1[j] + "'>" + as[j] + "</option>");

        stringbuffer.append("</select></td>");
        stringbuffer.append("<td align='center' width='3%' ><input type='button' name='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>");
        stringbuffer.append("<td width='45%' align='center'><select name='orderbycolumns' size='5' multiple='true'>");
        stringbuffer.append("<option value='" + as1[0] + "'>" + as[0] + "</option></select></td></tr></table></p></td></tr></table>");
        stringbuffer.append("<br><table border='0' width='100%' align='center'><tr><td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' class='Button' onclick='execQuery()' ></td></tr></table><script>var exe=getLabel('Common.Execute.label','common'); document.forms(0).ExecuteQuery.value=exe;</script> ");
        stringbuffer.append("</form></body></html>");
        return stringbuffer;
    }*/

    public String getDelimitedValue(String s)
    {
        String s3 = "";
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens();)
        {
            String s4 = stringtokenizer.nextToken();
            String s5 = stringtokenizer.nextToken();
            s3 = s3 + "<option value='" + s4 + "'>" + s5 + "</option>";
        }

        s3 = s3 + "</select>";
        return s3;
    }

    public PreparedStatement setPreparedValues(PreparedStatement preparedstatement, ArrayList arraylist)
        throws SQLException
    {
        if(arraylist != null)
        {
            for(int i = 0; i < arraylist.size(); i++)
            {
                Object obj = arraylist.get(i);
                if(obj instanceof String)
                    preparedstatement.setString(i + 1, (String)obj);
                else
                if(obj instanceof Integer)
                    preparedstatement.setInt(i + 1, ((Integer)obj).intValue());
                else
                if(obj instanceof Long)
                    preparedstatement.setLong(i + 1, ((Long)obj).longValue());
                else
                if(obj instanceof Float)
                    preparedstatement.setFloat(i + 1, ((Float)obj).floatValue());
                else
                if(obj instanceof Double)
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
        String s3 = "";
        try
        {
            PreparedStatement preparedstatement = connection.prepareStatement(s);
            preparedstatement = setPreparedValues(preparedstatement, arraylist);
            for(ResultSet resultset = preparedstatement.executeQuery(); resultset.next();)
            {
                String s4 = resultset.getString(1);
                String s5 = resultset.getString(2);
                s3 = s3 + "<option value='" + s4 + "'>" + s5 + "</option>";
            }

            s3 = s3 + "</select>";
        }
        catch(Exception exception)
        {
            s3 = s3 + exception.toString();
			exception.printStackTrace();
        }
        return s3;
    }

    public StringBuffer getMultiColumnQueryPage(Properties properties, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, 
            String s5, String as[], String as1[], String s6, boolean flag,String selectLabel)
    {
        StringBuffer stringbuffer;
label0:
        {
            Connection connection = null;
            stringbuffer = null;
            try
            {
                if(flag)
                    connection = ConnectionManager.getConnection();
                stringbuffer = getMultiColumnQueryPage(connection, arraylist, s, s1, s2, s3, s4, s5, as, as1, s6,selectLabel);
            }
            catch(Exception exception)
            {
                ConnectionManager.returnConnection(connection);
                break label0;
            }
            finally
            {
                ConnectionManager.returnConnection(connection);
                //throw exception1;
            }
            ConnectionManager.returnConnection(connection);
            break label0;
        }
        return stringbuffer;
    }

    public StringBuffer getMultiColumnQueryPage(Connection connection, ArrayList arraylist, String s, String s1, String s2, String s3, String s4, 
            String s5, String as[], String as1[], String s6,String selectLabel)
    {   
		
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("<html><head>");
        stringbuffer.append("<title>" + s + "</title>");
        stringbuffer.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>");
        stringbuffer.append("<script src='../../eCommon/js/messages.js' language='JavaScript'></script><Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script><script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script><Script src='../../eCommon/js/common.js' language='JavaScript'></Script><script  language='javascript'>function focusObject(){document.forms[0].elements[0].focus();}    function addOrderByCol()    {       var i=0; var from = document.all.item('orderbycols'); if ( from.options.length > 0 ) { var to = document.all.item('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element);          from.remove(from.selectedIndex); if(from.options[i])  from.options[i].selected=true ; i++; } } function removeOrderByCol()  {  var j=0; var from = document.all.item('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.all.item('orderbycols');var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);    from.remove(from.selectedIndex); if(from.options[j]) from.options[j].selected=true; j++;   } }      function SelectAll(){var i = 0; document.all.orderbycolumns.selectedIndex=0; while ( i < document.all.orderbycolumns.length) {  document.all.orderbycolumns.options[i].selected=true; i++; }}  function execQuery(){  if(document.all.orderbycolumns.options.length >0 ){SelectAll(); document.query_form.submit();}else{alert(getMessage('ORDERBY_NOT_BLANK'))}}</script> ");
       stringbuffer.append("<script>function selectPrinter1(desc,code){	if(desc.value == '')	{desc.value=''; code.value='';return ;}selectPrinter(desc,code)} async function selectPrinter(desc,code)	{  tar=desc.value;var retVal =    new String();var argumentArray  = new Array() ;var dataNameArray  = new Array() ;var dataValueArray = new Array() ;var dataTypeArray  = new Array() ;var tit=getLabel('eSM.Printers.label','SM');");
        stringbuffer.append("sql=\"Select printer_id code,printer_name description from sm_printer   where  eff_status=\'E\' and upper(printer_id) like upper(?) and upper(printer_name) like upper(?) order by 2 \";argumentArray[0] =sql;	argumentArray[1] = dataNameArray ;	argumentArray[2] = dataValueArray ;argumentArray[3] = dataTypeArray ;argumentArray[4] = '1,2';argumentArray[5] = tar;argumentArray[6] = DESC_LINK  ;argumentArray[7] = DESC_CODE ;	retVal = await CommonLookup( tit, argumentArray );	if(retVal != null && retVal != '' )	  {    var ret1=unescape(retVal);	arr=ret1.split(',');	desc.value=arr[1];	code.value=arr[0];}else{code.value='';desc.value='' }	} </Script>");
        
		
		stringbuffer.append("</head><body onLoad='focusObject()' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' ><form name='query_form' id='query_form' method='post' action='");
        stringbuffer.append(s1 + "' onsubmit='SelectAll()'>");


        stringbuffer.append("<table width='80%' align='center'><tr><th align='left' width='30%'>" + s3 + "</th></tr><tr><td  nowrap width='60%' ><p class='' ><table width='100%'  border='0' >");
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
            for(int l = j; l < j + 2 && l < i; l++)
            {
                ArrayList arraylist3 = (ArrayList)arraylist.get(l);
                
				if(arraylist3.get(0).equals("Lookup"))
                {
                    stringbuffer.append("<td  align='right' width='25%' class='label'>" + arraylist3.get(1) + "</td>" + "<td  align ='left' width='25%'>&nbsp;&nbsp;<input type=text   name = '" + arraylist3.get(2) + "1' id = '" + arraylist3.get(2) + "1' size='" + arraylist3.get(3) + "' maxlength='" + arraylist3.get(4) + "' onBlur='makeValidQueryCriteria(this);selectPrinter1(" + arraylist3.get(2) + "1,"+arraylist3.get(2)+")'><input type=button class=button value='?'  name='printer2' id='printer2' onClick='selectPrinter(" + arraylist3.get(2) + "1,"+arraylist3.get(2)+");' ><INPUT TYPE='hidden'   name='"+arraylist3.get(2)+"' id='"+arraylist3.get(2)+"'></td>");
                    continue;
                }
				
				if(arraylist3.get(0).equals("Text"))
                {
                    stringbuffer.append("<td  align='right' width='25%' class='label'>" + arraylist3.get(1) + "</td>" + "<td  align ='left' width='25%'>&nbsp;&nbsp;<input type=text name = '" + arraylist3.get(2) + "' id = '" + arraylist3.get(2) + "' size='" + arraylist3.get(3) + "' maxlength='" + arraylist3.get(4) + "' onBlur='makeValidQueryCriteria(this);'></td>");
                    continue;
                }
                if(arraylist3.get(0).equals("Date"))
                {
                    stringbuffer.append("<td align='right' width='40%' class='label' >" + arraylist3.get(1) + "</td>" + "<td  align ='left' width='60%'>&nbsp;&nbsp;<input type=text name = '" + arraylist3.get(2) + "' id = '" + arraylist3.get(2) + "' size='10' maxlength='10' onBlur='CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.all." + arraylist3.get(2) + ".focus();return showCalendar('" + arraylist3.get(2) + "');\" tabIndex=-1></td>");
                    continue;
                }
                if(arraylist3.get(0).equals("List"))
                {
                    String s10 = (String)arraylist3.get(3);
                    if(s10.substring(0, 6).equalsIgnoreCase("SELECT"))
                    {
                        Object obj1 = null;
                        if(arraylist3.size() > 4)
                            obj1 = arraylist3.get(4);
                        String s13 = getDynamicValues(s10, connection, obj1);
                        stringbuffer.append("<td  align='right' width='25%' class='label'>" + arraylist3.get(1) + "</td><td  width='25%' align='left' >&nbsp;&nbsp;<select name='" + arraylist3.get(2) + "' id='" + arraylist3.get(2) + "'><option value=''>----"+selectLabel+"----</option>" + s13 + "&nbsp;</td>");
                    } else
                    {
                        String s12 = getDelimitedValue(s10);
                        stringbuffer.append("<td  align='right' width='25%' class='label'>" + arraylist3.get(1) + "</td><td  width='25%' align='left' >&nbsp;&nbsp;<select name='" + arraylist3.get(2) + "' id='" + arraylist3.get(2) + "'>" + s12 + "&nbsp;</td>");
                    }
                    continue;
                }
                if(arraylist3.get(0).equals("Check"))
                {
                    stringbuffer.append("<td  width='25%' align='right' class='label'>" + arraylist3.get(1) + "</td><td  width='25%'  align='left' class='label'>&nbsp;&nbsp;<input type='check' name='" + arraylist3.get(2) + "' id='" + arraylist3.get(2) + "' ></td>");
                    continue;
                }
                if(arraylist3.get(0).equals("Hidden"))
                    stringbuffer.append("<input type='hidden' name='" + arraylist3.get(1) + "' id='" + arraylist3.get(1) + "' value='" + arraylist3.get(2) + "' >");
            }

            stringbuffer.append("</tr>");
        }

        if(s7.equals("span"))
        {
            ArrayList arraylist2 = (ArrayList)arraylist.get(i);
            if(arraylist2.get(0).equals("Text"))
                stringbuffer.append("<tr><td  align='right' width='25%' class='label' align='center'>" + arraylist2.get(1) + "</td>" + "<td   align ='left' width='25%'>&nbsp&nbsp<input type=text name = '" + arraylist2.get(2) + "' id = '" + arraylist2.get(2) + "' size='" + arraylist2.get(3) + "' maxlength='" + arraylist2.get(4) + "' onBlur='makeValidQueryCriteria(this);'></td></tr>");
            else
            if(arraylist2.get(0).equals("Date"))
                stringbuffer.append("<tr><td align='right' width='40%' class='label' >" + arraylist2.get(1) + "</td>" + "<td  align ='left' width='60%'>&nbsp;&nbsp;<input type=text name = '" + arraylist2.get(2) + "' id = '" + arraylist2.get(2) + "' size='10' maxlength='10' onBlur='CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.all." + arraylist2.get(2) + ".focus();return showCalendar('" + arraylist2.get(2) + "');\"  tabIndex=-1></td></tr>");
            else
            if(arraylist2.get(0).equals("List"))
            {
                String s8 = (String)arraylist2.get(3);
                if(s8.substring(0, 6).equalsIgnoreCase("SELECT"))
                {
                    Object obj = null;
                    if(arraylist2.size() > 4)
                        obj = arraylist2.get(4);
                    String s11 = getDynamicValues(s8, connection, obj);
                    stringbuffer.append("<tr><td  align='right' width='25%' class='label'>" + arraylist2.get(1) + "</td><td  width='25%' align='left' >&nbsp;&nbsp;<select name='" + arraylist2.get(2) + "' id='" + arraylist2.get(2) + "'><option value=''>----"+selectLabel+"----</option>" + s11 + "&nbsp;</td></tr>");
                } else
                {
                    String s9 = getDelimitedValue(s8);
                    stringbuffer.append("<tr><td  align='right'  width='25%' class='label' align='center'>&nbsp;&nbsp" + arraylist2.get(1) + "</td><td   align ='left' width='25%'>&nbsp&nbsp<select name='" + arraylist2.get(2) + "' id='" + arraylist2.get(2) + "'>" + s9 + "&nbsp;</td></tr>");
                }
            } else
            if(arraylist2.get(0).equals("Check"))
                stringbuffer.append("<tr><td  align='right' width='25%' class='label' align='center'>" + arraylist2.get(1) + "</td><td   align ='left' width='25%'>&nbsp&nbsp<input type='check' name='" + arraylist2.get(2) + "' id='" + arraylist2.get(2) + "' ></td></tr>");
            else
            if(arraylist2.get(0).equals("Hidden"))
                stringbuffer.append("<input type='hidden' name='" + arraylist2.get(1) + "' id='" + arraylist2.get(1) + "' value='" + arraylist2.get(2) + "' >");
        }
        stringbuffer.append("</table>");
        stringbuffer.append("</td></tr></table></p>");
        stringbuffer.append("<table width='80%' align='center'><th width='20%' align='left'>" + s2 + "</td><tr><td   width='60%' > <p  title='" + s2 + "'><table width='100%'><td  align='center'><b>" + s4 + "</td><td>&nbsp;</td><td  align='center'><b>" + s5 + "</td><tr><td  width='45%'  align='center'><select name='orderbycols' id='orderbycols' size='5' >");
        for(int k = 1; k < as.length; k++)
            stringbuffer.append("<option value='" + as1[k] + "'>" + as[k] + "</option>");

        stringbuffer.append("</select></td>");
        stringbuffer.append("<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' title='Sort Order' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button' title='Sort Order' value='<----' onclick='removeOrderByCol()'></img></td>");
        stringbuffer.append("<td  width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>");
        stringbuffer.append("<option value='" + as1[0] + "'>" + as[0] + "</option></select></td></tr></table></p></td></tr></table>");
        stringbuffer.append("<br><table border='0' width='100%' align='center'><tr><td  width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' ></td></tr></table> <script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>");
        stringbuffer.append("</form></body></html>");
        return stringbuffer;
    }
}
