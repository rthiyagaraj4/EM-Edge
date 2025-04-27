/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/** 
 * 
 */
package eAlert.src.alertfactory;

/**
 * @author PrasannaR 
 *
 */
public class TransportFactory {

	public ITransportMode getTransportMode(TransportEnum transEnum)
	{
		switch(transEnum)
		{
			case SMS:
				return new SmsTransport();
			case EMAIL:
				return new EmailTransport();
			case FAX:
				return new FaxTransport();
			default:
				break;
		}
		return null;
	}
	
}
