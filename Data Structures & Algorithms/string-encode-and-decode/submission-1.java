class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    //2#ab
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            j++;
            int end = j + length;
            StringBuilder sb = new StringBuilder();
            while (j < end) {
                sb.append(str.charAt(j));
                j++;
            }
            i = j;
            res.add(sb.toString());
        }
        return res;
    }
}
