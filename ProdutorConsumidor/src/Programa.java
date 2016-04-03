/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
import java.util.ArrayList;

public class Programa {

	int itemCount;
	ArrayList buffer;

	Programa() {
		itemCount = 0;
		buffer = new ArrayList();
	}

	int compartilhada;

	public static void main(String[] args) {
		Programa t = new Programa();
		t.run();
	}

	public void run() {
		
		Consumer c = new Consumer(this);
		Producer p = new Producer(this);
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(0);
		s1.down();
		c.start();
		s1.up();
		p.start();
		s1.down();
		
		Consumer c1 = new Consumer(this);
		Producer p1 = new Producer(this);
		s2.down();
		c1.start();
		s2.up();
		p1.start();
		
	}

}
