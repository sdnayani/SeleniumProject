
public class checkPanagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[26];
		//arr[0]=0,arr[1]=0....arr[19]=0
		Boolean isPanagram=true;
		String s="The quick brown fox jumps over the lazy dog";
		for(char ch:s.toCharArray()){
			ch=Character.toLowerCase(ch);
			if(ch!=' '){
				//arr[Math.abs(ch-'a')]+1;
				//arr[19]=arr[19]+1;
				//arr[7]=arr[7]+1;
				//arr[14]=arr[14]+1=1;- o in brown
				//arr[14]=arr[14]+1;=2 -o in fox
				if(ch>=97 || ch<=122){
					
				}
 			arr[Math.abs(ch-'a')]=arr[Math.abs(ch-'a')]+1;
			System.out.format(" The value %c %d %d ",ch,Math.abs(ch-'a') ,arr[Math.abs(ch-'a')]);
			System.out.println();
			    }
			}
		   for(int i=0; i<26;i++){
			   
			   if(arr[i]<1){
				   System.out.println(" The arr "+arr[i]);
				   isPanagram=false;  
			   }
			   
		}

		   System.out.println(" Is The String Panagram "+isPanagram);
	}

}
