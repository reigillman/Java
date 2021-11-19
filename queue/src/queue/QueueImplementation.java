package queue;

import java.util.ArrayList;

public class QueueImplementation<T> implements Queue<T> {
	private ArrayList<T> items=new ArrayList<T>();

	public void add(T item) {
		items.add(items.size(),item);
	}

	public T remove() {
		boolean empty=isEmpty();
		if (!empty) {
		T r=items.get(0);
		items.remove(0);
		return r;
		}
		else {
			return null;
		}
	}


	public boolean isEmpty() {
		if(items.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
