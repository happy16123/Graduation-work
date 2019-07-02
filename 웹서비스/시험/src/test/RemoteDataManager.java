package test;

import java.util.ArrayList;

public class RemoteDataManager extends Thread {
	
	protected ArrayList<DataObject> datas;
	protected RemoteDataHandler handler;
	
	public RemoteDataManager() {
		datas = new ArrayList<DataObject>();
	}
	
	public ArrayList<DataObject> getData(){
		return datas;
	}
	
	protected void complete(RemoteDataManager manager) {
		handler.complete(manager);
	}
	
	protected void complete(String message) {
		handler.complete(message);
	}
	
	public void setNamespace(String namespace) {}
	public void setOperationName(String name) {}
	public void setParameterArrayListObject(String sequence, ArrayList<DataObject> objects) throws Exception{}
	public void setParameter(String sequence, DataObject object) {}
	public void setParameter(String sequence, String value) throws Exception{}
}
