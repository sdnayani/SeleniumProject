
public class countWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="The quick brown fox jumps over the lazy dog";
        //int words=countWords(s);
        //System.out.println(" The count words "+words);
        String[] input={"hello","world"};
        String s1= toCSV(input);
        System.out.println(" The String " +s1);
        
	}

	public static int countWords(String word){		
	if(word==null){		
			return 0;
		}		
	//String input=word.trim();
	int count=word.isEmpty()?0:word.trim().split("\\s+").length;
	if(word.isEmpty()){
		//return 0
	}
	else{
		//return word.trim().split("\\s+").length
	}
	return count;
	}
   
	public static String  toCSV(String[] array){
		
		StringBuilder sbf= new StringBuilder();
		if (array.length>0){
		
		for(String s:array){
			sbf.append(s+",");
		     }
		sbf.deleteCharAt(sbf.length()-1);
		return sbf.toString();
		}
		return "";
	}
}