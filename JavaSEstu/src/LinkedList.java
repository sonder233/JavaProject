class ListNode<T>{
    public int data;
    public ListNode pred;//前驱
    public ListNode succ;//后继

    public ListNode(){}
    public ListNode(int e,ListNode p, ListNode s){
        this.data = e;
        this.pred = p;
        this.succ = s;
    }

    public ListNode insertAsPred(int e){
        ListNode x = new ListNode(e,pred,this);
        pred.succ = x;
        pred = x;
        return x;
    }

    public ListNode insertAsSucc(int e){
        ListNode x = new ListNode(e,this,succ);
        succ.pred =x;
        succ = x;
        return x;
    }


}

public class LinkedList {

    private int _size;
    private ListNode header;
    private ListNode trailer;
    LinkedList(){
        header = new ListNode();
        trailer = new ListNode();

        header.succ = trailer;
        header.pred = null;

        trailer.pred = header;
        trailer.succ = null;

        _size = 0;
    }
    //作为首节点插入
    public ListNode insertAsFirst(int e){
        _size++;
        return header.insertAsSucc(e);
    }

    //作为尾节点插入
    public ListNode insertAsLast(int e){
        _size++;
        return trailer.insertAsPred(e);
    }

    //后插
    public ListNode insertAfter(ListNode p,int e){
        _size++;
        return p.insertAsSucc(e);
    }
    //前插
    public ListNode insertBefore(ListNode p,int e){
        _size++;
        return p.insertAsPred(e);
    }

    //删除
    public int remove(ListNode p){
        int e = p.data;
        p.pred.succ = p.succ;
        p.succ.pred = p.pred;
        _size--;
        return e;
    }
    //遍历
    public void traverse(){
        for (ListNode p = header.succ; p != trailer; p = p.succ){
            visit(p.data);
        }
    }
    //对遍历元素执行的函数
    public void visit(int e){
        System.out.println(e);
    }
    //有序列表查找 不大于e的最靠后者
    public ListNode search(int e ,int n,ListNode p){
        do {
            p = p.pred;
            n--;
        }while ((-1 < n) && (e < p.data));
        return p;
    }

    //插入排序(部分)
    public void insertionSort(ListNode p, int n){
        for (int r = 0; r < n; r++) {
            insertAfter(search(p.data,r,p),p.data);
            p = p.succ;
            remove(p.pred);
        }
    }
    //插入排序(整体)
    public void insertionSort(){
        insertionSort(header.succ,_size);
    }


}
