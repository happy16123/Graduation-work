package test;

import java.util.ArrayList;

public class Client implements RemoteDataHandler {
	public static void main(String args[]) throws Exception {

		Client client = new Client();
		ArrayList<DataObject> objects = new ArrayList<DataObject>();
		DataObject object = new DataObject();
		RemoteDataManager manager = new SOAPDataManager("http://localhost:1000/w20143133/Web",client);
		manager.setNamespace("http://web.class.inje.ac.kr");
		
		//CREATE
		/*object.setData("company","인텔");
		object.setData("name","CPU i7");
		object.setData("price", "350000");
		objects.add(object);

		manager.setOperationName("insertData");
		manager.setParameterArrayListObject("0", objects); */ 
		
		manager.setOperationName("selectData");
		manager.setParameter("0", "500000");
		
		manager.start();
		 
	}

	public void complete(String message) {
		System.out.println(message);
	}

	public void complete(Object object) {
		RemoteDataManager manager = (RemoteDataManager)object;
		ArrayList<DataObject> list = manager.getData();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getValue("return") != null) {
				System.out.println(list.get(i).getValue("return"));
			}else {
				System.out.println(list.get(i).getValue("company"));
				System.out.println(list.get(i).getValue("name"));
				System.out.println(list.get(i).getValue("price"));
				System.out.println("------------------------------");
			}
		}
		
		
	}
}