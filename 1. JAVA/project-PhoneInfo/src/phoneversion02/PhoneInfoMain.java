package phoneversion02;

import phoneversion01.PhoneInfo;
import phoneversion02.PhoneInfoManager;

public class PhoneInfoMain {

	public static void main(String[] args) {

		PhoneInfoManager manager = new PhoneInfoManager();
		PhoneInfo info = null;

		while (true) {
			info = manager.createInstance();
			info.showData();
		}

	}

}
