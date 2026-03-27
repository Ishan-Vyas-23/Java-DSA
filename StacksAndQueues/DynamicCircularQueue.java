package StacksAndQueues;

public class DynamicCircularQueue extends CircularQueue{
    public DynamicCircularQueue() {
        super();
    }

    public DynamicCircularQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {

        // if full
        if(isFull()){
            int [] temp = new int[data.length * 2];
            //copy prev
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front+1)] % data.length;
            }
            front = 0 ;
            end = data.length;
            data= temp;
        }

        // at this point we know array is of sufficient size
        return super.insert(item);
    }
}
