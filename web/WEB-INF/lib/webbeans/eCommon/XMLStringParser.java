/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCommon;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class XMLStringParser{

    public XMLStringParser(){
    }

    public Hashtable parseXMLString(HttpServletRequest httpservletrequest){
		Hashtable hashtable = new Hashtable();
        try{
            java.io.BufferedReader bufferedreader = httpservletrequest.getReader();
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(bufferedreader);
            Element rootElement = document.getRootElement();
            for (Iterator i = rootElement.getChildren().listIterator(); i.hasNext();){
                Element element = (Element) i.next();
                Hashtable hashtable1 = new Hashtable();
                List<Attribute> list = element.getAttributes();
                for (Attribute attribute : list){
					// Added by Muthu on 12/07/2010 against incident IN022478
					String attValue = attribute.getValue().replace('\"','\n');
                	hashtable1.put(attribute.getName(),attValue);
                	//hashtable1.put(attribute.getName(),attribute.getValue());
                }
                hashtable.put(element.getName(), hashtable1);
            }
        }catch(Exception exception){
            hashtable.put("error", exception.toString());
        }
        return hashtable;        
    }
}
