package Application;

import java.util.concurrent.locks.ReentrantLock;

import data.db.DbConnectionUtil;
import data.db.DbSchema;
import view.LoginWindow;

public class Main {

	public static void main(String[] args) {
		Main.runApplication();
	}

	public static void runApplication() {
		new LoginWindow().runLoginWindow();

		Thread dbInstanceWorker = new Thread() {

			@Override
			public void run() {
				ReentrantLock lock = new ReentrantLock();
				lock.lock();

				super.run();
				new DbSchema();
				new DbConnectionUtil();

				lock.unlock();
			}
		};
		dbInstanceWorker.start();
	}
}
