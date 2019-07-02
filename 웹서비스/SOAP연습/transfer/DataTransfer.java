package transfer;

import java.util.ArrayList;

import javax.jws.WebService;

@WebService(targetNamespace="http://test.class.inje.ac.kr")
public class DataTransfer implements IDataTransfer{ //리턴값없는거만들기
	
	@Override
	public ArrayList<Person> getData() {
		DBConnection db = new DBConnection();
		ArrayList<Person> datas = db.getDb();
		return datas;
	}
	
	@Override
	public void putData(ArrayList<Person> list) {
		DBConnection db = new DBConnection();
		db.putDb(list);
	}
	
	@Override
	public void updateData(String name, String age, String address) {
		DBConnection db = new DBConnection();
		db.updateData(name, age, address);
	}
	
	@Override
	public void deleteData(String name) {
		DBConnection db = new DBConnection();
		db.deleteData(name);
	}
	
	@Override
	public void getDataObject(Person person) {
		System.out.println(person.getName());
		System.out.println(person.getAddress());
		System.out.println(person.getAge());
	}

}

