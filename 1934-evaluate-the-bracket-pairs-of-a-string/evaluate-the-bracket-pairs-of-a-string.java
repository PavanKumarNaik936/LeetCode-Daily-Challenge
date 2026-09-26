class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        HashMap<String,String>map = new HashMap<>();
        for(List<String>pair:knowledge){
            String key = pair.get(0);
            String val = pair.get(1);
            map.put(key,val);
        }
        int l=0;
        int r = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(ch=='('){
                l = r+1;
                r=l;
                while(r<s.length() && s.charAt(r)!=')'){
                    r++;
                }
                String key = s.substring(l,r);
                String val = map.getOrDefault(key,"?");
                sb.append(val);
                r++;
            }else{
                sb.append(ch);
                r++;
            }
        }
        return sb.toString();
    }
}