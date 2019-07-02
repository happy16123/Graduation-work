package soapTest;

import java.util.ArrayList;

public class Client implements RemoteDataHandler {
	public static void main(String args[]) throws Exception {

		Client client = new Client();
		ArrayList<DataObject> objects = new ArrayList<DataObject>();
		DataObject object = new DataObject();
		RemoteDataManager manager = new SOAPDataManager("http://192.168.152.132/test/DataTransfer",client);
		manager.setNamespace("http://test.class.inje.ac.kr");
		
		//CREATE
		/*object.setData("name","kim");
		object.setData("age","20");
		object.setData("address", "길바닥");
		objects.add(object);

		object = new DataObject();
		object.setData("name","lee");
		object.setData("age","30");
		object.setData("address", "아파트");
		objects.add(object);	

		manager.setOperationName("putData");
		manager.setParameterArrayListObject("0", objects);  // 서버에서 받는 메소드 파라미터임*/
		
		//READ
		manager.setOperationName("getData");
		
		//UPDATE
		/*manager.setParameter("0", "kim");  //이름
		manager.setParameter("1", "23");  //나이
		manager.setParameter("2", "어딘가");  //주소
		manager.setOperationName("updateData");*/
		
		//DELETE
		/*manager.setParameter("0", "lee");
		manager.setOperationName("deleteData");  */
		
		/*object.setData("name", "김현수");
		object.setData("age", "25");
		object.setData("address", "집");
		manager.setParameter("0", object);
		manager.setOperationName("getDataObject");*/
		manager.start();
		 
	}

	public void complete(String message) {
		System.out.println(message);
	}

	public void complete(Object object) {
		RemoteDataManager manager = (RemoteDataManager)object;
		ArrayList<DataObject> list = manager.getData();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getValue("name"));
			System.out.println(list.get(i).getValue("age"));
			System.out.println(list.get(i).getValue("address"));
			System.out.println("----------------------------");
		}
	}
}