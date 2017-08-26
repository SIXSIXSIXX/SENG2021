package users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) throws IOException {
		//Login.checkDealerLoginInfo("aaa", "aaa");
		//LoginCheck.checkPublicLoginInfo("nic", "sb");
		//Register.RegisterPublicInfo("nic", "sb", "0123456", "sb road");
		//Register.RegisterDealerInfo("nic2", "sb2", "0123456", "sb roadd");
		LoginCheck.check("nic2", "sb2");
	}

}
