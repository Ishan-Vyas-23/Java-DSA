package StacksAndQueues;

public class DynamicStack extends CustomStack{
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        // takes care of being full
        if(this.isFull()){
            //create new array
            int [] temp =new int[data.length*2];

            //copy old items
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        //here we know array is not full
        return super.push(item);
    }
}
