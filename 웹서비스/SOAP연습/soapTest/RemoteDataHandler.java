package soapTest;

public interface RemoteDataHandler {
	//public void complete(ArrayList<Person> list);
	public void complete(Object object);
	public void complete(String message);
}