class Solution {
    int parent[];
    int rank[];
    public boolean equationsPossible(String[] equations) {
        
        parent= new int[26];
        rank= new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(String eq:equations){
            if(eq.charAt(1)=='='){
                int x=eq.charAt(0)-'a';
                 int y=eq.charAt(3)-'a';
                 union(x,y);
            }
        }

         for(String eq:equations){
            if(eq.charAt(1)=='!'){
                int x=eq.charAt(0)-'a';
                 int y=eq.charAt(3)-'a';
                 if(find(x)==find(y)){
                    return false;
                 }
            }
        }
        return true;
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public void union(int x,int y){
        int x_parent=find(x);
        int y_parent=find(y);
        if(x_parent!=y_parent){
            if(rank[x_parent]>rank[y_parent]){
                parent[y_parent]=x_parent;
            }
            else if(rank[x_parent]<rank[y_parent]){
                parent[x_parent]=y_parent;
            }
            else{
                 parent[x_parent]=y_parent;
                 rank[y_parent]++;
            }
        }
    }
}

