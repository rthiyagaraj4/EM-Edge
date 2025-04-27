package com.isoft.interfaceengine.custominterface;

public interface IWebservice
{
	public int retriveData() throws Exception;
	public void buildRequest(Object obj);
	public void callService(Object obj) throws Exception;
	public void updateResponse();
	public int processPendingItems();
}