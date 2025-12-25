public class Strings{

    public static boolean isPalindrome(String s){
        int start=0;
        int end=s.length()-1;

        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static int sortestDistance(String s){
        int x=0;
        int y=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'W'){
                x--;
            }else if(s.charAt(i) == 'N'){
                y++;
            }else if(s.charAt(i) == 'E'){
                x++;
            }else{
                y--;
            }
        }
        return (int)Math.sqrt(Math.pow(x,2)+(int)Math.pow(y,2));
    }
    public static String stringCompression(String s){
        if(s == null || s.length() == 0 ){
            return s;
        }
        char ch=s.charAt(0);
        int count=0;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ch){
                count++;
            }else{
                if(count>1){
                    sb.append(ch);
                    sb.append(count);
                }else{
                    sb.append(ch);
                }
                ch=s.charAt(i);
                count=1;
            }
        }
        if(count>1){
            sb.append(ch);
            sb.append(count);
        }else{
            sb.append(ch);
        }
        return sb.toString();
    }
    public static boolean isAnagram(String s,String a){
        if(s.length() != a.length()){
            return false;
        }
        int[] count=new int[26];

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[a.charAt(i)-'a']--;
        }
        for(int i=0;i<count.length;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s="nagaram";
        String a="anagram";
        System.out.println(isAnagram(s,a));
    }
}