import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkHackeRank {

	public static void main(String[] args) {
		
		//String s="hereiamstackerrank";
		String s="hackerworld";
		Pattern p =Pattern.compile(".*h.*a.*c.*k.*e.*r.*a.*n.*k");
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
