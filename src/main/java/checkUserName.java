import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkUserName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				String s="Samantan";
				
				Pattern p =Pattern.compile("^[A-Za-z]\\w{7,29}$");
				// TODO Auto-generated method stub
				Matcher m=p.matcher(s);
				
				if(m.find()){
					System.out.println("Yes");
				}
				else{
					System.out.println("NO");
				}

			}


	}


