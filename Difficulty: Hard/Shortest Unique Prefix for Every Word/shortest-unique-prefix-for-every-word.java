class Solution {
    class Node{
        int freq;
        Node[] child;
        Node(){
            freq = 0;
            child = new Node[26];
        }
    }
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        Node root = new Node();
        for(int i=0;i<arr.length;i++){
            buildTrie(root,arr[i]);
        }
        ArrayList<String>res = new ArrayList<>();
        for(String str:arr){
            String pfx = getPrefix(root,str);
            res.add(pfx);
        }
        return res;
    }
    public String getPrefix(Node root,String str){
        Node curr = root;
        StringBuilder sb = new StringBuilder();
        for(char ch:str.toCharArray()){
            int idx = ch-'a';
            curr = curr.child[idx];
            sb.append(ch);
            if(curr.freq==1)
                break;
        }
        return sb.toString();
    }
    public void buildTrie(Node root,String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
            curr.freq++;
        }
    }
}