class Solution {
    class Node{
        int maxLen;
        int pre;
        int suff;
        char leftChar;
        char rightChar;
        Node(int maxLen,int pre,int suff,char leftChar,char rightChar){
            this.maxLen = maxLen;
            this.pre = pre;
            this.suff = suff;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        Node[]st = new Node[4*n];
        build(0,0,n-1,st,s);
        int[]res = new int[queryIndices.length];
        for(int i=0;i<res.length;i++){
            int targetIdx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            update(0,0,n-1,st,targetIdx,ch,s);
            res[i] = st[0].maxLen;
        }
        return res;
    }
    public void update(int i,int l,int r,Node[]st,int target,char ch,String s){
        if(l==r){
            Node newNode = new Node(1,1,1,ch,ch);
            st[i] = newNode;
            return;
        }

        int mid = l+(r-l)/2;
        if(mid<target){
            update(2*i+2,mid+1,r,st,target,ch,s);
        }else{
            update(2*i+1,l,mid,st,target,ch,s);
        }
        st[i] = merge(2*i+1,2*i+2,mid-l+1,r-mid,st,s);
    }
    public void build(int i,int l,int r,Node[]st,String s){
        if(l==r){
            Node n = new Node(1,1,1,s.charAt(l),s.charAt(r));
            st[i] = n;
            return;
        }

        int mid = l+(r-l)/2;
        build(2*i+1,l,mid,st,s);
        build(2*i+2,mid+1,r,st,s);
        st[i] = merge(2*i+1,2*i+2,mid-l+1,r-mid,st,s);
    }
    public Node merge(int left,int right,int leftLength,int rightLength,Node[]st,String s){
        int maxLen = Math.max(st[left].maxLen,st[right].maxLen);
        // handling merging case if left last char == right first char 
        if(st[left].rightChar == st[right].leftChar){
            maxLen = Math.max(maxLen,st[left].suff+st[right].pre);
        }
        int pre = st[left].pre;
        if(pre==leftLength && st[left].rightChar == st[right].leftChar){
            pre = pre+st[right].pre;
        }
        int suff = st[right].suff;
        if(suff==rightLength && st[right].leftChar == st[left].rightChar){
            suff = suff+st[left].suff;
        }
        char leftChar = st[left].leftChar;
        char rightChar = st[right].rightChar;
        Node newNode = new Node(maxLen,pre,suff,leftChar,rightChar);
        return newNode;
    }
}